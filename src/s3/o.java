package S3;

import android.graphics.Bitmap;

/* compiled from: RGBLuminanceSource.java */
/* loaded from: classes3.dex */
public final class o extends P4.c {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f3475c;

    public o(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = width * height;
        int[] iArr = new int[i10];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f3475c = new byte[i10];
        for (int i11 = 0; i11 < height; i11++) {
            int i12 = i11 * width;
            for (int i13 = 0; i13 < width; i13++) {
                int i14 = i12 + i13;
                int i15 = iArr[i14];
                int i16 = (i15 >> 16) & 255;
                int i17 = (i15 >> 8) & 255;
                int i18 = i15 & 255;
                if (i16 == i17 && i17 == i18) {
                    this.f3475c[i14] = (byte) i16;
                } else {
                    this.f3475c[i14] = (byte) ((((i16 + i17) + i17) + i18) >> 2);
                }
            }
        }
    }

    @Override // P4.c
    public byte[] b() {
        return this.f3475c;
    }

    @Override // P4.c
    public byte[] c(int i10, byte[] bArr) {
        if (i10 >= 0 && i10 < a()) {
            int d10 = d();
            if (bArr == null || bArr.length < d10) {
                bArr = new byte[d10];
            }
            System.arraycopy(this.f3475c, i10 * d10, bArr, 0, d10);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i10);
    }
}
