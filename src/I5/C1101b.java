package i5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;
import l5.C1294b;
import l5.c;
import l5.f;

/* compiled from: QRCodeWriter.java */
/* renamed from: i5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1101b {
    public static S4.b b(f fVar, int i10, int i11, int i12) {
        C1294b a10 = fVar.a();
        if (a10 != null) {
            int e10 = a10.e();
            int d10 = a10.d();
            int i13 = i12 << 1;
            int i14 = e10 + i13;
            int i15 = i13 + d10;
            int max = Math.max(i10, i14);
            int max2 = Math.max(i11, i15);
            int min = Math.min(max / i14, max2 / i15);
            int i16 = (max - (e10 * min)) / 2;
            int i17 = (max2 - (d10 * min)) / 2;
            S4.b bVar = new S4.b(max, max2);
            int i18 = 0;
            while (i18 < d10) {
                int i19 = 0;
                int i20 = i16;
                while (i19 < e10) {
                    if (a10.b(i19, i18) == 1) {
                        bVar.m(i20, i17, min, min);
                    }
                    i19++;
                    i20 += min;
                }
                i18++;
                i17 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    public S4.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (!str.isEmpty()) {
            if (barcodeFormat == BarcodeFormat.QR_CODE) {
                if (i10 >= 0 && i11 >= 0) {
                    ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
                    int i12 = 4;
                    if (map != null) {
                        EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
                        if (map.containsKey(encodeHintType)) {
                            errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
                        }
                        EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
                        if (map.containsKey(encodeHintType2)) {
                            i12 = Integer.parseInt(map.get(encodeHintType2).toString());
                        }
                    }
                    return b(c.n(str, errorCorrectionLevel, map), i10, i11, i12);
                }
                throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + 'x' + i11);
            }
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
