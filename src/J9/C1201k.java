package j9;

import io.grpc.ConnectivityState;
import io.grpc.Status;

/* compiled from: ConnectivityStateInfo.java */
/* renamed from: j9.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1201k {

    /* renamed from: a, reason: collision with root package name */
    public final ConnectivityState f34025a;

    /* renamed from: b, reason: collision with root package name */
    public final Status f34026b;

    public C1201k(ConnectivityState connectivityState, Status status) {
        this.f34025a = (ConnectivityState) com.google.common.base.k.p(connectivityState, "state is null");
        this.f34026b = (Status) com.google.common.base.k.p(status, "status is null");
    }

    public static C1201k a(ConnectivityState connectivityState) {
        boolean z10;
        if (connectivityState != ConnectivityState.TRANSIENT_FAILURE) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.e(z10, "state is TRANSIENT_ERROR. Use forError() instead");
        return new C1201k(connectivityState, Status.f32368e);
    }

    public static C1201k b(Status status) {
        com.google.common.base.k.e(!status.o(), "The error status must not be OK");
        return new C1201k(ConnectivityState.TRANSIENT_FAILURE, status);
    }

    public ConnectivityState c() {
        return this.f34025a;
    }

    public Status d() {
        return this.f34026b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1201k)) {
            return false;
        }
        C1201k c1201k = (C1201k) obj;
        if (!this.f34025a.equals(c1201k.f34025a) || !this.f34026b.equals(c1201k.f34026b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f34026b.hashCode() ^ this.f34025a.hashCode();
    }

    public String toString() {
        if (this.f34026b.o()) {
            return this.f34025a.toString();
        }
        return this.f34025a + "(" + this.f34026b + ")";
    }
}
