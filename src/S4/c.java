package S4;

import com.heytap.accessory.constant.FastPairConstants;

/* compiled from: BitSource.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3490a;

    /* renamed from: b, reason: collision with root package name */
    public int f3491b;

    /* renamed from: c, reason: collision with root package name */
    public int f3492c;

    public c(byte[] bArr) {
        this.f3490a = bArr;
    }

    public int a() {
        return ((this.f3490a.length - this.f3491b) * 8) - this.f3492c;
    }

    public int b() {
        return this.f3492c;
    }

    public int c() {
        return this.f3491b;
    }

    public int d(int i10) {
        int i11;
        if (i10 > 0 && i10 <= 32 && i10 <= a()) {
            int i12 = this.f3492c;
            int i13 = 0;
            if (i12 > 0) {
                int i14 = 8 - i12;
                if (i10 < i14) {
                    i11 = i10;
                } else {
                    i11 = i14;
                }
                int i15 = i14 - i11;
                byte[] bArr = this.f3490a;
                int i16 = this.f3491b;
                int i17 = (((255 >> (8 - i11)) << i15) & bArr[i16]) >> i15;
                i10 -= i11;
                int i18 = i12 + i11;
                this.f3492c = i18;
                if (i18 == 8) {
                    this.f3492c = 0;
                    this.f3491b = i16 + 1;
                }
                i13 = i17;
            }
            if (i10 > 0) {
                while (i10 >= 8) {
                    int i19 = i13 << 8;
                    byte[] bArr2 = this.f3490a;
                    int i20 = this.f3491b;
                    i13 = (bArr2[i20] & FastPairConstants.GO_INTENT_NOT_SET) | i19;
                    this.f3491b = i20 + 1;
                    i10 -= 8;
                }
                if (i10 > 0) {
                    int i21 = 8 - i10;
                    int i22 = (i13 << i10) | ((((255 >> i21) << i21) & this.f3490a[this.f3491b]) >> i21);
                    this.f3492c += i10;
                    return i22;
                }
                return i13;
            }
            return i13;
        }
        throw new IllegalArgumentException(String.valueOf(i10));
    }
}
