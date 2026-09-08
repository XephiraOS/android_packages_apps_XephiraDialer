package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public abstract class X extends Y implements L {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34345f = AtomicReferenceFieldUpdater.newUpdater(X.class, Object.class, "_queue");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34346g = AtomicReferenceFieldUpdater.newUpdater(X.class, Object.class, "_delayed");

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34347h = AtomicIntegerFieldUpdater.newUpdater(X.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public final class a extends b {

        /* renamed from: c, reason: collision with root package name */
        public final InterfaceC1266m<m9.q> f34348c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j10, InterfaceC1266m<? super m9.q> interfaceC1266m) {
            super(j10);
            this.f34348c = interfaceC1266m;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34348c.h(X.this, m9.q.f35511a);
        }

        @Override // kotlinx.coroutines.X.b
        public String toString() {
            return super.toString() + this.f34348c;
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public static abstract class b implements Runnable, Comparable<b>, T, kotlinx.coroutines.internal.I {
        private volatile Object _heap;

        /* renamed from: a, reason: collision with root package name */
        public long f34350a;

        /* renamed from: b, reason: collision with root package name */
        public int f34351b = -1;

        public b(long j10) {
            this.f34350a = j10;
        }

        @Override // kotlinx.coroutines.internal.I
        public void a(kotlinx.coroutines.internal.H<?> h10) {
            kotlinx.coroutines.internal.C c10;
            Object obj = this._heap;
            c10 = C1233a0.f34354a;
            if (obj != c10) {
                this._heap = h10;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.T
        public final void b() {
            kotlinx.coroutines.internal.C c10;
            c cVar;
            kotlinx.coroutines.internal.C c11;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    c10 = C1233a0.f34354a;
                    if (obj == c10) {
                        return;
                    }
                    if (obj instanceof c) {
                        cVar = (c) obj;
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        cVar.g(this);
                    }
                    c11 = C1233a0.f34354a;
                    this._heap = c11;
                    m9.q qVar = m9.q.f35511a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.I
        public kotlinx.coroutines.internal.H<?> c() {
            Object obj = this._heap;
            if (obj instanceof kotlinx.coroutines.internal.H) {
                return (kotlinx.coroutines.internal.H) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.I
        public void d(int i10) {
            this.f34351b = i10;
        }

        @Override // java.lang.Comparable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            long j10 = this.f34350a - bVar.f34350a;
            if (j10 > 0) {
                return 1;
            }
            if (j10 < 0) {
                return -1;
            }
            return 0;
        }

        public final int g(long j10, c cVar, X x10) {
            kotlinx.coroutines.internal.C c10;
            synchronized (this) {
                Object obj = this._heap;
                c10 = C1233a0.f34354a;
                if (obj == c10) {
                    return 2;
                }
                synchronized (cVar) {
                    try {
                        b b10 = cVar.b();
                        if (x10.X()) {
                            return 1;
                        }
                        if (b10 == null) {
                            cVar.f34352c = j10;
                        } else {
                            long j11 = b10.f34350a;
                            if (j11 - j10 < 0) {
                                j10 = j11;
                            }
                            if (j10 - cVar.f34352c > 0) {
                                cVar.f34352c = j10;
                            }
                        }
                        long j12 = this.f34350a;
                        long j13 = cVar.f34352c;
                        if (j12 - j13 < 0) {
                            this.f34350a = j13;
                        }
                        cVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.internal.I
        public int getIndex() {
            return this.f34351b;
        }

        public final boolean h(long j10) {
            if (j10 - this.f34350a >= 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f34350a + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public static final class c extends kotlinx.coroutines.internal.H<b> {

        /* renamed from: c, reason: collision with root package name */
        public long f34352c;

        public c(long j10) {
            this.f34352c = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean X() {
        if (f34347h.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final void B0() {
        kotlinx.coroutines.internal.C c10;
        kotlinx.coroutines.internal.C c11;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34345f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f34345f;
                c10 = C1233a0.f34355b;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, null, c10)) {
                    return;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                c11 = C1233a0.f34355b;
                if (obj == c11) {
                    return;
                }
                kotlinx.coroutines.internal.q qVar = new kotlinx.coroutines.internal.q(8, true);
                kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                qVar.a((Runnable) obj);
                if (f34345f.compareAndSet(this, obj, qVar)) {
                    return;
                }
            } else {
                ((kotlinx.coroutines.internal.q) obj).d();
                return;
            }
        }
    }

    public final Runnable C0() {
        kotlinx.coroutines.internal.C c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34345f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                c10 = C1233a0.f34355b;
                if (obj == c10) {
                    return null;
                }
                if (f34345f.compareAndSet(this, obj, null)) {
                    kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            } else {
                kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.q qVar = (kotlinx.coroutines.internal.q) obj;
                Object j10 = qVar.j();
                if (j10 != kotlinx.coroutines.internal.q.f34530h) {
                    return (Runnable) j10;
                }
                f34345f.compareAndSet(this, obj, qVar.i());
            }
        }
    }

    public void D0(Runnable runnable) {
        if (E0(runnable)) {
            z0();
        } else {
            H.f34318i.D0(runnable);
        }
    }

    public final boolean E0(Runnable runnable) {
        kotlinx.coroutines.internal.C c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34345f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (X()) {
                return false;
            }
            if (obj == null) {
                if (f34345f.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                c10 = C1233a0.f34355b;
                if (obj == c10) {
                    return false;
                }
                kotlinx.coroutines.internal.q qVar = new kotlinx.coroutines.internal.q(8, true);
                kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                qVar.a((Runnable) obj);
                qVar.a(runnable);
                if (f34345f.compareAndSet(this, obj, qVar)) {
                    return true;
                }
            } else {
                kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                kotlinx.coroutines.internal.q qVar2 = (kotlinx.coroutines.internal.q) obj;
                int a10 = qVar2.a(runnable);
                if (a10 == 0) {
                    return true;
                }
                if (a10 != 1) {
                    if (a10 == 2) {
                        return false;
                    }
                } else {
                    f34345f.compareAndSet(this, obj, qVar2.i());
                }
            }
        }
    }

    public boolean F0() {
        kotlinx.coroutines.internal.C c10;
        if (!t0()) {
            return false;
        }
        c cVar = (c) f34346g.get(this);
        if (cVar != null && !cVar.d()) {
            return false;
        }
        Object obj = f34345f.get(this);
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                c10 = C1233a0.f34355b;
                if (obj != c10) {
                    return false;
                }
            } else {
                return ((kotlinx.coroutines.internal.q) obj).g();
            }
        }
        return true;
    }

    public final void G0() {
        b i10;
        C1236c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) f34346g.get(this);
            if (cVar != null && (i10 = cVar.i()) != null) {
                y0(nanoTime, i10);
            } else {
                return;
            }
        }
    }

    public final void H0() {
        f34345f.set(this, null);
        f34346g.set(this, null);
    }

    public final void I0(long j10, b bVar) {
        int J02 = J0(j10, bVar);
        if (J02 != 0) {
            if (J02 != 1) {
                if (J02 != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
                return;
            } else {
                y0(j10, bVar);
                return;
            }
        }
        if (L0(bVar)) {
            z0();
        }
    }

    public final int J0(long j10, b bVar) {
        if (X()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34346g;
        c cVar = (c) atomicReferenceFieldUpdater.get(this);
        if (cVar == null) {
            atomicReferenceFieldUpdater.compareAndSet(this, null, new c(j10));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.i.c(obj);
            cVar = (c) obj;
        }
        return bVar.g(j10, cVar, this);
    }

    public final void K0(boolean z10) {
        f34347h.set(this, z10 ? 1 : 0);
    }

    public final boolean L0(b bVar) {
        b bVar2;
        c cVar = (c) f34346g.get(this);
        if (cVar != null) {
            bVar2 = cVar.e();
        } else {
            bVar2 = null;
        }
        if (bVar2 == bVar) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void f0(CoroutineContext coroutineContext, Runnable runnable) {
        D0(runnable);
    }

    @Override // kotlinx.coroutines.W
    public long o0() {
        b e10;
        long c10;
        kotlinx.coroutines.internal.C c11;
        if (super.o0() == 0) {
            return 0L;
        }
        Object obj = f34345f.get(this);
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.q)) {
                c11 = C1233a0.f34355b;
                if (obj != c11) {
                    return 0L;
                }
                return Long.MAX_VALUE;
            }
            if (!((kotlinx.coroutines.internal.q) obj).g()) {
                return 0L;
            }
        }
        c cVar = (c) f34346g.get(this);
        if (cVar == null || (e10 = cVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = e10.f34350a;
        C1236c.a();
        c10 = B9.i.c(j10 - System.nanoTime(), 0L);
        return c10;
    }

    @Override // kotlinx.coroutines.L
    public void s(long j10, InterfaceC1266m<? super m9.q> interfaceC1266m) {
        long c10 = C1233a0.c(j10);
        if (c10 < 4611686018427387903L) {
            C1236c.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(c10 + nanoTime, interfaceC1266m);
            I0(nanoTime, aVar);
            C1272p.a(interfaceC1266m, aVar);
        }
    }

    @Override // kotlinx.coroutines.W
    public void shutdown() {
        I0.f34322a.c();
        K0(true);
        B0();
        do {
        } while (u0() <= 0);
        G0();
    }

    @Override // kotlinx.coroutines.W
    public long u0() {
        b bVar;
        if (v0()) {
            return 0L;
        }
        c cVar = (c) f34346g.get(this);
        if (cVar != null && !cVar.d()) {
            C1236c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (cVar) {
                    b b10 = cVar.b();
                    bVar = null;
                    if (b10 != null) {
                        b bVar2 = b10;
                        if (bVar2.h(nanoTime) && E0(bVar2)) {
                            bVar = cVar.h(0);
                        }
                    }
                }
            } while (bVar != null);
        }
        Runnable C02 = C0();
        if (C02 != null) {
            C02.run();
            return 0L;
        }
        return o0();
    }
}
