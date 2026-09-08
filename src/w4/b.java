package W4;

import W4.d;

/* compiled from: DataBlock.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f4193a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4194b;

    public b(int i10, byte[] bArr) {
        this.f4193a = i10;
        this.f4194b = bArr;
    }

    public static b[] b(byte[] bArr, d dVar) {
        boolean z10;
        int i10;
        int i11;
        d.c d10 = dVar.d();
        d.b[] a10 = d10.a();
        int i12 = 0;
        for (d.b bVar : a10) {
            i12 += bVar.a();
        }
        b[] bVarArr = new b[i12];
        int i13 = 0;
        for (d.b bVar2 : a10) {
            int i14 = 0;
            while (i14 < bVar2.a()) {
                int b10 = bVar2.b();
                bVarArr[i13] = new b(b10, new byte[d10.b() + b10]);
                i14++;
                i13++;
            }
        }
        int length = bVarArr[0].f4194b.length - d10.b();
        int i15 = length - 1;
        int i16 = 0;
        for (int i17 = 0; i17 < i15; i17++) {
            int i18 = 0;
            while (i18 < i13) {
                bVarArr[i18].f4194b[i17] = bArr[i16];
                i18++;
                i16++;
            }
        }
        if (dVar.i() == 24) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = 8;
        } else {
            i10 = i13;
        }
        int i19 = 0;
        while (i19 < i10) {
            bVarArr[i19].f4194b[i15] = bArr[i16];
            i19++;
            i16++;
        }
        int length2 = bVarArr[0].f4194b.length;
        while (length < length2) {
            int i20 = 0;
            while (i20 < i13) {
                if (z10) {
                    i11 = (i20 + 8) % i13;
                } else {
                    i11 = i20;
                }
                bVarArr[i11].f4194b[(z10 && i11 > 7) ? length - 1 : length] = bArr[i16];
                i20++;
                i16++;
            }
            length++;
        }
        if (i16 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] a() {
        return this.f4194b;
    }

    public int c() {
        return this.f4193a;
    }
}
