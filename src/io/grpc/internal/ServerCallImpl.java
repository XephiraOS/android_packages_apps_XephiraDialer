package io.grpc.internal;

import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.A;
import io.grpc.Context;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.u0;
import io.grpc.u;
import j9.C1200j;
import j9.InterfaceC1197g;
import j9.InterfaceC1199i;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class ServerCallImpl<ReqT, RespT> extends io.grpc.A<ReqT, RespT> {
    static final String MISSING_RESPONSE = "Completed without a response";
    static final String TOO_MANY_RESPONSES = "Too many responses";

    /* renamed from: n, reason: collision with root package name */
    public static final Logger f32885n = Logger.getLogger(ServerCallImpl.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final l0 f32886a;

    /* renamed from: b, reason: collision with root package name */
    public final MethodDescriptor<ReqT, RespT> f32887b;

    /* renamed from: c, reason: collision with root package name */
    public final l9.d f32888c;

    /* renamed from: d, reason: collision with root package name */
    public final Context.a f32889d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f32890e;

    /* renamed from: f, reason: collision with root package name */
    public final j9.o f32891f;

    /* renamed from: g, reason: collision with root package name */
    public final C1200j f32892g;

    /* renamed from: h, reason: collision with root package name */
    public C1125g f32893h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f32894i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f32895j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f32896k;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC1199i f32897l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f32898m;

    /* loaded from: classes4.dex */
    public static final class ServerStreamListenerImpl<ReqT> implements m0 {

        /* renamed from: a, reason: collision with root package name */
        public final ServerCallImpl<ReqT, ?> f32899a;

        /* renamed from: b, reason: collision with root package name */
        public final A.a<ReqT> f32900b;

        /* renamed from: c, reason: collision with root package name */
        public final Context.a f32901c;

        /* loaded from: classes4.dex */
        public class a implements Context.b {
            public a() {
            }

            @Override // io.grpc.Context.b
            public void a(Context context) {
                if (context.f() != null) {
                    ServerStreamListenerImpl.this.f32899a.f32894i = true;
                }
            }
        }

        public ServerStreamListenerImpl(ServerCallImpl<ReqT, ?> serverCallImpl, A.a<ReqT> aVar, Context.a aVar2) {
            this.f32899a = (ServerCallImpl) com.google.common.base.k.p(serverCallImpl, "call");
            this.f32900b = (A.a) com.google.common.base.k.p(aVar, "listener must not be null");
            Context.a aVar3 = (Context.a) com.google.common.base.k.p(aVar2, "context");
            this.f32901c = aVar3;
            aVar3.a(new a(), MoreExecutors.a());
        }

        @Override // io.grpc.internal.m0
        public void a(Status status) {
            l9.e g10 = l9.c.g("ServerStreamListener.closed");
            try {
                l9.c.a(this.f32899a.f32888c);
                h(status);
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
                l9.c.a(this.f32899a.f32888c);
                if (this.f32899a.f32894i) {
                    if (g10 != null) {
                        g10.close();
                    }
                } else {
                    this.f32900b.c();
                    if (g10 != null) {
                        g10.close();
                    }
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
                l9.c.a(this.f32899a.f32888c);
                i(aVar);
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
                l9.c.a(this.f32899a.f32888c);
                if (this.f32899a.f32894i) {
                    if (g10 != null) {
                        g10.close();
                    }
                } else {
                    this.f32900b.e();
                    if (g10 != null) {
                        g10.close();
                    }
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

        public final void h(Status status) {
            StatusRuntimeException statusRuntimeException = null;
            try {
                if (!status.o()) {
                    this.f32899a.f32894i = true;
                    this.f32900b.a();
                    statusRuntimeException = io.grpc.p.a(Status.f32369f.r("RPC cancelled"), null, false);
                } else {
                    this.f32900b.b();
                }
                this.f32901c.Z(statusRuntimeException);
            } catch (Throwable th) {
                this.f32901c.Z(null);
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void i(u0.a aVar) {
            if (this.f32899a.f32894i) {
                GrpcUtil.d(aVar);
                return;
            }
            while (true) {
                try {
                    InputStream next = aVar.next();
                    if (next != null) {
                        try {
                            this.f32900b.d(this.f32899a.f32887b.h(next));
                            next.close();
                        } finally {
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    GrpcUtil.d(aVar);
                    com.google.common.base.q.f(th);
                    throw new RuntimeException(th);
                }
            }
        }
    }

    public ServerCallImpl(l0 l0Var, MethodDescriptor<ReqT, RespT> methodDescriptor, io.grpc.u uVar, Context.a aVar, j9.o oVar, C1200j c1200j, C1125g c1125g, l9.d dVar) {
        this.f32886a = l0Var;
        this.f32887b = methodDescriptor;
        this.f32889d = aVar;
        this.f32890e = (byte[]) uVar.h(GrpcUtil.f32524f);
        this.f32891f = oVar;
        this.f32892g = c1200j;
        this.f32893h = c1125g;
        c1125g.c();
        this.f32888c = dVar;
    }

    @Override // io.grpc.A
    public void a(Status status, io.grpc.u uVar) {
        l9.e g10 = l9.c.g("ServerCall.close");
        try {
            l9.c.a(this.f32888c);
            i(status, uVar);
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

    @Override // io.grpc.A
    public void b(int i10) {
        l9.e g10 = l9.c.g("ServerCall.request");
        try {
            l9.c.a(this.f32888c);
            this.f32886a.request(i10);
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

    @Override // io.grpc.A
    public void c(io.grpc.u uVar) {
        l9.e g10 = l9.c.g("ServerCall.sendHeaders");
        try {
            l9.c.a(this.f32888c);
            m(uVar);
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

    @Override // io.grpc.A
    public void d(RespT respt) {
        l9.e g10 = l9.c.g("ServerCall.sendMessage");
        try {
            l9.c.a(this.f32888c);
            n(respt);
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

    public final void i(Status status, io.grpc.u uVar) {
        com.google.common.base.k.v(!this.f32896k, "call already closed");
        try {
            this.f32896k = true;
            if (status.o() && this.f32887b.e().b() && !this.f32898m) {
                k(Status.f32382s.r(MISSING_RESPONSE).c());
            } else {
                this.f32886a.close(status, uVar);
            }
        } finally {
            this.f32893h.b(status.o());
        }
    }

    public MethodDescriptor<ReqT, RespT> j() {
        return this.f32887b;
    }

    public final void k(Throwable th) {
        Status r10;
        f32885n.log(Level.WARNING, "Cancelling the stream because of internal error", th);
        if (th instanceof StatusRuntimeException) {
            r10 = ((StatusRuntimeException) th).a();
        } else {
            r10 = Status.f32382s.q(th).r("Internal error so cancelling stream.");
        }
        this.f32886a.cancel(r10);
        this.f32893h.b(false);
    }

    public m0 l(A.a<ReqT> aVar) {
        return new ServerStreamListenerImpl(this, aVar, this.f32889d);
    }

    public final void m(io.grpc.u uVar) {
        com.google.common.base.k.v(!this.f32895j, "sendHeaders has already been called");
        com.google.common.base.k.v(!this.f32896k, "call is closed");
        uVar.f(GrpcUtil.f32527i);
        u.g<String> gVar = GrpcUtil.f32523e;
        uVar.f(gVar);
        if (this.f32897l == null) {
            this.f32897l = InterfaceC1197g.b.f34015a;
        } else {
            byte[] bArr = this.f32890e;
            if (bArr != null) {
                if (!GrpcUtil.k(GrpcUtil.f32531m.g(new String(bArr, GrpcUtil.f32521c)), this.f32897l.a())) {
                    this.f32897l = InterfaceC1197g.b.f34015a;
                }
            } else {
                this.f32897l = InterfaceC1197g.b.f34015a;
            }
        }
        uVar.o(gVar, this.f32897l.a());
        this.f32886a.setCompressor(this.f32897l);
        u.g<byte[]> gVar2 = GrpcUtil.f32524f;
        uVar.f(gVar2);
        byte[] a10 = j9.t.a(this.f32891f);
        if (a10.length != 0) {
            uVar.o(gVar2, a10);
        }
        this.f32895j = true;
        this.f32886a.writeHeaders(uVar, !j().e().b());
    }

    public final void n(RespT respt) {
        com.google.common.base.k.v(this.f32895j, "sendHeaders has not been called");
        com.google.common.base.k.v(!this.f32896k, "call is closed");
        if (this.f32887b.e().b() && this.f32898m) {
            k(Status.f32382s.r(TOO_MANY_RESPONSES).c());
            return;
        }
        this.f32898m = true;
        try {
            this.f32886a.writeMessage(this.f32887b.k(respt));
            if (!j().e().b()) {
                this.f32886a.flush();
            }
        } catch (Error e10) {
            a(Status.f32369f.r("Server sendMessage() failed with Error"), new io.grpc.u());
            throw e10;
        } catch (RuntimeException e11) {
            k(e11);
        }
    }
}
