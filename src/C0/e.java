package c0;

/* compiled from: SneakyThrow.java */
/* loaded from: classes.dex */
public class e {
    public static void a(Exception exc) {
        b(exc);
    }

    public static <E extends Throwable> void b(Throwable th) {
        throw th;
    }
}
