package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.b;
import java.util.Arrays;
import u.C1599a;

/* compiled from: SolverVariableValues.java */
/* loaded from: classes.dex */
public class e implements b.a {

    /* renamed from: n, reason: collision with root package name */
    public static float f8273n = 0.001f;

    /* renamed from: a, reason: collision with root package name */
    public final int f8274a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f8275b = 16;

    /* renamed from: c, reason: collision with root package name */
    public int f8276c = 16;

    /* renamed from: d, reason: collision with root package name */
    public int[] f8277d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    public int[] f8278e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    public int[] f8279f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    public float[] f8280g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    public int[] f8281h = new int[16];

    /* renamed from: i, reason: collision with root package name */
    public int[] f8282i = new int[16];

    /* renamed from: j, reason: collision with root package name */
    public int f8283j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f8284k = -1;

    /* renamed from: l, reason: collision with root package name */
    public final b f8285l;

    /* renamed from: m, reason: collision with root package name */
    public final C1599a f8286m;

    public e(b bVar, C1599a c1599a) {
        this.f8285l = bVar;
        this.f8286m = c1599a;
        clear();
    }

    @Override // androidx.constraintlayout.solver.b.a
    public int a() {
        return this.f8283j;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public SolverVariable b(int i10) {
        int i11 = this.f8283j;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f8284k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f8286m.f37296d[this.f8279f[i12]];
            }
            i12 = this.f8282i[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public void c() {
        int i10 = this.f8283j;
        int i11 = this.f8284k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f8280g;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f8282i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.b.a
    public void clear() {
        int i10 = this.f8283j;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable b10 = b(i11);
            if (b10 != null) {
                b10.c(this.f8285l);
            }
        }
        for (int i12 = 0; i12 < this.f8275b; i12++) {
            this.f8279f[i12] = -1;
            this.f8278e[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f8276c; i13++) {
            this.f8277d[i13] = -1;
        }
        this.f8283j = 0;
        this.f8284k = -1;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public float d(int i10) {
        int i11 = this.f8283j;
        int i12 = this.f8284k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f8280g[i12];
            }
            i12 = this.f8282i[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public void e(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f8273n;
        if (f10 > (-f11) && f10 < f11) {
            return;
        }
        int p10 = p(solverVariable);
        if (p10 == -1) {
            i(solverVariable, f10);
            return;
        }
        float[] fArr = this.f8280g;
        float f12 = fArr[p10] + f10;
        fArr[p10] = f12;
        float f13 = f8273n;
        if (f12 > (-f13) && f12 < f13) {
            fArr[p10] = 0.0f;
            j(solverVariable, z10);
        }
    }

    @Override // androidx.constraintlayout.solver.b.a
    public float f(SolverVariable solverVariable) {
        int p10 = p(solverVariable);
        if (p10 != -1) {
            return this.f8280g[p10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public boolean g(SolverVariable solverVariable) {
        if (p(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public float h(b bVar, boolean z10) {
        float f10 = f(bVar.f8231a);
        j(bVar.f8231a, z10);
        e eVar = (e) bVar.f8235e;
        int a10 = eVar.a();
        int i10 = 0;
        int i11 = 0;
        while (i10 < a10) {
            int i12 = eVar.f8279f[i11];
            if (i12 != -1) {
                e(this.f8286m.f37296d[i12], eVar.f8280g[i11] * f10, z10);
                i10++;
            }
            i11++;
        }
        return f10;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public void i(SolverVariable solverVariable, float f10) {
        float f11 = f8273n;
        if (f10 > (-f11) && f10 < f11) {
            j(solverVariable, true);
            return;
        }
        if (this.f8283j == 0) {
            m(0, solverVariable, f10);
            l(solverVariable, 0);
            this.f8284k = 0;
            return;
        }
        int p10 = p(solverVariable);
        if (p10 != -1) {
            this.f8280g[p10] = f10;
            return;
        }
        if (this.f8283j + 1 >= this.f8275b) {
            o();
        }
        int i10 = this.f8283j;
        int i11 = this.f8284k;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = this.f8279f[i11];
            int i15 = solverVariable.f8198c;
            if (i14 == i15) {
                this.f8280g[i11] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i11;
            }
            i11 = this.f8282i[i11];
            if (i11 == -1) {
                break;
            }
        }
        q(i12, solverVariable, f10);
    }

    @Override // androidx.constraintlayout.solver.b.a
    public float j(SolverVariable solverVariable, boolean z10) {
        int p10 = p(solverVariable);
        if (p10 == -1) {
            return 0.0f;
        }
        r(solverVariable);
        float f10 = this.f8280g[p10];
        if (this.f8284k == p10) {
            this.f8284k = this.f8282i[p10];
        }
        this.f8279f[p10] = -1;
        int[] iArr = this.f8281h;
        int i10 = iArr[p10];
        if (i10 != -1) {
            int[] iArr2 = this.f8282i;
            iArr2[i10] = iArr2[p10];
        }
        int i11 = this.f8282i[p10];
        if (i11 != -1) {
            iArr[i11] = iArr[p10];
        }
        this.f8283j--;
        solverVariable.f8208m--;
        if (z10) {
            solverVariable.c(this.f8285l);
        }
        return f10;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public void k(float f10) {
        int i10 = this.f8283j;
        int i11 = this.f8284k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f8280g;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f8282i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    public final void l(SolverVariable solverVariable, int i10) {
        int[] iArr;
        int i11 = solverVariable.f8198c % this.f8276c;
        int[] iArr2 = this.f8277d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f8278e;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            iArr[i12] = i10;
        }
        this.f8278e[i10] = -1;
    }

    public final void m(int i10, SolverVariable solverVariable, float f10) {
        this.f8279f[i10] = solverVariable.f8198c;
        this.f8280g[i10] = f10;
        this.f8281h[i10] = -1;
        this.f8282i[i10] = -1;
        solverVariable.a(this.f8285l);
        solverVariable.f8208m++;
        this.f8283j++;
    }

    public final int n() {
        for (int i10 = 0; i10 < this.f8275b; i10++) {
            if (this.f8279f[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    public final void o() {
        int i10 = this.f8275b * 2;
        this.f8279f = Arrays.copyOf(this.f8279f, i10);
        this.f8280g = Arrays.copyOf(this.f8280g, i10);
        this.f8281h = Arrays.copyOf(this.f8281h, i10);
        this.f8282i = Arrays.copyOf(this.f8282i, i10);
        this.f8278e = Arrays.copyOf(this.f8278e, i10);
        for (int i11 = this.f8275b; i11 < i10; i11++) {
            this.f8279f[i11] = -1;
            this.f8278e[i11] = -1;
        }
        this.f8275b = i10;
    }

    public int p(SolverVariable solverVariable) {
        if (this.f8283j != 0 && solverVariable != null) {
            int i10 = solverVariable.f8198c;
            int i11 = this.f8277d[i10 % this.f8276c];
            if (i11 == -1) {
                return -1;
            }
            if (this.f8279f[i11] == i10) {
                return i11;
            }
            do {
                i11 = this.f8278e[i11];
                if (i11 == -1) {
                    break;
                }
            } while (this.f8279f[i11] != i10);
            if (i11 != -1 && this.f8279f[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    public final void q(int i10, SolverVariable solverVariable, float f10) {
        int n10 = n();
        m(n10, solverVariable, f10);
        if (i10 != -1) {
            this.f8281h[n10] = i10;
            int[] iArr = this.f8282i;
            iArr[n10] = iArr[i10];
            iArr[i10] = n10;
        } else {
            this.f8281h[n10] = -1;
            if (this.f8283j > 0) {
                this.f8282i[n10] = this.f8284k;
                this.f8284k = n10;
            } else {
                this.f8282i[n10] = -1;
            }
        }
        int i11 = this.f8282i[n10];
        if (i11 != -1) {
            this.f8281h[i11] = n10;
        }
        l(solverVariable, n10);
    }

    public final void r(SolverVariable solverVariable) {
        int[] iArr;
        int i10;
        int i11 = solverVariable.f8198c;
        int i12 = i11 % this.f8276c;
        int[] iArr2 = this.f8277d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            return;
        }
        if (this.f8279f[i13] == i11) {
            int[] iArr3 = this.f8278e;
            iArr2[i12] = iArr3[i13];
            iArr3[i13] = -1;
            return;
        }
        while (true) {
            iArr = this.f8278e;
            i10 = iArr[i13];
            if (i10 == -1 || this.f8279f[i10] == i11) {
                break;
            } else {
                i13 = i10;
            }
        }
        if (i10 != -1 && this.f8279f[i10] == i11) {
            iArr[i13] = iArr[i10];
            iArr[i10] = -1;
        }
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i10 = this.f8283j;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable b10 = b(i11);
            if (b10 != null) {
                String str4 = str3 + b10 + " = " + d(i11) + " ";
                int p10 = p(b10);
                String str5 = str4 + "[p: ";
                if (this.f8281h[p10] != -1) {
                    str = str5 + this.f8286m.f37296d[this.f8279f[this.f8281h[p10]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f8282i[p10] != -1) {
                    str2 = str6 + this.f8286m.f37296d[this.f8279f[this.f8282i[p10]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }
}
