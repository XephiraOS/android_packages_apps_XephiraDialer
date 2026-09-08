package g3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import s3.C1540k;

/* compiled from: BitmapDrawableDecoder.java */
/* renamed from: g3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1039a<DataType> implements X2.e<DataType, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    public final X2.e<DataType, Bitmap> f31839a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f31840b;

    public C1039a(Resources resources, X2.e<DataType, Bitmap> eVar) {
        this.f31840b = (Resources) C1540k.d(resources);
        this.f31839a = (X2.e) C1540k.d(eVar);
    }

    @Override // X2.e
    public boolean a(DataType datatype, X2.d dVar) {
        return this.f31839a.a(datatype, dVar);
    }

    @Override // X2.e
    public Z2.j<BitmapDrawable> b(DataType datatype, int i10, int i11, X2.d dVar) {
        return q.f(this.f31840b, this.f31839a.b(datatype, i10, i11, dVar));
    }
}
