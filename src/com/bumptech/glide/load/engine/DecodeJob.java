package com.bumptech.glide.load.engine;

import android.util.Log;
import b3.InterfaceC0520a;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.c;
import com.bumptech.glide.load.engine.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import s3.C1536g;
import t3.C1589a;

/* loaded from: classes.dex */
public class DecodeJob<R> implements c.a, Runnable, Comparable<DecodeJob<?>>, C1589a.f {

    /* renamed from: A, reason: collision with root package name */
    public Object f19438A;

    /* renamed from: B, reason: collision with root package name */
    public Thread f19439B;

    /* renamed from: C, reason: collision with root package name */
    public X2.b f19440C;

    /* renamed from: D, reason: collision with root package name */
    public X2.b f19441D;

    /* renamed from: E, reason: collision with root package name */
    public Object f19442E;

    /* renamed from: F, reason: collision with root package name */
    public DataSource f19443F;

    /* renamed from: G, reason: collision with root package name */
    public com.bumptech.glide.load.data.d<?> f19444G;

    /* renamed from: H, reason: collision with root package name */
    public volatile com.bumptech.glide.load.engine.c f19445H;

    /* renamed from: I, reason: collision with root package name */
    public volatile boolean f19446I;

    /* renamed from: J, reason: collision with root package name */
    public volatile boolean f19447J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f19448K;

    /* renamed from: d, reason: collision with root package name */
    public final e f19452d;

    /* renamed from: e, reason: collision with root package name */
    public final I.e<DecodeJob<?>> f19453e;

    /* renamed from: h, reason: collision with root package name */
    public com.bumptech.glide.d f19456h;

    /* renamed from: i, reason: collision with root package name */
    public X2.b f19457i;

    /* renamed from: j, reason: collision with root package name */
    public Priority f19458j;

    /* renamed from: k, reason: collision with root package name */
    public Z2.e f19459k;

    /* renamed from: l, reason: collision with root package name */
    public int f19460l;

    /* renamed from: m, reason: collision with root package name */
    public int f19461m;

    /* renamed from: n, reason: collision with root package name */
    public Z2.c f19462n;

    /* renamed from: o, reason: collision with root package name */
    public X2.d f19463o;

    /* renamed from: p, reason: collision with root package name */
    public b<R> f19464p;

    /* renamed from: q, reason: collision with root package name */
    public int f19465q;

    /* renamed from: r, reason: collision with root package name */
    public Stage f19466r;

    /* renamed from: x, reason: collision with root package name */
    public RunReason f19467x;

    /* renamed from: y, reason: collision with root package name */
    public long f19468y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f19469z;

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.d<R> f19449a = new com.bumptech.glide.load.engine.d<>();

    /* renamed from: b, reason: collision with root package name */
    public final List<Throwable> f19450b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final t3.c f19451c = t3.c.a();

    /* renamed from: f, reason: collision with root package name */
    public final d<?> f19454f = new d<>();

    /* renamed from: g, reason: collision with root package name */
    public final f f19455g = new f();

    /* loaded from: classes.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* loaded from: classes.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19481a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19482b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f19483c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f19483c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19483c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f19482b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19482b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19482b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19482b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19482b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f19481a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19481a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19481a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b<R> {
        void a(GlideException glideException);

        void c(Z2.j<R> jVar, DataSource dataSource, boolean z10);

        void d(DecodeJob<?> decodeJob);
    }

    /* loaded from: classes.dex */
    public final class c<Z> implements e.a<Z> {

        /* renamed from: a, reason: collision with root package name */
        public final DataSource f19484a;

        public c(DataSource dataSource) {
            this.f19484a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.e.a
        public Z2.j<Z> a(Z2.j<Z> jVar) {
            return DecodeJob.this.v(this.f19484a, jVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d<Z> {

        /* renamed from: a, reason: collision with root package name */
        public X2.b f19486a;

        /* renamed from: b, reason: collision with root package name */
        public X2.f<Z> f19487b;

        /* renamed from: c, reason: collision with root package name */
        public Z2.i<Z> f19488c;

        public void a() {
            this.f19486a = null;
            this.f19487b = null;
            this.f19488c = null;
        }

        public void b(e eVar, X2.d dVar) {
            t3.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f19486a, new Z2.b(this.f19487b, this.f19488c, dVar));
            } finally {
                this.f19488c.h();
                t3.b.e();
            }
        }

        public boolean c() {
            if (this.f19488c != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <X> void d(X2.b bVar, X2.f<X> fVar, Z2.i<X> iVar) {
            this.f19486a = bVar;
            this.f19487b = fVar;
            this.f19488c = iVar;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        InterfaceC0520a a();
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19489a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19490b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f19491c;

        public final boolean a(boolean z10) {
            if ((this.f19491c || z10 || this.f19490b) && this.f19489a) {
                return true;
            }
            return false;
        }

        public synchronized boolean b() {
            this.f19490b = true;
            return a(false);
        }

        public synchronized boolean c() {
            this.f19491c = true;
            return a(false);
        }

        public synchronized boolean d(boolean z10) {
            this.f19489a = true;
            return a(z10);
        }

        public synchronized void e() {
            this.f19490b = false;
            this.f19489a = false;
            this.f19491c = false;
        }
    }

    public DecodeJob(e eVar, I.e<DecodeJob<?>> eVar2) {
        this.f19452d = eVar;
        this.f19453e = eVar2;
    }

    public final <Data, ResourceType> Z2.j<R> A(Data data, DataSource dataSource, i<Data, ResourceType, R> iVar) {
        X2.d l10 = l(dataSource);
        com.bumptech.glide.load.data.e<Data> l11 = this.f19456h.i().l(data);
        try {
            return iVar.a(l11, l10, this.f19460l, this.f19461m, new c(dataSource));
        } finally {
            l11.b();
        }
    }

    public final void B() {
        int i10 = a.f19481a[this.f19467x.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    i();
                    return;
                }
                throw new IllegalStateException("Unrecognized run reason: " + this.f19467x);
            }
            z();
            return;
        }
        this.f19466r = k(Stage.INITIALIZE);
        this.f19445H = j();
        z();
    }

    public final void C() {
        Throwable th;
        this.f19451c.c();
        if (this.f19446I) {
            if (this.f19450b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f19450b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.f19446I = true;
    }

    public boolean D() {
        Stage k10 = k(Stage.INITIALIZE);
        if (k10 != Stage.RESOURCE_CACHE && k10 != Stage.DATA_CACHE) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.engine.c.a
    public void a(X2.b bVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.j(bVar, dataSource, dVar.a());
        this.f19450b.add(glideException);
        if (Thread.currentThread() != this.f19439B) {
            y(RunReason.SWITCH_TO_SOURCE_SERVICE);
        } else {
            z();
        }
    }

    @Override // com.bumptech.glide.load.engine.c.a
    public void b(X2.b bVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, X2.b bVar2) {
        this.f19440C = bVar;
        this.f19442E = obj;
        this.f19444G = dVar;
        this.f19443F = dataSource;
        this.f19441D = bVar2;
        boolean z10 = false;
        if (bVar != this.f19449a.c().get(0)) {
            z10 = true;
        }
        this.f19448K = z10;
        if (Thread.currentThread() != this.f19439B) {
            y(RunReason.DECODE_DATA);
            return;
        }
        t3.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            i();
        } finally {
            t3.b.e();
        }
    }

    @Override // com.bumptech.glide.load.engine.c.a
    public void c() {
        y(RunReason.SWITCH_TO_SOURCE_SERVICE);
    }

    public void d() {
        this.f19447J = true;
        com.bumptech.glide.load.engine.c cVar = this.f19445H;
        if (cVar != null) {
            cVar.cancel();
        }
    }

    @Override // t3.C1589a.f
    public t3.c e() {
        return this.f19451c;
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(DecodeJob<?> decodeJob) {
        int m10 = m() - decodeJob.m();
        if (m10 == 0) {
            return this.f19465q - decodeJob.f19465q;
        }
        return m10;
    }

    public final <Data> Z2.j<R> g(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long b10 = C1536g.b();
            Z2.j<R> h10 = h(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + h10, b10);
            }
            return h10;
        } finally {
            dVar.b();
        }
    }

    public final <Data> Z2.j<R> h(Data data, DataSource dataSource) {
        return A(data, dataSource, this.f19449a.h(data.getClass()));
    }

    public final void i() {
        Z2.j<R> jVar;
        if (Log.isLoggable("DecodeJob", 2)) {
            p("Retrieved data", this.f19468y, "data: " + this.f19442E + ", cache key: " + this.f19440C + ", fetcher: " + this.f19444G);
        }
        try {
            jVar = g(this.f19444G, this.f19442E, this.f19443F);
        } catch (GlideException e10) {
            e10.i(this.f19441D, this.f19443F);
            this.f19450b.add(e10);
            jVar = null;
        }
        if (jVar != null) {
            r(jVar, this.f19443F, this.f19448K);
        } else {
            z();
        }
    }

    public final com.bumptech.glide.load.engine.c j() {
        int i10 = a.f19482b[this.f19466r.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.f19466r);
                }
                return new k(this.f19449a, this);
            }
            return new com.bumptech.glide.load.engine.b(this.f19449a, this);
        }
        return new j(this.f19449a, this);
    }

    public final Stage k(Stage stage) {
        int i10 = a.f19482b[stage.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3 && i10 != 4) {
                    if (i10 == 5) {
                        if (this.f19462n.b()) {
                            return Stage.RESOURCE_CACHE;
                        }
                        return k(Stage.RESOURCE_CACHE);
                    }
                    throw new IllegalArgumentException("Unrecognized stage: " + stage);
                }
                return Stage.FINISHED;
            }
            if (this.f19469z) {
                return Stage.FINISHED;
            }
            return Stage.SOURCE;
        }
        if (this.f19462n.a()) {
            return Stage.DATA_CACHE;
        }
        return k(Stage.DATA_CACHE);
    }

    public final X2.d l(DataSource dataSource) {
        boolean z10;
        X2.d dVar = this.f19463o;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE && !this.f19449a.x()) {
            z10 = false;
        } else {
            z10 = true;
        }
        X2.c<Boolean> cVar = com.bumptech.glide.load.resource.bitmap.a.f19666j;
        Boolean bool = (Boolean) dVar.c(cVar);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return dVar;
        }
        X2.d dVar2 = new X2.d();
        dVar2.d(this.f19463o);
        dVar2.e(cVar, Boolean.valueOf(z10));
        return dVar2;
    }

    public final int m() {
        return this.f19458j.ordinal();
    }

    public DecodeJob<R> n(com.bumptech.glide.d dVar, Object obj, Z2.e eVar, X2.b bVar, int i10, int i11, Class<?> cls, Class<R> cls2, Priority priority, Z2.c cVar, Map<Class<?>, X2.g<?>> map, boolean z10, boolean z11, boolean z12, X2.d dVar2, b<R> bVar2, int i12) {
        this.f19449a.v(dVar, obj, bVar, i10, i11, cVar, cls, cls2, priority, dVar2, map, z10, z11, this.f19452d);
        this.f19456h = dVar;
        this.f19457i = bVar;
        this.f19458j = priority;
        this.f19459k = eVar;
        this.f19460l = i10;
        this.f19461m = i11;
        this.f19462n = cVar;
        this.f19469z = z12;
        this.f19463o = dVar2;
        this.f19464p = bVar2;
        this.f19465q = i12;
        this.f19467x = RunReason.INITIALIZE;
        this.f19438A = obj;
        return this;
    }

    public final void o(String str, long j10) {
        p(str, j10, null);
    }

    public final void p(String str, long j10, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(C1536g.a(j10));
        sb.append(", load key: ");
        sb.append(this.f19459k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    public final void q(Z2.j<R> jVar, DataSource dataSource, boolean z10) {
        C();
        this.f19464p.c(jVar, dataSource, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(Z2.j<R> jVar, DataSource dataSource, boolean z10) {
        Z2.i iVar;
        t3.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (jVar instanceof Z2.g) {
                ((Z2.g) jVar).a();
            }
            if (this.f19454f.c()) {
                jVar = Z2.i.f(jVar);
                iVar = jVar;
            } else {
                iVar = 0;
            }
            q(jVar, dataSource, z10);
            this.f19466r = Stage.ENCODE;
            try {
                if (this.f19454f.c()) {
                    this.f19454f.b(this.f19452d, this.f19463o);
                }
                t();
                t3.b.e();
            } finally {
                if (iVar != 0) {
                    iVar.h();
                }
            }
        } catch (Throwable th) {
            t3.b.e();
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        t3.b.c("DecodeJob#run(reason=%s, model=%s)", this.f19467x, this.f19438A);
        com.bumptech.glide.load.data.d<?> dVar = this.f19444G;
        try {
            try {
                if (this.f19447J) {
                    s();
                    if (dVar != null) {
                        dVar.b();
                    }
                    t3.b.e();
                    return;
                }
                B();
                if (dVar != null) {
                    dVar.b();
                }
                t3.b.e();
            } catch (Throwable th) {
                if (dVar != null) {
                    dVar.b();
                }
                t3.b.e();
                throw th;
            }
        } catch (CallbackException e10) {
            throw e10;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.f19447J + ", stage: " + this.f19466r, th2);
            }
            if (this.f19466r != Stage.ENCODE) {
                this.f19450b.add(th2);
                s();
            }
            if (!this.f19447J) {
                throw th2;
            }
            throw th2;
        }
    }

    public final void s() {
        C();
        this.f19464p.a(new GlideException("Failed to load resource", new ArrayList(this.f19450b)));
        u();
    }

    public final void t() {
        if (this.f19455g.b()) {
            x();
        }
    }

    public final void u() {
        if (this.f19455g.c()) {
            x();
        }
    }

    public <Z> Z2.j<Z> v(DataSource dataSource, Z2.j<Z> jVar) {
        Z2.j<Z> jVar2;
        X2.g<Z> gVar;
        EncodeStrategy encodeStrategy;
        X2.b aVar;
        Class<?> cls = jVar.get().getClass();
        X2.f<Z> fVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            X2.g<Z> s10 = this.f19449a.s(cls);
            gVar = s10;
            jVar2 = s10.b(this.f19456h, jVar, this.f19460l, this.f19461m);
        } else {
            jVar2 = jVar;
            gVar = null;
        }
        if (!jVar.equals(jVar2)) {
            jVar.b();
        }
        if (this.f19449a.w(jVar2)) {
            fVar = this.f19449a.n(jVar2);
            encodeStrategy = fVar.a(this.f19463o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        X2.f fVar2 = fVar;
        if (this.f19462n.d(!this.f19449a.y(this.f19440C), dataSource, encodeStrategy)) {
            if (fVar2 != null) {
                int i10 = a.f19483c[encodeStrategy.ordinal()];
                if (i10 != 1) {
                    if (i10 == 2) {
                        aVar = new Z2.k(this.f19449a.b(), this.f19440C, this.f19457i, this.f19460l, this.f19461m, gVar, cls, this.f19463o);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                    }
                } else {
                    aVar = new Z2.a(this.f19440C, this.f19457i);
                }
                Z2.i f10 = Z2.i.f(jVar2);
                this.f19454f.d(aVar, fVar2, f10);
                return f10;
            }
            throw new Registry.NoResultEncoderAvailableException(jVar2.get().getClass());
        }
        return jVar2;
    }

    public void w(boolean z10) {
        if (this.f19455g.d(z10)) {
            x();
        }
    }

    public final void x() {
        this.f19455g.e();
        this.f19454f.a();
        this.f19449a.a();
        this.f19446I = false;
        this.f19456h = null;
        this.f19457i = null;
        this.f19463o = null;
        this.f19458j = null;
        this.f19459k = null;
        this.f19464p = null;
        this.f19466r = null;
        this.f19445H = null;
        this.f19439B = null;
        this.f19440C = null;
        this.f19442E = null;
        this.f19443F = null;
        this.f19444G = null;
        this.f19468y = 0L;
        this.f19447J = false;
        this.f19438A = null;
        this.f19450b.clear();
        this.f19453e.a(this);
    }

    public final void y(RunReason runReason) {
        this.f19467x = runReason;
        this.f19464p.d(this);
    }

    public final void z() {
        this.f19439B = Thread.currentThread();
        this.f19468y = C1536g.b();
        boolean z10 = false;
        while (!this.f19447J && this.f19445H != null && !(z10 = this.f19445H.d())) {
            this.f19466r = k(this.f19466r);
            this.f19445H = j();
            if (this.f19466r == Stage.SOURCE) {
                y(RunReason.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.f19466r == Stage.FINISHED || this.f19447J) && !z10) {
            s();
        }
    }
}
