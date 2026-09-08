package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.C1258i;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes4.dex */
public abstract class CoroutineDispatcher extends kotlin.coroutines.a implements kotlin.coroutines.d {

    /* renamed from: b, reason: collision with root package name */
    public static final Key f34306b = new Key(null);

    /* compiled from: CoroutineDispatcher.kt */
    /* loaded from: classes4.dex */
    public static final class Key extends kotlin.coroutines.b<kotlin.coroutines.d, CoroutineDispatcher> {
        public /* synthetic */ Key(kotlin.jvm.internal.f fVar) {
            this();
        }

        public Key() {
            super(kotlin.coroutines.d.f34217t, new v9.l<CoroutineContext.a, CoroutineDispatcher>() { // from class: kotlinx.coroutines.CoroutineDispatcher.Key.1
                @Override // v9.l
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final CoroutineDispatcher invoke(CoroutineContext.a aVar) {
                    if (aVar instanceof CoroutineDispatcher) {
                        return (CoroutineDispatcher) aVar;
                    }
                    return null;
                }
            });
        }
    }

    public CoroutineDispatcher() {
        super(kotlin.coroutines.d.f34217t);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.CoroutineContext
    public CoroutineContext L(CoroutineContext.b<?> bVar) {
        return d.a.b(this, bVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E a(CoroutineContext.b<E> bVar) {
        return (E) d.a.a(this, bVar);
    }

    public abstract void f0(CoroutineContext coroutineContext, Runnable runnable);

    @Override // kotlin.coroutines.d
    public final void g(kotlin.coroutines.c<?> cVar) {
        kotlin.jvm.internal.i.d(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C1258i) cVar).r();
    }

    public boolean g0(CoroutineContext coroutineContext) {
        return true;
    }

    public CoroutineDispatcher h0(int i10) {
        kotlinx.coroutines.internal.m.a(i10);
        return new kotlinx.coroutines.internal.l(this, i10);
    }

    @Override // kotlin.coroutines.d
    public final <T> kotlin.coroutines.c<T> l(kotlin.coroutines.c<? super T> cVar) {
        return new C1258i(this, cVar);
    }

    public String toString() {
        return G.a(this) + '@' + G.b(this);
    }
}
