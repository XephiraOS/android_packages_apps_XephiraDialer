package S4;

import java.lang.reflect.Array;

/* compiled from: HybridBinarizer.java */
/* loaded from: classes3.dex */
public final class i extends g {

    /* renamed from: e, reason: collision with root package name */
    public b f3509e;

    public i(P4.c cVar) {
        super(cVar);
    }

    public static int[][] i(byte[] bArr, int i10, int i11, int i12, int i13) {
        char c10;
        int i14 = 8;
        int i15 = i13 - 8;
        int i16 = i12 - 8;
        char c11 = 2;
        boolean z10 = true;
        int i17 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i11, i10);
        int i18 = 0;
        while (i18 < i11) {
            int i19 = i18 << 3;
            if (i19 > i15) {
                i19 = i15;
            }
            int i20 = i17;
            while (i20 < i10) {
                int i21 = i20 << 3;
                if (i21 > i16) {
                    i21 = i16;
                }
                int i22 = (i19 * i12) + i21;
                int i23 = i17;
                int i24 = i23;
                int i25 = i24;
                int i26 = 255;
                while (i23 < i14) {
                    int i27 = i25;
                    int i28 = 0;
                    while (i28 < i14) {
                        int i29 = bArr[i22 + i28] & 255;
                        i24 += i29;
                        if (i29 < i26) {
                            i26 = i29;
                        }
                        if (i29 > i27) {
                            i27 = i29;
                        }
                        i28++;
                        i14 = 8;
                    }
                    if (i27 - i26 <= 24) {
                        i23++;
                        i22 += i12;
                        i25 = i27;
                        z10 = true;
                        i14 = 8;
                    }
                    while (true) {
                        i23++;
                        i22 += i12;
                        if (i23 < 8) {
                            int i30 = 0;
                            for (int i31 = 8; i30 < i31; i31 = 8) {
                                i24 += bArr[i22 + i30] & 255;
                                i30++;
                            }
                        }
                    }
                    i23++;
                    i22 += i12;
                    i25 = i27;
                    z10 = true;
                    i14 = 8;
                }
                boolean z11 = z10;
                int i32 = i24 >> 6;
                if (i25 - i26 <= 24) {
                    i32 = i26 / 2;
                    if (i18 > 0 && i20 > 0) {
                        int[] iArr2 = iArr[i18 - 1];
                        int i33 = i20 - 1;
                        c10 = 2;
                        int i34 = ((iArr2[i20] + (iArr[i18][i33] * 2)) + iArr2[i33]) / 4;
                        if (i26 < i34) {
                            i32 = i34;
                        }
                        iArr[i18][i20] = i32;
                        i20++;
                        z10 = z11;
                        c11 = c10;
                        i14 = 8;
                        i17 = 0;
                    }
                }
                c10 = 2;
                iArr[i18][i20] = i32;
                i20++;
                z10 = z11;
                c11 = c10;
                i14 = 8;
                i17 = 0;
            }
            i18++;
            i14 = 8;
            i17 = 0;
        }
        return iArr;
    }

    public static void j(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr, b bVar) {
        int i14;
        int i15;
        int i16 = i13 - 8;
        int i17 = i12 - 8;
        for (int i18 = 0; i18 < i11; i18++) {
            int i19 = i18 << 3;
            if (i19 > i16) {
                i14 = i16;
            } else {
                i14 = i19;
            }
            int k10 = k(i18, i11 - 3);
            for (int i20 = 0; i20 < i10; i20++) {
                int i21 = i20 << 3;
                if (i21 > i17) {
                    i15 = i17;
                } else {
                    i15 = i21;
                }
                int k11 = k(i20, i10 - 3);
                int i22 = 0;
                for (int i23 = -2; i23 <= 2; i23++) {
                    int[] iArr2 = iArr[k10 + i23];
                    i22 += iArr2[k11 - 2] + iArr2[k11 - 1] + iArr2[k11] + iArr2[k11 + 1] + iArr2[2 + k11];
                }
                l(bArr, i15, i14, i22 / 25, i12, bVar);
            }
        }
    }

    public static int k(int i10, int i11) {
        if (i10 < 2) {
            return 2;
        }
        if (i10 > i11) {
            return i11;
        }
        return i10;
    }

    public static void l(byte[] bArr, int i10, int i11, int i12, int i13, b bVar) {
        int i14 = (i11 * i13) + i10;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                if ((bArr[i14 + i16] & 255) <= i12) {
                    bVar.l(i10 + i16, i11 + i15);
                }
            }
            i15++;
            i14 += i13;
        }
    }

    @Override // P4.a
    public P4.a a(P4.c cVar) {
        return new i(cVar);
    }

    @Override // S4.g, P4.a
    public b b() {
        b bVar = this.f3509e;
        if (bVar != null) {
            return bVar;
        }
        P4.c e10 = e();
        int d10 = e10.d();
        int a10 = e10.a();
        if (d10 >= 40 && a10 >= 40) {
            byte[] b10 = e10.b();
            int i10 = d10 >> 3;
            if ((d10 & 7) != 0) {
                i10++;
            }
            int i11 = i10;
            int i12 = a10 >> 3;
            if ((a10 & 7) != 0) {
                i12++;
            }
            int i13 = i12;
            int[][] i14 = i(b10, i11, i13, d10, a10);
            b bVar2 = new b(d10, a10);
            j(b10, i11, i13, d10, a10, i14, bVar2);
            this.f3509e = bVar2;
        } else {
            this.f3509e = super.b();
        }
        return this.f3509e;
    }
}
