package com.google.common.collect;

import java.util.ListIterator;

/* compiled from: UnmodifiableListIterator.java */
/* loaded from: classes3.dex */
public abstract class D<E> extends C<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e10) {
        throw new UnsupportedOperationException();
    }
}
