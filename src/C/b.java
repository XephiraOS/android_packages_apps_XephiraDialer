package C;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* compiled from: RoundedBitmapDrawable21.java */
/* loaded from: classes.dex */
public class b extends c {
    public b(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // C.c
    public void c(int i10, int i11, int i12, Rect rect, Rect rect2) {
        Gravity.apply(i10, i11, i12, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        h();
        outline.setRoundRect(this.f313h, b());
    }
}
