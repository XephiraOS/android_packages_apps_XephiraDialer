package com.bumptech.glide.load.engine;

import c3.ExecutorServiceC0552a;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import o3.InterfaceC1402f;
import s3.C1534e;
import s3.C1540k;
import t3.C1589a;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
public class g<R> implements DecodeJob.b<R>, C1589a.f {

    /* renamed from: E, reason: collision with root package name */
    public static final c f19565E = new c();

    /* renamed from: A, reason: collision with root package name */
    public h<?> f19566A;

    /* renamed from: B, reason: collision with root package name */
    public DecodeJob<R> f19567B;

    /* renamed from: C, reason: collision with root package name */
    public volatile boolean f19568C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f19569D;

    /* renamed from: a, reason: collision with root package name */
    public final e f19570a;

    /* renamed from: b, reason: collision with root package name */
    public final t3.c f19571b;

    /* renamed from: c, reason: collision with root package name */
    public final h.a f19572c;

    /* renamed from: d, reason: collision with root package name */
    public final I.e<g<?>> f19573d;

    /* renamed from: e, reason: collision with root package name */
    public final c f19574e;

    /* renamed from: f, reason: collision with root package name */
    public final Z2.d f19575f;

    /* renamed from: g, reason: collision with root package name */
    public final ExecutorServiceC0552a f19576g;

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorServiceC0552a f19577h;

    /* renamed from: i, reason: collision with root package name */
    public final ExecutorServiceC0552a f19578i;

    /* renamed from: j, reason: collision with root package name */
    public final ExecutorServiceC0552a f19579j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f19580k;

    /* renamed from: l, reason: collision with root package name */
    public X2.b f19581l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19582m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f19583n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f19584o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f19585p;

    /* renamed from: q, reason: collision with root package name */
    public Z2.j<?> f19586q;

    /* renamed from: r, reason: collision with root package name */
    public DataSource f19587r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f19588x;

    /* renamed from: y, reason: collision with root package name */
    public GlideException f19589y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f19590z;

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1402f f19591a;

        public a(InterfaceC1402f interfaceC1402f) {
            this.f19591a = interfaceC1402f;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f19591a.e()) {
                synchronized (g.this) {
                    try {
                        if (g.this.f19570a.c(this.f19591a)) {
                            g.this.f(this.f19591a);
                        }
                        g.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1402f f19593a;

        public b(InterfaceC1402f interfaceC1402f) {
            this.f19593a = interfaceC1402f;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f19593a.e()) {
                synchronized (g.this) {
                    try {
                        if (g.this.f19570a.c(this.f19593a)) {
                            g.this.f19566A.a();
                            g.this.g(this.f19593a);
                            g.this.r(this.f19593a);
                        }
                        g.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static class c {
        public <R> h<R> a(Z2.j<R> jVar, boolean z10, X2.b bVar, h.a aVar) {
            return new h<>(jVar, z10, true, bVar, aVar);
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1402f f19595a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f19596b;

        public d(InterfaceC1402f interfaceC1402f, Executor executor) {
            this.f19595a = interfaceC1402f;
            this.f19596b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f19595a.equals(((d) obj).f19595a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19595a.hashCode();
        }
    }

    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: a, reason: collision with root package name */
        public final List<d> f19597a;

        public e() {
            this(new ArrayList(2));
        }

        public static d g(InterfaceC1402f interfaceC1402f) {
            return new d(interfaceC1402f, C1534e.a());
        }

        public void a(InterfaceC1402f interfaceC1402f, Executor executor) {
            this.f19597a.add(new d(interfaceC1402f, executor));
        }

        public boolean c(InterfaceC1402f interfaceC1402f) {
            return this.f19597a.contains(g(interfaceC1402f));
        }

        public void clear() {
            this.f19597a.clear();
        }

        public e e() {
            return new e(new ArrayList(this.f19597a));
        }

        public void h(InterfaceC1402f interfaceC1402f) {
            this.f19597a.remove(g(interfaceC1402f));
        }

        public boolean isEmpty() {
            return this.f19597a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f19597a.iterator();
        }

        public int size() {
            return this.f19597a.size();
        }

        public e(List<d> list) {
            this.f19597a = list;
        }
    }

    public g(ExecutorServiceC0552a executorServiceC0552a, ExecutorServiceC0552a executorServiceC0552a2, ExecutorServiceC0552a executorServiceC0552a3, ExecutorServiceC0552a executorServiceC0552a4, Z2.d dVar, h.a aVar, I.e<g<?>> eVar) {
        this(executorServiceC0552a, executorServiceC0552a2, executorServiceC0552a3, executorServiceC0552a4, dVar, aVar, eVar, f19565E);
    }

    private synchronized void q() {
        if (this.f19581l != null) {
            this.f19570a.clear();
            this.f19581l = null;
            this.f19566A = null;
            this.f19586q = null;
            this.f19590z = false;
            this.f19568C = false;
            this.f19588x = false;
            this.f19569D = false;
            this.f19567B.w(false);
            this.f19567B = null;
            this.f19589y = null;
            this.f19587r = null;
            this.f19573d.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void a(GlideException glideException) {
        synchronized (this) {
            this.f19589y = glideException;
        }
        n();
    }

    public synchronized void b(InterfaceC1402f interfaceC1402f, Executor executor) {
        try {
            this.f19571b.c();
            this.f19570a.a(interfaceC1402f, executor);
            if (this.f19588x) {
                k(1);
                executor.execute(new b(interfaceC1402f));
            } else if (this.f19590z) {
                k(1);
                executor.execute(new a(interfaceC1402f));
            } else {
                C1540k.a(!this.f19568C, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void c(Z2.j<R> jVar, DataSource dataSource, boolean z10) {
        synchronized (this) {
            this.f19586q = jVar;
            this.f19587r = dataSource;
            this.f19569D = z10;
        }
        o();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void d(DecodeJob<?> decodeJob) {
        j().execute(decodeJob);
    }

    @Override // t3.C1589a.f
    public t3.c e() {
        return this.f19571b;
    }

    public void f(InterfaceC1402f interfaceC1402f) {
        try {
            interfaceC1402f.a(this.f19589y);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    public void g(InterfaceC1402f interfaceC1402f) {
        try {
            interfaceC1402f.c(this.f19566A, this.f19587r, this.f19569D);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    public void h() {
        if (m()) {
            return;
        }
        this.f19568C = true;
        this.f19567B.d();
        this.f19575f.b(this, this.f19581l);
    }

    public void i() {
        boolean z10;
        h<?> hVar;
        synchronized (this) {
            try {
                this.f19571b.c();
                C1540k.a(m(), "Not yet complete!");
                int decrementAndGet = this.f19580k.decrementAndGet();
                if (decrementAndGet >= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                C1540k.a(z10, "Can't decrement below 0");
                if (decrementAndGet == 0) {
                    hVar = this.f19566A;
                    q();
                } else {
                    hVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (hVar != null) {
            hVar.g();
        }
    }

    public final ExecutorServiceC0552a j() {
        if (this.f19583n) {
            return this.f19578i;
        }
        if (this.f19584o) {
            return this.f19579j;
        }
        return this.f19577h;
    }

    public synchronized void k(int i10) {
        h<?> hVar;
        C1540k.a(m(), "Not yet complete!");
        if (this.f19580k.getAndAdd(i10) == 0 && (hVar = this.f19566A) != null) {
            hVar.a();
        }
    }

    public synchronized g<R> l(X2.b bVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f19581l = bVar;
        this.f19582m = z10;
        this.f19583n = z11;
        this.f19584o = z12;
        this.f19585p = z13;
        return this;
    }

    public final boolean m() {
        if (!this.f19590z && !this.f19588x && !this.f19568C) {
            return false;
        }
        return true;
    }

    public void n() {
        synchronized (this) {
            try {
                this.f19571b.c();
                if (this.f19568C) {
                    q();
                    return;
                }
                if (!this.f19570a.isEmpty()) {
                    if (!this.f19590z) {
                        this.f19590z = true;
                        X2.b bVar = this.f19581l;
                        e e10 = this.f19570a.e();
                        k(e10.size() + 1);
                        this.f19575f.a(this, bVar, null);
                        Iterator<d> it = e10.iterator();
                        while (it.hasNext()) {
                            d next = it.next();
                            next.f19596b.execute(new a(next.f19595a));
                        }
                        i();
                        return;
                    }
                    throw new IllegalStateException("Already failed once");
                }
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o() {
        synchronized (this) {
            try {
                this.f19571b.c();
                if (this.f19568C) {
                    this.f19586q.b();
                    q();
                    return;
                }
                if (!this.f19570a.isEmpty()) {
                    if (!this.f19588x) {
                        this.f19566A = this.f19574e.a(this.f19586q, this.f19582m, this.f19581l, this.f19572c);
                        this.f19588x = true;
                        e e10 = this.f19570a.e();
                        k(e10.size() + 1);
                        this.f19575f.a(this, this.f19581l, this.f19566A);
                        Iterator<d> it = e10.iterator();
                        while (it.hasNext()) {
                            d next = it.next();
                            next.f19596b.execute(new b(next.f19595a));
                        }
                        i();
                        return;
                    }
                    throw new IllegalStateException("Already have resource");
                }
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean p() {
        return this.f19585p;
    }

    public synchronized void r(InterfaceC1402f interfaceC1402f) {
        try {
            this.f19571b.c();
            this.f19570a.h(interfaceC1402f);
            if (this.f19570a.isEmpty()) {
                h();
                if (!this.f19588x) {
                    if (this.f19590z) {
                    }
                }
                if (this.f19580k.get() == 0) {
                    q();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(DecodeJob<R> decodeJob) {
        ExecutorServiceC0552a j10;
        try {
            this.f19567B = decodeJob;
            if (decodeJob.D()) {
                j10 = this.f19576g;
            } else {
                j10 = j();
            }
            j10.execute(decodeJob);
        } catch (Throwable th) {
            throw th;
        }
    }

    public g(ExecutorServiceC0552a executorServiceC0552a, ExecutorServiceC0552a executorServiceC0552a2, ExecutorServiceC0552a executorServiceC0552a3, ExecutorServiceC0552a executorServiceC0552a4, Z2.d dVar, h.a aVar, I.e<g<?>> eVar, c cVar) {
        this.f19570a = new e();
        this.f19571b = t3.c.a();
        this.f19580k = new AtomicInteger();
        this.f19576g = executorServiceC0552a;
        this.f19577h = executorServiceC0552a2;
        this.f19578i = executorServiceC0552a3;
        this.f19579j = executorServiceC0552a4;
        this.f19575f = dVar;
        this.f19572c = aVar;
        this.f19573d = eVar;
        this.f19574e = cVar;
    }
}
