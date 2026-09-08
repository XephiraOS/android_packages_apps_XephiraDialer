package p;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.C1228i;
import kotlin.collections.CollectionsKt___CollectionsKt;
import q.C1474a;
import w9.InterfaceC1659b;

/* compiled from: ArraySet.jvm.kt */
/* renamed from: p.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1416b<E> implements Collection<E>, Set<E>, InterfaceC1659b {

    /* renamed from: a, reason: collision with root package name */
    public int[] f35948a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f35949b;

    /* renamed from: c, reason: collision with root package name */
    public int f35950c;

    /* compiled from: ArraySet.jvm.kt */
    /* renamed from: p.b$a */
    /* loaded from: classes.dex */
    public final class a extends AbstractC1419e<E> {
        public a() {
            super(C1416b.this.h());
        }

        @Override // p.AbstractC1419e
        public E a(int i10) {
            return C1416b.this.m(i10);
        }

        @Override // p.AbstractC1419e
        public void b(int i10) {
            C1416b.this.i(i10);
        }
    }

    public C1416b() {
        this(0, 1, null);
    }

    public final void a(int i10) {
        int h10 = h();
        if (e().length < i10) {
            int[] e10 = e();
            Object[] c10 = c();
            C1418d.a(this, i10);
            if (h() > 0) {
                C1228i.l(e10, e(), 0, 0, h(), 6, null);
                C1228i.m(c10, c(), 0, 0, h(), 6, null);
            }
        }
        if (h() == h10) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e10) {
        int i10;
        int c10;
        int h10 = h();
        boolean z10 = false;
        if (e10 == null) {
            c10 = C1418d.d(this);
            i10 = 0;
        } else {
            int hashCode = e10.hashCode();
            i10 = hashCode;
            c10 = C1418d.c(this, e10, hashCode);
        }
        if (c10 >= 0) {
            return false;
        }
        int i11 = ~c10;
        if (h10 >= e().length) {
            int i12 = 8;
            if (h10 >= 8) {
                i12 = (h10 >> 1) + h10;
            } else if (h10 < 4) {
                i12 = 4;
            }
            int[] e11 = e();
            Object[] c11 = c();
            C1418d.a(this, i12);
            if (h10 == h()) {
                if (e().length == 0) {
                    z10 = true;
                }
                if (!z10) {
                    C1228i.l(e11, e(), 0, 0, e11.length, 6, null);
                    C1228i.m(c11, c(), 0, 0, c11.length, 6, null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i11 < h10) {
            int i13 = i11 + 1;
            C1228i.h(e(), e(), i13, i11, h10);
            C1228i.j(c(), c(), i13, i11, h10);
        }
        if (h10 == h() && i11 < e().length) {
            e()[i11] = i10;
            c()[i11] = e10;
            l(h() + 1);
            return true;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        a(h() + elements.size());
        Iterator<? extends E> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= add(it.next());
        }
        return z10;
    }

    public final Object[] c() {
        return this.f35949b;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (h() != 0) {
            k(C1474a.f36116a);
            j(C1474a.f36118c);
            l(0);
        }
        if (h() == 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int[] e() {
        return this.f35948a;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int h10 = h();
                for (int i10 = 0; i10 < h10; i10++) {
                    if (((Set) obj).contains(m(i10))) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int g() {
        return this.f35950c;
    }

    public final int h() {
        return this.f35950c;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] e10 = e();
        int h10 = h();
        int i10 = 0;
        for (int i11 = 0; i11 < h10; i11++) {
            i10 += e10[i11];
        }
        return i10;
    }

    public final E i(int i10) {
        int h10 = h();
        E e10 = (E) c()[i10];
        if (h10 <= 1) {
            clear();
        } else {
            int i11 = h10 - 1;
            int i12 = 8;
            if (e().length > 8 && h() < e().length / 3) {
                if (h() > 8) {
                    i12 = h() + (h() >> 1);
                }
                int[] e11 = e();
                Object[] c10 = c();
                C1418d.a(this, i12);
                if (i10 > 0) {
                    C1228i.l(e11, e(), 0, 0, i10, 6, null);
                    C1228i.m(c10, c(), 0, 0, i10, 6, null);
                }
                if (i10 < i11) {
                    int i13 = i10 + 1;
                    C1228i.h(e11, e(), i10, i13, h10);
                    C1228i.j(c10, c(), i10, i13, h10);
                }
            } else {
                if (i10 < i11) {
                    int i14 = i10 + 1;
                    C1228i.h(e(), e(), i10, i14, h10);
                    C1228i.j(c(), c(), i10, i14, h10);
                }
                c()[i11] = null;
            }
            if (h10 == h()) {
                l(i11);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e10;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return C1418d.d(this);
        }
        return C1418d.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (h() <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    public final void j(Object[] objArr) {
        kotlin.jvm.internal.i.f(objArr, "<set-?>");
        this.f35949b = objArr;
    }

    public final void k(int[] iArr) {
        kotlin.jvm.internal.i.f(iArr, "<set-?>");
        this.f35948a = iArr;
    }

    public final void l(int i10) {
        this.f35950c = i10;
    }

    public final E m(int i10) {
        return (E) c()[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            i(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= remove(it.next());
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        boolean u10;
        kotlin.jvm.internal.i.f(elements, "elements");
        boolean z10 = false;
        for (int h10 = h() - 1; -1 < h10; h10--) {
            u10 = CollectionsKt___CollectionsKt.u(elements, c()[h10]);
            if (!u10) {
                i(h10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] o10;
        o10 = C1228i.o(this.f35949b, 0, this.f35950c);
        return o10;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(h() * 14);
        sb.append('{');
        int h10 = h();
        for (int i10 = 0; i10 < h10; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            E m10 = m(i10);
            if (m10 != this) {
                sb.append(m10);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        kotlin.jvm.internal.i.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public C1416b(int i10) {
        this.f35948a = C1474a.f36116a;
        this.f35949b = C1474a.f36118c;
        if (i10 > 0) {
            C1418d.a(this, i10);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        T[] result = (T[]) C1417c.a(array, this.f35950c);
        C1228i.j(this.f35949b, result, 0, 0, this.f35950c);
        kotlin.jvm.internal.i.e(result, "result");
        return result;
    }

    public /* synthetic */ C1416b(int i10, int i11, kotlin.jvm.internal.f fVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
