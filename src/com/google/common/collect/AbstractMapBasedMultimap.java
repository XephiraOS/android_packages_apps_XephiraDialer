package com.google.common.collect;

import com.google.common.collect.AbstractC0818c;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends AbstractC0818c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: d, reason: collision with root package name */
    public transient Map<K, Collection<V>> f24351d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f24352e;

    /* loaded from: classes3.dex */
    public class a extends AbstractMapBasedMultimap<K, V>.c<Map.Entry<K, V>> {
        public a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k10, V v10) {
            return Maps.c(k10, v10);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Maps.j<K, Collection<V>> {

        /* renamed from: c, reason: collision with root package name */
        public final transient Map<K, Collection<V>> f24353c;

        /* loaded from: classes3.dex */
        public class a extends Maps.d<K, Collection<V>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return g.b(b.this.f24353c.entrySet(), obj);
            }

            @Override // com.google.common.collect.Maps.d
            public Map<K, Collection<V>> h() {
                return b.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C0220b();
            }

            @Override // com.google.common.collect.Maps.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.r(entry.getKey());
                return true;
            }
        }

        /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0220b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a, reason: collision with root package name */
            public final Iterator<Map.Entry<K, Collection<V>>> f24356a;

            /* renamed from: b, reason: collision with root package name */
            public Collection<V> f24357b;

            public C0220b() {
                this.f24356a = b.this.f24353c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f24356a.next();
                this.f24357b = next.getValue();
                return b.this.g(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f24356a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z10;
                if (this.f24357b != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.v(z10, "no calls to next() since the last call to remove()");
                this.f24356a.remove();
                AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this, this.f24357b.size());
                this.f24357b.clear();
                this.f24357b = null;
            }
        }

        public b(Map<K, Collection<V>> map) {
            this.f24353c = map;
        }

        @Override // com.google.common.collect.Maps.j
        public Set<Map.Entry<K, Collection<V>>> b() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f24353c == AbstractMapBasedMultimap.this.f24351d) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.b(new C0220b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.g(this.f24353c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) Maps.h(this.f24353c, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.t(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            if (this != obj && !this.f24353c.equals(obj)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.f24353c.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> o10 = AbstractMapBasedMultimap.this.o();
            o10.addAll(remove);
            AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this, remove.size());
            remove.clear();
            return o10;
        }

        public Map.Entry<K, Collection<V>> g(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.c(key, AbstractMapBasedMultimap.this.t(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f24353c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f24353c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f24353c.toString();
        }
    }

    /* loaded from: classes3.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<K, Collection<V>>> f24359a;

        /* renamed from: b, reason: collision with root package name */
        public K f24360b = null;

        /* renamed from: c, reason: collision with root package name */
        public Collection<V> f24361c = null;

        /* renamed from: d, reason: collision with root package name */
        public Iterator<V> f24362d = Iterators.d();

        public c() {
            this.f24359a = AbstractMapBasedMultimap.this.f24351d.entrySet().iterator();
        }

        public abstract T a(K k10, V v10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f24359a.hasNext() && !this.f24362d.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f24362d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f24359a.next();
                this.f24360b = next.getKey();
                Collection<V> value = next.getValue();
                this.f24361c = value;
                this.f24362d = value.iterator();
            }
            return a(s.a(this.f24360b), this.f24362d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f24362d.remove();
            Collection<V> collection = this.f24361c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f24359a.remove();
            }
            AbstractMapBasedMultimap.k(AbstractMapBasedMultimap.this);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends Maps.f<K, Collection<V>> {

        /* loaded from: classes3.dex */
        public class a implements Iterator<K> {

            /* renamed from: a, reason: collision with root package name */
            public Map.Entry<K, Collection<V>> f24365a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f24366b;

            public a(Iterator it) {
                this.f24366b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f24366b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f24366b.next();
                this.f24365a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z10;
                if (this.f24365a != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.v(z10, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f24365a.getValue();
                this.f24366b.remove();
                AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this, value.size());
                value.clear();
                this.f24365a = null;
            }
        }

        public d(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.f, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.b(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return i().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (this != obj && !i().keySet().equals(obj)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return i().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(i().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.f, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Collection<V> remove = i().remove(obj);
            if (remove != null) {
                int size = remove.size();
                remove.clear();
                AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this, size);
                if (size > 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f24368a;

        /* renamed from: b, reason: collision with root package name */
        public Collection<V> f24369b;

        /* renamed from: c, reason: collision with root package name */
        public final AbstractMapBasedMultimap<K, V>.e f24370c;

        /* renamed from: d, reason: collision with root package name */
        public final Collection<V> f24371d;

        /* loaded from: classes3.dex */
        public class a implements Iterator<V> {

            /* renamed from: a, reason: collision with root package name */
            public final Iterator<V> f24373a;

            /* renamed from: b, reason: collision with root package name */
            public final Collection<V> f24374b;

            public a() {
                Collection<V> collection = e.this.f24369b;
                this.f24374b = collection;
                this.f24373a = AbstractMapBasedMultimap.q(collection);
            }

            public void a() {
                e.this.e();
                if (e.this.f24369b == this.f24374b) {
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f24373a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                a();
                return this.f24373a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f24373a.remove();
                AbstractMapBasedMultimap.k(AbstractMapBasedMultimap.this);
                e.this.g();
            }
        }

        public e(K k10, Collection<V> collection, AbstractMapBasedMultimap<K, V>.e eVar) {
            Collection<V> c10;
            this.f24368a = k10;
            this.f24369b = collection;
            this.f24370c = eVar;
            if (eVar == null) {
                c10 = null;
            } else {
                c10 = eVar.c();
            }
            this.f24371d = c10;
        }

        public void a() {
            AbstractMapBasedMultimap<K, V>.e eVar = this.f24370c;
            if (eVar != null) {
                eVar.a();
            } else {
                AbstractMapBasedMultimap.this.f24351d.put(this.f24368a, this.f24369b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v10) {
            e();
            boolean isEmpty = this.f24369b.isEmpty();
            boolean add = this.f24369b.add(v10);
            if (add) {
                AbstractMapBasedMultimap.j(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f24369b.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.l(AbstractMapBasedMultimap.this, this.f24369b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        public Collection<V> c() {
            return this.f24369b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f24369b.clear();
            AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this, size);
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            e();
            return this.f24369b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            e();
            return this.f24369b.containsAll(collection);
        }

        public void e() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.e eVar = this.f24370c;
            if (eVar != null) {
                eVar.e();
                if (this.f24370c.c() != this.f24371d) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f24369b.isEmpty() && (collection = (Collection) AbstractMapBasedMultimap.this.f24351d.get(this.f24368a)) != null) {
                this.f24369b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f24369b.equals(obj);
        }

        public void g() {
            AbstractMapBasedMultimap<K, V>.e eVar = this.f24370c;
            if (eVar != null) {
                eVar.g();
            } else if (this.f24369b.isEmpty()) {
                AbstractMapBasedMultimap.this.f24351d.remove(this.f24368a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.f24369b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            e();
            boolean remove = this.f24369b.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.k(AbstractMapBasedMultimap.this);
                g();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.k.o(collection);
            int size = size();
            boolean retainAll = this.f24369b.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.l(AbstractMapBasedMultimap.this, this.f24369b.size() - size);
                g();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.f24369b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.f24369b.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends AbstractMapBasedMultimap<K, V>.e implements Set<V> {
        public f(K k10, Set<V> set) {
            super(k10, set, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean g10 = y.g((Set) this.f24369b, collection);
            if (g10) {
                AbstractMapBasedMultimap.l(AbstractMapBasedMultimap.this, this.f24369b.size() - size);
                g();
            }
            return g10;
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        com.google.common.base.k.d(map.isEmpty());
        this.f24351d = map;
    }

    public static /* synthetic */ int j(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i10 = abstractMapBasedMultimap.f24352e;
        abstractMapBasedMultimap.f24352e = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int k(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i10 = abstractMapBasedMultimap.f24352e;
        abstractMapBasedMultimap.f24352e = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int l(AbstractMapBasedMultimap abstractMapBasedMultimap, int i10) {
        int i11 = abstractMapBasedMultimap.f24352e + i10;
        abstractMapBasedMultimap.f24352e = i11;
        return i11;
    }

    public static /* synthetic */ int m(AbstractMapBasedMultimap abstractMapBasedMultimap, int i10) {
        int i11 = abstractMapBasedMultimap.f24352e - i10;
        abstractMapBasedMultimap.f24352e = i11;
        return i11;
    }

    public static <E> Iterator<E> q(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    @Override // com.google.common.collect.AbstractC0818c
    public Map<K, Collection<V>> c() {
        return new b(this.f24351d);
    }

    @Override // com.google.common.collect.p
    public void clear() {
        Iterator<Collection<V>> it = this.f24351d.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f24351d.clear();
        this.f24352e = 0;
    }

    @Override // com.google.common.collect.AbstractC0818c
    public Collection<Map.Entry<K, V>> d() {
        if (this instanceof x) {
            return new AbstractC0818c.b(this);
        }
        return new AbstractC0818c.a();
    }

    @Override // com.google.common.collect.AbstractC0818c
    public Set<K> e() {
        return new d(this.f24351d);
    }

    @Override // com.google.common.collect.AbstractC0818c
    public Collection<Map.Entry<K, V>> f() {
        return super.f();
    }

    @Override // com.google.common.collect.AbstractC0818c
    public Iterator<Map.Entry<K, V>> g() {
        return new a(this);
    }

    @Override // com.google.common.collect.p
    public Collection<V> get(K k10) {
        Collection<V> collection = this.f24351d.get(k10);
        if (collection == null) {
            collection = p(k10);
        }
        return t(k10, collection);
    }

    public abstract Collection<V> o();

    public Collection<V> p(K k10) {
        return o();
    }

    @Override // com.google.common.collect.p
    public boolean put(K k10, V v10) {
        Collection<V> collection = this.f24351d.get(k10);
        if (collection == null) {
            Collection<V> p10 = p(k10);
            if (p10.add(v10)) {
                this.f24352e++;
                this.f24351d.put(k10, p10);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        }
        if (collection.add(v10)) {
            this.f24352e++;
            return true;
        }
        return false;
    }

    public final void r(Object obj) {
        Collection collection = (Collection) Maps.i(this.f24351d, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f24352e -= size;
        }
    }

    public final void s(Map<K, Collection<V>> map) {
        this.f24351d = map;
        this.f24352e = 0;
        for (Collection<V> collection : map.values()) {
            com.google.common.base.k.d(!collection.isEmpty());
            this.f24352e += collection.size();
        }
    }

    @Override // com.google.common.collect.p
    public int size() {
        return this.f24352e;
    }

    public abstract Collection<V> t(K k10, Collection<V> collection);
}
