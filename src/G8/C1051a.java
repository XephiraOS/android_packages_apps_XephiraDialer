package g8;

import android.graphics.RectF;
import f8.C1022a;
import f8.e;
import h8.C1086a;
import i8.c;

/* compiled from: Body.java */
/* renamed from: g8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1051a {

    /* renamed from: a, reason: collision with root package name */
    public final e f31934a;

    /* renamed from: b, reason: collision with root package name */
    public final e f31935b;

    /* renamed from: c, reason: collision with root package name */
    public final e f31936c;

    /* renamed from: d, reason: collision with root package name */
    public final e f31937d;

    /* renamed from: e, reason: collision with root package name */
    public final e f31938e;

    /* renamed from: f, reason: collision with root package name */
    public final e f31939f;

    /* renamed from: g, reason: collision with root package name */
    public c f31940g;

    /* renamed from: h, reason: collision with root package name */
    public RectF f31941h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f31942i;

    /* renamed from: j, reason: collision with root package name */
    public C1051a f31943j;

    /* renamed from: k, reason: collision with root package name */
    public C1051a f31944k;

    /* renamed from: l, reason: collision with root package name */
    public C1086a f31945l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f31946m;

    /* renamed from: n, reason: collision with root package name */
    public float f31947n;

    /* renamed from: o, reason: collision with root package name */
    public float f31948o;

    /* renamed from: p, reason: collision with root package name */
    public float f31949p;

    /* renamed from: q, reason: collision with root package name */
    public float f31950q;

    /* renamed from: r, reason: collision with root package name */
    public float f31951r;

    /* renamed from: s, reason: collision with root package name */
    public float f31952s;

    /* renamed from: t, reason: collision with root package name */
    public float f31953t;

    /* renamed from: u, reason: collision with root package name */
    public int f31954u;

    /* renamed from: v, reason: collision with root package name */
    public int f31955v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f31956w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f31957x;

    /* renamed from: y, reason: collision with root package name */
    public String f31958y;

    public C1051a(e eVar, int i10, int i11, float f10, float f11) {
        e eVar2 = new e();
        this.f31934a = eVar2;
        this.f31935b = new e();
        this.f31936c = new e();
        this.f31937d = new e(0.0f, 0.0f);
        this.f31938e = new e();
        this.f31939f = new e();
        this.f31940g = null;
        this.f31946m = false;
        this.f31947n = 50.0f;
        this.f31956w = false;
        this.f31957x = false;
        this.f31958y = "";
        v(i10);
        s(i11);
        eVar2.e(eVar);
        this.f31950q = 1.0f;
        t(f10, f11);
        this.f31956w = true;
        this.f31945l = null;
        this.f31943j = null;
        this.f31944k = null;
    }

    public void a(c cVar) {
        RectF rectF = this.f31941h;
        if (rectF != null && !rectF.isEmpty() && this.f31940g == cVar) {
            this.f31941h = null;
            this.f31942i = null;
            k(50.0f);
        }
    }

    public void b(c cVar) {
        c cVar2;
        RectF rectF = this.f31942i;
        if (rectF != null && (cVar2 = this.f31940g) != null && cVar2 == cVar) {
            rectF.setEmpty();
        }
    }

    public final e c() {
        return this.f31937d;
    }

    public final e d() {
        return this.f31938e;
    }

    public final float e() {
        return this.f31951r;
    }

    public final e f() {
        return this.f31934a;
    }

    public int g() {
        return this.f31955v;
    }

    public int h() {
        return this.f31954u;
    }

    public final e i() {
        return this.f31936c;
    }

    public final void j() {
        if (this.f31954u == 0) {
            p(1.0f);
            n(0.0f);
            return;
        }
        p(this.f31948o * this.f31949p * this.f31950q);
        n(C1022a.a(this.f31951r));
        if (!this.f31956w || this.f31955v == 1) {
            this.f31935b.d(this.f31948o * 0.5f, this.f31949p * 0.5f);
            this.f31936c.e(this.f31934a).a(this.f31935b);
        }
    }

    public void k(float f10) {
        this.f31947n = f10;
    }

    public void l(boolean z10) {
        this.f31946m = z10;
    }

    public final void m(float f10, float f11) {
        this.f31937d.d(C1022a.d(f10), C1022a.d(f11));
    }

    public final void n(float f10) {
        this.f31953t = f10;
    }

    public final void o(e eVar) {
        if (this.f31954u == 0) {
            return;
        }
        this.f31938e.e(eVar);
    }

    public final void p(float f10) {
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        this.f31951r = f10;
        this.f31952s = 1.0f / f10;
    }

    public void q(RectF rectF) {
        if (rectF != null && !rectF.isEmpty()) {
            if (this.f31941h == null) {
                this.f31941h = new RectF();
            }
            this.f31941h.set(C1022a.d(rectF.left), C1022a.d(rectF.top), C1022a.d(rectF.right), C1022a.d(rectF.bottom));
        }
    }

    public final void r(e eVar) {
        this.f31934a.e(eVar);
        this.f31936c.e(eVar).a(this.f31935b);
    }

    public final void s(int i10) {
        this.f31955v = i10;
    }

    public void t(float f10, float f11) {
        this.f31948o = f10;
        this.f31949p = f11;
        j();
    }

    public String toString() {
        return "Body{mType=" + this.f31954u + ", mProperty=" + this.f31955v + ", mLinearVelocity=" + this.f31938e + ", mLinearDamping=" + this.f31953t + ", mPosition=" + this.f31934a + ", mHookPosition=" + this.f31937d + ", mOriginActiveRect=" + this.f31941h + ", mActiveRect=" + this.f31942i + ", mTag='" + this.f31958y + "'}@" + hashCode();
    }

    public void u(String str) {
        this.f31958y = str;
    }

    public final void v(int i10) {
        this.f31954u = i10;
    }

    public void w() {
        e eVar = this.f31934a;
        e eVar2 = this.f31936c;
        float f10 = eVar2.f31799a;
        e eVar3 = this.f31935b;
        eVar.d(f10 - eVar3.f31799a, eVar2.f31800b - eVar3.f31800b);
    }

    public void x() {
        c cVar;
        RectF rectF = this.f31942i;
        if (rectF != null && !rectF.isEmpty() && (cVar = this.f31940g) != null && cVar.q() == 0) {
            RectF rectF2 = this.f31942i;
            float f10 = rectF2.left;
            float f11 = rectF2.right;
            float f12 = rectF2.top;
            float f13 = rectF2.bottom;
            e eVar = this.f31934a;
            float f14 = eVar.f31799a;
            if (f14 < f10) {
                this.f31939f.f31799a = f10 - f14;
            } else if (f14 > f11) {
                this.f31939f.f31799a = f11 - f14;
            }
            float f15 = eVar.f31800b;
            if (f15 < f12) {
                this.f31939f.f31800b = f12 - f15;
            } else if (f15 > f13) {
                this.f31939f.f31800b = f13 - f15;
            }
            float f16 = this.f31947n * 6.2831855f;
            this.f31939f.b(this.f31951r * f16 * f16 * 1.0f);
        }
    }

    public boolean y(c cVar) {
        RectF rectF = this.f31941h;
        if (rectF != null && !rectF.isEmpty()) {
            this.f31940g = cVar;
            if (this.f31942i == null) {
                this.f31942i = new RectF();
            }
            RectF rectF2 = this.f31942i;
            RectF rectF3 = this.f31941h;
            float f10 = rectF3.left;
            e eVar = this.f31937d;
            float f11 = eVar.f31799a;
            float f12 = rectF3.top;
            float f13 = eVar.f31800b;
            rectF2.set(f10 + f11, f12 + f13, rectF3.right - (this.f31948o - f11), rectF3.bottom - (this.f31949p - f13));
            return true;
        }
        return false;
    }
}
