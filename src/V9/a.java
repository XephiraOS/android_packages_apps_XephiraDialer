package V9;

/* compiled from: SupportPreconditions.java */
/* loaded from: classes4.dex */
public final class a {
    public static void a(boolean z10, Object obj) {
        if (z10) {
        } else {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T b(T t10, Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
