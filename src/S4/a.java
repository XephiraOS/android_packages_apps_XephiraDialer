package S4;

import java.util.Arrays;

/* compiled from: BitArray.java */
/* loaded from: classes3.dex */
public final class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int[] f3484a;

    /* renamed from: b, reason: collision with root package name */
    public int f3485b;

    public a() {
        this.f3485b = 0;
        this.f3484a = new int[1];
    }

    public static int[] n(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void a(boolean z10) {
        f(this.f3485b + 1);
        if (z10) {
            int[] iArr = this.f3484a;
            int i10 = this.f3485b;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f3485b++;
    }

    public void b(a aVar) {
        int i10 = aVar.f3485b;
        f(this.f3485b + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(aVar.g(i11));
        }
    }

    public void c(int i10, int i11) {
        if (i11 >= 0 && i11 <= 32) {
            f(this.f3485b + i11);
            while (i11 > 0) {
                boolean z10 = true;
                if (((i10 >> (i11 - 1)) & 1) != 1) {
                    z10 = false;
                }
                a(z10);
                i11--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void d() {
        int length = this.f3484a.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f3484a[i10] = 0;
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f3484a.clone(), this.f3485b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f3485b != aVar.f3485b || !Arrays.equals(this.f3484a, aVar.f3484a)) {
            return false;
        }
        return true;
    }

    public final void f(int i10) {
        if (i10 > (this.f3484a.length << 5)) {
            int[] n10 = n(i10);
            int[] iArr = this.f3484a;
            System.arraycopy(iArr, 0, n10, 0, iArr.length);
            this.f3484a = n10;
        }
    }

    public boolean g(int i10) {
        if ((this.f3484a[i10 / 32] & (1 << (i10 & 31))) != 0) {
            return true;
        }
        return false;
    }

    public int[] h() {
        return this.f3484a;
    }

    public int hashCode() {
        return (this.f3485b * 31) + Arrays.hashCode(this.f3484a);
    }

    public int i(int i10) {
        int i11 = this.f3485b;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (-(1 << (i10 & 31))) & this.f3484a[i12];
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f3484a;
            if (i12 == iArr.length) {
                return this.f3485b;
            }
            i13 = iArr[i12];
        }
        int numberOfTrailingZeros = (i12 << 5) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.f3485b;
        if (numberOfTrailingZeros > i14) {
            return i14;
        }
        return numberOfTrailingZeros;
    }

    public int j(int i10) {
        int i11 = this.f3485b;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (-(1 << (i10 & 31))) & (~this.f3484a[i12]);
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f3484a;
            if (i12 == iArr.length) {
                return this.f3485b;
            }
            i13 = ~iArr[i12];
        }
        int numberOfTrailingZeros = (i12 << 5) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.f3485b;
        if (numberOfTrailingZeros > i14) {
            return i14;
        }
        return numberOfTrailingZeros;
    }

    public int k() {
        return this.f3485b;
    }

    public int l() {
        return (this.f3485b + 7) / 8;
    }

    public boolean m(int i10, int i11, boolean z10) {
        int i12;
        if (i11 >= i10 && i10 >= 0 && i11 <= this.f3485b) {
            if (i11 == i10) {
                return true;
            }
            int i13 = i11 - 1;
            int i14 = i10 / 32;
            int i15 = i13 / 32;
            for (int i16 = i14; i16 <= i15; i16++) {
                int i17 = 31;
                if (i16 > i14) {
                    i12 = 0;
                } else {
                    i12 = i10 & 31;
                }
                if (i16 >= i15) {
                    i17 = 31 & i13;
                }
                int i18 = (2 << i17) - (1 << i12);
                int i19 = this.f3484a[i16] & i18;
                if (!z10) {
                    i18 = 0;
                }
                if (i19 != i18) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException();
    }

    public void o() {
        int[] iArr = new int[this.f3484a.length];
        int i10 = (this.f3485b - 1) / 32;
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            long j10 = this.f3484a[i12];
            long j11 = ((j10 & 1431655765) << 1) | ((j10 >> 1) & 1431655765);
            long j12 = ((j11 & 858993459) << 2) | ((j11 >> 2) & 858993459);
            long j13 = ((j12 & 252645135) << 4) | ((j12 >> 4) & 252645135);
            long j14 = ((j13 & 16711935) << 8) | ((j13 >> 8) & 16711935);
            iArr[i10 - i12] = (int) (((j14 & 65535) << 16) | ((j14 >> 16) & 65535));
        }
        int i13 = this.f3485b;
        int i14 = i11 << 5;
        if (i13 != i14) {
            int i15 = i14 - i13;
            int i16 = iArr[0] >>> i15;
            for (int i17 = 1; i17 < i11; i17++) {
                int i18 = iArr[i17];
                iArr[i17 - 1] = i16 | (i18 << (32 - i15));
                i16 = i18 >>> i15;
            }
            iArr[i10] = i16;
        }
        this.f3484a = iArr;
    }

    public void p(int i10) {
        int[] iArr = this.f3484a;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
    }

    public void q(int i10, int i11) {
        this.f3484a[i10 / 32] = i11;
    }

    public void r(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (g(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    public void s(a aVar) {
        if (this.f3485b == aVar.f3485b) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f3484a;
                if (i10 < iArr.length) {
                    iArr[i10] = iArr[i10] ^ aVar.f3484a[i10];
                    i10++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public String toString() {
        char c10;
        int i10 = this.f3485b;
        StringBuilder sb = new StringBuilder(i10 + (i10 / 8) + 1);
        for (int i11 = 0; i11 < this.f3485b; i11++) {
            if ((i11 & 7) == 0) {
                sb.append(' ');
            }
            if (g(i11)) {
                c10 = 'X';
            } else {
                c10 = '.';
            }
            sb.append(c10);
        }
        return sb.toString();
    }

    public a(int i10) {
        this.f3485b = i10;
        this.f3484a = n(i10);
    }

    public a(int[] iArr, int i10) {
        this.f3484a = iArr;
        this.f3485b = i10;
    }
}
