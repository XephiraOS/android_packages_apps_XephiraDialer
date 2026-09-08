package W4;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.datamatrix.decoder.DecodedBitStreamParser;
import com.heytap.accessory.constant.FastPairConstants;

/* compiled from: Decoder.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final U4.c f4195a = new U4.c(U4.a.f3857m);

    public final void a(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & FastPairConstants.GO_INTENT_NOT_SET;
        }
        try {
            this.f4195a.a(iArr, bArr.length - i10);
            for (int i12 = 0; i12 < i10; i12++) {
                bArr[i12] = (byte) iArr[i12];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.a();
        }
    }

    public S4.d b(S4.b bVar) {
        a aVar = new a(bVar);
        b[] b10 = b.b(aVar.c(), aVar.b());
        int i10 = 0;
        for (b bVar2 : b10) {
            i10 += bVar2.c();
        }
        byte[] bArr = new byte[i10];
        int length = b10.length;
        for (int i11 = 0; i11 < length; i11++) {
            b bVar3 = b10[i11];
            byte[] a10 = bVar3.a();
            int c10 = bVar3.c();
            a(a10, c10);
            for (int i12 = 0; i12 < c10; i12++) {
                bArr[(i12 * length) + i11] = a10[i12];
            }
        }
        return DecodedBitStreamParser.a(bArr);
    }
}
