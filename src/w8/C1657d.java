package w8;

import android.content.Context;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: PreferenceHandler.java */
/* renamed from: w8.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1657d {

    /* renamed from: a, reason: collision with root package name */
    public static final C1656c f37633a = new C1656c();

    public static long a(Context context) {
        return f37633a.d("activity.end.time", -1L);
    }

    public static long b(Context context) {
        return f37633a.d("activity.start.time", -1L);
    }

    public static String c(Context context) {
        return f37633a.e("current.activity", "");
    }

    public static long d(Context context, String str, long j10) {
        return f37633a.d(str, j10);
    }

    public static int e(Context context) {
        return f37633a.c("pagevisit.duration", 0);
    }

    public static String f(Context context) {
        return f37633a.e("pagevisit.routes", "");
    }

    public static int g(Context context) {
        return f37633a.c("session.timeout", 30);
    }

    public static String h(Context context) {
        return f37633a.e("ssoid", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
    }

    public static String i(Context context, String str, String str2) {
        return f37633a.e(str, str2);
    }

    public static void j(Context context, long j10) {
        f37633a.i("activity.end.time", j10);
    }

    public static void k(Context context, long j10) {
        f37633a.i("activity.start.time", j10);
    }

    public static void l(Context context, String str) {
        f37633a.j("current.activity", str);
    }

    public static void m(Context context, String str, long j10) {
        f37633a.i(str, j10);
    }

    public static void n(Context context, int i10) {
        f37633a.h("pagevisit.duration", i10);
    }

    public static void o(Context context, String str) {
        f37633a.j("pagevisit.routes", "");
    }

    public static void p(Context context, String str, String str2) {
        f37633a.j(str, str2);
    }
}
