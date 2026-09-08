package j9;

import io.grpc.Status;

/* compiled from: PartialForwardingServerCall.java */
/* loaded from: classes4.dex */
public abstract class D<ReqT, RespT> extends io.grpc.A<ReqT, RespT> {
    @Override // io.grpc.A
    public void a(Status status, io.grpc.u uVar) {
        e().a(status, uVar);
    }

    @Override // io.grpc.A
    public void b(int i10) {
        e().b(i10);
    }

    @Override // io.grpc.A
    public void c(io.grpc.u uVar) {
        e().c(uVar);
    }

    public abstract io.grpc.A<?, ?> e();

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", e()).toString();
    }
}
