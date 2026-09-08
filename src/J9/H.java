package j9;

import io.grpc.MethodDescriptor;

/* compiled from: ServerMethodDefinition.java */
/* loaded from: classes4.dex */
public final class H<ReqT, RespT> {

    /* renamed from: a, reason: collision with root package name */
    public final MethodDescriptor<ReqT, RespT> f33986a;

    /* renamed from: b, reason: collision with root package name */
    public final io.grpc.B<ReqT, RespT> f33987b;

    public H(MethodDescriptor<ReqT, RespT> methodDescriptor, io.grpc.B<ReqT, RespT> b10) {
        this.f33986a = methodDescriptor;
        this.f33987b = b10;
    }

    public static <ReqT, RespT> H<ReqT, RespT> a(MethodDescriptor<ReqT, RespT> methodDescriptor, io.grpc.B<ReqT, RespT> b10) {
        return new H<>(methodDescriptor, b10);
    }

    public MethodDescriptor<ReqT, RespT> b() {
        return this.f33986a;
    }

    public io.grpc.B<ReqT, RespT> c() {
        return this.f33987b;
    }

    public H<ReqT, RespT> d(io.grpc.B<ReqT, RespT> b10) {
        return new H<>(this.f33986a, b10);
    }
}
