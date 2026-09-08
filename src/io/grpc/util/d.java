package io.grpc.util;

import io.grpc.C1107a;
import io.grpc.C1114h;
import io.grpc.ChannelLogger;
import io.grpc.q;
import java.util.List;

/* compiled from: ForwardingSubchannel.java */
/* loaded from: classes4.dex */
public abstract class d extends q.i {
    @Override // io.grpc.q.i
    public List<C1114h> b() {
        return j().b();
    }

    @Override // io.grpc.q.i
    public C1107a c() {
        return j().c();
    }

    @Override // io.grpc.q.i
    public ChannelLogger d() {
        return j().d();
    }

    @Override // io.grpc.q.i
    public Object e() {
        return j().e();
    }

    @Override // io.grpc.q.i
    public void f() {
        j().f();
    }

    @Override // io.grpc.q.i
    public void g() {
        j().g();
    }

    @Override // io.grpc.q.i
    public void h(q.k kVar) {
        j().h(kVar);
    }

    @Override // io.grpc.q.i
    public void i(List<C1114h> list) {
        j().i(list);
    }

    public abstract q.i j();

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", j()).toString();
    }
}
