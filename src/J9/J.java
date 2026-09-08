package j9;

import io.grpc.Context;

/* compiled from: ServerStreamTracer.java */
/* loaded from: classes4.dex */
public abstract class J extends M {

    /* compiled from: ServerStreamTracer.java */
    /* loaded from: classes4.dex */
    public static abstract class a {
        public abstract J a(String str, io.grpc.u uVar);
    }

    /* compiled from: ServerStreamTracer.java */
    @Deprecated
    /* loaded from: classes4.dex */
    public static final class b<ReqT, RespT> extends q<ReqT, RespT> {

        /* renamed from: a, reason: collision with root package name */
        public final c<ReqT, RespT> f33993a;

        public b(c<ReqT, RespT> cVar) {
            this.f33993a = cVar;
        }

        public static <ReqT, RespT> b<ReqT, RespT> g(c<ReqT, RespT> cVar) {
            return new b<>(cVar);
        }

        @Override // j9.q, j9.D
        public io.grpc.A<ReqT, RespT> e() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: ServerStreamTracer.java */
    /* loaded from: classes4.dex */
    public static abstract class c<ReqT, RespT> {
    }

    public void i(c<?, ?> cVar) {
        h(b.g(cVar));
    }

    public Context g(Context context) {
        return context;
    }

    @Deprecated
    public void h(io.grpc.A<?, ?> a10) {
    }
}
