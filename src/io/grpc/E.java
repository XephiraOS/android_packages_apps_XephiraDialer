package io.grpc;

import io.grpc.ManagedChannelProvider;

/* compiled from: ServerProvider.java */
/* loaded from: classes4.dex */
public abstract class E {
    public static E d() {
        E c10 = F.b().c();
        if (c10 != null) {
            return c10;
        }
        throw new ManagedChannelProvider.ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty or grpc-netty-shaded artifact");
    }

    public abstract j9.F<?> a(int i10);

    public abstract boolean b();

    public abstract int c();
}
