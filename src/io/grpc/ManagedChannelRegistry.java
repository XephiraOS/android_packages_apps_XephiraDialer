package io.grpc;

import io.grpc.G;
import io.grpc.ManagedChannelProvider;
import j9.AbstractC1195e;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class ManagedChannelRegistry {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f32334c = Logger.getLogger(ManagedChannelRegistry.class.getName());

    /* renamed from: d, reason: collision with root package name */
    public static ManagedChannelRegistry f32335d;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<ManagedChannelProvider> f32336a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public List<ManagedChannelProvider> f32337b = Collections.emptyList();

    /* loaded from: classes4.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Comparator<ManagedChannelProvider> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ManagedChannelProvider managedChannelProvider, ManagedChannelProvider managedChannelProvider2) {
            return managedChannelProvider.f() - managedChannelProvider2.f();
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements G.b<ManagedChannelProvider> {
        public b() {
        }

        @Override // io.grpc.G.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.f();
        }

        @Override // io.grpc.G.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.d();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static synchronized ManagedChannelRegistry b() {
        ManagedChannelRegistry managedChannelRegistry;
        synchronized (ManagedChannelRegistry.class) {
            try {
                if (f32335d == null) {
                    List<ManagedChannelProvider> c10 = G.c(ManagedChannelProvider.class, getHardCodedClasses(), ManagedChannelProvider.class.getClassLoader(), new b(null));
                    f32335d = new ManagedChannelRegistry();
                    for (ManagedChannelProvider managedChannelProvider : c10) {
                        f32334c.fine("Service loader found " + managedChannelProvider);
                        f32335d.a(managedChannelProvider);
                    }
                    f32335d.d();
                }
                managedChannelRegistry = f32335d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return managedChannelRegistry;
    }

    public static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.okhttp.OkHttpChannelProvider"));
        } catch (ClassNotFoundException e10) {
            f32334c.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e10);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e11) {
            f32334c.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e11);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e12) {
            f32334c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e12);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(ManagedChannelProvider managedChannelProvider) {
        com.google.common.base.k.e(managedChannelProvider.d(), "isAvailable() returned false");
        this.f32336a.add(managedChannelProvider);
    }

    public ManagedChannelProvider c() {
        List<ManagedChannelProvider> providers = providers();
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    public final synchronized void d() {
        ArrayList arrayList = new ArrayList(this.f32336a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f32337b = Collections.unmodifiableList(arrayList);
    }

    public t<?> newChannelBuilder(x xVar, String str, AbstractC1195e abstractC1195e) {
        w wVar;
        Collection<Class<? extends SocketAddress>> emptySet;
        try {
            wVar = xVar.d(new URI(str).getScheme());
        } catch (URISyntaxException unused) {
            wVar = null;
        }
        if (wVar == null) {
            wVar = xVar.d(xVar.c());
        }
        if (wVar != null) {
            emptySet = wVar.c();
        } else {
            emptySet = Collections.emptySet();
        }
        if (!providers().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ManagedChannelProvider managedChannelProvider : providers()) {
                if (!managedChannelProvider.c().containsAll(emptySet)) {
                    sb.append("; ");
                    sb.append(managedChannelProvider.getClass().getName());
                    sb.append(": does not support 1 or more of ");
                    sb.append(Arrays.toString(emptySet.toArray()));
                } else {
                    ManagedChannelProvider.a e10 = managedChannelProvider.e(str, abstractC1195e);
                    if (e10.b() != null) {
                        return e10.b();
                    }
                    sb.append("; ");
                    sb.append(managedChannelProvider.getClass().getName());
                    sb.append(": ");
                    sb.append(e10.c());
                }
            }
            throw new ProviderNotFoundException(sb.substring(2));
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public synchronized List<ManagedChannelProvider> providers() {
        return this.f32337b;
    }
}
