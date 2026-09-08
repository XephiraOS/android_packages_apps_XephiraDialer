package io.grpc.internal;

import io.grpc.Status;

/* compiled from: ManagedClientTransport.java */
/* loaded from: classes4.dex */
public interface P extends InterfaceC1129k {

    /* compiled from: ManagedClientTransport.java */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b(Status status);

        void c();

        void d(boolean z10);
    }

    void shutdown(Status status);

    void shutdownNow(Status status);

    Runnable start(a aVar);
}
