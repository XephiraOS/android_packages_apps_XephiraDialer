package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.Q0;
import kotlinx.coroutines.internal.A;
import kotlinx.coroutines.internal.C;
import kotlinx.coroutines.internal.C1253d;
import kotlinx.coroutines.internal.z;
import m9.q;
import v9.l;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public class SemaphoreImpl {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34616c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34617d = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34618e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34619f = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34620g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");
    private volatile int _availablePermits;

    /* renamed from: a, reason: collision with root package name */
    public final int f34621a;

    /* renamed from: b, reason: collision with root package name */
    public final l<Throwable, q> f34622b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    public SemaphoreImpl(int i10, int i11) {
        this.f34621a = i10;
        if (i10 > 0) {
            if (i11 >= 0 && i11 <= i10) {
                d dVar = new d(0L, null, 2);
                this.head = dVar;
                this.tail = dVar;
                this._availablePermits = i10 - i11;
                this.f34622b = new l<Throwable, q>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
                    {
                        super(1);
                    }

                    public final void b(Throwable th) {
                        SemaphoreImpl.this.h();
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ q invoke(Throwable th) {
                        b(th);
                        return q.f35511a;
                    }
                };
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i10).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i10).toString());
    }

    public final void c(InterfaceC1266m<? super q> interfaceC1266m) {
        while (f() <= 0) {
            i.d(interfaceC1266m, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (d((Q0) interfaceC1266m)) {
                return;
            }
        }
        interfaceC1266m.b(q.f35511a, this.f34622b);
    }

    public final boolean d(Q0 q02) {
        int i10;
        Object c10;
        int i11;
        C c11;
        C c12;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34618e;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f34619f.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.f34623a;
        i10 = c.f34632f;
        long j10 = andIncrement / i10;
        loop0: while (true) {
            c10 = C1253d.c(dVar, j10, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (!A.c(c10)) {
                z b10 = A.b(c10);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f34541c >= b10.f34541c) {
                        break loop0;
                    }
                    if (!b10.q()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            } else {
                break;
            }
        }
        d dVar2 = (d) A.b(c10);
        i11 = c.f34632f;
        int i12 = (int) (andIncrement % i11);
        if (!dVar2.r().compareAndSet(i12, null, q02)) {
            c11 = c.f34628b;
            c12 = c.f34629c;
            if (dVar2.r().compareAndSet(i12, c11, c12)) {
                if (q02 instanceof InterfaceC1266m) {
                    i.d(q02, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    ((InterfaceC1266m) q02).b(q.f35511a, this.f34622b);
                } else if (q02 instanceof F9.b) {
                    ((F9.b) q02).e(q.f35511a);
                } else {
                    throw new IllegalStateException(("unexpected: " + q02).toString());
                }
                return true;
            }
            return false;
        }
        q02.c(dVar2, i12);
        return true;
    }

    public final void e() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        int i11;
        do {
            atomicIntegerFieldUpdater = f34620g;
            i10 = atomicIntegerFieldUpdater.get(this);
            i11 = this.f34621a;
            if (i10 <= i11) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i11));
    }

    public final int f() {
        int andDecrement;
        do {
            andDecrement = f34620g.getAndDecrement(this);
        } while (andDecrement > this.f34621a);
        return andDecrement;
    }

    public int g() {
        return Math.max(f34620g.get(this), 0);
    }

    public void h() {
        do {
            int andIncrement = f34620g.getAndIncrement(this);
            if (andIncrement < this.f34621a) {
                if (andIncrement >= 0) {
                    return;
                }
            } else {
                e();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f34621a).toString());
            }
        } while (!k());
    }

    public boolean i() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34620g;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 > this.f34621a) {
                e();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean j(Object obj) {
        if (obj instanceof InterfaceC1266m) {
            i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            InterfaceC1266m interfaceC1266m = (InterfaceC1266m) obj;
            Object f10 = interfaceC1266m.f(q.f35511a, null, this.f34622b);
            if (f10 != null) {
                interfaceC1266m.m(f10);
                return true;
            }
            return false;
        }
        if (obj instanceof F9.b) {
            return ((F9.b) obj).b(this, q.f35511a);
        }
        throw new IllegalStateException(("unexpected: " + obj).toString());
    }

    public final boolean k() {
        int i10;
        Object c10;
        int i11;
        C c11;
        C c12;
        int i12;
        C c13;
        C c14;
        C c15;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34616c;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f34617d.getAndIncrement(this);
        i10 = c.f34632f;
        long j10 = andIncrement / i10;
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.f34624a;
        loop0: while (true) {
            c10 = C1253d.c(dVar, j10, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (A.c(c10)) {
                break;
            }
            z b10 = A.b(c10);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.f34541c >= b10.f34541c) {
                    break loop0;
                }
                if (!b10.q()) {
                    break;
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, b10)) {
                    if (zVar.m()) {
                        zVar.k();
                    }
                } else if (b10.m()) {
                    b10.k();
                }
            }
        }
        d dVar2 = (d) A.b(c10);
        dVar2.b();
        if (dVar2.f34541c <= j10) {
            i11 = c.f34632f;
            int i13 = (int) (andIncrement % i11);
            c11 = c.f34628b;
            Object andSet = dVar2.r().getAndSet(i13, c11);
            if (andSet == null) {
                i12 = c.f34627a;
                for (int i14 = 0; i14 < i12; i14++) {
                    Object obj = dVar2.r().get(i13);
                    c15 = c.f34629c;
                    if (obj == c15) {
                        return true;
                    }
                }
                c13 = c.f34628b;
                c14 = c.f34630d;
                return !dVar2.r().compareAndSet(i13, c13, c14);
            }
            c12 = c.f34631e;
            if (andSet == c12) {
                return false;
            }
            return j(andSet);
        }
        return false;
    }
}
