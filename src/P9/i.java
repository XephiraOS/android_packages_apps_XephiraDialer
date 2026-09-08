package P9;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: PositionInputStream.java */
/* loaded from: classes4.dex */
public class i extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f2999a;

    /* renamed from: b, reason: collision with root package name */
    public long f3000b;

    public i(InputStream inputStream) {
        super(inputStream);
        this.f2999a = 0L;
        this.f3000b = 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return ((FilterInputStream) this).in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterInputStream) this).in.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
        this.f3000b = this.f2999a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f2999a++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        ((FilterInputStream) this).in.reset();
        this.f2999a = this.f3000b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        long skip = ((FilterInputStream) this).in.skip(j10);
        if (skip > 0) {
            this.f2999a += skip;
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (read > 0) {
            this.f2999a += read;
        }
        return read;
    }
}
