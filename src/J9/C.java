package j9;

import io.grpc.AbstractC1109c;

/* compiled from: PartialForwardingClientCall.java */
/* loaded from: classes4.dex */
public abstract class C<ReqT, RespT> extends AbstractC1109c<ReqT, RespT> {
    @Override // io.grpc.AbstractC1109c
    public void b() {
        f().b();
    }

    @Override // io.grpc.AbstractC1109c
    public void c(int i10) {
        f().c(i10);
    }

    public abstract AbstractC1109c<?, ?> f();

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", f()).toString();
    }
}
