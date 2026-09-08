package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.C1107a;
import io.grpc.C1108b;
import io.grpc.C1114h;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.InterfaceC1117c;
import io.grpc.internal.InterfaceC1130l;
import io.grpc.internal.P;
import j9.C1201k;
import j9.N;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class InternalSubchannel implements j9.v<Object>, w0 {

    /* renamed from: a, reason: collision with root package name */
    public final j9.w f32546a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32547b;

    /* renamed from: c, reason: collision with root package name */
    public final String f32548c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1117c.a f32549d;

    /* renamed from: e, reason: collision with root package name */
    public final i f32550e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC1130l f32551f;

    /* renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f32552g;

    /* renamed from: h, reason: collision with root package name */
    public final InternalChannelz f32553h;

    /* renamed from: i, reason: collision with root package name */
    public final C1125g f32554i;

    /* renamed from: j, reason: collision with root package name */
    public final ChannelTracer f32555j;

    /* renamed from: k, reason: collision with root package name */
    public final ChannelLogger f32556k;

    /* renamed from: l, reason: collision with root package name */
    public final j9.N f32557l;

    /* renamed from: m, reason: collision with root package name */
    public final Index f32558m;

    /* renamed from: n, reason: collision with root package name */
    public volatile List<C1114h> f32559n;

    /* renamed from: o, reason: collision with root package name */
    public InterfaceC1117c f32560o;

    /* renamed from: p, reason: collision with root package name */
    public final com.google.common.base.m f32561p;

    /* renamed from: q, reason: collision with root package name */
    public N.d f32562q;

    /* renamed from: r, reason: collision with root package name */
    public N.d f32563r;

    /* renamed from: s, reason: collision with root package name */
    public P f32564s;

    /* renamed from: v, reason: collision with root package name */
    public InterfaceC1131m f32567v;

    /* renamed from: w, reason: collision with root package name */
    public volatile P f32568w;

    /* renamed from: y, reason: collision with root package name */
    public Status f32570y;

    /* renamed from: t, reason: collision with root package name */
    public final Collection<InterfaceC1131m> f32565t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final E<InterfaceC1131m> f32566u = new a();

    /* renamed from: x, reason: collision with root package name */
    public volatile C1201k f32569x = C1201k.a(ConnectivityState.IDLE);

    /* loaded from: classes4.dex */
    public static final class CallTracingTransport extends AbstractC1143z {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1131m f32571a;

        /* renamed from: b, reason: collision with root package name */
        public final C1125g f32572b;

        /* loaded from: classes4.dex */
        public class a extends AbstractC1141x {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterfaceC1128j f32573a;

            /* renamed from: io.grpc.internal.InternalSubchannel$CallTracingTransport$a$a, reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0309a extends AbstractC1142y {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ClientStreamListener f32575a;

                public C0309a(ClientStreamListener clientStreamListener) {
                    this.f32575a = clientStreamListener;
                }

                @Override // io.grpc.internal.AbstractC1142y, io.grpc.internal.ClientStreamListener
                public void f(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
                    CallTracingTransport.this.f32572b.b(status.o());
                    super.f(status, rpcProgress, uVar);
                }

                @Override // io.grpc.internal.AbstractC1142y
                public ClientStreamListener g() {
                    return this.f32575a;
                }
            }

            public a(InterfaceC1128j interfaceC1128j) {
                this.f32573a = interfaceC1128j;
            }

            @Override // io.grpc.internal.AbstractC1141x
            public InterfaceC1128j a() {
                return this.f32573a;
            }

            @Override // io.grpc.internal.AbstractC1141x, io.grpc.internal.InterfaceC1128j
            public void start(ClientStreamListener clientStreamListener) {
                CallTracingTransport.this.f32572b.c();
                super.start(new C0309a(clientStreamListener));
            }
        }

        public /* synthetic */ CallTracingTransport(InterfaceC1131m interfaceC1131m, C1125g c1125g, a aVar) {
            this(interfaceC1131m, c1125g);
        }

        @Override // io.grpc.internal.AbstractC1143z
        public InterfaceC1131m a() {
            return this.f32571a;
        }

        @Override // io.grpc.internal.AbstractC1143z, io.grpc.internal.InterfaceC1129k
        public InterfaceC1128j newStream(MethodDescriptor<?, ?> methodDescriptor, io.grpc.u uVar, C1108b c1108b, AbstractC1112f[] abstractC1112fArr) {
            return new a(super.newStream(methodDescriptor, uVar, c1108b, abstractC1112fArr));
        }

        public CallTracingTransport(InterfaceC1131m interfaceC1131m, C1125g c1125g) {
            this.f32571a = interfaceC1131m;
            this.f32572b = c1125g;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Index {

        /* renamed from: a, reason: collision with root package name */
        public List<C1114h> f32577a;

        /* renamed from: b, reason: collision with root package name */
        public int f32578b;

        /* renamed from: c, reason: collision with root package name */
        public int f32579c;

        public Index(List<C1114h> list) {
            this.f32577a = list;
        }

        public SocketAddress a() {
            return this.f32577a.get(this.f32578b).a().get(this.f32579c);
        }

        public C1107a b() {
            return this.f32577a.get(this.f32578b).b();
        }

        public void c() {
            C1114h c1114h = this.f32577a.get(this.f32578b);
            int i10 = this.f32579c + 1;
            this.f32579c = i10;
            if (i10 >= c1114h.a().size()) {
                this.f32578b++;
                this.f32579c = 0;
            }
        }

        public boolean d() {
            if (this.f32578b == 0 && this.f32579c == 0) {
                return true;
            }
            return false;
        }

        public boolean e() {
            if (this.f32578b < this.f32577a.size()) {
                return true;
            }
            return false;
        }

        public void f() {
            this.f32578b = 0;
            this.f32579c = 0;
        }

        public boolean g(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f32577a.size(); i10++) {
                int indexOf = this.f32577a.get(i10).a().indexOf(socketAddress);
                if (indexOf != -1) {
                    this.f32578b = i10;
                    this.f32579c = indexOf;
                    return true;
                }
            }
            return false;
        }

        public void h(List<C1114h> list) {
            this.f32577a = list;
            f();
        }
    }

    /* loaded from: classes4.dex */
    public static final class TransportLogger extends ChannelLogger {

        /* renamed from: a, reason: collision with root package name */
        public j9.w f32580a;

        @Override // io.grpc.ChannelLogger
        public void a(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
            C1126h.d(this.f32580a, channelLogLevel, str);
        }

        @Override // io.grpc.ChannelLogger
        public void b(ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
            C1126h.e(this.f32580a, channelLogLevel, str, objArr);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends E<InterfaceC1131m> {
        public a() {
        }

        @Override // io.grpc.internal.E
        public void handleInUse() {
            InternalSubchannel.this.f32550e.a(InternalSubchannel.this);
        }

        @Override // io.grpc.internal.E
        public void handleNotInUse() {
            InternalSubchannel.this.f32550e.b(InternalSubchannel.this);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InternalSubchannel.this.f32562q = null;
            InternalSubchannel.this.f32556k.a(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING after backoff");
            InternalSubchannel.this.G(ConnectivityState.CONNECTING);
            InternalSubchannel.this.M();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InternalSubchannel.this.f32569x.c() == ConnectivityState.IDLE) {
                InternalSubchannel.this.f32556k.a(ChannelLogger.ChannelLogLevel.INFO, "CONNECTING as requested");
                InternalSubchannel.this.G(ConnectivityState.CONNECTING);
                InternalSubchannel.this.M();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f32584a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                P p10 = InternalSubchannel.this.f32564s;
                InternalSubchannel.this.f32563r = null;
                InternalSubchannel.this.f32564s = null;
                p10.shutdown(Status.f32383t.r("InternalSubchannel closed transport due to address change"));
            }
        }

        public d(List list) {
            this.f32584a = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0094  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel$Index r0 = io.grpc.internal.InternalSubchannel.C(r0)
                java.net.SocketAddress r0 = r0.a()
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel$Index r1 = io.grpc.internal.InternalSubchannel.C(r1)
                java.util.List r2 = r7.f32584a
                r1.h(r2)
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                java.util.List r2 = r7.f32584a
                io.grpc.internal.InternalSubchannel.D(r1, r2)
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                j9.k r1 = io.grpc.internal.InternalSubchannel.c(r1)
                io.grpc.ConnectivityState r1 = r1.c()
                io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.READY
                r3 = 0
                if (r1 == r2) goto L39
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                j9.k r1 = io.grpc.internal.InternalSubchannel.c(r1)
                io.grpc.ConnectivityState r1 = r1.c()
                io.grpc.ConnectivityState r4 = io.grpc.ConnectivityState.CONNECTING
                if (r1 != r4) goto L91
            L39:
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel$Index r1 = io.grpc.internal.InternalSubchannel.C(r1)
                boolean r0 = r1.g(r0)
                if (r0 != 0) goto L91
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                j9.k r0 = io.grpc.internal.InternalSubchannel.c(r0)
                io.grpc.ConnectivityState r0 = r0.c()
                if (r0 != r2) goto L6d
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.P r0 = io.grpc.internal.InternalSubchannel.d(r0)
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel.e(r1, r3)
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel$Index r1 = io.grpc.internal.InternalSubchannel.C(r1)
                r1.f()
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.ConnectivityState r2 = io.grpc.ConnectivityState.IDLE
                io.grpc.internal.InternalSubchannel.y(r1, r2)
                goto L92
            L6d:
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.m r0 = io.grpc.internal.InternalSubchannel.f(r0)
                io.grpc.Status r1 = io.grpc.Status.f32383t
                java.lang.String r2 = "InternalSubchannel closed pending transport due to address change"
                io.grpc.Status r1 = r1.r(r2)
                r0.shutdown(r1)
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel.g(r0, r3)
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel$Index r0 = io.grpc.internal.InternalSubchannel.C(r0)
                r0.f()
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel.z(r0)
            L91:
                r0 = r3
            L92:
                if (r0 == 0) goto Le1
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                j9.N$d r1 = io.grpc.internal.InternalSubchannel.h(r1)
                if (r1 == 0) goto Lc0
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.P r1 = io.grpc.internal.InternalSubchannel.j(r1)
                io.grpc.Status r2 = io.grpc.Status.f32383t
                java.lang.String r4 = "InternalSubchannel closed transport early due to address change"
                io.grpc.Status r2 = r2.r(r4)
                r1.shutdown(r2)
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                j9.N$d r1 = io.grpc.internal.InternalSubchannel.h(r1)
                r1.a()
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel.i(r1, r3)
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel.k(r1, r3)
            Lc0:
                io.grpc.internal.InternalSubchannel r1 = io.grpc.internal.InternalSubchannel.this
                io.grpc.internal.InternalSubchannel.k(r1, r0)
                io.grpc.internal.InternalSubchannel r0 = io.grpc.internal.InternalSubchannel.this
                j9.N r1 = io.grpc.internal.InternalSubchannel.m(r0)
                io.grpc.internal.InternalSubchannel$d$a r2 = new io.grpc.internal.InternalSubchannel$d$a
                r2.<init>()
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
                io.grpc.internal.InternalSubchannel r7 = io.grpc.internal.InternalSubchannel.this
                java.util.concurrent.ScheduledExecutorService r6 = io.grpc.internal.InternalSubchannel.l(r7)
                r3 = 5
                j9.N$d r7 = r1.c(r2, r3, r5, r6)
                io.grpc.internal.InternalSubchannel.i(r0, r7)
            Le1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.InternalSubchannel.d.run():void");
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Status f32587a;

        public e(Status status) {
            this.f32587a = status;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConnectivityState c10 = InternalSubchannel.this.f32569x.c();
            ConnectivityState connectivityState = ConnectivityState.SHUTDOWN;
            if (c10 == connectivityState) {
                return;
            }
            InternalSubchannel.this.f32570y = this.f32587a;
            P p10 = InternalSubchannel.this.f32568w;
            InterfaceC1131m interfaceC1131m = InternalSubchannel.this.f32567v;
            InternalSubchannel.this.f32568w = null;
            InternalSubchannel.this.f32567v = null;
            InternalSubchannel.this.G(connectivityState);
            InternalSubchannel.this.f32558m.f();
            if (InternalSubchannel.this.f32565t.isEmpty()) {
                InternalSubchannel.this.I();
            }
            InternalSubchannel.this.E();
            if (InternalSubchannel.this.f32563r != null) {
                InternalSubchannel.this.f32563r.a();
                InternalSubchannel.this.f32564s.shutdown(this.f32587a);
                InternalSubchannel.this.f32563r = null;
                InternalSubchannel.this.f32564s = null;
            }
            if (p10 != null) {
                p10.shutdown(this.f32587a);
            }
            if (interfaceC1131m != null) {
                interfaceC1131m.shutdown(this.f32587a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InternalSubchannel.this.f32556k.a(ChannelLogger.ChannelLogLevel.INFO, "Terminated");
            InternalSubchannel.this.f32550e.d(InternalSubchannel.this);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1131m f32590a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f32591b;

        public g(InterfaceC1131m interfaceC1131m, boolean z10) {
            this.f32590a = interfaceC1131m;
            this.f32591b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            InternalSubchannel.this.f32566u.updateObjectInUse(this.f32590a, this.f32591b);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Status f32593a;

        public h(Status status) {
            this.f32593a = status;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(InternalSubchannel.this.f32565t).iterator();
            while (it.hasNext()) {
                ((P) it.next()).shutdownNow(this.f32593a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class i {
        public abstract void a(InternalSubchannel internalSubchannel);

        public abstract void b(InternalSubchannel internalSubchannel);

        public abstract void c(InternalSubchannel internalSubchannel, C1201k c1201k);

        public abstract void d(InternalSubchannel internalSubchannel);
    }

    /* loaded from: classes4.dex */
    public class j implements P.a {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1131m f32595a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f32596b = false;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                InternalSubchannel.this.f32560o = null;
                if (InternalSubchannel.this.f32570y == null) {
                    InterfaceC1131m interfaceC1131m = InternalSubchannel.this.f32567v;
                    j jVar = j.this;
                    InterfaceC1131m interfaceC1131m2 = jVar.f32595a;
                    if (interfaceC1131m == interfaceC1131m2) {
                        InternalSubchannel.this.f32568w = interfaceC1131m2;
                        InternalSubchannel.this.f32567v = null;
                        InternalSubchannel.this.G(ConnectivityState.READY);
                        return;
                    }
                    return;
                }
                if (InternalSubchannel.this.f32568w == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.v(z10, "Unexpected non-null activeTransport");
                j jVar2 = j.this;
                jVar2.f32595a.shutdown(InternalSubchannel.this.f32570y);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Status f32599a;

            public b(Status status) {
                this.f32599a = status;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                if (InternalSubchannel.this.f32569x.c() != ConnectivityState.SHUTDOWN) {
                    P p10 = InternalSubchannel.this.f32568w;
                    j jVar = j.this;
                    if (p10 == jVar.f32595a) {
                        InternalSubchannel.this.f32568w = null;
                        InternalSubchannel.this.f32558m.f();
                        InternalSubchannel.this.G(ConnectivityState.IDLE);
                        return;
                    }
                    InterfaceC1131m interfaceC1131m = InternalSubchannel.this.f32567v;
                    j jVar2 = j.this;
                    if (interfaceC1131m == jVar2.f32595a) {
                        if (InternalSubchannel.this.f32569x.c() == ConnectivityState.CONNECTING) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        com.google.common.base.k.x(z10, "Expected state is CONNECTING, actual state is %s", InternalSubchannel.this.f32569x.c());
                        InternalSubchannel.this.f32558m.c();
                        if (!InternalSubchannel.this.f32558m.e()) {
                            InternalSubchannel.this.f32567v = null;
                            InternalSubchannel.this.f32558m.f();
                            InternalSubchannel.this.L(this.f32599a);
                            return;
                        }
                        InternalSubchannel.this.M();
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InternalSubchannel.this.f32565t.remove(j.this.f32595a);
                if (InternalSubchannel.this.f32569x.c() == ConnectivityState.SHUTDOWN && InternalSubchannel.this.f32565t.isEmpty()) {
                    InternalSubchannel.this.I();
                }
            }
        }

        public j(InterfaceC1131m interfaceC1131m) {
            this.f32595a = interfaceC1131m;
        }

        @Override // io.grpc.internal.P.a
        public void a() {
            com.google.common.base.k.v(this.f32596b, "transportShutdown() must be called before transportTerminated().");
            InternalSubchannel.this.f32556k.b(ChannelLogger.ChannelLogLevel.INFO, "{0} Terminated", this.f32595a.getLogId());
            InternalSubchannel.this.f32553h.k(this.f32595a);
            InternalSubchannel.this.J(this.f32595a, false);
            InternalSubchannel.this.f32557l.execute(new c());
        }

        @Override // io.grpc.internal.P.a
        public void b(Status status) {
            InternalSubchannel.this.f32556k.b(ChannelLogger.ChannelLogLevel.INFO, "{0} SHUTDOWN with {1}", this.f32595a.getLogId(), InternalSubchannel.this.K(status));
            this.f32596b = true;
            InternalSubchannel.this.f32557l.execute(new b(status));
        }

        @Override // io.grpc.internal.P.a
        public void c() {
            InternalSubchannel.this.f32556k.a(ChannelLogger.ChannelLogLevel.INFO, "READY");
            InternalSubchannel.this.f32557l.execute(new a());
        }

        @Override // io.grpc.internal.P.a
        public void d(boolean z10) {
            InternalSubchannel.this.J(this.f32595a, z10);
        }
    }

    public InternalSubchannel(List<C1114h> list, String str, String str2, InterfaceC1117c.a aVar, InterfaceC1130l interfaceC1130l, ScheduledExecutorService scheduledExecutorService, com.google.common.base.o<com.google.common.base.m> oVar, j9.N n10, i iVar, InternalChannelz internalChannelz, C1125g c1125g, ChannelTracer channelTracer, j9.w wVar, ChannelLogger channelLogger) {
        com.google.common.base.k.p(list, "addressGroups");
        com.google.common.base.k.e(!list.isEmpty(), "addressGroups is empty");
        F(list, "addressGroups contains null entry");
        List<C1114h> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f32559n = unmodifiableList;
        this.f32558m = new Index(unmodifiableList);
        this.f32547b = str;
        this.f32548c = str2;
        this.f32549d = aVar;
        this.f32551f = interfaceC1130l;
        this.f32552g = scheduledExecutorService;
        this.f32561p = oVar.get();
        this.f32557l = n10;
        this.f32550e = iVar;
        this.f32553h = internalChannelz;
        this.f32554i = c1125g;
        this.f32555j = (ChannelTracer) com.google.common.base.k.p(channelTracer, "channelTracer");
        this.f32546a = (j9.w) com.google.common.base.k.p(wVar, "logId");
        this.f32556k = (ChannelLogger) com.google.common.base.k.p(channelLogger, "channelLogger");
    }

    public static void F(List<?> list, String str) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            com.google.common.base.k.p(it.next(), str);
        }
    }

    public final void E() {
        this.f32557l.e();
        N.d dVar = this.f32562q;
        if (dVar != null) {
            dVar.a();
            this.f32562q = null;
            this.f32560o = null;
        }
    }

    public final void G(ConnectivityState connectivityState) {
        this.f32557l.e();
        H(C1201k.a(connectivityState));
    }

    public final void H(C1201k c1201k) {
        boolean z10;
        this.f32557l.e();
        if (this.f32569x.c() != c1201k.c()) {
            if (this.f32569x.c() != ConnectivityState.SHUTDOWN) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "Cannot transition out of SHUTDOWN to " + c1201k);
            this.f32569x = c1201k;
            this.f32550e.c(this, c1201k);
        }
    }

    public final void I() {
        this.f32557l.execute(new f());
    }

    public final void J(InterfaceC1131m interfaceC1131m, boolean z10) {
        this.f32557l.execute(new g(interfaceC1131m, z10));
    }

    public final String K(Status status) {
        StringBuilder sb = new StringBuilder();
        sb.append(status.m());
        if (status.n() != null) {
            sb.append("(");
            sb.append(status.n());
            sb.append(")");
        }
        if (status.l() != null) {
            sb.append("[");
            sb.append(status.l());
            sb.append("]");
        }
        return sb.toString();
    }

    public final void L(Status status) {
        boolean z10;
        this.f32557l.e();
        H(C1201k.b(status));
        if (this.f32560o == null) {
            this.f32560o = this.f32549d.get();
        }
        long a10 = this.f32560o.a();
        com.google.common.base.m mVar = this.f32561p;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long d10 = a10 - mVar.d(timeUnit);
        this.f32556k.b(ChannelLogger.ChannelLogLevel.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", K(status), Long.valueOf(d10));
        if (this.f32562q == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "previous reconnectTask is not done");
        this.f32562q = this.f32557l.c(new b(), d10, timeUnit, this.f32552g);
    }

    public final void M() {
        boolean z10;
        SocketAddress socketAddress;
        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress;
        this.f32557l.e();
        if (this.f32562q == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "Should have no reconnectTask scheduled");
        if (this.f32558m.d()) {
            this.f32561p.f().g();
        }
        SocketAddress a10 = this.f32558m.a();
        a aVar = null;
        if (a10 instanceof HttpConnectProxiedSocketAddress) {
            httpConnectProxiedSocketAddress = (HttpConnectProxiedSocketAddress) a10;
            socketAddress = httpConnectProxiedSocketAddress.a();
        } else {
            socketAddress = a10;
            httpConnectProxiedSocketAddress = null;
        }
        C1107a b10 = this.f32558m.b();
        String str = (String) b10.b(C1114h.f32449d);
        InterfaceC1130l.a aVar2 = new InterfaceC1130l.a();
        if (str == null) {
            str = this.f32547b;
        }
        InterfaceC1130l.a f10 = aVar2.d(str).e(b10).g(this.f32548c).f(httpConnectProxiedSocketAddress);
        TransportLogger transportLogger = new TransportLogger();
        transportLogger.f32580a = getLogId();
        CallTracingTransport callTracingTransport = new CallTracingTransport(this.f32551f.newClientTransport(socketAddress, f10, transportLogger), this.f32554i, aVar);
        transportLogger.f32580a = callTracingTransport.getLogId();
        this.f32553h.b(callTracingTransport);
        this.f32567v = callTracingTransport;
        this.f32565t.add(callTracingTransport);
        Runnable start = callTracingTransport.start(new j(callTracingTransport));
        if (start != null) {
            this.f32557l.b(start);
        }
        this.f32556k.b(ChannelLogger.ChannelLogLevel.INFO, "Started transport {0}", transportLogger.f32580a);
    }

    public void N(List<C1114h> list) {
        com.google.common.base.k.p(list, "newAddressGroups");
        F(list, "newAddressGroups contains null entry");
        com.google.common.base.k.e(!list.isEmpty(), "newAddressGroups is empty");
        this.f32557l.execute(new d(Collections.unmodifiableList(new ArrayList(list))));
    }

    @Override // io.grpc.internal.w0
    public InterfaceC1129k a() {
        P p10 = this.f32568w;
        if (p10 != null) {
            return p10;
        }
        this.f32557l.execute(new c());
        return null;
    }

    @Override // j9.z
    public j9.w getLogId() {
        return this.f32546a;
    }

    public void shutdown(Status status) {
        this.f32557l.execute(new e(status));
    }

    public void shutdownNow(Status status) {
        shutdown(status);
        this.f32557l.execute(new h(status));
    }

    public String toString() {
        return com.google.common.base.f.c(this).c("logId", this.f32546a.d()).d("addressGroups", this.f32559n).toString();
    }
}
