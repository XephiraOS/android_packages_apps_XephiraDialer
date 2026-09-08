package i8;

import android.graphics.RectF;
import g8.C1051a;

/* compiled from: ConstraintBehavior.java */
/* loaded from: classes3.dex */
public abstract class f extends c {

    /* renamed from: p, reason: collision with root package name */
    public C1051a f32219p;

    /* renamed from: v, reason: collision with root package name */
    public int f32225v;

    /* renamed from: o, reason: collision with root package name */
    public final RectF f32218o = new RectF();

    /* renamed from: q, reason: collision with root package name */
    public boolean f32220q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f32221r = false;

    /* renamed from: s, reason: collision with root package name */
    public float f32222s = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    public float f32223t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    public int f32224u = 0;

    public f(int i10, RectF rectF) {
        this.f32225v = i10;
        e0(rectF);
        if (S()) {
            h8.c cVar = new h8.c();
            this.f32210l = cVar;
            cVar.f32131e = 1.0f;
            cVar.f32132f = 0.4f;
        }
    }

    @Override // i8.c
    public void A() {
        super.A();
        c0();
    }

    @Override // i8.c
    public boolean B() {
        this.f32209k.b(this);
        if (S()) {
            M();
            this.f32219p.l(false);
        }
        return super.B();
    }

    public void J() {
        this.f32220q = a0();
        this.f32221r = b0();
        this.f32222s = N(this.f32209k.f().f31799a);
        this.f32223t = O(this.f32209k.f().f31800b);
    }

    public void K(float f10, float f11) {
        this.f32224u = 0;
        RectF rectF = this.f32209k.f31942i;
        if (rectF != null) {
            if (this.f32201c || !rectF.isEmpty()) {
                RectF rectF2 = this.f32209k.f31942i;
                if (f10 < rectF2.left) {
                    this.f32224u |= 1;
                } else if (f10 > rectF2.right) {
                    this.f32224u |= 4;
                }
                if (f11 < rectF2.top) {
                    this.f32224u |= 2;
                } else if (f11 > rectF2.bottom) {
                    this.f32224u |= 8;
                }
            }
        }
    }

    public final void L() {
        if (e(this.f32210l)) {
            this.f32211m.h(this.f32222s, this.f32223t);
        }
    }

    public final void M() {
        k();
        d0();
    }

    public float N(float f10) {
        RectF rectF = this.f32209k.f31942i;
        if (rectF != null && (this.f32201c || !rectF.isEmpty())) {
            RectF rectF2 = this.f32209k.f31942i;
            float f11 = rectF2.left;
            if (f10 < f11) {
                return f11;
            }
            float f12 = rectF2.right;
            if (f10 > f12) {
                return f12;
            }
        }
        return f10;
    }

    public float O(float f10) {
        RectF rectF = this.f32209k.f31942i;
        if (rectF != null && (this.f32201c || !rectF.isEmpty())) {
            RectF rectF2 = this.f32209k.f31942i;
            float f11 = rectF2.top;
            if (f10 < f11) {
                return f11;
            }
            float f12 = rectF2.bottom;
            if (f10 > f12) {
                return f12;
            }
        }
        return f10;
    }

    public void P() {
        int i10 = this.f32225v;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 4) {
                            this.f32208j.f32258d.e(this.f32209k.f());
                            if (!this.f32220q) {
                                this.f32222s = N(this.f32208j.f32258d.f31799a);
                            } else {
                                this.f32208j.f32258d.f31799a = this.f32219p.f().f31799a;
                            }
                            if (a0()) {
                                this.f32220q = true;
                            } else {
                                this.f32220q = false;
                            }
                            if (!this.f32221r) {
                                this.f32223t = O(this.f32208j.f32258d.f31800b);
                            } else {
                                this.f32208j.f32258d.f31800b = this.f32219p.f().f31800b;
                            }
                            if (b0()) {
                                this.f32221r = true;
                            } else {
                                this.f32221r = false;
                            }
                            f0(this.f32208j.f32258d);
                            return;
                        }
                        return;
                    }
                    if (!this.f32220q && !this.f32221r) {
                        if (W()) {
                            this.f32209k.d().f();
                        }
                        this.f32208j.f32258d.d(N(this.f32209k.f().f31799a), O(this.f32209k.f().f31800b));
                        this.f32222s = N(this.f32208j.f32258d.f31799a);
                        this.f32223t = O(this.f32208j.f32258d.f31800b);
                    } else {
                        this.f32208j.f32258d.e(this.f32219p.f());
                    }
                    f0(this.f32208j.f32258d);
                    return;
                }
                if (!this.f32220q && !this.f32221r) {
                    if (W()) {
                        C1051a c1051a = this.f32209k;
                        c1051a.o(c1051a.d().b(0.5f).c());
                    }
                    this.f32208j.f32258d.d(N(this.f32209k.f().f31799a), O(this.f32209k.f().f31800b));
                    this.f32222s = N(this.f32208j.f32258d.f31799a);
                    this.f32223t = O(this.f32208j.f32258d.f31800b);
                } else {
                    this.f32208j.f32258d.e(this.f32219p.f());
                }
                f0(this.f32208j.f32258d);
                return;
            }
            this.f32208j.f32258d.e(this.f32209k.f());
            if (!this.f32220q) {
                this.f32222s = N(this.f32208j.f32258d.f31799a);
            } else {
                this.f32208j.f32258d.f31799a = this.f32219p.f().f31799a;
            }
            if (a0()) {
                this.f32220q = true;
            }
            if (!this.f32221r) {
                this.f32223t = O(this.f32208j.f32258d.f31800b);
            } else {
                this.f32208j.f32258d.f31800b = this.f32219p.f().f31800b;
            }
            if (b0()) {
                this.f32221r = true;
            }
            f0(this.f32208j.f32258d);
            return;
        }
        this.f32208j.f32258d.e(this.f32209k.f());
        C(this.f32209k, this.f32208j.f32258d);
    }

    public final boolean Q() {
        if (this.f32225v == 1) {
            return true;
        }
        return false;
    }

    public final boolean R() {
        if (this.f32225v == 3) {
            return true;
        }
        return false;
    }

    public final boolean S() {
        if (!Q() && !R() && !T() && !U()) {
            return false;
        }
        return true;
    }

    public final boolean T() {
        if (this.f32225v == 2) {
            return true;
        }
        return false;
    }

    public final boolean U() {
        if (this.f32225v == 4) {
            return true;
        }
        return false;
    }

    public boolean V() {
        if ((this.f32224u & 8) != 0) {
            return true;
        }
        return false;
    }

    public boolean W() {
        if (this.f32224u != 0) {
            return true;
        }
        return false;
    }

    public boolean X() {
        if ((this.f32224u & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean Y() {
        if ((this.f32224u & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean Z() {
        if ((this.f32224u & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean a0() {
        if (!X() && !Y()) {
            return false;
        }
        return true;
    }

    public boolean b0() {
        if (!Z() && !V()) {
            return false;
        }
        return true;
    }

    public void c0() {
        if (this.f32209k.y(this) && S()) {
            K(this.f32209k.f().f31799a, this.f32209k.f().f31800b);
            J();
            this.f32219p.l(true);
            this.f32219p.o(this.f32209k.d());
            C(this.f32219p, this.f32209k.f());
            L();
        }
    }

    public final void d0() {
        this.f32224u = 0;
        this.f32220q = false;
        this.f32221r = false;
    }

    public void e0(RectF rectF) {
        if (rectF != null && !rectF.isEmpty()) {
            this.f32218o.set(rectF);
            C1051a c1051a = this.f32209k;
            if (c1051a != null) {
                c1051a.q(this.f32218o);
                this.f32209k.y(this);
            }
        }
    }

    public void f0(f8.e eVar) {
        C(this.f32209k, eVar);
        h8.b bVar = this.f32211m;
        if (bVar != null) {
            bVar.h(this.f32222s, this.f32223t);
            C(this.f32219p, eVar);
        }
    }

    @Override // i8.c
    public void m() {
        C1051a c1051a = this.f32209k;
        if (c1051a.f31942i != null) {
            K(c1051a.f().f31799a, this.f32209k.f().f31800b);
        }
        P();
        super.m();
    }

    @Override // i8.c
    public boolean s() {
        if (S()) {
            return super.s();
        }
        return t(this.f32209k.f31938e);
    }

    @Override // i8.c
    public void u(C1051a c1051a) {
        if (S()) {
            super.u(c1051a);
        }
    }

    @Override // i8.c
    public void v() {
        super.v();
        C1051a c1051a = this.f32219p;
        if (c1051a != null) {
            C(c1051a, this.f32208j.f32258d);
        }
    }

    @Override // i8.c
    public void x() {
        RectF rectF = this.f32218o;
        if (rectF != null && !rectF.isEmpty()) {
            this.f32209k.q(this.f32218o);
            this.f32209k.y(this);
            if (S()) {
                C1051a c1051a = this.f32209k;
                if (c1051a.f31947n == 50.0f) {
                    c1051a.k(this.f32210l.f32131e);
                }
            }
        }
        if (this.f32210l != null) {
            C1051a d10 = d("Assist", this.f32219p);
            this.f32219p = d10;
            this.f32210l.f32128b = d10;
        }
    }

    @Override // i8.c
    public void y() {
        super.y();
        this.f32209k.a(this);
        if (S()) {
            M();
            j(this.f32219p);
        }
    }

    @Override // i8.c
    public <T extends c> T z(float f10, float f11) {
        if (this.f32209k != null && S()) {
            C1051a c1051a = this.f32209k;
            if (c1051a.f31947n == 50.0f) {
                c1051a.k(f10);
            }
        }
        return (T) super.z(f10, f11);
    }
}
