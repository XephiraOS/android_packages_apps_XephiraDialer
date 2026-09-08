package com.google.common.collect;

import com.heytap.accessory.constant.FastPairConstants;
import java.util.Arrays;

/* compiled from: CompactHashing.java */
/* loaded from: classes3.dex */
public final class h {
    public static Object a(int i10) {
        if (i10 >= 2 && i10 <= 1073741824 && Integer.highestOneBit(i10) == i10) {
            if (i10 <= 256) {
                return new byte[i10];
            }
            if (i10 <= 65536) {
                return new short[i10];
            }
            return new int[i10];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i10);
    }

    public static int b(int i10, int i11) {
        return i10 & (~i11);
    }

    public static int c(int i10, int i11) {
        return i10 & i11;
    }

    public static int d(int i10, int i11, int i12) {
        return (i10 & (~i12)) | (i11 & i12);
    }

    public static int e(int i10) {
        int i11;
        if (i10 < 32) {
            i11 = 4;
        } else {
            i11 = 2;
        }
        return i11 * (i10 + 1);
    }

    public static int f(Object obj, Object obj2, int i10, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i11;
        int i12;
        int d10 = l.d(obj);
        int i13 = d10 & i10;
        int h10 = h(obj3, i13);
        if (h10 == 0) {
            return -1;
        }
        int b10 = b(d10, i10);
        int i14 = -1;
        while (true) {
            i11 = h10 - 1;
            i12 = iArr[i11];
            if (b(i12, i10) != b10 || !com.google.common.base.h.a(obj, objArr[i11]) || (objArr2 != null && !com.google.common.base.h.a(obj2, objArr2[i11]))) {
                int c10 = c(i12, i10);
                if (c10 == 0) {
                    return -1;
                }
                i14 = i11;
                h10 = c10;
            }
        }
        int c11 = c(i12, i10);
        if (i14 == -1) {
            i(obj3, i13, c11);
        } else {
            iArr[i14] = d(iArr[i14], c11, i10);
        }
        return i11;
    }

    public static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int h(Object obj, int i10) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i10] & FastPairConstants.GO_INTENT_NOT_SET;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i10] & 65535;
        }
        return ((int[]) obj)[i10];
    }

    public static void i(Object obj, int i10, int i11) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i10] = (byte) i11;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i10] = (short) i11;
        } else {
            ((int[]) obj)[i10] = i11;
        }
    }

    public static int j(int i10) {
        return Math.max(4, l.a(i10 + 1, 1.0d));
    }
}
