package com.android.incallui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.telecom.Call;
import android.telecom.DisconnectCause;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telecom.VideoProfile;
import android.view.Window;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.InCallVideoCallCallbackNotifier;
import com.android.incallui.util.MaterialColorMapUtils$MaterialPalette;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import t2.C1581a;

/* loaded from: classes.dex */
public class InCallPresenter implements CallList.Listener, InCallVideoCallCallbackNotifier.SessionModificationListener {
    protected AudioModeProvider mAudioModeProvider;
    protected CallList mCallList;
    protected ContactInfoCache mContactInfoCache;
    protected Context mContext;
    protected InCallActivity mInCallActivity;
    private PowerManager mPowerManager;
    protected ProximitySensor mProximitySensor;
    protected StatusBarNotifier mStatusBarNotifier;
    private TelecomManager mTelecomManager;
    private MaterialColorMapUtils$MaterialPalette mThemeColors;
    protected static InCallPresenter sInCallPresenter = new OplusInCallPresenter();
    private static String LOG_TAG = "InCallPresenter";
    protected final Set<InCallStateListener> mListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    protected final List<IncomingCallListener> mIncomingCallListeners = new CopyOnWriteArrayList();
    protected final Set<InCallDetailsListener> mDetailsListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private final Set<CanAddCallListener> mCanAddCallListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private final Set<InCallUiListener> mInCallUiListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private final Set<InCallOrientationListener> mOrientationListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    protected final Set<InCallEventListener> mInCallEventListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    protected InCallState mInCallState = InCallState.NO_CALLS;
    protected boolean mServiceConnected = false;
    private boolean mAccountSelectionCancelled = false;
    private InCallCameraManager mInCallCameraManager = null;
    private AnswerPresenter mAnswerPresenter = new AnswerPresenter();
    private PowerManager.WakeLock mWakeLock = null;
    protected Call primaryCall = null;
    protected Call secondaryCall = null;
    private boolean mIsFullScreen = false;
    private final Call.Callback mCallCallback = new Call.Callback() { // from class: com.android.incallui.InCallPresenter.1
        @Override // android.telecom.Call.Callback
        public void onConferenceableCallsChanged(android.telecom.Call call, List<android.telecom.Call> list) {
            Log.i(this, "onConferenceableCallsChanged: " + call);
            onDetailsChanged(call, call.getDetails());
        }

        @Override // android.telecom.Call.Callback
        public void onDetailsChanged(android.telecom.Call call, Call.Details details) {
            Call callByTelecommCall = InCallPresenter.this.mCallList.getCallByTelecommCall(call);
            if (callByTelecommCall == null) {
                Log.w(this, "Call not found in call list: " + call);
                return;
            }
            if (InCallPresenter.this.primaryCall == callByTelecommCall) {
                com.android.incallui.clean.data.datasource.i.f18344a.d(callByTelecommCall);
            }
            Iterator<InCallDetailsListener> it = InCallPresenter.this.mDetailsListeners.iterator();
            while (it.hasNext()) {
                it.next().onDetailsChanged(callByTelecommCall, details);
            }
        }

        @Override // android.telecom.Call.Callback
        public void onPostDialWait(android.telecom.Call call, String str) {
            Call callByTelecommCall = InCallPresenter.this.mCallList.getCallByTelecommCall(call);
            if (callByTelecommCall == null) {
                Log.w(this, "Call not found in call list: " + call);
                return;
            }
            InCallPresenter.this.onPostDialCharWait(callByTelecommCall.getId(), str);
        }
    };
    protected boolean mIsActivityPreviouslyStarted = false;
    private boolean mIsChangingConfigurations = false;
    private boolean mIsNavigationBarShow = false;
    private boolean mIsBringToForeground = false;
    protected boolean mIsHomeKeyPressed = false;

    /* loaded from: classes.dex */
    public interface CanAddCallListener {
        void onCanAddCallChanged(boolean z10);
    }

    /* loaded from: classes.dex */
    public interface InCallDetailsListener {
        void onDetailsChanged(Call call, Call.Details details);
    }

    /* loaded from: classes.dex */
    public interface InCallEventListener {
        void onFullscreenModeChanged(boolean z10);

        void onSecondaryCallerInfoVisibilityChanged(boolean z10, int i10);
    }

    /* loaded from: classes.dex */
    public interface InCallOrientationListener {
        void onDeviceOrientationChanged(int i10);
    }

    /* loaded from: classes.dex */
    public enum InCallState {
        NO_CALLS,
        INCOMING,
        INCALL,
        WAITING_FOR_ACCOUNT,
        PENDING_OUTGOING,
        OUTGOING;

        public boolean isConnectingOrConnected() {
            if (this != INCOMING && this != OUTGOING && this != PENDING_OUTGOING && this != WAITING_FOR_ACCOUNT && this != INCALL) {
                return false;
            }
            return true;
        }

        public boolean isDialing() {
            if (this != OUTGOING && this != PENDING_OUTGOING) {
                return false;
            }
            return true;
        }

        public boolean isInCall(Call call) {
            if (call == null || this != INCALL) {
                return false;
            }
            return !Call.State.isDisconnectingOrDisconnected(call.getState());
        }

        public boolean isIncoming() {
            if (this == INCOMING) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface InCallStateListener {
        void onStateChange(InCallState inCallState, InCallState inCallState2, CallList callList);
    }

    /* loaded from: classes.dex */
    public interface InCallUiListener {
        void onUiShowing(boolean z10);
    }

    /* loaded from: classes.dex */
    public interface IncomingCallListener {
        void onIncomingCall(InCallState inCallState, InCallState inCallState2, Call call);
    }

    private void acquireWakeLock() {
        Log.v(this, "acquireWakeLock");
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            wakeLock.acquire();
        }
    }

    public static InCallPresenter getInstance() {
        return sInCallPresenter;
    }

    private void notifyInCallUiStateNotifier(boolean z10) {
        Log.d(this, "notifyInCallUiStateNotifier: mIsChangingConfigurations=" + this.mIsChangingConfigurations);
        if (!this.mIsChangingConfigurations) {
            InCallUiStateNotifier.getInstance().onUiShowing(z10);
        }
    }

    private void releaseWakeLock() {
        Log.v(this, "releaseWakeLock");
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.mWakeLock.release();
        }
    }

    private void setDisconnectCauseForMissingAccounts(Call call) {
        String string;
        android.telecom.Call telecommCall = call.getTelecommCall();
        Bundle intentExtras = telecommCall.getDetails().getIntentExtras();
        if (intentExtras == null) {
            intentExtras = new Bundle();
        }
        ArrayList parcelableArrayList = intentExtras.getParcelableArrayList("selectPhoneAccountAccounts");
        Log.d(LOG_TAG, "setDisconnectCauseForMissingAccounts phoneAccountHandles = " + parcelableArrayList);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            if ("tel".equals(telecommCall.getDetails().getHandle().getScheme())) {
                string = this.mContext.getString(R.string.callFailed_simError);
            } else {
                string = this.mContext.getString(R.string.incall_error_supp_service_unknown);
            }
            call.setDisconnectCause(new DisconnectCause(1, null, string, string));
        }
    }

    public void acceptUpgradeRequest(Context context) {
        CallList callList = this.mCallList;
        if (callList == null) {
            StatusBarNotifier.clearInCallNotification(context);
            Log.e(this, " acceptUpgradeRequest mCallList is empty so returning");
        } else {
            Call videoUpgradeRequestCall = callList.getVideoUpgradeRequestCall();
            if (videoUpgradeRequestCall != null) {
                acceptUpgradeRequest(videoUpgradeRequestCall.getModifyToVideoState(), context);
            }
        }
    }

    public void acceptUpgradeRequestHideMe(Context context) {
        CallList callList = this.mCallList;
        if (callList == null) {
            StatusBarNotifier.clearInCallNotification(context);
            Log.e(this, " acceptUpgradeRequest mCallList is empty so returning");
        } else {
            Call videoUpgradeRequestCall = callList.getVideoUpgradeRequestCall();
            if (videoUpgradeRequestCall != null) {
                acceptUpgradeRequestHideMe(videoUpgradeRequestCall.getModifyToVideoState(), context);
            }
        }
    }

    public void addCanAddCallListener(CanAddCallListener canAddCallListener) {
        com.google.common.base.k.o(canAddCallListener);
        this.mCanAddCallListeners.add(canAddCallListener);
    }

    public void addDetailsListener(InCallDetailsListener inCallDetailsListener) {
        com.google.common.base.k.o(inCallDetailsListener);
        this.mDetailsListeners.add(inCallDetailsListener);
    }

    public void addInCallEventListener(InCallEventListener inCallEventListener) {
        com.google.common.base.k.o(inCallEventListener);
        this.mInCallEventListeners.add(inCallEventListener);
    }

    public void addInCallUiListener(InCallUiListener inCallUiListener) {
        this.mInCallUiListeners.add(inCallUiListener);
    }

    public void addIncomingCallListener(IncomingCallListener incomingCallListener) {
        com.google.common.base.k.o(incomingCallListener);
        if (!this.mIncomingCallListeners.contains(incomingCallListener)) {
            this.mIncomingCallListeners.add(incomingCallListener);
        }
    }

    public void addListener(InCallStateListener inCallStateListener) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "addListener = " + inCallStateListener);
        }
        com.google.common.base.k.o(inCallStateListener);
        this.mListeners.add(inCallStateListener);
    }

    public void addOrientationListener(InCallOrientationListener inCallOrientationListener) {
        com.google.common.base.k.o(inCallOrientationListener);
        this.mOrientationListeners.add(inCallOrientationListener);
    }

    public void answerIncomingCall(Context context, int i10) {
        CallList callList = this.mCallList;
        if (callList == null) {
            StatusBarNotifier.clearInCallNotification(context);
            return;
        }
        Call incomingCall = callList.getIncomingCall();
        if (incomingCall != null) {
            TelecomAdapter.getInstance().answerCall(incomingCall.getId(), i10);
            if (CallUtils.isVideoCall(i10)) {
                showInCall(false, false);
            }
        }
    }

    public void attemptCleanup() {
        boolean z10;
        if (this.mInCallActivity == null && !this.mServiceConnected && this.mInCallState == InCallState.NO_CALLS) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.i(LOG_TAG, "attemptCleanup? " + z10);
        }
        if (z10) {
            setIsActivityPreviouslyStarted(false);
            this.mIsChangingConfigurations = false;
            realInstance().unregisterOplusInCallPresenterBroadcastReceiver(this.mContext);
            ContactInfoCache contactInfoCache = this.mContactInfoCache;
            if (contactInfoCache != null) {
                contactInfoCache.clearCache();
            }
            this.mContactInfoCache = null;
            if (this.mProximitySensor != null) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "attemptCleanup mProximitySensor");
                }
                removeListener(this.mProximitySensor);
                this.mProximitySensor.tearDown();
            }
            this.mProximitySensor = null;
            this.mWakeLock = null;
            this.mPowerManager = null;
            this.mAudioModeProvider = null;
            if (this.mStatusBarNotifier != null) {
                if (Log.sDebug) {
                    Log.i(LOG_TAG, "attemptCleanup  cancelInCall");
                }
                this.mStatusBarNotifier.cancelInCall();
                removeListener(this.mStatusBarNotifier);
            }
            this.mStatusBarNotifier = null;
            CallList callList = this.mCallList;
            if (callList != null) {
                callList.removeListener(this);
                this.mCallList.oplusCallList().setImsMergedSuccessfully(false);
            }
            this.mCallList = null;
            this.mContext = null;
            this.mInCallActivity = null;
            Set<InCallStateListener> set = this.mListeners;
            if (set != null) {
                set.clear();
            }
            List<IncomingCallListener> list = this.mIncomingCallListeners;
            if (list != null) {
                list.clear();
            }
            this.mDetailsListeners.clear();
            this.mCanAddCallListeners.clear();
            this.mOrientationListeners.clear();
            this.mInCallEventListeners.clear();
            realInstance().setIncomingInterfaceType(0);
            Log.i(LOG_TAG, "Finished InCallPresenter.CleanUp");
        }
    }

    public void attemptFinishActivity() {
        boolean z10;
        if (this.mInCallActivity != null && isActivityStarted()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.i(LOG_TAG, "Hide in call UI: " + z10);
        if (this.mCallList != null && InCallServiceImpl.isDsdaEnabled()) {
            CallList callList = this.mCallList;
            if (!callList.hasAnyLiveCall(callList.getActiveSubId())) {
                Log.d(this, "Switch active sub");
                if (this.mCallList.switchToOtherActiveSub()) {
                    return;
                }
            }
        }
        CallList callList2 = this.mCallList;
        if (callList2 != null) {
            ((OplusCallList) callList2).clearExtCallInfoMap();
        }
        if (z10) {
            this.mInCallActivity.finish();
            if (this.mAccountSelectionCancelled) {
                this.mInCallActivity.overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        if (Log.sDebug) {
            Log.i(LOG_TAG, "sendMessageFinishActivity...");
        }
        realInstance().sendMessageFinishActivity();
    }

    public void bringToForeground(boolean z10) {
        InCallState inCallState;
        if (!isShowingInCallUi() && (inCallState = this.mInCallState) != InCallState.NO_CALLS && inCallState != InCallState.WAITING_FOR_ACCOUNT) {
            this.mIsBringToForeground = true;
            showInCall(z10, false);
            this.mIsBringToForeground = false;
            userActionStatisticsHomeKeyPressed();
        }
    }

    public void declineIncomingCall(Context context) {
        CallList callList = this.mCallList;
        if (callList == null) {
            StatusBarNotifier.clearInCallNotification(context);
            return;
        }
        Call incomingCall = callList.getIncomingCall();
        if (incomingCall != null) {
            TelecomAdapter.getInstance().rejectCall(incomingCall.getId(), false, null);
        }
    }

    public void declineUpgradeRequest(Context context) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, " declineUpgradeRequest");
        }
        CallList callList = this.mCallList;
        if (callList == null) {
            StatusBarNotifier.clearInCallNotification(context);
            Log.e(LOG_TAG, " declineUpgradeRequest mCallList is empty so returning");
            return;
        }
        Call videoUpgradeRequestCall = callList.getVideoUpgradeRequestCall();
        if (videoUpgradeRequestCall != null && videoUpgradeRequestCall.getVideoCall() != null) {
            videoUpgradeRequestCall.getVideoCall().sendSessionModifyResponse(new VideoProfile(videoUpgradeRequestCall.getVideoState()));
            videoUpgradeRequestCall.setSessionModificationState(0);
            return;
        }
        Log.e(LOG_TAG, " declineUpgradeRequest call or call.getVideoCall() is null");
    }

    public void enableScreenTimeout(boolean z10) {
        Log.v(this, "enableScreenTimeout: value=" + z10);
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity == null) {
            Log.e(this, "enableScreenTimeout: InCallActivity is null.");
            return;
        }
        Window window = inCallActivity.getWindow();
        if (z10) {
            window.clearFlags(128);
        } else {
            window.addFlags(128);
        }
    }

    public InCallActivity getActivity() {
        return this.mInCallActivity;
    }

    public AnswerPresenter getAnswerPresenter() {
        return this.mAnswerPresenter;
    }

    public boolean getCallCardFragmentVisible() {
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null && inCallActivity.getCallCardFragment() != null) {
            return this.mInCallActivity.getCallCardFragment().isVisible();
        }
        return false;
    }

    public CallList getCallList() {
        return this.mCallList;
    }

    public Context getContext() {
        return this.mContext;
    }

    public C1581a getFloatingWindowController() {
        return null;
    }

    public V5.b getFoldScreenController() {
        return null;
    }

    public InCallCameraManager getInCallCameraManager() {
        InCallCameraManager inCallCameraManager;
        synchronized (this) {
            try {
                if (this.mInCallCameraManager == null) {
                    this.mInCallCameraManager = new InCallCameraManager(this.mContext);
                }
                inCallCameraManager = this.mInCallCameraManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return inCallCameraManager;
    }

    public Intent getInCallIntent(boolean z10, boolean z11) {
        boolean z12;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setFlags(277086208);
        if (OplusTelephonyCapabilities.isOplusEnabled()) {
            intent.setClass(this.mContext, OplusInCallActivity.class);
            if (this.mIsBringToForeground && OplusPhoneUtils.getPhoneScreenLockState(this.mContext)) {
                z12 = true;
            } else {
                z12 = false;
            }
            intent.putExtra(InCallActivity.LOCK_SCREEN_STATE, z12);
        } else {
            intent.setClass(this.mContext, InCallActivity.class);
        }
        if (z10) {
            intent.putExtra(InCallActivity.SHOW_DIALPAD_EXTRA, true);
        }
        intent.putExtra(InCallActivity.NEW_OUTGOING_CALL, z11);
        return intent;
    }

    public InCallState getInCallState() {
        return this.mInCallState;
    }

    public A2.v getOplusSelectPhoneAccountManager() {
        return null;
    }

    public InCallState getPotentialStateFromCallList(CallList callList) {
        InCallState inCallState = InCallState.NO_CALLS;
        if (callList == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "getPotentialStateFromCallList  callList is null return!!!");
            }
            return inCallState;
        }
        if (callList.getIncomingCall() != null) {
            return InCallState.INCOMING;
        }
        if (callList.getWaitingForAccountCall() != null) {
            return InCallState.WAITING_FOR_ACCOUNT;
        }
        if (callList.getPendingOutgoingCall() != null) {
            return InCallState.PENDING_OUTGOING;
        }
        if (callList.getOutgoingCall() != null) {
            return InCallState.OUTGOING;
        }
        if (callList.getActiveCall() != null || callList.getBackgroundCall() != null || callList.getDisconnectedCall() != null || callList.getDisconnectingCall() != null || callList.getConferenceCall() != null) {
            return InCallState.INCALL;
        }
        return inCallState;
    }

    public ProximitySensor getProximitySensor() {
        return this.mProximitySensor;
    }

    public float getSpaceBesideCallCard() {
        return 0.0f;
    }

    public TelecomManager getTelecomManager() {
        if (this.mTelecomManager == null) {
            this.mTelecomManager = (TelecomManager) this.mContext.getSystemService("telecom");
        }
        return this.mTelecomManager;
    }

    public MaterialColorMapUtils$MaterialPalette getThemeColors() {
        return this.mThemeColors;
    }

    public VideoCallPresenter getVideoCallPresenter() {
        return null;
    }

    public boolean handleCallKey() {
        Log.v(LOG_TAG, "handleCallKey");
        CallList callList = this.mCallList;
        Call incomingCall = callList.getIncomingCall();
        Log.v(LOG_TAG, "incomingCall: " + incomingCall);
        if (incomingCall != null) {
            TelecomAdapter.getInstance().answerCall(incomingCall.getId(), 0);
            return true;
        }
        Call activeCall = callList.getActiveCall();
        if (activeCall != null) {
            boolean can = activeCall.can(4);
            boolean can2 = activeCall.can(8);
            Log.v(LOG_TAG, "activeCall: " + activeCall + ", canMerge: " + can + ", canSwap: " + can2);
            if (can) {
                TelecomAdapter.getInstance().merge(activeCall.getId());
                return true;
            }
            if (can2) {
                TelecomAdapter.getInstance().swap(activeCall.getId());
                return true;
            }
        }
        Call backgroundCall = callList.getBackgroundCall();
        if (backgroundCall != null) {
            boolean can3 = backgroundCall.can(1);
            Log.v(LOG_TAG, "heldCall: " + backgroundCall + ", canHold: " + can3);
            if (backgroundCall.getState() == 8 && can3) {
                TelecomAdapter.getInstance().unholdCall(backgroundCall.getId());
            }
        }
        return true;
    }

    public void hangUpOngoingCall(Context context) {
        CallList callList = this.mCallList;
        if (callList == null) {
            if (this.mStatusBarNotifier == null) {
                StatusBarNotifier.clearInCallNotification(context);
                return;
            }
            return;
        }
        Call outgoingCall = callList.getOutgoingCall();
        if (outgoingCall == null) {
            outgoingCall = this.mCallList.getActiveOrBackgroundCall();
        }
        if (outgoingCall != null) {
            TelecomAdapter.getInstance().disconnectCall(outgoingCall.getId());
            outgoingCall.setState(9);
            this.mCallList.onUpdate(outgoingCall);
        }
    }

    public boolean isActivityForeground() {
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null && inCallActivity.isForegroundActivity()) {
            return true;
        }
        return false;
    }

    public boolean isActivityPreviouslyStarted() {
        return this.mIsActivityPreviouslyStarted;
    }

    public boolean isActivityStarted() {
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null && !inCallActivity.isDestroyed() && !this.mInCallActivity.isFinishing()) {
            return true;
        }
        return false;
    }

    public boolean isChangingConfigurations() {
        return this.mIsChangingConfigurations;
    }

    public boolean isDialpadVisible() {
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity == null) {
            return false;
        }
        return inCallActivity.getInCallFragmentManager().isDialpadVisible();
    }

    public boolean isDisplayAod() {
        boolean z10;
        PowerManager powerManager;
        if (OplusPhoneUtils.isSoftwareAodSupport() && (powerManager = this.mPowerManager) != null) {
            z10 = A2.d.a(powerManager);
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isDisplayAod  = " + z10);
        }
        return z10;
    }

    public boolean isFullscreen() {
        return this.mIsFullScreen;
    }

    public boolean isNavigationBarShow() {
        return this.mIsNavigationBarShow;
    }

    public boolean isScreenInteractive() {
        boolean z10;
        PowerManager powerManager = this.mPowerManager;
        if (powerManager != null) {
            z10 = powerManager.isInteractive();
        } else {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isScreenInteractive  = " + z10);
        }
        return z10;
    }

    public boolean isShowingInCallUi() {
        if (isActivityStarted() && this.mInCallActivity.isForegroundActivity()) {
            return true;
        }
        return false;
    }

    public void log(String str) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, str);
        }
    }

    public void maybeShowErrorDialogOnDisconnect(Call call) {
        if (call.getDisconnectCause() != null && (call.getDisconnectCause().getCode() == 2 || call.getDisconnectCause().getCode() == 4)) {
            Log.d(LOG_TAG, "local disconnect, not need to show error dialog.");
            return;
        }
        if (isActivityStarted() && call.getState() == 10) {
            if (call.getAccountHandle() == null && !call.isConferenceCall()) {
                setDisconnectCauseForMissingAccounts(call);
            }
            this.mInCallActivity.maybeShowErrorDialogOnDisconnect(call.getDisconnectCause(), call.getSlotId());
        }
    }

    public void notifyFullscreenModeChange(boolean z10) {
        Iterator<InCallEventListener> it = this.mInCallEventListeners.iterator();
        while (it.hasNext()) {
            it.next().onFullscreenModeChanged(z10);
        }
    }

    public void notifyNavigationBarChange(boolean z10) {
        if (Log.sDebug) {
            Log.d(this, "notifyNavigationBarChange " + this.mIsNavigationBarShow + " newState = " + z10);
        }
        if (z10 == this.mIsNavigationBarShow) {
            return;
        }
        this.mIsNavigationBarShow = z10;
    }

    public void onActivityStarted() {
        Log.d(this, "onActivityStarted");
        notifyInCallUiStateNotifier(true);
    }

    public void onActivityStopped() {
        Log.d(this, "onActivityStopped");
        notifyInCallUiStateNotifier(false);
    }

    public void onBringToForeground(boolean z10) {
        Log.i(this, "Bringing UI to foreground.");
        bringToForeground(z10);
    }

    public void onCallAdded(android.telecom.Call call) {
        setBoundAndWaitingForOutgoingCall(false, null);
        call.registerCallback(this.mCallCallback);
    }

    @Override // com.android.incallui.CallList.Listener
    public void onCallListChange(CallList callList) {
        boolean z10;
        if (callList == null) {
            return;
        }
        InCallState potentialStateFromCallList = getPotentialStateFromCallList(callList);
        InCallState inCallState = this.mInCallState;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onCallListChange oldState= " + inCallState + " newState=" + potentialStateFromCallList);
        }
        InCallState startOrFinishUi = startOrFinishUi(potentialStateFromCallList);
        this.mInCallState = startOrFinishUi;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "Phone switching state: " + inCallState + " -> " + startOrFinishUi + " oplusGetCallSize=" + ((OplusCallList) CallList.getInstance()).oplusGetCallSize());
        }
        Iterator<InCallStateListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onStateChange(inCallState, this.mInCallState, callList);
        }
        if (isActivityStarted()) {
            if (callList.getActiveOrBackgroundCall() == null && callList.getOutgoingCall() == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.mInCallActivity.dismissKeyguard(z10);
        }
    }

    public void onCallRemoved(android.telecom.Call call) {
        call.unregisterCallback(this.mCallCallback);
    }

    public void onCanAddCallChanged(boolean z10) {
        Iterator<CanAddCallListener> it = this.mCanAddCallListeners.iterator();
        while (it.hasNext()) {
            it.next().onCanAddCallChanged(z10);
        }
    }

    public void onDeviceOrientationChange(int i10) {
        Log.d(this, "onDeviceOrientationChange: orientation= " + i10);
        CallList callList = this.mCallList;
        if (callList != null) {
            callList.notifyCallsOfDeviceRotation(i10);
        } else {
            Log.w(this, "onDeviceOrientationChange: CallList is null.");
        }
        Iterator<InCallOrientationListener> it = this.mOrientationListeners.iterator();
        while (it.hasNext()) {
            it.next().onDeviceOrientationChanged(i10);
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onDisconnect(Call call) {
        maybeShowErrorDialogOnDisconnect(call);
        onCallListChange(this.mCallList);
        if (isActivityStarted()) {
            this.mInCallActivity.dismissKeyguard(false);
        }
    }

    public void onDismissDialog() {
        if (Log.sDebug) {
            Log.i(LOG_TAG, "Dialog dismissed mInCallState = " + this.mInCallState);
        }
        if (this.mInCallState == InCallState.NO_CALLS) {
            attemptFinishActivity();
            attemptCleanup();
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onIncomingCall(Call call) {
        InCallState startOrFinishUi = startOrFinishUi(InCallState.INCOMING);
        InCallState inCallState = this.mInCallState;
        D2.g.i(LOG_TAG, "Phone switching state: " + inCallState + " -> " + startOrFinishUi);
        this.mInCallState = startOrFinishUi;
        Iterator<IncomingCallListener> it = this.mIncomingCallListeners.iterator();
        while (it.hasNext()) {
            it.next().onIncomingCall(inCallState, this.mInCallState, call);
        }
    }

    public void onPostDialCharWait(String str, String str2) {
        if (isActivityStarted()) {
            this.mInCallActivity.showPostCharWaitDialog(str, str2);
        }
    }

    public void onServiceUnbind() {
        getInstance().setBoundAndWaitingForOutgoingCall(false, null);
    }

    public void onUiShowing(boolean z10) {
        ProximitySensor proximitySensor = this.mProximitySensor;
        if (proximitySensor != null) {
            proximitySensor.onInCallShowing(z10);
        }
        if (z10) {
            setIsActivityPreviouslyStarted(true);
        } else {
            updateIsChangingConfigurations();
        }
        Iterator<InCallUiListener> it = this.mInCallUiListeners.iterator();
        while (it.hasNext()) {
            it.next().onUiShowing(z10);
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onUpgradeToVideo(Call call) {
        bringToForeground(false);
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoRequest(Call call, int i10) {
        Log.d(this, "onUpgradeToVideoRequest call = " + call + " video state = " + i10);
        if (call == null) {
            return;
        }
        call.setSessionModificationTo(i10);
    }

    public void oplusInterceptCallNotification(int i10) {
        StatusBarNotifier statusBarNotifier = this.mStatusBarNotifier;
        if (statusBarNotifier != null) {
            statusBarNotifier.interceptCallNotification(i10);
        }
    }

    public OplusInCallPresenter realInstance() {
        return (OplusInCallPresenter) sInCallPresenter;
    }

    public void removeCanAddCallListener(CanAddCallListener canAddCallListener) {
        if (canAddCallListener != null) {
            this.mCanAddCallListeners.remove(canAddCallListener);
        }
    }

    public void removeDetailsListener(InCallDetailsListener inCallDetailsListener) {
        if (inCallDetailsListener != null) {
            this.mDetailsListeners.remove(inCallDetailsListener);
        }
    }

    public void removeInCallEventListener(InCallEventListener inCallEventListener) {
        if (inCallEventListener != null) {
            this.mInCallEventListeners.remove(inCallEventListener);
        }
    }

    public boolean removeInCallUiListener(InCallUiListener inCallUiListener) {
        return this.mInCallUiListeners.remove(inCallUiListener);
    }

    public void removeIncomingCallListener(IncomingCallListener incomingCallListener) {
        if (incomingCallListener != null) {
            this.mIncomingCallListeners.remove(incomingCallListener);
        }
    }

    public void removeListener(InCallStateListener inCallStateListener) {
        if (inCallStateListener != null) {
            this.mListeners.remove(inCallStateListener);
        }
    }

    public void removeOrientationListener(InCallOrientationListener inCallOrientationListener) {
        if (inCallOrientationListener != null) {
            this.mOrientationListeners.remove(inCallOrientationListener);
        }
    }

    public void setActivity(InCallActivity inCallActivity) {
        boolean z10;
        boolean z11 = true;
        if (inCallActivity != null) {
            InCallActivity inCallActivity2 = this.mInCallActivity;
            z10 = false;
            if (inCallActivity2 == null) {
                Log.i(LOG_TAG, "UI Initialized");
            } else {
                if (inCallActivity2 != inCallActivity) {
                    Log.wtf(LOG_TAG, "Setting a second activity before destroying the first.");
                }
                z11 = false;
            }
            this.mInCallActivity = inCallActivity;
            CallList callList = this.mCallList;
            if (callList != null && callList.getDisconnectedCall() != null) {
                maybeShowErrorDialogOnDisconnect(this.mCallList.getDisconnectedCall());
            }
            if (this.mInCallState == InCallState.NO_CALLS) {
                Log.i(LOG_TAG, "UI Intialized, but no calls left.  shut down.");
                attemptFinishActivity();
                return;
            }
        } else {
            Log.i(LOG_TAG, "UI Destroyed)");
            this.mInCallActivity = null;
            z10 = true;
        }
        if (z11) {
            onCallListChange(this.mCallList);
        }
        if (z10) {
            attemptCleanup();
        }
    }

    public void setBoundAndWaitingForOutgoingCall(boolean z10, PhoneAccountHandle phoneAccountHandle) {
        Log.i(this, "setBoundAndWaitingForOutgoingCall: " + z10);
        if (z10 && this.mInCallState == InCallState.NO_CALLS) {
            this.mInCallState = InCallState.OUTGOING;
        }
    }

    public void setFullScreen(boolean z10) {
        setFullScreen(z10, false);
    }

    public void setInCallAllowsOrientationChange(Call call, int i10) {
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null && call != null) {
            inCallActivity.enableInCallOrientationEventListener(CallUtils.isVideoCall(call));
        } else {
            Log.e(this, "InCallActivity is null. Can't set requested orientation.");
        }
    }

    public void setIsActivityPreviouslyStarted(boolean z10) {
        if (Log.sDebug) {
            Log.i(LOG_TAG, "setIsActivityPreviouslyStarted previouslyStarted = " + z10 + "  mIsActivityPreviouslyStarted = " + this.mIsActivityPreviouslyStarted);
        }
        this.mIsActivityPreviouslyStarted = z10;
    }

    public void setUp(Context context, CallList callList, AudioModeProvider audioModeProvider, StatusBarNotifier statusBarNotifier, ContactInfoCache contactInfoCache, ProximitySensor proximitySensor) {
        boolean z10;
        boolean z11;
        boolean z12 = true;
        if (this.mServiceConnected) {
            Log.i(LOG_TAG, "New service connection replacing existing one.");
            if (context == this.mContext) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.u(z10);
            if (callList == this.mCallList) {
                z11 = true;
            } else {
                z11 = false;
            }
            com.google.common.base.k.u(z11);
            if (audioModeProvider != this.mAudioModeProvider) {
                z12 = false;
            }
            com.google.common.base.k.u(z12);
            return;
        }
        com.google.common.base.k.o(context);
        this.mContext = context;
        this.mContactInfoCache = contactInfoCache;
        this.mStatusBarNotifier = statusBarNotifier;
        addListener(statusBarNotifier);
        this.mAudioModeProvider = audioModeProvider;
        this.mProximitySensor = proximitySensor;
        addListener(proximitySensor);
        addIncomingCallListener(this.mAnswerPresenter);
        addInCallUiListener(this.mAnswerPresenter);
        PowerManager powerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mPowerManager = powerManager;
        this.mWakeLock = powerManager.newWakeLock(268435466, "InCallUI:InCallPresenter");
        this.mCallList = callList;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "mCallList  = " + this.mCallList);
        }
        this.mServiceConnected = true;
        this.mCallList.addListener(this);
        InCallUiStateNotifier.getInstance().setUp(this.mContext);
        InCallLowBatteryListener.getInstance().setUp(this.mContext);
        OrientationModeHandler.getInstance().setUp();
        addDetailsListener(CallSubstateNotifier.getInstance());
        addDetailsListener(SessionModificationCauseNotifier.getInstance());
        InCallVideoCallCallbackNotifier.getInstance().addSessionModificationListener(this);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "Finished InCallPresenter.setUp");
        }
    }

    public void showInCall(boolean z10, boolean z11) {
        Log.i(this, "Showing InCallActivity");
        L1.c.h(this.mContext, getInCallIntent(z10, z11));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.incallui.InCallPresenter.InCallState startOrFinishUi(com.android.incallui.InCallPresenter.InCallState r12) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.InCallPresenter.startOrFinishUi(com.android.incallui.InCallPresenter$InCallState):com.android.incallui.InCallPresenter$InCallState");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean startUi(com.android.incallui.InCallPresenter.InCallState r8) {
        /*
            r7 = this;
            com.android.incallui.CallList r0 = r7.mCallList
            com.android.incallui.Call r0 = r0.getIncomingCall()
            com.android.incallui.CallList r1 = r7.mCallList
            com.android.incallui.Call r1 = r1.getActiveCall()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1a
            com.android.incallui.CallList r1 = r7.mCallList
            com.android.incallui.Call r1 = r1.getIncomingCall()
            if (r1 == 0) goto L1a
            r1 = r2
            goto L1b
        L1a:
            r1 = r3
        L1b:
            if (r0 == 0) goto L2b
            com.android.incallui.CallList r0 = r7.mCallList
            int r4 = r0.getActiveSubId()
            boolean r0 = r0.isAnyOtherSubActive(r4)
            if (r0 == 0) goto L2b
            r0 = r2
            goto L2c
        L2b:
            r0 = r3
        L2c:
            boolean r4 = com.android.incallui.Log.sDebug
            if (r4 == 0) goto L46
            java.lang.String r4 = com.android.incallui.InCallPresenter.LOG_TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Start UI  anyOtherSubActive:"
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.android.incallui.Log.i(r4, r5)
        L46:
            boolean r4 = com.android.incallui.OplusTelephonyCapabilities.isOplusEnabled()
            if (r4 != 0) goto L68
            if (r1 != 0) goto L50
            if (r0 == 0) goto L68
        L50:
            com.android.incallui.ProximitySensor r8 = r7.mProximitySensor
            boolean r8 = r8.isScreenReallyOff()
            if (r8 == 0) goto L64
            boolean r8 = r7.isActivityStarted()
            if (r8 == 0) goto L64
            com.android.incallui.InCallActivity r7 = r7.mInCallActivity
            r7.finish()
            return r3
        L64:
            r7.showInCall(r3, r3)
            goto L7b
        L68:
            com.internal_dependency.InternalSdkDepends r0 = com.internal_dependency.InternalSdkDepends.getSInstance()
            java.lang.String r1 = "call"
            r0.closeSystemDialogs(r1)
            r7.setIsActivityPreviouslyStarted(r2)
            com.android.incallui.StatusBarNotifier r0 = r7.mStatusBarNotifier
            com.android.incallui.CallList r7 = r7.mCallList
            r0.updateNotificationAndLaunchIncomingCallUi(r8, r7)
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.InCallPresenter.startUi(com.android.incallui.InCallPresenter$InCallState):boolean");
    }

    public void tearDown() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "tearDown");
        }
        this.mServiceConnected = false;
        attemptCleanup();
        InCallUiStateNotifier.getInstance().tearDown();
        InCallLowBatteryListener.getInstance().tearDown();
        OrientationModeHandler.getInstance().tearDown();
        removeDetailsListener(CallSubstateNotifier.getInstance());
        removeDetailsListener(SessionModificationCauseNotifier.getInstance());
        InCallVideoCallCallbackNotifier.getInstance().removeSessionModificationListener(this);
    }

    public void updateIsChangingConfigurations() {
        this.mIsChangingConfigurations = false;
        InCallActivity inCallActivity = this.mInCallActivity;
        if (inCallActivity != null) {
            this.mIsChangingConfigurations = inCallActivity.isChangingConfigurations();
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateIsChangingConfigurations=" + this.mIsChangingConfigurations);
        }
    }

    public void userActionStatisticsHomeKeyPressed() {
        if (this.mIsHomeKeyPressed && CallList.getInstance().getIncomingCall() != null) {
            this.mIsHomeKeyPressed = false;
            if (Log.sDebug) {
                Log.d(LOG_TAG, "OplusPhoneUserActionStatistics mIsHomeKeyPressed");
            }
            OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_TECHNOLOGY_STATISTIC, OplusPhoneUserActionStatistics.EVENT_SHOW_RING_UI_AFTER_PRESS_HOME_KEY, (Map) null);
        }
    }

    public void wakeUpScreen() {
        if (!isScreenInteractive()) {
            acquireWakeLock();
            releaseWakeLock();
        }
    }

    public void setFullScreen(boolean z10, boolean z11) {
        Log.v(this, "setFullScreen = " + z10);
        if (isDialpadVisible()) {
            Log.v(this, "setFullScreen overridden as dialpad is shown = false");
            z10 = false;
        }
        if (this.mIsFullScreen == z10 && !z11) {
            Log.v(this, "setFullScreen ignored as already in that state.");
        } else {
            this.mIsFullScreen = z10;
            notifyFullscreenModeChange(z10);
        }
    }

    public void acceptUpgradeRequest(int i10, Context context) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, " acceptUpgradeRequest videoState " + i10);
        }
        CallList callList = this.mCallList;
        if (callList == null) {
            StatusBarNotifier.clearInCallNotification(context);
            Log.e(LOG_TAG, " acceptUpgradeRequest mCallList is empty so returning");
            return;
        }
        Call videoUpgradeRequestCall = callList.getVideoUpgradeRequestCall();
        if (videoUpgradeRequestCall != null && videoUpgradeRequestCall.getVideoCall() != null) {
            videoUpgradeRequestCall.getVideoCall().sendSessionModifyResponse(new VideoProfile(i10));
            videoUpgradeRequestCall.setSessionModificationState(0);
            InCallAudioManager.getInstance().onAcceptUpgradeRequest(videoUpgradeRequestCall, i10);
            return;
        }
        Log.e(LOG_TAG, " acceptUpgradeRequest call or call.getVideoCall() is null");
    }

    public void acceptUpgradeRequestHideMe(int i10, Context context) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, " acceptUpgradeRequest videoState " + i10);
        }
        CallList callList = this.mCallList;
        if (callList == null) {
            StatusBarNotifier.clearInCallNotification(context);
            Log.e(LOG_TAG, " acceptUpgradeRequest mCallList is empty so returning");
            return;
        }
        Call videoUpgradeRequestCall = callList.getVideoUpgradeRequestCall();
        if (videoUpgradeRequestCall != null && videoUpgradeRequestCall.getVideoCall() != null) {
            videoUpgradeRequestCall.getVideoCall().sendSessionModifyResponse(new VideoProfile(i10 & (-2)));
            videoUpgradeRequestCall.setSessionModificationState(0);
            InCallAudioManager.getInstance().onAcceptUpgradeRequest(videoUpgradeRequestCall, i10);
            return;
        }
        Log.e(LOG_TAG, " acceptUpgradeRequest call or call.getVideoCall() is null");
    }

    public void declineUpgradeRequest() {
        Context context = this.mInCallActivity;
        if (context == null) {
            context = this.mContext;
        }
        declineUpgradeRequest(context);
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onDowngradeToAudio(Call call) {
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoSuccess(Call call) {
    }

    public void setVideoCallPresenter(VideoCallPresenter videoCallPresenter) {
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoFail(int i10, Call call) {
    }
}
