package io.grpc.internal;

import j9.InterfaceC1199i;
import java.io.InputStream;

/* compiled from: Stream.java */
/* loaded from: classes4.dex */
public interface t0 {
    void flush();

    boolean isReady();

    void optimizeForDirectExecutor();

    void request(int i10);

    void setCompressor(InterfaceC1199i interfaceC1199i);

    void writeMessage(InputStream inputStream);
}
