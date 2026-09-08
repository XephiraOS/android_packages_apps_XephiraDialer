package com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
/* renamed from: com.google.common.collect.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0816a<E> extends D<E> {

    /* renamed from: a, reason: collision with root package name */
    public final int f24567a;

    /* renamed from: b, reason: collision with root package name */
    public int f24568b;

    public AbstractC0816a(int i10, int i11) {
        com.google.common.base.k.r(i11, i10);
        this.f24567a = i10;
        this.f24568b = i11;
    }

    public abstract E a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.f24568b < this.f24567a) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.f24568b > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i10 = this.f24568b;
            this.f24568b = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f24568b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i10 = this.f24568b - 1;
            this.f24568b = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f24568b - 1;
    }
}
