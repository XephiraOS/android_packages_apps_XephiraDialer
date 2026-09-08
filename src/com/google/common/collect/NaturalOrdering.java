package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class NaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final NaturalOrdering f24526a = new NaturalOrdering();
    private static final long serialVersionUID = 0;

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return f24526a;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> e() {
        return ReverseNaturalOrdering.f24551a;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        com.google.common.base.k.o(comparable);
        com.google.common.base.k.o(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
