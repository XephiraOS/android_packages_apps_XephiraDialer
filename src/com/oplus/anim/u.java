package com.oplus.anim;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: EffectiveAnimationTask.java */
/* loaded from: classes3.dex */
public class u<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final Executor f26202e = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    public final Set<InterfaceC0836q<T>> f26203a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<InterfaceC0836q<Throwable>> f26204b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f26205c;

    /* renamed from: d, reason: collision with root package name */
    public volatile C0837s<T> f26206d;

    /* compiled from: EffectiveAnimationTask.java */
    /* loaded from: classes3.dex */
    public class a extends FutureTask<C0837s<T>> {
        public a(Callable<C0837s<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (!isCancelled()) {
                try {
                    u.this.k(get());
                } catch (InterruptedException | ExecutionException e10) {
                    u.this.k(new C0837s(e10));
                }
            }
        }
    }

    public u(Callable<C0837s<T>> callable) {
        this(callable, false);
    }

    public synchronized u<T> c(InterfaceC0836q<Throwable> interfaceC0836q) {
        try {
            C0837s<T> c0837s = this.f26206d;
            if (c0837s != null && c0837s.a() != null) {
                interfaceC0836q.a(c0837s.a());
            }
            this.f26204b.add(interfaceC0836q);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized u<T> d(InterfaceC0836q<T> interfaceC0836q) {
        try {
            C0837s<T> c0837s = this.f26206d;
            if (c0837s != null && c0837s.b() != null) {
                interfaceC0836q.a(c0837s.b());
            }
            this.f26203a.add(interfaceC0836q);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final /* synthetic */ void e() {
        C0837s<T> c0837s = this.f26206d;
        if (c0837s == null) {
            return;
        }
        if (c0837s.b() != null) {
            h(c0837s.b());
        } else {
            f(c0837s.a());
        }
    }

    public final synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f26204b);
        if (arrayList.isEmpty()) {
            l6.e.d("EffectiveAnimation encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC0836q) it.next()).a(th);
        }
    }

    public final void g() {
        this.f26205c.post(new Runnable() { // from class: com.oplus.anim.t
            @Override // java.lang.Runnable
            public final void run() {
                u.this.e();
            }
        });
    }

    public final synchronized void h(T t10) {
        Iterator it = new ArrayList(this.f26203a).iterator();
        while (it.hasNext()) {
            ((InterfaceC0836q) it.next()).a(t10);
        }
    }

    public synchronized u<T> i(InterfaceC0836q<Throwable> interfaceC0836q) {
        this.f26204b.remove(interfaceC0836q);
        return this;
    }

    public synchronized u<T> j(InterfaceC0836q<T> interfaceC0836q) {
        this.f26203a.remove(interfaceC0836q);
        return this;
    }

    public final void k(C0837s<T> c0837s) {
        if (this.f26206d == null) {
            this.f26206d = c0837s;
            g();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public u(Callable<C0837s<T>> callable, boolean z10) {
        this.f26203a = new LinkedHashSet(1);
        this.f26204b = new LinkedHashSet(1);
        this.f26205c = new Handler(Looper.getMainLooper());
        this.f26206d = null;
        if (z10) {
            try {
                k(callable.call());
                return;
            } catch (Throwable th) {
                k(new C0837s<>(th));
                return;
            }
        }
        f26202e.execute(new a(callable));
    }
}
