package com.google.common.collect;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final ReverseNaturalOrdering f24551a = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return f24551a;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> e() {
        return Ordering.c();
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        com.google.common.base.k.o(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
