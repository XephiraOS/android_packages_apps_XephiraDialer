package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: _Arrays.kt */
/* renamed from: kotlin.collections.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1229j extends C1228i {
    public static <T> T A(T[] tArr, int i10) {
        int z10;
        kotlin.jvm.internal.i.f(tArr, "<this>");
        if (i10 >= 0) {
            z10 = z(tArr);
            if (i10 <= z10) {
                return tArr[i10];
            }
        }
        return null;
    }

    public static final int B(byte[] bArr, byte b10) {
        kotlin.jvm.internal.i.f(bArr, "<this>");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (b10 == bArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final int C(int[] iArr, int i10) {
        kotlin.jvm.internal.i.f(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final int D(long[] jArr, long j10) {
        kotlin.jvm.internal.i.f(jArr, "<this>");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (j10 == jArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final <T> int E(T[] tArr, T t10) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.i.b(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final int F(short[] sArr, short s10) {
        kotlin.jvm.internal.i.f(sArr, "<this>");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (s10 == sArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    public static final int G(int[] iArr, int i10) {
        kotlin.jvm.internal.i.f(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (i10 == iArr[length]) {
                    return length;
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return -1;
    }

    public static char H(char[] cArr) {
        kotlin.jvm.internal.i.f(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T I(T[] tArr) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> List<T> J(T[] tArr, int i10) {
        List<T> b10;
        List<T> K10;
        List<T> h10;
        kotlin.jvm.internal.i.f(tArr, "<this>");
        if (i10 >= 0) {
            if (i10 == 0) {
                h10 = o.h();
                return h10;
            }
            int length = tArr.length;
            if (i10 >= length) {
                K10 = K(tArr);
                return K10;
            }
            if (i10 == 1) {
                b10 = n.b(tArr[length - 1]);
                return b10;
            }
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = length - i10; i11 < length; i11++) {
                arrayList.add(tArr[i11]);
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> List<T> K(T[] tArr) {
        List<T> h10;
        List<T> b10;
        List<T> L10;
        kotlin.jvm.internal.i.f(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            h10 = o.h();
            return h10;
        }
        if (length != 1) {
            L10 = L(tArr);
            return L10;
        }
        b10 = n.b(tArr[0]);
        return b10;
    }

    public static <T> List<T> L(T[] tArr) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        return new ArrayList(o.e(tArr));
    }

    public static boolean q(byte[] bArr, byte b10) {
        kotlin.jvm.internal.i.f(bArr, "<this>");
        if (B(bArr, b10) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean r(int[] iArr, int i10) {
        kotlin.jvm.internal.i.f(iArr, "<this>");
        if (C(iArr, i10) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean s(long[] jArr, long j10) {
        kotlin.jvm.internal.i.f(jArr, "<this>");
        if (D(jArr, j10) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> boolean t(T[] tArr, T t10) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        if (E(tArr, t10) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean u(short[] sArr, short s10) {
        kotlin.jvm.internal.i.f(sArr, "<this>");
        if (F(sArr, s10) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> List<T> v(T[] tArr, int i10) {
        int b10;
        kotlin.jvm.internal.i.f(tArr, "<this>");
        if (i10 >= 0) {
            b10 = B9.i.b(tArr.length - i10, 0);
            return J(tArr, b10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> List<T> w(T[] tArr) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        return (List) x(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C x(T[] tArr, C destination) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        kotlin.jvm.internal.i.f(destination, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static int y(int[] iArr) {
        kotlin.jvm.internal.i.f(iArr, "<this>");
        return iArr.length - 1;
    }

    public static <T> int z(T[] tArr) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        return tArr.length - 1;
    }
}
