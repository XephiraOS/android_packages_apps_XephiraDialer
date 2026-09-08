package io.grpc.internal;

import io.grpc.Status;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: ServerTransport.java */
/* loaded from: classes4.dex */
public interface n0 extends j9.v<Object> {
    ScheduledExecutorService getScheduledExecutorService();

    void shutdown();

    void shutdownNow(Status status);
}
