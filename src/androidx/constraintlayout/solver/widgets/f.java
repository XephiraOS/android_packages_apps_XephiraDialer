package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class f extends ConstraintWidget {

    /* renamed from: N0, reason: collision with root package name */
    public float f8545N0 = -1.0f;

    /* renamed from: O0, reason: collision with root package name */
    public int f8546O0 = -1;

    /* renamed from: P0, reason: collision with root package name */
    public int f8547P0 = -1;

    /* renamed from: Q0, reason: collision with root package name */
    public ConstraintAnchor f8548Q0 = this.f8328K;

    /* renamed from: R0, reason: collision with root package name */
    public int f8549R0 = 0;

    /* renamed from: S0, reason: collision with root package name */
    public int f8550S0 = 0;

    /* renamed from: T0, reason: collision with root package name */
    public boolean f8551T0;

    /* compiled from: Guideline.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8552a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f8552a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8552a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8552a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8552a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8552a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8552a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8552a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8552a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8552a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public f() {
        this.f8338S.clear();
        this.f8338S.add(this.f8548Q0);
        int length = this.f8337R.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f8337R[i10] = this.f8548Q0;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void d1(androidx.constraintlayout.solver.c cVar, boolean z10) {
        if (L() == null) {
            return;
        }
        int y10 = cVar.y(this.f8548Q0);
        if (this.f8549R0 == 1) {
            Z0(y10);
            a1(0);
            z0(L().y());
            Y0(0);
            return;
        }
        Z0(0);
        a1(y10);
        Y0(L().U());
        z0(0);
    }

    public ConstraintAnchor e1() {
        return this.f8548Q0;
    }

    public int f1() {
        return this.f8549R0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.solver.c cVar, boolean z10) {
        boolean z11;
        d dVar = (d) L();
        if (dVar == null) {
            return;
        }
        ConstraintAnchor p10 = dVar.p(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor p11 = dVar.p(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.f8341V;
        boolean z12 = true;
        if (constraintWidget != null && constraintWidget.f8340U[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.f8549R0 == 0) {
            p10 = dVar.p(ConstraintAnchor.Type.TOP);
            p11 = dVar.p(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.f8341V;
            if (constraintWidget2 == null || constraintWidget2.f8340U[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z12 = false;
            }
            z11 = z12;
        }
        if (this.f8551T0 && this.f8548Q0.n()) {
            SolverVariable q10 = cVar.q(this.f8548Q0);
            cVar.f(q10, this.f8548Q0.e());
            if (this.f8546O0 != -1) {
                if (z11) {
                    cVar.h(cVar.q(p11), q10, 0, 5);
                }
            } else if (this.f8547P0 != -1 && z11) {
                SolverVariable q11 = cVar.q(p11);
                cVar.h(q10, cVar.q(p10), 0, 5);
                cVar.h(q11, q10, 0, 5);
            }
            this.f8551T0 = false;
            return;
        }
        if (this.f8546O0 != -1) {
            SolverVariable q12 = cVar.q(this.f8548Q0);
            cVar.e(q12, cVar.q(p10), this.f8546O0, 8);
            if (z11) {
                cVar.h(cVar.q(p11), q12, 0, 5);
                return;
            }
            return;
        }
        if (this.f8547P0 != -1) {
            SolverVariable q13 = cVar.q(this.f8548Q0);
            SolverVariable q14 = cVar.q(p11);
            cVar.e(q13, q14, -this.f8547P0, 8);
            if (z11) {
                cVar.h(q13, cVar.q(p10), 0, 5);
                cVar.h(q14, q13, 0, 5);
                return;
            }
            return;
        }
        if (this.f8545N0 != -1.0f) {
            cVar.d(androidx.constraintlayout.solver.c.s(cVar, cVar.q(this.f8548Q0), cVar.q(p11), this.f8545N0));
        }
    }

    public int g1() {
        return this.f8546O0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean h0() {
        return this.f8551T0;
    }

    public int h1() {
        return this.f8547P0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean i0() {
        return this.f8551T0;
    }

    public float i1() {
        return this.f8545N0;
    }

    public void j1(int i10) {
        this.f8548Q0.t(i10);
        this.f8551T0 = true;
    }

    public void k1(int i10) {
        if (i10 > -1) {
            this.f8545N0 = -1.0f;
            this.f8546O0 = i10;
            this.f8547P0 = -1;
        }
    }

    public void l1(int i10) {
        if (i10 > -1) {
            this.f8545N0 = -1.0f;
            this.f8546O0 = -1;
            this.f8547P0 = i10;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.m(constraintWidget, hashMap);
        f fVar = (f) constraintWidget;
        this.f8545N0 = fVar.f8545N0;
        this.f8546O0 = fVar.f8546O0;
        this.f8547P0 = fVar.f8547P0;
        n1(fVar.f8549R0);
    }

    public void m1(float f10) {
        if (f10 > -1.0f) {
            this.f8545N0 = f10;
            this.f8546O0 = -1;
            this.f8547P0 = -1;
        }
    }

    public void n1(int i10) {
        if (this.f8549R0 == i10) {
            return;
        }
        this.f8549R0 = i10;
        this.f8338S.clear();
        if (this.f8549R0 == 1) {
            this.f8548Q0 = this.f8326J;
        } else {
            this.f8548Q0 = this.f8328K;
        }
        this.f8338S.add(this.f8548Q0);
        int length = this.f8337R.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f8337R[i11] = this.f8548Q0;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor p(ConstraintAnchor.Type type) {
        switch (a.f8552a[type.ordinal()]) {
            case 1:
            case 2:
                if (this.f8549R0 == 1) {
                    return this.f8548Q0;
                }
                break;
            case 3:
            case 4:
                if (this.f8549R0 == 0) {
                    return this.f8548Q0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }
}
