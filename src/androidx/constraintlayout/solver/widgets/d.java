package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.opencv.imgcodecs.Imgcodecs;
import v.C1617c;
import w.C1639b;

/* compiled from: ConstraintWidgetContainer.java */
/* loaded from: classes.dex */
public class d extends C1617c {

    /* renamed from: T0, reason: collision with root package name */
    public int f8479T0;

    /* renamed from: U0, reason: collision with root package name */
    public int f8480U0;

    /* renamed from: V0, reason: collision with root package name */
    public int f8481V0;

    /* renamed from: W0, reason: collision with root package name */
    public int f8482W0;

    /* renamed from: O0, reason: collision with root package name */
    public C1639b f8474O0 = new C1639b(this);

    /* renamed from: P0, reason: collision with root package name */
    public w.e f8475P0 = new w.e(this);

    /* renamed from: Q0, reason: collision with root package name */
    public C1639b.InterfaceC0372b f8476Q0 = null;

    /* renamed from: R0, reason: collision with root package name */
    public boolean f8477R0 = false;

    /* renamed from: S0, reason: collision with root package name */
    public androidx.constraintlayout.solver.c f8478S0 = new androidx.constraintlayout.solver.c();

    /* renamed from: X0, reason: collision with root package name */
    public int f8483X0 = 0;

    /* renamed from: Y0, reason: collision with root package name */
    public int f8484Y0 = 0;

    /* renamed from: Z0, reason: collision with root package name */
    public c[] f8485Z0 = new c[4];

    /* renamed from: a1, reason: collision with root package name */
    public c[] f8486a1 = new c[4];

    /* renamed from: b1, reason: collision with root package name */
    public boolean f8487b1 = false;

    /* renamed from: c1, reason: collision with root package name */
    public boolean f8488c1 = false;

    /* renamed from: d1, reason: collision with root package name */
    public boolean f8489d1 = false;

    /* renamed from: e1, reason: collision with root package name */
    public int f8490e1 = 0;

    /* renamed from: f1, reason: collision with root package name */
    public int f8491f1 = 0;

    /* renamed from: g1, reason: collision with root package name */
    public int f8492g1 = Imgcodecs.IMWRITE_TIFF_XDPI;

    /* renamed from: h1, reason: collision with root package name */
    public boolean f8493h1 = false;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f8494i1 = false;

    /* renamed from: j1, reason: collision with root package name */
    public boolean f8495j1 = false;

    /* renamed from: k1, reason: collision with root package name */
    public int f8496k1 = 0;

    /* renamed from: l1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f8497l1 = null;

    /* renamed from: m1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f8498m1 = null;

    /* renamed from: n1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f8499n1 = null;

    /* renamed from: o1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f8500o1 = null;

    /* renamed from: p1, reason: collision with root package name */
    public C1639b.a f8501p1 = new C1639b.a();

    public static boolean G1(ConstraintWidget constraintWidget, C1639b.InterfaceC0372b interfaceC0372b, C1639b.a aVar, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i11;
        int i12;
        if (interfaceC0372b == null) {
            return false;
        }
        aVar.f37514a = constraintWidget.B();
        aVar.f37515b = constraintWidget.R();
        aVar.f37516c = constraintWidget.U();
        aVar.f37517d = constraintWidget.y();
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
        if (z10 && constraintWidget.Y(0) && constraintWidget.f8376p == 0 && !z12) {
            aVar.f37514a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.f8378q == 0) {
                aVar.f37514a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z10 = false;
        }
        if (z11 && constraintWidget.Y(1) && constraintWidget.f8378q == 0 && !z13) {
            aVar.f37515b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z10 && constraintWidget.f8376p == 0) {
                aVar.f37515b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (constraintWidget.h0()) {
            aVar.f37514a = ConstraintWidget.DimensionBehaviour.FIXED;
            z10 = false;
        }
        if (constraintWidget.i0()) {
            aVar.f37515b = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (z12) {
            if (constraintWidget.f8380r[0] == 4) {
                aVar.f37514a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = aVar.f37515b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i12 = aVar.f37517d;
                } else {
                    aVar.f37514a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0372b.b(constraintWidget, aVar);
                    i12 = aVar.f37519f;
                }
                aVar.f37514a = dimensionBehaviour4;
                int i13 = constraintWidget.f8345Z;
                if (i13 != 0 && i13 != -1) {
                    aVar.f37516c = (int) (constraintWidget.w() / i12);
                } else {
                    aVar.f37516c = (int) (constraintWidget.w() * i12);
                }
            }
        }
        if (z13) {
            if (constraintWidget.f8380r[1] == 4) {
                aVar.f37515b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z10) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = aVar.f37514a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i11 = aVar.f37516c;
                } else {
                    aVar.f37515b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0372b.b(constraintWidget, aVar);
                    i11 = aVar.f37518e;
                }
                aVar.f37515b = dimensionBehaviour6;
                int i14 = constraintWidget.f8345Z;
                if (i14 != 0 && i14 != -1) {
                    aVar.f37517d = (int) (i11 * constraintWidget.w());
                } else {
                    aVar.f37517d = (int) (i11 / constraintWidget.w());
                }
            }
        }
        interfaceC0372b.b(constraintWidget, aVar);
        constraintWidget.Y0(aVar.f37518e);
        constraintWidget.z0(aVar.f37519f);
        constraintWidget.y0(aVar.f37521h);
        constraintWidget.o0(aVar.f37520g);
        aVar.f37523j = C1639b.a.f37511k;
        return aVar.f37522i;
    }

    public void A1() {
        this.f8475P0.j();
    }

    public void B1() {
        this.f8475P0.k();
    }

    public boolean C1() {
        return this.f8495j1;
    }

    public boolean D1() {
        return this.f8477R0;
    }

    public boolean E1() {
        return this.f8494i1;
    }

    public long F1(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f8479T0 = i17;
        this.f8480U0 = i18;
        return this.f8474O0.d(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    public boolean H1(int i10) {
        if ((this.f8492g1 & i10) == i10) {
            return true;
        }
        return false;
    }

    public final void I1() {
        this.f8483X0 = 0;
        this.f8484Y0 = 0;
    }

    public void J1(C1639b.InterfaceC0372b interfaceC0372b) {
        this.f8476Q0 = interfaceC0372b;
        this.f8475P0.n(interfaceC0372b);
    }

    public void K1(int i10) {
        this.f8492g1 = i10;
        androidx.constraintlayout.solver.c.f8237r = H1(512);
    }

    public void L1(boolean z10) {
        this.f8477R0 = z10;
    }

    public void M1(androidx.constraintlayout.solver.c cVar, boolean[] zArr) {
        zArr[2] = false;
        boolean H12 = H1(64);
        d1(cVar, H12);
        int size = this.f37371N0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f37371N0.get(i10).d1(cVar, H12);
        }
    }

    public void N1() {
        this.f8474O0.e(this);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void c1(boolean z10, boolean z11) {
        super.c1(z10, z11);
        int size = this.f37371N0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f37371N0.get(i10).c1(z10, z11);
        }
    }

    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // v.C1617c
    public void f1() {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        ?? r62;
        boolean z14;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i12 = 0;
        this.f8347a0 = 0;
        this.f8349b0 = 0;
        this.f8494i1 = false;
        this.f8495j1 = false;
        int size = this.f37371N0.size();
        int max = Math.max(0, U());
        int max2 = Math.max(0, y());
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.f8340U;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
        if (g.b(this.f8492g1, 1)) {
            w.f.h(this, w1());
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget = this.f37371N0.get(i13);
                if (constraintWidget.g0() && !(constraintWidget instanceof f) && !(constraintWidget instanceof a) && !(constraintWidget instanceof h) && !constraintWidget.f0()) {
                    ConstraintWidget.DimensionBehaviour v10 = constraintWidget.v(0);
                    ConstraintWidget.DimensionBehaviour v11 = constraintWidget.v(1);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (v10 != dimensionBehaviour4 || constraintWidget.f8376p == 1 || v11 != dimensionBehaviour4 || constraintWidget.f8378q == 1) {
                        G1(constraintWidget, this.f8476Q0, new C1639b.a(), C1639b.a.f37511k);
                    }
                }
            }
        }
        if (size > 2 && ((dimensionBehaviour3 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == dimensionBehaviour) && g.b(this.f8492g1, 1024) && w.g.c(this, w1()))) {
            if (dimensionBehaviour3 == dimensionBehaviour) {
                if (max < U() && max > 0) {
                    Y0(max);
                    this.f8494i1 = true;
                } else {
                    max = U();
                }
            }
            if (dimensionBehaviour2 == dimensionBehaviour) {
                if (max2 < y() && max2 > 0) {
                    z0(max2);
                    this.f8495j1 = true;
                } else {
                    max2 = y();
                }
            }
            i10 = max2;
            i11 = max;
            z10 = true;
        } else {
            i10 = max2;
            i11 = max;
            z10 = false;
        }
        if (!H1(64) && !H1(128)) {
            z11 = false;
        } else {
            z11 = true;
        }
        androidx.constraintlayout.solver.c cVar = this.f8478S0;
        cVar.f8252h = false;
        cVar.f8253i = false;
        if (this.f8492g1 != 0 && z11) {
            cVar.f8253i = true;
        }
        ArrayList<ConstraintWidget> arrayList = this.f37371N0;
        ConstraintWidget.DimensionBehaviour B10 = B();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (B10 != dimensionBehaviour5 && R() != dimensionBehaviour5) {
            z12 = false;
        } else {
            z12 = true;
        }
        I1();
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget2 = this.f37371N0.get(i14);
            if (constraintWidget2 instanceof C1617c) {
                ((C1617c) constraintWidget2).f1();
            }
        }
        boolean H12 = H1(64);
        boolean z15 = z10;
        int i15 = 0;
        boolean z16 = true;
        while (z16) {
            int i16 = i15 + 1;
            try {
                this.f8478S0.E();
                I1();
                n(this.f8478S0);
                for (int i17 = i12; i17 < size; i17++) {
                    this.f37371N0.get(i17).n(this.f8478S0);
                }
                z16 = j1(this.f8478S0);
                WeakReference<ConstraintAnchor> weakReference = this.f8497l1;
                if (weakReference != null && weakReference.get() != null) {
                    o1(this.f8497l1.get(), this.f8478S0.q(this.f8328K));
                    this.f8497l1 = null;
                }
                WeakReference<ConstraintAnchor> weakReference2 = this.f8499n1;
                if (weakReference2 != null && weakReference2.get() != null) {
                    n1(this.f8499n1.get(), this.f8478S0.q(this.f8332M));
                    this.f8499n1 = null;
                }
                WeakReference<ConstraintAnchor> weakReference3 = this.f8498m1;
                if (weakReference3 != null && weakReference3.get() != null) {
                    o1(this.f8498m1.get(), this.f8478S0.q(this.f8326J));
                    this.f8498m1 = null;
                }
                WeakReference<ConstraintAnchor> weakReference4 = this.f8500o1;
                if (weakReference4 != null && weakReference4.get() != null) {
                    n1(this.f8500o1.get(), this.f8478S0.q(this.f8330L));
                    this.f8500o1 = null;
                }
                if (z16) {
                    this.f8478S0.A();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                System.out.println("EXCEPTION : " + e10);
            }
            if (z16) {
                M1(this.f8478S0, g.f8553a);
            } else {
                d1(this.f8478S0, H12);
                for (int i18 = 0; i18 < size; i18++) {
                    this.f37371N0.get(i18).d1(this.f8478S0, H12);
                }
            }
            if (z12 && i16 < 8 && g.f8553a[2]) {
                int i19 = 0;
                int i20 = 0;
                for (int i21 = 0; i21 < size; i21++) {
                    ConstraintWidget constraintWidget3 = this.f37371N0.get(i21);
                    i19 = Math.max(i19, constraintWidget3.f8347a0 + constraintWidget3.U());
                    i20 = Math.max(i20, constraintWidget3.f8349b0 + constraintWidget3.y());
                }
                int max3 = Math.max(this.f8361h0, i19);
                int max4 = Math.max(this.f8363i0, i20);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour3 == dimensionBehaviour6 && U() < max3) {
                    Y0(max3);
                    this.f8340U[0] = dimensionBehaviour6;
                    z13 = true;
                    z15 = true;
                } else {
                    z13 = false;
                }
                if (dimensionBehaviour2 == dimensionBehaviour6 && y() < max4) {
                    z0(max4);
                    this.f8340U[1] = dimensionBehaviour6;
                    z13 = true;
                    z15 = true;
                }
            } else {
                z13 = false;
            }
            int max5 = Math.max(this.f8361h0, U());
            if (max5 > U()) {
                Y0(max5);
                this.f8340U[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z13 = true;
                z15 = true;
            }
            int max6 = Math.max(this.f8363i0, y());
            if (max6 > y()) {
                z0(max6);
                r62 = 1;
                this.f8340U[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z13 = true;
                z14 = true;
            } else {
                r62 = 1;
                z14 = z15;
            }
            if (!z14) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = this.f8340U[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour7 == dimensionBehaviour8 && i11 > 0 && U() > i11) {
                    this.f8494i1 = r62;
                    this.f8340U[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    Y0(i11);
                    z13 = r62;
                    z14 = z13;
                }
                if (this.f8340U[r62] == dimensionBehaviour8 && i10 > 0 && y() > i10) {
                    this.f8495j1 = r62;
                    this.f8340U[r62] = ConstraintWidget.DimensionBehaviour.FIXED;
                    z0(i10);
                    z15 = true;
                    z16 = true;
                    i15 = i16;
                    i12 = 0;
                }
            }
            z16 = z13;
            z15 = z14;
            i15 = i16;
            i12 = 0;
        }
        this.f37371N0 = arrayList;
        if (z15) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.f8340U;
            dimensionBehaviourArr2[0] = dimensionBehaviour3;
            dimensionBehaviourArr2[1] = dimensionBehaviour2;
        }
        n0(this.f8478S0.w());
    }

    public void i1(ConstraintWidget constraintWidget, int i10) {
        if (i10 == 0) {
            k1(constraintWidget);
        } else if (i10 == 1) {
            p1(constraintWidget);
        }
    }

    public boolean j1(androidx.constraintlayout.solver.c cVar) {
        int i10;
        boolean H12 = H1(64);
        g(cVar, H12);
        int size = this.f37371N0.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.f37371N0.get(i11);
            constraintWidget.G0(0, false);
            constraintWidget.G0(1, false);
            if (constraintWidget instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = this.f37371N0.get(i12);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).l1();
                }
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            ConstraintWidget constraintWidget3 = this.f37371N0.get(i13);
            if (constraintWidget3.f()) {
                constraintWidget3.g(cVar, H12);
            }
        }
        if (androidx.constraintlayout.solver.c.f8237r) {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget4 = this.f37371N0.get(i14);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            if (B() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            e(this, cVar, hashSet, i10, false);
            Iterator<ConstraintWidget> it = hashSet.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                g.a(this, cVar, next);
                next.g(cVar, H12);
            }
        } else {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget5 = this.f37371N0.get(i15);
                if (constraintWidget5 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.f8340U;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.D0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.U0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget5.g(cVar, H12);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.D0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.U0(dimensionBehaviour2);
                    }
                } else {
                    g.a(this, cVar, constraintWidget5);
                    if (!constraintWidget5.f()) {
                        constraintWidget5.g(cVar, H12);
                    }
                }
            }
        }
        if (this.f8483X0 > 0) {
            b.b(this, cVar, null, 0);
        }
        if (this.f8484Y0 > 0) {
            b.b(this, cVar, null, 1);
        }
        return true;
    }

    @Override // v.C1617c, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void k0() {
        this.f8478S0.E();
        this.f8479T0 = 0;
        this.f8481V0 = 0;
        this.f8480U0 = 0;
        this.f8482W0 = 0;
        this.f8493h1 = false;
        super.k0();
    }

    public final void k1(ConstraintWidget constraintWidget) {
        int i10 = this.f8483X0 + 1;
        c[] cVarArr = this.f8486a1;
        if (i10 >= cVarArr.length) {
            this.f8486a1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f8486a1[this.f8483X0] = new c(constraintWidget, 0, D1());
        this.f8483X0++;
    }

    public void l1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f8500o1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f8500o1.get().e()) {
            this.f8500o1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void m1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f8498m1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f8498m1.get().e()) {
            this.f8498m1 = new WeakReference<>(constraintAnchor);
        }
    }

    public final void n1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f8478S0.h(solverVariable, this.f8478S0.q(constraintAnchor), 0, 5);
    }

    public final void o1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f8478S0.h(this.f8478S0.q(constraintAnchor), solverVariable, 0, 5);
    }

    public final void p1(ConstraintWidget constraintWidget) {
        int i10 = this.f8484Y0 + 1;
        c[] cVarArr = this.f8485Z0;
        if (i10 >= cVarArr.length) {
            this.f8485Z0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f8485Z0[this.f8484Y0] = new c(constraintWidget, 1, D1());
        this.f8484Y0++;
    }

    public void q1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f8499n1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f8499n1.get().e()) {
            this.f8499n1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void r1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f8497l1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f8497l1.get().e()) {
            this.f8497l1 = new WeakReference<>(constraintAnchor);
        }
    }

    public boolean s1(boolean z10) {
        return this.f8475P0.f(z10);
    }

    public boolean t1(boolean z10) {
        return this.f8475P0.g(z10);
    }

    public boolean u1(boolean z10, int i10) {
        return this.f8475P0.h(z10, i10);
    }

    public void v1(u.b bVar) {
        this.f8478S0.v(bVar);
    }

    public C1639b.InterfaceC0372b w1() {
        return this.f8476Q0;
    }

    public int x1() {
        return this.f8492g1;
    }

    public androidx.constraintlayout.solver.c y1() {
        return this.f8478S0;
    }

    public boolean z1() {
        return false;
    }
}
