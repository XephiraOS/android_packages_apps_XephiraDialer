package s3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionPassthroughInputStream.java */
/* renamed from: s3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1533d extends InputStream {

    /* renamed from: c, reason: collision with root package name */
    public static final Queue<C1533d> f36757c = C1541l.f(0);

    /* renamed from: a, reason: collision with root package name */
    public InputStream f36758a;

    /* renamed from: b, reason: collision with root package name */
    public IOException f36759b;

    public static C1533d c(InputStream inputStream) {
        C1533d poll;
        Queue<C1533d> queue = f36757c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new C1533d();
        }
        poll.f(inputStream);
        return poll;
    }

    public IOException a() {
        return this.f36759b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f36758a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f36758a.close();
    }

    public void e() {
        this.f36759b = null;
        this.f36758a = null;
        Queue<C1533d> queue = f36757c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public void f(InputStream inputStream) {
        this.f36758a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f36758a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f36758a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f36758a.read();
        } catch (IOException e10) {
            this.f36759b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f36758a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        try {
            return this.f36758a.skip(j10);
        } catch (IOException e10) {
            this.f36759b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f36758a.read(bArr);
        } catch (IOException e10) {
            this.f36759b = e10;
            throw e10;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        try {
            return this.f36758a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f36759b = e10;
            throw e10;
        }
    }
}
