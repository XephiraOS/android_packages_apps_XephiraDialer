package com.android.incallui.mvvm.utils;

import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;

/* compiled from: BackgroundUtils.kt */
/* renamed from: com.android.incallui.mvvm.utils.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0727a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0727a f18589a = new C0727a();

    public static final BitmapDrawable a() {
        Bitmap bitmap;
        Bitmap.Config config;
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(OplusInCallApp.getAppContext());
        if (wallpaperManager == null) {
            return null;
        }
        WallpaperInfo wallpaperInfo = wallpaperManager.getWallpaperInfo();
        if (wallpaperInfo == null) {
            if (androidx.core.content.b.a(OplusInCallApp.getAppContext(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                return null;
            }
            Drawable drawable = wallpaperManager.getDrawable();
            Log.d("BackgroundUtils", "captureWallpaper: static wallpaper " + drawable);
            bitmap = G2.b.a(drawable);
        } else {
            Log.d("BackgroundUtils", "captureWallpaper: live wallpaper use thumbnail");
            Drawable loadThumbnail = wallpaperInfo.loadThumbnail(OplusInCallApp.getAppContext().getPackageManager());
            Bitmap a10 = G2.b.a(loadThumbnail);
            if (a10 != null) {
                if (loadThumbnail.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                bitmap = a10.copy(config, true);
            } else {
                bitmap = a10;
            }
        }
        return new BitmapDrawable(b(bitmap));
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.graphics.Bitmap b(android.graphics.Bitmap r19) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.mvvm.utils.C0727a.b(android.graphics.Bitmap):android.graphics.Bitmap");
    }
}
