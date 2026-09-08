package com.oplus.phonenoareainquire;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: CountryDetector.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static a f28841e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f28842a;

    /* renamed from: b, reason: collision with root package name */
    public final C0277a f28843b;

    /* renamed from: c, reason: collision with root package name */
    public final TelephonyManager f28844c;

    /* renamed from: d, reason: collision with root package name */
    public final String f28845d;

    /* compiled from: CountryDetector.java */
    /* renamed from: com.oplus.phonenoareainquire.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0277a {
        public Locale a() {
            return Locale.getDefault();
        }
    }

    public a(Context context) {
        this(context, (TelephonyManager) context.getSystemService("phone"), new C0277a());
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f28841e == null) {
                    f28841e = new a(context.getApplicationContext());
                }
                aVar = f28841e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public String a() {
        String str;
        if (f()) {
            str = d();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = e();
        }
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        if (TextUtils.isEmpty(str) || g(str)) {
            str = "US";
        }
        return str.toUpperCase(Locale.US);
    }

    public final String c() {
        Locale a10 = this.f28843b.a();
        if (a10 != null) {
            return a10.getCountry();
        }
        return null;
    }

    public final String d() {
        return this.f28844c.getNetworkCountryIso();
    }

    public final String e() {
        return this.f28844c.getSimCountryIso();
    }

    public final boolean f() {
        if (this.f28844c.getPhoneType() == 1) {
            return true;
        }
        return false;
    }

    public boolean g(String str) {
        if (!Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public a(Context context, TelephonyManager telephonyManager, C0277a c0277a) {
        this.f28845d = "US";
        this.f28844c = telephonyManager;
        this.f28843b = c0277a;
        this.f28842a = context;
    }
}
