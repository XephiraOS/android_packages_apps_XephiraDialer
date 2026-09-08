package j9;

import io.grpc.Status;

/* compiled from: ForwardingServerCall.java */
/* loaded from: classes4.dex */
public abstract class q<ReqT, RespT> extends D<ReqT, RespT> {
    @Override // j9.D, io.grpc.A
    public /* bridge */ /* synthetic */ void a(Status status, io.grpc.u uVar) {
        super.a(status, uVar);
    }

    @Override // j9.D, io.grpc.A
    public /* bridge */ /* synthetic */ void b(int i10) {
        super.b(i10);
    }

    @Override // j9.D, io.grpc.A
    public /* bridge */ /* synthetic */ void c(io.grpc.u uVar) {
        super.c(uVar);
    }

    @Override // io.grpc.A
    public void d(RespT respt) {
        e().d(respt);
    }

    @Override // j9.D
    public abstract io.grpc.A<ReqT, RespT> e();

    @Override // j9.D
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
