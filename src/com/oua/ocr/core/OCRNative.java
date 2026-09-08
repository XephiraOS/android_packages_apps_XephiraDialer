package com.oua.ocr.core;

import android.graphics.Bitmap;
import com.oua.ocr.OCR;
import com.oua.ocr.OCRParams;
import com.oua.ocr.core.OCRManager;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import java.nio.ByteBuffer;
import java.util.List;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
class OCRNative {
    private static final String TAG;
    long handle;

    static {
        System.loadLibrary("ocr_jni");
        TAG = OCRNative.class.getName();
    }

    public static native long cinit(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, String str);

    public static native String crun(long j10, long j11);

    public static OCRManager.DetectorOutput detect(Mat mat) {
        List list = (List) new com.google.gson.d().k(detect(mat.getNativeObjAddr()), new J4.a<List<List<List<Point>>>>() { // from class: com.oua.ocr.core.OCRNative.2
        }.getType());
        OCRManager.DetectorOutput detectorOutput = new OCRManager.DetectorOutput();
        if (list != null && !list.isEmpty() && !list.isEmpty() && list.get(0) != null && !((List) list.get(0)).isEmpty()) {
            detectorOutput.boundingBoxes = (List) list.get(0);
            if (list.size() - 1 != detectorOutput.boundingBoxes.size()) {
                DebugConfig.loge(TAG, String.format("Incorrect number of segment boxes %d : %d", Integer.valueOf(detectorOutput.boundingBoxes.size()), Integer.valueOf(list.size())));
            } else {
                detectorOutput.segmentBoxes = list.subList(1, list.size());
            }
        }
        return detectorOutput;
    }

    public static native String detect(long j10);

    public static native long detectorinit();

    public static native void detectorrun(long j10, long j11, ByteBuffer byteBuffer);

    public static native void setDebugLevel(int i10, String str);

    public static native String textAreaDetectorPostProcess(long j10);

    public static List<Point> textAreaDetectorPostProcess(Mat mat) {
        return (List) new com.google.gson.d().k(textAreaDetectorPostProcess(mat.getNativeObjAddr()), new J4.a<List<Point>>() { // from class: com.oua.ocr.core.OCRNative.1
        }.getType());
    }

    public void init(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, String str) {
        this.handle = cinit(byteBuffer, byteBuffer2, byteBuffer3, str);
    }

    public OCR.OCRResult run(Bitmap bitmap, OCRParams oCRParams) {
        SimpleTrace.getTrace().startSection("run", "OCRNative");
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);
        SimpleTrace.getTrace().addEvent("bitmapToMat");
        bitmap.recycle();
        SimpleTrace.getTrace().addEvent("recycle");
        String crun = crun(this.handle, mat.getNativeObjAddr());
        DebugConfig.logd("OCRNative", crun);
        OCR.OCRResult oCRResult = (OCR.OCRResult) new com.google.gson.d().j(crun, OCR.OCRResult.class);
        SimpleTrace.getTrace().endSection("run");
        DebugConfig.logd("OCRResult", StringUtil.toString(oCRResult));
        return oCRResult;
    }
}
