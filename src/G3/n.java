package g3;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: FitCenter.java */
/* loaded from: classes.dex */
public class n extends AbstractC1044f {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f31856b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(X2.b.f4277a);

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f31856b);
    }

    @Override // g3.AbstractC1044f
    public Bitmap c(a3.d dVar, Bitmap bitmap, int i10, int i11) {
        return t.e(dVar, bitmap, i10, i11);
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        return obj instanceof n;
    }

    @Override // X2.b
    public int hashCode() {
        return 1572326941;
    }
}
