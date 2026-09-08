package A2;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.Log;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.TelecomAdapter;

/* compiled from: OplusPhoneStateListener.java */
/* loaded from: classes.dex */
public class p extends PhoneStateListener {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f153d = Log.sDebug;

    /* renamed from: a, reason: collision with root package name */
    public int f154a = 3;

    /* renamed from: b, reason: collision with root package name */
    public OplusInCallPresenter f155b;

    /* renamed from: c, reason: collision with root package name */
    public TelephonyManager f156c;

    public p(Context context, OplusInCallPresenter oplusInCallPresenter) {
        this.f155b = oplusInCallPresenter;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.f156c = telephonyManager;
        if (telephonyManager != null) {
            b();
        }
    }

    public final Call a() {
        OplusCallList oplusCallList = CallList.getInstance().oplusCallList();
        Call oplusGetOutgoingCall = oplusCallList.oplusGetOutgoingCall();
        if (oplusGetOutgoingCall == null) {
            oplusGetOutgoingCall = oplusCallList.oplusGetIncomingCall();
        }
        Log.d("OplusPhoneStateListener", " getOutgoingOrIncomingCall  call = " + oplusGetOutgoingCall);
        return oplusGetOutgoingCall;
    }

    public void b() {
        if (androidx.core.content.b.a(OplusInCallApp.getAppContext(), "android.permission.READ_PHONE_STATE") != 0) {
            android.util.Log.d("OplusPhoneStateListener", "NO READ_PHONE_STATE, return");
        } else if (OplusFeatureOption.OPLUS_PHONE_END_CALL_OUT_OF_SERVICE) {
            this.f156c.listen(this, 33);
        } else {
            this.f156c.listen(this, 32);
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i10, String str) {
        if (f153d) {
            Log.d("OplusPhoneStateListener", "MyPhoneStateListener onCallStateChanged = " + i10);
        }
        if (i10 == 2) {
            this.f155b.sendIncallActivityStateMessage();
        }
        super.onCallStateChanged(i10, str);
    }

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(ServiceState serviceState) {
        Call a10;
        int state = serviceState.getState();
        if (f153d) {
            Log.d("OplusPhoneStateListener", "onServiceStateChanged  newState = " + state + " mServiceState = " + this.f154a);
        }
        if (state == 1 && this.f154a != state && (a10 = a()) != null && !a10.isEmergencyCall()) {
            Log.d("OplusPhoneStateListener", " disconnectCall because of OUT_OF_SERVICE");
            TelecomAdapter.getInstance().disconnectCall(a10.getId());
        }
        this.f154a = state;
    }
}
