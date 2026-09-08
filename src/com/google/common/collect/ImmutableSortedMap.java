package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {

    /* renamed from: h, reason: collision with root package name */
    public static final Comparator<Comparable> f24440h = Ordering.c();

    /* renamed from: i, reason: collision with root package name */
    public static final ImmutableSortedMap<Comparable, Object> f24441i = new ImmutableSortedMap<>(ImmutableSortedSet.w(Ordering.c()), ImmutableList.s());
    private static final long serialVersionUID = 0;

    /* renamed from: e, reason: collision with root package name */
    public final transient RegularImmutableSortedSet<K> f24442e;

    /* renamed from: f, reason: collision with root package name */
    public final transient ImmutableList<V> f24443f;

    /* renamed from: g, reason: collision with root package name */
    public transient ImmutableSortedMap<K, V> f24444g;

    /* loaded from: classes3.dex */
    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        public SerializedForm(ImmutableSortedMap<K, V> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a<K, V> b(int i10) {
            return new a<>(this.comparator);
        }
    }

    /* loaded from: classes3.dex */
    public static class a<K, V> extends ImmutableMap.a<K, V> {

        /* renamed from: f, reason: collision with root package name */
        public transient Object[] f24445f;

        /* renamed from: g, reason: collision with root package name */
        public transient Object[] f24446g;

        /* renamed from: h, reason: collision with root package name */
        public final Comparator<? super K> f24447h;

        public a(Comparator<? super K> comparator) {
            this(comparator, 4);
        }

        public final void d(int i10) {
            Object[] objArr = this.f24445f;
            if (i10 > objArr.length) {
                int a10 = ImmutableCollection.b.a(objArr.length, i10);
                this.f24445f = Arrays.copyOf(this.f24445f, a10);
                this.f24446g = Arrays.copyOf(this.f24446g, a10);
            }
        }

        @Override // com.google.common.collect.ImmutableMap.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMap<K, V> a() {
            return c();
        }

        @Override // com.google.common.collect.ImmutableMap.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMap<K, V> c() {
            int i10 = this.f24432c;
            if (i10 != 0) {
                if (i10 != 1) {
                    Object[] copyOf = Arrays.copyOf(this.f24445f, i10);
                    Arrays.sort(copyOf, this.f24447h);
                    Object[] objArr = new Object[this.f24432c];
                    for (int i11 = 0; i11 < this.f24432c; i11++) {
                        if (i11 > 0) {
                            int i12 = i11 - 1;
                            if (this.f24447h.compare(copyOf[i12], copyOf[i11]) == 0) {
                                throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + copyOf[i12] + " and " + copyOf[i11]);
                            }
                        }
                        Object obj = this.f24445f[i11];
                        Objects.requireNonNull(obj);
                        int binarySearch = Arrays.binarySearch(copyOf, obj, this.f24447h);
                        Object obj2 = this.f24446g[i11];
                        Objects.requireNonNull(obj2);
                        objArr[binarySearch] = obj2;
                    }
                    return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.k(copyOf), this.f24447h), ImmutableList.k(objArr));
                }
                Comparator<? super K> comparator = this.f24447h;
                Object obj3 = this.f24445f[0];
                Objects.requireNonNull(obj3);
                Object obj4 = this.f24446g[0];
                Objects.requireNonNull(obj4);
                return ImmutableSortedMap.z(comparator, obj3, obj4);
            }
            return ImmutableSortedMap.s(this.f24447h);
        }

        @Override // com.google.common.collect.ImmutableMap.a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public a<K, V> f(K k10, V v10) {
            d(this.f24432c + 1);
            f.a(k10, v10);
            Object[] objArr = this.f24445f;
            int i10 = this.f24432c;
            objArr[i10] = k10;
            this.f24446g[i10] = v10;
            this.f24432c = i10 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            super.g(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public a<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.h(iterable);
            return this;
        }

        public a(Comparator<? super K> comparator, int i10) {
            this.f24447h = (Comparator) com.google.common.base.k.o(comparator);
            this.f24445f = new Object[i10];
            this.f24446g = new Object[i10];
        }
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K, V> ImmutableSortedMap<K, V> s(Comparator<? super K> comparator) {
        if (Ordering.c().equals(comparator)) {
            return y();
        }
        return new ImmutableSortedMap<>(ImmutableSortedSet.w(comparator), ImmutableList.s());
    }

    public static <K, V> ImmutableSortedMap<K, V> y() {
        return (ImmutableSortedMap<K, V>) f24441i;
    }

    public static <K, V> ImmutableSortedMap<K, V> z(Comparator<? super K> comparator, K k10, V v10) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.t(k10), (Comparator) com.google.common.base.k.o(comparator)), ImmutableList.t(v10));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap<K, V> subMap(K k10, K k11) {
        return subMap(k10, true, k11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
        boolean z12;
        com.google.common.base.k.o(k10);
        com.google.common.base.k.o(k11);
        if (comparator().compare(k10, k11) <= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        com.google.common.base.k.l(z12, "expected fromKey <= toKey but %s > %s", k10, k11);
        return headMap(k11, z11).tailMap(k10, z10);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap<K, V> tailMap(K k10) {
        return tailMap(k10, true);
    }

    @Override // java.util.NavigableMap
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap<K, V> tailMap(K k10, boolean z10) {
        return t(this.f24442e.K(com.google.common.base.k.o(k10), z10), size());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k10) {
        return tailMap(k10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k10) {
        return (K) Maps.e(ceilingEntry(k10));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> e() {
        if (isEmpty()) {
            return ImmutableSet.p();
        }
        return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet
            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: j */
            public C<Map.Entry<K, V>> iterator() {
                return a().iterator();
            }

            @Override // com.google.common.collect.ImmutableSet
            public ImmutableList<Map.Entry<K, V>> n() {
                return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                    @Override // com.google.common.collect.ImmutableCollection
                    public boolean i() {
                        return true;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }

                    @Override // java.util.List
                    /* renamed from: x, reason: merged with bridge method [inline-methods] */
                    public Map.Entry<K, V> get(int i10) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.f24442e.a().get(i10), ImmutableSortedMap.this.f24443f.get(i10));
                    }
                };
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            public ImmutableMap<K, V> s() {
                return ImmutableSortedMap.this;
            }
        };
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> f() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().a().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k10) {
        return headMap(k10, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k10) {
        return (K) Maps.e(floorEntry(k10));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> g() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        int indexOf = this.f24442e.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.f24443f.get(indexOf);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* renamed from: h */
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k10) {
        return tailMap(k10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k10) {
        return (K) Maps.e(higherEntry(k10));
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean j() {
        if (!this.f24442e.i() && !this.f24443f.i()) {
            return false;
        }
        return true;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().a().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k10) {
        return headMap(k10, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k10) {
        return (K) Maps.e(lowerEntry(k10));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* renamed from: m */
    public ImmutableCollection<V> values() {
        return this.f24443f;
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.f24442e.descendingSet();
    }

    @Override // java.util.NavigableMap
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.f24444g;
        if (immutableSortedMap == null) {
            if (isEmpty()) {
                return s(Ordering.b(comparator()).e());
            }
            return new ImmutableSortedMap<>((RegularImmutableSortedSet) this.f24442e.descendingSet(), this.f24443f.u(), this);
        }
        return immutableSortedMap;
    }

    @Override // java.util.Map
    public int size() {
        return this.f24443f.size();
    }

    public final ImmutableSortedMap<K, V> t(int i10, int i11) {
        if (i10 == 0 && i11 == size()) {
            return this;
        }
        if (i10 == i11) {
            return s(comparator());
        }
        return new ImmutableSortedMap<>(this.f24442e.I(i10, i11), this.f24443f.subList(i10, i11));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap<K, V> headMap(K k10) {
        return headMap(k10, false);
    }

    @Override // java.util.NavigableMap
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap<K, V> headMap(K k10, boolean z10) {
        return t(0, this.f24442e.J(com.google.common.base.k.o(k10), z10));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<K> keySet() {
        return this.f24442e;
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // java.util.NavigableMap
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.f24442e;
    }

    public ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.f24442e = regularImmutableSortedSet;
        this.f24443f = immutableList;
        this.f24444g = immutableSortedMap;
    }
}
