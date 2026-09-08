package com.google.common.collect;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class Ordering<T> implements Comparator<T> {

    /* loaded from: classes3.dex */
    public static class ArbitraryOrdering extends Ordering<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f24527a = new AtomicInteger(0);

        /* renamed from: b, reason: collision with root package name */
        public final ConcurrentMap<Object, Integer> f24528b = v.g(new o()).i();

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int h10 = h(obj);
            int h11 = h(obj2);
            if (h10 != h11) {
                if (h10 < h11) {
                    return -1;
                }
                return 1;
            }
            int compareTo = g(obj).compareTo(g(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        public final Integer g(Object obj) {
            Integer num = this.f24528b.get(obj);
            if (num == null) {
                Integer valueOf = Integer.valueOf(this.f24527a.getAndIncrement());
                Integer putIfAbsent = this.f24528b.putIfAbsent(obj, valueOf);
                if (putIfAbsent != null) {
                    return putIfAbsent;
                }
                return valueOf;
            }
            return num;
        }

        public int h(Object obj) {
            return System.identityHashCode(obj);
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    /* loaded from: classes3.dex */
    public static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;
    }

    public static <T> Ordering<T> b(Comparator<T> comparator) {
        if (comparator instanceof Ordering) {
            return (Ordering) comparator;
        }
        return new ComparatorOrdering(comparator);
    }

    public static <C extends Comparable> Ordering<C> c() {
        return NaturalOrdering.f24526a;
    }

    public <U extends T> Ordering<U> a(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) com.google.common.base.k.o(comparator));
    }

    @Override // java.util.Comparator
    public abstract int compare(T t10, T t11);

    public <F> Ordering<F> d(com.google.common.base.d<F, ? extends T> dVar) {
        return new ByFunctionOrdering(dVar, this);
    }

    public <S extends T> Ordering<S> e() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> f(Iterable<E> iterable) {
        Object[] c10 = m.c(iterable);
        Arrays.sort(c10, this);
        return n.g(Arrays.asList(c10));
    }
}
