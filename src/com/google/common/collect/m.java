package com.google.common.collect;

import java.util.Collection;

/* compiled from: Iterables.java */
/* loaded from: classes3.dex */
public final class m {
    public static <E> Collection<E> a(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return n.h(iterable.iterator());
    }

    public static <T> T b(Iterable<? extends T> iterable, T t10) {
        return (T) Iterators.e(iterable.iterator(), t10);
    }

    public static Object[] c(Iterable<?> iterable) {
        return a(iterable).toArray();
    }
}
