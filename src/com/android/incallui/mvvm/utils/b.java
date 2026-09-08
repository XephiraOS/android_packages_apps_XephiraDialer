package com.android.incallui.mvvm.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.android.incallui.OplusInCallApp;

/* compiled from: BackgroundUtils.kt */
/* loaded from: classes.dex */
public final class b {
    public static final boolean a(Drawable drawable) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (drawable == null) {
            return true;
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            intrinsicWidth = bitmap.getWidth();
            intrinsicHeight = bitmap.getHeight();
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        float f10 = OplusInCallApp.getDefaultDisplayUiContext().getResources().getDisplayMetrics().density;
        if (f10 > 0.0f) {
            intrinsicWidth = (int) (intrinsicWidth / f10);
            intrinsicHeight = (int) (intrinsicHeight / f10);
        }
        if (intrinsicWidth <= 150 || intrinsicHeight <= 150) {
            return true;
        }
        return false;
    }
}
