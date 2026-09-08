package io.grpc.internal;

import io.grpc.AbstractC1109c;
import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.C1127i;
import io.grpc.q;
import j9.AbstractC1190B;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* compiled from: OobChannel.java */
/* loaded from: classes4.dex */
public final class V extends AbstractC1190B implements j9.v<Object> {

    /* renamed from: l, reason: collision with root package name */
    public static final Logger f32978l = Logger.getLogger(V.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public InternalSubchannel f32979a;

    /* renamed from: b, reason: collision with root package name */
    public AbstractC1115a f32980b;

    /* renamed from: c, reason: collision with root package name */
    public final j9.w f32981c;

    /* renamed from: d, reason: collision with root package name */
    public final String f32982d;

    /* renamed from: e, reason: collision with root package name */
    public final C1135q f32983e;

    /* renamed from: f, reason: collision with root package name */
    public final Executor f32984f;

    /* renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f32985g;

    /* renamed from: h, reason: collision with root package name */
    public final CountDownLatch f32986h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f32987i;

    /* renamed from: j, reason: collision with root package name */
    public final C1125g f32988j;

    /* renamed from: k, reason: collision with root package name */
    public final C1127i.e f32989k;

    @Override // j9.AbstractC1194d
    public String a() {
        return this.f32982d;
    }

    @Override // j9.AbstractC1194d
    public <RequestT, ResponseT> AbstractC1109c<RequestT, ResponseT> b(MethodDescriptor<RequestT, ResponseT> methodDescriptor, C1108b c1108b) {
        Executor e10;
        if (c1108b.e() == null) {
            e10 = this.f32984f;
        } else {
            e10 = c1108b.e();
        }
        return new C1127i(methodDescriptor, e10, c1108b, this.f32989k, this.f32985g, this.f32988j, null);
    }

    @Override // j9.AbstractC1190B
    public boolean c(long j10, TimeUnit timeUnit) {
        return this.f32986h.await(j10, timeUnit);
    }

    @Override // j9.AbstractC1190B
    public AbstractC1190B d() {
        this.f32987i = true;
        this.f32983e.shutdownNow(Status.f32383t.r("OobChannel.shutdownNow() called"));
        return this;
    }

    public InternalSubchannel e() {
        return this.f32979a;
    }

    @Override // j9.z
    public j9.w getLogId() {
        return this.f32981c;
    }

    public q.i getSubchannel() {
        return this.f32980b;
    }

    public String toString() {
        return com.google.common.base.f.c(this).c("logId", this.f32981c.d()).d("authority", this.f32982d).toString();
    }
}
