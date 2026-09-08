package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.b;
import java.util.Arrays;
import u.C1599a;

/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: l, reason: collision with root package name */
    public static float f8219l = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    public final b f8221b;

    /* renamed from: c, reason: collision with root package name */
    public final C1599a f8222c;

    /* renamed from: a, reason: collision with root package name */
    public int f8220a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f8223d = 8;

    /* renamed from: e, reason: collision with root package name */
    public SolverVariable f8224e = null;

    /* renamed from: f, reason: collision with root package name */
    public int[] f8225f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public int[] f8226g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    public float[] f8227h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    public int f8228i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f8229j = -1;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8230k = false;

    public a(b bVar, C1599a c1599a) {
        this.f8221b = bVar;
        this.f8222c = c1599a;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public int a() {
        return this.f8220a;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public SolverVariable b(int i10) {
        int i11 = this.f8228i;
        for (int i12 = 0; i11 != -1 && i12 < this.f8220a; i12++) {
            if (i12 == i10) {
                return this.f8222c.f37296d[this.f8225f[i11]];
            }
            i11 = this.f8226g[i11];
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public void c() {
        int i10 = this.f8228i;
        for (int i11 = 0; i10 != -1 && i11 < this.f8220a; i11++) {
            float[] fArr = this.f8227h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f8226g[i10];
        }
    }

    @Override // androidx.constraintlayout.solver.b.a
    public final void clear() {
        int i10 = this.f8228i;
        for (int i11 = 0; i10 != -1 && i11 < this.f8220a; i11++) {
            SolverVariable solverVariable = this.f8222c.f37296d[this.f8225f[i10]];
            if (solverVariable != null) {
                solverVariable.c(this.f8221b);
            }
            i10 = this.f8226g[i10];
        }
        this.f8228i = -1;
        this.f8229j = -1;
        this.f8230k = false;
        this.f8220a = 0;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public float d(int i10) {
        int i11 = this.f8228i;
        for (int i12 = 0; i11 != -1 && i12 < this.f8220a; i12++) {
            if (i12 == i10) {
                return this.f8227h[i11];
            }
            i11 = this.f8226g[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public void e(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f8219l;
        if (f10 > (-f11) && f10 < f11) {
            return;
        }
        int i10 = this.f8228i;
        if (i10 == -1) {
            this.f8228i = 0;
            this.f8227h[0] = f10;
            this.f8225f[0] = solverVariable.f8198c;
            this.f8226g[0] = -1;
            solverVariable.f8208m++;
            solverVariable.a(this.f8221b);
            this.f8220a++;
            if (!this.f8230k) {
                int i11 = this.f8229j + 1;
                this.f8229j = i11;
                int[] iArr = this.f8225f;
                if (i11 >= iArr.length) {
                    this.f8230k = true;
                    this.f8229j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f8220a; i13++) {
            int i14 = this.f8225f[i10];
            int i15 = solverVariable.f8198c;
            if (i14 == i15) {
                float[] fArr = this.f8227h;
                float f12 = fArr[i10] + f10;
                float f13 = f8219l;
                if (f12 > (-f13) && f12 < f13) {
                    f12 = 0.0f;
                }
                fArr[i10] = f12;
                if (f12 == 0.0f) {
                    if (i10 == this.f8228i) {
                        this.f8228i = this.f8226g[i10];
                    } else {
                        int[] iArr2 = this.f8226g;
                        iArr2[i12] = iArr2[i10];
                    }
                    if (z10) {
                        solverVariable.c(this.f8221b);
                    }
                    if (this.f8230k) {
                        this.f8229j = i10;
                    }
                    solverVariable.f8208m--;
                    this.f8220a--;
                    return;
                }
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f8226g[i10];
        }
        int i16 = this.f8229j;
        int i17 = i16 + 1;
        if (this.f8230k) {
            int[] iArr3 = this.f8225f;
            if (iArr3[i16] != -1) {
                i16 = iArr3.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr4 = this.f8225f;
        if (i16 >= iArr4.length && this.f8220a < iArr4.length) {
            int i18 = 0;
            while (true) {
                int[] iArr5 = this.f8225f;
                if (i18 >= iArr5.length) {
                    break;
                }
                if (iArr5[i18] == -1) {
                    i16 = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr6 = this.f8225f;
        if (i16 >= iArr6.length) {
            i16 = iArr6.length;
            int i19 = this.f8223d * 2;
            this.f8223d = i19;
            this.f8230k = false;
            this.f8229j = i16 - 1;
            this.f8227h = Arrays.copyOf(this.f8227h, i19);
            this.f8225f = Arrays.copyOf(this.f8225f, this.f8223d);
            this.f8226g = Arrays.copyOf(this.f8226g, this.f8223d);
        }
        this.f8225f[i16] = solverVariable.f8198c;
        this.f8227h[i16] = f10;
        if (i12 != -1) {
            int[] iArr7 = this.f8226g;
            iArr7[i16] = iArr7[i12];
            iArr7[i12] = i16;
        } else {
            this.f8226g[i16] = this.f8228i;
            this.f8228i = i16;
        }
        solverVariable.f8208m++;
        solverVariable.a(this.f8221b);
        this.f8220a++;
        if (!this.f8230k) {
            this.f8229j++;
        }
        int i20 = this.f8229j;
        int[] iArr8 = this.f8225f;
        if (i20 >= iArr8.length) {
            this.f8230k = true;
            this.f8229j = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.b.a
    public final float f(SolverVariable solverVariable) {
        int i10 = this.f8228i;
        for (int i11 = 0; i10 != -1 && i11 < this.f8220a; i11++) {
            if (this.f8225f[i10] == solverVariable.f8198c) {
                return this.f8227h[i10];
            }
            i10 = this.f8226g[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public boolean g(SolverVariable solverVariable) {
        int i10 = this.f8228i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f8220a; i11++) {
            if (this.f8225f[i10] == solverVariable.f8198c) {
                return true;
            }
            i10 = this.f8226g[i10];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public float h(b bVar, boolean z10) {
        float f10 = f(bVar.f8231a);
        j(bVar.f8231a, z10);
        b.a aVar = bVar.f8235e;
        int a10 = aVar.a();
        for (int i10 = 0; i10 < a10; i10++) {
            SolverVariable b10 = aVar.b(i10);
            e(b10, aVar.f(b10) * f10, z10);
        }
        return f10;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public final void i(SolverVariable solverVariable, float f10) {
        if (f10 == 0.0f) {
            j(solverVariable, true);
            return;
        }
        int i10 = this.f8228i;
        if (i10 == -1) {
            this.f8228i = 0;
            this.f8227h[0] = f10;
            this.f8225f[0] = solverVariable.f8198c;
            this.f8226g[0] = -1;
            solverVariable.f8208m++;
            solverVariable.a(this.f8221b);
            this.f8220a++;
            if (!this.f8230k) {
                int i11 = this.f8229j + 1;
                this.f8229j = i11;
                int[] iArr = this.f8225f;
                if (i11 >= iArr.length) {
                    this.f8230k = true;
                    this.f8229j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f8220a; i13++) {
            int i14 = this.f8225f[i10];
            int i15 = solverVariable.f8198c;
            if (i14 == i15) {
                this.f8227h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f8226g[i10];
        }
        int i16 = this.f8229j;
        int i17 = i16 + 1;
        if (this.f8230k) {
            int[] iArr2 = this.f8225f;
            if (iArr2[i16] != -1) {
                i16 = iArr2.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr3 = this.f8225f;
        if (i16 >= iArr3.length && this.f8220a < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f8225f;
                if (i18 >= iArr4.length) {
                    break;
                }
                if (iArr4[i18] == -1) {
                    i16 = i18;
                    break;
                }
                i18++;
            }
        }
        int[] iArr5 = this.f8225f;
        if (i16 >= iArr5.length) {
            i16 = iArr5.length;
            int i19 = this.f8223d * 2;
            this.f8223d = i19;
            this.f8230k = false;
            this.f8229j = i16 - 1;
            this.f8227h = Arrays.copyOf(this.f8227h, i19);
            this.f8225f = Arrays.copyOf(this.f8225f, this.f8223d);
            this.f8226g = Arrays.copyOf(this.f8226g, this.f8223d);
        }
        this.f8225f[i16] = solverVariable.f8198c;
        this.f8227h[i16] = f10;
        if (i12 != -1) {
            int[] iArr6 = this.f8226g;
            iArr6[i16] = iArr6[i12];
            iArr6[i12] = i16;
        } else {
            this.f8226g[i16] = this.f8228i;
            this.f8228i = i16;
        }
        solverVariable.f8208m++;
        solverVariable.a(this.f8221b);
        int i20 = this.f8220a + 1;
        this.f8220a = i20;
        if (!this.f8230k) {
            this.f8229j++;
        }
        int[] iArr7 = this.f8225f;
        if (i20 >= iArr7.length) {
            this.f8230k = true;
        }
        if (this.f8229j >= iArr7.length) {
            this.f8230k = true;
            this.f8229j = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.b.a
    public final float j(SolverVariable solverVariable, boolean z10) {
        if (this.f8224e == solverVariable) {
            this.f8224e = null;
        }
        int i10 = this.f8228i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f8220a) {
            if (this.f8225f[i10] == solverVariable.f8198c) {
                if (i10 == this.f8228i) {
                    this.f8228i = this.f8226g[i10];
                } else {
                    int[] iArr = this.f8226g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    solverVariable.c(this.f8221b);
                }
                solverVariable.f8208m--;
                this.f8220a--;
                this.f8225f[i10] = -1;
                if (this.f8230k) {
                    this.f8229j = i10;
                }
                return this.f8227h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f8226g[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.b.a
    public void k(float f10) {
        int i10 = this.f8228i;
        for (int i11 = 0; i10 != -1 && i11 < this.f8220a; i11++) {
            float[] fArr = this.f8227h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f8226g[i10];
        }
    }

    public String toString() {
        int i10 = this.f8228i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f8220a; i11++) {
            str = ((str + " -> ") + this.f8227h[i10] + " : ") + this.f8222c.f37296d[this.f8225f[i10]];
            i10 = this.f8226g[i10];
        }
        return str;
    }
}
