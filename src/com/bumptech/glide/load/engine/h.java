package com.bumptech.glide.load.engine;

import s3.C1540k;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
public class h<Z> implements Z2.j<Z> {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f19598a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19599b;

    /* renamed from: c, reason: collision with root package name */
    public final Z2.j<Z> f19600c;

    /* renamed from: d, reason: collision with root package name */
    public final a f19601d;

    /* renamed from: e, reason: collision with root package name */
    public final X2.b f19602e;

    /* renamed from: f, reason: collision with root package name */
    public int f19603f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19604g;

    /* compiled from: EngineResource.java */
    /* loaded from: classes.dex */
    public interface a {
        void d(X2.b bVar, h<?> hVar);
    }

    public h(Z2.j<Z> jVar, boolean z10, boolean z11, X2.b bVar, a aVar) {
        this.f19600c = (Z2.j) C1540k.d(jVar);
        this.f19598a = z10;
        this.f19599b = z11;
        this.f19602e = bVar;
        this.f19601d = (a) C1540k.d(aVar);
    }

    public synchronized void a() {
        if (!this.f19604g) {
            this.f19603f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // Z2.j
    public synchronized void b() {
        if (this.f19603f <= 0) {
            if (!this.f19604g) {
                this.f19604g = true;
                if (this.f19599b) {
                    this.f19600c.b();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    @Override // Z2.j
    public int c() {
        return this.f19600c.c();
    }

    @Override // Z2.j
    public Class<Z> d() {
        return this.f19600c.d();
    }

    public Z2.j<Z> e() {
        return this.f19600c;
    }

    public boolean f() {
        return this.f19598a;
    }

    public void g() {
        boolean z10;
        synchronized (this) {
            int i10 = this.f19603f;
            if (i10 > 0) {
                z10 = true;
                int i11 = i10 - 1;
                this.f19603f = i11;
                if (i11 != 0) {
                    z10 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z10) {
            this.f19601d.d(this.f19602e, this);
        }
    }

    @Override // Z2.j
    public Z get() {
        return this.f19600c.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f19598a + ", listener=" + this.f19601d + ", key=" + this.f19602e + ", acquired=" + this.f19603f + ", isRecycled=" + this.f19604g + ", resource=" + this.f19600c + '}';
    }
}
