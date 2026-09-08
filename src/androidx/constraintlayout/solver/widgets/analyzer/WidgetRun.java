package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import w.i;

/* loaded from: classes.dex */
public abstract class WidgetRun implements w.d {

    /* renamed from: a, reason: collision with root package name */
    public int f8430a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintWidget f8431b;

    /* renamed from: c, reason: collision with root package name */
    public i f8432c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f8433d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.analyzer.a f8434e = new androidx.constraintlayout.solver.widgets.analyzer.a(this);

    /* renamed from: f, reason: collision with root package name */
    public int f8435f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8436g = false;

    /* renamed from: h, reason: collision with root package name */
    public DependencyNode f8437h = new DependencyNode(this);

    /* renamed from: i, reason: collision with root package name */
    public DependencyNode f8438i = new DependencyNode(this);

    /* renamed from: j, reason: collision with root package name */
    public RunType f8439j = RunType.NONE;

    /* loaded from: classes.dex */
    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8445a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f8445a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8445a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8445a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8445a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8445a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f8431b = constraintWidget;
    }

    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10) {
        dependencyNode.f8420l.add(dependencyNode2);
        dependencyNode.f8414f = i10;
        dependencyNode2.f8419k.add(dependencyNode);
    }

    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10, androidx.constraintlayout.solver.widgets.analyzer.a aVar) {
        dependencyNode.f8420l.add(dependencyNode2);
        dependencyNode.f8420l.add(this.f8434e);
        dependencyNode.f8416h = i10;
        dependencyNode.f8417i = aVar;
        dependencyNode2.f8419k.add(dependencyNode);
        aVar.f8419k.add(dependencyNode);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i10, int i11) {
        int max;
        if (i11 == 0) {
            ConstraintWidget constraintWidget = this.f8431b;
            int i12 = constraintWidget.f8384t;
            max = Math.max(constraintWidget.f8382s, i10);
            if (i12 > 0) {
                max = Math.min(i12, i10);
            }
            if (max == i10) {
                return i10;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f8431b;
            int i13 = constraintWidget2.f8390w;
            max = Math.max(constraintWidget2.f8388v, i10);
            if (i13 > 0) {
                max = Math.min(i13, i10);
            }
            if (max == i10) {
                return i10;
            }
        }
        return max;
    }

    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f8292f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f8290d;
        int i10 = a.f8445a[constraintAnchor2.f8291e.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            return null;
                        }
                        return constraintWidget.f8356f.f8438i;
                    }
                    return constraintWidget.f8356f.f8449k;
                }
                return constraintWidget.f8356f.f8437h;
            }
            return constraintWidget.f8354e.f8438i;
        }
        return constraintWidget.f8354e.f8437h;
    }

    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i10) {
        WidgetRun widgetRun;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f8292f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f8290d;
        if (i10 == 0) {
            widgetRun = constraintWidget.f8354e;
        } else {
            widgetRun = constraintWidget.f8356f;
        }
        int i11 = a.f8445a[constraintAnchor2.f8291e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f8438i;
        }
        return widgetRun.f8437h;
    }

    public long j() {
        if (this.f8434e.f8418j) {
            return r2.f8415g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f8436g;
    }

    public final void l(int i10, int i11) {
        WidgetRun widgetRun;
        float f10;
        int i12;
        int i13 = this.f8430a;
        if (i13 != 0) {
            if (i13 != 1) {
                if (i13 != 2) {
                    if (i13 == 3) {
                        ConstraintWidget constraintWidget = this.f8431b;
                        WidgetRun widgetRun2 = constraintWidget.f8354e;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun2.f8433d;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun2.f8430a == 3) {
                            d dVar = constraintWidget.f8356f;
                            if (dVar.f8433d == dimensionBehaviour2 && dVar.f8430a == 3) {
                                return;
                            }
                        }
                        if (i10 == 0) {
                            widgetRun2 = constraintWidget.f8356f;
                        }
                        if (widgetRun2.f8434e.f8418j) {
                            float w10 = constraintWidget.w();
                            if (i10 == 1) {
                                i12 = (int) ((widgetRun2.f8434e.f8415g / w10) + 0.5f);
                            } else {
                                i12 = (int) ((w10 * widgetRun2.f8434e.f8415g) + 0.5f);
                            }
                            this.f8434e.d(i12);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintWidget L10 = this.f8431b.L();
                if (L10 != null) {
                    if (i10 == 0) {
                        widgetRun = L10.f8354e;
                    } else {
                        widgetRun = L10.f8356f;
                    }
                    if (widgetRun.f8434e.f8418j) {
                        ConstraintWidget constraintWidget2 = this.f8431b;
                        if (i10 == 0) {
                            f10 = constraintWidget2.f8386u;
                        } else {
                            f10 = constraintWidget2.f8392x;
                        }
                        this.f8434e.d(g((int) ((r9.f8415g * f10) + 0.5f), i10));
                        return;
                    }
                    return;
                }
                return;
            }
            this.f8434e.d(Math.min(g(this.f8434e.f8446m, i10), i11));
            return;
        }
        this.f8434e.d(g(i11, i10));
    }

    public abstract boolean m();

    public void n(w.d dVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        float P10;
        DependencyNode h10 = h(constraintAnchor);
        DependencyNode h11 = h(constraintAnchor2);
        if (h10.f8418j && h11.f8418j) {
            int f10 = h10.f8415g + constraintAnchor.f();
            int f11 = h11.f8415g - constraintAnchor2.f();
            int i11 = f11 - f10;
            if (!this.f8434e.f8418j && this.f8433d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i10, i11);
            }
            androidx.constraintlayout.solver.widgets.analyzer.a aVar = this.f8434e;
            if (!aVar.f8418j) {
                return;
            }
            if (aVar.f8415g == i11) {
                this.f8437h.d(f10);
                this.f8438i.d(f11);
                return;
            }
            ConstraintWidget constraintWidget = this.f8431b;
            if (i10 == 0) {
                P10 = constraintWidget.z();
            } else {
                P10 = constraintWidget.P();
            }
            if (h10 == h11) {
                f10 = h10.f8415g;
                f11 = h11.f8415g;
                P10 = 0.5f;
            }
            this.f8437h.d((int) (f10 + 0.5f + (((f11 - f10) - this.f8434e.f8415g) * P10)));
            this.f8438i.d(this.f8437h.f8415g + this.f8434e.f8415g);
        }
    }

    @Override // w.d
    public void a(w.d dVar) {
    }

    public void o(w.d dVar) {
    }

    public void p(w.d dVar) {
    }
}
