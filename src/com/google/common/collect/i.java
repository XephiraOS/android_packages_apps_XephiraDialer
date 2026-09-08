package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

/* compiled from: ForwardingConcurrentMap.java */
/* loaded from: classes3.dex */
public abstract class i<K, V> extends j<K, V> implements ConcurrentMap<K, V> {
    public abstract ConcurrentMap<K, V> f();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k10, V v10) {
        return f().putIfAbsent(k10, v10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return f().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k10, V v10) {
        return f().replace(k10, v10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k10, V v10, V v11) {
        return f().replace(k10, v10, v11);
    }
}
