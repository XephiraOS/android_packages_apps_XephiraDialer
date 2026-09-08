package w;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import w.C1639b;

/* compiled from: Direct.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static C1639b.a f37535a = new C1639b.a();

    public static boolean a(ConstraintWidget constraintWidget) {
        androidx.constraintlayout.solver.widgets.d dVar;
        boolean z10;
        boolean z11;
        ConstraintWidget.DimensionBehaviour B10 = constraintWidget.B();
        ConstraintWidget.DimensionBehaviour R10 = constraintWidget.R();
        if (constraintWidget.L() != null) {
            dVar = (androidx.constraintlayout.solver.widgets.d) constraintWidget.L();
        } else {
            dVar = null;
        }
        if (dVar != null) {
            dVar.B();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (dVar != null) {
            dVar.R();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (B10 != dimensionBehaviour3 && B10 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((B10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.f8376p != 0 || constraintWidget.f8344Y != 0.0f || !constraintWidget.Y(0)) && !constraintWidget.h0())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (R10 != dimensionBehaviour3 && R10 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((R10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.f8378q != 0 || constraintWidget.f8344Y != 0.0f || !constraintWidget.Y(1)) && !constraintWidget.i0())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (constraintWidget.f8344Y > 0.0f && (z10 || z11)) {
            return true;
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }

    public static void b(ConstraintWidget constraintWidget, C1639b.InterfaceC0372b interfaceC0372b, boolean z10) {
        boolean z11;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        if (!(constraintWidget instanceof androidx.constraintlayout.solver.widgets.d) && constraintWidget.g0() && a(constraintWidget)) {
            androidx.constraintlayout.solver.widgets.d.G1(constraintWidget, interfaceC0372b, new C1639b.a(), C1639b.a.f37511k);
        }
        ConstraintAnchor p10 = constraintWidget.p(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor p11 = constraintWidget.p(ConstraintAnchor.Type.RIGHT);
        int e10 = p10.e();
        int e11 = p11.e();
        if (p10.d() != null && p10.n()) {
            Iterator<ConstraintAnchor> it = p10.d().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f8290d;
                boolean a10 = a(constraintWidget2);
                if (constraintWidget2.g0() && a10) {
                    androidx.constraintlayout.solver.widgets.d.G1(constraintWidget2, interfaceC0372b, new C1639b.a(), C1639b.a.f37511k);
                }
                ConstraintWidget.DimensionBehaviour B10 = constraintWidget2.B();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (B10 == dimensionBehaviour && !a10) {
                    if (constraintWidget2.B() == dimensionBehaviour && constraintWidget2.f8384t >= 0 && constraintWidget2.f8382s >= 0 && (constraintWidget2.T() == 8 || (constraintWidget2.f8376p == 0 && constraintWidget2.w() == 0.0f))) {
                        if (!constraintWidget2.c0() && !constraintWidget2.f0() && ((next == constraintWidget2.f8326J && (constraintAnchor5 = constraintWidget2.f8330L.f8292f) != null && constraintAnchor5.n()) || (next == constraintWidget2.f8330L && (constraintAnchor4 = constraintWidget2.f8326J.f8292f) != null && constraintAnchor4.n()))) {
                            if (!constraintWidget2.c0()) {
                                e(constraintWidget, interfaceC0372b, constraintWidget2, z10);
                            }
                        }
                    }
                } else if (!constraintWidget2.g0()) {
                    ConstraintAnchor constraintAnchor6 = constraintWidget2.f8326J;
                    if (next == constraintAnchor6 && constraintWidget2.f8330L.f8292f == null) {
                        int f10 = constraintAnchor6.f() + e10;
                        constraintWidget2.t0(f10, constraintWidget2.U() + f10);
                        b(constraintWidget2, interfaceC0372b, z10);
                    } else {
                        ConstraintAnchor constraintAnchor7 = constraintWidget2.f8330L;
                        if (next == constraintAnchor7 && constraintAnchor6.f8292f == null) {
                            int f11 = e10 - constraintAnchor7.f();
                            constraintWidget2.t0(f11 - constraintWidget2.U(), f11);
                            b(constraintWidget2, interfaceC0372b, z10);
                        } else if (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor7.f8292f) != null && constraintAnchor3.n() && !constraintWidget2.c0()) {
                            d(interfaceC0372b, constraintWidget2, z10);
                        }
                    }
                }
            }
        }
        if (!(constraintWidget instanceof androidx.constraintlayout.solver.widgets.f) && p11.d() != null && p11.n()) {
            Iterator<ConstraintAnchor> it2 = p11.d().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f8290d;
                boolean a11 = a(constraintWidget3);
                if (constraintWidget3.g0() && a11) {
                    androidx.constraintlayout.solver.widgets.d.G1(constraintWidget3, interfaceC0372b, new C1639b.a(), C1639b.a.f37511k);
                }
                if ((next2 == constraintWidget3.f8326J && (constraintAnchor2 = constraintWidget3.f8330L.f8292f) != null && constraintAnchor2.n()) || (next2 == constraintWidget3.f8330L && (constraintAnchor = constraintWidget3.f8326J.f8292f) != null && constraintAnchor.n())) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                ConstraintWidget.DimensionBehaviour B11 = constraintWidget3.B();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (B11 == dimensionBehaviour2 && !a11) {
                    if (constraintWidget3.B() == dimensionBehaviour2 && constraintWidget3.f8384t >= 0 && constraintWidget3.f8382s >= 0 && (constraintWidget3.T() == 8 || (constraintWidget3.f8376p == 0 && constraintWidget3.w() == 0.0f))) {
                        if (!constraintWidget3.c0() && !constraintWidget3.f0() && z11 && !constraintWidget3.c0()) {
                            e(constraintWidget, interfaceC0372b, constraintWidget3, z10);
                        }
                    }
                } else if (!constraintWidget3.g0()) {
                    ConstraintAnchor constraintAnchor8 = constraintWidget3.f8326J;
                    if (next2 == constraintAnchor8 && constraintWidget3.f8330L.f8292f == null) {
                        int f12 = constraintAnchor8.f() + e11;
                        constraintWidget3.t0(f12, constraintWidget3.U() + f12);
                        b(constraintWidget3, interfaceC0372b, z10);
                    } else {
                        ConstraintAnchor constraintAnchor9 = constraintWidget3.f8330L;
                        if (next2 == constraintAnchor9 && constraintAnchor8.f8292f == null) {
                            int f13 = e11 - constraintAnchor9.f();
                            constraintWidget3.t0(f13 - constraintWidget3.U(), f13);
                            b(constraintWidget3, interfaceC0372b, z10);
                        } else if (z11 && !constraintWidget3.c0()) {
                            d(interfaceC0372b, constraintWidget3, z10);
                        }
                    }
                }
            }
        }
    }

    public static void c(androidx.constraintlayout.solver.widgets.a aVar, C1639b.InterfaceC0372b interfaceC0372b, int i10, boolean z10) {
        if (aVar.g1()) {
            if (i10 == 0) {
                b(aVar, interfaceC0372b, z10);
            } else {
                i(aVar, interfaceC0372b);
            }
        }
    }

    public static void d(C1639b.InterfaceC0372b interfaceC0372b, ConstraintWidget constraintWidget, boolean z10) {
        float z11 = constraintWidget.z();
        int e10 = constraintWidget.f8326J.f8292f.e();
        int e11 = constraintWidget.f8330L.f8292f.e();
        int f10 = constraintWidget.f8326J.f() + e10;
        int f11 = e11 - constraintWidget.f8330L.f();
        if (e10 == e11) {
            z11 = 0.5f;
        } else {
            e10 = f10;
            e11 = f11;
        }
        int U10 = constraintWidget.U();
        int i10 = (e11 - e10) - U10;
        if (e10 > e11) {
            i10 = (e10 - e11) - U10;
        }
        int i11 = ((int) ((z11 * i10) + 0.5f)) + e10;
        int i12 = i11 + U10;
        if (e10 > e11) {
            i12 = i11 - U10;
        }
        constraintWidget.t0(i11, i12);
        b(constraintWidget, interfaceC0372b, z10);
    }

    public static void e(ConstraintWidget constraintWidget, C1639b.InterfaceC0372b interfaceC0372b, ConstraintWidget constraintWidget2, boolean z10) {
        int U10;
        float z11 = constraintWidget2.z();
        int e10 = constraintWidget2.f8326J.f8292f.e() + constraintWidget2.f8326J.f();
        int e11 = constraintWidget2.f8330L.f8292f.e() - constraintWidget2.f8330L.f();
        if (e11 >= e10) {
            int U11 = constraintWidget2.U();
            if (constraintWidget2.T() != 8) {
                int i10 = constraintWidget2.f8376p;
                if (i10 == 2) {
                    if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.d) {
                        U10 = constraintWidget.U();
                    } else {
                        U10 = constraintWidget.L().U();
                    }
                    U11 = (int) (constraintWidget2.z() * 0.5f * U10);
                } else if (i10 == 0) {
                    U11 = e11 - e10;
                }
                U11 = Math.max(constraintWidget2.f8382s, U11);
                int i11 = constraintWidget2.f8384t;
                if (i11 > 0) {
                    U11 = Math.min(i11, U11);
                }
            }
            int i12 = e10 + ((int) ((z11 * ((e11 - e10) - U11)) + 0.5f));
            constraintWidget2.t0(i12, U11 + i12);
            b(constraintWidget2, interfaceC0372b, z10);
        }
    }

    public static void f(C1639b.InterfaceC0372b interfaceC0372b, ConstraintWidget constraintWidget) {
        float P10 = constraintWidget.P();
        int e10 = constraintWidget.f8328K.f8292f.e();
        int e11 = constraintWidget.f8332M.f8292f.e();
        int f10 = constraintWidget.f8328K.f() + e10;
        int f11 = e11 - constraintWidget.f8332M.f();
        if (e10 == e11) {
            P10 = 0.5f;
        } else {
            e10 = f10;
            e11 = f11;
        }
        int y10 = constraintWidget.y();
        int i10 = (e11 - e10) - y10;
        if (e10 > e11) {
            i10 = (e10 - e11) - y10;
        }
        int i11 = (int) ((P10 * i10) + 0.5f);
        int i12 = e10 + i11;
        int i13 = i12 + y10;
        if (e10 > e11) {
            i12 = e10 - i11;
            i13 = i12 - y10;
        }
        constraintWidget.w0(i12, i13);
        i(constraintWidget, interfaceC0372b);
    }

    public static void g(ConstraintWidget constraintWidget, C1639b.InterfaceC0372b interfaceC0372b, ConstraintWidget constraintWidget2) {
        int y10;
        float P10 = constraintWidget2.P();
        int e10 = constraintWidget2.f8328K.f8292f.e() + constraintWidget2.f8328K.f();
        int e11 = constraintWidget2.f8332M.f8292f.e() - constraintWidget2.f8332M.f();
        if (e11 >= e10) {
            int y11 = constraintWidget2.y();
            if (constraintWidget2.T() != 8) {
                int i10 = constraintWidget2.f8378q;
                if (i10 == 2) {
                    if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.d) {
                        y10 = constraintWidget.y();
                    } else {
                        y10 = constraintWidget.L().y();
                    }
                    y11 = (int) (P10 * 0.5f * y10);
                } else if (i10 == 0) {
                    y11 = e11 - e10;
                }
                y11 = Math.max(constraintWidget2.f8388v, y11);
                int i11 = constraintWidget2.f8390w;
                if (i11 > 0) {
                    y11 = Math.min(i11, y11);
                }
            }
            int i12 = e10 + ((int) ((P10 * ((e11 - e10) - y11)) + 0.5f));
            constraintWidget2.w0(i12, y11 + i12);
            i(constraintWidget2, interfaceC0372b);
        }
    }

    public static void h(androidx.constraintlayout.solver.widgets.d dVar, C1639b.InterfaceC0372b interfaceC0372b) {
        ConstraintWidget.DimensionBehaviour B10 = dVar.B();
        ConstraintWidget.DimensionBehaviour R10 = dVar.R();
        dVar.m0();
        ArrayList<ConstraintWidget> e12 = dVar.e1();
        int size = e12.size();
        for (int i10 = 0; i10 < size; i10++) {
            e12.get(i10).m0();
        }
        boolean D12 = dVar.D1();
        if (B10 == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.t0(0, dVar.U());
        } else {
            dVar.u0(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = e12.get(i11);
            if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.f) {
                androidx.constraintlayout.solver.widgets.f fVar = (androidx.constraintlayout.solver.widgets.f) constraintWidget;
                if (fVar.f1() == 1) {
                    if (fVar.g1() != -1) {
                        fVar.j1(fVar.g1());
                    } else if (fVar.h1() != -1 && dVar.h0()) {
                        fVar.j1(dVar.U() - fVar.h1());
                    } else if (dVar.h0()) {
                        fVar.j1((int) ((fVar.i1() * dVar.U()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((constraintWidget instanceof androidx.constraintlayout.solver.widgets.a) && ((androidx.constraintlayout.solver.widgets.a) constraintWidget).k1() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = e12.get(i12);
                if (constraintWidget2 instanceof androidx.constraintlayout.solver.widgets.f) {
                    androidx.constraintlayout.solver.widgets.f fVar2 = (androidx.constraintlayout.solver.widgets.f) constraintWidget2;
                    if (fVar2.f1() == 1) {
                        b(fVar2, interfaceC0372b, D12);
                    }
                }
            }
        }
        b(dVar, interfaceC0372b, D12);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget3 = e12.get(i13);
                if (constraintWidget3 instanceof androidx.constraintlayout.solver.widgets.a) {
                    androidx.constraintlayout.solver.widgets.a aVar = (androidx.constraintlayout.solver.widgets.a) constraintWidget3;
                    if (aVar.k1() == 0) {
                        c(aVar, interfaceC0372b, 0, D12);
                    }
                }
            }
        }
        if (R10 == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.w0(0, dVar.y());
        } else {
            dVar.v0(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget4 = e12.get(i14);
            if (constraintWidget4 instanceof androidx.constraintlayout.solver.widgets.f) {
                androidx.constraintlayout.solver.widgets.f fVar3 = (androidx.constraintlayout.solver.widgets.f) constraintWidget4;
                if (fVar3.f1() == 0) {
                    if (fVar3.g1() != -1) {
                        fVar3.j1(fVar3.g1());
                    } else if (fVar3.h1() != -1 && dVar.i0()) {
                        fVar3.j1(dVar.y() - fVar3.h1());
                    } else if (dVar.i0()) {
                        fVar3.j1((int) ((fVar3.i1() * dVar.y()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((constraintWidget4 instanceof androidx.constraintlayout.solver.widgets.a) && ((androidx.constraintlayout.solver.widgets.a) constraintWidget4).k1() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget5 = e12.get(i15);
                if (constraintWidget5 instanceof androidx.constraintlayout.solver.widgets.f) {
                    androidx.constraintlayout.solver.widgets.f fVar4 = (androidx.constraintlayout.solver.widgets.f) constraintWidget5;
                    if (fVar4.f1() == 0) {
                        i(fVar4, interfaceC0372b);
                    }
                }
            }
        }
        i(dVar, interfaceC0372b);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget6 = e12.get(i16);
                if (constraintWidget6 instanceof androidx.constraintlayout.solver.widgets.a) {
                    androidx.constraintlayout.solver.widgets.a aVar2 = (androidx.constraintlayout.solver.widgets.a) constraintWidget6;
                    if (aVar2.k1() == 1) {
                        c(aVar2, interfaceC0372b, 1, D12);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            ConstraintWidget constraintWidget7 = e12.get(i17);
            if (constraintWidget7.g0() && a(constraintWidget7)) {
                androidx.constraintlayout.solver.widgets.d.G1(constraintWidget7, interfaceC0372b, f37535a, C1639b.a.f37511k);
                b(constraintWidget7, interfaceC0372b, D12);
                i(constraintWidget7, interfaceC0372b);
            }
        }
    }

    public static void i(ConstraintWidget constraintWidget, C1639b.InterfaceC0372b interfaceC0372b) {
        boolean z10;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        if (!(constraintWidget instanceof androidx.constraintlayout.solver.widgets.d) && constraintWidget.g0() && a(constraintWidget)) {
            androidx.constraintlayout.solver.widgets.d.G1(constraintWidget, interfaceC0372b, new C1639b.a(), C1639b.a.f37511k);
        }
        ConstraintAnchor p10 = constraintWidget.p(ConstraintAnchor.Type.TOP);
        ConstraintAnchor p11 = constraintWidget.p(ConstraintAnchor.Type.BOTTOM);
        int e10 = p10.e();
        int e11 = p11.e();
        if (p10.d() != null && p10.n()) {
            Iterator<ConstraintAnchor> it = p10.d().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.f8290d;
                boolean a10 = a(constraintWidget2);
                if (constraintWidget2.g0() && a10) {
                    androidx.constraintlayout.solver.widgets.d.G1(constraintWidget2, interfaceC0372b, new C1639b.a(), C1639b.a.f37511k);
                }
                ConstraintWidget.DimensionBehaviour R10 = constraintWidget2.R();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (R10 == dimensionBehaviour && !a10) {
                    if (constraintWidget2.R() == dimensionBehaviour && constraintWidget2.f8390w >= 0 && constraintWidget2.f8388v >= 0 && (constraintWidget2.T() == 8 || (constraintWidget2.f8378q == 0 && constraintWidget2.w() == 0.0f))) {
                        if (!constraintWidget2.e0() && !constraintWidget2.f0() && ((next == constraintWidget2.f8328K && (constraintAnchor5 = constraintWidget2.f8332M.f8292f) != null && constraintAnchor5.n()) || (next == constraintWidget2.f8332M && (constraintAnchor4 = constraintWidget2.f8328K.f8292f) != null && constraintAnchor4.n()))) {
                            if (!constraintWidget2.e0()) {
                                g(constraintWidget, interfaceC0372b, constraintWidget2);
                            }
                        }
                    }
                } else if (!constraintWidget2.g0()) {
                    ConstraintAnchor constraintAnchor6 = constraintWidget2.f8328K;
                    if (next == constraintAnchor6 && constraintWidget2.f8332M.f8292f == null) {
                        int f10 = constraintAnchor6.f() + e10;
                        constraintWidget2.w0(f10, constraintWidget2.y() + f10);
                        i(constraintWidget2, interfaceC0372b);
                    } else {
                        ConstraintAnchor constraintAnchor7 = constraintWidget2.f8332M;
                        if (next == constraintAnchor7 && constraintAnchor7.f8292f == null) {
                            int f11 = e10 - constraintAnchor7.f();
                            constraintWidget2.w0(f11 - constraintWidget2.y(), f11);
                            i(constraintWidget2, interfaceC0372b);
                        } else if (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor7.f8292f) != null && constraintAnchor3.n()) {
                            f(interfaceC0372b, constraintWidget2);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.solver.widgets.f) {
            return;
        }
        if (p11.d() != null && p11.n()) {
            Iterator<ConstraintAnchor> it2 = p11.d().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.f8290d;
                boolean a11 = a(constraintWidget3);
                if (constraintWidget3.g0() && a11) {
                    androidx.constraintlayout.solver.widgets.d.G1(constraintWidget3, interfaceC0372b, new C1639b.a(), C1639b.a.f37511k);
                }
                if ((next2 == constraintWidget3.f8328K && (constraintAnchor2 = constraintWidget3.f8332M.f8292f) != null && constraintAnchor2.n()) || (next2 == constraintWidget3.f8332M && (constraintAnchor = constraintWidget3.f8328K.f8292f) != null && constraintAnchor.n())) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                ConstraintWidget.DimensionBehaviour R11 = constraintWidget3.R();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (R11 == dimensionBehaviour2 && !a11) {
                    if (constraintWidget3.R() == dimensionBehaviour2 && constraintWidget3.f8390w >= 0 && constraintWidget3.f8388v >= 0 && (constraintWidget3.T() == 8 || (constraintWidget3.f8378q == 0 && constraintWidget3.w() == 0.0f))) {
                        if (!constraintWidget3.e0() && !constraintWidget3.f0() && z10 && !constraintWidget3.e0()) {
                            g(constraintWidget, interfaceC0372b, constraintWidget3);
                        }
                    }
                } else if (!constraintWidget3.g0()) {
                    ConstraintAnchor constraintAnchor8 = constraintWidget3.f8328K;
                    if (next2 == constraintAnchor8 && constraintWidget3.f8332M.f8292f == null) {
                        int f12 = constraintAnchor8.f() + e11;
                        constraintWidget3.w0(f12, constraintWidget3.y() + f12);
                        i(constraintWidget3, interfaceC0372b);
                    } else {
                        ConstraintAnchor constraintAnchor9 = constraintWidget3.f8332M;
                        if (next2 == constraintAnchor9 && constraintAnchor8.f8292f == null) {
                            int f13 = e11 - constraintAnchor9.f();
                            constraintWidget3.w0(f13 - constraintWidget3.y(), f13);
                            i(constraintWidget3, interfaceC0372b);
                        } else if (z10 && !constraintWidget3.e0()) {
                            f(interfaceC0372b, constraintWidget3);
                        }
                    }
                }
            }
        }
        ConstraintAnchor p12 = constraintWidget.p(ConstraintAnchor.Type.BASELINE);
        if (p12.d() != null && p12.n()) {
            int e12 = p12.e();
            Iterator<ConstraintAnchor> it3 = p12.d().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next3 = it3.next();
                ConstraintWidget constraintWidget4 = next3.f8290d;
                boolean a12 = a(constraintWidget4);
                if (constraintWidget4.g0() && a12) {
                    androidx.constraintlayout.solver.widgets.d.G1(constraintWidget4, interfaceC0372b, new C1639b.a(), C1639b.a.f37511k);
                }
                if (constraintWidget4.R() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a12) {
                    if (!constraintWidget4.g0() && next3 == constraintWidget4.f8333N) {
                        constraintWidget4.s0(e12);
                        i(constraintWidget4, interfaceC0372b);
                    }
                }
            }
        }
    }
}
