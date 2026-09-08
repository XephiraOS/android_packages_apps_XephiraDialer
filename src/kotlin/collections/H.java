package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes4.dex */
public final class H<T> extends AbstractC1221b<T> implements RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f34173b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34174c;

    /* renamed from: d, reason: collision with root package name */
    public int f34175d;

    /* renamed from: e, reason: collision with root package name */
    public int f34176e;

    /* compiled from: SlidingWindow.kt */
    /* loaded from: classes4.dex */
    public static final class a extends AbstractC1220a<T> {

        /* renamed from: c, reason: collision with root package name */
        public int f34177c;

        /* renamed from: d, reason: collision with root package name */
        public int f34178d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ H<T> f34179e;

        public a(H<T> h10) {
            this.f34179e = h10;
            this.f34177c = h10.size();
            this.f34178d = h10.f34175d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.AbstractC1220a
        public void a() {
            if (this.f34177c == 0) {
                b();
                return;
            }
            c(this.f34179e.f34173b[this.f34178d]);
            this.f34178d = (this.f34178d + 1) % this.f34179e.f34174c;
            this.f34177c--;
        }
    }

    public H(Object[] buffer, int i10) {
        kotlin.jvm.internal.i.f(buffer, "buffer");
        this.f34173b = buffer;
        if (i10 >= 0) {
            if (i10 <= buffer.length) {
                this.f34174c = buffer.length;
                this.f34176e = i10;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.f34176e;
    }

    @Override // kotlin.collections.AbstractC1221b, java.util.List
    public T get(int i10) {
        AbstractC1221b.f34189a.a(i10, size());
        return (T) this.f34173b[(this.f34175d + i10) % this.f34174c];
    }

    public final void h(T t10) {
        if (!j()) {
            this.f34173b[(this.f34175d + size()) % this.f34174c] = t10;
            this.f34176e = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final H<T> i(int i10) {
        int e10;
        Object[] array;
        int i11 = this.f34174c;
        e10 = B9.i.e(i11 + (i11 >> 1) + 1, i10);
        if (this.f34175d == 0) {
            array = Arrays.copyOf(this.f34173b, e10);
            kotlin.jvm.internal.i.e(array, "copyOf(...)");
        } else {
            array = toArray(new Object[e10]);
        }
        return new H<>(array, size());
    }

    @Override // kotlin.collections.AbstractC1221b, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final boolean j() {
        if (size() == this.f34174c) {
            return true;
        }
        return false;
    }

    public final void k(int i10) {
        if (i10 >= 0) {
            if (i10 <= size()) {
                if (i10 > 0) {
                    int i11 = this.f34175d;
                    int i12 = (i11 + i10) % this.f34174c;
                    if (i11 > i12) {
                        C1228i.p(this.f34173b, null, i11, this.f34174c);
                        C1228i.p(this.f34173b, null, 0, i12);
                    } else {
                        C1228i.p(this.f34173b, null, i11, i12);
                    }
                    this.f34175d = i12;
                    this.f34176e = size() - i10;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i10 + ", size = " + size()).toString());
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i10).toString());
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.i.e(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = this.f34175d; i11 < size && i12 < this.f34174c; i12++) {
            objArr[i11] = this.f34173b[i12];
            i11++;
        }
        while (i11 < size) {
            objArr[i11] = this.f34173b[i10];
            i11++;
            i10++;
        }
        return (T[]) n.c(size, objArr);
    }

    public H(int i10) {
        this(new Object[i10], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
