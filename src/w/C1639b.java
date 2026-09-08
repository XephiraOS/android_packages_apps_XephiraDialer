package w;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: BasicMeasure.java */
/* renamed from: w.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1639b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f37508a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public a f37509b = new a();

    /* renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.d f37510c;

    /* compiled from: BasicMeasure.java */
    /* renamed from: w.b$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: k, reason: collision with root package name */
        public static int f37511k = 0;

        /* renamed from: l, reason: collision with root package name */
        public static int f37512l = 1;

        /* renamed from: m, reason: collision with root package name */
        public static int f37513m = 2;

        /* renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f37514a;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f37515b;

        /* renamed from: c, reason: collision with root package name */
        public int f37516c;

        /* renamed from: d, reason: collision with root package name */
        public int f37517d;

        /* renamed from: e, reason: collision with root package name */
        public int f37518e;

        /* renamed from: f, reason: collision with root package name */
        public int f37519f;

        /* renamed from: g, reason: collision with root package name */
        public int f37520g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f37521h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f37522i;

        /* renamed from: j, reason: collision with root package name */
        public int f37523j;
    }

    /* compiled from: BasicMeasure.java */
    /* renamed from: w.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0372b {
        void a();

        void b(ConstraintWidget constraintWidget, a aVar);
    }

    public C1639b(androidx.constraintlayout.solver.widgets.d dVar) {
        this.f37510c = dVar;
    }

    public final boolean a(InterfaceC0372b interfaceC0372b, ConstraintWidget constraintWidget, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        this.f37509b.f37514a = constraintWidget.B();
        this.f37509b.f37515b = constraintWidget.R();
        this.f37509b.f37516c = constraintWidget.U();
        this.f37509b.f37517d = constraintWidget.y();
        a aVar = this.f37509b;
        aVar.f37522i = false;
        aVar.f37523j = i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f37514a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (aVar.f37515b == dimensionBehaviour2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && constraintWidget.f8344Y > 0.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 && constraintWidget.f8344Y > 0.0f) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 && constraintWidget.f8380r[0] == 4) {
            aVar.f37514a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z13 && constraintWidget.f8380r[1] == 4) {
            aVar.f37515b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        interfaceC0372b.b(constraintWidget, aVar);
        constraintWidget.Y0(this.f37509b.f37518e);
        constraintWidget.z0(this.f37509b.f37519f);
        constraintWidget.y0(this.f37509b.f37521h);
        constraintWidget.o0(this.f37509b.f37520g);
        a aVar2 = this.f37509b;
        aVar2.f37523j = a.f37511k;
        return aVar2.f37522i;
    }

    public final void b(androidx.constraintlayout.solver.widgets.d dVar) {
        boolean z10;
        androidx.constraintlayout.solver.widgets.analyzer.c cVar;
        androidx.constraintlayout.solver.widgets.analyzer.d dVar2;
        int size = dVar.f37371N0.size();
        boolean H12 = dVar.H1(64);
        InterfaceC0372b w12 = dVar.w1();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.f37371N0.get(i10);
            if (!(constraintWidget instanceof androidx.constraintlayout.solver.widgets.f) && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.a) && !constraintWidget.f0() && (!H12 || (cVar = constraintWidget.f8354e) == null || (dVar2 = constraintWidget.f8356f) == null || !cVar.f8434e.f8418j || !dVar2.f8434e.f8418j)) {
                ConstraintWidget.DimensionBehaviour v10 = constraintWidget.v(0);
                boolean z11 = true;
                ConstraintWidget.DimensionBehaviour v11 = constraintWidget.v(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (v10 == dimensionBehaviour && constraintWidget.f8376p != 1 && v11 == dimensionBehaviour && constraintWidget.f8378q != 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && dVar.H1(1) && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.h)) {
                    if (v10 == dimensionBehaviour && constraintWidget.f8376p == 0 && v11 != dimensionBehaviour && !constraintWidget.c0()) {
                        z10 = true;
                    }
                    if (v11 != dimensionBehaviour || constraintWidget.f8378q != 0 || v10 == dimensionBehaviour || constraintWidget.c0()) {
                        z11 = z10;
                    }
                    if ((v10 != dimensionBehaviour && v11 != dimensionBehaviour) || constraintWidget.f8344Y <= 0.0f) {
                        z10 = z11;
                    }
                }
                if (!z10) {
                    a(w12, constraintWidget, a.f37511k);
                }
            }
        }
        w12.a();
    }

    public final void c(androidx.constraintlayout.solver.widgets.d dVar, String str, int i10, int i11) {
        int J10 = dVar.J();
        int I10 = dVar.I();
        dVar.O0(0);
        dVar.N0(0);
        dVar.Y0(i10);
        dVar.z0(i11);
        dVar.O0(J10);
        dVar.N0(I10);
        this.f37510c.f1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x02e5, code lost:
    
        if (r10 != false) goto L185;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v5, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long d(androidx.constraintlayout.solver.widgets.d r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 759
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.C1639b.d(androidx.constraintlayout.solver.widgets.d, int, int, int, int, int, int, int, int, int):long");
    }

    public void e(androidx.constraintlayout.solver.widgets.d dVar) {
        this.f37508a.clear();
        int size = dVar.f37371N0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.f37371N0.get(i10);
            ConstraintWidget.DimensionBehaviour B10 = constraintWidget.B();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (B10 == dimensionBehaviour || constraintWidget.R() == dimensionBehaviour) {
                this.f37508a.add(constraintWidget);
            }
        }
        dVar.A1();
    }
}
