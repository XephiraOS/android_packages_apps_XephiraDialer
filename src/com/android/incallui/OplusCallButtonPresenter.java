package com.android.incallui;

import android.telecom.Call;
import android.telecom.InCallService;
import android.util.Pair;
import com.android.incallui.Call;
import com.android.incallui.CallButtonPresenter;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.android.oplus.brand.BrandCenter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class OplusCallButtonPresenter extends CallButtonPresenter implements CallList.CallUpdateListener, Q5.c {
    private static final String LOG_TAG = "OplusCallButtonPresenter";
    private Pair<String, Integer> mLastUpdateUICache;
    protected InCallPresenter.InCallState mPreviousState = null;
    private Call mPrimaryCall;

    public OplusCallButtonPresenter() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "OplusCallButtonPresenter...");
        }
    }

    private boolean isCallDialing(Call call, InCallPresenter.InCallState inCallState) {
        OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
        if ((oplusCallList == null || !oplusCallList.isCDMADialingCall(call)) && inCallState != InCallPresenter.InCallState.PENDING_OUTGOING && inCallState != InCallPresenter.InCallState.OUTGOING) {
            return false;
        }
        return true;
    }

    private void startRttUi() {
        BrandCenter.a aVar = BrandCenter.f19187a;
        if (aVar.a().d() != null) {
            aVar.a().j(OplusInCallApp.getAppContext());
        }
    }

    @Override // com.android.incallui.CallButtonPresenter
    public void addCallClicked() {
        TelecomAdapter.getInstance().addCall();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean canNotResposeEndClick() {
        /*
            r3 = this;
            com.android.incallui.Call r0 = r3.mCall
            java.lang.String r1 = "OplusCallButtonPresenter"
            if (r0 == 0) goto L4e
            boolean r0 = com.android.incallui.Log.sDebug
            if (r0 == 0) goto L38
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "canNotResposeEndClick, mCall State = "
            r0.append(r2)
            com.android.incallui.Call r2 = r3.mCall
            int r2 = r2.getState()
            r0.append(r2)
            java.lang.String r2 = "  callSize = "
            r0.append(r2)
            com.android.incallui.CallList r2 = com.android.incallui.CallList.getInstance()
            com.android.incallui.OplusCallList r2 = r2.oplusCallList()
            int r2 = r2.oplusGetCallSize()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.android.incallui.Log.d(r1, r0)
        L38:
            com.android.incallui.Call r0 = r3.mCall
            int r0 = r0.getState()
            r2 = 9
            if (r0 == r2) goto L4c
            com.android.incallui.Call r3 = r3.mCall
            int r3 = r3.getState()
            r0 = 10
            if (r3 != r0) goto L4e
        L4c:
            r3 = 1
            goto L4f
        L4e:
            r3 = 0
        L4f:
            boolean r0 = com.android.incallui.Log.sDebug
            if (r0 == 0) goto L67
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "canNotResposeEndClick, bRet = "
            r0.append(r2)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.android.incallui.Log.d(r1, r0)
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusCallButtonPresenter.canNotResposeEndClick():boolean");
    }

    public void changeToRttClicked() {
        Log.i("CallButtonPresenter", "changeToRttClicked");
        Call call = this.mCall;
        if (call == null) {
            Log.i("CallButtonPresenter.changeToRttClicked", "call:null");
        } else if (((OplusCall) call).isRttCall()) {
            startRttUi();
        } else if (OplusPhoneUtils.isRttFeatureOn()) {
            ((OplusCall) this.mCall).sendRttRequest();
        }
    }

    public boolean childCallIsCdmaCall(Call call) {
        if (call != null && call.isConferenceCall()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "call isConferenceCall ");
            }
            if (((OplusCall) call).isIms()) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "call is ims conference call");
                }
                return false;
            }
            List<String> childCallIds = call.getChildCallIds();
            for (int i10 = 0; i10 < childCallIds.size(); i10++) {
                Call callById = CallList.getInstance().getCallById(call.getChildCallIds().get(i10));
                if (callById != null && callById.getIsCdmaPhone()) {
                    if (Log.sDebug) {
                        Log.d(LOG_TAG, "childCall is cdmacall ");
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void conferencePanelHide() {
        Log.d(LOG_TAG, "conferencePanelHide ");
        InCallPresenter.InCallState inCallState = InCallPresenter.getInstance().getInCallState();
        onStateChange(inCallState, inCallState, CallList.getInstance());
    }

    @Override // com.android.incallui.CallButtonPresenter
    public boolean endCallClicked() {
        if (this.mCall == null) {
            if (Log.sDebug) {
                D2.g.f(LOG_TAG, "endCallClicked, mCall is null return ... ");
                return false;
            }
            return false;
        }
        if (Log.sDebug) {
            D2.g.b(LOG_TAG, "endCallClicked, mCall = " + this.mCall);
        }
        TelecomAdapter.getInstance().disconnectCall(this.mCall.getId());
        return true;
    }

    public boolean getCanAddCall(Call call) {
        if (call == null) {
            return false;
        }
        if (!OplusFeatureOption.OPLUS_VERSION_EXP && CallUtils.isVideoCall(call)) {
            return false;
        }
        if ((OplusPhoneUtils.isKDDIConferenceCall(call) && OplusFeatureOption.FEATURE_DISABLE_ADD_CALL_BUTTON) || childCallIsCdmaCall(call)) {
            return false;
        }
        return TelecomAdapter.getInstance().canAddCall();
    }

    public Call getPrimaryCall() {
        return this.mPrimaryCall;
    }

    @Override // com.android.incallui.CallButtonPresenter
    public String getPrimaryCallId() {
        Call call = this.mPrimaryCall;
        if (call != null) {
            return call.getId();
        }
        return "";
    }

    @Override // com.android.incallui.CallButtonPresenter
    public void mergeClicked() {
        if (this.mCall != null) {
            TelecomAdapter.getInstance().merge(this.mCall.getId());
        } else {
            Log.i(LOG_TAG, "mergeClicked call is null!");
        }
    }

    @Override // com.android.incallui.CallButtonPresenter
    public void muteClicked(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "turning on mute: " + z10);
        }
        Call call = this.mCall;
        if (call != null && !Call.State.isConnectingOrDialing(call.getState()) && this.mCall.can(64) && !CallList.getInstance().isCDMADialingCall(this.mCall)) {
            getUi().setMute(z10);
            if (Log.sDebug) {
                Log.d(LOG_TAG, "turning on mute: real click " + z10);
            }
            TelecomAdapter.getInstance().mute(z10);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter, com.android.incallui.InCallPresenter.CanAddCallListener
    public void onCanAddCallChanged(boolean z10) {
        Call call;
        boolean z11;
        CallButtonPresenter.CallButtonUi ui = getUi();
        if (ui != null && (call = this.mCall) != null) {
            boolean can = call.can(4);
            if (getCanAddCall(this.mCall) && !CallList.getInstance().isCDMADialingCall(this.mCall) && CallList.getInstance().oplusCallList().oplusGetOutgoingCall() == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (ui.getButtonController() != null) {
                ui.getButtonController().Q(can, z11);
            }
        }
    }

    @Override // com.android.incallui.CallButtonPresenter, com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onDetailsChanged begin...");
        }
        if (OplusFeatureOption.OPLUSOS_FEATURE_INCALLUI_DISPLAY_VOWIFI_ICON_ACTIVE.value().booleanValue()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "no need to change endButton-Image...");
            }
        } else if (getUi() != null && call != null) {
            getUi().refreshCallButtonsVisibility();
        }
    }

    @Override // com.android.incallui.CallButtonPresenter, com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        getUi().setEndCallButtonPressed(false);
        onStateChange(inCallState, inCallState2, CallList.getInstance());
    }

    @Override // com.android.incallui.CallButtonPresenter, com.android.incallui.AudioModeProvider.AudioModeListener
    public void onMute(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onMute: " + z10);
        }
        OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
        if (getUi() != null) {
            getUi().setMute(z10);
        }
        Call call = this.mCall;
        if (call != null) {
            ((OplusCall) call).setMuted(z10);
            if (this.mCall.isConferenceCall()) {
                oplusCallList.setConferenceMuteFlag(z10);
                setConferenceChildCallMuteFlag(this.mCall, z10);
            }
        }
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onSessionModificationStateChange(Call call, int i10) {
        boolean z10;
        Log.d(this, "onSessionModificationStateChange : sessionModificationState = " + i10 + " call:" + call);
        if (getUi() != null && call != null) {
            boolean z11 = false;
            if (i10 == 1) {
                getUi().enableChangeToVideo(false);
                getUi().enableHold(false);
                return;
            }
            CallButtonPresenter.CallButtonUi ui = getUi();
            if (OplusPhoneUtils.isOplusVideoCallEnableAndImsRegistered(call.getSlotId()) && call.getState() != 8 && !call.isConferenceCall() && !call.isUsedToBeConferenceCall()) {
                z10 = true;
            } else {
                z10 = false;
            }
            ui.enableChangeToVideo(z10);
            CallButtonPresenter.CallButtonUi ui2 = getUi();
            if (call.can(1) && OplusPhoneUtils.shouldEnableHoldButton(call) && !OplusPhoneUtils.sIsInEmergencyCall) {
                z11 = true;
            }
            ui2.enableHold(z11);
        }
    }

    @Override // com.android.incallui.CallButtonPresenter, com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        InCallActivity inCallActivity;
        Call call;
        boolean z10;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onStateChange oldState = " + inCallState + "  newState = " + inCallState2);
        }
        if (getUi() != null && getUi().isManageConferencePanelVisible()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "onStateChange ConferenceCall is display do not show opluscallbutton UI!");
                return;
            }
            return;
        }
        if (!callList.oplusCallList().allConferenceChildCallDisconnected()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "onStateChange ConferenceCall not hangup all return...");
                return;
            }
            return;
        }
        if (getUi() == null) {
            return;
        }
        InCallPresenter.InCallState inCallState3 = InCallPresenter.InCallState.NO_CALLS;
        if (inCallState2 == inCallState3) {
            getUi().setEndCallButtonPressed(false);
            getUi().displayDialpad(false);
            getUi().setVideoPaused(false);
        }
        OplusCallList oplusCallList = (OplusCallList) callList;
        InCallPresenter.InCallState inCallState4 = InCallPresenter.InCallState.INCALL;
        if (inCallState2 == inCallState4) {
            if (!oplusCallList.hasCDMADialingCall() && oplusCallList.oplusGetIncomingCall() != null) {
                getUi().hideButtonsView();
                return;
            }
            Call activeOrBackgroundCall = callList.getActiveOrBackgroundCall();
            this.mCall = activeOrBackgroundCall;
            if (activeOrBackgroundCall != null) {
                getUi().setIsVideoCall(CallUtils.isVideoCall(this.mCall));
                if (!CallUtils.isVideoCall(this.mCall)) {
                    getUi().refreshCallButtonsVisibility();
                }
                if (this.mCall.isActive()) {
                    muteClicked(((OplusCall) this.mCall).getMuted());
                }
            }
        } else {
            InCallPresenter.InCallState inCallState5 = InCallPresenter.InCallState.OUTGOING;
            if (inCallState2 == inCallState5 || inCallState2 == InCallPresenter.InCallState.PENDING_OUTGOING) {
                if (inCallState2 == InCallPresenter.InCallState.PENDING_OUTGOING) {
                    this.mCall = callList.getPendingOutgoingCall();
                } else {
                    this.mCall = callList.getOutgoingCall();
                }
                if (this.mCall != null) {
                    if (Log.sDebug) {
                        Log.d(LOG_TAG, "OUTGOING mCallId = " + this.mCall.getId());
                    }
                    getUi().setIsVideoCall(CallUtils.isBidirectionalVideoCall(this.mCall));
                    TelecomAdapter.getInstance().mute(false);
                    if (this.mCall.needTurnOnSpeaker()) {
                        AudioModeProvider.getInstance().autoTurnOnSpeaker(this.mCall, true);
                    } else if (inCallState2 == inCallState5 && inCallState != inCallState5 && OplusPhoneUtils.PRODUCT_FLAVOR == 1 && getAudioMode() == D2.a.f421b && (inCallActivity = InCallPresenter.getInstance().mInCallActivity) != null) {
                        ((OplusInCallViewModel) new androidx.lifecycle.K(inCallActivity).a(OplusInCallViewModel.class)).l().o(Boolean.TRUE);
                    }
                }
            }
        }
        parentOnStateChange(inCallState, inCallState2, callList);
        Call call2 = this.mCall;
        if (call2 != null && call2.getState() == 3 && !OplusPhoneUtils.sIsInEmergencyCall) {
            getUi().enableButton(4, true);
        } else {
            getUi().enableButton(4, false);
        }
        if (inCallState2 != inCallState3 && this.mCall != null) {
            CallButtonPresenter.CallButtonUi ui = getUi();
            if (inCallState == InCallPresenter.InCallState.INCOMING && oplusCallList.oplusGetCallSize() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            ui.showButtonsView(z10);
            if (InCallPresenter.getInstance().getAnswerPresenter() != null) {
                InCallPresenter.getInstance().getAnswerPresenter().showAnswerUi(false);
            }
        } else {
            if (inCallState2 != InCallPresenter.InCallState.WAITING_FOR_ACCOUNT) {
                getUi().hideButtonsView();
            }
            if (inCallState2 == inCallState3) {
                OplusPhoneUtils.showNumberMarkView();
            }
        }
        Call call3 = this.mCall;
        if (call3 != null && call3.isConferenceCall() && !this.mCall.getIsCdmaPhone()) {
            if (oplusCallList.getConferenceMuteFlag()) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "onStateChange Conference set mute true");
                }
                muteClicked(true);
            } else {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "onStateChange Conference set mute false");
                }
                setConferenceChildCallMuteFlag(this.mCall, false);
            }
        }
        if (inCallState2 == InCallPresenter.InCallState.INCOMING) {
            call = callList.getIncomingCall();
        } else if (inCallState2 == InCallPresenter.InCallState.OUTGOING) {
            call = callList.getOutgoingCall();
        } else if (inCallState2 == InCallPresenter.InCallState.PENDING_OUTGOING) {
            call = callList.getPendingOutgoingCall();
        } else if (inCallState2 == inCallState4) {
            call = callList.getActiveOrBackgroundCall();
        } else {
            call = null;
        }
        this.mPrimaryCall = call;
        if (call != null) {
            CallList.getInstance().addCallUpdateListener(this.mPrimaryCall.getId(), this);
        }
        if (getUi().getButtonController() != null) {
            getUi().getButtonController().p();
        }
    }

    public void parentOnStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onStateChange father > oldState = " + inCallState + "  newState = " + inCallState2);
        }
        Call call = null;
        if (inCallState2 == InCallPresenter.InCallState.PENDING_OUTGOING) {
            if (callList != null) {
                call = callList.getPendingOutgoingCall();
            }
            this.mCall = call;
        } else if (inCallState2 == InCallPresenter.InCallState.OUTGOING) {
            if (callList != null) {
                call = callList.getOutgoingCall();
            }
            this.mCall = call;
        } else if (inCallState2 == InCallPresenter.InCallState.INCALL) {
            if (callList != null) {
                call = callList.getActiveOrBackgroundCall();
            }
            this.mCall = call;
            if (this.mPreviousState == InCallPresenter.InCallState.INCOMING && callList != null && callList.oplusCallList().oplusGetCallSize() == 1 && (callList.getDisconnectingCall() != null || callList.getDisconnectedCall() != null)) {
                return;
            }
        } else if (inCallState2 == InCallPresenter.InCallState.INCOMING) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "INCOMING Call");
            }
            OplusInCallPresenter oplusInCallPresenter = (OplusInCallPresenter) InCallPresenter.getInstance();
            if (oplusInCallPresenter != null && oplusInCallPresenter.getActivity() != null && oplusInCallPresenter.getActivity().getInCallFragmentManager().isDialpadVisible()) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "mDialpadFragment setVisible(false)");
                }
                oplusInCallPresenter.getActivity().getInCallFragmentManager().g(false);
            }
            this.mCall = null;
        } else {
            this.mCall = null;
        }
        updateUi(inCallState2, this.mCall);
        this.mPreviousState = inCallState2;
    }

    @Override // com.android.incallui.CallButtonPresenter
    public void pauseVideoClicked(boolean z10) {
        Call call = this.mCall;
        if (call == null) {
            Log.w(this, "pauseVideoClicked: mCall is null.");
            return;
        }
        InCallService.VideoCall videoCall = call.getVideoCall();
        VideoCallPresenter videoCallPresenter = InCallPresenter.getInstance().getVideoCallPresenter();
        if (videoCall != null && videoCallPresenter != null) {
            this.mCall.setVideoPaused(z10);
            T5.a d10 = BrandCenter.f19187a.a().d();
            if (d10 != null) {
                d10.C(this.mCall, videoCall, z10);
            }
            if (!z10 && this.mCall.isConferenceCall()) {
                OplusPhoneUtils.setVideoPausedForConf(false);
            }
            videoCallPresenter.enableCamera(videoCall, !z10);
            getUi().setVideoPaused(z10);
            return;
        }
        Log.w(this, "pauseVideoClicked: videoCall or videoCallPresenter is null.");
    }

    @Override // com.android.incallui.CallButtonPresenter
    public void setAudioMode(int i10) {
        super.setAudioMode(i10);
    }

    public void setConferenceChildCallMuteFlag(Call call, boolean z10) {
        if (call == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "setConferenceChildCallMuteFlag: conferenceCall is null return  ");
                return;
            }
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setConferenceChildCallMuteFlag: isMute = " + z10);
        }
        Iterator<String> it = call.getChildCallIds().iterator();
        while (it.hasNext()) {
            Call callById = CallList.getInstance().getCallById(it.next());
            if (callById != null) {
                ((OplusCall) callById).setMuted(z10);
            }
        }
    }

    @Override // com.android.incallui.CallButtonPresenter
    public boolean shouldShowSwapButton() {
        return !InCallPresenter.getInstance().realInstance().isShowSingleCallView();
    }

    @Override // com.android.incallui.CallButtonPresenter
    public void swapClicked() {
        Call call = this.mCall;
        if (call == null) {
            return;
        }
        if (call.isConferenceCall() && CallList.getInstance().oplusCallList().isCdmaPhoneActive()) {
            CallList.getInstance().oplusCallList().swapCdmaCall();
            return;
        }
        if (this.mCall.getState() != 3) {
            InCallPresenter.getInstance().realInstance().showErrorMessageForPendingCallAction(OplusInCallPresenter.SuppService.SWITCH);
            return;
        }
        Call backgroundCall = CallList.getInstance().getBackgroundCall();
        if (backgroundCall != null && backgroundCall.getState() == 8) {
            Log.i(LOG_TAG, "Swapping the call: " + backgroundCall);
            TelecomAdapter.getInstance().unholdCall(backgroundCall.getId());
            return;
        }
        InCallPresenter.getInstance().realInstance().showErrorMessageForPendingCallAction(OplusInCallPresenter.SuppService.SWITCH);
    }

    @Override // Q5.c
    public void updateAudioRecordButton() {
        if (getUi() != null) {
            getUi().updateRecordButton();
        } else {
            Log.d(LOG_TAG, "updateAudioRecordButton is null");
        }
    }

    public void updateUi(InCallPresenter.InCallState inCallState, Call call) {
        CallButtonPresenter.CallButtonUi ui;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20 = false;
        if (call == null) {
            call = ((OplusCallList) CallList.getInstance()).oplusGetCallByPriority(null, null, false);
        }
        if (call == null || (ui = getUi()) == null) {
            return;
        }
        if (inCallState == InCallPresenter.InCallState.NO_CALLS) {
            ui.setEnabled(false);
            return;
        }
        if (inCallState.isConnectingOrConnected() && !inCallState.isIncoming()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "state >>" + inCallState + "   isEnabled >> " + z10);
        }
        ui.setVisible(!inCallState.isIncoming());
        getUi().refreshCallButtonsVisibility();
        ui.setEnabled(z10);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "Updating call UI for call: ", call);
        }
        if (z10) {
            if (getCanAddCall(call) && !CallList.getInstance().isCDMADialingCall(call) && CallList.getInstance().oplusCallList().oplusGetOutgoingCall() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean can = call.can(4);
            if (Log.sDebug) {
                Log.d(LOG_TAG, "canAdd= " + z16 + ",showMergeOption=" + can);
            }
            if (!can) {
                ui.enableAddCall(z16);
            }
            if (call.can(1) && call.getSessionModificationState() != 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            Log.d(LOG_TAG, "canHold= " + z17 + ",canSwap=" + call.can(8) + ",supportHold=" + call.can(2));
            if (!OplusPhoneUtils.sIsInEmergencyCall && z17 && OplusPhoneUtils.shouldEnableHoldButton(call)) {
                z18 = true;
            } else {
                z18 = false;
            }
            ui.enableHold(z18);
            String id = call.getId();
            int state = call.getState();
            Pair<String, Integer> pair = this.mLastUpdateUICache;
            if (pair == null || !((String) pair.first).equals(id) || ((Integer) this.mLastUpdateUICache.second).intValue() != state) {
                if (state == 8) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                ui.setHold(z19);
            }
            this.mLastUpdateUICache = new Pair<>(id, Integer.valueOf(state));
        }
        boolean isDialpadVisible = getUi().isDialpadVisible();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "dialpadVisible =" + isDialpadVisible);
        }
        getUi().setDialpad(isDialpadVisible);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateUi  canRecord=true");
        }
        getUi().enableRecorder(true);
        boolean isCallDialing = isCallDialing(call, inCallState);
        CallButtonPresenter.CallButtonUi ui2 = getUi();
        if (!isCallDialing && OplusPhoneUtils.isOplusVideoCallEnableAndImsRegistered(call.getSlotId()) && call.getState() != 8 && !call.isConferenceCall() && !call.isUsedToBeConferenceCall() && call.getSessionModificationState() != 1 && call.isActive() && !call.getIsRemotelyHeld()) {
            z11 = true;
        } else {
            z11 = false;
        }
        ui2.enableChangeToVideo(z11);
        CallButtonPresenter.CallButtonUi ui3 = getUi();
        if (!isCallDialing && !call.isConferenceCall() && call.getState() != 8 && !call.isUsedToBeConferenceCall()) {
            z12 = true;
        } else {
            z12 = false;
        }
        ui3.enableButton(11, z12);
        if (R5.a.b()) {
            if (!isCallDialing && call.getState() != 8) {
                z15 = true;
            } else {
                z15 = false;
            }
            getUi().enableButton(11, BrandCenter.f19187a.a().g(z15));
        }
        getUi().enableButton(5, !isCallDialing);
        getUi().setVideoPaused(call.getVideoPaused());
        if (R5.a.b()) {
            CallButtonPresenter.CallButtonUi ui4 = getUi();
            if (!call.getVideoPaused() && !QtiCallUtils.isVideoRxOnly(call)) {
                z14 = false;
            } else {
                z14 = true;
            }
            ui4.setVideoPaused(z14);
        }
        if (!Call.State.isConnectingOrDialing(call.getState()) && call.can(64) && !CallList.getInstance().isCDMADialingCall(call)) {
            z13 = true;
        } else {
            z13 = false;
        }
        getUi().enableMute(z13);
        if (z13) {
            getUi().setMute(AudioModeProvider.getInstance().getMute());
        }
        getUi().updateRecordButton();
        if (Log.sDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("state == InCallState.INCALL");
            if (inCallState == InCallPresenter.InCallState.INCALL) {
                z20 = true;
            }
            sb.append(z20);
            sb.append("  call=");
            sb.append(call);
            Log.d(LOG_TAG, sb.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.CallButtonPresenter, com.android.incallui.Presenter
    public void onUiReady(CallButtonPresenter.CallButtonUi callButtonUi) {
        super.onUiReady(callButtonUi);
        Q5.b a10 = Q5.a.a();
        if (a10 != null) {
            a10.e(this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.CallButtonPresenter, com.android.incallui.Presenter
    public void onUiUnready(CallButtonPresenter.CallButtonUi callButtonUi) {
        super.onUiUnready(callButtonUi);
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
