package kotlin.collections;

import java.util.Iterator;
import w9.InterfaceC1658a;

/* compiled from: Iterators.kt */
/* loaded from: classes4.dex */
public final class z<T> implements Iterator<x<? extends T>>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator<T> f34208a;

    /* renamed from: b, reason: collision with root package name */
    public int f34209b;

    /* JADX WARN: Multi-variable type inference failed */
    public z(Iterator<? extends T> iterator) {
        kotlin.jvm.internal.i.f(iterator, "iterator");
        this.f34208a = iterator;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final x<T> next() {
        int i10 = this.f34209b;
        this.f34209b = i10 + 1;
        if (i10 < 0) {
            o.o();
        }
        return new x<>(i10, this.f34208a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34208a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
