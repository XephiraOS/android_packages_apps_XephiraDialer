package X4;

import P4.g;
import S4.b;
import S4.f;
import S4.h;
import com.google.zxing.NotFoundException;

/* compiled from: Detector.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f4296a;

    /* renamed from: b, reason: collision with root package name */
    public final T4.b f4297b;

    public a(b bVar) {
        this.f4296a = bVar;
        this.f4297b = new T4.b(bVar);
    }

    public static g f(g gVar, float f10, float f11) {
        float f12;
        float f13;
        float c10 = gVar.c();
        float d10 = gVar.d();
        if (c10 < f10) {
            f12 = c10 - 1.0f;
        } else {
            f12 = c10 + 1.0f;
        }
        if (d10 < f11) {
            f13 = d10 - 1.0f;
        } else {
            f13 = d10 + 1.0f;
        }
        return new g(f12, f13);
    }

    public static b g(b bVar, g gVar, g gVar2, g gVar3, g gVar4, int i10, int i11) {
        float f10 = i10 - 0.5f;
        float f11 = i11 - 0.5f;
        return h.b().c(bVar, i10, i11, 0.5f, 0.5f, f10, 0.5f, f10, f11, 0.5f, f11, gVar.c(), gVar.d(), gVar4.c(), gVar4.d(), gVar3.c(), gVar3.d(), gVar2.c(), gVar2.d());
    }

    public static g h(g gVar, g gVar2, int i10) {
        float f10 = i10 + 1;
        return new g(gVar.c() + ((gVar2.c() - gVar.c()) / f10), gVar.d() + ((gVar2.d() - gVar.d()) / f10));
    }

    public final g a(g[] gVarArr) {
        g gVar = gVarArr[0];
        g gVar2 = gVarArr[1];
        g gVar3 = gVarArr[2];
        g gVar4 = gVarArr[3];
        int j10 = j(gVar, gVar4);
        g h10 = h(gVar, gVar2, (j(gVar2, gVar4) + 1) << 2);
        g h11 = h(gVar3, gVar2, (j10 + 1) << 2);
        int j11 = j(h10, gVar4);
        int j12 = j(h11, gVar4);
        float f10 = j11 + 1;
        g gVar5 = new g(gVar4.c() + ((gVar3.c() - gVar2.c()) / f10), gVar4.d() + ((gVar3.d() - gVar2.d()) / f10));
        float f11 = j12 + 1;
        g gVar6 = new g(gVar4.c() + ((gVar.c() - gVar2.c()) / f11), gVar4.d() + ((gVar.d() - gVar2.d()) / f11));
        if (!e(gVar5)) {
            if (e(gVar6)) {
                return gVar6;
            }
            return null;
        }
        if (!e(gVar6)) {
            return gVar5;
        }
        if (j(h10, gVar5) + j(h11, gVar5) > j(h10, gVar6) + j(h11, gVar6)) {
            return gVar5;
        }
        return gVar6;
    }

    public f b() {
        int i10;
        int i11;
        g[] d10 = d(c(this.f4297b.c()));
        g a10 = a(d10);
        d10[3] = a10;
        if (a10 != null) {
            g[] i12 = i(d10);
            g gVar = i12[0];
            g gVar2 = i12[1];
            g gVar3 = i12[2];
            g gVar4 = i12[3];
            int j10 = j(gVar, gVar4);
            int i13 = j10 + 1;
            int j11 = j(gVar3, gVar4);
            int i14 = j11 + 1;
            if ((i13 & 1) == 1) {
                i13 = j10 + 2;
            }
            if ((i14 & 1) == 1) {
                i14 = j11 + 2;
            }
            if (i13 * 4 < i14 * 7 && i14 * 4 < i13 * 7) {
                i10 = Math.max(i13, i14);
                i11 = i10;
            } else {
                i10 = i13;
                i11 = i14;
            }
            return new f(g(this.f4296a, gVar, gVar2, gVar3, gVar4, i10, i11), new g[]{gVar, gVar2, gVar3, gVar4});
        }
        throw NotFoundException.a();
    }

    public final g[] c(g[] gVarArr) {
        g gVar = gVarArr[0];
        g gVar2 = gVarArr[1];
        g gVar3 = gVarArr[3];
        g gVar4 = gVarArr[2];
        int j10 = j(gVar, gVar2);
        int j11 = j(gVar2, gVar3);
        int j12 = j(gVar3, gVar4);
        int j13 = j(gVar4, gVar);
        g[] gVarArr2 = {gVar4, gVar, gVar2, gVar3};
        if (j10 > j11) {
            gVarArr2[0] = gVar;
            gVarArr2[1] = gVar2;
            gVarArr2[2] = gVar3;
            gVarArr2[3] = gVar4;
            j10 = j11;
        }
        if (j10 > j12) {
            gVarArr2[0] = gVar2;
            gVarArr2[1] = gVar3;
            gVarArr2[2] = gVar4;
            gVarArr2[3] = gVar;
        } else {
            j12 = j10;
        }
        if (j12 > j13) {
            gVarArr2[0] = gVar3;
            gVarArr2[1] = gVar4;
            gVarArr2[2] = gVar;
            gVarArr2[3] = gVar2;
        }
        return gVarArr2;
    }

    public final g[] d(g[] gVarArr) {
        g gVar = gVarArr[0];
        g gVar2 = gVarArr[1];
        g gVar3 = gVarArr[2];
        g gVar4 = gVarArr[3];
        int j10 = (j(gVar, gVar4) + 1) << 2;
        if (j(h(gVar2, gVar3, j10), gVar) < j(h(gVar3, gVar2, j10), gVar4)) {
            gVarArr[0] = gVar;
            gVarArr[1] = gVar2;
            gVarArr[2] = gVar3;
            gVarArr[3] = gVar4;
        } else {
            gVarArr[0] = gVar2;
            gVarArr[1] = gVar3;
            gVarArr[2] = gVar4;
            gVarArr[3] = gVar;
        }
        return gVarArr;
    }

    public final boolean e(g gVar) {
        if (gVar.c() >= 0.0f && gVar.c() < this.f4296a.j() && gVar.d() > 0.0f && gVar.d() < this.f4296a.g()) {
            return true;
        }
        return false;
    }

    public final g[] i(g[] gVarArr) {
        g gVar = gVarArr[0];
        g gVar2 = gVarArr[1];
        g gVar3 = gVarArr[2];
        g gVar4 = gVarArr[3];
        int j10 = j(gVar, gVar4) + 1;
        g h10 = h(gVar, gVar2, (j(gVar3, gVar4) + 1) << 2);
        g h11 = h(gVar3, gVar2, j10 << 2);
        int j11 = j(h10, gVar4);
        int i10 = j11 + 1;
        int j12 = j(h11, gVar4);
        int i11 = j12 + 1;
        if ((i10 & 1) == 1) {
            i10 = j11 + 2;
        }
        if ((i11 & 1) == 1) {
            i11 = j12 + 2;
        }
        float c10 = (((gVar.c() + gVar2.c()) + gVar3.c()) + gVar4.c()) / 4.0f;
        float d10 = (((gVar.d() + gVar2.d()) + gVar3.d()) + gVar4.d()) / 4.0f;
        g f10 = f(gVar, c10, d10);
        g f11 = f(gVar2, c10, d10);
        g f12 = f(gVar3, c10, d10);
        g f13 = f(gVar4, c10, d10);
        int i12 = i11 << 2;
        int i13 = i10 << 2;
        return new g[]{h(h(f10, f11, i12), f13, i13), h(h(f11, f10, i12), f12, i13), h(h(f12, f13, i12), f11, i13), h(h(f13, f12, i12), f10, i13)};
    }

    public final int j(g gVar, g gVar2) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int c10 = (int) gVar.c();
        int d10 = (int) gVar.d();
        int c11 = (int) gVar2.c();
        int d11 = (int) gVar2.d();
        int i15 = 0;
        int i16 = 1;
        if (Math.abs(d11 - d10) > Math.abs(c11 - c10)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            d10 = c10;
            c10 = d10;
            d11 = c11;
            c11 = d11;
        }
        int abs = Math.abs(c11 - c10);
        int abs2 = Math.abs(d11 - d10);
        int i17 = (-abs) / 2;
        if (d10 < d11) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        if (c10 >= c11) {
            i16 = -1;
        }
        b bVar = this.f4296a;
        if (z10) {
            i11 = d10;
        } else {
            i11 = c10;
        }
        if (z10) {
            i12 = c10;
        } else {
            i12 = d10;
        }
        boolean d12 = bVar.d(i11, i12);
        while (c10 != c11) {
            b bVar2 = this.f4296a;
            if (z10) {
                i13 = d10;
            } else {
                i13 = c10;
            }
            if (z10) {
                i14 = c10;
            } else {
                i14 = d10;
            }
            boolean d13 = bVar2.d(i13, i14);
            if (d13 != d12) {
                i15++;
                d12 = d13;
            }
            i17 += abs2;
            if (i17 > 0) {
                if (d10 == d11) {
                    break;
                }
                d10 += i10;
                i17 -= abs;
            }
            c10 += i16;
        }
        return i15;
    }
}
