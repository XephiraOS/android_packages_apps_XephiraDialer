package io.grpc.internal;

import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.ProxiedSocketAddress;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ProxyDetectorImpl.java */
/* loaded from: classes4.dex */
public class Z implements j9.E {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f33007d = Logger.getLogger(Z.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final c f33008e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.common.base.o<ProxySelector> f33009f = new b();

    /* renamed from: a, reason: collision with root package name */
    public final com.google.common.base.o<ProxySelector> f33010a;

    /* renamed from: b, reason: collision with root package name */
    public final c f33011b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f33012c;

    /* compiled from: ProxyDetectorImpl.java */
    /* loaded from: classes4.dex */
    public class a implements c {
        @Override // io.grpc.internal.Z.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i10, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i10, "");
            } catch (MalformedURLException unused) {
                Z.f33007d.log(Level.WARNING, "failed to create URL for Authenticator: {0} {1}", new Object[]{str2, str});
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i10, str2, str3, str4, url, Authenticator.RequestorType.PROXY);
        }
    }

    /* compiled from: ProxyDetectorImpl.java */
    /* loaded from: classes4.dex */
    public class b implements com.google.common.base.o<ProxySelector> {
        @Override // com.google.common.base.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    /* compiled from: ProxyDetectorImpl.java */
    /* loaded from: classes4.dex */
    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i10, String str2, String str3, String str4);
    }

    public Z() {
        this(f33009f, f33008e, System.getenv("GRPC_PROXY_EXP"));
    }

    public static InetSocketAddress d(String str) {
        int i10;
        if (str == null) {
            return null;
        }
        String[] split = str.split(":", 2);
        if (split.length > 1) {
            i10 = Integer.parseInt(split[1]);
        } else {
            i10 = 80;
        }
        f33007d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
        return new InetSocketAddress(split[0], i10);
    }

    @Override // j9.E
    public ProxiedSocketAddress a(SocketAddress socketAddress) {
        if (!(socketAddress instanceof InetSocketAddress)) {
            return null;
        }
        if (this.f33012c != null) {
            return HttpConnectProxiedSocketAddress.b().c(this.f33012c).d((InetSocketAddress) socketAddress).a();
        }
        return c((InetSocketAddress) socketAddress);
    }

    public final ProxiedSocketAddress c(InetSocketAddress inetSocketAddress) {
        String str = null;
        try {
            try {
                URI uri = new URI("https", null, GrpcUtil.h(inetSocketAddress), inetSocketAddress.getPort(), null, null, null);
                ProxySelector proxySelector = this.f33010a.get();
                if (proxySelector == null) {
                    f33007d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> select = proxySelector.select(uri);
                if (select.size() > 1) {
                    f33007d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = select.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) proxy.address();
                PasswordAuthentication a10 = this.f33011b.a(GrpcUtil.h(inetSocketAddress2), inetSocketAddress2.getAddress(), inetSocketAddress2.getPort(), "https", "", null);
                if (inetSocketAddress2.isUnresolved()) {
                    inetSocketAddress2 = new InetSocketAddress(InetAddress.getByName(inetSocketAddress2.getHostName()), inetSocketAddress2.getPort());
                }
                HttpConnectProxiedSocketAddress.b c10 = HttpConnectProxiedSocketAddress.b().d(inetSocketAddress).c(inetSocketAddress2);
                if (a10 == null) {
                    return c10.a();
                }
                HttpConnectProxiedSocketAddress.b e10 = c10.e(a10.getUserName());
                if (a10.getPassword() != null) {
                    str = new String(a10.getPassword());
                }
                return e10.b(str).a();
            } catch (URISyntaxException e11) {
                f33007d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e11);
                return null;
            }
        } catch (Throwable th) {
            f33007d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }

    public Z(com.google.common.base.o<ProxySelector> oVar, c cVar, String str) {
        this.f33010a = (com.google.common.base.o) com.google.common.base.k.o(oVar);
        this.f33011b = (c) com.google.common.base.k.o(cVar);
        if (str != null) {
            this.f33012c = d(str);
        } else {
            this.f33012c = null;
        }
    }
}
