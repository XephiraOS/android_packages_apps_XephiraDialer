package com.oplus.ocs.icdf.grpcchannel.inner;

import java.io.InputStream;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private String f28674a;

    /* renamed from: b, reason: collision with root package name */
    private int f28675b;

    /* renamed from: c, reason: collision with root package name */
    private int f28676c;

    /* renamed from: d, reason: collision with root package name */
    private int f28677d;

    /* renamed from: e, reason: collision with root package name */
    private byte f28678e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f28679f;

    /* renamed from: g, reason: collision with root package name */
    private InputStream f28680g;

    public h(String str, int i10, byte b10, byte[] bArr, int i11, int i12) {
        this.f28680g = null;
        this.f28674a = str;
        this.f28675b = i10;
        this.f28678e = b10;
        this.f28679f = bArr;
        this.f28676c = i11;
        this.f28677d = i12;
    }

    public String a() {
        return this.f28674a;
    }

    public int b() {
        return this.f28676c;
    }

    public int c() {
        return this.f28675b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ad, code lost:
    
        if (r4 != r8.read(r6.array(), r7, r4)) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] a(boolean r9) {
        /*
            r8 = this;
            int r0 = r8.f28677d
            r1 = -1
            if (r0 != r1) goto L10
            int r0 = r8.f28675b
            byte r1 = r8.f28678e
            byte[] r8 = r8.f28679f
            byte[] r8 = com.oplus.ocs.icdf.grpcchannel.inner.c.a(r0, r1, r8, r9)
            return r8
        L10:
            int r1 = r8.f28675b
            byte r2 = r8.f28678e
            java.io.InputStream r8 = r8.f28680g
            int r3 = com.oplus.ocs.icdf.grpcchannel.inner.c.f28613b
            r3 = 0
            if (r9 == 0) goto L1d
            r9 = 4
            goto L1e
        L1d:
            r9 = r3
        L1e:
            if (r8 == 0) goto L25
            int r4 = r8.available()     // Catch: java.lang.Exception -> Laf
            goto L26
        L25:
            r4 = r3
        L26:
            int r5 = r4 + 11
            int r6 = r4 + 19
            int r6 = r6 + r9
            int r7 = r9 + 19
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r6)     // Catch: java.lang.Exception -> Laf
            if (r9 == 0) goto L38
            byte[] r9 = new byte[r9]     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
        L38:
            r9 = 73
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            r9 = 67
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            r9 = 68
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            r9 = 70
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r5 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r5 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r5 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            r9 = r5 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r1 >> 8
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            byte r9 = (byte) r1     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            r6.put(r2)     // Catch: java.lang.Exception -> Laf
            int r9 = r0 >> 24
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r0 >> 16
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r0 >> 8
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            byte r9 = (byte) r0     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r4 >> 24
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r4 >> 16
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            int r9 = r4 >> 8
            byte r9 = (byte) r9     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            byte r9 = (byte) r4     // Catch: java.lang.Exception -> Laf
            r6.put(r9)     // Catch: java.lang.Exception -> Laf
            if (r4 <= 0) goto Lb0
            byte[] r9 = r6.array()     // Catch: java.lang.Exception -> Laf
            int r8 = r8.read(r9, r7, r4)     // Catch: java.lang.Exception -> Laf
            if (r4 == r8) goto Lb0
        Laf:
            r6 = 0
        Lb0:
            if (r6 == 0) goto Lb3
            r3 = 1
        Lb3:
            java.lang.String r8 = "send data, pack fault!"
            com.google.common.base.k.v(r3, r8)
            byte[] r8 = r6.array()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.ocs.icdf.grpcchannel.inner.h.a(boolean):byte[]");
    }

    public h(String str, int i10, byte b10, InputStream inputStream, int i11, int i12) {
        this.f28679f = null;
        this.f28674a = str;
        this.f28675b = i10;
        this.f28678e = b10;
        this.f28680g = inputStream;
        this.f28676c = i11;
        this.f28677d = i12;
    }
}
