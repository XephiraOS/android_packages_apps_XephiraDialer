package com.android.incallui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.telecom.VideoProfile;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.android.incallui.Call;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallApp;
import com.android.incallui.InCallPresenter;
import com.internal_dependency.InternalSdkDepends;

/* loaded from: classes.dex */
public class StatusBarNotifier implements InCallPresenter.InCallStateListener {
    public static final String INCALLUI_CHANNEL_ID = "InCallUI_default";
    private static final int INTERCEPT_CALL_NOTIFICATION = 11;
    private static final String INTERCEPT_CHANNEL_ID = "intercept_call";
    private static final int IN_CALL_NOTIFICATION = 1;
    private static final long IN_CALL_TIMEOUT = 1000;
    private static final String LOG_TAG = "StatusBarNotifier";
    private int mCallState;
    private final ContactInfoCache mContactInfoCache;
    private final Context mContext;
    private boolean mInFoldMode;
    private boolean mIsShowingNotification;
    private final NotificationManager mNotificationManager;
    private NotificationTimer mNotificationTimer;
    private final BroadcastReceiver mReceiver;
    private int mSavedContent;
    private String mSavedContentTitle;
    private int mSavedIcon;
    private Bitmap mSavedLargeIcon;

    /* loaded from: classes.dex */
    public interface NotificationTimer {

        /* loaded from: classes.dex */
        public enum State {
            SCHEDULED,
            FIRED,
            CLEAR
        }

        void clear();

        State getState();

        void schedule();
    }

    /* loaded from: classes.dex */
    public class OplusInterceptNotifierBroadcastReceiver extends BroadcastReceiver {
        public OplusInterceptNotifierBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(StatusBarNotifier.LOG_TAG, "Action intent recieved:" + action);
            if (action.equals(OplusPhoneUtils.ACTION_CANCEL_INTERCEPT_NOTIFICATION)) {
                StatusBarNotifier.this.clearInterceptNotification();
            }
        }
    }

    public StatusBarNotifier(Context context, ContactInfoCache contactInfoCache) {
        OplusInterceptNotifierBroadcastReceiver oplusInterceptNotifierBroadcastReceiver = new OplusInterceptNotifierBroadcastReceiver();
        this.mReceiver = oplusInterceptNotifierBroadcastReceiver;
        this.mNotificationTimer = new NotificationTimer() { // from class: com.android.incallui.StatusBarNotifier.1
            private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.android.incallui.StatusBarNotifier.1.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    fire();
                    return true;
                }
            });
            private NotificationTimer.State mState = NotificationTimer.State.CLEAR;

            /* JADX INFO: Access modifiers changed from: private */
            public void fire() {
                if (Log.sDebug) {
                    Log.d(StatusBarNotifier.LOG_TAG, "updateInCallNotification: timer fired");
                }
                this.mState = NotificationTimer.State.FIRED;
                StatusBarNotifier.this.updateNotification(InCallPresenter.getInstance().getInCallState(), InCallPresenter.getInstance().getCallList());
            }

            @Override // com.android.incallui.StatusBarNotifier.NotificationTimer
            public void clear() {
                if (Log.sDebug) {
                    Log.d(StatusBarNotifier.LOG_TAG, "updateInCallNotification: timer cleared");
                }
                this.mHandler.removeMessages(0);
                this.mState = NotificationTimer.State.CLEAR;
            }

            @Override // com.android.incallui.StatusBarNotifier.NotificationTimer
            public NotificationTimer.State getState() {
                return this.mState;
            }

            @Override // com.android.incallui.StatusBarNotifier.NotificationTimer
            public void schedule() {
                if (this.mState == NotificationTimer.State.CLEAR) {
                    if (Log.sDebug) {
                        Log.d(StatusBarNotifier.LOG_TAG, "updateInCallNotification: timer scheduled");
                    }
                    this.mHandler.sendEmptyMessageDelayed(0, StatusBarNotifier.IN_CALL_TIMEOUT);
                    this.mState = NotificationTimer.State.SCHEDULED;
                }
            }
        };
        this.mIsShowingNotification = false;
        this.mCallState = 0;
        this.mSavedIcon = 0;
        this.mSavedContent = 0;
        this.mInFoldMode = false;
        com.google.common.base.k.o(context);
        this.mContext = context;
        this.mContactInfoCache = contactInfoCache;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
        context.registerReceiver(oplusInterceptNotifierBroadcastReceiver, new IntentFilter(OplusPhoneUtils.ACTION_CANCEL_INTERCEPT_NOTIFICATION), OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
    }

    private void addHangupAction(Notification.Builder builder) {
        if (Log.sDebug) {
            Log.i(LOG_TAG, "Will show \"hang-up\" action in the ongoing active call Notification");
        }
        builder.addAction(R.drawable.stat_sys_phone_call_end, this.mContext.getText(R.string.notification_action_end_call), createHangUpOngoingCallPendingIntent(this.mContext));
    }

    private void addPersonReference(Notification.Builder builder, ContactInfoCache.ContactCacheEntry contactCacheEntry, Call call) {
        Uri uri;
        if (contactCacheEntry != null && (uri = contactCacheEntry.lookupUri) != null) {
            builder.addPerson(uri.toString());
        } else if (call != null && !TextUtils.isEmpty(call.getNumber())) {
            builder.addPerson(Uri.fromParts("tel", call.getNumber(), null).toString());
        }
    }

    private void buildAndSendNotification(Call call, boolean z10) {
        boolean z11;
        String str;
        boolean z12;
        String str2;
        Call callToShow = getCallToShow(CallList.getInstance());
        if (callToShow != null && callToShow.getId().equals(call.getId())) {
            int state = callToShow.getState();
            Log.d(LOG_TAG, "buildAndSendNotification mInFoldMode:" + this.mInFoldMode);
            if (InCallPresenter.getInstance().isShowingInCallUi() && !Call.State.isRing(state) && !this.mInFoldMode) {
                Log.d(LOG_TAG, "isShowingInCallUi is true, so just return");
                return;
            }
            ContactInfoCache.ContactCacheEntry contactInfo = callToShow.getContactInfo();
            if (!callToShow.showSingleParty() && callToShow.isConferenceCall()) {
                z12 = true;
            } else {
                z12 = false;
            }
            int iconToDisplay = getIconToDisplay(callToShow);
            Bitmap largeIconToDisplay = getLargeIconToDisplay(contactInfo, z12, callToShow);
            int contentString = getContentString(callToShow);
            String contentTitle = getContentTitle(contactInfo, z12);
            if (!checkForChangeAndSaveData(iconToDisplay, contentString, largeIconToDisplay, contentTitle, state, z10)) {
                OplusPhoneUserActionStatistics.addNoCallUIAction(this.mContext, OplusPhoneUserActionStatistics.ACTION_NOTIFICATION_NOT_SHOW, String.valueOf(true));
                return;
            }
            Notification.Builder notificationBuilder = getNotificationBuilder();
            PendingIntent createLaunchPendingIntent = createLaunchPendingIntent();
            notificationBuilder.setContentIntent(createLaunchPendingIntent);
            if (z10) {
                configureFullScreenIntent(notificationBuilder, createLaunchPendingIntent, callToShow);
            }
            notificationBuilder.setContentText(this.mContext.getString(contentString));
            notificationBuilder.setSmallIcon(iconToDisplay);
            if (contentTitle != null && contentTitle.indexOf(43) == 0) {
                str2 = "\u200e" + contentTitle;
            } else {
                str2 = contentTitle;
            }
            notificationBuilder.setContentTitle(str2);
            if (largeIconToDisplay != null && !largeIconToDisplay.isRecycled()) {
                notificationBuilder.setLargeIcon(largeIconToDisplay);
            }
            if (state == 3 && !callToShow.isCdmaDialing()) {
                notificationBuilder.setUsesChronometer(true);
                notificationBuilder.setWhen(callToShow.getConnectTimeMillis());
            } else {
                notificationBuilder.setUsesChronometer(false);
            }
            if (state == 3 || state == 8 || Call.State.isDialing(state)) {
                addHangupAction(notificationBuilder);
            }
            if (Call.State.isRing(state)) {
                notificationBuilder.setCategory("call");
                addPersonReference(notificationBuilder, contactInfo, callToShow);
            }
            if (largeIconToDisplay != null && largeIconToDisplay.isRecycled()) {
                Log.e(LOG_TAG, "largeIcon isRecycled()");
                OplusPhoneUserActionStatistics.addNoCallUIAction(this.mContext, OplusPhoneUserActionStatistics.ACTION_ICON_RECYCLED, String.valueOf(true));
                return;
            }
            notificationBuilder.setChannelId(createChannel(INCALLUI_CHANNEL_ID).getId());
            try {
                Notification build = notificationBuilder.build();
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "Notifying IN_CALL_NOTIFICATION: " + build);
                }
                this.mNotificationManager.notify(1, build);
                this.mIsShowingNotification = true;
                return;
            } catch (AndroidRuntimeException e10) {
                Log.e(LOG_TAG, e10.getMessage());
                return;
            } catch (Exception e11) {
                Log.e(LOG_TAG, e11.getMessage());
                OplusPhoneUserActionStatistics.addNoCallUIAction(this.mContext, OplusPhoneUserActionStatistics.ACTION_NOTIFY_ERROR, e11.getMessage());
                return;
            }
        }
        Context context = this.mContext;
        int i10 = R.string.call_exit_show_notification;
        if (callToShow == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        String valueOf = String.valueOf(z11);
        String str3 = "";
        if (callToShow == null) {
            str = "";
        } else {
            str = callToShow.getId();
        }
        if (call != null) {
            str3 = call.getId();
        }
        OplusPhoneUserActionStatistics.addNoCallUIAction(context, OplusPhoneUserActionStatistics.ACTION_CALL_NULL_SHOW_NOTIFICATION, context.getString(i10, valueOf, str, str3));
    }

    private boolean checkForChangeAndSaveData(int i10, int i11, Bitmap bitmap, String str, int i12, boolean z10) {
        boolean z11;
        boolean z12 = false;
        boolean z13 = true;
        if ((str != null && !str.equals(this.mSavedContentTitle)) || (str == null && this.mSavedContentTitle != null)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.mSavedIcon != i10 || this.mSavedContent != i11 || this.mCallState != i12 || this.mSavedLargeIcon != bitmap || z11) {
            z12 = true;
        }
        if (z10) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Forcing full screen intent");
            }
            z12 = true;
        }
        if (!this.mIsShowingNotification) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Showing notification for first time.");
            }
        } else {
            z13 = z12;
        }
        this.mSavedIcon = i10;
        this.mSavedContent = i11;
        this.mCallState = i12;
        this.mSavedLargeIcon = bitmap;
        this.mSavedContentTitle = str;
        if (z13 && Log.sDebug) {
            Log.d(LOG_TAG, "Data changed.  Showing notification");
        }
        return z13;
    }

    public static void clearAllInCallNotification(Context context) {
        if (context == null) {
            Log.i(StatusBarNotifier.class.getSimpleName(), "clearAllInCallNotification: context is null");
            return;
        }
        if (Log.sDebug) {
            Log.i(StatusBarNotifier.class.getSimpleName(), "[Oplus] Something terrible happened. Clear all InCall notifications");
        }
        ((NotificationManager) context.getSystemService("notification")).cancelAll();
    }

    public static void clearInCallNotification(Context context) {
        if (Log.sDebug) {
            Log.i(StatusBarNotifier.class.getSimpleName(), "Something terrible happened. Clear all InCall notifications");
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInterceptNotification() {
        ((NotificationManager) this.mContext.getSystemService("notification")).cancel(11);
    }

    private void clearResources() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "clearResources...");
        }
        Bitmap bitmap = this.mSavedLargeIcon;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "recycle large icon: " + this.mSavedLargeIcon);
            }
            this.mSavedLargeIcon.recycle();
            this.mSavedLargeIcon = null;
        }
    }

    private void configureFullScreenIntent(Notification.Builder builder, PendingIntent pendingIntent, Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "- Setting fullScreenIntent: " + pendingIntent);
        }
        CallList callList = CallList.getInstance();
        if (call.getState() != 5) {
            if (call.getState() == 4) {
                if (callList.getBackgroundCall() == null && !callList.isAnyOtherSubActive(callList.getActiveSubId())) {
                    return;
                }
            } else {
                return;
            }
        }
        if (Log.sDebug) {
            Log.i(LOG_TAG, "updateInCallNotification: call-waiting or dsda incoming call! force relaunch...");
        }
        this.mNotificationManager.cancel(1);
    }

    public static NotificationChannel createChannel(String str, NotificationManager notificationManager, Context context) {
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        if (notificationChannel == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "createChannel channelId:" + str);
            }
            NotificationChannel notificationChannel2 = new NotificationChannel(str, getNotificationChannelName(str, context), 3);
            notificationChannel2.setSound(null, null);
            notificationChannel2.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel2);
            notificationChannel = notificationChannel2;
        }
        if (notificationChannel.getLockscreenVisibility() == -1) {
            try {
                notificationChannel.setLockscreenVisibility(1);
                InternalSdkDepends.getSInstance().updateNotificationChannelForPackage(context, context.getPackageName(), notificationChannel);
            } catch (Exception e10) {
                Log.w(LOG_TAG, "updateChannel: An exception occurs:" + e10.getMessage());
            }
        }
        return notificationChannel;
    }

    private static PendingIntent createHangUpOngoingCallPendingIntent(Context context) {
        return PendingIntent.getBroadcast(context, 0, new Intent(InCallApp.ACTION_HANG_UP_ONGOING_CALL, null, context, InCallApp.NotificationBroadcastReceiver.class), 67108864);
    }

    private PendingIntent createLaunchPendingIntent() {
        Intent inCallIntent = InCallPresenter.getInstance().getInCallIntent(false, false);
        inCallIntent.putExtra(InCallActivity.LAUNCH_FROM_NOTIFICATION_EXTRA, true);
        inCallIntent.putExtra(InCallActivity.LAUNCH_ON_DEFAULT_DISPLAY_EXTRA, true);
        return PendingIntent.getActivity(this.mContext, 0, inCallIntent, 67108864);
    }

    private Call getCallToShow(CallList callList) {
        if (callList == null) {
            return null;
        }
        Call incomingCall = callList.getIncomingCall();
        if (incomingCall == null) {
            incomingCall = callList.getPendingOutgoingCall();
        }
        if (incomingCall == null) {
            incomingCall = callList.getOutgoingCall();
        }
        if (incomingCall == null) {
            return callList.getActiveOrBackgroundCall();
        }
        return incomingCall;
    }

    private int getContentString(Call call) {
        int i10 = R.string.notification_ongoing_call;
        if (call.getState() != 4 && call.getState() != 5) {
            if (call.getState() == 8) {
                return R.string.notification_on_hold;
            }
            if (Call.State.isDialing(call.getState()) || call.isCdmaDialing()) {
                return R.string.notification_dialing;
            }
            return i10;
        }
        return R.string.notification_incoming_call;
    }

    private String getContentTitle(ContactInfoCache.ContactCacheEntry contactCacheEntry, boolean z10) {
        if (contactCacheEntry == null) {
            return "";
        }
        if (z10) {
            if (CallList.getInstance().oplusCallList().isCdmaPhoneActive()) {
                return this.mContext.getString(R.string.oplus_cdma_multi_call);
            }
            return this.mContext.getResources().getString(R.string.card_title_conf_call);
        }
        int numberHideSettings = OplusPhoneUtils.getNumberHideSettings(this.mContext);
        if (TextUtils.isEmpty(contactCacheEntry.name)) {
            String str = contactCacheEntry.number;
            if (str != null) {
                str = str.replaceAll("\\s+", "");
                if (numberHideSettings != 0) {
                    if (Log.sDebug) {
                        Log.d(LOG_TAG, "setPrimaryInfo: numberHideSettings:" + numberHideSettings);
                    }
                    str = OplusPhoneUtils.getNumberMaskedStr(str, numberHideSettings);
                }
                if (OplusPhoneUtils.isEmergencyNumber(str)) {
                    return this.mContext.getString(R.string.oplus_emergency_call_dialog_number_for_display);
                }
            }
            return str;
        }
        if (numberHideSettings != 0) {
            return OplusPhoneUtils.getHidedNumberInName(contactCacheEntry.name, numberHideSettings, this.mContext);
        }
        return contactCacheEntry.name;
    }

    private int getIconToDisplay(Call call) {
        boolean z10;
        if (OplusFeatureOption.OPLUS_HW_MANUFACTURER_QUALCOMM) {
            z10 = call.can(65536);
        } else {
            z10 = false;
        }
        if (call.getState() == 8) {
            if (z10) {
                return R.drawable.stat_sys_vp_phone_call_on_hold;
            }
            return R.drawable.incall_ic_launcher;
        }
        if (z10) {
            return R.drawable.stat_sys_vp_phone_call;
        }
        return R.drawable.incall_ic_launcher;
    }

    private Bitmap getLargeIconToDisplay(ContactInfoCache.ContactCacheEntry contactCacheEntry, boolean z10, Call call) {
        Bitmap decodeResource;
        if (contactCacheEntry == null) {
            return null;
        }
        if (z10) {
            BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.picture_conference);
        }
        if (!CallUtils.isBidirectionalVideoCall(call) && (!CallUtils.isVideoCall(call) || call == null || (Call.State.isConnectingOrDialingOrIncomming(call.getState()) && VideoProfile.isReceptionEnabled(call.getVideoState())))) {
            Drawable drawable = contactCacheEntry.photo;
            if (drawable != null && (drawable instanceof BitmapDrawable)) {
                decodeResource = ((BitmapDrawable) drawable).getBitmap();
            } else {
                decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.incall_ic_notification_voice_call);
            }
        } else {
            decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.incall_ic_notification_video_call);
        }
        if (decodeResource != null && !decodeResource.isRecycled()) {
            decodeResource = Bitmap.createScaledBitmap(decodeResource, (int) this.mContext.getResources().getDimension(android.R.dimen.notification_large_icon_width), (int) this.mContext.getResources().getDimension(android.R.dimen.notification_large_icon_height), false);
        }
        if (decodeResource != null && !decodeResource.isRecycled()) {
            return OplusPhoneUtils.bitmapToRoundCorner(decodeResource, 40.0f);
        }
        return decodeResource;
    }

    private Notification.Builder getNotificationBuilder() {
        Notification.Builder builder = new Notification.Builder(this.mContext);
        builder.setOngoing(true);
        return builder;
    }

    private static String getNotificationChannelName(String str, Context context) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (INCALLUI_CHANNEL_ID.equals(str)) {
                return context.getResources().getString(R.string.phoneAppLabel);
            }
            return context.getString(R.string.description_target_decline_and_intercept);
        }
        return "";
    }

    private void showNotification(Call call, boolean z10) {
        buildAndSendNotification(call, z10);
    }

    public void cancelInCall() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "cancelInCall()...");
        }
        this.mNotificationManager.cancel(1);
        this.mIsShowingNotification = false;
    }

    public void interceptCallNotification(int i10) {
        if (this.mContext == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "mContext is null return");
                return;
            }
            return;
        }
        if (OplusPhoneUtils.isNeedHideCallHarassInterceptSetting()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isNeedHideCallHarassInterceptSetting true return");
                return;
            }
            return;
        }
        Notification.Builder builder = new Notification.Builder(this.mContext);
        builder.setContentIntent(D2.f.n(this.mContext, i10));
        if (i10 == 1) {
            builder.setContentTitle(this.mContext.getString(R.string.oplus_has_intercept_n_times));
            builder.setContentText(this.mContext.getString(R.string.tap_to_modify_settings));
            builder.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.incall_ic_notification_intercept_settings));
        } else if (i10 == 2) {
            builder.setContentTitle(this.mContext.getString(R.string.oplus_new_intercept));
            Context context = this.mContext;
            builder.setContentText(context.getString(R.string.oplus_notify_intercept_tips, Integer.valueOf(D2.f.m(context))));
            builder.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.incall_ic_notification_intercept_list));
        }
        builder.setSmallIcon(R.drawable.incall_ic_launcher);
        builder.setChannelId(createChannel(INTERCEPT_CHANNEL_ID).getId());
        try {
            Notification build = builder.build();
            build.flags = 16;
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Notifying INTERCEPT_CALL_NOTIFICATION: " + build);
            }
            this.mNotificationManager.notify(11, build);
        } catch (Exception e10) {
            Log.e(LOG_TAG, e10.getMessage());
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onStateChange");
        }
        InCallPresenter.InCallState inCallState3 = InCallPresenter.InCallState.NO_CALLS;
        if (inCallState == inCallState3 && inCallState2 != inCallState && !inCallState2.isIncoming()) {
            Log.d(LOG_TAG, "no notification before InCallActivity launched");
            return;
        }
        updateNotification(inCallState2, callList);
        if (inCallState2 == inCallState3) {
            clearResources();
        }
    }

    public void updateFloatingWindowIncomingCallNotification(Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateFloatingWindowIncomingCallNotification call = " + call);
        }
        showNotification(call, false);
    }

    public void updateInCallNotification(boolean z10, InCallPresenter.InCallState inCallState, CallList callList) {
        boolean z11;
        boolean z12 = false;
        this.mInFoldMode = false;
        Call callToShow = getCallToShow(callList);
        if ((inCallState == InCallPresenter.InCallState.OUTGOING || inCallState == InCallPresenter.InCallState.PENDING_OUTGOING) && !InCallPresenter.getInstance().isActivityPreviouslyStarted()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (callToShow == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "updateInCallNotification: call is null, no need show Notification");
            }
        } else {
            if (Call.State.isRing(callToShow.getState())) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "updateInCallNotification: at ringing state, show notification immediately");
                }
            } else if (!inCallState.isConnectingOrConnected()) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "updateInCallNotification: no active call, no need show Notification");
                }
            } else if (Boolean.TRUE.equals(K1.b.f1620a.e().b().getValue())) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "updateInCallNotification: always show Notification when Dragonfly display fold close");
                }
                this.mInFoldMode = true;
            } else if (InCallPresenter.getInstance().isShowingInCallUi() && !OplusPhoneUtils.isInLockTaskMode()) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "updateInCallNotification: InCallUI is showing and not inLockTaskMode, no need show Notification");
                }
            } else if (z11 && this.mNotificationTimer.getState() != NotificationTimer.State.FIRED) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "updateInCallNotification: OutgoingWithoutInCallUI but timer has not fired, no need show Notification");
                }
            } else if (InCallPresenter.getInstance().realInstance().shouldIgnoreNotification()) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "updateInCallNotification: shouldIgnoreNotification, no need show Notification");
                }
            } else if (OplusPhoneUtils.getPhoneScreenLockState(this.mContext)) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "updateInCallNotification: screen locked, no need show Notification");
                }
            } else if (Log.sDebug) {
                Log.d(LOG_TAG, "updateInCallNotification: show notification immediately");
            }
            z12 = true;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateInCallNotification allowFullScreenIntent = " + z10 + " state = " + inCallState);
        }
        if (z12) {
            showNotification(callToShow, z10);
        } else {
            cancelInCall();
            if (z11 && this.mNotificationTimer.getState() == NotificationTimer.State.CLEAR) {
                this.mNotificationTimer.schedule();
            }
        }
        if (InCallPresenter.getInstance().isShowingInCallUi() || callToShow == null) {
            this.mNotificationTimer.clear();
        }
    }

    public void updateNotification(InCallPresenter.InCallState inCallState, CallList callList) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateNotification, state = " + inCallState);
        }
        if (inCallState == InCallPresenter.InCallState.OUTGOING && callList.getActiveOrBackgroundCall() != null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "do not notify for when add call ");
                return;
            }
            return;
        }
        updateInCallNotification(false, inCallState, callList);
    }

    public void updateNotificationAndLaunchIncomingCallUi(InCallPresenter.InCallState inCallState, CallList callList) {
        L1.c.h(OplusInCallApp.getInCallAppInstance(), InCallPresenter.getInstance().getInCallIntent(false, false));
    }

    private NotificationChannel createChannel(String str) {
        return createChannel(str, this.mNotificationManager, this.mContext);
    }
}
