package com.bumptech.glide.load.data;

import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final OutputStream f19413a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f19414b;

    /* renamed from: c, reason: collision with root package name */
    public a3.b f19415c;

    /* renamed from: d, reason: collision with root package name */
    public int f19416d;

    public c(OutputStream outputStream, a3.b bVar) {
        this(outputStream, bVar, 65536);
    }

    public final void a() {
        int i10 = this.f19416d;
        if (i10 > 0) {
            this.f19413a.write(this.f19414b, 0, i10);
            this.f19416d = 0;
        }
    }

    public final void c() {
        if (this.f19416d == this.f19414b.length) {
            a();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f19413a.close();
            e();
        } catch (Throwable th) {
            this.f19413a.close();
            throw th;
        }
    }

    public final void e() {
        byte[] bArr = this.f19414b;
        if (bArr != null) {
            this.f19415c.d(bArr);
            this.f19414b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f19413a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        byte[] bArr = this.f19414b;
        int i11 = this.f19416d;
        this.f19416d = i11 + 1;
        bArr[i11] = (byte) i10;
        c();
    }

    public c(OutputStream outputStream, a3.b bVar, int i10) {
        this.f19413a = outputStream;
        this.f19415c = bVar;
        this.f19414b = (byte[]) bVar.e(i10, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f19416d;
            if (i15 == 0 && i13 >= this.f19414b.length) {
                this.f19413a.write(bArr, i14, i13);
                return;
            }
            int min = Math.min(i13, this.f19414b.length - i15);
            System.arraycopy(bArr, i14, this.f19414b, this.f19416d, min);
            this.f19416d += min;
            i12 += min;
            c();
        } while (i12 < i11);
    }
}
