package w;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: WidgetGroup.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: g, reason: collision with root package name */
    public static int f37544g;

    /* renamed from: b, reason: collision with root package name */
    public int f37546b;

    /* renamed from: d, reason: collision with root package name */
    public int f37548d;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<ConstraintWidget> f37545a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public boolean f37547c = false;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<a> f37549e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f37550f = -1;

    /* compiled from: WidgetGroup.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ConstraintWidget> f37551a;

        /* renamed from: b, reason: collision with root package name */
        public int f37552b;

        /* renamed from: c, reason: collision with root package name */
        public int f37553c;

        /* renamed from: d, reason: collision with root package name */
        public int f37554d;

        /* renamed from: e, reason: collision with root package name */
        public int f37555e;

        /* renamed from: f, reason: collision with root package name */
        public int f37556f;

        /* renamed from: g, reason: collision with root package name */
        public int f37557g;

        public a(ConstraintWidget constraintWidget, androidx.constraintlayout.solver.c cVar, int i10) {
            this.f37551a = new WeakReference<>(constraintWidget);
            this.f37552b = cVar.y(constraintWidget.f8326J);
            this.f37553c = cVar.y(constraintWidget.f8328K);
            this.f37554d = cVar.y(constraintWidget.f8330L);
            this.f37555e = cVar.y(constraintWidget.f8332M);
            this.f37556f = cVar.y(constraintWidget.f8333N);
            this.f37557g = i10;
        }
    }

    public j(int i10) {
        int i11 = f37544g;
        f37544g = i11 + 1;
        this.f37546b = i11;
        this.f37548d = i10;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.f37545a.contains(constraintWidget)) {
            return false;
        }
        this.f37545a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList<j> arrayList) {
        int size = this.f37545a.size();
        if (this.f37550f != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                j jVar = arrayList.get(i10);
                if (this.f37550f == jVar.f37546b) {
                    g(this.f37548d, jVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f37546b;
    }

    public int d() {
        return this.f37548d;
    }

    public final String e() {
        int i10 = this.f37548d;
        if (i10 == 0) {
            return "Horizontal";
        }
        if (i10 == 1) {
            return "Vertical";
        }
        if (i10 == 2) {
            return "Both";
        }
        return "Unknown";
    }

    public int f(androidx.constraintlayout.solver.c cVar, int i10) {
        if (this.f37545a.size() == 0) {
            return 0;
        }
        return j(cVar, this.f37545a, i10);
    }

    public void g(int i10, j jVar) {
        Iterator<ConstraintWidget> it = this.f37545a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            jVar.a(next);
            if (i10 == 0) {
                next.f8329K0 = jVar.c();
            } else {
                next.f8331L0 = jVar.c();
            }
        }
        this.f37550f = jVar.f37546b;
    }

    public void h(boolean z10) {
        this.f37547c = z10;
    }

    public void i(int i10) {
        this.f37548d = i10;
    }

    public final int j(androidx.constraintlayout.solver.c cVar, ArrayList<ConstraintWidget> arrayList, int i10) {
        int y10;
        int y11;
        androidx.constraintlayout.solver.widgets.d dVar = (androidx.constraintlayout.solver.widgets.d) arrayList.get(0).L();
        cVar.E();
        dVar.g(cVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).g(cVar, false);
        }
        if (i10 == 0 && dVar.f8483X0 > 0) {
            androidx.constraintlayout.solver.widgets.b.b(dVar, cVar, arrayList, 0);
        }
        if (i10 == 1 && dVar.f8484Y0 > 0) {
            androidx.constraintlayout.solver.widgets.b.b(dVar, cVar, arrayList, 1);
        }
        try {
            cVar.A();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f37549e = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f37549e.add(new a(arrayList.get(i12), cVar, i10));
        }
        if (i10 == 0) {
            y10 = cVar.y(dVar.f8326J);
            y11 = cVar.y(dVar.f8330L);
            cVar.E();
        } else {
            y10 = cVar.y(dVar.f8328K);
            y11 = cVar.y(dVar.f8332M);
            cVar.E();
        }
        return y11 - y10;
    }

    public String toString() {
        String str = e() + " [" + this.f37546b + "] <";
        Iterator<ConstraintWidget> it = this.f37545a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().u();
        }
        return str + " >";
    }
}
