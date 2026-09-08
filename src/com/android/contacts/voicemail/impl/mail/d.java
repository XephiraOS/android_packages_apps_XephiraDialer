package com.android.contacts.voicemail.impl.mail;

import java.io.InputStream;

/* compiled from: FixedLengthInputStream.java */
/* loaded from: classes.dex */
public class d extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f18078a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18079b;

    /* renamed from: c, reason: collision with root package name */
    public int f18080c;

    public d(InputStream inputStream, int i10) {
        this.f18078a = inputStream;
        this.f18079b = i10;
    }

    public int a() {
        return this.f18079b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f18079b - this.f18080c;
    }

    @Override // java.io.InputStream
    public int read() {
        int i10 = this.f18080c;
        if (i10 >= this.f18079b) {
            return -1;
        }
        this.f18080c = i10 + 1;
        return this.f18078a.read();
    }

    public String toString() {
        return String.format("FixedLengthInputStream(in=%s, length=%d)", this.f18078a.toString(), Integer.valueOf(this.f18079b));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int read;
        int i12 = this.f18080c;
        int i13 = this.f18079b;
        if (i12 >= i13 || (read = this.f18078a.read(bArr, i10, Math.min(i13 - i12, i11))) == -1) {
            return -1;
        }
        this.f18080c += read;
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
