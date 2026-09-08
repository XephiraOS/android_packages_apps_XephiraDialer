package io.grpc.internal;

import com.google.common.base.VerifyException;
import com.oplus.backup.sdk.common.utils.Constants;
import io.grpc.Status;
import io.grpc.internal.c0;
import io.grpc.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ServiceConfigUtil.java */
/* loaded from: classes4.dex */
public final class p0 {

    /* compiled from: ServiceConfigUtil.java */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f33308a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, ?> f33309b;

        public a(String str, Map<String, ?> map) {
            this.f33308a = (String) com.google.common.base.k.p(str, "policyName");
            this.f33309b = (Map) com.google.common.base.k.p(map, "rawConfigValue");
        }

        public String a() {
            return this.f33308a;
        }

        public Map<String, ?> b() {
            return this.f33309b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f33308a.equals(aVar.f33308a) || !this.f33309b.equals(aVar.f33309b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f33308a, this.f33309b);
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("policyName", this.f33308a).d("rawConfigValue", this.f33309b).toString();
        }
    }

    /* compiled from: ServiceConfigUtil.java */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final io.grpc.r f33310a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f33311b;

        public b(io.grpc.r rVar, Object obj) {
            this.f33310a = (io.grpc.r) com.google.common.base.k.p(rVar, "provider");
            this.f33311b = obj;
        }

        public Object a() {
            return this.f33311b;
        }

        public io.grpc.r b() {
            return this.f33310a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (com.google.common.base.h.a(this.f33310a, bVar.f33310a) && com.google.common.base.h.a(this.f33311b, bVar.f33311b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f33310a, this.f33311b);
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("provider", this.f33310a).d(Constants.MessagerConstants.CONFIG_KEY, this.f33311b).toString();
        }
    }

    public static Double a(Map<String, ?> map) {
        return J.h(map, "backoffMultiplier");
    }

    public static Map<String, ?> b(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        return J.j(map, "healthCheckConfig");
    }

    public static Long c(Map<String, ?> map) {
        return J.l(map, "hedgingDelay");
    }

    public static Map<String, ?> d(Map<String, ?> map) {
        return J.j(map, "hedgingPolicy");
    }

    public static Long e(Map<String, ?> map) {
        return J.l(map, "initialBackoff");
    }

    public static Set<Status.Code> f(Map<String, ?> map, String str) {
        List<?> e10 = J.e(map, str);
        if (e10 == null) {
            return null;
        }
        return t(e10);
    }

    public static Integer g(Map<String, ?> map) {
        return J.i(map, "maxAttempts");
    }

    public static List<Map<String, ?>> getLoadBalancingConfigsFromServiceConfig(Map<String, ?> map) {
        String k10;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(J.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (k10 = J.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(k10.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Integer h(Map<String, ?> map) {
        return J.i(map, "maxAttempts");
    }

    public static Long i(Map<String, ?> map) {
        return J.l(map, "maxBackoff");
    }

    public static Integer j(Map<String, ?> map) {
        return J.i(map, "maxRequestMessageBytes");
    }

    public static Integer k(Map<String, ?> map) {
        return J.i(map, "maxResponseMessageBytes");
    }

    public static List<Map<String, ?>> l(Map<String, ?> map) {
        return J.f(map, "methodConfig");
    }

    public static String m(Map<String, ?> map) {
        return J.k(map, Constants.MessagerConstants.METHOD_KEY);
    }

    public static List<Map<String, ?>> n(Map<String, ?> map) {
        return J.f(map, "name");
    }

    public static Set<Status.Code> o(Map<String, ?> map) {
        Set<Status.Code> f10 = f(map, "nonFatalStatusCodes");
        if (f10 == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(Status.Code.class));
        }
        com.google.common.base.s.a(!f10.contains(Status.Code.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return f10;
    }

    public static Long p(Map<String, ?> map) {
        return J.l(map, "perAttemptRecvTimeout");
    }

    public static Map<String, ?> q(Map<String, ?> map) {
        return J.j(map, "retryPolicy");
    }

    public static Set<Status.Code> r(Map<String, ?> map) {
        boolean z10;
        Set<Status.Code> f10 = f(map, "retryableStatusCodes");
        if (f10 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.s.a(z10, "%s is required in retry policy", "retryableStatusCodes");
        com.google.common.base.s.a(true ^ f10.contains(Status.Code.OK), "%s must not contain OK", "retryableStatusCodes");
        return f10;
    }

    public static String s(Map<String, ?> map) {
        return J.k(map, "service");
    }

    public static Set<Status.Code> t(List<?> list) {
        Status.Code valueOf;
        boolean z10;
        EnumSet noneOf = EnumSet.noneOf(Status.Code.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d10 = (Double) obj;
                int intValue = d10.intValue();
                boolean z11 = false;
                if (intValue == d10.doubleValue()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.s.a(z10, "Status code %s is not integral", obj);
                valueOf = Status.h(intValue).m();
                if (valueOf.c() == d10.intValue()) {
                    z11 = true;
                }
                com.google.common.base.s.a(z11, "Status code %s is not valid", obj);
            } else if (obj instanceof String) {
                try {
                    valueOf = Status.Code.valueOf((String) obj);
                } catch (IllegalArgumentException e10) {
                    throw new VerifyException("Status code " + obj + " is not valid", e10);
                }
            } else {
                throw new VerifyException("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
            }
            noneOf.add(valueOf);
        }
        return Collections.unmodifiableSet(noneOf);
    }

    public static c0.D u(Map<String, ?> map) {
        Map<String, ?> j10;
        boolean z10;
        if (map == null || (j10 = J.j(map, "retryThrottling")) == null) {
            return null;
        }
        float floatValue = J.h(j10, "maxTokens").floatValue();
        float floatValue2 = J.h(j10, "tokenRatio").floatValue();
        boolean z11 = false;
        if (floatValue > 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "maxToken should be greater than zero");
        if (floatValue2 > 0.0f) {
            z11 = true;
        }
        com.google.common.base.k.v(z11, "tokenRatio should be greater than zero");
        return new c0.D(floatValue, floatValue2);
    }

    public static Long v(Map<String, ?> map) {
        return J.l(map, "timeout");
    }

    public static Boolean w(Map<String, ?> map) {
        return J.d(map, "waitForReady");
    }

    public static v.c x(List<a> list, io.grpc.s sVar) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            String a10 = aVar.a();
            io.grpc.r c10 = sVar.c(a10);
            if (c10 == null) {
                arrayList.add(a10);
            } else {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(p0.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                v.c e10 = c10.e(aVar.b());
                if (e10.d() != null) {
                    return e10;
                }
                return v.c.a(new b(c10, e10.c()));
            }
        }
        return v.c.b(Status.f32370g.r("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a y(Map<String, ?> map) {
        if (map.size() == 1) {
            String key = map.entrySet().iterator().next().getKey();
            return new a(key, J.j(map, key));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }

    public static List<a> z(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, ?>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(y(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }
}
