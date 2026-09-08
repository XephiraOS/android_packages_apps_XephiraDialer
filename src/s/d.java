package s;

/* compiled from: LinearCurveFit.java */
/* loaded from: classes.dex */
public class d extends b {

    /* renamed from: a, reason: collision with root package name */
    public double[] f36590a;

    /* renamed from: b, reason: collision with root package name */
    public double[][] f36591b;

    /* renamed from: c, reason: collision with root package name */
    public double f36592c;

    public d(double[] dArr, double[][] dArr2) {
        this.f36592c = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f36590a = dArr;
        this.f36591b = dArr2;
        if (length2 > 2) {
            int i10 = 0;
            double d10 = 0.0d;
            while (true) {
                double d11 = d10;
                if (i10 < dArr.length) {
                    double d12 = dArr2[i10][0];
                    if (i10 > 0) {
                        Math.hypot(d12 - d10, d12 - d11);
                    }
                    i10++;
                    d10 = d12;
                } else {
                    this.f36592c = 0.0d;
                    return;
                }
            }
        }
    }

    @Override // s.b
    public double c(double d10, int i10) {
        double[] dArr = this.f36590a;
        int length = dArr.length;
        int i11 = 0;
        if (d10 <= dArr[0]) {
            return this.f36591b[0][i10];
        }
        int i12 = length - 1;
        if (d10 >= dArr[i12]) {
            return this.f36591b[i12][i10];
        }
        while (i11 < i12) {
            double[] dArr2 = this.f36590a;
            double d11 = dArr2[i11];
            if (d10 == d11) {
                return this.f36591b[i11][i10];
            }
            int i13 = i11 + 1;
            double d12 = dArr2[i13];
            if (d10 < d12) {
                double d13 = (d10 - d11) / (d12 - d11);
                double[][] dArr3 = this.f36591b;
                return (dArr3[i11][i10] * (1.0d - d13)) + (dArr3[i13][i10] * d13);
            }
            i11 = i13;
        }
        return 0.0d;
    }

    @Override // s.b
    public void d(double d10, double[] dArr) {
        double[] dArr2 = this.f36590a;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.f36591b[0].length;
        if (d10 <= dArr2[0]) {
            for (int i11 = 0; i11 < length2; i11++) {
                dArr[i11] = this.f36591b[0][i11];
            }
            return;
        }
        int i12 = length - 1;
        if (d10 >= dArr2[i12]) {
            while (i10 < length2) {
                dArr[i10] = this.f36591b[i12][i10];
                i10++;
            }
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (d10 == this.f36590a[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.f36591b[i13][i14];
                }
            }
            double[] dArr3 = this.f36590a;
            int i15 = i13 + 1;
            double d11 = dArr3[i15];
            if (d10 < d11) {
                double d12 = dArr3[i13];
                double d13 = (d10 - d12) / (d11 - d12);
                while (i10 < length2) {
                    double[][] dArr4 = this.f36591b;
                    dArr[i10] = (dArr4[i13][i10] * (1.0d - d13)) + (dArr4[i15][i10] * d13);
                    i10++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // s.b
    public void e(double d10, float[] fArr) {
        double[] dArr = this.f36590a;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.f36591b[0].length;
        if (d10 <= dArr[0]) {
            for (int i11 = 0; i11 < length2; i11++) {
                fArr[i11] = (float) this.f36591b[0][i11];
            }
            return;
        }
        int i12 = length - 1;
        if (d10 >= dArr[i12]) {
            while (i10 < length2) {
                fArr[i10] = (float) this.f36591b[i12][i10];
                i10++;
            }
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (d10 == this.f36590a[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.f36591b[i13][i14];
                }
            }
            double[] dArr2 = this.f36590a;
            int i15 = i13 + 1;
            double d11 = dArr2[i15];
            if (d10 < d11) {
                double d12 = dArr2[i13];
                double d13 = (d10 - d12) / (d11 - d12);
                while (i10 < length2) {
                    double[][] dArr3 = this.f36591b;
                    fArr[i10] = (float) ((dArr3[i13][i10] * (1.0d - d13)) + (dArr3[i15][i10] * d13));
                    i10++;
                }
                return;
            }
            i13 = i15;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r8 >= r3) goto L4;
     */
    @Override // s.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double f(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.f36590a
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.f36590a
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r7 = r7.f36591b
            r8 = r7[r2]
            r8 = r8[r10]
            r7 = r7[r3]
            r0 = r7[r10]
            double r0 = r0 - r8
            double r0 = r0 / r4
            return r0
        L33:
            r2 = r3
            goto L15
        L35:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s.d.f(double, int):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r11 >= r4) goto L4;
     */
    @Override // s.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(double r11, double[] r13) {
        /*
            r10 = this;
            double[] r0 = r10.f36590a
            int r1 = r0.length
            double[][] r2 = r10.f36591b
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r11 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = r3
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r10.f36590a
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r11 = r4[r0]
            double r6 = r6 - r11
        L2c:
            if (r3 >= r2) goto L41
            double[][] r11 = r10.f36591b
            r12 = r11[r0]
            r8 = r12[r3]
            r11 = r11[r5]
            r11 = r11[r3]
            double r11 = r11 - r8
            double r11 = r11 / r6
            r13[r3] = r11
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s.d.g(double, double[]):void");
    }

    @Override // s.b
    public double[] h() {
        return this.f36590a;
    }
}
