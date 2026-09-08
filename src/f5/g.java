package f5;

/* compiled from: DetectionResultRowIndicatorColumn.java */
/* loaded from: classes3.dex */
public final class g extends f {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f31751c;

    public g(c cVar, boolean z10) {
        super(cVar);
        this.f31751c = z10;
    }

    public void g(C1012a c1012a) {
        P4.g i10;
        P4.g c10;
        boolean z10;
        d[] d10 = d();
        m();
        l(d10, c1012a);
        c a10 = a();
        if (this.f31751c) {
            i10 = a10.h();
        } else {
            i10 = a10.i();
        }
        if (this.f31751c) {
            c10 = a10.b();
        } else {
            c10 = a10.c();
        }
        int e10 = e((int) c10.d());
        int i11 = -1;
        int i12 = 0;
        int i13 = 1;
        for (int e11 = e((int) i10.d()); e11 < e10; e11++) {
            d dVar = d10[e11];
            if (dVar != null) {
                int c11 = dVar.c() - i11;
                if (c11 == 0) {
                    i12++;
                } else {
                    if (c11 == 1) {
                        i13 = Math.max(i13, i12);
                        i11 = dVar.c();
                    } else if (c11 >= 0 && dVar.c() < c1012a.c() && c11 <= e11) {
                        if (i13 > 2) {
                            c11 *= i13 - 2;
                        }
                        if (c11 >= e11) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        for (int i14 = 1; i14 <= c11 && !z10; i14++) {
                            if (d10[e11 - i14] != null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        }
                        if (z10) {
                            d10[e11] = null;
                        } else {
                            i11 = dVar.c();
                        }
                    } else {
                        d10[e11] = null;
                    }
                    i12 = 1;
                }
            }
        }
    }

    public final void h(C1012a c1012a) {
        P4.g i10;
        P4.g c10;
        c a10 = a();
        if (this.f31751c) {
            i10 = a10.h();
        } else {
            i10 = a10.i();
        }
        if (this.f31751c) {
            c10 = a10.b();
        } else {
            c10 = a10.c();
        }
        int e10 = e((int) c10.d());
        d[] d10 = d();
        int i11 = -1;
        int i12 = 0;
        int i13 = 1;
        for (int e11 = e((int) i10.d()); e11 < e10; e11++) {
            d dVar = d10[e11];
            if (dVar != null) {
                dVar.j();
                int c11 = dVar.c() - i11;
                if (c11 == 0) {
                    i12++;
                } else {
                    if (c11 == 1) {
                        i13 = Math.max(i13, i12);
                        i11 = dVar.c();
                    } else if (dVar.c() >= c1012a.c()) {
                        d10[e11] = null;
                    } else {
                        i11 = dVar.c();
                    }
                    i12 = 1;
                }
            }
        }
    }

    public C1012a i() {
        d[] d10 = d();
        C1013b c1013b = new C1013b();
        C1013b c1013b2 = new C1013b();
        C1013b c1013b3 = new C1013b();
        C1013b c1013b4 = new C1013b();
        for (d dVar : d10) {
            if (dVar != null) {
                dVar.j();
                int e10 = dVar.e() % 30;
                int c10 = dVar.c();
                if (!this.f31751c) {
                    c10 += 2;
                }
                int i10 = c10 % 3;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            c1013b.b(e10 + 1);
                        }
                    } else {
                        c1013b4.b(e10 / 3);
                        c1013b3.b(e10 % 3);
                    }
                } else {
                    c1013b2.b((e10 * 3) + 1);
                }
            }
        }
        if (c1013b.a().length != 0 && c1013b2.a().length != 0 && c1013b3.a().length != 0 && c1013b4.a().length != 0 && c1013b.a()[0] > 0 && c1013b2.a()[0] + c1013b3.a()[0] >= 3 && c1013b2.a()[0] + c1013b3.a()[0] <= 90) {
            C1012a c1012a = new C1012a(c1013b.a()[0], c1013b2.a()[0], c1013b3.a()[0], c1013b4.a()[0]);
            l(d10, c1012a);
            return c1012a;
        }
        return null;
    }

    public int[] j() {
        int c10;
        C1012a i10 = i();
        if (i10 == null) {
            return null;
        }
        h(i10);
        int c11 = i10.c();
        int[] iArr = new int[c11];
        for (d dVar : d()) {
            if (dVar != null && (c10 = dVar.c()) < c11) {
                iArr[c10] = iArr[c10] + 1;
            }
        }
        return iArr;
    }

    public boolean k() {
        return this.f31751c;
    }

    public final void l(d[] dVarArr, C1012a c1012a) {
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            d dVar = dVarArr[i10];
            if (dVar != null) {
                int e10 = dVar.e() % 30;
                int c10 = dVar.c();
                if (c10 > c1012a.c()) {
                    dVarArr[i10] = null;
                } else {
                    if (!this.f31751c) {
                        c10 += 2;
                    }
                    int i11 = c10 % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 == 2 && e10 + 1 != c1012a.a()) {
                                dVarArr[i10] = null;
                            }
                        } else if (e10 / 3 != c1012a.b() || e10 % 3 != c1012a.d()) {
                            dVarArr[i10] = null;
                        }
                    } else if ((e10 * 3) + 1 != c1012a.e()) {
                        dVarArr[i10] = null;
                    }
                }
            }
        }
    }

    public final void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    @Override // f5.f
    public String toString() {
        return "IsLeft: " + this.f31751c + '\n' + super.toString();
    }
}
