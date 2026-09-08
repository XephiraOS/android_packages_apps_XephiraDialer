package io.grpc.internal;

import com.oplus.backup.sdk.common.utils.Constants;
import io.grpc.AbstractC1109c;
import io.grpc.AbstractC1112f;
import io.grpc.C1107a;
import io.grpc.C1108b;
import io.grpc.C1111e;
import io.grpc.C1114h;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.Context;
import io.grpc.InternalChannelz;
import io.grpc.InternalChannelz$ChannelTrace$Event;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.AutoConfiguredLoadBalancerFactory;
import io.grpc.internal.C1125g;
import io.grpc.internal.C1127i;
import io.grpc.internal.C1137t;
import io.grpc.internal.InterfaceC1117c;
import io.grpc.internal.InternalSubchannel;
import io.grpc.internal.O;
import io.grpc.internal.P;
import io.grpc.internal.RetryingNameResolver;
import io.grpc.internal.c0;
import io.grpc.l;
import io.grpc.q;
import io.grpc.v;
import j9.AbstractC1190B;
import j9.AbstractC1194d;
import j9.C1200j;
import j9.C1201k;
import j9.C1203m;
import j9.InterfaceC1196f;
import j9.N;
import java.lang.Thread;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class ManagedChannelImpl extends AbstractC1190B implements j9.v<Object> {
    static final Status SHUTDOWN_NOW_STATUS;
    static final Status SHUTDOWN_STATUS;
    static final Status SUBCHANNEL_SHUTDOWN_STATUS;

    /* renamed from: j0, reason: collision with root package name */
    public static final O f32610j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final io.grpc.l f32611k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final AbstractC1109c<Object, Object> f32612l0;

    /* renamed from: A, reason: collision with root package name */
    public io.grpc.v f32613A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f32614B;

    /* renamed from: C, reason: collision with root package name */
    public o f32615C;

    /* renamed from: D, reason: collision with root package name */
    public volatile q.j f32616D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f32617E;

    /* renamed from: F, reason: collision with root package name */
    public final Set<InternalSubchannel> f32618F;

    /* renamed from: G, reason: collision with root package name */
    public Collection<q.g<?, ?>> f32619G;

    /* renamed from: H, reason: collision with root package name */
    public final Object f32620H;

    /* renamed from: I, reason: collision with root package name */
    public final Set<V> f32621I;

    /* renamed from: J, reason: collision with root package name */
    public final C1135q f32622J;

    /* renamed from: K, reason: collision with root package name */
    public final t f32623K;

    /* renamed from: L, reason: collision with root package name */
    public final AtomicBoolean f32624L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f32625M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f32626N;

    /* renamed from: O, reason: collision with root package name */
    public volatile boolean f32627O;

    /* renamed from: P, reason: collision with root package name */
    public final CountDownLatch f32628P;

    /* renamed from: Q, reason: collision with root package name */
    public final C1125g.b f32629Q;

    /* renamed from: R, reason: collision with root package name */
    public final C1125g f32630R;

    /* renamed from: S, reason: collision with root package name */
    public final ChannelTracer f32631S;

    /* renamed from: T, reason: collision with root package name */
    public final ChannelLogger f32632T;

    /* renamed from: U, reason: collision with root package name */
    public final InternalChannelz f32633U;

    /* renamed from: V, reason: collision with root package name */
    public final q f32634V;

    /* renamed from: W, reason: collision with root package name */
    public ResolutionState f32635W;

    /* renamed from: X, reason: collision with root package name */
    public O f32636X;

    /* renamed from: Y, reason: collision with root package name */
    public final O f32637Y;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f32638Z;

    /* renamed from: a, reason: collision with root package name */
    public final j9.w f32639a;

    /* renamed from: a0, reason: collision with root package name */
    public final boolean f32640a0;

    /* renamed from: b, reason: collision with root package name */
    public final String f32641b;

    /* renamed from: b0, reason: collision with root package name */
    public final c0.t f32642b0;

    /* renamed from: c, reason: collision with root package name */
    public final String f32643c;

    /* renamed from: c0, reason: collision with root package name */
    public final long f32644c0;

    /* renamed from: d, reason: collision with root package name */
    public final io.grpc.x f32645d;

    /* renamed from: d0, reason: collision with root package name */
    public final long f32646d0;

    /* renamed from: e, reason: collision with root package name */
    public final v.b f32647e;

    /* renamed from: e0, reason: collision with root package name */
    public final boolean f32648e0;

    /* renamed from: f, reason: collision with root package name */
    public final AutoConfiguredLoadBalancerFactory f32649f;

    /* renamed from: f0, reason: collision with root package name */
    public final C1203m.c f32650f0;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC1130l f32651g;

    /* renamed from: g0, reason: collision with root package name */
    public final P.a f32652g0;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC1130l f32653h;

    /* renamed from: h0, reason: collision with root package name */
    public final j f32654h0;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC1130l f32655i;

    /* renamed from: i0, reason: collision with root package name */
    public final b0 f32656i0;
    final E<Object> inUseStateAggregator;

    /* renamed from: j, reason: collision with root package name */
    public final r f32657j;

    /* renamed from: k, reason: collision with root package name */
    public final Executor f32658k;

    /* renamed from: l, reason: collision with root package name */
    public final U<? extends Executor> f32659l;

    /* renamed from: m, reason: collision with root package name */
    public final U<? extends Executor> f32660m;

    /* renamed from: n, reason: collision with root package name */
    public final ExecutorHolder f32661n;

    /* renamed from: o, reason: collision with root package name */
    public final ExecutorHolder f32662o;

    /* renamed from: p, reason: collision with root package name */
    public final v0 f32663p;

    /* renamed from: q, reason: collision with root package name */
    public final int f32664q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f32665r;

    /* renamed from: s, reason: collision with root package name */
    public final j9.o f32666s;
    final j9.N syncContext;

    /* renamed from: t, reason: collision with root package name */
    public final C1200j f32667t;

    /* renamed from: u, reason: collision with root package name */
    public final com.google.common.base.o<com.google.common.base.m> f32668u;

    /* renamed from: v, reason: collision with root package name */
    public final long f32669v;

    /* renamed from: w, reason: collision with root package name */
    public final C1132n f32670w;

    /* renamed from: x, reason: collision with root package name */
    public final InterfaceC1117c.a f32671x;

    /* renamed from: y, reason: collision with root package name */
    public final AbstractC1194d f32672y;

    /* renamed from: z, reason: collision with root package name */
    public final String f32673z;
    static final Logger logger = Logger.getLogger(ManagedChannelImpl.class.getName());
    static final Pattern URI_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");

    /* loaded from: classes4.dex */
    public static final class ExecutorHolder implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final U<? extends Executor> f32674a;

        /* renamed from: b, reason: collision with root package name */
        public Executor f32675b;

        public ExecutorHolder(U<? extends Executor> u10) {
            this.f32674a = (U) com.google.common.base.k.p(u10, "executorPool");
        }

        public synchronized Executor a() {
            try {
                if (this.f32675b == null) {
                    this.f32675b = (Executor) com.google.common.base.k.q(this.f32674a.a(), "%s.getObject()", this.f32675b);
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f32675b;
        }

        public synchronized void b() {
            Executor executor = this.f32675b;
            if (executor != null) {
                this.f32675b = this.f32674a.b(executor);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a().execute(runnable);
        }
    }

    /* loaded from: classes4.dex */
    public enum ResolutionState {
        NO_RESOLUTION,
        SUCCESS,
        ERROR
    }

    /* loaded from: classes4.dex */
    public class a extends io.grpc.l {
        @Override // io.grpc.l
        public l.b a(q.g gVar) {
            throw new IllegalStateException("Resolution is pending");
        }
    }

    /* loaded from: classes4.dex */
    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ManagedChannelImpl.this.m0(true);
        }
    }

    /* loaded from: classes4.dex */
    public final class c implements C1125g.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v0 f32681a;

        public c(v0 v0Var) {
            this.f32681a = v0Var;
        }

        @Override // io.grpc.internal.C1125g.b
        public C1125g create() {
            return new C1125g(this.f32681a);
        }
    }

    /* loaded from: classes4.dex */
    public final class d extends q.j {

        /* renamed from: a, reason: collision with root package name */
        public final q.f f32683a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f32684b;

        public d(Throwable th) {
            this.f32684b = th;
            this.f32683a = q.f.e(Status.f32382s.r("Panic! This is a bug!").q(th));
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            return this.f32683a;
        }

        public String toString() {
            return com.google.common.base.f.b(d.class).d("panicPickResult", this.f32683a).toString();
        }
    }

    /* loaded from: classes4.dex */
    public final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ManagedChannelImpl.this.f32632T.a(ChannelLogger.ChannelLogLevel.INFO, "Entering SHUTDOWN state");
            ManagedChannelImpl.this.f32670w.a(ConnectivityState.SHUTDOWN);
        }
    }

    /* loaded from: classes4.dex */
    public final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ManagedChannelImpl.this.f32625M) {
                ManagedChannelImpl.this.f32625M = true;
                ManagedChannelImpl.this.q0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Thread.UncaughtExceptionHandler {
        public g() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            ManagedChannelImpl.logger.log(Level.SEVERE, "[" + ManagedChannelImpl.this.getLogId() + "] Uncaught exception in the SynchronizationContext. Panic!", th);
            ManagedChannelImpl.this.panic(th);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends B {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f32689b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(io.grpc.v vVar, String str) {
            super(vVar);
            this.f32689b = str;
        }

        @Override // io.grpc.internal.B, io.grpc.v
        public String a() {
            return this.f32689b;
        }
    }

    /* loaded from: classes4.dex */
    public final class j implements C1127i.e {

        /* renamed from: a, reason: collision with root package name */
        public volatile c0.D f32690a;

        /* loaded from: classes4.dex */
        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.exitIdleMode();
            }
        }

        /* loaded from: classes4.dex */
        public final class b<ReqT> extends c0<ReqT> {

            /* renamed from: C, reason: collision with root package name */
            public final /* synthetic */ MethodDescriptor f32693C;

            /* renamed from: D, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f32694D;

            /* renamed from: E, reason: collision with root package name */
            public final /* synthetic */ C1108b f32695E;

            /* renamed from: F, reason: collision with root package name */
            public final /* synthetic */ d0 f32696F;

            /* renamed from: G, reason: collision with root package name */
            public final /* synthetic */ D f32697G;

            /* renamed from: H, reason: collision with root package name */
            public final /* synthetic */ Context f32698H;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(MethodDescriptor methodDescriptor, io.grpc.u uVar, C1108b c1108b, d0 d0Var, D d10, Context context) {
                super(methodDescriptor, uVar, ManagedChannelImpl.this.f32642b0, ManagedChannelImpl.this.f32644c0, ManagedChannelImpl.this.f32646d0, ManagedChannelImpl.this.o0(c1108b), ManagedChannelImpl.this.f32653h.getScheduledExecutorService(), d0Var, d10, j.this.f32690a);
                this.f32693C = methodDescriptor;
                this.f32694D = uVar;
                this.f32695E = c1108b;
                this.f32696F = d0Var;
                this.f32697G = d10;
                this.f32698H = context;
            }

            @Override // io.grpc.internal.c0
            public InterfaceC1128j N(io.grpc.u uVar, AbstractC1112f.a aVar, int i10, boolean z10) {
                C1108b t10 = this.f32695E.t(aVar);
                AbstractC1112f[] f10 = GrpcUtil.f(t10, uVar, i10, z10);
                InterfaceC1129k c10 = j.this.c(new Y(this.f32693C, uVar, t10));
                Context c11 = this.f32698H.c();
                try {
                    return c10.newStream(this.f32693C, uVar, t10, f10);
                } finally {
                    this.f32698H.o(c11);
                }
            }

            @Override // io.grpc.internal.c0
            public void O() {
                ManagedChannelImpl.this.f32623K.d(this);
            }

            @Override // io.grpc.internal.c0
            public Status P() {
                return ManagedChannelImpl.this.f32623K.a(this);
            }
        }

        public j() {
        }

        @Override // io.grpc.internal.C1127i.e
        public InterfaceC1128j a(MethodDescriptor<?, ?> methodDescriptor, C1108b c1108b, io.grpc.u uVar, Context context) {
            d0 d0Var;
            if (!ManagedChannelImpl.this.f32648e0) {
                InterfaceC1129k c10 = c(new Y(methodDescriptor, uVar, c1108b));
                Context c11 = context.c();
                try {
                    return c10.newStream(methodDescriptor, uVar, c1108b, GrpcUtil.f(c1108b, uVar, 0, false));
                } finally {
                    context.o(c11);
                }
            }
            O.b bVar = (O.b) c1108b.h(O.b.f32828g);
            D d10 = null;
            if (bVar == null) {
                d0Var = null;
            } else {
                d0Var = bVar.f32833e;
            }
            if (bVar != null) {
                d10 = bVar.f32834f;
            }
            return new b(methodDescriptor, uVar, c1108b, d0Var, d10, context);
        }

        public final InterfaceC1129k c(q.g gVar) {
            q.j jVar = ManagedChannelImpl.this.f32616D;
            if (ManagedChannelImpl.this.f32624L.get()) {
                return ManagedChannelImpl.this.f32622J;
            }
            if (jVar == null) {
                ManagedChannelImpl.this.syncContext.execute(new a());
                return ManagedChannelImpl.this.f32622J;
            }
            InterfaceC1129k j10 = GrpcUtil.j(jVar.a(gVar), gVar.a().j());
            if (j10 == null) {
                return ManagedChannelImpl.this.f32622J;
            }
            return j10;
        }

        public /* synthetic */ j(ManagedChannelImpl managedChannelImpl, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static final class k<ReqT, RespT> extends io.grpc.j<ReqT, RespT> {

        /* renamed from: a, reason: collision with root package name */
        public final io.grpc.l f32700a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC1194d f32701b;

        /* renamed from: c, reason: collision with root package name */
        public final Executor f32702c;

        /* renamed from: d, reason: collision with root package name */
        public final MethodDescriptor<ReqT, RespT> f32703d;

        /* renamed from: e, reason: collision with root package name */
        public final Context f32704e;

        /* renamed from: f, reason: collision with root package name */
        public C1108b f32705f;

        /* renamed from: g, reason: collision with root package name */
        public AbstractC1109c<ReqT, RespT> f32706g;

        /* loaded from: classes4.dex */
        public class a extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AbstractC1109c.a f32707b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Status f32708c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AbstractC1109c.a aVar, Status status) {
                super(k.this.f32704e);
                this.f32707b = aVar;
                this.f32708c = status;
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                this.f32707b.a(this.f32708c, new io.grpc.u());
            }
        }

        public k(io.grpc.l lVar, AbstractC1194d abstractC1194d, Executor executor, MethodDescriptor<ReqT, RespT> methodDescriptor, C1108b c1108b) {
            this.f32700a = lVar;
            this.f32701b = abstractC1194d;
            this.f32703d = methodDescriptor;
            executor = c1108b.e() != null ? c1108b.e() : executor;
            this.f32702c = executor;
            this.f32705f = c1108b.p(executor);
            this.f32704e = Context.l();
        }

        @Override // io.grpc.AbstractC1109c
        public void a(String str, Throwable th) {
            AbstractC1109c<ReqT, RespT> abstractC1109c = this.f32706g;
            if (abstractC1109c != null) {
                abstractC1109c.a(str, th);
            }
        }

        @Override // io.grpc.AbstractC1109c
        public void e(AbstractC1109c.a<RespT> aVar, io.grpc.u uVar) {
            l.b a10 = this.f32700a.a(new Y(this.f32703d, uVar, this.f32705f));
            Status c10 = a10.c();
            if (!c10.o()) {
                h(aVar, GrpcUtil.l(c10));
                this.f32706g = ManagedChannelImpl.f32612l0;
                return;
            }
            InterfaceC1196f b10 = a10.b();
            O.b e10 = ((O) a10.a()).e(this.f32703d);
            if (e10 != null) {
                this.f32705f = this.f32705f.s(O.b.f32828g, e10);
            }
            if (b10 != null) {
                this.f32706g = b10.a(this.f32703d, this.f32705f, this.f32701b);
            } else {
                this.f32706g = this.f32701b.b(this.f32703d, this.f32705f);
            }
            this.f32706g.e(aVar, uVar);
        }

        @Override // io.grpc.j, j9.C
        public AbstractC1109c<ReqT, RespT> f() {
            return this.f32706g;
        }

        public final void h(AbstractC1109c.a<RespT> aVar, Status status) {
            this.f32702c.execute(new a(aVar, status));
        }
    }

    /* loaded from: classes4.dex */
    public final class l implements P.a {
        public l() {
        }

        @Override // io.grpc.internal.P.a
        public void a() {
            com.google.common.base.k.v(ManagedChannelImpl.this.f32624L.get(), "Channel must have been shut down");
            ManagedChannelImpl.this.f32626N = true;
            ManagedChannelImpl.this.v0(false);
            ManagedChannelImpl.this.q0();
            ManagedChannelImpl.this.r0();
        }

        @Override // io.grpc.internal.P.a
        public void b(Status status) {
            com.google.common.base.k.v(ManagedChannelImpl.this.f32624L.get(), "Channel must have been shut down");
        }

        @Override // io.grpc.internal.P.a
        public void d(boolean z10) {
            ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
            managedChannelImpl.inUseStateAggregator.updateObjectInUse(managedChannelImpl.f32622J, z10);
        }

        public /* synthetic */ l(ManagedChannelImpl managedChannelImpl, a aVar) {
            this();
        }

        @Override // io.grpc.internal.P.a
        public void c() {
        }
    }

    /* loaded from: classes4.dex */
    public final class m extends E<Object> {
        public m() {
        }

        @Override // io.grpc.internal.E
        public void handleInUse() {
            ManagedChannelImpl.this.exitIdleMode();
        }

        @Override // io.grpc.internal.E
        public void handleNotInUse() {
            if (!ManagedChannelImpl.this.f32624L.get()) {
                ManagedChannelImpl.this.t0();
            }
        }

        public /* synthetic */ m(ManagedChannelImpl managedChannelImpl, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ManagedChannelImpl.this.f32615C != null) {
                ManagedChannelImpl.this.n0();
            }
        }

        public /* synthetic */ n(ManagedChannelImpl managedChannelImpl, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public final class o extends q.e {

        /* renamed from: a, reason: collision with root package name */
        public AutoConfiguredLoadBalancerFactory.AutoConfiguredLoadBalancer f32713a;

        /* loaded from: classes4.dex */
        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.s0();
            }
        }

        /* loaded from: classes4.dex */
        public final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q.j f32716a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ConnectivityState f32717b;

            public b(q.j jVar, ConnectivityState connectivityState) {
                this.f32716a = jVar;
                this.f32717b = connectivityState;
            }

            @Override // java.lang.Runnable
            public void run() {
                o oVar = o.this;
                if (oVar == ManagedChannelImpl.this.f32615C) {
                    ManagedChannelImpl.this.x0(this.f32716a);
                    if (this.f32717b != ConnectivityState.SHUTDOWN) {
                        ManagedChannelImpl.this.f32632T.b(ChannelLogger.ChannelLogLevel.INFO, "Entering {0} state with picker: {1}", this.f32717b, this.f32716a);
                        ManagedChannelImpl.this.f32670w.a(this.f32717b);
                    }
                }
            }
        }

        public o() {
        }

        @Override // io.grpc.q.e
        public ChannelLogger b() {
            return ManagedChannelImpl.this.f32632T;
        }

        @Override // io.grpc.q.e
        public ScheduledExecutorService c() {
            return ManagedChannelImpl.this.f32657j;
        }

        @Override // io.grpc.q.e
        public j9.N d() {
            return ManagedChannelImpl.this.syncContext;
        }

        @Override // io.grpc.q.e
        public void e() {
            ManagedChannelImpl.this.syncContext.e();
            ManagedChannelImpl.this.syncContext.execute(new a());
        }

        @Override // io.grpc.q.e
        public void f(ConnectivityState connectivityState, q.j jVar) {
            ManagedChannelImpl.this.syncContext.e();
            com.google.common.base.k.p(connectivityState, "newState");
            com.google.common.base.k.p(jVar, "newPicker");
            ManagedChannelImpl.this.syncContext.execute(new b(jVar, connectivityState));
        }

        @Override // io.grpc.q.e
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public AbstractC1115a a(q.b bVar) {
            ManagedChannelImpl.this.syncContext.e();
            com.google.common.base.k.v(!ManagedChannelImpl.this.f32626N, "Channel is being terminated");
            return new s(bVar);
        }

        public /* synthetic */ o(ManagedChannelImpl managedChannelImpl, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public final class p extends v.e {

        /* renamed from: a, reason: collision with root package name */
        public final o f32719a;

        /* renamed from: b, reason: collision with root package name */
        public final io.grpc.v f32720b;

        /* loaded from: classes4.dex */
        public final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Status f32722a;

            public a(Status status) {
                this.f32722a = status;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.e(this.f32722a);
            }
        }

        /* loaded from: classes4.dex */
        public final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v.g f32724a;

            public b(v.g gVar) {
                this.f32724a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                O o10;
                Status status;
                O o11;
                String str;
                if (ManagedChannelImpl.this.f32613A != p.this.f32720b) {
                    return;
                }
                List<C1114h> a10 = this.f32724a.a();
                ChannelLogger channelLogger = ManagedChannelImpl.this.f32632T;
                ChannelLogger.ChannelLogLevel channelLogLevel = ChannelLogger.ChannelLogLevel.DEBUG;
                channelLogger.b(channelLogLevel, "Resolved address: {0}, config={1}", a10, this.f32724a.b());
                ResolutionState resolutionState = ManagedChannelImpl.this.f32635W;
                ResolutionState resolutionState2 = ResolutionState.SUCCESS;
                if (resolutionState != resolutionState2) {
                    ManagedChannelImpl.this.f32632T.b(ChannelLogger.ChannelLogLevel.INFO, "Address resolved: {0}", a10);
                    ManagedChannelImpl.this.f32635W = resolutionState2;
                }
                v.c c10 = this.f32724a.c();
                RetryingNameResolver.a aVar = (RetryingNameResolver.a) this.f32724a.b().b(RetryingNameResolver.f32872e);
                io.grpc.l lVar = (io.grpc.l) this.f32724a.b().b(io.grpc.l.f33413a);
                if (c10 != null && c10.c() != null) {
                    o10 = (O) c10.c();
                } else {
                    o10 = null;
                }
                if (c10 != null) {
                    status = c10.d();
                } else {
                    status = null;
                }
                if (!ManagedChannelImpl.this.f32640a0) {
                    if (o10 != null) {
                        ManagedChannelImpl.this.f32632T.a(ChannelLogger.ChannelLogLevel.INFO, "Service config from name resolver discarded by channel settings");
                    }
                    o11 = ManagedChannelImpl.this.f32637Y == null ? ManagedChannelImpl.f32610j0 : ManagedChannelImpl.this.f32637Y;
                    if (lVar != null) {
                        ManagedChannelImpl.this.f32632T.a(ChannelLogger.ChannelLogLevel.INFO, "Config selector from name resolver discarded by channel settings");
                    }
                    ManagedChannelImpl.this.f32634V.i(o11.c());
                } else {
                    if (o10 != null) {
                        if (lVar != null) {
                            ManagedChannelImpl.this.f32634V.i(lVar);
                            if (o10.c() != null) {
                                ManagedChannelImpl.this.f32632T.a(channelLogLevel, "Method configs in service config will be discarded due to presence ofconfig-selector");
                            }
                        } else {
                            ManagedChannelImpl.this.f32634V.i(o10.c());
                        }
                    } else if (ManagedChannelImpl.this.f32637Y != null) {
                        o10 = ManagedChannelImpl.this.f32637Y;
                        ManagedChannelImpl.this.f32634V.i(o10.c());
                        ManagedChannelImpl.this.f32632T.a(ChannelLogger.ChannelLogLevel.INFO, "Received no service config, using default service config");
                    } else if (status == null) {
                        o10 = ManagedChannelImpl.f32610j0;
                        ManagedChannelImpl.this.f32634V.i(null);
                    } else if (ManagedChannelImpl.this.f32638Z) {
                        o10 = ManagedChannelImpl.this.f32636X;
                    } else {
                        ManagedChannelImpl.this.f32632T.a(ChannelLogger.ChannelLogLevel.INFO, "Fallback to error due to invalid first service config without default config");
                        p.this.a(c10.d());
                        if (aVar != null) {
                            aVar.a(c10.d());
                            return;
                        }
                        return;
                    }
                    if (!o10.equals(ManagedChannelImpl.this.f32636X)) {
                        ChannelLogger channelLogger2 = ManagedChannelImpl.this.f32632T;
                        ChannelLogger.ChannelLogLevel channelLogLevel2 = ChannelLogger.ChannelLogLevel.INFO;
                        if (o10 == ManagedChannelImpl.f32610j0) {
                            str = " to empty";
                        } else {
                            str = "";
                        }
                        channelLogger2.b(channelLogLevel2, "Service config changed{0}", str);
                        ManagedChannelImpl.this.f32636X = o10;
                        ManagedChannelImpl.this.f32654h0.f32690a = o10.f();
                    }
                    try {
                        ManagedChannelImpl.this.f32638Z = true;
                    } catch (RuntimeException e10) {
                        ManagedChannelImpl.logger.log(Level.WARNING, "[" + ManagedChannelImpl.this.getLogId() + "] Unexpected exception from parsing service config", (Throwable) e10);
                    }
                    o11 = o10;
                }
                C1107a b10 = this.f32724a.b();
                p pVar = p.this;
                if (pVar.f32719a == ManagedChannelImpl.this.f32615C) {
                    C1107a.b c11 = b10.d().c(io.grpc.l.f33413a);
                    Map<String, ?> d10 = o11.d();
                    if (d10 != null) {
                        c11.d(io.grpc.q.f33434b, d10).a();
                    }
                    Status c12 = p.this.f32719a.f32713a.c(q.h.d().b(a10).c(c11.a()).d(o11.getLoadBalancingConfig()).a());
                    if (aVar != null) {
                        aVar.a(c12);
                    }
                }
            }
        }

        public p(o oVar, io.grpc.v vVar) {
            this.f32719a = (o) com.google.common.base.k.p(oVar, "helperImpl");
            this.f32720b = (io.grpc.v) com.google.common.base.k.p(vVar, "resolver");
        }

        @Override // io.grpc.v.e, io.grpc.v.f
        public void a(Status status) {
            com.google.common.base.k.e(!status.o(), "the error status must not be OK");
            ManagedChannelImpl.this.syncContext.execute(new a(status));
        }

        @Override // io.grpc.v.e
        public void c(v.g gVar) {
            ManagedChannelImpl.this.syncContext.execute(new b(gVar));
        }

        public final void e(Status status) {
            ManagedChannelImpl.logger.log(Level.WARNING, "[{0}] Failed to resolve name. status={1}", new Object[]{ManagedChannelImpl.this.getLogId(), status});
            ManagedChannelImpl.this.f32634V.g();
            ResolutionState resolutionState = ManagedChannelImpl.this.f32635W;
            ResolutionState resolutionState2 = ResolutionState.ERROR;
            if (resolutionState != resolutionState2) {
                ManagedChannelImpl.this.f32632T.b(ChannelLogger.ChannelLogLevel.WARNING, "Failed to resolve name: {0}", status);
                ManagedChannelImpl.this.f32635W = resolutionState2;
            }
            if (this.f32719a != ManagedChannelImpl.this.f32615C) {
                return;
            }
            this.f32719a.f32713a.a(status);
        }
    }

    /* loaded from: classes4.dex */
    public class q extends AbstractC1194d {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReference<io.grpc.l> f32726a;

        /* renamed from: b, reason: collision with root package name */
        public final String f32727b;

        /* renamed from: c, reason: collision with root package name */
        public final AbstractC1194d f32728c;

        /* loaded from: classes4.dex */
        public class a extends AbstractC1194d {
            public a() {
            }

            @Override // j9.AbstractC1194d
            public String a() {
                return q.this.f32727b;
            }

            @Override // j9.AbstractC1194d
            public <RequestT, ResponseT> AbstractC1109c<RequestT, ResponseT> b(MethodDescriptor<RequestT, ResponseT> methodDescriptor, C1108b c1108b) {
                ScheduledExecutorService scheduledExecutorService;
                Executor o02 = ManagedChannelImpl.this.o0(c1108b);
                j jVar = ManagedChannelImpl.this.f32654h0;
                if (ManagedChannelImpl.this.f32627O) {
                    scheduledExecutorService = null;
                } else {
                    scheduledExecutorService = ManagedChannelImpl.this.f32653h.getScheduledExecutorService();
                }
                return new C1127i(methodDescriptor, o02, c1108b, jVar, scheduledExecutorService, ManagedChannelImpl.this.f32630R, null).D(ManagedChannelImpl.this.f32665r).C(ManagedChannelImpl.this.f32666s).B(ManagedChannelImpl.this.f32667t);
            }
        }

        /* loaded from: classes4.dex */
        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ManagedChannelImpl.this.f32619G == null) {
                    if (q.this.f32726a.get() == ManagedChannelImpl.f32611k0) {
                        q.this.f32726a.set(null);
                    }
                    ManagedChannelImpl.this.f32623K.b(ManagedChannelImpl.SHUTDOWN_STATUS);
                }
            }
        }

        /* loaded from: classes4.dex */
        public final class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (q.this.f32726a.get() == ManagedChannelImpl.f32611k0) {
                    q.this.f32726a.set(null);
                }
                if (ManagedChannelImpl.this.f32619G != null) {
                    Iterator it = ManagedChannelImpl.this.f32619G.iterator();
                    while (it.hasNext()) {
                        ((g) it.next()).a("Channel is forcefully shutdown", null);
                    }
                }
                ManagedChannelImpl.this.f32623K.c(ManagedChannelImpl.SHUTDOWN_NOW_STATUS);
            }
        }

        /* loaded from: classes4.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ManagedChannelImpl.this.exitIdleMode();
            }
        }

        /* loaded from: classes4.dex */
        public class f implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f32735a;

            public f(g gVar) {
                this.f32735a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (q.this.f32726a.get() == ManagedChannelImpl.f32611k0) {
                    if (ManagedChannelImpl.this.f32619G == null) {
                        ManagedChannelImpl.this.f32619G = new LinkedHashSet();
                        ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
                        managedChannelImpl.inUseStateAggregator.updateObjectInUse(managedChannelImpl.f32620H, true);
                    }
                    ManagedChannelImpl.this.f32619G.add(this.f32735a);
                    return;
                }
                this.f32735a.r();
            }
        }

        /* loaded from: classes4.dex */
        public final class g<ReqT, RespT> extends C1134p<ReqT, RespT> {

            /* renamed from: l, reason: collision with root package name */
            public final Context f32737l;

            /* renamed from: m, reason: collision with root package name */
            public final MethodDescriptor<ReqT, RespT> f32738m;

            /* renamed from: n, reason: collision with root package name */
            public final C1108b f32739n;

            /* renamed from: o, reason: collision with root package name */
            public final long f32740o;

            /* loaded from: classes4.dex */
            public class a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f32742a;

                public a(Runnable runnable) {
                    this.f32742a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f32742a.run();
                    g gVar = g.this;
                    ManagedChannelImpl.this.syncContext.execute(new b());
                }
            }

            /* loaded from: classes4.dex */
            public final class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (ManagedChannelImpl.this.f32619G != null) {
                        ManagedChannelImpl.this.f32619G.remove(g.this);
                        if (ManagedChannelImpl.this.f32619G.isEmpty()) {
                            ManagedChannelImpl managedChannelImpl = ManagedChannelImpl.this;
                            managedChannelImpl.inUseStateAggregator.updateObjectInUse(managedChannelImpl.f32620H, false);
                            ManagedChannelImpl.this.f32619G = null;
                            if (ManagedChannelImpl.this.f32624L.get()) {
                                ManagedChannelImpl.this.f32623K.b(ManagedChannelImpl.SHUTDOWN_STATUS);
                            }
                        }
                    }
                }
            }

            public g(Context context, MethodDescriptor<ReqT, RespT> methodDescriptor, C1108b c1108b) {
                super(ManagedChannelImpl.this.o0(c1108b), ManagedChannelImpl.this.f32657j, c1108b.d());
                this.f32737l = context;
                this.f32738m = methodDescriptor;
                this.f32739n = c1108b;
                this.f32740o = ManagedChannelImpl.this.f32650f0.a();
            }

            @Override // io.grpc.internal.C1134p
            public void j() {
                super.j();
                ManagedChannelImpl.this.syncContext.execute(new b());
            }

            public void r() {
                Context c10 = this.f32737l.c();
                try {
                    AbstractC1109c<ReqT, RespT> f10 = q.this.f(this.f32738m, this.f32739n.s(AbstractC1112f.f32442a, Long.valueOf(ManagedChannelImpl.this.f32650f0.a() - this.f32740o)));
                    this.f32737l.o(c10);
                    Runnable p10 = p(f10);
                    if (p10 == null) {
                        ManagedChannelImpl.this.syncContext.execute(new b());
                    } else {
                        ManagedChannelImpl.this.o0(this.f32739n).execute(new a(p10));
                    }
                } catch (Throwable th) {
                    this.f32737l.o(c10);
                    throw th;
                }
            }
        }

        public /* synthetic */ q(ManagedChannelImpl managedChannelImpl, String str, a aVar) {
            this(str);
        }

        @Override // j9.AbstractC1194d
        public String a() {
            return this.f32727b;
        }

        @Override // j9.AbstractC1194d
        public <ReqT, RespT> AbstractC1109c<ReqT, RespT> b(MethodDescriptor<ReqT, RespT> methodDescriptor, C1108b c1108b) {
            if (this.f32726a.get() != ManagedChannelImpl.f32611k0) {
                return f(methodDescriptor, c1108b);
            }
            ManagedChannelImpl.this.syncContext.execute(new d());
            if (this.f32726a.get() != ManagedChannelImpl.f32611k0) {
                return f(methodDescriptor, c1108b);
            }
            if (ManagedChannelImpl.this.f32624L.get()) {
                return new e();
            }
            g gVar = new g(Context.l(), methodDescriptor, c1108b);
            ManagedChannelImpl.this.syncContext.execute(new f(gVar));
            return gVar;
        }

        public final <ReqT, RespT> AbstractC1109c<ReqT, RespT> f(MethodDescriptor<ReqT, RespT> methodDescriptor, C1108b c1108b) {
            io.grpc.l lVar = this.f32726a.get();
            if (lVar == null) {
                return this.f32728c.b(methodDescriptor, c1108b);
            }
            if (lVar instanceof O.c) {
                O.b e10 = ((O.c) lVar).f32835b.e(methodDescriptor);
                if (e10 != null) {
                    c1108b = c1108b.s(O.b.f32828g, e10);
                }
                return this.f32728c.b(methodDescriptor, c1108b);
            }
            return new k(lVar, this.f32728c, ManagedChannelImpl.this.f32658k, methodDescriptor, c1108b);
        }

        public void g() {
            if (this.f32726a.get() == ManagedChannelImpl.f32611k0) {
                i(null);
            }
        }

        public void h() {
            ManagedChannelImpl.this.syncContext.execute(new c());
        }

        public void i(io.grpc.l lVar) {
            io.grpc.l lVar2 = this.f32726a.get();
            this.f32726a.set(lVar);
            if (lVar2 == ManagedChannelImpl.f32611k0 && ManagedChannelImpl.this.f32619G != null) {
                Iterator it = ManagedChannelImpl.this.f32619G.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).r();
                }
            }
        }

        public void shutdown() {
            ManagedChannelImpl.this.syncContext.execute(new b());
        }

        public q(String str) {
            this.f32726a = new AtomicReference<>(ManagedChannelImpl.f32611k0);
            this.f32728c = new a();
            this.f32727b = (String) com.google.common.base.k.p(str, "authority");
        }

        /* JADX INFO: Add missing generic type declarations: [ReqT, RespT] */
        /* loaded from: classes4.dex */
        public class e<ReqT, RespT> extends AbstractC1109c<ReqT, RespT> {
            public e() {
            }

            @Override // io.grpc.AbstractC1109c
            public void e(AbstractC1109c.a<RespT> aVar, io.grpc.u uVar) {
                aVar.a(ManagedChannelImpl.SHUTDOWN_STATUS, new io.grpc.u());
            }

            @Override // io.grpc.AbstractC1109c
            public void c(int i10) {
            }

            @Override // io.grpc.AbstractC1109c
            public void d(ReqT reqt) {
            }

            @Override // io.grpc.AbstractC1109c
            public void b() {
            }

            @Override // io.grpc.AbstractC1109c
            public void a(String str, Throwable th) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class r implements ScheduledExecutorService {

        /* renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f32745a;

        public /* synthetic */ r(ScheduledExecutorService scheduledExecutorService, a aVar) {
            this(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) {
            return this.f32745a.awaitTermination(j10, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f32745a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
            return this.f32745a.invokeAll(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
            return (T) this.f32745a.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f32745a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f32745a.isTerminated();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
            return this.f32745a.schedule(callable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f32745a.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            return this.f32745a.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            throw new UnsupportedOperationException("Restricted: shutdown() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            throw new UnsupportedOperationException("Restricted: shutdownNow() is not allowed");
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.f32745a.submit(callable);
        }

        public r(ScheduledExecutorService scheduledExecutorService) {
            this.f32745a = (ScheduledExecutorService) com.google.common.base.k.p(scheduledExecutorService, "delegate");
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
            return this.f32745a.invokeAll(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) {
            return (T) this.f32745a.invokeAny(collection, j10, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f32745a.schedule(runnable, j10, timeUnit);
        }

        @Override // java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.f32745a.submit(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t10) {
            return this.f32745a.submit(runnable, t10);
        }
    }

    /* loaded from: classes4.dex */
    public final class s extends AbstractC1115a {

        /* renamed from: a, reason: collision with root package name */
        public final q.b f32746a;

        /* renamed from: b, reason: collision with root package name */
        public final j9.w f32747b;

        /* renamed from: c, reason: collision with root package name */
        public final C1126h f32748c;

        /* renamed from: d, reason: collision with root package name */
        public final ChannelTracer f32749d;

        /* renamed from: e, reason: collision with root package name */
        public List<C1114h> f32750e;

        /* renamed from: f, reason: collision with root package name */
        public InternalSubchannel f32751f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f32752g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f32753h;

        /* renamed from: i, reason: collision with root package name */
        public N.d f32754i;

        /* loaded from: classes4.dex */
        public final class a extends InternalSubchannel.i {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q.k f32756a;

            public a(q.k kVar) {
                this.f32756a = kVar;
            }

            @Override // io.grpc.internal.InternalSubchannel.i
            public void a(InternalSubchannel internalSubchannel) {
                ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(internalSubchannel, true);
            }

            @Override // io.grpc.internal.InternalSubchannel.i
            public void b(InternalSubchannel internalSubchannel) {
                ManagedChannelImpl.this.inUseStateAggregator.updateObjectInUse(internalSubchannel, false);
            }

            @Override // io.grpc.internal.InternalSubchannel.i
            public void c(InternalSubchannel internalSubchannel, C1201k c1201k) {
                boolean z10;
                if (this.f32756a != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.v(z10, "listener is null");
                this.f32756a.a(c1201k);
            }

            @Override // io.grpc.internal.InternalSubchannel.i
            public void d(InternalSubchannel internalSubchannel) {
                ManagedChannelImpl.this.f32618F.remove(internalSubchannel);
                ManagedChannelImpl.this.f32633U.o(internalSubchannel);
                ManagedChannelImpl.this.r0();
            }
        }

        /* loaded from: classes4.dex */
        public final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                s.this.f32751f.shutdown(ManagedChannelImpl.SUBCHANNEL_SHUTDOWN_STATUS);
            }
        }

        public s(q.b bVar) {
            com.google.common.base.k.p(bVar, Constants.MessagerConstants.ARGS_KEY);
            this.f32750e = bVar.a();
            if (ManagedChannelImpl.this.f32643c != null) {
                bVar = bVar.e().e(j(bVar.a())).c();
            }
            this.f32746a = bVar;
            j9.w b10 = j9.w.b("Subchannel", ManagedChannelImpl.this.a());
            this.f32747b = b10;
            ChannelTracer channelTracer = new ChannelTracer(b10, ManagedChannelImpl.this.f32664q, ManagedChannelImpl.this.f32663p.a(), "Subchannel for " + bVar.a());
            this.f32749d = channelTracer;
            this.f32748c = new C1126h(channelTracer, ManagedChannelImpl.this.f32663p);
        }

        @Override // io.grpc.q.i
        public List<C1114h> b() {
            ManagedChannelImpl.this.syncContext.e();
            com.google.common.base.k.v(this.f32752g, "not started");
            return this.f32750e;
        }

        @Override // io.grpc.q.i
        public C1107a c() {
            return this.f32746a.b();
        }

        @Override // io.grpc.q.i
        public ChannelLogger d() {
            return this.f32748c;
        }

        @Override // io.grpc.q.i
        public Object e() {
            com.google.common.base.k.v(this.f32752g, "Subchannel is not started");
            return this.f32751f;
        }

        @Override // io.grpc.q.i
        public void f() {
            ManagedChannelImpl.this.syncContext.e();
            com.google.common.base.k.v(this.f32752g, "not started");
            this.f32751f.a();
        }

        @Override // io.grpc.q.i
        public void g() {
            N.d dVar;
            ManagedChannelImpl.this.syncContext.e();
            if (this.f32751f == null) {
                this.f32753h = true;
                return;
            }
            if (this.f32753h) {
                if (ManagedChannelImpl.this.f32626N && (dVar = this.f32754i) != null) {
                    dVar.a();
                    this.f32754i = null;
                } else {
                    return;
                }
            } else {
                this.f32753h = true;
            }
            if (!ManagedChannelImpl.this.f32626N) {
                this.f32754i = ManagedChannelImpl.this.syncContext.c(new K(new b()), 5L, TimeUnit.SECONDS, ManagedChannelImpl.this.f32653h.getScheduledExecutorService());
            } else {
                this.f32751f.shutdown(ManagedChannelImpl.SHUTDOWN_STATUS);
            }
        }

        @Override // io.grpc.internal.AbstractC1115a
        public j9.v<Object> getInstrumentedInternalSubchannel() {
            com.google.common.base.k.v(this.f32752g, "not started");
            return this.f32751f;
        }

        @Override // io.grpc.q.i
        public void h(q.k kVar) {
            ManagedChannelImpl.this.syncContext.e();
            com.google.common.base.k.v(!this.f32752g, "already started");
            com.google.common.base.k.v(!this.f32753h, "already shutdown");
            com.google.common.base.k.v(!ManagedChannelImpl.this.f32626N, "Channel is being terminated");
            this.f32752g = true;
            InternalSubchannel internalSubchannel = new InternalSubchannel(this.f32746a.a(), ManagedChannelImpl.this.a(), ManagedChannelImpl.this.f32673z, ManagedChannelImpl.this.f32671x, ManagedChannelImpl.this.f32653h, ManagedChannelImpl.this.f32653h.getScheduledExecutorService(), ManagedChannelImpl.this.f32668u, ManagedChannelImpl.this.syncContext, new a(kVar), ManagedChannelImpl.this.f32633U, ManagedChannelImpl.this.f32629Q.create(), this.f32749d, this.f32747b, this.f32748c);
            ManagedChannelImpl.this.f32631S.e(new InternalChannelz$ChannelTrace$Event.a().b("Child Subchannel started").c(InternalChannelz$ChannelTrace$Event.Severity.CT_INFO).e(ManagedChannelImpl.this.f32663p.a()).d(internalSubchannel).a());
            this.f32751f = internalSubchannel;
            ManagedChannelImpl.this.f32633U.f(internalSubchannel);
            ManagedChannelImpl.this.f32618F.add(internalSubchannel);
        }

        @Override // io.grpc.q.i
        public void i(List<C1114h> list) {
            ManagedChannelImpl.this.syncContext.e();
            this.f32750e = list;
            if (ManagedChannelImpl.this.f32643c != null) {
                list = j(list);
            }
            this.f32751f.N(list);
        }

        public final List<C1114h> j(List<C1114h> list) {
            ArrayList arrayList = new ArrayList();
            for (C1114h c1114h : list) {
                arrayList.add(new C1114h(c1114h.a(), c1114h.b().d().c(C1114h.f32449d).a()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        public String toString() {
            return this.f32747b.toString();
        }
    }

    static {
        Status status = Status.f32383t;
        SHUTDOWN_NOW_STATUS = status.r("Channel shutdownNow invoked");
        SHUTDOWN_STATUS = status.r("Channel shutdown invoked");
        SUBCHANNEL_SHUTDOWN_STATUS = status.r("Subchannel shutdown invoked");
        f32610j0 = O.a();
        f32611k0 = new a();
        f32612l0 = new i();
    }

    public ManagedChannelImpl(N n10, InterfaceC1130l interfaceC1130l, InterfaceC1117c.a aVar, U<? extends Executor> u10, com.google.common.base.o<com.google.common.base.m> oVar, List<InterfaceC1196f> list, v0 v0Var) {
        a aVar2;
        j9.N n11 = new j9.N(new g());
        this.syncContext = n11;
        this.f32670w = new C1132n();
        this.f32618F = new HashSet(16, 0.75f);
        this.f32620H = new Object();
        this.f32621I = new HashSet(1, 0.75f);
        a aVar3 = null;
        this.f32623K = new t(this, aVar3);
        this.f32624L = new AtomicBoolean(false);
        this.f32628P = new CountDownLatch(1);
        this.f32635W = ResolutionState.NO_RESOLUTION;
        this.f32636X = f32610j0;
        this.f32638Z = false;
        this.f32642b0 = new c0.t();
        this.f32650f0 = C1203m.f();
        l lVar = new l(this, aVar3);
        this.f32652g0 = lVar;
        this.inUseStateAggregator = new m(this, aVar3);
        this.f32654h0 = new j(this, aVar3);
        String str = (String) com.google.common.base.k.p(n10.f32800i, "target");
        this.f32641b = str;
        j9.w b10 = j9.w.b("Channel", str);
        this.f32639a = b10;
        this.f32663p = (v0) com.google.common.base.k.p(v0Var, "timeProvider");
        U<? extends Executor> u11 = (U) com.google.common.base.k.p(n10.f32796e, "executorPool");
        this.f32659l = u11;
        Executor executor = (Executor) com.google.common.base.k.p(u11.a(), "executor");
        this.f32658k = executor;
        this.f32651g = interfaceC1130l;
        ExecutorHolder executorHolder = new ExecutorHolder((U) com.google.common.base.k.p(n10.f32797f, "offloadExecutorPool"));
        this.f32662o = executorHolder;
        C1124f c1124f = new C1124f(interfaceC1130l, n10.f32801j, executorHolder);
        this.f32653h = c1124f;
        this.f32655i = new C1124f(interfaceC1130l, null, executorHolder);
        r rVar = new r(c1124f.getScheduledExecutorService(), aVar3);
        this.f32657j = rVar;
        this.f32664q = n10.f32816y;
        ChannelTracer channelTracer = new ChannelTracer(b10, n10.f32816y, v0Var.a(), "Channel for '" + str + "'");
        this.f32631S = channelTracer;
        C1126h c1126h = new C1126h(channelTracer, v0Var);
        this.f32632T = c1126h;
        j9.E e10 = n10.f32786B;
        e10 = e10 == null ? GrpcUtil.f32535q : e10;
        boolean z10 = n10.f32814w;
        this.f32648e0 = z10;
        AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory = new AutoConfiguredLoadBalancerFactory(n10.f32805n);
        this.f32649f = autoConfiguredLoadBalancerFactory;
        io.grpc.x xVar = n10.f32799h;
        this.f32645d = xVar;
        ScParser scParser = new ScParser(z10, n10.f32810s, n10.f32811t, autoConfiguredLoadBalancerFactory);
        String str2 = n10.f32804m;
        this.f32643c = str2;
        v.b a10 = v.b.g().c(n10.l()).f(e10).i(n11).g(rVar).h(scParser).b(c1126h).d(executorHolder).e(str2).a();
        this.f32647e = a10;
        this.f32613A = getNameResolver(str, str2, xVar, a10, c1124f.getSupportedSocketAddressTypes());
        this.f32660m = (U) com.google.common.base.k.p(u10, "balancerRpcExecutorPool");
        this.f32661n = new ExecutorHolder(u10);
        C1135q c1135q = new C1135q(executor, n11);
        this.f32622J = c1135q;
        c1135q.start(lVar);
        this.f32671x = aVar;
        Map<String, ?> map = n10.f32817z;
        if (map != null) {
            v.c a11 = scParser.a(map);
            com.google.common.base.k.x(a11.d() == null, "Default config is invalid: %s", a11.d());
            O o10 = (O) a11.c();
            this.f32637Y = o10;
            this.f32636X = o10;
            aVar2 = null;
        } else {
            aVar2 = null;
            this.f32637Y = null;
        }
        boolean z11 = n10.f32785A;
        this.f32640a0 = z11;
        q qVar = new q(this, this.f32613A.a(), aVar2);
        this.f32634V = qVar;
        this.f32672y = C1111e.a(qVar, list);
        this.f32668u = (com.google.common.base.o) com.google.common.base.k.p(oVar, "stopwatchSupplier");
        long j10 = n10.f32809r;
        if (j10 == -1) {
            this.f32669v = j10;
        } else {
            com.google.common.base.k.j(j10 >= N.f32780M, "invalid idleTimeoutMillis %s", j10);
            this.f32669v = n10.f32809r;
        }
        this.f32656i0 = new b0(new n(this, null), n11, c1124f.getScheduledExecutorService(), oVar.get());
        this.f32665r = n10.f32806o;
        this.f32666s = (j9.o) com.google.common.base.k.p(n10.f32807p, "decompressorRegistry");
        this.f32667t = (C1200j) com.google.common.base.k.p(n10.f32808q, "compressorRegistry");
        this.f32673z = n10.f32803l;
        this.f32646d0 = n10.f32812u;
        this.f32644c0 = n10.f32813v;
        c cVar = new c(v0Var);
        this.f32629Q = cVar;
        this.f32630R = cVar.create();
        InternalChannelz internalChannelz = (InternalChannelz) com.google.common.base.k.o(n10.f32815x);
        this.f32633U = internalChannelz;
        internalChannelz.c(this);
        if (z11) {
            return;
        }
        if (this.f32637Y != null) {
            c1126h.a(ChannelLogger.ChannelLogLevel.INFO, "Service config look-up disabled, using default service config");
        }
        this.f32638Z = true;
    }

    public static io.grpc.v getNameResolver(String str, String str2, io.grpc.x xVar, v.b bVar, Collection<Class<? extends SocketAddress>> collection) {
        RetryingNameResolver retryingNameResolver = new RetryingNameResolver(p0(str, xVar, bVar, collection), new C1123e(new C1137t.a(), bVar.d(), bVar.f()), bVar.f());
        if (str2 == null) {
            return retryingNameResolver;
        }
        return new h(retryingNameResolver, str2);
    }

    public static io.grpc.v p0(String str, io.grpc.x xVar, v.b bVar, Collection<Class<? extends SocketAddress>> collection) {
        URI uri;
        io.grpc.w wVar;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e10) {
            sb.append(e10.getMessage());
            uri = null;
        }
        if (uri != null) {
            wVar = xVar.d(uri.getScheme());
        } else {
            wVar = null;
        }
        String str2 = "";
        if (wVar == null && !URI_PATTERN.matcher(str).matches()) {
            try {
                uri = new URI(xVar.c(), "", "/" + str, null);
                wVar = xVar.d(uri.getScheme());
            } catch (URISyntaxException e11) {
                throw new IllegalArgumentException(e11);
            }
        }
        if (wVar == null) {
            if (sb.length() > 0) {
                str2 = " (" + ((Object) sb) + ")";
            }
            throw new IllegalArgumentException(String.format("Could not find a NameResolverProvider for %s%s", str, str2));
        }
        if (collection != null && !collection.containsAll(wVar.c())) {
            throw new IllegalArgumentException(String.format("Address types of NameResolver '%s' for '%s' not supported by transport", uri.getScheme(), str));
        }
        io.grpc.v b10 = wVar.b(uri, bVar);
        if (b10 != null) {
            return b10;
        }
        if (sb.length() > 0) {
            str2 = " (" + ((Object) sb) + ")";
        }
        throw new IllegalArgumentException(String.format("cannot create a NameResolver for %s%s", str, str2));
    }

    @Override // j9.AbstractC1194d
    public String a() {
        return this.f32672y.a();
    }

    @Override // j9.AbstractC1194d
    public <ReqT, RespT> AbstractC1109c<ReqT, RespT> b(MethodDescriptor<ReqT, RespT> methodDescriptor, C1108b c1108b) {
        return this.f32672y.b(methodDescriptor, c1108b);
    }

    @Override // j9.AbstractC1190B
    public boolean c(long j10, TimeUnit timeUnit) {
        return this.f32628P.await(j10, timeUnit);
    }

    public void exitIdleMode() {
        this.syncContext.e();
        if (!this.f32624L.get() && !this.f32617E) {
            if (this.inUseStateAggregator.isInUse()) {
                m0(false);
            } else {
                t0();
            }
            if (this.f32615C != null) {
                return;
            }
            this.f32632T.a(ChannelLogger.ChannelLogLevel.INFO, "Exiting idle mode");
            o oVar = new o(this, null);
            oVar.f32713a = this.f32649f.e(oVar);
            this.f32615C = oVar;
            this.f32613A.d(new p(oVar, this.f32613A));
            this.f32614B = true;
        }
    }

    public io.grpc.l getConfigSelector() {
        return (io.grpc.l) this.f32634V.f32726a.get();
    }

    @Override // j9.z
    public j9.w getLogId() {
        return this.f32639a;
    }

    public boolean isInPanicMode() {
        return this.f32617E;
    }

    public final void m0(boolean z10) {
        this.f32656i0.i(z10);
    }

    public final void n0() {
        v0(true);
        this.f32622J.k(null);
        this.f32632T.a(ChannelLogger.ChannelLogLevel.INFO, "Entering IDLE state");
        this.f32670w.a(ConnectivityState.IDLE);
        if (this.inUseStateAggregator.anyObjectInUse(this.f32620H, this.f32622J)) {
            exitIdleMode();
        }
    }

    public final Executor o0(C1108b c1108b) {
        Executor e10 = c1108b.e();
        if (e10 == null) {
            return this.f32658k;
        }
        return e10;
    }

    public void panic(Throwable th) {
        if (this.f32617E) {
            return;
        }
        this.f32617E = true;
        m0(true);
        v0(false);
        x0(new d(th));
        this.f32634V.i(null);
        this.f32632T.a(ChannelLogger.ChannelLogLevel.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        this.f32670w.a(ConnectivityState.TRANSIENT_FAILURE);
    }

    public final void q0() {
        if (this.f32625M) {
            Iterator<InternalSubchannel> it = this.f32618F.iterator();
            while (it.hasNext()) {
                it.next().shutdownNow(SHUTDOWN_NOW_STATUS);
            }
            Iterator<V> it2 = this.f32621I.iterator();
            while (it2.hasNext()) {
                it2.next().e().shutdownNow(SHUTDOWN_NOW_STATUS);
            }
        }
    }

    public final void r0() {
        if (!this.f32627O && this.f32624L.get() && this.f32618F.isEmpty() && this.f32621I.isEmpty()) {
            this.f32632T.a(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
            this.f32633U.l(this);
            this.f32659l.b(this.f32658k);
            this.f32661n.b();
            this.f32662o.b();
            this.f32653h.close();
            this.f32627O = true;
            this.f32628P.countDown();
        }
    }

    public final void s0() {
        this.syncContext.e();
        if (this.f32614B) {
            this.f32613A.b();
        }
    }

    public final void t0() {
        long j10 = this.f32669v;
        if (j10 == -1) {
            return;
        }
        this.f32656i0.k(j10, TimeUnit.MILLISECONDS);
    }

    public String toString() {
        return com.google.common.base.f.c(this).c("logId", this.f32639a.d()).d("target", this.f32641b).toString();
    }

    public ManagedChannelImpl u0() {
        this.f32632T.a(ChannelLogger.ChannelLogLevel.DEBUG, "shutdown() called");
        if (!this.f32624L.compareAndSet(false, true)) {
            return this;
        }
        this.syncContext.execute(new e());
        this.f32634V.shutdown();
        this.syncContext.execute(new b());
        return this;
    }

    public final void v0(boolean z10) {
        boolean z11;
        this.syncContext.e();
        if (z10) {
            com.google.common.base.k.v(this.f32614B, "nameResolver is not started");
            if (this.f32615C != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            com.google.common.base.k.v(z11, "lbHelper is null");
        }
        io.grpc.v vVar = this.f32613A;
        if (vVar != null) {
            vVar.c();
            this.f32614B = false;
            if (z10) {
                this.f32613A = getNameResolver(this.f32641b, this.f32643c, this.f32645d, this.f32647e, this.f32653h.getSupportedSocketAddressTypes());
            } else {
                this.f32613A = null;
            }
        }
        o oVar = this.f32615C;
        if (oVar != null) {
            oVar.f32713a.b();
            this.f32615C = null;
        }
        this.f32616D = null;
    }

    @Override // j9.AbstractC1190B
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public ManagedChannelImpl d() {
        this.f32632T.a(ChannelLogger.ChannelLogLevel.DEBUG, "shutdownNow() called");
        u0();
        this.f32634V.h();
        this.syncContext.execute(new f());
        return this;
    }

    public final void x0(q.j jVar) {
        this.f32616D = jVar;
        this.f32622J.k(jVar);
    }

    /* loaded from: classes4.dex */
    public final class t {

        /* renamed from: a, reason: collision with root package name */
        public final Object f32759a;

        /* renamed from: b, reason: collision with root package name */
        public Collection<InterfaceC1128j> f32760b;

        /* renamed from: c, reason: collision with root package name */
        public Status f32761c;

        public t() {
            this.f32759a = new Object();
            this.f32760b = new HashSet();
        }

        public Status a(c0<?> c0Var) {
            synchronized (this.f32759a) {
                try {
                    Status status = this.f32761c;
                    if (status != null) {
                        return status;
                    }
                    this.f32760b.add(c0Var);
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b(Status status) {
            synchronized (this.f32759a) {
                try {
                    if (this.f32761c != null) {
                        return;
                    }
                    this.f32761c = status;
                    boolean isEmpty = this.f32760b.isEmpty();
                    if (isEmpty) {
                        ManagedChannelImpl.this.f32622J.shutdown(status);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void c(Status status) {
            ArrayList arrayList;
            b(status);
            synchronized (this.f32759a) {
                arrayList = new ArrayList(this.f32760b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InterfaceC1128j) it.next()).cancel(status);
            }
            ManagedChannelImpl.this.f32622J.shutdownNow(status);
        }

        public void d(c0<?> c0Var) {
            Status status;
            synchronized (this.f32759a) {
                try {
                    this.f32760b.remove(c0Var);
                    if (this.f32760b.isEmpty()) {
                        status = this.f32761c;
                        this.f32760b = new HashSet();
                    } else {
                        status = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (status != null) {
                ManagedChannelImpl.this.f32622J.shutdown(status);
            }
        }

        public /* synthetic */ t(ManagedChannelImpl managedChannelImpl, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class i extends AbstractC1109c<Object, Object> {
        @Override // io.grpc.AbstractC1109c
        public void c(int i10) {
        }

        @Override // io.grpc.AbstractC1109c
        public void d(Object obj) {
        }

        @Override // io.grpc.AbstractC1109c
        public void b() {
        }

        @Override // io.grpc.AbstractC1109c
        public void a(String str, Throwable th) {
        }

        @Override // io.grpc.AbstractC1109c
        public void e(AbstractC1109c.a<Object> aVar, io.grpc.u uVar) {
        }
    }
}
