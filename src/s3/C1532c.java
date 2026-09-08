package s3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* renamed from: s3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1532c extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final long f36755a;

    /* renamed from: b, reason: collision with root package name */
    public int f36756b;

    public C1532c(InputStream inputStream, long j10) {
        super(inputStream);
        this.f36755a = j10;
    }

    public static InputStream c(InputStream inputStream, long j10) {
        return new C1532c(inputStream, j10);
    }

    public final int a(int i10) {
        if (i10 >= 0) {
            this.f36756b += i10;
        } else if (this.f36755a - this.f36756b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f36755a + ", but read: " + this.f36756b);
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f36755a - this.f36756b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) {
        return a(super.read(bArr, i10, i11));
    }
}
