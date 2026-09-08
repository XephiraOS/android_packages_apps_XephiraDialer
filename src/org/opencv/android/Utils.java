package org.opencv.android;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.opencv.core.CvException;
import org.opencv.core.Mat;

/* loaded from: classes4.dex */
public class Utils {
    public static void bitmapToMat(Bitmap bitmap, Mat mat, boolean z10) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bmp == null");
        }
        if (mat != null) {
            nBitmapToMat2(bitmap, mat.nativeObj, z10);
            return;
        }
        throw new IllegalArgumentException("mat == null");
    }

    public static String exportResource(Context context, int i10) {
        return exportResource(context, i10, "OpenCV_data");
    }

    public static Mat loadResource(Context context, int i10, int i11) {
        return null;
    }

    public static void matToBitmap(Mat mat, Bitmap bitmap, boolean z10) {
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        }
        if (bitmap != null) {
            nMatToBitmap2(mat.nativeObj, bitmap, z10);
            return;
        }
        throw new IllegalArgumentException("bmp == null");
    }

    private static native void nBitmapToMat2(Bitmap bitmap, long j10, boolean z10);

    private static native void nMatToBitmap2(long j10, Bitmap bitmap, boolean z10);

    public static String exportResource(Context context, int i10, String str) {
        String string = context.getResources().getString(i10);
        String substring = string.substring(string.lastIndexOf("/") + 1);
        try {
            InputStream openRawResource = context.getResources().openRawResource(i10);
            File file = new File(context.getDir(str, 0), substring);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = openRawResource.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    openRawResource.close();
                    fileOutputStream.close();
                    return file.getAbsolutePath();
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            throw new CvException("Failed to export resource " + substring + ". Exception thrown: " + e10);
        }
    }

    public static Mat loadResource(Context context, int i10) {
        return loadResource(context, i10, -1);
    }

    public static void bitmapToMat(Bitmap bitmap, Mat mat) {
        bitmapToMat(bitmap, mat, false);
    }

    public static void matToBitmap(Mat mat, Bitmap bitmap) {
        matToBitmap(mat, bitmap, false);
    }
}
