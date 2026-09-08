package com.google.common.math;

import com.google.common.base.k;
import java.math.RoundingMode;

/* compiled from: IntMath.java */
/* loaded from: classes3.dex */
public final class a {
    static final int FLOOR_SQRT_MAX_INT = 46340;
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;
    static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    static final int[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    static final int[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f24602a = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* compiled from: IntMath.java */
    /* renamed from: com.google.common.math.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0223a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24603a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f24603a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24603a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24603a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24603a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24603a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24603a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24603a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f24603a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i10, int i11, RoundingMode roundingMode) {
        boolean z10;
        k.o(roundingMode);
        if (i11 != 0) {
            int i12 = i10 / i11;
            int i13 = i10 - (i11 * i12);
            if (i13 == 0) {
                return i12;
            }
            boolean z11 = true;
            int i14 = ((i10 ^ i11) >> 31) | 1;
            switch (C0223a.f24603a[roundingMode.ordinal()]) {
                case 1:
                    if (i13 != 0) {
                        z11 = false;
                    }
                    c.c(z11);
                    return i12;
                case 2:
                    return i12;
                case 3:
                    if (i14 >= 0) {
                        return i12;
                    }
                    break;
                case 4:
                    break;
                case 5:
                    if (i14 <= 0) {
                        return i12;
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i13);
                    int abs2 = abs - (Math.abs(i11) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            if (roundingMode == RoundingMode.HALF_EVEN) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if ((i12 & 1) == 0) {
                                z11 = false;
                            }
                            if (!(z10 & z11)) {
                                return i12;
                            }
                        }
                    } else if (abs2 <= 0) {
                        return i12;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return i12 + i14;
        }
        throw new ArithmeticException("/ by zero");
    }

    public static boolean b(int i10) {
        boolean z10;
        boolean z11 = false;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & (i10 - 1)) == 0) {
            z11 = true;
        }
        return z10 & z11;
    }

    public static int c(int i10, RoundingMode roundingMode) {
        c.b("x", i10);
        switch (C0223a.f24603a[roundingMode.ordinal()]) {
            case 1:
                c.c(b(i10));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i10 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i10);
                return (31 - numberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> numberOfLeadingZeros, i10);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static int d(int i10, int i11) {
        return com.google.common.primitives.b.b(i10 * i11);
    }

    public static int lessThanBranchFree(int i10, int i11) {
        return (~(~(i10 - i11))) >>> 31;
    }
}
