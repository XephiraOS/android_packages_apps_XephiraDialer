package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import v9.p;

/* compiled from: SafeCollector.kt */
/* loaded from: classes4.dex */
public final class f implements CoroutineContext {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f34459a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f34460b;

    public f(Throwable th, CoroutineContext coroutineContext) {
        this.f34459a = th;
        this.f34460b = coroutineContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext L(CoroutineContext.b<?> bVar) {
        return this.f34460b.L(bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E a(CoroutineContext.b<E> bVar) {
        return (E) this.f34460b.a(bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext r(CoroutineContext coroutineContext) {
        return this.f34460b.r(coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R y(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) this.f34460b.y(r10, pVar);
    }
}
