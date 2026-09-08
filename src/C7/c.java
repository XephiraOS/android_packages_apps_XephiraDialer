package C7;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: CountryDetector.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static c f399c;

    /* renamed from: a, reason: collision with root package name */
    public final a f400a;

    /* renamed from: b, reason: collision with root package name */
    public final TelephonyManager f401b;

    /* compiled from: CountryDetector.java */
    /* loaded from: classes3.dex */
    public static class a {
        public Locale a() {
            return Locale.getDefault();
        }
    }

    public c(Context context) {
        this(context, (TelephonyManager) context.getSystemService("phone"), new a());
    }

    public static synchronized c b(Context context) {
        c cVar;
        synchronized (c.class) {
            try {
                if (f399c == null) {
                    f399c = new c(context.getApplicationContext());
                }
                cVar = f399c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public String a() {
        String str;
        if (g()) {
            str = d();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = f();
        }
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        if (TextUtils.isEmpty(str) || h(str)) {
            str = "US";
        }
        if (H7.a.b()) {
            H7.b.b("CountryDetector", "result = " + str);
        }
        return str.toUpperCase(Locale.US);
    }

    public final String c() {
        Locale a10 = this.f400a.a();
        if (a10 != null) {
            return a10.getCountry();
        }
        return null;
    }

    public final String d() {
        return this.f401b.getNetworkCountryIso();
    }

    public String e() {
        String d10 = d();
        if (d10 != null) {
            return d10.toUpperCase(Locale.US);
        }
        return null;
    }

    public String f() {
        return this.f401b.getSimCountryIso();
    }

    public final boolean g() {
        if (this.f401b.getPhoneType() == 1) {
            return true;
        }
        return false;
    }

    public boolean h(String str) {
        if (TextUtils.isEmpty(str) || !Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public c(Context context, TelephonyManager telephonyManager, a aVar) {
        this.f401b = telephonyManager;
        this.f400a = aVar;
    }
}
