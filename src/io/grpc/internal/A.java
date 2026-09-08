package io.grpc.internal;

import io.grpc.AbstractC1109c;
import io.grpc.C1108b;
import io.grpc.MethodDescriptor;
import j9.AbstractC1190B;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingManagedChannel.java */
/* loaded from: classes4.dex */
public abstract class A extends AbstractC1190B {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1190B f32453a;

    public A(AbstractC1190B abstractC1190B) {
        this.f32453a = abstractC1190B;
    }

    @Override // j9.AbstractC1194d
    public String a() {
        return this.f32453a.a();
    }

    @Override // j9.AbstractC1194d
    public <RequestT, ResponseT> AbstractC1109c<RequestT, ResponseT> b(MethodDescriptor<RequestT, ResponseT> methodDescriptor, C1108b c1108b) {
        return this.f32453a.b(methodDescriptor, c1108b);
    }

    @Override // j9.AbstractC1190B
    public boolean c(long j10, TimeUnit timeUnit) {
        return this.f32453a.c(j10, timeUnit);
    }

    @Override // j9.AbstractC1190B
    public AbstractC1190B d() {
        return this.f32453a.d();
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("delegate", this.f32453a).toString();
    }
}
