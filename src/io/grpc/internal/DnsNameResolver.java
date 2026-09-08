package io.grpc.internal;

import com.google.common.base.VerifyException;
import com.oplus.backup.sdk.common.utils.Constants;
import io.grpc.C1107a;
import io.grpc.C1114h;
import io.grpc.ProxiedSocketAddress;
import io.grpc.Status;
import io.grpc.internal.q0;
import io.grpc.v;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public class DnsNameResolver extends io.grpc.v {
    static final long DEFAULT_NETWORK_CACHE_TTL_SECONDS = 30;
    static final String NETWORKADDRESS_CACHE_TTL_PROPERTY = "networkaddress.cache.ttl";
    static boolean enableJndi;
    static boolean enableJndiLocalhost;
    protected static boolean enableTxt;

    /* renamed from: r, reason: collision with root package name */
    public static final Logger f32479r = Logger.getLogger(DnsNameResolver.class.getName());

    /* renamed from: s, reason: collision with root package name */
    public static final Set<String> f32480s = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* renamed from: t, reason: collision with root package name */
    public static final String f32481t;

    /* renamed from: u, reason: collision with root package name */
    public static final String f32482u;

    /* renamed from: v, reason: collision with root package name */
    public static final String f32483v;

    /* renamed from: w, reason: collision with root package name */
    public static final d f32484w;

    /* renamed from: x, reason: collision with root package name */
    public static String f32485x;

    /* renamed from: a, reason: collision with root package name */
    public final Random f32486a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public volatile AddressResolver f32487b = JdkAddressResolver.INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference<ResourceResolver> f32488c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    public final String f32489d;

    /* renamed from: e, reason: collision with root package name */
    public final String f32490e;

    /* renamed from: f, reason: collision with root package name */
    public final int f32491f;

    /* renamed from: g, reason: collision with root package name */
    public final q0.d<Executor> f32492g;

    /* renamed from: h, reason: collision with root package name */
    public final long f32493h;

    /* renamed from: i, reason: collision with root package name */
    public final j9.N f32494i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.common.base.m f32495j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f32496k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f32497l;

    /* renamed from: m, reason: collision with root package name */
    public Executor f32498m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f32499n;

    /* renamed from: o, reason: collision with root package name */
    public final v.h f32500o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f32501p;
    final j9.E proxyDetector;

    /* renamed from: q, reason: collision with root package name */
    public v.e f32502q;

    /* loaded from: classes4.dex */
    public interface AddressResolver {
        List<InetAddress> a(String str);
    }

    /* loaded from: classes4.dex */
    public enum JdkAddressResolver implements AddressResolver {
        INSTANCE;

        @Override // io.grpc.internal.DnsNameResolver.AddressResolver
        public List<InetAddress> a(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* loaded from: classes4.dex */
    public interface ResourceResolver {
        List<String> a(String str);
    }

    /* loaded from: classes4.dex */
    public static final class SrvRecord {

        /* renamed from: a, reason: collision with root package name */
        public final String f32505a;

        /* renamed from: b, reason: collision with root package name */
        public final int f32506b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SrvRecord.class != obj.getClass()) {
                return false;
            }
            SrvRecord srvRecord = (SrvRecord) obj;
            if (this.f32506b == srvRecord.f32506b && this.f32505a.equals(srvRecord.f32505a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f32505a, Integer.valueOf(this.f32506b));
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("host", this.f32505a).b("port", this.f32506b).toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Status f32507a;

        /* renamed from: b, reason: collision with root package name */
        public List<C1114h> f32508b;

        /* renamed from: c, reason: collision with root package name */
        public v.c f32509c;

        /* renamed from: d, reason: collision with root package name */
        public C1107a f32510d;

        public b() {
        }
    }

    /* loaded from: classes4.dex */
    public final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final v.e f32511a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f32513a;

            public a(boolean z10) {
                this.f32513a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f32513a) {
                    DnsNameResolver dnsNameResolver = DnsNameResolver.this;
                    dnsNameResolver.f32496k = true;
                    if (dnsNameResolver.f32493h > 0) {
                        DnsNameResolver.this.f32495j.f().g();
                    }
                }
                DnsNameResolver.this.f32501p = false;
            }
        }

        public c(v.e eVar) {
            this.f32511a = (v.e) com.google.common.base.k.p(eVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            j9.N n10;
            a aVar;
            Logger logger = DnsNameResolver.f32479r;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                DnsNameResolver.f32479r.finer("Attempting DNS resolution of " + DnsNameResolver.this.f32490e);
            }
            boolean z10 = true;
            b bVar = null;
            try {
                try {
                    C1114h n11 = DnsNameResolver.this.n();
                    v.g.a d10 = v.g.d();
                    if (n11 != null) {
                        if (DnsNameResolver.f32479r.isLoggable(level)) {
                            DnsNameResolver.f32479r.finer("Using proxy address " + n11);
                        }
                        d10.b(Collections.singletonList(n11));
                    } else {
                        bVar = DnsNameResolver.this.o(false);
                        if (bVar.f32507a != null) {
                            this.f32511a.a(bVar.f32507a);
                            if (bVar == null || bVar.f32507a != null) {
                                z10 = false;
                            }
                            DnsNameResolver.this.f32494i.execute(new a(z10));
                            return;
                        }
                        if (bVar.f32508b != null) {
                            d10.b(bVar.f32508b);
                        }
                        if (bVar.f32509c != null) {
                            d10.d(bVar.f32509c);
                        }
                        C1107a c1107a = bVar.f32510d;
                        if (c1107a != null) {
                            d10.c(c1107a);
                        }
                    }
                    this.f32511a.c(d10.a());
                    if (bVar == null || bVar.f32507a != null) {
                        z10 = false;
                    }
                    n10 = DnsNameResolver.this.f32494i;
                    aVar = new a(z10);
                } catch (IOException e10) {
                    this.f32511a.a(Status.f32383t.r("Unable to resolve host " + DnsNameResolver.this.f32490e).q(e10));
                    if (0 == 0 || null.f32507a != null) {
                        z10 = false;
                    }
                    n10 = DnsNameResolver.this.f32494i;
                    aVar = new a(z10);
                }
                n10.execute(aVar);
            } catch (Throwable th) {
                if (0 == 0 || null.f32507a != null) {
                    z10 = false;
                }
                DnsNameResolver.this.f32494i.execute(new a(z10));
                throw th;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        ResourceResolver a();

        Throwable b();
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        f32481t = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        f32482u = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        f32483v = property3;
        enableJndi = Boolean.parseBoolean(property);
        enableJndiLocalhost = Boolean.parseBoolean(property2);
        enableTxt = Boolean.parseBoolean(property3);
        f32484w = getResourceResolverFactory(DnsNameResolver.class.getClassLoader());
    }

    public DnsNameResolver(String str, String str2, v.b bVar, q0.d<Executor> dVar, com.google.common.base.m mVar, boolean z10) {
        boolean z11;
        com.google.common.base.k.p(bVar, Constants.MessagerConstants.ARGS_KEY);
        this.f32492g = dVar;
        URI create = URI.create("//" + ((String) com.google.common.base.k.p(str2, "name")));
        if (create.getHost() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        com.google.common.base.k.k(z11, "Invalid DNS name: %s", str2);
        this.f32489d = (String) com.google.common.base.k.q(create.getAuthority(), "nameUri (%s) doesn't have an authority", create);
        this.f32490e = create.getHost();
        if (create.getPort() == -1) {
            this.f32491f = bVar.a();
        } else {
            this.f32491f = create.getPort();
        }
        this.proxyDetector = (j9.E) com.google.common.base.k.p(bVar.c(), "proxyDetector");
        this.f32493h = s(z10);
        this.f32495j = (com.google.common.base.m) com.google.common.base.k.p(mVar, "stopwatch");
        this.f32494i = (j9.N) com.google.common.base.k.p(bVar.f(), "syncContext");
        Executor b10 = bVar.b();
        this.f32498m = b10;
        this.f32499n = b10 == null;
        this.f32500o = (v.h) com.google.common.base.k.p(bVar.e(), "serviceConfigParser");
    }

    public static d getResourceResolverFactory(ClassLoader classLoader) {
        try {
            try {
                try {
                    d dVar = (d) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, classLoader).asSubclass(d.class).getConstructor(null).newInstance(null);
                    if (dVar.b() != null) {
                        f32479r.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", dVar.b());
                        return null;
                    }
                    return dVar;
                } catch (Exception e10) {
                    f32479r.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e10);
                    return null;
                }
            } catch (Exception e11) {
                f32479r.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e11);
                return null;
            }
        } catch (ClassCastException e12) {
            f32479r.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e12);
            return null;
        } catch (ClassNotFoundException e13) {
            f32479r.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e13);
            return null;
        }
    }

    public static Map<String, ?> maybeChooseServiceConfig(Map<String, ?> map, Random random, String str) {
        boolean z10;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            com.google.common.base.s.a(f32480s.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> p10 = p(map);
        if (p10 != null && !p10.isEmpty()) {
            Iterator<String> it = p10.iterator();
            while (it.hasNext()) {
                if ("java".equalsIgnoreCase(it.next())) {
                }
            }
            return null;
        }
        Double t10 = t(map);
        if (t10 != null) {
            int intValue = t10.intValue();
            if (intValue >= 0 && intValue <= 100) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.s.a(z10, "Bad percentage: %s", t10);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List<String> q10 = q(map);
        if (q10 != null && !q10.isEmpty()) {
            Iterator<String> it2 = q10.iterator();
            while (it2.hasNext()) {
                if (it2.next().equals(str)) {
                }
            }
            return null;
        }
        Map<String, ?> j10 = J.j(map, "serviceConfig");
        if (j10 != null) {
            return j10;
        }
        throw new VerifyException(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    public static final List<String> p(Map<String, ?> map) {
        return J.g(map, "clientLanguage");
    }

    public static List<Map<String, ?>> parseTxtResults(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.startsWith("grpc_config=")) {
                f32479r.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            } else {
                Object a10 = I.a(str.substring(12));
                if (a10 instanceof List) {
                    arrayList.addAll(J.a((List) a10));
                } else {
                    throw new ClassCastException("wrong type " + a10);
                }
            }
        }
        return arrayList;
    }

    public static final List<String> q(Map<String, ?> map) {
        return J.g(map, "clientHostname");
    }

    public static String r() {
        if (f32485x == null) {
            try {
                f32485x = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e10) {
                throw new RuntimeException(e10);
            }
        }
        return f32485x;
    }

    public static long s(boolean z10) {
        if (z10) {
            return 0L;
        }
        String property = System.getProperty(NETWORKADDRESS_CACHE_TTL_PROPERTY);
        long j10 = DEFAULT_NETWORK_CACHE_TTL_SECONDS;
        if (property != null) {
            try {
                j10 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f32479r.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{NETWORKADDRESS_CACHE_TTL_PROPERTY, property, Long.valueOf(DEFAULT_NETWORK_CACHE_TTL_SECONDS)});
            }
        }
        if (j10 > 0) {
            return TimeUnit.SECONDS.toNanos(j10);
        }
        return j10;
    }

    public static boolean shouldUseJndi(boolean z10, boolean z11, String str) {
        boolean z12;
        if (!z10) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z11;
        }
        if (str.contains(":")) {
            return false;
        }
        boolean z13 = true;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '.') {
                if (charAt >= '0' && charAt <= '9') {
                    z12 = true;
                } else {
                    z12 = false;
                }
                z13 &= z12;
            }
        }
        return true ^ z13;
    }

    public static final Double t(Map<String, ?> map) {
        return J.h(map, "percentage");
    }

    public static v.c v(List<String> list, Random random, String str) {
        try {
            Iterator<Map<String, ?>> it = parseTxtResults(list).iterator();
            Map<String, ?> map = null;
            while (it.hasNext()) {
                try {
                    map = maybeChooseServiceConfig(it.next(), random, str);
                    if (map != null) {
                        break;
                    }
                } catch (RuntimeException e10) {
                    return v.c.b(Status.f32370g.r("failed to pick service config choice").q(e10));
                }
            }
            if (map == null) {
                return null;
            }
            return v.c.a(map);
        } catch (IOException | RuntimeException e11) {
            return v.c.b(Status.f32370g.r("failed to parse TXT records").q(e11));
        }
    }

    @Override // io.grpc.v
    public String a() {
        return this.f32489d;
    }

    @Override // io.grpc.v
    public void b() {
        boolean z10;
        if (this.f32502q != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "not started");
        w();
    }

    @Override // io.grpc.v
    public void c() {
        if (this.f32497l) {
            return;
        }
        this.f32497l = true;
        Executor executor = this.f32498m;
        if (executor != null && this.f32499n) {
            this.f32498m = (Executor) q0.f(this.f32492g, executor);
        }
    }

    @Override // io.grpc.v
    public void d(v.e eVar) {
        boolean z10;
        if (this.f32502q == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "already started");
        if (this.f32499n) {
            this.f32498m = (Executor) q0.d(this.f32492g);
        }
        this.f32502q = (v.e) com.google.common.base.k.p(eVar, "listener");
        w();
    }

    public String getHost() {
        return this.f32490e;
    }

    public final boolean m() {
        if (this.f32496k) {
            long j10 = this.f32493h;
            if (j10 != 0 && (j10 <= 0 || this.f32495j.d(TimeUnit.NANOSECONDS) <= this.f32493h)) {
                return false;
            }
        }
        return true;
    }

    public final C1114h n() {
        ProxiedSocketAddress a10 = this.proxyDetector.a(InetSocketAddress.createUnresolved(this.f32490e, this.f32491f));
        if (a10 != null) {
            return new C1114h(a10);
        }
        return null;
    }

    public b o(boolean z10) {
        b bVar = new b();
        try {
            bVar.f32508b = x();
        } catch (Exception e10) {
            if (!z10) {
                bVar.f32507a = Status.f32383t.r("Unable to resolve host " + this.f32490e).q(e10);
                return bVar;
            }
        }
        if (enableTxt) {
            bVar.f32509c = y();
        }
        return bVar;
    }

    public void setAddressResolver(AddressResolver addressResolver) {
        this.f32487b = addressResolver;
    }

    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.f32488c.set(resourceResolver);
    }

    public ResourceResolver u() {
        d dVar;
        if (!shouldUseJndi(enableJndi, enableJndiLocalhost, this.f32490e)) {
            return null;
        }
        ResourceResolver resourceResolver = this.f32488c.get();
        if (resourceResolver == null && (dVar = f32484w) != null) {
            return dVar.a();
        }
        return resourceResolver;
    }

    public final void w() {
        if (!this.f32501p && !this.f32497l && m()) {
            this.f32501p = true;
            this.f32498m.execute(new c(this.f32502q));
        }
    }

    public final List<C1114h> x() {
        Exception exc = null;
        try {
            try {
                List<InetAddress> a10 = this.f32487b.a(this.f32490e);
                ArrayList arrayList = new ArrayList(a10.size());
                Iterator<InetAddress> it = a10.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C1114h(new InetSocketAddress(it.next(), this.f32491f)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e10) {
                exc = e10;
                com.google.common.base.q.f(exc);
                throw new RuntimeException(exc);
            }
        } catch (Throwable th) {
            if (exc != null) {
                f32479r.log(Level.FINE, "Address resolution failure", (Throwable) exc);
            }
            throw th;
        }
    }

    public final v.c y() {
        List<String> emptyList = Collections.emptyList();
        ResourceResolver u10 = u();
        if (u10 != null) {
            try {
                emptyList = u10.a("_grpc_config." + this.f32490e);
            } catch (Exception e10) {
                f32479r.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) e10);
            }
        }
        if (!emptyList.isEmpty()) {
            v.c v10 = v(emptyList, this.f32486a, r());
            if (v10 != null) {
                if (v10.d() != null) {
                    return v.c.b(v10.d());
                }
                return this.f32500o.a((Map) v10.c());
            }
            return null;
        }
        f32479r.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f32490e});
        return null;
    }
}
