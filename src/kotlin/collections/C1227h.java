package kotlin.collections;

import java.util.Arrays;
import n9.C1382c;

/* compiled from: Arrays.kt */
/* renamed from: kotlin.collections.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1227h extends C1226g {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean d(T[] tArr, T[] tArr2) {
        boolean d10;
        boolean b10;
        boolean a10;
        boolean c10;
        boolean d11;
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Object[] objArr = tArr[i10];
            Object[] objArr2 = tArr2[i10];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    d11 = d(objArr, objArr2);
                    if (!d11) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof m9.i) && (objArr2 instanceof m9.i)) {
                    c10 = C1382c.c(((m9.i) objArr).n(), ((m9.i) objArr2).n());
                    if (!c10) {
                        return false;
                    }
                } else if ((objArr instanceof m9.p) && (objArr2 instanceof m9.p)) {
                    a10 = C1382c.a(((m9.p) objArr).n(), ((m9.p) objArr2).n());
                    if (!a10) {
                        return false;
                    }
                } else if ((objArr instanceof m9.k) && (objArr2 instanceof m9.k)) {
                    b10 = C1382c.b(((m9.k) objArr).n(), ((m9.k) objArr2).n());
                    if (!b10) {
                        return false;
                    }
                } else if ((objArr instanceof m9.m) && (objArr2 instanceof m9.m)) {
                    d10 = C1382c.d(((m9.m) objArr).n(), ((m9.m) objArr2).n());
                    if (!d10) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.i.b(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
