package m9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.C1229j;
import w9.InterfaceC1658a;

/* compiled from: UIntArray.kt */
/* loaded from: classes4.dex */
public final class k implements Collection<j>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f35497a;

    /* compiled from: UIntArray.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<j>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f35498a;

        /* renamed from: b, reason: collision with root package name */
        public int f35499b;

        public a(int[] array) {
            kotlin.jvm.internal.i.f(array, "array");
            this.f35498a = array;
        }

        public int a() {
            int i10 = this.f35499b;
            int[] iArr = this.f35498a;
            if (i10 < iArr.length) {
                this.f35499b = i10 + 1;
                return j.b(iArr[i10]);
            }
            throw new NoSuchElementException(String.valueOf(this.f35499b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35499b < this.f35498a.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ j next() {
            return j.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static boolean c(int[] iArr, int i10) {
        boolean r10;
        r10 = C1229j.r(iArr, i10);
        return r10;
    }

    public static boolean e(int[] iArr, Collection<j> elements) {
        boolean r10;
        kotlin.jvm.internal.i.f(elements, "elements");
        Collection<j> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof j) {
                r10 = C1229j.r(iArr, ((j) obj).f());
                if (r10) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean g(int[] iArr, Object obj) {
        if (!(obj instanceof k) || !kotlin.jvm.internal.i.b(iArr, ((k) obj).n())) {
            return false;
        }
        return true;
    }

    public static int i(int[] iArr) {
        return iArr.length;
    }

    public static int j(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean k(int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator<j> l(int[] iArr) {
        return new a(iArr);
    }

    public static String m(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public boolean a(int i10) {
        return c(this.f35497a, i10);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(j jVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends j> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        return a(((j) obj).f());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        return e(this.f35497a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return g(this.f35497a, obj);
    }

    @Override // java.util.Collection
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int size() {
        return i(this.f35497a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return j(this.f35497a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return k(this.f35497a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<j> iterator() {
        return l(this.f35497a);
    }

    public final /* synthetic */ int[] n() {
        return this.f35497a;
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
        return m(this.f35497a);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        return (T[]) kotlin.jvm.internal.e.b(this, array);
    }
}
