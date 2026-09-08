package io.grpc.internal;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: SerializingExecutor.java */
/* loaded from: classes4.dex */
public final class h0 implements Executor, Runnable {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f33180d = Logger.getLogger(h0.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final b f33181e = c();

    /* renamed from: a, reason: collision with root package name */
    public Executor f33182a;

    /* renamed from: b, reason: collision with root package name */
    public final Queue<Runnable> f33183b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    public volatile int f33184c = 0;

    /* compiled from: SerializingExecutor.java */
    /* loaded from: classes4.dex */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(h0 h0Var, int i10, int i11);

        public abstract void b(h0 h0Var, int i10);
    }

    /* compiled from: SerializingExecutor.java */
    /* loaded from: classes4.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<h0> f33185a;

        @Override // io.grpc.internal.h0.b
        public boolean a(h0 h0Var, int i10, int i11) {
            return this.f33185a.compareAndSet(h0Var, i10, i11);
        }

        @Override // io.grpc.internal.h0.b
        public void b(h0 h0Var, int i10) {
            this.f33185a.set(h0Var, i10);
        }

        public c(AtomicIntegerFieldUpdater<h0> atomicIntegerFieldUpdater) {
            super();
            this.f33185a = atomicIntegerFieldUpdater;
        }
    }

    /* compiled from: SerializingExecutor.java */
    /* loaded from: classes4.dex */
    public static final class d extends b {
        public d() {
            super();
        }

        @Override // io.grpc.internal.h0.b
        public boolean a(h0 h0Var, int i10, int i11) {
            synchronized (h0Var) {
                try {
                    if (h0Var.f33184c == i10) {
                        h0Var.f33184c = i11;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.internal.h0.b
        public void b(h0 h0Var, int i10) {
            synchronized (h0Var) {
                h0Var.f33184c = i10;
            }
        }
    }

    public h0(Executor executor) {
        com.google.common.base.k.p(executor, "'executor' must not be null.");
        this.f33182a = executor;
    }

    public static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(h0.class, "c"));
        } catch (Throwable th) {
            f33180d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new d();
        }
    }

    public final void d(Runnable runnable) {
        if (f33181e.a(this, 0, -1)) {
            try {
                this.f33182a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f33183b.remove(runnable);
                }
                f33181e.b(this, 0);
                throw th;
            }
        }
    }

    public void e(Executor executor) {
        com.google.common.base.k.p(executor, "'executor' must not be null.");
        this.f33182a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f33183b.add((Runnable) com.google.common.base.k.p(runnable, "'r' must not be null."));
        d(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable poll;
        try {
            Executor executor = this.f33182a;
            while (executor == this.f33182a && (poll = this.f33183b.poll()) != null) {
                try {
                    poll.run();
                } catch (RuntimeException e10) {
                    f33180d.log(Level.SEVERE, "Exception while executing runnable " + poll, (Throwable) e10);
                }
            }
            f33181e.b(this, 0);
            if (!this.f33183b.isEmpty()) {
                d(null);
            }
        } catch (Throwable th) {
            f33181e.b(this, 0);
            throw th;
        }
    }
}
