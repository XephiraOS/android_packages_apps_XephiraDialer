package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.z0;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes4.dex */
public abstract class z<S extends z<S>> extends AbstractC1254e<S> implements z0 {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34540d = AtomicIntegerFieldUpdater.newUpdater(z.class, "cleanedAndPointers");

    /* renamed from: c, reason: collision with root package name */
    public final long f34541c;
    private volatile int cleanedAndPointers;

    public z(long j10, S s10, int i10) {
        super(s10);
        this.f34541c = j10;
        this.cleanedAndPointers = i10 << 16;
    }

    @Override // kotlinx.coroutines.internal.AbstractC1254e
    public boolean h() {
        if (f34540d.get(this) == n() && !i()) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        if (f34540d.addAndGet(this, -65536) == n() && !i()) {
            return true;
        }
        return false;
    }

    public abstract int n();

    public abstract void o(int i10, Throwable th, CoroutineContext coroutineContext);

    public final void p() {
        if (f34540d.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34540d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 == n() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
