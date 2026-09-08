package com.google.common.collect;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {

    /* renamed from: e, reason: collision with root package name */
    public transient int[] f24411e;

    /* renamed from: f, reason: collision with root package name */
    public transient int[] f24412f;

    /* renamed from: g, reason: collision with root package name */
    public transient int f24413g;

    /* renamed from: h, reason: collision with root package name */
    public transient int f24414h;

    public CompactLinkedHashSet(int i10) {
        super(i10);
    }

    public static <E> CompactLinkedHashSet<E> B(int i10) {
        return new CompactLinkedHashSet<>(i10);
    }

    public final int C(int i10) {
        return D()[i10] - 1;
    }

    public final int[] D() {
        int[] iArr = this.f24411e;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final int[] E() {
        int[] iArr = this.f24412f;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final void F(int i10, int i11) {
        D()[i10] = i11 + 1;
    }

    public final void G(int i10, int i11) {
        if (i10 == -2) {
            this.f24413g = i11;
        } else {
            H(i10, i11);
        }
        if (i11 == -2) {
            this.f24414h = i10;
        } else {
            F(i11, i10);
        }
    }

    public final void H(int i10, int i11) {
        E()[i10] = i11 + 1;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.f24413g = -2;
        this.f24414h = -2;
        int[] iArr = this.f24411e;
        if (iArr != null && this.f24412f != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f24412f, 0, size(), 0);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.f24411e = null;
        this.f24412f = null;
        return convertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int e(int i10, int i11) {
        if (i10 >= size()) {
            return i11;
        }
        return i10;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int g() {
        int g10 = super.g();
        this.f24411e = new int[g10];
        this.f24412f = new int[g10];
        return g10;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int l() {
        return this.f24413g;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int m(int i10) {
        return E()[i10] - 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void p(int i10) {
        super.p(i10);
        this.f24413g = -2;
        this.f24414h = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void q(int i10, E e10, int i11, int i12) {
        super.q(i10, e10, i11, i12);
        G(this.f24414h, i10);
        G(i10, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    public void r(int i10, int i11) {
        int size = size() - 1;
        super.r(i10, i11);
        G(C(i10), m(i10));
        if (i10 < size) {
            G(C(size), i10);
            G(i10, m(size));
        }
        D()[size] = 0;
        E()[size] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return t.f(this);
    }

    @Override // com.google.common.collect.CompactHashSet
    public void v(int i10) {
        super.v(i10);
        this.f24411e = Arrays.copyOf(D(), i10);
        this.f24412f = Arrays.copyOf(E(), i10);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) t.g(this, tArr);
    }
}
