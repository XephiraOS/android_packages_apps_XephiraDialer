package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;

/* compiled from: DimensionDependency.java */
/* loaded from: classes.dex */
public class a extends DependencyNode {

    /* renamed from: m, reason: collision with root package name */
    public int f8446m;

    public a(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof c) {
            this.f8413e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f8413e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
    public void d(int i10) {
        if (this.f8418j) {
            return;
        }
        this.f8418j = true;
        this.f8415g = i10;
        for (w.d dVar : this.f8419k) {
            dVar.a(dVar);
        }
    }
}
