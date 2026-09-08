package kotlinx.coroutines;

/* compiled from: Executors.kt */
/* loaded from: classes4.dex */
public final class D0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f34314a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1266m<m9.q> f34315b;

    /* JADX WARN: Multi-variable type inference failed */
    public D0(CoroutineDispatcher coroutineDispatcher, InterfaceC1266m<? super m9.q> interfaceC1266m) {
        this.f34314a = coroutineDispatcher;
        this.f34315b = interfaceC1266m;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f34315b.h(this.f34314a, m9.q.f35511a);
    }
}
