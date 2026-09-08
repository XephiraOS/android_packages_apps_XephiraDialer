package j9;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SynchronizationContext.java */
/* loaded from: classes4.dex */
public final class N implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f34000a;

    /* renamed from: b, reason: collision with root package name */
    public final Queue<Runnable> f34001b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference<Thread> f34002c = new AtomicReference<>();

    /* compiled from: SynchronizationContext.java */
    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f34003a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f34004b;

        public a(c cVar, Runnable runnable) {
            this.f34003a = cVar;
            this.f34004b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            N.this.execute(this.f34003a);
        }

        public String toString() {
            return this.f34004b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    /* compiled from: SynchronizationContext.java */
    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f34006a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f34007b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f34008c;

        public b(c cVar, Runnable runnable, long j10) {
            this.f34006a = cVar;
            this.f34007b = runnable;
            this.f34008c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            N.this.execute(this.f34006a);
        }

        public String toString() {
            return this.f34007b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f34008c + ")";
        }
    }

    /* compiled from: SynchronizationContext.java */
    /* loaded from: classes4.dex */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f34010a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f34011b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f34012c;

        public c(Runnable runnable) {
            this.f34010a = (Runnable) com.google.common.base.k.p(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f34011b) {
                this.f34012c = true;
                this.f34010a.run();
            }
        }
    }

    /* compiled from: SynchronizationContext.java */
    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final c f34013a;

        /* renamed from: b, reason: collision with root package name */
        public final ScheduledFuture<?> f34014b;

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f34013a.f34011b = true;
            this.f34014b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f34013a;
            if (!cVar.f34012c && !cVar.f34011b) {
                return true;
            }
            return false;
        }

        public d(c cVar, ScheduledFuture<?> scheduledFuture) {
            this.f34013a = (c) com.google.common.base.k.p(cVar, "runnable");
            this.f34014b = (ScheduledFuture) com.google.common.base.k.p(scheduledFuture, "future");
        }
    }

    public N(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f34000a = (Thread.UncaughtExceptionHandler) com.google.common.base.k.p(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (this.f34002c.compareAndSet(null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable poll = this.f34001b.poll();
                    if (poll == null) {
                        break;
                    }
                    try {
                        poll.run();
                    } catch (Throwable th) {
                        this.f34000a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.f34002c.set(null);
                    throw th2;
                }
            }
            this.f34002c.set(null);
            if (this.f34001b.isEmpty()) {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f34001b.add((Runnable) com.google.common.base.k.p(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j10, timeUnit), null);
    }

    public final d d(Runnable runnable, long j10, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j11), j10, j11, timeUnit), null);
    }

    public void e() {
        boolean z10;
        if (Thread.currentThread() == this.f34002c.get()) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
