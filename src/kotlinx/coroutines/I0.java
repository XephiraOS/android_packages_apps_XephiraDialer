package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public final class I0 {

    /* renamed from: a, reason: collision with root package name */
    public static final I0 f34322a = new I0();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<W> f34323b = kotlinx.coroutines.internal.G.a(new kotlinx.coroutines.internal.C("ThreadLocalEventLoop"));

    public final W a() {
        return f34323b.get();
    }

    public final W b() {
        ThreadLocal<W> threadLocal = f34323b;
        W w10 = threadLocal.get();
        if (w10 == null) {
            W a10 = Z.a();
            threadLocal.set(a10);
            return a10;
        }
        return w10;
    }

    public final void c() {
        f34323b.set(null);
    }

    public final void d(W w10) {
        f34323b.set(w10);
    }
}
