package com.android.incallui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telecom.Call;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class InCallLowBatteryListener implements CallList.Listener, InCallPresenter.InCallDetailsListener, InCallPresenter.InCallUiListener {
    private static InCallLowBatteryListener sInCallLowBatteryListener;
    private PrimaryCallTracker mPrimaryCallTracker;
    private CallList mCallList = null;
    private androidx.appcompat.app.b mAlert = null;
    private List<Call> mLowBatteryCalls = new CopyOnWriteArrayList();

    private InCallLowBatteryListener() {
    }

    private void dismissPendingDialogs() {
        androidx.appcompat.app.b bVar = this.mAlert;
        if (bVar != null && bVar.isShowing()) {
            this.mAlert.dismiss();
            this.mAlert = null;
        }
    }

    private void displayLowBatteryAlert(final Call call) {
        InCallActivity activity = InCallPresenter.getInstance().getActivity();
        if (activity == null) {
            Log.e(this, "displayLowBatteryAlert inCallActivity is NULL");
            return;
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(activity);
        cOUIAlertDialogBuilder.setTitle(R.string.low_battery);
        cOUIAlertDialogBuilder.setNegativeButton(R.string.low_battery_no, (DialogInterface.OnClickListener) null);
        cOUIAlertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.incallui.InCallLowBatteryListener.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Log.d(this, "displayLowBatteryAlert onDismiss");
                InCallLowBatteryListener.this.mAlert = null;
            }
        });
        if (QtiCallUtils.hasVoiceCapabilities(call)) {
            cOUIAlertDialogBuilder.setMessage(R.string.low_battery_downgrade_to_voice_msg);
            cOUIAlertDialogBuilder.setPositiveButton(R.string.low_battery_yes, new DialogInterface.OnClickListener() { // from class: com.android.incallui.InCallLowBatteryListener.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    Log.i(this, "displayLowBatteryAlert downgrading to voice call");
                    QtiCallUtils.downgradeToVoiceCall(call);
                }
            });
        } else {
            cOUIAlertDialogBuilder.setMessage(R.string.low_battery_hangup_msg);
            cOUIAlertDialogBuilder.setPositiveButton(R.string.low_battery_yes, new DialogInterface.OnClickListener() { // from class: com.android.incallui.InCallLowBatteryListener.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    Log.i(this, "displayLowBatteryAlert hanging up the call: " + call);
                    String id = call.getId();
                    call.setState(9);
                    CallList.getInstance().onUpdate(call);
                    TelecomAdapter.getInstance().disconnectCall(id);
                }
            });
        }
        androidx.appcompat.app.b create = cOUIAlertDialogBuilder.create();
        this.mAlert = create;
        create.setCanceledOnTouchOutside(false);
        this.mAlert.getWindow().addFlags(2);
        this.mAlert.show();
    }

    public static synchronized InCallLowBatteryListener getInstance() {
        InCallLowBatteryListener inCallLowBatteryListener;
        synchronized (InCallLowBatteryListener.class) {
            try {
                if (sInCallLowBatteryListener == null) {
                    sInCallLowBatteryListener = new InCallLowBatteryListener();
                }
                inCallLowBatteryListener = sInCallLowBatteryListener;
            } catch (Throwable th) {
                throw th;
            }
        }
        return inCallLowBatteryListener;
    }

    private void maybeProcessLowBatteryIndication(Call call, Call.Details details) {
        Bundle bundle;
        if (details != null) {
            bundle = details.getExtras();
        } else {
            bundle = null;
        }
        boolean z10 = false;
        if (bundle != null && bundle.getBoolean("LowBattery", false)) {
            z10 = true;
        }
        Log.i(this, "maybeProcessLowBatteryIndication: isLowBattery : " + z10);
        if (z10 && updateCallInMap(call)) {
            processLowBatteryIndication(call);
        }
    }

    private void processLowBatteryIndication(Call call) {
        Log.i(this, "processLowBatteryIndication call: " + call);
        if (CallUtils.isActiveUnPausedVideoCall(call)) {
            Log.i(this, "is an active unpaused video call");
            dismissPendingDialogs();
            displayLowBatteryAlert(call);
        }
    }

    private boolean updateCallInMap(Call call) {
        if (call == null) {
            Log.e(this, "call is null");
            return false;
        }
        boolean contains = this.mLowBatteryCalls.contains(call);
        if (!Call.State.isConnectingOrConnected(call.getState())) {
            if (contains) {
                this.mLowBatteryCalls.remove(call);
                return false;
            }
        } else {
            if (InCallPresenter.getInstance().getActivity() == null) {
                Log.i(this, "incallactivity is null");
                return false;
            }
            if (CallUtils.isActiveUnPausedVideoCall(call) && !contains && call.getParentId() == null) {
                this.mLowBatteryCalls.add(call);
                return true;
            }
        }
        return false;
    }

    @Override // com.android.incallui.InCallPresenter.InCallDetailsListener
    public void onDetailsChanged(Call call, Call.Details details) {
        Log.d(this, " onDetailsChanged call=" + call + " details=" + details);
        if (call != null && this.mPrimaryCallTracker.isPrimaryCall(call)) {
            maybeProcessLowBatteryIndication(call, details);
        } else {
            Log.d(this, " onDetailsChanged: call is null/Details not for primary call");
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onDisconnect(Call call) {
        Log.i(this, "onDisconnect call: " + call);
        updateCallInMap(call);
        if (this.mPrimaryCallTracker.isPrimaryCall(call)) {
            dismissPendingDialogs();
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onIncomingCall(Call call) {
        dismissPendingDialogs();
    }

    @Override // com.android.incallui.InCallPresenter.InCallUiListener
    public void onUiShowing(boolean z10) {
        Call primaryCall = this.mPrimaryCallTracker.getPrimaryCall();
        Log.i(this, "onUiShowing showing: " + z10 + "call = " + primaryCall);
        if (z10 && primaryCall != null) {
            maybeProcessLowBatteryIndication(primaryCall, primaryCall.getTelecommCall().getDetails());
        }
    }

    @Override // com.android.incallui.CallList.Listener
    public void onUpgradeToVideo(Call call) {
        dismissPendingDialogs();
    }

    public void setUp(Context context) {
        this.mPrimaryCallTracker = PrimaryCallTracker.getInstance();
        CallList callList = CallList.getInstance();
        this.mCallList = callList;
        callList.addListener(this);
        InCallPresenter.getInstance().addListener(this.mPrimaryCallTracker);
        InCallPresenter.getInstance().addIncomingCallListener(this.mPrimaryCallTracker);
        InCallPresenter.getInstance().addDetailsListener(this);
        InCallPresenter.getInstance().addInCallUiListener(this);
    }

    public void tearDown() {
        CallList callList = this.mCallList;
        if (callList != null) {
            callList.removeListener(this);
            this.mCallList = null;
        }
        InCallPresenter.getInstance().removeListener(this.mPrimaryCallTracker);
        InCallPresenter.getInstance().removeIncomingCallListener(this.mPrimaryCallTracker);
        InCallPresenter.getInstance().removeDetailsListener(this);
        InCallPresenter.getInstance().removeInCallUiListener(this);
        this.mPrimaryCallTracker = null;
    }

    @Override // com.android.incallui.CallList.Listener
    public void onCallListChange(CallList callList) {
    }
}
