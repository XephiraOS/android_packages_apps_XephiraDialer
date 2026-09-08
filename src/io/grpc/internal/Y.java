package io.grpc.internal;

import com.oplus.backup.sdk.common.utils.Constants;
import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import io.grpc.q;

/* compiled from: PickSubchannelArgsImpl.java */
/* loaded from: classes4.dex */
public final class Y extends q.g {

    /* renamed from: a, reason: collision with root package name */
    public final C1108b f33004a;

    /* renamed from: b, reason: collision with root package name */
    public final io.grpc.u f33005b;

    /* renamed from: c, reason: collision with root package name */
    public final MethodDescriptor<?, ?> f33006c;

    public Y(MethodDescriptor<?, ?> methodDescriptor, io.grpc.u uVar, C1108b c1108b) {
        this.f33006c = (MethodDescriptor) com.google.common.base.k.p(methodDescriptor, Constants.MessagerConstants.METHOD_KEY);
        this.f33005b = (io.grpc.u) com.google.common.base.k.p(uVar, "headers");
        this.f33004a = (C1108b) com.google.common.base.k.p(c1108b, "callOptions");
    }

    @Override // io.grpc.q.g
    public C1108b a() {
        return this.f33004a;
    }

    @Override // io.grpc.q.g
    public io.grpc.u b() {
        return this.f33005b;
    }

    @Override // io.grpc.q.g
    public MethodDescriptor<?, ?> c() {
        return this.f33006c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Y.class != obj.getClass()) {
            return false;
        }
        Y y10 = (Y) obj;
        if (com.google.common.base.h.a(this.f33004a, y10.f33004a) && com.google.common.base.h.a(this.f33005b, y10.f33005b) && com.google.common.base.h.a(this.f33006c, y10.f33006c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return com.google.common.base.h.b(this.f33004a, this.f33005b, this.f33006c);
    }

    public final String toString() {
        return "[method=" + this.f33006c + " headers=" + this.f33005b + " callOptions=" + this.f33004a + "]";
    }
}
