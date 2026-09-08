package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import v9.InterfaceC1637a;
import w9.InterfaceC1658a;

/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public final class d<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1637a<T> f34267a;

    /* renamed from: b, reason: collision with root package name */
    public final v9.l<T, T> f34268b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<T>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public T f34269a;

        /* renamed from: b, reason: collision with root package name */
        public int f34270b = -2;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d<T> f34271c;

        public a(d<T> dVar) {
            this.f34271c = dVar;
        }

        private final void a() {
            T t10;
            int i10;
            if (this.f34270b != -2) {
                v9.l lVar = this.f34271c.f34268b;
                T t11 = this.f34269a;
                kotlin.jvm.internal.i.c(t11);
                t10 = (T) lVar.invoke(t11);
            } else {
                t10 = (T) this.f34271c.f34267a.invoke();
            }
            this.f34269a = t10;
            if (t10 == null) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            this.f34270b = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34270b < 0) {
                a();
            }
            if (this.f34270b == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f34270b < 0) {
                a();
            }
            if (this.f34270b != 0) {
                T t10 = this.f34269a;
                kotlin.jvm.internal.i.d(t10, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f34270b = -1;
                return t10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(InterfaceC1637a<? extends T> getInitialValue, v9.l<? super T, ? extends T> getNextValue) {
        kotlin.jvm.internal.i.f(getInitialValue, "getInitialValue");
        kotlin.jvm.internal.i.f(getNextValue, "getNextValue");
        this.f34267a = getInitialValue;
        this.f34268b = getNextValue;
    }

    @Override // kotlin.sequences.e
    public Iterator<T> iterator() {
        return new a(this);
    }
}
