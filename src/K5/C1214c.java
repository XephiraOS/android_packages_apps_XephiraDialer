package k5;

import P4.g;
import P4.h;
import S4.f;
import S4.j;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import java.util.Map;

/* compiled from: Detector.java */
/* renamed from: k5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1214c {

    /* renamed from: a, reason: collision with root package name */
    public final S4.b f34153a;

    /* renamed from: b, reason: collision with root package name */
    public h f34154b;

    public C1214c(S4.b bVar) {
        this.f34153a = bVar;
    }

    public static int c(g gVar, g gVar2, g gVar3, float f10) {
        int c10 = (T4.a.c(g.b(gVar, gVar2) / f10) + T4.a.c(g.b(gVar, gVar3) / f10)) / 2;
        int i10 = c10 + 7;
        int i11 = i10 & 3;
        if (i11 != 0) {
            if (i11 != 2) {
                if (i11 == 3) {
                    throw NotFoundException.a();
                }
                return i10;
            }
            return c10 + 6;
        }
        return c10 + 8;
    }

    public static j d(g gVar, g gVar2, g gVar3, g gVar4, int i10) {
        float c10;
        float d10;
        float f10;
        float f11 = i10 - 3.5f;
        if (gVar4 != null) {
            c10 = gVar4.c();
            d10 = gVar4.d();
            f10 = f11 - 3.0f;
        } else {
            c10 = (gVar2.c() - gVar.c()) + gVar3.c();
            d10 = (gVar2.d() - gVar.d()) + gVar3.d();
            f10 = f11;
        }
        return j.b(3.5f, 3.5f, f11, 3.5f, f10, f10, 3.5f, f11, gVar.c(), gVar.d(), gVar2.c(), gVar2.d(), c10, d10, gVar3.c(), gVar3.d());
    }

    public static S4.b h(S4.b bVar, j jVar, int i10) {
        return S4.h.b().d(bVar, i10, i10, jVar);
    }

    public final float a(g gVar, g gVar2, g gVar3) {
        return (b(gVar, gVar2) + b(gVar, gVar3)) / 2.0f;
    }

    public final float b(g gVar, g gVar2) {
        float j10 = j((int) gVar.c(), (int) gVar.d(), (int) gVar2.c(), (int) gVar2.d());
        float j11 = j((int) gVar2.c(), (int) gVar2.d(), (int) gVar.c(), (int) gVar.d());
        if (Float.isNaN(j10)) {
            return j11 / 7.0f;
        }
        if (Float.isNaN(j11)) {
            return j10 / 7.0f;
        }
        return (j10 + j11) / 14.0f;
    }

    public final f e(Map<DecodeHintType, ?> map) {
        h hVar;
        if (map == null) {
            hVar = null;
        } else {
            hVar = (h) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.f34154b = hVar;
        return g(new FinderPatternFinder(this.f34153a, this.f34154b).f(map));
    }

    public final C1212a f(float f10, int i10, int i11, float f11) {
        int i12 = (int) (f11 * f10);
        int max = Math.max(0, i10 - i12);
        int min = Math.min(this.f34153a.j() - 1, i10 + i12) - max;
        float f12 = 3.0f * f10;
        if (min >= f12) {
            int max2 = Math.max(0, i11 - i12);
            int min2 = Math.min(this.f34153a.g() - 1, i11 + i12) - max2;
            if (min2 >= f12) {
                return new C1213b(this.f34153a, max, max2, min, min2, f10, this.f34154b).c();
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public final f g(e eVar) {
        C1212a c1212a;
        g[] gVarArr;
        d b10 = eVar.b();
        d c10 = eVar.c();
        d a10 = eVar.a();
        float a11 = a(b10, c10, a10);
        if (a11 >= 1.0f) {
            int c11 = c(b10, c10, a10, a11);
            j5.f g10 = j5.f.g(c11);
            int e10 = g10.e() - 7;
            if (g10.d().length > 0) {
                float c12 = (c10.c() - b10.c()) + a10.c();
                float d10 = (c10.d() - b10.d()) + a10.d();
                float f10 = 1.0f - (3.0f / e10);
                int c13 = (int) (b10.c() + ((c12 - b10.c()) * f10));
                int d11 = (int) (b10.d() + (f10 * (d10 - b10.d())));
                for (int i10 = 4; i10 <= 16; i10 <<= 1) {
                    try {
                        c1212a = f(a11, c13, d11, i10);
                        break;
                    } catch (NotFoundException unused) {
                    }
                }
            }
            c1212a = null;
            S4.b h10 = h(this.f34153a, d(b10, c10, a10, c1212a, c11), c11);
            if (c1212a == null) {
                gVarArr = new g[]{a10, b10, c10};
            } else {
                gVarArr = new g[]{a10, b10, c10, c1212a};
            }
            return new f(h10, gVarArr);
        }
        throw NotFoundException.a();
    }

    public final float i(int i10, int i11, int i12, int i13) {
        boolean z10;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        C1214c c1214c;
        boolean z11;
        int i23;
        int i24 = 1;
        if (Math.abs(i13 - i11) > Math.abs(i12 - i10)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i15 = i10;
            i14 = i11;
            i17 = i12;
            i16 = i13;
        } else {
            i14 = i10;
            i15 = i11;
            i16 = i12;
            i17 = i13;
        }
        int abs = Math.abs(i16 - i14);
        int abs2 = Math.abs(i17 - i15);
        int i25 = 2;
        int i26 = (-abs) / 2;
        int i27 = -1;
        if (i14 < i16) {
            i18 = 1;
        } else {
            i18 = -1;
        }
        if (i15 < i17) {
            i27 = 1;
        }
        int i28 = i16 + i18;
        int i29 = i14;
        int i30 = i15;
        int i31 = 0;
        while (true) {
            if (i29 != i28) {
                if (z10) {
                    i21 = i30;
                } else {
                    i21 = i29;
                }
                if (z10) {
                    i22 = i29;
                } else {
                    i22 = i30;
                }
                if (i31 == i24) {
                    z11 = z10;
                    i23 = i24;
                    i19 = i28;
                    c1214c = this;
                } else {
                    c1214c = this;
                    z11 = z10;
                    i19 = i28;
                    i23 = 0;
                }
                if (i23 == c1214c.f34153a.d(i21, i22)) {
                    if (i31 == 2) {
                        return T4.a.b(i29, i30, i14, i15);
                    }
                    i31++;
                }
                i26 += abs2;
                if (i26 > 0) {
                    if (i30 != i17) {
                        i30 += i27;
                        i26 -= abs;
                    } else {
                        i20 = 2;
                        break;
                    }
                }
                i29 += i18;
                i28 = i19;
                z10 = z11;
                i24 = 1;
                i25 = 2;
            } else {
                i19 = i28;
                i20 = i25;
                break;
            }
        }
        if (i31 == i20) {
            return T4.a.b(i19, i17, i14, i15);
        }
        return Float.NaN;
    }

    public final float j(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float i14 = i(i10, i11, i12, i13);
        int i15 = i10 - (i12 - i10);
        int i16 = 0;
        if (i15 < 0) {
            f10 = i10 / (i10 - i15);
            i15 = 0;
        } else if (i15 >= this.f34153a.j()) {
            f10 = ((this.f34153a.j() - 1) - i10) / (i15 - i10);
            i15 = this.f34153a.j() - 1;
        } else {
            f10 = 1.0f;
        }
        float f12 = i11;
        int i17 = (int) (f12 - ((i13 - i11) * f10));
        if (i17 < 0) {
            f11 = f12 / (i11 - i17);
        } else if (i17 >= this.f34153a.g()) {
            f11 = ((this.f34153a.g() - 1) - i11) / (i17 - i11);
            i16 = this.f34153a.g() - 1;
        } else {
            i16 = i17;
            f11 = 1.0f;
        }
        return (i14 + i(i10, i11, (int) (i10 + ((i15 - i10) * f11)), i16)) - 1.0f;
    }
}
