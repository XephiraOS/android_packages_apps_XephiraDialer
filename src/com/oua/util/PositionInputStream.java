package com.oua.util;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes4.dex */
class PositionInputStream extends FilterInputStream {
    private long mark;
    private long position;

    public PositionInputStream(InputStream inputStream) {
        super(inputStream);
        this.mark = -1L;
    }

    public long getPosition() {
        return this.position;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
        this.mark = this.position;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.position++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        ((FilterInputStream) this).in.reset();
        this.position = this.mark;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        long skip = ((FilterInputStream) this).in.skip(j10);
        this.position += skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (read != -1) {
            this.position += read;
        }
        return read;
    }
}
