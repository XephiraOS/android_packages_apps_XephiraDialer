package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.C1108b;
import io.grpc.Context;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import j9.AbstractC1193c;

/* compiled from: MetadataApplierImpl.java */
/* loaded from: classes4.dex */
public final class Q extends AbstractC1193c.a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1129k f32861a;

    /* renamed from: b, reason: collision with root package name */
    public final MethodDescriptor<?, ?> f32862b;

    /* renamed from: c, reason: collision with root package name */
    public final io.grpc.u f32863c;

    /* renamed from: d, reason: collision with root package name */
    public final C1108b f32864d;

    /* renamed from: f, reason: collision with root package name */
    public final a f32866f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC1112f[] f32867g;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceC1128j f32869i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f32870j;

    /* renamed from: k, reason: collision with root package name */
    public r f32871k;

    /* renamed from: h, reason: collision with root package name */
    public final Object f32868h = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final Context f32865e = Context.l();

    /* compiled from: MetadataApplierImpl.java */
    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    public Q(InterfaceC1129k interfaceC1129k, MethodDescriptor<?, ?> methodDescriptor, io.grpc.u uVar, C1108b c1108b, a aVar, AbstractC1112f[] abstractC1112fArr) {
        this.f32861a = interfaceC1129k;
        this.f32862b = methodDescriptor;
        this.f32863c = uVar;
        this.f32864d = c1108b;
        this.f32866f = aVar;
        this.f32867g = abstractC1112fArr;
    }

    public void a(Status status) {
        com.google.common.base.k.e(!status.o(), "Cannot fail with OK status");
        com.google.common.base.k.v(!this.f32870j, "apply() or fail() already called");
        b(new C1138u(GrpcUtil.l(status), this.f32867g));
    }

    public final void b(InterfaceC1128j interfaceC1128j) {
        boolean z10;
        boolean z11 = true;
        com.google.common.base.k.v(!this.f32870j, "already finalized");
        this.f32870j = true;
        synchronized (this.f32868h) {
            try {
                if (this.f32869i == null) {
                    this.f32869i = interfaceC1128j;
                    z10 = true;
                } else {
                    z10 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            this.f32866f.a();
            return;
        }
        if (this.f32871k == null) {
            z11 = false;
        }
        com.google.common.base.k.v(z11, "delayedStream is null");
        Runnable h10 = this.f32871k.h(interfaceC1128j);
        if (h10 != null) {
            h10.run();
        }
        this.f32866f.a();
    }

    public InterfaceC1128j c() {
        synchronized (this.f32868h) {
            try {
                InterfaceC1128j interfaceC1128j = this.f32869i;
                if (interfaceC1128j == null) {
                    r rVar = new r();
                    this.f32871k = rVar;
                    this.f32869i = rVar;
                    return rVar;
                }
                return interfaceC1128j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
