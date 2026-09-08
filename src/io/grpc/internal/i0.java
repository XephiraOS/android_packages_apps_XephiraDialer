package io.grpc.internal;

import io.grpc.C1107a;
import io.grpc.MethodDescriptor;
import j9.J;

/* compiled from: ServerCallInfoImpl.java */
/* loaded from: classes4.dex */
public final class i0<ReqT, RespT> extends J.c<ReqT, RespT> {

    /* renamed from: a, reason: collision with root package name */
    public final MethodDescriptor<ReqT, RespT> f33231a;

    /* renamed from: b, reason: collision with root package name */
    public final C1107a f33232b;

    /* renamed from: c, reason: collision with root package name */
    public final String f33233c;

    public i0(MethodDescriptor<ReqT, RespT> methodDescriptor, C1107a c1107a, String str) {
        this.f33231a = methodDescriptor;
        this.f33232b = c1107a;
        this.f33233c = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        if (!com.google.common.base.h.a(this.f33231a, i0Var.f33231a) || !com.google.common.base.h.a(this.f33232b, i0Var.f33232b) || !com.google.common.base.h.a(this.f33233c, i0Var.f33233c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return com.google.common.base.h.b(this.f33231a, this.f33232b, this.f33233c);
    }
}
