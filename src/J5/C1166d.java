package j5;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* compiled from: FormatInformation.java */
/* renamed from: j5.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1166d {

    /* renamed from: c, reason: collision with root package name */
    public static final int[][] f33877c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a, reason: collision with root package name */
    public final ErrorCorrectionLevel f33878a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f33879b;

    public C1166d(int i10) {
        this.f33878a = ErrorCorrectionLevel.a((i10 >> 3) & 3);
        this.f33879b = (byte) (i10 & 7);
    }

    public static C1166d a(int i10, int i11) {
        C1166d b10 = b(i10, i11);
        if (b10 != null) {
            return b10;
        }
        return b(i10 ^ 21522, i11 ^ 21522);
    }

    public static C1166d b(int i10, int i11) {
        int e10;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        for (int[] iArr : f33877c) {
            int i14 = iArr[0];
            if (i14 != i10 && i14 != i11) {
                int e11 = e(i10, i14);
                if (e11 < i12) {
                    i13 = iArr[1];
                    i12 = e11;
                }
                if (i10 != i11 && (e10 = e(i11, i14)) < i12) {
                    i13 = iArr[1];
                    i12 = e10;
                }
            } else {
                return new C1166d(iArr[1]);
            }
        }
        if (i12 <= 3) {
            return new C1166d(i13);
        }
        return null;
    }

    public static int e(int i10, int i11) {
        return Integer.bitCount(i10 ^ i11);
    }

    public byte c() {
        return this.f33879b;
    }

    public ErrorCorrectionLevel d() {
        return this.f33878a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1166d)) {
            return false;
        }
        C1166d c1166d = (C1166d) obj;
        if (this.f33878a != c1166d.f33878a || this.f33879b != c1166d.f33879b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f33879b | (this.f33878a.ordinal() << 3);
    }
}
