package I;

import java.io.PrintWriter;

/* compiled from: TimeUtils.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f1300a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static char[] f1301b = new char[24];

    public static int a(int i10, int i11, boolean z10, int i12) {
        if (i10 <= 99 && (!z10 || i12 < 3)) {
            if (i10 <= 9 && (!z10 || i12 < 2)) {
                if (!z10 && i10 <= 0) {
                    return 0;
                }
                return i11 + 1;
            }
            return i11 + 2;
        }
        return i11 + 3;
    }

    public static void b(long j10, long j11, PrintWriter printWriter) {
        if (j10 == 0) {
            printWriter.print("--");
        } else {
            d(j10 - j11, printWriter, 0);
        }
    }

    public static void c(long j10, PrintWriter printWriter) {
        d(j10, printWriter, 0);
    }

    public static void d(long j10, PrintWriter printWriter, int i10) {
        synchronized (f1300a) {
            printWriter.print(new String(f1301b, 0, e(j10, i10)));
        }
    }

    public static int e(long j10, int i10) {
        char c10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z10;
        boolean z11;
        int i16;
        boolean z12;
        int i17;
        boolean z13;
        int i18;
        int i19;
        boolean z14;
        boolean z15;
        boolean z16;
        int i20;
        long j11 = j10;
        if (f1301b.length < i10) {
            f1301b = new char[i10];
        }
        char[] cArr = f1301b;
        if (j11 == 0) {
            int i21 = i10 - 1;
            while (i21 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j11 > 0) {
            c10 = '+';
        } else {
            j11 = -j11;
            c10 = '-';
        }
        int i22 = (int) (j11 % 1000);
        int floor = (int) Math.floor(j11 / 1000);
        if (floor > 86400) {
            i11 = floor / 86400;
            floor -= 86400 * i11;
        } else {
            i11 = 0;
        }
        if (floor > 3600) {
            i12 = floor / 3600;
            floor -= i12 * 3600;
        } else {
            i12 = 0;
        }
        if (floor > 60) {
            int i23 = floor / 60;
            i13 = floor - (i23 * 60);
            i14 = i23;
        } else {
            i13 = floor;
            i14 = 0;
        }
        if (i10 != 0) {
            int a10 = a(i11, 1, false, 0);
            if (a10 > 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            int a11 = a10 + a(i12, 1, z14, 2);
            if (a11 > 0) {
                z15 = true;
            } else {
                z15 = false;
            }
            int a12 = a11 + a(i14, 1, z15, 2);
            if (a12 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int a13 = a12 + a(i13, 1, z16, 2);
            if (a13 > 0) {
                i20 = 3;
            } else {
                i20 = 0;
            }
            i15 = 0;
            for (int a14 = a13 + a(i22, 2, true, i20) + 1; a14 < i10; a14++) {
                cArr[i15] = ' ';
                i15++;
            }
        } else {
            i15 = 0;
        }
        cArr[i15] = c10;
        int i24 = i15 + 1;
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int f10 = f(cArr, i11, 'd', i24, false, 0);
        if (f10 != i24) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        int f11 = f(cArr, i12, 'h', f10, z11, i16);
        if (f11 != i24) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z10) {
            i17 = 2;
        } else {
            i17 = 0;
        }
        int f12 = f(cArr, i14, 'm', f11, z12, i17);
        if (f12 != i24) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z10) {
            i18 = 2;
        } else {
            i18 = 0;
        }
        int f13 = f(cArr, i13, 's', f12, z13, i18);
        if (z10 && f13 != i24) {
            i19 = 3;
        } else {
            i19 = 0;
        }
        int f14 = f(cArr, i22, 'm', f13, true, i19);
        cArr[f14] = 's';
        return f14 + 1;
    }

    public static int f(char[] cArr, int i10, char c10, int i11, boolean z10, int i12) {
        int i13;
        if (z10 || i10 > 0) {
            if ((z10 && i12 >= 3) || i10 > 99) {
                int i14 = i10 / 100;
                cArr[i11] = (char) (i14 + 48);
                i13 = i11 + 1;
                i10 -= i14 * 100;
            } else {
                i13 = i11;
            }
            if ((z10 && i12 >= 2) || i10 > 9 || i11 != i13) {
                int i15 = i10 / 10;
                cArr[i13] = (char) (i15 + 48);
                i13++;
                i10 -= i15 * 10;
            }
            cArr[i13] = (char) (i10 + 48);
            cArr[i13 + 1] = c10;
            return i13 + 2;
        }
        return i11;
    }
}
