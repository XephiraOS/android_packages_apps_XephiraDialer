package io.grpc.internal;

import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.c0;
import io.grpc.l;
import io.grpc.q;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ManagedChannelServiceConfig.java */
/* loaded from: classes4.dex */
public final class O {

    /* renamed from: a, reason: collision with root package name */
    public final b f32822a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, b> f32823b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, b> f32824c;

    /* renamed from: d, reason: collision with root package name */
    public final c0.D f32825d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f32826e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, ?> f32827f;

    /* compiled from: ManagedChannelServiceConfig.java */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: g, reason: collision with root package name */
        public static final C1108b.c<b> f32828g = C1108b.c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* renamed from: a, reason: collision with root package name */
        public final Long f32829a;

        /* renamed from: b, reason: collision with root package name */
        public final Boolean f32830b;

        /* renamed from: c, reason: collision with root package name */
        public final Integer f32831c;

        /* renamed from: d, reason: collision with root package name */
        public final Integer f32832d;

        /* renamed from: e, reason: collision with root package name */
        public final d0 f32833e;

        /* renamed from: f, reason: collision with root package name */
        public final D f32834f;

        public b(Map<String, ?> map, boolean z10, int i10, int i11) {
            Map<String, ?> map2;
            d0 b10;
            Map<String, ?> map3;
            boolean z11;
            this.f32829a = p0.v(map);
            this.f32830b = p0.w(map);
            Integer k10 = p0.k(map);
            this.f32831c = k10;
            if (k10 != null) {
                if (k10.intValue() >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                com.google.common.base.k.k(z11, "maxInboundMessageSize %s exceeds bounds", k10);
            }
            Integer j10 = p0.j(map);
            this.f32832d = j10;
            if (j10 != null) {
                com.google.common.base.k.k(j10.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", j10);
            }
            if (z10) {
                map2 = p0.q(map);
            } else {
                map2 = null;
            }
            if (map2 == null) {
                b10 = null;
            } else {
                b10 = b(map2, i10);
            }
            this.f32833e = b10;
            if (z10) {
                map3 = p0.d(map);
            } else {
                map3 = null;
            }
            this.f32834f = map3 != null ? a(map3, i11) : null;
        }

        public static D a(Map<String, ?> map, int i10) {
            boolean z10;
            int intValue = ((Integer) com.google.common.base.k.p(p0.g(map), "maxAttempts cannot be empty")).intValue();
            boolean z11 = false;
            if (intValue >= 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.h(z10, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i10);
            long longValue = ((Long) com.google.common.base.k.p(p0.c(map), "hedgingDelay cannot be empty")).longValue();
            if (longValue >= 0) {
                z11 = true;
            }
            com.google.common.base.k.j(z11, "hedgingDelay must not be negative: %s", longValue);
            return new D(min, longValue, p0.o(map));
        }

        public static d0 b(Map<String, ?> map, int i10) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            int intValue = ((Integer) com.google.common.base.k.p(p0.h(map), "maxAttempts cannot be empty")).intValue();
            boolean z15 = false;
            if (intValue >= 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.h(z10, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i10);
            long longValue = ((Long) com.google.common.base.k.p(p0.e(map), "initialBackoff cannot be empty")).longValue();
            if (longValue > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            com.google.common.base.k.j(z11, "initialBackoffNanos must be greater than 0: %s", longValue);
            long longValue2 = ((Long) com.google.common.base.k.p(p0.i(map), "maxBackoff cannot be empty")).longValue();
            if (longValue2 > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            com.google.common.base.k.j(z12, "maxBackoff must be greater than 0: %s", longValue2);
            Double d10 = (Double) com.google.common.base.k.p(p0.a(map), "backoffMultiplier cannot be empty");
            double doubleValue = d10.doubleValue();
            if (doubleValue > 0.0d) {
                z13 = true;
            } else {
                z13 = false;
            }
            com.google.common.base.k.k(z13, "backoffMultiplier must be greater than 0: %s", d10);
            Long p10 = p0.p(map);
            if (p10 != null && p10.longValue() < 0) {
                z14 = false;
            } else {
                z14 = true;
            }
            com.google.common.base.k.k(z14, "perAttemptRecvTimeout cannot be negative: %s", p10);
            Set<Status.Code> r10 = p0.r(map);
            if (p10 != null || !r10.isEmpty()) {
                z15 = true;
            }
            com.google.common.base.k.e(z15, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new d0(min, longValue, longValue2, doubleValue, p10, r10);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!com.google.common.base.h.a(this.f32829a, bVar.f32829a) || !com.google.common.base.h.a(this.f32830b, bVar.f32830b) || !com.google.common.base.h.a(this.f32831c, bVar.f32831c) || !com.google.common.base.h.a(this.f32832d, bVar.f32832d) || !com.google.common.base.h.a(this.f32833e, bVar.f32833e) || !com.google.common.base.h.a(this.f32834f, bVar.f32834f)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f32829a, this.f32830b, this.f32831c, this.f32832d, this.f32833e, this.f32834f);
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("timeoutNanos", this.f32829a).d("waitForReady", this.f32830b).d("maxInboundMessageSize", this.f32831c).d("maxOutboundMessageSize", this.f32832d).d("retryPolicy", this.f32833e).d("hedgingPolicy", this.f32834f).toString();
        }
    }

    /* compiled from: ManagedChannelServiceConfig.java */
    /* loaded from: classes4.dex */
    public static final class c extends io.grpc.l {

        /* renamed from: b, reason: collision with root package name */
        public final O f32835b;

        @Override // io.grpc.l
        public l.b a(q.g gVar) {
            return l.b.d().b(this.f32835b).a();
        }

        public c(O o10) {
            this.f32835b = o10;
        }
    }

    public O(b bVar, Map<String, b> map, Map<String, b> map2, c0.D d10, Object obj, Map<String, ?> map3) {
        Map<String, ?> map4;
        this.f32822a = bVar;
        this.f32823b = Collections.unmodifiableMap(new HashMap(map));
        this.f32824c = Collections.unmodifiableMap(new HashMap(map2));
        this.f32825d = d10;
        this.f32826e = obj;
        if (map3 != null) {
            map4 = Collections.unmodifiableMap(new HashMap(map3));
        } else {
            map4 = null;
        }
        this.f32827f = map4;
    }

    public static O a() {
        return new O(null, new HashMap(), new HashMap(), null, null, null);
    }

    public static O b(Map<String, ?> map, boolean z10, int i10, int i11, Object obj) {
        c0.D d10;
        if (z10) {
            d10 = p0.u(map);
        } else {
            d10 = null;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Map<String, ?> b10 = p0.b(map);
        List<Map<String, ?>> l10 = p0.l(map);
        if (l10 == null) {
            return new O(null, hashMap, hashMap2, d10, obj, b10);
        }
        b bVar = null;
        for (Map<String, ?> map2 : l10) {
            b bVar2 = new b(map2, z10, i10, i11);
            List<Map<String, ?>> n10 = p0.n(map2);
            if (n10 != null && !n10.isEmpty()) {
                for (Map<String, ?> map3 : n10) {
                    String s10 = p0.s(map3);
                    String m10 = p0.m(map3);
                    boolean z11 = true;
                    if (com.google.common.base.n.b(s10)) {
                        com.google.common.base.k.k(com.google.common.base.n.b(m10), "missing service name for method %s", m10);
                        if (bVar != null) {
                            z11 = false;
                        }
                        com.google.common.base.k.k(z11, "Duplicate default method config in service config %s", map);
                        bVar = bVar2;
                    } else if (com.google.common.base.n.b(m10)) {
                        com.google.common.base.k.k(!hashMap2.containsKey(s10), "Duplicate service %s", s10);
                        hashMap2.put(s10, bVar2);
                    } else {
                        String b11 = MethodDescriptor.b(s10, m10);
                        com.google.common.base.k.k(!hashMap.containsKey(b11), "Duplicate method name %s", b11);
                        hashMap.put(b11, bVar2);
                    }
                }
            }
        }
        return new O(bVar, hashMap, hashMap2, d10, obj, b10);
    }

    public io.grpc.l c() {
        if (this.f32824c.isEmpty() && this.f32823b.isEmpty() && this.f32822a == null) {
            return null;
        }
        return new c();
    }

    public Map<String, ?> d() {
        return this.f32827f;
    }

    public b e(MethodDescriptor<?, ?> methodDescriptor) {
        b bVar = this.f32823b.get(methodDescriptor.c());
        if (bVar == null) {
            bVar = this.f32824c.get(methodDescriptor.d());
        }
        if (bVar == null) {
            return this.f32822a;
        }
        return bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || O.class != obj.getClass()) {
            return false;
        }
        O o10 = (O) obj;
        if (com.google.common.base.h.a(this.f32822a, o10.f32822a) && com.google.common.base.h.a(this.f32823b, o10.f32823b) && com.google.common.base.h.a(this.f32824c, o10.f32824c) && com.google.common.base.h.a(this.f32825d, o10.f32825d) && com.google.common.base.h.a(this.f32826e, o10.f32826e)) {
            return true;
        }
        return false;
    }

    public c0.D f() {
        return this.f32825d;
    }

    public Object getLoadBalancingConfig() {
        return this.f32826e;
    }

    public int hashCode() {
        return com.google.common.base.h.b(this.f32822a, this.f32823b, this.f32824c, this.f32825d, this.f32826e);
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("defaultMethodConfig", this.f32822a).d("serviceMethodMap", this.f32823b).d("serviceMap", this.f32824c).d("retryThrottling", this.f32825d).d("loadBalancingConfig", this.f32826e).toString();
    }
}
