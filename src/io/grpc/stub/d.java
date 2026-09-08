package io.grpc.stub;

import com.google.common.base.k;
import com.google.common.base.n;
import io.grpc.AbstractC1109c;
import io.grpc.C1108b;
import io.grpc.Status;
import io.grpc.u;
import java.util.logging.Logger;

/* compiled from: ClientCalls.java */
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f33466a = Logger.getLogger(d.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final C1108b.c<Object> f33467b;
    static boolean rejectRunnableOnExecutor;

    /* compiled from: ClientCalls.java */
    /* loaded from: classes4.dex */
    public static final class b<ReqT> extends io.grpc.stub.c<ReqT> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f33468a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC1109c<ReqT, ?> f33469b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f33470c;

        /* renamed from: d, reason: collision with root package name */
        public Runnable f33471d;

        /* renamed from: e, reason: collision with root package name */
        public int f33472e = 1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f33473f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f33474g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f33475h = false;

        public b(AbstractC1109c<ReqT, ?> abstractC1109c, boolean z10) {
            this.f33469b = abstractC1109c;
            this.f33470c = z10;
        }

        public final void g() {
            this.f33468a = true;
        }

        public void h(int i10) {
            if (!this.f33470c && i10 == 1) {
                this.f33469b.c(2);
            } else {
                this.f33469b.c(i10);
            }
        }

        @Override // io.grpc.stub.h
        public void onCompleted() {
            this.f33469b.b();
            this.f33475h = true;
        }

        @Override // io.grpc.stub.h
        public void onError(Throwable th) {
            this.f33469b.a("Cancelled by client with StreamObserver.onError()", th);
            this.f33474g = true;
        }

        @Override // io.grpc.stub.h
        public void onNext(ReqT reqt) {
            k.v(!this.f33474g, "Stream was terminated by error, no further calls are allowed");
            k.v(!this.f33475h, "Stream is already completed, no further calls are allowed");
            this.f33469b.d(reqt);
        }
    }

    /* compiled from: ClientCalls.java */
    /* loaded from: classes4.dex */
    public static abstract class c<T> extends AbstractC1109c.a<T> {
        public c() {
        }

        public abstract void e();
    }

    static {
        boolean z10;
        if (!n.b(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"))) {
            z10 = true;
        } else {
            z10 = false;
        }
        rejectRunnableOnExecutor = z10;
        f33467b = C1108b.c.b("internal-stub-type");
    }

    public static <ReqT, RespT> h<ReqT> a(AbstractC1109c<ReqT, RespT> abstractC1109c, h<RespT> hVar) {
        k.p(hVar, "responseObserver");
        return b(abstractC1109c, hVar, true);
    }

    public static <ReqT, RespT> h<ReqT> b(AbstractC1109c<ReqT, RespT> abstractC1109c, h<RespT> hVar, boolean z10) {
        b bVar = new b(abstractC1109c, z10);
        c(abstractC1109c, new C0315d(hVar, bVar));
        return bVar;
    }

    public static <ReqT, RespT> void c(AbstractC1109c<ReqT, RespT> abstractC1109c, c<RespT> cVar) {
        abstractC1109c.e(cVar, new u());
        cVar.e();
    }

    /* compiled from: ClientCalls.java */
    /* renamed from: io.grpc.stub.d$d, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0315d<ReqT, RespT> extends c<RespT> {

        /* renamed from: a, reason: collision with root package name */
        public final h<RespT> f33476a;

        /* renamed from: b, reason: collision with root package name */
        public final b<ReqT> f33477b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f33478c;

        public C0315d(h<RespT> hVar, b<ReqT> bVar) {
            super();
            this.f33476a = hVar;
            this.f33477b = bVar;
            if (hVar instanceof e) {
                ((e) hVar).a(bVar);
            }
            bVar.g();
        }

        @Override // io.grpc.AbstractC1109c.a
        public void a(Status status, u uVar) {
            if (status.o()) {
                this.f33476a.onCompleted();
            } else {
                this.f33476a.onError(status.d(uVar));
            }
        }

        @Override // io.grpc.AbstractC1109c.a
        public void c(RespT respt) {
            if (this.f33478c && !this.f33477b.f33470c) {
                throw Status.f32382s.r("More than one responses received for unary or client-streaming call").c();
            }
            this.f33478c = true;
            this.f33476a.onNext(respt);
            if (this.f33477b.f33470c && this.f33477b.f33473f) {
                this.f33477b.h(1);
            }
        }

        @Override // io.grpc.AbstractC1109c.a
        public void d() {
            if (this.f33477b.f33471d != null) {
                this.f33477b.f33471d.run();
            }
        }

        @Override // io.grpc.stub.d.c
        public void e() {
            if (this.f33477b.f33472e > 0) {
                b<ReqT> bVar = this.f33477b;
                bVar.h(bVar.f33472e);
            }
        }

        @Override // io.grpc.AbstractC1109c.a
        public void b(u uVar) {
        }
    }
}
