package io.grpc.internal;

import io.grpc.C1107a;
import io.grpc.Status;
import j9.C1203m;
import j9.InterfaceC1199i;
import java.io.InputStream;

/* compiled from: NoopClientStream.java */
/* loaded from: classes4.dex */
public class T implements InterfaceC1128j {
    public static final T INSTANCE = new T();

    @Override // io.grpc.internal.InterfaceC1128j
    public void appendTimeoutInsight(F f10) {
        f10.a("noop");
    }

    public C1107a getAttributes() {
        return C1107a.f32411c;
    }

    @Override // io.grpc.internal.t0
    public boolean isReady() {
        return false;
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void cancel(Status status) {
    }

    @Override // io.grpc.internal.t0
    public void request(int i10) {
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setAuthority(String str) {
    }

    @Override // io.grpc.internal.t0
    public void setCompressor(InterfaceC1199i interfaceC1199i) {
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setDeadline(C1203m c1203m) {
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setDecompressorRegistry(j9.o oVar) {
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setFullStreamDecompression(boolean z10) {
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setMaxInboundMessageSize(int i10) {
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setMaxOutboundMessageSize(int i10) {
    }

    public void setMessageCompression(boolean z10) {
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void start(ClientStreamListener clientStreamListener) {
    }

    @Override // io.grpc.internal.t0
    public void writeMessage(InputStream inputStream) {
    }

    @Override // io.grpc.internal.t0
    public void flush() {
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void halfClose() {
    }

    @Override // io.grpc.internal.t0
    public void optimizeForDirectExecutor() {
    }
}
