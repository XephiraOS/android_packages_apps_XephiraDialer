package l5;

import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.opencv.imgproc.Imgproc;

/* compiled from: MatrixUtil.java */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f34695a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    public static final int[][] f34696b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    public static final int[][] f34697c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, Imgproc.COLOR_BGRA2YUV_YV12, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, VibrateUtils.TYPE_STEPABLE_EDGE}, new int[]{6, 28, 54, 80, 106, Imgproc.COLOR_BGR2YUV_YV12, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d, reason: collision with root package name */
    public static final int[][] f34698d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(S4.a aVar, ErrorCorrectionLevel errorCorrectionLevel, j5.f fVar, int i10, C1294b c1294b) {
        c(c1294b);
        d(fVar, c1294b);
        l(errorCorrectionLevel, i10, c1294b);
        s(fVar, c1294b);
        f(aVar, i10, c1294b);
    }

    public static int b(int i10, int i11) {
        if (i11 != 0) {
            int n10 = n(i11);
            int i12 = i10 << (n10 - 1);
            while (n(i12) >= n10) {
                i12 ^= i11 << (n(i12) - n10);
            }
            return i12;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    public static void c(C1294b c1294b) {
        c1294b.a((byte) -1);
    }

    public static void d(j5.f fVar, C1294b c1294b) {
        j(c1294b);
        e(c1294b);
        r(fVar, c1294b);
        k(c1294b);
    }

    public static void e(C1294b c1294b) {
        if (c1294b.b(8, c1294b.d() - 8) != 0) {
            c1294b.f(8, c1294b.d() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    public static void f(S4.a aVar, int i10, C1294b c1294b) {
        boolean z10;
        int e10 = c1294b.e() - 1;
        int d10 = c1294b.d() - 1;
        int i11 = 0;
        int i12 = -1;
        while (e10 > 0) {
            if (e10 == 6) {
                e10--;
            }
            while (d10 >= 0 && d10 < c1294b.d()) {
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = e10 - i13;
                    if (o(c1294b.b(i14, d10))) {
                        if (i11 < aVar.k()) {
                            z10 = aVar.g(i11);
                            i11++;
                        } else {
                            z10 = false;
                        }
                        if (i10 != -1 && d.f(i10, i14, d10)) {
                            z10 = !z10;
                        }
                        c1294b.g(i14, d10, z10);
                    }
                }
                d10 += i12;
            }
            i12 = -i12;
            d10 += i12;
            e10 -= 2;
        }
        if (i11 == aVar.k()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i11 + '/' + aVar.k());
    }

    public static void g(int i10, int i11, C1294b c1294b) {
        for (int i12 = 0; i12 < 8; i12++) {
            int i13 = i10 + i12;
            if (o(c1294b.b(i13, i11))) {
                c1294b.f(i13, i11, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    public static void h(int i10, int i11, C1294b c1294b) {
        for (int i12 = 0; i12 < 5; i12++) {
            int[] iArr = f34696b[i12];
            for (int i13 = 0; i13 < 5; i13++) {
                c1294b.f(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    public static void i(int i10, int i11, C1294b c1294b) {
        for (int i12 = 0; i12 < 7; i12++) {
            int[] iArr = f34695a[i12];
            for (int i13 = 0; i13 < 7; i13++) {
                c1294b.f(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    public static void j(C1294b c1294b) {
        int length = f34695a[0].length;
        i(0, 0, c1294b);
        i(c1294b.e() - length, 0, c1294b);
        i(0, c1294b.e() - length, c1294b);
        g(0, 7, c1294b);
        g(c1294b.e() - 8, 7, c1294b);
        g(0, c1294b.e() - 8, c1294b);
        m(7, 0, c1294b);
        m(c1294b.d() - 8, 0, c1294b);
        m(7, c1294b.d() - 7, c1294b);
    }

    public static void k(C1294b c1294b) {
        int i10 = 8;
        while (i10 < c1294b.e() - 8) {
            int i11 = i10 + 1;
            int i12 = i11 % 2;
            if (o(c1294b.b(i10, 6))) {
                c1294b.f(i10, 6, i12);
            }
            if (o(c1294b.b(6, i10))) {
                c1294b.f(6, i10, i12);
            }
            i10 = i11;
        }
    }

    public static void l(ErrorCorrectionLevel errorCorrectionLevel, int i10, C1294b c1294b) {
        S4.a aVar = new S4.a();
        p(errorCorrectionLevel, i10, aVar);
        for (int i11 = 0; i11 < aVar.k(); i11++) {
            boolean g10 = aVar.g((aVar.k() - 1) - i11);
            int[] iArr = f34698d[i11];
            c1294b.g(iArr[0], iArr[1], g10);
            if (i11 < 8) {
                c1294b.g((c1294b.e() - i11) - 1, 8, g10);
            } else {
                c1294b.g(8, (c1294b.d() - 7) + (i11 - 8), g10);
            }
        }
    }

    public static void m(int i10, int i11, C1294b c1294b) {
        for (int i12 = 0; i12 < 7; i12++) {
            int i13 = i11 + i12;
            if (o(c1294b.b(i10, i13))) {
                c1294b.f(i10, i13, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    public static int n(int i10) {
        return 32 - Integer.numberOfLeadingZeros(i10);
    }

    public static boolean o(int i10) {
        if (i10 == -1) {
            return true;
        }
        return false;
    }

    public static void p(ErrorCorrectionLevel errorCorrectionLevel, int i10, S4.a aVar) {
        if (f.b(i10)) {
            int b10 = (errorCorrectionLevel.b() << 3) | i10;
            aVar.c(b10, 5);
            aVar.c(b(b10, 1335), 10);
            S4.a aVar2 = new S4.a();
            aVar2.c(21522, 15);
            aVar.s(aVar2);
            if (aVar.k() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + aVar.k());
        }
        throw new WriterException("Invalid mask pattern");
    }

    public static void q(j5.f fVar, S4.a aVar) {
        aVar.c(fVar.j(), 6);
        aVar.c(b(fVar.j(), 7973), 12);
        if (aVar.k() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar.k());
    }

    public static void r(j5.f fVar, C1294b c1294b) {
        if (fVar.j() < 2) {
            return;
        }
        int[] iArr = f34697c[fVar.j() - 1];
        for (int i10 : iArr) {
            if (i10 >= 0) {
                for (int i11 : iArr) {
                    if (i11 >= 0 && o(c1294b.b(i11, i10))) {
                        h(i11 - 2, i10 - 2, c1294b);
                    }
                }
            }
        }
    }

    public static void s(j5.f fVar, C1294b c1294b) {
        if (fVar.j() < 7) {
            return;
        }
        S4.a aVar = new S4.a();
        q(fVar, aVar);
        int i10 = 17;
        for (int i11 = 0; i11 < 6; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                boolean g10 = aVar.g(i10);
                i10--;
                c1294b.g(i11, (c1294b.d() - 11) + i12, g10);
                c1294b.g((c1294b.d() - 11) + i12, i11, g10);
            }
        }
    }
}
