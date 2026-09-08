package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes3.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {

    /* renamed from: b, reason: collision with root package name */
    @RetainedWith
    public transient ImmutableList<E> f24438b;

    /* loaded from: classes3.dex */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.m(this.elements);
        }
    }

    /* loaded from: classes3.dex */
    public static class a<E> extends ImmutableCollection.a<E> {

        /* renamed from: d, reason: collision with root package name */
        public int f24439d;
        Object[] hashTable;

        public a() {
            super(4);
        }

        public a<E> f(E e10) {
            com.google.common.base.k.o(e10);
            if (this.hashTable != null && ImmutableSet.chooseTableSize(this.f24419b) <= this.hashTable.length) {
                h(e10);
                return this;
            }
            this.hashTable = null;
            super.b(e10);
            return this;
        }

        public a<E> g(E... eArr) {
            if (this.hashTable != null) {
                for (E e10 : eArr) {
                    f(e10);
                }
            } else {
                super.c(eArr);
            }
            return this;
        }

        public final void h(E e10) {
            Objects.requireNonNull(this.hashTable);
            int length = this.hashTable.length - 1;
            int hashCode = e10.hashCode();
            int c10 = l.c(hashCode);
            while (true) {
                int i10 = c10 & length;
                Object[] objArr = this.hashTable;
                Object obj = objArr[i10];
                if (obj == null) {
                    objArr[i10] = e10;
                    this.f24439d += hashCode;
                    super.b(e10);
                    return;
                } else if (obj.equals(e10)) {
                    return;
                } else {
                    c10 = i10 + 1;
                }
            }
        }
    }

    public static int chooseTableSize(int i10) {
        int max = Math.max(i10, 2);
        boolean z10 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> k(int i10, Object... objArr) {
        if (i10 != 0) {
            if (i10 != 1) {
                int chooseTableSize = chooseTableSize(i10);
                Object[] objArr2 = new Object[chooseTableSize];
                int i11 = chooseTableSize - 1;
                int i12 = 0;
                int i13 = 0;
                for (int i14 = 0; i14 < i10; i14++) {
                    Object a10 = t.a(objArr[i14], i14);
                    int hashCode = a10.hashCode();
                    int c10 = l.c(hashCode);
                    while (true) {
                        int i15 = c10 & i11;
                        Object obj = objArr2[i15];
                        if (obj == null) {
                            objArr[i13] = a10;
                            objArr2[i15] = a10;
                            i12 += hashCode;
                            i13++;
                            break;
                        }
                        if (obj.equals(a10)) {
                            break;
                        }
                        c10++;
                    }
                }
                Arrays.fill(objArr, i13, i10, (Object) null);
                if (i13 == 1) {
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    return new SingletonImmutableSet(obj2);
                }
                if (chooseTableSize(i13) < chooseTableSize / 2) {
                    return k(i13, objArr);
                }
                if (r(i13, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i13);
                }
                return new RegularImmutableSet(objArr, i12, objArr2, i11, i13);
            }
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return q(obj3);
        }
        return p();
    }

    public static <E> ImmutableSet<E> l(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.i()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return k(array.length, array);
    }

    public static <E> ImmutableSet<E> m(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            if (length != 1) {
                return k(eArr.length, (Object[]) eArr.clone());
            }
            return q(eArr[0]);
        }
        return p();
    }

    public static <E> ImmutableSet<E> p() {
        return RegularImmutableSet.f24546g;
    }

    public static <E> ImmutableSet<E> q(E e10) {
        return new SingletonImmutableSet(e10);
    }

    public static boolean r(int i10, int i11) {
        if (i10 < (i11 >> 1) + (i11 >> 2)) {
            return true;
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> a() {
        ImmutableList<E> immutableList = this.f24438b;
        if (immutableList == null) {
            ImmutableList<E> n10 = n();
            this.f24438b = n10;
            return n10;
        }
        return immutableList;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && o() && ((ImmutableSet) obj).o() && hashCode() != obj.hashCode()) {
            return false;
        }
        return y.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return y.b(this);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: j */
    public abstract C<E> iterator();

    public ImmutableList<E> n() {
        return ImmutableList.k(toArray());
    }

    public boolean o() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
