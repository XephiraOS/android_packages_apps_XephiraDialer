package kotlinx.coroutines.scheduling;

import E9.g;
import E9.h;
import E9.j;
import E9.k;
import E9.m;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.random.Random;
import kotlinx.coroutines.C1236c;
import kotlinx.coroutines.G;
import kotlinx.coroutines.internal.C;
import kotlinx.coroutines.internal.x;
import m9.q;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes4.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final a f34571h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34572i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34573j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34574k = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* renamed from: l, reason: collision with root package name */
    public static final C f34575l = new C("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* renamed from: a, reason: collision with root package name */
    public final int f34576a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34577b;

    /* renamed from: c, reason: collision with root package name */
    public final long f34578c;
    private volatile long controlState;

    /* renamed from: d, reason: collision with root package name */
    public final String f34579d;

    /* renamed from: e, reason: collision with root package name */
    public final E9.c f34580e;

    /* renamed from: f, reason: collision with root package name */
    public final E9.c f34581f;

    /* renamed from: g, reason: collision with root package name */
    public final x<c> f34582g;
    private volatile long parkedWorkersStack;

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes4.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34589a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f34589a = iArr;
        }
    }

    public CoroutineScheduler(int i10, int i11, long j10, String str) {
        this.f34576a = i10;
        this.f34577b = i11;
        this.f34578c = j10;
        this.f34579d = str;
        if (i10 >= 1) {
            if (i11 >= i10) {
                if (i11 <= 2097150) {
                    if (j10 > 0) {
                        this.f34580e = new E9.c();
                        this.f34581f = new E9.c();
                        this.f34582g = new x<>((i10 + 1) * 2);
                        this.controlState = i10 << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
    }

    public static /* synthetic */ boolean V(CoroutineScheduler coroutineScheduler, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f34573j.get(coroutineScheduler);
        }
        return coroutineScheduler.U(j10);
    }

    public static /* synthetic */ void r(CoroutineScheduler coroutineScheduler, Runnable runnable, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            hVar = k.f762g;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        coroutineScheduler.o(runnable, hVar, z10);
    }

    public final void B(c cVar, int i10, int i11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34572i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (i12 == i10) {
                if (i11 == 0) {
                    i12 = s(cVar);
                } else {
                    i12 = i11;
                }
            }
            if (i12 >= 0 && f34572i.compareAndSet(this, j10, j11 | i12)) {
                return;
            }
        }
    }

    public final void G(g gVar) {
        try {
            gVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void I(long j10) {
        int i10;
        g d10;
        if (!f34574k.compareAndSet(this, 0, 1)) {
            return;
        }
        c l10 = l();
        synchronized (this.f34582g) {
            i10 = (int) (f34573j.get(this) & 2097151);
        }
        if (1 <= i10) {
            int i11 = 1;
            while (true) {
                c b10 = this.f34582g.b(i11);
                i.c(b10);
                c cVar = b10;
                if (cVar != l10) {
                    while (cVar.isAlive()) {
                        LockSupport.unpark(cVar);
                        cVar.join(j10);
                    }
                    cVar.f34591a.f(this.f34581f);
                }
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.f34581f.b();
        this.f34580e.b();
        while (true) {
            if (l10 != null) {
                d10 = l10.g(true);
                if (d10 != null) {
                    continue;
                    G(d10);
                }
            }
            d10 = this.f34580e.d();
            if (d10 == null && (d10 = this.f34581f.d()) == null) {
                break;
            }
            G(d10);
        }
        if (l10 != null) {
            l10.u(WorkerState.TERMINATED);
        }
        f34572i.set(this, 0L);
        f34573j.set(this, 0L);
    }

    public final void L(long j10, boolean z10) {
        if (z10 || X() || U(j10)) {
            return;
        }
        X();
    }

    public final void O() {
        if (X() || V(this, 0L, 1, null)) {
            return;
        }
        X();
    }

    public final g S(c cVar, g gVar, boolean z10) {
        if (cVar == null) {
            return gVar;
        }
        if (cVar.f34593c == WorkerState.TERMINATED) {
            return gVar;
        }
        if (gVar.f753b.b() == 0 && cVar.f34593c == WorkerState.BLOCKING) {
            return gVar;
        }
        cVar.f34597g = true;
        return cVar.f34591a.a(gVar, z10);
    }

    public final boolean U(long j10) {
        int b10;
        b10 = B9.i.b(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0);
        if (b10 < this.f34576a) {
            int e10 = e();
            if (e10 == 1 && this.f34576a > 1) {
                e();
            }
            if (e10 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean X() {
        c u10;
        do {
            u10 = u();
            if (u10 == null) {
                return false;
            }
        } while (!c.j().compareAndSet(u10, -1, 0));
        LockSupport.unpark(u10);
        return true;
    }

    public final boolean c(g gVar) {
        if (gVar.f753b.b() == 1) {
            return this.f34581f.a(gVar);
        }
        return this.f34580e.a(gVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        I(10000L);
    }

    public final int e() {
        int b10;
        synchronized (this.f34582g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f34573j;
                long j10 = atomicLongFieldUpdater.get(this);
                int i10 = (int) (j10 & 2097151);
                b10 = B9.i.b(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
                if (b10 >= this.f34576a) {
                    return 0;
                }
                if (i10 >= this.f34577b) {
                    return 0;
                }
                int i11 = ((int) (f34573j.get(this) & 2097151)) + 1;
                if (i11 > 0 && this.f34582g.b(i11) == null) {
                    c cVar = new c(this, i11);
                    this.f34582g.c(i11, cVar);
                    if (i11 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                        int i12 = b10 + 1;
                        cVar.start();
                        return i12;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        r(this, runnable, null, false, 6, null);
    }

    public final g g(Runnable runnable, h hVar) {
        long a10 = k.f761f.a();
        if (runnable instanceof g) {
            g gVar = (g) runnable;
            gVar.f752a = a10;
            gVar.f753b = hVar;
            return gVar;
        }
        return new j(runnable, a10, hVar);
    }

    public final boolean isTerminated() {
        if (f34574k.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final c l() {
        c cVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof c) {
            cVar = (c) currentThread;
        } else {
            cVar = null;
        }
        if (cVar == null || !i.b(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    public final void o(Runnable runnable, h hVar, boolean z10) {
        boolean z11;
        long j10;
        C1236c.a();
        g g10 = g(runnable, hVar);
        boolean z12 = false;
        if (g10.f753b.b() == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            j10 = f34573j.addAndGet(this, 2097152L);
        } else {
            j10 = 0;
        }
        c l10 = l();
        g S10 = S(l10, g10, z10);
        if (S10 != null && !c(S10)) {
            throw new RejectedExecutionException(this.f34579d + " was terminated");
        }
        if (z10 && l10 != null) {
            z12 = true;
        }
        if (z11) {
            L(j10, z12);
        } else {
            if (z12) {
                return;
            }
            O();
        }
    }

    public final int s(c cVar) {
        Object i10 = cVar.i();
        while (i10 != f34575l) {
            if (i10 == null) {
                return 0;
            }
            c cVar2 = (c) i10;
            int h10 = cVar2.h();
            if (h10 != 0) {
                return h10;
            }
            i10 = cVar2.i();
        }
        return -1;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a10 = this.f34582g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < a10; i15++) {
            c b10 = this.f34582g.b(i15);
            if (b10 != null) {
                int e10 = b10.f34591a.e();
                int i16 = b.f34589a[b10.f34593c.ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 4) {
                                if (i16 == 5) {
                                    i14++;
                                }
                            } else {
                                i13++;
                                if (e10 > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(e10);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            i10++;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(e10);
                            sb2.append('c');
                            arrayList.add(sb2.toString());
                        }
                    } else {
                        i11++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(e10);
                        sb3.append('b');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    i12++;
                }
            }
        }
        long j10 = f34573j.get(this);
        return this.f34579d + '@' + G.b(this) + "[Pool Size {core = " + this.f34576a + ", max = " + this.f34577b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f34580e.c() + ", global blocking queue size = " + this.f34581f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f34576a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final c u() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34572i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c b10 = this.f34582g.b((int) (2097151 & j10));
            if (b10 == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int s10 = s(b10);
            if (s10 >= 0 && f34572i.compareAndSet(this, j10, s10 | j11)) {
                b10.r(f34575l);
                return b10;
            }
        }
    }

    public final boolean y(c cVar) {
        long j10;
        int h10;
        if (cVar.i() != f34575l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34572i;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            h10 = cVar.h();
            cVar.r(this.f34582g.b((int) (2097151 & j10)));
        } while (!f34572i.compareAndSet(this, j10, ((2097152 + j10) & (-2097152)) | h10));
        return true;
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes4.dex */
    public final class c extends Thread {

        /* renamed from: i, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f34590i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a, reason: collision with root package name */
        public final m f34591a;

        /* renamed from: b, reason: collision with root package name */
        public final Ref$ObjectRef<g> f34592b;

        /* renamed from: c, reason: collision with root package name */
        public WorkerState f34593c;

        /* renamed from: d, reason: collision with root package name */
        public long f34594d;

        /* renamed from: e, reason: collision with root package name */
        public long f34595e;

        /* renamed from: f, reason: collision with root package name */
        public int f34596f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f34597g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        public c() {
            setDaemon(true);
            this.f34591a = new m();
            this.f34592b = new Ref$ObjectRef<>();
            this.f34593c = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f34575l;
            this.f34596f = Random.f34246a.b();
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f34590i;
        }

        public final void b(int i10) {
            if (i10 == 0) {
                return;
            }
            CoroutineScheduler.f34573j.addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.f34593c != WorkerState.TERMINATED) {
                this.f34593c = WorkerState.DORMANT;
            }
        }

        public final void c(int i10) {
            if (i10 != 0 && u(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.O();
            }
        }

        public final void d(g gVar) {
            int b10 = gVar.f753b.b();
            k(b10);
            c(b10);
            CoroutineScheduler.this.G(gVar);
            b(b10);
        }

        public final g e(boolean z10) {
            boolean z11;
            g o10;
            g o11;
            if (z10) {
                if (m(CoroutineScheduler.this.f34576a * 2) == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (o11 = o()) != null) {
                    return o11;
                }
                g g10 = this.f34591a.g();
                if (g10 != null) {
                    return g10;
                }
                if (!z11 && (o10 = o()) != null) {
                    return o10;
                }
            } else {
                g o12 = o();
                if (o12 != null) {
                    return o12;
                }
            }
            return v(3);
        }

        public final g f() {
            g h10 = this.f34591a.h();
            if (h10 == null) {
                g d10 = CoroutineScheduler.this.f34581f.d();
                if (d10 == null) {
                    return v(1);
                }
                return d10;
            }
            return h10;
        }

        public final g g(boolean z10) {
            if (s()) {
                return e(z10);
            }
            return f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final void k(int i10) {
            this.f34594d = 0L;
            if (this.f34593c == WorkerState.PARKING) {
                this.f34593c = WorkerState.BLOCKING;
            }
        }

        public final boolean l() {
            if (this.nextParkedWorker != CoroutineScheduler.f34575l) {
                return true;
            }
            return false;
        }

        public final int m(int i10) {
            int i11 = this.f34596f;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f34596f = i14;
            int i15 = i10 - 1;
            if ((i15 & i10) == 0) {
                return i15 & i14;
            }
            return (Integer.MAX_VALUE & i14) % i10;
        }

        public final void n() {
            if (this.f34594d == 0) {
                this.f34594d = System.nanoTime() + CoroutineScheduler.this.f34578c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f34578c);
            if (System.nanoTime() - this.f34594d >= 0) {
                this.f34594d = 0L;
                w();
            }
        }

        public final g o() {
            if (m(2) == 0) {
                g d10 = CoroutineScheduler.this.f34580e.d();
                if (d10 != null) {
                    return d10;
                }
                return CoroutineScheduler.this.f34581f.d();
            }
            g d11 = CoroutineScheduler.this.f34581f.d();
            if (d11 != null) {
                return d11;
            }
            return CoroutineScheduler.this.f34580e.d();
        }

        public final void p() {
            loop0: while (true) {
                boolean z10 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f34593c != WorkerState.TERMINATED) {
                    g g10 = g(this.f34597g);
                    if (g10 != null) {
                        this.f34595e = 0L;
                        d(g10);
                    } else {
                        this.f34597g = false;
                        if (this.f34595e != 0) {
                            if (!z10) {
                                z10 = true;
                            } else {
                                u(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.f34595e);
                                this.f34595e = 0L;
                            }
                        } else {
                            t();
                        }
                    }
                }
            }
            u(WorkerState.TERMINATED);
        }

        public final void q(int i10) {
            String valueOf;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f34579d);
            sb.append("-worker-");
            if (i10 == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(i10);
            }
            sb.append(valueOf);
            setName(sb.toString());
            this.indexInArray = i10;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean s() {
            long j10;
            if (this.f34593c == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.f34573j;
            do {
                j10 = atomicLongFieldUpdater.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j10) >> 42)) != 0) {
                } else {
                    return false;
                }
            } while (!CoroutineScheduler.f34573j.compareAndSet(coroutineScheduler, j10, j10 - 4398046511104L));
            this.f34593c = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final void t() {
            if (!l()) {
                CoroutineScheduler.this.y(this);
                return;
            }
            f34590i.set(this, -1);
            while (l() && f34590i.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.f34593c != WorkerState.TERMINATED) {
                u(WorkerState.PARKING);
                Thread.interrupted();
                n();
            }
        }

        public final boolean u(WorkerState workerState) {
            boolean z10;
            WorkerState workerState2 = this.f34593c;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                CoroutineScheduler.f34573j.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f34593c = workerState;
            }
            return z10;
        }

        public final g v(int i10) {
            int i11 = (int) (CoroutineScheduler.f34573j.get(CoroutineScheduler.this) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int m10 = m(i11);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j10 = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                m10++;
                if (m10 > i11) {
                    m10 = 1;
                }
                c b10 = coroutineScheduler.f34582g.b(m10);
                if (b10 != null && b10 != this) {
                    long n10 = b10.f34591a.n(i10, this.f34592b);
                    if (n10 == -1) {
                        Ref$ObjectRef<g> ref$ObjectRef = this.f34592b;
                        g gVar = ref$ObjectRef.element;
                        ref$ObjectRef.element = null;
                        return gVar;
                    }
                    if (n10 > 0) {
                        j10 = Math.min(j10, n10);
                    }
                }
            }
            if (j10 == Long.MAX_VALUE) {
                j10 = 0;
            }
            this.f34595e = j10;
            return null;
        }

        public final void w() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f34582g) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.f34573j.get(coroutineScheduler) & 2097151)) <= coroutineScheduler.f34576a) {
                        return;
                    }
                    if (!f34590i.compareAndSet(this, -1, 1)) {
                        return;
                    }
                    int i10 = this.indexInArray;
                    q(0);
                    coroutineScheduler.B(this, i10, 0);
                    int andDecrement = (int) (CoroutineScheduler.f34573j.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != i10) {
                        c b10 = coroutineScheduler.f34582g.b(andDecrement);
                        i.c(b10);
                        c cVar = b10;
                        coroutineScheduler.f34582g.c(i10, cVar);
                        cVar.q(i10);
                        coroutineScheduler.B(cVar, andDecrement, i10);
                    }
                    coroutineScheduler.f34582g.c(andDecrement, null);
                    q qVar = q.f35511a;
                    this.f34593c = WorkerState.TERMINATED;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(CoroutineScheduler coroutineScheduler, int i10) {
            this();
            q(i10);
        }
    }
}
