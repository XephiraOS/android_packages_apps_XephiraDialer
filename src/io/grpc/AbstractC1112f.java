package io.grpc;

import io.grpc.C1108b;
import j9.M;

/* compiled from: ClientStreamTracer.java */
/* renamed from: io.grpc.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1112f extends M {

    /* renamed from: a, reason: collision with root package name */
    public static final C1108b.c<Long> f32442a = C1108b.c.b("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED");

    /* compiled from: ClientStreamTracer.java */
    /* renamed from: io.grpc.f$a */
    /* loaded from: classes4.dex */
    public static abstract class a {
        public AbstractC1112f a(b bVar, u uVar) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* compiled from: ClientStreamTracer.java */
    /* renamed from: io.grpc.f$b */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final C1108b f32443a;

        /* renamed from: b, reason: collision with root package name */
        public final int f32444b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f32445c;

        /* compiled from: ClientStreamTracer.java */
        /* renamed from: io.grpc.f$b$a */
        /* loaded from: classes4.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public C1108b f32446a = C1108b.f32416k;

            /* renamed from: b, reason: collision with root package name */
            public int f32447b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f32448c;

            public b a() {
                return new b(this.f32446a, this.f32447b, this.f32448c);
            }

            public a b(C1108b c1108b) {
                this.f32446a = (C1108b) com.google.common.base.k.p(c1108b, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z10) {
                this.f32448c = z10;
                return this;
            }

            public a d(int i10) {
                this.f32447b = i10;
                return this;
            }
        }

        public b(C1108b c1108b, int i10, boolean z10) {
            this.f32443a = (C1108b) com.google.common.base.k.p(c1108b, "callOptions");
            this.f32444b = i10;
            this.f32445c = z10;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("callOptions", this.f32443a).b("previousAttempts", this.f32444b).e("isTransparentRetry", this.f32445c).toString();
        }
    }

    public void i(u uVar) {
    }

    public void g() {
    }

    public void h() {
    }

    public void j() {
    }

    public void k(C1107a c1107a, u uVar) {
    }
}
