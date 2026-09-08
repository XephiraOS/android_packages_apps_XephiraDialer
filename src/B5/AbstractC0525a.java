package b5;

import a5.k;
import com.google.zxing.NotFoundException;

/* compiled from: AbstractRSSReader.java */
/* renamed from: b5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0525a extends k {

    /* renamed from: b, reason: collision with root package name */
    public final int[] f12164b;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f12167e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f12168f;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f12163a = new int[4];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f12165c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f12166d = new float[4];

    public AbstractC0525a() {
        int[] iArr = new int[8];
        this.f12164b = iArr;
        this.f12167e = new int[iArr.length / 2];
        this.f12168f = new int[iArr.length / 2];
    }

    public static void g(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            float f11 = fArr[i11];
            if (f11 < f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        iArr[i10] = iArr[i10] - 1;
    }

    public static void n(int[] iArr, float[] fArr) {
        int i10 = 0;
        float f10 = fArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            float f11 = fArr[i11];
            if (f11 > f10) {
                i10 = i11;
                f10 = f11;
            }
        }
        iArr[i10] = iArr[i10] + 1;
    }

    public static boolean o(int[] iArr) {
        float f10 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f10 >= 0.7916667f && f10 <= 0.89285713f) {
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MIN_VALUE;
            for (int i12 : iArr) {
                if (i12 > i11) {
                    i11 = i12;
                }
                if (i12 < i10) {
                    i10 = i12;
                }
            }
            if (i11 < i10 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int p(int[] iArr, int[][] iArr2) {
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            if (k.d(iArr, iArr2[i10], 0.45f) < 0.2f) {
                return i10;
            }
        }
        throw NotFoundException.a();
    }

    public final int[] h() {
        return this.f12164b;
    }

    public final int[] i() {
        return this.f12163a;
    }

    public final int[] j() {
        return this.f12168f;
    }

    public final float[] k() {
        return this.f12166d;
    }

    public final int[] l() {
        return this.f12167e;
    }

    public final float[] m() {
        return this.f12165c;
    }
}
