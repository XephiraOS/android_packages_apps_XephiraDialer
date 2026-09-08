package io.grpc;

import io.grpc.G;
import io.grpc.internal.X;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LoadBalancerRegistry.java */
/* loaded from: classes4.dex */
public final class s {

    /* renamed from: d, reason: collision with root package name */
    public static s f33462d;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<r> f33464a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, r> f33465b = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f33461c = Logger.getLogger(s.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final Iterable<Class<?>> f33463e = getHardCodedClasses();

    /* compiled from: LoadBalancerRegistry.java */
    /* loaded from: classes4.dex */
    public static final class a implements G.b<r> {
        @Override // io.grpc.G.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(r rVar) {
            return rVar.c();
        }

        @Override // io.grpc.G.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(r rVar) {
            return rVar.d();
        }
    }

    public static synchronized s b() {
        s sVar;
        synchronized (s.class) {
            try {
                if (f33462d == null) {
                    List<r> c10 = G.c(r.class, f33463e, r.class.getClassLoader(), new a());
                    f33462d = new s();
                    for (r rVar : c10) {
                        f33461c.fine("Service loader found " + rVar);
                        f33462d.a(rVar);
                    }
                    f33462d.d();
                }
                sVar = f33462d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z10 = X.f33003b;
            arrayList.add(X.class);
        } catch (ClassNotFoundException e10) {
            f33461c.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e10);
        }
        try {
            int i10 = io.grpc.util.i.f33629b;
            arrayList.add(io.grpc.util.i.class);
        } catch (ClassNotFoundException e11) {
            f33461c.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e11);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(r rVar) {
        com.google.common.base.k.e(rVar.d(), "isAvailable() returned false");
        this.f33464a.add(rVar);
    }

    public synchronized r c(String str) {
        return this.f33465b.get(com.google.common.base.k.p(str, "policy"));
    }

    public final synchronized void d() {
        try {
            this.f33465b.clear();
            Iterator<r> it = this.f33464a.iterator();
            while (it.hasNext()) {
                r next = it.next();
                String b10 = next.b();
                r rVar = this.f33465b.get(b10);
                if (rVar != null && rVar.c() >= next.c()) {
                }
                this.f33465b.put(b10, next);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Map<String, r> providers() {
        return new LinkedHashMap(this.f33465b);
    }
}
