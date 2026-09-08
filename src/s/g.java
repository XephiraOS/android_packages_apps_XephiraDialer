package s;

import t.o;

/* compiled from: StopLogic.java */
/* loaded from: classes.dex */
public class g extends o {

    /* renamed from: a, reason: collision with root package name */
    public float f36602a;

    /* renamed from: b, reason: collision with root package name */
    public float f36603b;

    /* renamed from: c, reason: collision with root package name */
    public float f36604c;

    /* renamed from: d, reason: collision with root package name */
    public float f36605d;

    /* renamed from: e, reason: collision with root package name */
    public float f36606e;

    /* renamed from: f, reason: collision with root package name */
    public float f36607f;

    /* renamed from: g, reason: collision with root package name */
    public float f36608g;

    /* renamed from: h, reason: collision with root package name */
    public float f36609h;

    /* renamed from: i, reason: collision with root package name */
    public float f36610i;

    /* renamed from: j, reason: collision with root package name */
    public int f36611j;

    /* renamed from: k, reason: collision with root package name */
    public String f36612k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f36613l = false;

    /* renamed from: m, reason: collision with root package name */
    public float f36614m;

    /* renamed from: n, reason: collision with root package name */
    public float f36615n;

    @Override // t.o
    public float a() {
        if (this.f36613l) {
            return -d(this.f36615n);
        }
        return d(this.f36615n);
    }

    public final float b(float f10) {
        float f11 = this.f36605d;
        if (f10 <= f11) {
            float f12 = this.f36602a;
            return (f12 * f10) + ((((this.f36603b - f12) * f10) * f10) / (f11 * 2.0f));
        }
        int i10 = this.f36611j;
        if (i10 == 1) {
            return this.f36608g;
        }
        float f13 = f10 - f11;
        float f14 = this.f36606e;
        if (f13 < f14) {
            float f15 = this.f36608g;
            float f16 = this.f36603b;
            return f15 + (f16 * f13) + ((((this.f36604c - f16) * f13) * f13) / (f14 * 2.0f));
        }
        if (i10 == 2) {
            return this.f36609h;
        }
        float f17 = f13 - f14;
        float f18 = this.f36607f;
        if (f17 < f18) {
            float f19 = this.f36609h;
            float f20 = this.f36604c;
            return (f19 + (f20 * f17)) - (((f20 * f17) * f17) / (f18 * 2.0f));
        }
        return this.f36610i;
    }

    public void c(float f10, float f11, float f12, float f13, float f14, float f15) {
        boolean z10;
        this.f36614m = f10;
        if (f10 > f11) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f36613l = z10;
        if (z10) {
            e(-f12, f10 - f11, f14, f15, f13);
        } else {
            e(f12, f11 - f10, f14, f15, f13);
        }
    }

    public float d(float f10) {
        float f11;
        float f12;
        float f13 = this.f36605d;
        if (f10 <= f13) {
            f11 = this.f36602a;
            f12 = this.f36603b;
        } else {
            int i10 = this.f36611j;
            if (i10 == 1) {
                return 0.0f;
            }
            f10 -= f13;
            f13 = this.f36606e;
            if (f10 < f13) {
                f11 = this.f36603b;
                f12 = this.f36604c;
            } else {
                if (i10 == 2) {
                    return this.f36609h;
                }
                float f14 = f10 - f13;
                float f15 = this.f36607f;
                if (f14 < f15) {
                    float f16 = this.f36604c;
                    return f16 - ((f14 * f16) / f15);
                }
                return this.f36610i;
            }
        }
        return f11 + (((f12 - f11) * f10) / f13);
    }

    public final void e(float f10, float f11, float f12, float f13, float f14) {
        if (f10 == 0.0f) {
            f10 = 1.0E-4f;
        }
        this.f36602a = f10;
        float f15 = f10 / f12;
        float f16 = (f15 * f10) / 2.0f;
        if (f10 < 0.0f) {
            float sqrt = (float) Math.sqrt((f11 - ((((-f10) / f12) * f10) / 2.0f)) * f12);
            if (sqrt < f13) {
                this.f36612k = "backward accelerate, decelerate";
                this.f36611j = 2;
                this.f36602a = f10;
                this.f36603b = sqrt;
                this.f36604c = 0.0f;
                float f17 = (sqrt - f10) / f12;
                this.f36605d = f17;
                this.f36606e = sqrt / f12;
                this.f36608g = ((f10 + sqrt) * f17) / 2.0f;
                this.f36609h = f11;
                this.f36610i = f11;
                return;
            }
            this.f36612k = "backward accelerate cruse decelerate";
            this.f36611j = 3;
            this.f36602a = f10;
            this.f36603b = f13;
            this.f36604c = f13;
            float f18 = (f13 - f10) / f12;
            this.f36605d = f18;
            float f19 = f13 / f12;
            this.f36607f = f19;
            float f20 = ((f10 + f13) * f18) / 2.0f;
            float f21 = (f19 * f13) / 2.0f;
            this.f36606e = ((f11 - f20) - f21) / f13;
            this.f36608g = f20;
            this.f36609h = f11 - f21;
            this.f36610i = f11;
            return;
        }
        if (f16 >= f11) {
            this.f36612k = "hard stop";
            this.f36611j = 1;
            this.f36602a = f10;
            this.f36603b = 0.0f;
            this.f36608g = f11;
            this.f36605d = (2.0f * f11) / f10;
            return;
        }
        float f22 = f11 - f16;
        float f23 = f22 / f10;
        if (f23 + f15 < f14) {
            this.f36612k = "cruse decelerate";
            this.f36611j = 2;
            this.f36602a = f10;
            this.f36603b = f10;
            this.f36604c = 0.0f;
            this.f36608g = f22;
            this.f36609h = f11;
            this.f36605d = f23;
            this.f36606e = f15;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f12 * f11) + ((f10 * f10) / 2.0f));
        float f24 = (sqrt2 - f10) / f12;
        this.f36605d = f24;
        float f25 = sqrt2 / f12;
        this.f36606e = f25;
        if (sqrt2 < f13) {
            this.f36612k = "accelerate decelerate";
            this.f36611j = 2;
            this.f36602a = f10;
            this.f36603b = sqrt2;
            this.f36604c = 0.0f;
            this.f36605d = f24;
            this.f36606e = f25;
            this.f36608g = ((f10 + sqrt2) * f24) / 2.0f;
            this.f36609h = f11;
            return;
        }
        this.f36612k = "accelerate cruse decelerate";
        this.f36611j = 3;
        this.f36602a = f10;
        this.f36603b = f13;
        this.f36604c = f13;
        float f26 = (f13 - f10) / f12;
        this.f36605d = f26;
        float f27 = f13 / f12;
        this.f36607f = f27;
        float f28 = ((f10 + f13) * f26) / 2.0f;
        float f29 = (f27 * f13) / 2.0f;
        this.f36606e = ((f11 - f28) - f29) / f13;
        this.f36608g = f28;
        this.f36609h = f11 - f29;
        this.f36610i = f11;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float b10 = b(f10);
        this.f36615n = f10;
        boolean z10 = this.f36613l;
        float f11 = this.f36614m;
        if (z10) {
            return f11 - b10;
        }
        return f11 + b10;
    }
}
