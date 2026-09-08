package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes4.dex */
public final class P0 implements CoroutineContext.a, CoroutineContext.b<P0> {

    /* renamed from: a, reason: collision with root package name */
    public static final P0 f34332a = new P0();

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext L(CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0326a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E a(CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0326a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext r(CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0326a.d(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R y(R r10, v9.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0326a.a(this, r10, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    public CoroutineContext.b<?> getKey() {
        return this;
    }
}
