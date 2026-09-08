package J9;

/* compiled from: ByteArrayOutputStream.java */
/* loaded from: classes4.dex */
public class b extends a {
    public b() {
        this(1024);
    }

    @Override // J9.a
    public synchronized byte[] c() {
        return e();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return;
        }
        synchronized (this) {
            g(bArr, i10, i11);
        }
    }

    public b(int i10) {
        if (i10 >= 0) {
            synchronized (this) {
                a(i10);
            }
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i10);
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i10) {
        f(i10);
    }
}
