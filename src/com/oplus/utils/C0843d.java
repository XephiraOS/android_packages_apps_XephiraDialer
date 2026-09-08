package com.oplus.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: BitmapUtil.java */
/* renamed from: com.oplus.utils.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0843d {
    public static Bitmap a(byte[] bArr, int i10) {
        BitmapFactory.Options options;
        if (i10 <= 1) {
            options = null;
        } else {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i10;
            options = options2;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static int b(int i10, int i11) {
        if (i11 < 1 || i10 < 1) {
            return 1;
        }
        int i12 = 1;
        while (true) {
            i10 >>= 1;
            if (i10 >= i11 * 0.8f) {
                i12 <<= 1;
            } else {
                return i12;
            }
        }
    }

    public static int c(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        return Math.min(options.outWidth, options.outHeight);
    }
}
