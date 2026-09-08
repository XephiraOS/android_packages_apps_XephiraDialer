package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes4.dex */
public final class q<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final a f34527e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34528f = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34529g = AtomicLongFieldUpdater.newUpdater(q.class, "_state");

    /* renamed from: h, reason: collision with root package name */
    public static final C f34530h = new C("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a, reason: collision with root package name */
    public final int f34531a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f34532b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34533c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f34534d;

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public final int a(long j10) {
            if ((j10 & 2305843009213693952L) != 0) {
                return 2;
            }
            return 1;
        }

        public final long b(long j10, int i10) {
            return d(j10, 1073741823L) | i10;
        }

        public final long c(long j10, int i10) {
            return d(j10, 1152921503533105152L) | (i10 << 30);
        }

        public final long d(long j10, long j11) {
            return j10 & (~j11);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f34535a;

        public b(int i10) {
            this.f34535a = i10;
        }
    }

    public q(int i10, boolean z10) {
        this.f34531a = i10;
        this.f34532b = z10;
        int i11 = i10 - 1;
        this.f34533c = i11;
        this.f34534d = new AtomicReferenceArray(i10);
        if (i11 <= 1073741823) {
            if ((i10 & i11) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.internal.q.f34529g
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L16
            kotlinx.coroutines.internal.q$a r12 = kotlinx.coroutines.internal.q.f34527e
            int r12 = r12.a(r3)
            return r12
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f34533c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L30
            return r6
        L30:
            boolean r2 = r12.f34532b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f34534d
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L4f
            int r2 = r12.f34531a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L2
        L4e:
            return r6
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kotlinx.coroutines.internal.q.f34529g
            kotlinx.coroutines.internal.q$a r5 = kotlinx.coroutines.internal.q.f34527e
            long r5 = r5.c(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f34534d
            r1 = r9 & r10
            r0.set(r1, r13)
        L69:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.internal.q.f34529g
            long r0 = r0.get(r12)
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 == 0) goto L80
            kotlinx.coroutines.internal.q r12 = r12.i()
            kotlinx.coroutines.internal.q r12 = r12.e(r9, r13)
            if (r12 != 0) goto L69
        L80:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.q.a(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q<E> b(long j10) {
        q<E> qVar = new q<>(this.f34531a * 2, this.f34532b);
        int i10 = (int) (1073741823 & j10);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f34533c;
            if ((i10 & i12) != (i11 & i12)) {
                Object obj = this.f34534d.get(i12 & i10);
                if (obj == null) {
                    obj = new b(i10);
                }
                qVar.f34534d.set(qVar.f34533c & i10, obj);
                i10++;
            } else {
                f34529g.set(qVar, f34527e.d(j10, 1152921504606846976L));
                return qVar;
            }
        }
    }

    public final q<E> c(long j10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34528f;
        while (true) {
            q<E> qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (qVar != null) {
                return qVar;
            }
            f34528f.compareAndSet(this, null, b(j10));
        }
    }

    public final boolean d() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34529g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    public final q<E> e(int i10, E e10) {
        Object obj = this.f34534d.get(this.f34533c & i10);
        if ((obj instanceof b) && ((b) obj).f34535a == i10) {
            this.f34534d.set(i10 & this.f34533c, e10);
            return this;
        }
        return null;
    }

    public final int f() {
        long j10 = f34529g.get(this);
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j10)));
    }

    public final boolean g() {
        long j10 = f34529g.get(this);
        if (((int) (1073741823 & j10)) == ((int) ((j10 & 1152921503533105152L) >> 30))) {
            return true;
        }
        return false;
    }

    public final long h() {
        long j10;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34529g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            j11 = j10 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j11));
        return j11;
    }

    public final q<E> i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34529g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j10) != 0) {
                return f34530h;
            }
            int i10 = (int) (1073741823 & j10);
            int i11 = this.f34533c;
            if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i10 & i11)) {
                return null;
            }
            Object obj = this.f34534d.get(i11 & i10);
            if (obj == null) {
                if (this.f34532b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i12 = (i10 + 1) & 1073741823;
                if (f34529g.compareAndSet(this, j10, f34527e.b(j10, i12))) {
                    this.f34534d.set(this.f34533c & i10, null);
                    return obj;
                }
                if (this.f34532b) {
                    do {
                        this = this.k(i10, i12);
                    } while (this != null);
                    return obj;
                }
            }
        }
    }

    public final q<E> k(int i10, int i11) {
        long j10;
        int i12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34529g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            i12 = (int) (1073741823 & j10);
            if ((1152921504606846976L & j10) != 0) {
                return i();
            }
        } while (!f34529g.compareAndSet(this, j10, f34527e.b(j10, i11)));
        this.f34534d.set(this.f34533c & i12, null);
        return null;
    }
}
