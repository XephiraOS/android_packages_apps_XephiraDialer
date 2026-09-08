package com.bumptech.glide.load.data;

import com.heytap.accessory.constant.FastPairConstants;
import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: ExifOrientationStream.java */
/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f19420c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f19421d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f19422e;

    /* renamed from: a, reason: collision with root package name */
    public final byte f19423a;

    /* renamed from: b, reason: collision with root package name */
    public int f19424b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f19420c = bArr;
        int length = bArr.length;
        f19421d = length;
        f19422e = length + 2;
    }

    public g(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 >= -1 && i10 <= 8) {
            this.f19423a = (byte) i10;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read;
        int i10;
        int i11 = this.f19424b;
        if (i11 < 2 || i11 > (i10 = f19422e)) {
            read = super.read();
        } else if (i11 == i10) {
            read = this.f19423a;
        } else {
            read = f19420c[i11 - 2] & FastPairConstants.GO_INTENT_NOT_SET;
        }
        if (read != -1) {
            this.f19424b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        long skip = super.skip(j10);
        if (skip > 0) {
            this.f19424b = (int) (this.f19424b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = this.f19424b;
        int i14 = f19422e;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.f19423a;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int min = Math.min(i14 - i13, i11);
            System.arraycopy(f19420c, this.f19424b - 2, bArr, i10, min);
            i12 = min;
        }
        if (i12 > 0) {
            this.f19424b += i12;
        }
        return i12;
    }
}
