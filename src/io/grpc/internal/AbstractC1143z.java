package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.P;

/* compiled from: ForwardingConnectionClientTransport.java */
/* renamed from: io.grpc.internal.z, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1143z implements InterfaceC1131m {
    public abstract InterfaceC1131m a();

    @Override // j9.z
    public j9.w getLogId() {
        return a().getLogId();
    }

    @Override // io.grpc.internal.InterfaceC1129k
    public InterfaceC1128j newStream(MethodDescriptor<?, ?> methodDescriptor, io.grpc.u uVar, C1108b c1108b, AbstractC1112f[] abstractC1112fArr) {
        return a().newStream(methodDescriptor, uVar, c1108b, abstractC1112fArr);
    }

    @Override // io.grpc.internal.P
    public void shutdown(Status status) {
        a().shutdown(status);
    }

    @Override // io.grpc.internal.P
    public void shutdownNow(Status status) {
        a().shutdownNow(status);
    }

    @Override // io.grpc.internal.P
    public Runnable start(P.a aVar) {
        return a().start(aVar);
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", a()).toString();
    }
}
