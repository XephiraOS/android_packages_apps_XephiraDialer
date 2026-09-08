package kotlinx.coroutines;

import kotlin.collections.C1224e;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public abstract class W extends CoroutineDispatcher {

    /* renamed from: c, reason: collision with root package name */
    public long f34342c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f34343d;

    /* renamed from: e, reason: collision with root package name */
    public C1224e<O<?>> f34344e;

    public static /* synthetic */ void j0(W w10, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            w10.i0(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public static /* synthetic */ void r0(W w10, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            w10.q0(z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void i0(boolean z10) {
        long l02 = this.f34342c - l0(z10);
        this.f34342c = l02;
        if (l02 <= 0 && this.f34343d) {
            shutdown();
        }
    }

    public final long l0(boolean z10) {
        if (z10) {
            return 4294967296L;
        }
        return 1L;
    }

    public final void m0(O<?> o10) {
        C1224e<O<?>> c1224e = this.f34344e;
        if (c1224e == null) {
            c1224e = new C1224e<>();
            this.f34344e = c1224e;
        }
        c1224e.addLast(o10);
    }

    public long o0() {
        C1224e<O<?>> c1224e = this.f34344e;
        if (c1224e == null || c1224e.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final void q0(boolean z10) {
        this.f34342c += l0(z10);
        if (!z10) {
            this.f34343d = true;
        }
    }

    public final boolean s0() {
        if (this.f34342c >= l0(true)) {
            return true;
        }
        return false;
    }

    public final boolean t0() {
        C1224e<O<?>> c1224e = this.f34344e;
        if (c1224e != null) {
            return c1224e.isEmpty();
        }
        return true;
    }

    public long u0() {
        if (!v0()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean v0() {
        O<?> m10;
        C1224e<O<?>> c1224e = this.f34344e;
        if (c1224e == null || (m10 = c1224e.m()) == null) {
            return false;
        }
        m10.run();
        return true;
    }

    public boolean w0() {
        return false;
    }

    public void shutdown() {
    }
}
