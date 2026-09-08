package io.grpc.internal;

import io.grpc.C1107a;
import io.grpc.Status;
import j9.InterfaceC1204n;

/* compiled from: ServerStream.java */
/* loaded from: classes4.dex */
public interface l0 extends t0 {
    void cancel(Status status);

    void close(Status status, io.grpc.u uVar);

    C1107a getAttributes();

    String getAuthority();

    void setDecompressor(InterfaceC1204n interfaceC1204n);

    void setListener(m0 m0Var);

    s0 statsTraceContext();

    int streamId();

    void writeHeaders(io.grpc.u uVar, boolean z10);
}
