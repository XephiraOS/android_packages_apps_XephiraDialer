package io.grpc.internal;

import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.A;
import io.grpc.C1107a;
import io.grpc.C1113g;
import io.grpc.Context;
import io.grpc.InternalChannelz;
import io.grpc.Status;
import io.grpc.internal.u0;
import io.grpc.u;
import j9.AbstractC1191a;
import j9.C1200j;
import j9.C1203m;
import j9.InterfaceC1204n;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import l9.C1300b;

/* loaded from: classes4.dex */
public final class ServerImpl extends io.grpc.z implements j9.v<Object> {

    /* renamed from: c, reason: collision with root package name */
    public final U<? extends Executor> f32906c;

    /* renamed from: d, reason: collision with root package name */
    public Executor f32907d;

    /* renamed from: e, reason: collision with root package name */
    public final j9.s f32908e;

    /* renamed from: f, reason: collision with root package name */
    public final j9.s f32909f;

    /* renamed from: g, reason: collision with root package name */
    public final List<j9.K> f32910g;

    /* renamed from: h, reason: collision with root package name */
    public final io.grpc.C[] f32911h;

    /* renamed from: i, reason: collision with root package name */
    public final long f32912i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f32913j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f32914k;

    /* renamed from: l, reason: collision with root package name */
    public Status f32915l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f32916m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f32917n;

    /* renamed from: o, reason: collision with root package name */
    public final H f32918o;

    /* renamed from: q, reason: collision with root package name */
    public boolean f32920q;

    /* renamed from: s, reason: collision with root package name */
    public final Context f32922s;

    /* renamed from: t, reason: collision with root package name */
    public final j9.o f32923t;

    /* renamed from: u, reason: collision with root package name */
    public final C1200j f32924u;

    /* renamed from: v, reason: collision with root package name */
    public final InternalChannelz f32925v;

    /* renamed from: w, reason: collision with root package name */
    public final C1125g f32926w;

    /* renamed from: x, reason: collision with root package name */
    public final C1203m.c f32927x;

    /* renamed from: y, reason: collision with root package name */
    public final j9.G f32928y;

    /* renamed from: z, reason: collision with root package name */
    public static final Logger f32904z = Logger.getLogger(ServerImpl.class.getName());

    /* renamed from: A, reason: collision with root package name */
    public static final m0 f32903A = new b();

    /* renamed from: p, reason: collision with root package name */
    public final Object f32919p = new Object();

    /* renamed from: r, reason: collision with root package name */
    public final Set<n0> f32921r = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final j9.w f32905b = j9.w.b("Server", String.valueOf(C()));

    /* loaded from: classes4.dex */
    public static final class ContextCloser implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Context.a f32929a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f32930b;

        public ContextCloser(Context.a aVar, Throwable th) {
            this.f32929a = aVar;
            this.f32930b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f32929a.Z(this.f32930b);
        }
    }

    /* loaded from: classes4.dex */
    public static final class JumpToApplicationThreadServerStreamListener implements m0 {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f32931a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f32932b;

        /* renamed from: c, reason: collision with root package name */
        public final Context.a f32933c;

        /* renamed from: d, reason: collision with root package name */
        public final l0 f32934d;

        /* renamed from: e, reason: collision with root package name */
        public final l9.d f32935e;

        /* renamed from: f, reason: collision with root package name */
        public m0 f32936f;

        /* loaded from: classes4.dex */
        public final class a extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1300b f32937b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Status f32938c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C1300b c1300b, Status status) {
                super(JumpToApplicationThreadServerStreamListener.this.f32933c);
                this.f32937b = c1300b;
                this.f32938c = status;
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                l9.e g10 = l9.c.g("ServerCallListener(app).closed");
                try {
                    l9.c.a(JumpToApplicationThreadServerStreamListener.this.f32935e);
                    l9.c.d(this.f32937b);
                    JumpToApplicationThreadServerStreamListener.this.l().a(this.f32938c);
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

        /* loaded from: classes4.dex */
        public final class b extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1300b f32940b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(C1300b c1300b) {
                super(JumpToApplicationThreadServerStreamListener.this.f32933c);
                this.f32940b = c1300b;
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                try {
                    l9.e g10 = l9.c.g("ServerCallListener(app).halfClosed");
                    try {
                        l9.c.a(JumpToApplicationThreadServerStreamListener.this.f32935e);
                        l9.c.d(this.f32940b);
                        JumpToApplicationThreadServerStreamListener.this.l().b();
                        if (g10 != null) {
                            g10.close();
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    JumpToApplicationThreadServerStreamListener.this.m(th);
                    throw th;
                }
            }
        }

        /* loaded from: classes4.dex */
        public final class c extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1300b f32942b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ u0.a f32943c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(C1300b c1300b, u0.a aVar) {
                super(JumpToApplicationThreadServerStreamListener.this.f32933c);
                this.f32942b = c1300b;
                this.f32943c = aVar;
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                try {
                    l9.e g10 = l9.c.g("ServerCallListener(app).messagesAvailable");
                    try {
                        l9.c.a(JumpToApplicationThreadServerStreamListener.this.f32935e);
                        l9.c.d(this.f32942b);
                        JumpToApplicationThreadServerStreamListener.this.l().c(this.f32943c);
                        if (g10 != null) {
                            g10.close();
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    JumpToApplicationThreadServerStreamListener.this.m(th);
                    throw th;
                }
            }
        }

        /* loaded from: classes4.dex */
        public final class d extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1300b f32945b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(C1300b c1300b) {
                super(JumpToApplicationThreadServerStreamListener.this.f32933c);
                this.f32945b = c1300b;
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                try {
                    l9.e g10 = l9.c.g("ServerCallListener(app).onReady");
                    try {
                        l9.c.a(JumpToApplicationThreadServerStreamListener.this.f32935e);
                        l9.c.d(this.f32945b);
                        JumpToApplicationThreadServerStreamListener.this.l().e();
                        if (g10 != null) {
                            g10.close();
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    JumpToApplicationThreadServerStreamListener.this.m(th);
                    throw th;
                }
            }
        }

        public JumpToApplicationThreadServerStreamListener(Executor executor, Executor executor2, l0 l0Var, Context.a aVar, l9.d dVar) {
            this.f32931a = executor;
            this.f32932b = executor2;
            this.f32934d = l0Var;
            this.f32933c = aVar;
            this.f32935e = dVar;
        }

        private void k(Status status) {
            if (!status.o()) {
                Throwable l10 = status.l();
                if (l10 == null) {
                    l10 = io.grpc.p.a(Status.f32369f.r("RPC cancelled"), null, false);
                }
                this.f32932b.execute(new ContextCloser(this.f32933c, l10));
            }
            this.f32931a.execute(new a(l9.c.e(), status));
        }

        @Override // io.grpc.internal.m0
        public void a(Status status) {
            l9.e g10 = l9.c.g("ServerStreamListener.closed");
            try {
                l9.c.a(this.f32935e);
                k(status);
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

        @Override // io.grpc.internal.m0
        public void b() {
            l9.e g10 = l9.c.g("ServerStreamListener.halfClosed");
            try {
                l9.c.a(this.f32935e);
                this.f32931a.execute(new b(l9.c.e()));
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
        public void c(u0.a aVar) {
            l9.e g10 = l9.c.g("ServerStreamListener.messagesAvailable");
            try {
                l9.c.a(this.f32935e);
                this.f32931a.execute(new c(l9.c.e(), aVar));
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
            l9.e g10 = l9.c.g("ServerStreamListener.onReady");
            try {
                l9.c.a(this.f32935e);
                this.f32931a.execute(new d(l9.c.e()));
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

        public final m0 l() {
            m0 m0Var = this.f32936f;
            if (m0Var != null) {
                return m0Var;
            }
            throw new IllegalStateException("listener unset");
        }

        public final void m(Throwable th) {
            this.f32934d.close(Status.f32370g.r("Application error processing RPC").q(th), new io.grpc.u());
        }

        public void setListener(m0 m0Var) {
            boolean z10;
            com.google.common.base.k.p(m0Var, "listener must not be null");
            if (this.f32936f == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "Listener already set");
            this.f32936f = m0Var;
        }
    }

    /* loaded from: classes4.dex */
    public final class c implements k0 {
        public c() {
        }

        @Override // io.grpc.internal.k0
        public void a() {
            synchronized (ServerImpl.this.f32919p) {
                try {
                    if (ServerImpl.this.f32916m) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList(ServerImpl.this.f32921r);
                    Status status = ServerImpl.this.f32915l;
                    ServerImpl.this.f32916m = true;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        n0 n0Var = (n0) it.next();
                        if (status == null) {
                            n0Var.shutdown();
                        } else {
                            n0Var.shutdownNow(status);
                        }
                    }
                    synchronized (ServerImpl.this.f32919p) {
                        ServerImpl.this.f32920q = true;
                        ServerImpl.this.B();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.internal.k0
        public o0 b(n0 n0Var) {
            synchronized (ServerImpl.this.f32919p) {
                ServerImpl.this.f32921r.add(n0Var);
            }
            d dVar = new d(n0Var);
            dVar.h();
            return dVar;
        }
    }

    public ServerImpl(j0 j0Var, H h10, Context context) {
        this.f32906c = (U) com.google.common.base.k.p(j0Var.f33246k, "executorPool");
        this.f32908e = (j9.s) com.google.common.base.k.p(j0Var.f33240e.b(), "registryBuilder");
        this.f32909f = (j9.s) com.google.common.base.k.p(j0Var.f33245j, "fallbackRegistry");
        this.f32918o = (H) com.google.common.base.k.p(h10, "transportServer");
        this.f32922s = ((Context) com.google.common.base.k.p(context, "rootContext")).r();
        this.f32923t = j0Var.f33247l;
        this.f32924u = j0Var.f33248m;
        this.f32910g = Collections.unmodifiableList(new ArrayList(j0Var.f33241f));
        List<io.grpc.C> list = j0Var.f33242g;
        this.f32911h = (io.grpc.C[]) list.toArray(new io.grpc.C[list.size()]);
        this.f32912i = j0Var.f33249n;
        InternalChannelz internalChannelz = j0Var.f33256u;
        this.f32925v = internalChannelz;
        this.f32926w = j0Var.f33257v.create();
        this.f32927x = (C1203m.c) com.google.common.base.k.p(j0Var.f33250o, "ticker");
        internalChannelz.d(this);
        this.f32928y = j0Var.f33258w;
    }

    public static /* synthetic */ AbstractC1191a s(ServerImpl serverImpl) {
        serverImpl.getClass();
        return null;
    }

    public final void B() {
        synchronized (this.f32919p) {
            try {
                if (this.f32914k && this.f32921r.isEmpty() && this.f32920q) {
                    if (!this.f32917n) {
                        this.f32917n = true;
                        this.f32925v.m(this);
                        Executor executor = this.f32907d;
                        if (executor != null) {
                            this.f32907d = this.f32906c.b(executor);
                        }
                        this.f32919p.notifyAll();
                    } else {
                        throw new AssertionError("Server already terminated");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final List<SocketAddress> C() {
        List<SocketAddress> unmodifiableList;
        synchronized (this.f32919p) {
            unmodifiableList = Collections.unmodifiableList(this.f32918o.getListenSocketAddresses());
        }
        return unmodifiableList;
    }

    public ServerImpl D() {
        synchronized (this.f32919p) {
            try {
                if (this.f32914k) {
                    return this;
                }
                this.f32914k = true;
                boolean z10 = this.f32913j;
                if (!z10) {
                    this.f32920q = true;
                    B();
                }
                if (z10) {
                    this.f32918o.shutdown();
                }
                return this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.z
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public ServerImpl b() {
        D();
        Status r10 = Status.f32383t.r("Server shutdownNow invoked");
        synchronized (this.f32919p) {
            try {
                if (this.f32915l != null) {
                    return this;
                }
                this.f32915l = r10;
                ArrayList arrayList = new ArrayList(this.f32921r);
                boolean z10 = this.f32916m;
                if (z10) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((n0) it.next()).shutdownNow(r10);
                    }
                }
                return this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.z
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public ServerImpl c() {
        synchronized (this.f32919p) {
            com.google.common.base.k.v(!this.f32913j, "Already started");
            com.google.common.base.k.v(!this.f32914k, "Shutting down");
            this.f32918o.start(new c());
            this.f32907d = (Executor) com.google.common.base.k.p(this.f32906c.a(), "executor");
            this.f32913j = true;
        }
        return this;
    }

    public final void G(n0 n0Var) {
        synchronized (this.f32919p) {
            try {
                if (this.f32921r.remove(n0Var)) {
                    this.f32925v.n(this, n0Var);
                    B();
                } else {
                    throw new AssertionError("Transport already removed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.z
    public boolean a(long j10, TimeUnit timeUnit) {
        boolean z10;
        synchronized (this.f32919p) {
            try {
                long nanoTime = System.nanoTime() + timeUnit.toNanos(j10);
                while (!this.f32917n) {
                    long nanoTime2 = nanoTime - System.nanoTime();
                    if (nanoTime2 <= 0) {
                        break;
                    }
                    TimeUnit.NANOSECONDS.timedWait(this.f32919p, nanoTime2);
                }
                z10 = this.f32917n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    @Override // j9.z
    public j9.w getLogId() {
        return this.f32905b;
    }

    public String toString() {
        return com.google.common.base.f.c(this).c("logId", this.f32905b.d()).d("transportServer", this.f32918o).toString();
    }

    /* loaded from: classes4.dex */
    public static final class b implements m0 {
        public b() {
        }

        @Override // io.grpc.internal.u0
        public void c(u0.a aVar) {
            while (true) {
                InputStream next = aVar.next();
                if (next != null) {
                    try {
                        next.close();
                    } catch (IOException e10) {
                        while (true) {
                            InputStream next2 = aVar.next();
                            if (next2 == null) {
                                break;
                            }
                            try {
                                next2.close();
                            } catch (IOException e11) {
                                ServerImpl.f32904z.log(Level.WARNING, "Exception closing stream", (Throwable) e11);
                            }
                        }
                        throw new RuntimeException(e10);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // io.grpc.internal.m0
        public void a(Status status) {
        }

        @Override // io.grpc.internal.m0
        public void b() {
        }

        @Override // io.grpc.internal.u0
        public void e() {
        }
    }

    /* loaded from: classes4.dex */
    public final class d implements o0 {

        /* renamed from: a, reason: collision with root package name */
        public final n0 f32948a;

        /* renamed from: b, reason: collision with root package name */
        public Future<?> f32949b;

        /* renamed from: c, reason: collision with root package name */
        public C1107a f32950c;

        /* loaded from: classes4.dex */
        public final class b extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context.a f32953b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ C1300b f32954c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ l9.d f32955d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ com.google.common.util.concurrent.i f32956e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ String f32957f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f32958g;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ l0 f32959h;

            /* renamed from: i, reason: collision with root package name */
            public final /* synthetic */ JumpToApplicationThreadServerStreamListener f32960i;

            /* loaded from: classes4.dex */
            public final class a implements Context.b {
                public a() {
                }

                @Override // io.grpc.Context.b
                public void a(Context context) {
                    Status a10 = C1113g.a(context);
                    if (Status.f32372i.m().equals(a10.m())) {
                        b.this.f32959h.cancel(a10);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context.a aVar, C1300b c1300b, l9.d dVar, com.google.common.util.concurrent.i iVar, String str, io.grpc.u uVar, l0 l0Var, JumpToApplicationThreadServerStreamListener jumpToApplicationThreadServerStreamListener) {
                super(aVar);
                this.f32953b = aVar;
                this.f32954c = c1300b;
                this.f32955d = dVar;
                this.f32956e = iVar;
                this.f32957f = str;
                this.f32958g = uVar;
                this.f32959h = l0Var;
                this.f32960i = jumpToApplicationThreadServerStreamListener;
            }

            private void b() {
                m0 m0Var = ServerImpl.f32903A;
                if (!this.f32956e.isCancelled()) {
                    try {
                        this.f32960i.setListener(d.this.i(this.f32957f, (e) com.google.common.util.concurrent.a.a(this.f32956e), this.f32958g));
                        this.f32953b.a(new a(), MoreExecutors.a());
                    } finally {
                    }
                }
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                l9.e g10 = l9.c.g("ServerTransportListener$HandleServerCall.startCall");
                try {
                    l9.c.d(this.f32954c);
                    l9.c.a(this.f32955d);
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

        /* loaded from: classes4.dex */
        public final class c extends AbstractRunnableC1133o {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context.a f32963b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ l9.d f32964c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ C1300b f32965d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f32966e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ l0 f32967f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ JumpToApplicationThreadServerStreamListener f32968g;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ com.google.common.util.concurrent.i f32969h;

            /* renamed from: i, reason: collision with root package name */
            public final /* synthetic */ s0 f32970i;

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f32971j;

            /* renamed from: k, reason: collision with root package name */
            public final /* synthetic */ Executor f32972k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Context.a aVar, l9.d dVar, C1300b c1300b, String str, l0 l0Var, JumpToApplicationThreadServerStreamListener jumpToApplicationThreadServerStreamListener, com.google.common.util.concurrent.i iVar, s0 s0Var, io.grpc.u uVar, Executor executor) {
                super(aVar);
                this.f32963b = aVar;
                this.f32964c = dVar;
                this.f32965d = c1300b;
                this.f32966e = str;
                this.f32967f = l0Var;
                this.f32968g = jumpToApplicationThreadServerStreamListener;
                this.f32969h = iVar;
                this.f32970i = s0Var;
                this.f32971j = uVar;
                this.f32972k = executor;
            }

            private void c() {
                try {
                    j9.H<?, ?> a10 = ServerImpl.this.f32908e.a(this.f32966e);
                    if (a10 == null) {
                        a10 = ServerImpl.this.f32909f.b(this.f32966e, this.f32967f.getAuthority());
                    }
                    if (a10 == null) {
                        Status r10 = Status.f32381r.r("Method not found: " + this.f32966e);
                        this.f32968g.setListener(ServerImpl.f32903A);
                        this.f32967f.close(r10, new io.grpc.u());
                        this.f32963b.Z(null);
                        this.f32969h.cancel(false);
                        return;
                    }
                    this.f32969h.A(b(d.this.k(this.f32967f, a10, this.f32970i), this.f32967f, this.f32971j, this.f32963b, this.f32964c));
                } catch (Throwable th) {
                    this.f32968g.setListener(ServerImpl.f32903A);
                    this.f32967f.close(Status.k(th), new io.grpc.u());
                    this.f32963b.Z(null);
                    this.f32969h.cancel(false);
                    throw th;
                }
            }

            @Override // io.grpc.internal.AbstractRunnableC1133o
            public void a() {
                l9.e g10 = l9.c.g("ServerTransportListener$MethodLookup.startCall");
                try {
                    l9.c.a(this.f32964c);
                    l9.c.d(this.f32965d);
                    c();
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

            public final <ReqT, RespT> e<ReqT, RespT> b(j9.H<ReqT, RespT> h10, l0 l0Var, io.grpc.u uVar, Context.a aVar, l9.d dVar) {
                Executor a10;
                ServerCallImpl serverCallImpl = new ServerCallImpl(l0Var, h10.b(), uVar, aVar, ServerImpl.this.f32923t, ServerImpl.this.f32924u, ServerImpl.this.f32926w, dVar);
                if (ServerImpl.this.f32928y != null && (a10 = ServerImpl.this.f32928y.a(serverCallImpl, uVar)) != null) {
                    ((h0) this.f32972k).e(a10);
                }
                return new e<>(serverCallImpl, h10.c());
            }
        }

        /* renamed from: io.grpc.internal.ServerImpl$d$d, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0310d implements Runnable {
            public RunnableC0310d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f32948a.shutdownNow(Status.f32369f.r("Handshake timeout exceeded"));
            }
        }

        /* loaded from: classes4.dex */
        public final class e<ReqT, RespT> {

            /* renamed from: a, reason: collision with root package name */
            public ServerCallImpl<ReqT, RespT> f32975a;

            /* renamed from: b, reason: collision with root package name */
            public io.grpc.B<ReqT, RespT> f32976b;

            public e(ServerCallImpl<ReqT, RespT> serverCallImpl, io.grpc.B<ReqT, RespT> b10) {
                this.f32975a = serverCallImpl;
                this.f32976b = b10;
            }
        }

        public d(n0 n0Var) {
            this.f32948a = n0Var;
        }

        @Override // io.grpc.internal.o0
        public void a() {
            Future<?> future = this.f32949b;
            if (future != null) {
                future.cancel(false);
                this.f32949b = null;
            }
            Iterator it = ServerImpl.this.f32910g.iterator();
            while (it.hasNext()) {
                ((j9.K) it.next()).b(this.f32950c);
            }
            ServerImpl.this.G(this.f32948a);
        }

        @Override // io.grpc.internal.o0
        public void b(l0 l0Var, String str, io.grpc.u uVar) {
            l9.d b10 = l9.c.b(str, l0Var.streamId());
            l9.e g10 = l9.c.g("ServerTransportListener.streamCreated");
            try {
                l9.c.a(b10);
                j(l0Var, str, uVar, b10);
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

        @Override // io.grpc.internal.o0
        public C1107a c(C1107a c1107a) {
            this.f32949b.cancel(false);
            this.f32949b = null;
            for (j9.K k10 : ServerImpl.this.f32910g) {
                c1107a = (C1107a) com.google.common.base.k.q(k10.a(c1107a), "Filter %s returned null", k10);
            }
            this.f32950c = c1107a;
            return c1107a;
        }

        public final Context.a g(io.grpc.u uVar, s0 s0Var) {
            Long l10 = (Long) uVar.h(GrpcUtil.f32522d);
            Context S10 = s0Var.l(ServerImpl.this.f32922s).S(io.grpc.n.f33421a, ServerImpl.this);
            if (l10 == null) {
                return S10.L();
            }
            return S10.O(C1203m.b(l10.longValue(), TimeUnit.NANOSECONDS, ServerImpl.this.f32927x), this.f32948a.getScheduledExecutorService());
        }

        public void h() {
            if (ServerImpl.this.f32912i != Long.MAX_VALUE) {
                this.f32949b = this.f32948a.getScheduledExecutorService().schedule(new RunnableC0310d(), ServerImpl.this.f32912i, TimeUnit.MILLISECONDS);
            } else {
                this.f32949b = new FutureTask(new a(), null);
            }
            ServerImpl.this.f32925v.e(ServerImpl.this, this.f32948a);
        }

        public final <WReqT, WRespT> m0 i(String str, e<WReqT, WRespT> eVar, io.grpc.u uVar) {
            A.a<WReqT> a10 = eVar.f32976b.a(eVar.f32975a, uVar);
            if (a10 != null) {
                return eVar.f32975a.l(a10);
            }
            throw new NullPointerException("startCall() returned a null listener for method " + str);
        }

        public final void j(l0 l0Var, String str, io.grpc.u uVar, l9.d dVar) {
            Executor h0Var;
            if (ServerImpl.this.f32928y == null && ServerImpl.this.f32907d == MoreExecutors.a()) {
                h0Var = new g0();
                l0Var.optimizeForDirectExecutor();
            } else {
                h0Var = new h0(ServerImpl.this.f32907d);
            }
            Executor executor = h0Var;
            u.g<String> gVar = GrpcUtil.f32523e;
            if (uVar.e(gVar)) {
                String str2 = (String) uVar.h(gVar);
                InterfaceC1204n e10 = ServerImpl.this.f32923t.e(str2);
                if (e10 == null) {
                    l0Var.setListener(ServerImpl.f32903A);
                    l0Var.close(Status.f32381r.r(String.format("Can't find decompressor for %s", str2)), new io.grpc.u());
                    return;
                }
                l0Var.setDecompressor(e10);
            }
            s0 s0Var = (s0) com.google.common.base.k.p(l0Var.statsTraceContext(), "statsTraceCtx not present from stream");
            Context.a g10 = g(uVar, s0Var);
            C1300b e11 = l9.c.e();
            JumpToApplicationThreadServerStreamListener jumpToApplicationThreadServerStreamListener = new JumpToApplicationThreadServerStreamListener(executor, ServerImpl.this.f32907d, l0Var, g10, dVar);
            l0Var.setListener(jumpToApplicationThreadServerStreamListener);
            com.google.common.util.concurrent.i B10 = com.google.common.util.concurrent.i.B();
            executor.execute(new c(g10, dVar, e11, str, l0Var, jumpToApplicationThreadServerStreamListener, B10, s0Var, uVar, executor));
            executor.execute(new b(g10, e11, dVar, B10, str, uVar, l0Var, jumpToApplicationThreadServerStreamListener));
        }

        public final <ReqT, RespT> j9.H<?, ?> k(l0 l0Var, j9.H<ReqT, RespT> h10, s0 s0Var) {
            s0Var.k(new i0(h10.b(), l0Var.getAttributes(), l0Var.getAuthority()));
            io.grpc.B<ReqT, RespT> c10 = h10.c();
            for (io.grpc.C c11 : ServerImpl.this.f32911h) {
                c10 = j9.y.a(c11, c10);
            }
            j9.H<ReqT, RespT> d10 = h10.d(c10);
            ServerImpl.s(ServerImpl.this);
            return d10;
        }

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }
    }
}
