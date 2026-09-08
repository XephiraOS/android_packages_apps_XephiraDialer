package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.i;

/* compiled from: ContinuationInterceptor.kt */
/* loaded from: classes4.dex */
public interface d extends CoroutineContext.a {

    /* renamed from: t, reason: collision with root package name */
    public static final b f34217t = b.f34218a;

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static <E extends CoroutineContext.a> E a(d dVar, CoroutineContext.b<E> key) {
            i.f(key, "key");
            if (key instanceof kotlin.coroutines.b) {
                kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
                if (!bVar.a(dVar.getKey())) {
                    return null;
                }
                E e10 = (E) bVar.b(dVar);
                if (!(e10 instanceof CoroutineContext.a)) {
                    return null;
                }
                return e10;
            }
            if (d.f34217t != key) {
                return null;
            }
            i.d(dVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return dVar;
        }

        public static CoroutineContext b(d dVar, CoroutineContext.b<?> key) {
            i.f(key, "key");
            if (key instanceof kotlin.coroutines.b) {
                kotlin.coroutines.b bVar = (kotlin.coroutines.b) key;
                if (bVar.a(dVar.getKey()) && bVar.b(dVar) != null) {
                    return EmptyCoroutineContext.f34213a;
                }
                return dVar;
            }
            if (d.f34217t == key) {
                return EmptyCoroutineContext.f34213a;
            }
            return dVar;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    /* loaded from: classes4.dex */
    public static final class b implements CoroutineContext.b<d> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f34218a = new b();
    }

    void g(c<?> cVar);

    <T> c<T> l(c<? super T> cVar);
}
