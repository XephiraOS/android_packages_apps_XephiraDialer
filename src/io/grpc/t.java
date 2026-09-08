package io.grpc;

import io.grpc.t;
import io.grpc.v;
import j9.AbstractC1190B;
import j9.AbstractC1191a;
import j9.C1200j;
import j9.InterfaceC1196f;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: ManagedChannelBuilder.java */
/* loaded from: classes4.dex */
public abstract class t<T extends t<T>> {
    public static t<?> forAddress(String str, int i10) {
        return ManagedChannelProvider.g().a(str, i10);
    }

    public static t<?> forTarget(String str) {
        return ManagedChannelProvider.g().b(str);
    }

    public abstract AbstractC1190B build();

    public abstract T compressorRegistry(C1200j c1200j);

    public abstract T decompressorRegistry(j9.o oVar);

    public T defaultLoadBalancingPolicy(String str) {
        throw new UnsupportedOperationException();
    }

    public T defaultServiceConfig(Map<String, ?> map) {
        throw new UnsupportedOperationException();
    }

    public abstract T directExecutor();

    public T disableRetry() {
        throw new UnsupportedOperationException();
    }

    public T disableServiceConfigLookUp() {
        throw new UnsupportedOperationException();
    }

    public T enableRetry() {
        throw new UnsupportedOperationException();
    }

    public abstract T executor(Executor executor);

    public abstract T idleTimeout(long j10, TimeUnit timeUnit);

    public abstract T intercept(List<InterfaceC1196f> list);

    public abstract T intercept(InterfaceC1196f... interfaceC1196fArr);

    public T keepAliveTime(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T keepAliveTimeout(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T keepAliveWithoutCalls(boolean z10) {
        throw new UnsupportedOperationException();
    }

    public T maxHedgedAttempts(int i10) {
        throw new UnsupportedOperationException();
    }

    public T maxInboundMessageSize(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "bytes must be >= 0");
        return thisT();
    }

    public T maxInboundMetadataSize(int i10) {
        boolean z10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "maxInboundMetadataSize must be > 0");
        return thisT();
    }

    public T maxRetryAttempts(int i10) {
        throw new UnsupportedOperationException();
    }

    public T maxTraceEvents(int i10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public abstract T nameResolverFactory(v.d dVar);

    public T offloadExecutor(Executor executor) {
        throw new UnsupportedOperationException();
    }

    public abstract T overrideAuthority(String str);

    public T perRpcBufferLimit(long j10) {
        throw new UnsupportedOperationException();
    }

    public T proxyDetector(j9.E e10) {
        throw new UnsupportedOperationException();
    }

    public T retryBufferSize(long j10) {
        throw new UnsupportedOperationException();
    }

    public T setBinaryLog(AbstractC1191a abstractC1191a) {
        throw new UnsupportedOperationException();
    }

    public T usePlaintext() {
        throw new UnsupportedOperationException();
    }

    public T useTransportSecurity() {
        throw new UnsupportedOperationException();
    }

    public abstract T userAgent(String str);

    private T thisT() {
        return this;
    }
}
