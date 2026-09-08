package E9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: WorkQueue.kt */
/* loaded from: classes4.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f765b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f766c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f767d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f768e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<g> f769a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final g a(g gVar, boolean z10) {
        if (z10) {
            return b(gVar);
        }
        g gVar2 = (g) f765b.getAndSet(this, gVar);
        if (gVar2 == null) {
            return null;
        }
        return b(gVar2);
    }

    public final g b(g gVar) {
        if (d() == 127) {
            return gVar;
        }
        if (gVar.f753b.b() == 1) {
            f768e.incrementAndGet(this);
        }
        int i10 = f766c.get(this) & 127;
        while (this.f769a.get(i10) != null) {
            Thread.yield();
        }
        this.f769a.lazySet(i10, gVar);
        f766c.incrementAndGet(this);
        return null;
    }

    public final void c(g gVar) {
        if (gVar != null && gVar.f753b.b() == 1) {
            f768e.decrementAndGet(this);
        }
    }

    public final int d() {
        return f766c.get(this) - f767d.get(this);
    }

    public final int e() {
        Object obj = f765b.get(this);
        int d10 = d();
        if (obj != null) {
            return d10 + 1;
        }
        return d10;
    }

    public final void f(c cVar) {
        g gVar = (g) f765b.getAndSet(this, null);
        if (gVar != null) {
            cVar.a(gVar);
        }
        do {
        } while (j(cVar));
    }

    public final g g() {
        g gVar = (g) f765b.getAndSet(this, null);
        if (gVar == null) {
            return i();
        }
        return gVar;
    }

    public final g h() {
        return k(true);
    }

    public final g i() {
        g andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f767d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f766c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (andSet = this.f769a.getAndSet(i11, null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    public final boolean j(c cVar) {
        g i10 = i();
        if (i10 == null) {
            return false;
        }
        cVar.a(i10);
        return true;
    }

    public final g k(boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        g gVar;
        do {
            atomicReferenceFieldUpdater = f765b;
            gVar = (g) atomicReferenceFieldUpdater.get(this);
            if (gVar != null) {
                boolean z11 = true;
                if (gVar.f753b.b() != 1) {
                    z11 = false;
                }
                if (z11 == z10) {
                }
            }
            int i10 = f767d.get(this);
            int i11 = f766c.get(this);
            while (i10 != i11) {
                if (z10 && f768e.get(this) == 0) {
                    return null;
                }
                i11--;
                g m10 = m(i11, z10);
                if (m10 != null) {
                    return m10;
                }
            }
            return null;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, gVar, null));
        return gVar;
    }

    public final g l(int i10) {
        int i11 = f767d.get(this);
        int i12 = f766c.get(this);
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        while (i11 != i12) {
            if (z10 && f768e.get(this) == 0) {
                return null;
            }
            int i13 = i11 + 1;
            g m10 = m(i11, z10);
            if (m10 == null) {
                i11 = i13;
            } else {
                return m10;
            }
        }
        return null;
    }

    public final g m(int i10, boolean z10) {
        int i11 = i10 & 127;
        g gVar = this.f769a.get(i11);
        if (gVar != null) {
            boolean z11 = true;
            if (gVar.f753b.b() != 1) {
                z11 = false;
            }
            if (z11 == z10 && this.f769a.compareAndSet(i11, gVar, null)) {
                if (z10) {
                    f768e.decrementAndGet(this);
                }
                return gVar;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long n(int i10, Ref$ObjectRef<g> ref$ObjectRef) {
        T t10;
        if (i10 == 3) {
            t10 = i();
        } else {
            t10 = l(i10);
        }
        if (t10 != 0) {
            ref$ObjectRef.element = t10;
            return -1L;
        }
        return o(i10, ref$ObjectRef);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, E9.g] */
    public final long o(int i10, Ref$ObjectRef<g> ref$ObjectRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r12;
        do {
            atomicReferenceFieldUpdater = f765b;
            r12 = (g) atomicReferenceFieldUpdater.get(this);
            if (r12 == 0) {
                return -2L;
            }
            int i11 = 1;
            if (r12.f753b.b() != 1) {
                i11 = 2;
            }
            if ((i11 & i10) == 0) {
                return -2L;
            }
            long a10 = k.f761f.a() - r12.f752a;
            long j10 = k.f757b;
            if (a10 < j10) {
                return j10 - a10;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, r12, null));
        ref$ObjectRef.element = r12;
        return -1L;
    }
}
