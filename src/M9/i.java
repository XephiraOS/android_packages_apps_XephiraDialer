package m9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.C1229j;
import w9.InterfaceC1658a;

/* compiled from: UByteArray.kt */
/* loaded from: classes4.dex */
public final class i implements Collection<h>, InterfaceC1658a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f35492a;

    /* compiled from: UByteArray.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterator<h>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f35493a;

        /* renamed from: b, reason: collision with root package name */
        public int f35494b;

        public a(byte[] array) {
            kotlin.jvm.internal.i.f(array, "array");
            this.f35493a = array;
        }

        public byte a() {
            int i10 = this.f35494b;
            byte[] bArr = this.f35493a;
            if (i10 < bArr.length) {
                this.f35494b = i10 + 1;
                return h.b(bArr[i10]);
            }
            throw new NoSuchElementException(String.valueOf(this.f35494b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35494b < this.f35493a.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ h next() {
            return h.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static boolean c(byte[] bArr, byte b10) {
        boolean q10;
        q10 = C1229j.q(bArr, b10);
        return q10;
    }

    public static boolean e(byte[] bArr, Collection<h> elements) {
        boolean q10;
        kotlin.jvm.internal.i.f(elements, "elements");
        Collection<h> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (obj instanceof h) {
                q10 = C1229j.q(bArr, ((h) obj).f());
                if (q10) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean g(byte[] bArr, Object obj) {
        if (!(obj instanceof i) || !kotlin.jvm.internal.i.b(bArr, ((i) obj).n())) {
            return false;
        }
        return true;
    }

    public static int i(byte[] bArr) {
        return bArr.length;
    }

    public static int j(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean k(byte[] bArr) {
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    public static Iterator<h> l(byte[] bArr) {
        return new a(bArr);
    }

    public static String m(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public boolean a(byte b10) {
        return c(this.f35492a, b10);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(h hVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends h> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        return a(((h) obj).f());
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        return e(this.f35492a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return g(this.f35492a, obj);
    }

    @Override // java.util.Collection
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int size() {
        return i(this.f35492a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return j(this.f35492a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return k(this.f35492a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<h> iterator() {
        return l(this.f35492a);
    }

    public final /* synthetic */ byte[] n() {
        return this.f35492a;
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
        return m(this.f35492a);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        return (T[]) kotlin.jvm.internal.e.b(this, array);
    }
}
