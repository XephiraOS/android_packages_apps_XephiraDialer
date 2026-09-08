package B;

import android.graphics.Color;
import com.coui.appcompat.uiutil.UIUtil;

/* compiled from: ColorUtils.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<double[]> f205a = new ThreadLocal<>();

    public static int a(float[] fArr) {
        int round;
        int round2;
        int round3;
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float abs = (1.0f - Math.abs((f12 * 2.0f) - 1.0f)) * f11;
        float f13 = f12 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f10 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f10) / 60) {
            case 0:
                round = Math.round((abs + f13) * 255.0f);
                round2 = Math.round((abs2 + f13) * 255.0f);
                round3 = Math.round(f13 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f13) * 255.0f);
                round2 = Math.round((abs + f13) * 255.0f);
                round3 = Math.round(f13 * 255.0f);
                break;
            case 2:
                round = Math.round(f13 * 255.0f);
                round2 = Math.round((abs + f13) * 255.0f);
                round3 = Math.round((abs2 + f13) * 255.0f);
                break;
            case 3:
                round = Math.round(f13 * 255.0f);
                round2 = Math.round((abs2 + f13) * 255.0f);
                round3 = Math.round((abs + f13) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f13) * 255.0f);
                round2 = Math.round(f13 * 255.0f);
                round3 = Math.round((abs + f13) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f13) * 255.0f);
                round2 = Math.round(f13 * 255.0f);
                round3 = Math.round((abs2 + f13) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(t(round, 0, 255), t(round2, 0, 255), t(round3, 0, 255));
    }

    public static int b(double d10, double d11, double d12) {
        double[] u10 = u();
        c(d10, d11, d12, u10);
        return g(u10[0], u10[1], u10[2]);
    }

    public static void c(double d10, double d11, double d12, double[] dArr) {
        double d13;
        double d14 = (d10 + 16.0d) / 116.0d;
        double d15 = (d11 / 500.0d) + d14;
        double d16 = d14 - (d12 / 200.0d);
        double pow = Math.pow(d15, 3.0d);
        if (pow <= 0.008856d) {
            pow = ((d15 * 116.0d) - 16.0d) / 903.3d;
        }
        if (d10 > 7.9996247999999985d) {
            d13 = Math.pow(d14, 3.0d);
        } else {
            d13 = d10 / 903.3d;
        }
        double pow2 = Math.pow(d16, 3.0d);
        if (pow2 <= 0.008856d) {
            pow2 = ((d16 * 116.0d) - 16.0d) / 903.3d;
        }
        dArr[0] = pow * 95.047d;
        dArr[1] = d13 * 100.0d;
        dArr[2] = pow2 * 108.883d;
    }

    public static void d(int i10, int i11, int i12, float[] fArr) {
        float f10;
        float abs;
        float f11 = i10 / 255.0f;
        float f12 = i11 / 255.0f;
        float f13 = i12 / 255.0f;
        float max = Math.max(f11, Math.max(f12, f13));
        float min = Math.min(f11, Math.min(f12, f13));
        float f14 = max - min;
        float f15 = (max + min) / 2.0f;
        if (max == min) {
            f10 = 0.0f;
            abs = 0.0f;
        } else {
            if (max == f11) {
                f10 = ((f12 - f13) / f14) % 6.0f;
            } else if (max == f12) {
                f10 = ((f13 - f11) / f14) + 2.0f;
            } else {
                f10 = 4.0f + ((f11 - f12) / f14);
            }
            abs = f14 / (1.0f - Math.abs((2.0f * f15) - 1.0f));
        }
        float f16 = (f10 * 60.0f) % 360.0f;
        if (f16 < 0.0f) {
            f16 += 360.0f;
        }
        fArr[0] = s(f16, 0.0f, 360.0f);
        fArr[1] = s(abs, 0.0f, 1.0f);
        fArr[2] = s(f15, 0.0f, 1.0f);
    }

    public static void e(int i10, int i11, int i12, double[] dArr) {
        f(i10, i11, i12, dArr);
        h(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void f(int i10, int i11, int i12, double[] dArr) {
        double pow;
        double pow2;
        double pow3;
        if (dArr.length == 3) {
            double d10 = i10 / 255.0d;
            if (d10 < 0.04045d) {
                pow = d10 / 12.92d;
            } else {
                pow = Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
            }
            double d11 = i11 / 255.0d;
            if (d11 < 0.04045d) {
                pow2 = d11 / 12.92d;
            } else {
                pow2 = Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
            }
            double d12 = i12 / 255.0d;
            if (d12 < 0.04045d) {
                pow3 = d12 / 12.92d;
            } else {
                pow3 = Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
            }
            dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
            dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
            dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int g(double d10, double d11, double d12) {
        double d13;
        double d14;
        double d15;
        double d16 = (((3.2406d * d10) + ((-1.5372d) * d11)) + ((-0.4986d) * d12)) / 100.0d;
        double d17 = ((((-0.9689d) * d10) + (1.8758d * d11)) + (0.0415d * d12)) / 100.0d;
        double d18 = (((0.0557d * d10) + ((-0.204d) * d11)) + (1.057d * d12)) / 100.0d;
        if (d16 > 0.0031308d) {
            d13 = (Math.pow(d16, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d13 = d16 * 12.92d;
        }
        if (d17 > 0.0031308d) {
            d14 = (Math.pow(d17, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d14 = d17 * 12.92d;
        }
        if (d18 > 0.0031308d) {
            d15 = (Math.pow(d18, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d15 = d18 * 12.92d;
        }
        return Color.rgb(t((int) Math.round(d13 * 255.0d), 0, 255), t((int) Math.round(d14 * 255.0d), 0, 255), t((int) Math.round(d15 * 255.0d), 0, 255));
    }

    public static void h(double d10, double d11, double d12, double[] dArr) {
        if (dArr.length == 3) {
            double v10 = v(d10 / 95.047d);
            double v11 = v(d11 / 100.0d);
            double v12 = v(d12 / 108.883d);
            dArr[0] = Math.max(0.0d, (116.0d * v11) - 16.0d);
            dArr[1] = (v10 - v11) * 500.0d;
            dArr[2] = (v11 - v12) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    public static int i(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb((int) ((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), (int) ((Color.red(i10) * f11) + (Color.red(i11) * f10)), (int) ((Color.green(i10) * f11) + (Color.green(i11) * f10)), (int) ((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    public static double j(int i10, int i11) {
        if (Color.alpha(i11) == 255) {
            if (Color.alpha(i10) < 255) {
                i10 = q(i10, i11);
            }
            double k10 = k(i10) + 0.05d;
            double k11 = k(i11) + 0.05d;
            return Math.max(k10, k11) / Math.min(k10, k11);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i11));
    }

    public static double k(int i10) {
        double[] u10 = u();
        o(i10, u10);
        return u10[1] / 100.0d;
    }

    public static int l(int i10, int i11, float f10) {
        int i12 = 255;
        if (Color.alpha(i11) == 255) {
            double d10 = f10;
            if (j(w(i10, 255), i11) < d10) {
                return -1;
            }
            int i13 = 0;
            for (int i14 = 0; i14 <= 10 && i12 - i13 > 1; i14++) {
                int i15 = (i13 + i12) / 2;
                if (j(w(i10, i15), i11) < d10) {
                    i13 = i15;
                } else {
                    i12 = i15;
                }
            }
            return i12;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i11));
    }

    public static void m(int i10, float[] fArr) {
        d(Color.red(i10), Color.green(i10), Color.blue(i10), fArr);
    }

    public static void n(int i10, double[] dArr) {
        e(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    public static void o(int i10, double[] dArr) {
        f(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    public static int p(int i10, int i11) {
        return 255 - (((255 - i11) * (255 - i10)) / 255);
    }

    public static int q(int i10, int i11) {
        int alpha = Color.alpha(i11);
        int alpha2 = Color.alpha(i10);
        int p10 = p(alpha2, alpha);
        return Color.argb(p10, r(Color.red(i10), alpha2, Color.red(i11), alpha, p10), r(Color.green(i10), alpha2, Color.green(i11), alpha, p10), r(Color.blue(i10), alpha2, Color.blue(i11), alpha, p10));
    }

    public static int r(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            return 0;
        }
        return (((i10 * 255) * i11) + ((i12 * i13) * (255 - i11))) / (i14 * 255);
    }

    public static float s(float f10, float f11, float f12) {
        if (f10 >= f11) {
            return Math.min(f10, f12);
        }
        return f11;
    }

    public static int t(int i10, int i11, int i12) {
        if (i10 >= i11) {
            return Math.min(i10, i12);
        }
        return i11;
    }

    public static double[] u() {
        ThreadLocal<double[]> threadLocal = f205a;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    public static double v(double d10) {
        if (d10 > 0.008856d) {
            return Math.pow(d10, 0.3333333333333333d);
        }
        return ((d10 * 903.3d) + 16.0d) / 116.0d;
    }

    public static int w(int i10, int i11) {
        if (i11 >= 0 && i11 <= 255) {
            return (i10 & UIUtil.CONSTANT_COLOR_MASK) | (i11 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
