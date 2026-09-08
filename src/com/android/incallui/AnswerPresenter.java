package com.android.incallui;

import android.content.Context;
import android.text.TextUtils;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallPresenter;
import com.internal_dependency.SettingsUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AnswerPresenter extends Presenter<AnswerUi> implements CallList.CallUpdateListener, InCallPresenter.InCallUiListener, InCallPresenter.IncomingCallListener, CallList.Listener, CallList.ActiveSubChangeListener {
    private static final String TAG = "AnswerPresenter";
    private final int INVALID_PHONE_INDEX;
    public com.android.incallui.mvvm.utils.h<Boolean> mIsShowDeclineAndInterceptIcon;
    public com.android.incallui.mvvm.utils.h<Boolean> mIsVideoCall;
    public com.android.incallui.mvvm.utils.h<Boolean> mIsVoWifiCall;
    protected ContactInfoCache.ContactCacheEntry mPrimaryContactInfo;
    public com.android.incallui.mvvm.utils.h<Boolean> mUiIsShowing;
    private String[] mCallId = new String[InCallServiceImpl.sPhoneCount];
    private final CallList mCalls = CallList.getInstance();
    private boolean mHasTextMessages = false;
    protected Call[] mCall = new Call[InCallServiceImpl.sPhoneCount];
    private boolean mHasSentBroadcastForSideOption = false;

    /* loaded from: classes.dex */
    public interface AnswerUi extends Ui {
        void configureMessageDialog(List<String> list);

        Context getContext();

        void onShowAnswerUi(boolean z10);

        void refreshAlertDialog();

        @Override // com.android.incallui.Ui
        void setVisible(boolean z10);

        void showMessageDialog();

        void showTargets(int i10);

        void updateSideWaveView(boolean z10, ContactInfoCache.ContactCacheEntry contactCacheEntry);
    }

    public AnswerPresenter() {
        Boolean bool = Boolean.FALSE;
        this.mUiIsShowing = new com.android.incallui.mvvm.utils.h<>(bool, false);
        this.mIsVideoCall = new com.android.incallui.mvvm.utils.h<>(bool, false);
        this.mIsVoWifiCall = new com.android.incallui.mvvm.utils.h<>(bool, false);
        this.mIsShowDeclineAndInterceptIcon = new com.android.incallui.mvvm.utils.h<>(bool, false);
        this.INVALID_PHONE_INDEX = -1;
    }

    private void configureAnswerTargetsForSms(Call call, List<String> list) {
        boolean z10;
        boolean z11;
        if (getUi() == null) {
            return;
        }
        if (list != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mHasTextMessages = z10;
        if (call.can(32) && this.mHasTextMessages) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (call.isVideoCall()) {
            if (z11) {
                getUi().showTargets(QtiCallUtils.getIncomingCallAnswerOptions(getUi().getContext(), z11));
                getUi().configureMessageDialog(list);
                return;
            } else {
                getUi().showTargets(QtiCallUtils.getIncomingCallAnswerOptions(getUi().getContext(), z11));
                return;
            }
        }
        if (isCallDeflectSupported()) {
            if (z11) {
                getUi().showTargets(1008);
                getUi().configureMessageDialog(list);
                return;
            } else {
                getUi().showTargets(1007);
                return;
            }
        }
        if (z11) {
            getUi().showTargets(1);
            getUi().configureMessageDialog(list);
        } else {
            getUi().showTargets(0);
        }
    }

    private boolean isOutOfBounds(int i10) {
        if (i10 >= 0 && i10 < InCallServiceImpl.sPhoneCount) {
            return false;
        }
        return true;
    }

    private boolean isVideoUpgradePending(Call call) {
        if (call.getSessionModificationState() == 3) {
            return true;
        }
        return false;
    }

    private void notifyAnswerRepositoryForCallStateChanged(Call call) {
        boolean z10;
        com.android.incallui.mvvm.utils.h<Boolean> hVar = this.mIsVideoCall;
        if (CallUtils.isVideoCall(call) && !CallUtils.isAudioCallRingtone(OplusInCallApp.getAppContext(), call)) {
            z10 = true;
        } else {
            z10 = false;
        }
        hVar.o(Boolean.valueOf(z10));
        this.mIsVoWifiCall.o(Boolean.valueOf(OplusPhoneUtils.changeToVowifiIcon(call, CallList.getInstance().getActiveSubId())));
    }

    private void processIncomingCall(Call call) {
        int subId = call.getSubId();
        int phoneId = this.mCalls.getPhoneId(subId);
        Log.d(TAG, "processIncomingCall... " + call + ", subId = " + subId + ", phoneId = " + phoneId);
        if (phoneId == -1) {
            return;
        }
        int i10 = 0;
        while (true) {
            Call[] callArr = this.mCall;
            if (i10 >= callArr.length) {
                break;
            }
            callArr[i10] = null;
            i10++;
        }
        String str = this.mCallId[phoneId];
        if (!TextUtils.isEmpty(str)) {
            this.mCalls.removeCallUpdateListener(str, this);
        }
        this.mCallId[phoneId] = call.getId();
        this.mCall[phoneId] = call;
        this.mCalls.addListener(this);
        this.mCalls.addCallUpdateListener(this.mCallId[phoneId], this);
        OplusInCallPresenter oplusInCallPresenter = (OplusInCallPresenter) InCallPresenter.getInstance();
        if (this.mCall != null && oplusInCallPresenter != null && oplusInCallPresenter.getActivity() != null) {
            this.mPrimaryContactInfo = call.getContactInfo();
        }
        Log.d(TAG, "Showing incoming for call id: " + this.mCallId[phoneId]);
        notifyAnswerRepositoryForCallStateChanged(call);
        if (showAnswerUi(true)) {
            configureAnswerTargetsForSms(call, this.mCalls.getTextResponses(call.getId()));
        }
    }

    private void processVideoUpgradeRequestCall(Call call) {
        Log.d(this, " processVideoUpgradeRequestCall call=" + call);
        int phoneId = this.mCalls.getPhoneId(call.getSubId());
        this.mCallId[phoneId] = call.getId();
        this.mCall[phoneId] = call;
        CallList.getInstance().addCallUpdateListener(this.mCallId[phoneId], this);
        if (call.getVideoState() == call.getModifyToVideoState()) {
            Log.w(this, "processVideoUpgradeRequestCall: Video states are same. Return.");
        } else {
            OplusPhoneUserActionStatistics.onCommon(OplusInCallApp.getAppContext(), OplusPhoneUserActionStatistics.TAG_VIDEO_CALL, OplusPhoneUserActionStatistics.VIDEO_RECEIVE_VIDEO_REQUEST_WHEN_CALL, (Map) null);
            InCallPresenter.getInstance().realInstance().showVideoUpgradeRequestDialog();
        }
    }

    public int getActivePhoneId() {
        Call[] mCall = getMCall();
        for (int i10 = 0; i10 < mCall.length; i10++) {
            Log.d(TAG, "getActive Id: call " + mCall[i10] + " " + i10);
            if (mCall[i10] != null) {
                return i10;
            }
        }
        return -1;
    }

    public Call getCall() {
        int activePhoneId = getActivePhoneId();
        if (activePhoneId == -1) {
            if (Log.sDebug) {
                Log.d(TAG, "INVALID_PHONE_INDEX ");
                return null;
            }
            return null;
        }
        return this.mCall[activePhoneId];
    }

    public String getCallNumber() {
        Call call = getCall();
        if (call == null) {
            Log.d(this, "mCall is null");
            return null;
        }
        Log.d(this, "mCall is number" + D2.g.l(call.getNumber()));
        return call.getNumber();
    }

    public Call[] getMCall() {
        return this.mCall;
    }

    public boolean isCallDeflectSupported() {
        if (getUi() == null || SettingsUtils.INSTANCE.getGlobalSettingsInt(getUi().getContext().getContentResolver(), "qti.ims.call_deflect", 0) != 1) {
            return false;
        }
        return true;
    }

    public void merge(String str) {
        if (!TextUtils.isEmpty(str)) {
            TelecomAdapter.getInstance().merge(str);
        }
    }

    public void notifyAnswerRepositoryForVisibilityChanged() {
        if (getUi() != null) {
            this.mIsShowDeclineAndInterceptIcon.o(Boolean.valueOf(D2.f.F(getUi().getContext(), CallList.getInstance().getIncomingCall())));
        }
    }

    @Override // com.android.incallui.CallList.ActiveSubChangeListener
    public void onActiveSubChanged(int i10) {
        Call incomingCall = this.mCalls.getIncomingCall();
        int phoneId = CallList.getInstance().getPhoneId(i10);
        if (incomingCall != null && incomingCall.getId() == this.mCallId[phoneId]) {
            Log.d(this, "Show incoming for call id: " + this.mCallId[phoneId] + " " + this);
            if (showAnswerUi(true)) {
                configureAnswerTargetsForSms(incomingCall, this.mCalls.getTextResponses(incomingCall.getId()));
                return;
            }
            return;
        }
        if (incomingCall == null && this.mCalls.hasAnyLiveCall(i10)) {
            Log.d(this, "Hide incoming for call id: " + this.mCallId[phoneId] + " " + this);
            showAnswerUi(false);
            return;
        }
        Log.d(this, "No incoming call present for sub = " + i10 + " " + this);
    }

    public void onAnswer(int i10, Context context) {
        int activePhoneId = getActivePhoneId();
        D2.g.g(TAG, "onAnswer  mCallId:" + Arrays.toString(this.mCallId) + " phoneId = " + activePhoneId);
        if (this.mCallId != null && activePhoneId != -1) {
            if (this.mCall[activePhoneId].getSessionModificationState() == 3) {
                InCallPresenter.getInstance().acceptUpgradeRequest(i10, context);
            } else {
                TelecomAdapter.getInstance().answerCall(this.mCall[activePhoneId].getId(), i10);
            }
        }
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onCallChanged(Call call) {
        List<String> textResponses;
        boolean z10;
        Log.d(this, "onCallStateChange() " + call);
        if (call.getState() == 4 && getUi() != null) {
            notifyAnswerRepositoryForCallStateChanged(call);
        }
        if (call.getState() != 4) {
            boolean isVideoUpgradePending = isVideoUpgradePending(call);
            int phoneId = this.mCalls.getPhoneId(call.getSubId());
            if (!isVideoUpgradePending && ((phoneId == 0 || phoneId == 1) && call.getId() != null && call.getId().equals(this.mCallId[phoneId]))) {
                this.mCalls.removeCallUpdateListener(this.mCallId[phoneId], this);
            }
            if (this.mCalls.getIncomingCall() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            showAnswerUi(z10);
            if ((phoneId == 0 || phoneId == 1) && call.getId() != null && call.getId().equals(this.mCallId[phoneId])) {
                this.mCallId[phoneId] = null;
            }
            this.mHasTextMessages = false;
            return;
        }
        if (!this.mHasTextMessages && (textResponses = this.mCalls.getTextResponses(call.getId())) != null) {
            configureAnswerTargetsForSms(call, textResponses);
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onCallListChange(CallList callList) {
        if (callList == null) {
            return;
        }
        if (getUi() != null) {
            getUi().refreshAlertDialog();
        }
        if (callList.getIncomingCall() == null) {
            Log.d(this, "onCallListChange, sendBroadcastIncomingCallStop");
            OplusPhoneUtils.sendBroadcastIncomingCallStop(OplusInCallApp.getAppContext());
            this.mHasSentBroadcastForSideOption = false;
        }
    }

    public void onContactInfoComplete(ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        if (this.mUiIsShowing.getValue().booleanValue()) {
            if (getUi() != null) {
                getUi().updateSideWaveView(true, contactCacheEntry);
            }
            if (!this.mHasSentBroadcastForSideOption && CallList.getInstance().getActiveOrBackgroundCall() == null && OplusPhoneUtils.needShowSideWaveView(OplusInCallApp.getAppContext()) && !OplusPhoneUtils.isScreenOn(OplusInCallApp.getAppContext())) {
                Log.d(this, "onContactInfoComplete, sendBroadcastIncomingCallStart");
                OplusPhoneUtils.sendBroadcastIncomingCallStart(OplusInCallApp.getAppContext());
                this.mHasSentBroadcastForSideOption = true;
                return;
            }
            return;
        }
        Log.d(this, "onContactInfoComplete: answer ui is not showing, return.");
    }

    public void onDeclineWithSms(Context context, String str) {
        int activePhoneId = getActivePhoneId();
        D2.g.j(TAG, "onDecline mCallId:" + Arrays.toString(this.mCallId));
        if (isOutOfBounds(activePhoneId)) {
            return;
        }
        if (this.mCall[activePhoneId].getSessionModificationState() == 3) {
            InCallPresenter.getInstance().declineUpgradeRequest(context);
        } else {
            TelecomAdapter.getInstance().rejectCall(this.mCall[activePhoneId].getId(), !TextUtils.isEmpty(str), str);
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onDisconnect(Call call) {
        int phoneId = this.mCalls.getPhoneId(call.getSubId());
        if (call.equals(this.mCall[phoneId])) {
            this.mCall[phoneId] = null;
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onIncomingCall(Call call) {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onSessionModificationStateChange(Call call, int i10) {
        if (i10 != 3) {
            for (int i11 = 0; i11 < InCallServiceImpl.sPhoneCount; i11++) {
                String str = this.mCallId[i11];
                if (str != null) {
                    this.mCalls.removeCallUpdateListener(str, this);
                }
            }
            if (InCallPresenter.getInstance().getInCallState() != InCallPresenter.InCallState.INCOMING) {
                showAnswerUi(false);
            }
        }
    }

    @Override // com.android.incallui.InCallPresenter.InCallUiListener
    public void onUiShowing(boolean z10) {
        Call incomingCall;
        if (z10) {
            this.mCalls.addListener(this);
            this.mCalls.addActiveSubChangeListener(this);
            boolean z11 = false;
            for (int i10 = 0; i10 < InCallServiceImpl.sPhoneCount; i10++) {
                int subId = this.mCalls.getSubId(i10);
                if (subId != -1) {
                    Call callWithState = this.mCalls.getCallWithState(4, 0, subId);
                    if (callWithState == null) {
                        callWithState = this.mCalls.getCallWithState(5, 0, subId);
                    }
                    if (callWithState != null) {
                        processIncomingCall(callWithState);
                        z11 = true;
                    }
                } else {
                    Log.d(TAG, "No valid sub");
                }
            }
            if (!z11 && (incomingCall = this.mCalls.getIncomingCall()) != null) {
                processIncomingCall(incomingCall);
            }
            Call videoUpgradeRequestCall = this.mCalls.getVideoUpgradeRequestCall();
            Log.d(this, "getVideoUpgradeRequestCall call =" + videoUpgradeRequestCall);
            if (videoUpgradeRequestCall != null && !Call.State.isDisconnectingOrDisconnected(videoUpgradeRequestCall.getState())) {
                processVideoUpgradeRequestCall(videoUpgradeRequestCall);
                return;
            }
            return;
        }
        this.mCalls.removeListener(this);
        for (int i11 = 0; i11 < InCallServiceImpl.sPhoneCount; i11++) {
            int subId2 = this.mCalls.getSubId(i11);
            if (subId2 != -1) {
                Call callWithState2 = this.mCalls.getCallWithState(4, 0, subId2);
                if (callWithState2 == null) {
                    callWithState2 = this.mCalls.getCallWithState(5, 0, subId2);
                }
                if (callWithState2 == null) {
                    callWithState2 = this.mCalls.getCallWithState(3, 0, subId2);
                }
                String str = this.mCallId[i11];
                if (str != null && callWithState2 == null) {
                    this.mCalls.removeCallUpdateListener(str, this);
                }
            } else {
                Log.d(TAG, "No valid sub");
            }
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onUpgradeToVideo(Call call) {
        Log.d(this, "onUpgradeToVideo: " + this + " call=" + call);
        boolean isVideoUpgradePending = isVideoUpgradePending(call);
        InCallPresenter inCallPresenter = InCallPresenter.getInstance();
        if (isVideoUpgradePending && inCallPresenter.getInCallState() == InCallPresenter.InCallState.INCOMING) {
            Log.d(this, "declining upgrade request");
            if (getUi() != null) {
                inCallPresenter.declineUpgradeRequest(getUi().getContext());
                return;
            }
            return;
        }
        if (isVideoUpgradePending) {
            Log.d(this, "process upgrade request as no MT call");
            processVideoUpgradeRequestCall(call);
        }
    }

    public void setScreenLocked(boolean z10) {
        ContactInfoCache.ContactCacheEntry contactInfo;
        Call call = getCall();
        Log.i(this, "setScreenLocked  isLocked:" + z10);
        if (call != null && (contactInfo = call.getContactInfo()) != null) {
            contactInfo.isLocked = z10;
            if (Log.sDebug) {
                Log.d(this, "setScreenLocked  info.isLocked = " + contactInfo.isLocked);
            }
        }
    }

    public boolean showAnswerUi(boolean z10) {
        Log.d(TAG, "showAnswerUi mUiIsShowing = " + this.mUiIsShowing.getValue() + " show = " + z10);
        if (this.mUiIsShowing.getValue().booleanValue() == z10 || InCallPresenter.getInstance().getActivity() == null) {
            return false;
        }
        if (getUi() != null) {
            this.mUiIsShowing.o(Boolean.valueOf(z10));
            getUi().onShowAnswerUi(z10);
            return true;
        }
        return true;
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        int phoneId = this.mCalls.getPhoneId(call.getSubId());
        Log.d(this, "onIncomingCall: " + this);
        if (this.mCalls.getVideoUpgradeRequestCall() != null) {
            showAnswerUi(false);
            Log.d(this, "declining upgrade request id: ");
            this.mCalls.removeCallUpdateListener(this.mCallId[phoneId], this);
            InCallPresenter.getInstance().declineUpgradeRequest();
        }
        if (call.getId().equals(this.mCallId[phoneId])) {
            return;
        }
        processIncomingCall(call);
        if (CallList.getInstance().getActiveOrBackgroundCall() == null && OplusPhoneUtils.needShowSideWaveView(OplusInCallApp.getAppContext()) && !OplusPhoneUtils.isScreenOn(OplusInCallApp.getAppContext())) {
            Log.d(this, "onIncomingCall, sendBroadcastIncomingCallStart");
            OplusPhoneUtils.sendBroadcastIncomingCallStart(OplusInCallApp.getAppContext());
            this.mHasSentBroadcastForSideOption = true;
        }
    }

    @Override // com.android.incallui.Presenter
    public void onUiReady(AnswerUi answerUi) {
        Call incomingCall;
        Log.d(this, "onUiReady ui=" + answerUi);
        super.onUiReady((AnswerPresenter) answerUi);
        this.mUiIsShowing.o(Boolean.FALSE);
        CallList callList = CallList.getInstance();
        Call videoUpgradeRequestCall = callList.getVideoUpgradeRequestCall();
        Log.d(this, "getVideoUpgradeRequestCall call =" + videoUpgradeRequestCall);
        if (videoUpgradeRequestCall != null && callList.getIncomingCall() == null) {
            processVideoUpgradeRequestCall(videoUpgradeRequestCall);
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < InCallServiceImpl.sPhoneCount; i10++) {
            int subId = CallList.getInstance().getSubId(i10);
            Call callWithState = callList.getCallWithState(4, 0, subId);
            if (callWithState == null) {
                callWithState = callList.getCallWithState(5, 0, subId);
            }
            if (callWithState != null) {
                processIncomingCall(callWithState);
                z10 = true;
            }
        }
        if (!z10 && (incomingCall = callList.getIncomingCall()) != null) {
            processIncomingCall(incomingCall);
        }
        callList.addListener(this);
        CallList.getInstance().addActiveSubChangeListener(this);
    }

    @Override // com.android.incallui.Presenter
    public void onUiUnready(AnswerUi answerUi) {
        super.onUiUnready((AnswerPresenter) answerUi);
        CallList.getInstance().removeListener(this);
        for (int i10 = 0; i10 < InCallServiceImpl.sPhoneCount; i10++) {
            if (this.mCallId[i10] != null) {
                CallList.getInstance().removeCallUpdateListener(this.mCallId[i10], this);
            }
        }
        CallList.getInstance().removeActiveSubChangeListener(this);
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onChildNumberChange() {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onLastForwardedNumberChange() {
    }
}
