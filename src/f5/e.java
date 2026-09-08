package f5;

import java.util.Formatter;

/* compiled from: DetectionResult.java */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final C1012a f31745a;

    /* renamed from: b, reason: collision with root package name */
    public final f[] f31746b;

    /* renamed from: c, reason: collision with root package name */
    public c f31747c;

    /* renamed from: d, reason: collision with root package name */
    public final int f31748d;

    public e(C1012a c1012a, c cVar) {
        this.f31745a = c1012a;
        int a10 = c1012a.a();
        this.f31748d = a10;
        this.f31747c = cVar;
        this.f31746b = new f[a10 + 2];
    }

    public static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    public static int c(int i10, int i11, d dVar) {
        if (dVar == null) {
            return i11;
        }
        if (!dVar.g()) {
            if (dVar.h(i10)) {
                dVar.i(i10);
                return 0;
            }
            return i11 + 1;
        }
        return i11;
    }

    public final void a(f fVar) {
        if (fVar != null) {
            ((g) fVar).g(this.f31745a);
        }
    }

    public final int d() {
        int f10 = f();
        if (f10 == 0) {
            return 0;
        }
        for (int i10 = 1; i10 < this.f31748d + 1; i10++) {
            d[] d10 = this.f31746b[i10].d();
            for (int i11 = 0; i11 < d10.length; i11++) {
                d dVar = d10[i11];
                if (dVar != null && !dVar.g()) {
                    e(i10, i11, d10);
                }
            }
        }
        return f10;
    }

    public final void e(int i10, int i11, d[] dVarArr) {
        d[] dVarArr2;
        d dVar = dVarArr[i11];
        d[] d10 = this.f31746b[i10 - 1].d();
        f fVar = this.f31746b[i10 + 1];
        if (fVar != null) {
            dVarArr2 = fVar.d();
        } else {
            dVarArr2 = d10;
        }
        d[] dVarArr3 = new d[14];
        dVarArr3[2] = d10[i11];
        dVarArr3[3] = dVarArr2[i11];
        if (i11 > 0) {
            int i12 = i11 - 1;
            dVarArr3[0] = dVarArr[i12];
            dVarArr3[4] = d10[i12];
            dVarArr3[5] = dVarArr2[i12];
        }
        if (i11 > 1) {
            int i13 = i11 - 2;
            dVarArr3[8] = dVarArr[i13];
            dVarArr3[10] = d10[i13];
            dVarArr3[11] = dVarArr2[i13];
        }
        if (i11 < dVarArr.length - 1) {
            int i14 = i11 + 1;
            dVarArr3[1] = dVarArr[i14];
            dVarArr3[6] = d10[i14];
            dVarArr3[7] = dVarArr2[i14];
        }
        if (i11 < dVarArr.length - 2) {
            int i15 = i11 + 2;
            dVarArr3[9] = dVarArr[i15];
            dVarArr3[12] = d10[i15];
            dVarArr3[13] = dVarArr2[i15];
        }
        for (int i16 = 0; i16 < 14 && !b(dVar, dVarArr3[i16]); i16++) {
        }
    }

    public final int f() {
        g();
        return h() + i();
    }

    public final void g() {
        f[] fVarArr = this.f31746b;
        f fVar = fVarArr[0];
        if (fVar != null && fVarArr[this.f31748d + 1] != null) {
            d[] d10 = fVar.d();
            d[] d11 = this.f31746b[this.f31748d + 1].d();
            for (int i10 = 0; i10 < d10.length; i10++) {
                d dVar = d10[i10];
                if (dVar != null && d11[i10] != null && dVar.c() == d11[i10].c()) {
                    for (int i11 = 1; i11 <= this.f31748d; i11++) {
                        d dVar2 = this.f31746b[i11].d()[i10];
                        if (dVar2 != null) {
                            dVar2.i(d10[i10].c());
                            if (!dVar2.g()) {
                                this.f31746b[i11].d()[i10] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    public final int h() {
        f fVar = this.f31746b[0];
        if (fVar == null) {
            return 0;
        }
        d[] d10 = fVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < d10.length; i11++) {
            d dVar = d10[i11];
            if (dVar != null) {
                int c10 = dVar.c();
                int i12 = 0;
                for (int i13 = 1; i13 < this.f31748d + 1 && i12 < 2; i13++) {
                    d dVar2 = this.f31746b[i13].d()[i11];
                    if (dVar2 != null) {
                        i12 = c(c10, i12, dVar2);
                        if (!dVar2.g()) {
                            i10++;
                        }
                    }
                }
            }
        }
        return i10;
    }

    public final int i() {
        f[] fVarArr = this.f31746b;
        int i10 = this.f31748d;
        if (fVarArr[i10 + 1] == null) {
            return 0;
        }
        d[] d10 = fVarArr[i10 + 1].d();
        int i11 = 0;
        for (int i12 = 0; i12 < d10.length; i12++) {
            d dVar = d10[i12];
            if (dVar != null) {
                int c10 = dVar.c();
                int i13 = 0;
                for (int i14 = this.f31748d + 1; i14 > 0 && i13 < 2; i14--) {
                    d dVar2 = this.f31746b[i14].d()[i12];
                    if (dVar2 != null) {
                        i13 = c(c10, i13, dVar2);
                        if (!dVar2.g()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    public int j() {
        return this.f31748d;
    }

    public int k() {
        return this.f31745a.b();
    }

    public int l() {
        return this.f31745a.c();
    }

    public c m() {
        return this.f31747c;
    }

    public f n(int i10) {
        return this.f31746b[i10];
    }

    public f[] o() {
        a(this.f31746b[0]);
        a(this.f31746b[this.f31748d + 1]);
        int i10 = 928;
        while (true) {
            int d10 = d();
            if (d10 <= 0 || d10 >= i10) {
                break;
            }
            i10 = d10;
        }
        return this.f31746b;
    }

    public void p(c cVar) {
        this.f31747c = cVar;
    }

    public void q(int i10, f fVar) {
        this.f31746b[i10] = fVar;
    }

    public String toString() {
        f[] fVarArr = this.f31746b;
        f fVar = fVarArr[0];
        if (fVar == null) {
            fVar = fVarArr[this.f31748d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < fVar.d().length; i10++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i10));
                for (int i11 = 0; i11 < this.f31748d + 2; i11++) {
                    f fVar2 = this.f31746b[i11];
                    if (fVar2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = fVar2.d()[i10];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
