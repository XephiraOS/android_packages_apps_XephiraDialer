package com.heytap.epona;

import C5.e;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Route.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f25439a = 64;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f25440b = e();

    /* renamed from: c, reason: collision with root package name */
    public ArrayDeque<e.b> f25441c = new ArrayDeque<>();

    /* renamed from: d, reason: collision with root package name */
    public ArrayDeque<e.b> f25442d = new ArrayDeque<>();

    public static /* synthetic */ Thread h(String str, Boolean bool, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(bool.booleanValue());
        return thread;
    }

    public synchronized void b(e.b bVar) {
        try {
            if (this.f25442d.size() < 64) {
                this.f25442d.add(bVar);
                this.f25440b.execute(bVar);
            } else {
                this.f25441c.add(bVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final ThreadFactory c(final String str, final Boolean bool) {
        return new ThreadFactory() { // from class: com.heytap.epona.f
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread h10;
                h10 = g.h(str, bool, runnable);
                return h10;
            }
        };
    }

    public final synchronized ExecutorService e() {
        try {
            if (this.f25440b == null) {
                this.f25440b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c("Epona Route", Boolean.FALSE));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f25440b;
    }

    public void f(e.b bVar, boolean z10) {
        synchronized (this) {
            try {
                this.f25442d.remove(bVar);
                if (!z10) {
                    this.f25441c.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        j();
    }

    public C5.e i(Request request) {
        return C5.e.e(this, request);
    }

    public final synchronized void j() {
        if (this.f25442d.size() >= 64) {
            return;
        }
        if (this.f25441c.isEmpty()) {
            return;
        }
        Iterator<e.b> it = this.f25441c.iterator();
        while (it.hasNext()) {
            e.b next = it.next();
            this.f25442d.add(next);
            this.f25440b.execute(next);
            this.f25441c.remove(next);
            if (this.f25442d.size() >= 64) {
                return;
            }
        }
    }

    public void d(C5.e eVar) {
    }

    public void g(C5.e eVar) {
    }
}
