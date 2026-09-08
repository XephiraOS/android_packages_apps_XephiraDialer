package j5;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import j5.f;

/* compiled from: DataBlock.java */
/* renamed from: j5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1163a {

    /* renamed from: a, reason: collision with root package name */
    public final int f33872a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f33873b;

    public C1163a(int i10, byte[] bArr) {
        this.f33872a = i10;
        this.f33873b = bArr;
    }

    public static C1163a[] b(byte[] bArr, f fVar, ErrorCorrectionLevel errorCorrectionLevel) {
        int i10;
        if (bArr.length == fVar.h()) {
            f.b f10 = fVar.f(errorCorrectionLevel);
            f.a[] a10 = f10.a();
            int i11 = 0;
            for (f.a aVar : a10) {
                i11 += aVar.a();
            }
            C1163a[] c1163aArr = new C1163a[i11];
            int i12 = 0;
            for (f.a aVar2 : a10) {
                int i13 = 0;
                while (i13 < aVar2.a()) {
                    int b10 = aVar2.b();
                    c1163aArr[i12] = new C1163a(b10, new byte[f10.b() + b10]);
                    i13++;
                    i12++;
                }
            }
            int length = c1163aArr[0].f33873b.length;
            int i14 = i11 - 1;
            while (i14 >= 0 && c1163aArr[i14].f33873b.length != length) {
                i14--;
            }
            int i15 = i14 + 1;
            int b11 = length - f10.b();
            int i16 = 0;
            for (int i17 = 0; i17 < b11; i17++) {
                int i18 = 0;
                while (i18 < i12) {
                    c1163aArr[i18].f33873b[i17] = bArr[i16];
                    i18++;
                    i16++;
                }
            }
            int i19 = i15;
            while (i19 < i12) {
                c1163aArr[i19].f33873b[b11] = bArr[i16];
                i19++;
                i16++;
            }
            int length2 = c1163aArr[0].f33873b.length;
            while (b11 < length2) {
                int i20 = 0;
                while (i20 < i12) {
                    if (i20 < i15) {
                        i10 = b11;
                    } else {
                        i10 = b11 + 1;
                    }
                    c1163aArr[i20].f33873b[i10] = bArr[i16];
                    i20++;
                    i16++;
                }
                b11++;
            }
            return c1163aArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] a() {
        return this.f33873b;
    }

    public int c() {
        return this.f33872a;
    }
}
