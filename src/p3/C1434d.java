package p3;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: DrawableImageViewTarget.java */
/* renamed from: p3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1434d extends AbstractC1435e<Drawable> {
    public C1434d(ImageView imageView) {
        super(imageView);
    }

    @Override // p3.AbstractC1435e
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void p(Drawable drawable) {
        ((ImageView) this.f36000a).setImageDrawable(drawable);
    }
}
