package com.google.common.collect;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RegularImmutableList<E> extends ImmutableList<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableList<Object> f24531d = new RegularImmutableList(new Object[0], 0);
    final transient Object[] array;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f24532c;

    public RegularImmutableList(Object[] objArr, int i10) {
        this.array = objArr;
        this.f24532c = i10;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int c(Object[] objArr, int i10) {
        System.arraycopy(this.array, 0, objArr, i10, this.f24532c);
        return i10 + this.f24532c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] e() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int g() {
        return this.f24532c;
    }

    @Override // java.util.List
    public E get(int i10) {
        com.google.common.base.k.m(i10, this.f24532c);
        E e10 = (E) this.array[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int h() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean i() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f24532c;
    }
}
