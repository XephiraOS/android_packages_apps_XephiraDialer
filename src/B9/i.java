package B9;

/* compiled from: _Ranges.kt */
/* loaded from: classes4.dex */
public class i extends h {
    public static float a(float f10, float f11) {
        if (f10 < f11) {
            return f11;
        }
        return f10;
    }

    public static int b(int i10, int i11) {
        if (i10 < i11) {
            return i11;
        }
        return i10;
    }

    public static long c(long j10, long j11) {
        if (j10 < j11) {
            return j11;
        }
        return j10;
    }

    public static float d(float f10, float f11) {
        if (f10 > f11) {
            return f11;
        }
        return f10;
    }

    public static int e(int i10, int i11) {
        if (i10 > i11) {
            return i11;
        }
        return i10;
    }

    public static long f(long j10, long j11) {
        if (j10 > j11) {
            return j11;
        }
        return j10;
    }

    public static int g(int i10, int i11, int i12) {
        if (i11 <= i12) {
            if (i10 < i11) {
                return i11;
            }
            if (i10 > i12) {
                return i12;
            }
            return i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    public static d h(int i10, int i11) {
        return d.f296d.a(i10, i11, -1);
    }

    public static f i(int i10, int i11) {
        if (i11 <= Integer.MIN_VALUE) {
            return f.f304e.a();
        }
        return new f(i10, i11 - 1);
    }
}
