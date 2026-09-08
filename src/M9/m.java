package m9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.C1229j;
import w9.InterfaceC1658a;

/* compiled from: ULongArray.kt */
/* loaded from: classes4.dex */
public final class m implements Collection<l>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f35502a;

    /* compiled from: ULongArray.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<l>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f35503a;

        /* renamed from: b, reason: collision with root package name */
        public int f35504b;

        public a(long[] array) {
            kotlin.jvm.internal.i.f(array, "array");
            this.f35503a = array;
        }

        public long a() {
            int i10 = this.f35504b;
            long[] jArr = this.f35503a;
            if (i10 < jArr.length) {
                this.f35504b = i10 + 1;
                return l.b(jArr[i10]);
            }
            throw new NoSuchElementException(String.valueOf(this.f35504b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35504b < this.f35503a.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ l next() {
            return l.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static boolean c(long[] jArr, long j10) {
        boolean s10;
        s10 = C1229j.s(jArr, j10);
        return s10;
    }

    public static boolean e(long[] jArr, Collection<l> elements) {
        boolean s10;
        kotlin.jvm.internal.i.f(elements, "elements");
        Collection<l> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof l) {
                s10 = C1229j.s(jArr, ((l) obj).f());
                if (s10) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean g(long[] jArr, Object obj) {
        if (!(obj instanceof m) || !kotlin.jvm.internal.i.b(jArr, ((m) obj).n())) {
            return false;
        }
        return true;
    }

    public static int i(long[] jArr) {
        return jArr.length;
    }

    public static int j(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean k(long[] jArr) {
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator<l> l(long[] jArr) {
        return new a(jArr);
    }

    public static String m(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public boolean a(long j10) {
        return c(this.f35502a, j10);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(l lVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends l> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        return a(((l) obj).f());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        return e(this.f35502a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return g(this.f35502a, obj);
    }

    @Override // java.util.Collection
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int size() {
        return i(this.f35502a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return j(this.f35502a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return k(this.f35502a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<l> iterator() {
        return l(this.f35502a);
    }

    public final /* synthetic */ long[] n() {
        return this.f35502a;
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
        return m(this.f35502a);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        return (T[]) kotlin.jvm.internal.e.b(this, array);
    }
}
