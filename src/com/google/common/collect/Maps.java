package com.google.common.collect;

import com.google.common.collect.y;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes3.dex */
public final class Maps {

    /* loaded from: classes3.dex */
    public enum EntryFunction implements com.google.common.base.d<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.base.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.base.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(a aVar) {
            this();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* loaded from: classes3.dex */
    public class a<K, V> extends B<Map.Entry<K, V>, K> {
        public a(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.B
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* loaded from: classes3.dex */
    public class b<K, V> extends B<Map.Entry<K, V>, V> {
        public b(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.B
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class c<K, V> extends com.google.common.collect.j<K, V> implements NavigableMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public transient Comparator<? super K> f24517a;

        /* renamed from: b, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f24518b;

        /* renamed from: c, reason: collision with root package name */
        public transient NavigableSet<K> f24519c;

        /* loaded from: classes3.dex */
        public class a extends d<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.d
            public Map<K, V> h() {
                return c.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return c.this.g();
            }
        }

        public static <T> Ordering<T> i(Comparator<T> comparator) {
            return Ordering.b(comparator).e();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k10) {
            return h().floorEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            return h().floorKey(k10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f24517a;
            if (comparator == null) {
                Comparator<? super K> comparator2 = h().comparator();
                if (comparator2 == null) {
                    comparator2 = Ordering.c();
                }
                Ordering i10 = i(comparator2);
                this.f24517a = i10;
                return i10;
            }
            return comparator;
        }

        @Override // com.google.common.collect.k
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Map<K, V> b() {
            return h();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return h().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return h();
        }

        @Override // com.google.common.collect.j, java.util.Map, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f24518b;
            if (set == null) {
                Set<Map.Entry<K, V>> f10 = f();
                this.f24518b = f10;
                return f10;
            }
            return set;
        }

        public Set<Map.Entry<K, V>> f() {
            return new a();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return h().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return h().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k10) {
            return h().ceilingEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            return h().ceilingKey(k10);
        }

        public abstract Iterator<Map.Entry<K, V>> g();

        public abstract NavigableMap<K, V> h();

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k10, boolean z10) {
            return h().tailMap(k10, z10).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k10) {
            return h().lowerEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            return h().lowerKey(k10);
        }

        @Override // com.google.common.collect.j, java.util.Map, java.util.SortedMap
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return h().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return h().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k10) {
            return h().higherEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            return h().higherKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f24519c;
            if (navigableSet == null) {
                g gVar = new g(this);
                this.f24519c = gVar;
                return gVar;
            }
            return navigableSet;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return h().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return h().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
            return h().subMap(k11, z11, k10, z10).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k10, boolean z10) {
            return h().headMap(k10, z10).descendingMap();
        }

        @Override // com.google.common.collect.k
        public String toString() {
            return e();
        }

        @Override // com.google.common.collect.j, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new i(this);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k10) {
            return tailMap(k10, true);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<K, V> extends y.a<Map.Entry<K, V>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object h10 = Maps.h(h(), key);
            if (!com.google.common.base.h.a(h10, entry.getValue())) {
                return false;
            }
            if (h10 == null && !h().containsKey(key)) {
                return false;
            }
            return true;
        }

        public abstract Map<K, V> h();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return h().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return h().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.y.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.k.o(collection));
            } catch (UnsupportedOperationException unused) {
                return y.h(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.y.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.k.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet f10 = y.f(collection.size());
                for (Object obj : collection) {
                    if (this.contains(obj) && (obj instanceof Map.Entry)) {
                        f10.add(((Map.Entry) obj).getKey());
                    }
                }
                return this.h().keySet().retainAll(f10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h().size();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class e<K, V> extends AbstractMap<K, V> {

        /* loaded from: classes3.dex */
        public class a extends d<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.d
            public Map<K, V> h() {
                return e.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return e.this.b();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> b();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.b(b());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }
    }

    /* loaded from: classes3.dex */
    public static class f<K, V> extends y.a<K> {

        /* renamed from: a, reason: collision with root package name */
        @Weak
        public final Map<K, V> f24522a;

        public f(Map<K, V> map) {
            this.f24522a = (Map) com.google.common.base.k.o(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return i().containsKey(obj);
        }

        /* renamed from: h */
        public Map<K, V> i() {
            return this.f24522a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return i().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.d(i().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                i().remove(obj);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i().size();
        }
    }

    /* loaded from: classes3.dex */
    public static class g<K, V> extends h<K, V> implements NavigableSet<K> {
        public g(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k10) {
            return h().ceilingKey(k10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return h().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k10) {
            return h().floorKey(k10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k10, boolean z10) {
            return h().headMap(k10, z10).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k10) {
            return h().higherKey(k10);
        }

        @Override // com.google.common.collect.Maps.h
        /* renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> i() {
            return (NavigableMap) this.f24522a;
        }

        @Override // java.util.NavigableSet
        public K lower(K k10) {
            return h().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.e(h().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.e(h().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k10, boolean z10, K k11, boolean z11) {
            return h().subMap(k10, z10, k11, z11).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k10, boolean z10) {
            return h().tailMap(k10, z10).navigableKeySet();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k10) {
            return headSet(k10, false);
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k10, K k11) {
            return subSet(k10, true, k11, false);
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k10) {
            return tailSet(k10, true);
        }
    }

    /* loaded from: classes3.dex */
    public static class h<K, V> extends f<K, V> implements SortedSet<K> {
        public h(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return i().firstKey();
        }

        public SortedMap<K, V> i() {
            throw null;
        }

        @Override // java.util.SortedSet
        public K last() {
            return i().lastKey();
        }
    }

    /* loaded from: classes3.dex */
    public static class i<K, V> extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        @Weak
        public final Map<K, V> f24523a;

        public i(Map<K, V> map) {
            this.f24523a = (Map) com.google.common.base.k.o(map);
        }

        public final Map<K, V> a() {
            return this.f24523a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.l(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : this.a().entrySet()) {
                    if (com.google.common.base.h.a(obj, entry.getValue())) {
                        this.a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.k.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d10 = y.d();
                for (Map.Entry<K, V> entry : this.a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d10.add(entry.getKey());
                    }
                }
                return this.a().keySet().removeAll(d10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.k.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d10 = y.d();
                for (Map.Entry<K, V> entry : this.a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d10.add(entry.getKey());
                    }
                }
                return this.a().keySet().retainAll(d10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class j<K, V> extends AbstractMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f24524a;

        /* renamed from: b, reason: collision with root package name */
        public transient Collection<V> f24525b;

        public abstract Set<Map.Entry<K, V>> b();

        public Collection<V> d() {
            return new i(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f24524a;
            if (set == null) {
                Set<Map.Entry<K, V>> b10 = b();
                this.f24524a = b10;
                return b10;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f24525b;
            if (collection == null) {
                Collection<V> d10 = d();
                this.f24525b = d10;
                return d10;
            }
            return collection;
        }
    }

    public static int a(int i10) {
        if (i10 < 3) {
            com.google.common.collect.f.b(i10, "expectedSize");
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) Math.ceil(i10 / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean b(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> c(K k10, V v10) {
        return new ImmutableEntry(k10, v10);
    }

    public static <K, V> Iterator<K> d(Iterator<Map.Entry<K, V>> it) {
        return new a(it);
    }

    public static <K> K e(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K, V> HashMap<K, V> f() {
        return new HashMap<>();
    }

    public static boolean g(Map<?, ?> map, Object obj) {
        com.google.common.base.k.o(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V h(Map<?, V> map, Object obj) {
        com.google.common.base.k.o(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <V> V i(Map<?, V> map, Object obj) {
        com.google.common.base.k.o(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String j(Map<?, ?> map) {
        StringBuilder a10 = com.google.common.collect.g.a(map.size());
        a10.append('{');
        boolean z10 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z10) {
                a10.append(", ");
            }
            a10.append(entry.getKey());
            a10.append('=');
            a10.append(entry.getValue());
            z10 = false;
        }
        a10.append('}');
        return a10.toString();
    }

    public static <V> com.google.common.base.d<Map.Entry<?, V>, V> k() {
        return EntryFunction.VALUE;
    }

    public static <K, V> Iterator<V> l(Iterator<Map.Entry<K, V>> it) {
        return new b(it);
    }
}
