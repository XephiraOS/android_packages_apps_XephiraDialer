package v6;

import android.util.Log;
import com.oplus.utils.C0846g;

/* compiled from: CallFilterLog.java */
/* renamed from: v6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1627a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f37409a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f37410b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f37411c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f37412d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f37413e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f37414f;

    static {
        boolean c10 = C0846g.c();
        f37409a = c10;
        f37410b = c10;
        f37411c = c10;
        f37412d = c10;
        f37413e = c10;
        f37414f = false;
    }

    public static void a(Object obj, String str) {
        if (f37411c) {
            Log.d("CallFilter", j(obj) + str);
        }
    }

    public static void b(Object obj, String str, Object obj2) {
        if (f37411c) {
            Log.d("CallFilter", j(obj) + str + obj2);
        }
    }

    public static void c(String str, String str2) {
        if (f37411c) {
            Log.d("CallFilter", f(str) + str2);
        }
    }

    public static void d(String str, String str2) {
        c(str, "ANTI_HARASSMENT: " + str2);
    }

    public static void e(String str, String str2) {
        c(str, "INCALL_QUERY: " + str2);
    }

    public static String f(String str) {
        return str + com.android.incallui.Log.TAG_DELIMETER;
    }

    public static void g(Object obj, String str) {
        Log.e("CallFilter", j(obj) + str);
    }

    public static void h(String str, String str2) {
        Log.e("CallFilter", f(str) + str2);
    }

    public static void i(String str, String str2, Exception exc) {
        Log.e("CallFilter", f(str) + str2 + exc);
    }

    public static String j(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.getClass().getSimpleName() + com.android.incallui.Log.TAG_DELIMETER;
    }

    public static void k(String str, String str2) {
        if (f37413e) {
            Log.i("CallFilter", f(str) + str2);
        }
    }

    public static void l(String str, String str2) {
        k(str, "ANTI_HARASSMENT: " + str2);
    }

    public static void m(String str, String str2) {
        k(str, "INCALL_QUERY: " + str2);
    }

    public static void n() {
        boolean c10 = C0846g.c();
        f37409a = c10;
        f37410b = c10;
        f37411c = c10;
        f37412d = c10;
        f37413e = c10;
    }

    public static void o(Object obj, String str) {
        if (f37412d) {
            Log.v("CallFilter", j(obj) + str);
        }
    }

    public static void p(Object obj, String str, Object obj2) {
        if (f37412d) {
            Log.d("CallFilter", j(obj) + str + obj2);
        }
    }

    public static void q(Object obj, String str) {
        Log.w("CallFilter", j(obj) + str);
    }

    public static void r(Object obj, String str) {
        Log.wtf("CallFilter", j(obj) + str);
    }
}
