package w;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

/* compiled from: GuidelineReference.java */
/* loaded from: classes.dex */
public class h extends WidgetRun {
    public h(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f8354e.f();
        constraintWidget.f8356f.f();
        this.f8435f = ((androidx.constraintlayout.solver.widgets.f) constraintWidget).f1();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, w.d
    public void a(d dVar) {
        DependencyNode dependencyNode = this.f8437h;
        if (!dependencyNode.f8411c || dependencyNode.f8418j) {
            return;
        }
        this.f8437h.d((int) ((dependencyNode.f8420l.get(0).f8415g * ((androidx.constraintlayout.solver.widgets.f) this.f8431b).i1()) + 0.5f));
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void d() {
        androidx.constraintlayout.solver.widgets.f fVar = (androidx.constraintlayout.solver.widgets.f) this.f8431b;
        int g12 = fVar.g1();
        int h12 = fVar.h1();
        fVar.i1();
        if (fVar.f1() == 1) {
            if (g12 != -1) {
                this.f8437h.f8420l.add(this.f8431b.f8341V.f8354e.f8437h);
                this.f8431b.f8341V.f8354e.f8437h.f8419k.add(this.f8437h);
                this.f8437h.f8414f = g12;
            } else if (h12 != -1) {
                this.f8437h.f8420l.add(this.f8431b.f8341V.f8354e.f8438i);
                this.f8431b.f8341V.f8354e.f8438i.f8419k.add(this.f8437h);
                this.f8437h.f8414f = -h12;
            } else {
                DependencyNode dependencyNode = this.f8437h;
                dependencyNode.f8410b = true;
                dependencyNode.f8420l.add(this.f8431b.f8341V.f8354e.f8438i);
                this.f8431b.f8341V.f8354e.f8438i.f8419k.add(this.f8437h);
            }
            q(this.f8431b.f8354e.f8437h);
            q(this.f8431b.f8354e.f8438i);
            return;
        }
        if (g12 != -1) {
            this.f8437h.f8420l.add(this.f8431b.f8341V.f8356f.f8437h);
            this.f8431b.f8341V.f8356f.f8437h.f8419k.add(this.f8437h);
            this.f8437h.f8414f = g12;
        } else if (h12 != -1) {
            this.f8437h.f8420l.add(this.f8431b.f8341V.f8356f.f8438i);
            this.f8431b.f8341V.f8356f.f8438i.f8419k.add(this.f8437h);
            this.f8437h.f8414f = -h12;
        } else {
            DependencyNode dependencyNode2 = this.f8437h;
            dependencyNode2.f8410b = true;
            dependencyNode2.f8420l.add(this.f8431b.f8341V.f8356f.f8438i);
            this.f8431b.f8341V.f8356f.f8438i.f8419k.add(this.f8437h);
        }
        q(this.f8431b.f8356f.f8437h);
        q(this.f8431b.f8356f.f8438i);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void e() {
        if (((androidx.constraintlayout.solver.widgets.f) this.f8431b).f1() == 1) {
            this.f8431b.Z0(this.f8437h.f8415g);
        } else {
            this.f8431b.a1(this.f8437h.f8415g);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void f() {
        this.f8437h.c();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }

    public final void q(DependencyNode dependencyNode) {
        this.f8437h.f8419k.add(dependencyNode);
        dependencyNode.f8420l.add(this.f8437h);
    }
}
