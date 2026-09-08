package i8;

import f8.C1022a;
import g8.C1051a;
import java.util.HashMap;

/* compiled from: BaseBehavior.java */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, i> f32204f;

    /* renamed from: h, reason: collision with root package name */
    public Runnable f32206h;

    /* renamed from: i, reason: collision with root package name */
    public Runnable f32207i;

    /* renamed from: j, reason: collision with root package name */
    public m f32208j;

    /* renamed from: k, reason: collision with root package name */
    public C1051a f32209k;

    /* renamed from: l, reason: collision with root package name */
    public h8.c f32210l;

    /* renamed from: n, reason: collision with root package name */
    public Object f32212n;

    /* renamed from: a, reason: collision with root package name */
    public float f32199a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    public boolean f32200b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f32201c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f32202d = false;

    /* renamed from: e, reason: collision with root package name */
    public i f32203e = null;

    /* renamed from: g, reason: collision with root package name */
    public k f32205g = null;

    /* renamed from: m, reason: collision with root package name */
    public h8.b f32211m = null;

    public c() {
        w();
    }

    public void A() {
        if (!this.f32201c) {
            G();
            F();
            v();
            m();
            this.f32205g.B(this);
            this.f32205g.x(this);
            this.f32201c = true;
            Runnable runnable = this.f32206h;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public boolean B() {
        if (!this.f32201c) {
            return false;
        }
        if (q() != 0) {
            this.f32208j.f32261g.f();
        }
        this.f32205g.z(this);
        this.f32201c = false;
        Runnable runnable = this.f32207i;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        return true;
    }

    public void C(C1051a c1051a, f8.e eVar) {
        c1051a.r(eVar);
    }

    public void D() {
        HashMap<String, i> hashMap = this.f32204f;
        if (hashMap == null) {
            return;
        }
        for (i iVar : hashMap.values()) {
            if (iVar != null) {
                E(this.f32208j, iVar);
            }
        }
    }

    public final void E(m mVar, i iVar) {
        iVar.e(mVar);
    }

    public void F() {
        HashMap<String, i> hashMap = this.f32204f;
        if (hashMap == null) {
            m mVar = this.f32208j;
            mVar.c(mVar.a().f32251a, this.f32208j.a().f32252b);
            return;
        }
        for (i iVar : hashMap.values()) {
            if (iVar != null) {
                iVar.f(this.f32208j);
            }
        }
    }

    public void G() {
        if (this.f32202d) {
            this.f32202d = false;
            this.f32209k.d().d(C1022a.d(this.f32208j.f32261g.f31799a), C1022a.d(this.f32208j.f32261g.f31800b));
        }
    }

    public final void H() {
        int i10;
        k kVar = this.f32205g;
        if (kVar == null || this.f32209k != null) {
            return;
        }
        m n10 = kVar.n(this.f32212n);
        this.f32208j = n10;
        k kVar2 = this.f32205g;
        i iVar = this.f32203e;
        if (iVar != null) {
            i10 = iVar.f32234a;
        } else {
            i10 = 1;
        }
        this.f32209k = kVar2.m(n10, i10);
        x();
        if (f8.b.b()) {
            f8.b.c("verifyBodyProperty : mActiveUIItem =:" + this.f32208j + ",mPropertyBody =:" + this.f32209k + ",this =:" + this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends c> T I(i... iVarArr) {
        for (i iVar : iVarArr) {
            a(iVar);
        }
        return this;
    }

    public final void a(i iVar) {
        if (this.f32204f == null) {
            this.f32204f = new HashMap<>(1);
        }
        if (this.f32203e == null) {
            this.f32203e = iVar;
            H();
        }
        this.f32204f.put(iVar.f32235b, iVar);
        this.f32199a = f8.d.b(this.f32199a, iVar.f32236c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends c> T b(Object obj) {
        this.f32212n = obj;
        H();
        return this;
    }

    public c c(k kVar) {
        this.f32205g = kVar;
        H();
        u(this.f32205g.l());
        return this;
    }

    public C1051a d(String str, C1051a c1051a) {
        if (c1051a == null) {
            C1051a c1051a2 = this.f32209k;
            f8.e eVar = c1051a2.f31934a;
            int h10 = c1051a2.h();
            int g10 = this.f32209k.g();
            C1051a c1051a3 = this.f32209k;
            c1051a = i(eVar, h10, g10, c1051a3.f31948o, c1051a3.f31949p, str);
        } else {
            C1051a c1051a4 = this.f32209k;
            c1051a.t(c1051a4.f31948o, c1051a4.f31949p);
        }
        c1051a.o(this.f32209k.d());
        c1051a.l(false);
        return c1051a;
    }

    public boolean e(h8.c cVar) {
        if (!this.f32200b) {
            h8.b f10 = f(cVar, this.f32209k);
            this.f32211m = f10;
            if (f10 != null) {
                this.f32200b = true;
                return true;
            }
            return false;
        }
        return false;
    }

    public h8.b f(h8.c cVar, C1051a c1051a) {
        if (cVar != null && c1051a != null) {
            cVar.f32129c.e(c1051a.i());
            return this.f32205g.g(cVar);
        }
        return null;
    }

    public void g() {
        h(4.0f, 0.2f);
    }

    public void h(float f10, float f11) {
        h8.c cVar = new h8.c();
        this.f32210l = cVar;
        cVar.f32131e = 4.0f;
        cVar.f32132f = 0.2f;
    }

    public final C1051a i(f8.e eVar, int i10, int i11, float f10, float f11, String str) {
        return this.f32205g.f(eVar, i10, i11, f10, f11, str);
    }

    public boolean j(C1051a c1051a) {
        return this.f32205g.j(c1051a);
    }

    public boolean k() {
        if (!this.f32200b) {
            return false;
        }
        l(this.f32211m);
        this.f32211m = null;
        this.f32200b = false;
        return true;
    }

    public void l(h8.b bVar) {
        this.f32205g.k(bVar);
    }

    public void m() {
        this.f32208j.f(C1022a.c(this.f32209k.f().f31799a - this.f32209k.c().f31799a), C1022a.c(this.f32209k.f().f31800b - this.f32209k.c().f31800b));
    }

    public Object n() {
        i iVar = this.f32203e;
        if (iVar == null) {
            if (p() != null) {
                return Float.valueOf(p().f32251a);
            }
            return null;
        }
        return Float.valueOf(o(this.f32208j, iVar));
    }

    public float o(Object obj, i iVar) {
        return iVar.a(obj);
    }

    public l p() {
        m mVar = this.f32208j;
        if (mVar != null) {
            return mVar.a();
        }
        return null;
    }

    public abstract int q();

    public boolean r(f8.e eVar) {
        h8.b bVar = this.f32211m;
        if (bVar != null) {
            return C1022a.b(f8.d.a(bVar.d().f31799a - eVar.f31799a) + f8.d.a(this.f32211m.d().f31800b - eVar.f31800b));
        }
        return true;
    }

    public boolean s() {
        if (t(this.f32209k.f31938e) && r(this.f32209k.f())) {
            return true;
        }
        return false;
    }

    public boolean t(f8.e eVar) {
        if (C1022a.b(f8.d.a(eVar.f31799a)) && C1022a.b(f8.d.a(eVar.f31800b))) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Behavior{type=" + q() + ", mValueThreshold=" + this.f32199a + ", mTarget=" + this.f32212n + ", mPropertyBody=" + this.f32209k + "}@" + hashCode();
    }

    public void u(C1051a c1051a) {
        h8.c cVar = this.f32210l;
        if (cVar != null) {
            cVar.f32127a = c1051a;
            c1051a.l(true);
        }
    }

    public void v() {
        m mVar = this.f32208j;
        mVar.f32258d.d((C1022a.d(mVar.f32259e.f31799a) + this.f32209k.c().f31799a) / this.f32199a, (C1022a.d(this.f32208j.f32259e.f31800b) + this.f32209k.c().f31800b) / this.f32199a);
        C(this.f32209k, this.f32208j.f32258d);
    }

    public void x() {
        h8.c cVar = this.f32210l;
        if (cVar != null) {
            cVar.f32128b = this.f32209k;
        }
    }

    public void y() {
        if (f8.b.b()) {
            f8.b.c("onRemove mIsStarted =:" + this.f32201c + ",this =:" + this);
        }
        this.f32207i = null;
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends c> T z(float f10, float f11) {
        h8.c cVar = this.f32210l;
        if (cVar != null) {
            cVar.f32131e = f10;
            cVar.f32132f = f11;
            h8.b bVar = this.f32211m;
            if (bVar != null) {
                bVar.g(f10);
                this.f32211m.f(f11);
            }
        }
        return this;
    }

    public void w() {
    }
}
