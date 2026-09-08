package com.oua.ocr.core;

import android.graphics.Rect;
import android.util.Size;
import com.oua.opencv.OpenCVUtil;
import com.oua.util.DebugConfig;
import com.oua.util.StringUtil;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes4.dex */
public class DirectionDetector {
    private static final int SOBEL_IMG_SIZE = 300;
    private static final float SOBEL_THRESHOLD = 100.0f;
    private static final String TAG = "com.oua.ocr.core.DirectionDetector";

    private static double calcStd(int[] iArr, int i10, int i11) {
        int i12 = i11 - i10;
        double d10 = 0.0d;
        double d11 = 0.0d;
        for (int i13 = i10; i13 < i11; i13++) {
            d11 += iArr[i13];
        }
        double d12 = i12;
        double d13 = d11 / d12;
        while (i10 < i11) {
            d10 += Math.pow(iArr[i10] - d13, 2.0d);
            i10++;
        }
        return Math.sqrt(d10 / d12);
    }

    public static boolean isHorizontal(Mat mat) {
        int width;
        Rect rect;
        Size size = new Size(300, 300);
        int width2 = (mat.width() - mat.height()) / 2;
        if (width2 > 0) {
            width = mat.height();
        } else {
            width = mat.width();
        }
        if (width2 > 0) {
            rect = new Rect(width2, 0, width + width2, width);
        } else {
            rect = new Rect(0, -width2, width, width - width2);
        }
        String str = TAG;
        DebugConfig.logd(str, "crop_rect " + StringUtil.toString(rect));
        Mat mat2 = new Mat();
        OpenCVUtil.cropResizeRotatePad(mat, mat2, OpenCVUtil.toOpenCVRect(rect), OpenCVUtil.toOpenCVSize(size), null, 0, null);
        Imgproc.cvtColor(mat2, mat2, 11);
        OpenCVUtil.logAndSave(str, "croppedMat", mat2);
        Mat mat3 = new Mat();
        Imgproc.Sobel(mat2, mat3, 3, 1, 0, 3);
        OpenCVUtil.logAndSave(str, "sobelxMat", mat3);
        Mat mat4 = new Mat();
        Imgproc.Sobel(mat2, mat4, 3, 0, 1, 3);
        OpenCVUtil.logAndSave(str, "sobelyMat", mat4);
        short[] sArr = (short[]) OpenCVUtil.toArray(mat3);
        short[] sArr2 = (short[]) OpenCVUtil.toArray(mat4);
        int[] iArr = new int[300];
        int[] iArr2 = new int[300];
        int i10 = 0;
        for (int i11 = 0; i11 < 300; i11++) {
            for (int i12 = 0; i12 < 300; i12++) {
                if (Math.abs((int) sArr[i10]) >= SOBEL_THRESHOLD || Math.abs((int) sArr2[i10]) >= SOBEL_THRESHOLD) {
                    iArr[i12] = iArr[i12] + 1;
                    iArr2[i11] = iArr2[i11] + 1;
                }
                i10++;
            }
        }
        double signal_std = signal_std(iArr);
        double signal_std2 = signal_std(iArr2);
        DebugConfig.logd(TAG, String.format("%f, %f", Double.valueOf(signal_std), Double.valueOf(signal_std2)));
        if (signal_std > signal_std2) {
            return false;
        }
        return true;
    }

    private static double signal_std(int[] iArr) {
        int length = iArr.length / 20;
        double d10 = 0.0d;
        int i10 = 0;
        while (i10 < 19) {
            int i11 = length * i10;
            i10++;
            d10 += calcStd(iArr, i11, length * i10);
        }
        return d10 + calcStd(iArr, length * 19, iArr.length);
    }
}
