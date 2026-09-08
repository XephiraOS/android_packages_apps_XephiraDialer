package io.grpc.util;

import com.google.common.base.k;
import io.grpc.ConnectivityState;
import io.grpc.Status;
import io.grpc.q;

/* compiled from: GracefulSwitchLoadBalancer.java */
/* loaded from: classes4.dex */
public final class e extends io.grpc.util.b {
    static final q.j BUFFER_PICKER = new c();

    /* renamed from: g, reason: collision with root package name */
    public final q f33523g;

    /* renamed from: h, reason: collision with root package name */
    public final q.e f33524h;

    /* renamed from: i, reason: collision with root package name */
    public q.c f33525i;

    /* renamed from: j, reason: collision with root package name */
    public q f33526j;

    /* renamed from: k, reason: collision with root package name */
    public q.c f33527k;

    /* renamed from: l, reason: collision with root package name */
    public q f33528l;

    /* renamed from: m, reason: collision with root package name */
    public ConnectivityState f33529m;

    /* renamed from: n, reason: collision with root package name */
    public q.j f33530n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f33531o;

    /* compiled from: GracefulSwitchLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class b extends io.grpc.util.c {

        /* renamed from: a, reason: collision with root package name */
        public q f33533a;

        public b() {
        }

        @Override // io.grpc.util.c, io.grpc.q.e
        public void f(ConnectivityState connectivityState, q.j jVar) {
            boolean z10;
            if (this.f33533a == e.this.f33528l) {
                k.v(e.this.f33531o, "there's pending lb while current lb has been out of READY");
                e.this.f33529m = connectivityState;
                e.this.f33530n = jVar;
                if (connectivityState == ConnectivityState.READY) {
                    e.this.q();
                    return;
                }
                return;
            }
            if (this.f33533a == e.this.f33526j) {
                e eVar = e.this;
                if (connectivityState == ConnectivityState.READY) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                eVar.f33531o = z10;
                if (!e.this.f33531o && e.this.f33528l != e.this.f33523g) {
                    e.this.q();
                } else {
                    e.this.f33524h.f(connectivityState, jVar);
                }
            }
        }

        @Override // io.grpc.util.c
        public q.e g() {
            return e.this.f33524h;
        }
    }

    /* compiled from: GracefulSwitchLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class c extends q.j {
        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            return q.f.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public e(q.e eVar) {
        a aVar = new a();
        this.f33523g = aVar;
        this.f33526j = aVar;
        this.f33528l = aVar;
        this.f33524h = (q.e) k.p(eVar, "helper");
    }

    @Override // io.grpc.q
    public void f() {
        this.f33528l.f();
        this.f33526j.f();
    }

    @Override // io.grpc.util.b
    public q g() {
        q qVar = this.f33528l;
        if (qVar == this.f33523g) {
            return this.f33526j;
        }
        return qVar;
    }

    public final void q() {
        this.f33524h.f(this.f33529m, this.f33530n);
        this.f33526j.f();
        this.f33526j = this.f33528l;
        this.f33525i = this.f33527k;
        this.f33528l = this.f33523g;
        this.f33527k = null;
    }

    public void r(q.c cVar) {
        k.p(cVar, "newBalancerFactory");
        if (cVar.equals(this.f33527k)) {
            return;
        }
        this.f33528l.f();
        this.f33528l = this.f33523g;
        this.f33527k = null;
        this.f33529m = ConnectivityState.CONNECTING;
        this.f33530n = BUFFER_PICKER;
        if (cVar.equals(this.f33525i)) {
            return;
        }
        b bVar = new b();
        q a10 = cVar.a(bVar);
        bVar.f33533a = a10;
        this.f33528l = a10;
        this.f33527k = cVar;
        if (!this.f33531o) {
            q();
        }
    }

    /* compiled from: GracefulSwitchLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class a extends q {
        public a() {
        }

        @Override // io.grpc.q
        public void c(Status status) {
            e.this.f33524h.f(ConnectivityState.TRANSIENT_FAILURE, new q.d(q.f.f(status)));
        }

        @Override // io.grpc.q
        public void d(q.h hVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // io.grpc.q
        public void f() {
        }
    }
}
