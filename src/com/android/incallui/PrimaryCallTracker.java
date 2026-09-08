package com.android.incallui;

import com.android.incallui.InCallPresenter;
import java.util.Objects;

/* loaded from: classes.dex */
public class PrimaryCallTracker implements InCallPresenter.InCallStateListener, InCallPresenter.IncomingCallListener {
    private static PrimaryCallTracker mInstance = new PrimaryCallTracker();
    private Call mPrimaryCall;

    public static PrimaryCallTracker getInstance() {
        return mInstance;
    }

    public Call getPrimaryCall() {
        return this.mPrimaryCall;
    }

    public boolean isPrimaryCall(Call call) {
        return Objects.equals(this.mPrimaryCall, call);
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        onStateChange(inCallState, InCallPresenter.InCallState.INCOMING, CallList.getInstance());
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        Call call;
        Log.d(this, "onStateChange: oldState" + inCallState + " newState=" + inCallState2 + "callList =" + callList);
        if (inCallState2 == InCallPresenter.InCallState.INCOMING) {
            call = callList.getIncomingCall();
        } else if (inCallState2 == InCallPresenter.InCallState.OUTGOING) {
            call = callList.getOutgoingCall();
        } else if (inCallState2 == InCallPresenter.InCallState.PENDING_OUTGOING) {
            call = callList.getPendingOutgoingCall();
        } else if (inCallState2 == InCallPresenter.InCallState.INCALL) {
            call = callList.getActiveOrBackgroundCall();
        } else {
            call = null;
        }
        if (!Objects.equals(this.mPrimaryCall, call)) {
            this.mPrimaryCall = call;
        }
    }
}
