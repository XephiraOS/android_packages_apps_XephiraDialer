package io.grpc.util;

import io.grpc.AbstractC1112f;
import io.grpc.C1107a;
import io.grpc.u;

/* compiled from: ForwardingClientStreamTracer.java */
/* loaded from: classes4.dex */
public abstract class a extends AbstractC1112f {
    @Override // j9.M
    public void a(int i10) {
        l().a(i10);
    }

    @Override // j9.M
    public void b(int i10, long j10, long j11) {
        l().b(i10, j10, j11);
    }

    @Override // j9.M
    public void c(long j10) {
        l().c(j10);
    }

    @Override // j9.M
    public void d(int i10) {
        l().d(i10);
    }

    @Override // j9.M
    public void e(int i10, long j10, long j11) {
        l().e(i10, j10, j11);
    }

    @Override // io.grpc.AbstractC1112f
    public void g() {
        l().g();
    }

    @Override // io.grpc.AbstractC1112f
    public void h() {
        l().h();
    }

    @Override // io.grpc.AbstractC1112f
    public void i(u uVar) {
        l().i(uVar);
    }

    @Override // io.grpc.AbstractC1112f
    public void j() {
        l().j();
    }

    @Override // io.grpc.AbstractC1112f
    public void k(C1107a c1107a, u uVar) {
        l().k(c1107a, uVar);
    }

    public abstract AbstractC1112f l();

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", l()).toString();
    }
}
