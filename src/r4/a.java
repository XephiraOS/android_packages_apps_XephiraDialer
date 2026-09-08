package R4;

import P4.g;
import S4.b;
import S4.h;
import U4.c;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* compiled from: Detector.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f3346g = {3808, 476, 2107, 1799};

    /* renamed from: a, reason: collision with root package name */
    public final b f3347a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3348b;

    /* renamed from: c, reason: collision with root package name */
    public int f3349c;

    /* renamed from: d, reason: collision with root package name */
    public int f3350d;

    /* renamed from: e, reason: collision with root package name */
    public int f3351e;

    /* renamed from: f, reason: collision with root package name */
    public int f3352f;

    /* compiled from: Detector.java */
    /* renamed from: R4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0062a {

        /* renamed from: a, reason: collision with root package name */
        public final int f3353a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3354b;

        public C0062a(int i10, int i11) {
            this.f3353a = i10;
            this.f3354b = i11;
        }

        public int a() {
            return this.f3353a;
        }

        public int b() {
            return this.f3354b;
        }

        public g c() {
            return new g(a(), b());
        }

        public String toString() {
            return "<" + this.f3353a + ' ' + this.f3354b + '>';
        }
    }

    public a(b bVar) {
        this.f3347a = bVar;
    }

    public static float b(g gVar, g gVar2) {
        return T4.a.a(gVar.c(), gVar.d(), gVar2.c(), gVar2.d());
    }

    public static float c(C0062a c0062a, C0062a c0062a2) {
        return T4.a.b(c0062a.a(), c0062a.b(), c0062a2.a(), c0062a2.b());
    }

    public static g[] d(g[] gVarArr, int i10, int i11) {
        float f10 = i11 / (i10 * 2.0f);
        float c10 = gVarArr[0].c() - gVarArr[2].c();
        float d10 = gVarArr[0].d() - gVarArr[2].d();
        float c11 = (gVarArr[0].c() + gVarArr[2].c()) / 2.0f;
        float d11 = (gVarArr[0].d() + gVarArr[2].d()) / 2.0f;
        float f11 = c10 * f10;
        float f12 = d10 * f10;
        g gVar = new g(c11 + f11, d11 + f12);
        g gVar2 = new g(c11 - f11, d11 - f12);
        float c12 = gVarArr[1].c() - gVarArr[3].c();
        float d12 = gVarArr[1].d() - gVarArr[3].d();
        float c13 = (gVarArr[1].c() + gVarArr[3].c()) / 2.0f;
        float d13 = (gVarArr[1].d() + gVarArr[3].d()) / 2.0f;
        float f13 = c12 * f10;
        float f14 = f10 * d12;
        return new g[]{gVar, new g(c13 + f13, d13 + f14), gVar2, new g(c13 - f13, d13 - f14)};
    }

    public static int h(long j10, boolean z10) {
        int i10;
        int i11;
        if (z10) {
            i10 = 7;
            i11 = 2;
        } else {
            i10 = 10;
            i11 = 4;
        }
        int i12 = i10 - i11;
        int[] iArr = new int[i10];
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iArr[i13] = ((int) j10) & 15;
            j10 >>= 4;
        }
        try {
            new c(U4.a.f3855k).a(iArr, i12);
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 = (i14 << 4) + iArr[i15];
            }
            return i14;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.a();
        }
    }

    public static int m(int[] iArr, int i10) {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 = (i11 << 3) + ((i12 >> (i10 - 2)) << 1) + (i12 & 1);
        }
        int i13 = ((i11 & 1) << 11) + (i11 >> 1);
        for (int i14 = 0; i14 < 4; i14++) {
            if (Integer.bitCount(f3346g[i14] ^ i13) <= 2) {
                return i14;
            }
        }
        throw NotFoundException.a();
    }

    public Q4.a a(boolean z10) {
        g[] f10 = f(k());
        if (z10) {
            g gVar = f10[0];
            f10[0] = f10[2];
            f10[2] = gVar;
        }
        e(f10);
        b bVar = this.f3347a;
        int i10 = this.f3352f;
        return new Q4.a(q(bVar, f10[i10 % 4], f10[(i10 + 1) % 4], f10[(i10 + 2) % 4], f10[(i10 + 3) % 4]), l(f10), this.f3348b, this.f3350d, this.f3349c);
    }

    public final void e(g[] gVarArr) {
        long j10;
        long j11;
        if (o(gVarArr[0]) && o(gVarArr[1]) && o(gVarArr[2]) && o(gVarArr[3])) {
            int i10 = this.f3351e * 2;
            int[] iArr = {r(gVarArr[0], gVarArr[1], i10), r(gVarArr[1], gVarArr[2], i10), r(gVarArr[2], gVarArr[3], i10), r(gVarArr[3], gVarArr[0], i10)};
            this.f3352f = m(iArr, i10);
            long j12 = 0;
            for (int i11 = 0; i11 < 4; i11++) {
                int i12 = iArr[(this.f3352f + i11) % 4];
                if (this.f3348b) {
                    j10 = j12 << 7;
                    j11 = (i12 >> 1) & 127;
                } else {
                    j10 = j12 << 10;
                    j11 = ((i12 >> 2) & 992) + ((i12 >> 1) & 31);
                }
                j12 = j10 + j11;
            }
            int h10 = h(j12, this.f3348b);
            if (this.f3348b) {
                this.f3349c = (h10 >> 6) + 1;
                this.f3350d = (h10 & 63) + 1;
                return;
            } else {
                this.f3349c = (h10 >> 11) + 1;
                this.f3350d = (h10 & 2047) + 1;
                return;
            }
        }
        throw NotFoundException.a();
    }

    public final g[] f(C0062a c0062a) {
        boolean z10 = true;
        this.f3351e = 1;
        C0062a c0062a2 = c0062a;
        C0062a c0062a3 = c0062a2;
        C0062a c0062a4 = c0062a3;
        boolean z11 = true;
        while (this.f3351e < 9) {
            C0062a j10 = j(c0062a, z11, 1, -1);
            C0062a j11 = j(c0062a2, z11, 1, 1);
            C0062a j12 = j(c0062a3, z11, -1, 1);
            C0062a j13 = j(c0062a4, z11, -1, -1);
            if (this.f3351e > 2) {
                double c10 = (c(j13, j10) * this.f3351e) / (c(c0062a4, c0062a) * (this.f3351e + 2));
                if (c10 < 0.75d || c10 > 1.25d || !p(j10, j11, j12, j13)) {
                    break;
                }
            }
            z11 = !z11;
            this.f3351e++;
            c0062a4 = j13;
            c0062a = j10;
            c0062a2 = j11;
            c0062a3 = j12;
        }
        int i10 = this.f3351e;
        if (i10 != 5 && i10 != 7) {
            throw NotFoundException.a();
        }
        if (i10 != 5) {
            z10 = false;
        }
        this.f3348b = z10;
        return d(new g[]{new g(c0062a.a() + 0.5f, c0062a.b() - 0.5f), new g(c0062a2.a() + 0.5f, c0062a2.b() + 0.5f), new g(c0062a3.a() - 0.5f, c0062a3.b() + 0.5f), new g(c0062a4.a() - 0.5f, c0062a4.b() - 0.5f)}, (r14 * 2) - 3, this.f3351e * 2);
    }

    public final int g(C0062a c0062a, C0062a c0062a2) {
        float c10 = c(c0062a, c0062a2);
        float a10 = (c0062a2.a() - c0062a.a()) / c10;
        float b10 = (c0062a2.b() - c0062a.b()) / c10;
        float a11 = c0062a.a();
        float b11 = c0062a.b();
        boolean d10 = this.f3347a.d(c0062a.a(), c0062a.b());
        int ceil = (int) Math.ceil(c10);
        boolean z10 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < ceil; i11++) {
            a11 += a10;
            b11 += b10;
            if (this.f3347a.d(T4.a.c(a11), T4.a.c(b11)) != d10) {
                i10++;
            }
        }
        float f10 = i10 / c10;
        if (f10 > 0.1f && f10 < 0.9f) {
            return 0;
        }
        if (f10 <= 0.1f) {
            z10 = true;
        }
        if (z10 == d10) {
            return 1;
        }
        return -1;
    }

    public final int i() {
        if (this.f3348b) {
            return (this.f3349c * 4) + 11;
        }
        int i10 = this.f3349c;
        if (i10 <= 4) {
            return (i10 * 4) + 15;
        }
        return (i10 * 4) + ((((i10 - 4) / 8) + 1) * 2) + 15;
    }

    public final C0062a j(C0062a c0062a, boolean z10, int i10, int i11) {
        int a10 = c0062a.a() + i10;
        int b10 = c0062a.b();
        while (true) {
            b10 += i11;
            if (!n(a10, b10) || this.f3347a.d(a10, b10) != z10) {
                break;
            }
            a10 += i10;
        }
        int i12 = a10 - i10;
        int i13 = b10 - i11;
        while (n(i12, i13) && this.f3347a.d(i12, i13) == z10) {
            i12 += i10;
        }
        int i14 = i12 - i10;
        while (n(i14, i13) && this.f3347a.d(i14, i13) == z10) {
            i13 += i11;
        }
        return new C0062a(i14, i13 - i11);
    }

    public final C0062a k() {
        g c10;
        g gVar;
        g gVar2;
        g gVar3;
        g c11;
        g c12;
        g c13;
        g c14;
        try {
            g[] c15 = new T4.b(this.f3347a).c();
            gVar2 = c15[0];
            gVar3 = c15[1];
            gVar = c15[2];
            c10 = c15[3];
        } catch (NotFoundException unused) {
            int j10 = this.f3347a.j() / 2;
            int g10 = this.f3347a.g() / 2;
            int i10 = j10 + 7;
            int i11 = g10 - 7;
            g c16 = j(new C0062a(i10, i11), false, 1, -1).c();
            int i12 = g10 + 7;
            g c17 = j(new C0062a(i10, i12), false, 1, 1).c();
            int i13 = j10 - 7;
            g c18 = j(new C0062a(i13, i12), false, -1, 1).c();
            c10 = j(new C0062a(i13, i11), false, -1, -1).c();
            gVar = c18;
            gVar2 = c16;
            gVar3 = c17;
        }
        int c19 = T4.a.c((((gVar2.c() + c10.c()) + gVar3.c()) + gVar.c()) / 4.0f);
        int c20 = T4.a.c((((gVar2.d() + c10.d()) + gVar3.d()) + gVar.d()) / 4.0f);
        try {
            g[] c21 = new T4.b(this.f3347a, 15, c19, c20).c();
            c11 = c21[0];
            c12 = c21[1];
            c13 = c21[2];
            c14 = c21[3];
        } catch (NotFoundException unused2) {
            int i14 = c19 + 7;
            int i15 = c20 - 7;
            c11 = this.j(new C0062a(i14, i15), false, 1, -1).c();
            int i16 = c20 + 7;
            c12 = this.j(new C0062a(i14, i16), false, 1, 1).c();
            int i17 = c19 - 7;
            c13 = this.j(new C0062a(i17, i16), false, -1, 1).c();
            c14 = this.j(new C0062a(i17, i15), false, -1, -1).c();
        }
        return new C0062a(T4.a.c((((c11.c() + c14.c()) + c12.c()) + c13.c()) / 4.0f), T4.a.c((((c11.d() + c14.d()) + c12.d()) + c13.d()) / 4.0f));
    }

    public final g[] l(g[] gVarArr) {
        return d(gVarArr, this.f3351e * 2, i());
    }

    public final boolean n(int i10, int i11) {
        if (i10 >= 0 && i10 < this.f3347a.j() && i11 > 0 && i11 < this.f3347a.g()) {
            return true;
        }
        return false;
    }

    public final boolean o(g gVar) {
        return n(T4.a.c(gVar.c()), T4.a.c(gVar.d()));
    }

    public final boolean p(C0062a c0062a, C0062a c0062a2, C0062a c0062a3, C0062a c0062a4) {
        C0062a c0062a5 = new C0062a(c0062a.a() - 3, c0062a.b() + 3);
        C0062a c0062a6 = new C0062a(c0062a2.a() - 3, c0062a2.b() - 3);
        C0062a c0062a7 = new C0062a(c0062a3.a() + 3, c0062a3.b() - 3);
        C0062a c0062a8 = new C0062a(c0062a4.a() + 3, c0062a4.b() + 3);
        int g10 = g(c0062a8, c0062a5);
        if (g10 == 0 || g(c0062a5, c0062a6) != g10 || g(c0062a6, c0062a7) != g10 || g(c0062a7, c0062a8) != g10) {
            return false;
        }
        return true;
    }

    public final b q(b bVar, g gVar, g gVar2, g gVar3, g gVar4) {
        h b10 = h.b();
        int i10 = i();
        float f10 = i10 / 2.0f;
        int i11 = this.f3351e;
        float f11 = f10 - i11;
        float f12 = f10 + i11;
        return b10.c(bVar, i10, i10, f11, f11, f12, f11, f12, f12, f11, f12, gVar.c(), gVar.d(), gVar2.c(), gVar2.d(), gVar3.c(), gVar3.d(), gVar4.c(), gVar4.d());
    }

    public final int r(g gVar, g gVar2, int i10) {
        float b10 = b(gVar, gVar2);
        float f10 = b10 / i10;
        float c10 = gVar.c();
        float d10 = gVar.d();
        float c11 = ((gVar2.c() - gVar.c()) * f10) / b10;
        float d11 = (f10 * (gVar2.d() - gVar.d())) / b10;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f11 = i12;
            if (this.f3347a.d(T4.a.c((f11 * c11) + c10), T4.a.c((f11 * d11) + d10))) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }
}
