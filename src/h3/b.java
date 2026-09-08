package H3;

import com.heytap.accessory.constant.FastPairConstants;

/* compiled from: GuessEncoding.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1276a = false;

    /* renamed from: b, reason: collision with root package name */
    public static char[] f1277b = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 3, 3, 3, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0104 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H3.b.a(java.lang.String):java.lang.String");
    }

    public static boolean b(byte[] bArr, int i10) {
        int min = Math.min(i10, bArr.length);
        for (int i11 = 0; i11 < min; i11++) {
            int i12 = bArr[i11];
            if (i12 < 0) {
                i12 += 256;
            }
            if ((f1277b[i12] & 255) != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(byte[] bArr, int i10) {
        if (i10 < 2) {
            return false;
        }
        int i11 = bArr[0] & FastPairConstants.GO_INTENT_NOT_SET;
        int i12 = bArr[1] & FastPairConstants.GO_INTENT_NOT_SET;
        if (i11 < 161 || i11 > 249) {
            return false;
        }
        if ((i12 < 64 || i12 > 126) && (i12 < 161 || i12 > 254)) {
            return false;
        }
        return true;
    }

    public static boolean d(byte[] bArr, int i10) {
        if (i10 < 2) {
            return false;
        }
        int i11 = bArr[0] & FastPairConstants.GO_INTENT_NOT_SET;
        int i12 = bArr[1] & FastPairConstants.GO_INTENT_NOT_SET;
        if (i11 < 129 || i11 > 254 || i12 < 64 || i12 > 254 || i12 == 127) {
            return false;
        }
        return true;
    }

    public static int e(byte[] bArr, int i10) {
        if (i10 < 2) {
            return 0;
        }
        int i11 = bArr[0] & FastPairConstants.GO_INTENT_NOT_SET;
        int i12 = bArr[1] & FastPairConstants.GO_INTENT_NOT_SET;
        if (i11 == 255 && i12 == 254) {
            return 1;
        }
        if (i11 != 254 || i12 != 255) {
            return 0;
        }
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int f(byte[] bArr, int i10, int i11) {
        int i12;
        int min = Math.min(i11, bArr.length);
        boolean z10 = false;
        boolean z11 = false;
        loop0: while (i10 < min) {
            int i13 = bArr[i10];
            if ((i13 & 128) == 0) {
                if (i13 < 0) {
                    i13 += 256;
                }
                if (f1277b[i13] != 1) {
                    z11 = true;
                }
            } else {
                if ((i13 & 64) == 0) {
                    return -1;
                }
                if ((i13 & 32) == 0) {
                    i12 = 1;
                } else if ((i13 & 16) == 0) {
                    i12 = 2;
                } else if ((i13 & 8) == 0) {
                    i12 = 3;
                } else if ((i13 & 4) == 0) {
                    i12 = 4;
                } else {
                    if ((i13 & 2) != 0) {
                        return -1;
                    }
                    i12 = 5;
                }
                for (int i14 = 0; i14 < i12; i14++) {
                    i10++;
                    if (i10 >= min) {
                        break loop0;
                    }
                    char c10 = bArr[i10];
                    if ((c10 & 128) == 0 || (c10 & 64) != 0) {
                        return -1;
                    }
                }
                z10 = true;
            }
            i10++;
        }
        if (z11) {
            return 0;
        }
        if (z10) {
            return 2;
        }
        return 1;
    }

    public static int g(byte[] bArr, int i10) {
        int i11 = bArr[0] & FastPairConstants.GO_INTENT_NOT_SET;
        int i12 = bArr[1] & FastPairConstants.GO_INTENT_NOT_SET;
        int i13 = bArr[2] & FastPairConstants.GO_INTENT_NOT_SET;
        if (i10 > 3 && i11 == 239 && i12 == 187 && i13 == 191) {
            return f(bArr, 3, i10);
        }
        return -1;
    }
}
