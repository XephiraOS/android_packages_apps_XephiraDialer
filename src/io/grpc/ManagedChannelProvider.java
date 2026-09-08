package io.grpc;

import j9.AbstractC1195e;
import java.net.SocketAddress;
import java.util.Collection;

/* loaded from: classes4.dex */
public abstract class ManagedChannelProvider {

    /* loaded from: classes4.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final t<?> f32332a;

        /* renamed from: b, reason: collision with root package name */
        public final String f32333b;

        public a(t<?> tVar, String str) {
            this.f32332a = tVar;
            this.f32333b = str;
        }

        public static a a(String str) {
            return new a(null, (String) com.google.common.base.k.o(str));
        }

        public t<?> b() {
            return this.f32332a;
        }

        public String c() {
            return this.f32333b;
        }
    }

    public static ManagedChannelProvider g() {
        ManagedChannelProvider c10 = ManagedChannelRegistry.b().c();
        if (c10 != null) {
            return c10;
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract t<?> a(String str, int i10);

    public abstract t<?> b(String str);

    public abstract Collection<Class<? extends SocketAddress>> c();

    public abstract boolean d();

    public a e(String str, AbstractC1195e abstractC1195e) {
        return a.a("ChannelCredentials are unsupported");
    }

    public abstract int f();
}
