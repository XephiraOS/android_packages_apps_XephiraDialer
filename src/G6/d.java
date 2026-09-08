package g6;

import java.util.Arrays;

/* compiled from: GradientColor.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f31892a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f31893b;

    public d(float[] fArr, int[] iArr) {
        this.f31892a = fArr;
        this.f31893b = iArr;
    }

    public d a(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            iArr[i10] = b(fArr[i10]);
        }
        return new d(fArr, iArr);
    }

    public final int b(float f10) {
        int binarySearch = Arrays.binarySearch(this.f31892a, f10);
        if (binarySearch >= 0) {
            return this.f31893b[binarySearch];
        }
        int i10 = -(binarySearch + 1);
        if (i10 == 0) {
            return this.f31893b[0];
        }
        int[] iArr = this.f31893b;
        if (i10 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f31892a;
        int i11 = i10 - 1;
        float f11 = fArr[i11];
        return l6.c.c((f10 - f11) / (fArr[i10] - f11), iArr[i11], iArr[i10]);
    }

    public int[] c() {
        return this.f31893b;
    }

    public float[] d() {
        return this.f31892a;
    }

    public int e() {
        return this.f31893b.length;
    }

    public void f(d dVar, d dVar2, float f10) {
        if (dVar.f31893b.length == dVar2.f31893b.length) {
            for (int i10 = 0; i10 < dVar.f31893b.length; i10++) {
                this.f31892a[i10] = l6.g.i(dVar.f31892a[i10], dVar2.f31892a[i10], f10);
                this.f31893b[i10] = l6.c.c(f10, dVar.f31893b[i10], dVar2.f31893b[i10]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + dVar.f31893b.length + " vs " + dVar2.f31893b.length + ")");
    }
}
