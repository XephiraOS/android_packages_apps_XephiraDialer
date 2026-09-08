package I;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class h {
    public static void a(boolean z10) {
        if (z10) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z10, Object obj) {
        if (z10) {
        } else {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int c(int i10) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException();
    }

    public static int d(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str);
    }

    public static <T> T e(T t10) {
        t10.getClass();
        return t10;
    }

    public static <T> T f(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void g(boolean z10) {
        h(z10, null);
    }

    public static void h(boolean z10, String str) {
        if (z10) {
        } else {
            throw new IllegalStateException(str);
        }
    }
}
