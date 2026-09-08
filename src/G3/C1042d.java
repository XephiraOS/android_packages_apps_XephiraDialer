package g3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import f3.C0997a;

/* compiled from: BitmapImageDecoderResourceDecoder.java */
/* renamed from: g3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1042d implements X2.e<ImageDecoder.Source, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f31846a = new a3.e();

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Z2.j<Bitmap> b(ImageDecoder.Source source, int i10, int i11, X2.d dVar) {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new C0997a(i10, i11, dVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i10 + "x" + i11 + "]");
        }
        return new C1043e(decodeBitmap, this.f31846a);
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ImageDecoder.Source source, X2.d dVar) {
        return true;
    }
}
