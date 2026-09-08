package m9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.C1229j;
import w9.InterfaceC1658a;

/* compiled from: UShortArray.kt */
/* loaded from: classes4.dex */
public final class p implements Collection<o>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public final short[] f35508a;

    /* compiled from: UShortArray.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<o>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public final short[] f35509a;

        /* renamed from: b, reason: collision with root package name */
        public int f35510b;

        public a(short[] array) {
            kotlin.jvm.internal.i.f(array, "array");
            this.f35509a = array;
        }

        public short a() {
            int i10 = this.f35510b;
            short[] sArr = this.f35509a;
            if (i10 < sArr.length) {
                this.f35510b = i10 + 1;
                return o.b(sArr[i10]);
            }
            throw new NoSuchElementException(String.valueOf(this.f35510b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35510b < this.f35509a.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ o next() {
            return o.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static boolean c(short[] sArr, short s10) {
        boolean u10;
        u10 = C1229j.u(sArr, s10);
        return u10;
    }

    public static boolean e(short[] sArr, Collection<o> elements) {
        boolean u10;
        kotlin.jvm.internal.i.f(elements, "elements");
        Collection<o> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof o) {
                u10 = C1229j.u(sArr, ((o) obj).f());
                if (u10) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean g(short[] sArr, Object obj) {
        if (!(obj instanceof p) || !kotlin.jvm.internal.i.b(sArr, ((p) obj).n())) {
            return false;
        }
        return true;
    }

    public static int i(short[] sArr) {
        return sArr.length;
    }

    public static int j(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean k(short[] sArr) {
        if (sArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator<o> l(short[] sArr) {
        return new a(sArr);
    }

    public static String m(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public boolean a(short s10) {
        return c(this.f35508a, s10);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(o oVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends o> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        return a(((o) obj).f());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        return e(this.f35508a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return g(this.f35508a, obj);
    }

    @Override // java.util.Collection
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int size() {
        return i(this.f35508a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return j(this.f35508a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return k(this.f35508a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<o> iterator() {
        return l(this.f35508a);
    }

    public final /* synthetic */ short[] n() {
        return this.f35508a;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.e.a(this);
    }

    public String toString() {
        return m(this.f35508a);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        return (T[]) kotlin.jvm.internal.e.b(this, array);
    }
}
