package com.google.common.collect;

import com.google.common.collect.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: AbstractMultimap.java */
/* renamed from: com.google.common.collect.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0818c<K, V> implements p<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public transient Collection<Map.Entry<K, V>> f24569a;

    /* renamed from: b, reason: collision with root package name */
    public transient Set<K> f24570b;

    /* renamed from: c, reason: collision with root package name */
    public transient Map<K, Collection<V>> f24571c;

    /* compiled from: AbstractMultimap.java */
    /* renamed from: com.google.common.collect.c$a */
    /* loaded from: classes3.dex */
    public class a extends q.a<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.q.a
        public p<K, V> a() {
            return AbstractC0818c.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractC0818c.this.g();
        }
    }

    /* compiled from: AbstractMultimap.java */
    /* renamed from: com.google.common.collect.c$b */
    /* loaded from: classes3.dex */
    public class b extends AbstractC0818c<K, V>.a implements Set<Map.Entry<K, V>> {
        public b(AbstractC0818c abstractC0818c) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return y.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return y.b(this);
        }
    }

    @Override // com.google.common.collect.p
    public Map<K, Collection<V>> a() {
        Map<K, Collection<V>> map = this.f24571c;
        if (map == null) {
            Map<K, Collection<V>> c10 = c();
            this.f24571c = c10;
            return c10;
        }
        return map;
    }

    @Override // com.google.common.collect.p
    public boolean b(Object obj, Object obj2) {
        Collection<V> collection = a().get(obj);
        if (collection != null && collection.contains(obj2)) {
            return true;
        }
        return false;
    }

    public abstract Map<K, Collection<V>> c();

    public abstract Collection<Map.Entry<K, V>> d();

    public abstract Set<K> e();

    public boolean equals(Object obj) {
        return q.a(this, obj);
    }

    public Collection<Map.Entry<K, V>> f() {
        Collection<Map.Entry<K, V>> collection = this.f24569a;
        if (collection == null) {
            Collection<Map.Entry<K, V>> d10 = d();
            this.f24569a = d10;
            return d10;
        }
        return collection;
    }

    public abstract Iterator<Map.Entry<K, V>> g();

    public int hashCode() {
        return a().hashCode();
    }

    @Override // com.google.common.collect.p
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.p
    public Set<K> keySet() {
        Set<K> set = this.f24570b;
        if (set == null) {
            Set<K> e10 = e();
            this.f24570b = e10;
            return e10;
        }
        return set;
    }

    @Override // com.google.common.collect.p
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = a().get(obj);
        if (collection != null && collection.remove(obj2)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return a().toString();
    }
}
