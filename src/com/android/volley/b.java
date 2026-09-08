package com.android.volley;

import S2.g;
import android.os.Process;
import com.android.volley.a;
import java.util.concurrent.BlockingQueue;

/* compiled from: CacheDispatcher.java */
/* loaded from: classes.dex */
public class b extends Thread {

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f19233g = e.f19252b;

    /* renamed from: a, reason: collision with root package name */
    public final BlockingQueue<Request<?>> f19234a;

    /* renamed from: b, reason: collision with root package name */
    public final BlockingQueue<Request<?>> f19235b;

    /* renamed from: c, reason: collision with root package name */
    public final com.android.volley.a f19236c;

    /* renamed from: d, reason: collision with root package name */
    public final g f19237d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f19238e = false;

    /* renamed from: f, reason: collision with root package name */
    public final f f19239f;

    /* compiled from: CacheDispatcher.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Request f19240a;

        public a(Request request) {
            this.f19240a = request;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.f19235b.put(this.f19240a);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public b(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.android.volley.a aVar, g gVar) {
        this.f19234a = blockingQueue;
        this.f19235b = blockingQueue2;
        this.f19236c = aVar;
        this.f19237d = gVar;
        this.f19239f = new f(this, blockingQueue2, gVar);
    }

    private void b() {
        c(this.f19234a.take());
    }

    public void c(Request<?> request) {
        request.b("cache-queue-take");
        request.G(1);
        try {
            if (request.A()) {
                request.i("cache-discard-canceled");
                return;
            }
            a.C0186a d10 = this.f19236c.d(request.m());
            if (d10 == null) {
                request.b("cache-miss");
                if (!this.f19239f.c(request)) {
                    this.f19235b.put(request);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (d10.b(currentTimeMillis)) {
                request.b("cache-hit-expired");
                request.H(d10);
                if (!this.f19239f.c(request)) {
                    this.f19235b.put(request);
                }
                return;
            }
            request.b("cache-hit");
            d<?> F10 = request.F(new S2.e(d10.f19225a, d10.f19231g));
            request.b("cache-hit-parsed");
            if (!F10.b()) {
                request.b("cache-parsing-failed");
                this.f19236c.b(request.m(), true);
                request.H(null);
                if (!this.f19239f.c(request)) {
                    this.f19235b.put(request);
                }
                return;
            }
            if (!d10.c(currentTimeMillis)) {
                this.f19237d.a(request, F10);
            } else {
                request.b("cache-hit-refresh-needed");
                request.H(d10);
                F10.f19250d = true;
                if (!this.f19239f.c(request)) {
                    this.f19237d.b(request, F10, new a(request));
                } else {
                    this.f19237d.a(request, F10);
                }
            }
        } finally {
            request.G(2);
        }
    }

    public void d() {
        this.f19238e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f19233g) {
            e.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f19236c.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f19238e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                e.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
