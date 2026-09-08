package com.oua.ocr.core;

import com.oua.ocr.OCR;
import com.oua.ocr.OCRParams;
import com.oua.ocr.core.OCRManager;
import com.oua.opencv.BBoxUtil;
import com.oua.opencv.OpenCVUtil;
import com.oua.util.DebugConfig;
import com.oua.util.StringUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.opencv.core.Core;
import org.opencv.core.Mat;

/* loaded from: classes4.dex */
public class TextDirectionUtil {
    private static final String TAG = "com.oua.ocr.core.TextDirectionUtil";

    private static int compareProb(List<OCR.OCRItem> list, List<OCR.OCRItem> list2) {
        double[] array = list.stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.ocr.core.V0
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double lambda$compareProb$6;
                lambda$compareProb$6 = TextDirectionUtil.lambda$compareProb$6((OCR.OCRItem) obj);
                return lambda$compareProb$6;
            }
        }).toArray();
        double[] array2 = list2.stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.ocr.core.W0
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double lambda$compareProb$8;
                lambda$compareProb$8 = TextDirectionUtil.lambda$compareProb$8((OCR.OCRItem) obj);
                return lambda$compareProb$8;
            }
        }).toArray();
        int i10 = 0;
        for (int i11 = 0; i11 < array.length; i11++) {
            i10 = array[i11] < array2[i11] ? i10 - 1 : i10 + 1;
        }
        return i10;
    }

    public static List<List<OCR.OCRItem>> findTestedBBoxes(List<OCR.OCRItem> list, boolean z10, OCRParams oCRParams) {
        int i10;
        List<OCR.OCRItem> sortBBoxByRatio = sortBBoxByRatio(list, z10);
        int i11 = oCRParams.recognizerDirectionCheckCount;
        double d10 = oCRParams.recognizerDirectionRatioLower;
        double d11 = oCRParams.recognizerDirectionRatioUpper;
        int size = sortBBoxByRatio.size();
        if (i11 < sortBBoxByRatio.size()) {
            size = 0;
            while (size < sortBBoxByRatio.size() && BBoxUtil.calcRatio(sortBBoxByRatio.get(size).boundingBox, z10) <= d11) {
                size++;
            }
            if (size > 0) {
                i10 = size - 1;
                while (i10 > 0 && size - i10 < i11 && BBoxUtil.calcRatio(sortBBoxByRatio.get(i10).boundingBox, z10) >= d10) {
                    i10--;
                }
            } else {
                i10 = 0;
            }
            while (size < sortBBoxByRatio.size() && size - i10 < i11) {
                size++;
            }
            while (i10 >= 0 && size - i10 < i11) {
                i10--;
            }
        } else {
            i10 = 0;
        }
        DebugConfig.logd(TAG, String.format("test box from %d to %d", Integer.valueOf(i10), Integer.valueOf(size)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sortBBoxByRatio.subList(i10, size));
        arrayList.add(new ArrayList());
        ((List) arrayList.get(1)).addAll(sortBBoxByRatio.subList(0, i10));
        if (size < sortBBoxByRatio.size()) {
            ((List) arrayList.get(1)).addAll(sortBBoxByRatio.subList(size, sortBBoxByRatio.size()));
        }
        return arrayList;
    }

    public static boolean isReverse(OCRManager.Recognizer recognizer, List<Mat> list, List<OCR.OCRItem> list2) {
        boolean z10;
        OCRManager.RecognizerInput recognizerInput = new OCRManager.RecognizerInput();
        recognizerInput.textImages = list;
        List<OCR.OCRItem> run = recognizer.run(recognizerInput);
        String str = TAG;
        DebugConfig.logd(str, "Test output 1: " + StringUtil.toString(run));
        recognizerInput.textImages.forEach(new Consumer() { // from class: com.oua.ocr.core.O0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                TextDirectionUtil.lambda$isReverse$4((Mat) obj);
            }
        });
        List<OCR.OCRItem> run2 = recognizer.run(recognizerInput);
        DebugConfig.logd(str, "Test output 2: " + StringUtil.toString(run2));
        if (compareProb(run, run2) < 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            run = run2;
        }
        list2.addAll(run);
        DebugConfig.logd(str, "Test output: " + z10 + " " + StringUtil.toString(list2));
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$compareProb$6(OCR.OCRItem oCRItem) {
        return oCRItem.probabilities.stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.ocr.core.P0
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double doubleValue;
                doubleValue = ((Double) obj).doubleValue();
                return doubleValue;
            }
        }).average().orElse(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$compareProb$8(OCR.OCRItem oCRItem) {
        return oCRItem.probabilities.stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.ocr.core.U0
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double doubleValue;
                doubleValue = ((Double) obj).doubleValue();
                return doubleValue;
            }
        }).average().orElse(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isReverse$4(Mat mat) {
        Core.rotate(mat, mat, OpenCVUtil.toOpencvRotate(180));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$sortBBoxByRatio$0(boolean z10, OCR.OCRItem oCRItem) {
        return BBoxUtil.calcRatio(oCRItem.boundingBox, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortBBoxByRatio$2(double[] dArr, Integer num, Integer num2) {
        return Double.compare(dArr[num.intValue()], dArr[num2.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ OCR.OCRItem lambda$sortBBoxByRatio$3(List list, Integer num) {
        return (OCR.OCRItem) list.get(num.intValue());
    }

    public static List<OCR.OCRItem> sortBBoxByRatio(final List<OCR.OCRItem> list, final boolean z10) {
        final double[] array = list.stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.ocr.core.Q0
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double lambda$sortBBoxByRatio$0;
                lambda$sortBBoxByRatio$0 = TextDirectionUtil.lambda$sortBBoxByRatio$0(z10, (OCR.OCRItem) obj);
                return lambda$sortBBoxByRatio$0;
            }
        }).toArray();
        DebugConfig.logd(TAG, "ratios " + StringUtil.toString(array));
        return (List) IntStream.range(0, list.size()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.R0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Integer valueOf;
                valueOf = Integer.valueOf(i10);
                return valueOf;
            }
        }).sorted(new Comparator() { // from class: com.oua.ocr.core.S0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$sortBBoxByRatio$2;
                lambda$sortBBoxByRatio$2 = TextDirectionUtil.lambda$sortBBoxByRatio$2(array, (Integer) obj, (Integer) obj2);
                return lambda$sortBBoxByRatio$2;
            }
        }).map(new Function() { // from class: com.oua.ocr.core.T0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                OCR.OCRItem lambda$sortBBoxByRatio$3;
                lambda$sortBBoxByRatio$3 = TextDirectionUtil.lambda$sortBBoxByRatio$3(list, (Integer) obj);
                return lambda$sortBBoxByRatio$3;
            }
        }).collect(Collectors.toList());
    }
}
