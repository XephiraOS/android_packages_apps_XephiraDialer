package K9;

import com.heytap.accessory.constant.FastPairConstants;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: QuotedPrintableInputStream.java */
/* loaded from: classes4.dex */
public class e extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1692a;

    /* renamed from: b, reason: collision with root package name */
    public final InputStream f1693b;

    /* renamed from: c, reason: collision with root package name */
    public final T9.a f1694c;

    /* renamed from: d, reason: collision with root package name */
    public final T9.a f1695d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f1696e;

    /* renamed from: f, reason: collision with root package name */
    public int f1697f;

    /* renamed from: g, reason: collision with root package name */
    public int f1698g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1699h;

    /* renamed from: i, reason: collision with root package name */
    public final c f1700i;

    public e(InputStream inputStream, c cVar) {
        this(2048, inputStream, cVar);
    }

    public final int a(int i10) {
        if (i10 >= 48 && i10 <= 57) {
            return i10 - 48;
        }
        if (i10 >= 65 && i10 <= 70) {
            return i10 - 55;
        }
        if (i10 >= 97 && i10 <= 102) {
            return i10 - 87;
        }
        return -1;
    }

    public final int c() {
        int i10 = this.f1697f;
        int i11 = this.f1698g;
        if (i10 < i11) {
            byte[] bArr = this.f1696e;
            System.arraycopy(bArr, i10, bArr, 0, i11 - i10);
            this.f1698g -= this.f1697f;
            this.f1697f = 0;
        } else {
            this.f1698g = 0;
            this.f1697f = 0;
        }
        byte[] bArr2 = this.f1696e;
        int length = bArr2.length;
        int i12 = this.f1698g;
        int i13 = length - i12;
        if (i13 <= 0) {
            return 0;
        }
        int read = this.f1693b.read(bArr2, i12, i13);
        if (read > 0) {
            this.f1698g += read;
        }
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1699h = true;
    }

    public final int e() {
        int i10 = this.f1697f;
        if (i10 < this.f1698g) {
            byte b10 = this.f1696e[i10];
            this.f1697f = i10 + 1;
            return b10 & FastPairConstants.GO_INTENT_NOT_SET;
        }
        return -1;
    }

    public final int f(int i10) {
        int i11 = this.f1697f;
        if (i11 + i10 < this.f1698g) {
            return this.f1696e[i11 + i10] & FastPairConstants.GO_INTENT_NOT_SET;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00d3, code lost:
    
        if (r16.f1695d.byteAt(0) == 61) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00d5, code lost:
    
        r3 = l(10, r17, l(13, r17, r3, r8, false), r8, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
    
        if (r14 != 10) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ee, code lost:
    
        if (r14 != 61) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01d5, code lost:
    
        if (java.lang.Character.isWhitespace(r14) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01d7, code lost:
    
        r16.f1695d.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01de, code lost:
    
        r0 = l(r13 & com.heytap.accessory.constant.FastPairConstants.GO_INTENT_NOT_SET, r17, r3, r8, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        r1 = r16.f1698g;
        r2 = r16.f1697f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f6, code lost:
    
        if ((r1 - r2) >= 2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f8, code lost:
    
        if (r12 != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fa, code lost:
    
        r16.f1697f = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fe, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01ec, code lost:
    
        r1 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0101, code lost:
    
        r13 = e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0105, code lost:
    
        if (r13 != 61) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0156, code lost:
    
        r0 = (char) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015b, code lost:
    
        if (java.lang.Character.isWhitespace(r0) == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0176, code lost:
    
        r14 = e();
        r1 = a(r13);
        r2 = a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0182, code lost:
    
        if (r1 < 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0184, code lost:
    
        if (r2 >= 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0197, code lost:
    
        r16.f1700i.b("Malformed encoded value encountered", "leaving =" + r0 + ((char) r14) + " as is");
        r0 = l(r14, r17, l(r13, r17, l(61, r17, r3, r8, true), r8, false), r8, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0187, code lost:
    
        r0 = l((r1 << 4) | r2, r17, r3, r8, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015d, code lost:
    
        r0 = l(-1, r17, r3, r8, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0168, code lost:
    
        if (r13 == 10) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016a, code lost:
    
        r16.f1695d.a(r14);
        r16.f1695d.a(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0107, code lost:
    
        r0 = l(r13, r17, r3, r8, true);
        r1 = f(0);
        r2 = f(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011b, code lost:
    
        if (r1 == 10) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x011f, code lost:
    
        if (r1 != 13) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0121, code lost:
    
        if (r2 != 10) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x012f, code lost:
    
        r16.f1700i.b("Unexpected ==EOL encountered", "== 0x" + r1 + " 0x" + r2);
        r16.f1695d.a(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0124, code lost:
    
        r16.f1700i.b("Unexpected == encountered", "==");
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00b8, code lost:
    
        if (r16.f1695d.length() != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00ba, code lost:
    
        r3 = l(10, r17, l(13, r17, r3, r8, false), r8, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00e7, code lost:
    
        r16.f1695d.d();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K9.e.g(byte[], int, int):int");
    }

    public final int l(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        if (z10 && this.f1695d.length() > 0) {
            int min = Math.min(this.f1695d.length(), i12 - i11);
            System.arraycopy(this.f1695d.c(), 0, bArr, i11, min);
            i11 += min;
            int length = this.f1695d.length() - min;
            if (length > 0) {
                this.f1694c.b(this.f1695d.c(), min, length);
            }
            this.f1695d.d();
        } else if (this.f1695d.length() > 0 && !z10) {
            StringBuilder sb = new StringBuilder(this.f1695d.length() * 3);
            for (int i13 = 0; i13 < this.f1695d.length(); i13++) {
                sb.append(" " + ((int) this.f1695d.byteAt(i13)));
            }
            if (this.f1700i.b("ignored blanks", sb.toString())) {
                throw new IOException("ignored blanks");
            }
        }
        if (i10 != -1) {
            if (i11 < i12) {
                int i14 = i11 + 1;
                bArr[i11] = (byte) i10;
                return i14;
            }
            this.f1694c.a(i10);
            return i11;
        }
        return i11;
    }

    @Override // java.io.InputStream
    public int read() {
        int read;
        if (this.f1699h) {
            throw new IOException("Stream has been closed");
        }
        do {
            read = read(this.f1692a, 0, 1);
            if (read == -1) {
                return -1;
            }
        } while (read != 1);
        return this.f1692a[0] & FastPairConstants.GO_INTENT_NOT_SET;
    }

    public e(int i10, InputStream inputStream, c cVar) {
        this.f1692a = new byte[1];
        this.f1697f = 0;
        this.f1698g = 0;
        this.f1693b = inputStream;
        this.f1696e = new byte[i10];
        this.f1694c = new T9.a(512);
        this.f1695d = new T9.a(512);
        this.f1699h = false;
        this.f1700i = cVar;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        if (!this.f1699h) {
            return g(bArr, i10, i11);
        }
        throw new IOException("Stream has been closed");
    }

    public e(int i10, InputStream inputStream, boolean z10) {
        this(i10, inputStream, z10 ? c.f1689a : c.f1690b);
    }

    public e(InputStream inputStream, boolean z10) {
        this(2048, inputStream, z10);
    }

    public e(InputStream inputStream) {
        this(inputStream, false);
    }
}
