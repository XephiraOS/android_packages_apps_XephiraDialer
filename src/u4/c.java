package U4;

import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* compiled from: ReedSolomonDecoder.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f3869a;

    public c(a aVar) {
        this.f3869a = aVar;
    }

    public void a(int[] iArr, int i10) {
        b bVar = new b(this.f3869a, iArr);
        int[] iArr2 = new int[i10];
        boolean z10 = true;
        for (int i11 = 0; i11 < i10; i11++) {
            a aVar = this.f3869a;
            int c10 = bVar.c(aVar.c(aVar.d() + i11));
            iArr2[(i10 - 1) - i11] = c10;
            if (c10 != 0) {
                z10 = false;
            }
        }
        if (z10) {
            return;
        }
        b[] d10 = d(this.f3869a.b(i10, 1), new b(this.f3869a, iArr2), i10);
        b bVar2 = d10[0];
        b bVar3 = d10[1];
        int[] b10 = b(bVar2);
        int[] c11 = c(bVar3, b10);
        for (int i12 = 0; i12 < b10.length; i12++) {
            int length = (iArr.length - 1) - this.f3869a.i(b10[i12]);
            if (length >= 0) {
                iArr[length] = a.a(iArr[length], c11[i12]);
            } else {
                throw new ReedSolomonException("Bad error location");
            }
        }
    }

    public final int[] b(b bVar) {
        int f10 = bVar.f();
        if (f10 == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[f10];
        int i10 = 0;
        for (int i11 = 1; i11 < this.f3869a.f() && i10 < f10; i11++) {
            if (bVar.c(i11) == 0) {
                iArr[i10] = this.f3869a.h(i11);
                i10++;
            }
        }
        if (i10 == f10) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    public final int[] c(b bVar, int[] iArr) {
        int i10;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            int h10 = this.f3869a.h(iArr[i11]);
            int i12 = 1;
            for (int i13 = 0; i13 < length; i13++) {
                if (i11 != i13) {
                    int j10 = this.f3869a.j(iArr[i13], h10);
                    if ((j10 & 1) == 0) {
                        i10 = j10 | 1;
                    } else {
                        i10 = j10 & (-2);
                    }
                    i12 = this.f3869a.j(i12, i10);
                }
            }
            iArr2[i11] = this.f3869a.j(bVar.c(h10), this.f3869a.h(i12));
            if (this.f3869a.d() != 0) {
                iArr2[i11] = this.f3869a.j(iArr2[i11], h10);
            }
        }
        return iArr2;
    }

    public final b[] d(b bVar, b bVar2, int i10) {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b g10 = this.f3869a.g();
        b e10 = this.f3869a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = e10;
            b bVar5 = g10;
            g10 = bVar4;
            if (bVar.f() >= i10 / 2) {
                if (!bVar.g()) {
                    b g11 = this.f3869a.g();
                    int h10 = this.f3869a.h(bVar.d(bVar.f()));
                    while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                        int f10 = bVar2.f() - bVar.f();
                        int j10 = this.f3869a.j(bVar2.d(bVar2.f()), h10);
                        g11 = g11.a(this.f3869a.b(f10, j10));
                        bVar2 = bVar2.a(bVar.j(f10, j10));
                    }
                    e10 = g11.i(g10).a(bVar5);
                } else {
                    throw new ReedSolomonException("r_{i-1} was zero");
                }
            } else {
                int d10 = g10.d(0);
                if (d10 != 0) {
                    int h11 = this.f3869a.h(d10);
                    return new b[]{g10.h(h11), bVar.h(h11)};
                }
                throw new ReedSolomonException("sigmaTilde(0) was zero");
            }
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }
}
