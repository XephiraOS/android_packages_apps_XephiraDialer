package com.android.incallui;

import android.content.Intent;
import android.os.IBinder;
import android.telecom.CallAudioState;
import android.telecom.InCallService;
import android.telephony.TelephonyManager;

/* loaded from: classes.dex */
public class InCallServiceImpl extends InCallService {
    static TelephonyManager mTelephonyManager;
    static int sPhoneCount = D2.l.a(OplusInCallApp.getAppContext());

    public static boolean isDsdaEnabled() {
        Object b10 = D2.k.b(null, "android.telephony.TelephonyManager", "isConcurrentCallsPossible", null, null);
        if (b10 != null && ((Boolean) b10).booleanValue()) {
            return true;
        }
        return false;
    }

    private void tearDown() {
        Log.v(this, "tearDown");
        TelecomAdapter.getInstance().clearInCallService();
        CallList.getInstance().clearOnDisconnect();
        InCallPresenter.getInstance().tearDown();
    }

    @Override // android.telecom.InCallService, android.app.Service
    public IBinder onBind(Intent intent) {
        mTelephonyManager = (TelephonyManager) getApplicationContext().getSystemService("phone");
        TelecomAdapter.getInstance().setInCallService(this);
        return super.onBind(intent);
    }

    @Override // android.telecom.InCallService
    public void onBringToForeground(boolean z10) {
        InCallPresenter.getInstance().onBringToForeground(z10);
    }

    @Override // android.telecom.InCallService
    public void onCallAdded(android.telecom.Call call) {
        CallList.getInstance().onCallAdded(call);
        InCallPresenter.getInstance().onCallAdded(call);
    }

    @Override // android.telecom.InCallService
    public void onCallAudioStateChanged(CallAudioState callAudioState) {
        AudioModeProvider.getInstance().onAudioStateChanged(callAudioState);
    }

    @Override // android.telecom.InCallService
    public void onCallRemoved(android.telecom.Call call) {
        CallList.getInstance().onCallRemoved(call);
        InCallPresenter.getInstance().onCallRemoved(call);
    }

    @Override // android.telecom.InCallService
    public void onCanAddCallChanged(boolean z10) {
        InCallPresenter.getInstance().onCanAddCallChanged(z10);
    }

    @Override // android.telecom.InCallService
    public void onSilenceRinger() {
        if (CallList.getInstance() != null && CallList.getInstance().getIncomingCall() != null) {
            CallList.getInstance().getIncomingCall().setIsSilence(true);
        }
    }

    @Override // android.telecom.InCallService, android.app.Service
    public boolean onUnbind(Intent intent) {
        super.onUnbind(intent);
        InCallPresenter.getInstance().onServiceUnbind();
        tearDown();
        return false;
    }
}
