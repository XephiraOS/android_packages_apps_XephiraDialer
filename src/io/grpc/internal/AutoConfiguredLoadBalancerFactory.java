package io.grpc.internal;

import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.Status;
import io.grpc.internal.p0;
import io.grpc.q;
import io.grpc.v;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class AutoConfiguredLoadBalancerFactory {

    /* renamed from: a, reason: collision with root package name */
    public final io.grpc.s f32454a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32455b;

    /* loaded from: classes4.dex */
    public final class AutoConfiguredLoadBalancer {

        /* renamed from: a, reason: collision with root package name */
        public final q.e f32456a;

        /* renamed from: b, reason: collision with root package name */
        public io.grpc.q f32457b;

        /* renamed from: c, reason: collision with root package name */
        public io.grpc.r f32458c;

        public AutoConfiguredLoadBalancer(q.e eVar) {
            this.f32456a = eVar;
            io.grpc.r c10 = AutoConfiguredLoadBalancerFactory.this.f32454a.c(AutoConfiguredLoadBalancerFactory.this.f32455b);
            this.f32458c = c10;
            if (c10 != null) {
                this.f32457b = c10.a(eVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + AutoConfiguredLoadBalancerFactory.this.f32455b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public void a(Status status) {
            getDelegate().c(status);
        }

        public void b() {
            this.f32457b.f();
            this.f32457b = null;
        }

        public Status c(q.h hVar) {
            p0.b bVar = (p0.b) hVar.c();
            if (bVar == null) {
                try {
                    AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory = AutoConfiguredLoadBalancerFactory.this;
                    bVar = new p0.b(autoConfiguredLoadBalancerFactory.d(autoConfiguredLoadBalancerFactory.f32455b, "using default policy"), null);
                } catch (PolicyException e10) {
                    this.f32456a.f(ConnectivityState.TRANSIENT_FAILURE, new c(Status.f32382s.r(e10.getMessage())));
                    this.f32457b.f();
                    this.f32458c = null;
                    this.f32457b = new d();
                    return Status.f32368e;
                }
            }
            if (this.f32458c == null || !bVar.f33310a.b().equals(this.f32458c.b())) {
                this.f32456a.f(ConnectivityState.CONNECTING, new b());
                this.f32457b.f();
                io.grpc.r rVar = bVar.f33310a;
                this.f32458c = rVar;
                io.grpc.q qVar = this.f32457b;
                this.f32457b = rVar.a(this.f32456a);
                this.f32456a.b().b(ChannelLogger.ChannelLogLevel.INFO, "Load balancer changed from {0} to {1}", qVar.getClass().getSimpleName(), this.f32457b.getClass().getSimpleName());
            }
            Object obj = bVar.f33311b;
            if (obj != null) {
                this.f32456a.b().b(ChannelLogger.ChannelLogLevel.DEBUG, "Load-balancing config: {0}", bVar.f33311b);
            }
            return getDelegate().a(q.h.d().b(hVar.a()).c(hVar.b()).d(obj).a());
        }

        public io.grpc.q getDelegate() {
            return this.f32457b;
        }

        public io.grpc.r getDelegateProvider() {
            return this.f32458c;
        }

        public void setDelegate(io.grpc.q qVar) {
            this.f32457b = qVar;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PolicyException extends Exception {
        private static final long serialVersionUID = 1;

        public PolicyException(String str) {
            super(str);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends q.j {
        public b() {
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            return q.f.g();
        }

        public String toString() {
            return com.google.common.base.f.b(b.class).toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends q.j {

        /* renamed from: a, reason: collision with root package name */
        public final Status f32460a;

        public c(Status status) {
            this.f32460a = status;
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            return q.f.f(this.f32460a);
        }
    }

    public AutoConfiguredLoadBalancerFactory(String str) {
        this(io.grpc.s.b(), str);
    }

    public final io.grpc.r d(String str, String str2) {
        io.grpc.r c10 = this.f32454a.c(str);
        if (c10 != null) {
            return c10;
        }
        throw new PolicyException("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public AutoConfiguredLoadBalancer e(q.e eVar) {
        return new AutoConfiguredLoadBalancer(eVar);
    }

    public v.c f(Map<String, ?> map) {
        List<p0.a> z10;
        if (map != null) {
            try {
                z10 = p0.z(p0.getLoadBalancingConfigsFromServiceConfig(map));
            } catch (RuntimeException e10) {
                return v.c.b(Status.f32370g.r("can't parse load balancer configuration").q(e10));
            }
        } else {
            z10 = null;
        }
        if (z10 == null || z10.isEmpty()) {
            return null;
        }
        return p0.x(z10, this.f32454a);
    }

    public AutoConfiguredLoadBalancerFactory(io.grpc.s sVar, String str) {
        this.f32454a = (io.grpc.s) com.google.common.base.k.p(sVar, "registry");
        this.f32455b = (String) com.google.common.base.k.p(str, "defaultPolicy");
    }

    /* loaded from: classes4.dex */
    public static final class d extends io.grpc.q {
        public d() {
        }

        @Override // io.grpc.q
        public Status a(q.h hVar) {
            return Status.f32368e;
        }

        @Override // io.grpc.q
        public void c(Status status) {
        }

        @Override // io.grpc.q
        @Deprecated
        public void d(q.h hVar) {
        }

        @Override // io.grpc.q
        public void f() {
        }
    }
}
