package P9;

import com.heytap.accessory.constant.FastPairConstants;
import java.io.FilterInputStream;
import java.io.InputStream;
import org.apache.james.mime4j.io.MaxLineLimitException;

/* compiled from: BufferedLineReaderInputStream.java */
/* loaded from: classes4.dex */
public class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2971a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2972b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2973c;

    /* renamed from: d, reason: collision with root package name */
    public int f2974d;

    /* renamed from: e, reason: collision with root package name */
    public int f2975e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2976f;

    /* renamed from: g, reason: collision with root package name */
    public int f2977g;

    /* renamed from: h, reason: collision with root package name */
    public int f2978h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2979i;

    public a(InputStream inputStream, int i10, int i11) {
        super(inputStream);
        this.f2972b = false;
        if (inputStream != null) {
            if (i10 > 0) {
                this.f2976f = new byte[i10];
                this.f2977g = 0;
                this.f2978h = 0;
                this.f2979i = i11;
                this.f2971a = false;
                return;
            }
            throw new IllegalArgumentException("Buffer size may not be negative or zero");
        }
        throw new IllegalArgumentException("Input stream may not be null");
    }

    public int B(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            if (i10 >= this.f2977g && i11 >= 0 && i10 + i11 <= this.f2978h) {
                if (i11 < bArr.length) {
                    return -1;
                }
                int[] iArr = new int[256];
                for (int i12 = 0; i12 < 256; i12++) {
                    iArr[i12] = bArr.length + 1;
                }
                for (int i13 = 0; i13 < bArr.length; i13++) {
                    iArr[bArr[i13] & FastPairConstants.GO_INTENT_NOT_SET] = bArr.length - i13;
                }
                int i14 = 0;
                while (i14 <= i11 - bArr.length) {
                    int i15 = i10 + i14;
                    for (int i16 = 0; i16 < bArr.length; i16++) {
                        byte[] bArr2 = this.f2976f;
                        if (bArr2[i15 + i16] != bArr[i16]) {
                            int length = i15 + bArr.length;
                            if (length >= bArr2.length) {
                                break;
                            }
                            i14 += iArr[bArr2[length] & FastPairConstants.GO_INTENT_NOT_SET];
                        }
                    }
                    return i15;
                }
                return -1;
            }
            throw new IndexOutOfBoundsException("looking for " + i10 + "(" + i11 + ") in " + this.f2977g + "/" + this.f2978h);
        }
        throw new IllegalArgumentException("Pattern may not be null");
    }

    public int G() {
        return f();
    }

    public int I() {
        return this.f2978h;
    }

    public int L() {
        return this.f2977g;
    }

    public boolean O() {
        return !this.f2971a;
    }

    public int S(int i10) {
        int min = Math.min(i10, f());
        this.f2977g += min;
        return min;
    }

    @Override // P9.f
    public int a(T9.a aVar) {
        int G10;
        if (aVar != null) {
            if (!O()) {
                return -1;
            }
            boolean z10 = false;
            int i10 = 0;
            int i11 = 0;
            while (!z10 && (s() || (i11 = r()) != -1)) {
                int u10 = u((byte) 10);
                if (u10 != -1) {
                    G10 = (u10 + 1) - L();
                    z10 = true;
                } else {
                    G10 = G();
                }
                if (G10 > 0) {
                    aVar.b(e(), L(), G10);
                    S(G10);
                    i10 += G10;
                }
                if (this.f2979i > 0 && aVar.length() >= this.f2979i) {
                    throw new MaxLineLimitException("Maximum line length limit exceeded");
                }
            }
            if (i10 == 0 && i11 == -1) {
                return -1;
            }
            return i10;
        }
        throw new IllegalArgumentException("Buffer may not be null");
    }

    @Override // P9.f
    public boolean c(T9.a aVar) {
        if (this.f2972b) {
            return false;
        }
        this.f2973c = this.f2976f;
        this.f2975e = this.f2978h;
        this.f2974d = this.f2977g;
        this.f2977g = 0;
        this.f2978h = aVar.length();
        this.f2976f = aVar.c();
        this.f2972b = true;
        return true;
    }

    public byte[] e() {
        return this.f2976f;
    }

    public final int f() {
        return this.f2978h - this.f2977g;
    }

    public int g(int i10) {
        if (i10 >= this.f2977g && i10 <= this.f2978h) {
            return this.f2976f[i10] & FastPairConstants.GO_INTENT_NOT_SET;
        }
        throw new IndexOutOfBoundsException("looking for " + i10 + " in " + this.f2977g + "/" + this.f2978h);
    }

    public void l(int i10) {
        if (i10 > this.f2976f.length) {
            o(i10);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public final void o(int i10) {
        byte[] bArr = new byte[i10];
        int f10 = f();
        if (f10 > 0) {
            byte[] bArr2 = this.f2976f;
            int i11 = this.f2977g;
            System.arraycopy(bArr2, i11, bArr, i11, f10);
        }
        this.f2976f = bArr;
    }

    public int r() {
        if (this.f2972b) {
            if (this.f2977g == this.f2978h) {
                this.f2976f = this.f2973c;
                this.f2978h = this.f2975e;
                this.f2977g = this.f2974d;
                this.f2972b = false;
                return f();
            }
            throw new IllegalStateException("unread only works when a buffer is fully read before the next refill is asked!");
        }
        if (this.f2977g > 0) {
            int f10 = f();
            if (f10 > 0) {
                byte[] bArr = this.f2976f;
                System.arraycopy(bArr, this.f2977g, bArr, 0, f10);
            }
            this.f2977g = 0;
            this.f2978h = f10;
        }
        int i10 = this.f2978h;
        int read = ((FilterInputStream) this).in.read(this.f2976f, i10, this.f2976f.length - i10);
        if (read == -1) {
            return -1;
        }
        this.f2978h = i10 + read;
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (!O()) {
            return -1;
        }
        while (!s()) {
            if (r() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.f2976f;
        int i10 = this.f2977g;
        this.f2977g = i10 + 1;
        return bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET;
    }

    public boolean s() {
        if (f() > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[pos: ");
        sb.append(this.f2977g);
        sb.append("]");
        sb.append("[limit: ");
        sb.append(this.f2978h);
        sb.append("]");
        sb.append("[");
        for (int i10 = this.f2977g; i10 < this.f2978h; i10++) {
            sb.append((char) this.f2976f[i10]);
        }
        sb.append("]");
        if (this.f2972b) {
            sb.append("-ORIG[pos: ");
            sb.append(this.f2974d);
            sb.append("]");
            sb.append("[limit: ");
            sb.append(this.f2975e);
            sb.append("]");
            sb.append("[");
            for (int i11 = this.f2974d; i11 < this.f2975e; i11++) {
                sb.append((char) this.f2973c[i11]);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public int u(byte b10) {
        return y(b10, this.f2977g, f());
    }

    public int y(byte b10, int i10, int i11) {
        int i12;
        if (i10 >= this.f2977g && i11 >= 0 && (i12 = i11 + i10) <= this.f2978h) {
            while (i10 < i12) {
                if (this.f2976f[i10] == b10) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        if (!O()) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        while (!s()) {
            if (r() == -1) {
                return -1;
            }
        }
        int f10 = f();
        if (f10 <= i11) {
            i11 = f10;
        }
        System.arraycopy(this.f2976f, this.f2977g, bArr, i10, i11);
        this.f2977g += i11;
        return i11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        if (!O()) {
            return -1;
        }
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }
}
