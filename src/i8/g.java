package i8;

import android.graphics.RectF;
import f8.C1022a;
import g8.C1051a;

/* compiled from: DragBehavior.java */
/* loaded from: classes3.dex */
public class g extends c {

    /* renamed from: o, reason: collision with root package name */
    public C1051a f32226o;

    /* renamed from: p, reason: collision with root package name */
    public h8.c f32227p;

    /* renamed from: q, reason: collision with root package name */
    public h8.b f32228q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f32229r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f32230s = true;

    public g() {
        g();
        h8.c cVar = new h8.c();
        this.f32227p = cVar;
        cVar.f32131e = 2000000.0f;
        cVar.f32132f = 100.0f;
    }

    private void L() {
        if (e(this.f32210l)) {
            this.f32211m.i(this.f32208j.f32258d);
            h8.b f10 = f(this.f32227p, this.f32226o);
            this.f32228q = f10;
            if (f10 != null) {
                f10.i(this.f32208j.f32258d);
                this.f32226o.l(true);
            }
        }
    }

    private void M() {
        if (k()) {
            l(this.f32228q);
            this.f32226o.l(false);
        }
    }

    private void U(f8.e eVar) {
        C(this.f32209k, eVar);
        C1051a c1051a = this.f32226o;
        if (c1051a != null) {
            C(c1051a, eVar);
        }
    }

    @Override // i8.c
    public void A() {
        super.A();
        L();
    }

    @Override // i8.c
    public boolean B() {
        M();
        return super.B();
    }

    public void J(float f10, float f11) {
        K(f10, 0.0f, f11, 0.0f);
    }

    public void K(float f10, float f11, float f12, float f13) {
        if (f8.b.b()) {
            f8.b.c("DragBehavior : beginDrag : x =:" + f10 + ",y =:" + f11 + ",currentX =:" + f12 + ",currentY =:" + f13);
        }
        this.f32209k.m(f10 - f12, f11 - f13);
        this.f32209k.y(this);
        this.f32209k.f31938e.f();
        C1051a c1051a = this.f32226o;
        if (c1051a != null) {
            c1051a.f31938e.f();
        }
        this.f32208j.f32258d.d(Q(C1022a.d(f10)), R(C1022a.d(f11)));
        U(this.f32208j.f32258d);
        this.f32229r = true;
        A();
    }

    public final void N(float f10, float f11) {
        if (f8.b.b()) {
            f8.b.c("DragBehavior : dragTo : x =:" + f10 + ",y =:" + f11);
        }
        if (this.f32211m != null) {
            this.f32208j.f32258d.d(Q(C1022a.d(f10)), R(C1022a.d(f11)));
            this.f32211m.i(this.f32208j.f32258d);
            h8.b bVar = this.f32228q;
            if (bVar != null) {
                bVar.i(this.f32208j.f32258d);
            }
        }
    }

    public void O(float f10) {
        P(f10, 0.0f);
    }

    public void P(float f10, float f11) {
        if (f8.b.b()) {
            f8.b.c("DragBehavior : endDrag : xVel =:" + f10 + ",yVel =:" + f11);
        }
        M();
        C1051a c1051a = this.f32226o;
        if (c1051a != null) {
            f8.e eVar = c1051a.f31938e;
            float f12 = eVar.f31799a;
            if (f12 == 0.0f) {
                f10 = 0.0f;
            } else {
                f10 = (f12 / f8.d.a(f12)) * f8.d.a(f10);
            }
            float f13 = eVar.f31800b;
            if (f13 == 0.0f) {
                f11 = 0.0f;
            } else {
                f11 = f8.d.a(f11) * (f13 / f8.d.a(f13));
            }
        }
        this.f32208j.e(f10, f11);
        this.f32229r = false;
        this.f32209k.b(this);
    }

    public float Q(float f10) {
        RectF rectF;
        if (!this.f32230s && (rectF = this.f32209k.f31942i) != null && (this.f32201c || !rectF.isEmpty())) {
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

    public float R(float f10) {
        RectF rectF;
        if (!this.f32230s && (rectF = this.f32209k.f31942i) != null && (this.f32201c || !rectF.isEmpty())) {
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

    public boolean S() {
        return this.f32229r;
    }

    public void T(float f10) {
        N(f10, 0.0f);
    }

    @Override // i8.c
    public int q() {
        return 0;
    }

    @Override // i8.c
    public boolean s() {
        return !this.f32229r;
    }

    @Override // i8.c
    public void u(C1051a c1051a) {
        super.u(c1051a);
        h8.c cVar = this.f32227p;
        if (cVar != null) {
            cVar.f32127a = c1051a;
        }
    }

    @Override // i8.c
    public void x() {
        super.x();
        this.f32209k.k(this.f32210l.f32131e);
        if (this.f32227p != null) {
            C1051a d10 = d("SimulateTouch", this.f32226o);
            this.f32226o = d10;
            this.f32227p.f32128b = d10;
        }
    }

    @Override // i8.c
    public void y() {
        super.y();
        C1051a c1051a = this.f32226o;
        if (c1051a != null) {
            j(c1051a);
        }
    }

    @Override // i8.c
    public <T extends c> T z(float f10, float f11) {
        C1051a c1051a = this.f32209k;
        if (c1051a != null) {
            c1051a.k(f10);
        }
        return (T) super.z(f10, f11);
    }

    @Override // i8.c
    public void v() {
    }
}
