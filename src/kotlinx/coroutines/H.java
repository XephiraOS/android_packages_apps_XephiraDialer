package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.X;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes4.dex */
public final class H extends X implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: i, reason: collision with root package name */
    public static final H f34318i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f34319j;

    static {
        Long l10;
        H h10 = new H();
        f34318i = h10;
        W.r0(h10, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f34319j = timeUnit.toNanos(l10.longValue());
    }

    @Override // kotlinx.coroutines.X
    public void D0(Runnable runnable) {
        if (O0()) {
            R0();
        }
        super.D0(runnable);
    }

    public final synchronized void M0() {
        if (!P0()) {
            return;
        }
        debugStatus = 3;
        H0();
        kotlin.jvm.internal.i.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
    }

    public final synchronized Thread N0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean O0() {
        if (debugStatus == 4) {
            return true;
        }
        return false;
    }

    public final boolean P0() {
        int i10 = debugStatus;
        if (i10 != 2 && i10 != 3) {
            return false;
        }
        return true;
    }

    public final synchronized boolean Q0() {
        if (P0()) {
            return false;
        }
        debugStatus = 1;
        kotlin.jvm.internal.i.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void R0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean F02;
        I0.f34322a.d(this);
        C1236c.a();
        try {
            if (!Q0()) {
                if (!F02) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long u02 = u0();
                if (u02 == Long.MAX_VALUE) {
                    C1236c.a();
                    long nanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f34319j + nanoTime;
                    }
                    long j11 = j10 - nanoTime;
                    if (j11 > 0) {
                        u02 = B9.i.f(u02, j11);
                    } else {
                        _thread = null;
                        M0();
                        C1236c.a();
                        if (!F0()) {
                            x0();
                            return;
                        }
                        return;
                    }
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (u02 > 0) {
                    if (P0()) {
                        _thread = null;
                        M0();
                        C1236c.a();
                        if (!F0()) {
                            x0();
                            return;
                        }
                        return;
                    }
                    C1236c.a();
                    LockSupport.parkNanos(this, u02);
                }
            }
        } finally {
            _thread = null;
            M0();
            C1236c.a();
            if (!F0()) {
                x0();
            }
        }
    }

    @Override // kotlinx.coroutines.X, kotlinx.coroutines.W
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.Y
    public Thread x0() {
        Thread thread = _thread;
        if (thread == null) {
            return N0();
        }
        return thread;
    }

    @Override // kotlinx.coroutines.Y
    public void y0(long j10, X.b bVar) {
        R0();
    }
}
