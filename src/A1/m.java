package a1;

import com.heytap.accessory.constant.FastPairConstants;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: PrivateInputStream.java */
/* loaded from: classes.dex */
public final class m extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0411b f6346a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f6347b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public int f6348c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6349d = true;

    public m(InterfaceC0411b interfaceC0411b) {
        this.f6346a = interfaceC0411b;
    }

    public final void a() {
        this.f6346a.b();
        if (this.f6349d) {
        } else {
            throw new IOException("Input stream is closed");
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        a();
        return this.f6347b.length - this.f6348c;
    }

    public synchronized void c(byte[] bArr, int i10) {
        int length = bArr.length - i10;
        byte[] bArr2 = this.f6347b;
        int length2 = bArr2.length;
        int i11 = this.f6348c;
        byte[] bArr3 = new byte[length + (length2 - i11)];
        System.arraycopy(bArr2, i11, bArr3, 0, bArr2.length - i11);
        System.arraycopy(bArr, i10, bArr3, this.f6347b.length - this.f6348c, bArr.length - i10);
        this.f6347b = bArr3;
        this.f6348c = 0;
        notifyAll();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6349d = false;
        this.f6346a.a(true);
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        a();
        do {
            byte[] bArr = this.f6347b;
            int length = bArr.length;
            int i10 = this.f6348c;
            if (length != i10) {
                this.f6348c = i10 + 1;
                return bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET;
            }
        } while (this.f6346a.c(true, true));
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) {
        try {
            if (bArr != null) {
                if ((i10 | i11) >= 0 && i11 <= bArr.length - i10) {
                    a();
                    int length = this.f6347b.length - this.f6348c;
                    int i12 = 0;
                    while (length <= i11) {
                        System.arraycopy(this.f6347b, this.f6348c, bArr, i10, length);
                        this.f6348c += length;
                        i10 += length;
                        i12 += length;
                        i11 -= length;
                        if (!this.f6346a.c(true, true)) {
                            if (i12 == 0) {
                                i12 = -1;
                            }
                            return i12;
                        }
                        length = this.f6347b.length - this.f6348c;
                    }
                    if (i11 > 0) {
                        System.arraycopy(this.f6347b, this.f6348c, bArr, i10, i11);
                        this.f6348c += i11;
                        i12 += i11;
                    }
                    return i12;
                }
                throw new ArrayIndexOutOfBoundsException("index outof bound");
            }
            throw new IOException("buffer is null");
        } catch (Throwable th) {
            throw th;
        }
    }
}
