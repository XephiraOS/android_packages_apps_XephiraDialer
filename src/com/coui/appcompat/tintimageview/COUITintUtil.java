package com.coui.appcompat.tintimageview;

import C.a;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public class COUITintUtil {
    public static Bitmap tintBitmap(Bitmap bitmap, int i10) {
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_IN));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        createBitmap.setDensity(bitmap.getDensity());
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static Drawable tintDrawable(Drawable drawable, ColorStateList colorStateList) {
        Drawable r10 = a.r(drawable);
        a.o(r10.mutate(), colorStateList);
        return r10;
    }

    public static Drawable tintDrawable(Drawable drawable, int i10) {
        Drawable r10 = a.r(drawable);
        a.n(r10.mutate(), i10);
        return r10;
    }
}
