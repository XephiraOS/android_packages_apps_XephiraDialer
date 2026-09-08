package g3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.InputStream;
import s3.C1530a;

/* compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public final class p implements X2.e<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final C1042d f31865a = new C1042d();

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Z2.j<Bitmap> b(InputStream inputStream, int i10, int i11, X2.d dVar) {
        return this.f31865a.b(ImageDecoder.createSource(C1530a.b(inputStream)), i10, i11, dVar);
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, X2.d dVar) {
        return true;
    }
}
