package io.grpc.internal;

import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Set;

/* compiled from: RetryPolicy.java */
/* loaded from: classes4.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f33140a;

    /* renamed from: b, reason: collision with root package name */
    public final long f33141b;

    /* renamed from: c, reason: collision with root package name */
    public final long f33142c;

    /* renamed from: d, reason: collision with root package name */
    public final double f33143d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f33144e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<Status.Code> f33145f;

    public d0(int i10, long j10, long j11, double d10, Long l10, Set<Status.Code> set) {
        this.f33140a = i10;
        this.f33141b = j10;
        this.f33142c = j11;
        this.f33143d = d10;
        this.f33144e = l10;
        this.f33145f = ImmutableSet.l(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (this.f33140a != d0Var.f33140a || this.f33141b != d0Var.f33141b || this.f33142c != d0Var.f33142c || Double.compare(this.f33143d, d0Var.f33143d) != 0 || !com.google.common.base.h.a(this.f33144e, d0Var.f33144e) || !com.google.common.base.h.a(this.f33145f, d0Var.f33145f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return com.google.common.base.h.b(Integer.valueOf(this.f33140a), Long.valueOf(this.f33141b), Long.valueOf(this.f33142c), Double.valueOf(this.f33143d), this.f33144e, this.f33145f);
    }

    public String toString() {
        return com.google.common.base.f.c(this).b("maxAttempts", this.f33140a).c("initialBackoffNanos", this.f33141b).c("maxBackoffNanos", this.f33142c).a("backoffMultiplier", this.f33143d).d("perAttemptRecvTimeoutNanos", this.f33144e).d("retryableStatusCodes", this.f33145f).toString();
    }
}
