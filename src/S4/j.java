package S4;

/* compiled from: PerspectiveTransform.java */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final float f3510a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3511b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3512c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3513d;

    /* renamed from: e, reason: collision with root package name */
    public final float f3514e;

    /* renamed from: f, reason: collision with root package name */
    public final float f3515f;

    /* renamed from: g, reason: collision with root package name */
    public final float f3516g;

    /* renamed from: h, reason: collision with root package name */
    public final float f3517h;

    /* renamed from: i, reason: collision with root package name */
    public final float f3518i;

    public j(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f3510a = f10;
        this.f3511b = f13;
        this.f3512c = f16;
        this.f3513d = f11;
        this.f3514e = f14;
        this.f3515f = f17;
        this.f3516g = f12;
        this.f3517h = f15;
        this.f3518i = f18;
    }

    public static j b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
        return d(f18, f19, f20, f21, f22, f23, f24, f25).e(c(f10, f11, f12, f13, f14, f15, f16, f17));
    }

    public static j c(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return d(f10, f11, f12, f13, f14, f15, f16, f17).a();
    }

    public static j d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = ((f10 - f12) + f14) - f16;
        float f19 = ((f11 - f13) + f15) - f17;
        if (f18 == 0.0f && f19 == 0.0f) {
            return new j(f12 - f10, f14 - f12, f10, f13 - f11, f15 - f13, f11, 0.0f, 0.0f, 1.0f);
        }
        float f20 = f12 - f14;
        float f21 = f16 - f14;
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = (f20 * f23) - (f21 * f22);
        float f25 = ((f23 * f18) - (f21 * f19)) / f24;
        float f26 = ((f20 * f19) - (f18 * f22)) / f24;
        return new j((f25 * f12) + (f12 - f10), (f26 * f16) + (f16 - f10), f10, (f13 - f11) + (f25 * f13), (f17 - f11) + (f26 * f17), f11, f25, f26, 1.0f);
    }

    public j a() {
        float f10 = this.f3514e;
        float f11 = this.f3518i;
        float f12 = this.f3515f;
        float f13 = this.f3517h;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = this.f3516g;
        float f16 = this.f3513d;
        float f17 = (f12 * f15) - (f16 * f11);
        float f18 = (f16 * f13) - (f10 * f15);
        float f19 = this.f3512c;
        float f20 = this.f3511b;
        float f21 = this.f3510a;
        return new j(f14, f17, f18, (f19 * f13) - (f20 * f11), (f11 * f21) - (f19 * f15), (f15 * f20) - (f13 * f21), (f20 * f12) - (f19 * f10), (f19 * f16) - (f12 * f21), (f21 * f10) - (f20 * f16));
    }

    public j e(j jVar) {
        float f10 = this.f3510a;
        float f11 = jVar.f3510a;
        float f12 = this.f3513d;
        float f13 = jVar.f3511b;
        float f14 = this.f3516g;
        float f15 = jVar.f3512c;
        float f16 = (f10 * f11) + (f12 * f13) + (f14 * f15);
        float f17 = jVar.f3513d;
        float f18 = jVar.f3514e;
        float f19 = jVar.f3515f;
        float f20 = (f10 * f17) + (f12 * f18) + (f14 * f19);
        float f21 = jVar.f3516g;
        float f22 = jVar.f3517h;
        float f23 = jVar.f3518i;
        float f24 = (f10 * f21) + (f12 * f22) + (f14 * f23);
        float f25 = this.f3511b;
        float f26 = this.f3514e;
        float f27 = this.f3517h;
        float f28 = (f25 * f11) + (f26 * f13) + (f27 * f15);
        float f29 = (f25 * f17) + (f26 * f18) + (f27 * f19);
        float f30 = (f27 * f23) + (f25 * f21) + (f26 * f22);
        float f31 = this.f3512c;
        float f32 = this.f3515f;
        float f33 = this.f3518i;
        return new j(f16, f20, f24, f28, f29, f30, (f15 * f33) + (f11 * f31) + (f13 * f32), (f17 * f31) + (f18 * f32) + (f19 * f33), (f31 * f21) + (f32 * f22) + (f33 * f23));
    }

    public void f(float[] fArr) {
        float f10 = this.f3510a;
        float f11 = this.f3511b;
        float f12 = this.f3512c;
        float f13 = this.f3513d;
        float f14 = this.f3514e;
        float f15 = this.f3515f;
        float f16 = this.f3516g;
        float f17 = this.f3517h;
        float f18 = this.f3518i;
        int length = fArr.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f19 = fArr[i10];
            int i11 = i10 + 1;
            float f20 = fArr[i11];
            float f21 = (f12 * f19) + (f15 * f20) + f18;
            fArr[i10] = (((f10 * f19) + (f13 * f20)) + f16) / f21;
            fArr[i11] = (((f19 * f11) + (f20 * f14)) + f17) / f21;
        }
    }
}
