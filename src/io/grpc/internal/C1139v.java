package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

/* compiled from: FailingClientTransport.java */
/* renamed from: io.grpc.internal.v, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1139v implements InterfaceC1129k {

    /* renamed from: a, reason: collision with root package name */
    public final ClientStreamListener.RpcProgress f33407a;
    final Status error;

    public C1139v(Status status, ClientStreamListener.RpcProgress rpcProgress) {
        com.google.common.base.k.e(!status.o(), "error must not be OK");
        this.error = status;
        this.f33407a = rpcProgress;
    }

    @Override // j9.z
    public j9.w getLogId() {
        throw new UnsupportedOperationException("Not a real transport");
    }

    @Override // io.grpc.internal.InterfaceC1129k
    public InterfaceC1128j newStream(MethodDescriptor<?, ?> methodDescriptor, io.grpc.u uVar, C1108b c1108b, AbstractC1112f[] abstractC1112fArr) {
        return new C1138u(this.error, this.f33407a, abstractC1112fArr);
    }
}
