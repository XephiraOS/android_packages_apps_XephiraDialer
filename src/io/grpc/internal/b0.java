package io.grpc.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Rescheduler.java */
/* loaded from: classes4.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f33021a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f33022b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f33023c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.common.base.m f33024d;

    /* renamed from: e, reason: collision with root package name */
    public long f33025e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f33026f;

    /* renamed from: g, reason: collision with root package name */
    public ScheduledFuture<?> f33027g;

    /* compiled from: Rescheduler.java */
    /* loaded from: classes4.dex */
    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b0.this.f33026f) {
                b0.this.f33027g = null;
                return;
            }
            long j10 = b0.this.j();
            if (b0.this.f33025e - j10 <= 0) {
                b0.this.f33026f = false;
                b0.this.f33027g = null;
                b0.this.f33023c.run();
            } else {
                b0 b0Var = b0.this;
                b0Var.f33027g = b0Var.f33021a.schedule(new c(), b0.this.f33025e - j10, TimeUnit.NANOSECONDS);
            }
        }
    }

    /* compiled from: Rescheduler.java */
    /* loaded from: classes4.dex */
    public final class c implements Runnable {
        public c() {
        }

        public final boolean b() {
            return b0.this.f33026f;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f33022b.execute(new b());
        }
    }

    public b0(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, com.google.common.base.m mVar) {
        this.f33023c = runnable;
        this.f33022b = executor;
        this.f33021a = scheduledExecutorService;
        this.f33024d = mVar;
        mVar.g();
    }

    public static boolean isEnabled(Runnable runnable) {
        return ((c) runnable).b();
    }

    public void i(boolean z10) {
        ScheduledFuture<?> scheduledFuture;
        this.f33026f = false;
        if (z10 && (scheduledFuture = this.f33027g) != null) {
            scheduledFuture.cancel(false);
            this.f33027g = null;
        }
    }

    public final long j() {
        return this.f33024d.d(TimeUnit.NANOSECONDS);
    }

    public void k(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        long j11 = j() + nanos;
        this.f33026f = true;
        if (j11 - this.f33025e < 0 || this.f33027g == null) {
            ScheduledFuture<?> scheduledFuture = this.f33027g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f33027g = this.f33021a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f33025e = j11;
    }
}
