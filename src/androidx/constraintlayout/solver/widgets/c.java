package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: ChainHead.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintWidget f8452a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintWidget f8453b;

    /* renamed from: c, reason: collision with root package name */
    public ConstraintWidget f8454c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidget f8455d;

    /* renamed from: e, reason: collision with root package name */
    public ConstraintWidget f8456e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintWidget f8457f;

    /* renamed from: g, reason: collision with root package name */
    public ConstraintWidget f8458g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f8459h;

    /* renamed from: i, reason: collision with root package name */
    public int f8460i;

    /* renamed from: j, reason: collision with root package name */
    public int f8461j;

    /* renamed from: k, reason: collision with root package name */
    public float f8462k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public int f8463l;

    /* renamed from: m, reason: collision with root package name */
    public int f8464m;

    /* renamed from: n, reason: collision with root package name */
    public int f8465n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8466o;

    /* renamed from: p, reason: collision with root package name */
    public int f8467p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8468q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8469r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8470s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8471t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8472u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8473v;

    public c(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f8452a = constraintWidget;
        this.f8467p = i10;
        this.f8468q = z10;
    }

    public static boolean c(ConstraintWidget constraintWidget, int i10) {
        int i11;
        if (constraintWidget.T() != 8 && constraintWidget.f8340U[i10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i11 = constraintWidget.f8380r[i10]) == 0 || i11 == 3)) {
            return true;
        }
        return false;
    }

    public void a() {
        if (!this.f8473v) {
            b();
        }
        this.f8473v = true;
    }

    public final void b() {
        int i10 = this.f8467p * 2;
        ConstraintWidget constraintWidget = this.f8452a;
        boolean z10 = true;
        this.f8466o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z11 = false;
        while (!z11) {
            this.f8460i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.f8323H0;
            int i11 = this.f8467p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i11] = null;
            constraintWidget.f8321G0[i11] = null;
            if (constraintWidget.T() != 8) {
                this.f8463l++;
                ConstraintWidget.DimensionBehaviour v10 = constraintWidget.v(this.f8467p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (v10 != dimensionBehaviour) {
                    this.f8464m += constraintWidget.F(this.f8467p);
                }
                int f10 = this.f8464m + constraintWidget.f8337R[i10].f();
                this.f8464m = f10;
                int i12 = i10 + 1;
                this.f8464m = f10 + constraintWidget.f8337R[i12].f();
                int f11 = this.f8465n + constraintWidget.f8337R[i10].f();
                this.f8465n = f11;
                this.f8465n = f11 + constraintWidget.f8337R[i12].f();
                if (this.f8453b == null) {
                    this.f8453b = constraintWidget;
                }
                this.f8455d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.f8340U;
                int i13 = this.f8467p;
                if (dimensionBehaviourArr[i13] == dimensionBehaviour) {
                    int i14 = constraintWidget.f8380r[i13];
                    if (i14 == 0 || i14 == 3 || i14 == 2) {
                        this.f8461j++;
                        float f12 = constraintWidget.f8319F0[i13];
                        if (f12 > 0.0f) {
                            this.f8462k += f12;
                        }
                        if (c(constraintWidget, i13)) {
                            if (f12 < 0.0f) {
                                this.f8469r = true;
                            } else {
                                this.f8470s = true;
                            }
                            if (this.f8459h == null) {
                                this.f8459h = new ArrayList<>();
                            }
                            this.f8459h.add(constraintWidget);
                        }
                        if (this.f8457f == null) {
                            this.f8457f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f8458g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.f8321G0[this.f8467p] = constraintWidget;
                        }
                        this.f8458g = constraintWidget;
                    }
                    if (this.f8467p == 0) {
                        if (constraintWidget.f8376p != 0) {
                            this.f8466o = false;
                        } else if (constraintWidget.f8382s != 0 || constraintWidget.f8384t != 0) {
                            this.f8466o = false;
                        }
                    } else if (constraintWidget.f8378q != 0) {
                        this.f8466o = false;
                    } else if (constraintWidget.f8388v != 0 || constraintWidget.f8390w != 0) {
                        this.f8466o = false;
                    }
                    if (constraintWidget.f8344Y != 0.0f) {
                        this.f8466o = false;
                        this.f8472u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.f8323H0[this.f8467p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.f8337R[i10 + 1].f8292f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f8290d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.f8337R[i10].f8292f;
                if (constraintAnchor2 != null && constraintAnchor2.f8290d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z11 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f8453b;
        if (constraintWidget6 != null) {
            this.f8464m -= constraintWidget6.f8337R[i10].f();
        }
        ConstraintWidget constraintWidget7 = this.f8455d;
        if (constraintWidget7 != null) {
            this.f8464m -= constraintWidget7.f8337R[i10 + 1].f();
        }
        this.f8454c = constraintWidget;
        if (this.f8467p == 0 && this.f8468q) {
            this.f8456e = constraintWidget;
        } else {
            this.f8456e = this.f8452a;
        }
        if (!this.f8470s || !this.f8469r) {
            z10 = false;
        }
        this.f8471t = z10;
    }
}
