package s;

import java.lang.reflect.Array;

/* compiled from: MonotonicCurveFit.java */
/* loaded from: classes.dex */
public class e extends b {

    /* renamed from: a, reason: collision with root package name */
    public double[] f36593a;

    /* renamed from: b, reason: collision with root package name */
    public double[][] f36594b;

    /* renamed from: c, reason: collision with root package name */
    public double[][] f36595c;

    public e(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        int i10 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i10, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i11 = 0; i11 < length2; i11++) {
            int i12 = 0;
            while (i12 < i10) {
                int i13 = i12 + 1;
                double d10 = dArr[i13] - dArr[i12];
                double[] dArr5 = dArr3[i12];
                double d11 = (dArr2[i13][i11] - dArr2[i12][i11]) / d10;
                dArr5[i11] = d11;
                if (i12 == 0) {
                    dArr4[i12][i11] = d11;
                } else {
                    dArr4[i12][i11] = (dArr3[i12 - 1][i11] + d11) * 0.5d;
                }
                i12 = i13;
            }
            dArr4[i10][i11] = dArr3[length - 2][i11];
        }
        for (int i14 = 0; i14 < i10; i14++) {
            for (int i15 = 0; i15 < length2; i15++) {
                double d12 = dArr3[i14][i15];
                if (d12 == 0.0d) {
                    dArr4[i14][i15] = 0.0d;
                    dArr4[i14 + 1][i15] = 0.0d;
                } else {
                    double d13 = dArr4[i14][i15] / d12;
                    int i16 = i14 + 1;
                    double d14 = dArr4[i16][i15] / d12;
                    double hypot = Math.hypot(d13, d14);
                    if (hypot > 9.0d) {
                        double d15 = 3.0d / hypot;
                        double[] dArr6 = dArr4[i14];
                        double[] dArr7 = dArr3[i14];
                        dArr6[i15] = d13 * d15 * dArr7[i15];
                        dArr4[i16][i15] = d15 * d14 * dArr7[i15];
                    }
                }
            }
        }
        this.f36593a = dArr;
        this.f36594b = dArr2;
        this.f36595c = dArr4;
    }

    public static double i(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d11 * d11;
        double d17 = d11 * 6.0d;
        double d18 = 3.0d * d10;
        return ((((((((((-6.0d) * d16) * d13) + (d17 * d13)) + ((6.0d * d16) * d12)) - (d17 * d12)) + ((d18 * d15) * d16)) + ((d18 * d14) * d16)) - (((2.0d * d10) * d15) * d11)) - (((4.0d * d10) * d14) * d11)) + (d10 * d14);
    }

    public static double j(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d11 * d11;
        double d17 = d16 * d11;
        double d18 = 3.0d * d16;
        double d19 = ((((((-2.0d) * d17) * d13) + (d18 * d13)) + ((d17 * 2.0d) * d12)) - (d18 * d12)) + d12;
        double d20 = d10 * d15;
        double d21 = d10 * d14;
        return ((((d19 + (d20 * d17)) + (d17 * d21)) - (d20 * d16)) - (((d10 * 2.0d) * d14) * d16)) + (d21 * d11);
    }

    @Override // s.b
    public double c(double d10, int i10) {
        double[] dArr = this.f36593a;
        int length = dArr.length;
        int i11 = 0;
        if (d10 <= dArr[0]) {
            return this.f36594b[0][i10];
        }
        int i12 = length - 1;
        if (d10 >= dArr[i12]) {
            return this.f36594b[i12][i10];
        }
        while (i11 < i12) {
            double[] dArr2 = this.f36593a;
            double d11 = dArr2[i11];
            if (d10 == d11) {
                return this.f36594b[i11][i10];
            }
            int i13 = i11 + 1;
            double d12 = dArr2[i13];
            if (d10 < d12) {
                double d13 = d12 - d11;
                double d14 = (d10 - d11) / d13;
                double[][] dArr3 = this.f36594b;
                double d15 = dArr3[i11][i10];
                double d16 = dArr3[i13][i10];
                double[][] dArr4 = this.f36595c;
                return j(d13, d14, d15, d16, dArr4[i11][i10], dArr4[i13][i10]);
            }
            i11 = i13;
        }
        return 0.0d;
    }

    @Override // s.b
    public void d(double d10, double[] dArr) {
        double[] dArr2 = this.f36593a;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.f36594b[0].length;
        if (d10 <= dArr2[0]) {
            for (int i11 = 0; i11 < length2; i11++) {
                dArr[i11] = this.f36594b[0][i11];
            }
            return;
        }
        int i12 = length - 1;
        if (d10 >= dArr2[i12]) {
            while (i10 < length2) {
                dArr[i10] = this.f36594b[i12][i10];
                i10++;
            }
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (d10 == this.f36593a[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.f36594b[i13][i14];
                }
            }
            double[] dArr3 = this.f36593a;
            int i15 = i13 + 1;
            double d11 = dArr3[i15];
            if (d10 < d11) {
                double d12 = dArr3[i13];
                double d13 = d11 - d12;
                double d14 = (d10 - d12) / d13;
                while (i10 < length2) {
                    double[][] dArr4 = this.f36594b;
                    double d15 = dArr4[i13][i10];
                    double d16 = dArr4[i15][i10];
                    double[][] dArr5 = this.f36595c;
                    dArr[i10] = j(d13, d14, d15, d16, dArr5[i13][i10], dArr5[i15][i10]);
                    i10++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // s.b
    public void e(double d10, float[] fArr) {
        double[] dArr = this.f36593a;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.f36594b[0].length;
        if (d10 <= dArr[0]) {
            for (int i11 = 0; i11 < length2; i11++) {
                fArr[i11] = (float) this.f36594b[0][i11];
            }
            return;
        }
        int i12 = length - 1;
        if (d10 >= dArr[i12]) {
            while (i10 < length2) {
                fArr[i10] = (float) this.f36594b[i12][i10];
                i10++;
            }
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (d10 == this.f36593a[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.f36594b[i13][i14];
                }
            }
            double[] dArr2 = this.f36593a;
            int i15 = i13 + 1;
            double d11 = dArr2[i15];
            if (d10 < d11) {
                double d12 = dArr2[i13];
                double d13 = d11 - d12;
                double d14 = (d10 - d12) / d13;
                while (i10 < length2) {
                    double[][] dArr3 = this.f36594b;
                    double d15 = dArr3[i13][i10];
                    double d16 = dArr3[i15][i10];
                    double[][] dArr4 = this.f36595c;
                    fArr[i10] = (float) j(d13, d14, d15, d16, dArr4[i13][i10], dArr4[i15][i10]);
                    i10++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // s.b
    public double f(double d10, int i10) {
        double[] dArr = this.f36593a;
        int length = dArr.length;
        int i11 = 0;
        double d11 = dArr[0];
        if (d10 >= d11) {
            d11 = dArr[length - 1];
            if (d10 < d11) {
                d11 = d10;
            }
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.f36593a;
            int i12 = i11 + 1;
            double d12 = dArr2[i12];
            if (d11 <= d12) {
                double d13 = dArr2[i11];
                double d14 = d12 - d13;
                double d15 = (d11 - d13) / d14;
                double[][] dArr3 = this.f36594b;
                double d16 = dArr3[i11][i10];
                double d17 = dArr3[i12][i10];
                double[][] dArr4 = this.f36595c;
                return i(d14, d15, d16, d17, dArr4[i11][i10], dArr4[i12][i10]) / d14;
            }
            i11 = i12;
        }
        return 0.0d;
    }

    @Override // s.b
    public void g(double d10, double[] dArr) {
        double[] dArr2 = this.f36593a;
        int length = dArr2.length;
        int length2 = this.f36594b[0].length;
        double d11 = dArr2[0];
        if (d10 > d11) {
            d11 = dArr2[length - 1];
            if (d10 < d11) {
                d11 = d10;
            }
        }
        int i10 = 0;
        while (i10 < length - 1) {
            double[] dArr3 = this.f36593a;
            int i11 = i10 + 1;
            double d12 = dArr3[i11];
            if (d11 <= d12) {
                double d13 = dArr3[i10];
                double d14 = d12 - d13;
                double d15 = (d11 - d13) / d14;
                for (int i12 = 0; i12 < length2; i12++) {
                    double[][] dArr4 = this.f36594b;
                    double d16 = dArr4[i10][i12];
                    double d17 = dArr4[i11][i12];
                    double[][] dArr5 = this.f36595c;
                    dArr[i12] = i(d14, d15, d16, d17, dArr5[i10][i12], dArr5[i11][i12]) / d14;
                }
                return;
            }
            i10 = i11;
        }
    }

    @Override // s.b
    public double[] h() {
        return this.f36593a;
    }
}
