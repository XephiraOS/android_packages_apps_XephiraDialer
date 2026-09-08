package com.bumptech.glide.request;

import Z2.j;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.f;
import i3.C1093b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import o3.AbstractC1397a;
import o3.AbstractC1398b;
import o3.InterfaceC1399c;
import o3.InterfaceC1400d;
import o3.InterfaceC1402f;
import p3.InterfaceC1437g;
import p3.InterfaceC1438h;
import q3.InterfaceC1484c;
import s3.C1536g;
import s3.C1541l;
import t3.c;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements InterfaceC1399c, InterfaceC1437g, InterfaceC1402f {

    /* renamed from: E, reason: collision with root package name */
    public static final boolean f19735E = Log.isLoggable("GlideRequest", 2);

    /* renamed from: A, reason: collision with root package name */
    public int f19736A;

    /* renamed from: B, reason: collision with root package name */
    public int f19737B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f19738C;

    /* renamed from: D, reason: collision with root package name */
    public RuntimeException f19739D;

    /* renamed from: a, reason: collision with root package name */
    public int f19740a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19741b;

    /* renamed from: c, reason: collision with root package name */
    public final c f19742c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f19743d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC1400d<R> f19744e;

    /* renamed from: f, reason: collision with root package name */
    public final RequestCoordinator f19745f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f19746g;

    /* renamed from: h, reason: collision with root package name */
    public final d f19747h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f19748i;

    /* renamed from: j, reason: collision with root package name */
    public final Class<R> f19749j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC1397a<?> f19750k;

    /* renamed from: l, reason: collision with root package name */
    public final int f19751l;

    /* renamed from: m, reason: collision with root package name */
    public final int f19752m;

    /* renamed from: n, reason: collision with root package name */
    public final Priority f19753n;

    /* renamed from: o, reason: collision with root package name */
    public final InterfaceC1438h<R> f19754o;

    /* renamed from: p, reason: collision with root package name */
    public final List<InterfaceC1400d<R>> f19755p;

    /* renamed from: q, reason: collision with root package name */
    public final InterfaceC1484c<? super R> f19756q;

    /* renamed from: r, reason: collision with root package name */
    public final Executor f19757r;

    /* renamed from: s, reason: collision with root package name */
    public j<R> f19758s;

    /* renamed from: t, reason: collision with root package name */
    public f.d f19759t;

    /* renamed from: u, reason: collision with root package name */
    public long f19760u;

    /* renamed from: v, reason: collision with root package name */
    public volatile f f19761v;

    /* renamed from: w, reason: collision with root package name */
    public Status f19762w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f19763x;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f19764y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f19765z;

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(Context context, d dVar, Object obj, Object obj2, Class<R> cls, AbstractC1397a<?> abstractC1397a, int i10, int i11, Priority priority, InterfaceC1438h<R> interfaceC1438h, InterfaceC1400d<R> interfaceC1400d, List<InterfaceC1400d<R>> list, RequestCoordinator requestCoordinator, f fVar, InterfaceC1484c<? super R> interfaceC1484c, Executor executor) {
        this.f19741b = f19735E ? String.valueOf(super.hashCode()) : null;
        this.f19742c = c.a();
        this.f19743d = obj;
        this.f19746g = context;
        this.f19747h = dVar;
        this.f19748i = obj2;
        this.f19749j = cls;
        this.f19750k = abstractC1397a;
        this.f19751l = i10;
        this.f19752m = i11;
        this.f19753n = priority;
        this.f19754o = interfaceC1438h;
        this.f19744e = interfaceC1400d;
        this.f19755p = list;
        this.f19745f = requestCoordinator;
        this.f19761v = fVar;
        this.f19756q = interfaceC1484c;
        this.f19757r = executor;
        this.f19762w = Status.PENDING;
        if (this.f19739D == null && dVar.g().a(c.C0188c.class)) {
            this.f19739D = new RuntimeException("Glide request origin trace");
        }
    }

    public static int w(int i10, float f10) {
        if (i10 != Integer.MIN_VALUE) {
            return Math.round(f10 * i10);
        }
        return i10;
    }

    public static <R> SingleRequest<R> z(Context context, d dVar, Object obj, Object obj2, Class<R> cls, AbstractC1397a<?> abstractC1397a, int i10, int i11, Priority priority, InterfaceC1438h<R> interfaceC1438h, InterfaceC1400d<R> interfaceC1400d, List<InterfaceC1400d<R>> list, RequestCoordinator requestCoordinator, f fVar, InterfaceC1484c<? super R> interfaceC1484c, Executor executor) {
        return new SingleRequest<>(context, dVar, obj, obj2, cls, abstractC1397a, i10, i11, priority, interfaceC1438h, interfaceC1400d, list, requestCoordinator, fVar, interfaceC1484c, executor);
    }

    public final void A(GlideException glideException, int i10) {
        boolean z10;
        this.f19742c.c();
        synchronized (this.f19743d) {
            try {
                glideException.k(this.f19739D);
                int h10 = this.f19747h.h();
                if (h10 <= i10) {
                    Log.w("Glide", "Load failed for [" + this.f19748i + "] with dimensions [" + this.f19736A + "x" + this.f19737B + "]", glideException);
                    if (h10 <= 4) {
                        glideException.g("Glide");
                    }
                }
                this.f19759t = null;
                this.f19762w = Status.FAILED;
                x();
                boolean z11 = true;
                this.f19738C = true;
                try {
                    List<InterfaceC1400d<R>> list = this.f19755p;
                    if (list != null) {
                        Iterator<InterfaceC1400d<R>> it = list.iterator();
                        z10 = false;
                        while (it.hasNext()) {
                            z10 |= it.next().a(glideException, this.f19748i, this.f19754o, t());
                        }
                    } else {
                        z10 = false;
                    }
                    InterfaceC1400d<R> interfaceC1400d = this.f19744e;
                    if (interfaceC1400d == null || !interfaceC1400d.a(glideException, this.f19748i, this.f19754o, t())) {
                        z11 = false;
                    }
                    if (!(z10 | z11)) {
                        C();
                    }
                    this.f19738C = false;
                    t3.b.f("GlideRequest", this.f19740a);
                } catch (Throwable th) {
                    this.f19738C = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void B(j<R> jVar, R r10, DataSource dataSource, boolean z10) {
        boolean z11;
        boolean t10 = t();
        this.f19762w = Status.COMPLETE;
        this.f19758s = jVar;
        if (this.f19747h.h() <= 3) {
            Log.d("Glide", "Finished loading " + r10.getClass().getSimpleName() + " from " + dataSource + " for " + this.f19748i + " with size [" + this.f19736A + "x" + this.f19737B + "] in " + C1536g.a(this.f19760u) + " ms");
        }
        y();
        boolean z12 = true;
        this.f19738C = true;
        try {
            List<InterfaceC1400d<R>> list = this.f19755p;
            if (list != null) {
                z11 = false;
                for (InterfaceC1400d<R> interfaceC1400d : list) {
                    boolean b10 = z11 | interfaceC1400d.b(r10, this.f19748i, this.f19754o, dataSource, t10);
                    if (interfaceC1400d instanceof AbstractC1398b) {
                        z11 = ((AbstractC1398b) interfaceC1400d).d(r10, this.f19748i, this.f19754o, dataSource, t10, z10) | b10;
                    } else {
                        z11 = b10;
                    }
                }
            } else {
                z11 = false;
            }
            InterfaceC1400d<R> interfaceC1400d2 = this.f19744e;
            if (interfaceC1400d2 == null || !interfaceC1400d2.b(r10, this.f19748i, this.f19754o, dataSource, t10)) {
                z12 = false;
            }
            if (!(z11 | z12)) {
                this.f19754o.a(r10, this.f19756q.a(dataSource, t10));
            }
            this.f19738C = false;
            t3.b.f("GlideRequest", this.f19740a);
        } catch (Throwable th) {
            this.f19738C = false;
            throw th;
        }
    }

    public final void C() {
        Drawable drawable;
        if (!l()) {
            return;
        }
        if (this.f19748i == null) {
            drawable = r();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = q();
        }
        if (drawable == null) {
            drawable = s();
        }
        this.f19754o.d(drawable);
    }

    @Override // o3.InterfaceC1402f
    public void a(GlideException glideException) {
        A(glideException, 5);
    }

    @Override // o3.InterfaceC1399c
    public boolean b() {
        boolean z10;
        synchronized (this.f19743d) {
            if (this.f19762w == Status.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // o3.InterfaceC1402f
    public void c(j<?> jVar, DataSource dataSource, boolean z10) {
        Object obj;
        String str;
        this.f19742c.c();
        j<?> jVar2 = null;
        try {
            synchronized (this.f19743d) {
                try {
                    this.f19759t = null;
                    if (jVar == null) {
                        a(new GlideException("Expected to receive a Resource<R> with an object of " + this.f19749j + " inside, but instead got null."));
                        return;
                    }
                    Object obj2 = jVar.get();
                    try {
                        if (obj2 != null && this.f19749j.isAssignableFrom(obj2.getClass())) {
                            if (!m()) {
                                this.f19758s = null;
                                this.f19762w = Status.COMPLETE;
                                t3.b.f("GlideRequest", this.f19740a);
                                this.f19761v.k(jVar);
                                return;
                            }
                            B(jVar, obj2, dataSource, z10);
                            return;
                        }
                        this.f19758s = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f19749j);
                        sb.append(" but instead got ");
                        if (obj2 != null) {
                            obj = obj2.getClass();
                        } else {
                            obj = "";
                        }
                        sb.append(obj);
                        sb.append("{");
                        sb.append(obj2);
                        sb.append("} inside Resource{");
                        sb.append(jVar);
                        sb.append("}.");
                        if (obj2 != null) {
                            str = "";
                        } else {
                            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                        }
                        sb.append(str);
                        a(new GlideException(sb.toString()));
                        this.f19761v.k(jVar);
                    } catch (Throwable th) {
                        jVar2 = jVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (jVar2 != null) {
                this.f19761v.k(jVar2);
            }
            throw th3;
        }
    }

    @Override // o3.InterfaceC1399c
    public void clear() {
        synchronized (this.f19743d) {
            try {
                i();
                this.f19742c.c();
                Status status = this.f19762w;
                Status status2 = Status.CLEARED;
                if (status == status2) {
                    return;
                }
                n();
                j<R> jVar = this.f19758s;
                if (jVar != null) {
                    this.f19758s = null;
                } else {
                    jVar = null;
                }
                if (k()) {
                    this.f19754o.h(s());
                }
                t3.b.f("GlideRequest", this.f19740a);
                this.f19762w = status2;
                if (jVar != null) {
                    this.f19761v.k(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p3.InterfaceC1437g
    public void d(int i10, int i11) {
        this.f19742c.c();
        synchronized (this.f19743d) {
            try {
                try {
                    boolean z10 = f19735E;
                    if (z10) {
                        v("Got onSizeReady in " + C1536g.a(this.f19760u));
                    }
                    if (this.f19762w != Status.WAITING_FOR_SIZE) {
                        return;
                    }
                    Status status = Status.RUNNING;
                    this.f19762w = status;
                    float w10 = this.f19750k.w();
                    this.f19736A = w(i10, w10);
                    this.f19737B = w(i11, w10);
                    if (z10) {
                        v("finished setup for calling load in " + C1536g.a(this.f19760u));
                    }
                    this.f19759t = this.f19761v.f(this.f19747h, this.f19748i, this.f19750k.v(), this.f19736A, this.f19737B, this.f19750k.u(), this.f19749j, this.f19753n, this.f19750k.i(), this.f19750k.y(), this.f19750k.J(), this.f19750k.F(), this.f19750k.o(), this.f19750k.D(), this.f19750k.A(), this.f19750k.z(), this.f19750k.n(), this, this.f19757r);
                    if (this.f19762w != status) {
                        this.f19759t = null;
                    }
                    if (z10) {
                        v("finished onSizeReady in " + C1536g.a(this.f19760u));
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // o3.InterfaceC1402f
    public Object e() {
        this.f19742c.c();
        return this.f19743d;
    }

    @Override // o3.InterfaceC1399c
    public boolean f() {
        boolean z10;
        synchronized (this.f19743d) {
            if (this.f19762w == Status.CLEARED) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public boolean g(InterfaceC1399c interfaceC1399c) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        AbstractC1397a<?> abstractC1397a;
        Priority priority;
        int i12;
        int i13;
        int i14;
        Object obj2;
        Class<R> cls2;
        AbstractC1397a<?> abstractC1397a2;
        Priority priority2;
        int i15;
        if (!(interfaceC1399c instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f19743d) {
            try {
                i10 = this.f19751l;
                i11 = this.f19752m;
                obj = this.f19748i;
                cls = this.f19749j;
                abstractC1397a = this.f19750k;
                priority = this.f19753n;
                List<InterfaceC1400d<R>> list = this.f19755p;
                if (list != null) {
                    i12 = list.size();
                } else {
                    i12 = 0;
                }
            } finally {
            }
        }
        SingleRequest singleRequest = (SingleRequest) interfaceC1399c;
        synchronized (singleRequest.f19743d) {
            try {
                i13 = singleRequest.f19751l;
                i14 = singleRequest.f19752m;
                obj2 = singleRequest.f19748i;
                cls2 = singleRequest.f19749j;
                abstractC1397a2 = singleRequest.f19750k;
                priority2 = singleRequest.f19753n;
                List<InterfaceC1400d<R>> list2 = singleRequest.f19755p;
                if (list2 != null) {
                    i15 = list2.size();
                } else {
                    i15 = 0;
                }
            } finally {
            }
        }
        if (i10 != i13 || i11 != i14 || !C1541l.c(obj, obj2) || !cls.equals(cls2) || !C1541l.b(abstractC1397a, abstractC1397a2) || priority != priority2 || i12 != i15) {
            return false;
        }
        return true;
    }

    @Override // o3.InterfaceC1399c
    public void h() {
        int i10;
        synchronized (this.f19743d) {
            try {
                i();
                this.f19742c.c();
                this.f19760u = C1536g.b();
                Object obj = this.f19748i;
                if (obj == null) {
                    if (C1541l.t(this.f19751l, this.f19752m)) {
                        this.f19736A = this.f19751l;
                        this.f19737B = this.f19752m;
                    }
                    if (r() == null) {
                        i10 = 5;
                    } else {
                        i10 = 3;
                    }
                    A(new GlideException("Received null model"), i10);
                    return;
                }
                Status status = this.f19762w;
                Status status2 = Status.RUNNING;
                if (status != status2) {
                    if (status == Status.COMPLETE) {
                        c(this.f19758s, DataSource.MEMORY_CACHE, false);
                        return;
                    }
                    p(obj);
                    this.f19740a = t3.b.b("GlideRequest");
                    Status status3 = Status.WAITING_FOR_SIZE;
                    this.f19762w = status3;
                    if (C1541l.t(this.f19751l, this.f19752m)) {
                        d(this.f19751l, this.f19752m);
                    } else {
                        this.f19754o.i(this);
                    }
                    Status status4 = this.f19762w;
                    if ((status4 == status2 || status4 == status3) && l()) {
                        this.f19754o.g(s());
                    }
                    if (f19735E) {
                        v("finished run method in " + C1536g.a(this.f19760u));
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot restart a running request");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        if (!this.f19738C) {
        } else {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // o3.InterfaceC1399c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f19743d) {
            try {
                Status status = this.f19762w;
                if (status != Status.RUNNING && status != Status.WAITING_FOR_SIZE) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public boolean j() {
        boolean z10;
        synchronized (this.f19743d) {
            if (this.f19762w == Status.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public final boolean k() {
        RequestCoordinator requestCoordinator = this.f19745f;
        if (requestCoordinator != null && !requestCoordinator.i(this)) {
            return false;
        }
        return true;
    }

    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f19745f;
        if (requestCoordinator != null && !requestCoordinator.c(this)) {
            return false;
        }
        return true;
    }

    public final boolean m() {
        RequestCoordinator requestCoordinator = this.f19745f;
        if (requestCoordinator != null && !requestCoordinator.e(this)) {
            return false;
        }
        return true;
    }

    public final void n() {
        i();
        this.f19742c.c();
        this.f19754o.c(this);
        f.d dVar = this.f19759t;
        if (dVar != null) {
            dVar.a();
            this.f19759t = null;
        }
    }

    @Override // o3.InterfaceC1399c
    public void o() {
        synchronized (this.f19743d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(Object obj) {
        List<InterfaceC1400d<R>> list = this.f19755p;
        if (list == null) {
            return;
        }
        for (InterfaceC1400d<R> interfaceC1400d : list) {
            if (interfaceC1400d instanceof AbstractC1398b) {
                ((AbstractC1398b) interfaceC1400d).c(obj);
            }
        }
    }

    public final Drawable q() {
        if (this.f19763x == null) {
            Drawable k10 = this.f19750k.k();
            this.f19763x = k10;
            if (k10 == null && this.f19750k.j() > 0) {
                this.f19763x = u(this.f19750k.j());
            }
        }
        return this.f19763x;
    }

    public final Drawable r() {
        if (this.f19765z == null) {
            Drawable l10 = this.f19750k.l();
            this.f19765z = l10;
            if (l10 == null && this.f19750k.m() > 0) {
                this.f19765z = u(this.f19750k.m());
            }
        }
        return this.f19765z;
    }

    public final Drawable s() {
        if (this.f19764y == null) {
            Drawable r10 = this.f19750k.r();
            this.f19764y = r10;
            if (r10 == null && this.f19750k.s() > 0) {
                this.f19764y = u(this.f19750k.s());
            }
        }
        return this.f19764y;
    }

    public final boolean t() {
        RequestCoordinator requestCoordinator = this.f19745f;
        if (requestCoordinator != null && requestCoordinator.getRoot().b()) {
            return false;
        }
        return true;
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.f19743d) {
            obj = this.f19748i;
            cls = this.f19749j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    public final Drawable u(int i10) {
        Resources.Theme theme;
        if (this.f19750k.x() != null) {
            theme = this.f19750k.x();
        } else {
            theme = this.f19746g.getTheme();
        }
        return C1093b.a(this.f19746g, i10, theme);
    }

    public final void v(String str) {
        Log.v("GlideRequest", str + " this: " + this.f19741b);
    }

    public final void x() {
        RequestCoordinator requestCoordinator = this.f19745f;
        if (requestCoordinator != null) {
            requestCoordinator.d(this);
        }
    }

    public final void y() {
        RequestCoordinator requestCoordinator = this.f19745f;
        if (requestCoordinator != null) {
            requestCoordinator.k(this);
        }
    }
}
