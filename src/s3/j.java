package S3;

/* compiled from: PlanarYUVLuminanceSource.java */
/* loaded from: classes3.dex */
public final class j extends P4.c {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f3463c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3464d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3465e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3466f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3467g;

    public j(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i14, i15);
        if (i14 + i12 <= i10 && i15 + i13 <= i11) {
            this.f3463c = bArr;
            this.f3464d = i10;
            this.f3465e = i11;
            this.f3466f = i12;
            this.f3467g = i13;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    @Override // P4.c
    public byte[] b() {
        int d10 = d();
        int a10 = a();
        int i10 = this.f3464d;
        if (d10 == i10 && a10 == this.f3465e) {
            return this.f3463c;
        }
        int i11 = d10 * a10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f3467g * i10) + this.f3466f;
        if (d10 == i10) {
            System.arraycopy(this.f3463c, i12, bArr, 0, i11);
            return bArr;
        }
        byte[] bArr2 = this.f3463c;
        for (int i13 = 0; i13 < a10; i13++) {
            System.arraycopy(bArr2, i12, bArr, i13 * d10, d10);
            i12 += this.f3464d;
        }
        return bArr;
    }

    @Override // P4.c
    public byte[] c(int i10, byte[] bArr) {
        if (i10 >= 0 && i10 < a()) {
            int d10 = d();
            if (bArr == null || bArr.length < d10) {
                bArr = new byte[d10];
            }
            System.arraycopy(this.f3463c, ((i10 + this.f3467g) * this.f3464d) + this.f3466f, bArr, 0, d10);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i10);
    }
}
