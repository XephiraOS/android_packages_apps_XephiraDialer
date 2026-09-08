package com.android.incallui;

import android.content.Context;
import android.os.Bundle;
import android.telecom.Call;
import android.telecom.CallAudioState;
import android.telecom.InCallService;
import android.telecom.VideoProfile;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.CallList;
import com.android.incallui.InCallCameraManager;
import com.android.incallui.InCallPresenter;
import com.internal_dependency.InternalSdkDepends;
import j2.C1159a;

/* loaded from: classes.dex */
public class CallButtonPresenter extends Presenter<CallButtonUi> implements InCallPresenter.InCallStateListener, AudioModeProvider.AudioModeListener, InCallPresenter.IncomingCallListener, InCallPresenter.InCallDetailsListener, InCallPresenter.CanAddCallListener, CallList.ActiveSubChangeListener, InCallCameraManager.Listener {
    private static final String KEY_AUTOMATICALLY_MUTED = "incall_key_automatically_muted";
    private static final String KEY_PREVIOUS_MUTE_STATE = "incall_key_previous_mute_state";
    private static final String LOG_TAG = "CallButtonPresenter";
    protected Call mCall;
    protected boolean mAutomaticallyMuted = false;
    protected boolean mPreviousMuteState = false;

    private void updateUi(InCallPresenter.InCallState inCallState, Call call) {
        boolean z10;
        Log.d(this, "Updating call UI for call: ", call);
        CallButtonUi ui = getUi();
        if (ui == null) {
            return;
        }
        if (inCallState.isConnectingOrConnected() && !inCallState.isIncoming() && call != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ui.setEnabled(z10);
    }

    public void addCallClicked() {
        TelecomAdapter.getInstance().addCall();
    }

    public void changeToVideoClicked() {
        Call call = this.mCall;
        if (call == null) {
            return;
        }
        InCallService.VideoCall videoCall = call.getVideoCall();
        if (videoCall == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "changeToVideoClicked: videoCall == null");
            }
            if (!this.mCall.can(1024)) {
                InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoFail(100, this.mCall);
                return;
            }
            return;
        }
        int videoState = this.mCall.getVideoState();
        int unPausedVideoState = CallUtils.getUnPausedVideoState(videoState);
        if (VideoProfile.isAudioOnly(videoState)) {
            if (!this.mCall.can(1024)) {
                InCallVideoCallCallbackNotifier.getInstance().upgradeToVideoFail(100, this.mCall);
                return;
            } else {
                videoCall.sendSessionModifyRequest(new VideoProfile(unPausedVideoState | 3));
                this.mCall.setSessionModificationState(1);
                return;
            }
        }
        if (CallUtils.isVideoCall(videoState)) {
            changeToVoiceClicked();
        }
    }

    public void changeToVoiceClicked() {
        InCallService.VideoCall videoCall;
        Call call = this.mCall;
        if (call == null || (videoCall = call.getVideoCall()) == null || this.mCall.getOplusClickToVoice()) {
            return;
        }
        videoCall.sendSessionModifyRequest(new VideoProfile(0, 4));
        this.mCall.setOplusClickToVoice(true);
    }

    public boolean endCallClicked() {
        return false;
    }

    public void explicitCallTransfer() {
        Call backgroundCall = CallList.getInstance().getBackgroundCall();
        if (backgroundCall != null && backgroundCall.getTelecommCall() != null) {
            A2.l.d().b(InternalSdkDepends.getSInstance().getTelecomCallId(backgroundCall.getTelecommCall()));
        }
    }

    public int getAudioMode() {
        return AudioModeProvider.getInstance().getAudioMode();
    }

    public Call getCurrentCall() {
        return this.mCall;
    }

    public String getPrimaryCallId() {
        return "";
    }

    public int getSupportedAudio() {
        return AudioModeProvider.getInstance().getSupportedModes();
    }

    public boolean holdClicked(boolean z10) {
        Call call = this.mCall;
        if (call == null) {
            return false;
        }
        if (call.getFakeState() != 0) {
            Log.i(LOG_TAG, "holdClicked, it's fake state now");
            return false;
        }
        if (z10) {
            Log.i(LOG_TAG, "Putting the call on hold: " + this.mCall);
            return TelecomAdapter.getInstance().oplusTelecomAdapter().holdCallByUser(this.mCall.getId(), true);
        }
        Log.i(LOG_TAG, "Removing the call from hold: " + this.mCall);
        return TelecomAdapter.getInstance().oplusTelecomAdapter().holdCallByUser(this.mCall.getId(), false);
    }

    public void mergeClicked() {
        TelecomAdapter.getInstance().merge(this.mCall.getId());
        InCallAudioManager.getInstance().onMergeClicked();
    }

    public void muteClicked(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "turning on mute: " + z10);
        }
        TelecomAdapter.getInstance().mute(z10);
    }

    @Override // com.android.incallui.InCallCameraManager.Listener
    public void onActiveCameraSelectionChanged(boolean z10) {
        if (getUi() == null) {
            return;
        }
        getUi().setCameraSwitched(!z10);
    }

    @Override // com.android.incallui.CallList.ActiveSubChangeListener
    public void onActiveSubChanged(int i10) {
        onStateChange(null, InCallPresenter.getInstance().getPotentialStateFromCallList(CallList.getInstance()), CallList.getInstance());
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        onStateChange(inCallState, inCallState2, CallList.getInstance());
    }

    @Override // com.android.incallui.AudioModeProvider.AudioModeListener
    public void onMute(boolean z10) {
        if (getUi() != null && !this.mAutomaticallyMuted) {
            getUi().setMute(z10);
        }
    }

    @Override // com.android.incallui.Presenter
    public void onRestoreInstanceState(Bundle bundle) {
        this.mAutomaticallyMuted = bundle.getBoolean(KEY_AUTOMATICALLY_MUTED, this.mAutomaticallyMuted);
        this.mPreviousMuteState = bundle.getBoolean(KEY_PREVIOUS_MUTE_STATE, this.mPreviousMuteState);
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.android.incallui.Presenter
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(KEY_AUTOMATICALLY_MUTED, this.mAutomaticallyMuted);
        bundle.putBoolean(KEY_PREVIOUS_MUTE_STATE, this.mPreviousMuteState);
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        CallButtonUi ui = getUi();
        InCallPresenter.InCallState inCallState3 = InCallPresenter.InCallState.OUTGOING;
        if (inCallState2 == inCallState3) {
            this.mCall = callList.getOutgoingCall();
        } else if (inCallState2 == InCallPresenter.InCallState.INCALL) {
            Call activeOrBackgroundCall = callList.getActiveOrBackgroundCall();
            this.mCall = activeOrBackgroundCall;
            if (ui != null && inCallState == inCallState3 && activeOrBackgroundCall != null && CallerInfoUtils.isVoiceMailNumber(ui.getContext(), this.mCall)) {
                ui.displayDialpad(true, true);
            }
        } else if (inCallState2 == InCallPresenter.InCallState.INCOMING) {
            if (ui != null) {
                ui.displayDialpad(false, true);
            }
            this.mCall = callList.getIncomingCall();
        } else {
            this.mCall = null;
        }
        updateUi(inCallState2, this.mCall);
    }

    public void pauseVideoClicked(boolean z10) {
        InCallService.VideoCall videoCall = this.mCall.getVideoCall();
        if (videoCall == null) {
            return;
        }
        if (z10) {
            videoCall.setCamera(null);
            videoCall.sendSessionModifyRequest(new VideoProfile(this.mCall.getVideoState() & (-2)));
        } else {
            videoCall.setCamera(InCallPresenter.getInstance().getInCallCameraManager().getActiveCameraId());
            videoCall.sendSessionModifyRequest(new VideoProfile(this.mCall.getVideoState() | 1));
            this.mCall.setSessionModificationState(1);
        }
        getUi().setVideoPaused(z10);
    }

    public void refreshMuteState() {
        if (this.mAutomaticallyMuted && AudioModeProvider.getInstance().getMute() != this.mPreviousMuteState) {
            if (getUi() == null) {
                return;
            } else {
                muteClicked(this.mPreviousMuteState);
            }
        }
        this.mAutomaticallyMuted = false;
    }

    public void setAudioMode(int i10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "Sending new Audio Mode: " + CallAudioState.audioRouteToString(i10));
        }
        TelecomAdapter.getInstance().setAudioRoute(i10);
    }

    public boolean shouldShowSwapButton() {
        return false;
    }

    public void swapClicked() {
        if (this.mCall == null) {
            return;
        }
        Log.i(LOG_TAG, "Swapping the call: " + this.mCall);
        TelecomAdapter.getInstance().swap(this.mCall.getId());
    }

    public void switchCameraClicked(boolean z10) {
        String activeCameraId;
        InCallCameraManager inCallCameraManager = InCallPresenter.getInstance().getInCallCameraManager();
        inCallCameraManager.setUseFrontFacingCamera(z10);
        Call call = this.mCall;
        if (call == null) {
            return;
        }
        if (call.getIsVideoRingTone()) {
            Log.d(this, "switchCameraClicked: it is video ring tone, return");
            return;
        }
        InCallService.VideoCall videoCall = this.mCall.getVideoCall();
        if (videoCall != null && (activeCameraId = inCallCameraManager.getActiveCameraId()) != null) {
            this.mCall.getVideoSettings().setCameraDir(!inCallCameraManager.isUsingFrontFacingCamera() ? 1 : 0);
            if (!this.mCall.getVideoPaused()) {
                videoCall.setCamera(activeCameraId);
                videoCall.requestCameraCapabilities();
            }
        }
    }

    public void toggleSpeakerphone() {
        if ((getSupportedAudio() & 2) != 0) {
            Log.e(LOG_TAG, "toggling speakerphone not allowed when bluetooth supported.");
            return;
        }
        int i10 = 8;
        if (getAudioMode() == 8) {
            i10 = 5;
        }
        setAudioMode(i10);
    }

    @Override // com.android.incallui.Presenter
    public void onUiReady(CallButtonUi callButtonUi) {
        super.onUiReady((CallButtonPresenter) callButtonUi);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onUiready");
        }
        InCallPresenter inCallPresenter = InCallPresenter.getInstance();
        InCallPresenter.InCallState inCallState = inCallPresenter.getInCallState();
        CallList callList = CallList.getInstance();
        if (inCallState == InCallPresenter.InCallState.OUTGOING) {
            this.mCall = callList.getOutgoingCall();
        } else if (inCallState == InCallPresenter.InCallState.INCALL) {
            this.mCall = callList.getActiveOrBackgroundCall();
        } else if (inCallState == InCallPresenter.InCallState.INCOMING) {
            this.mCall = callList.getIncomingCall();
        } else {
            this.mCall = null;
        }
        AudioModeProvider.getInstance().addListener(this);
        inCallPresenter.addListener(this);
        inCallPresenter.addIncomingCallListener(this);
        inCallPresenter.addDetailsListener(this);
        inCallPresenter.addCanAddCallListener(this);
        inCallPresenter.getInCallCameraManager().addCameraSelectionListener(this);
        callList.addActiveSubChangeListener(this);
        onStateChange(InCallPresenter.InCallState.NO_CALLS, inCallState, callList);
    }

    @Override // com.android.incallui.Presenter
    public void onUiUnready(CallButtonUi callButtonUi) {
        super.onUiUnready((CallButtonPresenter) callButtonUi);
        InCallPresenter.getInstance().removeListener(this);
        AudioModeProvider.getInstance().removeListener(this);
        InCallPresenter.getInstance().removeIncomingCallListener(this);
        InCallPresenter.getInstance().removeDetailsListener(this);
        InCallPresenter.getInstance().getInCallCameraManager().removeCameraSelectionListener(this);
        InCallPresenter.getInstance().removeCanAddCallListener(this);
        CallList.getInstance().removeActiveSubChangeListener(this);
    }

    /* loaded from: classes.dex */
    public interface CallButtonUi extends Ui {
        void displayDialpad(boolean z10);

        void displayDialpad(boolean z10, boolean z11);

        void displayManageConferencePanel(boolean z10);

        void enableAddCall(boolean z10);

        void enableButton(int i10, boolean z10);

        void enableChangeToVideo(boolean z10);

        void enableHold(boolean z10);

        void enableMute(boolean z10);

        void enableRecorder(boolean z10);

        void enableSwitchCamera(boolean z10);

        C1159a getButtonController();

        Context getContext();

        void hideButtonsView();

        boolean isDialpadVisible();

        boolean isManageConferencePanelVisible();

        void refreshCallButtonsVisibility();

        void setCameraSwitched(boolean z10);

        void setDialpad(boolean z10);

        void setEnabled(boolean z10);

        void setEndCallButtonPressed(boolean z10);

        void setHold(boolean z10);

        void setIsVideoCall(boolean z10);

        void setMute(boolean z10);

        void setVideoPaused(boolean z10);

        @Override // com.android.incallui.Ui
        void setVisible(boolean z10);

        void showButtonsView(boolean z10);

        void updateRecordButton();

        void updateRecordText();

        default void displayCallControlButton(boolean z10) {
        }
    }

    @Override // com.android.incallui.InCallPresenter.CanAddCallListener
    public void onCanAddCallChanged(boolean z10) {
    }

    @Override // com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
    }
}
