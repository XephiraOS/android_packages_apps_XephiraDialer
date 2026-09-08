package l5;

/* compiled from: MaskUtil.java */
/* loaded from: classes3.dex */
public final class d {
    public static int a(C1294b c1294b) {
        return b(c1294b, true) + b(c1294b, false);
    }

    public static int b(C1294b c1294b, boolean z10) {
        int e10;
        int d10;
        byte b10;
        if (z10) {
            e10 = c1294b.d();
        } else {
            e10 = c1294b.e();
        }
        if (z10) {
            d10 = c1294b.e();
        } else {
            d10 = c1294b.d();
        }
        byte[][] c10 = c1294b.c();
        int i10 = 0;
        for (int i11 = 0; i11 < e10; i11++) {
            byte b11 = -1;
            int i12 = 0;
            for (int i13 = 0; i13 < d10; i13++) {
                if (z10) {
                    b10 = c10[i11][i13];
                } else {
                    b10 = c10[i13][i11];
                }
                if (b10 == b11) {
                    i12++;
                } else {
                    if (i12 >= 5) {
                        i10 += i12 - 2;
                    }
                    i12 = 1;
                    b11 = b10;
                }
            }
            if (i12 >= 5) {
                i10 += i12 - 2;
            }
        }
        return i10;
    }

    public static int c(C1294b c1294b) {
        byte[][] c10 = c1294b.c();
        int e10 = c1294b.e();
        int d10 = c1294b.d();
        int i10 = 0;
        for (int i11 = 0; i11 < d10 - 1; i11++) {
            byte[] bArr = c10[i11];
            int i12 = 0;
            while (i12 < e10 - 1) {
                byte b10 = bArr[i12];
                int i13 = i12 + 1;
                if (b10 == bArr[i13]) {
                    byte[] bArr2 = c10[i11 + 1];
                    if (b10 == bArr2[i12] && b10 == bArr2[i13]) {
                        i10++;
                    }
                }
                i12 = i13;
            }
        }
        return i10 * 3;
    }

    public static int d(C1294b c1294b) {
        byte[][] c10 = c1294b.c();
        int e10 = c1294b.e();
        int d10 = c1294b.d();
        int i10 = 0;
        for (int i11 = 0; i11 < d10; i11++) {
            for (int i12 = 0; i12 < e10; i12++) {
                byte[] bArr = c10[i11];
                int i13 = i12 + 6;
                if (i13 < e10 && bArr[i12] == 1 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1 && bArr[i12 + 3] == 1 && bArr[i12 + 4] == 1 && bArr[i12 + 5] == 0 && bArr[i13] == 1 && (g(bArr, i12 - 4, i12) || g(bArr, i12 + 7, i12 + 11))) {
                    i10++;
                }
                int i14 = i11 + 6;
                if (i14 < d10 && c10[i11][i12] == 1 && c10[i11 + 1][i12] == 0 && c10[i11 + 2][i12] == 1 && c10[i11 + 3][i12] == 1 && c10[i11 + 4][i12] == 1 && c10[i11 + 5][i12] == 0 && c10[i14][i12] == 1 && (h(c10, i12, i11 - 4, i11) || h(c10, i12, i11 + 7, i11 + 11))) {
                    i10++;
                }
            }
        }
        return i10 * 40;
    }

    public static int e(C1294b c1294b) {
        byte[][] c10 = c1294b.c();
        int e10 = c1294b.e();
        int d10 = c1294b.d();
        int i10 = 0;
        for (int i11 = 0; i11 < d10; i11++) {
            byte[] bArr = c10[i11];
            for (int i12 = 0; i12 < e10; i12++) {
                if (bArr[i12] == 1) {
                    i10++;
                }
            }
        }
        int d11 = c1294b.d() * c1294b.e();
        return ((Math.abs((i10 << 1) - d11) * 10) / d11) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L30;
                case 1: goto L31;
                case 2: goto L38;
                case 3: goto L34;
                case 4: goto L2c;
                case 5: goto L25;
                case 6: goto L1e;
                case 7: goto L14;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L14:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
        L1c:
            r1 = r1 & r0
            goto L3a
        L1e:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L1c
        L25:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3a
        L2c:
            int r3 = r3 / 2
            int r2 = r2 / 3
        L30:
            int r3 = r3 + r2
        L31:
            r1 = r3 & 1
            goto L3a
        L34:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L3a
        L38:
            int r1 = r2 % 3
        L3a:
            if (r1 != 0) goto L3d
            return r0
        L3d:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.d.f(int, int, int):boolean");
    }

    public static boolean g(byte[] bArr, int i10, int i11) {
        int min = Math.min(i11, bArr.length);
        for (int max = Math.max(i10, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(byte[][] bArr, int i10, int i11, int i12) {
        int min = Math.min(i12, bArr.length);
        for (int max = Math.max(i11, 0); max < min; max++) {
            if (bArr[max][i10] == 1) {
                return false;
            }
        }
        return true;
    }
}
