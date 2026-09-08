package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

/* compiled from: FailingClientStream.java */
/* renamed from: io.grpc.internal.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1138u extends T {

    /* renamed from: c, reason: collision with root package name */
    public boolean f33403c;

    /* renamed from: d, reason: collision with root package name */
    public final Status f33404d;

    /* renamed from: e, reason: collision with root package name */
    public final ClientStreamListener.RpcProgress f33405e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC1112f[] f33406f;

    public C1138u(Status status, AbstractC1112f[] abstractC1112fArr) {
        this(status, ClientStreamListener.RpcProgress.PROCESSED, abstractC1112fArr);
    }

    @Override // io.grpc.internal.T, io.grpc.internal.InterfaceC1128j
    public void appendTimeoutInsight(F f10) {
        f10.b("error", this.f33404d).b("progress", this.f33405e);
    }

    public Status getError() {
        return this.f33404d;
    }

    @Override // io.grpc.internal.T, io.grpc.internal.InterfaceC1128j
    public void start(ClientStreamListener clientStreamListener) {
        com.google.common.base.k.v(!this.f33403c, "already started");
        this.f33403c = true;
        for (AbstractC1112f abstractC1112f : this.f33406f) {
            abstractC1112f.f(this.f33404d);
        }
        clientStreamListener.f(this.f33404d, this.f33405e, new io.grpc.u());
    }

    public C1138u(Status status, ClientStreamListener.RpcProgress rpcProgress, AbstractC1112f[] abstractC1112fArr) {
        com.google.common.base.k.e(!status.o(), "error must not be OK");
        this.f33404d = status;
        this.f33405e = rpcProgress;
        this.f33406f = abstractC1112fArr;
    }
}
