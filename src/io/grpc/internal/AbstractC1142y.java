package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.u0;

/* compiled from: ForwardingClientStreamListener.java */
/* renamed from: io.grpc.internal.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1142y implements ClientStreamListener {
    @Override // io.grpc.internal.u0
    public void c(u0.a aVar) {
        g().c(aVar);
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void d(io.grpc.u uVar) {
        g().d(uVar);
    }

    @Override // io.grpc.internal.u0
    public void e() {
        g().e();
    }

    @Override // io.grpc.internal.ClientStreamListener
    public void f(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
        g().f(status, rpcProgress, uVar);
    }

    public abstract ClientStreamListener g();

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", g()).toString();
    }
}
