package f5;

import e5.C0980a;
import java.lang.reflect.Array;

/* compiled from: PDF417CodewordDecoder.java */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final float[][] f31752a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, C0980a.f31615b.length, 8);

    static {
        int i10;
        int i11 = 0;
        while (true) {
            int[] iArr = C0980a.f31615b;
            if (i11 < iArr.length) {
                int i12 = iArr[i11];
                int i13 = i12 & 1;
                int i14 = 0;
                while (i14 < 8) {
                    float f10 = 0.0f;
                    while (true) {
                        i10 = i12 & 1;
                        if (i10 == i13) {
                            f10 += 1.0f;
                            i12 >>= 1;
                        }
                    }
                    f31752a[i11][7 - i14] = f10 / 17.0f;
                    i14++;
                    i13 = i10;
                }
                i11++;
            } else {
                return;
            }
        }
    }

    public static int a(int[] iArr) {
        long j10 = 0;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            for (int i11 = 0; i11 < iArr[i10]; i11++) {
                int i12 = 1;
                long j11 = j10 << 1;
                if (i10 % 2 != 0) {
                    i12 = 0;
                }
                j10 = j11 | i12;
            }
        }
        return (int) j10;
    }

    public static int b(int[] iArr) {
        int d10 = T4.a.d(iArr);
        float[] fArr = new float[8];
        if (d10 > 1) {
            for (int i10 = 0; i10 < 8; i10++) {
                fArr[i10] = iArr[i10] / d10;
            }
        }
        float f10 = Float.MAX_VALUE;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            float[][] fArr2 = f31752a;
            if (i12 < fArr2.length) {
                float[] fArr3 = fArr2[i12];
                float f11 = 0.0f;
                for (int i13 = 0; i13 < 8; i13++) {
                    float f12 = fArr3[i13] - fArr[i13];
                    f11 += f12 * f12;
                    if (f11 >= f10) {
                        break;
                    }
                }
                if (f11 < f10) {
                    i11 = C0980a.f31615b[i12];
                    f10 = f11;
                }
                i12++;
            } else {
                return i11;
            }
        }
    }

    public static int c(int[] iArr) {
        int a10 = a(iArr);
        if (C0980a.a(a10) == -1) {
            return -1;
        }
        return a10;
    }

    public static int d(int[] iArr) {
        int c10 = c(e(iArr));
        if (c10 != -1) {
            return c10;
        }
        return b(iArr);
    }

    public static int[] e(int[] iArr) {
        float d10 = T4.a.d(iArr);
        int[] iArr2 = new int[8];
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 17; i12++) {
            float f10 = (d10 / 34.0f) + ((i12 * d10) / 17.0f);
            int i13 = iArr[i11];
            if (i10 + i13 <= f10) {
                i10 += i13;
                i11++;
            }
            iArr2[i11] = iArr2[i11] + 1;
        }
        return iArr2;
    }
}
