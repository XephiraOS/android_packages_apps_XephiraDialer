package com.android.incallui;

import android.content.Context;
import android.telecom.Call;
import android.telecom.DisconnectCause;
import android.text.TextUtils;
import com.android.incallui.Call;
import com.android.incallui.CallCardPresenter;
import com.android.incallui.CallList;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallPresenter;
import com.android.incallui.InCallVideoCallCallbackNotifier;
import com.android.incallui.OplusInCallPresenter;
import com.android.oplus.brand.BrandCenter;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import m2.C1327a;

/* loaded from: classes.dex */
public class OplusCallCardPresenter extends CallCardPresenter implements InCallVideoCallCallbackNotifier.SessionModificationListener, CallList.CallUpdateListener {
    private static final int CALL_AND_CONTACT_MAX = 5;
    protected static final String LOG_TAG = "OplusCallCardPresenter";
    private static final int OPLUS_REJECT_VIDEO_CALL_DELAY_TIME = 2000;
    private static final int PRIMARY = 0;
    private static final int SECONDARY = 1;
    private Call[] mCalls;
    private Context mContext;
    private final U5.b mRealImpl = U5.a.a();

    public OplusCallCardPresenter() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "OplusCallCardPresenter...");
        }
        this.mCalls = new Call[5];
        A2.j.J().l(new CallCardPresenter.ContactLookupCallback(this, false));
    }

    private void addSessionListener(Call call, Call call2) {
        if (call2 != null) {
            if (!Call.areSame(call, call2) && call != null) {
                CallList.getInstance().removeCallUpdateListener(call.getId(), this);
            }
            CallList.getInstance().addCallUpdateListener(call2.getId(), this);
        }
    }

    private void clearUnusefulCallInfo(int i10) {
        if (i10 >= 4) {
            return;
        }
        while (i10 < 4) {
            this.mCalls[i10] = null;
            i10++;
        }
    }

    private String getCallStateLabelFromState(int i10, DisconnectCause disconnectCause) {
        String callStateLabelWhenVoLTEVoWifi;
        String string;
        Call incomingCall;
        String str = null;
        if (2 == i10) {
            return null;
        }
        if (3 == i10) {
            if (shouldDisplayDialingCallState()) {
                str = this.mContext.getString(R.string.oplus_card_title_dialing);
            }
            Call activeCall = CallList.getInstance().getActiveCall();
            if (activeCall != null && activeCall.getFakeState() == 1 && !activeCall.getIsFakeGuard()) {
                string = this.mContext.getString(R.string.oplus_card_title_answering);
            } else {
                return str;
            }
        } else {
            if (8 == i10) {
                return this.mContext.getString(R.string.card_title_on_hold);
            }
            if (6 != i10 && 13 != i10) {
                if (7 == i10) {
                    return this.mContext.getString(R.string.card_title_redialing);
                }
                if (4 != i10 && 5 != i10) {
                    if (9 == i10) {
                        return this.mContext.getString(R.string.oplus_card_title_hanging_up);
                    }
                    if (10 == i10) {
                        String callTime = getCallTime(this.mCalls[0]);
                        string = D2.b.e(this.mContext, disconnectCause, callTime);
                        if (callTime != null) {
                            string = string + "  " + callTime;
                        }
                    } else {
                        Log.w(LOG_TAG, "updateCallStateWidgets: unexpected call: " + i10);
                        return null;
                    }
                } else {
                    callStateLabelWhenVoLTEVoWifi = this.mContext.getString(R.string.card_title_incoming_call);
                    T5.a d10 = BrandCenter.f19187a.a().d();
                    if (d10 != null && (incomingCall = CallList.getInstance().getIncomingCall()) != null && ((OplusCall) incomingCall).isRttCall()) {
                        string = d10.G(this.mContext);
                    }
                    return callStateLabelWhenVoLTEVoWifi;
                }
            } else {
                callStateLabelWhenVoLTEVoWifi = OplusPhoneUtils.getCallStateLabelWhenVoLTEVoWifi(this.mContext);
                Call outgoingCall = CallList.getInstance().getOutgoingCall();
                if (outgoingCall != null && TextUtils.isEmpty(callStateLabelWhenVoLTEVoWifi)) {
                    callStateLabelWhenVoLTEVoWifi = outgoingCall.getCallStateString();
                }
                T5.a d11 = BrandCenter.f19187a.a().d();
                if (outgoingCall != null && d11 != null && ((OplusCall) outgoingCall).isRttCall()) {
                    callStateLabelWhenVoLTEVoWifi = d11.H(this.mContext);
                }
                if (TextUtils.isEmpty(callStateLabelWhenVoLTEVoWifi)) {
                    string = this.mContext.getString(R.string.oplus_card_title_dialing);
                }
                return callStateLabelWhenVoLTEVoWifi;
            }
        }
        return string;
    }

    private String getPrimaryCallStateLabel() {
        boolean z10 = false;
        Call call = this.mCalls[0];
        if (call == null) {
            return null;
        }
        int state = call.getState();
        DisconnectCause disconnectCause = call.getDisconnectCause();
        int sessionModificationState = call.getSessionModificationState();
        if (CallUtils.isVideoCall(call) && !CallUtils.isAudioCallRingtone(this.mContext, call)) {
            z10 = true;
        }
        boolean oplusGetIsCallForwarded = call.oplusGetIsCallForwarded();
        boolean isRing = Call.State.isRing(state);
        if (isRing && z10) {
            return this.mContext.getString(R.string.call_card_video_incoming_label);
        }
        if (isRing && oplusGetIsCallForwarded) {
            return this.mContext.getString(R.string.oplus_call_forward_info);
        }
        if (sessionModificationState == 1) {
            return this.mContext.getString(R.string.oplus_waiting_video_call);
        }
        return getCallStateLabelFromState(state, disconnectCause);
    }

    private String getSecondaryCallStateLabelFromState() {
        Call call = this.mCalls[1];
        if (call == null) {
            return "";
        }
        int state = call.getState();
        if (2 != state) {
            if (3 == state) {
                String string = this.mContext.getString(R.string.card_title_in_call);
                if (call.getFakeState() == 1 && !call.getIsFakeGuard()) {
                    return this.mContext.getString(R.string.oplus_card_title_answering);
                }
                return string;
            }
            if (8 == state) {
                return this.mContext.getString(R.string.card_title_on_hold);
            }
            if (6 != state && 13 != state) {
                if (7 == state) {
                    return this.mContext.getString(R.string.card_title_redialing);
                }
                if (4 != state && 5 != state) {
                    if (9 == state) {
                        return this.mContext.getString(R.string.oplus_card_title_hanging_up);
                    }
                    if (10 == state) {
                        String callTime = getCallTime(this.mCalls[1]);
                        String e10 = D2.b.e(this.mContext, call.getDisconnectCause(), callTime);
                        if (callTime != null) {
                            e10 = e10 + "  " + callTime;
                        }
                        return e10;
                    }
                    Log.w(LOG_TAG, "updateCallStateWidgets: unexpected call: " + state);
                } else {
                    return this.mContext.getString(R.string.card_title_incoming_call);
                }
            } else {
                return this.mContext.getString(R.string.oplus_card_title_dialing);
            }
        }
        return null;
    }

    private boolean getSwapToSecondaryButtonState() {
        Call[] callArr = this.mCalls;
        if (callArr[1] != null) {
            return true;
        }
        if (isConference(callArr[0]) && CallList.getInstance().oplusCallList().isCdmaPhoneActive()) {
            return true;
        }
        return false;
    }

    private static boolean isConference(Call call) {
        if (call != null && !call.showSingleParty() && call.isConferenceCall()) {
            return true;
        }
        return false;
    }

    private boolean isConferenceSRVCC() {
        Call call = this.mCalls[0];
        if (call == null || isConference(call) || !this.mCalls[0].getHasSRVCC() || CallList.getInstance().getCallSizeWithState(3, true) <= 1) {
            return false;
        }
        Log.d(LOG_TAG, "for conference call with SRVCC, no need update for child call");
        return true;
    }

    private void setDisplayCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        Call outgoingCall;
        int i10;
        Call call;
        if (callList == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "callList is null, return");
                return;
            }
            return;
        }
        OplusCallList oplusCallList = callList.oplusCallList();
        InCallPresenter.InCallState inCallState3 = InCallPresenter.InCallState.INCOMING;
        Call call2 = null;
        if (inCallState2 != inCallState3 && inCallState2 != InCallPresenter.InCallState.PENDING_OUTGOING && inCallState2 != InCallPresenter.InCallState.OUTGOING && inCallState2 != InCallPresenter.InCallState.INCALL) {
            i10 = 0;
            call = null;
        } else {
            if (inCallState2 == inCallState3) {
                outgoingCall = oplusCallList.oplusGetIncomingCall();
            } else if (inCallState2 != InCallPresenter.InCallState.PENDING_OUTGOING && inCallState2 != InCallPresenter.InCallState.OUTGOING) {
                outgoingCall = D2.b.g(callList, null, null, null, false);
            } else {
                outgoingCall = callList.getOutgoingCall();
                if (outgoingCall == null) {
                    outgoingCall = callList.getPendingOutgoingCall();
                }
            }
            int oplusGetCallSize = callList.oplusCallList().oplusGetCallSize();
            if (outgoingCall != null) {
                if (oplusGetCallSize > 1) {
                    call2 = D2.b.g(callList, outgoingCall, null, null, true);
                }
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (call2 != null) {
                i10++;
            }
            Call call3 = call2;
            call2 = outgoingCall;
            call = call3;
        }
        Call[] callArr = this.mCalls;
        callArr[0] = call2;
        callArr[1] = call;
        if (Log.sDebug) {
            D2.g.d(LOG_TAG, "getAvailableCall primary = " + call2 + ",  secondary = " + call);
        }
        clearUnusefulCallInfo(i10);
    }

    private void updateSecondaryDisplayInfo() {
        Log.d(LOG_TAG, "updateSecondaryDisplayInfo: ");
        D2.b.x(this.mContext, this.mCalls[1], getUi(), getSecondaryCallStateLabelFromState());
    }

    public String getCallTime(Call call) {
        return D2.b.d(this.mContext, call);
    }

    public Call getPrimaryCall() {
        Call call = this.mCalls[0];
        if (call == null) {
            call = null;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getPrimaryCall = " + call);
        }
        return call;
    }

    public long getPrimaryContactID() {
        ContactInfoCache.ContactCacheEntry contactCacheEntry;
        long j10;
        Call call = this.mCalls[0];
        if (call != null) {
            contactCacheEntry = call.getContactInfo();
        } else {
            contactCacheEntry = null;
        }
        if (contactCacheEntry != null) {
            j10 = contactCacheEntry.person_id;
        } else {
            j10 = -1;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "getPrimaryContactID = " + j10);
        }
        return j10;
    }

    @Override // com.android.incallui.CallCardPresenter
    public void init(Context context, Call call) {
        this.mContext = context;
    }

    public boolean isNeedShowSecondaryIcon(Call call, Call call2) {
        if (call == null || call2 == null || call.getSlotId() == call2.getSlotId()) {
            return false;
        }
        return true;
    }

    public boolean isOnlyCDMADialingNow() {
        Call primaryCall = getPrimaryCall();
        if (primaryCall != null && 1 == ((OplusCallList) CallList.getInstance()).oplusGetCallSize() && CallList.getInstance().isCDMADialingCall(primaryCall)) {
            return true;
        }
        return false;
    }

    public boolean isPrimaryCallIsCdmaActive() {
        OplusCall oplusCall = (OplusCall) getPrimaryCall();
        if (oplusCall != null && oplusCall.getIsCdmaPhone() && !CallList.getInstance().isCDMADialingCall(oplusCall)) {
            return true;
        }
        return false;
    }

    @Override // com.android.incallui.CallCardPresenter
    public void manageConferenceButtonClicked() {
        if (InCallPresenter.getInstance() != null && InCallPresenter.getInstance().getVideoCallPresenter() != null) {
            InCallPresenter.getInstance().getVideoCallPresenter().toggleFullScreen();
        }
        getUi().displayManageConferencePanel(true);
    }

    @Override // com.android.incallui.CallCardPresenter
    public void onContactInfoComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry, boolean z10) {
        if (contactCacheEntry == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Contact found: entry is null");
                return;
            }
            return;
        }
        contactCacheEntry.callId = str;
        Call call = this.mCalls[0];
        if (call != null && call.getId().equals(str)) {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onContactInfoComplete:callId = " + str + ",isPrimary=" + z10 + ", entry.name = " + D2.g.o(contactCacheEntry.name));
        }
        updateContactEntry(contactCacheEntry, z10);
    }

    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
        if (call == this.mCalls[0]) {
            updatePrimaryCallState();
        }
    }

    @Override // com.android.incallui.CallCardPresenter
    public void onImageLoadComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        if (getUi() == null) {
            return;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onImageLoadComplete... callId = " + str);
        }
        if (contactCacheEntry != null && contactCacheEntry.photo != null && str != null) {
            Call call = this.mCalls[0];
            if (call != null && str.equals(call.getId())) {
                updateContactEntry(contactCacheEntry, true);
                return;
            }
            Call call2 = this.mCalls[1];
            if (call2 != null && str.equals(call2.getId())) {
                updateContactEntry(contactCacheEntry, false);
            }
        }
    }

    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        onStateChange(inCallState, inCallState2, CallList.getInstance());
    }

    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.CallList.CallUpdateListener
    public void onSessionModificationStateChange(Call call, int i10) {
        Log.d(this, "onSessionModificationStateChange : sessionModificationState = " + i10 + " call:" + call);
        if (call != this.mCalls[0]) {
            return;
        }
        updatePrimaryCallState();
    }

    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onStateChange oldState = " + inCallState + "  newState = " + inCallState2);
        }
        CallCardPresenter.CallCardUi ui = getUi();
        if (ui == null) {
            return;
        }
        if (callList != null && !callList.oplusCallList().allConferenceChildCallDisconnected()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "onStateChange ConferenceCall not hangup all return...");
                return;
            }
            return;
        }
        Call[] callArr = this.mCalls;
        Call call = callArr[0];
        Call call2 = callArr[1];
        setDisplayCall(inCallState, inCallState2, callList);
        addSessionListener(call, this.mCalls[0]);
        boolean z10 = !Call.areSame(call, this.mCalls[0]);
        boolean z11 = !Call.areSame(call2, this.mCalls[1]);
        Log.d(LOG_TAG, "onStateChange: primaryChanged=" + z10 + ", secondaryChanged=" + z11);
        if (z10) {
            updatePrimaryDisplayInfo();
        } else {
            Call call3 = this.mCalls[0];
            if (call3 != null && call3.mIsUpdateSinglePartyUI) {
                call3.mIsUpdateSinglePartyUI = false;
                updatePrimaryDisplayInfo();
            }
        }
        if (OplusPhoneUtils.isUstOplusExport()) {
            OplusCall oplusCall = (OplusCall) getPrimaryCall();
            if (inCallState == InCallPresenter.InCallState.INCOMING && oplusCall != null && oplusCall.hasVerstatVerificationStatus()) {
                updatePrimaryDisplayInfo();
            }
        }
        if (z11) {
            updateSecondaryDisplayInfo();
        }
        Call[] callArr2 = this.mCalls;
        if (callArr2[0] != null && callArr2[1] == null) {
            ui.showLocationUi();
        }
        if (this.mCalls[1] != null) {
            updateSecondaryCallState();
        }
        if (this.mCalls[0] != null) {
            updatePrimaryCallState();
        }
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoFail(int i10, Call call) {
        String string;
        if (getUi() == null) {
            return;
        }
        if (i10 == 100) {
            string = this.mContext.getResources().getString(R.string.incall_request_video_remote_not_support);
        } else if (i10 == 4) {
            string = this.mContext.getResources().getString(R.string.oplus_request_video_call_timeout);
        } else if (i10 == 5) {
            string = this.mContext.getResources().getString(R.string.incall_request_video_remote_reject);
        } else {
            string = this.mContext.getResources().getString(R.string.incall_request_video_remote_not_support);
        }
        getUi().updateCallStatusPrompt(string, COUIScrollBar.SCROLLER_FADE_TIMEOUT);
    }

    public boolean primaryCallIsActive() {
        boolean z10 = false;
        Call call = this.mCalls[0];
        if (call != null && (call.getState() == 3 || call.getState() == 8)) {
            z10 = true;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "primaryCallIsActive = " + z10);
        }
        return z10;
    }

    public boolean primaryCallIsDialing() {
        boolean z10;
        Call primaryCall = getPrimaryCall();
        if (primaryCall != null && ((Call.State.isConnectingOrDialing(primaryCall.getState()) || CallList.getInstance().oplusCallList().isCDMADialingCall(primaryCall)) && !Call.State.isDisconnectingOrDisconnected(primaryCall.getState()))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "primaryCallIsDialing = " + z10);
        }
        return z10;
    }

    public boolean primaryCallIsRinging() {
        boolean z10;
        Call primaryCall = getPrimaryCall();
        if (primaryCall != null && Call.State.isRing(primaryCall.getState())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "primaryCallIsRinging = " + z10);
        }
        return z10;
    }

    @Override // com.android.incallui.CallCardPresenter
    public void secondaryInfoClicked() {
        Call call;
        Call[] callArr = this.mCalls;
        if (callArr[1] != null && (call = callArr[0]) != null) {
            if (OplusPhoneUtils.sIsInEmergencyCall) {
                Log.d(LOG_TAG, "Secondary info clicked but in emergency call.");
                return;
            }
            if (call.getState() == 3 && this.mCalls[1].getState() == 8) {
                OplusCallList oplusCallList = CallList.getInstance().oplusCallList();
                if (this.mCalls[0].isConferenceCall() && oplusCallList.isCdmaPhoneActive()) {
                    oplusCallList.swapCdmaCall();
                    return;
                }
                Log.d(LOG_TAG, "Swapping call to foreground: " + this.mCalls[1]);
                TelecomAdapter.getInstance().unholdCall(this.mCalls[1].getId());
                return;
            }
            InCallPresenter.getInstance().realInstance().showErrorMessageForPendingCallAction(OplusInCallPresenter.SuppService.SWITCH);
            return;
        }
        Log.d(LOG_TAG, "Secondary info clicked but call is null.");
    }

    public boolean shouldDisplayDialingCallState() {
        if (!OplusPhoneUtils.isCDMATelecomCustomize() && isOnlyCDMADialingNow()) {
            return true;
        }
        return false;
    }

    public void updateContactEntry(ContactInfoCache.ContactCacheEntry contactCacheEntry, boolean z10) {
        if (z10) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "updateContactEntry for conference");
            }
            updatePrimaryDisplayInfo();
            return;
        }
        updateSecondaryDisplayInfo();
    }

    @Override // com.android.incallui.CallCardPresenter
    public void updatePrimaryCallState() {
        boolean z10;
        boolean z11;
        Log.d(LOG_TAG, "updatePrimaryCallState: ");
        if (getUi() == null) {
            return;
        }
        C1327a c1327a = new C1327a();
        Call call = this.mCalls[0];
        if (call != null) {
            if (call.getState() == 3 && ((call.getFakeState() == 0 || call.getIsFakeGuard()) && call.getConnectTimeMillis() != 0 && (OplusPhoneUtils.isCDMATelecomCustomize() || !call.isCdmaDialing()))) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                A2.c.d().h();
            }
            boolean isVideoCall = CallUtils.isVideoCall(call);
            boolean oplusGetIsCallForwarded = call.oplusGetIsCallForwarded();
            boolean isConference = isConference(call);
            String primaryCallStateLabel = getPrimaryCallStateLabel();
            if (z10 && call.getSessionModificationState() == 1) {
                z10 = false;
            }
            if (isConference) {
                z11 = OplusPhoneUtils.isShowConferenceManageButton(call);
            } else {
                z11 = false;
            }
            c1327a.r(call.getState());
            c1327a.o(primaryCallStateLabel);
            c1327a.q(OplusPhoneUtils.getAudioQualityDrawableId(this.mContext, call, false));
            c1327a.n(call.getConnectTimeMillis());
            c1327a.m(isConference);
            c1327a.k(z11);
            c1327a.u(isVideoCall);
            c1327a.t(z10);
            c1327a.p(oplusGetIsCallForwarded);
            c1327a.l(call.getChildCallIds().size());
            c1327a.s(getSwapToSecondaryButtonState());
        }
        getUi().setCallState(c1327a);
    }

    public void updatePrimaryDisplayInfo() {
        Log.d(LOG_TAG, "updatePrimaryDisplayInfo : ");
        if (isConferenceSRVCC()) {
            return;
        }
        CallCardPresenter.CallCardUi ui = getUi();
        if (ui == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "updatePrimaryDisplayInfo called but ui is null!");
            }
        } else {
            if (isConference(this.mCalls[0])) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "conference calle just display title");
                }
                TelecomAdapter.getInstance().oplusTelecomAdapter().dealWithParentChanged();
            }
            D2.b.w(this.mContext, this.mCalls[0], ui);
        }
    }

    public void updateSecondaryCallState() {
        Log.d(LOG_TAG, "updateSecondaryCallState: ");
        if (getUi() != null && this.mCalls[1] != null) {
            getUi().setSecondaryConnectionLabel(getSecondaryCallStateLabelFromState());
            CallCardPresenter.CallCardUi ui = getUi();
            Call[] callArr = this.mCalls;
            ui.updateSecondaryIcon(isNeedShowSecondaryIcon(callArr[0], callArr[1]));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.Presenter
    public void onUiReady(CallCardPresenter.CallCardUi callCardUi) {
        super.onUiReady(callCardUi);
        onStateChange(null, InCallPresenter.getInstance().getInCallState(), CallList.getInstance());
        InCallVideoCallCallbackNotifier.getInstance().addSessionModificationListener(this);
        callCardUi.showLocationUi();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.Presenter
    public void onUiUnready(CallCardPresenter.CallCardUi callCardUi) {
        super.onUiUnready(callCardUi);
        for (int i10 = 0; i10 < 5; i10++) {
            this.mCalls[i10] = null;
        }
        if (InCallVideoCallCallbackNotifier.getInstance() != null) {
            InCallVideoCallCallbackNotifier.getInstance().removeSessionModificationListener(this);
        }
        U5.b bVar = this.mRealImpl;
        if (bVar != null) {
            bVar.clear();
        }
    }

    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.CallList.CallUpdateListener
    public void onCallChanged(Call call) {
    }

    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.CallList.CallUpdateListener
    public void onChildNumberChange() {
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onDowngradeToAudio(Call call) {
    }

    @Override // com.android.incallui.CallCardPresenter, com.android.incallui.CallList.CallUpdateListener
    public void onLastForwardedNumberChange() {
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoSuccess(Call call) {
    }

    @Override // com.android.incallui.InCallVideoCallCallbackNotifier.SessionModificationListener
    public void onUpgradeToVideoRequest(Call call, int i10) {
    }
}
