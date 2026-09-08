package I6;

import Q6.c;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.utils.C0854o;
import java.util.Locale;

/* compiled from: CountryDetector.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static a f1352e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f1353a;

    /* renamed from: b, reason: collision with root package name */
    public final C0029a f1354b;

    /* renamed from: c, reason: collision with root package name */
    public final TelephonyManager f1355c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1356d;

    /* compiled from: CountryDetector.java */
    /* renamed from: I6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0029a {
        public Locale a() {
            return Locale.getDefault();
        }
    }

    public a(Context context) {
        this(context, (TelephonyManager) context.getSystemService("phone"), new C0029a());
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f1352e == null) {
                    f1352e = new a(context.getApplicationContext());
                }
                aVar = f1352e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public String a() {
        String str;
        if (h()) {
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
        if (TextUtils.isEmpty(str)) {
            str = "US";
        }
        return str.toUpperCase(Locale.US);
    }

    public final String c() {
        Locale a10 = this.f1354b.a();
        if (a10 != null) {
            return a10.getCountry();
        }
        return null;
    }

    public String d() {
        return this.f1355c.getNetworkCountryIso();
    }

    public String e(int i10) {
        return this.f1355c.getNetworkCountryIso(i10);
    }

    public String f() {
        return this.f1355c.getSimCountryIso();
    }

    public String g(int i10) {
        try {
            if (C0854o.a()) {
                return com.oplus.wrapper.telephony.TelephonyManager.getSimCountryIso(i10);
            }
            return c.a(i10);
        } catch (Throwable th) {
            Log.e("CountryDetector", th.toString());
            return "";
        }
    }

    public final boolean h() {
        if (this.f1355c.getPhoneType() == 1) {
            return true;
        }
        return false;
    }

    public a(Context context, TelephonyManager telephonyManager, C0029a c0029a) {
        this.f1356d = "US";
        this.f1355c = telephonyManager;
        this.f1354b = c0029a;
        this.f1353a = context;
    }
}
