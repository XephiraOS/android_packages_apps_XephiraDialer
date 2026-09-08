package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DependencyNode implements w.d {

    /* renamed from: d, reason: collision with root package name */
    public WidgetRun f8412d;

    /* renamed from: f, reason: collision with root package name */
    public int f8414f;

    /* renamed from: g, reason: collision with root package name */
    public int f8415g;

    /* renamed from: a, reason: collision with root package name */
    public w.d f8409a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8410b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8411c = false;

    /* renamed from: e, reason: collision with root package name */
    public Type f8413e = Type.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    public int f8416h = 1;

    /* renamed from: i, reason: collision with root package name */
    public a f8417i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8418j = false;

    /* renamed from: k, reason: collision with root package name */
    public List<w.d> f8419k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public List<DependencyNode> f8420l = new ArrayList();

    /* loaded from: classes.dex */
    public enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f8412d = widgetRun;
    }

    @Override // w.d
    public void a(w.d dVar) {
        Iterator<DependencyNode> it = this.f8420l.iterator();
        while (it.hasNext()) {
            if (!it.next().f8418j) {
                return;
            }
        }
        this.f8411c = true;
        w.d dVar2 = this.f8409a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f8410b) {
            this.f8412d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i10 = 0;
        for (DependencyNode dependencyNode2 : this.f8420l) {
            if (!(dependencyNode2 instanceof a)) {
                i10++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i10 == 1 && dependencyNode.f8418j) {
            a aVar = this.f8417i;
            if (aVar != null) {
                if (aVar.f8418j) {
                    this.f8414f = this.f8416h * aVar.f8415g;
                } else {
                    return;
                }
            }
            d(dependencyNode.f8415g + this.f8414f);
        }
        w.d dVar3 = this.f8409a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(w.d dVar) {
        this.f8419k.add(dVar);
        if (this.f8418j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f8420l.clear();
        this.f8419k.clear();
        this.f8418j = false;
        this.f8415g = 0;
        this.f8411c = false;
        this.f8410b = false;
    }

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

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8412d.f8431b.u());
        sb.append(":");
        sb.append(this.f8413e);
        sb.append("(");
        if (this.f8418j) {
            obj = Integer.valueOf(this.f8415g);
        } else {
            obj = "unresolved";
        }
        sb.append(obj);
        sb.append(") <t=");
        sb.append(this.f8420l.size());
        sb.append(":d=");
        sb.append(this.f8419k.size());
        sb.append(">");
        return sb.toString();
    }
}
