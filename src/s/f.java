package s;

import java.util.Arrays;

/* compiled from: Oscillator.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    public double[] f36598c;

    /* renamed from: d, reason: collision with root package name */
    public int f36599d;

    /* renamed from: a, reason: collision with root package name */
    public float[] f36596a = new float[0];

    /* renamed from: b, reason: collision with root package name */
    public double[] f36597b = new double[0];

    /* renamed from: e, reason: collision with root package name */
    public double f36600e = 6.283185307179586d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f36601f = false;

    public void a(double d10, float f10) {
        int length = this.f36596a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f36597b, d10);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f36597b = Arrays.copyOf(this.f36597b, length);
        this.f36596a = Arrays.copyOf(this.f36596a, length);
        this.f36598c = new double[length];
        double[] dArr = this.f36597b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f36597b[binarySearch] = d10;
        this.f36596a[binarySearch] = f10;
        this.f36601f = false;
    }

    public double b(double d10) {
        if (d10 <= 0.0d) {
            d10 = 1.0E-5d;
        } else if (d10 >= 1.0d) {
            d10 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f36597b, d10);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i10 = -binarySearch;
        int i11 = i10 - 1;
        float[] fArr = this.f36596a;
        float f10 = fArr[i11];
        int i12 = i10 - 2;
        float f11 = fArr[i12];
        double[] dArr = this.f36597b;
        double d11 = dArr[i11];
        double d12 = dArr[i12];
        double d13 = (f10 - f11) / (d11 - d12);
        return (d10 * d13) + (f11 - (d13 * d12));
    }

    public double c(double d10) {
        if (d10 < 0.0d) {
            d10 = 0.0d;
        } else if (d10 > 1.0d) {
            d10 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f36597b, d10);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i10 = -binarySearch;
        int i11 = i10 - 1;
        float[] fArr = this.f36596a;
        float f10 = fArr[i11];
        int i12 = i10 - 2;
        float f11 = fArr[i12];
        double[] dArr = this.f36597b;
        double d11 = dArr[i11];
        double d12 = dArr[i12];
        double d13 = (f10 - f11) / (d11 - d12);
        return this.f36598c[i12] + ((f11 - (d13 * d12)) * (d10 - d12)) + ((d13 * ((d10 * d10) - (d12 * d12))) / 2.0d);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    public double d(double d10) {
        double b10;
        double signum;
        double b11;
        double b12;
        double sin;
        switch (this.f36599d) {
            case 1:
                return 0.0d;
            case 2:
                b10 = b(d10) * 4.0d;
                signum = Math.signum((((c(d10) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return b10 * signum;
            case 3:
                b11 = b(d10);
                return b11 * 2.0d;
            case 4:
                b11 = -b(d10);
                return b11 * 2.0d;
            case 5:
                b12 = (-this.f36600e) * b(d10);
                sin = Math.sin(this.f36600e * c(d10));
                return b12 * sin;
            case 6:
                b10 = b(d10) * 4.0d;
                signum = (((c(d10) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return b10 * signum;
            default:
                b12 = this.f36600e * b(d10);
                sin = Math.cos(this.f36600e * c(d10));
                return b12 * sin;
        }
    }

    public double e(double d10) {
        double abs;
        switch (this.f36599d) {
            case 1:
                return Math.signum(0.5d - (c(d10) % 1.0d));
            case 2:
                abs = Math.abs((((c(d10) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((c(d10) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((c(d10) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f36600e * c(d10));
            case 6:
                double abs2 = 1.0d - Math.abs(((c(d10) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.f36600e * c(d10));
        }
        return 1.0d - abs;
    }

    public void f() {
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f36596a.length) {
                break;
            }
            d10 += r7[i10];
            i10++;
        }
        double d11 = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr = this.f36596a;
            if (i11 >= fArr.length) {
                break;
            }
            int i12 = i11 - 1;
            float f10 = (fArr[i12] + fArr[i11]) / 2.0f;
            double[] dArr = this.f36597b;
            d11 += (dArr[i11] - dArr[i12]) * f10;
            i11++;
        }
        int i13 = 0;
        while (true) {
            float[] fArr2 = this.f36596a;
            if (i13 >= fArr2.length) {
                break;
            }
            fArr2[i13] = (float) (fArr2[i13] * (d10 / d11));
            i13++;
        }
        this.f36598c[0] = 0.0d;
        int i14 = 1;
        while (true) {
            float[] fArr3 = this.f36596a;
            if (i14 < fArr3.length) {
                int i15 = i14 - 1;
                float f11 = (fArr3[i15] + fArr3[i14]) / 2.0f;
                double[] dArr2 = this.f36597b;
                double d12 = dArr2[i14] - dArr2[i15];
                double[] dArr3 = this.f36598c;
                dArr3[i14] = dArr3[i15] + (d12 * f11);
                i14++;
            } else {
                this.f36601f = true;
                return;
            }
        }
    }

    public void g(int i10) {
        this.f36599d = i10;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f36597b) + " period=" + Arrays.toString(this.f36596a);
    }
}
