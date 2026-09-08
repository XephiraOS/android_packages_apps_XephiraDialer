package P9;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: LineNumberInputStream.java */
/* loaded from: classes4.dex */
public class d extends FilterInputStream implements e {

    /* renamed from: a, reason: collision with root package name */
    public int f2984a;

    public d(InputStream inputStream) {
        super(inputStream);
        this.f2984a = 1;
    }

    @Override // P9.e
    public int getLineNumber() {
        return this.f2984a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read == 10) {
            this.f2984a++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        for (int i12 = i10; i12 < i10 + read; i12++) {
            if (bArr[i12] == 10) {
                this.f2984a++;
            }
        }
        return read;
    }
}
