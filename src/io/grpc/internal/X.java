package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.W;
import io.grpc.q;
import io.grpc.v;
import java.util.Map;

/* compiled from: PickFirstLoadBalancerProvider.java */
/* loaded from: classes4.dex */
public final class X extends io.grpc.r {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f33003b;

    static {
        boolean z10;
        if (!com.google.common.base.n.b(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST")) && Boolean.parseBoolean(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST"))) {
            z10 = true;
        } else {
            z10 = false;
        }
        f33003b = z10;
    }

    @Override // io.grpc.q.c
    public io.grpc.q a(q.e eVar) {
        if (f33003b) {
            return new PickFirstLeafLoadBalancer(eVar);
        }
        return new W(eVar);
    }

    @Override // io.grpc.r
    public String b() {
        return "pick_first";
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
            return v.c.a(new W.c(J.d(map, "shuffleAddressList")));
        } catch (RuntimeException e10) {
            return v.c.b(Status.f32383t.q(e10).r("Failed parsing configuration for " + this.b()));
        }
    }
}
