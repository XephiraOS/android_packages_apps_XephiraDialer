package com.android.incallui;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.telecom.DisconnectCause;
import android.telecom.InCallService;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.incallui.Call;
import com.android.oplus.module.castScreen.CastScreen;
import com.internal_dependency.InternalSdkDepends;
import java.util.HashMap;
import t2.C1581a;

/* loaded from: classes.dex */
public class OplusTelecomAdapter extends TelecomAdapter {
    private static final int DELAY_PROCESS_CALL_STATE_CHANGE_TIME = 300;
    private static final String LOG_TAG = "OplusTelecomAdapter";
    public static final int MAX_CONFERENCE_CHILD = 6;
    private static final int MSG_DELAY_PROCESS_CALL_STATE_CHANGE = 101;
    private static final int MSG_RECOVERY_FAKE_GUARD = 102;
    private static final int MSG_RECOVERY_INCOMING_STATE = 100;
    private static final int MSG_RECOVERY_INCOMING_STATE_DELAY_TIME = 4500;
    Handler mHandler = new Handler() { // from class: com.android.incallui.OplusTelecomAdapter.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str = (String) message.obj;
            OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
            Call callById = oplusCallList.getCallById(str);
            boolean z10 = false;
            switch (message.what) {
                case 100:
                    if (Log.sDebug) {
                        Log.d(OplusTelecomAdapter.LOG_TAG, "MSG_RECOVERY_INCOMING_STATE");
                    }
                    if (callById != null && callById.getIsFakeGuard()) {
                        callById.setIsFakeGuard(false);
                    }
                    Call oplusGetBackgroundCall = oplusCallList.oplusGetBackgroundCall();
                    if (callById != null && callById.getFakeState() != 0 && callById.getTelecommCall() != null && A2.l.d().r(callById.getTelecommCallId())) {
                        if (Log.sDebug) {
                            Log.d(OplusTelecomAdapter.LOG_TAG, "MSG_RECOVERY_INCOMING_STATE ret = " + str);
                        }
                        oplusCallList.resetAllFakeState();
                        if (oplusGetBackgroundCall != null) {
                            int realCallStateFromTelecommCall = oplusGetBackgroundCall.getRealCallStateFromTelecommCall();
                            if (realCallStateFromTelecommCall != 0) {
                                oplusGetBackgroundCall.setState(realCallStateFromTelecommCall);
                            } else {
                                oplusGetBackgroundCall.setState(3);
                            }
                            oplusGetBackgroundCall.setFakeState(0);
                            callById.setState(5);
                            z10 = true;
                        } else {
                            callById.setState(4);
                        }
                        callById.setIsAnswerFail(true);
                        oplusCallList.onIncoming(callById, CallList.getInstance().getTextResponses(str));
                        HashMap hashMap = new HashMap();
                        hashMap.put("IS_CALL_WAITING", String.valueOf(z10));
                        OplusPhoneUserActionStatistics.onCommon(InCallPresenter.getInstance().getContext(), OplusPhoneUserActionStatistics.TAG_TECHNOLOGY_STATISTIC, OplusPhoneUserActionStatistics.ANSWER_CALL_FAIL, hashMap);
                        return;
                    }
                    if (callById != null && callById.getFakeState() != 0) {
                        oplusCallList.resetAllFakeState();
                        return;
                    }
                    return;
                case 101:
                    String str2 = (String) message.obj;
                    if (Log.sDebug) {
                        Log.d(OplusTelecomAdapter.LOG_TAG, "MSG_DELAY_PROCESS_CALL_STATE_CHANGE + callId = " + str2);
                    }
                    if (str2 != null) {
                        OplusTelecomAdapter.this.processCallStateChange(str2);
                        return;
                    }
                    return;
                case 102:
                    if (callById != null && callById.getIsFakeGuard()) {
                        callById.setIsFakeGuard(false);
                        oplusCallList.onUpdate(callById);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private PendingCallAction mPendingCallAction;

    /* loaded from: classes.dex */
    public static class FakeState {
        public static final int FAKE_ANSWER = 1;
        public static final int FAKE_HOLD = 3;
        public static final int FAKE_REJECT = 2;
        public static final int NOT_FAKE = 0;

        public static int convertToCallState(int i10) {
            if (i10 == 1) {
                return 3;
            }
            if (i10 == 2) {
                return 9;
            }
            if (i10 == 3) {
                return 8;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public class PendingCallAction {
        public static final int ANSWER = 1;
        public static final int CONFERENCE = 3;
        public static final int INVALID = 0;
        public static final int UNHOLD = 2;
        private int mAction;
        private String mCallId;
        private boolean mHasPengingAction;

        public PendingCallAction() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clean() {
            if (Log.sDebug) {
                Log.d(OplusTelecomAdapter.LOG_TAG, "PendingCallAction clean()...");
            }
            this.mHasPengingAction = false;
            this.mCallId = null;
            this.mAction = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleActionProcessSuccessful(String str) {
            if (Log.sDebug) {
                Log.d(OplusTelecomAdapter.LOG_TAG, "handleActionProcessSuccessful  callId = " + str + "  mCallId =  " + this.mCallId);
            }
            if (str != null && str.equals(this.mCallId)) {
                clean();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleParentChanged(int i10) {
            if (Log.sDebug) {
                Log.d(OplusTelecomAdapter.LOG_TAG, "handleParentChanged, action = ", Integer.valueOf(i10));
            }
            if (i10 == this.mAction) {
                clean();
            }
        }

        public boolean contain(String str) {
            boolean z10;
            String str2 = this.mCallId;
            if (str2 != null && str2.equals(str)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (Log.sDebug) {
                Log.d(OplusTelecomAdapter.LOG_TAG, "contain callId = " + str + "  is " + z10);
            }
            return z10;
        }

        public boolean hasPengingAction() {
            if (Log.sDebug) {
                Log.d(OplusTelecomAdapter.LOG_TAG, "hasPengingAction mCallId = " + this.mCallId + " mHasPengingAction = " + this.mHasPengingAction);
            }
            return this.mHasPengingAction;
        }

        public void setPendingCallAction(String str, int i10) {
            if (Log.sDebug) {
                Log.d(OplusTelecomAdapter.LOG_TAG, "setPendingCallAction  callId= " + str + "  action = " + i10);
            }
            this.mCallId = str;
            this.mAction = i10;
            this.mHasPengingAction = true;
        }

        public String toString() {
            String str;
            int i10 = this.mAction;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            str = "UNKNOWN";
                        } else {
                            str = "CONFERENCE";
                        }
                    } else {
                        str = "UNHOLD";
                    }
                } else {
                    str = "ANSWER";
                }
            } else {
                str = "INVALID";
            }
            return "PendingCallAction callId = " + this.mCallId + "  action = " + str;
        }
    }

    private void fakeAnswerCall(String str, int i10) {
        OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
        Call callById = oplusCallList.getCallById(str);
        if (Log.sDebug) {
            D2.g.a(LOG_TAG, "fakeAnswerCall  callId = " + str);
        }
        Context context = InCallPresenter.getInstance().getContext();
        if (callById != null && Call.State.isRing(callById.getState())) {
            if (context != null) {
                C1581a floatingWindowController = InCallPresenter.getInstance().getFloatingWindowController();
                if (CallUtils.isBidirectionalVideoCall(i10) || OplusPhoneUtils.isMotorCameraUp(context)) {
                    if (floatingWindowController != null && floatingWindowController.G()) {
                        floatingWindowController.M();
                    } else if (InCallPresenter.getInstance() != null && !InCallPresenter.getInstance().isActivityForeground()) {
                        L1.c.h(OplusInCallApp.getInCallAppInstance(), InCallPresenter.getInstance().getInCallIntent(false, false));
                    }
                }
                Intent intent = new Intent("oplus.intent.action.INCALLUI_ANSWER");
                intent.putExtra("isVideo", CallUtils.isBidirectionalVideoCall(i10));
                InternalSdkDepends.getSInstance().sendBroadcastAsAllUser(context, intent, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
            }
            Call activeCall = oplusCallList.getActiveCall();
            if (activeCall != null && oplusCallList.isCdmaPhoneInactive()) {
                activeCall.setState(8);
                activeCall.setFakeState(3);
            }
            if (callById.getVideoState() == 0) {
                i10 = 0;
            }
            callById.setState(3);
            callById.setFakeState(1);
            callById.setFakeAnswerVideoState(i10);
            callById.setIsFakeGuard(true);
            oplusCallList.onUpdate(callById);
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = callById.getId();
            this.mHandler.sendMessageDelayed(obtain, 4500L);
        }
    }

    private void fakeRejectCall(String str) {
        OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
        Call callById = oplusCallList.getCallById(str);
        int oplusGetCallSize = oplusCallList.oplusGetCallSize();
        if (callById != null && Call.State.isRing(callById.getState())) {
            if (Log.sDebug) {
                D2.g.c(LOG_TAG, "fakeRejectCall  callId = " + callById.getId());
            }
            if (oplusGetCallSize == 1) {
                InCallPresenter.getInstance().realInstance().quickHideInCallActivity();
                callById.setState(10);
            } else {
                callById.setState(9);
                callById.setFakeState(2);
            }
            oplusCallList.onUpdate(callById);
        }
    }

    public void addPendingCallAction(String str, int i10) {
        if (this.mPendingCallAction == null) {
            this.mPendingCallAction = new PendingCallAction();
        }
        this.mPendingCallAction.setPendingCallAction(str, i10);
    }

    @Override // com.android.incallui.TelecomAdapter
    public void answerCall(String str, int i10) {
        if (this.mInCallService == null) {
            Log.e(LOG_TAG, "error answerCall, mInCallService is null...");
        } else {
            fakeAnswerCall(str, i10);
            super.answerCall(str, i10);
        }
    }

    public void answerFromNonUi(String str, int i10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "answerFromNonUi telecomCallId = " + str);
        }
        Call incomingCall = CallList.getInstance().getIncomingCall();
        if (incomingCall != null && !TextUtils.isEmpty(incomingCall.getId())) {
            fakeAnswerCall(incomingCall.getId(), i10);
            if (i10 == 0) {
                incomingCall.setOplusClickToVoice(true);
            }
        }
    }

    @Override // com.android.incallui.TelecomAdapter
    public boolean canAddCall() {
        InCallService inCallService = this.mInCallService;
        if (inCallService == null) {
            return false;
        }
        return inCallService.canAddCall();
    }

    public void clearPendingCallAction() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "clearPendingCallAction");
        }
        PendingCallAction pendingCallAction = this.mPendingCallAction;
        if (pendingCallAction != null && pendingCallAction.hasPengingAction()) {
            this.mPendingCallAction.clean();
        }
    }

    public void dealWithParentChanged() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "dealWithParentChanged ");
        }
        PendingCallAction pendingCallAction = this.mPendingCallAction;
        if (pendingCallAction != null && pendingCallAction.hasPengingAction()) {
            this.mPendingCallAction.handleParentChanged(3);
        }
    }

    public void dealWithSuppServiceFailed() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "dealWithSuppServiceFailed");
        }
        clearPendingCallAction();
    }

    @Override // com.android.incallui.TelecomAdapter
    public void disconnectCall(String str) {
        OplusCallList oplusCallList = CallList.getInstance().oplusCallList();
        if (Log.sDebug) {
            D2.g.b(LOG_TAG, "disconnectCall call id = " + str);
        }
        if (this.mInCallService != null && oplusCallList != null) {
            if (getTelecommCallById(str) == null) {
                Call firstCallExceptRingAndDisconnect = oplusCallList.getFirstCallExceptRingAndDisconnect();
                if (firstCallExceptRingAndDisconnect != null && firstCallExceptRingAndDisconnect.getTelecommCall() != null) {
                    if (Log.sDebug) {
                        D2.g.b(LOG_TAG, "getTelecommCallById is null , but can find need hangup call ...");
                    }
                    if (oplusCallList.oplusGetCallSize() == 1) {
                        firstCallExceptRingAndDisconnect.setState(10);
                        firstCallExceptRingAndDisconnect.setDisconnectCause(new DisconnectCause(2));
                    } else {
                        firstCallExceptRingAndDisconnect.setState(9);
                    }
                    firstCallExceptRingAndDisconnect.getTelecommCall().disconnect();
                    oplusCallList.onDisconnect(firstCallExceptRingAndDisconnect);
                    return;
                }
                D2.g.f(LOG_TAG, "error disconnectCall, disconnectCall is null");
                return;
            }
            Call callById = oplusCallList.getCallById(str);
            if (callById != null && callById.isDisconnectGuard() && oplusCallList.oplusGetCallSize() > 1) {
                callById.setState(9);
                Call activeCall = CallList.getInstance().getActiveCall();
                if (activeCall != null) {
                    activeCall.setState(8);
                    activeCall.setFakeState(3);
                }
                if (Log.sDebug) {
                    D2.g.b(LOG_TAG, "disconnectGuard do not invoked...");
                }
                oplusCallList.onUpdate(callById);
                return;
            }
            if (callById != null) {
                if (!callById.isConferenceCall() && callById.getParentId() == null) {
                    if (oplusCallList.oplusGetCallSize() == 1) {
                        callById.setState(10);
                        callById.setDisconnectCause(new DisconnectCause(2));
                    } else {
                        callById.setState(9);
                    }
                    if (Log.sDebug) {
                        D2.g.b(LOG_TAG, "disconnectCall invoked...");
                    }
                    getTelecommCallById(str).disconnect();
                    oplusCallList.onDisconnect(callById);
                    return;
                }
                if (Log.sDebug) {
                    D2.g.b(LOG_TAG, "conferenceCall set disconnecting ...");
                }
                oplusCallList.setConferenceChildCallDisconnecting(callById);
                if (oplusCallList.getBackgroundCall() == null) {
                    OplusPhoneUtils.setIsHangUpConfernceCall(true);
                    callById.setState(10);
                    callById.setDisconnectCause(new DisconnectCause(2));
                } else {
                    callById.setState(9);
                }
                getTelecommCallById(str).disconnect();
                return;
            }
            return;
        }
        Log.e(LOG_TAG, "error disconnectCall, mInCallService is null");
    }

    public String getTelecommCallId(String str) {
        String telecommCallId;
        Call callById = CallList.getInstance().getCallById(str);
        if (callById == null) {
            telecommCallId = null;
        } else {
            telecommCallId = callById.getTelecommCallId();
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getTelecommCallId call id = " + telecommCallId);
        }
        return telecommCallId;
    }

    public boolean hasMergedPendingCallAction() {
        PendingCallAction pendingCallAction = this.mPendingCallAction;
        if (pendingCallAction != null && pendingCallAction.mAction == 3) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "hasMergedPendingCallAction true");
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean holdCallByUser(String str, boolean z10) {
        PendingCallAction pendingCallAction = this.mPendingCallAction;
        if (pendingCallAction != null && pendingCallAction.hasPengingAction()) {
            Log.i(LOG_TAG, "hasPengingAction can not unholdCall by user: " + this.mPendingCallAction);
            return false;
        }
        if (this.mInCallService != null) {
            String telecommCallId = getTelecommCallId(str);
            if (telecommCallId != null) {
                A2.l.d().j(telecommCallId, z10);
                addPendingCallAction(str, 2);
                return true;
            }
        } else {
            Log.e(this, "error unholdCall by user, mInCallService is null");
        }
        return false;
    }

    @Override // com.android.incallui.TelecomAdapter
    public void merge(String str) {
        if (this.mInCallService == null) {
            Log.e(LOG_TAG, "error merge, mInCallService is null...");
            return;
        }
        Context context = InCallPresenter.getInstance().getContext();
        if (context == null) {
            Log.e(LOG_TAG, "context is null...");
            return;
        }
        if (OplusPhoneUtils.getImsConferenceSize() >= 6) {
            Toast.makeText(context, context.getString(R.string.oplus_toast_volte_conf_member_reach_max), 0).show();
            return;
        }
        PendingCallAction pendingCallAction = this.mPendingCallAction;
        if (pendingCallAction != null && pendingCallAction.hasPengingAction()) {
            Log.i(LOG_TAG, "hasPengingAction  can not merge  " + this.mPendingCallAction);
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "merge callId = " + str);
        }
        OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
        oplusCallList.setConferenceMuteFlag();
        oplusCallList.setVideoPausedForConference();
        super.merge(str);
        if (this.mInCallService != null && oplusCallList.isCdmaPhoneInactive()) {
            addPendingCallAction(str, 3);
        }
    }

    public void processCallStateChange(String str) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "processCallStateChange + callId = " + str);
        }
        PendingCallAction pendingCallAction = this.mPendingCallAction;
        if (pendingCallAction != null && pendingCallAction.hasPengingAction()) {
            this.mPendingCallAction.handleActionProcessSuccessful(str);
        }
    }

    public void processCallStateChangeDelay(String str) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "processCallStateChangeDelay + callId = " + str);
        }
        PendingCallAction pendingCallAction = this.mPendingCallAction;
        if (pendingCallAction != null && pendingCallAction.hasPengingAction()) {
            if (this.mHandler == null) {
                processCallStateChange(str);
                return;
            }
            if (!this.mPendingCallAction.contain(str) || this.mHandler.hasMessages(101)) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 101;
            obtain.obj = str;
            this.mHandler.sendMessageDelayed(obtain, 300L);
        }
    }

    @Override // com.android.incallui.TelecomAdapter
    public void rejectCall(String str, boolean z10, String str2) {
        if (this.mInCallService == null) {
            Log.e(LOG_TAG, "error rejectCall, mInCallService is null...");
            return;
        }
        if (InCallPresenter.getInstance().realInstance().hasAnswerFromNonUiMsg()) {
            Log.i(LOG_TAG, "hasAnswerFromNonUiMsg  can not reject  ");
            return;
        }
        Call callById = CallList.getInstance().getCallById(str);
        if (callById != null && callById.getFakeState() != 0) {
            Log.i(LOG_TAG, "has fake state  can not reject  ");
        } else {
            super.rejectCall(str, z10, str2);
            fakeRejectCall(str);
        }
    }

    @Override // com.android.incallui.TelecomAdapter
    public void setAudioRoute(int i10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setAudioRoute route = " + i10);
        }
        CastScreen.a aVar = CastScreen.f19196a;
        if (aVar.a().k0()) {
            AudioModeProvider.getInstance().setCurrentAudioState(i10);
            if (i10 != 64 && i10 != 128) {
                if (this.mInCallService != null && CallList.getInstance().getIncomingCall() == null) {
                    this.mInCallService.setAudioRoute(i10);
                    aVar.a().a(0);
                    return;
                }
                return;
            }
            aVar.a().a(i10);
            return;
        }
        if (this.mInCallService != null && CallList.getInstance().getIncomingCall() == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "setAudioRoute route = " + i10);
            }
            this.mInCallService.setAudioRoute(i10);
        }
    }

    @Override // com.android.incallui.TelecomAdapter
    public void unholdCall(String str) {
        PendingCallAction pendingCallAction = this.mPendingCallAction;
        if (pendingCallAction != null && pendingCallAction.hasPengingAction()) {
            Log.i(LOG_TAG, "hasPengingAction can not unholdCall " + this.mPendingCallAction);
            return;
        }
        OplusCallList oplusCallList = (OplusCallList) CallList.getInstance();
        if (oplusCallList.getCallById(str) == null) {
            Log.i(LOG_TAG, "unholdCall, call is null return");
            return;
        }
        if (oplusCallList.hasFakeStateCall()) {
            Log.i(LOG_TAG, "unholdCall,hasFakeStateCall return");
            return;
        }
        if (this.mInCallService != null) {
            android.telecom.Call telecommCallById = getTelecommCallById(str);
            if (telecommCallById != null) {
                telecommCallById.unhold();
                addPendingCallAction(str, 2);
                return;
            } else {
                Log.e(this, "error unholdCall, call not in call list " + str);
                return;
            }
        }
        Log.e(this, "error unholdCall, mInCallService is null");
    }
}
