package kotlin.sequences;

import java.util.Iterator;
import w9.InterfaceC1658a;

/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public final class l<T, R> implements e<R> {

    /* renamed from: a, reason: collision with root package name */
    public final e<T> f34276a;

    /* renamed from: b, reason: collision with root package name */
    public final v9.l<T, R> f34277b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<R>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<T> f34278a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<T, R> f34279b;

        public a(l<T, R> lVar) {
            this.f34279b = lVar;
            this.f34278a = lVar.f34276a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f34278a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f34279b.f34277b.invoke(this.f34278a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(e<? extends T> sequence, v9.l<? super T, ? extends R> transformer) {
        kotlin.jvm.internal.i.f(sequence, "sequence");
        kotlin.jvm.internal.i.f(transformer, "transformer");
        this.f34276a = sequence;
        this.f34277b = transformer;
    }

    @Override // kotlin.sequences.e
    public Iterator<R> iterator() {
        return new a(this);
    }
}
