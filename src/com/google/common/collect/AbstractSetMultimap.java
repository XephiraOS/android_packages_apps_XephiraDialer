package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements x<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public Map<K, Collection<V>> a() {
        return super.a();
    }

    @Override // com.google.common.collect.AbstractC0818c
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.p
    public boolean put(K k10, V v10) {
        return super.put(k10, v10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> t(K k10, Collection<V> collection) {
        return new AbstractMapBasedMultimap.f(k10, (Set) collection);
    }

    public Set<Map.Entry<K, V>> u() {
        return (Set) super.f();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.p
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Set<V> get(K k10) {
        return (Set) super.get(k10);
    }
}
