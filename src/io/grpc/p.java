package io.grpc;

import io.grpc.u;

/* compiled from: InternalStatus.java */
/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final u.g<String> f33424a = Status.f32387x;

    /* renamed from: b, reason: collision with root package name */
    public static final u.g<Status> f33425b = Status.f32385v;

    public static final StatusRuntimeException a(Status status, u uVar, boolean z10) {
        return new StatusRuntimeException(status, uVar, z10);
    }
}
