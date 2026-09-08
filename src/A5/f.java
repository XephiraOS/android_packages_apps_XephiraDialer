package a5;

import com.google.zxing.BarcodeFormat;

/* compiled from: EAN8Reader.java */
/* loaded from: classes3.dex */
public final class f extends q {

    /* renamed from: i, reason: collision with root package name */
    public final int[] f6415i = new int[4];

    @Override // a5.q
    public int k(S4.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6415i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int k10 = aVar.k();
        int i10 = iArr[1];
        for (int i11 = 0; i11 < 4 && i10 < k10; i11++) {
            sb.append((char) (q.i(aVar, iArr2, i10, q.f6440g) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        int i13 = q.m(aVar, i10, true, q.f6438e)[1];
        for (int i14 = 0; i14 < 4 && i13 < k10; i14++) {
            sb.append((char) (q.i(aVar, iArr2, i13, q.f6440g) + 48));
            for (int i15 : iArr2) {
                i13 += i15;
            }
        }
        return i13;
    }

    @Override // a5.q
    public BarcodeFormat p() {
        return BarcodeFormat.EAN_8;
    }
}
