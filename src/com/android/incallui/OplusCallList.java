package com.android.incallui;

import android.telecom.DisconnectCause;
import android.telephony.SubscriptionManager;
import com.internal_dependency.AddOnSdkDepends;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class OplusCallList extends CallList {
    private static final String IMS_MERGED_SUCCESSFULLY = "IMS_MERGED_SUCCESSFULLY";
    private static final String LOG_TAG = "OplusCallList";
    private final HashMap<String, ExtCallInfo> mExtCallInfoMap = new HashMap<>();
    private boolean mConferenceMuteFlagSub1 = false;
    private boolean mConferenceMuteFlagSub2 = false;
    private boolean mHangUpConfernceCall = false;
    private int mActiveSubPhoneType = -1;

    /* loaded from: classes.dex */
    public class ExtCallInfo {
        private boolean mConferenceCallDisconnecting = false;

        public ExtCallInfo() {
        }

        public boolean getConferenceCallDisconnecting() {
            return this.mConferenceCallDisconnecting;
        }

        public void setConferenceCallDisconnecting(boolean z10) {
            this.mConferenceCallDisconnecting = z10;
        }
    }

    public boolean allConferenceChildCallDisconnected() {
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "allConferenceChildCallDisconnected...");
        }
        Iterator<String> it = this.mExtCallInfoMap.keySet().iterator();
        if (!this.mHangUpConfernceCall) {
            return true;
        }
        while (it.hasNext()) {
            ExtCallInfo extCallInfo = this.mExtCallInfoMap.get(it.next());
            if (extCallInfo != null && extCallInfo.getConferenceCallDisconnecting()) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "allConferenceChildCallDisconnected false");
                }
                return false;
            }
        }
        setIsHangUpConfernceCall(false);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "allConferenceChildCallDisconnected true");
        }
        return true;
    }

    public void cleanup() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "cleanup in call list");
        }
        this.mConferenceMuteFlagSub1 = false;
        this.mConferenceMuteFlagSub2 = false;
    }

    public void clearExtCallInfoMap() {
        this.mExtCallInfoMap.clear();
    }

    public ExtCallInfo findExtCallInfoById(String str) {
        return this.mExtCallInfoMap.get(str);
    }

    @Override // com.android.incallui.CallList
    public Call getActiveCall() {
        int oplusGetCallSize = oplusGetCallSize();
        int i10 = 1;
        if (oplusGetCallSize > 1 && isCdmaPhoneActive()) {
            Call firstCallWithState = getFirstCallWithState(3);
            while (true) {
                if (i10 < oplusGetCallSize) {
                    Call callWithState = getCallWithState(3, i10);
                    if (callWithState != null && callWithState.isConferenceCall()) {
                        firstCallWithState = callWithState;
                        break;
                    }
                    i10++;
                } else {
                    break;
                }
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "get cdma activeCall = " + firstCallWithState);
            }
            return firstCallWithState;
        }
        return getFirstCallWithState(3);
    }

    public boolean getConferenceMuteFlag() {
        if (getActiveSubId() == 0) {
            return this.mConferenceMuteFlagSub1;
        }
        return this.mConferenceMuteFlagSub2;
    }

    public Call getFirstCallExceptRingAndDisconnect() {
        Call pendingOutgoingCall = getPendingOutgoingCall();
        if (pendingOutgoingCall == null) {
            pendingOutgoingCall = getOutgoingCall();
        }
        if (pendingOutgoingCall == null) {
            pendingOutgoingCall = getFirstCallWithState(3);
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getFirstCallExceptRingAndDisconnect  = " + pendingOutgoingCall);
        }
        return pendingOutgoingCall;
    }

    public int getOtherActiveSubId() {
        int activeSubId = getActiveSubId();
        if (!InCallServiceImpl.isDsdaEnabled() || InCallServiceImpl.sPhoneCount <= 1) {
            return -1;
        }
        for (int i10 = 0; i10 < InCallServiceImpl.sPhoneCount; i10++) {
            int subId = getSubId(i10);
            if (subId != activeSubId && hasAnyLiveCall(subId)) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "getOtherActiveSubId , subId = " + subId);
                }
                return subId;
            }
        }
        return -1;
    }

    public boolean hasCDMADialingCall() {
        Call callWithState = getCallWithState(3, 0, 0);
        if (callWithState == null || !isCDMADialingCall(callWithState)) {
            return false;
        }
        return true;
    }

    public boolean hasConferenceCall() {
        int oplusGetCallSize = oplusGetCallSize();
        for (int i10 = 0; i10 < oplusGetCallSize; i10++) {
            Call callWithState = getCallWithState(3, i10);
            if (callWithState != null && callWithState.isConferenceCall()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFakeStateCall() {
        Collection<Call> collection;
        if (getMCallMap() != null) {
            collection = getMCallMap().values();
        } else {
            collection = null;
        }
        boolean z10 = false;
        if (collection != null && !collection.isEmpty()) {
            Iterator<Call> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Call next = it.next();
                if (next != null && next.getFakeState() != 0) {
                    z10 = true;
                    break;
                }
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "hasFakeStateCall  = " + z10);
            }
        }
        return z10;
    }

    public boolean hasVideoCall() {
        if (getMCallMap() == null) {
            return false;
        }
        Iterator<Call> it = getMCallMap().values().iterator();
        while (it.hasNext()) {
            if (CallUtils.isBidirectionalVideoCall(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasVideoRingToneCall() {
        if (getMCallMap() == null) {
            return false;
        }
        Iterator<Call> it = getMCallMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().getIsVideoRingTone()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.android.incallui.CallList
    public boolean isCDMADialingCall(Call call) {
        if (call != null && call.isCdmaDialing()) {
            return true;
        }
        return false;
    }

    public boolean isCdmaPhoneActive() {
        boolean z10;
        if (this.mActiveSubPhoneType == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isCdmaPhoneActive  = " + z10);
        }
        return z10;
    }

    public boolean isCdmaPhoneInactive() {
        boolean z10;
        if (this.mActiveSubPhoneType == 2) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isCdmaPhoneInctive  = " + z10);
        }
        return z10;
    }

    @Override // com.android.incallui.CallList
    public void onDisconnect(Call call) {
        boolean z10;
        boolean z11;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onDisconnect: ", call);
        }
        boolean isVideoCall = CallUtils.isVideoCall(call);
        boolean z12 = true;
        if (oplusGetCallSize() == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean equals = IMS_MERGED_SUCCESSFULLY.equals(call.getDisconnectCause().getReason());
        if (!equals && !OplusFeatureOption.OPLUS_VERSION_EXP && call.getDisconnectCause().getCode() == 9) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isVideoCall = " + isVideoCall + ", isCallNumbersValid = " + z10 + ", imsMergerSuccessReason = " + equals + ", imsMergerSuccessCode = " + z11);
        }
        if (!isVideoCall && z10 && (equals || z11)) {
            setImsMergedSuccessfully(true);
        }
        DisconnectCause disconnectCause = call.getDisconnectCause();
        if (disconnectCause == null || (disconnectCause.getCode() != 2 && disconnectCause.getCode() != 4)) {
            z12 = false;
        }
        if (oplusGetBackgroundCall() != null || oplusGetIncomingCall() != null) {
            clearExtCallInfoMap();
        }
        if (findExtCallInfoById(call.getId()) == null || !z12) {
            setIsHangUpConfernceCall(false);
            clearExtCallInfoMap();
        }
        Call oplusGetBackgroundCall = oplusGetBackgroundCall();
        if (oplusGetBackgroundCall != null && oplusGetBackgroundCall.getFakeState() == 3) {
            oplusGetBackgroundCall.setFakeState(0);
            Log.d(LOG_TAG, "reset background call fakeState");
        }
        super.onDisconnect(call);
    }

    public Call oplusGetActiveCall() {
        Call activeCall = getActiveCall();
        if (activeCall == null) {
            return oplusGetAnotherActiveCall();
        }
        return activeCall;
    }

    public Call oplusGetAnotherActiveCall() {
        int otherActiveSubId = getOtherActiveSubId();
        if (otherActiveSubId != -1) {
            return getCallWithState(3, 0, otherActiveSubId);
        }
        return null;
    }

    public Call oplusGetAnotherBackgroundCall() {
        int otherActiveSubId = getOtherActiveSubId();
        if (otherActiveSubId != -1) {
            return getCallWithState(8, 0, otherActiveSubId);
        }
        return null;
    }

    public Call oplusGetAnotherDisconnectedCall() {
        int otherActiveSubId = getOtherActiveSubId();
        if (otherActiveSubId != -1) {
            return getCallWithState(10, 0, otherActiveSubId);
        }
        return null;
    }

    public Call oplusGetAnotherDisconnectingCall() {
        int otherActiveSubId = getOtherActiveSubId();
        if (otherActiveSubId != -1) {
            return getCallWithState(9, 0, otherActiveSubId);
        }
        return null;
    }

    public Call oplusGetAnotherIncomingCall() {
        int otherActiveSubId = getOtherActiveSubId();
        if (otherActiveSubId != -1) {
            Call callWithState = getCallWithState(4, 0, otherActiveSubId);
            if (callWithState == null) {
                return getCallWithState(5, 0, otherActiveSubId);
            }
            return callWithState;
        }
        return null;
    }

    public Call oplusGetAnotherOutgoingCall() {
        int otherActiveSubId = getOtherActiveSubId();
        if (otherActiveSubId != -1) {
            Call callWithState = getCallWithState(6, 0, otherActiveSubId);
            if (callWithState == null) {
                return getCallWithState(7, 0, otherActiveSubId);
            }
            return callWithState;
        }
        return null;
    }

    public Call oplusGetAnotherPendingOutgoingCall() {
        int otherActiveSubId = getOtherActiveSubId();
        if (otherActiveSubId != -1) {
            return getCallWithState(13, 0, otherActiveSubId);
        }
        return null;
    }

    public Call oplusGetAnotherSecondBackgroundCall() {
        int otherActiveSubId = getOtherActiveSubId();
        if (otherActiveSubId != -1) {
            return getCallWithState(8, 1, otherActiveSubId);
        }
        return null;
    }

    public Call oplusGetBackgroundCall() {
        Call backgroundCall = getBackgroundCall();
        if (backgroundCall == null) {
            return oplusGetAnotherBackgroundCall();
        }
        return backgroundCall;
    }

    public Call oplusGetCallByPriority(Call call, Call call2, boolean z10) {
        Call oplusGetIncomingCall = oplusGetIncomingCall();
        if (oplusGetIncomingCall != null && oplusGetIncomingCall != call && oplusGetIncomingCall != call2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "CurrentPhoneHasIncomingCall");
            }
            return oplusGetIncomingCall;
        }
        Call activeCall = getActiveCall();
        if (activeCall != null && activeCall != call && activeCall != call2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "CurrentPhoneHasActiveCall");
            }
            return activeCall;
        }
        Call backgroundCall = getBackgroundCall();
        if (backgroundCall != null && backgroundCall != call && backgroundCall != call2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "CurrentPhoneHasBackgroundCall");
            }
            return backgroundCall;
        }
        Call oplusGetAnotherOutgoingCall = oplusGetAnotherOutgoingCall();
        if (oplusGetAnotherOutgoingCall != null && oplusGetAnotherOutgoingCall != call && oplusGetAnotherOutgoingCall != call2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "oplusGetAnotherOutgoingCall");
            }
            return oplusGetAnotherOutgoingCall;
        }
        Call oplusGetAnotherActiveCall = oplusGetAnotherActiveCall();
        if (oplusGetAnotherActiveCall != null && oplusGetAnotherActiveCall != call && oplusGetAnotherActiveCall != call2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "AnotherPhoneHasActiveCall");
            }
            return oplusGetAnotherActiveCall;
        }
        if (!z10) {
            Call oplusGetDisconnectingCall = oplusGetDisconnectingCall();
            if (oplusGetDisconnectingCall != null && oplusGetDisconnectingCall != call && oplusGetDisconnectingCall != call2) {
                return oplusGetDisconnectingCall;
            }
            Call oplusGetDisconnectedCall = oplusGetDisconnectedCall();
            if (oplusGetDisconnectedCall != null && oplusGetDisconnectedCall != call && oplusGetDisconnectedCall != call2) {
                return oplusGetDisconnectedCall;
            }
        }
        Call oplusGetAnotherBackgroundCall = oplusGetAnotherBackgroundCall();
        if (oplusGetAnotherBackgroundCall != null && oplusGetAnotherBackgroundCall != call && oplusGetAnotherBackgroundCall != call2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "AnotherPhoneHasBackgroundCall");
            }
            return oplusGetAnotherBackgroundCall;
        }
        Call secondBackgroundCall = getSecondBackgroundCall();
        if (secondBackgroundCall != null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "CurrentPhoneHasSecBackgroundCall2");
            }
            return secondBackgroundCall;
        }
        return oplusGetSecondBackgroundCall();
    }

    public int oplusGetCallSize() {
        int size;
        if (getMCallMap() == null) {
            size = 0;
        } else {
            size = getMCallMap().size();
        }
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "CallList size = " + size);
        }
        return size;
    }

    public Call oplusGetDisconnectedCall() {
        Call disconnectedCall = getDisconnectedCall();
        if (disconnectedCall == null) {
            return oplusGetAnotherDisconnectedCall();
        }
        return disconnectedCall;
    }

    public Call oplusGetDisconnectingCall() {
        Call disconnectingCall = getDisconnectingCall();
        if (disconnectingCall == null) {
            return oplusGetAnotherDisconnectingCall();
        }
        return disconnectingCall;
    }

    public Call oplusGetIncomingCall() {
        Call incomingCall = getIncomingCall();
        if (incomingCall == null) {
            return oplusGetAnotherIncomingCall();
        }
        return incomingCall;
    }

    public Call oplusGetOutgoingCall() {
        Call oplusGetPendingOutgoingCall = oplusGetPendingOutgoingCall();
        if (oplusGetPendingOutgoingCall == null) {
            oplusGetPendingOutgoingCall = getOutgoingCall();
        }
        if (oplusGetPendingOutgoingCall == null) {
            return oplusGetAnotherOutgoingCall();
        }
        return oplusGetPendingOutgoingCall;
    }

    public Call oplusGetPendingOutgoingCall() {
        Call pendingOutgoingCall = getPendingOutgoingCall();
        if (pendingOutgoingCall == null) {
            return oplusGetAnotherPendingOutgoingCall();
        }
        return pendingOutgoingCall;
    }

    public Call oplusGetSecondBackgroundCall() {
        Call secondBackgroundCall = getSecondBackgroundCall();
        if (secondBackgroundCall == null) {
            return oplusGetAnotherSecondBackgroundCall();
        }
        return secondBackgroundCall;
    }

    public void refreshExtendCallInfoDisconnecting(String str, boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "refreshExtendCallInfoDisconnecting callId = " + str + "   disconnected = " + z10);
        }
        if (!this.mHangUpConfernceCall) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "refreshExtendCallInfoDisconnecting mHangUpConfernceCall return !!!");
                return;
            }
            return;
        }
        ExtCallInfo findExtCallInfoById = findExtCallInfoById(str);
        if (findExtCallInfoById == null) {
            if (z10) {
                findExtCallInfoById = new ExtCallInfo();
            } else {
                return;
            }
        }
        findExtCallInfoById.setConferenceCallDisconnecting(z10);
        this.mExtCallInfoMap.put(str, findExtCallInfoById);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "refreshExtendCallInfoDisconnecting size = " + this.mExtCallInfoMap.size());
        }
    }

    public void setActiceSubPhoneType(Call call) {
        if (call != null) {
            this.mActiveSubPhoneType = call.getIsCdmaPhone() ? 2 : 1;
        }
    }

    @Override // com.android.incallui.CallList
    public void setActiveSubId(int i10) {
        if (i10 != this.mSubId) {
            super.setActiveSubId(i10);
            setActiceSubPhoneType(i10);
        }
    }

    public void setConferenceChildCallDisconnecting(Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setConferenceChildCallDisconnecting...");
        }
        if (call != null && call.getChildCallIds().size() != 0) {
            setIsHangUpConfernceCall(true);
            List<String> childCallIds = call.getChildCallIds();
            refreshExtendCallInfoDisconnecting(call.getId(), true);
            for (String str : childCallIds) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "setConferenceChildCallDisconnecting callId = " + str);
                }
                refreshExtendCallInfoDisconnecting(str, true);
            }
        }
    }

    public void setConferenceMuteFlag() {
        boolean z10 = getActiveCall() != null && ((OplusCall) getActiveCall()).getMuted() && getBackgroundCall() != null && ((OplusCall) getBackgroundCall()).getMuted();
        if (getActiveSubId() == 0) {
            this.mConferenceMuteFlagSub1 = z10;
        } else {
            this.mConferenceMuteFlagSub2 = z10;
        }
    }

    public void setImsMergedSuccessfully(boolean z10) {
        Log.d(LOG_TAG, "setImsMergedSuccessfully  mImsMergedSuccessfully = " + z10);
    }

    public void setIsHangUpConfernceCall(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setIsHangUpConfernceCall  = " + z10);
        }
        this.mHangUpConfernceCall = z10;
    }

    @Override // com.android.incallui.CallList
    public void setSRVCCforCalls(boolean z10) {
        if (getMCallMap() == null) {
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setSRVCCforCalls = " + z10);
        }
        for (Call call : getMCallMap().values()) {
            if (call != null) {
                call.setHasSRVCC(z10);
            }
        }
        ((OplusCallList) CallList.getInstance()).setActiceSubPhoneType(this.mSubId);
    }

    public void setVideoPausedForConference() {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (getActiveCall() != null) {
            z10 = getActiveCall().getVideoPaused();
        } else {
            z10 = false;
        }
        if (getBackgroundCall() != null) {
            z11 = getBackgroundCall().getVideoPaused();
        } else {
            z11 = false;
        }
        if (CallUtils.isVideoCall(getActiveCall())) {
            if (CallUtils.isVideoCall(getBackgroundCall())) {
                if (z10 && z11) {
                    z12 = true;
                }
                OplusPhoneUtils.setVideoPausedForConf(z12);
                return;
            }
            OplusPhoneUtils.setVideoPausedForConf(z10);
            return;
        }
        if (CallUtils.isVideoCall(getBackgroundCall())) {
            OplusPhoneUtils.setVideoPausedForConf(z11);
        }
    }

    public void shouldChangeActiveSubscription() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "shouldChangeActiveSubscription current = " + getActiveSubId());
        }
        Call oplusGetCallByPriority = oplusGetCallByPriority(null, null, true);
        if (oplusGetCallByPriority != null && oplusGetCallByPriority.getSubId() != getActiveSubId()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "shouldChangeActiveSubscription = " + oplusGetCallByPriority.getSubId());
            }
            switchToOtherActiveSub();
        }
    }

    public void swapCdmaCall() {
        Call activeCall = getActiveCall();
        if (activeCall == null) {
            activeCall = getBackgroundCall();
        }
        if (activeCall == null) {
            activeCall = getSecondBackgroundCall();
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "swapCdmaCall call = " + activeCall);
        }
        if (activeCall != null) {
            TelecomAdapter.getInstance().swap(activeCall.getId());
        }
    }

    public void setActiceSubPhoneType(int i10) {
        int phoneTypeBySubId = OplusPhoneUtils.getPhoneTypeBySubId(i10);
        this.mActiveSubPhoneType = phoneTypeBySubId;
        if (phoneTypeBySubId == 2) {
            if (AddOnSdkDepends.getSInstance().oplusIsImsRegistered(OplusInCallApp.getAppContext(), SubscriptionManager.getSlotIndex(i10), i10)) {
                this.mActiveSubPhoneType = 1;
            }
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setActiceSubPhoneType subId = " + i10 + "  mActiveSubPhoneType = " + this.mActiveSubPhoneType);
        }
    }

    public void setConferenceMuteFlag(boolean z10) {
        if (getActiveSubId() == 0) {
            this.mConferenceMuteFlagSub1 = z10;
        } else {
            this.mConferenceMuteFlagSub2 = z10;
        }
    }
}
