package io.grpc.internal;

/* compiled from: FixedObjectPool.java */
/* renamed from: io.grpc.internal.w, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1140w<T> implements U<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f33409a;

    public C1140w(T t10) {
        this.f33409a = (T) com.google.common.base.k.p(t10, "object");
    }

    @Override // io.grpc.internal.U
    public T a() {
        return this.f33409a;
    }

    @Override // io.grpc.internal.U
    public T b(Object obj) {
        return null;
    }
}
