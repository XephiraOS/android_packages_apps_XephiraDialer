package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private final boolean accessOrder;

    /* renamed from: h, reason: collision with root package name */
    public transient int f24409h;

    /* renamed from: i, reason: collision with root package name */
    public transient int f24410i;
    transient long[] links;

    public CompactLinkedHashMap(int i10) {
        this(i10, false);
    }

    public static <K, V> CompactLinkedHashMap<K, V> X(int i10) {
        return new CompactLinkedHashMap<>(i10);
    }

    @Override // com.google.common.collect.CompactHashMap
    public int A(int i10) {
        return ((int) Z(i10)) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void E(int i10) {
        super.E(i10);
        this.f24409h = -2;
        this.f24410i = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void F(int i10, K k10, V v10, int i11, int i12) {
        super.F(i10, k10, v10, i11, i12);
        d0(this.f24410i, i10);
        d0(i10, -2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void I(int i10, int i11) {
        int size = size() - 1;
        super.I(i10, i11);
        d0(Y(i10), A(i10));
        if (i10 < size) {
            d0(Y(size), i10);
            d0(i10, A(size));
        }
        b0(size, 0L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void O(int i10) {
        super.O(i10);
        this.links = Arrays.copyOf(a0(), i10);
    }

    public final int Y(int i10) {
        return ((int) (Z(i10) >>> 32)) - 1;
    }

    public final long Z(int i10) {
        return a0()[i10];
    }

    public final long[] a0() {
        long[] jArr = this.links;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    public final void b0(int i10, long j10) {
        a0()[i10] = j10;
    }

    public final void c0(int i10, int i11) {
        b0(i10, (Z(i10) & 4294967295L) | ((i11 + 1) << 32));
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.f24409h = -2;
        this.f24410i = -2;
        long[] jArr = this.links;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return convertToHashFloodingResistantImplementation;
    }

    public final void d0(int i10, int i11) {
        if (i10 == -2) {
            this.f24409h = i11;
        } else {
            e0(i10, i11);
        }
        if (i11 == -2) {
            this.f24410i = i10;
        } else {
            c0(i11, i10);
        }
    }

    public final void e0(int i10, int i11) {
        b0(i10, (Z(i10) & (-4294967296L)) | ((i11 + 1) & 4294967295L));
    }

    @Override // com.google.common.collect.CompactHashMap
    public void p(int i10) {
        if (this.accessOrder) {
            d0(Y(i10), A(i10));
            d0(this.f24410i, i10);
            d0(i10, -2);
            C();
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int q(int i10, int i11) {
        if (i10 >= size()) {
            return i11;
        }
        return i10;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int r() {
        int r10 = super.r();
        this.links = new long[r10];
        return r10;
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> t(int i10) {
        return new LinkedHashMap(i10, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    public int z() {
        return this.f24409h;
    }

    public CompactLinkedHashMap(int i10, boolean z10) {
        super(i10);
        this.accessOrder = z10;
    }
}
