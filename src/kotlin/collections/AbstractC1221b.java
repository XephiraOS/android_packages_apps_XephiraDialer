package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import w9.InterfaceC1658a;

/* compiled from: AbstractList.kt */
/* renamed from: kotlin.collections.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1221b<E> extends AbstractCollection<E> implements List<E>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f34189a = new a(null);

    /* compiled from: AbstractList.kt */
    /* renamed from: kotlin.collections.b$a */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public final void a(int i10, int i11) {
            if (i10 >= 0 && i10 < i11) {
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
        }

        public final void b(int i10, int i11) {
            if (i10 >= 0 && i10 <= i11) {
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
        }

        public final void c(int i10, int i11, int i12) {
            if (i10 >= 0 && i11 <= i12) {
                if (i10 <= i11) {
                    return;
                }
                throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
            }
            throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
        }

        public final int d(int i10, int i11) {
            int i12 = i10 + (i10 >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            int i13 = 2147483639;
            if (i12 - 2147483639 > 0) {
                if (i11 > 2147483639) {
                    i13 = Integer.MAX_VALUE;
                }
                return i13;
            }
            return i12;
        }

        public final boolean e(Collection<?> c10, Collection<?> other) {
            kotlin.jvm.internal.i.f(c10, "c");
            kotlin.jvm.internal.i.f(other, "other");
            if (c10.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c10.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.i.b(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection<?> c10) {
            int i10;
            kotlin.jvm.internal.i.f(c10, "c");
            int i11 = 1;
            for (Object obj : c10) {
                int i12 = i11 * 31;
                if (obj != null) {
                    i10 = obj.hashCode();
                } else {
                    i10 = 0;
                }
                i11 = i12 + i10;
            }
            return i11;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: kotlin.collections.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0325b implements Iterator<E>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public int f34190a;

        public C0325b() {
        }

        public final int a() {
            return this.f34190a;
        }

        public final void b(int i10) {
            this.f34190a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34190a < AbstractC1221b.this.size()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                AbstractC1221b<E> abstractC1221b = AbstractC1221b.this;
                int i10 = this.f34190a;
                this.f34190a = i10 + 1;
                return abstractC1221b.get(i10);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: kotlin.collections.b$c */
    /* loaded from: classes4.dex */
    public class c extends AbstractC1221b<E>.C0325b implements ListIterator<E>, InterfaceC1658a {
        public c(int i10) {
            super();
            AbstractC1221b.f34189a.b(i10, AbstractC1221b.this.size());
            b(i10);
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (a() > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                AbstractC1221b<E> abstractC1221b = AbstractC1221b.this;
                b(a() - 1);
                return abstractC1221b.get(a());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    /* renamed from: kotlin.collections.b$d */
    /* loaded from: classes4.dex */
    public static final class d<E> extends AbstractC1221b<E> implements RandomAccess {

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC1221b<E> f34193b;

        /* renamed from: c, reason: collision with root package name */
        public final int f34194c;

        /* renamed from: d, reason: collision with root package name */
        public int f34195d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(AbstractC1221b<? extends E> list, int i10, int i11) {
            kotlin.jvm.internal.i.f(list, "list");
            this.f34193b = list;
            this.f34194c = i10;
            AbstractC1221b.f34189a.c(i10, i11, list.size());
            this.f34195d = i11 - i10;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.f34195d;
        }

        @Override // kotlin.collections.AbstractC1221b, java.util.List
        public E get(int i10) {
            AbstractC1221b.f34189a.a(i10, this.f34195d);
            return this.f34193b.get(this.f34194c + i10);
        }
    }

    @Override // java.util.List
    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return f34189a.e(this, (Collection) obj);
    }

    public abstract E get(int i10);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f34189a.f(this);
    }

    public int indexOf(E e10) {
        Iterator<E> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (!kotlin.jvm.internal.i.b(it.next(), e10)) {
                i10++;
            } else {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new C0325b();
    }

    public int lastIndexOf(E e10) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.i.b(listIterator.previous(), e10)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new c(i10);
    }
}
