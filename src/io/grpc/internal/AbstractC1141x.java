package io.grpc.internal;

import io.grpc.Status;
import j9.C1203m;
import j9.InterfaceC1199i;
import java.io.InputStream;

/* compiled from: ForwardingClientStream.java */
/* renamed from: io.grpc.internal.x, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1141x implements InterfaceC1128j {
    public abstract InterfaceC1128j a();

    @Override // io.grpc.internal.InterfaceC1128j
    public void appendTimeoutInsight(F f10) {
        a().appendTimeoutInsight(f10);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void cancel(Status status) {
        a().cancel(status);
    }

    @Override // io.grpc.internal.t0
    public void flush() {
        a().flush();
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void halfClose() {
        a().halfClose();
    }

    @Override // io.grpc.internal.t0
    public boolean isReady() {
        return a().isReady();
    }

    @Override // io.grpc.internal.t0
    public void optimizeForDirectExecutor() {
        a().optimizeForDirectExecutor();
    }

    @Override // io.grpc.internal.t0
    public void request(int i10) {
        a().request(i10);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setAuthority(String str) {
        a().setAuthority(str);
    }

    @Override // io.grpc.internal.t0
    public void setCompressor(InterfaceC1199i interfaceC1199i) {
        a().setCompressor(interfaceC1199i);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setDeadline(C1203m c1203m) {
        a().setDeadline(c1203m);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setDecompressorRegistry(j9.o oVar) {
        a().setDecompressorRegistry(oVar);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setFullStreamDecompression(boolean z10) {
        a().setFullStreamDecompression(z10);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setMaxInboundMessageSize(int i10) {
        a().setMaxInboundMessageSize(i10);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setMaxOutboundMessageSize(int i10) {
        a().setMaxOutboundMessageSize(i10);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void start(ClientStreamListener clientStreamListener) {
        a().start(clientStreamListener);
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", a()).toString();
    }

    @Override // io.grpc.internal.t0
    public void writeMessage(InputStream inputStream) {
        a().writeMessage(inputStream);
    }
}
