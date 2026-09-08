package c4;

/* compiled from: BouncyConversion.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final double f12754a;

    /* renamed from: b, reason: collision with root package name */
    public final double f12755b;

    /* renamed from: c, reason: collision with root package name */
    public final double f12756c;

    /* renamed from: d, reason: collision with root package name */
    public final double f12757d;

    public c(double d10, double d11) {
        this.f12756c = d10;
        this.f12757d = d11;
        double i10 = i(h(d11 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        double i11 = i(h(d10 / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.f12754a = i11;
        this.f12755b = j(i10, d(i11), 0.01d);
    }

    public final double a(double d10) {
        return ((Math.pow(d10, 3.0d) * 7.0E-4d) - (Math.pow(d10, 2.0d) * 0.031d)) + (d10 * 0.64d) + 1.28d;
    }

    public final double b(double d10) {
        return ((Math.pow(d10, 3.0d) * 4.4E-5d) - (Math.pow(d10, 2.0d) * 0.006d)) + (d10 * 0.36d) + 2.0d;
    }

    public final double c(double d10) {
        return ((Math.pow(d10, 3.0d) * 4.5E-7d) - (Math.pow(d10, 2.0d) * 3.32E-4d)) + (d10 * 0.1078d) + 5.84d;
    }

    public final double d(double d10) {
        if (d10 <= 18.0d) {
            return a(d10);
        }
        if (d10 > 18.0d && d10 <= 44.0d) {
            return b(d10);
        }
        if (d10 > 44.0d) {
            return c(d10);
        }
        return 0.0d;
    }

    public double e() {
        return this.f12755b;
    }

    public double f() {
        return this.f12754a;
    }

    public final double g(double d10, double d11, double d12) {
        return (d12 * d10) + ((1.0d - d10) * d11);
    }

    public final double h(double d10, double d11, double d12) {
        return (d10 - d11) / (d12 - d11);
    }

    public final double i(double d10, double d11, double d12) {
        return d11 + (d10 * (d12 - d11));
    }

    public final double j(double d10, double d11, double d12) {
        return g((2.0d * d10) - (d10 * d10), d11, d12);
    }
}
