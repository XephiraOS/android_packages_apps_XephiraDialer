package p3;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* renamed from: p3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1432b extends AbstractC1435e<Bitmap> {
    public C1432b(ImageView imageView) {
        super(imageView);
    }

    @Override // p3.AbstractC1435e
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void p(Bitmap bitmap) {
        ((ImageView) this.f36000a).setImageBitmap(bitmap);
    }
}
