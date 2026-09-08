package J0;

/* compiled from: Assert.java */
/* loaded from: classes.dex */
public class b {
    public static void a(boolean z10) {
        if (z10) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t10) {
        t10.getClass();
        return t10;
    }
}
