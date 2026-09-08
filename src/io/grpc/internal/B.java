package io.grpc.internal;

import io.grpc.v;

/* compiled from: ForwardingNameResolver.java */
/* loaded from: classes4.dex */
public abstract class B extends io.grpc.v {

    /* renamed from: a, reason: collision with root package name */
    public final io.grpc.v f32461a;

    public B(io.grpc.v vVar) {
        com.google.common.base.k.p(vVar, "delegate can not be null");
        this.f32461a = vVar;
    }

    @Override // io.grpc.v
    public String a() {
        return this.f32461a.a();
    }

    @Override // io.grpc.v
    public void b() {
        this.f32461a.b();
    }

    @Override // io.grpc.v
    public void c() {
        this.f32461a.c();
    }

    @Override // io.grpc.v
    public void d(v.e eVar) {
        this.f32461a.d(eVar);
    }

    @Override // io.grpc.v
    @Deprecated
    public void e(v.f fVar) {
        this.f32461a.e(fVar);
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", this.f32461a).toString();
    }
}
