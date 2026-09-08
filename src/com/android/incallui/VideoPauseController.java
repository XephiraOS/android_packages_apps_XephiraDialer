package com.android.incallui;

import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.InCallVideoCallCallbackNotifier;

/* loaded from: classes.dex */
class VideoPauseController implements InCallPresenter.InCallStateListener, InCallPresenter.IncomingCallListener, InCallVideoCallCallbackNotifier.SessionModificationListener, InCallUiStateNotifierListener {
    private static final String TAG = "VideoPauseController:";
    private InCallPresenter mInCallPresenter;
    private CallContext mPrimaryCallContext = null;
    private boolean mIsInBackground = false;

    /* loaded from: classes.dex */
    public class CallContext {
        private Call mCall;
        private int mState = 0;
        private int mVideoState;

        public CallContext(Call call) {
            com.google.common.base.k.o(call);
            update(call);
        }

        public Call getCall() {
            return this.mCall;
        }

        public int getState() {
            return this.mState;
        }

        public int getVideoState() {
            return this.mVideoState;
        }

        public String toString() {
            return String.format("CallContext {CallId=%s, State=%s, VideoState=%d}", this.mCall.getId(), Integer.valueOf(this.mState), Integer.valueOf(this.mVideoState));
        }

        public void update(Call call) {
            this.mCall = (Call) com.google.common.base.k.o(call);
            this.mState = call.getState();
            this.mVideoState = call.getVideoState();
        }
    }

    private static boolean areSame(Call call, CallContext callContext) {
        if (call == null && callContext == null) {
            return true;
        }
        if (call != null && callContext != null) {
            return call.equals(callContext.getCall());
        }
        return false;
    }

    private void bringToForeground() {
        if (this.mInCallPresenter != null) {
            log("Bringing UI to foreground");
            this.mInCallPresenter.bringToForeground(false);
        } else {
            loge("InCallPresenter is null. Cannot bring UI to foreground");
        }
    }

    private static boolean canVideoPause(CallContext callContext) {
        if (isVideoCall(callContext) && callContext.getState() == 3) {
            return true;
        }
        return false;
    }

    private void clear() {
        this.mInCallPresenter = null;
        this.mPrimaryCallContext = null;
        this.mIsInBackground = false;
    }

    private static boolean isDialing(CallContext callContext) {
        if (callContext != null && Call.State.isDialing(callContext.getState())) {
            return true;
        }
        return false;
    }

    private static boolean isIncoming(int i10) {
        if (i10 != 5 && i10 != 4) {
            return false;
        }
        return true;
    }

    private static boolean isIncomingCall(CallContext callContext) {
        return callContext != null && isIncoming(callContext.getState());
    }

    private static boolean isVideoCall(CallContext callContext) {
        if (callContext != null && CallUtils.isVideoCall(callContext.getVideoState())) {
            return true;
        }
        return false;
    }

    private void log(String str) {
        Log.d(this, TAG + str);
    }

    private void loge(String str) {
        Log.e(this, TAG + str);
    }

    private void onPause(boolean z10) {
        log("onPause");
        if (this.mIsInBackground) {
            log("onPause, Ignoring... already paused");
            return;
        }
        this.mIsInBackground = true;
        if (canVideoPause(this.mPrimaryCallContext) && z10) {
            sendRequest(this.mPrimaryCallContext.getCall(), false);
        } else {
            log("onPause, Ignoring...");
        }
    }

    private void onPrimaryCallChanged(Call call) {
        log("onPrimaryCallChanged: New call = " + call);
        log("onPrimaryCallChanged: Old call = " + this.mPrimaryCallContext);
        log("onPrimaryCallChanged, IsInBackground=" + this.mIsInBackground);
        com.google.common.base.k.u(areSame(call, this.mPrimaryCallContext) ^ true);
        boolean canVideoPause = CallUtils.canVideoPause(call);
        if ((isIncomingCall(this.mPrimaryCallContext) || isDialing(this.mPrimaryCallContext)) && canVideoPause && !this.mIsInBackground) {
            sendRequest(call, true);
        } else if (isIncomingCall(call) && canVideoPause(this.mPrimaryCallContext)) {
            sendRequest(this.mPrimaryCallContext.getCall(), false);
        }
        updatePrimaryCallContext(call);
    }

    private void onResume(boolean z10) {
        log("onResume");
        if (!this.mIsInBackground) {
            log("onResume, Ignoring... already resumed");
            return;
        }
        this.mIsInBackground = false;
        if (canVideoPause(this.mPrimaryCallContext) && z10) {
            sendRequest(this.mPrimaryCallContext.getCall(), true);
        } else {
            log("onResume. Ignoring...");
        }
    }

    private void sendRequest(Call call, boolean z10) {
        if (!call.can(OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS)) {
            return;
        }
        if (z10) {
            log("sending resume request, call=" + call);
            call.getVideoCall().sendSessionModifyRequest(CallUtils.makeVideoUnPauseProfile(call));
            return;
        }
        log("sending pause request, call=" + call);
        call.getVideoCall().sendSessionModifyRequest(CallUtils.makeVideoPauseProfile(call));
    }

    private void updatePrimaryCallContext(Call call) {
        if (call == null) {
            this.mPrimaryCallContext = null;
            return;
        }
        CallContext callContext = this.mPrimaryCallContext;
        if (callContext != null) {
            callContext.update(call);
        } else {
            this.mPrimaryCallContext = new CallContext(call);
        }
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        log("onIncomingCall, OldState=" + inCallState + " NewState=" + inCallState2 + " Call=" + call);
        if (areSame(call, this.mPrimaryCallContext)) {
            return;
        }
        onPrimaryCallChanged(call);
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        Call activeCall;
        log("onStateChange, OldState=" + inCallState + " NewState=" + inCallState2);
        if (inCallState2 == InCallPresenter.InCallState.INCOMING) {
            activeCall = callList.getIncomingCall();
        } else if (inCallState2 == InCallPresenter.InCallState.WAITING_FOR_ACCOUNT) {
            activeCall = callList.getWaitingForAccountCall();
        } else if (inCallState2 == InCallPresenter.InCallState.PENDING_OUTGOING) {
            activeCall = callList.getPendingOutgoingCall();
        } else if (inCallState2 == InCallPresenter.InCallState.OUTGOING) {
            activeCall = callList.getOutgoingCall();
        } else {
            activeCall = callList.getActiveCall();
        }
        boolean z10 = !areSame(activeCall, this.mPrimaryCallContext);
        boolean canVideoPause = CallUtils.canVideoPause(activeCall);
        log("onStateChange, hasPrimaryCallChanged=" + z10);
        log("onStateChange, canVideoPause=" + canVideoPause);
        log("onStateChange, IsInBackground=" + this.mIsInBackground);
        if (z10) {
            onPrimaryCallChanged(activeCall);
            return;
        }
        if (isDialing(this.mPrimaryCallContext) && canVideoPause && this.mIsInBackground) {
            bringToForeground();
        } else if (!isVideoCall(this.mPrimaryCallContext) && canVideoPause && this.mIsInBackground) {
            bringToForeground();
        }
        updatePrimaryCallContext(activeCall);
    }

    @Override // com.android.incallui.InCallUiStateNotifierListener
    public void onUiShowing(boolean z10) {
        boolean z11;
        log("onUiShowing, showing = " + z10);
        InCallPresenter inCallPresenter = this.mInCallPresenter;
        if (inCallPresenter == null) {
            return;
        }
        if (inCallPresenter.getInCallState() == InCallPresenter.InCallState.INCALL) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            onResume(z11);
        } else {
            onPause(z11);
        }
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoFail(int i10, Call call) {
        log("onUpgradeToVideoFail status: " + i10 + "call: " + call);
        if (this.mIsInBackground) {
            bringToForeground();
        }
    }

    public void setUp(InCallPresenter inCallPresenter) {
        log("setUp");
        InCallPresenter inCallPresenter2 = (InCallPresenter) com.google.common.base.k.o(inCallPresenter);
        this.mInCallPresenter = inCallPresenter2;
        inCallPresenter2.addListener(this);
        this.mInCallPresenter.addIncomingCallListener(this);
        InCallVideoCallCallbackNotifier.getInstance().addSessionModificationListener(this);
        InCallUiStateNotifier.getInstance().addListener(this);
    }

    public void tearDown() {
        log("tearDown...");
        InCallUiStateNotifier.getInstance().removeListener(this);
        InCallVideoCallCallbackNotifier.getInstance().removeSessionModificationListener(this);
        this.mInCallPresenter.removeListener(this);
        this.mInCallPresenter.removeIncomingCallListener(this);
        clear();
    }

    private static boolean isIncomingCall(Call call) {
        return call != null && isIncoming(call.getState());
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onDowngradeToAudio(Call call) {
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoSuccess(Call call) {
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoRequest(Call call, int i10) {
    }
}
