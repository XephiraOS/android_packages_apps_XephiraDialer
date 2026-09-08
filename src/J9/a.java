package J9;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AbstractByteArrayOutputStream.java */
/* loaded from: classes4.dex */
public abstract class a extends OutputStream {

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f1604g = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public int f1606b;

    /* renamed from: c, reason: collision with root package name */
    public int f1607c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f1608d;

    /* renamed from: e, reason: collision with root package name */
    public int f1609e;

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f1605a = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public boolean f1610f = true;

    public void a(int i10) {
        if (this.f1606b < this.f1605a.size() - 1) {
            this.f1607c += this.f1608d.length;
            int i11 = this.f1606b + 1;
            this.f1606b = i11;
            this.f1608d = this.f1605a.get(i11);
            return;
        }
        byte[] bArr = this.f1608d;
        if (bArr == null) {
            this.f1607c = 0;
        } else {
            i10 = Math.max(bArr.length << 1, i10 - this.f1607c);
            this.f1607c += this.f1608d.length;
        }
        this.f1606b++;
        byte[] bArr2 = new byte[i10];
        this.f1608d = bArr2;
        this.f1605a.add(bArr2);
    }

    public abstract byte[] c();

    public byte[] e() {
        int i10 = this.f1609e;
        if (i10 == 0) {
            return f1604g;
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (byte[] bArr2 : this.f1605a) {
            int min = Math.min(bArr2.length, i10);
            System.arraycopy(bArr2, 0, bArr, i11, min);
            i11 += min;
            i10 -= min;
            if (i10 == 0) {
                break;
            }
        }
        return bArr;
    }

    public void f(int i10) {
        int i11 = this.f1609e;
        int i12 = i11 - this.f1607c;
        if (i12 == this.f1608d.length) {
            a(i11 + 1);
            i12 = 0;
        }
        this.f1608d[i12] = (byte) i10;
        this.f1609e++;
    }

    public void g(byte[] bArr, int i10, int i11) {
        int i12 = this.f1609e;
        int i13 = i12 + i11;
        int i14 = i12 - this.f1607c;
        int i15 = i11;
        while (i15 > 0) {
            int min = Math.min(i15, this.f1608d.length - i14);
            System.arraycopy(bArr, (i10 + i11) - i15, this.f1608d, i14, min);
            i15 -= min;
            if (i15 > 0) {
                a(i13);
                i14 = 0;
            }
        }
        this.f1609e = i13;
    }

    @Deprecated
    public String toString() {
        return new String(c(), Charset.defaultCharset());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
