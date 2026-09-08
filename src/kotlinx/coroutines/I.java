package kotlinx.coroutines;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes4.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f34320a = kotlinx.coroutines.internal.D.f("kotlinx.coroutines.main.delay", false);

    /* renamed from: b, reason: collision with root package name */
    public static final L f34321b = b();

    public static final L a() {
        return f34321b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final L b() {
        if (!f34320a) {
            return H.f34318i;
        }
        w0 c10 = S.c();
        if (!kotlinx.coroutines.internal.t.c(c10) && (c10 instanceof L)) {
            return (L) c10;
        }
        return H.f34318i;
    }
}
