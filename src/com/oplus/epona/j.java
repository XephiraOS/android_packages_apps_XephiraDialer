package com.oplus.epona;

import f7.f;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Route.java */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f28175a = 64;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f28176b = e();

    /* renamed from: c, reason: collision with root package name */
    public ArrayDeque<f.b> f28177c = new ArrayDeque<>();

    /* renamed from: d, reason: collision with root package name */
    public ArrayDeque<f.b> f28178d = new ArrayDeque<>();

    public static /* synthetic */ Thread h(String str, Boolean bool, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(bool.booleanValue());
        return thread;
    }

    public synchronized void b(f.b bVar) {
        try {
            if (this.f28178d.size() < 64) {
                this.f28178d.add(bVar);
                this.f28176b.execute(bVar);
            } else {
                this.f28177c.add(bVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final ThreadFactory c(final String str, final Boolean bool) {
        return new ThreadFactory() { // from class: com.oplus.epona.i
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread h10;
                h10 = j.h(str, bool, runnable);
                return h10;
            }
        };
    }

    public final synchronized ExecutorService e() {
        try {
            if (this.f28176b == null) {
                this.f28176b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c("Epona Route", Boolean.FALSE));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f28176b;
    }

    public void f(f.b bVar, boolean z10) {
        synchronized (this) {
            try {
                this.f28178d.remove(bVar);
                if (!z10) {
                    this.f28177c.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        j();
    }

    public f7.f i(Request request) {
        return f7.f.e(this, request);
    }

    public final synchronized void j() {
        if (this.f28178d.size() >= 64) {
            return;
        }
        if (this.f28177c.isEmpty()) {
            return;
        }
        Iterator<f.b> it = this.f28177c.iterator();
        while (it.hasNext()) {
            f.b next = it.next();
            this.f28178d.add(next);
            this.f28176b.execute(next);
            this.f28177c.remove(next);
            if (this.f28178d.size() >= 64) {
                return;
            }
        }
    }

    public void d(f7.f fVar) {
    }

    public void g(f7.f fVar) {
    }
}
