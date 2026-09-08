package a1;

/* compiled from: ApplicationParameter.java */
/* renamed from: a1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0410a {

    /* renamed from: c, reason: collision with root package name */
    public int f6275c = 1000;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f6273a = new byte[1000];

    /* renamed from: b, reason: collision with root package name */
    public int f6274b = 0;

    public void a(byte b10, byte b11, byte[] bArr) {
        int i10 = this.f6274b;
        if (i10 + b11 + 2 > this.f6275c) {
            int i11 = b11 * 4;
            byte[] bArr2 = new byte[i10 + i11];
            System.arraycopy(this.f6273a, 0, bArr2, 0, i10);
            this.f6273a = bArr2;
            this.f6275c = this.f6274b + i11;
        }
        byte[] bArr3 = this.f6273a;
        int i12 = this.f6274b;
        int i13 = i12 + 1;
        bArr3[i12] = b10;
        int i14 = i12 + 2;
        this.f6274b = i14;
        bArr3[i13] = b11;
        System.arraycopy(bArr, 0, bArr3, i14, b11);
        this.f6274b += b11;
    }

    public byte[] b() {
        int i10 = this.f6274b;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f6273a, 0, bArr, 0, i10);
        return bArr;
    }
}
