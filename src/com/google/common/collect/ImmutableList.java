package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public static final D<Object> f24421b = new b(RegularImmutableList.f24531d, 0);

    /* loaded from: classes3.dex */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* renamed from: c, reason: collision with root package name */
        public final transient ImmutableList<E> f24422c;

        public ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f24422c = immutableList;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f24422c.contains(obj);
        }

        @Override // java.util.List
        public E get(int i10) {
            com.google.common.base.k.m(i10, size());
            return this.f24422c.get(x(i10));
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean i() {
            return this.f24422c.i();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int lastIndexOf = this.f24422c.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return x(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int indexOf = this.f24422c.indexOf(obj);
            if (indexOf >= 0) {
                return x(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f24422c.size();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> u() {
            return this.f24422c;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public ImmutableList<E> subList(int i10, int i11) {
            com.google.common.base.k.t(i10, i11, size());
            return this.f24422c.subList(y(i11), y(i10)).u();
        }

        public final int x(int i10) {
            return (size() - 1) - i10;
        }

        public final int y(int i10) {
            return size() - i10;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableList.p(this.elements);
        }
    }

    /* loaded from: classes3.dex */
    public class SubList extends ImmutableList<E> {

        /* renamed from: c, reason: collision with root package name */
        public final transient int f24423c;

        /* renamed from: d, reason: collision with root package name */
        public final transient int f24424d;

        public SubList(int i10, int i11) {
            this.f24423c = i10;
            this.f24424d = i11;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public Object[] e() {
            return ImmutableList.this.e();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int g() {
            return ImmutableList.this.h() + this.f24423c + this.f24424d;
        }

        @Override // java.util.List
        public E get(int i10) {
            com.google.common.base.k.m(i10, this.f24424d);
            return ImmutableList.this.get(i10 + this.f24423c);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int h() {
            return ImmutableList.this.h() + this.f24423c;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean i() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f24424d;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* renamed from: v */
        public ImmutableList<E> subList(int i10, int i11) {
            com.google.common.base.k.t(i10, i11, this.f24424d);
            ImmutableList immutableList = ImmutableList.this;
            int i12 = this.f24423c;
            return immutableList.subList(i10 + i12, i11 + i12);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a<E> extends ImmutableCollection.a<E> {
        public a() {
            this(4);
        }

        public a<E> f(E e10) {
            super.b(e10);
            return this;
        }

        public ImmutableList<E> g() {
            this.f24420c = true;
            return ImmutableList.l(this.f24418a, this.f24419b);
        }

        public a(int i10) {
            super(i10);
        }
    }

    /* loaded from: classes3.dex */
    public static class b<E> extends AbstractC0816a<E> {

        /* renamed from: c, reason: collision with root package name */
        public final ImmutableList<E> f24425c;

        public b(ImmutableList<E> immutableList, int i10) {
            super(immutableList.size(), i10);
            this.f24425c = immutableList;
        }

        @Override // com.google.common.collect.AbstractC0816a
        public E a(int i10) {
            return this.f24425c.get(i10);
        }
    }

    public static <E> ImmutableList<E> k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    public static <E> ImmutableList<E> l(Object[] objArr, int i10) {
        if (i10 == 0) {
            return s();
        }
        return new RegularImmutableList(objArr, i10);
    }

    public static <E> a<E> m() {
        return new a<>();
    }

    public static <E> ImmutableList<E> n(Object... objArr) {
        return k(t.b(objArr));
    }

    public static <E> ImmutableList<E> o(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> a10 = ((ImmutableCollection) collection).a();
            if (a10.i()) {
                return k(a10.toArray());
            }
            return a10;
        }
        return n(collection.toArray());
    }

    public static <E> ImmutableList<E> p(E[] eArr) {
        if (eArr.length == 0) {
            return s();
        }
        return n((Object[]) eArr.clone());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> ImmutableList<E> s() {
        return (ImmutableList<E>) RegularImmutableList.f24531d;
    }

    public static <E> ImmutableList<E> t(E e10) {
        return n(e10);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int c(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return n.a(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return n.b(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: j */
    public C<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return n.d(this, obj);
    }

    @Override // java.util.List
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public D<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public D<E> listIterator(int i10) {
        com.google.common.base.k.r(i10, size());
        if (isEmpty()) {
            return (D<E>) f24421b;
        }
        return new b(this, i10);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> u() {
        if (size() > 1) {
            return new ReverseImmutableList(this);
        }
        return this;
    }

    @Override // java.util.List
    /* renamed from: v */
    public ImmutableList<E> subList(int i10, int i11) {
        com.google.common.base.k.t(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return s();
        }
        return w(i10, i11);
    }

    public ImmutableList<E> w(int i10, int i11) {
        return new SubList(i10, i11 - i10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    @Override // com.google.common.collect.ImmutableCollection
    @Deprecated
    public final ImmutableList<E> a() {
        return this;
    }
}
