package j9;

import j9.F;
import j9.J;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: ServerBuilder.java */
/* loaded from: classes4.dex */
public abstract class F<T extends F<T>> {
    public static F<?> forPort(int i10) {
        return io.grpc.E.d().a(i10);
    }

    public abstract T addService(I i10);

    public abstract T addService(InterfaceC1192b interfaceC1192b);

    public final T addServices(List<I> list) {
        com.google.common.base.k.p(list, "services");
        Iterator<I> it = list.iterator();
        while (it.hasNext()) {
            addService(it.next());
        }
        return thisT();
    }

    public T addStreamTracerFactory(J.a aVar) {
        throw new UnsupportedOperationException();
    }

    public T addTransportFilter(K k10) {
        throw new UnsupportedOperationException();
    }

    public abstract io.grpc.z build();

    public T callExecutor(G g10) {
        return thisT();
    }

    public abstract T compressorRegistry(C1200j c1200j);

    public abstract T decompressorRegistry(o oVar);

    public abstract T directExecutor();

    public abstract T executor(Executor executor);

    public abstract T fallbackHandlerRegistry(s sVar);

    public T handshakeTimeout(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T intercept(io.grpc.C c10) {
        throw new UnsupportedOperationException();
    }

    public T keepAliveTime(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T keepAliveTimeout(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T maxConnectionAge(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T maxConnectionAgeGrace(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T maxConnectionIdle(long j10, TimeUnit timeUnit) {
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

    public T permitKeepAliveTime(long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public T permitKeepAliveWithoutCalls(boolean z10) {
        throw new UnsupportedOperationException();
    }

    public T setBinaryLog(AbstractC1191a abstractC1191a) {
        throw new UnsupportedOperationException();
    }

    public abstract T useTransportSecurity(File file, File file2);

    public T useTransportSecurity(InputStream inputStream, InputStream inputStream2) {
        throw new UnsupportedOperationException();
    }

    private T thisT() {
        return this;
    }
}
