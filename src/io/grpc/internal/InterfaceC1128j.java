package io.grpc.internal;

import io.grpc.Status;
import j9.C1203m;

/* compiled from: ClientStream.java */
/* renamed from: io.grpc.internal.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC1128j extends t0 {
    void appendTimeoutInsight(F f10);

    void cancel(Status status);

    void halfClose();

    void setAuthority(String str);

    void setDeadline(C1203m c1203m);

    void setDecompressorRegistry(j9.o oVar);

    void setFullStreamDecompression(boolean z10);

    void setMaxInboundMessageSize(int i10);

    void setMaxOutboundMessageSize(int i10);

    void start(ClientStreamListener clientStreamListener);
}
