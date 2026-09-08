package w;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import v.C1616b;

/* compiled from: Grouping.java */
/* loaded from: classes.dex */
public class g {
    public static j a(ConstraintWidget constraintWidget, int i10, ArrayList<j> arrayList, j jVar) {
        int i11;
        int f12;
        if (i10 == 0) {
            i11 = constraintWidget.f8329K0;
        } else {
            i11 = constraintWidget.f8331L0;
        }
        int i12 = 0;
        if (i11 != -1 && (jVar == null || i11 != jVar.f37546b)) {
            int i13 = 0;
            while (true) {
                if (i13 >= arrayList.size()) {
                    break;
                }
                j jVar2 = arrayList.get(i13);
                if (jVar2.c() == i11) {
                    if (jVar != null) {
                        jVar.g(i10, jVar2);
                        arrayList.remove(jVar);
                    }
                    jVar = jVar2;
                } else {
                    i13++;
                }
            }
        } else if (i11 != -1) {
            return jVar;
        }
        if (jVar == null) {
            if ((constraintWidget instanceof C1616b) && (f12 = ((C1616b) constraintWidget).f1(i10)) != -1) {
                int i14 = 0;
                while (true) {
                    if (i14 >= arrayList.size()) {
                        break;
                    }
                    j jVar3 = arrayList.get(i14);
                    if (jVar3.c() == f12) {
                        jVar = jVar3;
                        break;
                    }
                    i14++;
                }
            }
            if (jVar == null) {
                jVar = new j(i10);
            }
            arrayList.add(jVar);
        }
        if (jVar.a(constraintWidget)) {
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.f) {
                androidx.constraintlayout.solver.widgets.f fVar = (androidx.constraintlayout.solver.widgets.f) constraintWidget;
                ConstraintAnchor e12 = fVar.e1();
                if (fVar.f1() == 0) {
                    i12 = 1;
                }
                e12.c(i12, arrayList, jVar);
            }
            if (i10 == 0) {
                constraintWidget.f8329K0 = jVar.c();
                constraintWidget.f8326J.c(i10, arrayList, jVar);
                constraintWidget.f8330L.c(i10, arrayList, jVar);
            } else {
                constraintWidget.f8331L0 = jVar.c();
                constraintWidget.f8328K.c(i10, arrayList, jVar);
                constraintWidget.f8333N.c(i10, arrayList, jVar);
                constraintWidget.f8332M.c(i10, arrayList, jVar);
            }
            constraintWidget.f8336Q.c(i10, arrayList, jVar);
        }
        return jVar;
    }

    public static j b(ArrayList<j> arrayList, int i10) {
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            j jVar = arrayList.get(i11);
            if (i10 == jVar.f37546b) {
                return jVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:211:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0383 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x037f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(androidx.constraintlayout.solver.widgets.d r16, w.C1639b.InterfaceC0372b r17) {
        /*
            Method dump skipped, instructions count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.g.c(androidx.constraintlayout.solver.widgets.d, w.b$b):boolean");
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        boolean z10;
        boolean z11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour3 != dimensionBehaviour7 && dimensionBehaviour3 != (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == dimensionBehaviour6)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (dimensionBehaviour4 != dimensionBehaviour7 && dimensionBehaviour4 != (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour2 == dimensionBehaviour5)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z10 || z11) {
            return true;
        }
        return false;
    }
}
