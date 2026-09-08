package com.android.incallui;

import A2.C0385a;
import D2.e;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b2.InterfaceC0519a;
import com.android.incallui.AnswerPresenter;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.mvvm.view_model.OplusInCallViewModel;
import com.android.oplus.brand.BrandCenter;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.internal_dependency.InternalSdkDepends;
import g2.InterfaceC1034a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import t2.C1581a;

/* loaded from: classes.dex */
public class OplusAnswerFragment extends BaseFragment<AnswerPresenter, AnswerPresenter.AnswerUi> implements AnswerPresenter.AnswerUi, InterfaceC1034a, DialogInterface.OnClickListener, View.OnClickListener {
    private static final int ANSWER_ITEM_LEN = 2;
    private static final int ANSWER_ITEM_MAP_LEN = 2;
    private static final int END_ALL_CALL = 4;
    private static final int END_BG_CALL = 2;
    private static final int END_FG_CALL = 0;
    private static final int HOLD_FG_CALL = 1;
    private static final String INTERCEPT_MARK_NUMBER_ADVERTISING_SELECTED = "intercept_mark_number_advertising_selected";
    private static final String INTERCEPT_MARK_NUMBER_FRAUD_SELECTED = "intercept_mark_number_fraud_selected";
    private static final String INTERCEPT_MARK_NUMBER_HARASSMENT_SELECTED = "intercept_mark_number_harassment_selected";
    private static final String INTERCEPT_MARK_NUMBER_INTERMEDIARY_SELECTED = "intercept_mark_number_intermediary_selected";
    private static final String LOG_TAG = "OplusAnswerFragment";
    private static final int MERGE_FG_CALL = 3;
    protected static final int OPLUS_DELAY_GOTO_ANSWER_TIME = 500;
    protected static final int OPLUS_MSG_DELAY_GOTO_ANSWER = 200;
    protected static final int OPLUS_MSG_DELAY_GOTO_REPLY_NEW_MSG = 311;
    protected static final int OPLUS_MSG_DELAY_SHOW_SMS_LISTVIEW = 312;
    protected static final int OPLUS_MSG_QUERY_REFUSE_MSG = 209;
    private static final int OPLUS_TIME_DELAY_REPLY_MSG = 100;
    private static final String SIM_ID = "sim_id_mms";
    private static final int SMS_REFUSE_LIST_ITEM = 4;
    private ArrayList<String> mAnswerItems;
    private HashMap<String, Integer> mAnswerItemsMap;
    private androidx.appcompat.app.b mAnswerSelectDialog;
    private androidx.appcompat.app.b mInterceptSelectionDialog;
    private ListView mInterceptSelectionListView;
    private View mInterceptSelectionView;
    private OplusCallList mOplusCallList;
    private androidx.appcompat.app.b mSmsDialog;
    protected String mTempReplyNumber = null;
    private int mAnswerVideoState = 0;
    private int mCallSize = 0;
    private boolean mIsSecure = false;
    ArrayList<String> mSmsRefuseList = null;
    private boolean mShow = false;
    private boolean mShowRejectCustomizeMsg = false;
    private D2.e mInterceptAdapter = null;
    private ArrayList<String> mInterceptSelectionList = null;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.incallui.OplusAnswerFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 200) {
                if (i10 != OplusAnswerFragment.OPLUS_MSG_QUERY_REFUSE_MSG) {
                    if (i10 == OplusAnswerFragment.OPLUS_MSG_DELAY_GOTO_REPLY_NEW_MSG) {
                        OplusAnswerFragment.this.gotoReplyNewMsgUI();
                        return;
                    }
                    if (i10 == OplusAnswerFragment.OPLUS_MSG_DELAY_SHOW_SMS_LISTVIEW) {
                        OplusAnswerFragment.this.showSmsListView();
                        return;
                    }
                    Log.w(OplusAnswerFragment.LOG_TAG, "mHandler: unexpected message: " + message);
                    return;
                }
                OplusAnswerFragment.this.log("OPLUS_MSG_QUERY_REFUSE_MSG...");
                OplusAnswerFragment.this.queryRefuseMessage(false);
                return;
            }
            OplusAnswerFragment.this.getPresenter().onAnswer(OplusAnswerFragment.this.mAnswerVideoState, OplusAnswerFragment.this.getContext());
        }
    };

    /* loaded from: classes.dex */
    public interface AnswerViewType {
        public static final int LOCK_SCREEN_ANSWER_VIEW = 0;
        public static final int RIDE_MODE_ANSWER_VIEW = 2;
        public static final int UNLOCK_SCREEN_ANSWER_VIEW = 1;
    }

    private void chooseAnswer(int i10, Context context, int i11) {
        if (isAnswerSelectDialogShowing()) {
            Log.d(LOG_TAG, "onClick, unlock_answer return");
            return;
        }
        if (this.mOplusCallList == null) {
            this.mOplusCallList = (OplusCallList) CallList.getInstance();
        }
        Call oplusGetIncomingCall = this.mOplusCallList.oplusGetIncomingCall();
        if (oplusGetIncomingCall != null && !oplusGetIncomingCall.getIsCdmaPhone()) {
            Call oplusGetActiveCall = this.mOplusCallList.oplusGetActiveCall();
            String str = null;
            if (oplusGetActiveCall != null) {
                String nameOrNumber = getNameOrNumber(oplusGetActiveCall);
                if (this.mOplusCallList.oplusGetBackgroundCall() != null) {
                    str = getNameOrNumber(this.mOplusCallList.oplusGetBackgroundCall());
                }
                this.mAnswerVideoState = i10;
                showDialogToSelectAction(nameOrNumber, str, OplusPhoneUtils.isNeedHideHoldOption(oplusGetActiveCall, oplusGetIncomingCall, i10, OplusFeatureOption.OPLUS_FEATURE_DSDA_HOLD_NOT_SUPPORT.value().booleanValue()), context);
                return;
            }
            boolean z10 = false;
            Call parentCallWithState = this.mOplusCallList.getParentCallWithState(8, 0);
            Call parentCallWithState2 = this.mOplusCallList.getParentCallWithState(8, 1);
            if (parentCallWithState != null && parentCallWithState2 != null) {
                if (Log.sDebug) {
                    Log.d(LOG_TAG, "chooseAnswer hasDoubleBackgroundCall ...");
                }
                String nameOrNumber2 = getNameOrNumber(parentCallWithState);
                String nameOrNumber3 = getNameOrNumber(parentCallWithState2);
                this.mAnswerVideoState = i10;
                if (oplusGetIncomingCall.getSlotId() != parentCallWithState.getSlotId()) {
                    z10 = true;
                }
                showDialogToSelectAction(nameOrNumber2, nameOrNumber3, z10, context);
                return;
            }
            OplusPhoneUtils.changeCallCastAudioModeForPcOrPad(context, i11, this.mOplusCallList);
            Call oplusGetOutgoingCall = this.mOplusCallList.oplusGetOutgoingCall();
            if (oplusGetOutgoingCall != null) {
                String nameOrNumber4 = getNameOrNumber(oplusGetOutgoingCall);
                this.mAnswerVideoState = i10;
                showDialogToSelectAction(nameOrNumber4, null, true, context);
                return;
            }
            getPresenter().onAnswer(i10, context);
            return;
        }
        OplusPhoneUtils.changeCallCastAudioModeForPcOrPad(context, i11, this.mOplusCallList);
        getPresenter().onAnswer(i10, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoReplyNewMsgUI() {
        log("gotoReplyNewMsgUI() mIsSecure = " + this.mIsSecure);
        try {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", this.mTempReplyNumber, null));
            intent.setFlags(335544320);
            intent.putExtra(SIM_ID, OplusPhoneUtils.getActiveSimId(getContext()));
            if (!this.mIsSecure) {
                intent.putExtra("show_when_locked", true);
            } else {
                OplusPhoneUtils.dismissKeyguard();
            }
            startActivity(intent);
            if (getActivity() != null) {
                getActivity().overridePendingTransition(R.anim.oplus_rounded_corners_anim_open_slide_enter, R.anim.oplus_rounded_corners_anim_open_slide_exit);
            }
            onDecline(getContext());
        } catch (Exception e10) {
            Log.w(LOG_TAG, "goto reply msg exception!e=" + e10);
        }
    }

    private void hideInterceptDialogAndRestoreAnswerView() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "hideSmsListView");
        }
        hideInterceptSelectionDialog();
        displayAnswerView(!OplusPhoneUtils.getShowLockScreenAnswerView() ? 1 : 0);
    }

    private void hideInterceptSelectionDialog() {
        androidx.appcompat.app.b bVar = this.mInterceptSelectionDialog;
        if (bVar != null && bVar.isShowing()) {
            this.mInterceptSelectionDialog.dismiss();
        }
    }

    private void hideSmsListDialog() {
        androidx.appcompat.app.b bVar = this.mSmsDialog;
        if (bVar != null && bVar.isShowing()) {
            this.mSmsDialog.dismiss();
        }
    }

    private void initInterceptSelectionView(int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this.mInterceptSelectionView != null) {
            Log.d(LOG_TAG, "no need initInterceptSelectionView");
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.oplus_intercept_selection_layout, (ViewGroup) null);
        this.mInterceptSelectionView = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.oplus_intercept_tips);
        int i12 = R.string.oplus_summary_decline_and_intercept_mark_number;
        String string = getString(i12);
        boolean z16 = true;
        if (OplusPhoneUtils.getAvailableCardSize(getContext()) == 2) {
            if (i11 == 0) {
                string = getString(R.string.sim_1, getString(i12));
            } else if (i11 == 1) {
                string = getString(R.string.sim_2, getString(i12));
            }
        }
        textView.setText(string);
        int q10 = D2.f.q(getContext(), i11);
        boolean A10 = D2.f.A(getContext(), "oplus_customize_harass_intercept_mark_number_fraud", 3, q10);
        boolean z17 = false;
        boolean A11 = D2.f.A(getContext(), "oplus_customize_harass_intercept_mark_number_harassment", 0, q10);
        boolean A12 = D2.f.A(getContext(), "oplus_customize_harass_intercept_mark_number_advertising", 0, q10);
        boolean A13 = D2.f.A(getContext(), "oplus_customize_harass_intercept_mark_number_intermediary", 0, q10);
        if (this.mInterceptSelectionList == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.mInterceptSelectionList = arrayList;
            if (A10) {
                arrayList.add(getString(R.string.oplus_item_intercept_fraud_call) + getString(R.string.oplus_already_intercept));
            } else {
                arrayList.add(getString(R.string.oplus_item_intercept_fraud_call));
            }
            if (A11) {
                this.mInterceptSelectionList.add(getString(R.string.oplus_item_intercept_harassment_call) + getString(R.string.oplus_already_intercept));
            } else {
                this.mInterceptSelectionList.add(getString(R.string.oplus_item_intercept_harassment_call));
            }
            if (A12) {
                this.mInterceptSelectionList.add(getString(R.string.oplus_item_intercept_advertising_call) + getString(R.string.oplus_already_intercept));
            } else {
                this.mInterceptSelectionList.add(getString(R.string.oplus_item_intercept_advertising_call));
            }
            if (A13) {
                this.mInterceptSelectionList.add(getString(R.string.oplus_item_intercept_real_estate_broker_call) + getString(R.string.oplus_already_intercept));
            } else {
                this.mInterceptSelectionList.add(getString(R.string.oplus_item_intercept_real_estate_broker_call));
            }
        }
        if (this.mInterceptAdapter == null) {
            this.mInterceptAdapter = new D2.e(getContext(), this.mInterceptSelectionList);
        }
        if (i10 == 3) {
            z11 = true;
            z10 = true;
        } else if (A10) {
            z11 = true;
            z10 = false;
        } else {
            z10 = true;
            z11 = false;
        }
        this.mInterceptAdapter.d(0, z11, z10);
        if (i10 == 4) {
            z13 = true;
            z12 = true;
        } else if (A11) {
            z13 = true;
            z12 = false;
        } else {
            z12 = true;
            z13 = false;
        }
        this.mInterceptAdapter.d(1, z13, z12);
        if (i10 == 1) {
            z15 = true;
            z14 = true;
        } else if (A12) {
            z15 = true;
            z14 = false;
        } else {
            z14 = true;
            z15 = false;
        }
        this.mInterceptAdapter.d(2, z15, z14);
        if (i10 == 5) {
            z17 = true;
        } else if (!A13) {
            z17 = true;
            z16 = false;
        }
        this.mInterceptAdapter.d(3, z16, z17);
        ListView listView = (ListView) this.mInterceptSelectionView.findViewById(R.id.oplus_intercept_list);
        this.mInterceptSelectionListView = listView;
        listView.setAdapter((ListAdapter) this.mInterceptAdapter);
        this.mInterceptSelectionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.android.incallui.o
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i13, long j10) {
                OplusAnswerFragment.this.lambda$initInterceptSelectionView$6(adapterView, view, i13, j10);
            }
        });
    }

    private boolean isSmsListDialogShowing() {
        androidx.appcompat.app.b bVar = this.mSmsDialog;
        if (bVar != null && bVar.isShowing()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initInterceptSelectionView$6(AdapterView adapterView, View view, int i10, long j10) {
        Log.d(LOG_TAG, "onItemClick, position = " + i10);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        e.a a10 = this.mInterceptAdapter.a(i10);
        boolean z10 = true;
        a10.f432a = !a10.f432a;
        this.mInterceptAdapter.c(i10, a10);
        checkBox.setChecked(a10.f432a);
        Button b10 = this.mInterceptSelectionDialog.b(-1);
        int i11 = 0;
        while (true) {
            if (i11 < this.mInterceptAdapter.getCount()) {
                e.a a11 = this.mInterceptAdapter.a(i11);
                if (a11.f432a && a11.f433b) {
                    break;
                } else {
                    i11++;
                }
            } else {
                z10 = false;
                break;
            }
        }
        b10.setEnabled(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogToSelectAction$7(Context context, DialogInterface dialogInterface, int i10) {
        int intValue = this.mAnswerItemsMap.get(this.mAnswerItems.get(i10)).intValue();
        Log.d(LOG_TAG, "showDialogToSelectAction onclick index = " + intValue);
        if (this.mOplusCallList == null) {
            this.mOplusCallList = (OplusCallList) CallList.getInstance();
        }
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        if (intValue == 4) {
                            getPresenter().onAnswer(this.mAnswerVideoState, context);
                        }
                    } else {
                        String id = this.mOplusCallList.getIncomingCall().getId();
                        if (this.mOplusCallList.oplusGetActiveCall() != null) {
                            getPresenter().onAnswer(this.mAnswerVideoState, context);
                            InCallPresenter.getInstance().realInstance().setNeedMerge(true, id);
                        }
                    }
                } else {
                    if (this.mOplusCallList.oplusGetBackgroundCall() != null) {
                        disconnectCall(this.mOplusCallList.oplusGetBackgroundCall().getId());
                    }
                    this.mHandler.sendEmptyMessageDelayed(200, 500L);
                }
            } else {
                getPresenter().onAnswer(this.mAnswerVideoState, context);
            }
        } else {
            Call oplusGetActiveCall = this.mOplusCallList.oplusGetActiveCall();
            if (oplusGetActiveCall == null) {
                oplusGetActiveCall = this.mOplusCallList.oplusGetOutgoingCall();
            }
            if (oplusGetActiveCall != null) {
                disconnectCall(oplusGetActiveCall.getId());
            }
            this.mHandler.sendEmptyMessageDelayed(200, 500L);
        }
        removeAnswerSelectDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogToSelectAction$8(DialogInterface dialogInterface, int i10) {
        Log.d(LOG_TAG, "showDialogToSelectAction: negative button onClick");
        notifyUiReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialogToSelectAction$9(DialogInterface dialogInterface) {
        Log.d(LOG_TAG, "showDialogToSelectAction: onCancel");
        notifyUiReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterceptSelectionDialog$2(DialogInterface dialogInterface, int i10) {
        Log.d(LOG_TAG, "show intercept selection dialog: OnClick Negative");
        hideInterceptDialogAndRestoreAnswerView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterceptSelectionDialog$3(DialogInterface dialogInterface, int i10) {
        Log.d(LOG_TAG, "show intercept selection dialog: OnClick Positive");
        D2.f.L(true);
        HashMap hashMap = new HashMap();
        int q10 = D2.f.q(getContext(), D2.f.p());
        try {
            if (this.mInterceptAdapter.a(0).f432a) {
                D2.f.J(getActivity(), q10, "oplus_customize_harass_intercept_mark_number_fraud", true, 3);
                hashMap.put(INTERCEPT_MARK_NUMBER_FRAUD_SELECTED, 1);
            } else {
                hashMap.put(INTERCEPT_MARK_NUMBER_FRAUD_SELECTED, 0);
            }
            if (this.mInterceptAdapter.a(1).f432a) {
                D2.f.J(getActivity(), q10, "oplus_customize_harass_intercept_mark_number_harassment", true, 0);
                hashMap.put(INTERCEPT_MARK_NUMBER_HARASSMENT_SELECTED, 1);
            } else {
                hashMap.put(INTERCEPT_MARK_NUMBER_HARASSMENT_SELECTED, 0);
            }
            if (this.mInterceptAdapter.a(2).f432a) {
                D2.f.J(getActivity(), q10, "oplus_customize_harass_intercept_mark_number_advertising", true, 0);
                hashMap.put(INTERCEPT_MARK_NUMBER_ADVERTISING_SELECTED, 1);
            } else {
                hashMap.put(INTERCEPT_MARK_NUMBER_ADVERTISING_SELECTED, 0);
            }
            if (this.mInterceptAdapter.a(3).f432a) {
                D2.f.J(getActivity(), q10, "oplus_customize_harass_intercept_mark_number_intermediary", true, 0);
                hashMap.put(INTERCEPT_MARK_NUMBER_INTERMEDIARY_SELECTED, 1);
            } else {
                hashMap.put(INTERCEPT_MARK_NUMBER_INTERMEDIARY_SELECTED, 0);
            }
        } catch (Exception e10) {
            log("exception occur at mInterceptSelectionDialog.onClick: " + e10);
        }
        OplusPhoneUserActionStatistics.onCommon(getContext(), OplusPhoneUserActionStatistics.TAG_HARASS_INTERCEPT, OplusPhoneUserActionStatistics.INCOMING_CALL_CLICK_CONFIRM_INTERCEPT_BUTTON, hashMap);
        onDecline(getContext());
        Toast c10 = A2.b.b().c(R.string.oplus_intercept_mark_number_tips, 1);
        if (c10 != null) {
            c10.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterceptSelectionDialog$4(DialogInterface dialogInterface) {
        Log.d(LOG_TAG, "show intercept selection dialog: onCancel");
        hideInterceptDialogAndRestoreAnswerView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showInterceptSelectionDialog$5(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Log.d(LOG_TAG, "show intercept selection dialog: onKey = " + i10);
        if (i10 == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSmsListDialog$0(DialogInterface dialogInterface, int i10) {
        hideSmsListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSmsListDialog$1(DialogInterface dialogInterface) {
        hideSmsListView();
    }

    private boolean needAddRejectCustomizeMsg() {
        Context context = InCallPresenter.getInstance().getContext();
        if (context == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "needAddRejectCustomizeMsg context is null");
            }
            return false;
        }
        if (OplusPhoneUtils.isDeviceRestricted(context)) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "needAddRejectCustomizeMsg, not need to add because the device restricted");
            }
            return false;
        }
        if (C0385a.a(context)) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "needAddRejectCustomizeMsg, not need to add because in focusMode");
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUiReady() {
        getPresenter().onUiReady((AnswerPresenter.AnswerUi) this);
    }

    private void onDeclineWithSms(Context context, String str) {
        if (Log.sDebug) {
            D2.g.c(LOG_TAG, "onDecline");
        }
        getPresenter().onDeclineWithSms(context, str);
    }

    private void removeInterceptSelectionDialog() {
        Log.d(LOG_TAG, "removeInterceptSelectionDialog");
        ArrayList<String> arrayList = this.mInterceptSelectionList;
        if (arrayList != null) {
            arrayList.clear();
            this.mInterceptSelectionList = null;
        }
        androidx.appcompat.app.b bVar = this.mInterceptSelectionDialog;
        if (bVar != null) {
            bVar.dismiss();
            this.mInterceptSelectionDialog = null;
        }
        ListView listView = this.mInterceptSelectionListView;
        if (listView != null) {
            listView.setAdapter((ListAdapter) null);
            this.mInterceptSelectionListView = null;
        }
        D2.e eVar = this.mInterceptAdapter;
        if (eVar != null) {
            eVar.b();
            this.mInterceptAdapter = null;
        }
        this.mInterceptSelectionView = null;
    }

    private void removeSmsListDialog() {
        androidx.appcompat.app.b bVar = this.mSmsDialog;
        if (bVar != null) {
            bVar.dismiss();
            this.mSmsDialog = null;
        }
    }

    private void saveIncomingNumberToTemp() {
        if (OplusTelephonyCapabilities.isOplusEnabled()) {
            String callNumber = getPresenter().getCallNumber();
            Log.i(LOG_TAG, "saveIncomingNumber mCallNumber =" + D2.g.l(callNumber));
            this.mTempReplyNumber = callNumber;
            return;
        }
        if (getPresenter().mPrimaryContactInfo != null && getPresenter().mPrimaryContactInfo.number != null) {
            this.mTempReplyNumber = getPresenter().mPrimaryContactInfo.number;
        }
        Log.i(LOG_TAG, "mTempReplyNumber=" + D2.g.l(this.mTempReplyNumber));
    }

    private void showDialogToSelectAction(String str, String str2, boolean z10, final Context context) {
        String str3;
        if (context == null) {
            return;
        }
        Log.d(LOG_TAG, "showDialogToSelectAction,isNeedHideHold = " + z10);
        if (TextUtils.isEmpty(str)) {
            getPresenter().onAnswer(this.mAnswerVideoState, context);
            return;
        }
        if (this.mAnswerItemsMap == null) {
            this.mAnswerItemsMap = new HashMap<>(2);
        }
        this.mAnswerItemsMap.clear();
        if (this.mAnswerItems == null) {
            this.mAnswerItems = new ArrayList<>(2);
        }
        this.mAnswerItems.clear();
        if (this.mOplusCallList == null) {
            this.mOplusCallList = (OplusCallList) CallList.getInstance();
        }
        boolean hasConferenceCall = this.mOplusCallList.hasConferenceCall();
        boolean isEmpty = TextUtils.isEmpty(str2);
        if (isEmpty) {
            if (hasConferenceCall) {
                HashMap<String, Integer> hashMap = this.mAnswerItemsMap;
                int i10 = R.string.incall_answer_after_end_conference;
                hashMap.put(context.getString(i10), 0);
                this.mAnswerItems.add(context.getString(i10));
                if (!z10) {
                    HashMap<String, Integer> hashMap2 = this.mAnswerItemsMap;
                    int i11 = R.string.incall_answer_after_hold_conference;
                    hashMap2.put(context.getString(i11), 1);
                    this.mAnswerItems.add(context.getString(i11));
                }
            } else {
                HashMap<String, Integer> hashMap3 = this.mAnswerItemsMap;
                int i12 = R.string.incall_answer_after_end_call;
                hashMap3.put(context.getString(i12, str), 0);
                this.mAnswerItems.add(context.getString(i12, str));
                if (!z10) {
                    HashMap<String, Integer> hashMap4 = this.mAnswerItemsMap;
                    int i13 = R.string.incall_answer_after_hold_call;
                    hashMap4.put(context.getString(i13, str), 1);
                    this.mAnswerItems.add(context.getString(i13, str));
                }
            }
            T5.a d10 = BrandCenter.f19187a.a().d();
            if (d10 != null && d10.F()) {
                HashMap<String, Integer> hashMap5 = this.mAnswerItemsMap;
                int i14 = R.string.oplus_merge;
                hashMap5.put(context.getString(i14, str), 3);
                this.mAnswerItems.add(context.getString(i14, str));
                Log.i(LOG_TAG, "showMergeOption");
            }
        } else if (hasConferenceCall) {
            HashMap<String, Integer> hashMap6 = this.mAnswerItemsMap;
            int i15 = R.string.incall_answer_after_end_conference;
            hashMap6.put(context.getString(i15), 0);
            this.mAnswerItemsMap.put(context.getString(i15), 2);
            this.mAnswerItems.add(context.getString(i15));
        } else if (!z10) {
            HashMap<String, Integer> hashMap7 = this.mAnswerItemsMap;
            int i16 = R.string.incall_answer_after_end_call;
            hashMap7.put(context.getString(i16, str), 0);
            this.mAnswerItemsMap.put(context.getString(i16, str2), 2);
            this.mAnswerItems.add(context.getString(i16, str));
            this.mAnswerItems.add(context.getString(i16, str2));
        } else {
            HashMap<String, Integer> hashMap8 = this.mAnswerItemsMap;
            int i17 = R.string.incall_answer_end_all_call;
            hashMap8.put(context.getString(i17), 4);
            this.mAnswerItems.add(context.getString(i17));
        }
        this.mCallSize = this.mOplusCallList.oplusGetCallSize();
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context, R.style.COUIAlertDialog_Bottom);
        if (!isEmpty && !z10) {
            str3 = context.getString(R.string.answer_summary_when_multiple_call);
        } else {
            str3 = null;
        }
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.setMessage((CharSequence) str3).setItems((CharSequence[]) this.mAnswerItems.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.android.incallui.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i18) {
                OplusAnswerFragment.this.lambda$showDialogToSelectAction$7(context, dialogInterface, i18);
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.incallui.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i18) {
                OplusAnswerFragment.this.lambda$showDialogToSelectAction$8(dialogInterface, i18);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.incallui.m
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                OplusAnswerFragment.this.lambda$showDialogToSelectAction$9(dialogInterface);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.incallui.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                Log.d(OplusAnswerFragment.LOG_TAG, "showDialogToSelectAction: onDismiss");
            }
        }).show();
        this.mAnswerSelectDialog = show;
        show.setCanceledOnTouchOutside(true);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "showDialogToSelectAction has showing");
        }
    }

    private void showInterceptSelectionDialog() {
        if (this.mInterceptSelectionDialog == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "showInterceptSelectionDialog create mInterceptSelectionDialog");
            }
            int i10 = R.string.oplus_title_decline_and_intercept_mark_number;
            String string = getString(i10);
            if (OplusPhoneUtils.getAvailableCardSize(getContext()) == 2) {
                int p10 = D2.f.p();
                if (p10 == 0) {
                    string = getString(R.string.sim_1, getString(i10));
                } else if (p10 == 1) {
                    string = getString(R.string.sim_2, getString(i10));
                }
            }
            androidx.appcompat.app.b create = new COUIAlertDialogBuilder(getActivity()).setTitle((CharSequence) string).setView(this.mInterceptSelectionView).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.incallui.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    OplusAnswerFragment.this.lambda$showInterceptSelectionDialog$2(dialogInterface, i11);
                }
            }).setPositiveButton(R.string.oplus_confirm_intercept, new DialogInterface.OnClickListener() { // from class: com.android.incallui.q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    OplusAnswerFragment.this.lambda$showInterceptSelectionDialog$3(dialogInterface, i11);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.incallui.r
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    OplusAnswerFragment.this.lambda$showInterceptSelectionDialog$4(dialogInterface);
                }
            }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.android.incallui.s
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                    boolean lambda$showInterceptSelectionDialog$5;
                    lambda$showInterceptSelectionDialog$5 = OplusAnswerFragment.lambda$showInterceptSelectionDialog$5(dialogInterface, i11, keyEvent);
                    return lambda$showInterceptSelectionDialog$5;
                }
            }).create();
            this.mInterceptSelectionDialog = create;
            create.setCanceledOnTouchOutside(true);
        }
        this.mInterceptSelectionDialog.show();
        View findViewById = this.mInterceptSelectionDialog.findViewById(R.id.customPanel);
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) layoutParams)).weight = 1.0f;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    private void showSmsListDialog() {
        if (this.mSmsDialog == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "showSmsListDialog create mSmsDialog");
            }
            ArrayList<String> arrayList = this.mSmsRefuseList;
            if (arrayList != null && !arrayList.isEmpty()) {
                Context context = getContext();
                if (context == null) {
                    Log.d(LOG_TAG, "showSmsListDialog: context is null");
                    return;
                } else {
                    androidx.appcompat.app.b create = new COUIAlertDialogBuilder(context, R.style.COUIAlertDialog_Bottom).setAdapter((ListAdapter) new ArrayAdapter(context, R.layout.select_refused_sms_dialog_layout, R.id.select_refused_sms, this.mSmsRefuseList) { // from class: com.android.incallui.OplusAnswerFragment.2
                        private void resetPadding(int i10, View view) {
                            if (view != null) {
                                if (i10 == getCount() - 1 || i10 == 0) {
                                    int dimensionPixelSize = OplusAnswerFragment.this.getResources().getDimensionPixelSize(R.dimen.alert_dialog_item_padding_offset);
                                    if (i10 == getCount() - 1) {
                                        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom() + dimensionPixelSize);
                                    } else {
                                        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop() + dimensionPixelSize, view.getPaddingEnd(), view.getPaddingBottom());
                                    }
                                    view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                                }
                            }
                        }

                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public Object getItem(int i10) {
                            return OplusAnswerFragment.this.mSmsRefuseList.get(i10);
                        }

                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i10, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i10, null, viewGroup);
                            if (OplusAnswerFragment.this.mSmsRefuseList != null && i10 == 4) {
                                view2.findViewById(R.id.next_icon).setVisibility(0);
                            }
                            resetPadding(i10, view2);
                            return view2;
                        }
                    }, (DialogInterface.OnClickListener) this).setNegativeButton(R.string.hide_sms_list_view, new DialogInterface.OnClickListener() { // from class: com.android.incallui.i
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i10) {
                            OplusAnswerFragment.this.lambda$showSmsListDialog$0(dialogInterface, i10);
                        }
                    }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.incallui.j
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                            OplusAnswerFragment.this.lambda$showSmsListDialog$1(dialogInterface);
                        }
                    }).create();
                    this.mSmsDialog = create;
                    create.setCanceledOnTouchOutside(true);
                }
            } else {
                Log.d(LOG_TAG, "showSmsListDialog: mSmsRefuseList is null or isEmpty");
                return;
            }
        }
        this.mSmsDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSmsListView() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "showSmsListView mShow = " + this.mShow);
        }
        if (!this.mShow) {
            return;
        }
        onSilenceRinger();
        showSmsListDialog();
    }

    public void disconnectCall(String str) {
        TelecomAdapter.getInstance().disconnectCall(str);
    }

    public void displayAnswerView(int i10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "displayAnswerView viewType = " + i10);
        }
        if (isSmsListDialogShowing()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "Sms is show  return");
                return;
            }
            return;
        }
        C1581a floatingWindowController = InCallPresenter.getInstance().getFloatingWindowController();
        if (i10 != 2 && i10 != 0) {
            if (i10 == 1) {
                if (floatingWindowController == null || !floatingWindowController.G()) {
                    ((OplusInCallPresenter) InCallPresenter.getInstance()).setIncomingInterfaceType(2);
                    return;
                }
                return;
            }
            return;
        }
        if (floatingWindowController == null || !floatingWindowController.G()) {
            ((OplusInCallPresenter) InCallPresenter.getInstance()).setIncomingInterfaceType(1);
        }
    }

    @Override // androidx.fragment.app.Fragment, com.android.incallui.AnswerPresenter.AnswerUi
    public Context getContext() {
        return getActivity();
    }

    public String getNameOrNumber(Call call) {
        ContactInfoCache.ContactCacheEntry contactCacheEntry;
        Log.d(LOG_TAG, "getNameOrNumber  = " + call);
        OplusInCallPresenter oplusInCallPresenter = (OplusInCallPresenter) InCallPresenter.getInstance();
        if (oplusInCallPresenter != null && oplusInCallPresenter.getActivity() != null) {
            contactCacheEntry = call.getContactInfo();
        } else {
            contactCacheEntry = null;
        }
        Log.d(LOG_TAG, "getNameOrNumber mPrimaryContactInfo=" + contactCacheEntry);
        if (contactCacheEntry != null) {
            if (TextUtils.isEmpty(contactCacheEntry.name)) {
                if (!TextUtils.isEmpty(contactCacheEntry.number)) {
                    String formatNumber = PhoneNumberUtils.formatNumber(contactCacheEntry.number, null, InternalSdkDepends.getSInstance().getCurrentCountryIso(getContext()));
                    Log.d(LOG_TAG, "getNameOrNumber contactInfo number=" + D2.g.l(formatNumber));
                    return "\u200e" + formatNumber;
                }
            } else {
                return contactCacheEntry.name;
            }
        }
        String formatNumber2 = PhoneNumberUtils.formatNumber(call.getNumber(), null, InternalSdkDepends.getSInstance().getCurrentCountryIso(getContext()));
        Log.d(LOG_TAG, "getNameOrNumber call number=" + D2.g.l(formatNumber2));
        if (TextUtils.isEmpty(call.getNumber())) {
            return null;
        }
        return "\u200e" + formatNumber2;
    }

    public int getSmsRefuseListSize() {
        ArrayList<String> arrayList = this.mSmsRefuseList;
        if (arrayList == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "getSmsRefuseListSize  mSmsRefuseList return 0");
                return 0;
            }
            return 0;
        }
        return arrayList.size();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.BaseFragment
    public AnswerPresenter.AnswerUi getUi() {
        return this;
    }

    public boolean hasPendingDialogs() {
        return false;
    }

    public void hideSmsListView() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "hideSmsListView");
        }
        hideSmsListDialog();
        if (OplusPhoneUtils.isRideMode()) {
            displayAnswerView(2);
        } else if (OplusPhoneUtils.getShowLockScreenAnswerView()) {
            getPresenter().setScreenLocked(true);
            displayAnswerView(0);
        } else {
            displayAnswerView(1);
        }
    }

    public boolean isAnswerSelectDialogShowing() {
        androidx.appcompat.app.b bVar = this.mAnswerSelectDialog;
        if (bVar != null && bVar.isShowing()) {
            return true;
        }
        return false;
    }

    public boolean isInterceptSelectionDialogShowing() {
        androidx.appcompat.app.b bVar = this.mInterceptSelectionDialog;
        if (bVar != null && bVar.isShowing()) {
            return true;
        }
        return false;
    }

    public void log(String str) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, str);
        }
    }

    public void maybeDismissAnswerSelectDialog() {
        if (this.mOplusCallList == null) {
            this.mOplusCallList = (OplusCallList) CallList.getInstance();
        }
        if (this.mCallSize == this.mOplusCallList.oplusGetCallSize()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "refreshAlertDialog mCallSize is same, return");
                return;
            }
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.android.incallui.h
            @Override // java.lang.Runnable
            public final void run() {
                OplusAnswerFragment.this.notifyUiReady();
            }
        });
    }

    @Override // g2.InterfaceC1034a
    public void onAnswer(int i10, Context context, int i11) {
        if (Log.sDebug) {
            D2.g.a(LOG_TAG, "onAnswer videoState=" + i10 + " context=" + context + "deviceId=" + i11);
        }
        chooseAnswer(i10, context, i11);
    }

    public void onBackReplyMsgClick(String str) {
        onDeclineWithSms(getContext(), str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.oplus_answer_fragment, viewGroup, false);
    }

    @Override // g2.InterfaceC1034a
    public void onDecline(Context context) {
        onDeclineWithSms(context, null);
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onDestroyView");
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10) {
            getPresenter().notifyAnswerRepositoryForVisibilityChanged();
        }
    }

    public void onReplyNewMsgClick() {
        boolean z10;
        if (getActivity() != null) {
            z10 = OplusPhoneUtils.isScreenLocked(getActivity());
            this.mIsSecure = ((OplusInCallActivity) getActivity()).isSecureMode();
        } else {
            z10 = false;
        }
        if (z10) {
            OplusPhoneUtils.dismissKeyguard();
        }
        log("delayInMillis = 100 mIsSecure =" + this.mIsSecure + " isScreenLocked = " + z10);
        this.mHandler.sendEmptyMessageDelayed(OPLUS_MSG_DELAY_GOTO_REPLY_NEW_MSG, (long) 100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        notifyUiReady();
        getPresenter().notifyAnswerRepositoryForVisibilityChanged();
    }

    @Override // com.android.incallui.AnswerPresenter.AnswerUi
    public void onShowAnswerUi(boolean z10) {
        boolean z11;
        if (z10) {
            D2.f.P(D2.f.F(getContext(), CallList.getInstance().getIncomingCall()));
            D2.f.L(false);
        } else {
            D2.f.P(false);
        }
        if (z10) {
            com.android.incallui.oplus.answerview.fragment.d.f18742a.f(getChildFragmentManager());
        } else {
            com.android.incallui.oplus.answerview.fragment.d.f18742a.e(getChildFragmentManager());
        }
        boolean phoneScreenLockState = OplusPhoneUtils.getPhoneScreenLockState(InCallPresenter.getInstance().getContext());
        if (phoneScreenLockState && CallList.getInstance().oplusCallList().oplusGetCallSize() == 1) {
            OplusPhoneUtils.setIsLockScreenWhenFirstCallInComing(true);
        }
        if (phoneScreenLockState && CallList.getInstance().oplusCallList().oplusGetCallSize() == 1 && !G2.a.a(getContext())) {
            z11 = true;
        } else {
            z11 = false;
        }
        OplusPhoneUtils.setShowLockScreenAnswerView(z11);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "showAnswerUi isScreenLock = " + phoneScreenLockState + "  isScreenLockWhenIncomingCall = " + z11);
        }
        setVisible(z10);
        if (Log.sDebug) {
            Log.d(LOG_TAG, "Show answer UI: " + z10);
        }
        this.mShow = z10;
        Call incomingCall = CallList.getInstance().getIncomingCall();
        if (incomingCall != null) {
            updateSideWaveView(z10, incomingCall.getContactInfo());
        } else {
            updateSideWaveView(false, null);
        }
        removeSmsListDialog();
        removeInterceptSelectionDialog();
        removeAnswerSelectDialog();
        if (z10) {
            if (OplusPhoneUtils.isRideMode()) {
                displayAnswerView(2);
            } else if (OplusPhoneUtils.getShowLockScreenAnswerView()) {
                getPresenter().setScreenLocked(true);
                displayAnswerView(0);
            } else {
                displayAnswerView(1);
            }
        }
    }

    @Override // g2.InterfaceC1034a
    public void onShowInterceptSelectionDialog() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onShowInterceptSelectionDialog...");
        }
        onSilenceRinger();
        initInterceptSelectionView(D2.f.o(), D2.f.p());
        showInterceptSelectionDialog();
        OplusPhoneUserActionStatistics.onCommon(getContext(), OplusPhoneUserActionStatistics.TAG_HARASS_INTERCEPT, OplusPhoneUserActionStatistics.INCOMING_CALL_CLICK_DECLINE_AND_INTERCEPT_ICON, (Map) null);
    }

    @Override // g2.InterfaceC1034a
    public void onShowSmsListView() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onShowSmsListView...");
        }
        if (!OplusPhoneUtils.isReplyWithSmsAllowed(getContext())) {
            Toast c10 = A2.b.b().c(R.string.oplus_multiuser_sms_unauthorized, 0);
            if (c10 != null) {
                c10.show();
                return;
            }
            return;
        }
        queryRefuseMessage(true);
    }

    public void onSilenceRinger() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onSilenceRinger");
        }
        OplusPhoneUtils.silenceRinger(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onStart");
        }
        super.onStart();
        if (this.mHandler.hasMessages(OPLUS_MSG_QUERY_REFUSE_MSG)) {
            this.mHandler.removeMessages(OPLUS_MSG_QUERY_REFUSE_MSG);
        }
        this.mHandler.sendEmptyMessage(OPLUS_MSG_QUERY_REFUSE_MSG);
        if (!this.mDrawableInited) {
            this.mDrawableInited = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "onStop");
        }
        super.onStop();
        if (CallList.getInstance().getIncomingCall() != null && isSmsListDialogShowing()) {
            hideSmsListView();
        }
        removeSmsListDialog();
        ArrayList<String> arrayList = this.mSmsRefuseList;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (CallList.getInstance().getIncomingCall() != null && isInterceptSelectionDialogShowing()) {
            hideInterceptDialogAndRestoreAnswerView();
            removeInterceptSelectionDialog();
        }
    }

    @Override // com.android.incallui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setZ(3.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Log.d(LOG_TAG, "onViewStateRestored");
        super.onViewStateRestored(bundle);
        setVisible(false);
    }

    public void queryCallRefuseMessage() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "queryCallRefuseMessage");
        }
        ArrayList<String> arrayList = this.mSmsRefuseList;
        if (arrayList != null) {
            arrayList.clear();
        }
        Call incomingCall = CallList.getInstance().getIncomingCall();
        if (incomingCall != null) {
            List<String> cannedSmsResponses = incomingCall.getCannedSmsResponses();
            if (cannedSmsResponses != null && cannedSmsResponses.size() >= 1) {
                ArrayList<String> arrayList2 = this.mSmsRefuseList;
                if (arrayList2 != null) {
                    arrayList2.addAll(cannedSmsResponses);
                    return;
                }
                return;
            }
            Log.d(LOG_TAG, "queryCallRefuseMessage ,no response sms");
        }
    }

    public void queryRefuseMessage(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "queryRefuseMessage needShow=" + z10);
        }
        if (this.mSmsRefuseList == null) {
            this.mSmsRefuseList = new ArrayList<>();
        }
        if (!this.mSmsRefuseList.isEmpty()) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "queryRefuseMessage not empty list");
            }
            if (z10) {
                showSmsListView();
                return;
            }
            return;
        }
        queryCallRefuseMessage();
        ArrayList<String> arrayList = this.mSmsRefuseList;
        if (arrayList != null && !arrayList.isEmpty()) {
            boolean needAddRejectCustomizeMsg = needAddRejectCustomizeMsg();
            this.mShowRejectCustomizeMsg = needAddRejectCustomizeMsg;
            if (needAddRejectCustomizeMsg && getContext() != null) {
                this.mSmsRefuseList.add(getContext().getString(R.string.oplus_reject_customize_msg));
            }
            if (z10) {
                if (this.mHandler.hasMessages(OPLUS_MSG_DELAY_SHOW_SMS_LISTVIEW)) {
                    this.mHandler.removeMessages(OPLUS_MSG_DELAY_SHOW_SMS_LISTVIEW);
                }
                this.mHandler.sendEmptyMessage(OPLUS_MSG_DELAY_SHOW_SMS_LISTVIEW);
            }
        }
    }

    @Override // com.android.incallui.AnswerPresenter.AnswerUi
    public void refreshAlertDialog() {
        if (isAnswerSelectDialogShowing()) {
            maybeDismissAnswerSelectDialog();
            if (Log.sDebug) {
                Log.d(LOG_TAG, "refreshAlertDialog...");
            }
        }
    }

    @Override // com.android.incallui.BaseFragment
    public void releaseResources() {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "releaseResources...");
        }
        super.releaseResources();
        this.mDrawableInited = false;
        removeSmsListDialog();
        removeInterceptSelectionDialog();
        removeAnswerSelectDialog();
    }

    public void removeAnswerSelectDialog() {
        androidx.appcompat.app.b bVar = this.mAnswerSelectDialog;
        if (bVar != null) {
            bVar.dismiss();
            this.mAnswerSelectDialog = null;
        }
    }

    @Override // com.android.incallui.Ui
    public void setVisible(boolean z10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setVisible on = " + z10);
        }
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        Fragment m02 = supportFragmentManager.m0(InterfaceC0519a.f12084a.get(4).getName());
        if (m02 != null && m02.isAdded()) {
            if (z10) {
                supportFragmentManager.p().y(m02).j();
                return;
            } else {
                supportFragmentManager.p().p(m02).j();
                return;
            }
        }
        if (Log.sDebug) {
            Log.d(LOG_TAG, "setVisible: answerFragment is null or not added");
        }
    }

    @Override // com.android.incallui.AnswerPresenter.AnswerUi
    public void updateSideWaveView(boolean z10, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        boolean z11;
        if (Log.sDebug) {
            Log.d(LOG_TAG, "updateSideWaveView, show = " + z10 + ", entry = " + contactCacheEntry);
        }
        Context context = InCallPresenter.getInstance().getContext();
        if (z10 && OplusPhoneUtils.needShowSideWaveView(context)) {
            z11 = true;
        } else {
            z11 = false;
        }
        ((OplusInCallViewModel) new androidx.lifecycle.K(requireActivity()).a(OplusInCallViewModel.class)).r().m(Boolean.valueOf(z11));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.incallui.BaseFragment
    public AnswerPresenter createPresenter() {
        return InCallPresenter.getInstance().getAnswerPresenter();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        ArrayList<String> arrayList;
        Log.i(LOG_TAG, "showSmsListDialog onClick: position = " + i10);
        saveIncomingNumberToTemp();
        if (TextUtils.isEmpty(this.mTempReplyNumber)) {
            hideSmsListView();
            Toast c10 = A2.b.b().c(R.string.oplus_toast_null_incoming_number, 0);
            if (c10 != null) {
                c10.show();
                return;
            }
            return;
        }
        Call incomingCall = CallList.getInstance().getIncomingCall();
        if (incomingCall != null) {
            incomingCall.setAutoReplySms(false);
        }
        if (this.mShowRejectCustomizeMsg && (arrayList = this.mSmsRefuseList) != null && i10 == arrayList.size() - 1) {
            onReplyNewMsgClick();
            return;
        }
        try {
            ArrayList<String> arrayList2 = this.mSmsRefuseList;
            if (arrayList2 != null) {
                String str = arrayList2.get(i10);
                Log.i(LOG_TAG, "messgeText:" + str);
                onBackReplyMsgClick(str);
            }
        } catch (Exception e10) {
            Log.d(LOG_TAG, "Exception: " + e10.toString());
        }
    }

    @Override // com.android.incallui.AnswerPresenter.AnswerUi
    public void configureMessageDialog(List<String> list) {
    }

    @Override // com.android.incallui.AnswerPresenter.AnswerUi
    public void showMessageDialog() {
    }

    @Override // com.android.incallui.AnswerPresenter.AnswerUi
    public void showTargets(int i10) {
    }
}
