package io.grpc.internal;

import java.net.SocketAddress;
import java.util.List;

/* compiled from: InternalServer.java */
/* loaded from: classes4.dex */
public interface H {
    List<? extends SocketAddress> getListenSocketAddresses();

    void shutdown();

    void start(k0 k0Var);
}
