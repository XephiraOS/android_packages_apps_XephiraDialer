package com.android.incallui;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.usecase.VideoBackgroundUseCase;
import com.android.incallui.oplus.share.OplusScreenController;
import com.android.oplus.brand.BrandCenter;
import com.android.oplus.module.castScreen.CastScreen;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import t2.C1581a;
import x2.C1676a;
import z2.C1731b;

/* loaded from: classes.dex */
public class OplusInCallPresenter extends InCallPresenter implements OplusScreenController.b, CallList.CallUpdateListener {
    private static final String ACTION_CALL_FORWARD = "com.oplus.intent.action.CALL_FORWARDED";
    private static final String ACTION_SUPP_SERVICE_FAILURE = "org.codeaurora.ACTION_SUPP_SERVICE_FAILURE";
    private static final int DO_RECYCLE_CONTACT_PHOTO_DELAY_TIME = 200;
    private static final String LOG_TAG = "OplusInCallPresenter";
    protected static final int MSG_ATTEMPT_FINISH_ACTIVITY = 1;
    private static final int MSG_ATTEMPT_FINISH_ACTIVITY_TIME = 500;
    private static final int MSG_DELAY_RECYCLE_CONTACT_PHOTO = 100;
    protected static final int MSG_NOTIFY_SRVCC = 2;
    private static final int MSG_SEND_ANSWER_FROM_NONUI = 102;
    private static final int MSG_SEND_INCALL_ACTIVITY_STATE_BROADCAST = 101;
    private static final String OPLUS_ACTION_HIDE_INCOMING_FULL_UI = "oplus.intent.action.incallui.HIDE_INCOMING_FULL_UI";
    private static final int OPLUS_MSG_DELAY_GOTO_MERGE = 500;
    private static final int SEND_INCALL_ACTIVITY_STATE_BROADCAST_DELAY_TIME = 1000;
    private static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    private static final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    private static final int WAIT_WEAR_NOTIFY_SHOW_INCALL_DELAY_TIME = 3000;
    private C1581a mFloatingWindowController;
    private b2.l mInCallFragmentPresenter;
    protected OplusAutoRedialNotificationUI mOplusAutoRedialInstance;
    private A2.o mOplusMonitorActivityStatus;
    private A2.p mOplusPhoneStateListener;
    private com.android.incallui.oplus.widgets.c mOplusScheduledGenerator;
    private A2.v mOplusSelectPhoneAccountManager;
    private InCallPresenter.InCallState mPreviousCallState;
    private OplusInCallPresenterBroadcastReceiver mReceiver;
    private VideoCallPresenter mVideoCallPresenter;
    private String mLastRingCallId = null;
    private final V5.b mFoldScreenController = V5.a.a();
    private boolean mHasCatchSwitchError = false;
    private boolean mIsShowSingleCallView = false;
    private boolean mHasRegistHomekey = false;
    private boolean mIncomingCallReceivedWearShowInCallUiNotify = false;
    private boolean mNeedMerge = false;
    private String mInComingCallId = null;
    private Q5.b mAudioRecordInterface = null;
    private boolean mSetActivityShowFlag = false;
    private String OPLUS_IS_CALL_FORWARDED_INFO_EXTRA = "extra_is_call_forwarded_info";
    private final Set<CallSizeListener> mCallSizeListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private final SubscriptionManager.OnSubscriptionsChangedListener mOnSubscriptionsChangeListener = new SubscriptionManager.OnSubscriptionsChangedListener() { // from class: com.android.incallui.OplusInCallPresenter.1
        @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
        public void onSubscriptionsChanged() {
            Log.d(OplusInCallPresenter.LOG_TAG, "onSubscriptionsChanged");
            int cardSize = OplusPhoneUtils.getCardSize();
            OplusPhoneUtils.setCardSize(OplusPhoneUtils.getAvailableCardSize(OplusInCallPresenter.this.mContext));
            if (OplusInCallPresenter.this.mInCallActivity == null) {
                if (Log.sDebug) {
                    Log.d(OplusInCallPresenter.LOG_TAG, "InCallActivity is null, return.");
                }
            } else if (cardSize != OplusPhoneUtils.getCardSize() && Log.sDebug) {
                Log.d(OplusInCallPresenter.LOG_TAG, "trigger to update call card UI");
            }
        }
    };
    private BroadcastReceiver mHomeRecevier = new BroadcastReceiver() { // from class: com.android.incallui.OplusInCallPresenter.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra(OplusInCallPresenter.SYSTEM_DIALOG_REASON_KEY);
                Log.d(OplusInCallPresenter.LOG_TAG, "mHomeRecevier action:" + action + ",reason:" + stringExtra);
                if (OplusInCallPresenter.SYSTEM_DIALOG_REASON_HOME_KEY.equals(stringExtra)) {
                    OplusInCallPresenter.this.maySilenceRingerWhenPressHomeKey();
                    if (OplusInCallPresenter.this.mFloatingWindowController != null) {
                        OplusInCallPresenter.this.mFloatingWindowController.I();
                    }
                    OplusPhoneUtils.sendBroadcastInCallActivityStateIfBackground(OplusInCallApp.getAppContext());
                    return;
                }
                if (OplusInCallPresenter.SYSTEM_DIALOG_REASON_RECENT_APPS.equals(stringExtra) && OplusPhoneUtils.isUserGestureMode(context) && OplusPhoneUtils.getPhoneScreenLockState(context)) {
                    Log.d(OplusInCallPresenter.LOG_TAG, "mHomeRecevier mInCallState: " + OplusInCallPresenter.this.mInCallState);
                    OplusInCallPresenter oplusInCallPresenter = OplusInCallPresenter.this;
                    if (oplusInCallPresenter.mInCallState == InCallPresenter.InCallState.INCOMING && oplusInCallPresenter.isShowingInCallUi()) {
                        OplusInCallPresenter.this.mInCallActivity.finish();
                        OplusPhoneUserActionStatistics.addNoCallUIAction(OplusInCallPresenter.this.mContext, OplusPhoneUserActionStatistics.ACTION_FINISH_ACTIVITY_BY_BROADCAST, stringExtra);
                    }
                    OplusInCallPresenter.this.maySilenceRingerWhenPressHomeKey();
                    return;
                }
                return;
            }
            if (OplusInCallPresenter.OPLUS_ACTION_HIDE_INCOMING_FULL_UI.equals(action)) {
                Log.d(OplusInCallPresenter.LOG_TAG, "mHomeRecevier action:" + action + ", mInCallState " + OplusInCallPresenter.this.mInCallState);
                OplusInCallPresenter oplusInCallPresenter2 = OplusInCallPresenter.this;
                if (oplusInCallPresenter2.mInCallState == InCallPresenter.InCallState.INCOMING && oplusInCallPresenter2.isShowingInCallUi()) {
                    OplusInCallPresenter.this.mInCallActivity.finish();
                    OplusPhoneUserActionStatistics.addNoCallUIAction(OplusInCallPresenter.this.mContext, OplusPhoneUserActionStatistics.ACTION_FINISH_ACTIVITY_BY_BROADCAST, action);
                }
                OplusInCallPresenter.this.maySilenceRingerWhenPressHomeKey();
            }
        }
    };
    protected Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.incallui.OplusInCallPresenter.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    OplusInCallPresenter.this.oplusNotifySRVCC();
                    return;
                }
                switch (i10) {
                    case 100:
                        if (Log.sDebug) {
                            Log.d(OplusInCallPresenter.LOG_TAG, "MSG_DELAY_RECYCLE_CONTACT_PHOTO message received...");
                            return;
                        }
                        return;
                    case 101:
                        OplusInCallActivity activity = OplusInCallPresenter.this.getActivity();
                        if (activity == null || !activity.isForegroundActivity()) {
                            OplusPhoneUtils.sendBroadcastInCallActivityState(OplusInCallPresenter.this.mContext, false);
                            return;
                        }
                        return;
                    case 102:
                        TelecomAdapter.getInstance().oplusTelecomAdapter().answerFromNonUi((String) message.obj, message.arg1);
                        return;
                    default:
                        return;
                }
            }
            if (Log.sDebug) {
                Log.d(OplusInCallPresenter.LOG_TAG, "MSG_ATTEMPT_FINISH_ACTIVITY message received...");
            }
            if (OplusInCallPresenter.this.mInCallState == InCallPresenter.InCallState.NO_CALLS) {
                f2.c.f31677a.j(null);
                if (OplusInCallPresenter.this.getActivity() != null) {
                    OplusInCallPresenter.this.getActivity().finish();
                }
            }
        }
    };
    private Runnable mShowInCallRunnable = new Runnable() { // from class: com.android.incallui.P
        @Override // java.lang.Runnable
        public final void run() {
            OplusInCallPresenter.this.lambda$new$1();
        }
    };
    private boolean mIgnoreNotificatoin = false;
    private int mIncomingInterfaceType = 0;

    /* renamed from: com.android.incallui.OplusInCallPresenter$5, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$android$incallui$OplusInCallPresenter$SuppService;

        static {
            int[] iArr = new int[SuppService.values().length];
            $SwitchMap$com$android$incallui$OplusInCallPresenter$SuppService = iArr;
            try {
                iArr[SuppService.SWITCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface CallSizeListener {
        void onCallSizeChanged(int i10);
    }

    /* loaded from: classes.dex */
    public class OplusInCallPresenterBroadcastReceiver extends BroadcastReceiver {
        public OplusInCallPresenterBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Call incomingCall;
            android.telecom.Call call;
            ProximitySensor proximitySensor;
            InCallActivity inCallActivity;
            k2.e h10;
            String action = intent.getAction();
            Log.d(this, "OplusInCallPresenterBroadcastReceiver Action: " + action);
            boolean z10 = true;
            if (action.equals(OplusInCallPresenter.ACTION_SUPP_SERVICE_FAILURE)) {
                TelecomAdapter.getInstance().oplusTelecomAdapter().dealWithSuppServiceFailed();
                int c10 = D2.d.c(intent, "supp_serv_failure", 0);
                Log.d(this, "OplusInCallPresenterBroadcastReceiver val: " + c10);
                SuppService suppService = SuppService.HOLD;
                if ((c10 == suppService.ordinal() || c10 == SuppService.RESUME.ordinal()) && (inCallActivity = OplusInCallPresenter.this.mInCallActivity) != null && inCallActivity.getInCallFragmentManager().c() != null && (h10 = OplusInCallPresenter.this.mInCallActivity.getInCallFragmentManager().c().getButtonController().h(3)) != null) {
                    if (c10 == suppService.ordinal()) {
                        z10 = false;
                    }
                    h10.a(z10);
                    return;
                }
                return;
            }
            if (action.equals(OplusPhoneUtils.ACTION_SUBINFO_RECORD_UPDATED)) {
                int cardSize = OplusPhoneUtils.getCardSize();
                OplusPhoneUtils.setCardSize(OplusPhoneUtils.getAvailableCardSize(context));
                if (OplusInCallPresenter.this.mInCallActivity == null) {
                    if (Log.sDebug) {
                        Log.d(OplusInCallPresenter.LOG_TAG, "InCallActivity is null, return.");
                        return;
                    }
                    return;
                } else {
                    if (cardSize != OplusPhoneUtils.getCardSize() && Log.sDebug) {
                        Log.d(OplusInCallPresenter.LOG_TAG, "trigger to update call card UI");
                        return;
                    }
                    return;
                }
            }
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                CallList callList = CallList.getInstance();
                if (callList != null && callList.getIncomingCall() != null && (proximitySensor = OplusInCallPresenter.this.mProximitySensor) != null) {
                    proximitySensor.updateProximitySensorMode();
                }
                OplusInCallPresenter.this.dealWithLockedScreenNotification(false);
                return;
            }
            if ("oplusos.intent.action.telecom.FINISH_INCALL_UI".equals(action)) {
                if (OplusInCallPresenter.this.isShowingInCallUi()) {
                    Log.d(Log.TAG, "ACTION_FINISH_INCALL_UI!");
                    OplusInCallPresenter.this.mInCallActivity.finish();
                    OplusPhoneUserActionStatistics.addNoCallUIAction(OplusInCallPresenter.this.mContext, OplusPhoneUserActionStatistics.ACTION_FINISH_ACTIVITY_BY_BROADCAST, action);
                    return;
                }
                return;
            }
            if ("oplusos.intent.action.telecom.WEAR_SHOW_INCALLUI".equals(action)) {
                OplusInCallPresenter.this.mIncomingCallReceivedWearShowInCallUiNotify = true;
                OplusInCallPresenter.this.removeShowInCallRunnable();
                return;
            }
            if (action.equals(OplusInCallPresenter.ACTION_CALL_FORWARD)) {
                boolean isIncoming = OplusInCallPresenter.this.mInCallState.isIncoming();
                boolean booleanExtra = intent.getBooleanExtra("is_call_forwarded", false);
                Log.d(OplusInCallPresenter.LOG_TAG, "isInComingCall = " + isIncoming + " isCallForwarded = " + booleanExtra);
                InCallActivity inCallActivity2 = OplusInCallPresenter.this.mInCallActivity;
                if (inCallActivity2 == null) {
                    if (Log.sDebug) {
                        Log.d(OplusInCallPresenter.LOG_TAG, "InCallActivity is null, return.");
                    }
                    if (isIncoming && booleanExtra && (incomingCall = OplusInCallPresenter.this.mCallList.getIncomingCall()) != null && (call = incomingCall.mTelecomCall) != null && call.getDetails() != null && incomingCall.mTelecomCall.getDetails().getExtras() != null) {
                        incomingCall.mTelecomCall.getDetails().getExtras().putBoolean(OplusInCallPresenter.this.OPLUS_IS_CALL_FORWARDED_INFO_EXTRA, true);
                        incomingCall.oplusUpdateFromTelecommCall();
                        return;
                    }
                    return;
                }
                if (inCallActivity2.getInCallFragmentManager().h() != null && isIncoming && booleanExtra) {
                    OplusInCallPresenter.this.mInCallActivity.getInCallFragmentManager().h().updateCallStatusPrompt(OplusInCallPresenter.this.mContext.getString(R.string.oplus_call_forward_info));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public enum SuppService {
        UNKNOWN,
        SWITCH,
        SEPARATE,
        TRANSFER,
        CONFERENCE,
        REJECT,
        HANGUP,
        RESUME,
        HOLD,
        VOLTE_CONFERENCE_FULL
    }

    private void addSessionListener(Call call, Call call2) {
        if (call2 != null) {
            if (!Call.areSame(call, call2) && call != null) {
                CallList.getInstance().removeCallUpdateListener(call.getId(), this);
            }
            CallList.getInstance().addCallUpdateListener(call2.getId(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealWithLockedScreenNotification(boolean z10) {
        if (this.mInCallState == InCallPresenter.InCallState.NO_CALLS) {
            this.mIgnoreNotificatoin = false;
            return;
        }
        boolean phoneScreenLockState = OplusPhoneUtils.getPhoneScreenLockState(this.mContext);
        if (Log.sDebug) {
            Log.d(Log.TAG, "dealWithLockedScreenNotification needLock = " + z10 + ", lockState = " + phoneScreenLockState);
        }
        if (z10 && phoneScreenLockState) {
            this.mIgnoreNotificatoin = true;
            StatusBarNotifier statusBarNotifier = this.mStatusBarNotifier;
            if (statusBarNotifier != null) {
                statusBarNotifier.updateInCallNotification(false, this.mInCallState, this.mCallList);
                return;
            }
            return;
        }
        if (!z10 && !phoneScreenLockState) {
            this.mIgnoreNotificatoin = false;
            StatusBarNotifier statusBarNotifier2 = this.mStatusBarNotifier;
            if (statusBarNotifier2 != null) {
                statusBarNotifier2.updateInCallNotification(false, this.mInCallState, this.mCallList);
                return;
            }
            return;
        }
        this.mIgnoreNotificatoin = false;
    }

    private void handleHideIncomingCallUiByNotDisturb() {
        setIsActivityPreviouslyStarted(true);
        sendIncallActivityStateMessage();
    }

    private void handleHideIncomingCallUiByWear() {
        hideIncomingCallUiButUpdateNotification();
        if (!this.mIncomingCallReceivedWearShowInCallUiNotify) {
            postDelayedShowInCallRunnable();
        }
    }

    private void handleShowAnswerFloatingWindow(OplusCall oplusCall) {
        if (oplusCall != null) {
            VideoBackgroundUseCase.f18569a.r(true);
        }
        setIsActivityPreviouslyStarted(true);
        V5.b foldScreenController = InCallPresenter.getInstance().getFoldScreenController();
        if (foldScreenController != null) {
            foldScreenController.g();
        }
    }

    private void hideIncomingCallUiButUpdateNotification() {
        setIsActivityPreviouslyStarted(true);
        sendIncallActivityStateMessage();
        StatusBarNotifier statusBarNotifier = this.mStatusBarNotifier;
        if (statusBarNotifier != null) {
            statusBarNotifier.updateNotification(InCallPresenter.InCallState.INCOMING, this.mCallList);
        }
    }

    private boolean hideIncomingCallUiByNotDisturb(OplusCall oplusCall, boolean z10) {
        if (oplusCall != null && oplusCall.isNotShowInCallUIForIncoming() && !z10) {
            return true;
        }
        return false;
    }

    private boolean hideIncomingCallUiByWear(OplusCall oplusCall) {
        if (oplusCall == null) {
            return false;
        }
        if (!OplusPhoneUtils.isSupportHideMTCallUiByWatch(getContext())) {
            Log.i(LOG_TAG, "Telecom is not support hide incoming call by watch");
            return false;
        }
        if (!notHideIncomingCallUiByWear(oplusCall) && I2.a.e(getContext().getContentResolver())) {
            boolean mHideIncomingCallUiByWear = WearInfoQueryUtils.INSTANCE.getMHideIncomingCallUiByWear();
            Log.d(LOG_TAG, "hideIncomingCallUiByWear , shouldHideIncomingCallUi: " + mHideIncomingCallUiByWear);
            return mHideIncomingCallUiByWear;
        }
        Log.d(LOG_TAG, "Video call, or VC, or incoming call is null.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        Log.d(LOG_TAG, "ShowInCallRunnable, mInCallState: " + this.mInCallState);
        if (this.mInCallState.isIncoming()) {
            showInCall(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUp$0(Integer num) {
        this.mProximitySensor.oplusUpdateProximitySensorMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maySilenceRingerWhenPressHomeKey() {
        C1581a c1581a;
        Call incomingCall;
        if (this.mContext != null && this.mInCallState.isIncoming() && (c1581a = this.mFloatingWindowController) != null && !c1581a.G() && (incomingCall = CallList.getInstance().getIncomingCall()) != null && !incomingCall.getIsSilence()) {
            Log.d(LOG_TAG, "silence ringing cause press home key");
            this.mIsHomeKeyPressed = true;
            OplusPhoneUtils.silenceRinger(this.mContext);
            OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_TECHNOLOGY_STATISTIC, OplusPhoneUserActionStatistics.EVENT_HIDE_RING_UI_BY_PRESS_HOME_KEY, (Map) null);
        }
    }

    private boolean notHideIncomingCallUiByWear(OplusCall oplusCall) {
        if (!oplusCall.isVipContact() && !CallUtils.isBidirectionalVideoCall(oplusCall)) {
            return false;
        }
        return true;
    }

    private void onCallSizeChange() {
        int oplusGetCallSize = CallList.getInstance().oplusCallList().oplusGetCallSize();
        Log.d(this, "onCallSizeChange: size= " + oplusGetCallSize);
        Iterator<CallSizeListener> it = this.mCallSizeListeners.iterator();
        while (it.hasNext()) {
            it.next().onCallSizeChanged(oplusGetCallSize);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void oplusAutoRedial(com.android.incallui.Call r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusInCallPresenter.oplusAutoRedial(com.android.incallui.Call, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oplusNotifySRVCC() {
        if (CallList.getInstance() != null && CallList.getInstance().getActiveCall() != null) {
            TelecomAdapter.getInstance().oplusTelecomAdapter().clearPendingCallAction();
        }
        if (this.mInCallActivity != null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "oplusNotifySRVCC ... refreshCallButtonsVisibility");
            }
            this.mInCallActivity.getInCallFragmentManager().refreshCallButtonsVisibility();
        }
    }

    private void postDelayedShowInCallRunnable() {
        removeShowInCallRunnable();
        if (this.mHandler != null) {
            Log.d(LOG_TAG, "postDelayedShowInCallRunnable...");
            this.mHandler.postDelayed(this.mShowInCallRunnable, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeShowInCallRunnable() {
        if (this.mHandler != null) {
            Log.d(LOG_TAG, "removeShowInCallRunnable...");
            this.mHandler.removeCallbacks(this.mShowInCallRunnable);
        }
    }

    private void showDefaultInCallUi(InCallPresenter.InCallState inCallState, OplusCall oplusCall) {
        if (startUi(inCallState) && this.mOplusMonitorActivityStatus != null) {
            if (oplusCall != null) {
                VideoBackgroundUseCase.f18569a.r(false);
            }
            this.mOplusMonitorActivityStatus.h();
        }
        V5.b foldScreenController = InCallPresenter.getInstance().getFoldScreenController();
        if (foldScreenController != null) {
            foldScreenController.g();
        }
    }

    private void updateCallInfoUseCase(InCallPresenter.InCallState inCallState, CallList callList) {
        Call outgoingCall;
        Call g10;
        if (callList != null && callList.oplusCallList().allConferenceChildCallDisconnected()) {
            InCallPresenter.InCallState inCallState2 = InCallPresenter.InCallState.INCOMING;
            Call call = null;
            if (inCallState != inCallState2 && inCallState != InCallPresenter.InCallState.PENDING_OUTGOING && inCallState != InCallPresenter.InCallState.OUTGOING && inCallState != InCallPresenter.InCallState.INCALL) {
                g10 = null;
            } else {
                if (inCallState == inCallState2) {
                    outgoingCall = callList.getIncomingCall();
                } else if (inCallState != InCallPresenter.InCallState.PENDING_OUTGOING && inCallState != InCallPresenter.InCallState.OUTGOING) {
                    outgoingCall = D2.b.g(callList, null, null, null, false);
                } else {
                    outgoingCall = callList.getOutgoingCall();
                    if (outgoingCall == null) {
                        outgoingCall = callList.getPendingOutgoingCall();
                    }
                }
                g10 = D2.b.g(callList, outgoingCall, null, null, true);
                call = outgoingCall;
            }
            boolean z10 = !Call.areSame(this.primaryCall, call);
            boolean areSame = true ^ Call.areSame(this.secondaryCall, g10);
            addSessionListener(this.primaryCall, call);
            this.primaryCall = call;
            this.secondaryCall = g10;
            if (z10) {
                com.android.incallui.clean.data.datasource.i.f18344a.c(call);
            } else if (call != null && call.mIsUpdateSinglePartyUI) {
                call.mIsUpdateSinglePartyUI = false;
                com.android.incallui.clean.data.datasource.i.f18344a.c(call);
            }
            if (areSame) {
                com.android.incallui.clean.data.datasource.j.f18347a.c(g10);
            }
            Log.d(LOG_TAG, "updateCallInfoUseCase: newState=" + inCallState + ", primaryCall=" + call + ", secondary=" + g10);
            f2.d.f31685a.a(g10);
            f2.c.f31677a.j(call);
            com.android.incallui.clean.data.datasource.j.f18347a.d(g10);
            com.android.incallui.clean.data.datasource.i.f18344a.d(call);
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateCallInfoUseCase ConferenceCall not hangup all return...");
        }
    }

    public void OplusMonitorActivityStatusClean() {
        A2.o oVar = this.mOplusMonitorActivityStatus;
        if (oVar != null) {
            oVar.d();
        }
    }

    @Override // com.android.incallui.InCallPresenter
    public void addListener(InCallPresenter.InCallStateListener inCallStateListener) {
        if (inCallStateListener == null) {
            Log.d(LOG_TAG, "listener is null, return");
            return;
        }
        if (!this.mListeners.contains(inCallStateListener)) {
            this.mListeners.add(inCallStateListener);
            if (Log.sDebug) {
                Log.d(LOG_TAG, "addListener listener = " + inCallStateListener + "  mListeners: size = " + this.mListeners.size());
            }
        }
    }

    public void answerFromNonUi(String str, int i10) {
        Message obtain = Message.obtain();
        obtain.what = 102;
        obtain.obj = str;
        obtain.arg1 = i10;
        this.mHandler.sendMessage(obtain);
    }

    @Override // com.android.incallui.InCallPresenter
    public void attemptCleanup() {
        boolean z10;
        boolean z11 = true;
        if (this.mInCallActivity == null && !this.mServiceConnected && this.mInCallState == InCallPresenter.InCallState.NO_CALLS) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.i(LOG_TAG, "attemptCleanup? " + z10);
        if (z10) {
            super.attemptCleanup();
            return;
        }
        if (this.mStatusBarNotifier != null && this.mInCallState == InCallPresenter.InCallState.NO_CALLS) {
            if (Log.sDebug) {
                Log.i(LOG_TAG, "attemptCleanup  cancelInCall");
            }
            this.mStatusBarNotifier.cancelInCall();
        }
        if (this.mInCallActivity == null && this.mInCallState == InCallPresenter.InCallState.NO_CALLS) {
            Log.i(LOG_TAG, "sendRecordNotification ");
            Q5.b bVar = this.mAudioRecordInterface;
            if (bVar != null) {
                bVar.d();
            }
        }
        if (this.mInCallState == InCallPresenter.InCallState.NO_CALLS) {
            setIsActivityPreviouslyStarted(false);
            if (Log.sDebug) {
                Log.d(LOG_TAG, "InCallPresenter clear resources");
            }
            C1581a c1581a = this.mFloatingWindowController;
            if (c1581a == null || !c1581a.G()) {
                z11 = false;
            }
            if (!this.mSetActivityShowFlag && !z11) {
                clearResources();
            }
            this.mHasCatchSwitchError = false;
            unregisterHomeRecevier();
            OplusPhoneUtils.clearEmergencyNumberCache();
            OplusPhoneUtils.cleanMccmncCache();
            setIncomingInterfaceType(0);
            com.ted.number.t.c();
            InCallUIAide.getInstance().clearFontChangeListener();
            CallList.getInstance().oplusCallList().cleanup();
            TelecomAdapter.getInstance().oplusTelecomAdapter().clearPendingCallAction();
        }
    }

    public void attemptMerge() {
        if (this.mNeedMerge && canMerge() != null) {
            this.mNeedMerge = false;
            A2.z.c(new Runnable() { // from class: com.android.incallui.OplusInCallPresenter.4
                @Override // java.lang.Runnable
                public void run() {
                    Call canMerge = OplusInCallPresenter.this.canMerge();
                    if (canMerge == null) {
                        return;
                    }
                    if (Log.sDebug) {
                        Log.d(OplusInCallPresenter.LOG_TAG, "do merge ...");
                    }
                    OplusInCallPresenter.this.getAnswerPresenter().merge(canMerge.getId());
                }
            }, 500L);
        }
    }

    public void callBeRemoved() {
        onCallSizeChange();
    }

    public Call canMerge() {
        Call activeCall = CallList.getInstance().getActiveCall();
        if (activeCall != null && activeCall.getState() == 3 && !TextUtils.isEmpty(activeCall.getId()) && activeCall.getId().equals(this.mInComingCallId)) {
            return activeCall;
        }
        return null;
    }

    public void checkRttUi() {
        BrandCenter.f19187a.a().b(this.mInCallState);
    }

    public void clearResources() {
        ContactInfoCache contactInfoCache = this.mContactInfoCache;
        if (contactInfoCache != null) {
            contactInfoCache.clearCache();
        }
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null) {
            ((OplusInCallActivity) inCallActivity).getInCallFragmentManager().o();
        }
        HashMap<String, OplusPhoneUtils.NumberAttributionInfo> hashMap = OplusPhoneUtils.mNumberAttributionCache;
        if (hashMap != null) {
            hashMap.clear();
        }
        A2.j.J().a0();
        this.mHandler.sendEmptyMessageDelayed(100, 200L);
        OplusPhoneUtils.setVideoPausedForConf(false);
        C1731b.d().c();
    }

    public void dismissPermissionDialog() {
        Q5.b bVar = this.mAudioRecordInterface;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void dismissVideoUpgradeRequestDialog() {
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null) {
            ((OplusInCallActivity) inCallActivity).dismissVideoUpgradeRequestDialog();
        }
        L1.b.c(false);
    }

    @Override // com.android.incallui.InCallPresenter
    public C1581a getFloatingWindowController() {
        return this.mFloatingWindowController;
    }

    @Override // com.android.incallui.InCallPresenter
    public V5.b getFoldScreenController() {
        return this.mFoldScreenController;
    }

    public b2.b getInCallFragmentPresenter() {
        return this.mInCallFragmentPresenter;
    }

    public int getIncomingInterfaceType() {
        return this.mIncomingInterfaceType;
    }

    public com.android.incallui.oplus.widgets.c getOplusScheduledGenerator() {
        return this.mOplusScheduledGenerator;
    }

    @Override // com.android.incallui.InCallPresenter
    public A2.v getOplusSelectPhoneAccountManager() {
        return this.mOplusSelectPhoneAccountManager;
    }

    @Override // com.android.incallui.InCallPresenter
    public VideoCallPresenter getVideoCallPresenter() {
        return this.mVideoCallPresenter;
    }

    public boolean hasAnswerFromNonUiMsg() {
        return this.mHandler.hasMessages(102);
    }

    public boolean hasCatchSwitchError() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "mHasCatchSwitchError = " + this.mHasCatchSwitchError);
        }
        return this.mHasCatchSwitchError;
    }

    public void inCallActivityHasFocus() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "inCallActivityHasFocus");
        }
        startRinging("ActivityFocus");
        ProximitySensor proximitySensor = this.mProximitySensor;
        if (proximitySensor != null) {
            proximitySensor.inCallActivityChangeFocus();
        }
        A2.o oVar = this.mOplusMonitorActivityStatus;
        if (oVar != null) {
            oVar.d();
        }
        VideoCallPresenter videoCallPresenter = this.mVideoCallPresenter;
        if (videoCallPresenter != null) {
            videoCallPresenter.oplusCheckSystemUiVisibility();
        }
    }

    public boolean inCallActivityIsForeground() {
        boolean z10;
        if (getActivity() != null && getActivity().isForegroundActivity()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "inCallActivityIsForeground = " + z10);
        }
        return z10;
    }

    public void inCallActivityLoseFocus() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "inCallActivityLoseFocus");
        }
        ProximitySensor proximitySensor = this.mProximitySensor;
        if (proximitySensor != null) {
            proximitySensor.inCallActivityChangeFocus();
        }
    }

    public void inCallActivityOnPostResume() {
        boolean isScreenInteractive = isScreenInteractive();
        boolean isDisplayAod = isDisplayAod();
        boolean phoneScreenLockState = OplusPhoneUtils.getPhoneScreenLockState(this.mContext);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "inCallActivityOnPostResume isScreenOn =" + isScreenInteractive + " isScreenLock = " + phoneScreenLockState + " isDisplayAod = " + isDisplayAod);
        }
        if (isDisplayAod) {
            startRinging("ActivityResumeAod");
        }
    }

    public void inCallActivityonResume() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "inCallActivityonResume...");
        }
        C1581a c1581a = this.mFloatingWindowController;
        if (c1581a != null) {
            c1581a.J();
        }
        updateNotificationWhenResumeAndPause();
    }

    public boolean isShowSingleCallView() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isShowSingleCallView = " + this.mIsShowSingleCallView);
        }
        return this.mIsShowSingleCallView;
    }

    public boolean needToRedialForRttEmergency(int i10) {
        InCallPresenter.InCallState inCallState = this.mPreviousCallState;
        if ((inCallState == InCallPresenter.InCallState.OUTGOING || inCallState == InCallPresenter.InCallState.PENDING_OUTGOING) && (i10 == 0 || i10 == 1 || i10 == 6 || i10 == 2)) {
            return true;
        }
        return false;
    }

    @Override // com.android.incallui.InCallPresenter
    public void onCallAdded(android.telecom.Call call) {
        super.onCallAdded(call);
        onCallSizeChange();
    }

    @Override // com.android.incallui.InCallPresenter, com.android.incallui.CallList.Listener
    public void onCallListChange(CallList callList) {
        if (callList == null) {
            Log.i(LOG_TAG, "onCallListChange callList is null ");
            return;
        }
        InCallPresenter.InCallState potentialStateFromCallList = getPotentialStateFromCallList(callList);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "oplusOnCallListChange newState = " + potentialStateFromCallList + " mInCallState = " + this.mInCallState);
        }
        if (this.mInCallState == potentialStateFromCallList && potentialStateFromCallList == InCallPresenter.InCallState.NO_CALLS) {
            return;
        }
        if (this.mReceiver == null) {
            registerOplusInCallPresenterBroadcastReceiver(this.mContext);
        }
        InCallPresenter.InCallState inCallState = InCallPresenter.InCallState.NO_CALLS;
        if (potentialStateFromCallList == inCallState && this.mInCallState != potentialStateFromCallList) {
            Log.d(LOG_TAG, "onCallListChange first enter no_calls don't update primary call");
        } else {
            updateCallInfoUseCase(potentialStateFromCallList, callList);
        }
        InCallPresenter.InCallState inCallState2 = InCallPresenter.InCallState.INCALL;
        if (potentialStateFromCallList != inCallState2) {
            this.mPreviousCallState = potentialStateFromCallList;
        }
        super.onCallListChange(callList);
        if (potentialStateFromCallList == inCallState && ((OplusCallList) CallList.getInstance()).oplusGetCallSize() == 0) {
            attemptCleanup();
        }
        Call activeOrBackgroundCall = callList.getActiveOrBackgroundCall();
        if ((activeOrBackgroundCall != null && !callList.isCDMADialingCall(activeOrBackgroundCall)) || potentialStateFromCallList == InCallPresenter.InCallState.INCOMING) {
            OplusAutoRedial.getInstance(this.mContext).endRedialTask();
            OplusAutoRedialNotificationUI oplusAutoRedialNotificationUI = this.mOplusAutoRedialInstance;
            if (oplusAutoRedialNotificationUI != null) {
                oplusAutoRedialNotificationUI.cancelMsgAndFinishScreen();
            }
        }
        if (potentialStateFromCallList == inCallState2 && !((OplusCallList) callList).hasCDMADialingCall()) {
            callList.oplusCallList().shouldChangeActiveSubscription();
        }
        if (OplusFeatureOption.OPLUS_PHONE_SHOW_HD_NOTIFICATION) {
            if (D2.c.g(this.mContext, activeOrBackgroundCall)) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "onCallListChange show hd voice call notification");
                }
                D2.c.e(this.mContext);
            } else {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "onCallListChange should not show hd voice call notification");
                }
                D2.c.a(this.mContext, 5);
            }
        }
        if (inCallState == potentialStateFromCallList) {
            if (OplusPhoneUtils.sOplusShowDigits != null && !OplusPhoneUtils.isDeviceRestricted(this.mContext)) {
                Intent intent = new Intent("oppo.intent.action.DIAL", Uri.fromParts("tel", OplusPhoneUtils.sOplusShowDigits, null));
                intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                intent.putExtra("from", "com.android.phone");
                log("mOplusShowDigits--");
                InCallActivity inCallActivity = this.mInCallActivity;
                if (inCallActivity != null && inCallActivity.getInCallFragmentManager().l() != null && !TextUtils.isEmpty(this.mInCallActivity.getInCallFragmentManager().l().f1())) {
                    this.mInCallActivity.getInCallFragmentManager().l().e1();
                    log("clearDigits--");
                }
                OplusPhoneUtils.sOplusShowDigits = null;
                try {
                    this.mContext.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    if (Log.sDebug) {
                        Log.d(LOG_TAG, "onDisconnect: transition to call log failed; intent = " + intent);
                    }
                }
            }
            if (!OplusPhoneUtils.getNeedMarkNumber(this.mContext)) {
                A2.c.d().c();
            }
        }
        attemptMerge();
    }

    @Override // com.android.incallui.InCallPresenter, com.android.incallui.CallList.Listener
    public void onDisconnect(Call call) {
        InCallActivity inCallActivity;
        InCallActivity inCallActivity2;
        if (call == null) {
            Log.d(LOG_TAG, "onDisconnect call is null");
            return;
        }
        super.onDisconnect(call);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "calls.disconnect cause=" + call.getDisconnectCause() + "  number =" + D2.g.l(call.getNumber()));
        }
        if (call.getSessionModificationState() == 3) {
            dismissVideoUpgradeRequestDialog();
        }
        if (((OplusCallList) CallList.getInstance()).oplusGetCallSize() == 1 && (inCallActivity2 = this.mInCallActivity) != null) {
            inCallActivity2.getInCallFragmentManager().d(5, false);
        }
        boolean isSpecialNumberByYellowPage = OplusSpecialNumberUtils.getInstance().isSpecialNumberByYellowPage(call);
        OplusPhoneUtils.sOplusShowDigits = null;
        if (!call.isEmergencyCall() && !isSpecialNumberByYellowPage && (inCallActivity = this.mInCallActivity) != null && inCallActivity.getInCallFragmentManager().l() != null && !TextUtils.isEmpty(this.mInCallActivity.getInCallFragmentManager().l().f1())) {
            OplusPhoneUtils.sOplusShowDigits = this.mInCallActivity.getInCallFragmentManager().l().f1();
        }
        Q5.b bVar = this.mAudioRecordInterface;
        if (bVar != null && bVar.k()) {
            try {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "in phone record endRecord()");
                }
                if (this.mAudioRecordInterface.g()) {
                    this.mAudioRecordInterface.i(true, true);
                } else {
                    this.mAudioRecordInterface.i(true, false);
                }
            } catch (Exception e10) {
                Log.d(LOG_TAG, "Exception: " + e10.toString());
            }
        }
        oplusAutoRedial(call, call.getNumber());
    }

    @Override // com.android.incallui.InCallPresenter, com.android.incallui.CallList.Listener
    public void onIncomingCall(Call call) {
        StatusBarNotifier statusBarNotifier;
        if (this.mReceiver == null) {
            registerOplusInCallPresenterBroadcastReceiver(this.mContext);
        }
        if (call == null) {
            return;
        }
        super.onIncomingCall(call);
        updateCallInfoUseCase(InCallPresenter.InCallState.INCOMING, this.mCallList);
        if ((OplusPhoneUtils.isInLockTaskMode() || call.isNotShowInCallUIForIncoming()) && (statusBarNotifier = this.mStatusBarNotifier) != null) {
            statusBarNotifier.updateNotification(this.mInCallState, this.mCallList);
        }
        registerHomeRecevier();
    }

    @Override // com.android.incallui.oplus.share.OplusScreenController.b
    public void onScreenStateChange(boolean z10) {
        Log.d(this, "onScreenStateChange: isScreenOn = " + z10);
        if (!z10) {
            dealWithLockedScreenNotification(true);
        }
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onSessionModificationStateChange(Call call, int i10) {
        Log.d(this, "onSessionModificationStateChangeTest : sessionModificationState = " + i10 + " call:" + call);
        if (call == this.primaryCall) {
            com.android.incallui.clean.data.datasource.i.f18344a.d(call);
        }
    }

    @Override // com.android.incallui.InCallPresenter
    public void onUiShowing(boolean z10) {
        if (z10 && !CallList.getInstance().hasAnyLiveCall()) {
            Log.i(LOG_TAG, "onUiShowing  there is no call ,return...");
            return;
        }
        super.onUiShowing(z10);
        if (!z10) {
            registerHomeRecevier();
        }
    }

    public void oplusSendSRVCCMsg() {
        if (CallList.getInstance() != null) {
            CallList.getInstance().setSRVCCforCalls(true);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
    }

    public void quickHideInCallActivity() {
        if (Log.sDebug) {
            D2.g.c(LOG_TAG, "quickHideInCallActivity ");
        }
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null) {
            inCallActivity.moveTaskToBack(true);
        }
    }

    public void registerHomeRecevier() {
        if (this.mInCallState != InCallPresenter.InCallState.NO_CALLS && this.mContext != null && !this.mHasRegistHomekey) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "regist mHomeRecevier");
            }
            IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            intentFilter.addAction(OPLUS_ACTION_HIDE_INCOMING_FULL_UI);
            this.mContext.registerReceiver(this.mHomeRecevier, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
            this.mHasRegistHomekey = true;
        }
    }

    public void registerOplusInCallPresenterBroadcastReceiver(Context context) {
        if (A2.z.b() && context != null && this.mReceiver == null) {
            if (Log.sDebug) {
                Log.w(LOG_TAG, "registerOplusInCallPresenterBroadcastReceiver");
            }
            this.mReceiver = new OplusInCallPresenterBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter(ACTION_SUPP_SERVICE_FAILURE);
            intentFilter.addAction(ACTION_CALL_FORWARD);
            intentFilter.addAction(OplusPhoneUtils.ACTION_SUBINFO_RECORD_UPDATED);
            intentFilter.addAction("oplusos.intent.action.telecom.FINISH_INCALL_UI");
            intentFilter.addAction("oplusos.intent.action.telecom.WEAR_SHOW_INCALLUI");
            context.registerReceiver(this.mReceiver, intentFilter, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
            context.registerReceiver(this.mReceiver, new IntentFilter("android.intent.action.USER_PRESENT"), OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE, null, 2);
            OplusScreenController.e().d(this);
            OplusPhoneUtils.oplusAddOnSubscriptionsChangedListener(context, this.mOnSubscriptionsChangeListener);
        }
    }

    @Override // com.android.incallui.InCallPresenter
    public void removeListener(InCallPresenter.InCallStateListener inCallStateListener) {
        if (inCallStateListener != null && this.mListeners.contains(inCallStateListener)) {
            this.mListeners.remove(inCallStateListener);
        }
    }

    public void sendIncallActivityStateMessage() {
        this.mHandler.sendEmptyMessageDelayed(101, 1000L);
    }

    public void sendMessageFinishActivity() {
        this.mHandler.sendEmptyMessageDelayed(1, 500L);
    }

    @Override // com.android.incallui.InCallPresenter
    public void setActivity(InCallActivity inCallActivity) {
        A2.v vVar;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setActivity inCallActivity = " + inCallActivity + ">>> mInCallActivity =" + this.mInCallActivity);
        }
        boolean z10 = true;
        boolean z11 = false;
        if (inCallActivity != null) {
            InCallActivity inCallActivity2 = this.mInCallActivity;
            if (inCallActivity2 != null && inCallActivity2 == inCallActivity) {
                this.mInCallActivity = inCallActivity;
                z10 = false;
            } else {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "UI Initialized");
                }
                this.mInCallActivity = inCallActivity;
                this.mSetActivityShowFlag = true;
                enableScreenTimeout(CallUtils.isAudioCall(OplusPhoneUtils.getCallToShow(CallList.getInstance())));
                Q5.b bVar = this.mAudioRecordInterface;
                if (bVar != null) {
                    bVar.j();
                }
            }
            CallList callList = this.mCallList;
            if (callList != null && callList.getDisconnectedCall() != null) {
                maybeShowErrorDialogOnDisconnect(this.mCallList.getDisconnectedCall());
            }
            CallList callList2 = this.mCallList;
            if (callList2 != null && callList2.getWaitingForAccountCall() != null && (vVar = this.mOplusSelectPhoneAccountManager) != null) {
                vVar.c();
            }
            if (this.mInCallState == InCallPresenter.InCallState.NO_CALLS) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "UI Intialized, but no calls left.  shut down.");
                }
                attemptFinishActivity();
                return;
            }
        } else {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "UI Destroyed)");
            }
            this.mInCallActivity = null;
            this.mSetActivityShowFlag = false;
            z11 = true;
        }
        if (z10) {
            onCallListChange(this.mCallList);
        }
        if (z11) {
            attemptCleanup();
        }
    }

    public void setIncomingInterfaceType(int i10) {
        if (Log.sDebug) {
            Log.d(Log.TAG, "setIncomingInterfaceType = " + i10);
        }
        if (i10 != this.mIncomingInterfaceType) {
            this.mIncomingInterfaceType = i10;
            A2.l.d().p(this.mIncomingInterfaceType);
        }
    }

    public void setIsShowSingleCallView(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setIsShowSingleCallView newValue = " + z10 + ", oldValue = " + this.mIsShowSingleCallView);
        }
        if (this.mIsShowSingleCallView == z10) {
            return;
        }
        this.mIsShowSingleCallView = z10;
        if (getActivity() == null) {
            Log.i(LOG_TAG, "setIsShowSingleCallView activity is null, return.");
            return;
        }
        OplusCallButtonFragment callButtonFragment = getActivity().getCallButtonFragment();
        if (callButtonFragment != null && callButtonFragment.getButtonController() != null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "set call button fragment widget");
            }
            if (callButtonFragment.getIsVideoCall() && OplusPhoneUtils.isNeedShowVideoCallHold(this.mContext, OplusPhoneUtils.getCallToShow(this.mCallList))) {
                callButtonFragment.getButtonController().T(true);
            } else {
                callButtonFragment.getButtonController().T(!callButtonFragment.getIsVideoCall());
            }
        }
    }

    public void setNeedMerge(boolean z10, String str) {
        this.mNeedMerge = z10;
        this.mInComingCallId = str;
    }

    public void setOplusAutoRedialNotificationInstance(OplusAutoRedialNotificationUI oplusAutoRedialNotificationUI) {
        this.mOplusAutoRedialInstance = oplusAutoRedialNotificationUI;
    }

    public void setUp(Context context) {
        if (context == null) {
            Log.d(LOG_TAG, "setUp failed for that context is null");
            return;
        }
        CallList callList = CallList.getInstance();
        ContactInfoCache contactInfoCache = ContactInfoCache.getInstance(context);
        AudioModeProvider audioModeProvider = AudioModeProvider.getInstance();
        if (this.mStatusBarNotifier == null) {
            this.mStatusBarNotifier = new StatusBarNotifier(context, contactInfoCache);
        }
        if (this.mProximitySensor == null) {
            this.mProximitySensor = new OplusProximitySensor(context, audioModeProvider);
            ResponsiveConfigRepository.f18540a.h1().j(new androidx.lifecycle.w() { // from class: com.android.incallui.Q
                @Override // androidx.lifecycle.w
                public final void onChanged(Object obj) {
                    OplusInCallPresenter.this.lambda$setUp$0((Integer) obj);
                }
            });
        }
        setUp(context, callList, audioModeProvider, this.mStatusBarNotifier, contactInfoCache, this.mProximitySensor);
        if (this.mOplusMonitorActivityStatus == null) {
            this.mOplusMonitorActivityStatus = new A2.o();
        }
        A2.j.J().N(context);
        C1676a.g().h(context);
        if (this.mOplusPhoneStateListener == null) {
            this.mOplusPhoneStateListener = new A2.p(context, this);
        }
        if (this.mFloatingWindowController == null) {
            C1581a c1581a = new C1581a(context);
            this.mFloatingWindowController = c1581a;
            c1581a.A();
        }
        if (this.mOplusSelectPhoneAccountManager == null) {
            this.mOplusSelectPhoneAccountManager = new A2.v(context);
        }
        if (this.mOplusScheduledGenerator == null) {
            this.mOplusScheduledGenerator = new com.android.incallui.oplus.widgets.c();
        }
        A2.c.d().e();
        Q5.b a10 = Q5.a.a();
        this.mAudioRecordInterface = a10;
        if (a10 != null) {
            a10.init(context);
        }
        com.android.incallui.anim.b.c().h(context);
        CastScreen.f19196a.a().G(context);
        if (this.mInCallFragmentPresenter == null) {
            b2.l lVar = new b2.l();
            this.mInCallFragmentPresenter = lVar;
            addListener(lVar);
            addIncomingCallListener(this.mInCallFragmentPresenter);
        }
        V5.b bVar = this.mFoldScreenController;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.android.incallui.InCallPresenter
    public void setVideoCallPresenter(VideoCallPresenter videoCallPresenter) {
        this.mVideoCallPresenter = videoCallPresenter;
    }

    public boolean shouldAddFragmentLazy() {
        if (CallList.getInstance().getIncomingCall() == null) {
            return true;
        }
        return false;
    }

    public boolean shouldIgnoreNotification() {
        return this.mIgnoreNotificatoin;
    }

    public void showErrorMessageForPendingCallAction(SuppService suppService) {
        int i10 = R.string.incall_error_supp_service_unknown;
        if (AnonymousClass5.$SwitchMap$com$android$incallui$OplusInCallPresenter$SuppService[suppService.ordinal()] == 1) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "SWITCH return...");
            }
            OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
            if (oplusCallList != null) {
                if (oplusCallList.oplusGetCallSize() != 0) {
                    if (oplusCallList.oplusGetCallSize() == 1 && (oplusCallList.oplusGetDisconnectingCall() != null || oplusCallList.oplusGetDisconnectingCall() != null)) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (oplusCallList != null && oplusCallList.oplusGetCallSize() == 1) {
                i10 = R.string.oplus_incall_error_supp_service_hold;
            } else {
                i10 = R.string.incall_error_supp_service_switch;
            }
        }
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null) {
            inCallActivity.showErrorDialog(this.mContext.getString(i10));
        }
    }

    @Override // com.android.incallui.InCallPresenter
    public void showInCall(boolean z10, boolean z11) {
        try {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "start showInCall");
            }
            setIsActivityPreviouslyStarted(true);
            L1.c.h(OplusInCallApp.getInCallAppInstance(), getInCallIntent(z10, z11));
        } catch (ActivityNotFoundException e10) {
            Log.w(LOG_TAG, "displayCallScreen: transition to InCallScreen failed: " + e10);
        } catch (Exception e11) {
            e11.fillInStackTrace();
        }
    }

    public void showRecordStorageFullDialog(int i10) {
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null) {
            ((OplusInCallActivity) inCallActivity).showRecordStorageFullDialog(i10);
        }
    }

    public void showVideoUpgradeRequestDialog() {
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null) {
            ((OplusInCallActivity) inCallActivity).showVideoUpgradeRequestDialog();
        }
        L1.b.c(true);
    }

    @Override // com.android.incallui.InCallPresenter
    public InCallPresenter.InCallState startOrFinishUi(InCallPresenter.InCallState inCallState) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        Q5.b bVar;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "startOrFinishUi: " + this.mInCallState + " -> " + inCallState);
        }
        InCallPresenter.InCallState inCallState2 = this.mInCallState;
        InCallPresenter.InCallState inCallState3 = InCallPresenter.InCallState.PENDING_OUTGOING;
        boolean z16 = true;
        if (inCallState2 == inCallState3 && inCallState == InCallPresenter.InCallState.OUTGOING) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "startOrFinishUi: newState = " + inCallState + "  mIsActivityPreviouslyStarted = " + this.mIsActivityPreviouslyStarted);
        }
        InCallPresenter.InCallState inCallState4 = InCallPresenter.InCallState.INCOMING;
        if (inCallState4 == inCallState && !this.mIsActivityPreviouslyStarted) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((inCallState == this.mInCallState && !z11) || z10) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "startOrFinishUi: same state return");
            }
            return inCallState;
        }
        if (inCallState4 == inCallState) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (inCallState != inCallState4) {
            this.mIncomingCallReceivedWearShowInCallUiNotify = false;
        }
        if (isShowingInCallUi() && getCallCardFragmentVisible()) {
            z13 = false;
        } else {
            z13 = true;
        }
        if ((inCallState3 == inCallState || InCallPresenter.InCallState.OUTGOING == inCallState) && z13) {
            z14 = true;
        } else {
            z14 = false;
        }
        OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
        if (oplusCallList != null && (oplusCallList.oplusGetActiveCall() != null || oplusCallList.oplusGetBackgroundCall() != null)) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (OplusFeatureOption.OPLUS_PHONE_AT_COMMAND) {
            if (!z14 && (this.mIsActivityPreviouslyStarted || !z15)) {
                z14 = false;
            } else {
                z14 = true;
            }
        }
        if (this.mInCallActivity != null && !isActivityStarted()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Undo the state change: " + inCallState + " -> " + this.mInCallState);
            }
            Context context = this.mContext;
            OplusPhoneUserActionStatistics.addNoCallUIAction(context, OplusPhoneUserActionStatistics.ACTION_ACTIVITY_FINISHING, context.getString(R.string.call_state_change, this.mInCallState, inCallState));
            return this.mInCallState;
        }
        if (!z14 && !z12) {
            if (InCallPresenter.InCallState.INCALL == inCallState && InCallPresenter.InCallState.NO_CALLS == this.mInCallState && z13) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "isAutoAnswer need to showUI = " + z14);
            }
        }
        D2.g.h(LOG_TAG, "Start in call UI showCallUi = " + z14 + "  startStartupSequence = " + z12);
        if (z14) {
            if (isActivityStarted()) {
                this.mInCallActivity.dismissPendingDialogs();
            }
            if (this.mFloatingWindowController.K()) {
                setIsActivityPreviouslyStarted(true);
                return inCallState;
            }
            Call oplusGetOutgoingCall = oplusCallList.oplusGetOutgoingCall();
            if (oplusGetOutgoingCall != null && ((OplusCall) oplusGetOutgoingCall).shouldHideUI()) {
                Context context2 = this.mContext;
                OplusPhoneUserActionStatistics.addNoCallUIAction(context2, OplusPhoneUserActionStatistics.ACTION_SHOULD_HIDE_ACTIVITY, context2.getString(R.string.call_state_change, this.mInCallState, inCallState));
                return inCallState;
            }
            showInCall(false, true);
            ProximitySensor proximitySensor = this.mProximitySensor;
            if (proximitySensor != null) {
                proximitySensor.oplusOnInCallShowing(true, true);
            }
        } else if (z12) {
            if (isActivityStarted()) {
                this.mInCallActivity.dismissPendingDialogs();
            }
            OplusCall oplusCall = (OplusCall) oplusCallList.getIncomingCall();
            if (oplusCall == null || !oplusCall.shouldAutoRecord() || (bVar = this.mAudioRecordInterface) == null || bVar.a().booleanValue()) {
                z16 = false;
            }
            if (hideIncomingCallUiByWear(oplusCall)) {
                D2.g.i(LOG_TAG, "NOTE, hide incoming call UI by wear device.");
                handleHideIncomingCallUiByWear();
                OplusPhoneUserActionStatistics.gameModeWatchInCallActivity(this.mContext, oplusCall);
                return inCallState;
            }
            if (!z16 && this.mFloatingWindowController.L()) {
                handleShowAnswerFloatingWindow(oplusCall);
            } else {
                if (hideIncomingCallUiByNotDisturb(oplusCall, z15)) {
                    handleHideIncomingCallUiByNotDisturb();
                    Context context3 = this.mContext;
                    OplusPhoneUserActionStatistics.addNoCallUIAction(context3, OplusPhoneUserActionStatistics.ACTION_INCALL_NOT_DISTURB, context3.getString(R.string.call_state_change, this.mInCallState, inCallState));
                    return inCallState;
                }
                D2.g.i(LOG_TAG, "showDefaultInCallUi.");
                showDefaultInCallUi(inCallState, oplusCall);
            }
            if (oplusCall != null) {
                oplusCall.setNotShowInCallUIForIncoming(false);
            }
        } else if (inCallState == InCallPresenter.InCallState.NO_CALLS && !OplusPhoneUtils.getNeedMarkNumber(this.mContext)) {
            attemptFinishActivity();
            attemptCleanup();
        }
        return inCallState;
    }

    public void startRinging(String str) {
        if (Log.sDebug) {
            K2.a.b(LOG_TAG, "startRinging from " + str);
        }
        if (VideoBackgroundUseCase.f18569a.n()) {
            if (Log.sDebug) {
                K2.a.b(LOG_TAG, "startRinging  VideoShow  will start ring from Video Show from " + str);
                return;
            }
            return;
        }
        Call incomingCall = CallList.getInstance().getIncomingCall();
        if (incomingCall != null) {
            String id = incomingCall.getId();
            if (Log.sDebug) {
                K2.a.b(LOG_TAG, "startRinging call id = " + id + " mLastRingCallId = " + this.mLastRingCallId + "  from " + str);
            }
            if (id != null && !id.equals(this.mLastRingCallId)) {
                A2.l.d().q(id, str);
                this.mLastRingCallId = id;
            } else {
                OplusPhoneUserActionStatistics.addNoIncomingRingAction(OplusInCallApp.getAppContext(), OplusPhoneUserActionStatistics.USER_ACTION_INCOMING_CALL_ID_NULL, this.mContext.getString(R.string.call_id_invalid, id, this.mLastRingCallId));
            }
        }
    }

    @Override // com.android.incallui.InCallPresenter
    public void tearDown() {
        super.tearDown();
        unregisterOplusInCallPresenterBroadcastReceiver(this.mContext);
        com.android.incallui.mvvm.utils.A.b(false);
    }

    public void unregisterHomeRecevier() {
        if (this.mHomeRecevier != null && this.mContext != null && this.mHasRegistHomekey) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "unregist mHomeRecevier , attemptCleanup...");
            }
            try {
                this.mContext.unregisterReceiver(this.mHomeRecevier);
                this.mHasRegistHomekey = false;
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public void unregisterOplusInCallPresenterBroadcastReceiver(Context context) {
        if (!A2.z.b()) {
            return;
        }
        if (context != null && this.mReceiver != null) {
            if (Log.sDebug) {
                Log.w(LOG_TAG, "unregisterOplusInCallPresenterBroadcastReceiver ");
            }
            OplusScreenController.e().h(this);
            context.unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
            OplusPhoneUtils.oplusRemoveOnSubscriptionsChangedListener(context, this.mOnSubscriptionsChangeListener);
            return;
        }
        if (Log.sDebug) {
            Log.w(LOG_TAG, "unregisterOplusInCallPresenterBroadcastReceiver fail");
        }
    }

    public void updateFloatingWindowIncomingCallNotification(Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateFloatingWindowIncomingCallNotification...");
        }
        StatusBarNotifier statusBarNotifier = this.mStatusBarNotifier;
        if (statusBarNotifier != null) {
            statusBarNotifier.updateFloatingWindowIncomingCallNotification(call);
        }
    }

    public void updateNotificationWhenResumeAndPause() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateNotificationWhenResumeAndPause...");
        }
        StatusBarNotifier statusBarNotifier = this.mStatusBarNotifier;
        if (statusBarNotifier != null) {
            statusBarNotifier.updateInCallNotification(false, this.mInCallState, this.mCallList);
        }
    }

    @Override // com.android.incallui.InCallPresenter
    public OplusInCallActivity getActivity() {
        return (OplusInCallActivity) this.mInCallActivity;
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onCallChanged(Call call) {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onChildNumberChange() {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onLastForwardedNumberChange() {
    }
}
