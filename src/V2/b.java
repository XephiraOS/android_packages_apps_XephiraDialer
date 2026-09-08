package V2;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
public class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f3997a;

    /* renamed from: b, reason: collision with root package name */
    public final Charset f3998b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f3999c;

    /* renamed from: d, reason: collision with root package name */
    public int f4000d;

    /* renamed from: e, reason: collision with root package name */
    public int f4001e;

    /* compiled from: StrictLineReader.java */
    /* loaded from: classes.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, b.this.f3998b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void c() {
        InputStream inputStream = this.f3997a;
        byte[] bArr = this.f3999c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f4000d = 0;
            this.f4001e = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f3997a) {
            try {
                if (this.f3999c != null) {
                    this.f3999c = null;
                    this.f3997a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e() {
        if (this.f4001e == -1) {
            return true;
        }
        return false;
    }

    public String f() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f3997a) {
            try {
                if (this.f3999c != null) {
                    if (this.f4000d >= this.f4001e) {
                        c();
                    }
                    for (int i12 = this.f4000d; i12 != this.f4001e; i12++) {
                        byte[] bArr2 = this.f3999c;
                        if (bArr2[i12] == 10) {
                            int i13 = this.f4000d;
                            if (i12 != i13) {
                                i11 = i12 - 1;
                                if (bArr2[i11] == 13) {
                                    String str = new String(bArr2, i13, i11 - i13, this.f3998b.name());
                                    this.f4000d = i12 + 1;
                                    return str;
                                }
                            }
                            i11 = i12;
                            String str2 = new String(bArr2, i13, i11 - i13, this.f3998b.name());
                            this.f4000d = i12 + 1;
                            return str2;
                        }
                    }
                    a aVar = new a((this.f4001e - this.f4000d) + 80);
                    loop1: while (true) {
                        byte[] bArr3 = this.f3999c;
                        int i14 = this.f4000d;
                        aVar.write(bArr3, i14, this.f4001e - i14);
                        this.f4001e = -1;
                        c();
                        i10 = this.f4000d;
                        while (i10 != this.f4001e) {
                            bArr = this.f3999c;
                            if (bArr[i10] == 10) {
                                break loop1;
                            }
                            i10++;
                        }
                    }
                    int i15 = this.f4000d;
                    if (i10 != i15) {
                        aVar.write(bArr, i15, i10 - i15);
                    }
                    this.f4000d = i10 + 1;
                    return aVar.toString();
                }
                throw new IOException("LineReader is closed");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public b(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 >= 0) {
            if (charset.equals(c.f4003a)) {
                this.f3997a = inputStream;
                this.f3998b = charset;
                this.f3999c = new byte[i10];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
