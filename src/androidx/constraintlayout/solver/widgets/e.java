package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Flow.java */
/* loaded from: classes.dex */
public class e extends h {

    /* renamed from: z1, reason: collision with root package name */
    public ConstraintWidget[] f8526z1;

    /* renamed from: c1, reason: collision with root package name */
    public int f8503c1 = -1;

    /* renamed from: d1, reason: collision with root package name */
    public int f8504d1 = -1;

    /* renamed from: e1, reason: collision with root package name */
    public int f8505e1 = -1;

    /* renamed from: f1, reason: collision with root package name */
    public int f8506f1 = -1;

    /* renamed from: g1, reason: collision with root package name */
    public int f8507g1 = -1;

    /* renamed from: h1, reason: collision with root package name */
    public int f8508h1 = -1;

    /* renamed from: i1, reason: collision with root package name */
    public float f8509i1 = 0.5f;

    /* renamed from: j1, reason: collision with root package name */
    public float f8510j1 = 0.5f;

    /* renamed from: k1, reason: collision with root package name */
    public float f8511k1 = 0.5f;

    /* renamed from: l1, reason: collision with root package name */
    public float f8512l1 = 0.5f;

    /* renamed from: m1, reason: collision with root package name */
    public float f8513m1 = 0.5f;

    /* renamed from: n1, reason: collision with root package name */
    public float f8514n1 = 0.5f;

    /* renamed from: o1, reason: collision with root package name */
    public int f8515o1 = 0;

    /* renamed from: p1, reason: collision with root package name */
    public int f8516p1 = 0;

    /* renamed from: q1, reason: collision with root package name */
    public int f8517q1 = 2;

    /* renamed from: r1, reason: collision with root package name */
    public int f8518r1 = 2;

    /* renamed from: s1, reason: collision with root package name */
    public int f8519s1 = 0;

    /* renamed from: t1, reason: collision with root package name */
    public int f8520t1 = -1;

    /* renamed from: u1, reason: collision with root package name */
    public int f8521u1 = 0;

    /* renamed from: v1, reason: collision with root package name */
    public ArrayList<a> f8522v1 = new ArrayList<>();

    /* renamed from: w1, reason: collision with root package name */
    public ConstraintWidget[] f8523w1 = null;

    /* renamed from: x1, reason: collision with root package name */
    public ConstraintWidget[] f8524x1 = null;

    /* renamed from: y1, reason: collision with root package name */
    public int[] f8525y1 = null;

    /* renamed from: A1, reason: collision with root package name */
    public int f8502A1 = 0;

    /* compiled from: Flow.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f8527a;

        /* renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f8530d;

        /* renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f8531e;

        /* renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f8532f;

        /* renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f8533g;

        /* renamed from: h, reason: collision with root package name */
        public int f8534h;

        /* renamed from: i, reason: collision with root package name */
        public int f8535i;

        /* renamed from: j, reason: collision with root package name */
        public int f8536j;

        /* renamed from: k, reason: collision with root package name */
        public int f8537k;

        /* renamed from: q, reason: collision with root package name */
        public int f8543q;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget f8528b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f8529c = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f8538l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f8539m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f8540n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f8541o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f8542p = 0;

        public a(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11) {
            this.f8534h = 0;
            this.f8535i = 0;
            this.f8536j = 0;
            this.f8537k = 0;
            this.f8543q = 0;
            this.f8527a = i10;
            this.f8530d = constraintAnchor;
            this.f8531e = constraintAnchor2;
            this.f8532f = constraintAnchor3;
            this.f8533g = constraintAnchor4;
            this.f8534h = e.this.l1();
            this.f8535i = e.this.n1();
            this.f8536j = e.this.m1();
            this.f8537k = e.this.k1();
            this.f8543q = i11;
        }

        public void b(ConstraintWidget constraintWidget) {
            int i10 = 0;
            if (this.f8527a == 0) {
                int X12 = e.this.X1(constraintWidget, this.f8543q);
                if (constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f8542p++;
                    X12 = 0;
                }
                int i11 = e.this.f8515o1;
                if (constraintWidget.T() != 8) {
                    i10 = i11;
                }
                this.f8538l += X12 + i10;
                int W12 = e.this.W1(constraintWidget, this.f8543q);
                if (this.f8528b == null || this.f8529c < W12) {
                    this.f8528b = constraintWidget;
                    this.f8529c = W12;
                    this.f8539m = W12;
                }
            } else {
                int X13 = e.this.X1(constraintWidget, this.f8543q);
                int W13 = e.this.W1(constraintWidget, this.f8543q);
                if (constraintWidget.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f8542p++;
                    W13 = 0;
                }
                int i12 = e.this.f8516p1;
                if (constraintWidget.T() != 8) {
                    i10 = i12;
                }
                this.f8539m += W13 + i10;
                if (this.f8528b == null || this.f8529c < X13) {
                    this.f8528b = constraintWidget;
                    this.f8529c = X13;
                    this.f8538l = X13;
                }
            }
            this.f8541o++;
        }

        public void c() {
            this.f8529c = 0;
            this.f8528b = null;
            this.f8538l = 0;
            this.f8539m = 0;
            this.f8540n = 0;
            this.f8541o = 0;
            this.f8542p = 0;
        }

        public void d(boolean z10, int i10, boolean z11) {
            ConstraintWidget constraintWidget;
            char c10;
            int i11 = this.f8541o;
            for (int i12 = 0; i12 < i11 && this.f8540n + i12 < e.this.f8502A1; i12++) {
                ConstraintWidget constraintWidget2 = e.this.f8526z1[this.f8540n + i12];
                if (constraintWidget2 != null) {
                    constraintWidget2.l0();
                }
            }
            if (i11 == 0 || this.f8528b == null) {
                return;
            }
            boolean z12 = z11 && i10 == 0;
            int i13 = -1;
            int i14 = -1;
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = z10 ? (i11 - 1) - i15 : i15;
                if (this.f8540n + i16 >= e.this.f8502A1) {
                    break;
                }
                if (e.this.f8526z1[this.f8540n + i16].T() == 0) {
                    if (i13 == -1) {
                        i13 = i15;
                    }
                    i14 = i15;
                }
            }
            ConstraintWidget constraintWidget3 = null;
            if (this.f8527a == 0) {
                ConstraintWidget constraintWidget4 = this.f8528b;
                constraintWidget4.S0(e.this.f8504d1);
                int i17 = this.f8535i;
                if (i10 > 0) {
                    i17 += e.this.f8516p1;
                }
                constraintWidget4.f8328K.a(this.f8531e, i17);
                if (z11) {
                    constraintWidget4.f8332M.a(this.f8533g, this.f8537k);
                }
                if (i10 > 0) {
                    this.f8531e.f8290d.f8332M.a(constraintWidget4.f8328K, 0);
                }
                if (e.this.f8518r1 == 3 && !constraintWidget4.X()) {
                    for (int i18 = 0; i18 < i11; i18++) {
                        int i19 = z10 ? (i11 - 1) - i18 : i18;
                        if (this.f8540n + i19 >= e.this.f8502A1) {
                            break;
                        }
                        constraintWidget = e.this.f8526z1[this.f8540n + i19];
                        if (constraintWidget.X()) {
                            break;
                        }
                    }
                }
                constraintWidget = constraintWidget4;
                int i20 = 0;
                while (i20 < i11) {
                    int i21 = z10 ? (i11 - 1) - i20 : i20;
                    if (this.f8540n + i21 >= e.this.f8502A1) {
                        return;
                    }
                    ConstraintWidget constraintWidget5 = e.this.f8526z1[this.f8540n + i21];
                    if (i20 == 0) {
                        constraintWidget5.k(constraintWidget5.f8326J, this.f8530d, this.f8534h);
                    }
                    if (i21 == 0) {
                        int i22 = e.this.f8503c1;
                        float f10 = e.this.f8509i1;
                        if (this.f8540n != 0 || e.this.f8505e1 == -1) {
                            if (z11 && e.this.f8507g1 != -1) {
                                i22 = e.this.f8507g1;
                                f10 = e.this.f8513m1;
                            }
                        } else {
                            i22 = e.this.f8505e1;
                            f10 = e.this.f8511k1;
                        }
                        constraintWidget5.B0(i22);
                        constraintWidget5.A0(f10);
                    }
                    if (i20 == i11 - 1) {
                        constraintWidget5.k(constraintWidget5.f8330L, this.f8532f, this.f8536j);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget5.f8326J.a(constraintWidget3.f8330L, e.this.f8515o1);
                        if (i20 == i13) {
                            constraintWidget5.f8326J.u(this.f8534h);
                        }
                        constraintWidget3.f8330L.a(constraintWidget5.f8326J, 0);
                        if (i20 == i14 + 1) {
                            constraintWidget3.f8330L.u(this.f8536j);
                        }
                    }
                    if (constraintWidget5 != constraintWidget4) {
                        c10 = 3;
                        if (e.this.f8518r1 != 3 || !constraintWidget.X() || constraintWidget5 == constraintWidget || !constraintWidget5.X()) {
                            int i23 = e.this.f8518r1;
                            if (i23 == 0) {
                                constraintWidget5.f8328K.a(constraintWidget4.f8328K, 0);
                            } else if (i23 == 1) {
                                constraintWidget5.f8332M.a(constraintWidget4.f8332M, 0);
                            } else if (z12) {
                                constraintWidget5.f8328K.a(this.f8531e, this.f8535i);
                                constraintWidget5.f8332M.a(this.f8533g, this.f8537k);
                            } else {
                                constraintWidget5.f8328K.a(constraintWidget4.f8328K, 0);
                                constraintWidget5.f8332M.a(constraintWidget4.f8332M, 0);
                            }
                        } else {
                            constraintWidget5.f8333N.a(constraintWidget.f8333N, 0);
                        }
                    } else {
                        c10 = 3;
                    }
                    i20++;
                    constraintWidget3 = constraintWidget5;
                }
                return;
            }
            ConstraintWidget constraintWidget6 = this.f8528b;
            constraintWidget6.B0(e.this.f8503c1);
            int i24 = this.f8534h;
            if (i10 > 0) {
                i24 += e.this.f8515o1;
            }
            if (z10) {
                constraintWidget6.f8330L.a(this.f8532f, i24);
                if (z11) {
                    constraintWidget6.f8326J.a(this.f8530d, this.f8536j);
                }
                if (i10 > 0) {
                    this.f8532f.f8290d.f8326J.a(constraintWidget6.f8330L, 0);
                }
            } else {
                constraintWidget6.f8326J.a(this.f8530d, i24);
                if (z11) {
                    constraintWidget6.f8330L.a(this.f8532f, this.f8536j);
                }
                if (i10 > 0) {
                    this.f8530d.f8290d.f8330L.a(constraintWidget6.f8326J, 0);
                }
            }
            int i25 = 0;
            while (i25 < i11 && this.f8540n + i25 < e.this.f8502A1) {
                ConstraintWidget constraintWidget7 = e.this.f8526z1[this.f8540n + i25];
                if (i25 == 0) {
                    constraintWidget7.k(constraintWidget7.f8328K, this.f8531e, this.f8535i);
                    int i26 = e.this.f8504d1;
                    float f11 = e.this.f8510j1;
                    if (this.f8540n != 0 || e.this.f8506f1 == -1) {
                        if (z11 && e.this.f8508h1 != -1) {
                            i26 = e.this.f8508h1;
                            f11 = e.this.f8514n1;
                        }
                    } else {
                        i26 = e.this.f8506f1;
                        f11 = e.this.f8512l1;
                    }
                    constraintWidget7.S0(i26);
                    constraintWidget7.R0(f11);
                }
                if (i25 == i11 - 1) {
                    constraintWidget7.k(constraintWidget7.f8332M, this.f8533g, this.f8537k);
                }
                if (constraintWidget3 != null) {
                    constraintWidget7.f8328K.a(constraintWidget3.f8332M, e.this.f8516p1);
                    if (i25 == i13) {
                        constraintWidget7.f8328K.u(this.f8535i);
                    }
                    constraintWidget3.f8332M.a(constraintWidget7.f8328K, 0);
                    if (i25 == i14 + 1) {
                        constraintWidget3.f8332M.u(this.f8537k);
                    }
                }
                if (constraintWidget7 != constraintWidget6) {
                    if (z10) {
                        int i27 = e.this.f8517q1;
                        if (i27 == 0) {
                            constraintWidget7.f8330L.a(constraintWidget6.f8330L, 0);
                        } else if (i27 == 1) {
                            constraintWidget7.f8326J.a(constraintWidget6.f8326J, 0);
                        } else if (i27 == 2) {
                            constraintWidget7.f8326J.a(constraintWidget6.f8326J, 0);
                            constraintWidget7.f8330L.a(constraintWidget6.f8330L, 0);
                        }
                    } else {
                        int i28 = e.this.f8517q1;
                        if (i28 == 0) {
                            constraintWidget7.f8326J.a(constraintWidget6.f8326J, 0);
                        } else if (i28 == 1) {
                            constraintWidget7.f8330L.a(constraintWidget6.f8330L, 0);
                        } else if (i28 == 2) {
                            if (z12) {
                                constraintWidget7.f8326J.a(this.f8530d, this.f8534h);
                                constraintWidget7.f8330L.a(this.f8532f, this.f8536j);
                            } else {
                                constraintWidget7.f8326J.a(constraintWidget6.f8326J, 0);
                                constraintWidget7.f8330L.a(constraintWidget6.f8330L, 0);
                            }
                        }
                        i25++;
                        constraintWidget3 = constraintWidget7;
                    }
                }
                i25++;
                constraintWidget3 = constraintWidget7;
            }
        }

        public int e() {
            if (this.f8527a == 1) {
                return this.f8539m - e.this.f8516p1;
            }
            return this.f8539m;
        }

        public int f() {
            if (this.f8527a == 0) {
                return this.f8538l - e.this.f8515o1;
            }
            return this.f8538l;
        }

        public void g(int i10) {
            int i11 = this.f8542p;
            if (i11 == 0) {
                return;
            }
            int i12 = this.f8541o;
            int i13 = i10 / i11;
            for (int i14 = 0; i14 < i12 && this.f8540n + i14 < e.this.f8502A1; i14++) {
                ConstraintWidget constraintWidget = e.this.f8526z1[this.f8540n + i14];
                if (this.f8527a == 0) {
                    if (constraintWidget != null && constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f8376p == 0) {
                        e.this.p1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i13, constraintWidget.R(), constraintWidget.y());
                    }
                } else if (constraintWidget != null && constraintWidget.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f8378q == 0) {
                    e.this.p1(constraintWidget, constraintWidget.B(), constraintWidget.U(), ConstraintWidget.DimensionBehaviour.FIXED, i13);
                }
            }
            h();
        }

        public final void h() {
            this.f8538l = 0;
            this.f8539m = 0;
            this.f8528b = null;
            this.f8529c = 0;
            int i10 = this.f8541o;
            for (int i11 = 0; i11 < i10 && this.f8540n + i11 < e.this.f8502A1; i11++) {
                ConstraintWidget constraintWidget = e.this.f8526z1[this.f8540n + i11];
                if (this.f8527a != 0) {
                    int X12 = e.this.X1(constraintWidget, this.f8543q);
                    int W12 = e.this.W1(constraintWidget, this.f8543q);
                    int i12 = e.this.f8516p1;
                    if (constraintWidget.T() == 8) {
                        i12 = 0;
                    }
                    this.f8539m += W12 + i12;
                    if (this.f8528b == null || this.f8529c < X12) {
                        this.f8528b = constraintWidget;
                        this.f8529c = X12;
                        this.f8538l = X12;
                    }
                } else {
                    int U10 = constraintWidget.U();
                    int i13 = e.this.f8515o1;
                    if (constraintWidget.T() == 8) {
                        i13 = 0;
                    }
                    this.f8538l += U10 + i13;
                    int W13 = e.this.W1(constraintWidget, this.f8543q);
                    if (this.f8528b == null || this.f8529c < W13) {
                        this.f8528b = constraintWidget;
                        this.f8529c = W13;
                        this.f8539m = W13;
                    }
                }
            }
        }

        public void i(int i10) {
            this.f8540n = i10;
        }

        public void j(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11, int i12, int i13, int i14, int i15) {
            this.f8527a = i10;
            this.f8530d = constraintAnchor;
            this.f8531e = constraintAnchor2;
            this.f8532f = constraintAnchor3;
            this.f8533g = constraintAnchor4;
            this.f8534h = i11;
            this.f8535i = i12;
            this.f8536j = i13;
            this.f8537k = i14;
            this.f8543q = i15;
        }
    }

    public final void V1(boolean z10) {
        ConstraintWidget constraintWidget;
        int i10;
        if (this.f8525y1 != null && this.f8524x1 != null && this.f8523w1 != null) {
            for (int i11 = 0; i11 < this.f8502A1; i11++) {
                this.f8526z1[i11].l0();
            }
            int[] iArr = this.f8525y1;
            int i12 = iArr[0];
            int i13 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            for (int i14 = 0; i14 < i12; i14++) {
                if (z10) {
                    i10 = (i12 - i14) - 1;
                } else {
                    i10 = i14;
                }
                ConstraintWidget constraintWidget3 = this.f8524x1[i10];
                if (constraintWidget3 != null && constraintWidget3.T() != 8) {
                    if (i14 == 0) {
                        constraintWidget3.k(constraintWidget3.f8326J, this.f8326J, l1());
                        constraintWidget3.B0(this.f8503c1);
                        constraintWidget3.A0(this.f8509i1);
                    }
                    if (i14 == i12 - 1) {
                        constraintWidget3.k(constraintWidget3.f8330L, this.f8330L, m1());
                    }
                    if (i14 > 0) {
                        constraintWidget3.k(constraintWidget3.f8326J, constraintWidget2.f8330L, this.f8515o1);
                        constraintWidget2.k(constraintWidget2.f8330L, constraintWidget3.f8326J, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
            }
            for (int i15 = 0; i15 < i13; i15++) {
                ConstraintWidget constraintWidget4 = this.f8523w1[i15];
                if (constraintWidget4 != null && constraintWidget4.T() != 8) {
                    if (i15 == 0) {
                        constraintWidget4.k(constraintWidget4.f8328K, this.f8328K, n1());
                        constraintWidget4.S0(this.f8504d1);
                        constraintWidget4.R0(this.f8510j1);
                    }
                    if (i15 == i13 - 1) {
                        constraintWidget4.k(constraintWidget4.f8332M, this.f8332M, k1());
                    }
                    if (i15 > 0) {
                        constraintWidget4.k(constraintWidget4.f8328K, constraintWidget2.f8332M, this.f8516p1);
                        constraintWidget2.k(constraintWidget2.f8332M, constraintWidget4.f8328K, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i16 = 0; i16 < i12; i16++) {
                for (int i17 = 0; i17 < i13; i17++) {
                    int i18 = (i17 * i12) + i16;
                    if (this.f8521u1 == 1) {
                        i18 = (i16 * i13) + i17;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.f8526z1;
                    if (i18 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i18]) != null && constraintWidget.T() != 8) {
                        ConstraintWidget constraintWidget5 = this.f8524x1[i16];
                        ConstraintWidget constraintWidget6 = this.f8523w1[i17];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.k(constraintWidget.f8326J, constraintWidget5.f8326J, 0);
                            constraintWidget.k(constraintWidget.f8330L, constraintWidget5.f8330L, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.k(constraintWidget.f8328K, constraintWidget6.f8328K, 0);
                            constraintWidget.k(constraintWidget.f8332M, constraintWidget6.f8332M, 0);
                        }
                    }
                }
            }
        }
    }

    public final int W1(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f8378q;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.f8392x * i10);
                if (i12 != constraintWidget.y()) {
                    constraintWidget.M0(true);
                    p1(constraintWidget, constraintWidget.B(), constraintWidget.U(), ConstraintWidget.DimensionBehaviour.FIXED, i12);
                }
                return i12;
            }
            if (i11 == 1) {
                return constraintWidget.y();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget.U() * constraintWidget.f8344Y) + 0.5f);
            }
        }
        return constraintWidget.y();
    }

    public final int X1(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f8376p;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.f8386u * i10);
                if (i12 != constraintWidget.U()) {
                    constraintWidget.M0(true);
                    p1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i12, constraintWidget.R(), constraintWidget.y());
                }
                return i12;
            }
            if (i11 == 1) {
                return constraintWidget.U();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget.y() * constraintWidget.f8344Y) + 0.5f);
            }
        }
        return constraintWidget.U();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x010d -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x010f -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0115 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0117 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y1(androidx.constraintlayout.solver.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.e.Y1(androidx.constraintlayout.solver.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    public final void Z1(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        boolean z10;
        int i14;
        boolean z11;
        int i15;
        ConstraintAnchor constraintAnchor;
        int m12;
        ConstraintAnchor constraintAnchor2;
        int k12;
        boolean z12;
        int i16;
        if (i10 == 0) {
            return;
        }
        this.f8522v1.clear();
        a aVar = new a(i11, this.f8326J, this.f8328K, this.f8330L, this.f8332M, i12);
        this.f8522v1.add(aVar);
        if (i11 == 0) {
            i13 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i18 < i10) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i18];
                int X12 = X1(constraintWidget, i12);
                if (constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i19 = i13;
                if ((i17 == i12 || this.f8515o1 + i17 + X12 > i12) && aVar.f8528b != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if ((!z12 && i18 > 0 && (i16 = this.f8520t1) > 0 && i18 % i16 == 0) || z12) {
                    aVar = new a(i11, this.f8326J, this.f8328K, this.f8330L, this.f8332M, i12);
                    aVar.i(i18);
                    this.f8522v1.add(aVar);
                } else if (i18 > 0) {
                    i17 += this.f8515o1 + X12;
                    aVar.b(constraintWidget);
                    i18++;
                    i13 = i19;
                }
                i17 = X12;
                aVar.b(constraintWidget);
                i18++;
                i13 = i19;
            }
        } else {
            i13 = 0;
            int i20 = 0;
            int i21 = 0;
            while (i21 < i10) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i21];
                int W12 = W1(constraintWidget2, i12);
                if (constraintWidget2.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i22 = i13;
                if ((i20 == i12 || this.f8516p1 + i20 + W12 > i12) && aVar.f8528b != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((!z10 && i21 > 0 && (i14 = this.f8520t1) > 0 && i21 % i14 == 0) || z10) {
                    aVar = new a(i11, this.f8326J, this.f8328K, this.f8330L, this.f8332M, i12);
                    aVar.i(i21);
                    this.f8522v1.add(aVar);
                } else if (i21 > 0) {
                    i20 += this.f8516p1 + W12;
                    aVar.b(constraintWidget2);
                    i21++;
                    i13 = i22;
                }
                i20 = W12;
                aVar.b(constraintWidget2);
                i21++;
                i13 = i22;
            }
        }
        int size = this.f8522v1.size();
        ConstraintAnchor constraintAnchor3 = this.f8326J;
        ConstraintAnchor constraintAnchor4 = this.f8328K;
        ConstraintAnchor constraintAnchor5 = this.f8330L;
        ConstraintAnchor constraintAnchor6 = this.f8332M;
        int l12 = l1();
        int n12 = n1();
        int m13 = m1();
        int k13 = k1();
        ConstraintWidget.DimensionBehaviour B10 = B();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (B10 != dimensionBehaviour && R() != dimensionBehaviour) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i13 > 0 && z11) {
            for (int i23 = 0; i23 < size; i23++) {
                a aVar2 = this.f8522v1.get(i23);
                if (i11 == 0) {
                    aVar2.g(i12 - aVar2.f());
                } else {
                    aVar2.g(i12 - aVar2.e());
                }
            }
        }
        int i24 = n12;
        int i25 = m13;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = l12;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i30 = k13;
        while (i28 < size) {
            a aVar3 = this.f8522v1.get(i28);
            if (i11 == 0) {
                if (i28 < size - 1) {
                    constraintAnchor2 = this.f8522v1.get(i28 + 1).f8528b.f8328K;
                    k12 = 0;
                } else {
                    constraintAnchor2 = this.f8332M;
                    k12 = k1();
                }
                ConstraintAnchor constraintAnchor9 = aVar3.f8528b.f8332M;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i31 = i26;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i32 = i27;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i15 = i28;
                aVar3.j(i11, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i29, i24, i25, k12, i12);
                int max = Math.max(i32, aVar3.f());
                i26 = i31 + aVar3.e();
                if (i15 > 0) {
                    i26 += this.f8516p1;
                }
                constraintAnchor8 = constraintAnchor11;
                i27 = max;
                i24 = 0;
                constraintAnchor7 = constraintAnchor9;
                constraintAnchor = constraintAnchor14;
                int i33 = k12;
                constraintAnchor6 = constraintAnchor2;
                i30 = i33;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i34 = i26;
                int i35 = i27;
                i15 = i28;
                if (i15 < size - 1) {
                    constraintAnchor = this.f8522v1.get(i15 + 1).f8528b.f8326J;
                    m12 = 0;
                } else {
                    constraintAnchor = this.f8330L;
                    m12 = m1();
                }
                ConstraintAnchor constraintAnchor16 = aVar3.f8528b.f8330L;
                aVar3.j(i11, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i29, i24, m12, i30, i12);
                i27 = i35 + aVar3.f();
                int max2 = Math.max(i34, aVar3.e());
                if (i15 > 0) {
                    i27 += this.f8515o1;
                }
                i26 = max2;
                i29 = 0;
                i25 = m12;
                constraintAnchor8 = constraintAnchor16;
            }
            i28 = i15 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = i27;
        iArr[1] = i26;
    }

    public final void a2(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        a aVar;
        if (i10 == 0) {
            return;
        }
        if (this.f8522v1.size() == 0) {
            aVar = new a(i11, this.f8326J, this.f8328K, this.f8330L, this.f8332M, i12);
            this.f8522v1.add(aVar);
        } else {
            a aVar2 = this.f8522v1.get(0);
            aVar2.c();
            aVar = aVar2;
            aVar.j(i11, this.f8326J, this.f8328K, this.f8330L, this.f8332M, l1(), n1(), m1(), k1(), i12);
        }
        for (int i13 = 0; i13 < i10; i13++) {
            aVar.b(constraintWidgetArr[i13]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void b2(float f10) {
        this.f8511k1 = f10;
    }

    public void c2(int i10) {
        this.f8505e1 = i10;
    }

    public void d2(float f10) {
        this.f8512l1 = f10;
    }

    public void e2(int i10) {
        this.f8506f1 = i10;
    }

    public void f2(int i10) {
        this.f8517q1 = i10;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.solver.c cVar, boolean z10) {
        boolean z11;
        boolean z12;
        super.g(cVar, z10);
        if (L() != null) {
            z11 = ((d) L()).D1();
        } else {
            z11 = false;
        }
        int i10 = this.f8519s1;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    V1(z11);
                }
            } else {
                int size = this.f8522v1.size();
                for (int i11 = 0; i11 < size; i11++) {
                    a aVar = this.f8522v1.get(i11);
                    if (i11 == size - 1) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    aVar.d(z11, i11, z12);
                }
            }
        } else if (this.f8522v1.size() > 0) {
            this.f8522v1.get(0).d(z11, 0, true);
        }
        s1(false);
    }

    public void g2(float f10) {
        this.f8509i1 = f10;
    }

    public void h2(int i10) {
        this.f8515o1 = i10;
    }

    public void i2(int i10) {
        this.f8503c1 = i10;
    }

    public void j2(float f10) {
        this.f8513m1 = f10;
    }

    public void k2(int i10) {
        this.f8507g1 = i10;
    }

    public void l2(float f10) {
        this.f8514n1 = f10;
    }

    @Override // v.C1616b, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.m(constraintWidget, hashMap);
        e eVar = (e) constraintWidget;
        this.f8503c1 = eVar.f8503c1;
        this.f8504d1 = eVar.f8504d1;
        this.f8505e1 = eVar.f8505e1;
        this.f8506f1 = eVar.f8506f1;
        this.f8507g1 = eVar.f8507g1;
        this.f8508h1 = eVar.f8508h1;
        this.f8509i1 = eVar.f8509i1;
        this.f8510j1 = eVar.f8510j1;
        this.f8511k1 = eVar.f8511k1;
        this.f8512l1 = eVar.f8512l1;
        this.f8513m1 = eVar.f8513m1;
        this.f8514n1 = eVar.f8514n1;
        this.f8515o1 = eVar.f8515o1;
        this.f8516p1 = eVar.f8516p1;
        this.f8517q1 = eVar.f8517q1;
        this.f8518r1 = eVar.f8518r1;
        this.f8519s1 = eVar.f8519s1;
        this.f8520t1 = eVar.f8520t1;
        this.f8521u1 = eVar.f8521u1;
    }

    public void m2(int i10) {
        this.f8508h1 = i10;
    }

    public void n2(int i10) {
        this.f8520t1 = i10;
    }

    @Override // androidx.constraintlayout.solver.widgets.h
    public void o1(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int[] iArr;
        boolean z10;
        if (this.f37370O0 > 0 && !q1()) {
            t1(0, 0);
            s1(false);
            return;
        }
        int l12 = l1();
        int m12 = m1();
        int n12 = n1();
        int k12 = k1();
        int[] iArr2 = new int[2];
        int i16 = (i11 - l12) - m12;
        int i17 = this.f8521u1;
        if (i17 == 1) {
            i16 = (i13 - n12) - k12;
        }
        int i18 = i16;
        if (i17 == 0) {
            if (this.f8503c1 == -1) {
                this.f8503c1 = 0;
            }
            if (this.f8504d1 == -1) {
                this.f8504d1 = 0;
            }
        } else {
            if (this.f8503c1 == -1) {
                this.f8503c1 = 0;
            }
            if (this.f8504d1 == -1) {
                this.f8504d1 = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.f37369N0;
        int i19 = 0;
        int i20 = 0;
        while (true) {
            i14 = this.f37370O0;
            if (i19 >= i14) {
                break;
            }
            if (this.f37369N0[i19].T() == 8) {
                i20++;
            }
            i19++;
        }
        if (i20 > 0) {
            constraintWidgetArr = new ConstraintWidget[i14 - i20];
            int i21 = 0;
            for (int i22 = 0; i22 < this.f37370O0; i22++) {
                ConstraintWidget constraintWidget = this.f37369N0[i22];
                if (constraintWidget.T() != 8) {
                    constraintWidgetArr[i21] = constraintWidget;
                    i21++;
                }
            }
            i15 = i21;
        } else {
            i15 = i14;
        }
        this.f8526z1 = constraintWidgetArr;
        this.f8502A1 = i15;
        int i23 = this.f8519s1;
        if (i23 != 0) {
            if (i23 != 1) {
                if (i23 != 2) {
                    z10 = true;
                    iArr = iArr2;
                } else {
                    z10 = true;
                    iArr = iArr2;
                    Y1(constraintWidgetArr, i15, this.f8521u1, i18, iArr2);
                }
            } else {
                z10 = true;
                iArr = iArr2;
                Z1(constraintWidgetArr, i15, this.f8521u1, i18, iArr2);
            }
        } else {
            iArr = iArr2;
            z10 = true;
            a2(constraintWidgetArr, i15, this.f8521u1, i18, iArr2);
        }
        int i24 = iArr[0] + l12 + m12;
        int i25 = iArr[z10 ? 1 : 0] + n12 + k12;
        if (i10 == 1073741824) {
            i24 = i11;
        } else if (i10 == Integer.MIN_VALUE) {
            i24 = Math.min(i24, i11);
        } else if (i10 != 0) {
            i24 = 0;
        }
        if (i12 == 1073741824) {
            i25 = i13;
        } else if (i12 == Integer.MIN_VALUE) {
            i25 = Math.min(i25, i13);
        } else if (i12 != 0) {
            i25 = 0;
        }
        t1(i24, i25);
        Y0(i24);
        z0(i25);
        if (this.f37370O0 <= 0) {
            z10 = false;
        }
        s1(z10);
    }

    public void o2(int i10) {
        this.f8521u1 = i10;
    }

    public void p2(int i10) {
        this.f8518r1 = i10;
    }

    public void q2(float f10) {
        this.f8510j1 = f10;
    }

    public void r2(int i10) {
        this.f8516p1 = i10;
    }

    public void s2(int i10) {
        this.f8504d1 = i10;
    }

    public void t2(int i10) {
        this.f8519s1 = i10;
    }
}
