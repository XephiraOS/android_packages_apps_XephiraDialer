package w;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChainRun.java */
/* renamed from: w.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1640c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<WidgetRun> f37524k;

    /* renamed from: l, reason: collision with root package name */
    public int f37525l;

    public C1640c(ConstraintWidget constraintWidget, int i10) {
        super(constraintWidget);
        this.f37524k = new ArrayList<>();
        this.f8435f = i10;
        q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x01ad, code lost:
    
        if (r1 != r7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01d8, code lost:
    
        r9.f8434e.d(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01d5, code lost:
    
        r13 = r13 + 1;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01d3, code lost:
    
        if (r1 != r7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0416, code lost:
    
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, w.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(w.d r26) {
        /*
            Method dump skipped, instructions count: 1086
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.C1640c.a(w.d):void");
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void d() {
        Iterator<WidgetRun> it = this.f37524k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f37524k.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.f37524k.get(0).f8431b;
        ConstraintWidget constraintWidget2 = this.f37524k.get(size - 1).f8431b;
        if (this.f8435f == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.f8326J;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.f8330L;
            DependencyNode i10 = i(constraintAnchor, 0);
            int f10 = constraintAnchor.f();
            ConstraintWidget r10 = r();
            if (r10 != null) {
                f10 = r10.f8326J.f();
            }
            if (i10 != null) {
                b(this.f8437h, i10, f10);
            }
            DependencyNode i11 = i(constraintAnchor2, 0);
            int f11 = constraintAnchor2.f();
            ConstraintWidget s10 = s();
            if (s10 != null) {
                f11 = s10.f8330L.f();
            }
            if (i11 != null) {
                b(this.f8438i, i11, -f11);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.f8328K;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.f8332M;
            DependencyNode i12 = i(constraintAnchor3, 1);
            int f12 = constraintAnchor3.f();
            ConstraintWidget r11 = r();
            if (r11 != null) {
                f12 = r11.f8328K.f();
            }
            if (i12 != null) {
                b(this.f8437h, i12, f12);
            }
            DependencyNode i13 = i(constraintAnchor4, 1);
            int f13 = constraintAnchor4.f();
            ConstraintWidget s11 = s();
            if (s11 != null) {
                f13 = s11.f8332M.f();
            }
            if (i13 != null) {
                b(this.f8438i, i13, -f13);
            }
        }
        this.f8437h.f8409a = this;
        this.f8438i.f8409a = this;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void e() {
        for (int i10 = 0; i10 < this.f37524k.size(); i10++) {
            this.f37524k.get(i10).e();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void f() {
        this.f8432c = null;
        Iterator<WidgetRun> it = this.f37524k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long j() {
        int size = this.f37524k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 = j10 + r4.f8437h.f8414f + this.f37524k.get(i10).j() + r4.f8438i.f8414f;
        }
        return j10;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public boolean m() {
        int size = this.f37524k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f37524k.get(i10).m()) {
                return false;
            }
        }
        return true;
    }

    public final void q() {
        ConstraintWidget constraintWidget;
        int Q10;
        ConstraintWidget constraintWidget2 = this.f8431b;
        ConstraintWidget M10 = constraintWidget2.M(this.f8435f);
        while (true) {
            ConstraintWidget constraintWidget3 = M10;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                M10 = constraintWidget2.M(this.f8435f);
            }
        }
        this.f8431b = constraintWidget;
        this.f37524k.add(constraintWidget.O(this.f8435f));
        ConstraintWidget K10 = constraintWidget.K(this.f8435f);
        while (K10 != null) {
            this.f37524k.add(K10.O(this.f8435f));
            K10 = K10.K(this.f8435f);
        }
        Iterator<WidgetRun> it = this.f37524k.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i10 = this.f8435f;
            if (i10 == 0) {
                next.f8431b.f8350c = this;
            } else if (i10 == 1) {
                next.f8431b.f8352d = this;
            }
        }
        if (this.f8435f == 0 && ((androidx.constraintlayout.solver.widgets.d) this.f8431b.L()).D1() && this.f37524k.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f37524k;
            this.f8431b = arrayList.get(arrayList.size() - 1).f8431b;
        }
        if (this.f8435f == 0) {
            Q10 = this.f8431b.A();
        } else {
            Q10 = this.f8431b.Q();
        }
        this.f37525l = Q10;
    }

    public final ConstraintWidget r() {
        for (int i10 = 0; i10 < this.f37524k.size(); i10++) {
            WidgetRun widgetRun = this.f37524k.get(i10);
            if (widgetRun.f8431b.T() != 8) {
                return widgetRun.f8431b;
            }
        }
        return null;
    }

    public final ConstraintWidget s() {
        for (int size = this.f37524k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f37524k.get(size);
            if (widgetRun.f8431b.T() != 8) {
                return widgetRun.f8431b;
            }
        }
        return null;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        if (this.f8435f == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb.append(str);
        String sb2 = sb.toString();
        Iterator<WidgetRun> it = this.f37524k.iterator();
        while (it.hasNext()) {
            String str2 = sb2 + "<";
            sb2 = (str2 + it.next()) + "> ";
        }
        return sb2;
    }
}
