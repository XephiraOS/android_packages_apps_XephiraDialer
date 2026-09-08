package io.grpc.internal;

import io.grpc.Status;

/* loaded from: classes4.dex */
public interface ClientStreamListener extends u0 {

    /* loaded from: classes4.dex */
    public enum RpcProgress {
        PROCESSED,
        REFUSED,
        DROPPED,
        MISCARRIED
    }

    void d(io.grpc.u uVar);

    void f(Status status, RpcProgress rpcProgress, io.grpc.u uVar);
}
