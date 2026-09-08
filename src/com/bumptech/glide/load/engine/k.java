package com.bumptech.glide.load.engine;

import android.util.Log;
import b3.InterfaceC0520a;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.c;
import d3.o;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import s3.C1536g;

/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
public class k implements c, c.a {

    /* renamed from: a, reason: collision with root package name */
    public final d<?> f19619a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f19620b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f19621c;

    /* renamed from: d, reason: collision with root package name */
    public volatile b f19622d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f19623e;

    /* renamed from: f, reason: collision with root package name */
    public volatile o.a<?> f19624f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Z2.a f19625g;

    /* compiled from: SourceGenerator.java */
    /* loaded from: classes.dex */
    public class a implements d.a<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o.a f19626a;

        public a(o.a aVar) {
            this.f19626a = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(Exception exc) {
            if (k.this.g(this.f19626a)) {
                k.this.i(this.f19626a, exc);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void f(Object obj) {
            if (k.this.g(this.f19626a)) {
                k.this.h(this.f19626a, obj);
            }
        }
    }

    public k(d<?> dVar, c.a aVar) {
        this.f19619a = dVar;
        this.f19620b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.c.a
    public void a(X2.b bVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        this.f19620b.a(bVar, exc, dVar, this.f19624f.f29992c.d());
    }

    @Override // com.bumptech.glide.load.engine.c.a
    public void b(X2.b bVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, X2.b bVar2) {
        this.f19620b.b(bVar, obj, dVar, this.f19624f.f29992c.d(), bVar);
    }

    @Override // com.bumptech.glide.load.engine.c.a
    public void c() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.c
    public void cancel() {
        o.a<?> aVar = this.f19624f;
        if (aVar != null) {
            aVar.f29992c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.c
    public boolean d() {
        if (this.f19623e != null) {
            Object obj = this.f19623e;
            this.f19623e = null;
            try {
                if (!e(obj)) {
                    return true;
                }
            } catch (IOException e10) {
                if (Log.isLoggable("SourceGenerator", 3)) {
                    Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e10);
                }
            }
        }
        if (this.f19622d != null && this.f19622d.d()) {
            return true;
        }
        this.f19622d = null;
        this.f19624f = null;
        boolean z10 = false;
        while (!z10 && f()) {
            List<o.a<?>> g10 = this.f19619a.g();
            int i10 = this.f19621c;
            this.f19621c = i10 + 1;
            this.f19624f = g10.get(i10);
            if (this.f19624f != null && (this.f19619a.e().c(this.f19624f.f29992c.d()) || this.f19619a.u(this.f19624f.f29992c.a()))) {
                j(this.f19624f);
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean e(Object obj) {
        long b10 = C1536g.b();
        boolean z10 = false;
        try {
            com.bumptech.glide.load.data.e<T> o10 = this.f19619a.o(obj);
            Object a10 = o10.a();
            X2.a<X> q10 = this.f19619a.q(a10);
            Z2.b bVar = new Z2.b(q10, a10, this.f19619a.k());
            Z2.a aVar = new Z2.a(this.f19624f.f29990a, this.f19619a.p());
            InterfaceC0520a d10 = this.f19619a.d();
            d10.a(aVar, bVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + aVar + ", data: " + obj + ", encoder: " + q10 + ", duration: " + C1536g.a(b10));
            }
            if (d10.b(aVar) != null) {
                this.f19625g = aVar;
                this.f19622d = new b(Collections.singletonList(this.f19624f.f29990a), this.f19619a, this);
                this.f19624f.f29992c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.f19625g + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f19620b.b(this.f19624f.f29990a, o10.a(), this.f19624f.f29992c, this.f19624f.f29992c.d(), this.f19624f.f29990a);
                return false;
            } catch (Throwable th) {
                th = th;
                z10 = true;
                if (!z10) {
                    this.f19624f.f29992c.b();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean f() {
        if (this.f19621c < this.f19619a.g().size()) {
            return true;
        }
        return false;
    }

    public boolean g(o.a<?> aVar) {
        o.a<?> aVar2 = this.f19624f;
        if (aVar2 != null && aVar2 == aVar) {
            return true;
        }
        return false;
    }

    public void h(o.a<?> aVar, Object obj) {
        Z2.c e10 = this.f19619a.e();
        if (obj != null && e10.c(aVar.f29992c.d())) {
            this.f19623e = obj;
            this.f19620b.c();
        } else {
            c.a aVar2 = this.f19620b;
            X2.b bVar = aVar.f29990a;
            com.bumptech.glide.load.data.d<?> dVar = aVar.f29992c;
            aVar2.b(bVar, obj, dVar, dVar.d(), this.f19625g);
        }
    }

    public void i(o.a<?> aVar, Exception exc) {
        c.a aVar2 = this.f19620b;
        Z2.a aVar3 = this.f19625g;
        com.bumptech.glide.load.data.d<?> dVar = aVar.f29992c;
        aVar2.a(aVar3, exc, dVar, dVar.d());
    }

    public final void j(o.a<?> aVar) {
        this.f19624f.f29992c.e(this.f19619a.l(), new a(aVar));
    }
}
