package S3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;
import l5.C1294b;

/* compiled from: QRCodeWriter.kt */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public int f3468a = 1;

    public S4.b a(String contents, BarcodeFormat format, int i10, int i11, Map<EncodeHintType, ?> map) {
        kotlin.jvm.internal.i.f(contents, "contents");
        kotlin.jvm.internal.i.f(format, "format");
        if (contents.length() != 0) {
            if (format == BarcodeFormat.QR_CODE) {
                if (i10 >= 0 && i11 >= 0) {
                    ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
                    if (map != null) {
                        EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
                        if (map.containsKey(encodeHintType)) {
                            errorCorrectionLevel = ErrorCorrectionLevel.valueOf(String.valueOf(map.get(encodeHintType)));
                        }
                    }
                    l5.f code = l5.c.n(contents, errorCorrectionLevel, map);
                    kotlin.jvm.internal.i.e(code, "code");
                    return c(code, i10, i11);
                }
                throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + "x" + i11);
            }
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + format);
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    public final int b() {
        return this.f3468a;
    }

    public final S4.b c(l5.f fVar, int i10, int i11) {
        C1294b a10 = fVar.a();
        if (a10 != null) {
            int e10 = a10.e();
            int d10 = a10.d();
            int min = Math.min(Math.max(i10, e10) / e10, Math.max(i11, d10) / d10);
            this.f3468a = min;
            S4.b bVar = new S4.b(min * e10, min * d10);
            int i12 = 0;
            int i13 = 0;
            while (i12 < d10) {
                int i14 = 0;
                int i15 = 0;
                while (i14 < e10) {
                    if (a10.b(i14, i12) == 1) {
                        bVar.m(i15, i13, min, min);
                    }
                    i14++;
                    i15 += min;
                }
                i12++;
                i13 += min;
            }
            return bVar;
        }
        throw new IllegalStateException("Found empty input");
    }
}
