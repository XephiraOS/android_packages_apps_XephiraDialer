package a5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* compiled from: UPCEReader.java */
/* loaded from: classes3.dex */
public final class r extends q {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f6445j = {1, 1, 1, 1, 1, 1};

    /* renamed from: k, reason: collision with root package name */
    public static final int[][] f6446k = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: i, reason: collision with root package name */
    public final int[] f6447i = new int[4];

    public static String r(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c10 = cArr[5];
        switch (c10) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c10);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c10);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    public static void s(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 <= 1; i11++) {
            for (int i12 = 0; i12 < 10; i12++) {
                if (i10 == f6446k[i11][i12]) {
                    sb.insert(0, (char) (i11 + 48));
                    sb.append((char) (i12 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.a();
    }

    @Override // a5.q
    public boolean g(String str) {
        return super.g(r(str));
    }

    @Override // a5.q
    public int[] j(S4.a aVar, int i10) {
        return q.m(aVar, i10, true, f6445j);
    }

    @Override // a5.q
    public int k(S4.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6447i;
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
        s(sb, i11);
        return i10;
    }

    @Override // a5.q
    public BarcodeFormat p() {
        return BarcodeFormat.UPC_E;
    }
}
