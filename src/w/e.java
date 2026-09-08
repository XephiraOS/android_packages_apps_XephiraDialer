package w;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import v.C1616b;
import w.C1639b;

/* compiled from: DependencyGraph.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.d f37526a;

    /* renamed from: d, reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.d f37529d;

    /* renamed from: b, reason: collision with root package name */
    public boolean f37527b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f37528c = true;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f37530e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<i> f37531f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public C1639b.InterfaceC0372b f37532g = null;

    /* renamed from: h, reason: collision with root package name */
    public C1639b.a f37533h = new C1639b.a();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<i> f37534i = new ArrayList<>();

    public e(androidx.constraintlayout.solver.widgets.d dVar) {
        this.f37526a = dVar;
        this.f37529d = dVar;
    }

    public final void a(DependencyNode dependencyNode, int i10, int i11, DependencyNode dependencyNode2, ArrayList<i> arrayList, i iVar) {
        WidgetRun widgetRun = dependencyNode.f8412d;
        if (widgetRun.f8432c == null) {
            androidx.constraintlayout.solver.widgets.d dVar = this.f37526a;
            if (widgetRun != dVar.f8354e && widgetRun != dVar.f8356f) {
                if (iVar == null) {
                    iVar = new i(widgetRun, i11);
                    arrayList.add(iVar);
                }
                widgetRun.f8432c = iVar;
                iVar.a(widgetRun);
                for (d dVar2 : widgetRun.f8437h.f8419k) {
                    if (dVar2 instanceof DependencyNode) {
                        a((DependencyNode) dVar2, i10, 0, dependencyNode2, arrayList, iVar);
                    }
                }
                for (d dVar3 : widgetRun.f8438i.f8419k) {
                    if (dVar3 instanceof DependencyNode) {
                        a((DependencyNode) dVar3, i10, 1, dependencyNode2, arrayList, iVar);
                    }
                }
                if (i10 == 1 && (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.d)) {
                    for (d dVar4 : ((androidx.constraintlayout.solver.widgets.analyzer.d) widgetRun).f8449k.f8419k) {
                        if (dVar4 instanceof DependencyNode) {
                            a((DependencyNode) dVar4, i10, 2, dependencyNode2, arrayList, iVar);
                        }
                    }
                }
                for (DependencyNode dependencyNode3 : widgetRun.f8437h.f8420l) {
                    if (dependencyNode3 == dependencyNode2) {
                        iVar.f37538b = true;
                    }
                    a(dependencyNode3, i10, 0, dependencyNode2, arrayList, iVar);
                }
                for (DependencyNode dependencyNode4 : widgetRun.f8438i.f8420l) {
                    if (dependencyNode4 == dependencyNode2) {
                        iVar.f37538b = true;
                    }
                    a(dependencyNode4, i10, 1, dependencyNode2, arrayList, iVar);
                }
                if (i10 == 1 && (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.d)) {
                    Iterator<DependencyNode> it = ((androidx.constraintlayout.solver.widgets.analyzer.d) widgetRun).f8449k.f8420l.iterator();
                    while (it.hasNext()) {
                        a(it.next(), i10, 2, dependencyNode2, arrayList, iVar);
                    }
                }
            }
        }
    }

    public final boolean b(androidx.constraintlayout.solver.widgets.d dVar) {
        int i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        Iterator<ConstraintWidget> it = dVar.f37371N0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = next.f8340U;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr2[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr2[1];
            if (next.T() == 8) {
                next.f8346a = true;
            } else {
                if (next.f8386u < 1.0f && dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.f8376p = 2;
                }
                if (next.f8392x < 1.0f && dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.f8378q = 2;
                }
                if (next.w() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour7 == dimensionBehaviour9 && (dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.f8376p = 3;
                    } else if (dimensionBehaviour8 == dimensionBehaviour9 && (dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.f8378q = 3;
                    } else if (dimensionBehaviour7 == dimensionBehaviour9 && dimensionBehaviour8 == dimensionBehaviour9) {
                        if (next.f8376p == 0) {
                            next.f8376p = 3;
                        }
                        if (next.f8378q == 0) {
                            next.f8378q = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour7 == dimensionBehaviour10 && next.f8376p == 1 && (next.f8326J.f8292f == null || next.f8330L.f8292f == null)) {
                    dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = dimensionBehaviour7;
                if (dimensionBehaviour8 == dimensionBehaviour10 && next.f8378q == 1 && (next.f8328K.f8292f == null || next.f8332M.f8292f == null)) {
                    dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = dimensionBehaviour8;
                androidx.constraintlayout.solver.widgets.analyzer.c cVar = next.f8354e;
                cVar.f8433d = dimensionBehaviour11;
                int i12 = next.f8376p;
                cVar.f8430a = i12;
                androidx.constraintlayout.solver.widgets.analyzer.d dVar2 = next.f8356f;
                dVar2.f8433d = dimensionBehaviour12;
                int i13 = next.f8378q;
                dVar2.f8430a = i13;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour11 != dimensionBehaviour13 && dimensionBehaviour11 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour11 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour12 != dimensionBehaviour13 && dimensionBehaviour12 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour12 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    if (dimensionBehaviour11 == dimensionBehaviour10 && (dimensionBehaviour12 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour12 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i12 == 3) {
                            if (dimensionBehaviour12 == dimensionBehaviour6) {
                                l(next, dimensionBehaviour6, 0, dimensionBehaviour6, 0);
                            }
                            int y10 = next.y();
                            int i14 = (int) ((y10 * next.f8344Y) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(next, dimensionBehaviour14, i14, dimensionBehaviour14, y10);
                            next.f8354e.f8434e.d(next.U());
                            next.f8356f.f8434e.d(next.y());
                            next.f8346a = true;
                        } else if (i12 == 1) {
                            l(next, dimensionBehaviour6, 0, dimensionBehaviour12, 0);
                            next.f8354e.f8434e.f8446m = next.U();
                        } else if (i12 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = dVar.f8340U[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour15 == dimensionBehaviour16 || dimensionBehaviour15 == dimensionBehaviour13) {
                                l(next, dimensionBehaviour16, (int) ((next.f8386u * dVar.U()) + 0.5f), dimensionBehaviour12, next.y());
                                next.f8354e.f8434e.d(next.U());
                                next.f8356f.f8434e.d(next.y());
                                next.f8346a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.f8337R;
                            if (constraintAnchorArr[0].f8292f == null || constraintAnchorArr[1].f8292f == null) {
                                l(next, dimensionBehaviour6, 0, dimensionBehaviour12, 0);
                                next.f8354e.f8434e.d(next.U());
                                next.f8356f.f8434e.d(next.y());
                                next.f8346a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour12 == dimensionBehaviour10 && (dimensionBehaviour11 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour11 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i13 == 3) {
                            if (dimensionBehaviour11 == dimensionBehaviour5) {
                                l(next, dimensionBehaviour5, 0, dimensionBehaviour5, 0);
                            }
                            int U10 = next.U();
                            float f10 = next.f8344Y;
                            if (next.x() == -1) {
                                f10 = 1.0f / f10;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(next, dimensionBehaviour17, U10, dimensionBehaviour17, (int) ((U10 * f10) + 0.5f));
                            next.f8354e.f8434e.d(next.U());
                            next.f8356f.f8434e.d(next.y());
                            next.f8346a = true;
                        } else if (i13 == 1) {
                            l(next, dimensionBehaviour11, 0, dimensionBehaviour5, 0);
                            next.f8356f.f8434e.f8446m = next.y();
                        } else if (i13 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = dVar.f8340U[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour18 == dimensionBehaviour19 || dimensionBehaviour18 == dimensionBehaviour13) {
                                l(next, dimensionBehaviour11, next.U(), dimensionBehaviour19, (int) ((next.f8392x * dVar.y()) + 0.5f));
                                next.f8354e.f8434e.d(next.U());
                                next.f8356f.f8434e.d(next.y());
                                next.f8346a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.f8337R;
                            if (constraintAnchorArr2[2].f8292f == null || constraintAnchorArr2[3].f8292f == null) {
                                l(next, dimensionBehaviour5, 0, dimensionBehaviour12, 0);
                                next.f8354e.f8434e.d(next.U());
                                next.f8356f.f8434e.d(next.y());
                                next.f8346a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour11 == dimensionBehaviour10 && dimensionBehaviour12 == dimensionBehaviour10) {
                        if (i12 != 1 && i13 != 1) {
                            if (i13 == 2 && i12 == 2 && ((dimensionBehaviour3 = (dimensionBehaviourArr = dVar.f8340U)[0]) == (dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED) || dimensionBehaviour3 == dimensionBehaviour4)) {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = dimensionBehaviourArr[1];
                                if (dimensionBehaviour20 == dimensionBehaviour4 || dimensionBehaviour20 == dimensionBehaviour4) {
                                    l(next, dimensionBehaviour4, (int) ((next.f8386u * dVar.U()) + 0.5f), dimensionBehaviour4, (int) ((next.f8392x * dVar.y()) + 0.5f));
                                    next.f8354e.f8434e.d(next.U());
                                    next.f8356f.f8434e.d(next.y());
                                    next.f8346a = true;
                                }
                            }
                        } else {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour21 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            l(next, dimensionBehaviour21, 0, dimensionBehaviour21, 0);
                            next.f8354e.f8434e.f8446m = next.U();
                            next.f8356f.f8434e.f8446m = next.y();
                        }
                    }
                } else {
                    int U11 = next.U();
                    if (dimensionBehaviour11 == dimensionBehaviour13) {
                        i10 = (dVar.U() - next.f8326J.f8293g) - next.f8330L.f8293g;
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i10 = U11;
                        dimensionBehaviour = dimensionBehaviour11;
                    }
                    int y11 = next.y();
                    if (dimensionBehaviour12 == dimensionBehaviour13) {
                        i11 = (dVar.y() - next.f8328K.f8293g) - next.f8332M.f8293g;
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i11 = y11;
                        dimensionBehaviour2 = dimensionBehaviour12;
                    }
                    l(next, dimensionBehaviour, i10, dimensionBehaviour2, i11);
                    next.f8354e.f8434e.d(next.U());
                    next.f8356f.f8434e.d(next.y());
                    next.f8346a = true;
                }
            }
        }
        return false;
    }

    public void c() {
        d(this.f37530e);
        this.f37534i.clear();
        i.f37536h = 0;
        i(this.f37526a.f8354e, 0, this.f37534i);
        i(this.f37526a.f8356f, 1, this.f37534i);
        this.f37527b = false;
    }

    public void d(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.f37529d.f8354e.f();
        this.f37529d.f8356f.f();
        arrayList.add(this.f37529d.f8354e);
        arrayList.add(this.f37529d.f8356f);
        Iterator<ConstraintWidget> it = this.f37529d.f37371N0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof androidx.constraintlayout.solver.widgets.f) {
                arrayList.add(new h(next));
            } else {
                if (next.c0()) {
                    if (next.f8350c == null) {
                        next.f8350c = new C1640c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f8350c);
                } else {
                    arrayList.add(next.f8354e);
                }
                if (next.e0()) {
                    if (next.f8352d == null) {
                        next.f8352d = new C1640c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f8352d);
                } else {
                    arrayList.add(next.f8356f);
                }
                if (next instanceof C1616b) {
                    arrayList.add(new androidx.constraintlayout.solver.widgets.analyzer.b(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f8431b != this.f37529d) {
                next2.d();
            }
        }
    }

    public final int e(androidx.constraintlayout.solver.widgets.d dVar, int i10) {
        int size = this.f37534i.size();
        long j10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            j10 = Math.max(j10, this.f37534i.get(i11).b(dVar, i10));
        }
        return (int) j10;
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = z10 & true;
        if (this.f37527b || this.f37528c) {
            Iterator<ConstraintWidget> it = this.f37526a.f37371N0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.o();
                next.f8346a = false;
                next.f8354e.r();
                next.f8356f.q();
            }
            this.f37526a.o();
            androidx.constraintlayout.solver.widgets.d dVar = this.f37526a;
            dVar.f8346a = false;
            dVar.f8354e.r();
            this.f37526a.f8356f.q();
            this.f37528c = false;
        }
        if (b(this.f37529d)) {
            return false;
        }
        this.f37526a.Z0(0);
        this.f37526a.a1(0);
        ConstraintWidget.DimensionBehaviour v10 = this.f37526a.v(0);
        ConstraintWidget.DimensionBehaviour v11 = this.f37526a.v(1);
        if (this.f37527b) {
            c();
        }
        int V10 = this.f37526a.V();
        int W10 = this.f37526a.W();
        this.f37526a.f8354e.f8437h.d(V10);
        this.f37526a.f8356f.f8437h.d(W10);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (v10 == dimensionBehaviour || v11 == dimensionBehaviour) {
            if (z13) {
                Iterator<WidgetRun> it2 = this.f37530e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().m()) {
                        z13 = false;
                        break;
                    }
                }
            }
            if (z13 && v10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f37526a.D0(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.solver.widgets.d dVar2 = this.f37526a;
                dVar2.Y0(e(dVar2, 0));
                androidx.constraintlayout.solver.widgets.d dVar3 = this.f37526a;
                dVar3.f8354e.f8434e.d(dVar3.U());
            }
            if (z13 && v11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f37526a.U0(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.solver.widgets.d dVar4 = this.f37526a;
                dVar4.z0(e(dVar4, 1));
                androidx.constraintlayout.solver.widgets.d dVar5 = this.f37526a;
                dVar5.f8356f.f8434e.d(dVar5.y());
            }
        }
        androidx.constraintlayout.solver.widgets.d dVar6 = this.f37526a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar6.f8340U[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 != dimensionBehaviour3 && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            z11 = false;
        } else {
            int U10 = dVar6.U() + V10;
            this.f37526a.f8354e.f8438i.d(U10);
            this.f37526a.f8354e.f8434e.d(U10 - V10);
            m();
            androidx.constraintlayout.solver.widgets.d dVar7 = this.f37526a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dVar7.f8340U[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int y10 = dVar7.y() + W10;
                this.f37526a.f8356f.f8438i.d(y10);
                this.f37526a.f8356f.f8434e.d(y10 - W10);
            }
            m();
            z11 = true;
        }
        Iterator<WidgetRun> it3 = this.f37530e.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f8431b != this.f37526a || next2.f8436g) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it4 = this.f37530e.iterator();
        while (it4.hasNext()) {
            WidgetRun next3 = it4.next();
            if (z11 || next3.f8431b != this.f37526a) {
                if (!next3.f8437h.f8418j || ((!next3.f8438i.f8418j && !(next3 instanceof h)) || (!next3.f8434e.f8418j && !(next3 instanceof C1640c) && !(next3 instanceof h)))) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f37526a.D0(v10);
        this.f37526a.U0(v11);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f37527b) {
            Iterator<ConstraintWidget> it = this.f37526a.f37371N0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.o();
                next.f8346a = false;
                androidx.constraintlayout.solver.widgets.analyzer.c cVar = next.f8354e;
                cVar.f8434e.f8418j = false;
                cVar.f8436g = false;
                cVar.r();
                androidx.constraintlayout.solver.widgets.analyzer.d dVar = next.f8356f;
                dVar.f8434e.f8418j = false;
                dVar.f8436g = false;
                dVar.q();
            }
            this.f37526a.o();
            androidx.constraintlayout.solver.widgets.d dVar2 = this.f37526a;
            dVar2.f8346a = false;
            androidx.constraintlayout.solver.widgets.analyzer.c cVar2 = dVar2.f8354e;
            cVar2.f8434e.f8418j = false;
            cVar2.f8436g = false;
            cVar2.r();
            androidx.constraintlayout.solver.widgets.analyzer.d dVar3 = this.f37526a.f8356f;
            dVar3.f8434e.f8418j = false;
            dVar3.f8436g = false;
            dVar3.q();
            c();
        }
        if (b(this.f37529d)) {
            return false;
        }
        this.f37526a.Z0(0);
        this.f37526a.a1(0);
        this.f37526a.f8354e.f8437h.d(0);
        this.f37526a.f8356f.f8437h.d(0);
        return true;
    }

    public boolean h(boolean z10, int i10) {
        boolean z11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z12 = true;
        boolean z13 = z10 & true;
        ConstraintWidget.DimensionBehaviour v10 = this.f37526a.v(0);
        ConstraintWidget.DimensionBehaviour v11 = this.f37526a.v(1);
        int V10 = this.f37526a.V();
        int W10 = this.f37526a.W();
        if (z13 && (v10 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || v11 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = this.f37530e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.f8435f == i10 && !next.m()) {
                    z13 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z13 && v10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.f37526a.D0(ConstraintWidget.DimensionBehaviour.FIXED);
                    androidx.constraintlayout.solver.widgets.d dVar = this.f37526a;
                    dVar.Y0(e(dVar, 0));
                    androidx.constraintlayout.solver.widgets.d dVar2 = this.f37526a;
                    dVar2.f8354e.f8434e.d(dVar2.U());
                }
            } else if (z13 && v11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f37526a.U0(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.solver.widgets.d dVar3 = this.f37526a;
                dVar3.z0(e(dVar3, 1));
                androidx.constraintlayout.solver.widgets.d dVar4 = this.f37526a;
                dVar4.f8356f.f8434e.d(dVar4.y());
            }
        }
        if (i10 == 0) {
            androidx.constraintlayout.solver.widgets.d dVar5 = this.f37526a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar5.f8340U[0];
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int U10 = dVar5.U() + V10;
                this.f37526a.f8354e.f8438i.d(U10);
                this.f37526a.f8354e.f8434e.d(U10 - V10);
                z11 = true;
            }
            z11 = false;
        } else {
            androidx.constraintlayout.solver.widgets.d dVar6 = this.f37526a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dVar6.f8340U[1];
            if (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int y10 = dVar6.y() + W10;
                this.f37526a.f8356f.f8438i.d(y10);
                this.f37526a.f8356f.f8434e.d(y10 - W10);
                z11 = true;
            }
            z11 = false;
        }
        m();
        Iterator<WidgetRun> it2 = this.f37530e.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.f8435f == i10 && (next2.f8431b != this.f37526a || next2.f8436g)) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it3 = this.f37530e.iterator();
        while (it3.hasNext()) {
            WidgetRun next3 = it3.next();
            if (next3.f8435f == i10 && (z11 || next3.f8431b != this.f37526a)) {
                if (!next3.f8437h.f8418j || !next3.f8438i.f8418j || (!(next3 instanceof C1640c) && !next3.f8434e.f8418j)) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f37526a.D0(v10);
        this.f37526a.U0(v11);
        return z12;
    }

    public final void i(WidgetRun widgetRun, int i10, ArrayList<i> arrayList) {
        for (d dVar : widgetRun.f8437h.f8419k) {
            if (dVar instanceof DependencyNode) {
                a((DependencyNode) dVar, i10, 0, widgetRun.f8438i, arrayList, null);
            } else if (dVar instanceof WidgetRun) {
                a(((WidgetRun) dVar).f8437h, i10, 0, widgetRun.f8438i, arrayList, null);
            }
        }
        for (d dVar2 : widgetRun.f8438i.f8419k) {
            if (dVar2 instanceof DependencyNode) {
                a((DependencyNode) dVar2, i10, 1, widgetRun.f8437h, arrayList, null);
            } else if (dVar2 instanceof WidgetRun) {
                a(((WidgetRun) dVar2).f8438i, i10, 1, widgetRun.f8437h, arrayList, null);
            }
        }
        if (i10 == 1) {
            for (d dVar3 : ((androidx.constraintlayout.solver.widgets.analyzer.d) widgetRun).f8449k.f8419k) {
                if (dVar3 instanceof DependencyNode) {
                    a((DependencyNode) dVar3, i10, 2, null, arrayList, null);
                }
            }
        }
    }

    public void j() {
        this.f37527b = true;
    }

    public void k() {
        this.f37528c = true;
    }

    public final void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        C1639b.a aVar = this.f37533h;
        aVar.f37514a = dimensionBehaviour;
        aVar.f37515b = dimensionBehaviour2;
        aVar.f37516c = i10;
        aVar.f37517d = i11;
        this.f37532g.b(constraintWidget, aVar);
        constraintWidget.Y0(this.f37533h.f37518e);
        constraintWidget.z0(this.f37533h.f37519f);
        constraintWidget.y0(this.f37533h.f37521h);
        constraintWidget.o0(this.f37533h.f37520g);
    }

    public void m() {
        boolean z10;
        androidx.constraintlayout.solver.widgets.analyzer.a aVar;
        Iterator<ConstraintWidget> it = this.f37526a.f37371N0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.f8346a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.f8340U;
                boolean z11 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i10 = next.f8376p;
                int i11 = next.f8378q;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour != dimensionBehaviour3 && (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || i10 != 1)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1)) {
                    z11 = true;
                }
                androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = next.f8354e.f8434e;
                boolean z12 = aVar2.f8418j;
                androidx.constraintlayout.solver.widgets.analyzer.a aVar3 = next.f8356f.f8434e;
                boolean z13 = aVar3.f8418j;
                if (z12 && z13) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(next, dimensionBehaviour4, aVar2.f8415g, dimensionBehaviour4, aVar3.f8415g);
                    next.f8346a = true;
                } else if (z12 && z11) {
                    l(next, ConstraintWidget.DimensionBehaviour.FIXED, aVar2.f8415g, dimensionBehaviour3, aVar3.f8415g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f8356f.f8434e.f8446m = next.y();
                    } else {
                        next.f8356f.f8434e.d(next.y());
                        next.f8346a = true;
                    }
                } else if (z13 && z10) {
                    l(next, dimensionBehaviour3, aVar2.f8415g, ConstraintWidget.DimensionBehaviour.FIXED, aVar3.f8415g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f8354e.f8434e.f8446m = next.U();
                    } else {
                        next.f8354e.f8434e.d(next.U());
                        next.f8346a = true;
                    }
                }
                if (next.f8346a && (aVar = next.f8356f.f8450l) != null) {
                    aVar.d(next.q());
                }
            }
        }
    }

    public void n(C1639b.InterfaceC0372b interfaceC0372b) {
        this.f37532g = interfaceC0372b;
    }
}
