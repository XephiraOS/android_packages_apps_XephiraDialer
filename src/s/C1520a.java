package s;

import java.util.Arrays;

/* compiled from: ArcCurveFit.java */
/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1520a extends b {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f36558a;

    /* renamed from: b, reason: collision with root package name */
    public C0351a[] f36559b;

    /* compiled from: ArcCurveFit.java */
    /* renamed from: s.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0351a {

        /* renamed from: s, reason: collision with root package name */
        public static double[] f36560s = new double[91];

        /* renamed from: a, reason: collision with root package name */
        public double[] f36561a;

        /* renamed from: b, reason: collision with root package name */
        public double f36562b;

        /* renamed from: c, reason: collision with root package name */
        public double f36563c;

        /* renamed from: d, reason: collision with root package name */
        public double f36564d;

        /* renamed from: e, reason: collision with root package name */
        public double f36565e;

        /* renamed from: f, reason: collision with root package name */
        public double f36566f;

        /* renamed from: g, reason: collision with root package name */
        public double f36567g;

        /* renamed from: h, reason: collision with root package name */
        public double f36568h;

        /* renamed from: i, reason: collision with root package name */
        public double f36569i;

        /* renamed from: j, reason: collision with root package name */
        public double f36570j;

        /* renamed from: k, reason: collision with root package name */
        public double f36571k;

        /* renamed from: l, reason: collision with root package name */
        public double f36572l;

        /* renamed from: m, reason: collision with root package name */
        public double f36573m;

        /* renamed from: n, reason: collision with root package name */
        public double f36574n;

        /* renamed from: o, reason: collision with root package name */
        public double f36575o;

        /* renamed from: p, reason: collision with root package name */
        public double f36576p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f36577q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f36578r;

        public C0351a(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
            int i11;
            double d16;
            double d17;
            this.f36578r = false;
            this.f36577q = i10 == 1;
            this.f36563c = d10;
            this.f36564d = d11;
            this.f36569i = 1.0d / (d11 - d10);
            if (3 == i10) {
                this.f36578r = true;
            }
            double d18 = d14 - d12;
            double d19 = d15 - d13;
            if (!this.f36578r && Math.abs(d18) >= 0.001d && Math.abs(d19) >= 0.001d) {
                this.f36561a = new double[101];
                boolean z10 = this.f36577q;
                if (z10) {
                    i11 = -1;
                } else {
                    i11 = 1;
                }
                this.f36570j = d18 * i11;
                this.f36571k = d19 * (z10 ? 1 : -1);
                if (z10) {
                    d16 = d14;
                } else {
                    d16 = d12;
                }
                this.f36572l = d16;
                if (z10) {
                    d17 = d13;
                } else {
                    d17 = d15;
                }
                this.f36573m = d17;
                a(d12, d13, d14, d15);
                this.f36574n = this.f36562b * this.f36569i;
                return;
            }
            this.f36578r = true;
            this.f36565e = d12;
            this.f36566f = d14;
            this.f36567g = d13;
            this.f36568h = d15;
            double hypot = Math.hypot(d19, d18);
            this.f36562b = hypot;
            this.f36574n = hypot * this.f36569i;
            double d20 = this.f36564d;
            double d21 = this.f36563c;
            this.f36572l = d18 / (d20 - d21);
            this.f36573m = d19 / (d20 - d21);
        }

        public final void a(double d10, double d11, double d12, double d13) {
            double d14;
            double d15 = d12 - d10;
            double d16 = d11 - d13;
            int i10 = 0;
            double d17 = 0.0d;
            double d18 = 0.0d;
            double d19 = 0.0d;
            while (true) {
                if (i10 >= f36560s.length) {
                    break;
                }
                double d20 = d17;
                double radians = Math.toRadians((i10 * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d15;
                double cos = Math.cos(radians) * d16;
                if (i10 > 0) {
                    d14 = Math.hypot(sin - d18, cos - d19) + d20;
                    f36560s[i10] = d14;
                } else {
                    d14 = d20;
                }
                i10++;
                d19 = cos;
                d17 = d14;
                d18 = sin;
            }
            double d21 = d17;
            this.f36562b = d21;
            int i11 = 0;
            while (true) {
                double[] dArr = f36560s;
                if (i11 >= dArr.length) {
                    break;
                }
                dArr[i11] = dArr[i11] / d21;
                i11++;
            }
            int i12 = 0;
            while (true) {
                if (i12 < this.f36561a.length) {
                    double length = i12 / (r1.length - 1);
                    int binarySearch = Arrays.binarySearch(f36560s, length);
                    if (binarySearch >= 0) {
                        this.f36561a[i12] = binarySearch / (f36560s.length - 1);
                    } else if (binarySearch == -1) {
                        this.f36561a[i12] = 0.0d;
                    } else {
                        int i13 = -binarySearch;
                        int i14 = i13 - 2;
                        double[] dArr2 = f36560s;
                        double d22 = dArr2[i14];
                        this.f36561a[i12] = (i14 + ((length - d22) / (dArr2[i13 - 1] - d22))) / (dArr2.length - 1);
                    }
                    i12++;
                } else {
                    return;
                }
            }
        }

        public double b() {
            double d10 = this.f36570j * this.f36576p;
            double hypot = this.f36574n / Math.hypot(d10, (-this.f36571k) * this.f36575o);
            if (this.f36577q) {
                d10 = -d10;
            }
            return d10 * hypot;
        }

        public double c() {
            double d10 = this.f36570j * this.f36576p;
            double d11 = (-this.f36571k) * this.f36575o;
            double hypot = this.f36574n / Math.hypot(d10, d11);
            if (this.f36577q) {
                return (-d11) * hypot;
            }
            return d11 * hypot;
        }

        public double d(double d10) {
            return this.f36572l;
        }

        public double e(double d10) {
            return this.f36573m;
        }

        public double f(double d10) {
            double d11 = (d10 - this.f36563c) * this.f36569i;
            double d12 = this.f36565e;
            return d12 + (d11 * (this.f36566f - d12));
        }

        public double g(double d10) {
            double d11 = (d10 - this.f36563c) * this.f36569i;
            double d12 = this.f36567g;
            return d12 + (d11 * (this.f36568h - d12));
        }

        public double h() {
            return this.f36572l + (this.f36570j * this.f36575o);
        }

        public double i() {
            return this.f36573m + (this.f36571k * this.f36576p);
        }

        public double j(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f36561a;
            double length = d10 * (dArr.length - 1);
            int i10 = (int) length;
            double d11 = length - i10;
            double d12 = dArr[i10];
            return d12 + (d11 * (dArr[i10 + 1] - d12));
        }

        public void k(double d10) {
            double d11;
            if (this.f36577q) {
                d11 = this.f36564d - d10;
            } else {
                d11 = d10 - this.f36563c;
            }
            double j10 = j(d11 * this.f36569i) * 1.5707963267948966d;
            this.f36575o = Math.sin(j10);
            this.f36576p = Math.cos(j10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r5 == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1520a(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r0.f36558a = r1
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            s.a$a[] r2 = new s.C1520a.C0351a[r2]
            r0.f36559b = r2
            r2 = 0
            r4 = r2
            r5 = r3
            r6 = r5
        L14:
            s.a$a[] r7 = r0.f36559b
            int r8 = r7.length
            if (r4 >= r8) goto L4f
            r8 = r25[r4]
            r9 = 3
            if (r8 == 0) goto L2f
            if (r8 == r3) goto L2d
            r10 = 2
            if (r8 == r10) goto L2b
            if (r8 == r9) goto L26
            goto L30
        L26:
            if (r5 != r3) goto L2d
            goto L2b
        L29:
            r6 = r5
            goto L30
        L2b:
            r5 = r10
            goto L29
        L2d:
            r5 = r3
            goto L29
        L2f:
            r6 = r9
        L30:
            s.a$a r22 = new s.a$a
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r2]
            r16 = r8[r3]
            r8 = r27[r23]
            r18 = r8[r2]
            r20 = r8[r3]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L14
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s.C1520a.<init>(int[], double[], double[][]):void");
    }

    @Override // s.b
    public double c(double d10, int i10) {
        C0351a[] c0351aArr = this.f36559b;
        int i11 = 0;
        double d11 = c0351aArr[0].f36563c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > c0351aArr[c0351aArr.length - 1].f36564d) {
            d10 = c0351aArr[c0351aArr.length - 1].f36564d;
        }
        while (true) {
            C0351a[] c0351aArr2 = this.f36559b;
            if (i11 < c0351aArr2.length) {
                C0351a c0351a = c0351aArr2[i11];
                if (d10 <= c0351a.f36564d) {
                    if (c0351a.f36578r) {
                        if (i10 == 0) {
                            return c0351a.f(d10);
                        }
                        return c0351a.g(d10);
                    }
                    c0351a.k(d10);
                    if (i10 == 0) {
                        return this.f36559b[i11].h();
                    }
                    return this.f36559b[i11].i();
                }
                i11++;
            } else {
                return Double.NaN;
            }
        }
    }

    @Override // s.b
    public void d(double d10, double[] dArr) {
        C0351a[] c0351aArr = this.f36559b;
        double d11 = c0351aArr[0].f36563c;
        if (d10 < d11) {
            d10 = d11;
        }
        if (d10 > c0351aArr[c0351aArr.length - 1].f36564d) {
            d10 = c0351aArr[c0351aArr.length - 1].f36564d;
        }
        int i10 = 0;
        while (true) {
            C0351a[] c0351aArr2 = this.f36559b;
            if (i10 < c0351aArr2.length) {
                C0351a c0351a = c0351aArr2[i10];
                if (d10 <= c0351a.f36564d) {
                    if (c0351a.f36578r) {
                        dArr[0] = c0351a.f(d10);
                        dArr[1] = this.f36559b[i10].g(d10);
                        return;
                    } else {
                        c0351a.k(d10);
                        dArr[0] = this.f36559b[i10].h();
                        dArr[1] = this.f36559b[i10].i();
                        return;
                    }
                }
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // s.b
    public void e(double d10, float[] fArr) {
        C0351a[] c0351aArr = this.f36559b;
        double d11 = c0351aArr[0].f36563c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > c0351aArr[c0351aArr.length - 1].f36564d) {
            d10 = c0351aArr[c0351aArr.length - 1].f36564d;
        }
        int i10 = 0;
        while (true) {
            C0351a[] c0351aArr2 = this.f36559b;
            if (i10 < c0351aArr2.length) {
                C0351a c0351a = c0351aArr2[i10];
                if (d10 <= c0351a.f36564d) {
                    if (c0351a.f36578r) {
                        fArr[0] = (float) c0351a.f(d10);
                        fArr[1] = (float) this.f36559b[i10].g(d10);
                        return;
                    } else {
                        c0351a.k(d10);
                        fArr[0] = (float) this.f36559b[i10].h();
                        fArr[1] = (float) this.f36559b[i10].i();
                        return;
                    }
                }
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // s.b
    public double f(double d10, int i10) {
        C0351a[] c0351aArr = this.f36559b;
        int i11 = 0;
        double d11 = c0351aArr[0].f36563c;
        if (d10 < d11) {
            d10 = d11;
        }
        if (d10 > c0351aArr[c0351aArr.length - 1].f36564d) {
            d10 = c0351aArr[c0351aArr.length - 1].f36564d;
        }
        while (true) {
            C0351a[] c0351aArr2 = this.f36559b;
            if (i11 < c0351aArr2.length) {
                C0351a c0351a = c0351aArr2[i11];
                if (d10 <= c0351a.f36564d) {
                    if (c0351a.f36578r) {
                        if (i10 == 0) {
                            return c0351a.d(d10);
                        }
                        return c0351a.e(d10);
                    }
                    c0351a.k(d10);
                    if (i10 == 0) {
                        return this.f36559b[i11].b();
                    }
                    return this.f36559b[i11].c();
                }
                i11++;
            } else {
                return Double.NaN;
            }
        }
    }

    @Override // s.b
    public void g(double d10, double[] dArr) {
        C0351a[] c0351aArr = this.f36559b;
        double d11 = c0351aArr[0].f36563c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > c0351aArr[c0351aArr.length - 1].f36564d) {
            d10 = c0351aArr[c0351aArr.length - 1].f36564d;
        }
        int i10 = 0;
        while (true) {
            C0351a[] c0351aArr2 = this.f36559b;
            if (i10 < c0351aArr2.length) {
                C0351a c0351a = c0351aArr2[i10];
                if (d10 <= c0351a.f36564d) {
                    if (c0351a.f36578r) {
                        dArr[0] = c0351a.d(d10);
                        dArr[1] = this.f36559b[i10].e(d10);
                        return;
                    } else {
                        c0351a.k(d10);
                        dArr[0] = this.f36559b[i10].b();
                        dArr[1] = this.f36559b[i10].c();
                        return;
                    }
                }
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // s.b
    public double[] h() {
        return this.f36558a;
    }
}
