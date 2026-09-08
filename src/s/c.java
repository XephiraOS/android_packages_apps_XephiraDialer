package s;

import android.util.Log;
import java.util.Arrays;

/* compiled from: Easing.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static c f36581b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static String[] f36582c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a, reason: collision with root package name */
    public String f36583a = "identity";

    /* compiled from: Easing.java */
    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: h, reason: collision with root package name */
        public static double f36584h = 0.01d;

        /* renamed from: i, reason: collision with root package name */
        public static double f36585i = 1.0E-4d;

        /* renamed from: d, reason: collision with root package name */
        public double f36586d;

        /* renamed from: e, reason: collision with root package name */
        public double f36587e;

        /* renamed from: f, reason: collision with root package name */
        public double f36588f;

        /* renamed from: g, reason: collision with root package name */
        public double f36589g;

        public a(String str) {
            this.f36583a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f36586d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i10 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i10);
            this.f36587e = Double.parseDouble(str.substring(i10, indexOf3).trim());
            int i11 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i11);
            this.f36588f = Double.parseDouble(str.substring(i11, indexOf4).trim());
            int i12 = indexOf4 + 1;
            this.f36589g = Double.parseDouble(str.substring(i12, str.indexOf(41, i12)).trim());
        }

        @Override // s.c
        public double a(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f36584h) {
                d11 *= 0.5d;
                if (d(d12) < d10) {
                    d12 += d11;
                } else {
                    d12 -= d11;
                }
            }
            double d13 = d12 - d11;
            double d14 = d(d13);
            double d15 = d12 + d11;
            double d16 = d(d15);
            double e10 = e(d13);
            return (((e(d15) - e10) * (d10 - d14)) / (d16 - d14)) + e10;
        }

        @Override // s.c
        public double b(double d10) {
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f36585i) {
                d11 *= 0.5d;
                if (d(d12) < d10) {
                    d12 += d11;
                } else {
                    d12 -= d11;
                }
            }
            double d13 = d12 - d11;
            double d14 = d(d13);
            double d15 = d12 + d11;
            return (e(d15) - e(d13)) / (d(d15) - d14);
        }

        public final double d(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f36586d * d11 * d12 * d10) + (this.f36588f * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        public final double e(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f36587e * d11 * d12 * d10) + (this.f36589g * d12 * d10 * d10) + (d10 * d10 * d10);
        }
    }

    public static c c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c10 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new a("cubic(1, 1, 0, 0)");
            case 3:
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f36582c));
                return f36581b;
        }
    }

    public double b(double d10) {
        return 1.0d;
    }

    public String toString() {
        return this.f36583a;
    }

    public double a(double d10) {
        return d10;
    }
}
