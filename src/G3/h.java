package g3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapImageDecoderResourceDecoder.java */
/* loaded from: classes.dex */
public final class h implements X2.e<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final C1042d f31850a = new C1042d();

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Z2.j<Bitmap> b(ByteBuffer byteBuffer, int i10, int i11, X2.d dVar) {
        return this.f31850a.b(ImageDecoder.createSource(byteBuffer), i10, i11, dVar);
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, X2.d dVar) {
        return true;
    }
}
