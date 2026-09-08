package io.grpc.util;

import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.q;
import j9.N;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: ForwardingLoadBalancerHelper.java */
/* loaded from: classes4.dex */
public abstract class c extends q.e {
    @Override // io.grpc.q.e
    public q.i a(q.b bVar) {
        return g().a(bVar);
    }

    @Override // io.grpc.q.e
    public ChannelLogger b() {
        return g().b();
    }

    @Override // io.grpc.q.e
    public ScheduledExecutorService c() {
        return g().c();
    }

    @Override // io.grpc.q.e
    public N d() {
        return g().d();
    }

    @Override // io.grpc.q.e
    public void e() {
        g().e();
    }

    @Override // io.grpc.q.e
    public void f(ConnectivityState connectivityState, q.j jVar) {
        g().f(connectivityState, jVar);
    }

    public abstract q.e g();

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", g()).toString();
    }
}
