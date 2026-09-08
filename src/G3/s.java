package g3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import i3.C1096e;

/* compiled from: ResourceBitmapDecoder.java */
/* loaded from: classes.dex */
public class s implements X2.e<Uri, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    public final C1096e f31869a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.d f31870b;

    public s(C1096e c1096e, a3.d dVar) {
        this.f31869a = c1096e;
        this.f31870b = dVar;
    }

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Z2.j<Bitmap> b(Uri uri, int i10, int i11, X2.d dVar) {
        Z2.j<Drawable> b10 = this.f31869a.b(uri, i10, i11, dVar);
        if (b10 == null) {
            return null;
        }
        return k.a(this.f31870b, b10.get(), i10, i11);
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, X2.d dVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
