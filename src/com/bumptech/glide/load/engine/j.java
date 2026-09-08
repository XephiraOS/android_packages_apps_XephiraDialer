package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.c;
import d3.o;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator.java */
/* loaded from: classes.dex */
public class j implements c, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a f19609a;

    /* renamed from: b, reason: collision with root package name */
    public final d<?> f19610b;

    /* renamed from: c, reason: collision with root package name */
    public int f19611c;

    /* renamed from: d, reason: collision with root package name */
    public int f19612d = -1;

    /* renamed from: e, reason: collision with root package name */
    public X2.b f19613e;

    /* renamed from: f, reason: collision with root package name */
    public List<o<File, ?>> f19614f;

    /* renamed from: g, reason: collision with root package name */
    public int f19615g;

    /* renamed from: h, reason: collision with root package name */
    public volatile o.a<?> f19616h;

    /* renamed from: i, reason: collision with root package name */
    public File f19617i;

    /* renamed from: j, reason: collision with root package name */
    public Z2.k f19618j;

    public j(d<?> dVar, c.a aVar) {
        this.f19610b = dVar;
        this.f19609a = aVar;
    }

    private boolean a() {
        if (this.f19615g < this.f19614f.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(Exception exc) {
        this.f19609a.a(this.f19618j, exc, this.f19616h.f29992c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.c
    public void cancel() {
        o.a<?> aVar = this.f19616h;
        if (aVar != null) {
            aVar.f29992c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.c
    public boolean d() {
        t3.b.a("ResourceCacheGenerator.startNext");
        try {
            List<X2.b> c10 = this.f19610b.c();
            boolean z10 = false;
            if (c10.isEmpty()) {
                t3.b.e();
                return false;
            }
            List<Class<?>> m10 = this.f19610b.m();
            if (m10.isEmpty()) {
                if (File.class.equals(this.f19610b.r())) {
                    t3.b.e();
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f19610b.i() + " to " + this.f19610b.r());
            }
            while (true) {
                if (this.f19614f != null && a()) {
                    this.f19616h = null;
                    while (!z10 && a()) {
                        List<o<File, ?>> list = this.f19614f;
                        int i10 = this.f19615g;
                        this.f19615g = i10 + 1;
                        this.f19616h = list.get(i10).b(this.f19617i, this.f19610b.t(), this.f19610b.f(), this.f19610b.k());
                        if (this.f19616h != null && this.f19610b.u(this.f19616h.f29992c.a())) {
                            this.f19616h.f29992c.e(this.f19610b.l(), this);
                            z10 = true;
                        }
                    }
                    t3.b.e();
                    return z10;
                }
                int i11 = this.f19612d + 1;
                this.f19612d = i11;
                if (i11 >= m10.size()) {
                    int i12 = this.f19611c + 1;
                    this.f19611c = i12;
                    if (i12 >= c10.size()) {
                        t3.b.e();
                        return false;
                    }
                    this.f19612d = 0;
                }
                X2.b bVar = c10.get(this.f19611c);
                Class<?> cls = m10.get(this.f19612d);
                this.f19618j = new Z2.k(this.f19610b.b(), bVar, this.f19610b.p(), this.f19610b.t(), this.f19610b.f(), this.f19610b.s(cls), cls, this.f19610b.k());
                File b10 = this.f19610b.d().b(this.f19618j);
                this.f19617i = b10;
                if (b10 != null) {
                    this.f19613e = bVar;
                    this.f19614f = this.f19610b.j(b10);
                    this.f19615g = 0;
                }
            }
        } catch (Throwable th) {
            t3.b.e();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void f(Object obj) {
        this.f19609a.b(this.f19613e, obj, this.f19616h.f29992c, DataSource.RESOURCE_DISK_CACHE, this.f19618j);
    }
}
