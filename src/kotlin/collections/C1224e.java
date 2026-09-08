package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayDeque.kt */
/* renamed from: kotlin.collections.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1224e<E> extends AbstractC1222c<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final a f34198d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final Object[] f34199e = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f34200a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f34201b = f34199e;

    /* renamed from: c, reason: collision with root package name */
    public int f34202c;

    /* compiled from: ArrayDeque.kt */
    /* renamed from: kotlin.collections.e$a */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    private final void i(int i10) {
        int b10;
        if (i10 >= 0) {
            Object[] objArr = this.f34201b;
            if (i10 <= objArr.length) {
                return;
            }
            if (objArr == f34199e) {
                b10 = B9.i.b(i10, 10);
                this.f34201b = new Object[b10];
                return;
            } else {
                g(AbstractC1221b.f34189a.d(objArr.length, i10));
                return;
            }
        }
        throw new IllegalStateException("Deque is too big.");
    }

    @Override // kotlin.collections.AbstractC1222c
    public int a() {
        return this.f34202c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        i(size() + elements.size());
        e(l(this.f34200a + size()), elements);
        return true;
    }

    public final void addFirst(E e10) {
        i(size() + 1);
        int h10 = h(this.f34200a);
        this.f34200a = h10;
        this.f34201b[h10] = e10;
        this.f34202c = size() + 1;
    }

    public final void addLast(E e10) {
        i(size() + 1);
        this.f34201b[l(this.f34200a + size())] = e10;
        this.f34202c = size() + 1;
    }

    @Override // kotlin.collections.AbstractC1222c
    public E c(int i10) {
        int i11;
        int i12;
        AbstractC1221b.f34189a.a(i10, size());
        i11 = o.i(this);
        if (i10 == i11) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        int l10 = l(this.f34200a + i10);
        E e10 = (E) this.f34201b[l10];
        if (i10 < (size() >> 1)) {
            int i13 = this.f34200a;
            if (l10 >= i13) {
                Object[] objArr = this.f34201b;
                C1228i.j(objArr, objArr, i13 + 1, i13, l10);
            } else {
                Object[] objArr2 = this.f34201b;
                C1228i.j(objArr2, objArr2, 1, 0, l10);
                Object[] objArr3 = this.f34201b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i14 = this.f34200a;
                C1228i.j(objArr3, objArr3, i14 + 1, i14, objArr3.length - 1);
            }
            Object[] objArr4 = this.f34201b;
            int i15 = this.f34200a;
            objArr4[i15] = null;
            this.f34200a = j(i15);
        } else {
            int i16 = this.f34200a;
            i12 = o.i(this);
            int l11 = l(i16 + i12);
            if (l10 <= l11) {
                Object[] objArr5 = this.f34201b;
                C1228i.j(objArr5, objArr5, l10, l10 + 1, l11 + 1);
            } else {
                Object[] objArr6 = this.f34201b;
                C1228i.j(objArr6, objArr6, l10, l10 + 1, objArr6.length);
                Object[] objArr7 = this.f34201b;
                objArr7[objArr7.length - 1] = objArr7[0];
                C1228i.j(objArr7, objArr7, 0, 1, l11 + 1);
            }
            this.f34201b[l11] = null;
        }
        this.f34202c = size() - 1;
        return e10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int l10 = l(this.f34200a + size());
        int i10 = this.f34200a;
        if (i10 < l10) {
            C1228i.p(this.f34201b, null, i10, l10);
        } else if (!isEmpty()) {
            Object[] objArr = this.f34201b;
            C1228i.p(objArr, null, this.f34200a, objArr.length);
            C1228i.p(this.f34201b, null, 0, l10);
        }
        this.f34200a = 0;
        this.f34202c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final void e(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f34201b.length;
        while (i10 < length && it.hasNext()) {
            this.f34201b[i10] = it.next();
            i10++;
        }
        int i11 = this.f34200a;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f34201b[i12] = it.next();
        }
        this.f34202c = size() + collection.size();
    }

    public final void g(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f34201b;
        C1228i.j(objArr2, objArr, 0, this.f34200a, objArr2.length);
        Object[] objArr3 = this.f34201b;
        int length = objArr3.length;
        int i11 = this.f34200a;
        C1228i.j(objArr3, objArr, length - i11, 0, i11);
        this.f34200a = 0;
        this.f34201b = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        AbstractC1221b.f34189a.a(i10, size());
        return (E) this.f34201b[l(this.f34200a + i10)];
    }

    public final int h(int i10) {
        int z10;
        if (i10 == 0) {
            z10 = C1229j.z(this.f34201b);
            return z10;
        }
        return i10 - 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i10;
        int l10 = l(this.f34200a + size());
        int i11 = this.f34200a;
        if (i11 < l10) {
            while (i11 < l10) {
                if (kotlin.jvm.internal.i.b(obj, this.f34201b[i11])) {
                    i10 = this.f34200a;
                } else {
                    i11++;
                }
            }
            return -1;
        }
        if (i11 >= l10) {
            int length = this.f34201b.length;
            while (true) {
                if (i11 < length) {
                    if (kotlin.jvm.internal.i.b(obj, this.f34201b[i11])) {
                        i10 = this.f34200a;
                        break;
                    }
                    i11++;
                } else {
                    for (int i12 = 0; i12 < l10; i12++) {
                        if (kotlin.jvm.internal.i.b(obj, this.f34201b[i12])) {
                            i11 = i12 + this.f34201b.length;
                            i10 = this.f34200a;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i11 - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final int j(int i10) {
        int z10;
        z10 = C1229j.z(this.f34201b);
        if (i10 == z10) {
            return 0;
        }
        return i10 + 1;
    }

    public final int k(int i10) {
        if (i10 < 0) {
            return i10 + this.f34201b.length;
        }
        return i10;
    }

    public final int l(int i10) {
        Object[] objArr = this.f34201b;
        if (i10 >= objArr.length) {
            return i10 - objArr.length;
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int z10;
        int i10;
        int l10 = l(this.f34200a + size());
        int i11 = this.f34200a;
        if (i11 < l10) {
            z10 = l10 - 1;
            if (i11 <= z10) {
                while (!kotlin.jvm.internal.i.b(obj, this.f34201b[z10])) {
                    if (z10 != i11) {
                        z10--;
                    }
                }
                i10 = this.f34200a;
                return z10 - i10;
            }
            return -1;
        }
        if (i11 > l10) {
            int i12 = l10 - 1;
            while (true) {
                if (-1 >= i12) {
                    z10 = C1229j.z(this.f34201b);
                    int i13 = this.f34200a;
                    if (i13 <= z10) {
                        while (!kotlin.jvm.internal.i.b(obj, this.f34201b[z10])) {
                            if (z10 != i13) {
                                z10--;
                            }
                        }
                        i10 = this.f34200a;
                    }
                } else {
                    if (kotlin.jvm.internal.i.b(obj, this.f34201b[i12])) {
                        z10 = i12 + this.f34201b.length;
                        i10 = this.f34200a;
                        break;
                    }
                    i12--;
                }
            }
        }
        return -1;
    }

    public final E m() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        int l10;
        kotlin.jvm.internal.i.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f34201b.length != 0) {
            int l11 = l(this.f34200a + size());
            int i10 = this.f34200a;
            if (i10 < l11) {
                l10 = i10;
                while (i10 < l11) {
                    Object obj = this.f34201b[i10];
                    if (!elements.contains(obj)) {
                        this.f34201b[l10] = obj;
                        l10++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                C1228i.p(this.f34201b, null, l10, l11);
            } else {
                int length = this.f34201b.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f34201b;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (!elements.contains(obj2)) {
                        this.f34201b[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                l10 = l(i11);
                for (int i12 = 0; i12 < l11; i12++) {
                    Object[] objArr2 = this.f34201b;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (!elements.contains(obj3)) {
                        this.f34201b[l10] = obj3;
                        l10 = j(l10);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                this.f34202c = k(l10 - this.f34200a);
            }
        }
        return z10;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.f34201b;
            int i10 = this.f34200a;
            E e10 = (E) objArr[i10];
            objArr[i10] = null;
            this.f34200a = j(i10);
            this.f34202c = size() - 1;
            return e10;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        int i10;
        if (!isEmpty()) {
            int i11 = this.f34200a;
            i10 = o.i(this);
            int l10 = l(i11 + i10);
            Object[] objArr = this.f34201b;
            E e10 = (E) objArr[l10];
            objArr[l10] = null;
            this.f34202c = size() - 1;
            return e10;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        int l10;
        kotlin.jvm.internal.i.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f34201b.length != 0) {
            int l11 = l(this.f34200a + size());
            int i10 = this.f34200a;
            if (i10 < l11) {
                l10 = i10;
                while (i10 < l11) {
                    Object obj = this.f34201b[i10];
                    if (elements.contains(obj)) {
                        this.f34201b[l10] = obj;
                        l10++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                C1228i.p(this.f34201b, null, l10, l11);
            } else {
                int length = this.f34201b.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f34201b;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        this.f34201b[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                l10 = l(i11);
                for (int i12 = 0; i12 < l11; i12++) {
                    Object[] objArr2 = this.f34201b;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        this.f34201b[l10] = obj3;
                        l10 = j(l10);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                this.f34202c = k(l10 - this.f34200a);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        AbstractC1221b.f34189a.a(i10, size());
        int l10 = l(this.f34200a + i10);
        Object[] objArr = this.f34201b;
        E e11 = (E) objArr[l10];
        objArr[l10] = e10;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        if (array.length < size()) {
            array = (T[]) C1226g.a(array, size());
        }
        int l10 = l(this.f34200a + size());
        int i10 = this.f34200a;
        if (i10 < l10) {
            C1228i.m(this.f34201b, array, 0, i10, l10, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f34201b;
            C1228i.j(objArr, array, 0, this.f34200a, objArr.length);
            Object[] objArr2 = this.f34201b;
            C1228i.j(objArr2, array, objArr2.length - this.f34200a, 0, l10);
        }
        return (T[]) n.c(size(), array);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        AbstractC1221b.f34189a.b(i10, size());
        if (i10 == size()) {
            addLast(e10);
            return;
        }
        if (i10 == 0) {
            addFirst(e10);
            return;
        }
        i(size() + 1);
        int l10 = l(this.f34200a + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int h10 = h(l10);
            int h11 = h(this.f34200a);
            int i11 = this.f34200a;
            if (h10 >= i11) {
                Object[] objArr = this.f34201b;
                objArr[h11] = objArr[i11];
                C1228i.j(objArr, objArr, i11, i11 + 1, h10 + 1);
            } else {
                Object[] objArr2 = this.f34201b;
                C1228i.j(objArr2, objArr2, i11 - 1, i11, objArr2.length);
                Object[] objArr3 = this.f34201b;
                objArr3[objArr3.length - 1] = objArr3[0];
                C1228i.j(objArr3, objArr3, 0, 1, h10 + 1);
            }
            this.f34201b[h10] = e10;
            this.f34200a = h11;
        } else {
            int l11 = l(this.f34200a + size());
            if (l10 < l11) {
                Object[] objArr4 = this.f34201b;
                C1228i.j(objArr4, objArr4, l10 + 1, l10, l11);
            } else {
                Object[] objArr5 = this.f34201b;
                C1228i.j(objArr5, objArr5, 1, 0, l11);
                Object[] objArr6 = this.f34201b;
                objArr6[0] = objArr6[objArr6.length - 1];
                C1228i.j(objArr6, objArr6, l10 + 1, l10, objArr6.length - 1);
            }
            this.f34201b[l10] = e10;
        }
        this.f34202c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends E> elements) {
        kotlin.jvm.internal.i.f(elements, "elements");
        AbstractC1221b.f34189a.b(i10, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(elements);
        }
        i(size() + elements.size());
        int l10 = l(this.f34200a + size());
        int l11 = l(this.f34200a + i10);
        int size = elements.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i11 = this.f34200a;
            int i12 = i11 - size;
            if (l11 < i11) {
                Object[] objArr = this.f34201b;
                C1228i.j(objArr, objArr, i12, i11, objArr.length);
                if (size >= l11) {
                    Object[] objArr2 = this.f34201b;
                    C1228i.j(objArr2, objArr2, objArr2.length - size, 0, l11);
                } else {
                    Object[] objArr3 = this.f34201b;
                    C1228i.j(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f34201b;
                    C1228i.j(objArr4, objArr4, 0, size, l11);
                }
            } else if (i12 >= 0) {
                Object[] objArr5 = this.f34201b;
                C1228i.j(objArr5, objArr5, i12, i11, l11);
            } else {
                Object[] objArr6 = this.f34201b;
                i12 += objArr6.length;
                int i13 = l11 - i11;
                int length = objArr6.length - i12;
                if (length >= i13) {
                    C1228i.j(objArr6, objArr6, i12, i11, l11);
                } else {
                    C1228i.j(objArr6, objArr6, i12, i11, i11 + length);
                    Object[] objArr7 = this.f34201b;
                    C1228i.j(objArr7, objArr7, 0, this.f34200a + length, l11);
                }
            }
            this.f34200a = i12;
            e(k(l11 - size), elements);
        } else {
            int i14 = l11 + size;
            if (l11 < l10) {
                int i15 = size + l10;
                Object[] objArr8 = this.f34201b;
                if (i15 <= objArr8.length) {
                    C1228i.j(objArr8, objArr8, i14, l11, l10);
                } else if (i14 >= objArr8.length) {
                    C1228i.j(objArr8, objArr8, i14 - objArr8.length, l11, l10);
                } else {
                    int length2 = l10 - (i15 - objArr8.length);
                    C1228i.j(objArr8, objArr8, 0, length2, l10);
                    Object[] objArr9 = this.f34201b;
                    C1228i.j(objArr9, objArr9, i14, l11, length2);
                }
            } else {
                Object[] objArr10 = this.f34201b;
                C1228i.j(objArr10, objArr10, size, 0, l10);
                Object[] objArr11 = this.f34201b;
                if (i14 >= objArr11.length) {
                    C1228i.j(objArr11, objArr11, i14 - objArr11.length, l11, objArr11.length);
                } else {
                    C1228i.j(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f34201b;
                    C1228i.j(objArr12, objArr12, i14, l11, objArr12.length - size);
                }
            }
            e(l11, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
