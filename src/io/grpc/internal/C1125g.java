package io.grpc.internal;

/* compiled from: CallTracer.java */
/* renamed from: io.grpc.internal.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1125g {

    /* renamed from: f, reason: collision with root package name */
    public static final b f33168f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final v0 f33169a;

    /* renamed from: b, reason: collision with root package name */
    public final L f33170b = M.a();

    /* renamed from: c, reason: collision with root package name */
    public final L f33171c = M.a();

    /* renamed from: d, reason: collision with root package name */
    public final L f33172d = M.a();

    /* renamed from: e, reason: collision with root package name */
    public volatile long f33173e;

    /* compiled from: CallTracer.java */
    /* renamed from: io.grpc.internal.g$a */
    /* loaded from: classes4.dex */
    public class a implements b {
        @Override // io.grpc.internal.C1125g.b
        public C1125g create() {
            return new C1125g(v0.f33408a);
        }
    }

    /* compiled from: CallTracer.java */
    /* renamed from: io.grpc.internal.g$b */
    /* loaded from: classes4.dex */
    public interface b {
        C1125g create();
    }

    public C1125g(v0 v0Var) {
        this.f33169a = v0Var;
    }

    public static b a() {
        return f33168f;
    }

    public void b(boolean z10) {
        if (z10) {
            this.f33171c.a(1L);
        } else {
            this.f33172d.a(1L);
        }
    }

    public void c() {
        this.f33170b.a(1L);
        this.f33173e = this.f33169a.a();
    }
}
