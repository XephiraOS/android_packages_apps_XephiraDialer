package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final RegularImmutableSortedSet<Comparable> f24550e = new RegularImmutableSortedSet<>(ImmutableList.s(), Ordering.c());
    final transient ImmutableList<E> elements;

    public RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.elements = immutableList;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> C(E e10, boolean z10, E e11, boolean z11) {
        return F(e10, z10).z(e11, z11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> F(E e10, boolean z10) {
        return I(K(e10, z10), size());
    }

    public RegularImmutableSortedSet<E> I(int i10, int i11) {
        if (i10 == 0 && i11 == size()) {
            return this;
        }
        if (i10 < i11) {
            return new RegularImmutableSortedSet<>(this.elements.subList(i10, i11), this.f24448c);
        }
        return ImmutableSortedSet.w(this.f24448c);
    }

    public int J(E e10, boolean z10) {
        int binarySearch = Collections.binarySearch(this.elements, com.google.common.base.k.o(e10), comparator());
        if (binarySearch >= 0) {
            if (z10) {
                return binarySearch + 1;
            }
            return binarySearch;
        }
        return ~binarySearch;
    }

    public int K(E e10, boolean z10) {
        int binarySearch = Collections.binarySearch(this.elements, com.google.common.base.k.o(e10), comparator());
        if (binarySearch >= 0) {
            if (!z10) {
                return binarySearch + 1;
            }
            return binarySearch;
        }
        return ~binarySearch;
    }

    public final int L(Object obj) {
        return Collections.binarySearch(this.elements, obj, M());
    }

    public Comparator<Object> M() {
        return this.f24448c;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList<E> a() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int c(Object[] objArr, int i10) {
        return this.elements.c(objArr, i10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e10) {
        int K10 = K(e10, true);
        if (K10 == size()) {
            return null;
        }
        return this.elements.get(K10);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (L(obj) < 0) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof r) {
            collection = ((r) collection).d();
        }
        if (A.b(comparator(), collection) && collection.size() > 1) {
            C<E> it = iterator();
            Iterator<?> it2 = collection.iterator();
            if (!it.hasNext()) {
                return false;
            }
            Object next = it2.next();
            E next2 = it.next();
            while (true) {
                try {
                    int G10 = G(next2, next);
                    if (G10 < 0) {
                        if (!it.hasNext()) {
                            return false;
                        }
                        next2 = it.next();
                    } else if (G10 == 0) {
                        if (!it2.hasNext()) {
                            return true;
                        }
                        next = it2.next();
                    } else if (G10 > 0) {
                        break;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
        } else {
            return super.containsAll(collection);
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] e() {
        return this.elements.e();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (A.b(this.f24448c, set)) {
            Iterator<E> it = set.iterator();
            try {
                C<E> it2 = iterator();
                while (it2.hasNext()) {
                    E next = it2.next();
                    E next2 = it.next();
                    if (next2 == null || G(next, next2) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (ClassCastException | NoSuchElementException unused) {
                return false;
            }
        }
        return containsAll(set);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (!isEmpty()) {
            return this.elements.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e10) {
        int J10 = J(e10, true) - 1;
        if (J10 == -1) {
            return null;
        }
        return this.elements.get(J10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int g() {
        return this.elements.g();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int h() {
        return this.elements.h();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e10) {
        int K10 = K(e10, false);
        if (K10 == size()) {
            return null;
        }
        return this.elements.get(K10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean i() {
        return this.elements.i();
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.elements, obj, M());
            if (binarySearch < 0) {
                return -1;
            }
            return binarySearch;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: j */
    public C<E> iterator() {
        return this.elements.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (!isEmpty()) {
            return this.elements.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e10) {
        int J10 = J(e10, false) - 1;
        if (J10 == -1) {
            return null;
        }
        return this.elements.get(J10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> t() {
        Comparator reverseOrder = Collections.reverseOrder(this.f24448c);
        if (isEmpty()) {
            return ImmutableSortedSet.w(reverseOrder);
        }
        return new RegularImmutableSortedSet(this.elements.u(), reverseOrder);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C<E> descendingIterator() {
        return this.elements.u().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> z(E e10, boolean z10) {
        return I(0, J(e10, z10));
    }
}
