package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.c;
import d3.o;
import java.io.File;
import java.util.List;

/* compiled from: DataCacheGenerator.java */
/* loaded from: classes.dex */
public class b implements c, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final List<X2.b> f19507a;

    /* renamed from: b, reason: collision with root package name */
    public final d<?> f19508b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a f19509c;

    /* renamed from: d, reason: collision with root package name */
    public int f19510d;

    /* renamed from: e, reason: collision with root package name */
    public X2.b f19511e;

    /* renamed from: f, reason: collision with root package name */
    public List<o<File, ?>> f19512f;

    /* renamed from: g, reason: collision with root package name */
    public int f19513g;

    /* renamed from: h, reason: collision with root package name */
    public volatile o.a<?> f19514h;

    /* renamed from: i, reason: collision with root package name */
    public File f19515i;

    public b(d<?> dVar, c.a aVar) {
        this(dVar.c(), dVar, aVar);
    }

    private boolean a() {
        if (this.f19513g < this.f19512f.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(Exception exc) {
        this.f19509c.a(this.f19511e, exc, this.f19514h.f29992c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.c
    public void cancel() {
        o.a<?> aVar = this.f19514h;
        if (aVar != null) {
            aVar.f29992c.cancel();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r2 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (a() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        r0 = r7.f19512f;
        r3 = r7.f19513g;
        r7.f19513g = r3 + 1;
        r7.f19514h = r0.get(r3).b(r7.f19515i, r7.f19508b.t(), r7.f19508b.f(), r7.f19508b.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        if (r7.f19514h == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        if (r7.f19508b.u(r7.f19514h.f29992c.a()) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        r7.f19514h.f29992c.e(r7.f19508b.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
    
        r7.f19514h = null;
     */
    @Override // com.bumptech.glide.load.engine.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d() {
        /*
            r7 = this;
            java.lang.String r0 = "DataCacheGenerator.startNext"
            t3.b.a(r0)
        L5:
            java.util.List<d3.o<java.io.File, ?>> r0 = r7.f19512f     // Catch: java.lang.Throwable -> L68
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6e
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L12
            goto L6e
        L12:
            r0 = 0
            r7.f19514h = r0     // Catch: java.lang.Throwable -> L68
        L15:
            if (r2 != 0) goto L6a
            boolean r0 = r7.a()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L6a
            java.util.List<d3.o<java.io.File, ?>> r0 = r7.f19512f     // Catch: java.lang.Throwable -> L68
            int r3 = r7.f19513g     // Catch: java.lang.Throwable -> L68
            int r4 = r3 + 1
            r7.f19513g = r4     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L68
            d3.o r0 = (d3.o) r0     // Catch: java.lang.Throwable -> L68
            java.io.File r3 = r7.f19515i     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.d<?> r4 = r7.f19508b     // Catch: java.lang.Throwable -> L68
            int r4 = r4.t()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.d<?> r5 = r7.f19508b     // Catch: java.lang.Throwable -> L68
            int r5 = r5.f()     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.d<?> r6 = r7.f19508b     // Catch: java.lang.Throwable -> L68
            X2.d r6 = r6.k()     // Catch: java.lang.Throwable -> L68
            d3.o$a r0 = r0.b(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L68
            r7.f19514h = r0     // Catch: java.lang.Throwable -> L68
            d3.o$a<?> r0 = r7.f19514h     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            com.bumptech.glide.load.engine.d<?> r0 = r7.f19508b     // Catch: java.lang.Throwable -> L68
            d3.o$a<?> r3 = r7.f19514h     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.d<Data> r3 = r3.f29992c     // Catch: java.lang.Throwable -> L68
            java.lang.Class r3 = r3.a()     // Catch: java.lang.Throwable -> L68
            boolean r0 = r0.u(r3)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L15
            d3.o$a<?> r0 = r7.f19514h     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.data.d<Data> r0 = r0.f29992c     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.d<?> r2 = r7.f19508b     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.Priority r2 = r2.l()     // Catch: java.lang.Throwable -> L68
            r0.e(r2, r7)     // Catch: java.lang.Throwable -> L68
            r2 = r1
            goto L15
        L68:
            r7 = move-exception
            goto Lb0
        L6a:
            t3.b.e()
            return r2
        L6e:
            int r0 = r7.f19510d     // Catch: java.lang.Throwable -> L68
            int r0 = r0 + r1
            r7.f19510d = r0     // Catch: java.lang.Throwable -> L68
            java.util.List<X2.b> r1 = r7.f19507a     // Catch: java.lang.Throwable -> L68
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68
            if (r0 < r1) goto L7f
            t3.b.e()
            return r2
        L7f:
            java.util.List<X2.b> r0 = r7.f19507a     // Catch: java.lang.Throwable -> L68
            int r1 = r7.f19510d     // Catch: java.lang.Throwable -> L68
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68
            X2.b r0 = (X2.b) r0     // Catch: java.lang.Throwable -> L68
            Z2.a r1 = new Z2.a     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.d<?> r3 = r7.f19508b     // Catch: java.lang.Throwable -> L68
            X2.b r3 = r3.p()     // Catch: java.lang.Throwable -> L68
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.d<?> r3 = r7.f19508b     // Catch: java.lang.Throwable -> L68
            b3.a r3 = r3.d()     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = r3.b(r1)     // Catch: java.lang.Throwable -> L68
            r7.f19515i = r1     // Catch: java.lang.Throwable -> L68
            if (r1 == 0) goto L5
            r7.f19511e = r0     // Catch: java.lang.Throwable -> L68
            com.bumptech.glide.load.engine.d<?> r0 = r7.f19508b     // Catch: java.lang.Throwable -> L68
            java.util.List r0 = r0.j(r1)     // Catch: java.lang.Throwable -> L68
            r7.f19512f = r0     // Catch: java.lang.Throwable -> L68
            r7.f19513g = r2     // Catch: java.lang.Throwable -> L68
            goto L5
        Lb0:
            t3.b.e()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.b.d():boolean");
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void f(Object obj) {
        this.f19509c.b(this.f19511e, obj, this.f19514h.f29992c, DataSource.DATA_DISK_CACHE, this.f19511e);
    }

    public b(List<X2.b> list, d<?> dVar, c.a aVar) {
        this.f19510d = -1;
        this.f19507a = list;
        this.f19508b = dVar;
        this.f19509c = aVar;
    }
}
