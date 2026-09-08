package com.oua.ocr.core;

import com.oua.opencv.BBoxUtil;
import com.oua.opencv.OpenCVUtil;
import com.oua.tflite.TBufferUtil;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes4.dex */
public class DetectionPostprocessor {
    private static final String TAG = "com.oua.ocr.core.DetectionPostprocessor";
    private OCRManager ocrManager;
    private Scores scores;

    /* loaded from: classes4.dex */
    public static class Scores {
        Mat matLink;
        Mat matLinkBinary;
        Mat matText;
        Mat matTextBinary;

        private Scores() {
        }
    }

    private Mat breakTextLink(Mat mat, Mat mat2, Mat mat3) {
        final int[] intArray = OpenCVUtil.toIntArray(mat);
        final float[] floatArray = OpenCVUtil.toFloatArray(mat2);
        final float[] floatArray2 = OpenCVUtil.toFloatArray(mat3);
        IntStream.range(0, intArray.length).forEach(new IntConsumer() { // from class: com.oua.ocr.core.f
            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                DetectionPostprocessor.lambda$breakTextLink$5(floatArray2, floatArray, intArray, i10);
            }
        });
        Mat mat4 = new Mat(mat.size(), CvType.CV_32SC1);
        mat4.put(0, 0, intArray);
        mat4.convertTo(mat4, CvType.CV_8UC1);
        OpenCVUtil.logAndSave(TAG, "mat_breaklink", mat4);
        return mat4;
    }

    private void clear() {
        this.scores.matLink.release();
        this.scores.matLinkBinary.release();
        this.scores.matText.release();
        this.scores.matTextBinary.release();
    }

    private void connectComponents(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        Mat mat6 = new Mat();
        Core.add(mat, mat2, mat6);
        String str = TAG;
        OpenCVUtil.logAndSave(str, "mat_score_comb", mat6);
        Imgproc.threshold(mat6, mat6, 0.9d, 1.0d, 0);
        OpenCVUtil.logAndSave(str, "mat_score_comb_binary", mat6);
        mat6.convertTo(mat6, 0);
        OpenCVUtil.logAndSave(str, "mat_score_comb_8u", mat6);
        Imgproc.connectedComponentsWithStats(mat6, mat3, mat4, mat5, 4);
        mat6.release();
        if (DebugConfig.isLogVerbose()) {
            DebugConfig.logv(str, "mat_stats", mat4);
            DebugConfig.logv(str, "mat_labels", mat3);
            DebugConfig.logv(str, "mat_centroids", mat5);
            Mat cc_createStatsMap = OpenCVUtil.cc_createStatsMap(mat4, mat.size(), OpenCVUtil.cc_createLablesMap(mat3, mat4.rows()));
            OpenCVUtil.logAndSave(str, "cc_map", cc_createStatsMap);
            cc_createStatsMap.release();
        }
    }

    private static List<Point> getBoundingBox(int i10, Mat mat, Mat mat2) {
        Rect cc_getStatRect = OpenCVUtil.cc_getStatRect(mat, i10);
        int sqrt = (int) (Math.sqrt((mat.get(i10, 4)[0] * Math.min(cc_getStatRect.width, cc_getStatRect.height)) / cc_getStatRect.area()) * 2.0d);
        final Rect externRect = BBoxUtil.externRect(cc_getStatRect, sqrt, new Rect(new Point(0.0d, 0.0d), mat2.size()));
        double d10 = sqrt + 1;
        Mat structuringElement = Imgproc.getStructuringElement(0, new Size(d10, d10));
        Mat clone = new Mat(mat2, externRect).clone();
        double d11 = i10;
        Imgproc.threshold(clone, clone, d11 + 0.1d, 255.0d, 4);
        Imgproc.threshold(clone, clone, d11 - 0.1d, 255.0d, 0);
        String str = TAG;
        OpenCVUtil.logAndSave(str, String.format("mat_label_%d", Integer.valueOf(i10)), clone);
        Imgproc.dilate(clone, clone, structuringElement, new Point(-1.0d, -1.0d), 1);
        OpenCVUtil.logAndSave(str, String.format("mat_label_dilated_%d", Integer.valueOf(i10)), clone);
        List<Point> boundingBox = OpenCVUtil.getBoundingBox(clone);
        boundingBox.forEach(new Consumer() { // from class: com.oua.ocr.core.e
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DetectionPostprocessor.lambda$getBoundingBox$4(Rect.this, (Point) obj);
            }
        });
        clone.release();
        return boundingBox;
    }

    private int[] getValidCCIndexes(Mat mat, final Mat mat2, Mat mat3) {
        final double[] dArr = new double[mat2.rows()];
        final float[] floatArray = OpenCVUtil.toFloatArray(mat);
        final int[] intArray = OpenCVUtil.toIntArray(mat3);
        IntStream.range(0, floatArray.length).forEach(new IntConsumer() { // from class: com.oua.ocr.core.b
            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                DetectionPostprocessor.lambda$getValidCCIndexes$1(floatArray, intArray, dArr, i10);
            }
        });
        int[] array = IntStream.range(0, mat2.rows()).filter(new IntPredicate() { // from class: com.oua.ocr.core.c
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                boolean lambda$getValidCCIndexes$2;
                lambda$getValidCCIndexes$2 = DetectionPostprocessor.this.lambda$getValidCCIndexes$2(mat2, i10);
                return lambda$getValidCCIndexes$2;
            }
        }).filter(new IntPredicate() { // from class: com.oua.ocr.core.d
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                boolean lambda$getValidCCIndexes$3;
                lambda$getValidCCIndexes$3 = DetectionPostprocessor.this.lambda$getValidCCIndexes$3(dArr, i10);
                return lambda$getValidCCIndexes$3;
            }
        }).toArray();
        DebugConfig.logd(TAG, "valid indexes " + StringUtil.toString(array));
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$breakTextLink$5(float[] fArr, float[] fArr2, int[] iArr, int i10) {
        if (((int) fArr[i10]) == 1 && ((int) fArr2[i10]) == 0) {
            iArr[i10] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getBoundingBox$4(Rect rect, Point point) {
        point.f35882x += rect.f35887x;
        point.f35883y += rect.f35888y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getValidCCIndexes$1(float[] fArr, int[] iArr, double[] dArr, int i10) {
        double d10 = fArr[i10];
        int i11 = iArr[i10];
        double d11 = dArr[i11];
        if (d10 <= d11) {
            d10 = d11;
        }
        dArr[i11] = d10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getValidCCIndexes$2(Mat mat, int i10) {
        if (mat.get(i10, 4)[0] <= this.ocrManager.getOCRParams().detectorBlockSizeThreshold) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getValidCCIndexes$3(double[] dArr, int i10) {
        if (dArr[i10] > this.ocrManager.getOCRParams().detectorHighTextThreshold) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$run$0(Mat mat, Mat mat2, int i10) {
        return getBoundingBox(i10, mat, mat2);
    }

    private Scores retriveScores(W9.a aVar, List<Point> list) {
        W9.a[] split = split(aVar);
        Mat clone = toMat(split[0]).clone();
        OpenCVUtil.warpCrop(clone, clone, list);
        String str = TAG;
        OpenCVUtil.logAndSave(str, "mat_text", clone);
        Mat mat = new Mat();
        DebugConfig.logd(str, "DETECTOR_TEXT_THRESHOLD " + this.ocrManager.getOCRParams().detectorTextThreshold);
        Imgproc.threshold(clone, mat, (double) this.ocrManager.getOCRParams().detectorTextThreshold, 1.0d, 0);
        OpenCVUtil.logAndSave(str, "mat_text_binary", mat);
        Mat mat2 = toMat(split[1]);
        OpenCVUtil.warpCrop(mat2, mat2, list);
        OpenCVUtil.logAndSave(str, "mat_link", mat2);
        Mat mat3 = new Mat();
        Imgproc.threshold(mat2, mat3, this.ocrManager.getOCRParams().detectorLinkThreshold, 1.0d, 0);
        OpenCVUtil.logAndSave(str, "mat_link_binary", mat3);
        Scores scores = new Scores();
        scores.matText = clone;
        scores.matTextBinary = mat;
        scores.matLink = mat2;
        scores.matLinkBinary = mat3;
        return scores;
    }

    private static Mat sigmoid(W9.a aVar) {
        float[] g10 = aVar.g();
        for (int i10 = 0; i10 < g10.length; i10++) {
            g10[i10] = (float) MathUtil.sigmoid(g10[i10]);
        }
        int[] h10 = aVar.h();
        Mat mat = new Mat(h10[1], h10[2], 5);
        mat.put(0, 0, g10);
        return mat;
    }

    private W9.a[] split(W9.a aVar) {
        return TBufferUtil.split(aVar);
    }

    private static Mat toMat(W9.a aVar) {
        int[] h10 = aVar.h();
        return new Mat(h10[1], h10[2], 5, aVar.d());
    }

    public List<List<Point>> run(OCRManager oCRManager, W9.a aVar, List<Point> list) {
        return run(oCRManager, aVar, list, null);
    }

    public List<List<Point>> run(OCRManager oCRManager, W9.a aVar, List<Point> list, Mat mat) {
        SimpleTrace trace = SimpleTrace.getTrace();
        String str = TAG;
        trace.startSection("detector_postprocess", str);
        this.ocrManager = oCRManager;
        this.scores = retriveScores(aVar, list);
        SimpleTrace.getTrace().addEvent("retriveScores");
        Mat mat2 = new Mat();
        final Mat mat3 = new Mat();
        Mat mat4 = new Mat();
        Scores scores = this.scores;
        connectComponents(scores.matTextBinary, scores.matLinkBinary, mat2, mat3, mat4);
        SimpleTrace.getTrace().addEvent("connectComponents");
        int[] validCCIndexes = getValidCCIndexes(this.scores.matText, mat3, mat2);
        SimpleTrace.getTrace().addEvent("getValidCCIndexes");
        Scores scores2 = this.scores;
        final Mat breakTextLink = breakTextLink(mat2, scores2.matTextBinary, scores2.matLinkBinary);
        SimpleTrace.getTrace().addEvent("breakTextLink");
        List<List<Point>> list2 = (List) Arrays.stream(validCCIndexes).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.a
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                List lambda$run$0;
                lambda$run$0 = DetectionPostprocessor.lambda$run$0(Mat.this, breakTextLink, i10);
                return lambda$run$0;
            }
        }).collect(Collectors.toList());
        breakTextLink.release();
        SimpleTrace.getTrace().addEvent("get_bounding_boxes");
        DebugConfig.logd(str, "result:" + StringUtil.toString(list2));
        if (DebugConfig.isLogVerbose()) {
            Mat clone = this.scores.matTextBinary.clone();
            OpenCVUtil.drawBBoxes(clone, list2, new Scalar(1.0d), 1);
            OpenCVUtil.logAndSave(str, "postprocess_result", clone);
            clone.release();
        }
        clear();
        SimpleTrace.getTrace().addEvent("clear");
        SimpleTrace.getTrace().endSection("detector_postprocess");
        return list2;
    }
}
