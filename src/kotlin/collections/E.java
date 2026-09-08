package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* compiled from: Maps.kt */
/* loaded from: classes4.dex */
public class E extends D {
    public static <K, V> Map<K, V> d() {
        EmptyMap emptyMap = EmptyMap.f34171a;
        kotlin.jvm.internal.i.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static <K, V> HashMap<K, V> e(Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.i.f(pairs, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(B.a(pairs.length));
        i(hashMap, pairs);
        return hashMap;
    }

    public static <K, V> Map<K, V> f(Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.i.f(pairs, "pairs");
        if (pairs.length > 0) {
            return m(pairs, new LinkedHashMap(B.a(pairs.length)));
        }
        return B.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> g(Map<K, ? extends V> map) {
        kotlin.jvm.internal.i.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            if (size == 1) {
                return D.c(map);
            }
            return map;
        }
        return B.d();
    }

    public static <K, V> void h(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.i.f(map, "<this>");
        kotlin.jvm.internal.i.f(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.a(), pair.b());
        }
    }

    public static final <K, V> void i(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.i.f(map, "<this>");
        kotlin.jvm.internal.i.f(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.a(), pair.b());
        }
    }

    public static <K, V> Map<K, V> j(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Pair<? extends K, ? extends V> next;
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return k(iterable, new LinkedHashMap(B.a(collection.size())));
                }
                if (iterable instanceof List) {
                    next = (Pair<? extends K, ? extends V>) ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return B.b(next);
            }
            return B.d();
        }
        return g(k(iterable, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M k(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M destination) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        kotlin.jvm.internal.i.f(destination, "destination");
        B.h(destination, iterable);
        return destination;
    }

    public static <K, V> Map<K, V> l(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.i.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            if (size != 1) {
                return n(map);
            }
            return D.c(map);
        }
        return B.d();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M m(Pair<? extends K, ? extends V>[] pairArr, M destination) {
        kotlin.jvm.internal.i.f(pairArr, "<this>");
        kotlin.jvm.internal.i.f(destination, "destination");
        i(destination, pairArr);
        return destination;
    }

    public static final <K, V> Map<K, V> n(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.i.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
