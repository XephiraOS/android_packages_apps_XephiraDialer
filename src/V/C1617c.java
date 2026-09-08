package v;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import u.C1599a;

/* compiled from: WidgetContainer.java */
/* renamed from: v.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1617c extends ConstraintWidget {

    /* renamed from: N0, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f37371N0 = new ArrayList<>();

    public void a(ConstraintWidget constraintWidget) {
        this.f37371N0.add(constraintWidget);
        if (constraintWidget.L() != null) {
            ((C1617c) constraintWidget.L()).g1(constraintWidget);
        }
        constraintWidget.Q0(this);
    }

    public ArrayList<ConstraintWidget> e1() {
        return this.f37371N0;
    }

    public void f1() {
        ArrayList<ConstraintWidget> arrayList = this.f37371N0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f37371N0.get(i10);
            if (constraintWidget instanceof C1617c) {
                ((C1617c) constraintWidget).f1();
            }
        }
    }

    public void g1(ConstraintWidget constraintWidget) {
        this.f37371N0.remove(constraintWidget);
        constraintWidget.k0();
    }

    public void h1() {
        this.f37371N0.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void k0() {
        this.f37371N0.clear();
        super.k0();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void n0(C1599a c1599a) {
        super.n0(c1599a);
        int size = this.f37371N0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f37371N0.get(i10).n0(c1599a);
        }
    }
}
