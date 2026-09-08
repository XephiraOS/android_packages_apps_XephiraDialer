package io.grpc.internal;

import io.grpc.C1107a;
import io.grpc.Status;
import io.grpc.internal.RetryingNameResolver;
import io.grpc.v;

/* loaded from: classes4.dex */
public final class RetryingNameResolver extends B {

    /* renamed from: e, reason: collision with root package name */
    public static final C1107a.c<a> f32872e = C1107a.c.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* renamed from: b, reason: collision with root package name */
    public final io.grpc.v f32873b;

    /* renamed from: c, reason: collision with root package name */
    public final e0 f32874c;

    /* renamed from: d, reason: collision with root package name */
    public final j9.N f32875d;

    /* loaded from: classes4.dex */
    public class DelayedNameResolverRefresh implements Runnable {
        public DelayedNameResolverRefresh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RetryingNameResolver.this.b();
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public a() {
        }

        public void a(Status status) {
            if (status.o()) {
                RetryingNameResolver.this.f32874c.reset();
            } else {
                RetryingNameResolver.this.f32874c.a(new DelayedNameResolverRefresh());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends v.e {

        /* renamed from: a, reason: collision with root package name */
        public v.e f32878a;

        public b(v.e eVar) {
            this.f32878a = eVar;
        }

        @Override // io.grpc.v.e, io.grpc.v.f
        public void a(Status status) {
            this.f32878a.a(status);
            RetryingNameResolver.this.f32875d.execute(new Runnable() { // from class: io.grpc.internal.f0
                @Override // java.lang.Runnable
                public final void run() {
                    RetryingNameResolver.b.this.e();
                }
            });
        }

        @Override // io.grpc.v.e
        public void c(v.g gVar) {
            C1107a b10 = gVar.b();
            C1107a.c<a> cVar = RetryingNameResolver.f32872e;
            if (b10.b(cVar) == null) {
                this.f32878a.c(gVar.e().c(gVar.b().d().d(cVar, new a()).a()).a());
                return;
            }
            throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
        }

        public final /* synthetic */ void e() {
            RetryingNameResolver.this.f32874c.a(new DelayedNameResolverRefresh());
        }
    }

    public RetryingNameResolver(io.grpc.v vVar, e0 e0Var, j9.N n10) {
        super(vVar);
        this.f32873b = vVar;
        this.f32874c = e0Var;
        this.f32875d = n10;
    }

    @Override // io.grpc.internal.B, io.grpc.v
    public void c() {
        super.c();
        this.f32874c.reset();
    }

    @Override // io.grpc.internal.B, io.grpc.v
    public void d(v.e eVar) {
        super.d(new b(eVar));
    }

    public io.grpc.v getRetriedNameResolver() {
        return this.f32873b;
    }
}
