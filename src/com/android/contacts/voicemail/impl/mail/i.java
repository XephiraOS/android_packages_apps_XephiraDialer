package com.android.contacts.voicemail.impl.mail;

import java.io.InputStream;

/* compiled from: PeekableInputStream.java */
/* loaded from: classes.dex */
public class i extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f18099a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18100b;

    /* renamed from: c, reason: collision with root package name */
    public int f18101c;

    public i(InputStream inputStream) {
        this.f18099a = inputStream;
    }

    public int a() {
        if (!this.f18100b) {
            this.f18101c = read();
            this.f18100b = true;
        }
        return this.f18101c;
    }

    @Override // java.io.InputStream
    public int read() {
        if (!this.f18100b) {
            return this.f18099a.read();
        }
        this.f18100b = false;
        return this.f18101c;
    }

    public String toString() {
        return String.format("PeekableInputStream(in=%s, peeked=%b, peekedByte=%d)", this.f18099a.toString(), Boolean.valueOf(this.f18100b), Integer.valueOf(this.f18101c));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        if (!this.f18100b) {
            return this.f18099a.read(bArr, i10, i11);
        }
        bArr[0] = (byte) this.f18101c;
        this.f18100b = false;
        int read = this.f18099a.read(bArr, i10 + 1, i11 - 1);
        if (read == -1) {
            return 1;
        }
        return read + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
