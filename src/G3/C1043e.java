package g3;

import android.graphics.Bitmap;
import s3.C1540k;
import s3.C1541l;

/* compiled from: BitmapResource.java */
/* renamed from: g3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1043e implements Z2.j<Bitmap>, Z2.g {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f31847a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.d f31848b;

    public C1043e(Bitmap bitmap, a3.d dVar) {
        this.f31847a = (Bitmap) C1540k.e(bitmap, "Bitmap must not be null");
        this.f31848b = (a3.d) C1540k.e(dVar, "BitmapPool must not be null");
    }

    public static C1043e f(Bitmap bitmap, a3.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new C1043e(bitmap, dVar);
    }

    @Override // Z2.g
    public void a() {
        this.f31847a.prepareToDraw();
    }

    @Override // Z2.j
    public void b() {
        this.f31848b.c(this.f31847a);
    }

    @Override // Z2.j
    public int c() {
        return C1541l.h(this.f31847a);
    }

    @Override // Z2.j
    public Class<Bitmap> d() {
        return Bitmap.class;
    }

    @Override // Z2.j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f31847a;
    }
}
