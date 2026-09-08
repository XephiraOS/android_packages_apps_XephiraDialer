package j9;

import j9.F;
import j9.J;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingServerBuilder.java */
/* loaded from: classes4.dex */
public abstract class p<T extends F<T>> extends F<T> {
    public static F<?> forPort(int i10) {
        throw new UnsupportedOperationException("Subclass failed to hide static factory");
    }

    @Override // j9.F
    public T addService(I i10) {
        delegate().addService(i10);
        return thisT();
    }

    @Override // j9.F
    public T addStreamTracerFactory(J.a aVar) {
        delegate().addStreamTracerFactory(aVar);
        return thisT();
    }

    @Override // j9.F
    public T addTransportFilter(K k10) {
        delegate().addTransportFilter(k10);
        return thisT();
    }

    @Override // j9.F
    public io.grpc.z build() {
        return delegate().build();
    }

    @Override // j9.F
    public T callExecutor(G g10) {
        delegate().callExecutor(g10);
        return thisT();
    }

    @Override // j9.F
    public T compressorRegistry(C1200j c1200j) {
        delegate().compressorRegistry(c1200j);
        return thisT();
    }

    @Override // j9.F
    public T decompressorRegistry(o oVar) {
        delegate().decompressorRegistry(oVar);
        return thisT();
    }

    public abstract F<?> delegate();

    @Override // j9.F
    public T directExecutor() {
        delegate().directExecutor();
        return thisT();
    }

    @Override // j9.F
    public T executor(Executor executor) {
        delegate().executor(executor);
        return thisT();
    }

    @Override // j9.F
    public T fallbackHandlerRegistry(s sVar) {
        delegate().fallbackHandlerRegistry(sVar);
        return thisT();
    }

    @Override // j9.F
    public T handshakeTimeout(long j10, TimeUnit timeUnit) {
        delegate().handshakeTimeout(j10, timeUnit);
        return thisT();
    }

    @Override // j9.F
    public T intercept(io.grpc.C c10) {
        delegate().intercept(c10);
        return thisT();
    }

    @Override // j9.F
    public T keepAliveTime(long j10, TimeUnit timeUnit) {
        delegate().keepAliveTime(j10, timeUnit);
        return thisT();
    }

    @Override // j9.F
    public T keepAliveTimeout(long j10, TimeUnit timeUnit) {
        delegate().keepAliveTimeout(j10, timeUnit);
        return thisT();
    }

    @Override // j9.F
    public T maxConnectionAge(long j10, TimeUnit timeUnit) {
        delegate().maxConnectionAge(j10, timeUnit);
        return thisT();
    }

    @Override // j9.F
    public T maxConnectionAgeGrace(long j10, TimeUnit timeUnit) {
        delegate().maxConnectionAgeGrace(j10, timeUnit);
        return thisT();
    }

    @Override // j9.F
    public T maxConnectionIdle(long j10, TimeUnit timeUnit) {
        delegate().maxConnectionIdle(j10, timeUnit);
        return thisT();
    }

    @Override // j9.F
    public T maxInboundMessageSize(int i10) {
        delegate().maxInboundMessageSize(i10);
        return thisT();
    }

    @Override // j9.F
    public T maxInboundMetadataSize(int i10) {
        delegate().maxInboundMetadataSize(i10);
        return thisT();
    }

    @Override // j9.F
    public T permitKeepAliveTime(long j10, TimeUnit timeUnit) {
        delegate().permitKeepAliveTime(j10, timeUnit);
        return thisT();
    }

    @Override // j9.F
    public T permitKeepAliveWithoutCalls(boolean z10) {
        delegate().permitKeepAliveWithoutCalls(z10);
        return thisT();
    }

    @Override // j9.F
    public T setBinaryLog(AbstractC1191a abstractC1191a) {
        delegate().setBinaryLog(abstractC1191a);
        return thisT();
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", delegate()).toString();
    }

    @Override // j9.F
    public T useTransportSecurity(File file, File file2) {
        delegate().useTransportSecurity(file, file2);
        return thisT();
    }

    @Override // j9.F
    public T addService(InterfaceC1192b interfaceC1192b) {
        delegate().addService(interfaceC1192b);
        return thisT();
    }

    @Override // j9.F
    public T useTransportSecurity(InputStream inputStream, InputStream inputStream2) {
        delegate().useTransportSecurity(inputStream, inputStream2);
        return thisT();
    }

    private T thisT() {
        return this;
    }
}
