package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

/* loaded from: classes3.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final Map.Entry<?, ?>[] f24426d = new Map.Entry[0];

    /* renamed from: a, reason: collision with root package name */
    @RetainedWith
    public transient ImmutableSet<Map.Entry<K, V>> f24427a;

    /* renamed from: b, reason: collision with root package name */
    @RetainedWith
    public transient ImmutableSet<K> f24428b;

    /* renamed from: c, reason: collision with root package name */
    @RetainedWith
    public transient ImmutableCollection<V> f24429c;

    /* loaded from: classes3.dex */
    public static class SerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        public SerializedForm(ImmutableMap<K, V> immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            C<Map.Entry<K, V>> it = immutableMap.entrySet().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i10] = next.getKey();
                objArr2[i10] = next.getValue();
                i10++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object a() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            a<K, V> b10 = b(objArr.length);
            for (int i10 = 0; i10 < objArr.length; i10++) {
                b10.f(objArr[i10], objArr2[i10]);
            }
            return b10.c();
        }

        public a<K, V> b(int i10) {
            return new a<>(i10);
        }

        public final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof ImmutableSet)) {
                return a();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            ImmutableCollection immutableCollection = (ImmutableCollection) this.values;
            a<K, V> b10 = b(immutableSet.size());
            C it = immutableSet.iterator();
            C it2 = immutableCollection.iterator();
            while (it.hasNext()) {
                b10.f(it.next(), it2.next());
            }
            return b10.c();
        }
    }

    /* loaded from: classes3.dex */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Comparator<? super V> f24430a;

        /* renamed from: b, reason: collision with root package name */
        public Object[] f24431b;

        /* renamed from: c, reason: collision with root package name */
        public int f24432c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f24433d;

        /* renamed from: e, reason: collision with root package name */
        public C0221a f24434e;

        /* renamed from: com.google.common.collect.ImmutableMap$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0221a {

            /* renamed from: a, reason: collision with root package name */
            public final Object f24435a;

            /* renamed from: b, reason: collision with root package name */
            public final Object f24436b;

            /* renamed from: c, reason: collision with root package name */
            public final Object f24437c;

            public C0221a(Object obj, Object obj2, Object obj3) {
                this.f24435a = obj;
                this.f24436b = obj2;
                this.f24437c = obj3;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f24435a + "=" + this.f24436b + " and " + this.f24435a + "=" + this.f24437c);
            }
        }

        public a() {
            this(4);
        }

        private void d(int i10) {
            int i11 = i10 * 2;
            Object[] objArr = this.f24431b;
            if (i11 > objArr.length) {
                this.f24431b = Arrays.copyOf(objArr, ImmutableCollection.b.a(objArr.length, i11));
                this.f24433d = false;
            }
        }

        public static <V> void i(Object[] objArr, int i10, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 2;
                Object obj = objArr[i12];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i12 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i11] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i10, Ordering.b(comparator).d(Maps.k()));
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                objArr[i14] = entryArr[i13].getKey();
                objArr[i14 + 1] = entryArr[i13].getValue();
            }
        }

        public ImmutableMap<K, V> a() {
            return c();
        }

        public final ImmutableMap<K, V> b(boolean z10) {
            Object[] objArr;
            C0221a c0221a;
            C0221a c0221a2;
            if (z10 && (c0221a2 = this.f24434e) != null) {
                throw c0221a2.a();
            }
            int i10 = this.f24432c;
            if (this.f24430a == null) {
                objArr = this.f24431b;
            } else {
                if (this.f24433d) {
                    this.f24431b = Arrays.copyOf(this.f24431b, i10 * 2);
                }
                objArr = this.f24431b;
                if (!z10) {
                    objArr = e(objArr, this.f24432c);
                    if (objArr.length < this.f24431b.length) {
                        i10 = objArr.length >>> 1;
                    }
                }
                i(objArr, i10, this.f24430a);
            }
            this.f24433d = true;
            RegularImmutableMap n10 = RegularImmutableMap.n(i10, objArr, this);
            if (z10 && (c0221a = this.f24434e) != null) {
                throw c0221a.a();
            }
            return n10;
        }

        public ImmutableMap<K, V> c() {
            return b(true);
        }

        public final Object[] e(Object[] objArr, int i10) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                Object obj = objArr[i11 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i11);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i10 - bitSet.cardinality()) * 2];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10 * 2) {
                if (bitSet.get(i12 >>> 1)) {
                    i12 += 2;
                } else {
                    int i14 = i13 + 1;
                    int i15 = i12 + 1;
                    Object obj2 = objArr[i12];
                    Objects.requireNonNull(obj2);
                    objArr2[i13] = obj2;
                    i13 += 2;
                    i12 += 2;
                    Object obj3 = objArr[i15];
                    Objects.requireNonNull(obj3);
                    objArr2[i14] = obj3;
                }
            }
            return objArr2;
        }

        public a<K, V> f(K k10, V v10) {
            d(this.f24432c + 1);
            f.a(k10, v10);
            Object[] objArr = this.f24431b;
            int i10 = this.f24432c;
            objArr[i10 * 2] = k10;
            objArr[(i10 * 2) + 1] = v10;
            this.f24432c = i10 + 1;
            return this;
        }

        public a<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a<K, V> h(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                d(this.f24432c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        public a(int i10) {
            this.f24431b = new Object[i10 * 2];
            this.f24432c = 0;
            this.f24433d = false;
        }
    }

    public static <K, V> ImmutableMap<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        int i10;
        if (iterable instanceof Collection) {
            i10 = ((Collection) iterable).size();
        } else {
            i10 = 4;
        }
        a aVar = new a(i10);
        aVar.h(iterable);
        return aVar.a();
    }

    public static <K, V> ImmutableMap<K, V> d(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.j()) {
                return immutableMap;
            }
        }
        return b(map.entrySet());
    }

    public static <K, V> ImmutableMap<K, V> l() {
        return (ImmutableMap<K, V>) RegularImmutableMap.f24533g;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Maps.b(this, obj);
    }

    public abstract ImmutableSet<K> f();

    public abstract ImmutableCollection<V> g();

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v10) {
        V v11 = get(obj);
        if (v11 != null) {
            return v11;
        }
        return v10;
    }

    @Override // java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f24427a;
        if (immutableSet == null) {
            ImmutableSet<Map.Entry<K, V>> e10 = e();
            this.f24427a = e10;
            return e10;
        }
        return immutableSet;
    }

    @Override // java.util.Map
    public int hashCode() {
        return y.b(entrySet());
    }

    public boolean i() {
        return false;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public abstract boolean j();

    @Override // java.util.Map
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.f24428b;
        if (immutableSet == null) {
            ImmutableSet<K> f10 = f();
            this.f24428b = f10;
            return f10;
        }
        return immutableSet;
    }

    @Override // java.util.Map
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.f24429c;
        if (immutableCollection == null) {
            ImmutableCollection<V> g10 = g();
            this.f24429c = g10;
            return g10;
        }
        return immutableCollection;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.j(this);
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
