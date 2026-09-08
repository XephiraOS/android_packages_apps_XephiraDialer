package com.android.contacts.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/* compiled from: ContactBadgeUtil.java */
/* loaded from: classes.dex */
public class f {
    public static Bitmap a(Drawable drawable) {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap b(Context context, boolean z10, boolean z11) {
        return BitmapFactory.decodeResource(context.getResources(), Z0.b.d(z10, z11));
    }

    public static Bitmap c(Context context, String str, String str2) {
        return a(Z0.b.f(context, str, str2));
    }
}
