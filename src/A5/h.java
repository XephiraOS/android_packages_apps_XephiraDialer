package a5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* compiled from: ITFReader.java */
/* loaded from: classes3.dex */
public final class h extends k {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f6418b = {6, 8, 10, 12, 14};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f6419c = {1, 1, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    public static final int[][] f6420d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: e, reason: collision with root package name */
    public static final int[][] f6421e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    public int f6422a = -1;

    public static int g(int[] iArr) {
        int length = f6421e.length;
        float f10 = 0.38f;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            float d10 = k.d(iArr, f6421e[i11], 0.5f);
            if (d10 < f10) {
                i10 = i11;
                f10 = d10;
            } else if (d10 == f10) {
                i10 = -1;
            }
        }
        if (i10 >= 0) {
            return i10 % 10;
        }
        throw NotFoundException.a();
    }

    public static void i(S4.a aVar, int i10, int i11, StringBuilder sb) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i10 < i11) {
            k.e(aVar, i10, iArr);
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = i12 * 2;
                iArr2[i12] = iArr[i13];
                iArr3[i12] = iArr[i13 + 1];
            }
            sb.append((char) (g(iArr2) + 48));
            sb.append((char) (g(iArr3) + 48));
            for (int i14 = 0; i14 < 10; i14++) {
                i10 += iArr[i14];
            }
        }
    }

    public static int[] k(S4.a aVar, int i10, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int k10 = aVar.k();
        int i11 = i10;
        boolean z10 = false;
        int i12 = 0;
        while (i10 < k10) {
            if (aVar.g(i10) != z10) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 == length - 1) {
                    if (k.d(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i11, i10};
                    }
                    i11 += iArr2[0] + iArr2[1];
                    int i13 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i12] = 0;
                    i12--;
                } else {
                    i12++;
                }
                iArr2[i12] = 1;
                z10 = !z10;
            }
            i10++;
        }
        throw NotFoundException.a();
    }

    public static int l(S4.a aVar) {
        int k10 = aVar.k();
        int i10 = aVar.i(0);
        if (i10 != k10) {
            return i10;
        }
        throw NotFoundException.a();
    }

    @Override // a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        int[] iArr;
        boolean z10;
        int[] j10 = j(aVar);
        int[] h10 = h(aVar);
        StringBuilder sb = new StringBuilder(20);
        i(aVar, j10[1], h10[0], sb);
        String sb2 = sb.toString();
        if (map != null) {
            iArr = (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS);
        } else {
            iArr = null;
        }
        if (iArr == null) {
            iArr = f6418b;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 < length2) {
                int i13 = iArr[i11];
                if (length == i13) {
                    z10 = true;
                    break;
                }
                if (i13 > i12) {
                    i12 = i13;
                }
                i11++;
            } else {
                z10 = false;
                break;
            }
        }
        if ((!z10 && length > i12) || z10) {
            float f10 = i10;
            return new P4.f(sb2, null, new P4.g[]{new P4.g(j10[1], f10), new P4.g(h10[0], f10)}, BarcodeFormat.ITF);
        }
        throw FormatException.a();
    }

    public final int[] h(S4.a aVar) {
        int[] k10;
        aVar.o();
        try {
            int l10 = l(aVar);
            try {
                k10 = k(aVar, l10, f6420d[0]);
            } catch (NotFoundException unused) {
                k10 = k(aVar, l10, f6420d[1]);
            }
            m(aVar, k10[0]);
            int i10 = k10[0];
            k10[0] = aVar.k() - k10[1];
            k10[1] = aVar.k() - i10;
            return k10;
        } finally {
            aVar.o();
        }
    }

    public final int[] j(S4.a aVar) {
        int[] k10 = k(aVar, l(aVar), f6419c);
        int i10 = k10[1];
        int i11 = k10[0];
        this.f6422a = (i10 - i11) / 4;
        m(aVar, i11);
        return k10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(S4.a r2, int r3) {
        /*
            r1 = this;
            int r1 = r1.f6422a
            int r1 = r1 * 10
            if (r1 >= r3) goto L7
            goto L8
        L7:
            r1 = r3
        L8:
            int r3 = r3 + (-1)
        La:
            if (r1 <= 0) goto L19
            if (r3 < 0) goto L19
            boolean r0 = r2.g(r3)
            if (r0 != 0) goto L19
            int r1 = r1 + (-1)
            int r3 = r3 + (-1)
            goto La
        L19:
            if (r1 != 0) goto L1c
            return
        L1c:
            com.google.zxing.NotFoundException r1 = com.google.zxing.NotFoundException.a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.h.m(S4.a, int):void");
    }
}
