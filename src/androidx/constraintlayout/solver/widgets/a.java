package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;
import v.C1616b;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class a extends C1616b {

    /* renamed from: P0, reason: collision with root package name */
    public int f8405P0 = 0;

    /* renamed from: Q0, reason: collision with root package name */
    public boolean f8406Q0 = true;

    /* renamed from: R0, reason: collision with root package name */
    public int f8407R0 = 0;

    /* renamed from: S0, reason: collision with root package name */
    public boolean f8408S0 = false;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.solver.c cVar, boolean z10) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        ConstraintAnchor[] constraintAnchorArr2 = this.f8337R;
        constraintAnchorArr2[0] = this.f8326J;
        constraintAnchorArr2[2] = this.f8328K;
        constraintAnchorArr2[1] = this.f8330L;
        constraintAnchorArr2[3] = this.f8332M;
        int i15 = 0;
        while (true) {
            constraintAnchorArr = this.f8337R;
            if (i15 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i15];
            constraintAnchor.f8295i = cVar.q(constraintAnchor);
            i15++;
        }
        int i16 = this.f8405P0;
        if (i16 >= 0 && i16 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i16];
            if (!this.f8408S0) {
                g1();
            }
            if (this.f8408S0) {
                this.f8408S0 = false;
                int i17 = this.f8405P0;
                if (i17 != 0 && i17 != 1) {
                    if (i17 == 2 || i17 == 3) {
                        cVar.f(this.f8328K.f8295i, this.f8349b0);
                        cVar.f(this.f8332M.f8295i, this.f8349b0);
                        return;
                    }
                    return;
                }
                cVar.f(this.f8326J.f8295i, this.f8347a0);
                cVar.f(this.f8330L.f8295i, this.f8347a0);
                return;
            }
            for (int i18 = 0; i18 < this.f37370O0; i18++) {
                ConstraintWidget constraintWidget = this.f37369N0[i18];
                if ((this.f8406Q0 || constraintWidget.h()) && ((((i13 = this.f8405P0) == 0 || i13 == 1) && constraintWidget.B() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f8326J.f8292f != null && constraintWidget.f8330L.f8292f != null) || (((i14 = this.f8405P0) == 2 || i14 == 3) && constraintWidget.R() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f8328K.f8292f != null && constraintWidget.f8332M.f8292f != null))) {
                    z11 = true;
                    break;
                }
            }
            z11 = false;
            if (!this.f8326J.l() && !this.f8330L.l()) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (!this.f8328K.l() && !this.f8332M.l()) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (!z11 && (((i12 = this.f8405P0) == 0 && z12) || ((i12 == 2 && z13) || ((i12 == 1 && z12) || (i12 == 3 && z13))))) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (!z14) {
                i10 = 4;
            } else {
                i10 = 5;
            }
            for (int i19 = 0; i19 < this.f37370O0; i19++) {
                ConstraintWidget constraintWidget2 = this.f37369N0[i19];
                if (this.f8406Q0 || constraintWidget2.h()) {
                    SolverVariable q10 = cVar.q(constraintWidget2.f8337R[this.f8405P0]);
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.f8337R;
                    int i20 = this.f8405P0;
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i20];
                    constraintAnchor3.f8295i = q10;
                    ConstraintAnchor constraintAnchor4 = constraintAnchor3.f8292f;
                    if (constraintAnchor4 != null && constraintAnchor4.f8290d == this) {
                        i11 = constraintAnchor3.f8293g;
                    } else {
                        i11 = 0;
                    }
                    if (i20 != 0 && i20 != 2) {
                        cVar.g(constraintAnchor2.f8295i, q10, this.f8407R0 + i11, z11);
                    } else {
                        cVar.i(constraintAnchor2.f8295i, q10, this.f8407R0 - i11, z11);
                    }
                    cVar.e(constraintAnchor2.f8295i, q10, this.f8407R0 + i11, i10);
                }
            }
            int i21 = this.f8405P0;
            if (i21 == 0) {
                cVar.e(this.f8330L.f8295i, this.f8326J.f8295i, 0, 8);
                cVar.e(this.f8326J.f8295i, this.f8341V.f8330L.f8295i, 0, 4);
                cVar.e(this.f8326J.f8295i, this.f8341V.f8326J.f8295i, 0, 0);
                return;
            }
            if (i21 == 1) {
                cVar.e(this.f8326J.f8295i, this.f8330L.f8295i, 0, 8);
                cVar.e(this.f8326J.f8295i, this.f8341V.f8326J.f8295i, 0, 4);
                cVar.e(this.f8326J.f8295i, this.f8341V.f8330L.f8295i, 0, 0);
            } else if (i21 == 2) {
                cVar.e(this.f8332M.f8295i, this.f8328K.f8295i, 0, 8);
                cVar.e(this.f8328K.f8295i, this.f8341V.f8332M.f8295i, 0, 4);
                cVar.e(this.f8328K.f8295i, this.f8341V.f8328K.f8295i, 0, 0);
            } else if (i21 == 3) {
                cVar.e(this.f8328K.f8295i, this.f8332M.f8295i, 0, 8);
                cVar.e(this.f8328K.f8295i, this.f8341V.f8328K.f8295i, 0, 4);
                cVar.e(this.f8328K.f8295i, this.f8341V.f8332M.f8295i, 0, 0);
            }
        }
    }

    public boolean g1() {
        int i10;
        int i11;
        int i12;
        boolean z10 = true;
        int i13 = 0;
        while (true) {
            i10 = this.f37370O0;
            if (i13 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget = this.f37369N0[i13];
            if ((this.f8406Q0 || constraintWidget.h()) && ((((i11 = this.f8405P0) == 0 || i11 == 1) && !constraintWidget.h0()) || (((i12 = this.f8405P0) == 2 || i12 == 3) && !constraintWidget.i0()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int i14 = 0;
        boolean z11 = false;
        for (int i15 = 0; i15 < this.f37370O0; i15++) {
            ConstraintWidget constraintWidget2 = this.f37369N0[i15];
            if (this.f8406Q0 || constraintWidget2.h()) {
                if (!z11) {
                    int i16 = this.f8405P0;
                    if (i16 == 0) {
                        i14 = constraintWidget2.p(ConstraintAnchor.Type.LEFT).e();
                    } else if (i16 == 1) {
                        i14 = constraintWidget2.p(ConstraintAnchor.Type.RIGHT).e();
                    } else if (i16 == 2) {
                        i14 = constraintWidget2.p(ConstraintAnchor.Type.TOP).e();
                    } else if (i16 == 3) {
                        i14 = constraintWidget2.p(ConstraintAnchor.Type.BOTTOM).e();
                    }
                    z11 = true;
                }
                int i17 = this.f8405P0;
                if (i17 == 0) {
                    i14 = Math.min(i14, constraintWidget2.p(ConstraintAnchor.Type.LEFT).e());
                } else if (i17 == 1) {
                    i14 = Math.max(i14, constraintWidget2.p(ConstraintAnchor.Type.RIGHT).e());
                } else if (i17 == 2) {
                    i14 = Math.min(i14, constraintWidget2.p(ConstraintAnchor.Type.TOP).e());
                } else if (i17 == 3) {
                    i14 = Math.max(i14, constraintWidget2.p(ConstraintAnchor.Type.BOTTOM).e());
                }
            }
        }
        int i18 = i14 + this.f8407R0;
        int i19 = this.f8405P0;
        if (i19 != 0 && i19 != 1) {
            w0(i18, i18);
        } else {
            t0(i18, i18);
        }
        this.f8408S0 = true;
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean h0() {
        return this.f8408S0;
    }

    public boolean h1() {
        return this.f8406Q0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean i0() {
        return this.f8408S0;
    }

    public int i1() {
        return this.f8405P0;
    }

    public int j1() {
        return this.f8407R0;
    }

    public int k1() {
        int i10 = this.f8405P0;
        if (i10 != 0 && i10 != 1) {
            if (i10 == 2 || i10 == 3) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public void l1() {
        for (int i10 = 0; i10 < this.f37370O0; i10++) {
            ConstraintWidget constraintWidget = this.f37369N0[i10];
            int i11 = this.f8405P0;
            if (i11 != 0 && i11 != 1) {
                if (i11 == 2 || i11 == 3) {
                    constraintWidget.G0(1, true);
                }
            } else {
                constraintWidget.G0(0, true);
            }
        }
    }

    @Override // v.C1616b, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.m(constraintWidget, hashMap);
        a aVar = (a) constraintWidget;
        this.f8405P0 = aVar.f8405P0;
        this.f8406Q0 = aVar.f8406Q0;
        this.f8407R0 = aVar.f8407R0;
    }

    public void m1(boolean z10) {
        this.f8406Q0 = z10;
    }

    public void n1(int i10) {
        this.f8405P0 = i10;
    }

    public void o1(int i10) {
        this.f8407R0 = i10;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + u() + " {";
        for (int i10 = 0; i10 < this.f37370O0; i10++) {
            ConstraintWidget constraintWidget = this.f37369N0[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.u();
        }
        return str + "}";
    }
}
