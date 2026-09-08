package S4;

import java.util.Arrays;

/* compiled from: BitMatrix.java */
/* loaded from: classes3.dex */
public final class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final int f3486a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3487b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3488c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f3489d;

    public b(int i10) {
        this(i10, i10);
    }

    public final String a(String str, String str2, String str3) {
        String str4;
        StringBuilder sb = new StringBuilder(this.f3487b * (this.f3486a + 1));
        for (int i10 = 0; i10 < this.f3487b; i10++) {
            for (int i11 = 0; i11 < this.f3486a; i11++) {
                if (d(i11, i10)) {
                    str4 = str;
                } else {
                    str4 = str2;
                }
                sb.append(str4);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f3486a, this.f3487b, this.f3488c, (int[]) this.f3489d.clone());
    }

    public void c(int i10, int i11) {
        int i12 = (i11 * this.f3488c) + (i10 / 32);
        int[] iArr = this.f3489d;
        iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
    }

    public boolean d(int i10, int i11) {
        if (((this.f3489d[(i11 * this.f3488c) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0) {
            return true;
        }
        return false;
    }

    public int[] e() {
        int length = this.f3489d.length - 1;
        while (length >= 0 && this.f3489d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i10 = this.f3488c;
        int i11 = length / i10;
        int i12 = (length % i10) << 5;
        int i13 = this.f3489d[length];
        int i14 = 31;
        while ((i13 >>> i14) == 0) {
            i14--;
        }
        return new int[]{i12 + i14, i11};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f3486a != bVar.f3486a || this.f3487b != bVar.f3487b || this.f3488c != bVar.f3488c || !Arrays.equals(this.f3489d, bVar.f3489d)) {
            return false;
        }
        return true;
    }

    public int[] f() {
        int i10 = this.f3486a;
        int i11 = this.f3487b;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < this.f3487b; i14++) {
            int i15 = 0;
            while (true) {
                int i16 = this.f3488c;
                if (i15 < i16) {
                    int i17 = this.f3489d[(i16 * i14) + i15];
                    if (i17 != 0) {
                        if (i14 < i11) {
                            i11 = i14;
                        }
                        if (i14 > i13) {
                            i13 = i14;
                        }
                        int i18 = i15 << 5;
                        if (i18 < i10) {
                            int i19 = 0;
                            while ((i17 << (31 - i19)) == 0) {
                                i19++;
                            }
                            int i20 = i19 + i18;
                            if (i20 < i10) {
                                i10 = i20;
                            }
                        }
                        if (i18 + 31 > i12) {
                            int i21 = 31;
                            while ((i17 >>> i21) == 0) {
                                i21--;
                            }
                            int i22 = i18 + i21;
                            if (i22 > i12) {
                                i12 = i22;
                            }
                        }
                    }
                    i15++;
                }
            }
        }
        if (i12 >= i10 && i13 >= i11) {
            return new int[]{i10, i11, (i12 - i10) + 1, (i13 - i11) + 1};
        }
        return null;
    }

    public int g() {
        return this.f3487b;
    }

    public a h(int i10, a aVar) {
        if (aVar != null && aVar.k() >= this.f3486a) {
            aVar.d();
        } else {
            aVar = new a(this.f3486a);
        }
        int i11 = i10 * this.f3488c;
        for (int i12 = 0; i12 < this.f3488c; i12++) {
            aVar.q(i12 << 5, this.f3489d[i11 + i12]);
        }
        return aVar;
    }

    public int hashCode() {
        int i10 = this.f3486a;
        return (((((((i10 * 31) + i10) * 31) + this.f3487b) * 31) + this.f3488c) * 31) + Arrays.hashCode(this.f3489d);
    }

    public int[] i() {
        int[] iArr;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            iArr = this.f3489d;
            if (i11 >= iArr.length || iArr[i11] != 0) {
                break;
            }
            i11++;
        }
        if (i11 == iArr.length) {
            return null;
        }
        int i12 = this.f3488c;
        int i13 = i11 / i12;
        int i14 = (i11 % i12) << 5;
        while ((iArr[i11] << (31 - i10)) == 0) {
            i10++;
        }
        return new int[]{i14 + i10, i13};
    }

    public int j() {
        return this.f3486a;
    }

    public void k() {
        int j10 = j();
        int g10 = g();
        a aVar = new a(j10);
        a aVar2 = new a(j10);
        for (int i10 = 0; i10 < (g10 + 1) / 2; i10++) {
            aVar = h(i10, aVar);
            int i11 = (g10 - 1) - i10;
            aVar2 = h(i11, aVar2);
            aVar.o();
            aVar2.o();
            n(i10, aVar2);
            n(i11, aVar);
        }
    }

    public void l(int i10, int i11) {
        int i12 = (i11 * this.f3488c) + (i10 / 32);
        int[] iArr = this.f3489d;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void m(int i10, int i11, int i12, int i13) {
        if (i11 >= 0 && i10 >= 0) {
            if (i13 > 0 && i12 > 0) {
                int i14 = i12 + i10;
                int i15 = i13 + i11;
                if (i15 <= this.f3487b && i14 <= this.f3486a) {
                    while (i11 < i15) {
                        int i16 = this.f3488c * i11;
                        for (int i17 = i10; i17 < i14; i17++) {
                            int[] iArr = this.f3489d;
                            int i18 = (i17 / 32) + i16;
                            iArr[i18] = iArr[i18] | (1 << (i17 & 31));
                        }
                        i11++;
                    }
                    return;
                }
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        throw new IllegalArgumentException("Left and top must be nonnegative");
    }

    public void n(int i10, a aVar) {
        int[] h10 = aVar.h();
        int[] iArr = this.f3489d;
        int i11 = this.f3488c;
        System.arraycopy(h10, 0, iArr, i10 * i11, i11);
    }

    public String o(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return o("X ", "  ");
    }

    public b(int i10, int i11) {
        if (i10 > 0 && i11 > 0) {
            this.f3486a = i10;
            this.f3487b = i11;
            int i12 = (i10 + 31) / 32;
            this.f3488c = i12;
            this.f3489d = new int[i12 * i11];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    public b(int i10, int i11, int i12, int[] iArr) {
        this.f3486a = i10;
        this.f3487b = i11;
        this.f3488c = i12;
        this.f3489d = iArr;
    }
}
