package g3;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: CenterCrop.java */
/* loaded from: classes.dex */
public class i extends AbstractC1044f {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f31851b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(X2.b.f4277a);

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f31851b);
    }

    @Override // g3.AbstractC1044f
    public Bitmap c(a3.d dVar, Bitmap bitmap, int i10, int i11) {
        return t.b(dVar, bitmap, i10, i11);
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // X2.b
    public int hashCode() {
        return -599754482;
    }
}
