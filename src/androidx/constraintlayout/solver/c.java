package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;
import u.C1599a;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: r, reason: collision with root package name */
    public static boolean f8237r = false;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f8238s = true;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f8239t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f8240u = true;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f8241v = false;

    /* renamed from: w, reason: collision with root package name */
    public static int f8242w = 1000;

    /* renamed from: x, reason: collision with root package name */
    public static long f8243x;

    /* renamed from: y, reason: collision with root package name */
    public static long f8244y;

    /* renamed from: d, reason: collision with root package name */
    public a f8248d;

    /* renamed from: g, reason: collision with root package name */
    public androidx.constraintlayout.solver.b[] f8251g;

    /* renamed from: n, reason: collision with root package name */
    public final C1599a f8258n;

    /* renamed from: q, reason: collision with root package name */
    public a f8261q;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8245a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f8246b = 0;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, SolverVariable> f8247c = null;

    /* renamed from: e, reason: collision with root package name */
    public int f8249e = 32;

    /* renamed from: f, reason: collision with root package name */
    public int f8250f = 32;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8252h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8253i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean[] f8254j = new boolean[32];

    /* renamed from: k, reason: collision with root package name */
    public int f8255k = 1;

    /* renamed from: l, reason: collision with root package name */
    public int f8256l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f8257m = 32;

    /* renamed from: o, reason: collision with root package name */
    public SolverVariable[] f8259o = new SolverVariable[f8242w];

    /* renamed from: p, reason: collision with root package name */
    public int f8260p = 0;

    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(SolverVariable solverVariable);

        SolverVariable b(c cVar, boolean[] zArr);

        void c(a aVar);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public class b extends androidx.constraintlayout.solver.b {
        public b(C1599a c1599a) {
            this.f8235e = new e(this, c1599a);
        }
    }

    public c() {
        this.f8251g = null;
        this.f8251g = new androidx.constraintlayout.solver.b[32];
        D();
        C1599a c1599a = new C1599a();
        this.f8258n = c1599a;
        this.f8248d = new d(c1599a);
        if (f8241v) {
            this.f8261q = new b(c1599a);
        } else {
            this.f8261q = new androidx.constraintlayout.solver.b(c1599a);
        }
    }

    public static androidx.constraintlayout.solver.b s(c cVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        return cVar.r().j(solverVariable, solverVariable2, f10);
    }

    public static u.b x() {
        return null;
    }

    public void A() {
        if (this.f8248d.isEmpty()) {
            n();
            return;
        }
        if (!this.f8252h && !this.f8253i) {
            B(this.f8248d);
            return;
        }
        for (int i10 = 0; i10 < this.f8256l; i10++) {
            if (!this.f8251g[i10].f8236f) {
                B(this.f8248d);
                return;
            }
        }
        n();
    }

    public void B(a aVar) {
        u(aVar);
        C(aVar, false);
        n();
    }

    public final int C(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f8255k; i10++) {
            this.f8254j[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 >= this.f8255k * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f8254j[aVar.getKey().f8198c] = true;
            }
            SolverVariable b10 = aVar.b(this, this.f8254j);
            if (b10 != null) {
                boolean[] zArr = this.f8254j;
                int i12 = b10.f8198c;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (b10 != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f8256l; i14++) {
                    androidx.constraintlayout.solver.b bVar = this.f8251g[i14];
                    if (bVar.f8231a.f8205j != SolverVariable.Type.UNRESTRICTED && !bVar.f8236f && bVar.t(b10)) {
                        float f11 = bVar.f8235e.f(b10);
                        if (f11 < 0.0f) {
                            float f12 = (-bVar.f8232b) / f11;
                            if (f12 < f10) {
                                i13 = i14;
                                f10 = f12;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    androidx.constraintlayout.solver.b bVar2 = this.f8251g[i13];
                    bVar2.f8231a.f8199d = -1;
                    bVar2.x(b10);
                    SolverVariable solverVariable = bVar2.f8231a;
                    solverVariable.f8199d = i13;
                    solverVariable.g(this, bVar2);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    public final void D() {
        int i10 = 0;
        if (f8241v) {
            while (i10 < this.f8256l) {
                androidx.constraintlayout.solver.b bVar = this.f8251g[i10];
                if (bVar != null) {
                    this.f8258n.f37293a.a(bVar);
                }
                this.f8251g[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f8256l) {
            androidx.constraintlayout.solver.b bVar2 = this.f8251g[i10];
            if (bVar2 != null) {
                this.f8258n.f37294b.a(bVar2);
            }
            this.f8251g[i10] = null;
            i10++;
        }
    }

    public void E() {
        C1599a c1599a;
        int i10 = 0;
        while (true) {
            c1599a = this.f8258n;
            SolverVariable[] solverVariableArr = c1599a.f37296d;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.d();
            }
            i10++;
        }
        c1599a.f37295c.c(this.f8259o, this.f8260p);
        this.f8260p = 0;
        Arrays.fill(this.f8258n.f37296d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f8247c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f8246b = 0;
        this.f8248d.clear();
        this.f8255k = 1;
        for (int i11 = 0; i11 < this.f8256l; i11++) {
            androidx.constraintlayout.solver.b bVar = this.f8251g[i11];
            if (bVar != null) {
                bVar.f8233c = false;
            }
        }
        D();
        this.f8256l = 0;
        if (f8241v) {
            this.f8261q = new b(this.f8258n);
        } else {
            this.f8261q = new androidx.constraintlayout.solver.b(this.f8258n);
        }
    }

    public final SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable b10 = this.f8258n.f37295c.b();
        if (b10 == null) {
            b10 = new SolverVariable(type, str);
            b10.f(type, str);
        } else {
            b10.d();
            b10.f(type, str);
        }
        int i10 = this.f8260p;
        int i11 = f8242w;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f8242w = i12;
            this.f8259o = (SolverVariable[]) Arrays.copyOf(this.f8259o, i12);
        }
        SolverVariable[] solverVariableArr = this.f8259o;
        int i13 = this.f8260p;
        this.f8260p = i13 + 1;
        solverVariableArr[i13] = b10;
        return b10;
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable q10 = q(constraintWidget.p(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable q11 = q(constraintWidget.p(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable q12 = q(constraintWidget.p(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable q13 = q(constraintWidget.p(type4));
        SolverVariable q14 = q(constraintWidget2.p(type));
        SolverVariable q15 = q(constraintWidget2.p(type2));
        SolverVariable q16 = q(constraintWidget2.p(type3));
        SolverVariable q17 = q(constraintWidget2.p(type4));
        androidx.constraintlayout.solver.b r10 = r();
        double d10 = f10;
        double d11 = i10;
        r10.q(q11, q13, q15, q17, (float) (Math.sin(d10) * d11));
        d(r10);
        androidx.constraintlayout.solver.b r11 = r();
        r11.q(q10, q12, q14, q16, (float) (Math.cos(d10) * d11));
        d(r11);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        androidx.constraintlayout.solver.b r10 = r();
        r10.h(solverVariable, solverVariable2, i10, f10, solverVariable3, solverVariable4, i11);
        if (i12 != 8) {
            r10.d(this, i12);
        }
        d(r10);
    }

    public void d(androidx.constraintlayout.solver.b bVar) {
        SolverVariable v10;
        if (bVar == null) {
            return;
        }
        boolean z10 = true;
        if (this.f8256l + 1 >= this.f8257m || this.f8255k + 1 >= this.f8250f) {
            z();
        }
        if (!bVar.f8236f) {
            bVar.D(this);
            if (bVar.isEmpty()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                SolverVariable p10 = p();
                bVar.f8231a = p10;
                int i10 = this.f8256l;
                l(bVar);
                if (this.f8256l == i10 + 1) {
                    this.f8261q.c(bVar);
                    C(this.f8261q, true);
                    if (p10.f8199d == -1) {
                        if (bVar.f8231a == p10 && (v10 = bVar.v(p10)) != null) {
                            bVar.x(v10);
                        }
                        if (!bVar.f8236f) {
                            bVar.f8231a.g(this, bVar);
                        }
                        if (f8241v) {
                            this.f8258n.f37293a.a(bVar);
                        } else {
                            this.f8258n.f37294b.a(bVar);
                        }
                        this.f8256l--;
                    }
                    if (!bVar.s() || z10) {
                        return;
                    }
                }
            }
            z10 = false;
            if (!bVar.s()) {
                return;
            } else {
                return;
            }
        }
        l(bVar);
    }

    public androidx.constraintlayout.solver.b e(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        if (f8238s && i11 == 8 && solverVariable2.f8202g && solverVariable.f8199d == -1) {
            solverVariable.e(this, solverVariable2.f8201f + i10);
            return null;
        }
        androidx.constraintlayout.solver.b r10 = r();
        r10.n(solverVariable, solverVariable2, i10);
        if (i11 != 8) {
            r10.d(this, i11);
        }
        d(r10);
        return r10;
    }

    public void f(SolverVariable solverVariable, int i10) {
        if (f8238s && solverVariable.f8199d == -1) {
            float f10 = i10;
            solverVariable.e(this, f10);
            for (int i11 = 0; i11 < this.f8246b + 1; i11++) {
                SolverVariable solverVariable2 = this.f8258n.f37296d[i11];
                if (solverVariable2 != null && solverVariable2.f8209n && solverVariable2.f8210o == solverVariable.f8198c) {
                    solverVariable2.e(this, solverVariable2.f8211p + f10);
                }
            }
            return;
        }
        int i12 = solverVariable.f8199d;
        if (i12 != -1) {
            androidx.constraintlayout.solver.b bVar = this.f8251g[i12];
            if (bVar.f8236f) {
                bVar.f8232b = i10;
                return;
            }
            if (bVar.f8235e.a() == 0) {
                bVar.f8236f = true;
                bVar.f8232b = i10;
                return;
            } else {
                androidx.constraintlayout.solver.b r10 = r();
                r10.m(solverVariable, i10);
                d(r10);
                return;
            }
        }
        androidx.constraintlayout.solver.b r11 = r();
        r11.i(solverVariable, i10);
        d(r11);
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        androidx.constraintlayout.solver.b r10 = r();
        SolverVariable t10 = t();
        t10.f8200e = 0;
        r10.o(solverVariable, solverVariable2, t10, i10);
        d(r10);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        androidx.constraintlayout.solver.b r10 = r();
        SolverVariable t10 = t();
        t10.f8200e = 0;
        r10.o(solverVariable, solverVariable2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f8235e.f(t10) * (-1.0f)), i11);
        }
        d(r10);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        androidx.constraintlayout.solver.b r10 = r();
        SolverVariable t10 = t();
        t10.f8200e = 0;
        r10.p(solverVariable, solverVariable2, t10, i10);
        d(r10);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        androidx.constraintlayout.solver.b r10 = r();
        SolverVariable t10 = t();
        t10.f8200e = 0;
        r10.p(solverVariable, solverVariable2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f8235e.f(t10) * (-1.0f)), i11);
        }
        d(r10);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10, int i10) {
        androidx.constraintlayout.solver.b r10 = r();
        r10.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f10);
        if (i10 != 8) {
            r10.d(this, i10);
        }
        d(r10);
    }

    public final void l(androidx.constraintlayout.solver.b bVar) {
        int i10;
        if (f8239t && bVar.f8236f) {
            bVar.f8231a.e(this, bVar.f8232b);
        } else {
            androidx.constraintlayout.solver.b[] bVarArr = this.f8251g;
            int i11 = this.f8256l;
            bVarArr[i11] = bVar;
            SolverVariable solverVariable = bVar.f8231a;
            solverVariable.f8199d = i11;
            this.f8256l = i11 + 1;
            solverVariable.g(this, bVar);
        }
        if (f8239t && this.f8245a) {
            int i12 = 0;
            while (i12 < this.f8256l) {
                if (this.f8251g[i12] == null) {
                    System.out.println("WTF");
                }
                androidx.constraintlayout.solver.b bVar2 = this.f8251g[i12];
                if (bVar2 != null && bVar2.f8236f) {
                    bVar2.f8231a.e(this, bVar2.f8232b);
                    if (f8241v) {
                        this.f8258n.f37293a.a(bVar2);
                    } else {
                        this.f8258n.f37294b.a(bVar2);
                    }
                    this.f8251g[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f8256l;
                        if (i13 >= i10) {
                            break;
                        }
                        androidx.constraintlayout.solver.b[] bVarArr2 = this.f8251g;
                        int i15 = i13 - 1;
                        androidx.constraintlayout.solver.b bVar3 = bVarArr2[i13];
                        bVarArr2[i15] = bVar3;
                        SolverVariable solverVariable2 = bVar3.f8231a;
                        if (solverVariable2.f8199d == i13) {
                            solverVariable2.f8199d = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f8251g[i14] = null;
                    }
                    this.f8256l = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f8245a = false;
        }
    }

    public void m(androidx.constraintlayout.solver.b bVar, int i10, int i11) {
        bVar.e(o(i11, null), i10);
    }

    public final void n() {
        for (int i10 = 0; i10 < this.f8256l; i10++) {
            androidx.constraintlayout.solver.b bVar = this.f8251g[i10];
            bVar.f8231a.f8201f = bVar.f8232b;
        }
    }

    public SolverVariable o(int i10, String str) {
        if (this.f8255k + 1 >= this.f8250f) {
            z();
        }
        SolverVariable a10 = a(SolverVariable.Type.ERROR, str);
        int i11 = this.f8246b + 1;
        this.f8246b = i11;
        this.f8255k++;
        a10.f8198c = i11;
        a10.f8200e = i10;
        this.f8258n.f37296d[i11] = a10;
        this.f8248d.a(a10);
        return a10;
    }

    public SolverVariable p() {
        if (this.f8255k + 1 >= this.f8250f) {
            z();
        }
        SolverVariable a10 = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f8246b + 1;
        this.f8246b = i10;
        this.f8255k++;
        a10.f8198c = i10;
        this.f8258n.f37296d[i10] = a10;
        return a10;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f8255k + 1 >= this.f8250f) {
            z();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.i();
            if (solverVariable == null) {
                constraintAnchor.s(this.f8258n);
                solverVariable = constraintAnchor.i();
            }
            int i10 = solverVariable.f8198c;
            if (i10 == -1 || i10 > this.f8246b || this.f8258n.f37296d[i10] == null) {
                if (i10 != -1) {
                    solverVariable.d();
                }
                int i11 = this.f8246b + 1;
                this.f8246b = i11;
                this.f8255k++;
                solverVariable.f8198c = i11;
                solverVariable.f8205j = SolverVariable.Type.UNRESTRICTED;
                this.f8258n.f37296d[i11] = solverVariable;
            }
        }
        return solverVariable;
    }

    public androidx.constraintlayout.solver.b r() {
        androidx.constraintlayout.solver.b b10;
        if (f8241v) {
            b10 = this.f8258n.f37293a.b();
            if (b10 == null) {
                b10 = new b(this.f8258n);
                f8244y++;
            } else {
                b10.y();
            }
        } else {
            b10 = this.f8258n.f37294b.b();
            if (b10 == null) {
                b10 = new androidx.constraintlayout.solver.b(this.f8258n);
                f8243x++;
            } else {
                b10.y();
            }
        }
        SolverVariable.b();
        return b10;
    }

    public SolverVariable t() {
        if (this.f8255k + 1 >= this.f8250f) {
            z();
        }
        SolverVariable a10 = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f8246b + 1;
        this.f8246b = i10;
        this.f8255k++;
        a10.f8198c = i10;
        this.f8258n.f37296d[i10] = a10;
        return a10;
    }

    public final int u(a aVar) {
        for (int i10 = 0; i10 < this.f8256l; i10++) {
            androidx.constraintlayout.solver.b bVar = this.f8251g[i10];
            if (bVar.f8231a.f8205j != SolverVariable.Type.UNRESTRICTED && bVar.f8232b < 0.0f) {
                boolean z10 = false;
                int i11 = 0;
                while (!z10) {
                    i11++;
                    float f10 = Float.MAX_VALUE;
                    int i12 = 0;
                    int i13 = -1;
                    int i14 = -1;
                    int i15 = 0;
                    while (true) {
                        if (i12 >= this.f8256l) {
                            break;
                        }
                        androidx.constraintlayout.solver.b bVar2 = this.f8251g[i12];
                        if (bVar2.f8231a.f8205j != SolverVariable.Type.UNRESTRICTED && !bVar2.f8236f && bVar2.f8232b < 0.0f) {
                            int i16 = 9;
                            if (f8240u) {
                                int a10 = bVar2.f8235e.a();
                                int i17 = 0;
                                while (i17 < a10) {
                                    SolverVariable b10 = bVar2.f8235e.b(i17);
                                    float f11 = bVar2.f8235e.f(b10);
                                    if (f11 > 0.0f) {
                                        int i18 = 0;
                                        while (i18 < i16) {
                                            float f12 = b10.f8203h[i18] / f11;
                                            if ((f12 < f10 && i18 == i15) || i18 > i15) {
                                                i15 = i18;
                                                i14 = b10.f8198c;
                                                i13 = i12;
                                                f10 = f12;
                                            }
                                            i18++;
                                            i16 = 9;
                                        }
                                    }
                                    i17++;
                                    i16 = 9;
                                }
                            } else {
                                for (int i19 = 1; i19 < this.f8255k; i19++) {
                                    SolverVariable solverVariable = this.f8258n.f37296d[i19];
                                    float f13 = bVar2.f8235e.f(solverVariable);
                                    if (f13 > 0.0f) {
                                        for (int i20 = 0; i20 < 9; i20++) {
                                            float f14 = solverVariable.f8203h[i20] / f13;
                                            if ((f14 < f10 && i20 == i15) || i20 > i15) {
                                                i13 = i12;
                                                i14 = i19;
                                                i15 = i20;
                                                f10 = f14;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i12++;
                    }
                    if (i13 != -1) {
                        androidx.constraintlayout.solver.b bVar3 = this.f8251g[i13];
                        bVar3.f8231a.f8199d = -1;
                        bVar3.x(this.f8258n.f37296d[i14]);
                        SolverVariable solverVariable2 = bVar3.f8231a;
                        solverVariable2.f8199d = i13;
                        solverVariable2.g(this, bVar3);
                    } else {
                        z10 = true;
                    }
                    if (i11 > this.f8255k / 2) {
                        z10 = true;
                    }
                }
                return i11;
            }
        }
        return 0;
    }

    public C1599a w() {
        return this.f8258n;
    }

    public int y(Object obj) {
        SolverVariable i10 = ((ConstraintAnchor) obj).i();
        if (i10 != null) {
            return (int) (i10.f8201f + 0.5f);
        }
        return 0;
    }

    public final void z() {
        int i10 = this.f8249e * 2;
        this.f8249e = i10;
        this.f8251g = (androidx.constraintlayout.solver.b[]) Arrays.copyOf(this.f8251g, i10);
        C1599a c1599a = this.f8258n;
        c1599a.f37296d = (SolverVariable[]) Arrays.copyOf(c1599a.f37296d, this.f8249e);
        int i11 = this.f8249e;
        this.f8254j = new boolean[i11];
        this.f8250f = i11;
        this.f8257m = i11;
    }

    public void v(u.b bVar) {
    }
}
