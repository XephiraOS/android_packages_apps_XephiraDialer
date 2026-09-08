package com.android.incallui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Trace;
import android.telecom.DisconnectCause;
import android.telecom.PhoneAccountHandle;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.ContactInfoCache;
import com.android.oplus.module.castScreen.CastScreen;
import com.google.common.collect.Maps;
import com.internal_dependency.InternalSdkDepends;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import z2.C1731b;

/* loaded from: classes.dex */
public class CallList {
    private static final long CONFERENCE_SRVCC_TIMEOUT = 3000;
    protected static final int DISCONNECTED_CALL_LONG_TIMEOUT_MS = 200;
    protected static final int DISCONNECTED_CALL_MEDIUM_TIMEOUT_MS = 100;
    protected static final int DISCONNECTED_CALL_PLAY_BUSY_TONE_MS = 3500;
    protected static final int DISCONNECTED_CALL_SHORT_TIMEOUT_MS = 20;
    private static final int EVENT_DISCONNECTED_TIMEOUT = 1;
    protected static final int EVENT_NOTIFY_CHANGE = 2;
    private static final String LOG_TAG = "CallList";
    private static final long NEED_MARK_NUMBER_TIME = 3000;
    protected static final int OPLUS_DISCONNECTED_CALL_LONG_TIMEOUT_MS = 2800;
    protected static final int OPLUS_DISCONNECTED_CALL_VIDEO_CONF_TIMEOUT_MS = 800;
    private static CallList sInstance = new OplusCallList();
    private boolean mHasSRVCCConferenceFlag;
    private final HashMap<String, Call> mCallById = new LinkedHashMap();
    private final HashMap<android.telecom.Call, Call> mCallByTelecommCall = new HashMap<>();
    private final HashMap<String, List<String>> mCallTextReponsesMap = Maps.f();
    private final Set<Listener> mListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    private final HashMap<String, List<CallUpdateListener>> mCallUpdateListenerMap = Maps.f();
    private final Set<Call> mPendingDisconnectCalls = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    protected int mSubId = -1;
    private final Set<ActiveSubChangeListener> mActiveSubChangeListeners = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
    protected Handler mHandler = new Handler(Looper.myLooper()) { // from class: com.android.incallui.CallList.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (Log.sDebug) {
                Log.d(CallList.LOG_TAG, "handleMessage msg = " + message);
            }
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    Log.wtf(CallList.LOG_TAG, "Message not expected: " + message.what);
                    return;
                }
                if (Log.sDebug) {
                    Log.d(CallList.LOG_TAG, "EVENT_NOTIFY_CHANGE: ");
                }
                CallList.this.notifyGenericListeners();
                Iterator it = CallList.this.mActiveSubChangeListeners.iterator();
                while (it.hasNext()) {
                    ((ActiveSubChangeListener) it.next()).onActiveSubChanged(CallList.this.getActiveSubId());
                }
                return;
            }
            if (Log.sDebug) {
                Log.d(CallList.LOG_TAG, "EVENT_DISCONNECTED_TIMEOUT ", message.obj);
            }
            CallList.this.finishDisconnectedCall((Call) message.obj);
        }
    };
    private Runnable mAutoCleanSRVCCConferenceFlag = new Runnable() { // from class: com.android.incallui.CallList.3
        @Override // java.lang.Runnable
        public void run() {
            CallList callList = CallList.this;
            callList.mHandler.removeCallbacks(callList.mAutoCleanSRVCCConferenceFlag);
            CallList.this.mHasSRVCCConferenceFlag = false;
            if (Log.sDebug) {
                Log.d(CallList.LOG_TAG, "autoCleanSRVCCConferenceFlag, mHasSRVCCConferenceFlag:" + CallList.this.mHasSRVCCConferenceFlag);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface ActiveSubChangeListener {
        void onActiveSubChanged(int i10);
    }

    /* loaded from: classes.dex */
    public interface Listener {
        void onCallListChange(CallList callList);

        void onDisconnect(Call call);

        void onIncomingCall(Call call);

        void onUpgradeToVideo(Call call);
    }

    public static CallList getInstance() {
        return sInstance;
    }

    private boolean isCallDead(Call call) {
        int state = call.getState();
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "isCallDead state = " + state);
        }
        if (2 != state && state != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGenericListeners() {
        Iterator<Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onCallListChange(this);
        }
    }

    private void notifyListenersOfDisconnect(Call call) {
        Iterator<Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onDisconnect(call);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateCall(Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "\t" + call);
        }
        if (updateCallInMap(call) && Log.sDebug) {
            Log.d(LOG_TAG, "onUpdate call =  " + call);
        }
        updateCallTextMap(call, call.getCannedSmsResponses());
        notifyCallUpdateListeners(call);
    }

    public void addActiveSubChangeListener(ActiveSubChangeListener activeSubChangeListener) {
        com.google.common.base.k.o(activeSubChangeListener);
        this.mActiveSubChangeListeners.add(activeSubChangeListener);
    }

    public void addCallUpdateListener(String str, CallUpdateListener callUpdateListener) {
        List<CallUpdateListener> list = this.mCallUpdateListenerMap.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.mCallUpdateListenerMap.put(str, list);
        }
        if (!list.contains(callUpdateListener)) {
            list.add(callUpdateListener);
        }
    }

    public void addHasSRVCCConferenceFlag() {
        this.mHasSRVCCConferenceFlag = true;
        this.mHandler.postDelayed(this.mAutoCleanSRVCCConferenceFlag, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "addHasSRVCCConferenceFlag() mHasSRVCCConferenceFlag:" + this.mHasSRVCCConferenceFlag);
        }
    }

    public void addListener(Listener listener) {
        com.google.common.base.k.o(listener);
        this.mListeners.add(listener);
        listener.onCallListChange(this);
    }

    public void clearOnDisconnect() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "clearOnDisconnect--");
        }
        for (Call call : this.mCallById.values()) {
            int state = call.getState();
            if (state != 2 && state != 0 && state != 10) {
                call.setState(10);
                call.setDisconnectCause(new DisconnectCause(0));
                updateCallInMap(call);
            }
        }
        notifyGenericListeners();
    }

    public void finishDisconnectedCall(Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "finishDisconnectedCall  call id = " + call.getId());
        }
        if (this.mPendingDisconnectCalls.contains(call)) {
            this.mPendingDisconnectCalls.remove(call);
        }
        call.setState(2);
        updateCallInMap(call);
        notifyGenericListeners();
        HashMap<String, Call> hashMap = this.mCallById;
        if (hashMap != null && hashMap.size() == 0) {
            A2.w.e().b();
        }
    }

    public Call getActiveCall() {
        return getFirstCallWithState(3);
    }

    public Call getActiveOrBackgroundCall() {
        Call activeCall = getActiveCall();
        if (activeCall == null) {
            return getBackgroundCall();
        }
        return activeCall;
    }

    public int getActiveSubId() {
        return this.mSubId;
    }

    public Call getBackgroundCall() {
        return getFirstCallWithState(8);
    }

    public Call getCallById(String str) {
        return this.mCallById.get(str);
    }

    public Call getCallByTelecommCall(android.telecom.Call call) {
        return this.mCallByTelecommCall.get(call);
    }

    public int getCallSizeWithState(int i10, boolean z10) {
        int i11 = 0;
        int i12 = 0;
        for (Call call : getMCallMap().values()) {
            if (call.getState() == i10) {
                i12++;
                if (!call.isConferenceCall()) {
                    i11++;
                }
            }
        }
        Log.d(LOG_TAG, "getCallSizeWithState: " + i10 + " sizeWithoutConf = " + i11 + " sizeWithConf = " + i12 + " withConference = " + z10);
        return z10 ? i12 : i11;
    }

    public Call getCallWithState(int i10, int i11) {
        int i12 = 0;
        for (Call call : getMCallMap().values()) {
            if (call.getState() == i10) {
                if (i12 >= i11) {
                    return call;
                }
                i12++;
            }
        }
        return null;
    }

    public Call getConferenceCall() {
        return getFirstCallWithState(11);
    }

    public int getDelayForDisconnect(Call call) {
        boolean z10;
        int i10;
        int i11 = 0;
        if (call.getState() == 10) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.u(z10);
        if (call.isConferenceCall() && CallUtils.isVideoCall(call)) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "getDelayForDisconnect for video conference = 800");
                return 800;
            }
            return 800;
        }
        int code = call.getDisconnectCause().getCode();
        switch (code) {
            case 1:
            case 3:
            case 7:
                if (OplusPhoneUtils.isNeedPlayBusyTone(code)) {
                    i11 = DISCONNECTED_CALL_PLAY_BUSY_TONE_MS;
                    break;
                } else if (code == 3 && call.isConferenceCall()) {
                    if (Log.sDebug) {
                        Log.d(LOG_TAG, "getDelayForDisconnect Conference REMOTE delay = 0");
                        break;
                    }
                } else {
                    if (OplusPhoneUtils.getNeedMarkNumber(OplusInCallApp.getAppContext())) {
                        i10 = 100;
                    } else {
                        i10 = OPLUS_DISCONNECTED_CALL_LONG_TIMEOUT_MS;
                    }
                    i11 = i10;
                    break;
                }
                break;
            case 2:
                i11 = 20;
                break;
            case 4:
            case 5:
            case 6:
                break;
            default:
                i11 = 200;
                break;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getDelayForDisconnect delay = " + i11);
        }
        return i11;
    }

    public Call getDisconnectedCall() {
        return getFirstCallWithState(10);
    }

    public Call getDisconnectingCall() {
        return getFirstCallWithState(9);
    }

    public Call getFirstCall() {
        Call incomingCall = getIncomingCall();
        if (incomingCall == null) {
            incomingCall = getPendingOutgoingCall();
        }
        if (incomingCall == null) {
            incomingCall = getOutgoingCall();
        }
        if (incomingCall == null) {
            incomingCall = getFirstCallWithState(3);
        }
        if (incomingCall == null) {
            incomingCall = getFirstCallWithState(8);
        }
        if (incomingCall == null) {
            incomingCall = getDisconnectingCall();
        }
        if (incomingCall == null) {
            return getDisconnectedCall();
        }
        return incomingCall;
    }

    public Call getFirstCallWithState(int i10) {
        return getCallWithState(i10, 0);
    }

    public Call getIncomingCall() {
        Call firstCallWithState = getFirstCallWithState(4);
        if (firstCallWithState == null) {
            return getFirstCallWithState(5);
        }
        return firstCallWithState;
    }

    public Call getIncomingOrActive() {
        Call incomingCall = getIncomingCall();
        if (incomingCall == null) {
            return getActiveCall();
        }
        return incomingCall;
    }

    public HashMap<String, Call> getMCallMap() {
        return this.mCallById;
    }

    public Call getOutgoingCall() {
        Call firstCallWithState = getFirstCallWithState(6);
        if (firstCallWithState == null) {
            return getFirstCallWithState(7);
        }
        return firstCallWithState;
    }

    public Call getOutgoingOrActive() {
        Call outgoingCall = getOutgoingCall();
        if (outgoingCall == null) {
            return getActiveCall();
        }
        return outgoingCall;
    }

    public Call getParentCallWithState(int i10, int i11) {
        int i12 = 0;
        Call call = null;
        for (Call call2 : getMCallMap().values()) {
            if (i10 == call2.getState() && call2.getParentCall() == null) {
                if (i12 >= i11) {
                    call = call2;
                } else {
                    i12++;
                }
            }
        }
        return call;
    }

    public Call getPendingOutgoingCall() {
        return getFirstCallWithState(13);
    }

    public int getPhoneId(int i10) {
        return InternalSdkDepends.getSInstance().getPhoneId(OplusInCallApp.getAppContext(), i10);
    }

    public Call getSecondBackgroundCall() {
        return getCallWithState(8, 1);
    }

    public int getSubId(int i10) {
        return InternalSdkDepends.getSInstance().getSubId(OplusInCallApp.getAppContext(), i10);
    }

    public List<String> getTextResponses(String str) {
        return this.mCallTextReponsesMap.get(str);
    }

    public Call getVideoUpgradeRequestCall() {
        for (Call call : this.mCallById.values()) {
            if (call.getSessionModificationState() == 3) {
                return call;
            }
        }
        return null;
    }

    public Call getWaitingForAccountCall() {
        return getFirstCallWithState(12);
    }

    public boolean hasAnyLiveCall(int i10) {
        for (Call call : this.mCallById.values()) {
            PhoneAccountHandle accountHandle = call.getAccountHandle();
            try {
                if (!isCallDead(call) && accountHandle != null && A2.d.d(accountHandle) == i10) {
                    Log.d(this, "hasAnyLiveCall sub = " + i10);
                    return true;
                }
            } catch (Exception e10) {
                Log.w(LOG_TAG, "Sub Id is not a number " + e10);
            }
        }
        if (!Log.sDebug) {
            return false;
        }
        Log.d(LOG_TAG, "no active call ");
        return false;
    }

    public boolean hasLiveCall() {
        Call firstCall = getFirstCall();
        if (firstCall == null || firstCall == getDisconnectingCall() || firstCall == getDisconnectedCall()) {
            return false;
        }
        return true;
    }

    public void initActiveSubId(int i10) {
        if (this.mCallById.size() == 0) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "initActiveSubId = " + i10);
            }
            this.mSubId = i10;
        }
    }

    public boolean isAnyOtherSubActive(int i10) {
        if (!InCallServiceImpl.isDsdaEnabled()) {
            return false;
        }
        for (int i11 = 0; i11 < InCallServiceImpl.sPhoneCount; i11++) {
            int subId = getSubId(i11);
            if (subId != i10 && hasAnyLiveCall(subId)) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "Live call found on another sub = " + subId);
                }
                return true;
            }
        }
        return false;
    }

    public boolean isCDMADialingCall(Call call) {
        return false;
    }

    public void notifyCallUpdateListeners(Call call) {
        List<CallUpdateListener> list = this.mCallUpdateListenerMap.get(call.getId());
        if (list != null) {
            Iterator<CallUpdateListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCallChanged(call);
            }
        }
    }

    public void notifyCallsOfDeviceRotation(int i10) {
        for (Call call : this.mCallById.values()) {
            if (call.getVideoCall() != null && CallUtils.isVideoCall(call)) {
                call.getVideoCall().setDeviceOrientation(i10);
            }
        }
    }

    public void onCallAdded(final android.telecom.Call call) {
        boolean z10;
        if (Log.sSystraceDebug) {
            Trace.beginSection("onCallAdded");
        }
        HashMap<String, Call> hashMap = this.mCallById;
        if (hashMap != null && hashMap.size() == 0) {
            C2.b.a().execute(new Runnable() { // from class: com.android.incallui.CallList.1
                @Override // java.lang.Runnable
                public void run() {
                    OplusPhoneUtils.refreshOplusVideoCallEnable(call);
                }
            });
        }
        OplusCall oplusCall = new OplusCall(call);
        oplusCall.addListener(new DialerCallListenerImpl(oplusCall));
        if (call != null && call.getDetails() != null) {
            z10 = call.getDetails().can(128);
        } else {
            z10 = false;
        }
        if (this.mHasSRVCCConferenceFlag && z10) {
            oplusCall.setIsSRVCCConference(true);
            removeHasSRVCCConferenceFlag();
        }
        D2.f.u();
        A2.j.J().Y();
        if (call != null && call.getState() == 8) {
            InCallPresenter.getInstance().realInstance().getOplusSelectPhoneAccountManager().q(oplusCall);
            return;
        }
        InCallPresenter.getInstance().realInstance().getOplusSelectPhoneAccountManager().q(null);
        if (oplusCall.isConferenceCall() && CallUtils.isVideoCall(oplusCall) && !OplusPhoneUtils.getVideoPausedForConf()) {
            oplusCallList().setVideoPausedForConference();
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onCallAdded: callState=" + oplusCall.getState());
        }
        if (oplusCall.getState() != 4 && oplusCall.getState() != 5) {
            onUpdate(oplusCall);
        } else {
            onIncoming(oplusCall, oplusCall.getCannedSmsResponses());
        }
        TelecomAdapter.getInstance().oplusTelecomAdapter().clearPendingCallAction();
        HashMap<String, Call> hashMap2 = this.mCallById;
        if (hashMap2 != null && hashMap2.size() == 1) {
            A2.w.e().c();
        }
        if (Log.sSystraceDebug) {
            Trace.endSection();
        }
    }

    public void onCallRemoved(android.telecom.Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onCallRemoved: callState=" + call.getState());
        }
        TelecomAdapter.getInstance().oplusTelecomAdapter().clearPendingCallAction();
        if (this.mCallByTelecommCall.containsKey(call)) {
            Call call2 = this.mCallByTelecommCall.get(call);
            call2.setState(10);
            call2.setDisconnectCause(call.getDetails().getDisconnectCause());
            onDisconnect(call2);
            if (call2.can(128)) {
                if ((call2.getHasSRVCC() && call.getDetails().getDisconnectCause().getCode() == 9) || (OplusFeatureOption.OPLUS_PHONE_HIDE_CONFERENCE_MANAGE_BUTTON_AFTER_SRVCC && call2.isSRVCCConference())) {
                    addHasSRVCCConferenceFlag();
                } else {
                    removeHasSRVCCConferenceFlag();
                }
            } else if (!hasAnyLiveCall()) {
                removeHasSRVCCConferenceFlag();
            }
            updateCallTextMap(call2, null);
            return;
        }
        Call i10 = InCallPresenter.getInstance().realInstance().getOplusSelectPhoneAccountManager().i();
        if (i10 != null && i10.getTelecommCall() != null && i10.getTelecommCall().equals(call)) {
            InCallPresenter.getInstance().realInstance().getOplusSelectPhoneAccountManager().q(null);
            if (call.getState() == 7 && oplusCallList().oplusGetCallSize() == 0 && !OplusPhoneUtils.isTelephonyRinging(OplusInCallApp.getAppContext())) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "Need to clear cache info when removed");
                }
                A2.j.J().w();
                C1731b.d().c();
            }
        }
    }

    public void onChildNumberChange(Call call) {
        List<CallUpdateListener> list = this.mCallUpdateListenerMap.get(call.getId());
        if (list != null) {
            Iterator<CallUpdateListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onChildNumberChange();
            }
        }
    }

    public void onDisconnect(Call call) {
        if (updateCallInMap(call)) {
            Log.i(LOG_TAG, "onDisconnect: " + call);
            notifyCallUpdateListeners(call);
            notifyListenersOfDisconnect(call);
        }
    }

    public void onIncoming(Call call, List<String> list) {
        D2.g.i(LOG_TAG, "onIncoming - " + call);
        PhoneAccountHandle accountHandle = call.getAccountHandle();
        try {
            if (call.mIsActiveSub && accountHandle != null) {
                int d10 = A2.d.d(accountHandle);
                Log.d(this, "onIncoming - sub:" + d10 + " mSubId:" + this.mSubId);
                if (d10 != this.mSubId) {
                    setActiveSubId(d10);
                }
            }
        } catch (Exception e10) {
            Log.w(this, "Sub Id is not a number " + e10);
        }
        if (updateCallInMap(call)) {
            Log.i(LOG_TAG, "onIncoming - " + call);
        }
        updateCallTextMap(call, list);
        Iterator<Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onIncomingCall(call);
        }
    }

    public void onLastForwardedNumberChange(Call call) {
        List<CallUpdateListener> list = this.mCallUpdateListenerMap.get(call.getId());
        if (list != null) {
            Iterator<CallUpdateListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onLastForwardedNumberChange();
            }
        }
    }

    public void onSessionModificationStateChange(Call call, int i10) {
        List<CallUpdateListener> list = this.mCallUpdateListenerMap.get(call.getId());
        if (list != null) {
            Iterator<CallUpdateListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onSessionModificationStateChange(call, i10);
            }
        }
    }

    public void onUpdate(Call call) {
        if (Log.sSystraceDebug) {
            Trace.beginSection("onUpdate");
        }
        PhoneAccountHandle accountHandle = call.getAccountHandle();
        Log.d(this, "onUpdate - " + call + " ph:" + accountHandle);
        try {
            if (call.mIsActiveSub && accountHandle != null) {
                int d10 = A2.d.d(accountHandle);
                Log.d(this, "onUpdate - sub:" + d10 + " mSubId:" + this.mSubId);
                if (d10 != this.mSubId) {
                    setActiveSubId(d10);
                }
            }
        } catch (Exception e10) {
            Log.w(this, "Sub Id is not a number " + e10);
        }
        onUpdateCall(call);
        notifyGenericListeners();
        if (Log.sSystraceDebug) {
            Trace.endSection();
        }
    }

    public void onUpgradeToVideo(Call call) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onUpgradeToVideo call=" + call);
        }
        Iterator<Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpgradeToVideo(call);
        }
    }

    public OplusCallList oplusCallList() {
        return (OplusCallList) sInstance;
    }

    public void removeActiveSubChangeListener(ActiveSubChangeListener activeSubChangeListener) {
        com.google.common.base.k.o(activeSubChangeListener);
        this.mActiveSubChangeListeners.remove(activeSubChangeListener);
    }

    public void removeCallUpdateListener(String str, CallUpdateListener callUpdateListener) {
        List<CallUpdateListener> list = this.mCallUpdateListenerMap.get(str);
        if (list != null) {
            list.remove(callUpdateListener);
        }
    }

    public void removeHasSRVCCConferenceFlag() {
        this.mHasSRVCCConferenceFlag = false;
        this.mHandler.removeCallbacks(this.mAutoCleanSRVCCConferenceFlag);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "removeHasSRVCCConferenceFlag() mHasSRVCCConferenceFlag:" + this.mHasSRVCCConferenceFlag);
        }
    }

    public void removeListener(Listener listener) {
        if (listener != null) {
            this.mListeners.remove(listener);
        }
    }

    public void resetAllFakeState() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "resetAllFakeState");
        }
        for (Call call : this.mCallById.values()) {
            if (call != null) {
                call.setFakeState(0);
            }
        }
    }

    public void setActiveSubId(int i10) {
        if (i10 != this.mSubId) {
            if (Log.sDebug) {
                Log.i(LOG_TAG, "setActiveSubscription, old = " + this.mSubId + " new = " + i10);
            }
            this.mSubId = i10;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, null));
        }
    }

    public boolean switchToOtherActiveSub() {
        int activeSubId = getActiveSubId();
        for (int i10 = 0; i10 < InCallServiceImpl.sPhoneCount; i10++) {
            int subId = getSubId(i10);
            if (subId != activeSubId && hasAnyLiveCall(subId)) {
                if (Log.sDebug) {
                    Log.i(LOG_TAG, "switchToOtherActiveSub, subId = " + subId);
                }
                setActiveSubId(subId);
                return true;
            }
        }
        return false;
    }

    public boolean updateCallInMap(Call call) {
        Call firstCallWithState;
        if (call == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "updateCallInMap call is null return" + this.mCallById.size());
            }
            return false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateCallInMap = " + this.mCallById.size());
        }
        if (call.getState() == 10) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "updateCallInMap DISCONNECTED");
            }
            if (!this.mCallById.containsKey(call.getId())) {
                return false;
            }
            ContactInfoCache.ContactCacheEntry contactInfo = call.getContactInfo();
            int code = call.getDisconnectCause().getCode();
            if (Log.sDebug) {
                Log.d(LOG_TAG, "updateCallInMap cause = " + code);
            }
            if ((code == 2 || code == 3) && OplusPhoneUtils.isUserUnlocked(OplusInCallApp.getAppContext()) && !call.isConferenceCall() && call.getParentCall() == null && contactInfo.isIncomingCall && A2.n.a(contactInfo) && (OplusFeatureOption.OPLUS_VERSION_EXP || System.currentTimeMillis() - call.getConnectTimeMillis() > GrpcUtils.CREATE_CHANNEL_TIME_OUT)) {
                OplusPhoneUtils.setNeedMarkNumber(true, contactInfo.number);
            } else {
                OplusPhoneUtils.setNeedMarkNumber(false, null);
            }
            Message obtainMessage = this.mHandler.obtainMessage(1, call);
            this.mHandler.sendMessageDelayed(obtainMessage, getDelayForDisconnect(call));
            if (Log.sDebug) {
                Log.d(LOG_TAG, "updateCallInMap sendMessageDelayed msg = " + obtainMessage);
            }
            this.mPendingDisconnectCalls.add(call);
            this.mCallById.put(call.getId(), call);
            this.mCallByTelecommCall.put(call.getTelecommCall(), call);
            CastScreen.f19196a.a().c0((OplusCall) call);
        } else if (!isCallDead(call)) {
            this.mCallById.put(call.getId(), call);
            if (Log.sDebug) {
                Log.d(LOG_TAG, "mCallById add size = " + this.mCallById.size());
            }
            this.mCallByTelecommCall.put(call.getTelecommCall(), call);
            CastScreen.f19196a.a().c0((OplusCall) call);
        } else {
            if (!this.mCallById.containsKey(call.getId())) {
                return false;
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "updateCallInMap remove");
            }
            this.mCallById.remove(call.getId());
            CastScreen.f19196a.a().B((OplusCall) call);
            this.mCallByTelecommCall.remove(call.getTelecommCall());
            call.onDestroy();
            this.mCallUpdateListenerMap.remove(call.getId());
            if (this.mCallById.size() == 1 && (firstCallWithState = getFirstCallWithState(8)) != null && firstCallWithState.getFakeState() == 3) {
                firstCallWithState.setState(3);
                firstCallWithState.setState(0);
            }
            InCallPresenter.getInstance().realInstance().callBeRemoved();
        }
        return true;
    }

    public void updateCallTextMap(Call call, List<String> list) {
        com.google.common.base.k.o(call);
        if (!isCallDead(call)) {
            if (list != null) {
                this.mCallTextReponsesMap.put(call.getId(), list);
            }
        } else if (this.mCallById.containsKey(call.getId())) {
            this.mCallTextReponsesMap.remove(call.getId());
        }
    }

    public Call getCallWithState(int i10, int i11, int i12) {
        int i13 = 0;
        for (Call call : this.mCallById.values()) {
            PhoneAccountHandle accountHandle = call.getAccountHandle();
            try {
                if (call.getState() == i10 && (accountHandle == null || A2.d.d(accountHandle) == i12)) {
                    if (i13 >= i11) {
                        return call;
                    }
                    i13++;
                }
            } catch (NumberFormatException e10) {
                Log.w(this, "Sub Id is not a number " + e10);
            }
        }
        return null;
    }

    public int getCallSizeWithState(int i10, int i11, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        for (Call call : this.mCallById.values()) {
            PhoneAccountHandle accountHandle = call.getAccountHandle();
            try {
                if (call.getState() == i10) {
                    if (accountHandle != null && A2.d.d(accountHandle) != i11) {
                    }
                    i13++;
                    if (!call.isConferenceCall()) {
                        i12++;
                    }
                }
            } catch (NumberFormatException e10) {
                Log.w(this, "Sub Id is not a number " + e10);
            }
        }
        Log.d(LOG_TAG, "getCallSizeWithStateWithSubId: " + i10 + " sizeWithoutConf = " + i12 + " sizeWithConf = " + i13 + " withConference = " + z10);
        return z10 ? i13 : i12;
    }

    public boolean hasAnyLiveCall() {
        for (Call call : this.mCallById.values()) {
            if (!isCallDead(call)) {
                if (!Log.sDebug) {
                    return true;
                }
                Log.d(LOG_TAG, "hasAnyLiveCall call = " + call);
                return true;
            }
        }
        if (!Log.sDebug) {
            return false;
        }
        Log.d(LOG_TAG, "no active call ");
        return false;
    }

    /* loaded from: classes.dex */
    public interface CallUpdateListener {
        void onCallChanged(Call call);

        default void onChildNumberChange() {
        }

        default void onLastForwardedNumberChange() {
        }

        default void onSessionModificationStateChange(Call call, int i10) {
        }
    }

    /* loaded from: classes.dex */
    public class DialerCallListenerImpl implements F1.a {
        private final Call call;

        public DialerCallListenerImpl(Call call) {
            this.call = (Call) N1.a.e(call);
        }

        @Override // F1.a
        public /* bridge */ /* synthetic */ void onDialerCallChildNumberChange() {
            super.onDialerCallChildNumberChange();
        }

        @Override // F1.a
        public /* bridge */ /* synthetic */ void onDialerCallLastForwardedNumberChange() {
            super.onDialerCallLastForwardedNumberChange();
        }

        @Override // F1.a
        public void onDialerCallUpdate() {
            Trace.beginSection("CallList.onDialerCallUpdate");
            CallList.this.onUpdateCall(this.call);
            CallList.this.notifyGenericListeners();
            Trace.endSection();
        }

        @Override // F1.a
        public void onHandoverToWifiFailure() {
        }

        @Override // F1.a
        public void onInternationalCallOnWifi() {
        }

        @Override // F1.a
        public void onWiFiToLteHandover() {
        }
    }

    public void setSRVCCforCalls(boolean z10) {
    }
}
