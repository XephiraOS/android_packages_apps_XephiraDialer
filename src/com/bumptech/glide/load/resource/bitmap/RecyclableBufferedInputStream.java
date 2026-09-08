package com.bumptech.glide.load.resource.bitmap;

import com.heytap.accessory.constant.FastPairConstants;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public volatile byte[] f19645a;

    /* renamed from: b, reason: collision with root package name */
    public int f19646b;

    /* renamed from: c, reason: collision with root package name */
    public int f19647c;

    /* renamed from: d, reason: collision with root package name */
    public int f19648d;

    /* renamed from: e, reason: collision with root package name */
    public int f19649e;

    /* renamed from: f, reason: collision with root package name */
    public final a3.b f19650f;

    /* loaded from: classes.dex */
    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, a3.b bVar) {
        this(inputStream, bVar, 65536);
    }

    public static IOException f() {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) {
        int i10 = this.f19648d;
        if (i10 != -1) {
            int i11 = this.f19649e - i10;
            int i12 = this.f19647c;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f19646b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f19650f.e(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f19645a = bArr2;
                    this.f19650f.d(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f19649e - this.f19648d;
                this.f19649e = i13;
                this.f19648d = 0;
                this.f19646b = 0;
                int read = inputStream.read(bArr, i13, bArr.length - i13);
                int i14 = this.f19649e;
                if (read > 0) {
                    i14 += read;
                }
                this.f19646b = i14;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f19648d = -1;
            this.f19649e = 0;
            this.f19646b = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f19645a != null && inputStream != null) {
        } else {
            throw f();
        }
        return (this.f19646b - this.f19649e) + inputStream.available();
    }

    public synchronized void c() {
        this.f19647c = this.f19645a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f19645a != null) {
            this.f19650f.d(this.f19645a);
            this.f19645a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void e() {
        if (this.f19645a != null) {
            this.f19650f.d(this.f19645a);
            this.f19645a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.f19647c = Math.max(this.f19647c, i10);
        this.f19648d = this.f19649e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f19645a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f19649e >= this.f19646b && a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.f19645a && (bArr = this.f19645a) == null) {
                throw f();
            }
            int i10 = this.f19646b;
            int i11 = this.f19649e;
            if (i10 - i11 <= 0) {
                return -1;
            }
            this.f19649e = i11 + 1;
            return bArr[i11] & FastPairConstants.GO_INTENT_NOT_SET;
        }
        throw f();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f19645a != null) {
            int i10 = this.f19648d;
            if (-1 != i10) {
                this.f19649e = i10;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f19649e + " markLimit: " + this.f19647c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f19645a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i10 = this.f19646b;
                int i11 = this.f19649e;
                if (i10 - i11 >= j10) {
                    this.f19649e = (int) (i11 + j10);
                    return j10;
                }
                long j11 = i10 - i11;
                this.f19649e = i10;
                if (this.f19648d != -1 && j10 <= this.f19647c) {
                    if (a(inputStream, bArr) == -1) {
                        return j11;
                    }
                    int i12 = this.f19646b;
                    int i13 = this.f19649e;
                    if (i12 - i13 >= j10 - j11) {
                        this.f19649e = (int) ((i13 + j10) - j11);
                        return j10;
                    }
                    long j12 = (j11 + i12) - i13;
                    this.f19649e = i12;
                    return j12;
                }
                long skip = inputStream.skip(j10 - j11);
                if (skip > 0) {
                    this.f19648d = -1;
                }
                return j11 + skip;
            }
            throw f();
        }
        throw f();
    }

    public RecyclableBufferedInputStream(InputStream inputStream, a3.b bVar, int i10) {
        super(inputStream);
        this.f19648d = -1;
        this.f19650f = bVar;
        this.f19645a = (byte[]) bVar.e(i10, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        byte[] bArr2 = this.f19645a;
        if (bArr2 == null) {
            throw f();
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i14 = this.f19649e;
            int i15 = this.f19646b;
            if (i14 < i15) {
                int i16 = i15 - i14 >= i11 ? i11 : i15 - i14;
                System.arraycopy(bArr2, i14, bArr, i10, i16);
                this.f19649e += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.f19648d == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.f19645a && (bArr2 = this.f19645a) == null) {
                        throw f();
                    }
                    int i17 = this.f19646b;
                    int i18 = this.f19649e;
                    i13 = i17 - i18 >= i12 ? i12 : i17 - i18;
                    System.arraycopy(bArr2, i18, bArr, i10, i13);
                    this.f19649e += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            throw f();
        }
    }
}
