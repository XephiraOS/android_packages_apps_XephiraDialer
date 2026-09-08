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

/* compiled from: ForwardingChannelBuilder2.java */
/* loaded from: classes4.dex */
public abstract class i<T extends t<T>> extends t<T> {
    public static t<?> forAddress(String str, int i10) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    public static t<?> forTarget(String str) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @Override // io.grpc.t
    public AbstractC1190B build() {
        return delegate().build();
    }

    @Override // io.grpc.t
    public T compressorRegistry(C1200j c1200j) {
        delegate().compressorRegistry(c1200j);
        return thisT();
    }

    @Override // io.grpc.t
    public T decompressorRegistry(j9.o oVar) {
        delegate().decompressorRegistry(oVar);
        return thisT();
    }

    @Override // io.grpc.t
    public T defaultLoadBalancingPolicy(String str) {
        delegate().defaultLoadBalancingPolicy(str);
        return thisT();
    }

    @Override // io.grpc.t
    public T defaultServiceConfig(Map<String, ?> map) {
        delegate().defaultServiceConfig(map);
        return thisT();
    }

    public abstract t<?> delegate();

    @Override // io.grpc.t
    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    @Override // io.grpc.t
    public T disableRetry() {
        delegate().disableRetry();
        return thisT();
    }

    @Override // io.grpc.t
    public T disableServiceConfigLookUp() {
        delegate().disableServiceConfigLookUp();
        return thisT();
    }

    @Override // io.grpc.t
    public T enableRetry() {
        delegate().enableRetry();
        return thisT();
    }

    @Override // io.grpc.t
    public T executor(Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    @Override // io.grpc.t
    public T idleTimeout(long j10, TimeUnit timeUnit) {
        delegate().idleTimeout(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.t
    public T intercept(List<InterfaceC1196f> list) {
        delegate().intercept(list);
        return thisT();
    }

    @Override // io.grpc.t
    public T keepAliveTime(long j10, TimeUnit timeUnit) {
        delegate().keepAliveTime(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.t
    public T keepAliveTimeout(long j10, TimeUnit timeUnit) {
        delegate().keepAliveTimeout(j10, timeUnit);
        return thisT();
    }

    @Override // io.grpc.t
    public T keepAliveWithoutCalls(boolean z10) {
        delegate().keepAliveWithoutCalls(z10);
        return thisT();
    }

    @Override // io.grpc.t
    public T maxHedgedAttempts(int i10) {
        delegate().maxHedgedAttempts(i10);
        return thisT();
    }

    @Override // io.grpc.t
    public T maxInboundMessageSize(int i10) {
        delegate().maxInboundMessageSize(i10);
        return thisT();
    }

    @Override // io.grpc.t
    public T maxInboundMetadataSize(int i10) {
        delegate().maxInboundMetadataSize(i10);
        return thisT();
    }

    @Override // io.grpc.t
    public T maxRetryAttempts(int i10) {
        delegate().maxRetryAttempts(i10);
        return thisT();
    }

    @Override // io.grpc.t
    public T maxTraceEvents(int i10) {
        delegate().maxTraceEvents(i10);
        return thisT();
    }

    @Override // io.grpc.t
    @Deprecated
    public T nameResolverFactory(v.d dVar) {
        delegate().nameResolverFactory(dVar);
        return thisT();
    }

    @Override // io.grpc.t
    public T offloadExecutor(Executor executor) {
        delegate().offloadExecutor(executor);
        return thisT();
    }

    @Override // io.grpc.t
    public T overrideAuthority(String str) {
        delegate().overrideAuthority(str);
        return thisT();
    }

    @Override // io.grpc.t
    public T perRpcBufferLimit(long j10) {
        delegate().perRpcBufferLimit(j10);
        return thisT();
    }

    @Override // io.grpc.t
    public T proxyDetector(j9.E e10) {
        delegate().proxyDetector(e10);
        return thisT();
    }

    @Override // io.grpc.t
    public T retryBufferSize(long j10) {
        delegate().retryBufferSize(j10);
        return thisT();
    }

    @Override // io.grpc.t
    public T setBinaryLog(AbstractC1191a abstractC1191a) {
        delegate().setBinaryLog(abstractC1191a);
        return thisT();
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", delegate()).toString();
    }

    @Override // io.grpc.t
    public T usePlaintext() {
        delegate().usePlaintext();
        return thisT();
    }

    @Override // io.grpc.t
    public T useTransportSecurity() {
        delegate().useTransportSecurity();
        return thisT();
    }

    @Override // io.grpc.t
    public T userAgent(String str) {
        delegate().userAgent(str);
        return thisT();
    }

    @Override // io.grpc.t
    public T intercept(InterfaceC1196f... interfaceC1196fArr) {
        delegate().intercept(interfaceC1196fArr);
        return thisT();
    }

    private T thisT() {
        return this;
    }
}
