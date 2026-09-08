package T4;

import P4.g;
import com.google.zxing.NotFoundException;

/* compiled from: WhiteRectangleDetector.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final S4.b f3750a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3751b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3752c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3753d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3754e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3755f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3756g;

    public b(S4.b bVar) {
        this(bVar, 10, bVar.j() / 2, bVar.g() / 2);
    }

    public final g[] a(g gVar, g gVar2, g gVar3, g gVar4) {
        float c10 = gVar.c();
        float d10 = gVar.d();
        float c11 = gVar2.c();
        float d11 = gVar2.d();
        float c12 = gVar3.c();
        float d12 = gVar3.d();
        float c13 = gVar4.c();
        float d13 = gVar4.d();
        if (c10 < this.f3752c / 2.0f) {
            return new g[]{new g(c13 - 1.0f, d13 + 1.0f), new g(c11 + 1.0f, d11 + 1.0f), new g(c12 - 1.0f, d12 - 1.0f), new g(c10 + 1.0f, d10 - 1.0f)};
        }
        return new g[]{new g(c13 + 1.0f, d13 + 1.0f), new g(c11 + 1.0f, d11 - 1.0f), new g(c12 - 1.0f, d12 + 1.0f), new g(c10 - 1.0f, d10 - 1.0f)};
    }

    public final boolean b(int i10, int i11, int i12, boolean z10) {
        if (z10) {
            while (i10 <= i11) {
                if (this.f3750a.d(i10, i12)) {
                    return true;
                }
                i10++;
            }
            return false;
        }
        while (i10 <= i11) {
            if (this.f3750a.d(i12, i10)) {
                return true;
            }
            i10++;
        }
        return false;
    }

    public g[] c() {
        int i10 = this.f3753d;
        int i11 = this.f3754e;
        int i12 = this.f3756g;
        int i13 = this.f3755f;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = true;
        while (z15) {
            boolean z16 = false;
            boolean z17 = true;
            while (true) {
                if ((z17 || !z11) && i11 < this.f3752c) {
                    z17 = b(i12, i13, i11, false);
                    if (z17) {
                        i11++;
                        z11 = true;
                        z16 = true;
                    } else if (!z11) {
                        i11++;
                    }
                }
            }
            if (i11 < this.f3752c) {
                boolean z18 = true;
                while (true) {
                    if ((z18 || !z12) && i13 < this.f3751b) {
                        z18 = b(i10, i11, i13, true);
                        if (z18) {
                            i13++;
                            z12 = true;
                            z16 = true;
                        } else if (!z12) {
                            i13++;
                        }
                    }
                }
                if (i13 < this.f3751b) {
                    boolean z19 = true;
                    while (true) {
                        if ((z19 || !z13) && i10 >= 0) {
                            z19 = b(i12, i13, i10, false);
                            if (z19) {
                                i10--;
                                z13 = true;
                                z16 = true;
                            } else if (!z13) {
                                i10--;
                            }
                        }
                    }
                    if (i10 >= 0) {
                        z15 = z16;
                        boolean z20 = true;
                        while (true) {
                            if ((z20 || !z14) && i12 >= 0) {
                                z20 = b(i10, i11, i12, true);
                                if (z20) {
                                    i12--;
                                    z15 = true;
                                    z14 = true;
                                } else if (!z14) {
                                    i12--;
                                }
                            }
                        }
                        if (i12 < 0) {
                        }
                    }
                }
            }
            z10 = true;
            break;
        }
        if (!z10) {
            int i14 = i11 - i10;
            g gVar = null;
            g gVar2 = null;
            for (int i15 = 1; gVar2 == null && i15 < i14; i15++) {
                gVar2 = d(i10, i13 - i15, i10 + i15, i13);
            }
            if (gVar2 != null) {
                g gVar3 = null;
                for (int i16 = 1; gVar3 == null && i16 < i14; i16++) {
                    gVar3 = d(i10, i12 + i16, i10 + i16, i12);
                }
                if (gVar3 != null) {
                    g gVar4 = null;
                    for (int i17 = 1; gVar4 == null && i17 < i14; i17++) {
                        gVar4 = d(i11, i12 + i17, i11 - i17, i12);
                    }
                    if (gVar4 != null) {
                        for (int i18 = 1; gVar == null && i18 < i14; i18++) {
                            gVar = d(i11, i13 - i18, i11 - i18, i13);
                        }
                        if (gVar != null) {
                            return a(gVar, gVar2, gVar4, gVar3);
                        }
                        throw NotFoundException.a();
                    }
                    throw NotFoundException.a();
                }
                throw NotFoundException.a();
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public final g d(float f10, float f11, float f12, float f13) {
        int c10 = a.c(a.a(f10, f11, f12, f13));
        float f14 = c10;
        float f15 = (f12 - f10) / f14;
        float f16 = (f13 - f11) / f14;
        for (int i10 = 0; i10 < c10; i10++) {
            float f17 = i10;
            int c11 = a.c((f17 * f15) + f10);
            int c12 = a.c((f17 * f16) + f11);
            if (this.f3750a.d(c11, c12)) {
                return new g(c11, c12);
            }
        }
        return null;
    }

    public b(S4.b bVar, int i10, int i11, int i12) {
        this.f3750a = bVar;
        int g10 = bVar.g();
        this.f3751b = g10;
        int j10 = bVar.j();
        this.f3752c = j10;
        int i13 = i10 / 2;
        int i14 = i11 - i13;
        this.f3753d = i14;
        int i15 = i11 + i13;
        this.f3754e = i15;
        int i16 = i12 - i13;
        this.f3756g = i16;
        int i17 = i12 + i13;
        this.f3755f = i17;
        if (i16 < 0 || i14 < 0 || i17 >= g10 || i15 >= j10) {
            throw NotFoundException.a();
        }
    }
}
