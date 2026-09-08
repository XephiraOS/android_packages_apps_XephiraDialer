package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean[] f8553a = new boolean[3];

    public static void a(d dVar, androidx.constraintlayout.solver.c cVar, ConstraintWidget constraintWidget) {
        constraintWidget.f8372n = -1;
        constraintWidget.f8374o = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.f8340U[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.f8340U[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i10 = constraintWidget.f8326J.f8293g;
            int U10 = dVar.U() - constraintWidget.f8330L.f8293g;
            ConstraintAnchor constraintAnchor = constraintWidget.f8326J;
            constraintAnchor.f8295i = cVar.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.f8330L;
            constraintAnchor2.f8295i = cVar.q(constraintAnchor2);
            cVar.f(constraintWidget.f8326J.f8295i, i10);
            cVar.f(constraintWidget.f8330L.f8295i, U10);
            constraintWidget.f8372n = 2;
            constraintWidget.C0(i10, U10);
        }
        if (dVar.f8340U[1] != dimensionBehaviour2 && constraintWidget.f8340U[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i11 = constraintWidget.f8328K.f8293g;
            int y10 = dVar.y() - constraintWidget.f8332M.f8293g;
            ConstraintAnchor constraintAnchor3 = constraintWidget.f8328K;
            constraintAnchor3.f8295i = cVar.q(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.f8332M;
            constraintAnchor4.f8295i = cVar.q(constraintAnchor4);
            cVar.f(constraintWidget.f8328K.f8295i, i11);
            cVar.f(constraintWidget.f8332M.f8295i, y10);
            if (constraintWidget.f8359g0 > 0 || constraintWidget.T() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.f8333N;
                constraintAnchor5.f8295i = cVar.q(constraintAnchor5);
                cVar.f(constraintWidget.f8333N.f8295i, constraintWidget.f8359g0 + i11);
            }
            constraintWidget.f8374o = 2;
            constraintWidget.T0(i11, y10);
        }
    }

    public static final boolean b(int i10, int i11) {
        if ((i10 & i11) == i11) {
            return true;
        }
        return false;
    }
}
