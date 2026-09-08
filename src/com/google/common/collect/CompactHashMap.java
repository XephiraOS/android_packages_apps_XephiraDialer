package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f24381g = new Object();

    /* renamed from: a, reason: collision with root package name */
    public transient Object f24382a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f24383b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f24384c;

    /* renamed from: d, reason: collision with root package name */
    public transient Set<K> f24385d;

    /* renamed from: e, reason: collision with root package name */
    public transient Set<Map.Entry<K, V>> f24386e;
    transient int[] entries;

    /* renamed from: f, reason: collision with root package name */
    public transient Collection<V> f24387f;
    transient Object[] keys;
    transient Object[] values;

    /* loaded from: classes3.dex */
    public class a extends CompactHashMap<K, V>.e<K> {
        public a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public K b(int i10) {
            return (K) CompactHashMap.this.G(i10);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CompactHashMap<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i10) {
            return new g(i10);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CompactHashMap<K, V>.e<V> {
        public c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public V b(int i10) {
            return (V) CompactHashMap.this.V(i10);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int D10 = CompactHashMap.this.D(entry.getKey());
            if (D10 == -1 || !com.google.common.base.h.a(CompactHashMap.this.V(D10), entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.y();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!CompactHashMap.this.needsAllocArrays()) {
                int B10 = CompactHashMap.this.B();
                int f10 = com.google.common.collect.h.f(entry.getKey(), entry.getValue(), B10, CompactHashMap.this.M(), CompactHashMap.this.K(), CompactHashMap.this.L(), CompactHashMap.this.N());
                if (f10 == -1) {
                    return false;
                }
                CompactHashMap.this.I(f10, B10);
                CompactHashMap.g(CompactHashMap.this);
                CompactHashMap.this.C();
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.H();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.keySet().remove(obj);
            }
            if (CompactHashMap.this.J(obj) != CompactHashMap.f24381g) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* loaded from: classes3.dex */
    public final class g extends AbstractC0817b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f24397a;

        /* renamed from: b, reason: collision with root package name */
        public int f24398b;

        public g(int i10) {
            this.f24397a = (K) CompactHashMap.this.G(i10);
            this.f24398b = i10;
        }

        public final void b() {
            int i10 = this.f24398b;
            if (i10 == -1 || i10 >= CompactHashMap.this.size() || !com.google.common.base.h.a(this.f24397a, CompactHashMap.this.G(this.f24398b))) {
                this.f24398b = CompactHashMap.this.D(this.f24397a);
            }
        }

        @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
        public K getKey() {
            return this.f24397a;
        }

        @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
        public V getValue() {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) s.a(delegateOrNull.get(this.f24397a));
            }
            b();
            int i10 = this.f24398b;
            if (i10 != -1) {
                return (V) CompactHashMap.this.V(i10);
            }
            return (V) s.b();
        }

        @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
        public V setValue(V v10) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) s.a(delegateOrNull.put(this.f24397a, v10));
            }
            b();
            int i10 = this.f24398b;
            if (i10 != -1) {
                V v11 = (V) CompactHashMap.this.V(i10);
                CompactHashMap.this.U(this.f24398b, v10);
                return v11;
            }
            CompactHashMap.this.put(this.f24397a, v10);
            return (V) s.b();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.W();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public CompactHashMap(int i10) {
        E(i10);
    }

    public static /* synthetic */ int g(CompactHashMap compactHashMap) {
        int i10 = compactHashMap.f24384c;
        compactHashMap.f24384c = i10 - 1;
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            E(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    public static <K, V> CompactHashMap<K, V> w(int i10) {
        return new CompactHashMap<>(i10);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> y10 = y();
        while (y10.hasNext()) {
            Map.Entry<K, V> next = y10.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public int A(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.f24384c) {
            return -1;
        }
        return i11;
    }

    public final int B() {
        return (1 << (this.f24383b & 31)) - 1;
    }

    public void C() {
        this.f24383b += 32;
    }

    public final int D(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int d10 = l.d(obj);
        int B10 = B();
        int h10 = com.google.common.collect.h.h(M(), d10 & B10);
        if (h10 == 0) {
            return -1;
        }
        int b10 = com.google.common.collect.h.b(d10, B10);
        do {
            int i10 = h10 - 1;
            int x10 = x(i10);
            if (com.google.common.collect.h.b(x10, B10) == b10 && com.google.common.base.h.a(obj, G(i10))) {
                return i10;
            }
            h10 = com.google.common.collect.h.c(x10, B10);
        } while (h10 != 0);
        return -1;
    }

    public void E(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "Expected size must be >= 0");
        this.f24383b = com.google.common.primitives.b.a(i10, 1, 1073741823);
    }

    public void F(int i10, K k10, V v10, int i11, int i12) {
        R(i10, com.google.common.collect.h.d(i11, 0, i12));
        T(i10, k10);
        U(i10, v10);
    }

    public final K G(int i10) {
        return (K) L()[i10];
    }

    public Iterator<K> H() {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.keySet().iterator();
        }
        return new a();
    }

    public void I(int i10, int i11) {
        Object M10 = M();
        int[] K10 = K();
        Object[] L10 = L();
        Object[] N10 = N();
        int size = size();
        int i12 = size - 1;
        if (i10 < i12) {
            Object obj = L10[i12];
            L10[i10] = obj;
            N10[i10] = N10[i12];
            L10[i12] = null;
            N10[i12] = null;
            K10[i10] = K10[i12];
            K10[i12] = 0;
            int d10 = l.d(obj) & i11;
            int h10 = com.google.common.collect.h.h(M10, d10);
            if (h10 == size) {
                com.google.common.collect.h.i(M10, d10, i10 + 1);
                return;
            }
            while (true) {
                int i13 = h10 - 1;
                int i14 = K10[i13];
                int c10 = com.google.common.collect.h.c(i14, i11);
                if (c10 == size) {
                    K10[i13] = com.google.common.collect.h.d(i14, i10 + 1, i11);
                    return;
                }
                h10 = c10;
            }
        } else {
            L10[i10] = null;
            N10[i10] = null;
            K10[i10] = 0;
        }
    }

    public final Object J(Object obj) {
        if (needsAllocArrays()) {
            return f24381g;
        }
        int B10 = B();
        int f10 = com.google.common.collect.h.f(obj, null, B10, M(), K(), L(), null);
        if (f10 == -1) {
            return f24381g;
        }
        V V10 = V(f10);
        I(f10, B10);
        this.f24384c--;
        C();
        return V10;
    }

    public final int[] K() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] L() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object M() {
        Object obj = this.f24382a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public final Object[] N() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public void O(int i10) {
        this.entries = Arrays.copyOf(K(), i10);
        this.keys = Arrays.copyOf(L(), i10);
        this.values = Arrays.copyOf(N(), i10);
    }

    public final void P(int i10) {
        int min;
        int length = K().length;
        if (i10 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            O(min);
        }
    }

    public final int Q(int i10, int i11, int i12, int i13) {
        Object a10 = com.google.common.collect.h.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            com.google.common.collect.h.i(a10, i12 & i14, i13 + 1);
        }
        Object M10 = M();
        int[] K10 = K();
        for (int i15 = 0; i15 <= i10; i15++) {
            int h10 = com.google.common.collect.h.h(M10, i15);
            while (h10 != 0) {
                int i16 = h10 - 1;
                int i17 = K10[i16];
                int b10 = com.google.common.collect.h.b(i17, i10) | i15;
                int i18 = b10 & i14;
                int h11 = com.google.common.collect.h.h(a10, i18);
                com.google.common.collect.h.i(a10, i18, h10);
                K10[i16] = com.google.common.collect.h.d(b10, h11, i14);
                h10 = com.google.common.collect.h.c(i17, i10);
            }
        }
        this.f24382a = a10;
        S(i14);
        return i14;
    }

    public final void R(int i10, int i11) {
        K()[i10] = i11;
    }

    public final void S(int i10) {
        this.f24383b = com.google.common.collect.h.d(this.f24383b, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    public final void T(int i10, K k10) {
        L()[i10] = k10;
    }

    public final void U(int i10, V v10) {
        N()[i10] = v10;
    }

    public final V V(int i10) {
        return (V) N()[i10];
    }

    public Iterator<V> W() {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.values().iterator();
        }
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        C();
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.f24383b = com.google.common.primitives.b.a(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.f24382a = null;
            this.f24384c = 0;
            return;
        }
        Arrays.fill(L(), 0, this.f24384c, (Object) null);
        Arrays.fill(N(), 0, this.f24384c, (Object) null);
        com.google.common.collect.h.g(M());
        Arrays.fill(K(), 0, this.f24384c, 0);
        this.f24384c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsKey(obj);
        }
        if (D(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f24384c; i10++) {
            if (com.google.common.base.h.a(obj, V(i10))) {
                return true;
            }
        }
        return false;
    }

    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> t10 = t(B() + 1);
        int z10 = z();
        while (z10 >= 0) {
            t10.put(G(z10), V(z10));
            z10 = A(z10);
        }
        this.f24382a = t10;
        this.entries = null;
        this.keys = null;
        this.values = null;
        C();
        return t10;
    }

    public Map<K, V> delegateOrNull() {
        Object obj = this.f24382a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f24386e;
        if (set == null) {
            Set<Map.Entry<K, V>> s10 = s();
            this.f24386e = s10;
            return s10;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int D10 = D(obj);
        if (D10 == -1) {
            return null;
        }
        p(D10);
        return V(D10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f24385d;
        if (set == null) {
            Set<K> u10 = u();
            this.f24385d = u10;
            return u10;
        }
        return set;
    }

    public boolean needsAllocArrays() {
        if (this.f24382a == null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        int Q10;
        int i10;
        if (needsAllocArrays()) {
            r();
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k10, v10);
        }
        int[] K10 = K();
        Object[] L10 = L();
        Object[] N10 = N();
        int i11 = this.f24384c;
        int i12 = i11 + 1;
        int d10 = l.d(k10);
        int B10 = B();
        int i13 = d10 & B10;
        int h10 = com.google.common.collect.h.h(M(), i13);
        if (h10 == 0) {
            if (i12 > B10) {
                Q10 = Q(B10, com.google.common.collect.h.e(B10), d10, i11);
                i10 = Q10;
            } else {
                com.google.common.collect.h.i(M(), i13, i12);
                i10 = B10;
            }
        } else {
            int b10 = com.google.common.collect.h.b(d10, B10);
            int i14 = 0;
            while (true) {
                int i15 = h10 - 1;
                int i16 = K10[i15];
                if (com.google.common.collect.h.b(i16, B10) == b10 && com.google.common.base.h.a(k10, L10[i15])) {
                    V v11 = (V) N10[i15];
                    N10[i15] = v10;
                    p(i15);
                    return v11;
                }
                int c10 = com.google.common.collect.h.c(i16, B10);
                i14++;
                if (c10 == 0) {
                    if (i14 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k10, v10);
                    }
                    if (i12 > B10) {
                        Q10 = Q(B10, com.google.common.collect.h.e(B10), d10, i11);
                    } else {
                        K10[i15] = com.google.common.collect.h.d(i16, i12, B10);
                    }
                } else {
                    h10 = c10;
                }
            }
        }
        P(i12);
        F(i11, k10, v10, d10, i10);
        this.f24384c = i12;
        C();
        return null;
    }

    public int q(int i10, int i11) {
        return i10 - 1;
    }

    public int r() {
        com.google.common.base.k.v(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.f24383b;
        int j10 = com.google.common.collect.h.j(i10);
        this.f24382a = com.google.common.collect.h.a(j10);
        S(j10 - 1);
        this.entries = new int[i10];
        this.keys = new Object[i10];
        this.values = new Object[i10];
        return i10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V v10 = (V) J(obj);
        if (v10 == f24381g) {
            return null;
        }
        return v10;
    }

    public Set<Map.Entry<K, V>> s() {
        return new d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.size();
        }
        return this.f24384c;
    }

    public Map<K, V> t(int i10) {
        return new LinkedHashMap(i10, 1.0f);
    }

    public Set<K> u() {
        return new f();
    }

    public Collection<V> v() {
        return new h();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f24387f;
        if (collection == null) {
            Collection<V> v10 = v();
            this.f24387f = v10;
            return v10;
        }
        return collection;
    }

    public final int x(int i10) {
        return K()[i10];
    }

    public Iterator<Map.Entry<K, V>> y() {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.entrySet().iterator();
        }
        return new b();
    }

    public int z() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    /* loaded from: classes3.dex */
    public abstract class e<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public int f24392a;

        /* renamed from: b, reason: collision with root package name */
        public int f24393b;

        /* renamed from: c, reason: collision with root package name */
        public int f24394c;

        public e() {
            this.f24392a = CompactHashMap.this.f24383b;
            this.f24393b = CompactHashMap.this.z();
            this.f24394c = -1;
        }

        public final void a() {
            if (CompactHashMap.this.f24383b == this.f24392a) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i10);

        public void c() {
            this.f24392a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f24393b >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (hasNext()) {
                int i10 = this.f24393b;
                this.f24394c = i10;
                T b10 = b(i10);
                this.f24393b = CompactHashMap.this.A(this.f24393b);
                return b10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z10;
            a();
            if (this.f24394c >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.collect.f.c(z10);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.G(this.f24394c));
            this.f24393b = CompactHashMap.this.q(this.f24393b, this.f24394c);
            this.f24394c = -1;
        }

        public /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }
    }

    public void p(int i10) {
    }
}
