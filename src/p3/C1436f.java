package p3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: ImageViewTargetFactory.java */
/* renamed from: p3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1436f {
    public <Z> i<ImageView, Z> a(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new C1432b(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new C1434d(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
