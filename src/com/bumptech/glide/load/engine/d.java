package com.bumptech.glide.load.engine;

import b3.InterfaceC0520a;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DecodeJob;
import d3.o;
import f3.C0999c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeHelper.java */
/* loaded from: classes.dex */
public final class d<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    public final List<o.a<?>> f19516a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final List<X2.b> f19517b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.d f19518c;

    /* renamed from: d, reason: collision with root package name */
    public Object f19519d;

    /* renamed from: e, reason: collision with root package name */
    public int f19520e;

    /* renamed from: f, reason: collision with root package name */
    public int f19521f;

    /* renamed from: g, reason: collision with root package name */
    public Class<?> f19522g;

    /* renamed from: h, reason: collision with root package name */
    public DecodeJob.e f19523h;

    /* renamed from: i, reason: collision with root package name */
    public X2.d f19524i;

    /* renamed from: j, reason: collision with root package name */
    public Map<Class<?>, X2.g<?>> f19525j;

    /* renamed from: k, reason: collision with root package name */
    public Class<Transcode> f19526k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f19527l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19528m;

    /* renamed from: n, reason: collision with root package name */
    public X2.b f19529n;

    /* renamed from: o, reason: collision with root package name */
    public Priority f19530o;

    /* renamed from: p, reason: collision with root package name */
    public Z2.c f19531p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19532q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f19533r;

    public void a() {
        this.f19518c = null;
        this.f19519d = null;
        this.f19529n = null;
        this.f19522g = null;
        this.f19526k = null;
        this.f19524i = null;
        this.f19530o = null;
        this.f19525j = null;
        this.f19531p = null;
        this.f19516a.clear();
        this.f19527l = false;
        this.f19517b.clear();
        this.f19528m = false;
    }

    public a3.b b() {
        return this.f19518c.b();
    }

    public List<X2.b> c() {
        if (!this.f19528m) {
            this.f19528m = true;
            this.f19517b.clear();
            List<o.a<?>> g10 = g();
            int size = g10.size();
            for (int i10 = 0; i10 < size; i10++) {
                o.a<?> aVar = g10.get(i10);
                if (!this.f19517b.contains(aVar.f29990a)) {
                    this.f19517b.add(aVar.f29990a);
                }
                for (int i11 = 0; i11 < aVar.f29991b.size(); i11++) {
                    if (!this.f19517b.contains(aVar.f29991b.get(i11))) {
                        this.f19517b.add(aVar.f29991b.get(i11));
                    }
                }
            }
        }
        return this.f19517b;
    }

    public InterfaceC0520a d() {
        return this.f19523h.a();
    }

    public Z2.c e() {
        return this.f19531p;
    }

    public int f() {
        return this.f19521f;
    }

    public List<o.a<?>> g() {
        if (!this.f19527l) {
            this.f19527l = true;
            this.f19516a.clear();
            List i10 = this.f19518c.i().i(this.f19519d);
            int size = i10.size();
            for (int i11 = 0; i11 < size; i11++) {
                o.a<?> b10 = ((o) i10.get(i11)).b(this.f19519d, this.f19520e, this.f19521f, this.f19524i);
                if (b10 != null) {
                    this.f19516a.add(b10);
                }
            }
        }
        return this.f19516a;
    }

    public <Data> i<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f19518c.i().h(cls, this.f19522g, this.f19526k);
    }

    public Class<?> i() {
        return this.f19519d.getClass();
    }

    public List<o<File, ?>> j(File file) {
        return this.f19518c.i().i(file);
    }

    public X2.d k() {
        return this.f19524i;
    }

    public Priority l() {
        return this.f19530o;
    }

    public List<Class<?>> m() {
        return this.f19518c.i().j(this.f19519d.getClass(), this.f19522g, this.f19526k);
    }

    public <Z> X2.f<Z> n(Z2.j<Z> jVar) {
        return this.f19518c.i().k(jVar);
    }

    public <T> com.bumptech.glide.load.data.e<T> o(T t10) {
        return this.f19518c.i().l(t10);
    }

    public X2.b p() {
        return this.f19529n;
    }

    public <X> X2.a<X> q(X x10) {
        return this.f19518c.i().m(x10);
    }

    public Class<?> r() {
        return this.f19526k;
    }

    public <Z> X2.g<Z> s(Class<Z> cls) {
        X2.g<Z> gVar = (X2.g) this.f19525j.get(cls);
        if (gVar == null) {
            Iterator<Map.Entry<Class<?>, X2.g<?>>> it = this.f19525j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, X2.g<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    gVar = (X2.g) next.getValue();
                    break;
                }
            }
        }
        if (gVar == null) {
            if (this.f19525j.isEmpty() && this.f19532q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return C0999c.c();
        }
        return gVar;
    }

    public int t() {
        return this.f19520e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean u(Class<?> cls) {
        if (h(cls) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void v(com.bumptech.glide.d dVar, Object obj, X2.b bVar, int i10, int i11, Z2.c cVar, Class<?> cls, Class<R> cls2, Priority priority, X2.d dVar2, Map<Class<?>, X2.g<?>> map, boolean z10, boolean z11, DecodeJob.e eVar) {
        this.f19518c = dVar;
        this.f19519d = obj;
        this.f19529n = bVar;
        this.f19520e = i10;
        this.f19521f = i11;
        this.f19531p = cVar;
        this.f19522g = cls;
        this.f19523h = eVar;
        this.f19526k = cls2;
        this.f19530o = priority;
        this.f19524i = dVar2;
        this.f19525j = map;
        this.f19532q = z10;
        this.f19533r = z11;
    }

    public boolean w(Z2.j<?> jVar) {
        return this.f19518c.i().n(jVar);
    }

    public boolean x() {
        return this.f19533r;
    }

    public boolean y(X2.b bVar) {
        List<o.a<?>> g10 = g();
        int size = g10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (g10.get(i10).f29990a.equals(bVar)) {
                return true;
            }
        }
        return false;
    }
}
