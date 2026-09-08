package g3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import s3.C1540k;

/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: classes.dex */
public final class q implements Z2.j<BitmapDrawable>, Z2.g {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f31866a;

    /* renamed from: b, reason: collision with root package name */
    public final Z2.j<Bitmap> f31867b;

    public q(Resources resources, Z2.j<Bitmap> jVar) {
        this.f31866a = (Resources) C1540k.d(resources);
        this.f31867b = (Z2.j) C1540k.d(jVar);
    }

    public static Z2.j<BitmapDrawable> f(Resources resources, Z2.j<Bitmap> jVar) {
        if (jVar == null) {
            return null;
        }
        return new q(resources, jVar);
    }

    @Override // Z2.g
    public void a() {
        Z2.j<Bitmap> jVar = this.f31867b;
        if (jVar instanceof Z2.g) {
            ((Z2.g) jVar).a();
        }
    }

    @Override // Z2.j
    public void b() {
        this.f31867b.b();
    }

    @Override // Z2.j
    public int c() {
        return this.f31867b.c();
    }

    @Override // Z2.j
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    @Override // Z2.j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f31866a, this.f31867b.get());
    }
}
