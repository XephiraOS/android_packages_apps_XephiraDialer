package io.grpc.internal;

import io.grpc.Status;
import io.grpc.v;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ScParser extends v.h {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f32881a;

    /* renamed from: b, reason: collision with root package name */
    public final int f32882b;

    /* renamed from: c, reason: collision with root package name */
    public final int f32883c;

    /* renamed from: d, reason: collision with root package name */
    public final AutoConfiguredLoadBalancerFactory f32884d;

    public ScParser(boolean z10, int i10, int i11, AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory) {
        this.f32881a = z10;
        this.f32882b = i10;
        this.f32883c = i11;
        this.f32884d = (AutoConfiguredLoadBalancerFactory) com.google.common.base.k.p(autoConfiguredLoadBalancerFactory, "autoLoadBalancerFactory");
    }

    @Override // io.grpc.v.h
    public v.c a(Map<String, ?> map) {
        Object c10;
        try {
            v.c f10 = this.f32884d.f(map);
            if (f10 == null) {
                c10 = null;
            } else {
                if (f10.d() != null) {
                    return v.c.b(f10.d());
                }
                c10 = f10.c();
            }
            return v.c.a(O.b(map, this.f32881a, this.f32882b, this.f32883c, c10));
        } catch (RuntimeException e10) {
            return v.c.b(Status.f32370g.r("failed to parse service config").q(e10));
        }
    }
}
