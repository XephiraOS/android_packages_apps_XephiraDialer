package io.grpc.util;

import io.grpc.q;
import io.grpc.r;
import io.grpc.v;
import java.util.Map;

/* compiled from: SecretRoundRobinLoadBalancerProvider.java */
/* loaded from: classes4.dex */
public final class i extends r {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f33629b = 0;

    @Override // io.grpc.q.c
    public q a(q.e eVar) {
        return new RoundRobinLoadBalancer(eVar);
    }

    @Override // io.grpc.r
    public String b() {
        return "round_robin";
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
        return v.c.a("no service config");
    }
}
