package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: SortedIterables.java */
/* loaded from: classes3.dex */
public final class A {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            return Ordering.c();
        }
        return comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        com.google.common.base.k.o(comparator);
        com.google.common.base.k.o(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (iterable instanceof z) {
            comparator2 = ((z) iterable).comparator();
        } else {
            return false;
        }
        return comparator.equals(comparator2);
    }
}
