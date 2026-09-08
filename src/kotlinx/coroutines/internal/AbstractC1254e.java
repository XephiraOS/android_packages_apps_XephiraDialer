package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.AbstractC1254e;

/* compiled from: ConcurrentLinkedList.kt */
/* renamed from: kotlinx.coroutines.internal.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1254e<N extends AbstractC1254e<N>> {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34506a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1254e.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34507b = AtomicReferenceFieldUpdater.newUpdater(AbstractC1254e.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public AbstractC1254e(N n10) {
        this._prev = n10;
    }

    public final void b() {
        f34507b.lazySet(this, null);
    }

    public final N c() {
        N g10 = g();
        while (g10 != null && g10.h()) {
            g10 = (N) f34507b.get(g10);
        }
        return g10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.e] */
    public final N d() {
        N e10 = e();
        kotlin.jvm.internal.i.c(e10);
        while (e10.h()) {
            ?? e11 = e10.e();
            if (e11 == 0) {
                return e10;
            }
            e10 = e11;
        }
        return e10;
    }

    public final N e() {
        Object f10 = f();
        if (f10 == C1253d.a()) {
            return null;
        }
        return (N) f10;
    }

    public final Object f() {
        return f34506a.get(this);
    }

    public final N g() {
        return (N) f34507b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        if (e() == null) {
            return true;
        }
        return false;
    }

    public final boolean j() {
        return f34506a.compareAndSet(this, null, C1253d.a());
    }

    public final void k() {
        Object obj;
        N n10;
        if (i()) {
            return;
        }
        while (true) {
            N c10 = c();
            N d10 = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34507b;
            do {
                obj = atomicReferenceFieldUpdater.get(d10);
                if (((AbstractC1254e) obj) == null) {
                    n10 = null;
                } else {
                    n10 = c10;
                }
            } while (!atomicReferenceFieldUpdater.compareAndSet(d10, obj, n10));
            if (c10 != null) {
                f34506a.set(c10, d10);
            }
            if (!d10.h() || d10.i()) {
                if (c10 == null || !c10.h()) {
                    return;
                }
            }
        }
    }

    public final boolean l(N n10) {
        return f34506a.compareAndSet(this, null, n10);
    }
}
