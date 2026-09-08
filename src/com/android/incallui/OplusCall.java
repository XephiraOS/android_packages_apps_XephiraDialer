package com.android.incallui;

import A2.k;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.incallui.Call;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.OplusTelecomAdapter;
import com.internal_dependency.AddOnSdkDepends;
import java.util.List;
import z2.C1731b;

/* loaded from: classes.dex */
public class OplusCall extends Call {
    private static final int CALL_PROGRESS_INFO_TYPE_CALL_WAITING = 1;
    private static final int CALL_PROGRESS_INFO_TYPE_REMOTE_AVAILABLE = 3;
    private static final int CALL_REJECTION_CODE_NO_USER_RESPONDING = 18;
    private static final int CALL_REJECTION_CODE_SUBSCRIBER_ABSENT = 20;
    private static final int CALL_REJECTION_CODE_UNALLOCATED_NUMBER = 1;
    private static final int CALL_REJECTION_CODE_USER_BUSY = 17;
    public static final String EXTRA_VERSTAT_VERIFICATION_STATUS = "extra_verstat_verification_status";
    private static final String LOG_TAG = "OplusCall";
    private static final String NOTE_VIEW_EDIT_ACTIVITY = "com.nearme.note.activity.edit.NoteViewEditActivity";
    private static final String OPLUS_CUSTOM_URI = "oplus_custom_uri";
    private static final String OPLUS_EXTRA_IS_CTCARD = "IS_CTCARD";
    private static final String OPLUS_EXTRA_IS_IMS = "IS_IMS";
    private static final String OPLUS_IS_CONF_PARTY = "oplus_is_conf_party";
    protected static final int RINGTONE_NOTIFICATION_CALL_PROCESSING = 11;
    private static final int RINGTONE_NOTIFICATION_CALL_WAITING = 3;
    private static final int RINGTONE_NOTIFICATION_INVALID_NUMBER = 1;
    private static final int RINGTONE_NOTIFICATION_OUT_OF_SERVICE = 18;
    private static final int RINGTONE_NOTIFICATION_POWER_OFF = 20;
    private static final int RINGTONE_NOTIFICATION_USER_BUSY = 17;
    public static final int TELECOM_STATE_DISCONNECTED = 7;
    public static final int VERSTAT_VERIFICATION_STATUS_FAIL = 2;
    public static final int VERSTAT_VERIFICATION_STATUS_NONE = 0;
    public static final int VERSTAT_VERIFICATION_STATUS_PASS = 1;
    private int mCallCapabilities;
    private boolean mCallMuted;
    private int mCallType;
    private boolean mCanRefreshUI;
    protected ContactInfoCache.ContactCacheEntry mContactInfo;
    private Uri mCustomContactUri;
    private int mFakeAnswerVideoState;
    private int mFakeState;
    private boolean mHasSRVCC;
    private boolean mInComingRingtone;
    private boolean mInComingVideoPaused;
    private boolean mIsCdmaDialing;
    private boolean mIsFakeGuard;
    private boolean mIsSRVCCConference;
    private boolean mIsSilence;
    private String mNotesGuid;
    private int mNotificationId;
    private OplusCallContactLookupCallback mOplusCallContactLookupCallback;
    private long mOplusConnectTimeMillis;
    private A2.j mOplusContactsInfoManager;
    private boolean mOriginalCanSeparate;
    private int mPhoneType;
    private int mPreVideoState;
    private int mProgressInfoId;
    private int mRejectionCodeId;
    private boolean mVideoPaused;

    public OplusCall(android.telecom.Call call) {
        super(call);
        boolean z10;
        Bundle intentExtras;
        this.mProgressInfoId = -1;
        this.mRejectionCodeId = -1;
        this.mNotificationId = -1;
        this.mIsFakeGuard = false;
        this.mOriginalCanSeparate = false;
        this.mFakeState = 0;
        this.mOplusCallContactLookupCallback = new OplusCallContactLookupCallback();
        this.mFakeAnswerVideoState = 0;
        this.mPreVideoState = 0;
        this.mVideoPaused = false;
        this.mCanRefreshUI = false;
        this.mCallMuted = false;
        this.mHasSRVCC = false;
        this.mInComingVideoPaused = false;
        this.mIsSilence = false;
        this.mNotesGuid = null;
        this.mCallType = 0;
        this.mInComingRingtone = false;
        this.mIsCdmaDialing = false;
        this.mPhoneType = -1;
        this.mCustomContactUri = null;
        this.mOplusConnectTimeMillis = 0L;
        this.mOplusContactsInfoManager = A2.j.J();
        setPhoneType(OplusPhoneUtils.getPhoneTypeByAccountHandle(getAccountHandle()));
        CallList.getInstance().oplusCallList().setActiceSubPhoneType(this);
        initContactInfo();
        setCanRefreshUI(true);
        startContactInfoSearch();
        if (getExtras() != null && !getExtras().getBoolean("oplus.telecom.extra.should_ring", true)) {
            z10 = false;
        } else {
            z10 = true;
        }
        setShouldRingForContact(z10);
        initNotShowInCallUIForIncoming();
        if (call != null && call.getState() == 2) {
            C1731b d10 = C1731b.d();
            final C1731b.f e10 = d10.e(1);
            e10.c(new C1731b.g() { // from class: com.android.incallui.OplusCall.1
                @Override // z2.C1731b.g
                public void onQueryPolicyComplete() {
                    C1731b.l lVar = (C1731b.l) e10.d();
                    if (lVar.f38292a) {
                        K2.a.e(OplusCall.LOG_TAG, "setAutoReplySms autoReplySms = " + lVar.f38295d);
                        K2.a.e(OplusCall.LOG_TAG, "setAutoSpeaker  autoSpeaker = " + lVar.f38298g);
                        OplusCall.this.setAutoReplySms(lVar.f38295d);
                        OplusCall.this.setAutoSpeaker(lVar.f38298g);
                    }
                }
            });
            final C1731b.f e11 = d10.e(2);
            e11.c(new C1731b.g() { // from class: com.android.incallui.OplusCall.2
                @Override // z2.C1731b.g
                public void onQueryPolicyComplete() {
                    C1731b.j jVar = (C1731b.j) e11.d();
                    if (OplusPhoneUtils.isRideMode()) {
                        K2.a.d(OplusCall.LOG_TAG, "setAutoReplySms autoReplySms = " + jVar.f38287d);
                        OplusCall.this.setAutoReplySms(jVar.f38287d);
                        if (OplusCall.this.isNotShowInCallUIForIncoming() && InCallPresenter.getInstance().isScreenInteractive()) {
                            OplusCall.this.setNotShowInCallUIForIncoming(false);
                        }
                    }
                }
            });
            final C1731b.f e12 = d10.e(3);
            e12.c(new C1731b.g() { // from class: com.android.incallui.OplusCall.3
                @Override // z2.C1731b.g
                public void onQueryPolicyComplete() {
                    if (OplusCall.this.mContactInfo == null) {
                        return;
                    }
                    C1731b.e eVar = (C1731b.e) e12.d();
                    ContactInfoCache.ContactCacheEntry contactCacheEntry = OplusCall.this.mContactInfo;
                    contactCacheEntry.lastCallTime = eVar.f38280a;
                    contactCacheEntry.callLogQueryState = 5;
                }
            });
        }
        if (call != null && call.getDetails() != null && (intentExtras = call.getDetails().getIntentExtras()) != null) {
            int i10 = intentExtras.getInt("intercept_properties", 0);
            this.mContactInfo.isPenetratedIncomingCall = P2.a.b(i10, 1);
            this.mContactInfo.isInWhiteList = P2.a.b(i10, 2);
            Log.d(LOG_TAG, "callId  =  " + getId() + "  isPenetratedIncomingCall " + this.mContactInfo.isPenetratedIncomingCall + " interceptTacticsProperties = " + i10 + "  inWhiteList = " + this.mContactInfo.isInWhiteList);
        }
        OplusPhoneUtils.updateIsInEmergencyCallValue();
        if (CallUtils.isInCommingCallRingtone(this.mContext, this) && !getIsInComingRingtoneCall()) {
            this.mInComingRingtone = true;
        }
    }

    private boolean canSeparateCall() {
        boolean z10;
        int callCapabilities = this.mTelecomCall.getDetails().getCallCapabilities();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "canSeparateCall supportedCapabilities  = " + callCapabilities);
        }
        if (4096 == (callCapabilities & 4096)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "canSeparateCall = " + z10);
        }
        if (z10) {
            this.mOriginalCanSeparate = true;
        }
        return z10;
    }

    private void initContactInfo() {
        int i10;
        boolean isRing = Call.State.isRing(getState());
        ContactInfoCache.ContactCacheEntry buildCacheEntryFromCall = ContactInfoCache.buildCacheEntryFromCall(this.mContext, this, isRing);
        this.mContactInfo = buildCacheEntryFromCall;
        buildCacheEntryFromCall.isVoiceMailComplete = true;
        buildCacheEntryFromCall.number = getNumber();
        this.mContactInfo.callId = getId();
        this.mContactInfo.subId = getSubId();
        this.mContactInfo.callState = getState();
        this.mContactInfo.isIncomingCall = isRing;
        if (getState() != 12) {
            ContactInfoCache.ContactCacheEntry contactCacheEntry = this.mContactInfo;
            if (OplusPhoneUtils.canDisplayCardIcon(this.mContext)) {
                i10 = getSlotId();
            } else {
                i10 = -1;
            }
            contactCacheEntry.slotId = i10;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "initContactInfo mContactInfo  = " + this.mContactInfo);
        }
        if (isConferenceCall()) {
            if (CallList.getInstance().oplusCallList().isCdmaPhoneInactive()) {
                if (Log.sDebug) {
                    Log.w(LOG_TAG, "startContactInfoSearch not cdma conference call");
                }
                this.mContactInfo.name = this.mContext.getResources().getString(R.string.card_title_conf_call);
                return;
            }
            return;
        }
        this.mContactInfo.location = "";
        setCustomContactUri();
        Uri uri = this.mCustomContactUri;
        if (uri != null) {
            this.mContactInfo.contactUri = uri;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "initCallInfo callId  = " + this.mContactInfo.callId + "  subId = " + this.mContactInfo.subId + "  callState = " + this.mContactInfo.callState + "  contactUri = " + D2.g.o(this.mContactInfo.contactUri));
        }
    }

    private void initNotShowInCallUIForIncoming() {
        boolean z10;
        if (isShouldRingForContact()) {
            z10 = false;
        } else if (!G2.a.a(this.mContext) && !OplusPhoneUtils.isRideMode() && (!OplusPhoneUtils.isSmartAutoAnswerOn(this.mContext) || !OplusPhoneUtils.isMotorCameraUp(this.mContext))) {
            z10 = true;
        } else {
            z10 = !InCallPresenter.getInstance().isScreenInteractive();
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "initNotShowInCallUIForIncoming: " + z10);
        }
        setNotShowInCallUIForIncoming(z10);
    }

    private boolean isCTCard() {
        Bundle extras = getExtras();
        if (extras == null) {
            Log.i(LOG_TAG, "isCTCard return false because mExtras is null!");
            return false;
        }
        return extras.getBoolean(OPLUS_EXTRA_IS_CTCARD, false);
    }

    private boolean isImsConfParty() {
        Bundle extras = getExtras();
        if (extras != null && !Call.State.isDisconnectingOrDisconnected(this.mState) && this.mState != 2) {
            return extras.getBoolean(OPLUS_IS_CONF_PARTY, false);
        }
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "isImsConfParty return false mExtras is null or state is disconnect or idle");
        }
        return false;
    }

    private boolean isNeedShowCnapName(String str) {
        boolean z10 = true;
        if (PhoneNumberUtils.isGlobalPhoneNumber(str) && !OplusFeatureOption.OPLUS_PHONE_SHOW_CNAPNAME_WHEN_IS_NUMBER && (!OplusFeatureOption.FEATURE_SHOW_CNAPNAME || !OplusPhoneUtils.isJpKddiOperatorNumeric(getSlotId(), getSubId()))) {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isNeedShowCnapName = " + z10);
        }
        return z10;
    }

    private void maybeAutoReplySms(android.telecom.Call call) {
        if (!getAutoReplySms()) {
            return;
        }
        if (call != null && call.getDetails() != null && call.getDetails().getDisconnectCause() != null && getContactInfo() != null) {
            if (call.getDetails().getDisconnectCause().getCode() != 6) {
                K2.a.e(LOG_TAG, "maybeAutoReplySms, DisconnectCause is not rejected !");
                return;
            } else if (D2.f.x()) {
                K2.a.e(LOG_TAG, "maybeAutoReplySms, Call Declined By Intercept Icon !");
                return;
            } else {
                OplusPhoneUtils.checkAutoReplySms(OplusInCallApp.getAppContext(), getContactInfo().number, getSubId());
                setAutoReplySms(false);
                return;
            }
        }
        K2.a.e(LOG_TAG, "maybeAutoReplySms, call info is null !");
    }

    private void setCustomContactUri() {
        Bundle intentExtras;
        android.telecom.Call call = this.mTelecomCall;
        if (call != null && call.getDetails() != null && (intentExtras = this.mTelecomCall.getDetails().getIntentExtras()) != null) {
            String string = intentExtras.getString(OPLUS_CUSTOM_URI);
            if (!TextUtils.isEmpty(string)) {
                this.mCustomContactUri = Uri.parse(string);
            }
        }
    }

    private void setIsCdmaPhone() {
        boolean z10 = false;
        if (this.mPhoneType == 2) {
            if (!isIms()) {
                z10 = true;
            }
        } else if (this.mContext != null && isCTCard() && !isIms()) {
            boolean isNetworkRoamingGemini = AddOnSdkDepends.getSInstance().isNetworkRoamingGemini(this.mContext, getSlotId(), getSubId());
            Log.d(LOG_TAG, "setIsCdmaPhone isNetWorkRoaming = " + isNetworkRoamingGemini);
            z10 = isNetworkRoamingGemini ^ true;
        }
        if (this.mOplusIsCdmaPhone != z10) {
            Log.d(LOG_TAG, "setIsCdmaPhone = " + z10);
            this.mOplusIsCdmaPhone = z10;
        }
    }

    private void startContactInfoSearch() {
        if (TextUtils.isEmpty(getNumber())) {
            if (Log.sDebug) {
                Log.w(LOG_TAG, "startContactInfoSearch callId  call number is null!!! ");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.mContactInfo.name) && TextUtils.isEmpty(getCnapName())) {
            if (Log.sDebug) {
                Log.i(LOG_TAG, "is GSM conference call or voicemail number,name = " + D2.g.o(this.mContactInfo.name));
            }
            ContactInfoCache.ContactCacheEntry contactCacheEntry = this.mContactInfo;
            contactCacheEntry.contactQueryState = 2;
            this.mOplusContactsInfoManager.U(this, contactCacheEntry, this.mOplusCallContactLookupCallback);
            this.mOplusContactsInfoManager.X(getNumber(), this.mContactInfo, this.mOplusCallContactLookupCallback);
            return;
        }
        this.mOplusContactsInfoManager.H(this, this.mContactInfo, this.mOplusCallContactLookupCallback);
        ContactInfoCache.ContactCacheEntry E10 = this.mOplusContactsInfoManager.E(getNumber());
        this.mOplusContactsInfoManager.X(getNumber(), E10, this.mOplusCallContactLookupCallback);
        if (E10 != null) {
            A2.l.d().i(getNumber(), E10);
        }
    }

    private void updateContactInfo() {
        ContactInfoCache.ContactCacheEntry contactCacheEntry = this.mContactInfo;
        if (contactCacheEntry != null) {
            contactCacheEntry.subId = getSubId();
            if (isConferenceCall() && getParentCall() != null) {
                Log.d(LOG_TAG, "updateContactInfo when is conference call but has parent!");
                this.mContactInfo.name = "";
                startContactInfoSearch();
            }
        }
    }

    @Override // com.android.incallui.Call
    public void copyContactInfoFromParty(Call call) {
        if (call == null) {
            if (!this.mShowSingleParty && isConferenceCall()) {
                if (CallList.getInstance().oplusCallList().isCdmaPhoneInactive()) {
                    this.mContactInfo.name = this.mContext.getResources().getString(R.string.card_title_conf_call);
                } else {
                    this.mContactInfo.name = this.mContext.getResources().getString(R.string.oplus_cdma_multi_call);
                }
            }
            Log.d(LOG_TAG, "copyContactInfoFromPart name " + D2.g.o(this.mContactInfo.name));
            return;
        }
        ContactInfoCache.ContactCacheEntry contactInfo = ((OplusCall) call).getContactInfo();
        ContactInfoCache.ContactCacheEntry contactCacheEntry = this.mContactInfo;
        String str = contactCacheEntry.callId;
        contactCacheEntry.name = null;
        A2.j.y(contactInfo, contactCacheEntry, true);
        ContactInfoCache.ContactCacheEntry contactCacheEntry2 = this.mContactInfo;
        contactCacheEntry2.number = contactInfo.number;
        contactCacheEntry2.callId = str;
        Log.d(LOG_TAG, "copyContactInfoFromPart mContactInfo " + D2.g.o(this.mContactInfo.name));
    }

    public String getCallProgressInfo() {
        String str = null;
        if (this.mContext == null || !Call.State.isDialing(getState())) {
            return null;
        }
        int i10 = this.mProgressInfoId;
        if (i10 != 1) {
            if (i10 == 3) {
                str = this.mContext.getString(R.string.video_ringtone_is_ringing);
            }
        } else {
            str = this.mContext.getString(R.string.video_ringtone_callwaiting);
        }
        Log.d(LOG_TAG, "getCallProgressInfo", "infoTypeString = " + str);
        return str;
    }

    @Override // com.android.incallui.Call
    public String getCallStateString() {
        if (getRejectionCode() != null) {
            return getRejectionCode();
        }
        if (getCallProgressInfo() != null) {
            return getCallProgressInfo();
        }
        return getCallStatusLabel();
    }

    @Override // com.android.incallui.Call
    public String getCallStatusLabel() {
        String str = null;
        if (this.mContext == null || !Call.State.isDialing(getState())) {
            return null;
        }
        int i10 = this.mNotificationId;
        if (i10 != 1) {
            if (i10 != 3) {
                if (i10 != 11) {
                    if (i10 != 20) {
                        if (i10 != 17) {
                            if (i10 == 18) {
                                str = this.mContext.getString(R.string.video_ringtone_no_user_responding);
                            }
                        } else {
                            str = this.mContext.getString(R.string.video_ringtone_user_busy);
                        }
                    } else {
                        str = this.mContext.getString(R.string.video_ringtone_subscriber_absent);
                    }
                } else {
                    str = this.mContext.getString(R.string.video_ringtone_is_ringing);
                }
            } else {
                str = this.mContext.getString(R.string.video_ringtone_callwaiting);
            }
        } else {
            str = this.mContext.getString(R.string.video_ringtone_unallocated_number);
        }
        Log.d(LOG_TAG, "getCallStatusLabel", "statusString = " + str);
        return str;
    }

    @Override // com.android.incallui.Call
    public int getCallType() {
        if (isConferenceCall()) {
            Log.d(LOG_TAG, "getCallType: type = 2");
            return 2;
        }
        Log.d(LOG_TAG, "getCallType: type = " + this.mCallType);
        return this.mCallType;
    }

    public int getChildCallSize() {
        List<String> list = this.mChildCallIds;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.android.incallui.Call
    public String getCnapName() {
        String cnapName = super.getCnapName();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "cnapName = " + D2.g.o(cnapName));
        }
        String str = "";
        if (!TextUtils.isEmpty(cnapName)) {
            str = cnapName.replace(" ", "");
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "temp = " + D2.g.o(str));
        }
        if (!isNeedShowCnapName(str)) {
            return null;
        }
        return cnapName;
    }

    @Override // com.android.incallui.Call
    public long getConnectTimeMillis() {
        if (this.mFakeState == 1) {
            return System.currentTimeMillis();
        }
        android.telecom.Call call = this.mTelecomCall;
        if (call != null && call.getDetails() != null) {
            return super.getConnectTimeMillis();
        }
        Log.w(LOG_TAG, "it's wrong, mTelecomCall is null!");
        return System.currentTimeMillis();
    }

    @Override // com.android.incallui.Call
    public ContactInfoCache.ContactCacheEntry getContactInfo() {
        return this.mContactInfo;
    }

    @Override // com.android.incallui.Call
    public Uri getCustomContactUri() {
        return this.mCustomContactUri;
    }

    @Override // com.android.incallui.Call
    public int getFakeState() {
        return this.mFakeState;
    }

    @Override // com.android.incallui.Call
    public boolean getHasSRVCC() {
        return this.mHasSRVCC;
    }

    @Override // com.android.incallui.Call
    public boolean getInComingVideoPaused() {
        return this.mInComingVideoPaused;
    }

    @Override // com.android.incallui.Call
    public boolean getIsFakeGuard() {
        return this.mIsFakeGuard;
    }

    @Override // com.android.incallui.Call
    public boolean getIsInComingRingtoneCall() {
        return this.mInComingRingtone;
    }

    @Override // com.android.incallui.Call
    public boolean getIsSilence() {
        return this.mIsSilence;
    }

    public boolean getMuted() {
        return this.mCallMuted;
    }

    @Override // com.android.incallui.Call
    public String getNotesGuid() {
        return this.mNotesGuid;
    }

    public long getOplusConnectTimeMillis() {
        return this.mOplusConnectTimeMillis;
    }

    public int getPhoneType() {
        return this.mPhoneType;
    }

    @Override // com.android.incallui.Call
    public int getPreVideoState() {
        return this.mPreVideoState;
    }

    public String getRejectionCode() {
        String str = null;
        if (this.mContext == null || !Call.State.isDialing(getState())) {
            return null;
        }
        int i10 = this.mRejectionCodeId;
        if (i10 != 1) {
            if (i10 != 20) {
                if (i10 != 17) {
                    if (i10 == 18) {
                        str = this.mContext.getString(R.string.video_ringtone_no_user_responding);
                    }
                } else {
                    str = this.mContext.getString(R.string.video_ringtone_user_busy);
                }
            } else {
                str = this.mContext.getString(R.string.video_ringtone_subscriber_absent);
            }
        } else {
            str = this.mContext.getString(R.string.video_ringtone_unallocated_number);
        }
        Log.d(LOG_TAG, "getRejectionCode", "reasonCodeString = " + str);
        return str;
    }

    public Call.RttCall getRttCall() {
        if (isRttCall() && getTelecommCall() != null) {
            return getTelecommCall().getRttCall();
        }
        return null;
    }

    @Override // com.android.incallui.Call
    public int getState() {
        int i10 = this.mFakeState;
        if (i10 != 0) {
            return OplusTelecomAdapter.FakeState.convertToCallState(i10);
        }
        int state = super.getState();
        if (state == 11 || isImsConfParty()) {
            return 11;
        }
        return state;
    }

    public int getVerstatVerificationStatus() {
        Bundle intentExtras;
        android.telecom.Call call = this.mTelecomCall;
        int i10 = 0;
        if (call != null && call.getDetails() != null && (intentExtras = this.mTelecomCall.getDetails().getIntentExtras()) != null) {
            i10 = intentExtras.getInt(EXTRA_VERSTAT_VERIFICATION_STATUS, 0);
        }
        if (Log.sDebug) {
            Log.i(LOG_TAG, "verified status is " + i10);
        }
        return i10;
    }

    @Override // com.android.incallui.Call
    public boolean getVideoPaused() {
        if (!this.mVideoPaused && OplusPhoneUtils.getVideoPausedForConf() && isConferenceCall()) {
            this.mVideoPaused = true;
            OplusPhoneUtils.setVideoPausedForConf(false);
        }
        return this.mVideoPaused;
    }

    @Override // com.android.incallui.Call
    public int getVideoState() {
        if (isFakeAnswerState()) {
            return this.mFakeAnswerVideoState;
        }
        return super.getVideoState();
    }

    public boolean hasVerstatVerificationStatus() {
        if (getVerstatVerificationStatus() == 1 || getVerstatVerificationStatus() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.android.incallui.Call
    public boolean isCdmaDialing() {
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "isCdmaDialing  = " + this.mIsCdmaDialing);
        }
        return this.mIsCdmaDialing;
    }

    @Override // com.android.incallui.Call
    public boolean isFakeAnswerState() {
        if (Log.sOplusDebug) {
            Log.d(LOG_TAG, "isFakeAnswerState  = " + this.mFakeState);
        }
        if (this.mFakeState == 1) {
            return true;
        }
        return false;
    }

    public boolean isIms() {
        if (this.mHasSRVCC) {
            return false;
        }
        Bundle extras = getExtras();
        if (extras == null) {
            Log.i(LOG_TAG, "isIms return false because mExtras is null!");
            return false;
        }
        return extras.getBoolean(OPLUS_EXTRA_IS_IMS, false);
    }

    public boolean isRttCall() {
        if (getTelecommCall() == null) {
            return false;
        }
        return getTelecommCall().isRttActive();
    }

    @Override // com.android.incallui.Call
    public boolean isSRVCCConference() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "isSRVCCConference isSRVCCConference:" + this.mIsSRVCCConference);
        }
        return this.mIsSRVCCConference;
    }

    @Override // com.android.incallui.Call
    public boolean isVipContact() {
        ContactInfoCache.ContactCacheEntry contactCacheEntry = this.mContactInfo;
        if (contactCacheEntry != null && contactCacheEntry.contactType == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b1, code lost:
    
        if (r3 < D2.f.s(r11.mContext)) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean needToJudgeShowInterceptDialog() {
        /*
            r11 = this;
            boolean r0 = com.android.incallui.Log.sDebug
            java.lang.String r1 = "OplusCall"
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "needToJudgeShowInterceptDialog  mContactInfo = "
            r0.append(r2)
            com.android.incallui.ContactInfoCache$ContactCacheEntry r2 = r11.mContactInfo
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.android.incallui.Log.d(r1, r0)
        L1c:
            com.android.incallui.ContactInfoCache$ContactCacheEntry r0 = r11.mContactInfo
            r2 = 0
            if (r0 != 0) goto L22
            return r2
        L22:
            boolean r3 = r0.isIncomingCall
            r4 = 0
            r6 = 1
            if (r3 == 0) goto L4c
            long r7 = r0.person_id
            r9 = -1
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 != 0) goto L4c
            A2.A r0 = r0.yellowPageInfo
            java.lang.String r0 = r0.f95c
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L4c
            com.android.incallui.ContactInfoCache$ContactCacheEntry r0 = r11.mContactInfo
            long r7 = r0.lastCallTime
            int r3 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r3 == 0) goto L4a
            A2.A r0 = r0.yellowPageInfo
            int r0 = r0.f99g
            if (r0 > 0) goto L4a
            goto L4c
        L4a:
            r0 = r6
            goto L56
        L4c:
            boolean r0 = com.android.incallui.Log.sDebug
            if (r0 == 0) goto L55
            java.lang.String r0 = "needToJudgeShowInterceptDialog  name or call log exist return "
            com.android.incallui.Log.d(r1, r0)
        L55:
            r0 = r2
        L56:
            if (r0 == 0) goto L70
            com.android.incallui.ContactInfoCache$ContactCacheEntry r3 = r11.mContactInfo
            A2.A r3 = r3.yellowPageInfo
            int r7 = r3.f99g
            if (r7 <= 0) goto L70
            boolean r3 = D2.f.B(r3)
            if (r3 != 0) goto L70
            boolean r0 = com.android.incallui.Log.sDebug
            if (r0 == 0) goto L6f
            java.lang.String r0 = "needToJudgeShowInterceptDialog  not intercept markinfo  return "
            com.android.incallui.Log.d(r1, r0)
        L6f:
            r0 = r2
        L70:
            long r7 = r11.getConnectTimeMillis()
            if (r0 == 0) goto Lb4
            int r3 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r3 == 0) goto Lb4
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r7
            r7 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r7
            int r3 = (int) r3
            boolean r4 = com.android.incallui.Log.sDebug
            if (r4 == 0) goto L9b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "needToJudgeShowInterceptDialog  dualTime = "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.android.incallui.Log.d(r1, r4)
        L9b:
            com.android.incallui.ContactInfoCache$ContactCacheEntry r4 = r11.mContactInfo
            A2.A r4 = r4.yellowPageInfo
            int r5 = r4.f99g
            if (r5 <= 0) goto Lab
            boolean r4 = D2.f.B(r4)
            if (r4 == 0) goto Lab
            r2 = r6
            goto Lb5
        Lab:
            android.content.Context r11 = r11.mContext
            int r11 = D2.f.s(r11)
            if (r3 < r11) goto Lb4
            goto Lb5
        Lb4:
            r2 = r0
        Lb5:
            boolean r11 = com.android.incallui.Log.sDebug
            if (r11 == 0) goto Lcd
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "needToJudgeShowInterceptDialog  bRet = "
            r11.append(r0)
            r11.append(r2)
            java.lang.String r11 = r11.toString()
            com.android.incallui.Log.d(r1, r11)
        Lcd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusCall.needToJudgeShowInterceptDialog():boolean");
    }

    @Override // com.android.incallui.Call
    public void onDestroy() {
        this.mOplusContactsInfoManager.f(getNumber(), this.mOplusCallContactLookupCallback);
        boolean hasAnyLiveCall = CallList.getInstance().hasAnyLiveCall();
        if (Log.sDebug) {
            Log.d(LOG_TAG, "call destroyed   hasLiveCall + " + hasAnyLiveCall);
        }
        Context context = this.mContext;
        if (context != null && !D2.f.t(context) && !hasAnyLiveCall && this.mContactInfo != null && needToJudgeShowInterceptDialog() && D2.f.Q(this.mContext)) {
            try {
                D2.f.R(this.mContext);
            } catch (Exception unused) {
                Log.w(LOG_TAG, "showInterceptDialog catch error!");
            }
        }
    }

    @Override // com.android.incallui.Call
    public void oplusOnDetailsChanged(android.telecom.Call call) {
        if (!shouldSkipFakeState(call.getState()) && !shouldSkipState(this.mState, call.getState()) && call.getState() != 7) {
            update();
        }
    }

    @Override // com.android.incallui.Call
    public void oplusOnStateChanged(android.telecom.Call call, int i10) {
        Call secondBackgroundCall;
        if (i10 == 7) {
            maybeAutoReplySms(call);
        }
        if (shouldSkipFakeState(i10) || shouldSkipState(this.mState, call.getState())) {
            return;
        }
        if (CallList.getInstance().getSecondBackgroundCall() == null) {
            secondBackgroundCall = CallList.getInstance().getBackgroundCall();
        } else {
            secondBackgroundCall = CallList.getInstance().getSecondBackgroundCall();
        }
        if (getFakeState() == 1 && i10 != 4 && secondBackgroundCall != null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "bg.setFakeState(OplusTelecomAdapter.FakeState.NOT_FAKE)");
            }
            if (secondBackgroundCall.getFakeState() == 3 && !Call.State.isRing(i10)) {
                secondBackgroundCall.setState(3);
                update();
            }
            secondBackgroundCall.setFakeState(0);
        }
        setIsFakeGuard(false);
        if (getFakeState() != 0) {
            setFakeState(0);
            this.mIsCallChanged = true;
        }
        if (i10 == 4 && getFakeState() == 0) {
            if (getAutoSpeaker()) {
                AudioModeProvider.getInstance().autoTurnOnSpeaker((Call) this, false);
                setAutoSpeaker(false);
            }
            setAutoReplySms(false);
        }
        if (this.mCanRefreshUI) {
            if (i10 != 7 || Call.State.isRing(getState())) {
                update();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x00b2, code lost:
    
        if (r2 == 0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e8 A[Catch: IllegalArgumentException -> 0x0105, TryCatch #0 {IllegalArgumentException -> 0x0105, blocks: (B:42:0x00e2, B:44:0x00e8, B:46:0x00f2, B:48:0x00ff, B:49:0x0107), top: B:41:0x00e2 }] */
    @Override // com.android.incallui.Call
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void oplusUpdateFromTelecommCall() {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.OplusCall.oplusUpdateFromTelecommCall():void");
    }

    @Override // com.android.incallui.Call
    public boolean originalCanSeparate() {
        boolean canSeparateCall;
        if (this.mOriginalCanSeparate) {
            canSeparateCall = true;
        } else {
            canSeparateCall = canSeparateCall();
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "originalCanSeparate = " + canSeparateCall);
        }
        return canSeparateCall;
    }

    @Override // com.android.incallui.Call
    public void parseBundleData(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i10 = bundle.getInt(OplusAutoRedialNotificationUI.TYPE, -1);
        if (i10 > 0) {
            this.mNotificationId = i10;
        } else {
            this.mNotificationId = bundle.getInt("cause", -1);
        }
        Log.d(LOG_TAG, "parseBundleData", "notificationId = " + this.mNotificationId);
    }

    public void sendRttRequest() {
        if (this.mTelecomCall == null) {
            return;
        }
        if (Log.sDebug) {
            Log.i("DialerCall.sendRttRequest", "");
        }
        this.mTelecomCall.sendRttRequest();
    }

    @Override // com.android.incallui.Call
    public void setCallLabledata(int i10, int i11) {
        if (i11 == 1 || i11 == 17 || i11 == 18 || i11 == 20) {
            this.mRejectionCodeId = i11;
        }
        if (i10 == 1 || i10 == 3) {
            this.mProgressInfoId = i10;
        }
        Log.d(LOG_TAG, "setCallLabledata mProgressInfoId = " + this.mProgressInfoId + ",mRejectionCodeId =" + this.mRejectionCodeId);
    }

    @Override // com.android.incallui.Call
    public void setCallType(int i10) {
        Log.d(LOG_TAG, "setCallType: type = " + i10);
        this.mCallType = i10;
    }

    public void setCanRefreshUI(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setCanRefreshUI = " + z10);
        }
        this.mCanRefreshUI = z10;
    }

    public void setCdmaDialing(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setCdmaDialing  = " + z10);
        }
        this.mIsCdmaDialing = z10;
    }

    @Override // com.android.incallui.Call
    public void setFakeAnswerVideoState(int i10) {
        this.mFakeAnswerVideoState = i10;
    }

    @Override // com.android.incallui.Call
    public void setFakeState(int i10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setFakeState callId = " + getId() + " oldState = " + this.mFakeState + " new State = " + i10);
        }
        this.mFakeState = i10;
    }

    @Override // com.android.incallui.Call
    public void setHasSRVCC(boolean z10) {
        if (this.mHasSRVCC != z10) {
            this.mHasSRVCC = z10;
            if (z10) {
                setPhoneType(OplusPhoneUtils.getPhoneTypeByAccountHandle(getAccountHandle()));
                if (this.mOplusIsCdmaPhone) {
                    setOplusConnectTimeMillis(getConnectTimeMillis());
                    setCdmaDialing(A2.l.d().e(this.mTelecommCallId));
                }
            }
        }
    }

    @Override // com.android.incallui.Call
    public void setInComingVideoPaused(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setInComingVideoPaused = " + z10);
        }
        this.mInComingVideoPaused = z10;
    }

    @Override // com.android.incallui.Call
    public void setIsFakeGuard(boolean z10) {
        this.mIsFakeGuard = z10;
    }

    @Override // com.android.incallui.Call
    public void setIsSRVCCConference(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setIsSRVCCConference isSRVCCConference:" + z10);
        }
        this.mIsSRVCCConference = z10;
    }

    @Override // com.android.incallui.Call
    public void setIsSilence(boolean z10) {
        this.mIsSilence = z10;
    }

    public void setMuted(boolean z10) {
        this.mCallMuted = z10;
    }

    @Override // com.android.incallui.Call
    public void setNotesGuid(String str) {
        Log.d(LOG_TAG, "setNotesGuid: guid = " + str);
        this.mNotesGuid = str;
    }

    public void setOplusConnectTimeMillis(long j10) {
        this.mOplusConnectTimeMillis = j10;
    }

    public void setPhoneType(int i10) {
        this.mPhoneType = i10;
        setIsCdmaPhone();
    }

    @Override // com.android.incallui.Call
    public void setState(int i10) {
        String className;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "callId =  " + getId() + "  old state >>: " + Call.State.toString(this.mState) + " new state >>:" + Call.State.toString(i10) + " mSetConnectingFirst = " + this.mSetConnectingFirst);
        }
        if (i10 == 3) {
            setPickup(true);
            OplusPhoneUtils.updateIsInEmergencyCallValue();
        }
        if (this.mSetConnectingFirst && i10 == 13) {
            this.mDisconnectGuard = true;
            this.mSetConnectingFirst = false;
            Log.d(LOG_TAG, " send MSG_RESET_DISCONNECT_GUARD");
            this.mHandler.sendEmptyMessageDelayed(1000, 1000L);
        }
        if (i10 == 2) {
            CallList.getInstance().oplusCallList().refreshExtendCallInfoDisconnecting(getId(), false);
            OplusPhoneUtils.updateIsInEmergencyCallValue();
        }
        if (!TextUtils.isEmpty(this.mNotesGuid) && this.mState != i10 && i10 == 10) {
            ComponentName topActivityComponentName = AddOnSdkDepends.getSInstance().getTopActivityComponentName();
            if (topActivityComponentName == null) {
                className = null;
            } else {
                className = topActivityComponentName.getClassName();
            }
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Call disconnected, topActivityName = " + className);
            }
            if (!NOTE_VIEW_EDIT_ACTIVITY.equals(className)) {
                D2.c.a(this.mContext, 3);
                D2.c.f(this.mContext, this);
            }
        }
        if (this.mState == 9 && Call.State.isConnectingOrDialing(i10)) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "not need to update call state when DISCONNECTING except DISCONNECTED.");
                return;
            }
            return;
        }
        if (this.mState != i10) {
            TelecomAdapter.getInstance().oplusTelecomAdapter().processCallStateChange(getId());
            if ((this.mState == 4 && i10 == 3) || i10 == 10) {
                Log.d(LOG_TAG, "INCOMING > ACTIVE or DISCONNECTED setIsVideoRingTone false.");
                setIsVideoRingTone(false);
            }
        } else if (i10 == 3 && (getParentId() != null || getChildCallSize() != 0)) {
            TelecomAdapter.getInstance().oplusTelecomAdapter().processCallStateChangeDelay(getId());
        }
        ContactInfoCache.ContactCacheEntry contactCacheEntry = this.mContactInfo;
        if (contactCacheEntry != null) {
            contactCacheEntry.callState = i10;
        }
        if (Call.State.isConnectingOrDialing(i10)) {
            setCallType(1);
        } else if (Call.State.isRing(i10)) {
            setCallType(0);
        }
        if (isConferenceCall()) {
            setCallType(2);
        }
        if (!this.mOplusIsCdmaPhone && 3 != this.mState && i10 == 3) {
            this.mState = i10;
            OplusPhoneUtils.sendBroadcastInCallActivityStateIfBackground(InCallPresenter.getInstance().getContext());
        } else {
            this.mState = i10;
        }
    }

    @Override // com.android.incallui.Call
    public void setVideoPaused(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setVideoPaused = " + z10);
        }
        this.mVideoPaused = z10;
    }

    @Override // com.android.incallui.Call
    public boolean shouldAutoRecord() {
        int i10;
        boolean z10 = false;
        if (AudioModeProvider.getInstance().getAudioMode() == 128 && this.mState != 4) {
            Log.d(LOG_TAG, "shouldAutoRecord return false for pc route!");
            return false;
        }
        if (OplusFeatureOption.FEATURE_SEND_CALL_RECORD_PATH) {
            OplusPhoneUserActionStatistics.addAutoRecordAction(this.mContext, OplusPhoneUserActionStatistics.SEND_CALL_RECORD_PATH, String.valueOf(true));
            return true;
        }
        if (OplusFeatureOption.FEATURE_RECORD_FOR_THIRD_PARTY && i2.d.a(this.mContext)) {
            Log.d(LOG_TAG, "shouldAutoRecord return true for record policy status is on!");
            OplusPhoneUserActionStatistics.addAutoRecordAction(this.mContext, OplusPhoneUserActionStatistics.RECORD_FOR_THIRD_PARTY, String.valueOf(true));
            return true;
        }
        if (OplusPhoneUtils.isNeedHideRecord(this.mContext) || !OplusPhoneUtils.isUserUnlocked(this.mContext)) {
            return false;
        }
        if (i2.b.f(this.mContext)) {
            return true;
        }
        Log.d(LOG_TAG, "shouldAutoRecord: mContactInfo = " + this.mContactInfo);
        ContactInfoCache.ContactCacheEntry contactCacheEntry = this.mContactInfo;
        if (contactCacheEntry != null && contactCacheEntry.shouldAutoRecord) {
            OplusPhoneUserActionStatistics.addAutoRecordAction(this.mContext, OplusPhoneUserActionStatistics.CONTACT_AUTO_RECORD, String.valueOf(true));
        } else {
            if (contactCacheEntry != null && (((i10 = contactCacheEntry.contactQueryState) == 2 || i10 == 3) && contactCacheEntry.person_id == -1 && !contactCacheEntry.isVoiceMail && i2.b.g(this.mContext))) {
                OplusPhoneUserActionStatistics.addAutoRecordAction(this.mContext, OplusPhoneUserActionStatistics.STRANGER_AUTO_RECORD, String.valueOf(true));
            }
            Log.d(LOG_TAG, "shouldAutoRecord flag = " + z10);
            return z10;
        }
        z10 = true;
        Log.d(LOG_TAG, "shouldAutoRecord flag = " + z10);
        return z10;
    }

    public boolean shouldHideUI() {
        Bundle intentExtras;
        android.telecom.Call call = this.mTelecomCall;
        boolean z10 = false;
        if (call != null && call.getDetails() != null && (intentExtras = this.mTelecomCall.getDetails().getIntentExtras()) != null) {
            z10 = intentExtras.getBoolean("oplusos.telecom.extra.HIDE_UI", false);
        }
        Log.d(LOG_TAG, "shouldHideUI should = " + z10);
        return z10;
    }

    public boolean shouldSkipFakeState(int i10) {
        if ((getFakeState() == 1 || getFakeState() == 2) && i10 == 2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "TelecommCallCallback shouldSkipFakeState, need not to update state when FakeState and call state is ringing, SeeBUG(639871)");
            }
            return true;
        }
        if (getFakeState() == 3 && i10 == 4) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "TelecommCallCallback shouldSkipFakeState, need not to update state when FakeState and call state is active, SeeBUG(641147)");
            }
            return true;
        }
        return false;
    }

    public boolean shouldSkipState(int i10, int i11) {
        int i12 = this.mState;
        if (i12 == 9 && i11 == 4) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "not need to update call state when DISCONNECTING except DISCONNECTED in onStateChanged");
            }
            return true;
        }
        if (i12 == 9 && i11 == 1) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "not need to update call state when DISCONNECTING except DISCONNECTED in onStateChanged");
            }
            return true;
        }
        if (i12 == 8 && i11 == 1) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "not need to update call state from hold to dialing");
            }
            return true;
        }
        if (i12 == 2) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "not need to update call state for the call is already idle");
            }
            return true;
        }
        if (i12 == 13 && i11 == 8) {
            this.mIsCallChanged = false;
            Log.d(LOG_TAG, "update CONNECTING change to SELECT_PHONE_ACCOUNT is not valid return ");
            return true;
        }
        if (i12 != 9 || i11 == 7) {
            return false;
        }
        this.mIsCallChanged = false;
        Log.d(LOG_TAG, "update DISCONNECTING change to other is not valid return ");
        return true;
    }

    public void stopRtt() {
        if (this.mTelecomCall == null) {
            return;
        }
        if (Log.sDebug) {
            Log.i("DialerCall.stopRtt", "");
        }
        if (this.mTelecomCall.isRttActive()) {
            this.mTelecomCall.stopRtt();
        }
    }

    @Override // com.android.incallui.Call
    public void updatePlaceCallContactInfo(String str, String str2, boolean z10) {
        int i10;
        this.mContactInfo.subId = getSubId();
        this.mContactInfo.callState = getState();
        this.mContactInfo.isIncomingCall = false;
        if (!TextUtils.isEmpty(str2)) {
            this.mContactInfo.number = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mContactInfo.name = str;
        }
        if (z10) {
            ContactInfoCache.ContactCacheEntry contactCacheEntry = this.mContactInfo;
            contactCacheEntry.isVoiceMail = true;
            contactCacheEntry.isYellowPageNumber = false;
            contactCacheEntry.photo = null;
            contactCacheEntry.yellowPageInfo.f95c = null;
        }
        ContactInfoCache.ContactCacheEntry contactCacheEntry2 = this.mContactInfo;
        if (OplusPhoneUtils.canDisplayCardIcon(this.mContext)) {
            i10 = getSlotId();
        } else {
            i10 = -1;
        }
        contactCacheEntry2.slotId = i10;
        if (!TextUtils.isEmpty(str2)) {
            this.mOplusContactsInfoManager.V(str2, this.mContactInfo, this.mOplusCallContactLookupCallback);
        }
    }

    /* loaded from: classes.dex */
    public class OplusCallContactLookupCallback implements k.b {
        public OplusCallContactLookupCallback() {
        }

        @Override // A2.k.b
        public boolean isInterceptQuery() {
            return false;
        }

        @Override // com.android.incallui.ContactInfoCache.ContactInfoCacheCallback
        public void onContactInfoComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
            String str2;
            Log.d(OplusCall.LOG_TAG, "onContactInfoComplete number = " + D2.g.l(str) + "  entry = " + contactCacheEntry);
            if (contactCacheEntry == null) {
                return;
            }
            ContactInfoCache.ContactCacheEntry contactCacheEntry2 = OplusCall.this.mContactInfo;
            if (contactCacheEntry2 != null) {
                contactCacheEntry2.yellowPageInfo.f95c = contactCacheEntry.yellowPageInfo.f95c;
                contactCacheEntry2.shouldAutoRecord = contactCacheEntry.shouldAutoRecord;
                contactCacheEntry2.contactQueryState = contactCacheEntry.contactQueryState;
                contactCacheEntry2.omojiPhoto = contactCacheEntry.omojiPhoto;
                contactCacheEntry2.omojiColor = contactCacheEntry.omojiColor;
            }
            if (contactCacheEntry.name != null && TextUtils.isEmpty(contactCacheEntry2.name)) {
                A2.j.y(contactCacheEntry, OplusCall.this.mContactInfo, false);
                OplusCall.this.mOplusContactsInfoManager.c(OplusCall.this.getId(), OplusCall.this.mContactInfo);
            } else {
                if (contactCacheEntry.isShowFdnName) {
                    ContactInfoCache.ContactCacheEntry contactCacheEntry3 = OplusCall.this.mContactInfo;
                    if (!contactCacheEntry3.isShowFdnName) {
                        A2.j.z(contactCacheEntry, contactCacheEntry3);
                        OplusCall.this.mOplusContactsInfoManager.c(OplusCall.this.getId(), OplusCall.this.mContactInfo);
                    }
                }
                A2.A a10 = contactCacheEntry.yellowPageInfo;
                if (a10.f97e != null || !TextUtils.isEmpty(a10.f96d)) {
                    A2.j.D(OplusCall.this.mContactInfo.yellowPageInfo, contactCacheEntry.yellowPageInfo, false, true);
                    A2.j.A(contactCacheEntry, OplusCall.this.mContactInfo);
                    OplusCall.this.mOplusContactsInfoManager.c(OplusCall.this.getId(), OplusCall.this.mContactInfo);
                }
            }
            String id = OplusCall.this.getId();
            f2.c cVar = f2.c.f31677a;
            if (TextUtils.equals(id, cVar.c().getValue())) {
                cVar.j(OplusCall.this);
            }
            com.android.incallui.clean.data.datasource.i iVar = com.android.incallui.clean.data.datasource.i.f18344a;
            String str3 = null;
            if (iVar.a().b() != null) {
                str2 = iVar.a().b().d();
            } else {
                str2 = null;
            }
            com.android.incallui.clean.data.datasource.j jVar = com.android.incallui.clean.data.datasource.j.f18347a;
            if (jVar.a().b() != null) {
                str3 = jVar.a().b().d();
            }
            if (TextUtils.equals(OplusCall.this.getId(), str2)) {
                iVar.c(OplusCall.this);
            } else if (TextUtils.equals(OplusCall.this.getId(), str3)) {
                jVar.c(OplusCall.this);
            }
            A2.l.d().i(str, OplusCall.this.mContactInfo);
        }

        @Override // com.android.incallui.ContactInfoCache.ContactInfoCacheCallback
        public void onImageLoadComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
            String str2;
            if (contactCacheEntry == null) {
                Log.d(OplusCall.LOG_TAG, "onImageLoadComplete end  number entry is null");
                return;
            }
            if (Log.sDebug) {
                String str3 = contactCacheEntry.name;
                if (str3 != null && str3.equals(str)) {
                    str3 = D2.g.l(str3);
                }
                Log.d(OplusCall.LOG_TAG, "onImageLoadComplete end  number = " + D2.g.l(str) + ", photo = " + contactCacheEntry.photo + " | " + contactCacheEntry.displayPhotoUri + " | " + contactCacheEntry.yellowPageInfo.f101i + ", name = " + D2.g.o(str3) + ", YellowPageName = " + D2.g.o(contactCacheEntry.yellowPageInfo.f95c));
            }
            ContactInfoCache.ContactCacheEntry contactCacheEntry2 = OplusCall.this.mContactInfo;
            if (contactCacheEntry2 != null) {
                long j10 = contactCacheEntry.person_id;
                if (j10 != -1) {
                    contactCacheEntry2.person_id = j10;
                    contactCacheEntry2.lookupKey = contactCacheEntry.lookupKey;
                    contactCacheEntry2.contactType = contactCacheEntry.contactType;
                    contactCacheEntry2.isYellowPageNumber = false;
                    contactCacheEntry2.starred = contactCacheEntry.starred;
                }
                contactCacheEntry2.photo = contactCacheEntry.photo;
                String str4 = contactCacheEntry.name;
                contactCacheEntry2.name = str4;
                contactCacheEntry2.company = contactCacheEntry.company;
                contactCacheEntry2.title = contactCacheEntry.title;
                A2.A a10 = contactCacheEntry2.yellowPageInfo;
                A2.A a11 = contactCacheEntry.yellowPageInfo;
                a10.f95c = a11.f95c;
                contactCacheEntry2.shouldAutoRecord = contactCacheEntry.shouldAutoRecord;
                a10.f101i = a11.f101i;
                a10.f102j = a11.f102j;
                contactCacheEntry2.contactQueryState = contactCacheEntry.contactQueryState;
                contactCacheEntry2.omojiPhoto = contactCacheEntry.omojiPhoto;
                contactCacheEntry2.omojiColor = contactCacheEntry.omojiColor;
                if (TextUtils.isEmpty(str4) && !TextUtils.isEmpty(contactCacheEntry.yellowPageInfo.f95c)) {
                    OplusCall.this.mContactInfo.name = contactCacheEntry.yellowPageInfo.f95c;
                }
                A2.j.D(OplusCall.this.mContactInfo.yellowPageInfo, contactCacheEntry.yellowPageInfo, false, true);
                OplusCall.this.mOplusContactsInfoManager.c(OplusCall.this.getId(), OplusCall.this.mContactInfo);
                String id = OplusCall.this.getId();
                f2.c cVar = f2.c.f31677a;
                if (TextUtils.equals(id, cVar.c().getValue())) {
                    cVar.j(OplusCall.this);
                }
                com.android.incallui.clean.data.datasource.i iVar = com.android.incallui.clean.data.datasource.i.f18344a;
                String str5 = null;
                if (iVar.a().b() != null) {
                    str2 = iVar.a().b().d();
                } else {
                    str2 = null;
                }
                com.android.incallui.clean.data.datasource.j jVar = com.android.incallui.clean.data.datasource.j.f18347a;
                if (jVar.a().b() != null) {
                    str5 = jVar.a().b().d();
                }
                if (TextUtils.equals(OplusCall.this.getId(), str2)) {
                    iVar.c(OplusCall.this);
                } else if (TextUtils.equals(OplusCall.this.getId(), str5)) {
                    jVar.c(OplusCall.this);
                }
                A2.l.d().i(str, OplusCall.this.mContactInfo);
                return;
            }
            Log.d(OplusCall.LOG_TAG, "onImageLoadComplete mContactInfo is null ");
        }

        @Override // A2.k.b
        public void onQueryCustomRecordComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
            if (contactCacheEntry == null) {
                Log.d(OplusCall.LOG_TAG, "onQueryCustomRecordComplete number entry is null");
                return;
            }
            Log.d(OplusCall.LOG_TAG, "onQueryCustomRecordComplete number = " + D2.g.l(str) + "  entry = " + contactCacheEntry.contactQueryState + ", " + contactCacheEntry.yellowPageQueryState + ", " + contactCacheEntry.locationQueryState + ", " + contactCacheEntry.callLogQueryState + ", " + contactCacheEntry.customRecordQueryState);
            ContactInfoCache.ContactCacheEntry contactCacheEntry2 = OplusCall.this.mContactInfo;
            contactCacheEntry2.customRecordQueryState = contactCacheEntry.customRecordQueryState;
            contactCacheEntry2.shouldAutoRecord = contactCacheEntry.shouldAutoRecord;
        }

        @Override // A2.k.b
        public void onQueryLocationComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
            String str2;
            if (Log.sDebug) {
                Log.d(OplusCall.LOG_TAG, "onQueryLocationComplete  number = " + D2.g.l(str) + "  entry = " + contactCacheEntry + "/n mContactInfo = " + OplusCall.this.mContactInfo);
            }
            if (contactCacheEntry == null) {
                return;
            }
            ContactInfoCache.ContactCacheEntry contactCacheEntry2 = OplusCall.this.mContactInfo;
            if (contactCacheEntry2 != null) {
                A2.j.D(contactCacheEntry2.yellowPageInfo, contactCacheEntry.yellowPageInfo, true, false);
            }
            if (!TextUtils.isEmpty(contactCacheEntry.location) && !contactCacheEntry.location.equals(OplusCall.this.mContactInfo.location)) {
                OplusCall.this.mContactInfo.location = contactCacheEntry.location;
                com.android.incallui.clean.data.datasource.i iVar = com.android.incallui.clean.data.datasource.i.f18344a;
                if (iVar.a().b() != null) {
                    str2 = iVar.a().b().d();
                } else {
                    str2 = null;
                }
                if (TextUtils.equals(OplusCall.this.getId(), str2)) {
                    iVar.c(OplusCall.this);
                }
                OplusCall oplusCall = OplusCall.this;
                oplusCall.mContactInfo.isYellowPageNumber = false;
                oplusCall.mOplusContactsInfoManager.c(OplusCall.this.getId(), OplusCall.this.mContactInfo);
            }
        }

        @Override // A2.k.b
        public void onQueryCallLogComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        }
    }
}
