package io.grpc.util;

import io.grpc.Status;
import io.grpc.q;

/* compiled from: ForwardingLoadBalancer.java */
/* loaded from: classes4.dex */
public abstract class b extends q {
    @Override // io.grpc.q
    public boolean b() {
        return g().b();
    }

    @Override // io.grpc.q
    public void c(Status status) {
        g().c(status);
    }

    @Override // io.grpc.q
    public void d(q.h hVar) {
        g().d(hVar);
    }

    @Override // io.grpc.q
    public void e() {
        g().e();
    }

    public abstract q g();

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", g()).toString();
    }
}
