package io.grpc.internal;

import io.grpc.Status;
import java.io.FilterInputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
final class MessageDeframer$SizeEnforcingInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final int f32774a;

    /* renamed from: b, reason: collision with root package name */
    public final s0 f32775b;

    /* renamed from: c, reason: collision with root package name */
    public long f32776c;

    /* renamed from: d, reason: collision with root package name */
    public long f32777d;

    /* renamed from: e, reason: collision with root package name */
    public long f32778e;

    public final void a() {
        long j10 = this.f32777d;
        long j11 = this.f32776c;
        if (j10 > j11) {
            this.f32775b.f(j10 - j11);
            this.f32776c = this.f32777d;
        }
    }

    public final void c() {
        if (this.f32777d <= this.f32774a) {
            return;
        }
        throw Status.f32377n.r("Decompressed gRPC message exceeds maximum size " + this.f32774a).c();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
        this.f32778e = this.f32777d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f32777d++;
        }
        c();
        a();
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (((FilterInputStream) this).in.markSupported()) {
            if (this.f32778e != -1) {
                ((FilterInputStream) this).in.reset();
                this.f32777d = this.f32778e;
            } else {
                throw new IOException("Mark not set");
            }
        } else {
            throw new IOException("Mark not supported");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        long skip = ((FilterInputStream) this).in.skip(j10);
        this.f32777d += skip;
        c();
        a();
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (read != -1) {
            this.f32777d += read;
        }
        c();
        a();
        return read;
    }
}
