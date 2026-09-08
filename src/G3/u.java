package g3;

import android.graphics.Bitmap;
import s3.C1541l;

/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class u implements X2.e<Bitmap, Bitmap> {
    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Z2.j<Bitmap> b(Bitmap bitmap, int i10, int i11, X2.d dVar) {
        return new a(bitmap);
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Bitmap bitmap, X2.d dVar) {
        return true;
    }

    /* compiled from: UnitBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static final class a implements Z2.j<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final Bitmap f31876a;

        public a(Bitmap bitmap) {
            this.f31876a = bitmap;
        }

        @Override // Z2.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f31876a;
        }

        @Override // Z2.j
        public int c() {
            return C1541l.h(this.f31876a);
        }

        @Override // Z2.j
        public Class<Bitmap> d() {
            return Bitmap.class;
        }

        @Override // Z2.j
        public void b() {
        }
    }
}
