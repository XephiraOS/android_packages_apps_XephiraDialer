package io.grpc;

/* compiled from: ForwardingClientCall.java */
/* loaded from: classes4.dex */
public abstract class j<ReqT, RespT> extends j9.C<ReqT, RespT> {
    @Override // j9.C, io.grpc.AbstractC1109c
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // j9.C, io.grpc.AbstractC1109c
    public /* bridge */ /* synthetic */ void c(int i10) {
        super.c(i10);
    }

    @Override // io.grpc.AbstractC1109c
    public void d(ReqT reqt) {
        f().d(reqt);
    }

    @Override // j9.C
    public abstract AbstractC1109c<ReqT, RespT> f();

    @Override // j9.C
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
