package com.google.common.collect;

import java.util.Iterator;

/* compiled from: TransformedIterator.java */
/* loaded from: classes3.dex */
public abstract class B<F, T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator<? extends F> f24377a;

    public B(Iterator<? extends F> it) {
        this.f24377a = (Iterator) com.google.common.base.k.o(it);
    }

    public abstract T a(F f10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f24377a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f24377a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f24377a.remove();
    }
}
