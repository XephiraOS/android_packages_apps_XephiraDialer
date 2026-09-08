package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.b;
import com.bumptech.glide.manager.k;
import com.bumptech.glide.manager.o;
import com.bumptech.glide.manager.p;
import com.bumptech.glide.manager.r;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import o3.C1401e;
import o3.InterfaceC1399c;
import o3.InterfaceC1400d;
import p3.InterfaceC1438h;
import s3.C1541l;

/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class i implements ComponentCallbacks2, k {

    /* renamed from: m, reason: collision with root package name */
    public static final C1401e f19361m = C1401e.i0(Bitmap.class).M();

    /* renamed from: n, reason: collision with root package name */
    public static final C1401e f19362n = C1401e.i0(k3.c.class).M();

    /* renamed from: o, reason: collision with root package name */
    public static final C1401e f19363o = C1401e.j0(Z2.c.f5872c).V(Priority.LOW).c0(true);

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.b f19364a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f19365b;

    /* renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.manager.j f19366c;

    /* renamed from: d, reason: collision with root package name */
    public final p f19367d;

    /* renamed from: e, reason: collision with root package name */
    public final o f19368e;

    /* renamed from: f, reason: collision with root package name */
    public final r f19369f;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f19370g;

    /* renamed from: h, reason: collision with root package name */
    public final com.bumptech.glide.manager.b f19371h;

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList<InterfaceC1400d<Object>> f19372i;

    /* renamed from: j, reason: collision with root package name */
    public C1401e f19373j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f19374k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f19375l;

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.f19366c.a(iVar);
        }
    }

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    public class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final p f19377a;

        public b(p pVar) {
            this.f19377a = pVar;
        }

        @Override // com.bumptech.glide.manager.b.a
        public void a(boolean z10) {
            if (z10) {
                synchronized (i.this) {
                    this.f19377a.e();
                }
            }
        }
    }

    public i(com.bumptech.glide.b bVar, com.bumptech.glide.manager.j jVar, o oVar, Context context) {
        this(bVar, jVar, oVar, new p(), bVar.g(), context);
    }

    @Override // com.bumptech.glide.manager.k
    public synchronized void b() {
        this.f19369f.b();
        n();
        this.f19367d.b();
        this.f19366c.b(this);
        this.f19366c.b(this.f19371h);
        C1541l.v(this.f19370g);
        this.f19364a.s(this);
    }

    @Override // com.bumptech.glide.manager.k
    public synchronized void e() {
        try {
            this.f19369f.e();
            if (this.f19375l) {
                n();
            } else {
                u();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public <ResourceType> h<ResourceType> j(Class<ResourceType> cls) {
        return new h<>(this.f19364a, this, cls, this.f19365b);
    }

    public h<Bitmap> k() {
        return j(Bitmap.class).a(f19361m);
    }

    public h<Drawable> l() {
        return j(Drawable.class);
    }

    public void m(InterfaceC1438h<?> interfaceC1438h) {
        if (interfaceC1438h == null) {
            return;
        }
        z(interfaceC1438h);
    }

    public final synchronized void n() {
        try {
            Iterator<InterfaceC1438h<?>> it = this.f19369f.k().iterator();
            while (it.hasNext()) {
                m(it.next());
            }
            this.f19369f.j();
        } catch (Throwable th) {
            throw th;
        }
    }

    public List<InterfaceC1400d<Object>> o() {
        return this.f19372i;
    }

    @Override // com.bumptech.glide.manager.k
    public synchronized void onStart() {
        v();
        this.f19369f.onStart();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f19374k) {
            t();
        }
    }

    public synchronized C1401e p() {
        return this.f19373j;
    }

    public <T> j<?, T> q(Class<T> cls) {
        return this.f19364a.i().e(cls);
    }

    public h<Drawable> r(String str) {
        return l().w0(str);
    }

    public synchronized void s() {
        this.f19367d.c();
    }

    public synchronized void t() {
        s();
        Iterator<i> it = this.f19368e.a().iterator();
        while (it.hasNext()) {
            it.next().s();
        }
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f19367d + ", treeNode=" + this.f19368e + "}";
    }

    public synchronized void u() {
        this.f19367d.d();
    }

    public synchronized void v() {
        this.f19367d.f();
    }

    public synchronized void w(C1401e c1401e) {
        this.f19373j = c1401e.clone().b();
    }

    public synchronized void x(InterfaceC1438h<?> interfaceC1438h, InterfaceC1399c interfaceC1399c) {
        this.f19369f.l(interfaceC1438h);
        this.f19367d.g(interfaceC1399c);
    }

    public synchronized boolean y(InterfaceC1438h<?> interfaceC1438h) {
        InterfaceC1399c request = interfaceC1438h.getRequest();
        if (request == null) {
            return true;
        }
        if (this.f19367d.a(request)) {
            this.f19369f.m(interfaceC1438h);
            interfaceC1438h.f(null);
            return true;
        }
        return false;
    }

    public final void z(InterfaceC1438h<?> interfaceC1438h) {
        boolean y10 = y(interfaceC1438h);
        InterfaceC1399c request = interfaceC1438h.getRequest();
        if (!y10 && !this.f19364a.p(interfaceC1438h) && request != null) {
            interfaceC1438h.f(null);
            request.clear();
        }
    }

    public i(com.bumptech.glide.b bVar, com.bumptech.glide.manager.j jVar, o oVar, p pVar, com.bumptech.glide.manager.c cVar, Context context) {
        this.f19369f = new r();
        a aVar = new a();
        this.f19370g = aVar;
        this.f19364a = bVar;
        this.f19366c = jVar;
        this.f19368e = oVar;
        this.f19367d = pVar;
        this.f19365b = context;
        com.bumptech.glide.manager.b a10 = cVar.a(context.getApplicationContext(), new b(pVar));
        this.f19371h = a10;
        bVar.o(this);
        if (C1541l.q()) {
            C1541l.u(aVar);
        } else {
            jVar.a(this);
        }
        jVar.a(a10);
        this.f19372i = new CopyOnWriteArrayList<>(bVar.i().c());
        w(bVar.i().d());
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }
}
