package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import w9.InterfaceC1658a;

/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public final class c<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final e<T> f34260a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f34261b;

    /* renamed from: c, reason: collision with root package name */
    public final v9.l<T, Boolean> f34262c;

    /* compiled from: Sequences.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<T>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<T> f34263a;

        /* renamed from: b, reason: collision with root package name */
        public int f34264b = -1;

        /* renamed from: c, reason: collision with root package name */
        public T f34265c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c<T> f34266d;

        public a(c<T> cVar) {
            this.f34266d = cVar;
            this.f34263a = cVar.f34260a.iterator();
        }

        public final void a() {
            while (this.f34263a.hasNext()) {
                T next = this.f34263a.next();
                if (((Boolean) this.f34266d.f34262c.invoke(next)).booleanValue() == this.f34266d.f34261b) {
                    this.f34265c = next;
                    this.f34264b = 1;
                    return;
                }
            }
            this.f34264b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34264b == -1) {
                a();
            }
            if (this.f34264b == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f34264b == -1) {
                a();
            }
            if (this.f34264b != 0) {
                T t10 = this.f34265c;
                this.f34265c = null;
                this.f34264b = -1;
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
    public c(e<? extends T> sequence, boolean z10, v9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.i.f(sequence, "sequence");
        kotlin.jvm.internal.i.f(predicate, "predicate");
        this.f34260a = sequence;
        this.f34261b = z10;
        this.f34262c = predicate;
    }

    @Override // kotlin.sequences.e
    public Iterator<T> iterator() {
        return new a(this);
    }
}
