package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;

/* compiled from: MapsJVM.kt */
/* loaded from: classes4.dex */
public class D extends C {
    public static int a(int i10) {
        if (i10 >= 0) {
            if (i10 < 3) {
                return i10 + 1;
            }
            if (i10 < 1073741824) {
                return (int) ((i10 / 0.75f) + 1.0f);
            }
            return Integer.MAX_VALUE;
        }
        return i10;
    }

    public static <K, V> Map<K, V> b(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.i.f(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.c(), pair.d());
        kotlin.jvm.internal.i.e(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.i.f(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.i.e(singletonMap, "with(...)");
        return singletonMap;
    }
}
