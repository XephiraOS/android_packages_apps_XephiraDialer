package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Map;

/* compiled from: Multimaps.java */
/* loaded from: classes3.dex */
public final class q {

    /* compiled from: Multimaps.java */
    /* loaded from: classes3.dex */
    public static abstract class a<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract p<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return a().b(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return a().remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    public static boolean a(p<?, ?> pVar, Object obj) {
        if (obj == pVar) {
            return true;
        }
        if (obj instanceof p) {
            return pVar.a().equals(((p) obj).a());
        }
        return false;
    }
}
