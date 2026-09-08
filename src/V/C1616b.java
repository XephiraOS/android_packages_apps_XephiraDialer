package v;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import w.g;
import w.j;

/* compiled from: HelperWidget.java */
/* renamed from: v.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1616b extends ConstraintWidget implements InterfaceC1615a {

    /* renamed from: N0, reason: collision with root package name */
    public ConstraintWidget[] f37369N0 = new ConstraintWidget[4];

    /* renamed from: O0, reason: collision with root package name */
    public int f37370O0 = 0;

    @Override // v.InterfaceC1615a
    public void a(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i10 = this.f37370O0 + 1;
            ConstraintWidget[] constraintWidgetArr = this.f37369N0;
            if (i10 > constraintWidgetArr.length) {
                this.f37369N0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.f37369N0;
            int i11 = this.f37370O0;
            constraintWidgetArr2[i11] = constraintWidget;
            this.f37370O0 = i11 + 1;
        }
    }

    @Override // v.InterfaceC1615a
    public void b() {
        this.f37370O0 = 0;
        Arrays.fill(this.f37369N0, (Object) null);
    }

    public void e1(ArrayList<j> arrayList, int i10, j jVar) {
        for (int i11 = 0; i11 < this.f37370O0; i11++) {
            jVar.a(this.f37369N0[i11]);
        }
        for (int i12 = 0; i12 < this.f37370O0; i12++) {
            g.a(this.f37369N0[i12], i10, arrayList, jVar);
        }
    }

    public int f1(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.f37370O0; i13++) {
            ConstraintWidget constraintWidget = this.f37369N0[i13];
            if (i10 == 0 && (i12 = constraintWidget.f8329K0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = constraintWidget.f8331L0) != -1) {
                return i11;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.m(constraintWidget, hashMap);
        C1616b c1616b = (C1616b) constraintWidget;
        this.f37370O0 = 0;
        int i10 = c1616b.f37370O0;
        for (int i11 = 0; i11 < i10; i11++) {
            a(hashMap.get(c1616b.f37369N0[i11]));
        }
    }

    public void c(d dVar) {
    }
}
