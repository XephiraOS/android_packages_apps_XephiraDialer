package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.i;
import v9.p;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes4.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext context) {
            i.f(context, "context");
            if (context != EmptyCoroutineContext.f34213a) {
                return (CoroutineContext) context.y(coroutineContext, new p<CoroutineContext, a, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                    @Override // v9.p
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final CoroutineContext invoke(CoroutineContext acc, CoroutineContext.a element) {
                        CombinedContext combinedContext;
                        i.f(acc, "acc");
                        i.f(element, "element");
                        CoroutineContext L10 = acc.L(element.getKey());
                        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f34213a;
                        if (L10 != emptyCoroutineContext) {
                            d.b bVar = d.f34217t;
                            d dVar = (d) L10.a(bVar);
                            if (dVar == null) {
                                combinedContext = new CombinedContext(L10, element);
                            } else {
                                CoroutineContext L11 = L10.L(bVar);
                                if (L11 == emptyCoroutineContext) {
                                    return new CombinedContext(element, dVar);
                                }
                                combinedContext = new CombinedContext(new CombinedContext(L11, element), dVar);
                            }
                            return combinedContext;
                        }
                        return element;
                    }
                });
            }
            return coroutineContext;
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes4.dex */
    public interface a extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.CoroutineContext$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0326a {
            public static <R> R a(a aVar, R r10, p<? super R, ? super a, ? extends R> operation) {
                i.f(operation, "operation");
                return operation.invoke(r10, aVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends a> E b(a aVar, b<E> key) {
                i.f(key, "key");
                if (i.b(aVar.getKey(), key)) {
                    i.d(aVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return aVar;
                }
                return null;
            }

            public static CoroutineContext c(a aVar, b<?> key) {
                i.f(key, "key");
                if (i.b(aVar.getKey(), key)) {
                    return EmptyCoroutineContext.f34213a;
                }
                return aVar;
            }

            public static CoroutineContext d(a aVar, CoroutineContext context) {
                i.f(context, "context");
                return DefaultImpls.a(aVar, context);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends a> E a(b<E> bVar);

        b<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes4.dex */
    public interface b<E extends a> {
    }

    CoroutineContext L(b<?> bVar);

    <E extends a> E a(b<E> bVar);

    CoroutineContext r(CoroutineContext coroutineContext);

    <R> R y(R r10, p<? super R, ? super a, ? extends R> pVar);
}
