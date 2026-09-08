package d5;

import com.google.zxing.FormatException;

/* compiled from: DecodedNumeric.java */
/* loaded from: classes3.dex */
public final class o extends p {

    /* renamed from: b, reason: collision with root package name */
    public final int f30046b;

    /* renamed from: c, reason: collision with root package name */
    public final int f30047c;

    public o(int i10, int i11, int i12) {
        super(i10);
        if (i11 >= 0 && i11 <= 10 && i12 >= 0 && i12 <= 10) {
            this.f30046b = i11;
            this.f30047c = i12;
            return;
        }
        throw FormatException.a();
    }

    public int b() {
        return this.f30046b;
    }

    public int c() {
        return this.f30047c;
    }

    public boolean d() {
        if (this.f30046b == 10) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f30047c == 10) {
            return true;
        }
        return false;
    }
}
