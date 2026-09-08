package j5;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.Map;

/* compiled from: Decoder.java */
/* renamed from: j5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1165c {

    /* renamed from: a, reason: collision with root package name */
    public final U4.c f33876a = new U4.c(U4.a.f3856l);

    public final void a(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & FastPairConstants.GO_INTENT_NOT_SET;
        }
        try {
            this.f33876a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.a();
        }
    }

    public S4.d b(S4.b bVar, Map<DecodeHintType, ?> map) {
        ChecksumException e10;
        com.google.zxing.qrcode.decoder.a aVar = new com.google.zxing.qrcode.decoder.a(bVar);
        FormatException formatException = null;
        try {
            return c(aVar, map);
        } catch (ChecksumException e11) {
            e10 = e11;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                S4.d c10 = this.c(aVar, map);
                c10.m(new C1167e(true));
                return c10;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e10;
            }
        } catch (FormatException e12) {
            e10 = null;
            formatException = e12;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            S4.d c102 = this.c(aVar, map);
            c102.m(new C1167e(true));
            return c102;
        }
    }

    public final S4.d c(com.google.zxing.qrcode.decoder.a aVar, Map<DecodeHintType, ?> map) {
        f e10 = aVar.e();
        ErrorCorrectionLevel d10 = aVar.d().d();
        C1163a[] b10 = C1163a.b(aVar.c(), e10, d10);
        int i10 = 0;
        for (C1163a c1163a : b10) {
            i10 += c1163a.c();
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (C1163a c1163a2 : b10) {
            byte[] a10 = c1163a2.a();
            int c10 = c1163a2.c();
            a(a10, c10);
            int i12 = 0;
            while (i12 < c10) {
                bArr[i11] = a10[i12];
                i12++;
                i11++;
            }
        }
        return C1164b.a(bArr, e10, d10, map);
    }
}
