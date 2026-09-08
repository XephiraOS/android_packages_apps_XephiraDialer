package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes3.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Object[] f24417a = new Object[0];

    /* loaded from: classes3.dex */
    public static abstract class a<E> extends b<E> {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f24418a;

        /* renamed from: b, reason: collision with root package name */
        public int f24419b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f24420c;

        public a(int i10) {
            f.b(i10, "initialCapacity");
            this.f24418a = new Object[i10];
            this.f24419b = 0;
        }

        public a<E> b(E e10) {
            com.google.common.base.k.o(e10);
            e(this.f24419b + 1);
            Object[] objArr = this.f24418a;
            int i10 = this.f24419b;
            this.f24419b = i10 + 1;
            objArr[i10] = e10;
            return this;
        }

        public b<E> c(E... eArr) {
            d(eArr, eArr.length);
            return this;
        }

        public final void d(Object[] objArr, int i10) {
            t.c(objArr, i10);
            e(this.f24419b + i10);
            System.arraycopy(objArr, 0, this.f24418a, this.f24419b, i10);
            this.f24419b += i10;
        }

        public final void e(int i10) {
            Object[] objArr = this.f24418a;
            if (objArr.length < i10) {
                this.f24418a = Arrays.copyOf(objArr, b.a(objArr.length, i10));
                this.f24420c = false;
            } else if (this.f24420c) {
                this.f24418a = (Object[]) objArr.clone();
                this.f24420c = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b<E> {
        public static int a(int i10, int i11) {
            if (i11 >= 0) {
                int i12 = i10 + (i10 >> 1) + 1;
                if (i12 < i11) {
                    i12 = Integer.highestOneBit(i11 - 1) << 1;
                }
                if (i12 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i12;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public ImmutableList<E> a() {
        if (isEmpty()) {
            return ImmutableList.s();
        }
        return ImmutableList.k(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public int c(Object[] objArr, int i10) {
        C<E> it = iterator();
        while (it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    public Object[] e() {
        return null;
    }

    public int g() {
        throw new UnsupportedOperationException();
    }

    public int h() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean i();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public abstract C<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f24417a);
    }

    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.k.o(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] e10 = e();
            if (e10 != null) {
                return (T[]) v.a(e10, h(), g(), tArr);
            }
            tArr = (T[]) t.e(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        c(tArr, 0);
        return tArr;
    }
}
