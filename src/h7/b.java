package H7;

import android.util.Log;

/* compiled from: ContactsLogUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1292a = false;

    public static String a(String str) {
        if (str == null) {
            return "ContactsLogUtils";
        }
        return str;
    }

    public static void b(String str, String str2) {
        if (a.b()) {
            Log.d(a(str), str2);
        }
    }

    public static void c(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void d(String str, String str2, Throwable th) {
        Log.e(a(str), str2, th);
    }

    public static void e(String str, String str2) {
        Log.i(a(str), str2);
    }

    public static void f(String str, String str2) {
        try {
            Class.forName("android.util.Log").getMethod("p", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e10) {
            c("PLACE_CALL: ", "logP: Exception: " + e10);
        }
    }

    public static void g(String str, String str2) {
        if (f1292a) {
            Log.d(a(str), str2);
        }
    }

    public static void h(String str, String str2) {
        if (a.b()) {
            Log.v(a(str), str2);
        }
    }

    public static void i(String str, String str2) {
        Log.w(a(str), str2);
    }
}
