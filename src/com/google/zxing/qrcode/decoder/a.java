package com.google.zxing.qrcode.decoder;

import S4.b;
import com.google.zxing.FormatException;
import j5.C1166d;
import j5.f;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f25120a;

    /* renamed from: b, reason: collision with root package name */
    public f f25121b;

    /* renamed from: c, reason: collision with root package name */
    public C1166d f25122c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25123d;

    public a(b bVar) {
        int g10 = bVar.g();
        if (g10 >= 21 && (g10 & 3) == 1) {
            this.f25120a = bVar;
            return;
        }
        throw FormatException.a();
    }

    public final int a(int i10, int i11, int i12) {
        boolean d10;
        boolean z10 = this.f25123d;
        b bVar = this.f25120a;
        if (z10) {
            d10 = bVar.d(i11, i10);
        } else {
            d10 = bVar.d(i10, i11);
        }
        if (d10) {
            return (i12 << 1) | 1;
        }
        return i12 << 1;
    }

    public void b() {
        int i10 = 0;
        while (i10 < this.f25120a.j()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f25120a.g(); i12++) {
                if (this.f25120a.d(i10, i12) != this.f25120a.d(i12, i10)) {
                    this.f25120a.c(i12, i10);
                    this.f25120a.c(i10, i12);
                }
            }
            i10 = i11;
        }
    }

    public byte[] c() {
        int i10;
        C1166d d10 = d();
        f e10 = e();
        DataMask dataMask = DataMask.values()[d10.c()];
        int g10 = this.f25120a.g();
        dataMask.b(this.f25120a, g10);
        b a10 = e10.a();
        byte[] bArr = new byte[e10.h()];
        int i11 = g10 - 1;
        boolean z10 = true;
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 > 0) {
            if (i12 == 6) {
                i12--;
            }
            for (int i16 = 0; i16 < g10; i16++) {
                if (z10) {
                    i10 = i11 - i16;
                } else {
                    i10 = i16;
                }
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i12 - i17;
                    if (!a10.d(i18, i10)) {
                        i14++;
                        i15 <<= 1;
                        if (this.f25120a.d(i18, i10)) {
                            i15 |= 1;
                        }
                        if (i14 == 8) {
                            bArr[i13] = (byte) i15;
                            i13++;
                            i14 = 0;
                            i15 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i12 -= 2;
        }
        if (i13 == e10.h()) {
            return bArr;
        }
        throw FormatException.a();
    }

    public C1166d d() {
        C1166d c1166d = this.f25122c;
        if (c1166d != null) {
            return c1166d;
        }
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 = a(i12, 8, i11);
        }
        int a10 = a(8, 7, a(8, 8, a(7, 8, i11)));
        for (int i13 = 5; i13 >= 0; i13--) {
            a10 = a(8, i13, a10);
        }
        int g10 = this.f25120a.g();
        int i14 = g10 - 7;
        for (int i15 = g10 - 1; i15 >= i14; i15--) {
            i10 = a(8, i15, i10);
        }
        for (int i16 = g10 - 8; i16 < g10; i16++) {
            i10 = a(i16, 8, i10);
        }
        C1166d a11 = C1166d.a(a10, i10);
        this.f25122c = a11;
        if (a11 != null) {
            return a11;
        }
        throw FormatException.a();
    }

    public f e() {
        f fVar = this.f25121b;
        if (fVar != null) {
            return fVar;
        }
        int g10 = this.f25120a.g();
        int i10 = (g10 - 17) / 4;
        if (i10 <= 6) {
            return f.i(i10);
        }
        int i11 = g10 - 11;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = g10 - 9; i15 >= i11; i15--) {
                i13 = a(i15, i14, i13);
            }
        }
        f c10 = f.c(i13);
        if (c10 != null && c10.e() == g10) {
            this.f25121b = c10;
            return c10;
        }
        for (int i16 = 5; i16 >= 0; i16--) {
            for (int i17 = g10 - 9; i17 >= i11; i17--) {
                i12 = a(i16, i17, i12);
            }
        }
        f c11 = f.c(i12);
        if (c11 != null && c11.e() == g10) {
            this.f25121b = c11;
            return c11;
        }
        throw FormatException.a();
    }

    public void f() {
        if (this.f25122c == null) {
            return;
        }
        DataMask.values()[this.f25122c.c()].b(this.f25120a, this.f25120a.g());
    }

    public void g(boolean z10) {
        this.f25121b = null;
        this.f25122c = null;
        this.f25123d = z10;
    }
}
