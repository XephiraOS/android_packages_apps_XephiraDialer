package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.i;
import v9.p;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes4.dex */
public abstract class a implements CoroutineContext.a {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext.b<?> f34214a;

    public a(CoroutineContext.b<?> key) {
        i.f(key, "key");
        this.f34214a = key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext L(CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0326a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E a(CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0326a.b(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    public CoroutineContext.b<?> getKey() {
        return this.f34214a;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext r(CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0326a.d(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R y(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0326a.a(this, r10, pVar);
    }
}
