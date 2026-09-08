package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* compiled from: Platform.java */
/* loaded from: classes3.dex */
public final class v {
    public static <T> T[] a(Object[] objArr, int i10, int i11, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i10, i11, tArr.getClass());
    }

    public static <T> T[] b(T[] tArr, int i10) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i10);
    }

    public static <K, V> Map<K, V> c(int i10) {
        return CompactHashMap.w(i10);
    }

    public static <E> Set<E> d(int i10) {
        return CompactHashSet.i(i10);
    }

    public static <K, V> Map<K, V> e(int i10) {
        return CompactLinkedHashMap.X(i10);
    }

    public static <E> Set<E> f(int i10) {
        return CompactLinkedHashSet.B(i10);
    }

    public static o g(o oVar) {
        return oVar.l();
    }
}
