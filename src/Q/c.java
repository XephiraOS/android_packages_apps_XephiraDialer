package q;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.i;

/* compiled from: LruHashMap.jvm.kt */
/* loaded from: classes.dex */
public final class c<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<K, V> f36119a;

    public c(int i10, float f10) {
        this.f36119a = new LinkedHashMap<>(i10, f10, true);
    }

    public final V a(K key) {
        i.f(key, "key");
        return this.f36119a.get(key);
    }

    public final Set<Map.Entry<K, V>> b() {
        Set<Map.Entry<K, V>> entrySet = this.f36119a.entrySet();
        i.e(entrySet, "map.entries");
        return entrySet;
    }

    public final boolean c() {
        return this.f36119a.isEmpty();
    }

    public final V d(K key, V value) {
        i.f(key, "key");
        i.f(value, "value");
        return this.f36119a.put(key, value);
    }

    public final V e(K key) {
        i.f(key, "key");
        return this.f36119a.remove(key);
    }
}
