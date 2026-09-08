package io.grpc.stub;

import com.google.common.base.k;
import io.grpc.A;
import io.grpc.B;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.u;

/* compiled from: ServerCalls.java */
/* loaded from: classes4.dex */
public final class g {
    static final String MISSING_REQUEST = "Half-closed without a request";
    static final String TOO_MANY_REQUESTS = "Too many requests";

    /* compiled from: ServerCalls.java */
    /* loaded from: classes4.dex */
    public interface a<ReqT, RespT> extends d<ReqT, RespT> {
    }

    /* compiled from: ServerCalls.java */
    /* loaded from: classes4.dex */
    public static final class c<ReqT, RespT> extends f<RespT> {

        /* renamed from: a, reason: collision with root package name */
        public final A<ReqT, RespT> f33479a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f33480b;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f33481c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f33482d;

        /* renamed from: f, reason: collision with root package name */
        public boolean f33484f;

        /* renamed from: g, reason: collision with root package name */
        public Runnable f33485g;

        /* renamed from: h, reason: collision with root package name */
        public Runnable f33486h;

        /* renamed from: k, reason: collision with root package name */
        public Runnable f33489k;

        /* renamed from: e, reason: collision with root package name */
        public boolean f33483e = true;

        /* renamed from: i, reason: collision with root package name */
        public boolean f33487i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f33488j = false;

        public c(A<ReqT, RespT> a10, boolean z10) {
            this.f33479a = a10;
            this.f33480b = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            this.f33482d = true;
        }

        @Override // io.grpc.stub.h
        public void onCompleted() {
            this.f33479a.a(Status.f32368e, new u());
            this.f33488j = true;
        }

        @Override // io.grpc.stub.h
        public void onError(Throwable th) {
            u p10 = Status.p(th);
            if (p10 == null) {
                p10 = new u();
            }
            this.f33479a.a(Status.k(th), p10);
            this.f33487i = true;
        }

        @Override // io.grpc.stub.h
        public void onNext(RespT respt) {
            if (this.f33481c && this.f33480b) {
                throw Status.f32369f.r("call already cancelled. Use ServerCallStreamObserver.setOnCancelHandler() to disable this exception").c();
            }
            k.v(!this.f33487i, "Stream was terminated by error, no further calls are allowed");
            k.v(!this.f33488j, "Stream is already completed, no further calls are allowed");
            if (!this.f33484f) {
                this.f33479a.c(new u());
                this.f33484f = true;
            }
            this.f33479a.d(respt);
        }
    }

    /* compiled from: ServerCalls.java */
    /* loaded from: classes4.dex */
    public interface d<ReqT, RespT> {
        h<ReqT> invoke(h<RespT> hVar);
    }

    /* compiled from: ServerCalls.java */
    /* loaded from: classes4.dex */
    public static final class e<ReqT, RespT> implements B<ReqT, RespT> {

        /* renamed from: a, reason: collision with root package name */
        public final d<ReqT, RespT> f33490a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f33491b;

        /* compiled from: ServerCalls.java */
        /* loaded from: classes4.dex */
        public final class a extends A.a<ReqT> {

            /* renamed from: a, reason: collision with root package name */
            public final h<ReqT> f33492a;

            /* renamed from: b, reason: collision with root package name */
            public final c<ReqT, RespT> f33493b;

            /* renamed from: c, reason: collision with root package name */
            public final A<ReqT, RespT> f33494c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f33495d = false;

            public a(h<ReqT> hVar, c<ReqT, RespT> cVar, A<ReqT, RespT> a10) {
                this.f33492a = hVar;
                this.f33493b = cVar;
                this.f33494c = a10;
            }

            @Override // io.grpc.A.a
            public void a() {
                if (this.f33493b.f33486h != null) {
                    this.f33493b.f33486h.run();
                } else {
                    this.f33493b.f33481c = true;
                }
                if (!this.f33495d) {
                    this.f33492a.onError(Status.f32369f.r("client cancelled").c());
                }
            }

            @Override // io.grpc.A.a
            public void b() {
                if (this.f33493b.f33489k != null) {
                    this.f33493b.f33489k.run();
                }
            }

            @Override // io.grpc.A.a
            public void c() {
                this.f33495d = true;
                this.f33492a.onCompleted();
            }

            @Override // io.grpc.A.a
            public void d(ReqT reqt) {
                this.f33492a.onNext(reqt);
                if (this.f33493b.f33483e) {
                    this.f33494c.b(1);
                }
            }

            @Override // io.grpc.A.a
            public void e() {
                if (this.f33493b.f33485g != null) {
                    this.f33493b.f33485g.run();
                }
            }
        }

        public e(d<ReqT, RespT> dVar, boolean z10) {
            this.f33490a = dVar;
            this.f33491b = z10;
        }

        @Override // io.grpc.B
        public A.a<ReqT> a(A<ReqT, RespT> a10, u uVar) {
            c cVar = new c(a10, this.f33491b);
            h<ReqT> invoke = this.f33490a.invoke(cVar);
            cVar.g();
            if (cVar.f33483e) {
                a10.b(1);
            }
            return new a(invoke, cVar, a10);
        }
    }

    public static <ReqT, RespT> B<ReqT, RespT> a(a<ReqT, RespT> aVar) {
        return new e(aVar, true);
    }

    public static <ReqT> h<ReqT> b(MethodDescriptor<?, ?> methodDescriptor, h<?> hVar) {
        c(methodDescriptor, hVar);
        return new b();
    }

    public static void c(MethodDescriptor<?, ?> methodDescriptor, h<?> hVar) {
        k.p(methodDescriptor, "methodDescriptor");
        k.p(hVar, "responseObserver");
        hVar.onError(Status.f32381r.r(String.format("Method %s is unimplemented", methodDescriptor.c())).c());
    }

    /* compiled from: ServerCalls.java */
    /* loaded from: classes4.dex */
    public static class b<V> implements h<V> {
        @Override // io.grpc.stub.h
        public void onError(Throwable th) {
        }

        @Override // io.grpc.stub.h
        public void onNext(V v10) {
        }

        @Override // io.grpc.stub.h
        public void onCompleted() {
        }
    }
}
