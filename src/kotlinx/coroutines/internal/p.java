package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes4.dex */
public class p<E> {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34526a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur");
    private volatile Object _cur;

    public p(boolean z10) {
        this._cur = new q(8, z10);
    }

    public final boolean a(E e10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34526a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            int a10 = qVar.a(e10);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                if (a10 == 2) {
                    return false;
                }
            } else {
                f34526a.compareAndSet(this, qVar, qVar.i());
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34526a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (qVar.d()) {
                return;
            } else {
                f34526a.compareAndSet(this, qVar, qVar.i());
            }
        }
    }

    public final int c() {
        return ((q) f34526a.get(this)).f();
    }

    public final E d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34526a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            E e10 = (E) qVar.j();
            if (e10 != q.f34530h) {
                return e10;
            }
            f34526a.compareAndSet(this, qVar, qVar.i());
        }
    }
}
