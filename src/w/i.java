package w;

import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* compiled from: RunGroup.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: h, reason: collision with root package name */
    public static int f37536h;

    /* renamed from: c, reason: collision with root package name */
    public WidgetRun f37539c;

    /* renamed from: d, reason: collision with root package name */
    public WidgetRun f37540d;

    /* renamed from: f, reason: collision with root package name */
    public int f37542f;

    /* renamed from: g, reason: collision with root package name */
    public int f37543g;

    /* renamed from: a, reason: collision with root package name */
    public int f37537a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f37538b = false;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<WidgetRun> f37541e = new ArrayList<>();

    public i(WidgetRun widgetRun, int i10) {
        this.f37539c = null;
        this.f37540d = null;
        int i11 = f37536h;
        this.f37542f = i11;
        f37536h = i11 + 1;
        this.f37539c = widgetRun;
        this.f37540d = widgetRun;
        this.f37543g = i10;
    }

    public void a(WidgetRun widgetRun) {
        this.f37541e.add(widgetRun);
        this.f37540d = widgetRun;
    }

    public long b(androidx.constraintlayout.solver.widgets.d dVar, int i10) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        WidgetRun widgetRun3 = this.f37539c;
        long j10 = 0;
        if (widgetRun3 instanceof C1640c) {
            if (((C1640c) widgetRun3).f8435f != i10) {
                return 0L;
            }
        } else if (i10 == 0) {
            if (!(widgetRun3 instanceof androidx.constraintlayout.solver.widgets.analyzer.c)) {
                return 0L;
            }
        } else if (!(widgetRun3 instanceof androidx.constraintlayout.solver.widgets.analyzer.d)) {
            return 0L;
        }
        if (i10 == 0) {
            widgetRun = dVar.f8354e;
        } else {
            widgetRun = dVar.f8356f;
        }
        DependencyNode dependencyNode = widgetRun.f8437h;
        if (i10 == 0) {
            widgetRun2 = dVar.f8354e;
        } else {
            widgetRun2 = dVar.f8356f;
        }
        DependencyNode dependencyNode2 = widgetRun2.f8438i;
        boolean contains = widgetRun3.f8437h.f8420l.contains(dependencyNode);
        boolean contains2 = this.f37539c.f8438i.f8420l.contains(dependencyNode2);
        long j11 = this.f37539c.j();
        if (contains && contains2) {
            long d10 = d(this.f37539c.f8437h, 0L);
            long c10 = c(this.f37539c.f8438i, 0L);
            long j12 = d10 - j11;
            WidgetRun widgetRun4 = this.f37539c;
            int i11 = widgetRun4.f8438i.f8414f;
            if (j12 >= (-i11)) {
                j12 += i11;
            }
            int i12 = widgetRun4.f8437h.f8414f;
            long j13 = ((-c10) - j11) - i12;
            if (j13 >= i12) {
                j13 -= i12;
            }
            float r10 = widgetRun4.f8431b.r(i10);
            if (r10 > 0.0f) {
                j10 = (((float) j13) / r10) + (((float) j12) / (1.0f - r10));
            }
            float f10 = (float) j10;
            long j14 = (f10 * r10) + 0.5f + j11 + (f10 * (1.0f - r10)) + 0.5f;
            WidgetRun widgetRun5 = this.f37539c;
            return (widgetRun5.f8437h.f8414f + j14) - widgetRun5.f8438i.f8414f;
        }
        if (contains) {
            return Math.max(d(this.f37539c.f8437h, r12.f8414f), this.f37539c.f8437h.f8414f + j11);
        }
        if (contains2) {
            return Math.max(-c(this.f37539c.f8438i, r12.f8414f), (-this.f37539c.f8438i.f8414f) + j11);
        }
        return (r12.f8437h.f8414f + this.f37539c.j()) - this.f37539c.f8438i.f8414f;
    }

    public final long c(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f8412d;
        if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.b) {
            return j10;
        }
        int size = dependencyNode.f8419k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = dependencyNode.f8419k.get(i10);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f8412d != widgetRun) {
                    j11 = Math.min(j11, c(dependencyNode2, dependencyNode2.f8414f + j10));
                }
            }
        }
        if (dependencyNode == widgetRun.f8438i) {
            long j12 = j10 - widgetRun.j();
            return Math.min(Math.min(j11, c(widgetRun.f8437h, j12)), j12 - widgetRun.f8437h.f8414f);
        }
        return j11;
    }

    public final long d(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f8412d;
        if (widgetRun instanceof androidx.constraintlayout.solver.widgets.analyzer.b) {
            return j10;
        }
        int size = dependencyNode.f8419k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar = dependencyNode.f8419k.get(i10);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f8412d != widgetRun) {
                    j11 = Math.max(j11, d(dependencyNode2, dependencyNode2.f8414f + j10));
                }
            }
        }
        if (dependencyNode == widgetRun.f8437h) {
            long j12 = j10 + widgetRun.j();
            return Math.max(Math.max(j11, d(widgetRun.f8438i, j12)), j12 - widgetRun.f8438i.f8414f);
        }
        return j11;
    }
}
