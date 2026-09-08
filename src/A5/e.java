package a5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* compiled from: EAN13Reader.java */
/* loaded from: classes3.dex */
public final class e extends q {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f6413j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: i, reason: collision with root package name */
    public final int[] f6414i = new int[4];

    public static void r(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f6413j[i11]) {
                sb.insert(0, (char) (i11 + 48));
                return;
            }
        }
        throw NotFoundException.a();
    }

    @Override // a5.q
    public int k(S4.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6414i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int k10 = aVar.k();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < k10; i12++) {
            int i13 = q.i(aVar, iArr2, i10, q.f6441h);
            sb.append((char) ((i13 % 10) + 48));
            for (int i14 : iArr2) {
                i10 += i14;
            }
            if (i13 >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        r(sb, i11);
        int i15 = q.m(aVar, i10, true, q.f6438e)[1];
        for (int i16 = 0; i16 < 6 && i15 < k10; i16++) {
            sb.append((char) (q.i(aVar, iArr2, i15, q.f6440g) + 48));
            for (int i17 : iArr2) {
                i15 += i17;
            }
        }
        return i15;
    }

    @Override // a5.q
    public BarcodeFormat p() {
        return BarcodeFormat.EAN_13;
    }
}
