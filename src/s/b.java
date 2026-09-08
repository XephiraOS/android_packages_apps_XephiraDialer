package s;

/* compiled from: CurveFit.java */
/* loaded from: classes.dex */
public abstract class b {

    /* compiled from: CurveFit.java */
    /* loaded from: classes.dex */
    public static class a extends b {

        /* renamed from: a, reason: collision with root package name */
        public double f36579a;

        /* renamed from: b, reason: collision with root package name */
        public double[] f36580b;

        public a(double d10, double[] dArr) {
            this.f36579a = d10;
            this.f36580b = dArr;
        }

        @Override // s.b
        public double c(double d10, int i10) {
            return this.f36580b[i10];
        }

        @Override // s.b
        public void d(double d10, double[] dArr) {
            double[] dArr2 = this.f36580b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // s.b
        public void e(double d10, float[] fArr) {
            int i10 = 0;
            while (true) {
                double[] dArr = this.f36580b;
                if (i10 < dArr.length) {
                    fArr[i10] = (float) dArr[i10];
                    i10++;
                } else {
                    return;
                }
            }
        }

        @Override // s.b
        public double f(double d10, int i10) {
            return 0.0d;
        }

        @Override // s.b
        public void g(double d10, double[] dArr) {
            for (int i10 = 0; i10 < this.f36580b.length; i10++) {
                dArr[i10] = 0.0d;
            }
        }

        @Override // s.b
        public double[] h() {
            return new double[]{this.f36579a};
        }
    }

    public static b a(int i10, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i10 = 2;
        }
        if (i10 != 0) {
            if (i10 != 2) {
                return new d(dArr, dArr2);
            }
            return new a(dArr[0], dArr2[0]);
        }
        return new e(dArr, dArr2);
    }

    public static b b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new C1520a(iArr, dArr, dArr2);
    }

    public abstract double c(double d10, int i10);

    public abstract void d(double d10, double[] dArr);

    public abstract void e(double d10, float[] fArr);

    public abstract double f(double d10, int i10);

    public abstract void g(double d10, double[] dArr);

    public abstract double[] h();
}
