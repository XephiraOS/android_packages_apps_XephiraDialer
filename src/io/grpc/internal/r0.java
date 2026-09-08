package io.grpc.internal;

import io.grpc.internal.q0;

/* compiled from: SharedResourcePool.java */
/* loaded from: classes4.dex */
public final class r0<T> implements U<T> {

    /* renamed from: a, reason: collision with root package name */
    public final q0.d<T> f33392a;

    public r0(q0.d<T> dVar) {
        this.f33392a = dVar;
    }

    public static <T> r0<T> c(q0.d<T> dVar) {
        return new r0<>(dVar);
    }

    @Override // io.grpc.internal.U
    public T a() {
        return (T) q0.d(this.f33392a);
    }

    @Override // io.grpc.internal.U
    public T b(Object obj) {
        q0.f(this.f33392a, obj);
        return null;
    }
}
