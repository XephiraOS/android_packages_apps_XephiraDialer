package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: Multimap.java */
/* loaded from: classes3.dex */
public interface p<K, V> {
    Map<K, Collection<V>> a();

    boolean b(Object obj, Object obj2);

    void clear();

    Collection<V> get(K k10);

    boolean isEmpty();

    Set<K> keySet();

    boolean put(K k10, V v10);

    boolean remove(Object obj, Object obj2);

    int size();
}
