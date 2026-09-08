package io.grpc.internal;

import io.grpc.internal.InterfaceC1117c;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* compiled from: ExponentialBackoffPolicy.java */
/* renamed from: io.grpc.internal.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1137t implements InterfaceC1117c {

    /* renamed from: a, reason: collision with root package name */
    public Random f33397a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public long f33398b = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: c, reason: collision with root package name */
    public long f33399c = TimeUnit.MINUTES.toNanos(2);

    /* renamed from: d, reason: collision with root package name */
    public double f33400d = 1.6d;

    /* renamed from: e, reason: collision with root package name */
    public double f33401e = 0.2d;

    /* renamed from: f, reason: collision with root package name */
    public long f33402f = this.f33398b;

    /* compiled from: ExponentialBackoffPolicy.java */
    /* renamed from: io.grpc.internal.t$a */
    /* loaded from: classes4.dex */
    public static final class a implements InterfaceC1117c.a {
        @Override // io.grpc.internal.InterfaceC1117c.a
        public InterfaceC1117c get() {
            return new C1137t();
        }
    }

    @Override // io.grpc.internal.InterfaceC1117c
    public long a() {
        long j10 = this.f33402f;
        double d10 = j10;
        this.f33402f = Math.min((long) (this.f33400d * d10), this.f33399c);
        double d11 = this.f33401e;
        return j10 + b((-d11) * d10, d11 * d10);
    }

    public final long b(double d10, double d11) {
        boolean z10;
        if (d11 >= d10) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.d(z10);
        return (long) ((this.f33397a.nextDouble() * (d11 - d10)) + d10);
    }

    public C1137t setInitialBackoffNanos(long j10) {
        this.f33398b = j10;
        return this;
    }

    public C1137t setJitter(double d10) {
        this.f33401e = d10;
        return this;
    }

    public C1137t setMaxBackoffNanos(long j10) {
        this.f33399c = j10;
        return this;
    }

    public C1137t setMultiplier(double d10) {
        this.f33400d = d10;
        return this;
    }

    public C1137t setRandom(Random random) {
        this.f33397a = random;
        return this;
    }
}
