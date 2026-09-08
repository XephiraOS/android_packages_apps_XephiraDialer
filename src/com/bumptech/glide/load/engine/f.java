package com.bumptech.glide.load.engine;

import Z2.l;
import android.util.Log;
import b3.C0521b;
import b3.InterfaceC0520a;
import b3.h;
import c3.ExecutorServiceC0552a;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.h;
import java.util.Map;
import java.util.concurrent.Executor;
import o3.InterfaceC1402f;
import s3.C1536g;
import s3.C1540k;
import t3.C1589a;

/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class f implements Z2.d, h.a, h.a {

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f19539i = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    public final Z2.h f19540a;

    /* renamed from: b, reason: collision with root package name */
    public final Z2.f f19541b;

    /* renamed from: c, reason: collision with root package name */
    public final b3.h f19542c;

    /* renamed from: d, reason: collision with root package name */
    public final b f19543d;

    /* renamed from: e, reason: collision with root package name */
    public final l f19544e;

    /* renamed from: f, reason: collision with root package name */
    public final c f19545f;

    /* renamed from: g, reason: collision with root package name */
    public final a f19546g;

    /* renamed from: h, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.a f19547h;

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final DecodeJob.e f19548a;

        /* renamed from: b, reason: collision with root package name */
        public final I.e<DecodeJob<?>> f19549b = C1589a.d(150, new C0192a());

        /* renamed from: c, reason: collision with root package name */
        public int f19550c;

        /* compiled from: Engine.java */
        /* renamed from: com.bumptech.glide.load.engine.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0192a implements C1589a.d<DecodeJob<?>> {
            public C0192a() {
            }

            @Override // t3.C1589a.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DecodeJob<?> create() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.f19548a, aVar.f19549b);
            }
        }

        public a(DecodeJob.e eVar) {
            this.f19548a = eVar;
        }

        public <R> DecodeJob<R> a(com.bumptech.glide.d dVar, Object obj, Z2.e eVar, X2.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, Z2.c cVar, Map<Class<?>, X2.g<?>> map, boolean z10, boolean z11, boolean z12, X2.d dVar2, DecodeJob.b<R> bVar2) {
            DecodeJob decodeJob = (DecodeJob) C1540k.d(this.f19549b.b());
            int i12 = this.f19550c;
            this.f19550c = i12 + 1;
            return decodeJob.n(dVar, obj, eVar, bVar, i10, i11, cls, cls2, priority, cVar, map, z10, z11, z12, dVar2, bVar2, i12);
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final ExecutorServiceC0552a f19552a;

        /* renamed from: b, reason: collision with root package name */
        public final ExecutorServiceC0552a f19553b;

        /* renamed from: c, reason: collision with root package name */
        public final ExecutorServiceC0552a f19554c;

        /* renamed from: d, reason: collision with root package name */
        public final ExecutorServiceC0552a f19555d;

        /* renamed from: e, reason: collision with root package name */
        public final Z2.d f19556e;

        /* renamed from: f, reason: collision with root package name */
        public final h.a f19557f;

        /* renamed from: g, reason: collision with root package name */
        public final I.e<g<?>> f19558g = C1589a.d(150, new a());

        /* compiled from: Engine.java */
        /* loaded from: classes.dex */
        public class a implements C1589a.d<g<?>> {
            public a() {
            }

            @Override // t3.C1589a.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g<?> create() {
                b bVar = b.this;
                return new g<>(bVar.f19552a, bVar.f19553b, bVar.f19554c, bVar.f19555d, bVar.f19556e, bVar.f19557f, bVar.f19558g);
            }
        }

        public b(ExecutorServiceC0552a executorServiceC0552a, ExecutorServiceC0552a executorServiceC0552a2, ExecutorServiceC0552a executorServiceC0552a3, ExecutorServiceC0552a executorServiceC0552a4, Z2.d dVar, h.a aVar) {
            this.f19552a = executorServiceC0552a;
            this.f19553b = executorServiceC0552a2;
            this.f19554c = executorServiceC0552a3;
            this.f19555d = executorServiceC0552a4;
            this.f19556e = dVar;
            this.f19557f = aVar;
        }

        public <R> g<R> a(X2.b bVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((g) C1540k.d(this.f19558g.b())).l(bVar, z10, z11, z12, z13);
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class c implements DecodeJob.e {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC0520a.InterfaceC0145a f19560a;

        /* renamed from: b, reason: collision with root package name */
        public volatile InterfaceC0520a f19561b;

        public c(InterfaceC0520a.InterfaceC0145a interfaceC0145a) {
            this.f19560a = interfaceC0145a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.e
        public InterfaceC0520a a() {
            if (this.f19561b == null) {
                synchronized (this) {
                    try {
                        if (this.f19561b == null) {
                            this.f19561b = this.f19560a.build();
                        }
                        if (this.f19561b == null) {
                            this.f19561b = new C0521b();
                        }
                    } finally {
                    }
                }
            }
            return this.f19561b;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public final g<?> f19562a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC1402f f19563b;

        public d(InterfaceC1402f interfaceC1402f, g<?> gVar) {
            this.f19563b = interfaceC1402f;
            this.f19562a = gVar;
        }

        public void a() {
            synchronized (f.this) {
                this.f19562a.r(this.f19563b);
            }
        }
    }

    public f(b3.h hVar, InterfaceC0520a.InterfaceC0145a interfaceC0145a, ExecutorServiceC0552a executorServiceC0552a, ExecutorServiceC0552a executorServiceC0552a2, ExecutorServiceC0552a executorServiceC0552a3, ExecutorServiceC0552a executorServiceC0552a4, boolean z10) {
        this(hVar, interfaceC0145a, executorServiceC0552a, executorServiceC0552a2, executorServiceC0552a3, executorServiceC0552a4, null, null, null, null, null, null, z10);
    }

    public static void j(String str, long j10, X2.b bVar) {
        Log.v("Engine", str + " in " + C1536g.a(j10) + "ms, key: " + bVar);
    }

    @Override // Z2.d
    public synchronized void a(g<?> gVar, X2.b bVar, h<?> hVar) {
        if (hVar != null) {
            try {
                if (hVar.f()) {
                    this.f19547h.a(bVar, hVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f19540a.d(bVar, gVar);
    }

    @Override // Z2.d
    public synchronized void b(g<?> gVar, X2.b bVar) {
        this.f19540a.d(bVar, gVar);
    }

    @Override // b3.h.a
    public void c(Z2.j<?> jVar) {
        this.f19544e.a(jVar, true);
    }

    @Override // com.bumptech.glide.load.engine.h.a
    public void d(X2.b bVar, h<?> hVar) {
        this.f19547h.d(bVar);
        if (hVar.f()) {
            this.f19542c.e(bVar, hVar);
        } else {
            this.f19544e.a(hVar, false);
        }
    }

    public final h<?> e(X2.b bVar) {
        Z2.j<?> d10 = this.f19542c.d(bVar);
        if (d10 == null) {
            return null;
        }
        if (d10 instanceof h) {
            return (h) d10;
        }
        return new h<>(d10, true, true, bVar, this);
    }

    public <R> d f(com.bumptech.glide.d dVar, Object obj, X2.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, Z2.c cVar, Map<Class<?>, X2.g<?>> map, boolean z10, boolean z11, X2.d dVar2, boolean z12, boolean z13, boolean z14, boolean z15, InterfaceC1402f interfaceC1402f, Executor executor) {
        long j10;
        if (f19539i) {
            j10 = C1536g.b();
        } else {
            j10 = 0;
        }
        long j11 = j10;
        Z2.e a10 = this.f19541b.a(obj, bVar, i10, i11, map, cls, cls2, dVar2);
        synchronized (this) {
            try {
                h<?> i12 = i(a10, z12, j11);
                if (i12 == null) {
                    return l(dVar, obj, bVar, i10, i11, cls, cls2, priority, cVar, map, z10, z11, dVar2, z12, z13, z14, z15, interfaceC1402f, executor, a10, j11);
                }
                interfaceC1402f.c(i12, DataSource.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final h<?> g(X2.b bVar) {
        h<?> e10 = this.f19547h.e(bVar);
        if (e10 != null) {
            e10.a();
        }
        return e10;
    }

    public final h<?> h(X2.b bVar) {
        h<?> e10 = e(bVar);
        if (e10 != null) {
            e10.a();
            this.f19547h.a(bVar, e10);
        }
        return e10;
    }

    public final h<?> i(Z2.e eVar, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        h<?> g10 = g(eVar);
        if (g10 != null) {
            if (f19539i) {
                j("Loaded resource from active resources", j10, eVar);
            }
            return g10;
        }
        h<?> h10 = h(eVar);
        if (h10 == null) {
            return null;
        }
        if (f19539i) {
            j("Loaded resource from cache", j10, eVar);
        }
        return h10;
    }

    public void k(Z2.j<?> jVar) {
        if (jVar instanceof h) {
            ((h) jVar).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public final <R> d l(com.bumptech.glide.d dVar, Object obj, X2.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, Z2.c cVar, Map<Class<?>, X2.g<?>> map, boolean z10, boolean z11, X2.d dVar2, boolean z12, boolean z13, boolean z14, boolean z15, InterfaceC1402f interfaceC1402f, Executor executor, Z2.e eVar, long j10) {
        g<?> a10 = this.f19540a.a(eVar, z15);
        if (a10 != null) {
            a10.b(interfaceC1402f, executor);
            if (f19539i) {
                j("Added to existing load", j10, eVar);
            }
            return new d(interfaceC1402f, a10);
        }
        g<R> a11 = this.f19543d.a(eVar, z12, z13, z14, z15);
        DecodeJob<R> a12 = this.f19546g.a(dVar, obj, eVar, bVar, i10, i11, cls, cls2, priority, cVar, map, z10, z11, z15, dVar2, a11);
        this.f19540a.c(eVar, a11);
        a11.b(interfaceC1402f, executor);
        a11.s(a12);
        if (f19539i) {
            j("Started new load", j10, eVar);
        }
        return new d(interfaceC1402f, a11);
    }

    public f(b3.h hVar, InterfaceC0520a.InterfaceC0145a interfaceC0145a, ExecutorServiceC0552a executorServiceC0552a, ExecutorServiceC0552a executorServiceC0552a2, ExecutorServiceC0552a executorServiceC0552a3, ExecutorServiceC0552a executorServiceC0552a4, Z2.h hVar2, Z2.f fVar, com.bumptech.glide.load.engine.a aVar, b bVar, a aVar2, l lVar, boolean z10) {
        this.f19542c = hVar;
        c cVar = new c(interfaceC0145a);
        this.f19545f = cVar;
        com.bumptech.glide.load.engine.a aVar3 = aVar == null ? new com.bumptech.glide.load.engine.a(z10) : aVar;
        this.f19547h = aVar3;
        aVar3.f(this);
        this.f19541b = fVar == null ? new Z2.f() : fVar;
        this.f19540a = hVar2 == null ? new Z2.h() : hVar2;
        this.f19543d = bVar == null ? new b(executorServiceC0552a, executorServiceC0552a2, executorServiceC0552a3, executorServiceC0552a4, this, this) : bVar;
        this.f19546g = aVar2 == null ? new a(cVar) : aVar2;
        this.f19544e = lVar == null ? new l() : lVar;
        hVar.c(this);
    }
}
