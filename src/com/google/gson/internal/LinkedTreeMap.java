package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<Comparable> f24748a = new a();
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    /* loaded from: classes3.dex */
    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes3.dex */
        public class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && LinkedTreeMap.this.e((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> e10;
            if (!(obj instanceof Map.Entry) || (e10 = LinkedTreeMap.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.h(e10, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public final class c extends AbstractSet<K> {

        /* loaded from: classes3.dex */
        public class a extends LinkedTreeMap<K, V>.d<K> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f24762f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (LinkedTreeMap.this.i(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes3.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public e<K, V> f24753a;

        /* renamed from: b, reason: collision with root package name */
        public e<K, V> f24754b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f24755c;

        public d() {
            this.f24753a = LinkedTreeMap.this.header.f24760d;
            this.f24755c = LinkedTreeMap.this.modCount;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f24753a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.f24755c) {
                    this.f24753a = eVar.f24760d;
                    this.f24754b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f24753a != LinkedTreeMap.this.header) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f24754b;
            if (eVar != null) {
                LinkedTreeMap.this.h(eVar, true);
                this.f24754b = null;
                this.f24755c = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(f24748a, true);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public final boolean b(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f24761e = eVar;
        eVar.f24760d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (f(obj) != null) {
            return true;
        }
        return false;
    }

    public e<K, V> d(K k10, boolean z10) {
        int i10;
        e<K, V> eVar;
        Comparable comparable;
        e<K, V> eVar2;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar3 = this.root;
        if (eVar3 != null) {
            if (comparator == f24748a) {
                comparable = (Comparable) k10;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(eVar3.f24762f);
                } else {
                    i10 = comparator.compare(k10, eVar3.f24762f);
                }
                if (i10 == 0) {
                    return eVar3;
                }
                if (i10 < 0) {
                    eVar2 = eVar3.f24758b;
                } else {
                    eVar2 = eVar3.f24759c;
                }
                if (eVar2 == null) {
                    break;
                }
                eVar3 = eVar2;
            }
        } else {
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar3 == null) {
            if (comparator == f24748a && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(this.allowNullValues, eVar3, k10, eVar4, eVar4.f24761e);
            this.root = eVar;
        } else {
            eVar = new e<>(this.allowNullValues, eVar3, k10, eVar4, eVar4.f24761e);
            if (i10 < 0) {
                eVar3.f24758b = eVar;
            } else {
                eVar3.f24759c = eVar;
            }
            g(eVar3, true);
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    public e<K, V> e(Map.Entry<?, ?> entry) {
        e<K, V> f10 = f(entry.getKey());
        if (f10 == null || !b(f10.f24764h, entry.getValue())) {
            return null;
        }
        return f10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.entrySet;
        if (bVar == null) {
            LinkedTreeMap<K, V>.b bVar2 = new b();
            this.entrySet = bVar2;
            return bVar2;
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> f(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return d(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void g(e<K, V> eVar, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f24758b;
            e<K, V> eVar3 = eVar.f24759c;
            int i14 = 0;
            if (eVar2 != null) {
                i10 = eVar2.f24765i;
            } else {
                i10 = 0;
            }
            if (eVar3 != null) {
                i11 = eVar3.f24765i;
            } else {
                i11 = 0;
            }
            int i15 = i10 - i11;
            if (i15 == -2) {
                e<K, V> eVar4 = eVar3.f24758b;
                e<K, V> eVar5 = eVar3.f24759c;
                if (eVar5 != null) {
                    i13 = eVar5.f24765i;
                } else {
                    i13 = 0;
                }
                if (eVar4 != null) {
                    i14 = eVar4.f24765i;
                }
                int i16 = i14 - i13;
                if (i16 != -1 && (i16 != 0 || z10)) {
                    l(eVar3);
                    k(eVar);
                } else {
                    k(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 2) {
                e<K, V> eVar6 = eVar2.f24758b;
                e<K, V> eVar7 = eVar2.f24759c;
                if (eVar7 != null) {
                    i12 = eVar7.f24765i;
                } else {
                    i12 = 0;
                }
                if (eVar6 != null) {
                    i14 = eVar6.f24765i;
                }
                int i17 = i14 - i12;
                if (i17 != 1 && (i17 != 0 || z10)) {
                    k(eVar2);
                    l(eVar);
                } else {
                    l(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 0) {
                eVar.f24765i = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f24765i = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f24757a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> f10 = f(obj);
        if (f10 != null) {
            return f10.f24764h;
        }
        return null;
    }

    public void h(e<K, V> eVar, boolean z10) {
        e<K, V> a10;
        int i10;
        if (z10) {
            e<K, V> eVar2 = eVar.f24761e;
            eVar2.f24760d = eVar.f24760d;
            eVar.f24760d.f24761e = eVar2;
        }
        e<K, V> eVar3 = eVar.f24758b;
        e<K, V> eVar4 = eVar.f24759c;
        e<K, V> eVar5 = eVar.f24757a;
        int i11 = 0;
        if (eVar3 != null && eVar4 != null) {
            if (eVar3.f24765i > eVar4.f24765i) {
                a10 = eVar3.b();
            } else {
                a10 = eVar4.a();
            }
            h(a10, false);
            e<K, V> eVar6 = eVar.f24758b;
            if (eVar6 != null) {
                i10 = eVar6.f24765i;
                a10.f24758b = eVar6;
                eVar6.f24757a = a10;
                eVar.f24758b = null;
            } else {
                i10 = 0;
            }
            e<K, V> eVar7 = eVar.f24759c;
            if (eVar7 != null) {
                i11 = eVar7.f24765i;
                a10.f24759c = eVar7;
                eVar7.f24757a = a10;
                eVar.f24759c = null;
            }
            a10.f24765i = Math.max(i10, i11) + 1;
            j(eVar, a10);
            return;
        }
        if (eVar3 != null) {
            j(eVar, eVar3);
            eVar.f24758b = null;
        } else if (eVar4 != null) {
            j(eVar, eVar4);
            eVar.f24759c = null;
        } else {
            j(eVar, null);
        }
        g(eVar5, false);
        this.size--;
        this.modCount++;
    }

    public e<K, V> i(Object obj) {
        e<K, V> f10 = f(obj);
        if (f10 != null) {
            h(f10, true);
        }
        return f10;
    }

    public final void j(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f24757a;
        eVar.f24757a = null;
        if (eVar2 != null) {
            eVar2.f24757a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.f24758b == eVar) {
                eVar3.f24758b = eVar2;
                return;
            } else {
                eVar3.f24759c = eVar2;
                return;
            }
        }
        this.root = eVar2;
    }

    public final void k(e<K, V> eVar) {
        int i10;
        int i11;
        e<K, V> eVar2 = eVar.f24758b;
        e<K, V> eVar3 = eVar.f24759c;
        e<K, V> eVar4 = eVar3.f24758b;
        e<K, V> eVar5 = eVar3.f24759c;
        eVar.f24759c = eVar4;
        if (eVar4 != null) {
            eVar4.f24757a = eVar;
        }
        j(eVar, eVar3);
        eVar3.f24758b = eVar;
        eVar.f24757a = eVar3;
        int i12 = 0;
        if (eVar2 != null) {
            i10 = eVar2.f24765i;
        } else {
            i10 = 0;
        }
        if (eVar4 != null) {
            i11 = eVar4.f24765i;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f24765i = max;
        if (eVar5 != null) {
            i12 = eVar5.f24765i;
        }
        eVar3.f24765i = Math.max(max, i12) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar == null) {
            LinkedTreeMap<K, V>.c cVar2 = new c();
            this.keySet = cVar2;
            return cVar2;
        }
        return cVar;
    }

    public final void l(e<K, V> eVar) {
        int i10;
        int i11;
        e<K, V> eVar2 = eVar.f24758b;
        e<K, V> eVar3 = eVar.f24759c;
        e<K, V> eVar4 = eVar2.f24758b;
        e<K, V> eVar5 = eVar2.f24759c;
        eVar.f24758b = eVar5;
        if (eVar5 != null) {
            eVar5.f24757a = eVar;
        }
        j(eVar, eVar2);
        eVar2.f24759c = eVar;
        eVar.f24757a = eVar2;
        int i12 = 0;
        if (eVar3 != null) {
            i10 = eVar3.f24765i;
        } else {
            i10 = 0;
        }
        if (eVar5 != null) {
            i11 = eVar5.f24765i;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f24765i = max;
        if (eVar4 != null) {
            i12 = eVar4.f24765i;
        }
        eVar2.f24765i = Math.max(max, i12) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        if (k10 != null) {
            if (v10 == null && !this.allowNullValues) {
                throw new NullPointerException("value == null");
            }
            e<K, V> d10 = d(k10, true);
            V v11 = d10.f24764h;
            d10.f24764h = v10;
            return v11;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> i10 = i(obj);
        if (i10 != null) {
            return i10.f24764h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(boolean z10) {
        this(f24748a, z10);
    }

    public LinkedTreeMap(Comparator<? super K> comparator, boolean z10) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? f24748a : comparator;
        this.allowNullValues = z10;
        this.header = new e<>(z10);
    }

    /* loaded from: classes3.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public e<K, V> f24757a;

        /* renamed from: b, reason: collision with root package name */
        public e<K, V> f24758b;

        /* renamed from: c, reason: collision with root package name */
        public e<K, V> f24759c;

        /* renamed from: d, reason: collision with root package name */
        public e<K, V> f24760d;

        /* renamed from: e, reason: collision with root package name */
        public e<K, V> f24761e;

        /* renamed from: f, reason: collision with root package name */
        public final K f24762f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f24763g;

        /* renamed from: h, reason: collision with root package name */
        public V f24764h;

        /* renamed from: i, reason: collision with root package name */
        public int f24765i;

        public e(boolean z10) {
            this.f24762f = null;
            this.f24763g = z10;
            this.f24761e = this;
            this.f24760d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this.f24758b;
            while (true) {
                e<K, V> eVar2 = eVar;
                e<K, V> eVar3 = this;
                this = eVar2;
                if (this != null) {
                    eVar = this.f24758b;
                } else {
                    return eVar3;
                }
            }
        }

        public e<K, V> b() {
            e<K, V> eVar = this.f24759c;
            while (true) {
                e<K, V> eVar2 = eVar;
                e<K, V> eVar3 = this;
                this = eVar2;
                if (this != null) {
                    eVar = this.f24759c;
                } else {
                    return eVar3;
                }
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f24762f;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v10 = this.f24764h;
            if (v10 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v10.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f24762f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f24764h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k10 = this.f24762f;
            int i10 = 0;
            if (k10 == null) {
                hashCode = 0;
            } else {
                hashCode = k10.hashCode();
            }
            V v10 = this.f24764h;
            if (v10 != null) {
                i10 = v10.hashCode();
            }
            return hashCode ^ i10;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (v10 == null && !this.f24763g) {
                throw new NullPointerException("value == null");
            }
            V v11 = this.f24764h;
            this.f24764h = v10;
            return v11;
        }

        public String toString() {
            return this.f24762f + "=" + this.f24764h;
        }

        public e(boolean z10, e<K, V> eVar, K k10, e<K, V> eVar2, e<K, V> eVar3) {
            this.f24757a = eVar;
            this.f24762f = k10;
            this.f24763g = z10;
            this.f24765i = 1;
            this.f24760d = eVar2;
            this.f24761e = eVar3;
            eVar3.f24760d = this;
            eVar2.f24761e = this;
        }
    }
}
