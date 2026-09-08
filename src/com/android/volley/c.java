package com.android.volley;

import S2.g;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: NetworkDispatcher.java */
/* loaded from: classes.dex */
public class c extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final BlockingQueue<Request<?>> f19242a;

    /* renamed from: b, reason: collision with root package name */
    public final S2.d f19243b;

    /* renamed from: c, reason: collision with root package name */
    public final a f19244c;

    /* renamed from: d, reason: collision with root package name */
    public final g f19245d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f19246e = false;

    public c(BlockingQueue<Request<?>> blockingQueue, S2.d dVar, a aVar, g gVar) {
        this.f19242a = blockingQueue;
        this.f19243b = dVar;
        this.f19244c = aVar;
        this.f19245d = gVar;
    }

    private void c() {
        d(this.f19242a.take());
    }

    public final void a(Request<?> request) {
        TrafficStats.setThreadStatsTag(request.x());
    }

    public final void b(Request<?> request, VolleyError volleyError) {
        this.f19245d.c(request, request.E(volleyError));
    }

    public void d(Request<?> request) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        request.G(3);
        try {
            try {
                try {
                    request.b("network-queue-take");
                } catch (VolleyError e10) {
                    e10.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    b(request, e10);
                    request.C();
                }
            } catch (Exception e11) {
                e.d(e11, "Unhandled exception %s", e11.toString());
                VolleyError volleyError = new VolleyError(e11);
                volleyError.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f19245d.c(request, volleyError);
                request.C();
            }
            if (request.A()) {
                request.i("network-discard-cancelled");
                request.C();
                return;
            }
            a(request);
            S2.e a10 = this.f19243b.a(request);
            request.b("network-http-complete");
            if (a10.f3394e && request.z()) {
                request.i("not-modified");
                request.C();
                return;
            }
            d<?> F10 = request.F(a10);
            request.b("network-parse-complete");
            if (request.M() && F10.f19248b != null) {
                this.f19244c.c(request.m(), F10.f19248b);
                request.b("network-cache-written");
            }
            request.B();
            this.f19245d.a(request, F10);
            request.D(F10);
        } finally {
            request.G(4);
        }
    }

    public void e() {
        this.f19246e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                c();
            } catch (InterruptedException unused) {
                if (this.f19246e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                e.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
