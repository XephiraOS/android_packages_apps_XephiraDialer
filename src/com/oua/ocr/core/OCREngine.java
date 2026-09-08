package com.oua.ocr.core;

import android.graphics.Bitmap;
import android.util.Size;
import com.oua.ocr.OCR;
import com.oua.ocr.core.OCRManager;
import com.oua.opencv.BBoxUtil;
import com.oua.opencv.OpenCVUtil;
import com.oua.util.BitmapUtil;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import com.oua.util.Transform;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public abstract class OCREngine {
    private static final String TAG = "com.oua.ocr.core.OCREngine";

    private static Size calcScaleSize(Size size, double d10) {
        double d11;
        double min = Math.min(size.getWidth(), size.getHeight());
        if (d10 > 0.0d && d10 < min) {
            d11 = d10 / min;
        } else {
            d11 = 1.0d;
        }
        return new Size((int) (size.getWidth() * d11), (int) (size.getHeight() * d11));
    }

    public static Bitmap cropAndScaleTextArea(Bitmap bitmap, List<Point> list, int i10, Transform.TransformGroup transformGroup) {
        SimpleTrace trace = SimpleTrace.getTrace();
        String str = TAG;
        trace.startSection("cropAndScale", str);
        if (list != null && !list.isEmpty()) {
            org.opencv.core.Size normBoxSize = BBoxUtil.normBoxSize(list);
            DebugConfig.logd(str, "boxSize " + normBoxSize.toString());
            bitmap = BitmapUtil.resizeAndCrop(bitmap, OpenCVUtil.toAndroidRect(BBoxUtil.getOutterBox(list)), calcScaleSize(OpenCVUtil.toAndroidSize(normBoxSize), (double) i10), transformGroup);
            SimpleTrace.getTrace().addEvent("BitmapUtil.crop");
            DebugConfig.logMemory(str, "BitmapUtil.crop");
            DebugConfig.logd(str, "corpBmp " + bitmap.getWidth() + " " + bitmap.getHeight());
        } else {
            double min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            if (i10 > 0) {
                double d10 = i10;
                if (min > d10) {
                    Size size = new Size(bitmap.getWidth(), bitmap.getHeight());
                    Transform.TransformScale transformScale = new Transform.TransformScale(size, calcScaleSize(size, d10));
                    bitmap = BitmapUtil.resize(bitmap, transformScale.getDstSize(), null);
                    transformGroup.transforms.add(transformScale);
                }
            }
        }
        SimpleTrace.getTrace().endSection("cropAndScale");
        return bitmap;
    }

    private static OCRManager.DetectorOutput doDetect(OCRManager.Detector detector, Mat mat, int i10, List<List<Point>> list) {
        OCRManager.DetectorOutput detectorOutput;
        if ((i10 & 2) != 0) {
            OCRManager.DetectorInput detectorInput = new OCRManager.DetectorInput();
            detectorInput.inputMat = mat;
            detectorOutput = detector.run(detectorInput);
        } else {
            detectorOutput = new OCRManager.DetectorOutput();
            if (list == null) {
                list = new ArrayList<>();
            }
            detectorOutput.boundingBoxes = list;
            detectorOutput.degree = 0;
            if (list.isEmpty()) {
                detectorOutput.boundingBoxes.add(BBoxUtil.rect2Points(0.0d, 0.0d, mat.cols(), mat.rows()));
            }
        }
        DebugConfig.logd(TAG, "detectorOutput ", detectorOutput);
        return detectorOutput;
    }

    private static OCR.OCRResult doOCR(OCRManager oCRManager, OCRManager.Detector detector, OCRManager.Recognizer recognizer, Bitmap bitmap, int i10, OCR.Option option, List<List<Point>> list) {
        OCR.OCRResult oCRResult;
        Mat mat = new Mat();
        Utils.bitmapToMat(bitmap, mat);
        if (!option.cropTextArea) {
            bitmap.recycle();
        }
        OCR.OCRResult oCRResult2 = new OCR.OCRResult();
        OCRManager.DetectorOutput doDetect = doDetect(detector, mat, i10, list);
        SimpleTrace.getTrace().addEvent("detect");
        oCRResult2.degree = doDetect.degree;
        oCRResult2.ocrItems = (List) doDetect.boundingBoxes.stream().map(new Function() { // from class: com.oua.ocr.core.K
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                OCR.OCRItem lambda$doOCR$1;
                lambda$doOCR$1 = OCREngine.lambda$doOCR$1((List) obj);
                return lambda$doOCR$1;
            }
        }).collect(Collectors.toList());
        DebugConfig.logv(TAG, "ocrResult1: " + oCRResult2.degree);
        if ((i10 & 4) != 0) {
            HashMap hashMap = new HashMap();
            if (doDetect.segmentBoxes.isEmpty()) {
                oCRResult = oCRResult2;
            } else {
                oCRResult = new OCR.OCRResult();
                oCRResult.degree = doDetect.degree;
                oCRResult.ocrItems = new ArrayList();
                for (int i11 = 0; i11 < doDetect.segmentBoxes.size(); i11++) {
                    for (int i12 = 0; i12 < doDetect.segmentBoxes.get(i11).size(); i12++) {
                        OCR.OCRItem oCRItem = new OCR.OCRItem();
                        oCRItem.boundingBox = doDetect.segmentBoxes.get(i11).get(i12);
                        oCRItem.id = oCRResult.ocrItems.size();
                        oCRResult.ocrItems.add(oCRItem);
                        hashMap.put(Integer.valueOf(oCRItem.id), Integer.valueOf(i11));
                    }
                }
            }
            oCRResult2 = mergeResult(oCRResult2, doRecognize(oCRManager, recognizer, mat, oCRResult), hashMap);
            oCRResult2.ocrItems = (List) oCRResult2.ocrItems.stream().filter(new Predicate() { // from class: com.oua.ocr.core.L
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$doOCR$2;
                    lambda$doOCR$2 = OCREngine.lambda$doOCR$2((OCR.OCRItem) obj);
                    return lambda$doOCR$2;
                }
            }).collect(Collectors.toList());
        }
        SimpleTrace.getTrace().addEvent("recognize");
        return oCRResult2;
    }

    private static OCRManager.RecognizerOutput doRecognize(OCRManager oCRManager, OCRManager.Recognizer recognizer, final Mat mat, final OCR.OCRResult oCRResult) {
        final List arrayList;
        boolean z10;
        int i10;
        boolean z11;
        SimpleTrace trace = SimpleTrace.getTrace();
        String str = TAG;
        trace.startSection("doRecognize", str);
        final OCRManager.RecognizerOutput recognizerOutput = new OCRManager.RecognizerOutput();
        if (oCRResult.ocrItems.isEmpty()) {
            recognizerOutput.degree = oCRResult.degree;
            SimpleTrace.getTrace().endSection("doRecognize");
            return recognizerOutput;
        }
        if (oCRManager.getOCRParams().recognizerDirectionCheckCount > 0) {
            List<OCR.OCRItem> list = oCRResult.ocrItems;
            int i11 = oCRResult.degree;
            if (i11 != 90 && i11 != -90) {
                z11 = false;
            } else {
                z11 = true;
            }
            arrayList = TextDirectionUtil.findTestedBBoxes(list, z11, oCRManager.getOCRParams());
        } else {
            arrayList = new ArrayList();
            arrayList.add(new ArrayList());
            arrayList.add(oCRResult.ocrItems);
        }
        DebugConfig.logv(str, "ocrItemListList", arrayList);
        OpenCVUtil.logAndSave(str, "rec_input_mat_full", mat);
        List list2 = (List) arrayList.stream().map(new Function() { // from class: com.oua.ocr.core.w
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List lambda$doRecognize$4;
                lambda$doRecognize$4 = OCREngine.lambda$doRecognize$4(Mat.this, oCRResult, (List) obj);
                return lambda$doRecognize$4;
            }
        }).collect(Collectors.toList());
        mat.release();
        SimpleTrace.getTrace().addEvent("crop");
        final ArrayList arrayList2 = new ArrayList();
        if (!((List) list2.get(0)).isEmpty()) {
            z10 = TextDirectionUtil.isReverse(recognizer, (List) list2.get(0), arrayList2);
            IntStream.range(0, arrayList2.size()).forEach(new IntConsumer() { // from class: com.oua.ocr.core.x
                @Override // java.util.function.IntConsumer
                public final void accept(int i12) {
                    OCREngine.lambda$doRecognize$5(arrayList, arrayList2, i12);
                }
            });
            recognizerOutput.items.addAll((Collection) arrayList.get(0));
            ((List) list2.get(0)).forEach(new Consumer() { // from class: com.oua.ocr.core.y
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Mat) obj).release();
                }
            });
            ((List) list2.get(0)).clear();
        } else {
            z10 = false;
        }
        SimpleTrace.getTrace().addEvent("isReverse");
        OCRManager.RecognizerInput recognizerInput = new OCRManager.RecognizerInput();
        if (z10) {
            i10 = 180;
        } else {
            i10 = 0;
        }
        recognizerOutput.degree = i10;
        DebugConfig.logd(str, "is_reverse " + z10);
        DebugConfig.logd(str, "recognizerOutput.degree  " + recognizerOutput.degree);
        for (int i12 = 1; i12 < list2.size(); i12++) {
            if (!((List) list2.get(i12)).isEmpty()) {
                List<Mat> list3 = (List) list2.get(i12);
                recognizerInput.textImages = list3;
                if (recognizerOutput.degree != 0) {
                    list3.forEach(new Consumer() { // from class: com.oua.ocr.core.z
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            OCREngine.lambda$doRecognize$7(OCRManager.RecognizerOutput.this, (Mat) obj);
                        }
                    });
                }
                final List<OCR.OCRItem> run = recognizer.run(recognizerInput);
                ((List) list2.get(i12)).forEach(new Consumer() { // from class: com.oua.ocr.core.A
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((Mat) obj).release();
                    }
                });
                ((List) list2.get(i12)).clear();
                final List list4 = (List) arrayList.get(i12);
                IntStream.range(0, run.size()).forEach(new IntConsumer() { // from class: com.oua.ocr.core.B
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i13) {
                        OCREngine.lambda$doRecognize$9(list4, run, i13);
                    }
                });
                recognizerOutput.items.addAll(list4);
            }
        }
        SimpleTrace.getTrace().endSection("doRecognize");
        return recognizerOutput;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ OCR.OCRItem lambda$doOCR$1(List list) {
        OCR.OCRItem oCRItem = new OCR.OCRItem();
        oCRItem.boundingBox = list;
        return oCRItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$doOCR$2(OCR.OCRItem oCRItem) {
        if (BBoxUtil.calcRatio(oCRItem.boundingBox) <= oCRItem.text.length() * 3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mat lambda$doRecognize$3(Mat mat, OCR.OCRResult oCRResult, OCR.OCRItem oCRItem) {
        return OpenCVUtil.warpCropAndRotate(mat, oCRItem.boundingBox, Transform.TransformRotate.reverseDegree(oCRResult.degree));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$doRecognize$4(final Mat mat, final OCR.OCRResult oCRResult, List list) {
        return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Mat lambda$doRecognize$3;
                lambda$doRecognize$3 = OCREngine.lambda$doRecognize$3(Mat.this, oCRResult, (OCR.OCRItem) obj);
                return lambda$doRecognize$3;
            }
        }).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doRecognize$5(List list, List list2, int i10) {
        ((OCR.OCRItem) ((List) list.get(0)).get(i10)).text = ((OCR.OCRItem) list2.get(i10)).text;
        ((OCR.OCRItem) ((List) list.get(0)).get(i10)).probabilities = ((OCR.OCRItem) list2.get(i10)).probabilities;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doRecognize$7(OCRManager.RecognizerOutput recognizerOutput, Mat mat) {
        Core.rotate(mat, mat, OpenCVUtil.toOpencvRotate(recognizerOutput.degree));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doRecognize$9(List list, List list2, int i10) {
        ((OCR.OCRItem) list.get(i10)).text = ((OCR.OCRItem) list2.get(i10)).text;
        ((OCR.OCRItem) list.get(i10)).probabilities = ((OCR.OCRItem) list2.get(i10)).probabilities;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList lambda$mergeResult$10(int i10) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$mergeResult$11(OCR.OCRItem oCRItem, OCR.OCRItem oCRItem2) {
        return Integer.compare(oCRItem.id, oCRItem2.id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$mergeResult$13(String str, String str2) {
        return str + " " + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$mergeResult$14(OCR.OCRItem oCRItem) {
        return oCRItem.probabilities.stream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$mergeResult$15(OCR.OCRItem oCRItem) {
        String str = oCRItem.text;
        if (str != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$mergeResult$16(OCR.OCRItem oCRItem) {
        DebugConfig.logd(TAG, StringUtil.toString(oCRItem));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$run$0(Transform.TransformRotate transformRotate, OCR.OCRItem oCRItem) {
        oCRItem.boundingBox = BBoxUtil.transform(oCRItem.boundingBox, transformRotate);
    }

    private static OCR.OCRResult mergeResult(OCR.OCRResult oCRResult, OCRManager.RecognizerOutput recognizerOutput, Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            oCRResult.ocrItems = recognizerOutput.items;
        } else {
            List list = (List) IntStream.range(0, oCRResult.ocrItems.size()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.D
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    ArrayList lambda$mergeResult$10;
                    lambda$mergeResult$10 = OCREngine.lambda$mergeResult$10(i10);
                    return lambda$mergeResult$10;
                }
            }).collect(Collectors.toList());
            for (OCR.OCRItem oCRItem : recognizerOutput.items) {
                ((List) list.get(map.get(Integer.valueOf(oCRItem.id)).intValue())).add(oCRItem);
            }
            for (int i10 = 0; i10 < list.size(); i10++) {
                List list2 = (List) list.get(i10);
                list2.sort(new Comparator() { // from class: com.oua.ocr.core.E
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int lambda$mergeResult$11;
                        lambda$mergeResult$11 = OCREngine.lambda$mergeResult$11((OCR.OCRItem) obj, (OCR.OCRItem) obj2);
                        return lambda$mergeResult$11;
                    }
                });
                if (recognizerOutput.degree != 0) {
                    Collections.reverse(list2);
                }
                oCRResult.ocrItems.get(i10).text = (String) list2.stream().map(new Function() { // from class: com.oua.ocr.core.F
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        String str;
                        str = ((OCR.OCRItem) obj).text;
                        return str;
                    }
                }).reduce(new BinaryOperator() { // from class: com.oua.ocr.core.G
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        String lambda$mergeResult$13;
                        lambda$mergeResult$13 = OCREngine.lambda$mergeResult$13((String) obj, (String) obj2);
                        return lambda$mergeResult$13;
                    }
                }).orElse("");
                oCRResult.ocrItems.get(i10).probabilities = (List) list2.stream().flatMap(new Function() { // from class: com.oua.ocr.core.H
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        Stream lambda$mergeResult$14;
                        lambda$mergeResult$14 = OCREngine.lambda$mergeResult$14((OCR.OCRItem) obj);
                        return lambda$mergeResult$14;
                    }
                }).collect(Collectors.toList());
            }
            oCRResult.ocrItems = (List) oCRResult.ocrItems.stream().filter(new Predicate() { // from class: com.oua.ocr.core.I
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$mergeResult$15;
                    lambda$mergeResult$15 = OCREngine.lambda$mergeResult$15((OCR.OCRItem) obj);
                    return lambda$mergeResult$15;
                }
            }).collect(Collectors.toList());
        }
        oCRResult.degree = Transform.TransformRotate.normalizeDegree(recognizerOutput.degree + oCRResult.degree);
        oCRResult.ocrItems.forEach(new Consumer() { // from class: com.oua.ocr.core.J
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                OCREngine.lambda$mergeResult$16((OCR.OCRItem) obj);
            }
        });
        return oCRResult;
    }

    public static OCR.OCRResult run(OCRManager oCRManager, OCRManager.TextAreaDetector textAreaDetector, OCRManager.Detector detector, OCRManager.Recognizer recognizer, Bitmap bitmap, int i10, OCR.Option option, List<List<Point>> list) {
        Bitmap cropAndScaleTextArea;
        SimpleTrace trace = SimpleTrace.getTrace();
        String str = TAG;
        trace.startSection("ocr_run", str);
        DebugConfig.logd(str, "inputBmp " + bitmap.getWidth() + " " + bitmap.getHeight());
        List<Point> arrayList = new ArrayList<>();
        if ((i10 & 1) != 0 && textAreaDetector != null) {
            arrayList = textAreaDetector.run(bitmap).textArea;
        }
        SimpleTrace.getTrace().addEvent("detect_edge");
        Transform.TransformGroup transformGroup = new Transform.TransformGroup();
        if (!arrayList.isEmpty()) {
            cropAndScaleTextArea = cropAndScaleTextArea(bitmap, arrayList, oCRManager.getOCRParams().textAreaShortEdge, transformGroup);
            SimpleTrace.getTrace().addEvent("cropAndScale");
        } else {
            cropAndScaleTextArea = cropAndScaleTextArea(bitmap, arrayList, oCRManager.getOCRParams().textAreaShortEdge, transformGroup);
            SimpleTrace.getTrace().addEvent("cropAndScale");
        }
        if (cropAndScaleTextArea != bitmap) {
            bitmap.recycle();
        }
        OCR.OCRResult doOCR = doOCR(oCRManager, detector, recognizer, cropAndScaleTextArea, i10, option, list);
        doOCR.textArea = arrayList;
        if (option.cropTextArea) {
            doOCR.textAreaBmp = cropAndScaleTextArea;
            int i11 = doOCR.degree;
            if (i11 != 0) {
                int reverseDegree = Transform.TransformRotate.reverseDegree(i11);
                final Transform.TransformRotate transformRotate = new Transform.TransformRotate(new Size(doOCR.textAreaBmp.getWidth(), doOCR.textAreaBmp.getHeight()), reverseDegree);
                doOCR.ocrItems.forEach(new Consumer() { // from class: com.oua.ocr.core.C
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        OCREngine.lambda$run$0(Transform.TransformRotate.this, (OCR.OCRItem) obj);
                    }
                });
                doOCR.textAreaBmp = BitmapUtil.rotate(doOCR.textAreaBmp, reverseDegree);
            }
        } else if (!transformGroup.transforms.isEmpty()) {
            for (OCR.OCRItem oCRItem : doOCR.ocrItems) {
                oCRItem.boundingBox = BBoxUtil.reverseTransform(oCRItem.boundingBox, transformGroup);
            }
        }
        DebugConfig.logd(TAG, "result:", doOCR);
        SimpleTrace.getTrace().endSection("ocr_run");
        return doOCR;
    }
}
