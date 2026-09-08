package io.grpc;

import io.grpc.A;

/* compiled from: ServerInterceptors.java */
/* loaded from: classes4.dex */
public final class D<ReqT, RespT> implements B<ReqT, RespT> {

    /* renamed from: a, reason: collision with root package name */
    public final C f32296a;

    /* renamed from: b, reason: collision with root package name */
    public final B<ReqT, RespT> f32297b;

    public D(C c10, B<ReqT, RespT> b10) {
        this.f32296a = (C) com.google.common.base.k.p(c10, "interceptor");
        this.f32297b = b10;
    }

    public static <ReqT, RespT> D<ReqT, RespT> b(C c10, B<ReqT, RespT> b10) {
        return new D<>(c10, b10);
    }

    @Override // io.grpc.B
    public A.a<ReqT> a(A<ReqT, RespT> a10, u uVar) {
        return this.f32296a.a(a10, uVar, this.f32297b);
    }
}
