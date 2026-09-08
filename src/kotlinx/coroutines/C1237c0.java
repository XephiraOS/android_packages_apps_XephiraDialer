package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C1252c;

/* compiled from: Executors.kt */
/* renamed from: kotlinx.coroutines.c0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1237c0 extends ExecutorCoroutineDispatcher implements L {

    /* renamed from: d, reason: collision with root package name */
    public final Executor f34363d;

    public C1237c0(Executor executor) {
        this.f34363d = executor;
        C1252c.a(j0());
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ExecutorService executorService;
        Executor j02 = j0();
        if (j02 instanceof ExecutorService) {
            executorService = (ExecutorService) j02;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof C1237c0) && ((C1237c0) obj).j0() == j0()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void f0(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor j02 = j0();
            C1236c.a();
            j02.execute(runnable);
        } catch (RejectedExecutionException e10) {
            C1236c.a();
            i0(coroutineContext, e10);
            S.b().f0(coroutineContext, runnable);
        }
    }

    public int hashCode() {
        return System.identityHashCode(j0());
    }

    public final void i0(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        C1271o0.c(coroutineContext, C1235b0.a("The task was rejected", rejectedExecutionException));
    }

    public Executor j0() {
        return this.f34363d;
    }

    public final ScheduledFuture<?> l0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            this.i0(coroutineContext, e10);
            return null;
        }
    }

    @Override // kotlinx.coroutines.L
    public void s(long j10, InterfaceC1266m<? super m9.q> interfaceC1266m) {
        ScheduledExecutorService scheduledExecutorService;
        Executor j02 = j0();
        ScheduledFuture<?> scheduledFuture = null;
        if (j02 instanceof ScheduledExecutorService) {
            scheduledExecutorService = (ScheduledExecutorService) j02;
        } else {
            scheduledExecutorService = null;
        }
        if (scheduledExecutorService != null) {
            scheduledFuture = l0(scheduledExecutorService, new D0(this, interfaceC1266m), interfaceC1266m.getContext(), j10);
        }
        if (scheduledFuture != null) {
            C1271o0.e(interfaceC1266m, scheduledFuture);
        } else {
            H.f34318i.s(j10, interfaceC1266m);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return j0().toString();
    }
}
