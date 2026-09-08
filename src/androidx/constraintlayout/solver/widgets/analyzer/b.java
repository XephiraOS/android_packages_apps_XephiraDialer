package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* compiled from: HelperReferences.java */
/* loaded from: classes.dex */
public class b extends WidgetRun {
    public b(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.f8437h.f8419k.add(dependencyNode);
        dependencyNode.f8420l.add(this.f8437h);
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, w.d
    public void a(w.d dVar) {
        androidx.constraintlayout.solver.widgets.a aVar = (androidx.constraintlayout.solver.widgets.a) this.f8431b;
        int i12 = aVar.i1();
        Iterator<DependencyNode> it = this.f8437h.f8420l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i13 = it.next().f8415g;
            if (i11 == -1 || i13 < i11) {
                i11 = i13;
            }
            if (i10 < i13) {
                i10 = i13;
            }
        }
        if (i12 != 0 && i12 != 2) {
            this.f8437h.d(i10 + aVar.j1());
        } else {
            this.f8437h.d(i11 + aVar.j1());
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidget = this.f8431b;
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.a) {
            this.f8437h.f8410b = true;
            androidx.constraintlayout.solver.widgets.a aVar = (androidx.constraintlayout.solver.widgets.a) constraintWidget;
            int i12 = aVar.i1();
            boolean h12 = aVar.h1();
            int i10 = 0;
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 == 3) {
                            this.f8437h.f8413e = DependencyNode.Type.BOTTOM;
                            while (i10 < aVar.f37370O0) {
                                ConstraintWidget constraintWidget2 = aVar.f37369N0[i10];
                                if (h12 || constraintWidget2.T() != 8) {
                                    DependencyNode dependencyNode = constraintWidget2.f8356f.f8438i;
                                    dependencyNode.f8419k.add(this.f8437h);
                                    this.f8437h.f8420l.add(dependencyNode);
                                }
                                i10++;
                            }
                            q(this.f8431b.f8356f.f8437h);
                            q(this.f8431b.f8356f.f8438i);
                            return;
                        }
                        return;
                    }
                    this.f8437h.f8413e = DependencyNode.Type.TOP;
                    while (i10 < aVar.f37370O0) {
                        ConstraintWidget constraintWidget3 = aVar.f37369N0[i10];
                        if (h12 || constraintWidget3.T() != 8) {
                            DependencyNode dependencyNode2 = constraintWidget3.f8356f.f8437h;
                            dependencyNode2.f8419k.add(this.f8437h);
                            this.f8437h.f8420l.add(dependencyNode2);
                        }
                        i10++;
                    }
                    q(this.f8431b.f8356f.f8437h);
                    q(this.f8431b.f8356f.f8438i);
                    return;
                }
                this.f8437h.f8413e = DependencyNode.Type.RIGHT;
                while (i10 < aVar.f37370O0) {
                    ConstraintWidget constraintWidget4 = aVar.f37369N0[i10];
                    if (h12 || constraintWidget4.T() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f8354e.f8438i;
                        dependencyNode3.f8419k.add(this.f8437h);
                        this.f8437h.f8420l.add(dependencyNode3);
                    }
                    i10++;
                }
                q(this.f8431b.f8354e.f8437h);
                q(this.f8431b.f8354e.f8438i);
                return;
            }
            this.f8437h.f8413e = DependencyNode.Type.LEFT;
            while (i10 < aVar.f37370O0) {
                ConstraintWidget constraintWidget5 = aVar.f37369N0[i10];
                if (h12 || constraintWidget5.T() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.f8354e.f8437h;
                    dependencyNode4.f8419k.add(this.f8437h);
                    this.f8437h.f8420l.add(dependencyNode4);
                }
                i10++;
            }
            q(this.f8431b.f8354e.f8437h);
            q(this.f8431b.f8354e.f8438i);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void e() {
        ConstraintWidget constraintWidget = this.f8431b;
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.a) {
            int i12 = ((androidx.constraintlayout.solver.widgets.a) constraintWidget).i1();
            if (i12 != 0 && i12 != 1) {
                this.f8431b.a1(this.f8437h.f8415g);
            } else {
                this.f8431b.Z0(this.f8437h.f8415g);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void f() {
        this.f8432c = null;
        this.f8437h.c();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }
}
