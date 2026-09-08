package io.grpc.internal;

import com.heytap.accessory.constant.AFConstants;
import io.grpc.AbstractC1112f;
import io.grpc.C1108b;
import io.grpc.ChannelLogger;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.InterfaceC1130l;
import io.grpc.internal.Q;
import j9.AbstractC1193c;
import j9.C1198h;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CallCredentialsApplyingTransportFactory.java */
/* renamed from: io.grpc.internal.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1124f implements InterfaceC1130l {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1130l f33152a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1193c f33153b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f33154c;

    /* compiled from: CallCredentialsApplyingTransportFactory.java */
    /* renamed from: io.grpc.internal.f$a */
    /* loaded from: classes4.dex */
    public class a extends AbstractC1143z {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1131m f33155a;

        /* renamed from: b, reason: collision with root package name */
        public final String f33156b;

        /* renamed from: d, reason: collision with root package name */
        public volatile Status f33158d;

        /* renamed from: e, reason: collision with root package name */
        public Status f33159e;

        /* renamed from: f, reason: collision with root package name */
        public Status f33160f;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicInteger f33157c = new AtomicInteger(-2147483647);

        /* renamed from: g, reason: collision with root package name */
        public final Q.a f33161g = new C0311a();

        /* compiled from: CallCredentialsApplyingTransportFactory.java */
        /* renamed from: io.grpc.internal.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0311a implements Q.a {
            public C0311a() {
            }

            @Override // io.grpc.internal.Q.a
            public void a() {
                if (a.this.f33157c.decrementAndGet() == 0) {
                    a.this.d();
                }
            }
        }

        /* compiled from: CallCredentialsApplyingTransportFactory.java */
        /* renamed from: io.grpc.internal.f$a$b */
        /* loaded from: classes4.dex */
        public class b extends AbstractC1193c.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MethodDescriptor f33164a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C1108b f33165b;

            public b(MethodDescriptor methodDescriptor, C1108b c1108b) {
                this.f33164a = methodDescriptor;
                this.f33165b = c1108b;
            }
        }

        public a(InterfaceC1131m interfaceC1131m, String str) {
            this.f33155a = (InterfaceC1131m) com.google.common.base.k.p(interfaceC1131m, "delegate");
            this.f33156b = (String) com.google.common.base.k.p(str, "authority");
        }

        @Override // io.grpc.internal.AbstractC1143z
        public InterfaceC1131m a() {
            return this.f33155a;
        }

        public final void d() {
            synchronized (this) {
                try {
                    if (this.f33157c.get() != 0) {
                        return;
                    }
                    Status status = this.f33159e;
                    Status status2 = this.f33160f;
                    this.f33159e = null;
                    this.f33160f = null;
                    if (status != null) {
                        super.shutdown(status);
                    }
                    if (status2 != null) {
                        super.shutdownNow(status2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [j9.c] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        @Override // io.grpc.internal.AbstractC1143z, io.grpc.internal.InterfaceC1129k
        public InterfaceC1128j newStream(MethodDescriptor<?, ?> methodDescriptor, io.grpc.u uVar, C1108b c1108b, AbstractC1112f[] abstractC1112fArr) {
            j9.x c1198h;
            Executor executor;
            AbstractC1193c c10 = c1108b.c();
            if (c10 == null) {
                c1198h = C1124f.this.f33153b;
            } else {
                c1198h = c10;
                if (C1124f.this.f33153b != null) {
                    c1198h = new C1198h(C1124f.this.f33153b, c10);
                }
            }
            if (c1198h != 0) {
                Q q10 = new Q(this.f33155a, methodDescriptor, uVar, c1108b, this.f33161g, abstractC1112fArr);
                if (this.f33157c.incrementAndGet() > 0) {
                    this.f33161g.a();
                    return new C1138u(this.f33158d, abstractC1112fArr);
                }
                b bVar = new b(methodDescriptor, c1108b);
                try {
                    if (!(c1198h instanceof j9.x) || !c1198h.a() || c1108b.e() == null) {
                        executor = C1124f.this.f33154c;
                    } else {
                        executor = c1108b.e();
                    }
                    c1198h.a(bVar, executor, q10);
                } catch (Throwable th) {
                    q10.a(Status.f32376m.r("Credentials should use fail() instead of throwing exceptions").q(th));
                }
                return q10.c();
            }
            if (this.f33157c.get() >= 0) {
                return new C1138u(this.f33158d, abstractC1112fArr);
            }
            return this.f33155a.newStream(methodDescriptor, uVar, c1108b, abstractC1112fArr);
        }

        @Override // io.grpc.internal.AbstractC1143z, io.grpc.internal.P
        public void shutdown(Status status) {
            com.google.common.base.k.p(status, AFConstants.EXTRA_STATUS);
            synchronized (this) {
                try {
                    if (this.f33157c.get() < 0) {
                        this.f33158d = status;
                        this.f33157c.addAndGet(Integer.MAX_VALUE);
                        if (this.f33157c.get() != 0) {
                            this.f33159e = status;
                        } else {
                            super.shutdown(status);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.grpc.internal.AbstractC1143z, io.grpc.internal.P
        public void shutdownNow(Status status) {
            com.google.common.base.k.p(status, AFConstants.EXTRA_STATUS);
            synchronized (this) {
                try {
                    if (this.f33157c.get() < 0) {
                        this.f33158d = status;
                        this.f33157c.addAndGet(Integer.MAX_VALUE);
                    } else if (this.f33160f != null) {
                        return;
                    }
                    if (this.f33157c.get() != 0) {
                        this.f33160f = status;
                    } else {
                        super.shutdownNow(status);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public C1124f(InterfaceC1130l interfaceC1130l, AbstractC1193c abstractC1193c, Executor executor) {
        this.f33152a = (InterfaceC1130l) com.google.common.base.k.p(interfaceC1130l, "delegate");
        this.f33153b = abstractC1193c;
        this.f33154c = (Executor) com.google.common.base.k.p(executor, "appExecutor");
    }

    @Override // io.grpc.internal.InterfaceC1130l, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f33152a.close();
    }

    @Override // io.grpc.internal.InterfaceC1130l
    public ScheduledExecutorService getScheduledExecutorService() {
        return this.f33152a.getScheduledExecutorService();
    }

    @Override // io.grpc.internal.InterfaceC1130l
    public Collection<Class<? extends SocketAddress>> getSupportedSocketAddressTypes() {
        return this.f33152a.getSupportedSocketAddressTypes();
    }

    @Override // io.grpc.internal.InterfaceC1130l
    public InterfaceC1131m newClientTransport(SocketAddress socketAddress, InterfaceC1130l.a aVar, ChannelLogger channelLogger) {
        return new a(this.f33152a.newClientTransport(socketAddress, aVar, channelLogger), aVar.a());
    }
}
