package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.c;
import java.util.ArrayList;
import u.C1599a;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements c.a {

    /* renamed from: e, reason: collision with root package name */
    public a f8235e;

    /* renamed from: a, reason: collision with root package name */
    public SolverVariable f8231a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f8232b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8233c = false;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<SolverVariable> f8234d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public boolean f8236f = false;

    /* compiled from: ArrayRow.java */
    /* loaded from: classes.dex */
    public interface a {
        int a();

        SolverVariable b(int i10);

        void c();

        void clear();

        float d(int i10);

        void e(SolverVariable solverVariable, float f10, boolean z10);

        float f(SolverVariable solverVariable);

        boolean g(SolverVariable solverVariable);

        float h(b bVar, boolean z10);

        void i(SolverVariable solverVariable, float f10);

        float j(SolverVariable solverVariable, boolean z10);

        void k(float f10);
    }

    public b() {
    }

    public void A(c cVar, SolverVariable solverVariable, boolean z10) {
        if (!solverVariable.f8202g) {
            return;
        }
        this.f8232b += solverVariable.f8201f * this.f8235e.f(solverVariable);
        this.f8235e.j(solverVariable, z10);
        if (z10) {
            solverVariable.c(this);
        }
        if (c.f8239t && this.f8235e.a() == 0) {
            this.f8236f = true;
            cVar.f8245a = true;
        }
    }

    public void B(c cVar, b bVar, boolean z10) {
        this.f8232b += bVar.f8232b * this.f8235e.h(bVar, z10);
        if (z10) {
            bVar.f8231a.c(this);
        }
        if (c.f8239t && this.f8231a != null && this.f8235e.a() == 0) {
            this.f8236f = true;
            cVar.f8245a = true;
        }
    }

    public void C(c cVar, SolverVariable solverVariable, boolean z10) {
        if (!solverVariable.f8209n) {
            return;
        }
        float f10 = this.f8235e.f(solverVariable);
        this.f8232b += solverVariable.f8211p * f10;
        this.f8235e.j(solverVariable, z10);
        if (z10) {
            solverVariable.c(this);
        }
        this.f8235e.e(cVar.f8258n.f37296d[solverVariable.f8210o], f10, z10);
        if (c.f8239t && this.f8235e.a() == 0) {
            this.f8236f = true;
            cVar.f8245a = true;
        }
    }

    public void D(c cVar) {
        if (cVar.f8251g.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int a10 = this.f8235e.a();
            for (int i10 = 0; i10 < a10; i10++) {
                SolverVariable b10 = this.f8235e.b(i10);
                if (b10.f8199d != -1 || b10.f8202g || b10.f8209n) {
                    this.f8234d.add(b10);
                }
            }
            int size = this.f8234d.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    SolverVariable solverVariable = this.f8234d.get(i11);
                    if (solverVariable.f8202g) {
                        A(cVar, solverVariable, true);
                    } else if (solverVariable.f8209n) {
                        C(cVar, solverVariable, true);
                    } else {
                        B(cVar, cVar.f8251g[solverVariable.f8199d], true);
                    }
                }
                this.f8234d.clear();
            } else {
                z10 = true;
            }
        }
        if (c.f8239t && this.f8231a != null && this.f8235e.a() == 0) {
            this.f8236f = true;
            cVar.f8245a = true;
        }
    }

    @Override // androidx.constraintlayout.solver.c.a
    public void a(SolverVariable solverVariable) {
        int i10 = solverVariable.f8200e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f8235e.i(solverVariable, f10);
    }

    @Override // androidx.constraintlayout.solver.c.a
    public SolverVariable b(c cVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // androidx.constraintlayout.solver.c.a
    public void c(c.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f8231a = null;
            this.f8235e.clear();
            for (int i10 = 0; i10 < bVar.f8235e.a(); i10++) {
                this.f8235e.e(bVar.f8235e.b(i10), bVar.f8235e.d(i10), true);
            }
        }
    }

    @Override // androidx.constraintlayout.solver.c.a
    public void clear() {
        this.f8235e.clear();
        this.f8231a = null;
        this.f8232b = 0.0f;
    }

    public b d(c cVar, int i10) {
        this.f8235e.i(cVar.o(i10, "ep"), 1.0f);
        this.f8235e.i(cVar.o(i10, "em"), -1.0f);
        return this;
    }

    public b e(SolverVariable solverVariable, int i10) {
        this.f8235e.i(solverVariable, i10);
        return this;
    }

    public boolean f(c cVar) {
        boolean z10;
        SolverVariable g10 = g(cVar);
        if (g10 == null) {
            z10 = true;
        } else {
            x(g10);
            z10 = false;
        }
        if (this.f8235e.a() == 0) {
            this.f8236f = true;
        }
        return z10;
    }

    public SolverVariable g(c cVar) {
        boolean u10;
        boolean u11;
        int a10 = this.f8235e.a();
        SolverVariable solverVariable = null;
        float f10 = 0.0f;
        float f11 = 0.0f;
        boolean z10 = false;
        boolean z11 = false;
        SolverVariable solverVariable2 = null;
        for (int i10 = 0; i10 < a10; i10++) {
            float d10 = this.f8235e.d(i10);
            SolverVariable b10 = this.f8235e.b(i10);
            if (b10.f8205j == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    u11 = u(b10, cVar);
                } else if (f10 > d10) {
                    u11 = u(b10, cVar);
                } else if (!z10 && u(b10, cVar)) {
                    f10 = d10;
                    solverVariable = b10;
                    z10 = true;
                }
                z10 = u11;
                f10 = d10;
                solverVariable = b10;
            } else if (solverVariable == null && d10 < 0.0f) {
                if (solverVariable2 == null) {
                    u10 = u(b10, cVar);
                } else if (f11 > d10) {
                    u10 = u(b10, cVar);
                } else if (!z11 && u(b10, cVar)) {
                    f11 = d10;
                    solverVariable2 = b10;
                    z11 = true;
                }
                z11 = u10;
                f11 = d10;
                solverVariable2 = b10;
            }
        }
        if (solverVariable != null) {
            return solverVariable;
        }
        return solverVariable2;
    }

    @Override // androidx.constraintlayout.solver.c.a
    public SolverVariable getKey() {
        return this.f8231a;
    }

    public b h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11) {
        if (solverVariable2 == solverVariable3) {
            this.f8235e.i(solverVariable, 1.0f);
            this.f8235e.i(solverVariable4, 1.0f);
            this.f8235e.i(solverVariable2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f8235e.i(solverVariable, 1.0f);
            this.f8235e.i(solverVariable2, -1.0f);
            this.f8235e.i(solverVariable3, -1.0f);
            this.f8235e.i(solverVariable4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f8232b = (-i10) + i11;
            }
        } else if (f10 <= 0.0f) {
            this.f8235e.i(solverVariable, -1.0f);
            this.f8235e.i(solverVariable2, 1.0f);
            this.f8232b = i10;
        } else if (f10 >= 1.0f) {
            this.f8235e.i(solverVariable4, -1.0f);
            this.f8235e.i(solverVariable3, 1.0f);
            this.f8232b = -i11;
        } else {
            float f11 = 1.0f - f10;
            this.f8235e.i(solverVariable, f11 * 1.0f);
            this.f8235e.i(solverVariable2, f11 * (-1.0f));
            this.f8235e.i(solverVariable3, (-1.0f) * f10);
            this.f8235e.i(solverVariable4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f8232b = ((-i10) * f11) + (i11 * f10);
            }
        }
        return this;
    }

    public b i(SolverVariable solverVariable, int i10) {
        this.f8231a = solverVariable;
        float f10 = i10;
        solverVariable.f8201f = f10;
        this.f8232b = f10;
        this.f8236f = true;
        return this;
    }

    @Override // androidx.constraintlayout.solver.c.a
    public boolean isEmpty() {
        if (this.f8231a == null && this.f8232b == 0.0f && this.f8235e.a() == 0) {
            return true;
        }
        return false;
    }

    public b j(SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        this.f8235e.i(solverVariable, -1.0f);
        this.f8235e.i(solverVariable2, f10);
        return this;
    }

    public b k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f8235e.i(solverVariable, -1.0f);
        this.f8235e.i(solverVariable2, 1.0f);
        this.f8235e.i(solverVariable3, f10);
        this.f8235e.i(solverVariable4, -f10);
        return this;
    }

    public b l(float f10, float f11, float f12, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f8232b = 0.0f;
        if (f11 != 0.0f && f10 != f12) {
            if (f10 == 0.0f) {
                this.f8235e.i(solverVariable, 1.0f);
                this.f8235e.i(solverVariable2, -1.0f);
            } else if (f12 == 0.0f) {
                this.f8235e.i(solverVariable3, 1.0f);
                this.f8235e.i(solverVariable4, -1.0f);
            } else {
                float f13 = (f10 / f11) / (f12 / f11);
                this.f8235e.i(solverVariable, 1.0f);
                this.f8235e.i(solverVariable2, -1.0f);
                this.f8235e.i(solverVariable4, f13);
                this.f8235e.i(solverVariable3, -f13);
            }
        } else {
            this.f8235e.i(solverVariable, 1.0f);
            this.f8235e.i(solverVariable2, -1.0f);
            this.f8235e.i(solverVariable4, 1.0f);
            this.f8235e.i(solverVariable3, -1.0f);
        }
        return this;
    }

    public b m(SolverVariable solverVariable, int i10) {
        if (i10 < 0) {
            this.f8232b = i10 * (-1);
            this.f8235e.i(solverVariable, 1.0f);
        } else {
            this.f8232b = i10;
            this.f8235e.i(solverVariable, -1.0f);
        }
        return this;
    }

    public b n(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        boolean z10;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            } else {
                z10 = false;
            }
            this.f8232b = i10;
            if (z10) {
                this.f8235e.i(solverVariable, 1.0f);
                this.f8235e.i(solverVariable2, -1.0f);
                return this;
            }
        }
        this.f8235e.i(solverVariable, -1.0f);
        this.f8235e.i(solverVariable2, 1.0f);
        return this;
    }

    public b o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            } else {
                z10 = false;
            }
            this.f8232b = i10;
            if (z10) {
                this.f8235e.i(solverVariable, 1.0f);
                this.f8235e.i(solverVariable2, -1.0f);
                this.f8235e.i(solverVariable3, -1.0f);
                return this;
            }
        }
        this.f8235e.i(solverVariable, -1.0f);
        this.f8235e.i(solverVariable2, 1.0f);
        this.f8235e.i(solverVariable3, 1.0f);
        return this;
    }

    public b p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            } else {
                z10 = false;
            }
            this.f8232b = i10;
            if (z10) {
                this.f8235e.i(solverVariable, 1.0f);
                this.f8235e.i(solverVariable2, -1.0f);
                this.f8235e.i(solverVariable3, 1.0f);
                return this;
            }
        }
        this.f8235e.i(solverVariable, -1.0f);
        this.f8235e.i(solverVariable2, 1.0f);
        this.f8235e.i(solverVariable3, -1.0f);
        return this;
    }

    public b q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f8235e.i(solverVariable3, 0.5f);
        this.f8235e.i(solverVariable4, 0.5f);
        this.f8235e.i(solverVariable, -0.5f);
        this.f8235e.i(solverVariable2, -0.5f);
        this.f8232b = -f10;
        return this;
    }

    public void r() {
        float f10 = this.f8232b;
        if (f10 < 0.0f) {
            this.f8232b = f10 * (-1.0f);
            this.f8235e.c();
        }
    }

    public boolean s() {
        SolverVariable solverVariable = this.f8231a;
        if (solverVariable != null && (solverVariable.f8205j == SolverVariable.Type.UNRESTRICTED || this.f8232b >= 0.0f)) {
            return true;
        }
        return false;
    }

    public boolean t(SolverVariable solverVariable) {
        return this.f8235e.g(solverVariable);
    }

    public String toString() {
        return z();
    }

    public final boolean u(SolverVariable solverVariable, c cVar) {
        if (solverVariable.f8208m <= 1) {
            return true;
        }
        return false;
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w(null, solverVariable);
    }

    public final SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int a10 = this.f8235e.a();
        SolverVariable solverVariable2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < a10; i10++) {
            float d10 = this.f8235e.d(i10);
            if (d10 < 0.0f) {
                SolverVariable b10 = this.f8235e.b(i10);
                if ((zArr == null || !zArr[b10.f8198c]) && b10 != solverVariable && (((type = b10.f8205j) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && d10 < f10)) {
                    f10 = d10;
                    solverVariable2 = b10;
                }
            }
        }
        return solverVariable2;
    }

    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f8231a;
        if (solverVariable2 != null) {
            this.f8235e.i(solverVariable2, -1.0f);
            this.f8231a.f8199d = -1;
            this.f8231a = null;
        }
        float j10 = this.f8235e.j(solverVariable, true) * (-1.0f);
        this.f8231a = solverVariable;
        if (j10 == 1.0f) {
            return;
        }
        this.f8232b /= j10;
        this.f8235e.k(j10);
    }

    public void y() {
        this.f8231a = null;
        this.f8235e.clear();
        this.f8232b = 0.0f;
        this.f8236f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String z() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.b.z():java.lang.String");
    }

    public b(C1599a c1599a) {
        this.f8235e = new androidx.constraintlayout.solver.a(this, c1599a);
    }
}
