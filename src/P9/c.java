package P9;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: LimitedInputStream.java */
/* loaded from: classes4.dex */
public class c extends i {

    /* renamed from: c, reason: collision with root package name */
    public final long f2983c;

    public c(InputStream inputStream, long j10) {
        super(inputStream);
        if (j10 >= 0) {
            this.f2983c = j10;
            return;
        }
        throw new IllegalArgumentException("Limit may not be negative");
    }

    public final void a() {
        if (this.f2999a < this.f2983c) {
        } else {
            throw new IOException("Input stream limit exceeded");
        }
    }

    public final int c() {
        return (int) Math.min(2147483647L, this.f2983c - this.f2999a);
    }

    @Override // P9.i, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        a();
        return super.read();
    }

    @Override // P9.i, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        a();
        return super.skip(Math.min(j10, c()));
    }

    @Override // P9.i, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        a();
        return super.read(bArr, i10, Math.min(i11, c()));
    }
}
