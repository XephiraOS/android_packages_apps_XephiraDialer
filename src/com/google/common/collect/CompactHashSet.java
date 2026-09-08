package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* renamed from: a, reason: collision with root package name */
    public transient Object f24401a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f24402b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f24403c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f24404d;
    transient Object[] elements;

    /* loaded from: classes3.dex */
    public class a implements Iterator<E> {

        /* renamed from: a, reason: collision with root package name */
        public int f24405a;

        /* renamed from: b, reason: collision with root package name */
        public int f24406b;

        /* renamed from: c, reason: collision with root package name */
        public int f24407c = -1;

        public a() {
            this.f24405a = CompactHashSet.this.f24403c;
            this.f24406b = CompactHashSet.this.l();
        }

        public final void a() {
            if (CompactHashSet.this.f24403c == this.f24405a) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public void b() {
            this.f24405a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f24406b >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (hasNext()) {
                int i10 = this.f24406b;
                this.f24407c = i10;
                E e10 = (E) CompactHashSet.this.j(i10);
                this.f24406b = CompactHashSet.this.m(this.f24406b);
                return e10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z10;
            a();
            if (this.f24407c >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            f.c(z10);
            b();
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.remove(compactHashSet.j(this.f24407c));
            this.f24406b = CompactHashSet.this.e(this.f24406b, this.f24407c);
            this.f24407c = -1;
        }
    }

    public CompactHashSet(int i10) {
        p(i10);
    }

    public static <E> CompactHashSet<E> i(int i10) {
        return new CompactHashSet<>(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            p(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    public final void A(int i10) {
        this.f24403c = h.d(this.f24403c, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        if (needsAllocArrays()) {
            g();
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.add(e10);
        }
        int[] t10 = t();
        Object[] s10 = s();
        int i10 = this.f24404d;
        int i11 = i10 + 1;
        int d10 = l.d(e10);
        int n10 = n();
        int i12 = d10 & n10;
        int h10 = h.h(u(), i12);
        if (h10 == 0) {
            if (i11 > n10) {
                n10 = x(n10, h.e(n10), d10, i10);
            } else {
                h.i(u(), i12, i11);
            }
        } else {
            int b10 = h.b(d10, n10);
            int i13 = 0;
            while (true) {
                int i14 = h10 - 1;
                int i15 = t10[i14];
                if (h.b(i15, n10) == b10 && com.google.common.base.h.a(e10, s10[i14])) {
                    return false;
                }
                int c10 = h.c(i15, n10);
                i13++;
                if (c10 == 0) {
                    if (i13 >= 9) {
                        return convertToHashFloodingResistantImplementation().add(e10);
                    }
                    if (i11 > n10) {
                        n10 = x(n10, h.e(n10), d10, i10);
                    } else {
                        t10[i14] = h.d(i15, i11, n10);
                    }
                } else {
                    h10 = c10;
                }
            }
        }
        w(i11);
        q(i10, e10, d10, n10);
        this.f24404d = i11;
        o();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        o();
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.f24403c = com.google.common.primitives.b.a(size(), 3, 1073741823);
            delegateOrNull.clear();
            this.f24401a = null;
            this.f24404d = 0;
            return;
        }
        Arrays.fill(s(), 0, this.f24404d, (Object) null);
        h.g(u());
        Arrays.fill(t(), 0, this.f24404d, 0);
        this.f24404d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.contains(obj);
        }
        int d10 = l.d(obj);
        int n10 = n();
        int h10 = h.h(u(), d10 & n10);
        if (h10 == 0) {
            return false;
        }
        int b10 = h.b(d10, n10);
        do {
            int i10 = h10 - 1;
            int k10 = k(i10);
            if (h.b(k10, n10) == b10 && com.google.common.base.h.a(obj, j(i10))) {
                return true;
            }
            h10 = h.c(k10, n10);
        } while (h10 != 0);
        return false;
    }

    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> h10 = h(n() + 1);
        int l10 = l();
        while (l10 >= 0) {
            h10.add(j(l10));
            l10 = m(l10);
        }
        this.f24401a = h10;
        this.f24402b = null;
        this.elements = null;
        o();
        return h10;
    }

    public Set<E> delegateOrNull() {
        Object obj = this.f24401a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public int e(int i10, int i11) {
        return i10 - 1;
    }

    public int g() {
        com.google.common.base.k.v(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.f24403c;
        int j10 = h.j(i10);
        this.f24401a = h.a(j10);
        A(j10 - 1);
        this.f24402b = new int[i10];
        this.elements = new Object[i10];
        return i10;
    }

    public final Set<E> h(int i10) {
        return new LinkedHashSet(i10, 1.0f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isUsingHashFloodingResistance() {
        if (delegateOrNull() != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.iterator();
        }
        return new a();
    }

    public final E j(int i10) {
        return (E) s()[i10];
    }

    public final int k(int i10) {
        return t()[i10];
    }

    public int l() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    public int m(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.f24404d) {
            return -1;
        }
        return i11;
    }

    public final int n() {
        return (1 << (this.f24403c & 31)) - 1;
    }

    public boolean needsAllocArrays() {
        if (this.f24401a == null) {
            return true;
        }
        return false;
    }

    public void o() {
        this.f24403c += 32;
    }

    public void p(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "Expected size must be >= 0");
        this.f24403c = com.google.common.primitives.b.a(i10, 1, 1073741823);
    }

    public void q(int i10, E e10, int i11, int i12) {
        z(i10, h.d(i11, 0, i12));
        y(i10, e10);
    }

    public void r(int i10, int i11) {
        Object u10 = u();
        int[] t10 = t();
        Object[] s10 = s();
        int size = size();
        int i12 = size - 1;
        if (i10 < i12) {
            Object obj = s10[i12];
            s10[i10] = obj;
            s10[i12] = null;
            t10[i10] = t10[i12];
            t10[i12] = 0;
            int d10 = l.d(obj) & i11;
            int h10 = h.h(u10, d10);
            if (h10 == size) {
                h.i(u10, d10, i10 + 1);
                return;
            }
            while (true) {
                int i13 = h10 - 1;
                int i14 = t10[i13];
                int c10 = h.c(i14, i11);
                if (c10 == size) {
                    t10[i13] = h.d(i14, i10 + 1, i11);
                    return;
                }
                h10 = c10;
            }
        } else {
            s10[i10] = null;
            t10[i10] = 0;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        int n10 = n();
        int f10 = h.f(obj, null, n10, u(), t(), s(), null);
        if (f10 == -1) {
            return false;
        }
        r(f10, n10);
        this.f24404d--;
        o();
        return true;
    }

    public final Object[] s() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.size();
        }
        return this.f24404d;
    }

    public final int[] t() {
        int[] iArr = this.f24402b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.toArray() : Arrays.copyOf(s(), this.f24404d);
    }

    public final Object u() {
        Object obj = this.f24401a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public void v(int i10) {
        this.f24402b = Arrays.copyOf(t(), i10);
        this.elements = Arrays.copyOf(s(), i10);
    }

    public final void w(int i10) {
        int min;
        int length = t().length;
        if (i10 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            v(min);
        }
    }

    public final int x(int i10, int i11, int i12, int i13) {
        Object a10 = h.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            h.i(a10, i12 & i14, i13 + 1);
        }
        Object u10 = u();
        int[] t10 = t();
        for (int i15 = 0; i15 <= i10; i15++) {
            int h10 = h.h(u10, i15);
            while (h10 != 0) {
                int i16 = h10 - 1;
                int i17 = t10[i16];
                int b10 = h.b(i17, i10) | i15;
                int i18 = b10 & i14;
                int h11 = h.h(a10, i18);
                h.i(a10, i18, h10);
                t10[i16] = h.d(b10, h11, i14);
                h10 = h.c(i17, i10);
            }
        }
        this.f24401a = a10;
        A(i14);
        return i14;
    }

    public final void y(int i10, E e10) {
        s()[i10] = e10;
    }

    public final void z(int i10, int i11) {
        t()[i10] = i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return (T[]) delegateOrNull.toArray(tArr);
        }
        return (T[]) t.h(s(), 0, this.f24404d, tArr);
    }
}
