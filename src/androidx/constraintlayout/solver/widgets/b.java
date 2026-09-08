package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

/* compiled from: Chain.java */
/* loaded from: classes.dex */
public class b {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r7 == 2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0031, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0044, code lost:
    
        if (r7 == 2) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0249 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x038f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0397 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c4  */
    /* JADX WARN: Type inference failed for: r2v56, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(androidx.constraintlayout.solver.widgets.d r37, androidx.constraintlayout.solver.c r38, int r39, int r40, androidx.constraintlayout.solver.widgets.c r41) {
        /*
            Method dump skipped, instructions count: 1295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.b.a(androidx.constraintlayout.solver.widgets.d, androidx.constraintlayout.solver.c, int, int, androidx.constraintlayout.solver.widgets.c):void");
    }

    public static void b(d dVar, androidx.constraintlayout.solver.c cVar, ArrayList<ConstraintWidget> arrayList, int i10) {
        int i11;
        c[] cVarArr;
        int i12;
        if (i10 == 0) {
            i11 = dVar.f8483X0;
            cVarArr = dVar.f8486a1;
            i12 = 0;
        } else {
            i11 = dVar.f8484Y0;
            cVarArr = dVar.f8485Z0;
            i12 = 2;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            c cVar2 = cVarArr[i13];
            cVar2.a();
            if (arrayList == null || arrayList.contains(cVar2.f8452a)) {
                a(dVar, cVar, i10, i12, cVar2);
            }
        }
    }
}
