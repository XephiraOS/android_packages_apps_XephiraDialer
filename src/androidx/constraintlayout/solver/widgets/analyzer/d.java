package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import v.InterfaceC1615a;
import w.C1638a;

/* compiled from: VerticalWidgetRun.java */
/* loaded from: classes.dex */
public class d extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public DependencyNode f8449k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.analyzer.a f8450l;

    /* compiled from: VerticalWidgetRun.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8451a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f8451a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8451a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8451a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f8449k = dependencyNode;
        this.f8450l = null;
        this.f8437h.f8413e = DependencyNode.Type.TOP;
        this.f8438i.f8413e = DependencyNode.Type.BOTTOM;
        dependencyNode.f8413e = DependencyNode.Type.BASELINE;
        this.f8435f = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, w.d
    public void a(w.d dVar) {
        float f10;
        float w10;
        float f11;
        int i10;
        int i11 = a.f8451a[this.f8439j.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    ConstraintWidget constraintWidget = this.f8431b;
                    n(dVar, constraintWidget.f8328K, constraintWidget.f8332M, 1);
                    return;
                }
            } else {
                o(dVar);
            }
        } else {
            p(dVar);
        }
        androidx.constraintlayout.solver.widgets.analyzer.a aVar = this.f8434e;
        if (aVar.f8411c && !aVar.f8418j && this.f8433d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f8431b;
            int i12 = constraintWidget2.f8378q;
            if (i12 != 2) {
                if (i12 == 3 && constraintWidget2.f8354e.f8434e.f8418j) {
                    int x10 = constraintWidget2.x();
                    if (x10 != -1) {
                        if (x10 != 0) {
                            if (x10 != 1) {
                                i10 = 0;
                                this.f8434e.d(i10);
                            } else {
                                ConstraintWidget constraintWidget3 = this.f8431b;
                                f10 = constraintWidget3.f8354e.f8434e.f8415g;
                                w10 = constraintWidget3.w();
                            }
                        } else {
                            f11 = r7.f8354e.f8434e.f8415g * this.f8431b.w();
                            i10 = (int) (f11 + 0.5f);
                            this.f8434e.d(i10);
                        }
                    } else {
                        ConstraintWidget constraintWidget4 = this.f8431b;
                        f10 = constraintWidget4.f8354e.f8434e.f8415g;
                        w10 = constraintWidget4.w();
                    }
                    f11 = f10 / w10;
                    i10 = (int) (f11 + 0.5f);
                    this.f8434e.d(i10);
                }
            } else {
                ConstraintWidget L10 = constraintWidget2.L();
                if (L10 != null) {
                    if (L10.f8356f.f8434e.f8418j) {
                        this.f8434e.d((int) ((r7.f8415g * this.f8431b.f8392x) + 0.5f));
                    }
                }
            }
        }
        DependencyNode dependencyNode = this.f8437h;
        if (dependencyNode.f8411c) {
            DependencyNode dependencyNode2 = this.f8438i;
            if (dependencyNode2.f8411c) {
                if (dependencyNode.f8418j && dependencyNode2.f8418j && this.f8434e.f8418j) {
                    return;
                }
                if (!this.f8434e.f8418j && this.f8433d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.f8431b;
                    if (constraintWidget5.f8376p == 0 && !constraintWidget5.e0()) {
                        DependencyNode dependencyNode3 = this.f8437h.f8420l.get(0);
                        DependencyNode dependencyNode4 = this.f8438i.f8420l.get(0);
                        int i13 = dependencyNode3.f8415g;
                        DependencyNode dependencyNode5 = this.f8437h;
                        int i14 = i13 + dependencyNode5.f8414f;
                        int i15 = dependencyNode4.f8415g + this.f8438i.f8414f;
                        dependencyNode5.d(i14);
                        this.f8438i.d(i15);
                        this.f8434e.d(i15 - i14);
                        return;
                    }
                }
                if (!this.f8434e.f8418j && this.f8433d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f8430a == 1 && this.f8437h.f8420l.size() > 0 && this.f8438i.f8420l.size() > 0) {
                    DependencyNode dependencyNode6 = this.f8437h.f8420l.get(0);
                    int i16 = (this.f8438i.f8420l.get(0).f8415g + this.f8438i.f8414f) - (dependencyNode6.f8415g + this.f8437h.f8414f);
                    androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = this.f8434e;
                    int i17 = aVar2.f8446m;
                    if (i16 < i17) {
                        aVar2.d(i16);
                    } else {
                        aVar2.d(i17);
                    }
                }
                if (this.f8434e.f8418j && this.f8437h.f8420l.size() > 0 && this.f8438i.f8420l.size() > 0) {
                    DependencyNode dependencyNode7 = this.f8437h.f8420l.get(0);
                    DependencyNode dependencyNode8 = this.f8438i.f8420l.get(0);
                    int i18 = dependencyNode7.f8415g + this.f8437h.f8414f;
                    int i19 = dependencyNode8.f8415g + this.f8438i.f8414f;
                    float P10 = this.f8431b.P();
                    if (dependencyNode7 == dependencyNode8) {
                        i18 = dependencyNode7.f8415g;
                        i19 = dependencyNode8.f8415g;
                        P10 = 0.5f;
                    }
                    this.f8437h.d((int) (i18 + 0.5f + (((i19 - i18) - this.f8434e.f8415g) * P10)));
                    this.f8438i.d(this.f8437h.f8415g + this.f8434e.f8415g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget L10;
        ConstraintWidget L11;
        ConstraintWidget constraintWidget = this.f8431b;
        if (constraintWidget.f8346a) {
            this.f8434e.d(constraintWidget.y());
        }
        if (!this.f8434e.f8418j) {
            this.f8433d = this.f8431b.R();
            if (this.f8431b.X()) {
                this.f8450l = new C1638a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f8433d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (L11 = this.f8431b.L()) != null && L11.R() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int y10 = (L11.y() - this.f8431b.f8328K.f()) - this.f8431b.f8332M.f();
                    b(this.f8437h, L11.f8356f.f8437h, this.f8431b.f8328K.f());
                    b(this.f8438i, L11.f8356f.f8438i, -this.f8431b.f8332M.f());
                    this.f8434e.d(y10);
                    return;
                }
                if (this.f8433d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f8434e.d(this.f8431b.y());
                }
            }
        } else if (this.f8433d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (L10 = this.f8431b.L()) != null && L10.R() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f8437h, L10.f8356f.f8437h, this.f8431b.f8328K.f());
            b(this.f8438i, L10.f8356f.f8438i, -this.f8431b.f8332M.f());
            return;
        }
        androidx.constraintlayout.solver.widgets.analyzer.a aVar = this.f8434e;
        boolean z10 = aVar.f8418j;
        if (z10) {
            ConstraintWidget constraintWidget2 = this.f8431b;
            if (constraintWidget2.f8346a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.f8337R;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f8292f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f8292f != null) {
                    if (constraintWidget2.e0()) {
                        this.f8437h.f8414f = this.f8431b.f8337R[2].f();
                        this.f8438i.f8414f = -this.f8431b.f8337R[3].f();
                    } else {
                        DependencyNode h10 = h(this.f8431b.f8337R[2]);
                        if (h10 != null) {
                            b(this.f8437h, h10, this.f8431b.f8337R[2].f());
                        }
                        DependencyNode h11 = h(this.f8431b.f8337R[3]);
                        if (h11 != null) {
                            b(this.f8438i, h11, -this.f8431b.f8337R[3].f());
                        }
                        this.f8437h.f8410b = true;
                        this.f8438i.f8410b = true;
                    }
                    if (this.f8431b.X()) {
                        b(this.f8449k, this.f8437h, this.f8431b.q());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode h12 = h(constraintAnchor);
                    if (h12 != null) {
                        b(this.f8437h, h12, this.f8431b.f8337R[2].f());
                        b(this.f8438i, this.f8437h, this.f8434e.f8415g);
                        if (this.f8431b.X()) {
                            b(this.f8449k, this.f8437h, this.f8431b.q());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f8292f != null) {
                    DependencyNode h13 = h(constraintAnchor3);
                    if (h13 != null) {
                        b(this.f8438i, h13, -this.f8431b.f8337R[3].f());
                        b(this.f8437h, this.f8438i, -this.f8434e.f8415g);
                    }
                    if (this.f8431b.X()) {
                        b(this.f8449k, this.f8437h, this.f8431b.q());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f8292f != null) {
                    DependencyNode h14 = h(constraintAnchor4);
                    if (h14 != null) {
                        b(this.f8449k, h14, 0);
                        b(this.f8437h, this.f8449k, -this.f8431b.q());
                        b(this.f8438i, this.f8437h, this.f8434e.f8415g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof InterfaceC1615a) || constraintWidget2.L() == null || this.f8431b.p(ConstraintAnchor.Type.CENTER).f8292f != null) {
                    return;
                }
                b(this.f8437h, this.f8431b.L().f8356f.f8437h, this.f8431b.W());
                b(this.f8438i, this.f8437h, this.f8434e.f8415g);
                if (this.f8431b.X()) {
                    b(this.f8449k, this.f8437h, this.f8431b.q());
                    return;
                }
                return;
            }
        }
        if (!z10 && this.f8433d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f8431b;
            int i10 = constraintWidget3.f8378q;
            if (i10 != 2) {
                if (i10 == 3 && !constraintWidget3.e0()) {
                    ConstraintWidget constraintWidget4 = this.f8431b;
                    if (constraintWidget4.f8376p != 3) {
                        androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = constraintWidget4.f8354e.f8434e;
                        this.f8434e.f8420l.add(aVar2);
                        aVar2.f8419k.add(this.f8434e);
                        androidx.constraintlayout.solver.widgets.analyzer.a aVar3 = this.f8434e;
                        aVar3.f8410b = true;
                        aVar3.f8419k.add(this.f8437h);
                        this.f8434e.f8419k.add(this.f8438i);
                    }
                }
            } else {
                ConstraintWidget L12 = constraintWidget3.L();
                if (L12 != null) {
                    androidx.constraintlayout.solver.widgets.analyzer.a aVar4 = L12.f8356f.f8434e;
                    this.f8434e.f8420l.add(aVar4);
                    aVar4.f8419k.add(this.f8434e);
                    androidx.constraintlayout.solver.widgets.analyzer.a aVar5 = this.f8434e;
                    aVar5.f8410b = true;
                    aVar5.f8419k.add(this.f8437h);
                    this.f8434e.f8419k.add(this.f8438i);
                }
            }
        } else {
            aVar.b(this);
        }
        ConstraintWidget constraintWidget5 = this.f8431b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.f8337R;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f8292f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f8292f != null) {
            if (constraintWidget5.e0()) {
                this.f8437h.f8414f = this.f8431b.f8337R[2].f();
                this.f8438i.f8414f = -this.f8431b.f8337R[3].f();
            } else {
                DependencyNode h15 = h(this.f8431b.f8337R[2]);
                DependencyNode h16 = h(this.f8431b.f8337R[3]);
                h15.b(this);
                h16.b(this);
                this.f8439j = WidgetRun.RunType.CENTER;
            }
            if (this.f8431b.X()) {
                c(this.f8449k, this.f8437h, 1, this.f8450l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode h17 = h(constraintAnchor5);
            if (h17 != null) {
                b(this.f8437h, h17, this.f8431b.f8337R[2].f());
                c(this.f8438i, this.f8437h, 1, this.f8434e);
                if (this.f8431b.X()) {
                    c(this.f8449k, this.f8437h, 1, this.f8450l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f8433d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f8431b.w() > 0.0f) {
                    c cVar = this.f8431b.f8354e;
                    if (cVar.f8433d == dimensionBehaviour3) {
                        cVar.f8434e.f8419k.add(this.f8434e);
                        this.f8434e.f8420l.add(this.f8431b.f8354e.f8434e);
                        this.f8434e.f8409a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f8292f != null) {
                DependencyNode h18 = h(constraintAnchor7);
                if (h18 != null) {
                    b(this.f8438i, h18, -this.f8431b.f8337R[3].f());
                    c(this.f8437h, this.f8438i, -1, this.f8434e);
                    if (this.f8431b.X()) {
                        c(this.f8449k, this.f8437h, 1, this.f8450l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f8292f != null) {
                    DependencyNode h19 = h(constraintAnchor8);
                    if (h19 != null) {
                        b(this.f8449k, h19, 0);
                        c(this.f8437h, this.f8449k, -1, this.f8450l);
                        c(this.f8438i, this.f8437h, 1, this.f8434e);
                    }
                } else if (!(constraintWidget5 instanceof InterfaceC1615a) && constraintWidget5.L() != null) {
                    b(this.f8437h, this.f8431b.L().f8356f.f8437h, this.f8431b.W());
                    c(this.f8438i, this.f8437h, 1, this.f8434e);
                    if (this.f8431b.X()) {
                        c(this.f8449k, this.f8437h, 1, this.f8450l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f8433d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f8431b.w() > 0.0f) {
                        c cVar2 = this.f8431b.f8354e;
                        if (cVar2.f8433d == dimensionBehaviour5) {
                            cVar2.f8434e.f8419k.add(this.f8434e);
                            this.f8434e.f8420l.add(this.f8431b.f8354e.f8434e);
                            this.f8434e.f8409a = this;
                        }
                    }
                }
            }
        }
        if (this.f8434e.f8420l.size() == 0) {
            this.f8434e.f8411c = true;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f8437h;
        if (dependencyNode.f8418j) {
            this.f8431b.a1(dependencyNode.f8415g);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void f() {
        this.f8432c = null;
        this.f8437h.c();
        this.f8438i.c();
        this.f8449k.c();
        this.f8434e.c();
        this.f8436g = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean m() {
        if (this.f8433d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f8431b.f8378q == 0) {
            return true;
        }
        return false;
    }

    public void q() {
        this.f8436g = false;
        this.f8437h.c();
        this.f8437h.f8418j = false;
        this.f8438i.c();
        this.f8438i.f8418j = false;
        this.f8449k.c();
        this.f8449k.f8418j = false;
        this.f8434e.f8418j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f8431b.u();
    }
}
