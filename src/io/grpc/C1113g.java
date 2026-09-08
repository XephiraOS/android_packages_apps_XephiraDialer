package io.grpc;

import io.grpc.Status;
import java.util.concurrent.TimeoutException;

/* compiled from: Contexts.java */
/* renamed from: io.grpc.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1113g {
    public static Status a(Context context) {
        com.google.common.base.k.p(context, "context must not be null");
        if (!context.u()) {
            return null;
        }
        Throwable f10 = context.f();
        if (f10 == null) {
            return Status.f32369f.r("io.grpc.Context was cancelled without error");
        }
        if (f10 instanceof TimeoutException) {
            return Status.f32372i.r(f10.getMessage()).q(f10);
        }
        Status k10 = Status.k(f10);
        if (Status.Code.UNKNOWN.equals(k10.m()) && k10.l() == f10) {
            return Status.f32369f.r("Context cancelled").q(f10);
        }
        return k10.q(f10);
    }
}
