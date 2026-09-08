package g3;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder.java */
/* loaded from: classes.dex */
public class g implements X2.e<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.resource.bitmap.a f31849a;

    public g(com.bumptech.glide.load.resource.bitmap.a aVar) {
        this.f31849a = aVar;
    }

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Z2.j<Bitmap> b(ByteBuffer byteBuffer, int i10, int i11, X2.d dVar) {
        return this.f31849a.g(byteBuffer, i10, i11, dVar);
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, X2.d dVar) {
        return this.f31849a.q(byteBuffer);
    }
}
