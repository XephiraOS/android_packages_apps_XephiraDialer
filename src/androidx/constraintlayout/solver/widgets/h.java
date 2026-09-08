package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import v.C1616b;
import w.C1639b;

/* compiled from: VirtualLayout.java */
/* loaded from: classes.dex */
public class h extends C1616b {

    /* renamed from: P0, reason: collision with root package name */
    public int f8554P0 = 0;

    /* renamed from: Q0, reason: collision with root package name */
    public int f8555Q0 = 0;

    /* renamed from: R0, reason: collision with root package name */
    public int f8556R0 = 0;

    /* renamed from: S0, reason: collision with root package name */
    public int f8557S0 = 0;

    /* renamed from: T0, reason: collision with root package name */
    public int f8558T0 = 0;

    /* renamed from: U0, reason: collision with root package name */
    public int f8559U0 = 0;

    /* renamed from: V0, reason: collision with root package name */
    public int f8560V0 = 0;

    /* renamed from: W0, reason: collision with root package name */
    public int f8561W0 = 0;

    /* renamed from: X0, reason: collision with root package name */
    public boolean f8562X0 = false;

    /* renamed from: Y0, reason: collision with root package name */
    public int f8563Y0 = 0;

    /* renamed from: Z0, reason: collision with root package name */
    public int f8564Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    public C1639b.a f8565a1 = new C1639b.a();

    /* renamed from: b1, reason: collision with root package name */
    public C1639b.InterfaceC0372b f8566b1 = null;

    public void A1(int i10) {
        this.f8554P0 = i10;
    }

    @Override // v.C1616b, v.InterfaceC1615a
    public void c(d dVar) {
        h1();
    }

    public void g1(boolean z10) {
        int i10 = this.f8558T0;
        if (i10 > 0 || this.f8559U0 > 0) {
            if (z10) {
                this.f8560V0 = this.f8559U0;
                this.f8561W0 = i10;
            } else {
                this.f8560V0 = i10;
                this.f8561W0 = this.f8559U0;
            }
        }
    }

    public void h1() {
        for (int i10 = 0; i10 < this.f37370O0; i10++) {
            ConstraintWidget constraintWidget = this.f37369N0[i10];
            if (constraintWidget != null) {
                constraintWidget.I0(true);
            }
        }
    }

    public int i1() {
        return this.f8564Z0;
    }

    public int j1() {
        return this.f8563Y0;
    }

    public int k1() {
        return this.f8555Q0;
    }

    public int l1() {
        return this.f8560V0;
    }

    public int m1() {
        return this.f8561W0;
    }

    public int n1() {
        return this.f8554P0;
    }

    public void p1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        while (this.f8566b1 == null && L() != null) {
            this.f8566b1 = ((d) L()).w1();
        }
        C1639b.a aVar = this.f8565a1;
        aVar.f37514a = dimensionBehaviour;
        aVar.f37515b = dimensionBehaviour2;
        aVar.f37516c = i10;
        aVar.f37517d = i11;
        this.f8566b1.b(constraintWidget, aVar);
        constraintWidget.Y0(this.f8565a1.f37518e);
        constraintWidget.z0(this.f8565a1.f37519f);
        constraintWidget.y0(this.f8565a1.f37521h);
        constraintWidget.o0(this.f8565a1.f37520g);
    }

    public boolean q1() {
        C1639b.InterfaceC0372b interfaceC0372b;
        ConstraintWidget constraintWidget = this.f8341V;
        if (constraintWidget != null) {
            interfaceC0372b = ((d) constraintWidget).w1();
        } else {
            interfaceC0372b = null;
        }
        if (interfaceC0372b == null) {
            return false;
        }
        for (int i10 = 0; i10 < this.f37370O0; i10++) {
            ConstraintWidget constraintWidget2 = this.f37369N0[i10];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof f)) {
                ConstraintWidget.DimensionBehaviour v10 = constraintWidget2.v(0);
                ConstraintWidget.DimensionBehaviour v11 = constraintWidget2.v(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (v10 != dimensionBehaviour || constraintWidget2.f8376p == 1 || v11 != dimensionBehaviour || constraintWidget2.f8378q == 1) {
                    if (v10 == dimensionBehaviour) {
                        v10 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (v11 == dimensionBehaviour) {
                        v11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    C1639b.a aVar = this.f8565a1;
                    aVar.f37514a = v10;
                    aVar.f37515b = v11;
                    aVar.f37516c = constraintWidget2.U();
                    this.f8565a1.f37517d = constraintWidget2.y();
                    interfaceC0372b.b(constraintWidget2, this.f8565a1);
                    constraintWidget2.Y0(this.f8565a1.f37518e);
                    constraintWidget2.z0(this.f8565a1.f37519f);
                    constraintWidget2.o0(this.f8565a1.f37520g);
                }
            }
        }
        return true;
    }

    public boolean r1() {
        return this.f8562X0;
    }

    public void s1(boolean z10) {
        this.f8562X0 = z10;
    }

    public void t1(int i10, int i11) {
        this.f8563Y0 = i10;
        this.f8564Z0 = i11;
    }

    public void u1(int i10) {
        this.f8556R0 = i10;
        this.f8554P0 = i10;
        this.f8557S0 = i10;
        this.f8555Q0 = i10;
        this.f8558T0 = i10;
        this.f8559U0 = i10;
    }

    public void v1(int i10) {
        this.f8555Q0 = i10;
    }

    public void w1(int i10) {
        this.f8559U0 = i10;
    }

    public void x1(int i10) {
        this.f8556R0 = i10;
        this.f8560V0 = i10;
    }

    public void y1(int i10) {
        this.f8557S0 = i10;
        this.f8561W0 = i10;
    }

    public void z1(int i10) {
        this.f8558T0 = i10;
        this.f8560V0 = i10;
        this.f8561W0 = i10;
    }

    public void o1(int i10, int i11, int i12, int i13) {
    }
}
