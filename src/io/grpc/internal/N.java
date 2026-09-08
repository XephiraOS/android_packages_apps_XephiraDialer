package io.grpc.internal;

import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.C1107a;
import io.grpc.C1114h;
import io.grpc.InternalChannelz;
import io.grpc.internal.C1137t;
import io.grpc.v;
import j9.AbstractC1190B;
import j9.AbstractC1191a;
import j9.AbstractC1193c;
import j9.AbstractC1195e;
import j9.C1200j;
import j9.InterfaceC1196f;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ManagedChannelImplBuilder.java */
/* loaded from: classes4.dex */
public final class N extends io.grpc.t<N> {

    /* renamed from: Q, reason: collision with root package name */
    public static final Method f32784Q;

    /* renamed from: A, reason: collision with root package name */
    public boolean f32785A;

    /* renamed from: B, reason: collision with root package name */
    public j9.E f32786B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f32787C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f32788D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f32789E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f32790F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f32791G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f32792H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f32793I;

    /* renamed from: J, reason: collision with root package name */
    public final c f32794J;

    /* renamed from: K, reason: collision with root package name */
    public final b f32795K;

    /* renamed from: e, reason: collision with root package name */
    public U<? extends Executor> f32796e;

    /* renamed from: f, reason: collision with root package name */
    public U<? extends Executor> f32797f;

    /* renamed from: g, reason: collision with root package name */
    public final List<InterfaceC1196f> f32798g;

    /* renamed from: h, reason: collision with root package name */
    public io.grpc.x f32799h;

    /* renamed from: i, reason: collision with root package name */
    public final String f32800i;

    /* renamed from: j, reason: collision with root package name */
    public final AbstractC1193c f32801j;

    /* renamed from: k, reason: collision with root package name */
    public final SocketAddress f32802k;

    /* renamed from: l, reason: collision with root package name */
    public String f32803l;

    /* renamed from: m, reason: collision with root package name */
    public String f32804m;

    /* renamed from: n, reason: collision with root package name */
    public String f32805n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f32806o;

    /* renamed from: p, reason: collision with root package name */
    public j9.o f32807p;

    /* renamed from: q, reason: collision with root package name */
    public C1200j f32808q;

    /* renamed from: r, reason: collision with root package name */
    public long f32809r;

    /* renamed from: s, reason: collision with root package name */
    public int f32810s;

    /* renamed from: t, reason: collision with root package name */
    public int f32811t;

    /* renamed from: u, reason: collision with root package name */
    public long f32812u;

    /* renamed from: v, reason: collision with root package name */
    public long f32813v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f32814w;

    /* renamed from: x, reason: collision with root package name */
    public InternalChannelz f32815x;

    /* renamed from: y, reason: collision with root package name */
    public int f32816y;

    /* renamed from: z, reason: collision with root package name */
    public Map<String, ?> f32817z;

    /* renamed from: L, reason: collision with root package name */
    public static final Logger f32779L = Logger.getLogger(N.class.getName());
    static final long IDLE_MODE_MAX_TIMEOUT_DAYS = 30;
    static final long IDLE_MODE_DEFAULT_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(IDLE_MODE_MAX_TIMEOUT_DAYS);

    /* renamed from: M, reason: collision with root package name */
    public static final long f32780M = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: N, reason: collision with root package name */
    public static final U<? extends Executor> f32781N = r0.c(GrpcUtil.f32539u);

    /* renamed from: O, reason: collision with root package name */
    public static final j9.o f32782O = j9.o.c();

    /* renamed from: P, reason: collision with root package name */
    public static final C1200j f32783P = C1200j.a();

    /* compiled from: ManagedChannelImplBuilder.java */
    /* loaded from: classes4.dex */
    public interface b {
        int a();
    }

    /* compiled from: ManagedChannelImplBuilder.java */
    /* loaded from: classes4.dex */
    public interface c {
        InterfaceC1130l buildClientTransportFactory();
    }

    /* compiled from: ManagedChannelImplBuilder.java */
    /* loaded from: classes4.dex */
    public static final class e implements b {
        public e() {
        }

        @Override // io.grpc.internal.N.b
        public int a() {
            return 443;
        }
    }

    static {
        Method method;
        try {
            Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
            Class cls2 = Boolean.TYPE;
            method = cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2);
        } catch (ClassNotFoundException e10) {
            f32779L.log(Level.FINE, "Unable to apply census stats", (Throwable) e10);
            method = null;
            f32784Q = method;
        } catch (NoSuchMethodException e11) {
            f32779L.log(Level.FINE, "Unable to apply census stats", (Throwable) e11);
            method = null;
            f32784Q = method;
        }
        f32784Q = method;
    }

    public N(SocketAddress socketAddress, String str, c cVar, b bVar) {
        this(socketAddress, str, null, null, cVar, bVar);
    }

    public static List<?> a(List<?> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            if (obj == null) {
                arrayList.add(null);
            } else if (obj instanceof Map) {
                arrayList.add(b((Map) obj));
            } else if (obj instanceof List) {
                arrayList.add(a((List) obj));
            } else if (obj instanceof String) {
                arrayList.add(obj);
            } else if (obj instanceof Double) {
                arrayList.add(obj);
            } else if (obj instanceof Boolean) {
                arrayList.add(obj);
            } else {
                throw new IllegalArgumentException("The entry '" + obj + "' is of type '" + obj.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Map<String, ?> b(Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            com.google.common.base.k.k(entry.getKey() instanceof String, "The key of the entry '%s' is not of String type", entry);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                linkedHashMap.put(str, null);
            } else if (value instanceof Map) {
                linkedHashMap.put(str, b((Map) value));
            } else if (value instanceof List) {
                linkedHashMap.put(str, a((List) value));
            } else if (value instanceof String) {
                linkedHashMap.put(str, value);
            } else if (value instanceof Double) {
                linkedHashMap.put(str, value);
            } else if (value instanceof Boolean) {
                linkedHashMap.put(str, value);
            } else {
                throw new IllegalArgumentException("The value of the map entry '" + entry + "' is of type '" + value.getClass() + "', which is not supported");
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static String makeTargetStringForDirectAddress(SocketAddress socketAddress) {
        try {
            return new URI("directaddress", "", "/" + socketAddress, null).toString();
        } catch (URISyntaxException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // io.grpc.t
    public AbstractC1190B build() {
        return new ManagedChannelOrphanWrapper(new ManagedChannelImpl(this, this.f32794J.buildClientTransportFactory(), new C1137t.a(), r0.c(GrpcUtil.f32539u), GrpcUtil.f32541w, getEffectiveInterceptors(), v0.f33408a));
    }

    @Override // io.grpc.t
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public N compressorRegistry(C1200j c1200j) {
        if (c1200j != null) {
            this.f32808q = c1200j;
        } else {
            this.f32808q = f32783P;
        }
        return this;
    }

    public String checkAuthority(String str) {
        if (this.f32787C) {
            return str;
        }
        return GrpcUtil.c(str);
    }

    @Override // io.grpc.t
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public N decompressorRegistry(j9.o oVar) {
        if (oVar != null) {
            this.f32807p = oVar;
        } else {
            this.f32807p = f32782O;
        }
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public N defaultLoadBalancingPolicy(String str) {
        boolean z10;
        SocketAddress socketAddress = this.f32802k;
        boolean z11 = false;
        if (socketAddress == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.x(z10, "directServerAddress is set (%s), which forbids the use of load-balancing policy", socketAddress);
        if (str != null) {
            z11 = true;
        }
        com.google.common.base.k.e(z11, "policy cannot be null");
        this.f32805n = str;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public N defaultServiceConfig(Map<String, ?> map) {
        this.f32817z = b(map);
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public N directExecutor() {
        return executor(MoreExecutors.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<j9.InterfaceC1196f> getEffectiveInterceptors() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<j9.f> r1 = r10.f32798g
            r0.<init>(r1)
            java.util.List r1 = j9.u.a()
            r2 = 0
            if (r1 == 0) goto L13
            r0.addAll(r1)
            r1 = 1
            goto L14
        L13:
            r1 = r2
        L14:
            java.lang.String r3 = "Unable to apply census stats"
            r4 = 0
            if (r1 != 0) goto L5d
            boolean r5 = r10.f32788D
            if (r5 == 0) goto L5d
            java.lang.reflect.Method r5 = io.grpc.internal.N.f32784Q
            if (r5 == 0) goto L57
            boolean r6 = r10.f32789E     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            boolean r7 = r10.f32790F     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            boolean r8 = r10.f32791G     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            boolean r9 = r10.f32792H     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7, r8, r9}     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            java.lang.Object r5 = r5.invoke(r4, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            j9.f r5 = (j9.InterfaceC1196f) r5     // Catch: java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L46
            goto L58
        L44:
            r5 = move-exception
            goto L48
        L46:
            r5 = move-exception
            goto L50
        L48:
            java.util.logging.Logger r6 = io.grpc.internal.N.f32779L
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r3, r5)
            goto L57
        L50:
            java.util.logging.Logger r6 = io.grpc.internal.N.f32779L
            java.util.logging.Level r7 = java.util.logging.Level.FINE
            r6.log(r7, r3, r5)
        L57:
            r5 = r4
        L58:
            if (r5 == 0) goto L5d
            r0.add(r2, r5)
        L5d:
            if (r1 != 0) goto La3
            boolean r10 = r10.f32793I
            if (r10 == 0) goto La3
            java.lang.String r10 = "io.grpc.census.InternalCensusTracingAccessor"
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch: java.lang.reflect.InvocationTargetException -> L77 java.lang.IllegalAccessException -> L79 java.lang.NoSuchMethodException -> L7b java.lang.ClassNotFoundException -> L7d
            java.lang.String r1 = "getClientInterceptor"
            java.lang.reflect.Method r10 = r10.getDeclaredMethod(r1, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L77 java.lang.IllegalAccessException -> L79 java.lang.NoSuchMethodException -> L7b java.lang.ClassNotFoundException -> L7d
            java.lang.Object r10 = r10.invoke(r4, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L77 java.lang.IllegalAccessException -> L79 java.lang.NoSuchMethodException -> L7b java.lang.ClassNotFoundException -> L7d
            j9.f r10 = (j9.InterfaceC1196f) r10     // Catch: java.lang.reflect.InvocationTargetException -> L77 java.lang.IllegalAccessException -> L79 java.lang.NoSuchMethodException -> L7b java.lang.ClassNotFoundException -> L7d
            r4 = r10
            goto L9e
        L77:
            r10 = move-exception
            goto L7f
        L79:
            r10 = move-exception
            goto L87
        L7b:
            r10 = move-exception
            goto L8f
        L7d:
            r10 = move-exception
            goto L97
        L7f:
            java.util.logging.Logger r1 = io.grpc.internal.N.f32779L
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r1.log(r5, r3, r10)
            goto L9e
        L87:
            java.util.logging.Logger r1 = io.grpc.internal.N.f32779L
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r1.log(r5, r3, r10)
            goto L9e
        L8f:
            java.util.logging.Logger r1 = io.grpc.internal.N.f32779L
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r1.log(r5, r3, r10)
            goto L9e
        L97:
            java.util.logging.Logger r1 = io.grpc.internal.N.f32779L
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r1.log(r5, r3, r10)
        L9e:
            if (r4 == 0) goto La3
            r0.add(r2, r4)
        La3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.N.getEffectiveInterceptors():java.util.List");
    }

    @Override // io.grpc.t
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public N disableRetry() {
        this.f32814w = false;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public N disableServiceConfigLookUp() {
        this.f32785A = false;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public N enableRetry() {
        this.f32814w = true;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public N executor(Executor executor) {
        if (executor != null) {
            this.f32796e = new C1140w(executor);
        } else {
            this.f32796e = f32781N;
        }
        return this;
    }

    public int l() {
        return this.f32795K.a();
    }

    @Override // io.grpc.t
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public N idleTimeout(long j10, TimeUnit timeUnit) {
        boolean z10;
        if (j10 > IDLE_MODE_DEFAULT_TIMEOUT_MILLIS) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.j(z10, "idle timeout is %s, but must be positive", j10);
        if (timeUnit.toDays(j10) >= IDLE_MODE_MAX_TIMEOUT_DAYS) {
            this.f32809r = -1L;
        } else {
            this.f32809r = Math.max(timeUnit.toMillis(j10), f32780M);
        }
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public N intercept(List<InterfaceC1196f> list) {
        this.f32798g.addAll(list);
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public N intercept(InterfaceC1196f... interfaceC1196fArr) {
        return intercept(Arrays.asList(interfaceC1196fArr));
    }

    @Override // io.grpc.t
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public N maxHedgedAttempts(int i10) {
        this.f32811t = i10;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public N maxRetryAttempts(int i10) {
        this.f32810s = i10;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public N maxTraceEvents(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "maxTraceEvents must be non-negative");
        this.f32816y = i10;
        return this;
    }

    @Override // io.grpc.t
    @Deprecated
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public N nameResolverFactory(v.d dVar) {
        boolean z10;
        SocketAddress socketAddress = this.f32802k;
        if (socketAddress == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.x(z10, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", socketAddress);
        if (dVar != null) {
            io.grpc.x xVar = new io.grpc.x();
            if (dVar instanceof io.grpc.w) {
                xVar.f((io.grpc.w) dVar);
            } else {
                xVar.f(new S(dVar));
            }
            this.f32799h = xVar;
        } else {
            this.f32799h = io.grpc.x.b();
        }
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public N offloadExecutor(Executor executor) {
        if (executor != null) {
            this.f32797f = new C1140w(executor);
        } else {
            this.f32797f = f32781N;
        }
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public N overrideAuthority(String str) {
        this.f32804m = checkAuthority(str);
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public N perRpcBufferLimit(long j10) {
        boolean z10;
        if (j10 > IDLE_MODE_DEFAULT_TIMEOUT_MILLIS) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "per RPC buffer limit must be positive");
        this.f32813v = j10;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public N proxyDetector(j9.E e10) {
        this.f32786B = e10;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public N retryBufferSize(long j10) {
        boolean z10;
        if (j10 > IDLE_MODE_DEFAULT_TIMEOUT_MILLIS) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "retry buffer size must be positive");
        this.f32812u = j10;
        return this;
    }

    @Override // io.grpc.t
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public N userAgent(String str) {
        this.f32803l = str;
        return this;
    }

    public N(SocketAddress socketAddress, String str, AbstractC1195e abstractC1195e, AbstractC1193c abstractC1193c, c cVar, b bVar) {
        U<? extends Executor> u10 = f32781N;
        this.f32796e = u10;
        this.f32797f = u10;
        this.f32798g = new ArrayList();
        this.f32799h = io.grpc.x.b();
        this.f32805n = "pick_first";
        this.f32807p = f32782O;
        this.f32808q = f32783P;
        this.f32809r = IDLE_MODE_DEFAULT_TIMEOUT_MILLIS;
        this.f32810s = 5;
        this.f32811t = 5;
        this.f32812u = 16777216L;
        this.f32813v = 1048576L;
        this.f32814w = true;
        this.f32815x = InternalChannelz.i();
        this.f32785A = true;
        this.f32788D = true;
        this.f32789E = true;
        this.f32790F = true;
        this.f32791G = false;
        this.f32792H = true;
        this.f32793I = true;
        this.f32800i = makeTargetStringForDirectAddress(socketAddress);
        this.f32801j = abstractC1193c;
        this.f32794J = (c) com.google.common.base.k.p(cVar, "clientTransportFactoryBuilder");
        this.f32802k = socketAddress;
        io.grpc.x xVar = new io.grpc.x();
        xVar.f(new d(socketAddress, str));
        this.f32799h = xVar;
        if (bVar != null) {
            this.f32795K = bVar;
        } else {
            this.f32795K = new e();
        }
    }

    /* compiled from: ManagedChannelImplBuilder.java */
    /* loaded from: classes4.dex */
    public static class d extends io.grpc.w {

        /* renamed from: a, reason: collision with root package name */
        public final SocketAddress f32818a;

        /* renamed from: b, reason: collision with root package name */
        public final String f32819b;

        /* renamed from: c, reason: collision with root package name */
        public final Collection<Class<? extends SocketAddress>> f32820c;

        public d(SocketAddress socketAddress, String str) {
            this.f32818a = socketAddress;
            this.f32819b = str;
            this.f32820c = Collections.singleton(socketAddress.getClass());
        }

        @Override // io.grpc.v.d
        public String a() {
            return "directaddress";
        }

        @Override // io.grpc.v.d
        public io.grpc.v b(URI uri, v.b bVar) {
            return new a();
        }

        @Override // io.grpc.w
        public Collection<Class<? extends SocketAddress>> c() {
            return this.f32820c;
        }

        @Override // io.grpc.w
        public boolean e() {
            return true;
        }

        @Override // io.grpc.w
        public int f() {
            return 5;
        }

        /* compiled from: ManagedChannelImplBuilder.java */
        /* loaded from: classes4.dex */
        public class a extends io.grpc.v {
            public a() {
            }

            @Override // io.grpc.v
            public String a() {
                return d.this.f32819b;
            }

            @Override // io.grpc.v
            public void d(v.e eVar) {
                eVar.c(v.g.d().b(Collections.singletonList(new C1114h(d.this.f32818a))).c(C1107a.f32411c).a());
            }

            @Override // io.grpc.v
            public void c() {
            }
        }
    }

    @Override // io.grpc.t
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public N setBinaryLog(AbstractC1191a abstractC1191a) {
        return this;
    }
}
