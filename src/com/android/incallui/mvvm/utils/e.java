package com.android.incallui.mvvm.utils;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import com.android.incallui.OplusInCallApp;
import java.io.InputStream;

/* compiled from: BitmapUtils.kt */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f18591a = new e();

    public static final Bitmap a(Uri uri) {
        return b(uri, 1);
    }

    public static final Bitmap b(Uri uri, int i10) {
        Bitmap bitmap;
        InputStream inputStream;
        Bitmap decodeStream;
        InputStream inputStream2 = null;
        Bitmap bitmap2 = null;
        InputStream inputStream3 = null;
        try {
            if (uri == null) {
                return null;
            }
            try {
                ContentResolver contentResolver = OplusInCallApp.getAppContext().getContentResolver();
                if (contentResolver != null) {
                    inputStream = contentResolver.openInputStream(uri);
                } else {
                    inputStream = null;
                }
            } catch (IllegalArgumentException e10) {
                e = e10;
                bitmap = null;
            }
            try {
                if (i10 == 1) {
                    decodeStream = BitmapFactory.decodeStream(inputStream);
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inSampleSize = i10;
                    decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                }
                bitmap2 = decodeStream;
                Log.d("BitmapUtils", "getBitmapFromUri: bitmap=" + bitmap2);
                if (inputStream != null) {
                    inputStream.close();
                    return bitmap2;
                }
                return bitmap2;
            } catch (IllegalArgumentException e11) {
                Bitmap bitmap3 = bitmap2;
                inputStream3 = inputStream;
                e = e11;
                bitmap = bitmap3;
                Log.d("BitmapUtils", "getBitmapFromUri: e=" + e.getMessage());
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                return bitmap;
            } catch (Throwable th) {
                inputStream2 = inputStream;
                th = th;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
