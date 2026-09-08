package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.b;
import java.util.Arrays;
import java.util.Comparator;
import u.C1599a;

/* compiled from: PriorityGoalRow.java */
/* loaded from: classes.dex */
public class d extends androidx.constraintlayout.solver.b {

    /* renamed from: g, reason: collision with root package name */
    public int f8263g;

    /* renamed from: h, reason: collision with root package name */
    public SolverVariable[] f8264h;

    /* renamed from: i, reason: collision with root package name */
    public SolverVariable[] f8265i;

    /* renamed from: j, reason: collision with root package name */
    public int f8266j;

    /* renamed from: k, reason: collision with root package name */
    public b f8267k;

    /* renamed from: l, reason: collision with root package name */
    public C1599a f8268l;

    /* compiled from: PriorityGoalRow.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<SolverVariable> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f8198c - solverVariable2.f8198c;
        }
    }

    /* compiled from: PriorityGoalRow.java */
    /* loaded from: classes.dex */
    public class b implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        public SolverVariable f8270a;

        /* renamed from: b, reason: collision with root package name */
        public d f8271b;

        public b(d dVar) {
            this.f8271b = dVar;
        }

        public boolean a(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (this.f8270a.f8196a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr = this.f8270a.f8204i;
                    float f11 = fArr[i10] + (solverVariable.f8204i[i10] * f10);
                    fArr[i10] = f11;
                    if (Math.abs(f11) < 1.0E-4f) {
                        this.f8270a.f8204i[i10] = 0.0f;
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    d.this.G(this.f8270a);
                }
                return false;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float f12 = solverVariable.f8204i[i11];
                if (f12 != 0.0f) {
                    float f13 = f12 * f10;
                    if (Math.abs(f13) < 1.0E-4f) {
                        f13 = 0.0f;
                    }
                    this.f8270a.f8204i[i11] = f13;
                } else {
                    this.f8270a.f8204i[i11] = 0.0f;
                }
            }
            return true;
        }

        public void b(SolverVariable solverVariable) {
            this.f8270a = solverVariable;
        }

        public final boolean c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f8270a.f8204i[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f8270a.f8198c - ((SolverVariable) obj).f8198c;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = solverVariable.f8204i[i10];
                float f11 = this.f8270a.f8204i[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f8270a.f8204i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f8270a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f8270a.f8204i[i10] + " ";
                }
            }
            return str + "] " + this.f8270a;
        }
    }

    public d(C1599a c1599a) {
        super(c1599a);
        this.f8263g = 128;
        this.f8264h = new SolverVariable[128];
        this.f8265i = new SolverVariable[128];
        this.f8266j = 0;
        this.f8267k = new b(this);
        this.f8268l = c1599a;
    }

    @Override // androidx.constraintlayout.solver.b
    public void B(c cVar, androidx.constraintlayout.solver.b bVar, boolean z10) {
        SolverVariable solverVariable = bVar.f8231a;
        if (solverVariable == null) {
            return;
        }
        b.a aVar = bVar.f8235e;
        int a10 = aVar.a();
        for (int i10 = 0; i10 < a10; i10++) {
            SolverVariable b10 = aVar.b(i10);
            float d10 = aVar.d(i10);
            this.f8267k.b(b10);
            if (this.f8267k.a(solverVariable, d10)) {
                F(b10);
            }
            this.f8232b += bVar.f8232b * d10;
        }
        G(solverVariable);
    }

    public final void F(SolverVariable solverVariable) {
        int i10;
        int i11 = this.f8266j + 1;
        SolverVariable[] solverVariableArr = this.f8264h;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f8264h = solverVariableArr2;
            this.f8265i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f8264h;
        int i12 = this.f8266j;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.f8266j = i13;
        if (i13 > 1 && solverVariableArr3[i12].f8198c > solverVariable.f8198c) {
            int i14 = 0;
            while (true) {
                i10 = this.f8266j;
                if (i14 >= i10) {
                    break;
                }
                this.f8265i[i14] = this.f8264h[i14];
                i14++;
            }
            Arrays.sort(this.f8265i, 0, i10, new a());
            for (int i15 = 0; i15 < this.f8266j; i15++) {
                this.f8264h[i15] = this.f8265i[i15];
            }
        }
        solverVariable.f8196a = true;
        solverVariable.a(this);
    }

    public final void G(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.f8266j) {
            if (this.f8264h[i10] == solverVariable) {
                while (true) {
                    int i11 = this.f8266j;
                    if (i10 < i11 - 1) {
                        SolverVariable[] solverVariableArr = this.f8264h;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    } else {
                        this.f8266j = i11 - 1;
                        solverVariable.f8196a = false;
                        return;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.b, androidx.constraintlayout.solver.c.a
    public void a(SolverVariable solverVariable) {
        this.f8267k.b(solverVariable);
        this.f8267k.e();
        solverVariable.f8204i[solverVariable.f8200e] = 1.0f;
        F(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.b, androidx.constraintlayout.solver.c.a
    public SolverVariable b(c cVar, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f8266j; i11++) {
            SolverVariable solverVariable = this.f8264h[i11];
            if (!zArr[solverVariable.f8198c]) {
                this.f8267k.b(solverVariable);
                if (i10 == -1) {
                    if (!this.f8267k.c()) {
                    }
                    i10 = i11;
                } else {
                    if (!this.f8267k.d(this.f8264h[i10])) {
                    }
                    i10 = i11;
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.f8264h[i10];
    }

    @Override // androidx.constraintlayout.solver.b, androidx.constraintlayout.solver.c.a
    public void clear() {
        this.f8266j = 0;
        this.f8232b = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.b, androidx.constraintlayout.solver.c.a
    public boolean isEmpty() {
        if (this.f8266j == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.b
    public String toString() {
        String str = " goal -> (" + this.f8232b + ") : ";
        for (int i10 = 0; i10 < this.f8266j; i10++) {
            this.f8267k.b(this.f8264h[i10]);
            str = str + this.f8267k + " ";
        }
        return str;
    }
}
