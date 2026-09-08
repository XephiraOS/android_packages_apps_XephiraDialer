package T9;

/* compiled from: ByteArrayBuffer.java */
/* loaded from: classes4.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f3785a;

    /* renamed from: b, reason: collision with root package name */
    public int f3786b;

    public a(int i10) {
        if (i10 >= 0) {
            this.f3785a = new byte[i10];
            return;
        }
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    public void a(int i10) {
        int i11 = this.f3786b + 1;
        if (i11 > this.f3785a.length) {
            e(i11);
        }
        this.f3785a[this.f3786b] = (byte) i10;
        this.f3786b = i11;
    }

    public void b(byte[] bArr, int i10, int i11) {
        int i12;
        if (bArr == null) {
            return;
        }
        if (i10 >= 0 && i10 <= bArr.length && i11 >= 0 && (i12 = i10 + i11) >= 0 && i12 <= bArr.length) {
            if (i11 == 0) {
                return;
            }
            int i13 = this.f3786b + i11;
            if (i13 > this.f3785a.length) {
                e(i13);
            }
            System.arraycopy(bArr, i10, this.f3785a, this.f3786b, i11);
            this.f3786b = i13;
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // T9.b
    public byte byteAt(int i10) {
        if (i10 >= 0 && i10 < this.f3786b) {
            return this.f3785a[i10];
        }
        throw new IndexOutOfBoundsException();
    }

    public byte[] c() {
        return this.f3785a;
    }

    public void d() {
        this.f3786b = 0;
    }

    public final void e(int i10) {
        byte[] bArr = new byte[Math.max(this.f3785a.length << 1, i10)];
        System.arraycopy(this.f3785a, 0, bArr, 0, this.f3786b);
        this.f3785a = bArr;
    }

    public void f(int i10, int i11) {
        int i12;
        int i13;
        if (i10 >= 0 && i10 <= (i12 = this.f3786b) && i11 >= 0 && (i13 = i10 + i11) >= 0 && i13 <= i12) {
            if (i11 == 0) {
                return;
            }
            int i14 = (i12 - i10) - i11;
            if (i14 > 0) {
                byte[] bArr = this.f3785a;
                System.arraycopy(bArr, i13, bArr, i10, i14);
            }
            this.f3786b -= i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public byte[] g() {
        int i10 = this.f3786b;
        byte[] bArr = new byte[i10];
        if (i10 > 0) {
            System.arraycopy(this.f3785a, 0, bArr, 0, i10);
        }
        return bArr;
    }

    @Override // T9.b
    public int length() {
        return this.f3786b;
    }

    public String toString() {
        return new String(g());
    }

    public a(byte[] bArr, int i10, boolean z10) {
        if (bArr != null) {
            if (i10 >= 0 && i10 <= bArr.length) {
                if (z10) {
                    this.f3785a = bArr;
                } else {
                    byte[] bArr2 = new byte[i10];
                    this.f3785a = bArr2;
                    System.arraycopy(bArr, 0, bArr2, 0, i10);
                }
                this.f3786b = i10;
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }
}
