package com.oplus.ocs.icdf.grpcchannel.inner;

import com.oplus.ocs.icdf.model.PeerAgent;
import io.grpc.ChannelLogger;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InterfaceC1130l;
import io.grpc.internal.InterfaceC1131m;
import io.grpc.internal.N;
import io.grpc.internal.q0;
import io.grpc.t;
import j9.AbstractC1195e;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class f extends io.grpc.i<f> {

    /* renamed from: a, reason: collision with root package name */
    private N f28662a;

    /* renamed from: b, reason: collision with root package name */
    private final PeerAgent f28663b;

    /* renamed from: c, reason: collision with root package name */
    private com.oplus.ocs.icdf.grpcchannel.inner.b f28664c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, p> f28665d = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public final class b implements N.c {
        private b() {
        }

        @Override // io.grpc.internal.N.c
        public InterfaceC1130l buildClientTransportFactory() {
            return f.this.a();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements InterfaceC1130l {

        /* renamed from: a, reason: collision with root package name */
        private final PeerAgent f28667a;

        /* renamed from: b, reason: collision with root package name */
        private final com.oplus.ocs.icdf.grpcchannel.inner.b f28668b;

        /* renamed from: c, reason: collision with root package name */
        private final ScheduledExecutorService f28669c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f28670d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f28671e;

        /* renamed from: f, reason: collision with root package name */
        private Map<String, p> f28672f;

        @Override // io.grpc.internal.InterfaceC1130l, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f28671e) {
                return;
            }
            this.f28671e = true;
            if (this.f28670d) {
                q0.f(GrpcUtil.f32540v, this.f28669c);
            }
        }

        @Override // io.grpc.internal.InterfaceC1130l
        public ScheduledExecutorService getScheduledExecutorService() {
            return this.f28669c;
        }

        @Override // io.grpc.internal.InterfaceC1130l
        public Collection<Class<? extends SocketAddress>> getSupportedSocketAddressTypes() {
            return null;
        }

        @Override // io.grpc.internal.InterfaceC1130l
        public InterfaceC1131m newClientTransport(SocketAddress socketAddress, InterfaceC1130l.a aVar, ChannelLogger channelLogger) {
            if (!this.f28671e) {
                return new d(this.f28667a, this.f28668b, this.f28672f, this.f28669c, aVar);
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        public InterfaceC1130l.b swapChannelCredentials(AbstractC1195e abstractC1195e) {
            return null;
        }

        private c(PeerAgent peerAgent, com.oplus.ocs.icdf.grpcchannel.inner.b bVar, Map<String, p> map, ScheduledExecutorService scheduledExecutorService, int i10) {
            this.f28672f = new ConcurrentHashMap();
            this.f28667a = peerAgent;
            this.f28668b = bVar;
            boolean z10 = scheduledExecutorService == null;
            this.f28670d = z10;
            this.f28669c = z10 ? (ScheduledExecutorService) q0.d(GrpcUtil.f32540v) : scheduledExecutorService;
            this.f28672f.putAll(map);
        }
    }

    private f(PeerAgent peerAgent) {
        this.f28662a = new N(new n(peerAgent), "localhost", new b(), null);
        this.f28663b = (PeerAgent) com.google.common.base.k.p(peerAgent, "peerAgent");
    }

    public static f a(PeerAgent peerAgent) {
        return new f(peerAgent);
    }

    @Override // io.grpc.i
    public t<?> delegate() {
        return this.f28662a;
    }

    @Override // io.grpc.i, io.grpc.t
    public t maxInboundMessageSize(int i10) {
        return (f) super.maxInboundMessageSize(i10);
    }

    @Override // io.grpc.i, io.grpc.t
    public t maxInboundMetadataSize(int i10) {
        throw new UnsupportedOperationException("maxInboundMetadataSize() is not allowed for client");
    }

    public f a(com.oplus.ocs.icdf.grpcchannel.inner.b bVar) {
        this.f28664c = bVar;
        return this;
    }

    public f a(Map<String, p> map) {
        this.f28665d.putAll(map);
        return this;
    }

    public final f a(int i10) {
        return (f) super.maxInboundMessageSize(i10);
    }

    public InterfaceC1130l a() {
        return new c(this.f28663b, this.f28664c, this.f28665d, Integer.MAX_VALUE);
    }

    @Override // io.grpc.i, io.grpc.t
    public t usePlaintext() {
        return this;
    }

    @Override // io.grpc.i, io.grpc.t
    public t useTransportSecurity() {
        return this;
    }

    @Override // io.grpc.i, io.grpc.t
    public t keepAliveWithoutCalls(boolean z10) {
        return this;
    }

    @Override // io.grpc.i, io.grpc.t
    public t keepAliveTime(long j10, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.grpc.i, io.grpc.t
    public t keepAliveTimeout(long j10, TimeUnit timeUnit) {
        return this;
    }
}
