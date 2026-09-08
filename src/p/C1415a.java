package p;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import q.C1474a;

/* compiled from: ArrayMap.java */
/* renamed from: p.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1415a<K, V> extends i<K, V> implements Map<K, V> {

    /* renamed from: d, reason: collision with root package name */
    public C1415a<K, V>.C0339a f35936d;

    /* renamed from: e, reason: collision with root package name */
    public C1415a<K, V>.c f35937e;

    /* renamed from: f, reason: collision with root package name */
    public C1415a<K, V>.e f35938f;

    /* compiled from: ArrayMap.java */
    /* renamed from: p.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0339a extends AbstractSet<Map.Entry<K, V>> {
        public C0339a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1415a.this.size();
        }
    }

    /* compiled from: ArrayMap.java */
    /* renamed from: p.a$b */
    /* loaded from: classes.dex */
    public final class b extends AbstractC1419e<K> {
        public b() {
            super(C1415a.this.size());
        }

        @Override // p.AbstractC1419e
        public K a(int i10) {
            return C1415a.this.h(i10);
        }

        @Override // p.AbstractC1419e
        public void b(int i10) {
            C1415a.this.j(i10);
        }
    }

    /* compiled from: ArrayMap.java */
    /* renamed from: p.a$d */
    /* loaded from: classes.dex */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public int f35942a;

        /* renamed from: b, reason: collision with root package name */
        public int f35943b = -1;

        /* renamed from: c, reason: collision with root package name */
        public boolean f35944c;

        public d() {
            this.f35942a = C1415a.this.size() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f35943b++;
                this.f35944c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f35944c) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!C1474a.c(entry.getKey(), C1415a.this.h(this.f35943b)) || !C1474a.c(entry.getValue(), C1415a.this.l(this.f35943b))) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f35944c) {
                return C1415a.this.h(this.f35943b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f35944c) {
                return C1415a.this.l(this.f35943b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35943b < this.f35942a) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            if (this.f35944c) {
                K h10 = C1415a.this.h(this.f35943b);
                V l10 = C1415a.this.l(this.f35943b);
                int i10 = 0;
                if (h10 == null) {
                    hashCode = 0;
                } else {
                    hashCode = h10.hashCode();
                }
                if (l10 != null) {
                    i10 = l10.hashCode();
                }
                return hashCode ^ i10;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f35944c) {
                C1415a.this.j(this.f35943b);
                this.f35943b--;
                this.f35942a--;
                this.f35944c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (this.f35944c) {
                return C1415a.this.k(this.f35943b, v10);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: ArrayMap.java */
    /* renamed from: p.a$f */
    /* loaded from: classes.dex */
    public final class f extends AbstractC1419e<V> {
        public f() {
            super(C1415a.this.size());
        }

        @Override // p.AbstractC1419e
        public V a(int i10) {
            return C1415a.this.l(i10);
        }

        @Override // p.AbstractC1419e
        public void b(int i10) {
            C1415a.this.j(i10);
        }
    }

    public C1415a() {
    }

    public static <T> boolean n(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p.i, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p.i, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        C1415a<K, V>.C0339a c0339a = this.f35936d;
        if (c0339a == null) {
            C1415a<K, V>.C0339a c0339a2 = new C0339a();
            this.f35936d = c0339a2;
            return c0339a2;
        }
        return c0339a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p.i, java.util.Map
    public V get(Object obj) {
        return (V) super.get(obj);
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        C1415a<K, V>.c cVar = this.f35937e;
        if (cVar == null) {
            C1415a<K, V>.c cVar2 = new c();
            this.f35937e = cVar2;
            return cVar2;
        }
        return cVar;
    }

    public boolean m(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean o(Collection<?> collection) {
        int size = size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        if (size != size()) {
            return true;
        }
        return false;
    }

    public boolean p(Collection<?> collection) {
        int size = size();
        for (int size2 = size() - 1; size2 >= 0; size2--) {
            if (!collection.contains(h(size2))) {
                j(size2);
            }
        }
        if (size != size()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        d(size() + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p.i, java.util.Map
    public V remove(Object obj) {
        return (V) super.remove(obj);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        C1415a<K, V>.e eVar = this.f35938f;
        if (eVar == null) {
            C1415a<K, V>.e eVar2 = new e();
            this.f35938f = eVar2;
            return eVar2;
        }
        return eVar;
    }

    public C1415a(int i10) {
        super(i10);
    }

    /* compiled from: ArrayMap.java */
    /* renamed from: p.a$c */
    /* loaded from: classes.dex */
    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            C1415a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return C1415a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return C1415a.this.m(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return C1415a.n(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int i10 = 0;
            for (int size = C1415a.this.size() - 1; size >= 0; size--) {
                K h10 = C1415a.this.h(size);
                if (h10 == null) {
                    hashCode = 0;
                } else {
                    hashCode = h10.hashCode();
                }
                i10 += hashCode;
            }
            return i10;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return C1415a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new b();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int f10 = C1415a.this.f(obj);
            if (f10 >= 0) {
                C1415a.this.j(f10);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return C1415a.this.o(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return C1415a.this.p(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return C1415a.this.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int size = C1415a.this.size();
            Object[] objArr = new Object[size];
            for (int i10 = 0; i10 < size; i10++) {
                objArr[i10] = C1415a.this.h(i10);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            for (int i10 = 0; i10 < size; i10++) {
                tArr[i10] = C1415a.this.h(i10);
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    /* compiled from: ArrayMap.java */
    /* renamed from: p.a$e */
    /* loaded from: classes.dex */
    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            C1415a.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            if (C1415a.this.b(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return C1415a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new f();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int b10 = C1415a.this.b(obj);
            if (b10 >= 0) {
                C1415a.this.j(b10);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int size = C1415a.this.size();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < size) {
                if (collection.contains(C1415a.this.l(i10))) {
                    C1415a.this.j(i10);
                    i10--;
                    size--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int size = C1415a.this.size();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < size) {
                if (!collection.contains(C1415a.this.l(i10))) {
                    C1415a.this.j(i10);
                    i10--;
                    size--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public int size() {
            return C1415a.this.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int size = C1415a.this.size();
            Object[] objArr = new Object[size];
            for (int i10 = 0; i10 < size; i10++) {
                objArr[i10] = C1415a.this.l(i10);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            for (int i10 = 0; i10 < size; i10++) {
                tArr[i10] = C1415a.this.l(i10);
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    public C1415a(i iVar) {
        super(iVar);
    }
}
