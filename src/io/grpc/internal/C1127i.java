package io.grpc.internal;

import com.google.common.util.concurrent.MoreExecutors;
import com.oplus.backup.sdk.common.utils.Constants;
import io.grpc.AbstractC1109c;
import io.grpc.AbstractC1112f;
import io.grpc.C1108b;
import io.grpc.C1113g;
import io.grpc.Context;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.O;
import io.grpc.internal.u0;
import io.grpc.u;
import j9.C1200j;
import j9.C1203m;
import j9.InterfaceC1197g;
import j9.InterfaceC1199i;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import l9.C1300b;

/* compiled from: ClientCallImpl.java */
/* renamed from: io.grpc.internal.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1127i<ReqT, RespT> extends AbstractC1109c<ReqT, RespT> {

    /* renamed from: t, reason: collision with root package name */
    public static final Logger f33186t = Logger.getLogger(C1127i.class.getName());

    /* renamed from: u, reason: collision with root package name */
    public static final byte[] f33187u = "gzip".getBytes(Charset.forName("US-ASCII"));

    /* renamed from: v, reason: collision with root package name */
    public static final double f33188v = TimeUnit.SECONDS.toNanos(1) * 1.0d;

    /* renamed from: a, reason: collision with root package name */
    public final MethodDescriptor<ReqT, RespT> f33189a;

    /* renamed from: b, reason: collision with root package name */
    public final l9.d f33190b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f33191c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f33192d;

    /* renamed from: e, reason: collision with root package name */
    public final C1125g f33193e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f33194f;

    /* renamed from: g, reason: collision with root package name */
    public volatile ScheduledFuture<?> f33195g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f33196h;

    /* renamed from: i, reason: collision with root package name */
    public C1108b f33197i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC1128j f33198j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f33199k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f33200l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f33201m;

    /* renamed from: n, reason: collision with root package name */
    public final e f33202n;

    /* renamed from: p, reason: collision with root package name */
    public final ScheduledExecutorService f33204p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f33205q;

    /* renamed from: o, reason: collision with root package name */
    public final C1127i<ReqT, RespT>.f f33203o = new f();

    /* renamed from: r, reason: collision with root package name */
    public j9.o f33206r = j9.o.c();

    /* renamed from: s, reason: collision with root package name */
    public C1200j f33207s = C1200j.a();

    /* compiled from: ClientCallImpl.java */
    /* renamed from: io.grpc.internal.i$b */
    /* loaded from: classes4.dex */
    public class b extends AbstractRunnableC1133o {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1109c.a f33208b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC1109c.a aVar) {
            super(C1127i.this.f33194f);
            this.f33208b = aVar;
        }

        @Override // io.grpc.internal.AbstractRunnableC1133o
        public void a() {
            C1127i c1127i = C1127i.this;
            c1127i.t(this.f33208b, C1113g.a(c1127i.f33194f), new io.grpc.u());
        }
    }

    /* compiled from: ClientCallImpl.java */
    /* renamed from: io.grpc.internal.i$c */
    /* loaded from: classes4.dex */
    public class c extends AbstractRunnableC1133o {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC1109c.a f33210b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f33211c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC1109c.a aVar, String str) {
            super(C1127i.this.f33194f);
            this.f33210b = aVar;
            this.f33211c = str;
        }

        @Override // io.grpc.internal.AbstractRunnableC1133o
        public void a() {
            C1127i.this.t(this.f33210b, Status.f32382s.r(String.format("Unable to find compressor by name %s", this.f33211c)), new io.grpc.u());
        }
    }

    /* compiled from: ClientCallImpl.java */
    /* renamed from: io.grpc.internal.i$d */
    /* loaded from: classes4.dex */
    public class d implements ClientStreamListener {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC1109c.a<RespT> f33213a;

        /* renamed from: b, reason: collision with root package name */
        public Status f33214b;

        /* compiled from: ClientCallImpl.java */
        /* renamed from: io.grpc.internal.i$d$a */
        /* loaded from: classes4.dex */
        public final class a extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1300b f33216b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f33217c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C1300b c1300b, io.grpc.u uVar) {
                super(C1127i.this.f33194f);
                this.f33216b = c1300b;
                this.f33217c = uVar;
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                l9.e g10 = l9.c.g("ClientCall$Listener.headersRead");
                try {
                    l9.c.a(C1127i.this.f33190b);
                    l9.c.d(this.f33216b);
                    b();
                    if (g10 != null) {
                        g10.close();
                    }
                } catch (Throwable th) {
                    if (g10 != null) {
                        try {
                            g10.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }

            public final void b() {
                if (d.this.f33214b != null) {
                    return;
                }
                try {
                    d.this.f33213a.b(this.f33217c);
                } catch (Throwable th) {
                    d.this.k(Status.f32369f.q(th).r("Failed to read headers"));
                }
            }
        }

        /* compiled from: ClientCallImpl.java */
        /* renamed from: io.grpc.internal.i$d$b */
        /* loaded from: classes4.dex */
        public final class b extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1300b f33219b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ u0.a f33220c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(C1300b c1300b, u0.a aVar) {
                super(C1127i.this.f33194f);
                this.f33219b = c1300b;
                this.f33220c = aVar;
            }

            private void b() {
                if (d.this.f33214b != null) {
                    GrpcUtil.d(this.f33220c);
                    return;
                }
                while (true) {
                    try {
                        InputStream next = this.f33220c.next();
                        if (next != null) {
                            try {
                                d.this.f33213a.c(C1127i.this.f33189a.i(next));
                                next.close();
                            } catch (Throwable th) {
                                GrpcUtil.e(next);
                                throw th;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        GrpcUtil.d(this.f33220c);
                        d.this.k(Status.f32369f.q(th2).r("Failed to read message."));
                        return;
                    }
                }
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                l9.e g10 = l9.c.g("ClientCall$Listener.messagesAvailable");
                try {
                    l9.c.a(C1127i.this.f33190b);
                    l9.c.d(this.f33219b);
                    b();
                    if (g10 != null) {
                        g10.close();
                    }
                } catch (Throwable th) {
                    if (g10 != null) {
                        try {
                            g10.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        /* compiled from: ClientCallImpl.java */
        /* renamed from: io.grpc.internal.i$d$c */
        /* loaded from: classes4.dex */
        public final class c extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1300b f33222b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Status f33223c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f33224d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(C1300b c1300b, Status status, io.grpc.u uVar) {
                super(C1127i.this.f33194f);
                this.f33222b = c1300b;
                this.f33223c = status;
                this.f33224d = uVar;
            }

            private void b() {
                Status status = this.f33223c;
                io.grpc.u uVar = this.f33224d;
                if (d.this.f33214b != null) {
                    status = d.this.f33214b;
                    uVar = new io.grpc.u();
                }
                C1127i.this.f33199k = true;
                try {
                    d dVar = d.this;
                    C1127i.this.t(dVar.f33213a, status, uVar);
                } finally {
                    C1127i.this.z();
                    C1127i.this.f33193e.b(status.o());
                }
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                l9.e g10 = l9.c.g("ClientCall$Listener.onClose");
                try {
                    l9.c.a(C1127i.this.f33190b);
                    l9.c.d(this.f33222b);
                    b();
                    if (g10 != null) {
                        g10.close();
                    }
                } catch (Throwable th) {
                    if (g10 != null) {
                        try {
                            g10.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        /* compiled from: ClientCallImpl.java */
        /* renamed from: io.grpc.internal.i$d$d, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public final class C0312d extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1300b f33226b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0312d(C1300b c1300b) {
                super(C1127i.this.f33194f);
                this.f33226b = c1300b;
            }

            private void b() {
                if (d.this.f33214b != null) {
                    return;
                }
                try {
                    d.this.f33213a.d();
                } catch (Throwable th) {
                    d.this.k(Status.f32369f.q(th).r("Failed to call onReady."));
                }
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                l9.e g10 = l9.c.g("ClientCall$Listener.onReady");
                try {
                    l9.c.a(C1127i.this.f33190b);
                    l9.c.d(this.f33226b);
                    b();
                    if (g10 != null) {
                        g10.close();
                    }
                } catch (Throwable th) {
                    if (g10 != null) {
                        try {
                            g10.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        }

        public d(AbstractC1109c.a<RespT> aVar) {
            this.f33213a = (AbstractC1109c.a) com.google.common.base.k.p(aVar, "observer");
        }

        @Override // io.grpc.internal.u0
        public void c(u0.a aVar) {
            l9.e g10 = l9.c.g("ClientStreamListener.messagesAvailable");
            try {
                l9.c.a(C1127i.this.f33190b);
                C1127i.this.f33191c.execute(new b(l9.c.e(), aVar));
                if (g10 != null) {
                    g10.close();
                }
            } catch (Throwable th) {
                if (g10 != null) {
                    try {
                        g10.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void d(io.grpc.u uVar) {
            l9.e g10 = l9.c.g("ClientStreamListener.headersRead");
            try {
                l9.c.a(C1127i.this.f33190b);
                C1127i.this.f33191c.execute(new a(l9.c.e(), uVar));
                if (g10 != null) {
                    g10.close();
                }
            } catch (Throwable th) {
                if (g10 != null) {
                    try {
                        g10.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.u0
        public void e() {
            if (C1127i.this.f33189a.e().a()) {
                return;
            }
            l9.e g10 = l9.c.g("ClientStreamListener.onReady");
            try {
                l9.c.a(C1127i.this.f33190b);
                C1127i.this.f33191c.execute(new C0312d(l9.c.e()));
                if (g10 != null) {
                    g10.close();
                }
            } catch (Throwable th) {
                if (g10 != null) {
                    try {
                        g10.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void f(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
            l9.e g10 = l9.c.g("ClientStreamListener.closed");
            try {
                l9.c.a(C1127i.this.f33190b);
                j(status, rpcProgress, uVar);
                if (g10 != null) {
                    g10.close();
                }
            } catch (Throwable th) {
                if (g10 != null) {
                    try {
                        g10.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public final void j(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
            C1203m u10 = C1127i.this.u();
            if (status.m() == Status.Code.CANCELLED && u10 != null && u10.h()) {
                F f10 = new F();
                C1127i.this.f33198j.appendTimeoutInsight(f10);
                status = Status.f32372i.e("ClientCall was cancelled at or after deadline. " + f10);
                uVar = new io.grpc.u();
            }
            C1127i.this.f33191c.execute(new c(l9.c.e(), status, uVar));
        }

        public final void k(Status status) {
            this.f33214b = status;
            C1127i.this.f33198j.cancel(status);
        }
    }

    /* compiled from: ClientCallImpl.java */
    /* renamed from: io.grpc.internal.i$e */
    /* loaded from: classes4.dex */
    public interface e {
        InterfaceC1128j a(MethodDescriptor<?, ?> methodDescriptor, C1108b c1108b, io.grpc.u uVar, Context context);
    }

    /* compiled from: ClientCallImpl.java */
    /* renamed from: io.grpc.internal.i$f */
    /* loaded from: classes4.dex */
    public final class f implements Context.b {
        public f() {
        }

        @Override // io.grpc.Context.b
        public void a(Context context) {
            C1127i.this.f33198j.cancel(C1113g.a(context));
        }
    }

    /* compiled from: ClientCallImpl.java */
    /* renamed from: io.grpc.internal.i$g */
    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final long f33229a;

        public g(long j10) {
            this.f33229a = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            double longValue;
            F f10 = new F();
            C1127i.this.f33198j.appendTimeoutInsight(f10);
            long abs = Math.abs(this.f33229a);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long nanos = abs / timeUnit.toNanos(1L);
            long abs2 = Math.abs(this.f33229a) % timeUnit.toNanos(1L);
            StringBuilder sb = new StringBuilder();
            sb.append("deadline exceeded after ");
            if (this.f33229a < 0) {
                sb.append('-');
            }
            sb.append(nanos);
            Locale locale = Locale.US;
            sb.append(String.format(locale, ".%09d", Long.valueOf(abs2)));
            sb.append("s. ");
            if (((Long) C1127i.this.f33197i.h(AbstractC1112f.f32442a)) == null) {
                longValue = 0.0d;
            } else {
                longValue = r2.longValue() / C1127i.f33188v;
            }
            sb.append(String.format(locale, "Name resolution delay %.9f seconds. ", Double.valueOf(longValue)));
            sb.append(f10);
            C1127i.this.f33198j.cancel(Status.f32372i.e(sb.toString()));
        }
    }

    public C1127i(MethodDescriptor<ReqT, RespT> methodDescriptor, Executor executor, C1108b c1108b, e eVar, ScheduledExecutorService scheduledExecutorService, C1125g c1125g, io.grpc.l lVar) {
        this.f33189a = methodDescriptor;
        l9.d b10 = l9.c.b(methodDescriptor.c(), System.identityHashCode(this));
        this.f33190b = b10;
        if (executor == MoreExecutors.a()) {
            this.f33191c = new g0();
            this.f33192d = true;
        } else {
            this.f33191c = new h0(executor);
            this.f33192d = false;
        }
        this.f33193e = c1125g;
        this.f33194f = Context.l();
        this.f33196h = methodDescriptor.e() == MethodDescriptor.MethodType.UNARY || methodDescriptor.e() == MethodDescriptor.MethodType.SERVER_STREAMING;
        this.f33197i = c1108b;
        this.f33202n = eVar;
        this.f33204p = scheduledExecutorService;
        l9.c.c("ClientCall.<init>", b10);
    }

    public static void prepareHeaders(io.grpc.u uVar, j9.o oVar, InterfaceC1199i interfaceC1199i, boolean z10) {
        uVar.f(GrpcUtil.f32527i);
        u.g<String> gVar = GrpcUtil.f32523e;
        uVar.f(gVar);
        if (interfaceC1199i != InterfaceC1197g.b.f34015a) {
            uVar.o(gVar, interfaceC1199i.a());
        }
        u.g<byte[]> gVar2 = GrpcUtil.f32524f;
        uVar.f(gVar2);
        byte[] a10 = j9.t.a(oVar);
        if (a10.length != 0) {
            uVar.o(gVar2, a10);
        }
        uVar.f(GrpcUtil.f32525g);
        u.g<byte[]> gVar3 = GrpcUtil.f32526h;
        uVar.f(gVar3);
        if (z10) {
            uVar.o(gVar3, f33187u);
        }
    }

    public static boolean w(C1203m c1203m, C1203m c1203m2) {
        if (c1203m == null) {
            return false;
        }
        if (c1203m2 == null) {
            return true;
        }
        return c1203m.g(c1203m2);
    }

    public static void x(C1203m c1203m, C1203m c1203m2, C1203m c1203m3) {
        Logger logger = f33186t;
        if (logger.isLoggable(Level.FINE) && c1203m != null && c1203m.equals(c1203m2)) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long max = Math.max(0L, c1203m.k(timeUnit));
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(max)));
            if (c1203m3 == null) {
                sb.append(" Explicit call timeout was not set.");
            } else {
                sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(c1203m3.k(timeUnit))));
            }
            logger.fine(sb.toString());
        }
    }

    public static C1203m y(C1203m c1203m, C1203m c1203m2) {
        if (c1203m == null) {
            return c1203m2;
        }
        if (c1203m2 == null) {
            return c1203m;
        }
        return c1203m.i(c1203m2);
    }

    public final void A(ReqT reqt) {
        boolean z10;
        if (this.f33198j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "Not started");
        com.google.common.base.k.v(!this.f33200l, "call was cancelled");
        com.google.common.base.k.v(!this.f33201m, "call was half-closed");
        try {
            InterfaceC1128j interfaceC1128j = this.f33198j;
            if (interfaceC1128j instanceof c0) {
                ((c0) interfaceC1128j).S(reqt);
            } else {
                interfaceC1128j.writeMessage(this.f33189a.j(reqt));
            }
            if (!this.f33196h) {
                this.f33198j.flush();
            }
        } catch (Error e10) {
            this.f33198j.cancel(Status.f32369f.r("Client sendMessage() failed with Error"));
            throw e10;
        } catch (RuntimeException e11) {
            this.f33198j.cancel(Status.f32369f.q(e11).r("Failed to stream message"));
        }
    }

    public C1127i<ReqT, RespT> B(C1200j c1200j) {
        this.f33207s = c1200j;
        return this;
    }

    public C1127i<ReqT, RespT> C(j9.o oVar) {
        this.f33206r = oVar;
        return this;
    }

    public C1127i<ReqT, RespT> D(boolean z10) {
        this.f33205q = z10;
        return this;
    }

    public final ScheduledFuture<?> E(C1203m c1203m) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long k10 = c1203m.k(timeUnit);
        return this.f33204p.schedule(new K(new g(k10)), k10, timeUnit);
    }

    public final void F(AbstractC1109c.a<RespT> aVar, io.grpc.u uVar) {
        boolean z10;
        InterfaceC1199i interfaceC1199i;
        String str;
        double longValue;
        if (this.f33198j == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "Already started");
        com.google.common.base.k.v(!this.f33200l, "call was cancelled");
        com.google.common.base.k.p(aVar, "observer");
        com.google.common.base.k.p(uVar, "headers");
        if (this.f33194f.u()) {
            this.f33198j = T.INSTANCE;
            this.f33191c.execute(new b(aVar));
            return;
        }
        r();
        String b10 = this.f33197i.b();
        if (b10 != null) {
            interfaceC1199i = this.f33207s.b(b10);
            if (interfaceC1199i == null) {
                this.f33198j = T.INSTANCE;
                this.f33191c.execute(new c(aVar, b10));
                return;
            }
        } else {
            interfaceC1199i = InterfaceC1197g.b.f34015a;
        }
        prepareHeaders(uVar, this.f33206r, interfaceC1199i, this.f33205q);
        C1203m u10 = u();
        if (u10 != null && u10.h()) {
            AbstractC1112f[] f10 = GrpcUtil.f(this.f33197i, uVar, 0, false);
            if (w(this.f33197i.d(), this.f33194f.s())) {
                str = "CallOptions";
            } else {
                str = "Context";
            }
            Long l10 = (Long) this.f33197i.h(AbstractC1112f.f32442a);
            double k10 = u10.k(TimeUnit.NANOSECONDS);
            double d10 = f33188v;
            Double valueOf = Double.valueOf(k10 / d10);
            if (l10 == null) {
                longValue = 0.0d;
            } else {
                longValue = l10.longValue() / d10;
            }
            this.f33198j = new C1138u(Status.f32372i.r(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", str, valueOf, Double.valueOf(longValue))), f10);
        } else {
            x(u10, this.f33194f.s(), this.f33197i.d());
            this.f33198j = this.f33202n.a(this.f33189a, this.f33197i, uVar, this.f33194f);
        }
        if (this.f33192d) {
            this.f33198j.optimizeForDirectExecutor();
        }
        if (this.f33197i.a() != null) {
            this.f33198j.setAuthority(this.f33197i.a());
        }
        if (this.f33197i.f() != null) {
            this.f33198j.setMaxInboundMessageSize(this.f33197i.f().intValue());
        }
        if (this.f33197i.g() != null) {
            this.f33198j.setMaxOutboundMessageSize(this.f33197i.g().intValue());
        }
        if (u10 != null) {
            this.f33198j.setDeadline(u10);
        }
        this.f33198j.setCompressor(interfaceC1199i);
        boolean z11 = this.f33205q;
        if (z11) {
            this.f33198j.setFullStreamDecompression(z11);
        }
        this.f33198j.setDecompressorRegistry(this.f33206r);
        this.f33193e.c();
        this.f33198j.start(new d(aVar));
        this.f33194f.a(this.f33203o, MoreExecutors.a());
        if (u10 != null && !u10.equals(this.f33194f.s()) && this.f33204p != null) {
            this.f33195g = E(u10);
        }
        if (this.f33199k) {
            z();
        }
    }

    @Override // io.grpc.AbstractC1109c
    public void a(String str, Throwable th) {
        l9.e g10 = l9.c.g("ClientCall.cancel");
        try {
            l9.c.a(this.f33190b);
            s(str, th);
            if (g10 != null) {
                g10.close();
            }
        } catch (Throwable th2) {
            if (g10 != null) {
                try {
                    g10.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // io.grpc.AbstractC1109c
    public void b() {
        l9.e g10 = l9.c.g("ClientCall.halfClose");
        try {
            l9.c.a(this.f33190b);
            v();
            if (g10 != null) {
                g10.close();
            }
        } catch (Throwable th) {
            if (g10 != null) {
                try {
                    g10.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.grpc.AbstractC1109c
    public void c(int i10) {
        boolean z10;
        l9.e g10 = l9.c.g("ClientCall.request");
        try {
            l9.c.a(this.f33190b);
            boolean z11 = false;
            if (this.f33198j != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "Not started");
            if (i10 >= 0) {
                z11 = true;
            }
            com.google.common.base.k.e(z11, "Number requested must be non-negative");
            this.f33198j.request(i10);
            if (g10 != null) {
                g10.close();
            }
        } catch (Throwable th) {
            if (g10 != null) {
                try {
                    g10.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.grpc.AbstractC1109c
    public void d(ReqT reqt) {
        l9.e g10 = l9.c.g("ClientCall.sendMessage");
        try {
            l9.c.a(this.f33190b);
            A(reqt);
            if (g10 != null) {
                g10.close();
            }
        } catch (Throwable th) {
            if (g10 != null) {
                try {
                    g10.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.grpc.AbstractC1109c
    public void e(AbstractC1109c.a<RespT> aVar, io.grpc.u uVar) {
        l9.e g10 = l9.c.g("ClientCall.start");
        try {
            l9.c.a(this.f33190b);
            F(aVar, uVar);
            if (g10 != null) {
                g10.close();
            }
        } catch (Throwable th) {
            if (g10 != null) {
                try {
                    g10.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void r() {
        C1108b v10;
        O.b bVar = (O.b) this.f33197i.h(O.b.f32828g);
        if (bVar == null) {
            return;
        }
        Long l10 = bVar.f32829a;
        if (l10 != null) {
            C1203m a10 = C1203m.a(l10.longValue(), TimeUnit.NANOSECONDS);
            C1203m d10 = this.f33197i.d();
            if (d10 == null || a10.compareTo(d10) < 0) {
                this.f33197i = this.f33197i.n(a10);
            }
        }
        Boolean bool = bVar.f32830b;
        if (bool != null) {
            if (bool.booleanValue()) {
                v10 = this.f33197i.u();
            } else {
                v10 = this.f33197i.v();
            }
            this.f33197i = v10;
        }
        if (bVar.f32831c != null) {
            Integer f10 = this.f33197i.f();
            if (f10 != null) {
                this.f33197i = this.f33197i.q(Math.min(f10.intValue(), bVar.f32831c.intValue()));
            } else {
                this.f33197i = this.f33197i.q(bVar.f32831c.intValue());
            }
        }
        if (bVar.f32832d != null) {
            Integer g10 = this.f33197i.g();
            if (g10 != null) {
                this.f33197i = this.f33197i.r(Math.min(g10.intValue(), bVar.f32832d.intValue()));
            } else {
                this.f33197i = this.f33197i.r(bVar.f32832d.intValue());
            }
        }
    }

    public final void s(String str, Throwable th) {
        Status r10;
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f33186t.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.f33200l) {
            return;
        }
        this.f33200l = true;
        try {
            if (this.f33198j != null) {
                Status status = Status.f32369f;
                if (str != null) {
                    r10 = status.r(str);
                } else {
                    r10 = status.r("Call cancelled without message");
                }
                if (th != null) {
                    r10 = r10.q(th);
                }
                this.f33198j.cancel(r10);
            }
            z();
        } catch (Throwable th2) {
            z();
            throw th2;
        }
    }

    public final void t(AbstractC1109c.a<RespT> aVar, Status status, io.grpc.u uVar) {
        aVar.a(status, uVar);
    }

    public String toString() {
        return com.google.common.base.f.c(this).d(Constants.MessagerConstants.METHOD_KEY, this.f33189a).toString();
    }

    public final C1203m u() {
        return y(this.f33197i.d(), this.f33194f.s());
    }

    public final void v() {
        boolean z10;
        if (this.f33198j != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "Not started");
        com.google.common.base.k.v(!this.f33200l, "call was cancelled");
        com.google.common.base.k.v(!this.f33201m, "call already half-closed");
        this.f33201m = true;
        this.f33198j.halfClose();
    }

    public final void z() {
        this.f33194f.B(this.f33203o);
        ScheduledFuture<?> scheduledFuture = this.f33195g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }
}
