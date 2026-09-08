package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.I;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes4.dex */
public class H<T extends I & Comparable<? super T>> {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34484b = AtomicIntegerFieldUpdater.newUpdater(H.class, "_size");
    private volatile int _size;

    /* renamed from: a, reason: collision with root package name */
    public T[] f34485a;

    public final void a(T t10) {
        t10.a(this);
        T[] f10 = f();
        int c10 = c();
        j(c10 + 1);
        f10[c10] = t10;
        t10.d(c10);
        l(c10);
    }

    public final T b() {
        T[] tArr = this.f34485a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return f34484b.get(this);
    }

    public final boolean d() {
        if (c() == 0) {
            return true;
        }
        return false;
    }

    public final T e() {
        T b10;
        synchronized (this) {
            b10 = b();
        }
        return b10;
    }

    public final T[] f() {
        T[] tArr = this.f34485a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new I[4];
            this.f34485a = tArr2;
            return tArr2;
        }
        if (c() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
            kotlin.jvm.internal.i.e(copyOf, "copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((I[]) copyOf);
            this.f34485a = tArr3;
            return tArr3;
        }
        return tArr;
    }

    public final boolean g(T t10) {
        boolean z10;
        synchronized (this) {
            if (t10.c() == null) {
                z10 = false;
            } else {
                h(t10.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    public final T h(int i10) {
        T[] tArr = this.f34485a;
        kotlin.jvm.internal.i.c(tArr);
        j(c() - 1);
        if (i10 < c()) {
            m(i10, c());
            int i11 = (i10 - 1) / 2;
            if (i10 > 0) {
                T t10 = tArr[i10];
                kotlin.jvm.internal.i.c(t10);
                T t11 = tArr[i11];
                kotlin.jvm.internal.i.c(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    m(i10, i11);
                    l(i11);
                }
            }
            k(i10);
        }
        T t12 = tArr[c()];
        kotlin.jvm.internal.i.c(t12);
        t12.a(null);
        t12.d(-1);
        tArr[c()] = null;
        return t12;
    }

    public final T i() {
        T t10;
        synchronized (this) {
            if (c() > 0) {
                t10 = h(0);
            } else {
                t10 = null;
            }
        }
        return t10;
    }

    public final void j(int i10) {
        f34484b.set(this, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            return
        Lb:
            T extends kotlinx.coroutines.internal.I & java.lang.Comparable<? super T>[] r2 = r5.f34485a
            kotlin.jvm.internal.i.c(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            kotlin.jvm.internal.i.c(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.i.c(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            kotlin.jvm.internal.i.c(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.i.c(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
            return
        L3f:
            r5.m(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.H.k(int):void");
    }

    public final void l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f34485a;
            kotlin.jvm.internal.i.c(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            kotlin.jvm.internal.i.c(t10);
            T t11 = tArr[i10];
            kotlin.jvm.internal.i.c(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    public final void m(int i10, int i11) {
        T[] tArr = this.f34485a;
        kotlin.jvm.internal.i.c(tArr);
        T t10 = tArr[i11];
        kotlin.jvm.internal.i.c(t10);
        T t11 = tArr[i10];
        kotlin.jvm.internal.i.c(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.d(i10);
        t11.d(i11);
    }
}
