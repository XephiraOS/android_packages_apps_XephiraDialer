package com.ted.number;

import android.util.Log;
import java.io.UnsupportedEncodingException;

/* compiled from: EncodedStringValue.java */
/* loaded from: classes4.dex */
public class q implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f29693a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f29694b;

    public q(int i10, byte[] bArr) {
        if (bArr != null) {
            this.f29693a = i10;
            byte[] bArr2 = new byte[bArr.length];
            this.f29694b = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return;
        }
        throw new NullPointerException("EncodedStringValue: Text-string is null.");
    }

    public String a() {
        int i10 = this.f29693a;
        if (i10 == 0) {
            return new String(this.f29694b);
        }
        try {
            try {
                return new String(this.f29694b, a.a(i10));
            } catch (UnsupportedEncodingException unused) {
                return new String(this.f29694b);
            }
        } catch (UnsupportedEncodingException unused2) {
            return new String(this.f29694b, "iso-8859-1");
        }
    }

    public Object clone() {
        super.clone();
        byte[] bArr = this.f29694b;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        try {
            return new q(this.f29693a, bArr2);
        } catch (Exception e10) {
            Log.e("EncodedStringValue", "failed to clone an EncodedStringValue: " + this);
            Log.e("EncodedStringValue", "e=" + e10);
            throw new CloneNotSupportedException("" + e10);
        }
    }
}
