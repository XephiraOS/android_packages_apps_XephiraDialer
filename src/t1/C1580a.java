package t1;

import android.os.Looper;

/* compiled from: Assert.java */
/* renamed from: t1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1580a {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f37142a;

    public static void b(String str) {
        C1.a.c("Assert", "fail", new AssertionError(str));
    }

    public static void c() {
        Boolean bool = f37142a;
        if (bool != null) {
            e(bool.booleanValue());
        } else {
            e(Looper.getMainLooper().equals(Looper.myLooper()));
        }
    }

    public static void d() {
        if (f37142a != null) {
            e(!r0.booleanValue());
        } else {
            e(!Looper.getMainLooper().equals(Looper.myLooper()));
        }
    }

    public static void e(boolean z10) {
        if (!z10) {
            C1.a.c("Assert", "isTrue", new AssertionError("Expected condition to be true"));
        }
    }

    public static void setIsMainThreadForTesting(Boolean bool) {
        f37142a = bool;
    }

    public static void a(boolean z10) {
    }
}
