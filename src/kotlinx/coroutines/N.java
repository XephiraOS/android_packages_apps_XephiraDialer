package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.internal.C1259j;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public final class N<T> extends kotlinx.coroutines.internal.y<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f34328e = AtomicIntegerFieldUpdater.newUpdater(N.class, "_decision");
    private volatile int _decision;

    public N(CoroutineContext coroutineContext, kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    private final boolean O0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34328e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f34328e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean P0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f34328e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f34328e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.AbstractC1232a
    public void J0(Object obj) {
        kotlin.coroutines.c b10;
        if (!O0()) {
            b10 = IntrinsicsKt__IntrinsicsJvmKt.b(this.f34539d);
            C1259j.c(b10, A.a(obj, this.f34539d), null, 2, null);
        }
    }

    public final Object N0() {
        Object c10;
        if (P0()) {
            c10 = kotlin.coroutines.intrinsics.b.c();
            return c10;
        }
        Object h10 = t0.h(d0());
        if (!(h10 instanceof C1282x)) {
            return h10;
        }
        throw ((C1282x) h10).f34650a;
    }

    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.s0
    public void v(Object obj) {
        J0(obj);
    }
}
