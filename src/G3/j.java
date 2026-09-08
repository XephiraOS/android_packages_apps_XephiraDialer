package g3;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: CenterInside.java */
/* loaded from: classes.dex */
public class j extends AbstractC1044f {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f31852b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(X2.b.f4277a);

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f31852b);
    }

    @Override // g3.AbstractC1044f
    public Bitmap c(a3.d dVar, Bitmap bitmap, int i10, int i11) {
        return t.c(dVar, bitmap, i10, i11);
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        return obj instanceof j;
    }

    @Override // X2.b
    public int hashCode() {
        return -670243078;
    }
}
