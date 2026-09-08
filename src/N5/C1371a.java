package n5;

import android.util.Log;

/* compiled from: SdkLog.java */
/* renamed from: n5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1371a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f35624a = false;

    public static void b(String str) {
        Log.d("AF.SDK", str);
    }

    public static void c(String str, String str2) {
        Log.d(a("AF.SDK." + str), str2);
    }

    public static void d(String str, String str2) {
        Log.e(a("AF.SDK." + str), str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(a("AF.SDK." + str), str2, th);
    }

    public static void f(String str, Throwable th) {
        Log.e("AF.SDK", str, th);
    }

    public static void g(String str, String str2) {
        Log.i(a("AF.SDK." + str), str2);
    }

    public static boolean h() {
        return f35624a;
    }

    public static void i(String str, String str2) {
        Log.v(a("AF.SDK." + str), str2);
    }

    public static void j(String str) {
        Log.w("AF.SDK", str);
    }

    public static void k(String str, String str2) {
        Log.w(a("AF.SDK." + str), str2);
    }

    public static void l(String str, String str2, Throwable th) {
        Log.w(a("AF.SDK." + str), str2, th);
    }

    public static void m(String str, Throwable th) {
        Log.w("AF.SDK", str, th);
    }

    public static String a(String str) {
        return str;
    }
}
