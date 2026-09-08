package com.oplus.foundation.util;

import C7.b;
import M6.a;
import android.os.Build;
import android.text.TextUtils;
import com.oplus.wrapper.os.SystemProperties;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import m9.d;
import m9.e;
import v9.InterfaceC1637a;

/* compiled from: OsUtils.kt */
/* loaded from: classes3.dex */
public final class OsUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final OsUtils f28275a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f28276b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f28277c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f28278d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f28279e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f28280f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f28281g;

    static {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        OsUtils osUtils = new OsUtils();
        f28275a = osUtils;
        int a10 = osUtils.a();
        boolean z14 = false;
        if (a10 >= 30) {
            z10 = true;
        } else {
            z10 = false;
        }
        f28277c = z10;
        if (a10 >= 29) {
            z11 = true;
        } else {
            z11 = false;
        }
        f28278d = z11;
        if (a10 > 30) {
            z12 = true;
        } else {
            z12 = false;
        }
        f28276b = z12;
        if (a10 > 33) {
            z13 = true;
        } else {
            z13 = false;
        }
        f28279e = z13;
        if (a10 > 34) {
            z14 = true;
        }
        f28280f = z14;
        f28281g = e.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<String>() { // from class: com.oplus.foundation.util.OsUtils$otaVersion$2
            @Override // v9.InterfaceC1637a
            public final String invoke() {
                Object b10;
                String a11;
                String a12;
                try {
                    Result.a aVar = Result.f34166a;
                    if (b.a(30, 1)) {
                        a11 = SystemProperties.get("ro.build.version.ota");
                    } else {
                        a11 = a.a("ro.build.version.ota");
                    }
                    if (b.a(30, 1)) {
                        a12 = SystemProperties.get("persist.sys.oplus.sota_ver_curr");
                    } else {
                        a12 = a.a("persist.sys.oplus.sota_ver_curr");
                    }
                    if (!TextUtils.isEmpty(a12)) {
                        a11 = a11 + "(" + a12 + ")";
                    }
                    b10 = Result.b(a11);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    H7.b.c("OsUtils", "get ota version failed e: " + d10);
                }
                if (Result.f(b10)) {
                    b10 = null;
                }
                String str = (String) b10;
                return str == null ? "" : str;
            }
        });
    }

    public static final boolean c() {
        if (D7.a.l() > 22) {
            return true;
        }
        return false;
    }

    public static final boolean d(int i10) {
        if (i10 > 22) {
            return true;
        }
        return false;
    }

    public static final boolean e() {
        if (D7.a.l() >= 29) {
            return true;
        }
        return false;
    }

    public static final boolean f() {
        if (D7.a.l() >= 31) {
            return true;
        }
        return false;
    }

    public static final boolean g() {
        if (D7.a.l() >= 33) {
            return true;
        }
        return false;
    }

    public static final boolean h() {
        if (D7.a.l() >= 34) {
            return true;
        }
        return false;
    }

    public static final boolean k() {
        return true;
    }

    public static final boolean l() {
        if (D7.a.l() <= 21) {
            return true;
        }
        return false;
    }

    public static final boolean m() {
        if (D7.a.l() > 21) {
            return true;
        }
        return false;
    }

    public final int a() {
        return Build.VERSION.SDK_INT;
    }

    public final String b() {
        return (String) f28281g.getValue();
    }

    public final boolean i() {
        return f28277c;
    }

    public final boolean j() {
        return f28276b;
    }
}
