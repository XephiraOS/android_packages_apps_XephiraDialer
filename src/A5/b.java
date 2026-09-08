package a5;

import com.google.zxing.NotFoundException;

/* compiled from: Code128Reader.java */
/* loaded from: classes3.dex */
public final class b extends k {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f6402a;

    static {
        int[] iArr = new int[6];
        // fill-array-data instruction
        iArr[0] = 1;
        iArr[1] = 2;
        iArr[2] = 2;
        iArr[3] = 2;
        iArr[4] = 3;
        iArr[5] = 1;
        f6402a = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, iArr, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    }

    public static int g(S4.a aVar, int[] iArr, int i10) {
        k.e(aVar, i10, iArr);
        float f10 = 0.25f;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[][] iArr2 = f6402a;
            if (i12 >= iArr2.length) {
                break;
            }
            float d10 = k.d(iArr, iArr2[i12], 0.7f);
            if (d10 < f10) {
                i11 = i12;
                f10 = d10;
            }
            i12++;
        }
        if (i11 >= 0) {
            return i11;
        }
        throw NotFoundException.a();
    }

    public static int[] h(S4.a aVar) {
        int k10 = aVar.k();
        int i10 = aVar.i(0);
        int[] iArr = new int[6];
        boolean z10 = false;
        int i11 = 0;
        int i12 = i10;
        while (i10 < k10) {
            if (aVar.g(i10) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == 5) {
                    int i13 = -1;
                    float f10 = 0.25f;
                    for (int i14 = 103; i14 <= 105; i14++) {
                        float d10 = k.d(iArr, f6402a[i14], 0.7f);
                        if (d10 < f10) {
                            i13 = i14;
                            f10 = d10;
                        }
                    }
                    if (i13 >= 0 && aVar.m(Math.max(0, i12 - ((i10 - i12) / 2)), i12, false)) {
                        return new int[]{i12, i10, i13};
                    }
                    i12 += iArr[0] + iArr[1];
                    int i15 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i15);
                    iArr[i15] = 0;
                    iArr[i11] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            i10++;
        }
        throw NotFoundException.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00da, code lost:
    
        if (r3 != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dc, code lost:
    
        r3 = false;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0132, code lost:
    
        if (r3 != false) goto L56;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0086. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00bb. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:73:0x010e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:97:0x0151. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:105:0x009e A[PHI: r3 r5 r16 r20
  0x009e: PHI (r3v7 boolean) = 
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v14 boolean)
  (r3v15 boolean)
  (r3v16 boolean)
  (r3v17 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
  (r3v1 boolean)
 binds: [B:25:0x0086, B:73:0x010e, B:74:0x0112, B:78:0x011e, B:77:0x011a, B:65:0x00f3, B:51:0x00df, B:50:0x00dc, B:47:0x00d5, B:30:0x009d, B:39:0x00bb, B:40:0x00bf, B:44:0x00cb, B:43:0x00c7] A[DONT_GENERATE, DONT_INLINE]
  0x009e: PHI (r5v11 boolean) = 
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v14 boolean)
  (r5v15 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
  (r5v2 boolean)
 binds: [B:25:0x0086, B:73:0x010e, B:74:0x0112, B:78:0x011e, B:77:0x011a, B:65:0x00f3, B:51:0x00df, B:50:0x00dc, B:47:0x00d5, B:30:0x009d, B:39:0x00bb, B:40:0x00bf, B:44:0x00cb, B:43:0x00c7] A[DONT_GENERATE, DONT_INLINE]
  0x009e: PHI (r16v2 boolean) = 
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v5 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
  (r16v1 boolean)
 binds: [B:25:0x0086, B:73:0x010e, B:74:0x0112, B:78:0x011e, B:77:0x011a, B:65:0x00f3, B:51:0x00df, B:50:0x00dc, B:47:0x00d5, B:30:0x009d, B:39:0x00bb, B:40:0x00bf, B:44:0x00cb, B:43:0x00c7] A[DONT_GENERATE, DONT_INLINE]
  0x009e: PHI (r20v3 boolean) = 
  (r20v2 boolean)
  (r20v9 boolean)
  (r20v9 boolean)
  (r20v9 boolean)
  (r20v9 boolean)
  (r20v11 boolean)
  (r20v14 boolean)
  (r20v15 boolean)
  (r20v16 boolean)
  (r20v2 boolean)
  (r20v17 boolean)
  (r20v17 boolean)
  (r20v17 boolean)
  (r20v17 boolean)
 binds: [B:25:0x0086, B:73:0x010e, B:74:0x0112, B:78:0x011e, B:77:0x011a, B:65:0x00f3, B:51:0x00df, B:50:0x00dc, B:47:0x00d5, B:30:0x009d, B:39:0x00bb, B:40:0x00bf, B:44:0x00cb, B:43:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e8 A[PHI: r20
  0x00e8: PHI (r20v12 boolean) = (r20v9 boolean), (r20v17 boolean) binds: [B:73:0x010e, B:39:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // a5.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public P4.f b(int r26, S4.a r27, java.util.Map<com.google.zxing.DecodeHintType, ?> r28) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.b.b(int, S4.a, java.util.Map):P4.f");
    }
}
