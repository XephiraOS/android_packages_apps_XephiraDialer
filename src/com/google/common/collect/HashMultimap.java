package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey;

    private HashMultimap() {
        this(12, 2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int b10 = w.b(objectInputStream);
        s(v.c(12));
        w.a(this, objectInputStream, b10);
    }

    public static <K, V> HashMultimap<K, V> w() {
        return new HashMultimap<>();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        w.c(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ Map a() {
        return super.a();
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ boolean b(Object obj, Object obj2) {
        return super.b(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.p
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractC0818c
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC0818c
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.p
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC0818c, com.google.common.collect.p
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.p
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractC0818c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap
    /* renamed from: v */
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Set<V> o() {
        return v.d(this.expectedValuesPerKey);
    }

    public HashMultimap(int i10, int i11) {
        super(v.c(i10));
        this.expectedValuesPerKey = 2;
        com.google.common.base.k.d(i11 >= 0);
        this.expectedValuesPerKey = i11;
    }
}
