package a3;

import android.graphics.Bitmap;

/* compiled from: BitmapPoolAdapter.java */
/* loaded from: classes.dex */
public class e implements d {
    @Override // a3.d
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // a3.d
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // a3.d
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        return d(i10, i11, config);
    }

    @Override // a3.d
    public void a(int i10) {
    }

    @Override // a3.d
    public void b() {
    }
}
