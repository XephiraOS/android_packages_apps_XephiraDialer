package io.grpc.internal;

import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Context;
import io.grpc.InternalChannelz;
import io.grpc.internal.C1125g;
import io.grpc.internal.G;
import j9.AbstractC1191a;
import j9.C1200j;
import j9.C1203m;
import j9.InterfaceC1192b;
import j9.J;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* compiled from: ServerImplBuilder.java */
/* loaded from: classes4.dex */
public final class j0 extends j9.F<j0> {

    /* renamed from: i, reason: collision with root package name */
    public final b f33244i;

    /* renamed from: w, reason: collision with root package name */
    public j9.G f33258w;

    /* renamed from: x, reason: collision with root package name */
    public static final Logger f33237x = Logger.getLogger(j0.class.getName());

    /* renamed from: y, reason: collision with root package name */
    public static final U<? extends Executor> f33238y = r0.c(GrpcUtil.f32539u);

    /* renamed from: z, reason: collision with root package name */
    public static final j9.s f33239z = new c();

    /* renamed from: A, reason: collision with root package name */
    public static final j9.o f33234A = j9.o.c();

    /* renamed from: B, reason: collision with root package name */
    public static final C1200j f33235B = C1200j.a();

    /* renamed from: C, reason: collision with root package name */
    public static final long f33236C = TimeUnit.SECONDS.toMillis(120);

    /* renamed from: e, reason: collision with root package name */
    public final G.b f33240e = new G.b();

    /* renamed from: f, reason: collision with root package name */
    public final List<j9.K> f33241f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final List<io.grpc.C> f33242g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List<J.a> f33243h = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public j9.s f33245j = f33239z;

    /* renamed from: k, reason: collision with root package name */
    public U<? extends Executor> f33246k = f33238y;

    /* renamed from: l, reason: collision with root package name */
    public j9.o f33247l = f33234A;

    /* renamed from: m, reason: collision with root package name */
    public C1200j f33248m = f33235B;

    /* renamed from: n, reason: collision with root package name */
    public long f33249n = f33236C;

    /* renamed from: o, reason: collision with root package name */
    public C1203m.c f33250o = C1203m.f();

    /* renamed from: p, reason: collision with root package name */
    public boolean f33251p = true;

    /* renamed from: q, reason: collision with root package name */
    public boolean f33252q = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f33253r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f33254s = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f33255t = true;

    /* renamed from: u, reason: collision with root package name */
    public InternalChannelz f33256u = InternalChannelz.i();

    /* renamed from: v, reason: collision with root package name */
    public C1125g.b f33257v = C1125g.a();

    /* compiled from: ServerImplBuilder.java */
    /* loaded from: classes4.dex */
    public interface b {
        H buildClientTransportServers(List<? extends J.a> list);
    }

    /* compiled from: ServerImplBuilder.java */
    /* loaded from: classes4.dex */
    public static final class c extends j9.s {
        public c() {
        }

        @Override // j9.s
        public j9.H<?, ?> b(String str, String str2) {
            return null;
        }
    }

    public j0(b bVar) {
        this.f33244i = (b) com.google.common.base.k.p(bVar, "clientTransportServersBuilder");
    }

    @Override // j9.F
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j0 addService(InterfaceC1192b interfaceC1192b) {
        return addService(((InterfaceC1192b) com.google.common.base.k.p(interfaceC1192b, "bindableService")).bindService());
    }

    @Override // j9.F
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j0 addService(j9.I i10) {
        this.f33240e.a((j9.I) com.google.common.base.k.p(i10, "service"));
        return this;
    }

    @Override // j9.F
    public io.grpc.z build() {
        return new ServerImpl(this, this.f33244i.buildClientTransportServers(getTracerFactories()), Context.f32275e);
    }

    @Override // j9.F
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j0 addStreamTracerFactory(J.a aVar) {
        this.f33243h.add((J.a) com.google.common.base.k.p(aVar, "factory"));
        return this;
    }

    @Override // j9.F
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public j0 addTransportFilter(j9.K k10) {
        this.f33241f.add((j9.K) com.google.common.base.k.p(k10, "filter"));
        return this;
    }

    @Override // j9.F
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public j0 callExecutor(j9.G g10) {
        this.f33258w = (j9.G) com.google.common.base.k.o(g10);
        return this;
    }

    @Override // j9.F
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public j0 compressorRegistry(C1200j c1200j) {
        if (c1200j == null) {
            c1200j = f33235B;
        }
        this.f33248m = c1200j;
        return this;
    }

    @Override // j9.F
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public j0 decompressorRegistry(j9.o oVar) {
        if (oVar == null) {
            oVar = f33234A;
        }
        this.f33247l = oVar;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<? extends j9.J.a> getTracerFactories() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r1 = j9.u.b()
            java.util.List r2 = j9.u.c()
            if (r1 == 0) goto L19
            r0.addAll(r2)
            java.util.List<io.grpc.C> r2 = r9.f33242g
            r2.addAll(r1)
            r1 = 1
            goto L1a
        L19:
            r1 = 0
        L1a:
            java.lang.String r2 = "getServerStreamTracerFactory"
            r3 = 0
            java.lang.String r4 = "Unable to apply census stats"
            if (r1 != 0) goto L7f
            boolean r5 = r9.f33251p
            if (r5 == 0) goto L7f
            java.lang.String r5 = "io.grpc.census.InternalCensusStatsAccessor"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            java.lang.Class r6 = java.lang.Boolean.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            java.lang.Class[] r6 = new java.lang.Class[]{r6, r6, r6}     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r2, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            boolean r6 = r9.f33252q     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            boolean r7 = r9.f33253r     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            boolean r8 = r9.f33254s     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7, r8}     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            java.lang.Object r5 = r5.invoke(r3, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            j9.J$a r5 = (j9.J.a) r5     // Catch: java.lang.reflect.InvocationTargetException -> L52 java.lang.IllegalAccessException -> L54 java.lang.NoSuchMethodException -> L56 java.lang.ClassNotFoundException -> L58
            goto L7a
        L52:
            r5 = move-exception
            goto L5a
        L54:
            r5 = move-exception
            goto L62
        L56:
            r5 = move-exception
            goto L6a
        L58:
            r5 = move-exception
            goto L72
        L5a:
            java.util.logging.Logger r6 = io.grpc.internal.j0.f33237x
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r4, r5)
            goto L79
        L62:
            java.util.logging.Logger r6 = io.grpc.internal.j0.f33237x
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r4, r5)
            goto L79
        L6a:
            java.util.logging.Logger r6 = io.grpc.internal.j0.f33237x
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r4, r5)
            goto L79
        L72:
            java.util.logging.Logger r6 = io.grpc.internal.j0.f33237x
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r4, r5)
        L79:
            r5 = r3
        L7a:
            if (r5 == 0) goto L7f
            r0.add(r5)
        L7f:
            if (r1 != 0) goto Lc3
            boolean r1 = r9.f33255t
            if (r1 == 0) goto Lc3
            java.lang.String r1 = "io.grpc.census.InternalCensusTracingAccessor"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> L99 java.lang.NoSuchMethodException -> L9b java.lang.ClassNotFoundException -> L9d
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> L99 java.lang.NoSuchMethodException -> L9b java.lang.ClassNotFoundException -> L9d
            java.lang.Object r1 = r1.invoke(r3, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> L99 java.lang.NoSuchMethodException -> L9b java.lang.ClassNotFoundException -> L9d
            j9.J$a r1 = (j9.J.a) r1     // Catch: java.lang.reflect.InvocationTargetException -> L97 java.lang.IllegalAccessException -> L99 java.lang.NoSuchMethodException -> L9b java.lang.ClassNotFoundException -> L9d
            r3 = r1
            goto Lbe
        L97:
            r1 = move-exception
            goto L9f
        L99:
            r1 = move-exception
            goto La7
        L9b:
            r1 = move-exception
            goto Laf
        L9d:
            r1 = move-exception
            goto Lb7
        L9f:
            java.util.logging.Logger r2 = io.grpc.internal.j0.f33237x
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r2.log(r5, r4, r1)
            goto Lbe
        La7:
            java.util.logging.Logger r2 = io.grpc.internal.j0.f33237x
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r2.log(r5, r4, r1)
            goto Lbe
        Laf:
            java.util.logging.Logger r2 = io.grpc.internal.j0.f33237x
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r2.log(r5, r4, r1)
            goto Lbe
        Lb7:
            java.util.logging.Logger r2 = io.grpc.internal.j0.f33237x
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r2.log(r5, r4, r1)
        Lbe:
            if (r3 == 0) goto Lc3
            r0.add(r3)
        Lc3:
            java.util.List<j9.J$a> r9 = r9.f33243h
            r0.addAll(r9)
            r0.trimToSize()
            java.util.List r9 = java.util.Collections.unmodifiableList(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.j0.getTracerFactories():java.util.List");
    }

    @Override // j9.F
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public j0 directExecutor() {
        return executor(MoreExecutors.a());
    }

    @Override // j9.F
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public j0 executor(Executor executor) {
        U<? extends Executor> u10;
        if (executor != null) {
            u10 = new C1140w<>(executor);
        } else {
            u10 = f33238y;
        }
        this.f33246k = u10;
        return this;
    }

    @Override // j9.F
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public j0 fallbackHandlerRegistry(j9.s sVar) {
        if (sVar == null) {
            sVar = f33239z;
        }
        this.f33245j = sVar;
        return this;
    }

    @Override // j9.F
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public j0 handshakeTimeout(long j10, TimeUnit timeUnit) {
        boolean z10;
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.j(z10, "handshake timeout is %s, but must be positive", j10);
        this.f33249n = ((TimeUnit) com.google.common.base.k.p(timeUnit, "unit")).toMillis(j10);
        return this;
    }

    @Override // j9.F
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public j0 intercept(io.grpc.C c10) {
        this.f33242g.add((io.grpc.C) com.google.common.base.k.p(c10, "interceptor"));
        return this;
    }

    @Override // j9.F
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public j0 useTransportSecurity(File file, File file2) {
        throw new UnsupportedOperationException("TLS not supported in ServerImplBuilder");
    }

    @Override // j9.F
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public j0 setBinaryLog(AbstractC1191a abstractC1191a) {
        return this;
    }
}
