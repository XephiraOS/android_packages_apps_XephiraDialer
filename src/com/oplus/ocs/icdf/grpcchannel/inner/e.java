package com.oplus.ocs.icdf.grpcchannel.inner;

import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.T;
import io.grpc.internal.s0;
import io.grpc.u;

/* loaded from: classes3.dex */
class e extends T {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s0 f28660a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Status f28661b;

    public e(d dVar, s0 s0Var, Status status) {
        this.f28660a = s0Var;
        this.f28661b = status;
    }

    @Override // io.grpc.internal.T, io.grpc.internal.InterfaceC1128j
    public void start(ClientStreamListener clientStreamListener) {
        this.f28660a.c();
        this.f28660a.m(this.f28661b);
        clientStreamListener.f(this.f28661b, ClientStreamListener.RpcProgress.PROCESSED, new u());
    }
}
