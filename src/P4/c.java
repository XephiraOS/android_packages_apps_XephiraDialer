package P4;

import com.heytap.accessory.constant.FastPairConstants;

/* compiled from: LuminanceSource.java */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f2944a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2945b;

    public c(int i10, int i11) {
        this.f2944a = i10;
        this.f2945b = i11;
    }

    public final int a() {
        return this.f2945b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i10, byte[] bArr);

    public final int d() {
        return this.f2944a;
    }

    public boolean e() {
        return false;
    }

    public c f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        char c10;
        int i10 = this.f2944a;
        byte[] bArr = new byte[i10];
        StringBuilder sb = new StringBuilder(this.f2945b * (i10 + 1));
        for (int i11 = 0; i11 < this.f2945b; i11++) {
            bArr = c(i11, bArr);
            for (int i12 = 0; i12 < this.f2944a; i12++) {
                int i13 = bArr[i12] & FastPairConstants.GO_INTENT_NOT_SET;
                if (i13 < 64) {
                    c10 = '#';
                } else if (i13 < 128) {
                    c10 = '+';
                } else if (i13 < 192) {
                    c10 = '.';
                } else {
                    c10 = ' ';
                }
                sb.append(c10);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
