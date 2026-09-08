package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.c;

/* compiled from: SpringForce.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public double f9731a;

    /* renamed from: b, reason: collision with root package name */
    public double f9732b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9733c;

    /* renamed from: d, reason: collision with root package name */
    public double f9734d;

    /* renamed from: e, reason: collision with root package name */
    public double f9735e;

    /* renamed from: f, reason: collision with root package name */
    public double f9736f;

    /* renamed from: g, reason: collision with root package name */
    public double f9737g;

    /* renamed from: h, reason: collision with root package name */
    public double f9738h;

    /* renamed from: i, reason: collision with root package name */
    public double f9739i;

    /* renamed from: j, reason: collision with root package name */
    public final c.p f9740j;

    public g() {
        this.f9731a = Math.sqrt(1500.0d);
        this.f9732b = 0.5d;
        this.f9733c = false;
        this.f9739i = Double.MAX_VALUE;
        this.f9740j = new c.p();
    }

    public float a() {
        return (float) this.f9739i;
    }

    public final void b() {
        if (this.f9733c) {
            return;
        }
        if (this.f9739i != Double.MAX_VALUE) {
            double d10 = this.f9732b;
            if (d10 > 1.0d) {
                double d11 = this.f9731a;
                this.f9736f = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
                double d12 = this.f9732b;
                double d13 = this.f9731a;
                this.f9737g = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
            } else if (d10 >= 0.0d && d10 < 1.0d) {
                this.f9738h = this.f9731a * Math.sqrt(1.0d - (d10 * d10));
            }
            this.f9733c = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public boolean c(float f10, float f11) {
        if (Math.abs(f11) < this.f9735e && Math.abs(f10 - a()) < this.f9734d) {
            return true;
        }
        return false;
    }

    public g d(float f10) {
        if (f10 >= 0.0f) {
            this.f9732b = f10;
            this.f9733c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public g e(float f10) {
        this.f9739i = f10;
        return this;
    }

    public g f(float f10) {
        if (f10 > 0.0f) {
            this.f9731a = Math.sqrt(f10);
            this.f9733c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void g(double d10) {
        double abs = Math.abs(d10);
        this.f9734d = abs;
        this.f9735e = abs * 62.5d;
    }

    public c.p h(double d10, double d11, long j10) {
        double cos;
        double d12;
        b();
        double d13 = j10 / 1000.0d;
        double d14 = d10 - this.f9739i;
        double d15 = this.f9732b;
        if (d15 > 1.0d) {
            double d16 = this.f9737g;
            double d17 = this.f9736f;
            double d18 = d14 - (((d16 * d14) - d11) / (d16 - d17));
            double d19 = ((d14 * d16) - d11) / (d16 - d17);
            d12 = (Math.pow(2.718281828459045d, d16 * d13) * d18) + (Math.pow(2.718281828459045d, this.f9736f * d13) * d19);
            double d20 = this.f9737g;
            double pow = d18 * d20 * Math.pow(2.718281828459045d, d20 * d13);
            double d21 = this.f9736f;
            cos = pow + (d19 * d21 * Math.pow(2.718281828459045d, d21 * d13));
        } else if (d15 == 1.0d) {
            double d22 = this.f9731a;
            double d23 = d11 + (d22 * d14);
            double d24 = d14 + (d23 * d13);
            d12 = Math.pow(2.718281828459045d, (-d22) * d13) * d24;
            double pow2 = d24 * Math.pow(2.718281828459045d, (-this.f9731a) * d13);
            double d25 = this.f9731a;
            cos = (d23 * Math.pow(2.718281828459045d, (-d25) * d13)) + (pow2 * (-d25));
        } else {
            double d26 = 1.0d / this.f9738h;
            double d27 = this.f9731a;
            double d28 = d26 * ((d15 * d27 * d14) + d11);
            double pow3 = Math.pow(2.718281828459045d, (-d15) * d27 * d13) * ((Math.cos(this.f9738h * d13) * d14) + (Math.sin(this.f9738h * d13) * d28));
            double d29 = this.f9731a;
            double d30 = this.f9732b;
            double d31 = (-d29) * pow3 * d30;
            double pow4 = Math.pow(2.718281828459045d, (-d30) * d29 * d13);
            double d32 = this.f9738h;
            double sin = (-d32) * d14 * Math.sin(d32 * d13);
            double d33 = this.f9738h;
            cos = d31 + (pow4 * (sin + (d28 * d33 * Math.cos(d33 * d13))));
            d12 = pow3;
        }
        c.p pVar = this.f9740j;
        pVar.f9724a = (float) (d12 + this.f9739i);
        pVar.f9725b = (float) cos;
        return pVar;
    }

    public g(float f10) {
        this.f9731a = Math.sqrt(1500.0d);
        this.f9732b = 0.5d;
        this.f9733c = false;
        this.f9739i = Double.MAX_VALUE;
        this.f9740j = new c.p();
        this.f9739i = f10;
    }
}
