package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import v.InterfaceC1615a;

/* compiled from: HorizontalWidgetRun.java */
/* loaded from: classes.dex */
public class c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public static int[] f8447k = new int[2];

    /* compiled from: HorizontalWidgetRun.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8448a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f8448a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8448a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8448a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public c(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f8437h.f8413e = DependencyNode.Type.LEFT;
        this.f8438i.f8413e = DependencyNode.Type.RIGHT;
        this.f8435f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x02ba, code lost:
    
        if (r14 != 1) goto L135;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, w.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(w.d r17) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.c.a(w.d):void");
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget L10;
        ConstraintWidget L11;
        ConstraintWidget constraintWidget = this.f8431b;
        if (constraintWidget.f8346a) {
            this.f8434e.d(constraintWidget.U());
        }
        if (!this.f8434e.f8418j) {
            ConstraintWidget.DimensionBehaviour B10 = this.f8431b.B();
            this.f8433d = B10;
            if (B10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (B10 == dimensionBehaviour && (((L11 = this.f8431b.L()) != null && L11.B() == ConstraintWidget.DimensionBehaviour.FIXED) || L11.B() == dimensionBehaviour)) {
                    int U10 = (L11.U() - this.f8431b.f8326J.f()) - this.f8431b.f8330L.f();
                    b(this.f8437h, L11.f8354e.f8437h, this.f8431b.f8326J.f());
                    b(this.f8438i, L11.f8354e.f8438i, -this.f8431b.f8330L.f());
                    this.f8434e.d(U10);
                    return;
                }
                if (this.f8433d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f8434e.d(this.f8431b.U());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f8433d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (((L10 = this.f8431b.L()) != null && L10.B() == ConstraintWidget.DimensionBehaviour.FIXED) || L10.B() == dimensionBehaviour3)) {
                b(this.f8437h, L10.f8354e.f8437h, this.f8431b.f8326J.f());
                b(this.f8438i, L10.f8354e.f8438i, -this.f8431b.f8330L.f());
                return;
            }
        }
        androidx.constraintlayout.solver.widgets.analyzer.a aVar = this.f8434e;
        if (aVar.f8418j) {
            ConstraintWidget constraintWidget2 = this.f8431b;
            if (constraintWidget2.f8346a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.f8337R;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f8292f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f8292f != null) {
                    if (constraintWidget2.c0()) {
                        this.f8437h.f8414f = this.f8431b.f8337R[0].f();
                        this.f8438i.f8414f = -this.f8431b.f8337R[1].f();
                        return;
                    }
                    DependencyNode h10 = h(this.f8431b.f8337R[0]);
                    if (h10 != null) {
                        b(this.f8437h, h10, this.f8431b.f8337R[0].f());
                    }
                    DependencyNode h11 = h(this.f8431b.f8337R[1]);
                    if (h11 != null) {
                        b(this.f8438i, h11, -this.f8431b.f8337R[1].f());
                    }
                    this.f8437h.f8410b = true;
                    this.f8438i.f8410b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode h12 = h(constraintAnchor);
                    if (h12 != null) {
                        b(this.f8437h, h12, this.f8431b.f8337R[0].f());
                        b(this.f8438i, this.f8437h, this.f8434e.f8415g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f8292f != null) {
                    DependencyNode h13 = h(constraintAnchor3);
                    if (h13 != null) {
                        b(this.f8438i, h13, -this.f8431b.f8337R[1].f());
                        b(this.f8437h, this.f8438i, -this.f8434e.f8415g);
                        return;
                    }
                    return;
                }
                if (!(constraintWidget2 instanceof InterfaceC1615a) && constraintWidget2.L() != null && this.f8431b.p(ConstraintAnchor.Type.CENTER).f8292f == null) {
                    b(this.f8437h, this.f8431b.L().f8354e.f8437h, this.f8431b.V());
                    b(this.f8438i, this.f8437h, this.f8434e.f8415g);
                    return;
                }
                return;
            }
        }
        if (this.f8433d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f8431b;
            int i10 = constraintWidget3.f8376p;
            if (i10 != 2) {
                if (i10 == 3) {
                    if (constraintWidget3.f8378q == 3) {
                        this.f8437h.f8409a = this;
                        this.f8438i.f8409a = this;
                        d dVar = constraintWidget3.f8356f;
                        dVar.f8437h.f8409a = this;
                        dVar.f8438i.f8409a = this;
                        aVar.f8409a = this;
                        if (constraintWidget3.e0()) {
                            this.f8434e.f8420l.add(this.f8431b.f8356f.f8434e);
                            this.f8431b.f8356f.f8434e.f8419k.add(this.f8434e);
                            d dVar2 = this.f8431b.f8356f;
                            dVar2.f8434e.f8409a = this;
                            this.f8434e.f8420l.add(dVar2.f8437h);
                            this.f8434e.f8420l.add(this.f8431b.f8356f.f8438i);
                            this.f8431b.f8356f.f8437h.f8419k.add(this.f8434e);
                            this.f8431b.f8356f.f8438i.f8419k.add(this.f8434e);
                        } else if (this.f8431b.c0()) {
                            this.f8431b.f8356f.f8434e.f8420l.add(this.f8434e);
                            this.f8434e.f8419k.add(this.f8431b.f8356f.f8434e);
                        } else {
                            this.f8431b.f8356f.f8434e.f8420l.add(this.f8434e);
                        }
                    } else {
                        androidx.constraintlayout.solver.widgets.analyzer.a aVar2 = constraintWidget3.f8356f.f8434e;
                        aVar.f8420l.add(aVar2);
                        aVar2.f8419k.add(this.f8434e);
                        this.f8431b.f8356f.f8437h.f8419k.add(this.f8434e);
                        this.f8431b.f8356f.f8438i.f8419k.add(this.f8434e);
                        androidx.constraintlayout.solver.widgets.analyzer.a aVar3 = this.f8434e;
                        aVar3.f8410b = true;
                        aVar3.f8419k.add(this.f8437h);
                        this.f8434e.f8419k.add(this.f8438i);
                        this.f8437h.f8420l.add(this.f8434e);
                        this.f8438i.f8420l.add(this.f8434e);
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
        }
        ConstraintWidget constraintWidget4 = this.f8431b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.f8337R;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f8292f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f8292f != null) {
            if (constraintWidget4.c0()) {
                this.f8437h.f8414f = this.f8431b.f8337R[0].f();
                this.f8438i.f8414f = -this.f8431b.f8337R[1].f();
                return;
            }
            DependencyNode h14 = h(this.f8431b.f8337R[0]);
            DependencyNode h15 = h(this.f8431b.f8337R[1]);
            h14.b(this);
            h15.b(this);
            this.f8439j = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode h16 = h(constraintAnchor4);
            if (h16 != null) {
                b(this.f8437h, h16, this.f8431b.f8337R[0].f());
                c(this.f8438i, this.f8437h, 1, this.f8434e);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f8292f != null) {
            DependencyNode h17 = h(constraintAnchor6);
            if (h17 != null) {
                b(this.f8438i, h17, -this.f8431b.f8337R[1].f());
                c(this.f8437h, this.f8438i, -1, this.f8434e);
                return;
            }
            return;
        }
        if (!(constraintWidget4 instanceof InterfaceC1615a) && constraintWidget4.L() != null) {
            b(this.f8437h, this.f8431b.L().f8354e.f8437h, this.f8431b.V());
            c(this.f8438i, this.f8437h, 1, this.f8434e);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f8437h;
        if (dependencyNode.f8418j) {
            this.f8431b.Z0(dependencyNode.f8415g);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void f() {
        this.f8432c = null;
        this.f8437h.c();
        this.f8438i.c();
        this.f8434e.c();
        this.f8436g = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean m() {
        if (this.f8433d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f8431b.f8376p == 0) {
            return true;
        }
        return false;
    }

    public final void q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 != 0) {
                if (i14 == 1) {
                    iArr[0] = i15;
                    iArr[1] = (int) ((i15 * f10) + 0.5f);
                    return;
                }
                return;
            }
            iArr[0] = (int) ((i16 * f10) + 0.5f);
            iArr[1] = i16;
            return;
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    public void r() {
        this.f8436g = false;
        this.f8437h.c();
        this.f8437h.f8418j = false;
        this.f8438i.c();
        this.f8438i.f8418j = false;
        this.f8434e.f8418j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f8431b.u();
    }
}
