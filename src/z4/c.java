package Z4;

import S4.d;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final U4.c f5951a = new U4.c(U4.a.f3859o);

    public final void a(byte[] bArr, int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = i11 + i12;
        if (i13 == 0) {
            i14 = 1;
        } else {
            i14 = 2;
        }
        int[] iArr = new int[i15 / i14];
        for (int i16 = 0; i16 < i15; i16++) {
            if (i13 == 0 || i16 % 2 == i13 - 1) {
                iArr[i16 / i14] = bArr[i16 + i10] & FastPairConstants.GO_INTENT_NOT_SET;
            }
        }
        try {
            this.f5951a.a(iArr, i12 / i14);
            for (int i17 = 0; i17 < i11; i17++) {
                if (i13 == 0 || i17 % 2 == i13 - 1) {
                    bArr[i17 + i10] = (byte) iArr[i17 / i14];
                }
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.a();
        }
    }

    public d b(S4.b bVar, Map<DecodeHintType, ?> map) {
        byte[] bArr;
        byte[] a10 = new a(bVar).a();
        a(a10, 0, 10, 10, 0);
        int i10 = a10[0] & FastPairConstants.GO_INTENT_MAX;
        if (i10 != 2 && i10 != 3 && i10 != 4) {
            if (i10 == 5) {
                a(a10, 20, 68, 56, 1);
                a(a10, 20, 68, 56, 2);
                bArr = new byte[78];
            } else {
                throw FormatException.a();
            }
        } else {
            a(a10, 20, 84, 40, 1);
            a(a10, 20, 84, 40, 2);
            bArr = new byte[94];
        }
        System.arraycopy(a10, 0, bArr, 0, 10);
        System.arraycopy(a10, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i10);
    }
}
