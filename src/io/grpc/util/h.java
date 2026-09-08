package io.grpc.util;

import io.grpc.Status;
import io.grpc.internal.J;
import io.grpc.internal.p0;
import io.grpc.internal.v0;
import io.grpc.q;
import io.grpc.r;
import io.grpc.s;
import io.grpc.util.g;
import io.grpc.v;
import java.util.List;
import java.util.Map;

/* compiled from: OutlierDetectionLoadBalancerProvider.java */
/* loaded from: classes4.dex */
public final class h extends r {
    @Override // io.grpc.q.c
    public q a(q.e eVar) {
        return new g(eVar, v0.f33408a);
    }

    @Override // io.grpc.r
    public String b() {
        return "outlier_detection_experimental";
    }

    @Override // io.grpc.r
    public int c() {
        return 5;
    }

    @Override // io.grpc.r
    public boolean d() {
        return true;
    }

    @Override // io.grpc.r
    public v.c e(Map<String, ?> map) {
        try {
            return f(map);
        } catch (RuntimeException e10) {
            return v.c.b(Status.f32383t.q(e10).r("Failed parsing configuration for " + this.b()));
        }
    }

    public final v.c f(Map<String, ?> map) {
        Long l10 = J.l(map, "interval");
        Long l11 = J.l(map, "baseEjectionTime");
        Long l12 = J.l(map, "maxEjectionTime");
        Integer i10 = J.i(map, "maxEjectionPercentage");
        g.C0316g.a aVar = new g.C0316g.a();
        if (l10 != null) {
            aVar.e(l10);
        }
        if (l11 != null) {
            aVar.b(l11);
        }
        if (l12 != null) {
            aVar.g(l12);
        }
        if (i10 != null) {
            aVar.f(i10);
        }
        Map<String, ?> j10 = J.j(map, "successRateEjection");
        if (j10 != null) {
            g.C0316g.c.a aVar2 = new g.C0316g.c.a();
            Integer i11 = J.i(j10, "stdevFactor");
            Integer i12 = J.i(j10, "enforcementPercentage");
            Integer i13 = J.i(j10, "minimumHosts");
            Integer i14 = J.i(j10, "requestVolume");
            if (i11 != null) {
                aVar2.e(i11);
            }
            if (i12 != null) {
                aVar2.b(i12);
            }
            if (i13 != null) {
                aVar2.c(i13);
            }
            if (i14 != null) {
                aVar2.d(i14);
            }
            aVar.h(aVar2.a());
        }
        Map<String, ?> j11 = J.j(map, "failurePercentageEjection");
        if (j11 != null) {
            g.C0316g.b.a aVar3 = new g.C0316g.b.a();
            Integer i15 = J.i(j11, "threshold");
            Integer i16 = J.i(j11, "enforcementPercentage");
            Integer i17 = J.i(j11, "minimumHosts");
            Integer i18 = J.i(j11, "requestVolume");
            if (i15 != null) {
                aVar3.e(i15);
            }
            if (i16 != null) {
                aVar3.b(i16);
            }
            if (i17 != null) {
                aVar3.c(i17);
            }
            if (i18 != null) {
                aVar3.d(i18);
            }
            aVar.d(aVar3.a());
        }
        List<p0.a> z10 = p0.z(J.f(map, "childPolicy"));
        if (z10 != null && !z10.isEmpty()) {
            v.c x10 = p0.x(z10, s.b());
            if (x10.d() != null) {
                return x10;
            }
            aVar.c((p0.b) x10.c());
            return v.c.a(aVar.a());
        }
        return v.c.b(Status.f32382s.r("No child policy in outlier_detection_experimental LB policy: " + map));
    }
}
