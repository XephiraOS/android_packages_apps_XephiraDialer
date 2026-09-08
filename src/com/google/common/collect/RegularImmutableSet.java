package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RegularImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: f, reason: collision with root package name */
    public static final Object[] f24545f;

    /* renamed from: g, reason: collision with root package name */
    public static final RegularImmutableSet<Object> f24546g;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f24547c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f24548d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f24549e;
    final transient Object[] elements;
    final transient Object[] table;

    static {
        Object[] objArr = new Object[0];
        f24545f = objArr;
        f24546g = new RegularImmutableSet<>(objArr, 0, objArr, 0, 0);
    }

    public RegularImmutableSet(Object[] objArr, int i10, Object[] objArr2, int i11, int i12) {
        this.elements = objArr;
        this.f24547c = i10;
        this.table = objArr2;
        this.f24548d = i11;
        this.f24549e = i12;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int c(Object[] objArr, int i10) {
        System.arraycopy(this.elements, 0, objArr, i10, this.f24549e);
        return i10 + this.f24549e;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int d10 = l.d(obj);
        while (true) {
            int i10 = d10 & this.f24548d;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            d10 = i10 + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] e() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int g() {
        return this.f24549e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int h() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f24547c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean i() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: j */
    public C<E> iterator() {
        return a().iterator();
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> n() {
        return ImmutableList.l(this.elements, this.f24549e);
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean o() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f24549e;
    }
}
