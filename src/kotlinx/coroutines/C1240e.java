package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.kt */
/* renamed from: kotlinx.coroutines.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1240e<T> extends AbstractC1232a<T> {

    /* renamed from: d, reason: collision with root package name */
    public final Thread f34420d;

    /* renamed from: e, reason: collision with root package name */
    public final W f34421e;

    public C1240e(CoroutineContext coroutineContext, Thread thread, W w10) {
        super(coroutineContext, true, true);
        this.f34420d = thread;
        this.f34421e = w10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T N0() {
        long j10;
        C1236c.a();
        try {
            W w10 = this.f34421e;
            C1282x c1282x = null;
            if (w10 != null) {
                W.r0(w10, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    W w11 = this.f34421e;
                    if (w11 != null) {
                        j10 = w11.u0();
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (!X()) {
                        C1236c.a();
                        LockSupport.parkNanos(this, j10);
                    } else {
                        W w12 = this.f34421e;
                        if (w12 != null) {
                            W.j0(w12, false, 1, null);
                        }
                        C1236c.a();
                        T t10 = (T) t0.h(d0());
                        if (t10 instanceof C1282x) {
                            c1282x = (C1282x) t10;
                        }
                        if (c1282x == null) {
                            return t10;
                        }
                        throw c1282x.f34650a;
                    }
                } catch (Throwable th) {
                    W w13 = this.f34421e;
                    if (w13 != null) {
                        W.j0(w13, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            z(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            C1236c.a();
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.s0
    public boolean i0() {
        return true;
    }

    @Override // kotlinx.coroutines.s0
    public void v(Object obj) {
        if (!kotlin.jvm.internal.i.b(Thread.currentThread(), this.f34420d)) {
            Thread thread = this.f34420d;
            C1236c.a();
            LockSupport.unpark(thread);
        }
    }
}
