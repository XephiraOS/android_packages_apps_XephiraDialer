package a5;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* compiled from: OneDReader.java */
/* loaded from: classes3.dex */
public abstract class k implements P4.e {
    public static float d(int[] iArr, int[] iArr2, float f10) {
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

    public static void e(S4.a aVar, int i10, int[] iArr) {
        int length = iArr.length;
        int i11 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int k10 = aVar.k();
        if (i10 < k10) {
            boolean z10 = !aVar.g(i10);
            while (i10 < k10) {
                if (aVar.g(i10) != z10) {
                    iArr[i11] = iArr[i11] + 1;
                } else {
                    i11++;
                    if (i11 == length) {
                        break;
                    }
                    iArr[i11] = 1;
                    z10 = !z10;
                }
                i10++;
            }
            if (i11 != length) {
                if (i11 != length - 1 || i10 != k10) {
                    throw NotFoundException.a();
                }
                return;
            }
            return;
        }
        throw NotFoundException.a();
    }

    public static void f(S4.a aVar, int i10, int[] iArr) {
        int length = iArr.length;
        boolean g10 = aVar.g(i10);
        while (i10 > 0 && length >= 0) {
            i10--;
            if (aVar.g(i10) != g10) {
                length--;
                g10 = !g10;
            }
        }
        if (length < 0) {
            e(aVar, i10 + 1, iArr);
            return;
        }
        throw NotFoundException.a();
    }

    @Override // P4.e
    public P4.f a(P4.b bVar, Map<DecodeHintType, ?> map) {
        try {
            return c(bVar, map);
        } catch (NotFoundException e10) {
            if (map != null && map.containsKey(DecodeHintType.TRY_HARDER) && bVar.e()) {
                P4.b f10 = bVar.f();
                P4.f c10 = this.c(f10, map);
                Map<ResultMetadataType, Object> d10 = c10.d();
                int i10 = 270;
                if (d10 != null) {
                    ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                    if (d10.containsKey(resultMetadataType)) {
                        i10 = (((Integer) d10.get(resultMetadataType)).intValue() + 270) % 360;
                    }
                }
                c10.h(ResultMetadataType.ORIENTATION, Integer.valueOf(i10));
                P4.g[] e11 = c10.e();
                if (e11 != null) {
                    int c11 = f10.c();
                    for (int i11 = 0; i11 < e11.length; i11++) {
                        e11[i11] = new P4.g((c11 - e11[i11].d()) - 1.0f, e11[i11].c());
                    }
                }
                return c10;
            }
            throw e10;
        }
    }

    public abstract P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map);

    /* JADX WARN: Removed duplicated region for block: B:34:0x0077 A[Catch: ReaderException -> 0x00c8, TRY_LEAVE, TryCatch #3 {ReaderException -> 0x00c8, blocks: (B:32:0x0071, B:34:0x0077), top: B:31:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ce A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final P4.f c(P4.b r22, java.util.Map<com.google.zxing.DecodeHintType, ?> r23) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.k.c(P4.b, java.util.Map):P4.f");
    }

    @Override // P4.e
    public void reset() {
    }
}
