package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.j0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1261j0 extends AbstractC1267m0 {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34543f = AtomicIntegerFieldUpdater.newUpdater(C1261j0.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: e, reason: collision with root package name */
    public final v9.l<Throwable, m9.q> f34544e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1261j0(v9.l<? super Throwable, m9.q> lVar) {
        this.f34544e = lVar;
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
        u(th);
        return m9.q.f35511a;
    }

    @Override // kotlinx.coroutines.AbstractC1284z
    public void u(Throwable th) {
        if (f34543f.compareAndSet(this, 0, 1)) {
            this.f34544e.invoke(th);
        }
    }
}
