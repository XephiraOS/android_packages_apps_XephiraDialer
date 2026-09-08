package io.grpc.internal;

import io.grpc.internal.InterfaceC1117c;
import j9.N;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: BackoffPolicyRetryScheduler.java */
/* renamed from: io.grpc.internal.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1123e implements e0 {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f33146f = Logger.getLogger(C1123e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f33147a;

    /* renamed from: b, reason: collision with root package name */
    public final j9.N f33148b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1117c.a f33149c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC1117c f33150d;

    /* renamed from: e, reason: collision with root package name */
    public N.d f33151e;

    public C1123e(InterfaceC1117c.a aVar, ScheduledExecutorService scheduledExecutorService, j9.N n10) {
        this.f33149c = aVar;
        this.f33147a = scheduledExecutorService;
        this.f33148b = n10;
    }

    @Override // io.grpc.internal.e0
    public void a(Runnable runnable) {
        this.f33148b.e();
        if (this.f33150d == null) {
            this.f33150d = this.f33149c.get();
        }
        N.d dVar = this.f33151e;
        if (dVar != null && dVar.b()) {
            return;
        }
        long a10 = this.f33150d.a();
        this.f33151e = this.f33148b.c(runnable, a10, TimeUnit.NANOSECONDS, this.f33147a);
        f33146f.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(a10));
    }

    public final /* synthetic */ void c() {
        N.d dVar = this.f33151e;
        if (dVar != null && dVar.b()) {
            this.f33151e.a();
        }
        this.f33150d = null;
    }

    @Override // io.grpc.internal.e0
    public void reset() {
        this.f33148b.e();
        this.f33148b.execute(new Runnable() { // from class: io.grpc.internal.d
            @Override // java.lang.Runnable
            public final void run() {
                C1123e.this.c();
            }
        });
    }
}
