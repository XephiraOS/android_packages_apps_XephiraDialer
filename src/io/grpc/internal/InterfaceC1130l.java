package io.grpc.internal;

import io.grpc.C1107a;
import io.grpc.ChannelLogger;
import io.grpc.HttpConnectProxiedSocketAddress;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: ClientTransportFactory.java */
/* renamed from: io.grpc.internal.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC1130l extends Closeable {

    /* compiled from: ClientTransportFactory.java */
    /* renamed from: io.grpc.internal.l$a */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f33259a = "unknown-authority";

        /* renamed from: b, reason: collision with root package name */
        public C1107a f33260b = C1107a.f32411c;

        /* renamed from: c, reason: collision with root package name */
        public String f33261c;

        /* renamed from: d, reason: collision with root package name */
        public HttpConnectProxiedSocketAddress f33262d;

        public String a() {
            return this.f33259a;
        }

        public C1107a b() {
            return this.f33260b;
        }

        public String c() {
            return this.f33261c;
        }

        public a d(String str) {
            this.f33259a = (String) com.google.common.base.k.p(str, "authority");
            return this;
        }

        public a e(C1107a c1107a) {
            com.google.common.base.k.p(c1107a, "eagAttributes");
            this.f33260b = c1107a;
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f33259a.equals(aVar.f33259a) || !this.f33260b.equals(aVar.f33260b) || !com.google.common.base.h.a(this.f33261c, aVar.f33261c) || !com.google.common.base.h.a(this.f33262d, aVar.f33262d)) {
                return false;
            }
            return true;
        }

        public a f(HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress) {
            this.f33262d = httpConnectProxiedSocketAddress;
            return this;
        }

        public a g(String str) {
            this.f33261c = str;
            return this;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f33259a, this.f33260b, this.f33261c, this.f33262d);
        }
    }

    /* compiled from: ClientTransportFactory.java */
    /* renamed from: io.grpc.internal.l$b */
    /* loaded from: classes4.dex */
    public static final class b {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ScheduledExecutorService getScheduledExecutorService();

    Collection<Class<? extends SocketAddress>> getSupportedSocketAddressTypes();

    InterfaceC1131m newClientTransport(SocketAddress socketAddress, a aVar, ChannelLogger channelLogger);
}
