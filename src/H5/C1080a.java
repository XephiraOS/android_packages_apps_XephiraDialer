package h5;

import P4.g;
import com.google.zxing.DecodeHintType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Detector.java */
/* renamed from: h5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1080a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f32055a = {0, 4, 1, 5};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f32056b = {6, 2, 7, 3};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f32057c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f32058d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    public static void a(g[] gVarArr, g[] gVarArr2, int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            gVarArr[iArr[i10]] = gVarArr2[i10];
        }
    }

    public static C1081b b(P4.b bVar, Map<DecodeHintType, ?> map, boolean z10) {
        S4.b a10 = bVar.a();
        List<g[]> c10 = c(z10, a10);
        if (c10.isEmpty()) {
            a10 = a10.clone();
            a10.k();
            c10 = c(z10, a10);
        }
        return new C1081b(a10, c10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r3.hasNext() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r4 = (P4.g[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<P4.g[]> c(boolean r8, S4.b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
            r3 = r2
        L8:
            r4 = r3
        L9:
            int r5 = r9.g()
            if (r2 >= r5) goto L77
            P4.g[] r3 = f(r9, r2, r3)
            r5 = r3[r1]
            r6 = 1
            if (r5 != 0) goto L4f
            r5 = 3
            r7 = r3[r5]
            if (r7 != 0) goto L4f
            if (r4 == 0) goto L77
            java.util.Iterator r3 = r0.iterator()
        L23:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L4b
            java.lang.Object r4 = r3.next()
            P4.g[] r4 = (P4.g[]) r4
            r7 = r4[r6]
            if (r7 == 0) goto L3d
            float r2 = (float) r2
            float r7 = r7.d()
            float r2 = java.lang.Math.max(r2, r7)
            int r2 = (int) r2
        L3d:
            r4 = r4[r5]
            if (r4 == 0) goto L23
            float r4 = r4.d()
            int r4 = (int) r4
            int r2 = java.lang.Math.max(r2, r4)
            goto L23
        L4b:
            int r2 = r2 + 5
            r3 = r1
            goto L8
        L4f:
            r0.add(r3)
            if (r8 == 0) goto L77
            r2 = 2
            r4 = r3[r2]
            if (r4 == 0) goto L68
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
        L64:
            int r2 = (int) r2
            r3 = r4
            r4 = r6
            goto L9
        L68:
            r2 = 4
            r4 = r3[r2]
            float r4 = r4.c()
            int r4 = (int) r4
            r2 = r3[r2]
            float r2 = r2.d()
            goto L64
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.C1080a.c(boolean, S4.b):java.util.List");
    }

    public static int[] d(S4.b bVar, int i10, int i11, int i12, boolean z10, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i13 = 0;
        while (bVar.d(i10, i11) && i10 > 0) {
            int i14 = i13 + 1;
            if (i13 >= 3) {
                break;
            }
            i10--;
            i13 = i14;
        }
        int length = iArr.length;
        boolean z11 = z10;
        int i15 = 0;
        int i16 = i10;
        while (i10 < i12) {
            if (bVar.d(i10, i11) != z11) {
                iArr2[i15] = iArr2[i15] + 1;
            } else {
                if (i15 == length - 1) {
                    if (g(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i16, i10};
                    }
                    i16 += iArr2[0] + iArr2[1];
                    int i17 = i15 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i17);
                    iArr2[i17] = 0;
                    iArr2[i15] = 0;
                    i15--;
                } else {
                    i15++;
                }
                iArr2[i15] = 1;
                z11 = !z11;
            }
            i10++;
        }
        if (i15 == length - 1 && g(iArr2, iArr, 0.8f) < 0.42f) {
            return new int[]{i16, i10 - 1};
        }
        return null;
    }

    public static g[] e(S4.b bVar, int i10, int i11, int i12, int i13, int[] iArr) {
        boolean z10;
        int i14;
        int i15;
        g[] gVarArr = new g[4];
        int[] iArr2 = new int[iArr.length];
        int i16 = i12;
        while (true) {
            if (i16 < i10) {
                int[] d10 = d(bVar, i13, i16, i11, false, iArr, iArr2);
                if (d10 != null) {
                    int i17 = i16;
                    int[] iArr3 = d10;
                    while (i17 > 0) {
                        int i18 = i17 - 1;
                        int[] d11 = d(bVar, i13, i18, i11, false, iArr, iArr2);
                        if (d11 == null) {
                            break;
                        }
                        iArr3 = d11;
                        i17 = i18;
                    }
                    float f10 = i17;
                    gVarArr[0] = new g(iArr3[0], f10);
                    gVarArr[1] = new g(iArr3[1], f10);
                    z10 = true;
                    i16 = i17;
                } else {
                    i16 += 5;
                }
            } else {
                z10 = false;
                break;
            }
        }
        int i19 = i16 + 1;
        if (z10) {
            int[] iArr4 = {(int) gVarArr[0].c(), (int) gVarArr[1].c()};
            int i20 = i19;
            int i21 = 0;
            while (true) {
                if (i20 < i10) {
                    i14 = i21;
                    i15 = i20;
                    int[] d12 = d(bVar, iArr4[0], i20, i11, false, iArr, iArr2);
                    if (d12 != null && Math.abs(iArr4[0] - d12[0]) < 5 && Math.abs(iArr4[1] - d12[1]) < 5) {
                        iArr4 = d12;
                        i21 = 0;
                    } else {
                        if (i14 > 25) {
                            break;
                        }
                        i21 = i14 + 1;
                    }
                    i20 = i15 + 1;
                } else {
                    i14 = i21;
                    i15 = i20;
                    break;
                }
            }
            i19 = i15 - (i14 + 1);
            float f11 = i19;
            gVarArr[2] = new g(iArr4[0], f11);
            gVarArr[3] = new g(iArr4[1], f11);
        }
        if (i19 - i16 < 10) {
            Arrays.fill(gVarArr, (Object) null);
        }
        return gVarArr;
    }

    public static g[] f(S4.b bVar, int i10, int i11) {
        int g10 = bVar.g();
        int j10 = bVar.j();
        g[] gVarArr = new g[8];
        a(gVarArr, e(bVar, g10, j10, i10, i11, f32057c), f32055a);
        g gVar = gVarArr[4];
        if (gVar != null) {
            i11 = (int) gVar.c();
            i10 = (int) gVarArr[4].d();
        }
        a(gVarArr, e(bVar, g10, j10, i10, i11, f32058d), f32056b);
        return gVarArr;
    }

    public static float g(int[] iArr, int[] iArr2, float f10) {
        float f11;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f12 = i10;
        float f13 = f12 / i11;
        float f14 = f10 * f13;
        float f15 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f16 = iArr2[i13] * f13;
            float f17 = iArr[i13];
            if (f17 > f16) {
                f11 = f17 - f16;
            } else {
                f11 = f16 - f17;
            }
            if (f11 > f14) {
                return Float.POSITIVE_INFINITY;
            }
            f15 += f11;
        }
        return f15 / f12;
    }
}
