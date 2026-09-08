package io.grpc.internal;

import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Set;

/* compiled from: HedgingPolicy.java */
/* loaded from: classes4.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final int f32476a;

    /* renamed from: b, reason: collision with root package name */
    public final long f32477b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Status.Code> f32478c;

    public D(int i10, long j10, Set<Status.Code> set) {
        this.f32476a = i10;
        this.f32477b = j10;
        this.f32478c = ImmutableSet.l(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || D.class != obj.getClass()) {
            return false;
        }
        D d10 = (D) obj;
        if (this.f32476a == d10.f32476a && this.f32477b == d10.f32477b && com.google.common.base.h.a(this.f32478c, d10.f32478c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return com.google.common.base.h.b(Integer.valueOf(this.f32476a), Long.valueOf(this.f32477b), this.f32478c);
    }

    public String toString() {
        return com.google.common.base.f.c(this).b("maxAttempts", this.f32476a).c("hedgingDelayNanos", this.f32477b).d("nonFatalStatusCodes", this.f32478c).toString();
    }
}
