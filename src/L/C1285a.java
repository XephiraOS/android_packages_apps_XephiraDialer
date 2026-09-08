package l;

import java.util.HashMap;
import java.util.Map;
import l.C1286b;

/* compiled from: FastSafeIterableMap.java */
/* renamed from: l.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1285a<K, V> extends C1286b<K, V> {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<K, C1286b.c<K, V>> f34654e = new HashMap<>();

    @Override // l.C1286b
    public C1286b.c<K, V> c(K k10) {
        return this.f34654e.get(k10);
    }

    public boolean contains(K k10) {
        return this.f34654e.containsKey(k10);
    }

    @Override // l.C1286b
    public V i(K k10, V v10) {
        C1286b.c<K, V> c10 = c(k10);
        if (c10 != null) {
            return c10.f34660b;
        }
        this.f34654e.put(k10, h(k10, v10));
        return null;
    }

    @Override // l.C1286b
    public V j(K k10) {
        V v10 = (V) super.j(k10);
        this.f34654e.remove(k10);
        return v10;
    }

    public Map.Entry<K, V> k(K k10) {
        if (contains(k10)) {
            return this.f34654e.get(k10).f34662d;
        }
        return null;
    }
}
