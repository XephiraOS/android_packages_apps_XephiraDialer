package com.oplus.ocs.icdf.grpcchannel.inner;

import io.grpc.internal.GrpcUtil;
import io.grpc.internal.H;
import io.grpc.internal.U;
import io.grpc.internal.j0;
import io.grpc.internal.r0;
import j9.F;
import j9.J;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class l extends j9.p<l> {

    /* renamed from: b, reason: collision with root package name */
    final String f28693b;

    /* renamed from: c, reason: collision with root package name */
    k f28694c;

    /* renamed from: d, reason: collision with root package name */
    U<ScheduledExecutorService> f28695d = r0.c(GrpcUtil.f32540v);

    /* renamed from: a, reason: collision with root package name */
    private j0 f28692a = new j0(new b());

    /* loaded from: classes3.dex */
    public final class b implements j0.b {
        private b() {
        }

        @Override // io.grpc.internal.j0.b
        public H buildClientTransportServers(List<? extends J.a> list) {
            l lVar = l.this;
            lVar.getClass();
            return new j(lVar, list);
        }
    }

    private l(String str) {
        this.f28693b = (String) com.google.common.base.k.p(str, "name");
        handshakeTimeout(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    public static l a(String str) {
        return new l(str);
    }

    @Override // j9.p
    public F<?> delegate() {
        return this.f28692a;
    }

    @Override // j9.p, j9.F
    public F maxInboundMetadataSize(int i10) {
        throw new UnsupportedOperationException("maxInboundMetadataSize() is not allowed for server");
    }

    @Override // j9.p, j9.F
    public F useTransportSecurity(File file, File file2) {
        throw new UnsupportedOperationException("TLS not supported in InProcessServer");
    }

    public l a(k kVar) {
        this.f28694c = kVar;
        return this;
    }
}
