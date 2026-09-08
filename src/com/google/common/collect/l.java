package com.google.common.collect;

/* compiled from: Hashing.java */
/* loaded from: classes3.dex */
public final class l {
    public static int a(int i10, double d10) {
        int max = Math.max(i10, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (d10 * highestOneBit))) {
            int i11 = highestOneBit << 1;
            if (i11 <= 0) {
                return 1073741824;
            }
            return i11;
        }
        return highestOneBit;
    }

    public static boolean b(int i10, int i11, double d10) {
        if (i10 > d10 * i11 && i11 < 1073741824) {
            return true;
        }
        return false;
    }

    public static int c(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * (-862048943)), 15) * 461845907);
    }

    public static int d(Object obj) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return c(hashCode);
    }
}
