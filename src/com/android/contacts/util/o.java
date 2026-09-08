package com.android.contacts.util;

import a4.C0421a;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.incallui.OplusPhoneCapabilities;
import com.customize.contacts.util.h0;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.Map;

/* compiled from: IntelligentKinectUtils.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: f, reason: collision with root package name */
    public static final String f17586f = "o";

    /* renamed from: g, reason: collision with root package name */
    public static final Context f17587g = ContactsApplication.h().getBaseContext();

    /* renamed from: c, reason: collision with root package name */
    public Context f17590c;

    /* renamed from: a, reason: collision with root package name */
    public String f17588a = null;

    /* renamed from: b, reason: collision with root package name */
    public b f17589b = null;

    /* renamed from: d, reason: collision with root package name */
    public c f17591d = null;

    /* renamed from: e, reason: collision with root package name */
    public final BroadcastReceiver f17592e = new a();

    /* compiled from: IntelligentKinectUtils.java */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (H7.a.b()) {
                H7.b.b(o.f17586f, "mGuestureDialBroadcastReceiver onReceive");
            }
            if (o.this.f17591d != null && o.this.f17591d.a()) {
                if (H7.a.b()) {
                    H7.b.b(o.f17586f, "call recording is playing");
                    return;
                }
                return;
            }
            if (o.f().inKeyguardRestrictedInputMode()) {
                if (H7.a.b()) {
                    H7.b.b(o.f17586f, "keyguard enable");
                }
            } else {
                if (o.this.f17589b == null || o.this.f17589b.a()) {
                    o.this.g();
                    if (H7.a.b()) {
                        H7.b.b(o.f17586f, "notifyResult success");
                        return;
                    }
                    return;
                }
                if (H7.a.b()) {
                    H7.b.b(o.f17586f, "no need call");
                }
            }
        }
    }

    /* compiled from: IntelligentKinectUtils.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a();
    }

    /* compiled from: IntelligentKinectUtils.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a();
    }

    public static KeyguardManager f() {
        return (KeyguardManager) f17587g.getSystemService("keyguard");
    }

    public static boolean l() {
        boolean z10 = false;
        if (OsUtils.h()) {
            return false;
        }
        if (G0.c.d(f17587g, 0, com.android.contacts.compat.data.f.a("oplus_customize_smart_apperceive_dial"), 0) == 1) {
            z10 = true;
        }
        if (H7.a.b()) {
            H7.b.b(f17586f, "shouldRegisterIntelligentDialService switchOn = " + z10);
        }
        return z10;
    }

    public static void n() {
        ((Vibrator) f17587g.getSystemService("vibrator")).vibrate(100L);
    }

    public String e() {
        if (H7.a.b()) {
            H7.b.b(f17586f, "getIntelligentDialNumber mIntelligentDialNumber" + H7.a.d(this.f17588a));
        }
        return this.f17588a;
    }

    public final void g() {
        if (!CommonFeatureOption.j()) {
            return;
        }
        Context context = f17587g;
        if (((TelephonyManager) context.getSystemService("phone")).getCallState() == 0) {
            String e10 = e();
            if (TextUtils.isEmpty(e10)) {
                if (H7.a.b()) {
                    H7.b.b(f17586f, "intelligentDial(): the dial number is Empty.");
                    return;
                }
                return;
            }
            Map<String, String> b02 = h0.b0(this.f17590c);
            b02.put("scenarios", String.valueOf(1));
            com.android.contacts.framework.baseui.util.A.a(this.f17590c, 2000305, 200031809, b02, false);
            Intent intent = new Intent(C0421a.f6395a, Uri.fromParts("tel", e10, null));
            intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            R7.b.c(context, intent);
            n();
        }
    }

    public void h(Context context) {
        this.f17590c = context;
        context.registerReceiver(this.f17592e, new IntentFilter("com.gesture.dial.forDial"), R0.b.f3175i, null, 2);
    }

    public void i(String str) {
        this.f17588a = str;
    }

    public void j(b bVar) {
        this.f17589b = bVar;
    }

    public void k(c cVar) {
        this.f17591d = cVar;
    }

    public void m(Context context) {
        try {
            context.unregisterReceiver(this.f17592e);
        } catch (IllegalArgumentException e10) {
            H7.b.c(f17586f, "IllegalArgumentException" + e10);
        }
    }
}
