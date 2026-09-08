package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.p;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes4.dex */
public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.a element;
    private final CoroutineContext left;

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes4.dex */
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f34210a = new a(null);
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        /* compiled from: CoroutineContextImpl.kt */
        /* loaded from: classes4.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        public Serialized(CoroutineContext[] elements) {
            i.f(elements, "elements");
            this.elements = elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContext = EmptyCoroutineContext.f34213a;
            for (CoroutineContext coroutineContext2 : coroutineContextArr) {
                coroutineContext = coroutineContext.r(coroutineContext2);
            }
            return coroutineContext;
        }
    }

    public CombinedContext(CoroutineContext left, CoroutineContext.a element) {
        i.f(left, "left");
        i.f(element, "element");
        this.left = left;
        this.element = element;
    }

    private final int f() {
        int i10 = 2;
        while (true) {
            CoroutineContext coroutineContext = this.left;
            if (coroutineContext instanceof CombinedContext) {
                this = (CombinedContext) coroutineContext;
            } else {
                this = null;
            }
            if (this == null) {
                return i10;
            }
            i10++;
        }
    }

    private final Object writeReplace() {
        int f10 = f();
        final CoroutineContext[] coroutineContextArr = new CoroutineContext[f10];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        y(q.f35511a, new p<q, CoroutineContext.a, q>() { // from class: kotlin.coroutines.CombinedContext$writeReplace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void b(q qVar, CoroutineContext.a element) {
                i.f(qVar, "<anonymous parameter 0>");
                i.f(element, "element");
                CoroutineContext[] coroutineContextArr2 = coroutineContextArr;
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                int i10 = ref$IntRef2.element;
                ref$IntRef2.element = i10 + 1;
                coroutineContextArr2[i10] = element;
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ q invoke(q qVar, CoroutineContext.a aVar) {
                b(qVar, aVar);
                return q.f35511a;
            }
        });
        if (ref$IntRef.element == f10) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext L(CoroutineContext.b<?> key) {
        i.f(key, "key");
        if (this.element.a(key) != null) {
            return this.left;
        }
        CoroutineContext L10 = this.left.L(key);
        if (L10 != this.left) {
            if (L10 == EmptyCoroutineContext.f34213a) {
                return this.element;
            }
            return new CombinedContext(L10, this.element);
        }
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E a(CoroutineContext.b<E> key) {
        i.f(key, "key");
        while (true) {
            E e10 = (E) this.element.a(key);
            if (e10 != null) {
                return e10;
            }
            CoroutineContext coroutineContext = this.left;
            if (coroutineContext instanceof CombinedContext) {
                this = (CombinedContext) coroutineContext;
            } else {
                return (E) coroutineContext.a(key);
            }
        }
    }

    public final boolean b(CoroutineContext.a aVar) {
        return i.b(a(aVar.getKey()), aVar);
    }

    public final boolean d(CombinedContext combinedContext) {
        while (b(combinedContext.element)) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                i.d(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((CoroutineContext.a) coroutineContext);
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.f() != f() || !combinedContext.d(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext r(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) y("", new p<String, CoroutineContext.a, String>() { // from class: kotlin.coroutines.CombinedContext$toString$1
            @Override // v9.p
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String invoke(String acc, CoroutineContext.a element) {
                i.f(acc, "acc");
                i.f(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            }
        })) + ']';
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R y(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> operation) {
        i.f(operation, "operation");
        return operation.invoke((Object) this.left.y(r10, operation), this.element);
    }
}
