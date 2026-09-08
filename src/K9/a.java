package K9;

import com.heytap.accessory.constant.FastPairConstants;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Base64InputStream.java */
/* loaded from: classes4.dex */
public class a extends InputStream {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f1676j = new int[256];

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1677a;

    /* renamed from: b, reason: collision with root package name */
    public final InputStream f1678b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f1679c;

    /* renamed from: d, reason: collision with root package name */
    public final T9.a f1680d;

    /* renamed from: e, reason: collision with root package name */
    public int f1681e;

    /* renamed from: f, reason: collision with root package name */
    public int f1682f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1683g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1684h;

    /* renamed from: i, reason: collision with root package name */
    public final c f1685i;

    static {
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            f1676j[i11] = -1;
        }
        while (true) {
            byte[] bArr = b.f1687b;
            if (i10 < bArr.length) {
                f1676j[bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET] = i10;
                i10++;
            } else {
                return;
            }
        }
    }

    public a(InputStream inputStream, c cVar) {
        this(1536, inputStream, cVar);
    }

    public final int a(int i10, int i11, byte[] bArr, int i12, int i13) {
        this.f1684h = true;
        if (i11 == 2) {
            byte b10 = (byte) (i10 >>> 4);
            if (i12 < i13) {
                int i14 = i12 + 1;
                bArr[i12] = b10;
                return i14;
            }
            this.f1680d.a(b10);
            return i12;
        }
        if (i11 == 3) {
            byte b11 = (byte) (i10 >>> 10);
            byte b12 = (byte) ((i10 >>> 2) & 255);
            if (i12 < i13 - 1) {
                int i15 = i12 + 1;
                bArr[i12] = b11;
                int i16 = i12 + 2;
                bArr[i15] = b12;
                return i16;
            }
            if (i12 < i13) {
                int i17 = i12 + 1;
                bArr[i12] = b11;
                this.f1680d.a(b12);
                return i17;
            }
            this.f1680d.a(b11);
            this.f1680d.a(b12);
            return i12;
        }
        c(i11);
        return i12;
    }

    public final void c(int i10) {
        if (!this.f1685i.b("Unexpected padding character", "dropping " + i10 + " sextet(s)")) {
        } else {
            throw new IOException("Unexpected padding character");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f1683g) {
            return;
        }
        this.f1683g = true;
    }

    public final void e(int i10) {
        if (!this.f1685i.b("Unexpected end of BASE64 stream", "dropping " + i10 + " sextet(s)")) {
        } else {
            throw new IOException("Unexpected end of BASE64 stream");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0107, code lost:
    
        r0 = r3;
        r3 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(byte[] r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K9.a.f(byte[], int, int):int");
    }

    @Override // java.io.InputStream
    public int read() {
        int f10;
        if (this.f1683g) {
            throw new IOException("Stream has been closed");
        }
        do {
            f10 = f(this.f1677a, 0, 1);
            if (f10 == -1) {
                return -1;
            }
        } while (f10 != 1);
        return this.f1677a[0] & FastPairConstants.GO_INTENT_NOT_SET;
    }

    public a(int i10, InputStream inputStream, c cVar) {
        this.f1677a = new byte[1];
        this.f1681e = 0;
        this.f1682f = 0;
        this.f1683g = false;
        if (inputStream != null) {
            this.f1679c = new byte[i10];
            this.f1680d = new T9.a(512);
            this.f1678b = inputStream;
            this.f1685i = cVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        if (!this.f1683g) {
            bArr.getClass();
            if (bArr.length == 0) {
                return 0;
            }
            return f(bArr, 0, bArr.length);
        }
        throw new IOException("Stream has been closed");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        if (!this.f1683g) {
            bArr.getClass();
            if (i10 < 0 || i11 < 0 || i10 + i11 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i11 == 0) {
                return 0;
            }
            return f(bArr, i10, i11);
        }
        throw new IOException("Stream has been closed");
    }
}
