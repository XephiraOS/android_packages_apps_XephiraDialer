package com.google.common.collect;

import java.io.Serializable;

/* loaded from: classes3.dex */
class ImmutableEntry<K, V> extends AbstractC0817b<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final K key;
    final V value;

    public ImmutableEntry(K k10, V v10) {
        this.key = k10;
        this.value = v10;
    }

    @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.AbstractC0817b, java.util.Map.Entry
    public final V setValue(V v10) {
        throw new UnsupportedOperationException();
    }
}
