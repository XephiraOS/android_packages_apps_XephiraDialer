package k5;

import P4.h;
import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder.java */
/* renamed from: k5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1213b {

    /* renamed from: a, reason: collision with root package name */
    public final S4.b f34144a;

    /* renamed from: c, reason: collision with root package name */
    public final int f34146c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34147d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34148e;

    /* renamed from: f, reason: collision with root package name */
    public final int f34149f;

    /* renamed from: g, reason: collision with root package name */
    public final float f34150g;

    /* renamed from: i, reason: collision with root package name */
    public final h f34152i;

    /* renamed from: b, reason: collision with root package name */
    public final List<C1212a> f34145b = new ArrayList(5);

    /* renamed from: h, reason: collision with root package name */
    public final int[] f34151h = new int[3];

    public C1213b(S4.b bVar, int i10, int i11, int i12, int i13, float f10, h hVar) {
        this.f34144a = bVar;
        this.f34146c = i10;
        this.f34147d = i11;
        this.f34148e = i12;
        this.f34149f = i13;
        this.f34150g = f10;
        this.f34152i = hVar;
    }

    public static float a(int[] iArr, int i10) {
        return (i10 - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final float b(int i10, int i11, int i12, int i13) {
        S4.b bVar = this.f34144a;
        int g10 = bVar.g();
        int[] iArr = this.f34151h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i14 = i10;
        while (i14 >= 0 && bVar.d(i11, i14)) {
            int i15 = iArr[1];
            if (i15 > i12) {
                break;
            }
            iArr[1] = i15 + 1;
            i14--;
        }
        if (i14 >= 0 && iArr[1] <= i12) {
            while (i14 >= 0 && !bVar.d(i11, i14)) {
                int i16 = iArr[0];
                if (i16 > i12) {
                    break;
                }
                iArr[0] = i16 + 1;
                i14--;
            }
            if (iArr[0] > i12) {
                return Float.NaN;
            }
            int i17 = i10 + 1;
            while (i17 < g10 && bVar.d(i11, i17)) {
                int i18 = iArr[1];
                if (i18 > i12) {
                    break;
                }
                iArr[1] = i18 + 1;
                i17++;
            }
            if (i17 != g10 && iArr[1] <= i12) {
                while (i17 < g10 && !bVar.d(i11, i17)) {
                    int i19 = iArr[2];
                    if (i19 > i12) {
                        break;
                    }
                    iArr[2] = i19 + 1;
                    i17++;
                }
                int i20 = iArr[2];
                if (i20 <= i12 && Math.abs(((iArr[0] + iArr[1]) + i20) - i13) * 5 < i13 * 2 && d(iArr)) {
                    return a(iArr, i17);
                }
            }
        }
        return Float.NaN;
    }

    public C1212a c() {
        int i10;
        C1212a e10;
        C1212a e11;
        int i11 = this.f34146c;
        int i12 = this.f34149f;
        int i13 = this.f34148e + i11;
        int i14 = this.f34147d + (i12 / 2);
        int[] iArr = new int[3];
        for (int i15 = 0; i15 < i12; i15++) {
            if ((i15 & 1) == 0) {
                i10 = (i15 + 1) / 2;
            } else {
                i10 = -((i15 + 1) / 2);
            }
            int i16 = i10 + i14;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i17 = i11;
            while (i17 < i13 && !this.f34144a.d(i17, i16)) {
                i17++;
            }
            int i18 = 0;
            while (i17 < i13) {
                if (this.f34144a.d(i17, i16)) {
                    if (i18 == 1) {
                        iArr[1] = iArr[1] + 1;
                    } else if (i18 == 2) {
                        if (d(iArr) && (e11 = e(iArr, i16, i17)) != null) {
                            return e11;
                        }
                        iArr[0] = iArr[2];
                        iArr[1] = 1;
                        iArr[2] = 0;
                        i18 = 1;
                    } else {
                        i18++;
                        iArr[i18] = iArr[i18] + 1;
                    }
                } else {
                    if (i18 == 1) {
                        i18++;
                    }
                    iArr[i18] = iArr[i18] + 1;
                }
                i17++;
            }
            if (d(iArr) && (e10 = e(iArr, i16, i13)) != null) {
                return e10;
            }
        }
        if (!this.f34145b.isEmpty()) {
            return this.f34145b.get(0);
        }
        throw NotFoundException.a();
    }

    public final boolean d(int[] iArr) {
        float f10 = this.f34150g;
        float f11 = f10 / 2.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            if (Math.abs(f10 - iArr[i10]) >= f11) {
                return false;
            }
        }
        return true;
    }

    public final C1212a e(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float a10 = a(iArr, i11);
        float b10 = b(i10, (int) a10, iArr[1] * 2, i12);
        if (!Float.isNaN(b10)) {
            float f10 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
            for (C1212a c1212a : this.f34145b) {
                if (c1212a.f(f10, b10, a10)) {
                    return c1212a.g(b10, a10, f10);
                }
            }
            C1212a c1212a2 = new C1212a(a10, b10, f10);
            this.f34145b.add(c1212a2);
            h hVar = this.f34152i;
            if (hVar != null) {
                hVar.a(c1212a2);
                return null;
            }
            return null;
        }
        return null;
    }
}
