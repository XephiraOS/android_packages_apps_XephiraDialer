package com.google.common.collect;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes3.dex */
public final class Synchronized {

    /* loaded from: classes3.dex */
    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements e<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: d, reason: collision with root package name */
        public transient Set<V> f24553d;

        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public e<K, V> h() {
            return (e) super.h();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                try {
                    if (this.f24553d == null) {
                        this.f24553d = Synchronized.set(g().values(), this.mutex);
                    }
                    set = this.f24553d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Collection
        public boolean add(E e10) {
            boolean add;
            synchronized (this.mutex) {
                add = h().add(e10);
            }
            return add;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = h().addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.mutex) {
                h().clear();
            }
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = h().contains(obj);
            }
            return contains;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = h().containsAll(collection);
            }
            return containsAll;
        }

        /* renamed from: g */
        public Collection<E> h() {
            return (Collection) super.e();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = h().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return h().iterator();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = h().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = h().removeAll(collection);
            }
            return removeAll;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = h().retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = h().size();
            }
            return size;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = h().toArray();
            }
            return array;
        }

        public SynchronizedCollection(Collection<E> collection, Object obj) {
            super(collection, obj);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) h().toArray(tArr);
            }
            return tArr2;
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedEntry(Map.Entry<K, V> entry, Object obj) {
            super(entry, obj);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = g().equals(obj);
            }
            return equals;
        }

        public Map.Entry<K, V> g() {
            return (Map.Entry) super.e();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = g().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = g().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = g().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            V value;
            synchronized (this.mutex) {
                value = g().setValue(v10);
            }
            return value;
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        public transient Set<K> f24554a;

        /* renamed from: b, reason: collision with root package name */
        public transient Collection<V> f24555b;

        /* renamed from: c, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f24556c;

        public SynchronizedMap(Map<K, V> map, Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                h().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = h().containsKey(obj);
            }
            return containsKey;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = h().containsValue(obj);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                try {
                    if (this.f24556c == null) {
                        this.f24556c = Synchronized.set(h().entrySet(), this.mutex);
                    }
                    set = this.f24556c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = h().equals(obj);
            }
            return equals;
        }

        /* renamed from: g */
        public Map<K, V> h() {
            return (Map) super.e();
        }

        @Override // java.util.Map
        public V get(Object obj) {
            V v10;
            synchronized (this.mutex) {
                v10 = h().get(obj);
            }
            return v10;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = h().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = h().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                try {
                    if (this.f24554a == null) {
                        this.f24554a = Synchronized.set(h().keySet(), this.mutex);
                    }
                    set = this.f24554a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public V put(K k10, V v10) {
            V put;
            synchronized (this.mutex) {
                put = h().put(k10, v10);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                h().putAll(map);
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = h().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = h().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                try {
                    if (this.f24555b == null) {
                        this.f24555b = Synchronized.d(h().values(), this.mutex);
                    }
                    collection = this.f24555b;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedObject implements Serializable {
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        public SynchronizedObject(Object obj, Object obj2) {
            this.delegate = com.google.common.base.k.o(obj);
            this.mutex = obj2 == null ? this : obj2;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        public Object e() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSet(Set<E> set, Object obj) {
            super(set, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = h().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        public Set<E> h() {
            return (Set) super.h();
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = h().hashCode();
            }
            return hashCode;
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedMap(SortedMap<K, V> sortedMap, Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = h().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = h().firstKey();
            }
            return firstKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        public SortedMap<K, V> h() {
            return (SortedMap) super.h();
        }

        public SortedMap<K, V> headMap(K k10) {
            SortedMap<K, V> h10;
            synchronized (this.mutex) {
                h10 = Synchronized.h(h().headMap(k10), this.mutex);
            }
            return h10;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = h().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k10, K k11) {
            SortedMap<K, V> h10;
            synchronized (this.mutex) {
                h10 = Synchronized.h(h().subMap(k10, k11), this.mutex);
            }
            return h10;
        }

        public SortedMap<K, V> tailMap(K k10) {
            SortedMap<K, V> h10;
            synchronized (this.mutex) {
                h10 = Synchronized.h(h().tailMap(k10), this.mutex);
            }
            return h10;
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSet(SortedSet<E> sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = h().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = h().first();
            }
            return first;
        }

        public SortedSet<E> headSet(E e10) {
            SortedSet<E> i10;
            synchronized (this.mutex) {
                i10 = Synchronized.i(h().headSet(e10), this.mutex);
            }
            return i10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public SortedSet<E> h() {
            return (SortedSet) super.h();
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = h().last();
            }
            return last;
        }

        public SortedSet<E> subSet(E e10, E e11) {
            SortedSet<E> i10;
            synchronized (this.mutex) {
                i10 = Synchronized.i(h().subSet(e10, e11), this.mutex);
            }
            return i10;
        }

        public SortedSet<E> tailSet(E e10) {
            SortedSet<E> i10;
            synchronized (this.mutex) {
                i10 = Synchronized.i(h().tailSet(e10), this.mutex);
            }
            return i10;
        }
    }

    public static <E> Collection<E> d(Collection<E> collection, Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    public static <K, V> NavigableMap<K, V> e(NavigableMap<K, V> navigableMap, Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    public static <E> NavigableSet<E> f(NavigableSet<E> navigableSet, Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    public static <K, V> Map.Entry<K, V> g(Map.Entry<K, V> entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    public static <K, V> SortedMap<K, V> h(SortedMap<K, V> sortedMap, Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    public static <E> SortedSet<E> i(SortedSet<E> sortedSet, Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    public static <K, V> Map<K, V> map(Map<K, V> map, Object obj) {
        return new SynchronizedMap(map, obj);
    }

    public static <E> Set<E> set(Set<E> set, Object obj) {
        return new SynchronizedSet(set, obj);
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        /* renamed from: d, reason: collision with root package name */
        public transient NavigableSet<K> f24557d;

        /* renamed from: e, reason: collision with root package name */
        public transient NavigableMap<K, V> f24558e;

        /* renamed from: f, reason: collision with root package name */
        public transient NavigableSet<K> f24559f;

        public SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k10) {
            Map.Entry<K, V> g10;
            synchronized (this.mutex) {
                g10 = Synchronized.g(g().ceilingEntry(k10), this.mutex);
            }
            return g10;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = g().ceilingKey(k10);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<K> navigableSet = this.f24557d;
                    if (navigableSet == null) {
                        NavigableSet<K> f10 = Synchronized.f(g().descendingKeySet(), this.mutex);
                        this.f24557d = f10;
                        return f10;
                    }
                    return navigableSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                try {
                    NavigableMap<K, V> navigableMap = this.f24558e;
                    if (navigableMap == null) {
                        NavigableMap<K, V> e10 = Synchronized.e(g().descendingMap(), this.mutex);
                        this.f24558e = e10;
                        return e10;
                    }
                    return navigableMap;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> g10;
            synchronized (this.mutex) {
                g10 = Synchronized.g(g().firstEntry(), this.mutex);
            }
            return g10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k10) {
            Map.Entry<K, V> g10;
            synchronized (this.mutex) {
                g10 = Synchronized.g(g().floorEntry(k10), this.mutex);
            }
            return g10;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = g().floorKey(k10);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k10, boolean z10) {
            NavigableMap<K, V> e10;
            synchronized (this.mutex) {
                e10 = Synchronized.e(g().headMap(k10, z10), this.mutex);
            }
            return e10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k10) {
            Map.Entry<K, V> g10;
            synchronized (this.mutex) {
                g10 = Synchronized.g(g().higherEntry(k10), this.mutex);
            }
            return g10;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = g().higherKey(k10);
            }
            return higherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap
        /* renamed from: i, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> h() {
            return (NavigableMap) super.h();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> g10;
            synchronized (this.mutex) {
                g10 = Synchronized.g(g().lastEntry(), this.mutex);
            }
            return g10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k10) {
            Map.Entry<K, V> g10;
            synchronized (this.mutex) {
                g10 = Synchronized.g(g().lowerEntry(k10), this.mutex);
            }
            return g10;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = g().lowerKey(k10);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<K> navigableSet = this.f24559f;
                    if (navigableSet == null) {
                        NavigableSet<K> f10 = Synchronized.f(g().navigableKeySet(), this.mutex);
                        this.f24559f = f10;
                        return f10;
                    }
                    return navigableSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> g10;
            synchronized (this.mutex) {
                g10 = Synchronized.g(g().pollFirstEntry(), this.mutex);
            }
            return g10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> g10;
            synchronized (this.mutex) {
                g10 = Synchronized.g(g().pollLastEntry(), this.mutex);
            }
            return g10;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
            NavigableMap<K, V> e10;
            synchronized (this.mutex) {
                e10 = Synchronized.e(g().subMap(k10, z10, k11, z11), this.mutex);
            }
            return e10;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k10, boolean z10) {
            NavigableMap<K, V> e10;
            synchronized (this.mutex) {
                e10 = Synchronized.e(g().tailMap(k10, z10), this.mutex);
            }
            return e10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k10) {
            return tailMap(k10, true);
        }
    }

    /* loaded from: classes3.dex */
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        public transient NavigableSet<E> f24560a;

        public SynchronizedNavigableSet(NavigableSet<E> navigableSet, Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e10) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = g().ceiling(e10);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return g().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<E> navigableSet = this.f24560a;
                    if (navigableSet == null) {
                        NavigableSet<E> f10 = Synchronized.f(g().descendingSet(), this.mutex);
                        this.f24560a = f10;
                        return f10;
                    }
                    return navigableSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableSet
        public E floor(E e10) {
            E floor;
            synchronized (this.mutex) {
                floor = g().floor(e10);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e10, boolean z10) {
            NavigableSet<E> f10;
            synchronized (this.mutex) {
                f10 = Synchronized.f(g().headSet(e10, z10), this.mutex);
            }
            return f10;
        }

        @Override // java.util.NavigableSet
        public E higher(E e10) {
            E higher;
            synchronized (this.mutex) {
                higher = g().higher(e10);
            }
            return higher;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet
        /* renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<E> h() {
            return (NavigableSet) super.h();
        }

        @Override // java.util.NavigableSet
        public E lower(E e10) {
            E lower;
            synchronized (this.mutex) {
                lower = g().lower(e10);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = g().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = g().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e10, boolean z10, E e11, boolean z11) {
            NavigableSet<E> f10;
            synchronized (this.mutex) {
                f10 = Synchronized.f(g().subSet(e10, z10, e11, z11), this.mutex);
            }
            return f10;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e10, boolean z10) {
            NavigableSet<E> f10;
            synchronized (this.mutex) {
                f10 = Synchronized.f(g().tailSet(e10, z10), this.mutex);
            }
            return f10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e10) {
            return headSet(e10, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e10) {
            return tailSet(e10, true);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e10, E e11) {
            return subSet(e10, true, e11, false);
        }
    }
}
