package com.google.common.collect;

import A.e;
import com.google.common.collect.ImmutableSet;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NavigableSet;

/* loaded from: classes3.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, z<E> {

    /* renamed from: c, reason: collision with root package name */
    public final transient Comparator<? super E> f24448c;

    /* renamed from: d, reason: collision with root package name */
    public transient ImmutableSortedSet<E> f24449d;

    /* loaded from: classes3.dex */
    public static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            return new a(this.comparator).j(this.elements).k();
        }
    }

    /* loaded from: classes3.dex */
    public static final class a<E> extends ImmutableSet.a<E> {

        /* renamed from: e, reason: collision with root package name */
        public final Comparator<? super E> f24450e;

        public a(Comparator<? super E> comparator) {
            this.f24450e = (Comparator) com.google.common.base.k.o(comparator);
        }

        @Override // com.google.common.collect.ImmutableSet.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public a<E> f(E e10) {
            super.f(e10);
            return this;
        }

        public a<E> j(E... eArr) {
            super.g(eArr);
            return this;
        }

        public ImmutableSortedSet<E> k() {
            ImmutableSortedSet<E> s10 = ImmutableSortedSet.s(this.f24450e, this.f24419b, this.f24418a);
            this.f24419b = s10.size();
            this.f24420c = true;
            return s10;
        }
    }

    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.f24448c = comparator;
    }

    public static int H(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSortedSet<E> s(Comparator<? super E> comparator, int i10, E... eArr) {
        if (i10 == 0) {
            return w(comparator);
        }
        t.c(eArr, i10);
        Arrays.sort(eArr, 0, i10, comparator);
        int i11 = 1;
        for (int i12 = 1; i12 < i10; i12++) {
            e.C0000e c0000e = (Object) eArr[i12];
            if (comparator.compare(c0000e, (Object) eArr[i11 - 1]) != 0) {
                eArr[i11] = c0000e;
                i11++;
            }
        }
        Arrays.fill(eArr, i11, i10, (Object) null);
        if (i11 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i11);
        }
        return new RegularImmutableSortedSet(ImmutableList.l(eArr, i11), comparator);
    }

    public static <E> RegularImmutableSortedSet<E> w(Comparator<? super E> comparator) {
        if (Ordering.c().equals(comparator)) {
            return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.f24550e;
        }
        return new RegularImmutableSortedSet<>(ImmutableList.s(), comparator);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<E> subSet(E e10, E e11) {
        return subSet(e10, true, e11, false);
    }

    @Override // java.util.NavigableSet
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<E> subSet(E e10, boolean z10, E e11, boolean z11) {
        boolean z12;
        com.google.common.base.k.o(e10);
        com.google.common.base.k.o(e11);
        if (this.f24448c.compare(e10, e11) <= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        com.google.common.base.k.d(z12);
        return C(e10, z10, e11, z11);
    }

    public abstract ImmutableSortedSet<E> C(E e10, boolean z10, E e11, boolean z11);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<E> tailSet(E e10) {
        return tailSet(e10, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<E> tailSet(E e10, boolean z10) {
        return F(com.google.common.base.k.o(e10), z10);
    }

    public abstract ImmutableSortedSet<E> F(E e10, boolean z10);

    public int G(Object obj, Object obj2) {
        return H(this.f24448c, obj, obj2);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e10) {
        return (E) m.b(tailSet(e10, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.z
    public Comparator<? super E> comparator() {
        return this.f24448c;
    }

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    public E floor(E e10) {
        return (E) Iterators.e(headSet(e10, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public E higher(E e10) {
        return (E) m.b(tailSet(e10, false), null);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: j */
    public abstract C<E> iterator();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public E lower(E e10) {
        return (E) Iterators.e(headSet(e10, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableSortedSet<E> t();

    @Override // java.util.NavigableSet
    /* renamed from: u */
    public abstract C<E> descendingIterator();

    @Override // java.util.NavigableSet
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.f24449d;
        if (immutableSortedSet == null) {
            ImmutableSortedSet<E> t10 = t();
            this.f24449d = t10;
            t10.f24449d = this;
            return t10;
        }
        return immutableSortedSet;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.f24448c, toArray());
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<E> headSet(E e10) {
        return headSet(e10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet<E> headSet(E e10, boolean z10) {
        return z(com.google.common.base.k.o(e10), z10);
    }

    public abstract ImmutableSortedSet<E> z(E e10, boolean z10);
}
