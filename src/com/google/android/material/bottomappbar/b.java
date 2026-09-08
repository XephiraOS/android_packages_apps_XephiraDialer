package com.google.android.material.bottomappbar;

import x4.g;
import x4.p;

/* compiled from: BottomAppBarTopEdgeTreatment.java */
/* loaded from: classes3.dex */
public class b extends g implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public float f22796a;

    /* renamed from: b, reason: collision with root package name */
    public float f22797b;

    /* renamed from: c, reason: collision with root package name */
    public float f22798c;

    /* renamed from: d, reason: collision with root package name */
    public float f22799d;

    /* renamed from: e, reason: collision with root package name */
    public float f22800e;

    /* renamed from: f, reason: collision with root package name */
    public float f22801f = -1.0f;

    public b(float f10, float f11, float f12) {
        this.f22797b = f10;
        this.f22796a = f11;
        i(f12);
        this.f22800e = 0.0f;
    }

    @Override // x4.g
    public void b(float f10, float f11, float f12, p pVar) {
        boolean z10;
        float f13;
        float f14;
        float f15 = this.f22798c;
        if (f15 == 0.0f) {
            pVar.m(f10, 0.0f);
            return;
        }
        float f16 = ((this.f22797b * 2.0f) + f15) / 2.0f;
        float f17 = f12 * this.f22796a;
        float f18 = f11 + this.f22800e;
        float f19 = (this.f22799d * f12) + ((1.0f - f12) * f16);
        if (f19 / f16 >= 1.0f) {
            pVar.m(f10, 0.0f);
            return;
        }
        float f20 = this.f22801f;
        float f21 = f20 * f12;
        if (f20 != -1.0f && Math.abs((f20 * 2.0f) - f15) >= 0.1f) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean z11 = z10;
        if (!z11) {
            f14 = 1.75f;
            f13 = 0.0f;
        } else {
            f13 = f19;
            f14 = 0.0f;
        }
        float f22 = f16 + f17;
        float f23 = f13 + f17;
        float sqrt = (float) Math.sqrt((f22 * f22) - (f23 * f23));
        float f24 = f18 - sqrt;
        float f25 = f18 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f23));
        float f26 = (90.0f - degrees) + f14;
        pVar.m(f24, 0.0f);
        float f27 = f17 * 2.0f;
        pVar.a(f24 - f17, 0.0f, f24 + f17, f27, 270.0f, degrees);
        if (z11) {
            pVar.a(f18 - f16, (-f16) - f13, f18 + f16, f16 - f13, 180.0f - f26, (f26 * 2.0f) - 180.0f);
        } else {
            float f28 = this.f22797b;
            float f29 = f21 * 2.0f;
            float f30 = f18 - f16;
            pVar.a(f30, -(f21 + f28), f30 + f28 + f29, f28 + f21, 180.0f - f26, ((f26 * 2.0f) - 180.0f) / 2.0f);
            float f31 = f18 + f16;
            float f32 = this.f22797b;
            pVar.m(f31 - ((f32 / 2.0f) + f21), f32 + f21);
            float f33 = this.f22797b;
            pVar.a(f31 - (f29 + f33), -(f21 + f33), f31, f33 + f21, 90.0f, f26 - 90.0f);
        }
        pVar.a(f25 - f17, 0.0f, f25 + f17, f27, 270.0f - degrees, degrees);
        pVar.m(f10, 0.0f);
    }

    public float c() {
        return this.f22799d;
    }

    public float d() {
        return this.f22801f;
    }

    public float e() {
        return this.f22797b;
    }

    public float f() {
        return this.f22796a;
    }

    public float g() {
        return this.f22798c;
    }

    public float h() {
        return this.f22800e;
    }

    public void i(float f10) {
        if (f10 >= 0.0f) {
            this.f22799d = f10;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void j(float f10) {
        this.f22801f = f10;
    }

    public void k(float f10) {
        this.f22797b = f10;
    }

    public void l(float f10) {
        this.f22796a = f10;
    }

    public void m(float f10) {
        this.f22798c = f10;
    }

    public void n(float f10) {
        this.f22800e = f10;
    }
}
