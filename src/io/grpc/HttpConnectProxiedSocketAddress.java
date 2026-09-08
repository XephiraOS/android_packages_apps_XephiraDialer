package io.grpc;

import com.google.common.base.f;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* loaded from: classes4.dex */
public final class HttpConnectProxiedSocketAddress extends ProxiedSocketAddress {
    private static final long serialVersionUID = 0;
    private final String password;
    private final SocketAddress proxyAddress;
    private final InetSocketAddress targetAddress;
    private final String username;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public SocketAddress f32306a;

        /* renamed from: b, reason: collision with root package name */
        public InetSocketAddress f32307b;

        /* renamed from: c, reason: collision with root package name */
        public String f32308c;

        /* renamed from: d, reason: collision with root package name */
        public String f32309d;

        public HttpConnectProxiedSocketAddress a() {
            return new HttpConnectProxiedSocketAddress(this.f32306a, this.f32307b, this.f32308c, this.f32309d);
        }

        public b b(String str) {
            this.f32309d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f32306a = (SocketAddress) com.google.common.base.k.p(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f32307b = (InetSocketAddress) com.google.common.base.k.p(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(String str) {
            this.f32308c = str;
            return this;
        }

        public b() {
        }
    }

    public static b b() {
        return new b();
    }

    public InetSocketAddress a() {
        return this.targetAddress;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpConnectProxiedSocketAddress)) {
            return false;
        }
        HttpConnectProxiedSocketAddress httpConnectProxiedSocketAddress = (HttpConnectProxiedSocketAddress) obj;
        if (!com.google.common.base.h.a(this.proxyAddress, httpConnectProxiedSocketAddress.proxyAddress) || !com.google.common.base.h.a(this.targetAddress, httpConnectProxiedSocketAddress.targetAddress) || !com.google.common.base.h.a(this.username, httpConnectProxiedSocketAddress.username) || !com.google.common.base.h.a(this.password, httpConnectProxiedSocketAddress.password)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return com.google.common.base.h.b(this.proxyAddress, this.targetAddress, this.username, this.password);
    }

    public String toString() {
        boolean z10;
        f.b d10 = com.google.common.base.f.c(this).d("proxyAddr", this.proxyAddress).d("targetAddr", this.targetAddress).d("username", this.username);
        if (this.password != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return d10.e("hasPassword", z10).toString();
    }

    public HttpConnectProxiedSocketAddress(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2) {
        com.google.common.base.k.p(socketAddress, "proxyAddress");
        com.google.common.base.k.p(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            com.google.common.base.k.x(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.proxyAddress = socketAddress;
        this.targetAddress = inetSocketAddress;
        this.username = str;
        this.password = str2;
    }
}
