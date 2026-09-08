package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.engine.h;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import s3.C1540k;

/* compiled from: ActiveResources.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f19495a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f19496b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<X2.b, c> f19497c;

    /* renamed from: d, reason: collision with root package name */
    public final ReferenceQueue<h<?>> f19498d;

    /* renamed from: e, reason: collision with root package name */
    public h.a f19499e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f19500f;

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ThreadFactoryC0190a implements ThreadFactory {

        /* compiled from: ActiveResources.java */
        /* renamed from: com.bumptech.glide.load.engine.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0191a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f19501a;

            public RunnableC0191a(Runnable runnable) {
                this.f19501a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f19501a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0191a(runnable), "glide-active-resources");
        }
    }

    /* compiled from: ActiveResources.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* compiled from: ActiveResources.java */
    /* loaded from: classes.dex */
    public static final class c extends WeakReference<h<?>> {

        /* renamed from: a, reason: collision with root package name */
        public final X2.b f19504a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f19505b;

        /* renamed from: c, reason: collision with root package name */
        public Z2.j<?> f19506c;

        public c(X2.b bVar, h<?> hVar, ReferenceQueue<? super h<?>> referenceQueue, boolean z10) {
            super(hVar, referenceQueue);
            Z2.j<?> jVar;
            this.f19504a = (X2.b) C1540k.d(bVar);
            if (hVar.f() && z10) {
                jVar = (Z2.j) C1540k.d(hVar.e());
            } else {
                jVar = null;
            }
            this.f19506c = jVar;
            this.f19505b = hVar.f();
        }

        public void a() {
            this.f19506c = null;
            clear();
        }
    }

    public a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new ThreadFactoryC0190a()));
    }

    public synchronized void a(X2.b bVar, h<?> hVar) {
        c put = this.f19497c.put(bVar, new c(bVar, hVar, this.f19498d, this.f19495a));
        if (put != null) {
            put.a();
        }
    }

    public void b() {
        while (!this.f19500f) {
            try {
                c((c) this.f19498d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void c(c cVar) {
        Z2.j<?> jVar;
        synchronized (this) {
            this.f19497c.remove(cVar.f19504a);
            if (cVar.f19505b && (jVar = cVar.f19506c) != null) {
                this.f19499e.d(cVar.f19504a, new h<>(jVar, true, false, cVar.f19504a, this.f19499e));
            }
        }
    }

    public synchronized void d(X2.b bVar) {
        c remove = this.f19497c.remove(bVar);
        if (remove != null) {
            remove.a();
        }
    }

    public synchronized h<?> e(X2.b bVar) {
        c cVar = this.f19497c.get(bVar);
        if (cVar == null) {
            return null;
        }
        h<?> hVar = cVar.get();
        if (hVar == null) {
            c(cVar);
        }
        return hVar;
    }

    public void f(h.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f19499e = aVar;
            }
        }
    }

    public a(boolean z10, Executor executor) {
        this.f19497c = new HashMap();
        this.f19498d = new ReferenceQueue<>();
        this.f19495a = z10;
        this.f19496b = executor;
        executor.execute(new b());
    }
}
