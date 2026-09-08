package P9;

import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.MimeIOException;

/* compiled from: MimeBoundaryInputStream.java */
/* loaded from: classes4.dex */
public class h extends f {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2989a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2990b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2991c;

    /* renamed from: d, reason: collision with root package name */
    public int f2992d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2993e;

    /* renamed from: f, reason: collision with root package name */
    public int f2994f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2995g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2996h;

    /* renamed from: i, reason: collision with root package name */
    public a f2997i;

    /* renamed from: j, reason: collision with root package name */
    public int f2998j;

    public h(a aVar, String str, boolean z10) {
        super(aVar);
        int length = str.length() * 2;
        aVar.l(length < 4096 ? 4096 : length);
        this.f2997i = aVar;
        this.f2991c = false;
        this.f2992d = -1;
        this.f2993e = false;
        this.f2994f = 0;
        this.f2995g = false;
        this.f2998j = -1;
        this.f2996h = false;
        this.f2990b = z10;
        byte[] bArr = new byte[str.length() + 2];
        this.f2989a = bArr;
        bArr[0] = 45;
        bArr[1] = 45;
        for (int i10 = 0; i10 < str.length(); i10++) {
            this.f2989a[i10 + 2] = (byte) str.charAt(i10);
        }
        l();
    }

    private int l() {
        int i10;
        int B10;
        if (this.f2991c) {
            return -1;
        }
        if (!o()) {
            i10 = this.f2997i.r();
            if (i10 == -1) {
                this.f2991c = true;
            }
        } else {
            i10 = 0;
        }
        int L10 = this.f2997i.L();
        while (true) {
            a aVar = this.f2997i;
            B10 = aVar.B(this.f2989a, L10, aVar.I() - L10);
            if (B10 == -1) {
                break;
            }
            if (B10 == this.f2997i.L() || this.f2997i.g(B10 - 1) == 10) {
                int length = this.f2989a.length + B10;
                if (this.f2997i.I() - length > 0) {
                    char g10 = (char) this.f2997i.g(length);
                    if (T9.c.a(g10) || g10 == '-') {
                        break;
                    }
                } else {
                    break;
                }
            }
            L10 = B10 + this.f2989a.length;
        }
        if (B10 != -1) {
            this.f2992d = B10;
            this.f2993e = true;
            e();
        } else if (this.f2991c) {
            this.f2992d = this.f2997i.I();
        } else {
            this.f2992d = this.f2997i.I() - (this.f2989a.length + 2);
        }
        return i10;
    }

    public final void B() {
        if (!this.f2996h) {
            this.f2996h = true;
            this.f2997i.S(this.f2994f);
            boolean z10 = true;
            while (true) {
                if (this.f2997i.G() > 1) {
                    a aVar = this.f2997i;
                    int g10 = aVar.g(aVar.L());
                    a aVar2 = this.f2997i;
                    int g11 = aVar2.g(aVar2.L() + 1);
                    if (z10 && g10 == 45 && g11 == 45) {
                        this.f2995g = true;
                        this.f2997i.S(2);
                        z10 = false;
                    } else if (g10 == 13 && g11 == 10) {
                        this.f2997i.S(2);
                        return;
                    } else {
                        if (g10 == 10) {
                            this.f2997i.S(1);
                            return;
                        }
                        this.f2997i.S(1);
                    }
                } else if (!this.f2991c) {
                    l();
                } else {
                    return;
                }
            }
        }
    }

    public final void G() {
        if (this.f2990b && this.f2991c && !this.f2993e) {
            throw new MimeIOException(new MimeException("Unexpected end of stream"));
        }
    }

    @Override // P9.f
    public int a(T9.a aVar) {
        if (aVar != null) {
            if (!y()) {
                return -1;
            }
            boolean z10 = false;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (z10) {
                    break;
                }
                if (!o()) {
                    i11 = l();
                    if (f() && !o()) {
                        B();
                        G();
                        i11 = -1;
                        break;
                    }
                }
                int L10 = this.f2992d - this.f2997i.L();
                a aVar2 = this.f2997i;
                int y10 = aVar2.y((byte) 10, aVar2.L(), L10);
                if (y10 != -1) {
                    L10 = (y10 + 1) - this.f2997i.L();
                    z10 = true;
                }
                if (L10 > 0) {
                    aVar.b(this.f2997i.e(), this.f2997i.L(), L10);
                    this.f2997i.S(L10);
                    i10 += L10;
                }
            }
            if (i10 == 0 && i11 == -1) {
                return -1;
            }
            return i10;
        }
        throw new IllegalArgumentException("Destination buffer may not be null");
    }

    @Override // P9.f
    public boolean c(T9.a aVar) {
        return false;
    }

    public final void e() {
        this.f2994f = this.f2989a.length;
        int L10 = this.f2992d - this.f2997i.L();
        if (L10 >= 0 && this.f2998j == -1) {
            this.f2998j = L10;
        }
        if (L10 > 0 && this.f2997i.g(this.f2992d - 1) == 10) {
            this.f2994f++;
            this.f2992d--;
        }
        if (L10 > 1 && this.f2997i.g(this.f2992d - 1) == 13) {
            this.f2994f++;
            this.f2992d--;
        }
    }

    public final boolean f() {
        if (!this.f2991c && !this.f2993e) {
            return false;
        }
        return true;
    }

    public boolean g() {
        if (this.f2991c && !this.f2997i.s()) {
            return true;
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public final boolean o() {
        if (this.f2992d > this.f2997i.L() && this.f2992d <= this.f2997i.I()) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.f2998j == 0) {
            return true;
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        while (y()) {
            if (o()) {
                return this.f2997i.read();
            }
            l();
        }
        return -1;
    }

    public boolean s() {
        if (this.f2996h && !this.f2997i.s()) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MimeBoundaryInputStream, boundary ");
        for (byte b10 : this.f2989a) {
            sb.append((char) b10);
        }
        return sb.toString();
    }

    public boolean u() {
        return this.f2995g;
    }

    public boolean y() {
        if (this.f2996h) {
            return false;
        }
        if (f() && !o()) {
            B();
            G();
            return false;
        }
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        while (y()) {
            if (o()) {
                return this.f2997i.read(bArr, i10, Math.min(i11, this.f2992d - this.f2997i.L()));
            }
            l();
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
