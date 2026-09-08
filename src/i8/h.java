package i8;

import android.graphics.RectF;
import f8.C1022a;
import g8.C1051a;

/* compiled from: FlingBehavior.java */
/* loaded from: classes3.dex */
public class h extends f {

    /* renamed from: w, reason: collision with root package name */
    public float f32231w;

    /* renamed from: x, reason: collision with root package name */
    public float f32232x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f32233y;

    public h() {
        this(0, null);
    }

    @Override // i8.f, i8.c
    public void A() {
        super.A();
        float f10 = this.f32232x;
        if (f10 != 0.0f) {
            C1051a c1051a = this.f32209k;
            this.f32231w = c1051a.f31953t;
            c1051a.n(f10);
            C1051a c1051a2 = this.f32219p;
            if (c1051a2 != null) {
                c1051a2.n(this.f32232x);
            }
        }
    }

    @Override // i8.f, i8.c
    public boolean B() {
        float f10 = this.f32231w;
        if (f10 != 0.0f) {
            this.f32209k.n(f10);
            C1051a c1051a = this.f32219p;
            if (c1051a != null) {
                c1051a.n(this.f32231w);
            }
        }
        return super.B();
    }

    @Override // i8.c
    public void G() {
        if (this.f32233y) {
            return;
        }
        super.G();
    }

    public void g0(float f10, float f11) {
        h0(new RectF(f10, f10, f11, f11));
    }

    public void h0(RectF rectF) {
        super.e0(rectF);
    }

    public h i0(float f10) {
        this.f32232x = f10;
        return this;
    }

    public void j0() {
        A();
    }

    public void k0(float f10) {
        l0(f10, 0.0f);
    }

    public void l0(float f10, float f11) {
        if (f8.b.b()) {
            f8.b.c("FlingBehavior : Fling : start : xVel =:" + f10 + ",yVel =:" + f11);
        }
        this.f32233y = true;
        this.f32209k.d().d(C1022a.d(f10), C1022a.d(f11));
        j0();
        this.f32233y = false;
    }

    public void m0() {
        B();
    }

    @Override // i8.c
    public int q() {
        return 2;
    }

    public h(int i10, float f10, float f11) {
        this(i10, new RectF(f10, f10, f11, f11));
    }

    public h(int i10, RectF rectF) {
        super(i10, rectF);
        this.f32231w = 0.0f;
        this.f32232x = 0.0f;
        this.f32233y = false;
    }
}
