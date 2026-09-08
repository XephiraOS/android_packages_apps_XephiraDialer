package A2;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telecom.Call;
import android.telecom.PhoneAccountHandle;
import android.text.TextUtils;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.CallerInfoUtils;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.oplus.share.OplusSelectPhoneAccountDialog;
import java.util.ArrayList;

/* compiled from: OplusSelectPhoneAccountManager.java */
/* loaded from: classes.dex */
public class v implements CallList.CallUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public Call f166a;

    /* renamed from: b, reason: collision with root package name */
    public Context f167b;

    /* renamed from: c, reason: collision with root package name */
    public OplusSelectPhoneAccountDialog f168c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<PhoneAccountHandle> f169d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f170e = new a(Looper.getMainLooper());

    /* compiled from: OplusSelectPhoneAccountManager.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                if (Log.sDebug) {
                    Log.d(this, "run check WaitingForAccountCall");
                }
                v.this.g((Call) message.obj);
            }
        }
    }

    public v(Context context) {
        this.f167b = context;
    }

    public static void r(Context context, int i10) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("oplus.android.intent.action.show_error_dialog");
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.putExtra("show_out_going_call_error", true);
        intent.putExtra("show_out_going_call_error_id", i10);
        context.startActivity(intent);
    }

    public static void s(Context context, ArrayList<PhoneAccountHandle> arrayList, PhoneAccountHandle phoneAccountHandle, int i10) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) OplusSelectPhoneAccountDialog.class);
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        if (arrayList != null) {
            intent.putParcelableArrayListExtra("selectPhoneAccountAccounts", arrayList);
        }
        if (!OplusPhoneUtils.getPhoneScreenLockState(context) && L1.c.g(context)) {
            intent.putExtra("dialog_type", 3);
            L1.c.i(OplusInCallApp.getInCallAppInstance(), intent);
        } else {
            if (phoneAccountHandle != null) {
                intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandle);
            }
            intent.putExtra("dialog_type", i10);
            L1.c.h(OplusInCallApp.getInCallAppInstance(), intent);
        }
    }

    public void b() {
        android.telecom.Call telecommCall;
        K2.a.c("OplusSelectPhoneAccountManager", "cancelPlaceCall... ");
        Call call = this.f166a;
        if (call == null) {
            telecommCall = null;
        } else {
            telecommCall = call.getTelecommCall();
        }
        if (telecommCall != null) {
            telecommCall.disconnect();
        }
    }

    public void c() {
        OplusSelectPhoneAccountDialog oplusSelectPhoneAccountDialog = this.f168c;
        if (oplusSelectPhoneAccountDialog != null) {
            oplusSelectPhoneAccountDialog.onCancel(null);
        }
    }

    public final boolean d(PhoneAccountHandle phoneAccountHandle) {
        PhoneAccountHandle accountHandle;
        Log.i(this, "checkCallInSamePhoneAccount phoneAccountHandle = " + phoneAccountHandle);
        Call activeOrBackgroundCall = CallList.getInstance().getActiveOrBackgroundCall();
        String str = null;
        if (activeOrBackgroundCall == null) {
            accountHandle = null;
        } else {
            accountHandle = activeOrBackgroundCall.getAccountHandle();
        }
        if (phoneAccountHandle != null) {
            str = phoneAccountHandle.getId();
        }
        if (accountHandle == null || TextUtils.isEmpty(str) || str.equals(accountHandle.getId())) {
            return true;
        }
        Log.i(this, "phoneAccountSelected not dsda ,can not dial in different phone account!!!");
        r(InCallPresenter.getInstance().getContext(), 1);
        return false;
    }

    public void e() {
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountManager", "cleanPreCallInfo...");
        }
        if (this.f166a != null) {
            CallList.getInstance().removeCallUpdateListener(this.f166a.getId(), this);
        }
        this.f166a = null;
        ArrayList<PhoneAccountHandle> arrayList = this.f169d;
        if (arrayList != null) {
            arrayList.clear();
        }
        OplusSelectPhoneAccountDialog oplusSelectPhoneAccountDialog = this.f168c;
        if (oplusSelectPhoneAccountDialog != null) {
            oplusSelectPhoneAccountDialog.u0();
        }
    }

    public void f() {
        Call i10 = i();
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountManager", "delaySendCheckMessage call: " + i10);
        }
        if (i10 != null) {
            if (this.f170e.hasMessages(1001)) {
                if (Log.sDebug) {
                    Log.d("OplusSelectPhoneAccountManager", "delaySendCheckMessage already check return ");
                }
            } else {
                this.f170e.sendMessageDelayed(this.f170e.obtainMessage(1001, i10), GrpcUtils.CREATE_CHANNEL_TIME_OUT);
            }
        }
    }

    public final void g(Call call) {
        android.telecom.Call telecommCall;
        Call waitingForAccountCall = CallList.getInstance().getWaitingForAccountCall();
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountManager", "disconnectSelectPhoneAccountCall currentCall: " + waitingForAccountCall);
        }
        if (call != null && waitingForAccountCall != null && waitingForAccountCall.getId() == call.getId() && (telecommCall = call.getTelecommCall()) != null) {
            telecommCall.disconnect();
        }
    }

    public Uri h() {
        Call call = this.f166a;
        if (call == null) {
            return null;
        }
        return call.getHandle();
    }

    public Call i() {
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountManager", "getSelectPhoneAccountCall mCall = " + this.f166a);
        }
        return this.f166a;
    }

    public boolean j() {
        boolean z10;
        if (this.f166a != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountManager", "hasInvalidSelectPhoneAccountCall bRet = " + z10);
        }
        return z10;
    }

    public boolean k(Uri uri) {
        if (uri == null || uri.getSchemeSpecificPart() == null || uri.getScheme() == null || !uri.getScheme().equals("tel")) {
            return false;
        }
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (!schemeSpecificPart.equals(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE) && ((!schemeSpecificPart.startsWith(OplusPhoneUtils.DeviceState.LOCK_DEVICE) || schemeSpecificPart.length() > 2) && ((!schemeSpecificPart.startsWith("2") || schemeSpecificPart.length() > 2) && !schemeSpecificPart.equals("3") && !schemeSpecificPart.equals("4") && !schemeSpecificPart.equals("5")))) {
            return false;
        }
        return true;
    }

    public boolean l(Uri uri) {
        if (uri != null && uri.getSchemeSpecificPart() != null && uri.getSchemeSpecificPart().contains("#")) {
            return true;
        }
        return false;
    }

    public void m(PhoneAccountHandle phoneAccountHandle, String str, int i10) {
        boolean z10;
        String str2;
        K2.a.c("OplusSelectPhoneAccountManager", "placeCall targetPhoneAccountHandle = " + phoneAccountHandle + " countryCode = " + D2.g.o(str) + " rakutenPrefix = " + i10);
        if (phoneAccountHandle != null && this.f166a != null && d(phoneAccountHandle)) {
            if (OplusPhoneUtils.isTelephonyRinging(OplusInCallApp.getAppContext())) {
                K2.a.c("OplusSelectPhoneAccountManager", "placeCall targetPhoneAccountHandle is ring state");
                b();
                return;
            }
            if (!k(this.f166a.getHandle()) && !l(this.f166a.getHandle()) && !D2.i.j(this.f167b, this.f166a.getNumber())) {
                this.f166a.setState(13);
                this.f166a.setPhoneAccountHandle(phoneAccountHandle);
                String id = this.f166a.getId();
                int d10 = d.d(phoneAccountHandle);
                CallList.getInstance().setActiveSubId(d10);
                String number = this.f166a.getNumber();
                String str3 = null;
                if ((this.f166a.getHandle() != null && "voicemail".equals(this.f166a.getHandle().getScheme())) || CallerInfoUtils.isVoiceMailNumber(this.f167b, phoneAccountHandle, number)) {
                    str2 = this.f167b.getResources().getString(R.string.voice_mail);
                    z10 = true;
                } else {
                    z10 = false;
                    str2 = null;
                }
                android.telecom.Call telecommCall = this.f166a.getTelecommCall();
                String telecommCallId = this.f166a.getTelecommCallId();
                OplusPhoneUtils.refreshOplusVideoCallEnable(phoneAccountHandle);
                if (d10 != -1 && !TextUtils.isEmpty(telecommCallId) && !TextUtils.isEmpty(number)) {
                    int c10 = d.c(phoneAccountHandle);
                    Call.Details details = telecommCall.getDetails();
                    if (details != null) {
                        if (c10 == 0) {
                            str3 = details.getIntentExtras().getString("sim_one_assisted_dialing_number");
                        } else if (c10 == 1) {
                            str3 = details.getIntentExtras().getString("sim_two_assisted_dialing_number");
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        l.d().s(telecommCallId, str3);
                        number = str3;
                    } else if (!TextUtils.isEmpty(str)) {
                        if (number.startsWith(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE) && number.length() > 1) {
                            number = number.substring(1);
                            Log.d("OplusSelectPhoneAccountManager", "placeCall number = " + D2.g.l(number));
                        }
                        number = str + number;
                        l.d().s(telecommCallId, number);
                    } else if (i10 == 1) {
                        number = OplusPhoneUtils.addRakutenPrefix(this.f167b, number);
                        l.d().s(telecommCallId, number);
                    }
                }
                this.f166a.updatePlaceCallContactInfo(str2, number, z10);
                CallList.getInstance().onUpdate(this.f166a);
                TelecomAdapter.getInstance().phoneAccountSelected(id, phoneAccountHandle, false);
                return;
            }
            if (this.f166a.getTelecommCall() != null) {
                this.f166a.getTelecommCall().phoneAccountSelected(phoneAccountHandle, false);
                return;
            }
            return;
        }
        b();
    }

    public void n() {
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountManager", "removeCheckMessage");
        }
        this.f170e.removeMessages(1001);
    }

    public final void o() {
        boolean z10;
        Context context = this.f167b;
        if (context == null) {
            return;
        }
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager != null) {
                z10 = keyguardManager.isKeyguardSecure();
            } else {
                z10 = false;
            }
            Log.d("OplusSelectPhoneAccountManager", "isSecure = " + z10);
            if (z10) {
                OplusPhoneUtils.dismissKeyguard();
            }
        } catch (Exception e10) {
            Log.e("OplusSelectPhoneAccountManager", "exception:" + e10.toString());
        }
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onCallChanged(com.android.incallui.Call call) {
        if (call == null) {
            return;
        }
        int state = call.getState();
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountManager", "onCallChanged callId = " + call.getId() + " state = " + state);
        }
        if (state != 12) {
            e();
        }
    }

    public void p(OplusSelectPhoneAccountDialog oplusSelectPhoneAccountDialog) {
        this.f168c = oplusSelectPhoneAccountDialog;
    }

    public void q(com.android.incallui.Call call) {
        int size;
        OplusSelectPhoneAccountDialog oplusSelectPhoneAccountDialog;
        K2.a.c("OplusSelectPhoneAccountManager", "setSelectPhoneAccountCall call = " + call);
        if (call != null && (oplusSelectPhoneAccountDialog = this.f168c) != null) {
            oplusSelectPhoneAccountDialog.finish();
        }
        if (call == null) {
            n();
        }
        if (call == null) {
            e();
            return;
        }
        this.f166a = call;
        Bundle intentExtras = call.getTelecommCall().getDetails().getIntentExtras();
        if (intentExtras != null) {
            ArrayList<PhoneAccountHandle> parcelableArrayList = intentExtras.getParcelableArrayList("selectPhoneAccountAccounts");
            this.f169d = parcelableArrayList;
            if (parcelableArrayList == null) {
                size = 0;
            } else {
                size = parcelableArrayList.size();
            }
            boolean z10 = intentExtras.getBoolean("oplus_japan_dialog", false);
            boolean z11 = intentExtras.getBoolean("oplus_rakuten_dialog", false);
            PhoneAccountHandle phoneAccountHandle = (PhoneAccountHandle) intentExtras.getParcelable("android.telecom.extra.PHONE_ACCOUNT_HANDLE");
            o();
            if (z10 && phoneAccountHandle != null) {
                s(InCallPresenter.getInstance().getContext(), null, phoneAccountHandle, 1);
            } else if (z11 && phoneAccountHandle != null) {
                s(InCallPresenter.getInstance().getContext(), null, phoneAccountHandle, 2);
            } else if (size > 1) {
                try {
                    s(InCallPresenter.getInstance().getContext(), this.f169d, null, 0);
                } catch (Exception e10) {
                    Log.d("OplusSelectPhoneAccountManager", "Exception: " + e10.toString());
                }
            }
        }
        CallList.getInstance().addCallUpdateListener(call.getId(), this);
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onChildNumberChange() {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onLastForwardedNumberChange() {
    }

    @Override // com.android.incallui.CallList.CallUpdateListener
    public void onSessionModificationStateChange(com.android.incallui.Call call, int i10) {
    }
}
