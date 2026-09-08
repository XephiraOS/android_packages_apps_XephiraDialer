package com.android.incallui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusPhoneUtils;
import com.internal_dependency.InternalSdkDepends;
import com.oplus.backup.sdk.common.utils.Constants;

/* loaded from: classes.dex */
public class ConferenceManagerPresenter extends Presenter<ConferenceManagerUi> implements InCallPresenter.InCallStateListener, InCallPresenter.IncomingCallListener {
    private static String LOG_TAG = "ConferenceManagerPresenter";
    private static final int MAX_CALLERS_IN_CONFERENCE = 6;
    private static final int MSG_DELAY_REFRESH_UI = 1;
    private static final int MSG_DELAY_REFRESH_UI_TIME = 100;
    private String[] mCallerIds;
    private Context mContext;
    private final Handler mHandler = new Handler() { // from class: com.android.incallui.ConferenceManagerPresenter.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                Log.e(this, "error message...");
            } else if (((OplusInCallPresenter) InCallPresenter.getInstance()) != null) {
                Log.d(this, "MSG_DELAY_REFLASH_UI");
                InCallPresenter.getInstance().onCallListChange(InCallPresenter.getInstance().getCallList());
            }
        }
    };
    private int mNumCallersInConference;
    private String[] mParticipantList;

    /* loaded from: classes.dex */
    public interface ConferenceManagerUi extends Ui {
        void displayCallerInfoForConferenceRow(int i10, String str, String str2, String str3);

        void displayManageConferencePanel(boolean z10);

        boolean getIsEndCall();

        boolean isFragmentVisible();

        void setCanSeparateButtonForRow(int i10, boolean z10);

        void setEndButtonEnable(int i10, boolean z10, Call call, int i11);

        void setRowVisible(int i10, boolean z10);

        void setSeparateButtonEnable(int i10, boolean z10);

        @Override // com.android.incallui.Ui
        void setVisible(boolean z10);

        void setupEndButtonForRow(int i10, Call call, int i11);

        void setupEndButtonForRowWithUrl(int i10, String str);

        void startConferenceTime(long j10);

        void stopConferenceTime();
    }

    private void initParticipantList(CallList callList) {
        this.mParticipantList = null;
        if (callList.getActiveOrBackgroundCall() != null && callList.getActiveOrBackgroundCall().getChildCallIds() != null) {
            this.mCallerIds = (String[]) callList.getActiveOrBackgroundCall().getChildCallIds().toArray(new String[0]);
            try {
                sortByCallId();
            } catch (Exception e10) {
                Log.e(this, e10.getMessage());
            }
        }
        String[] strArr = this.mCallerIds;
        if (strArr != null) {
            this.mNumCallersInConference = strArr.length;
        }
    }

    private void sortByCallId() {
        int i10;
        String str;
        String[] strArr = this.mCallerIds;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                for (int i12 = 0; i12 < (length - i11) - 1; i12++) {
                    String[] strArr2 = this.mCallerIds;
                    String str2 = strArr2[i12];
                    if (str2 != null && (str = strArr2[(i10 = i12 + 1)]) != null && beforeCallIdIsLarger(str2, str)) {
                        String[] strArr3 = this.mCallerIds;
                        String str3 = strArr3[i12];
                        strArr3[i12] = strArr3[i10];
                        strArr3[i10] = str3;
                    }
                }
            }
        }
    }

    private void update(CallList callList) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        ContactInfoCache.ContactCacheEntry contactCacheEntry;
        Call g10;
        int activeSubId = CallList.getInstance().getActiveSubId();
        this.mCallerIds = null;
        initParticipantList(callList);
        Log.v(this, "Number of calls is " + String.valueOf(this.mNumCallersInConference));
        if (this.mNumCallersInConference <= 1 && (g10 = D2.b.g(callList, null, null, null, true)) != null && g10.showSingleParty()) {
            manageConferenceDoneClicked();
            return;
        }
        if (callList.getActiveCall() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (callList.getBackgroundCall() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && z11) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!OplusPhoneUtils.needShowSeparateButton(this.mContext, callList.getFirstCallWithState(11))) {
            z13 = false;
        } else {
            z13 = z12;
        }
        Log.d(this, "update hasActiveCall = " + z10 + ",hasHoldingCall = " + z11 + ",canSeparate = " + z13);
        Call call = null;
        for (int i10 = 0; i10 < 6; i10++) {
            if (i10 < this.mNumCallersInConference) {
                String[] strArr = this.mParticipantList;
                if (strArr == null) {
                    if (this.mCallerIds == null) {
                        Log.v(this, "mCallerIds is null, return");
                        return;
                    }
                    Call callById = CallList.getInstance().getCallById(this.mCallerIds[i10]);
                    if (callById != null) {
                        contactCacheEntry = callById.getContactInfo();
                        call = callById.getParentCall();
                    } else {
                        contactCacheEntry = null;
                    }
                    if (contactCacheEntry == null && callById != null) {
                        Log.v(this, "mCallerIds   " + i10 + "number = " + D2.g.l(callList.getCallById(this.mCallerIds[i10]).getNumber()));
                        if (contactCacheEntry == null) {
                            contactCacheEntry = new ContactInfoCache.ContactCacheEntry();
                            if (callList.getCallById(this.mCallerIds[i10]).getNumber() != null) {
                                contactCacheEntry.number = callList.getCallById(this.mCallerIds[i10]).getNumber();
                            } else {
                                contactCacheEntry.number = D2.b.k(this.mContext);
                            }
                        }
                    }
                    ContactInfoCache.ContactCacheEntry contactCacheEntry2 = contactCacheEntry;
                    Log.v(this, "contactCache =  " + contactCacheEntry2);
                    updateManageConferenceRow(i10, contactCacheEntry2, z13, call, activeSubId);
                    if (contactCacheEntry2 != null) {
                        if (callById != null && callById.getIsCdmaPhone()) {
                            getUi().setEndButtonEnable(i10, false, call, activeSubId);
                            getUi().setSeparateButtonEnable(i10, false);
                        } else if (callById != null && !callById.originalCanSeparate()) {
                            Log.d(LOG_TAG, "IMS child call ");
                            getUi().setEndButtonEnable(i10, true, call, activeSubId);
                            getUi().setSeparateButtonEnable(i10, false);
                        } else {
                            getUi().setEndButtonEnable(i10, true, call, activeSubId);
                            getUi().setSeparateButtonEnable(i10, z13);
                        }
                    }
                } else {
                    updateManageConferenceRow(i10, strArr[i10]);
                }
            } else {
                updateManageConferenceRow(i10, null, false, null, activeSubId);
            }
        }
    }

    public boolean beforeCallIdIsLarger(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        int length = str.length();
        int length2 = str2.length();
        if (length <= length2 && (length != length2 || str.compareTo(str2) <= 0)) {
            return false;
        }
        return true;
    }

    public void endConferenceConnection(int i10) {
        Log.d(this, "endConferenceConnection mNumCallersInConference= " + this.mNumCallersInConference + "rowId=" + i10);
        String[] strArr = this.mCallerIds;
        if (strArr != null && i10 < strArr.length && i10 < this.mNumCallersInConference) {
            TelecomAdapter.getInstance().disconnectCall(String.valueOf(this.mCallerIds[i10]));
        } else {
            Log.d(this, "endConferenceConnection rowId is wrong!!!");
        }
    }

    public int getMaxCallersInConference() {
        return 6;
    }

    public void init(Context context, CallList callList) {
        this.mContext = context;
        update(callList);
    }

    public void manageConferenceDoneClicked() {
        getUi().displayManageConferencePanel(false);
        if (((OplusInCallPresenter) InCallPresenter.getInstance()) != null) {
            Log.d(this, "manageConferenceDoneClicked reflash UI");
            InCallPresenter.getInstance().onCallListChange(InCallPresenter.getInstance().getCallList());
        }
    }

    @Override // com.android.incallui.InCallPresenter.IncomingCallListener
    public void onIncomingCall(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, Call call) {
        onStateChange(inCallState, inCallState2, CallList.getInstance());
    }

    @Override // com.android.incallui.InCallPresenter.InCallStateListener
    public void onStateChange(InCallPresenter.InCallState inCallState, InCallPresenter.InCallState inCallState2, CallList callList) {
        if (getUi() != null && getUi().isFragmentVisible()) {
            Log.v(this, "onStateChange = " + inCallState2);
            if (inCallState2 == InCallPresenter.InCallState.INCALL) {
                Call activeOrBackgroundCall = callList.getActiveOrBackgroundCall();
                if (activeOrBackgroundCall != null && activeOrBackgroundCall.isConferenceCall()) {
                    Log.v(this, "Number of existing calls is " + String.valueOf(activeOrBackgroundCall.getChildCallIds().size()));
                    update(callList);
                    if ((activeOrBackgroundCall.getChildCallIds().size() == 0 || (getUi().getIsEndCall() && activeOrBackgroundCall.getIsCdmaPhone())) && getUi().isFragmentVisible()) {
                        getUi().displayManageConferencePanel(false);
                        return;
                    }
                    return;
                }
                if (getUi().isFragmentVisible()) {
                    getUi().displayManageConferencePanel(false);
                }
                Log.d(LOG_TAG, "sendEmptyMessageDelayed MSG_DELAY_REFLASH_UI");
                this.mHandler.sendEmptyMessageDelayed(1, 100L);
                return;
            }
            if (getUi().isFragmentVisible()) {
                getUi().displayManageConferencePanel(false);
            }
        }
    }

    public void separateConferenceConnection(int i10) {
        String[] strArr = this.mCallerIds;
        if (strArr != null && i10 < strArr.length) {
            TelecomAdapter.getInstance().separateCall(String.valueOf(this.mCallerIds[i10]));
        }
    }

    public void updateManageConferenceRow(int i10, ContactInfoCache.ContactCacheEntry contactCacheEntry, boolean z10, Call call, int i11) {
        int indexOf;
        int indexOf2;
        if (contactCacheEntry != null) {
            getUi().setRowVisible(i10, true);
            String str = contactCacheEntry.name;
            String str2 = contactCacheEntry.number;
            if (str2 != null) {
                if (str2.contains("@ims") && -1 != (indexOf2 = str2.indexOf("@"))) {
                    try {
                        str2 = str2.substring(0, indexOf2).toString();
                    } catch (IndexOutOfBoundsException unused) {
                        Log.d(this, " updateManageConferenceRow index1 = " + indexOf2);
                    }
                }
                if (str2.contains(Constants.DataMigration.SPLIT_TAG) && -1 != (indexOf = str2.indexOf(Constants.DataMigration.SPLIT_TAG))) {
                    try {
                        str2 = str2.substring(0, indexOf).toString();
                    } catch (IndexOutOfBoundsException unused2) {
                        Log.d(this, " updateManageConferenceRow index2 = " + indexOf);
                    }
                }
                if (str2.startsWith("+886") && G2.d.b("persist.sys.oplus.region", " ").equalsIgnoreCase("TW")) {
                    try {
                        str2 = str2.substring(4, str2.length()).toString();
                        str2 = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE + str2;
                    } catch (IndexOutOfBoundsException unused3) {
                        Log.d(this, " updateManageConferenceRow index3");
                    }
                }
                Log.d(this, " updateManageConferenceRow number = " + D2.g.l(str2));
            }
            String str3 = null;
            if (!TextUtils.isEmpty(str2)) {
                str2 = PhoneNumberUtils.formatNumber(str2, null, InternalSdkDepends.getSInstance().getCurrentCountryIso(this.mContext));
            }
            Log.d(this, " updateManageConferenceRow name= " + D2.g.o(str) + "number=" + D2.g.l(str2));
            if (TextUtils.isEmpty(str)) {
                str = str2;
            } else {
                str3 = str2;
            }
            if (z10 || OplusFeatureOption.OPLUS_VERSION_EXP) {
                getUi().setCanSeparateButtonForRow(i10, z10);
            }
            getUi().setupEndButtonForRow(i10, call, i11);
            getUi().displayCallerInfoForConferenceRow(i10, str, str3, contactCacheEntry.label);
            return;
        }
        getUi().setRowVisible(i10, false);
    }

    @Override // com.android.incallui.Presenter
    public void onUiReady(ConferenceManagerUi conferenceManagerUi) {
        super.onUiReady((ConferenceManagerPresenter) conferenceManagerUi);
        Log.d(LOG_TAG, "onUiready");
        InCallPresenter.getInstance().addListener(this);
        InCallPresenter.getInstance().addIncomingCallListener(this);
    }

    @Override // com.android.incallui.Presenter
    public void onUiUnready(ConferenceManagerUi conferenceManagerUi) {
        super.onUiUnready((ConferenceManagerPresenter) conferenceManagerUi);
        InCallPresenter.getInstance().removeListener(this);
        InCallPresenter.getInstance().removeIncomingCallListener(this);
    }

    public void updateManageConferenceRow(int i10, String str) {
        if (str != null) {
            getUi().setRowVisible(i10, true);
            getUi().setupEndButtonForRowWithUrl(i10, str);
            getUi().displayCallerInfoForConferenceRow(i10, "", str, "");
            return;
        }
        getUi().setRowVisible(i10, false);
    }
}
