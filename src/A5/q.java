package a5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader.java */
/* loaded from: classes3.dex */
public abstract class q extends k {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f6437d = {1, 1, 1};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f6438e = {1, 1, 1, 1, 1};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f6439f = {1, 1, 1, 1, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f6440g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[][] f6441h;

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f6442a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public final p f6443b = new p();

    /* renamed from: c, reason: collision with root package name */
    public final g f6444c = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f6440g = iArr;
        int[][] iArr2 = new int[20];
        f6441h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i10 = 10; i10 < 20; i10++) {
            int[] iArr3 = f6440g[i10 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i11 = 0; i11 < iArr3.length; i11++) {
                iArr4[i11] = iArr3[(iArr3.length - i11) - 1];
            }
            f6441h[i10] = iArr4;
        }
    }

    public static boolean h(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i10 = length - 1;
        if (q(charSequence.subSequence(0, i10)) != Character.digit(charSequence.charAt(i10), 10)) {
            return false;
        }
        return true;
    }

    public static int i(S4.a aVar, int[] iArr, int i10, int[][] iArr2) {
        k.e(aVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.48f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float d10 = k.d(iArr, iArr2[i12], 0.7f);
            if (d10 < f10) {
                i11 = i12;
                f10 = d10;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.a();
    }

    public static int[] m(S4.a aVar, int i10, boolean z10, int[] iArr) {
        return n(aVar, i10, z10, iArr, new int[iArr.length]);
    }

    public static int[] n(S4.a aVar, int i10, boolean z10, int[] iArr, int[] iArr2) {
        int i11;
        int k10 = aVar.k();
        if (z10) {
            i11 = aVar.j(i10);
        } else {
            i11 = aVar.i(i10);
        }
        int length = iArr.length;
        boolean z11 = z10;
        int i12 = 0;
        int i13 = i11;
        while (i11 < k10) {
            if (aVar.g(i11) != z11) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 == length - 1) {
                    if (k.d(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i13, i11};
                    }
                    i13 += iArr2[0] + iArr2[1];
                    int i14 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i12] = 0;
                    i12--;
                } else {
                    i12++;
                }
                iArr2[i12] = 1;
                z11 = !z11;
            }
            i11++;
        }
        throw NotFoundException.a();
    }

    public static int[] o(S4.a aVar) {
        int[] iArr = new int[f6437d.length];
        int[] iArr2 = null;
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            int[] iArr3 = f6437d;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = n(aVar, i10, false, iArr3, iArr);
            int i11 = iArr2[0];
            int i12 = iArr2[1];
            int i13 = i11 - (i12 - i11);
            if (i13 >= 0) {
                z10 = aVar.m(i13, i11, false);
            }
            i10 = i12;
        }
        return iArr2;
    }

    public static int q(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
            int charAt = charSequence.charAt(i11) - '0';
            if (charAt >= 0 && charAt <= 9) {
                i10 += charAt;
            } else {
                throw FormatException.a();
            }
        }
        int i12 = i10 * 3;
        for (int i13 = length - 2; i13 >= 0; i13 -= 2) {
            int charAt2 = charSequence.charAt(i13) - '0';
            if (charAt2 >= 0 && charAt2 <= 9) {
                i12 += charAt2;
            } else {
                throw FormatException.a();
            }
        }
        return (1000 - i12) % 10;
    }

    @Override // a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        return l(i10, aVar, o(aVar), map);
    }

    public boolean g(String str) {
        return h(str);
    }

    public int[] j(S4.a aVar, int i10) {
        return m(aVar, i10, false, f6437d);
    }

    public abstract int k(S4.a aVar, int[] iArr, StringBuilder sb);

    public P4.f l(int i10, S4.a aVar, int[] iArr, Map<DecodeHintType, ?> map) {
        P4.h hVar;
        int i11;
        String c10;
        int[] iArr2 = null;
        if (map == null) {
            hVar = null;
        } else {
            hVar = (P4.h) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        if (hVar != null) {
            hVar.a(new P4.g((iArr[0] + iArr[1]) / 2.0f, i10));
        }
        StringBuilder sb = this.f6442a;
        sb.setLength(0);
        int k10 = k(aVar, iArr, sb);
        if (hVar != null) {
            hVar.a(new P4.g(k10, i10));
        }
        int[] j10 = j(aVar, k10);
        if (hVar != null) {
            hVar.a(new P4.g((j10[0] + j10[1]) / 2.0f, i10));
        }
        int i12 = j10[1];
        int i13 = (i12 - j10[0]) + i12;
        if (i13 < aVar.k() && aVar.m(i12, i13, false)) {
            String sb2 = sb.toString();
            if (sb2.length() >= 8) {
                if (g(sb2)) {
                    BarcodeFormat p10 = p();
                    float f10 = i10;
                    P4.f fVar = new P4.f(sb2, null, new P4.g[]{new P4.g((iArr[1] + iArr[0]) / 2.0f, f10), new P4.g((j10[1] + j10[0]) / 2.0f, f10)}, p10);
                    try {
                        P4.f a10 = this.f6443b.a(i10, aVar, j10[1]);
                        fVar.h(ResultMetadataType.UPC_EAN_EXTENSION, a10.f());
                        fVar.g(a10.d());
                        fVar.a(a10.e());
                        i11 = a10.f().length();
                    } catch (ReaderException unused) {
                        i11 = 0;
                    }
                    if (map != null) {
                        iArr2 = (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
                    }
                    if (iArr2 != null) {
                        for (int i14 : iArr2) {
                            if (i11 != i14) {
                            }
                        }
                        throw NotFoundException.a();
                    }
                    if ((p10 == BarcodeFormat.EAN_13 || p10 == BarcodeFormat.UPC_A) && (c10 = this.f6444c.c(sb2)) != null) {
                        fVar.h(ResultMetadataType.POSSIBLE_COUNTRY, c10);
                    }
                    return fVar;
                }
                throw ChecksumException.a();
            }
            throw FormatException.a();
        }
        throw NotFoundException.a();
    }

    public abstract BarcodeFormat p();
}
