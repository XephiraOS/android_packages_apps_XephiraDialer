package io.grpc;

import com.google.common.collect.ImmutableMap;
import io.grpc.G;
import io.grpc.internal.C1136s;
import io.grpc.v;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: NameResolverRegistry.java */
/* loaded from: classes4.dex */
public final class x {

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f33656e = Logger.getLogger(x.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static x f33657f;

    /* renamed from: a, reason: collision with root package name */
    public final v.d f33658a = new b();

    /* renamed from: b, reason: collision with root package name */
    public String f33659b = "unknown";

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<w> f33660c = new LinkedHashSet<>();

    /* renamed from: d, reason: collision with root package name */
    public ImmutableMap<String, w> f33661d = ImmutableMap.l();

    /* compiled from: NameResolverRegistry.java */
    /* loaded from: classes4.dex */
    public final class b extends v.d {
        public b() {
        }

        @Override // io.grpc.v.d
        public String a() {
            return x.this.c();
        }

        @Override // io.grpc.v.d
        public v b(URI uri, v.b bVar) {
            w d10 = x.this.d(uri.getScheme());
            if (d10 == null) {
                return null;
            }
            return d10.b(uri, bVar);
        }
    }

    /* compiled from: NameResolverRegistry.java */
    /* loaded from: classes4.dex */
    public static final class c implements G.b<w> {
        public c() {
        }

        @Override // io.grpc.G.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(w wVar) {
            return wVar.f();
        }

        @Override // io.grpc.G.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(w wVar) {
            return wVar.e();
        }
    }

    public static synchronized x b() {
        x xVar;
        synchronized (x.class) {
            try {
                if (f33657f == null) {
                    List<w> c10 = G.c(w.class, getHardCodedClasses(), w.class.getClassLoader(), new c());
                    if (c10.isEmpty()) {
                        f33656e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                    }
                    f33657f = new x();
                    for (w wVar : c10) {
                        f33656e.fine("Service loader found " + wVar);
                        f33657f.a(wVar);
                    }
                    f33657f.e();
                }
                xVar = f33657f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    public static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z10 = C1136s.f33393a;
            arrayList.add(C1136s.class);
        } catch (ClassNotFoundException e10) {
            f33656e.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(w wVar) {
        com.google.common.base.k.e(wVar.e(), "isAvailable() returned false");
        this.f33660c.add(wVar);
    }

    public synchronized String c() {
        return this.f33659b;
    }

    public w d(String str) {
        if (str == null) {
            return null;
        }
        return providers().get(str.toLowerCase(Locale.US));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0010 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void e() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> L33
            r0.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = "unknown"
            java.util.LinkedHashSet<io.grpc.w> r2 = r9.f33660c     // Catch: java.lang.Throwable -> L33
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L33
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
        L10:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L33
            if (r4 == 0) goto L4a
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L33
            io.grpc.w r4 = (io.grpc.w) r4     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = r4.d()     // Catch: java.lang.Throwable -> L33
            java.lang.Object r6 = r0.get(r5)     // Catch: java.lang.Throwable -> L33
            io.grpc.w r6 = (io.grpc.w) r6     // Catch: java.lang.Throwable -> L33
            if (r6 == 0) goto L35
            int r6 = r6.f()     // Catch: java.lang.Throwable -> L33
            int r7 = r4.f()     // Catch: java.lang.Throwable -> L33
            if (r6 >= r7) goto L38
            goto L35
        L33:
            r0 = move-exception
            goto L54
        L35:
            r0.put(r5, r4)     // Catch: java.lang.Throwable -> L33
        L38:
            int r5 = r4.f()     // Catch: java.lang.Throwable -> L33
            if (r3 >= r5) goto L10
            int r1 = r4.f()     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r4.d()     // Catch: java.lang.Throwable -> L33
            r8 = r3
            r3 = r1
            r1 = r8
            goto L10
        L4a:
            com.google.common.collect.ImmutableMap r0 = com.google.common.collect.ImmutableMap.d(r0)     // Catch: java.lang.Throwable -> L33
            r9.f33661d = r0     // Catch: java.lang.Throwable -> L33
            r9.f33659b = r1     // Catch: java.lang.Throwable -> L33
            monitor-exit(r9)
            return
        L54:
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.x.e():void");
    }

    public synchronized void f(w wVar) {
        a(wVar);
        e();
    }

    public synchronized Map<String, w> providers() {
        return this.f33661d;
    }
}
