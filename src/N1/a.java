package N1;

import android.os.Looper;

/* compiled from: Assert.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f2294a = true;

    public static void a(boolean z10, String str, Object... objArr) {
        if (z10) {
        } else {
            throw new IllegalStateException(b(str, objArr));
        }
    }

    public static String b(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        return String.format(str, objArr);
    }

    public static void c() {
        d(null, new Object[0]);
    }

    public static void d(String str, Object... objArr) {
        if (!f2294a) {
            return;
        }
        a(Looper.getMainLooper().equals(Looper.myLooper()), str, objArr);
    }

    public static <T> T e(T t10) {
        return (T) f(t10, null, new Object[0]);
    }

    public static <T> T f(T t10, String str, Object... objArr) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(b(str, objArr));
    }
}
