package g5;

import com.android.incallui.Log;

/* compiled from: ModulusPoly.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final C1047b f31884a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f31885b;

    public c(C1047b c1047b, int[] iArr) {
        if (iArr.length != 0) {
            this.f31884a = c1047b;
            int length = iArr.length;
            int i10 = 1;
            if (length > 1 && iArr[0] == 0) {
                while (i10 < length && iArr[i10] == 0) {
                    i10++;
                }
                if (i10 == length) {
                    this.f31885b = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i10];
                this.f31885b = iArr2;
                System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
                return;
            }
            this.f31885b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    public c a(c cVar) {
        if (this.f31884a.equals(cVar.f31884a)) {
            if (e()) {
                return cVar;
            }
            if (cVar.e()) {
                return this;
            }
            int[] iArr = this.f31885b;
            int[] iArr2 = cVar.f31885b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i10 = length; i10 < iArr.length; i10++) {
                iArr3[i10] = this.f31884a.a(iArr2[i10 - length], iArr[i10]);
            }
            return new c(this.f31884a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public int b(int i10) {
        if (i10 == 0) {
            return c(0);
        }
        if (i10 == 1) {
            int i11 = 0;
            for (int i12 : this.f31885b) {
                i11 = this.f31884a.a(i11, i12);
            }
            return i11;
        }
        int[] iArr = this.f31885b;
        int i13 = iArr[0];
        int length = iArr.length;
        for (int i14 = 1; i14 < length; i14++) {
            C1047b c1047b = this.f31884a;
            i13 = c1047b.a(c1047b.i(i10, i13), this.f31885b[i14]);
        }
        return i13;
    }

    public int c(int i10) {
        return this.f31885b[(r1.length - 1) - i10];
    }

    public int d() {
        return this.f31885b.length - 1;
    }

    public boolean e() {
        if (this.f31885b[0] != 0) {
            return false;
        }
        return true;
    }

    public c f(int i10) {
        if (i10 == 0) {
            return this.f31884a.f();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f31885b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f31884a.i(this.f31885b[i11], i10);
        }
        return new c(this.f31884a, iArr);
    }

    public c g(c cVar) {
        if (this.f31884a.equals(cVar.f31884a)) {
            if (!e() && !cVar.e()) {
                int[] iArr = this.f31885b;
                int length = iArr.length;
                int[] iArr2 = cVar.f31885b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = iArr[i10];
                    for (int i12 = 0; i12 < length2; i12++) {
                        int i13 = i10 + i12;
                        C1047b c1047b = this.f31884a;
                        iArr3[i13] = c1047b.a(iArr3[i13], c1047b.i(i11, iArr2[i12]));
                    }
                }
                return new c(this.f31884a, iArr3);
            }
            return this.f31884a.f();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public c h(int i10, int i11) {
        if (i10 >= 0) {
            if (i11 == 0) {
                return this.f31884a.f();
            }
            int length = this.f31885b.length;
            int[] iArr = new int[i10 + length];
            for (int i12 = 0; i12 < length; i12++) {
                iArr[i12] = this.f31884a.i(this.f31885b[i12], i11);
            }
            return new c(this.f31884a, iArr);
        }
        throw new IllegalArgumentException();
    }

    public c i() {
        int length = this.f31885b.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = this.f31884a.j(0, this.f31885b[i10]);
        }
        return new c(this.f31884a, iArr);
    }

    public c j(c cVar) {
        if (this.f31884a.equals(cVar.f31884a)) {
            if (cVar.e()) {
                return this;
            }
            return a(cVar.i());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int d10 = d(); d10 >= 0; d10--) {
            int c10 = c(d10);
            if (c10 != 0) {
                if (c10 < 0) {
                    sb.append(Log.TAG_DELIMETER);
                    c10 = -c10;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (d10 == 0 || c10 != 1) {
                    sb.append(c10);
                }
                if (d10 != 0) {
                    if (d10 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(d10);
                    }
                }
            }
        }
        return sb.toString();
    }
}
