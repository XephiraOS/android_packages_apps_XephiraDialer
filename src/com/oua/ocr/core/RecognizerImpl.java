package com.oua.ocr.core;

import com.oua.ocr.OCR;
import com.oua.ocr.core.OCRManager;
import com.oua.opencv.BBoxUtil;
import com.oua.opencv.OpenCVUtil;
import com.oua.task.OUATask;
import com.oua.task.OUATaskExecutor;
import com.oua.util.DebugConfig;
import com.oua.util.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.opencv.core.Mat;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public abstract class RecognizerImpl extends OCRManager.Recognizer {
    private static final String TAG = "com.oua.ocr.core.RecognizerImpl";
    protected OCRManager.Config config;

    public RecognizerImpl(OCRManager.Config config) {
        this.config = config;
        if (config.recognizerConfig.dictPath != null) {
        } else {
            throw new RuntimeException("Dict path cannot be null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mat lambda$split$0(boolean z10, double d10, int i10, double d11, int i11, Mat mat, int i12) {
        List<Point> rect2Points;
        if (z10) {
            rect2Points = BBoxUtil.rect2Points(0.0d, i12 * d10, i10, (i12 + 1 + d11) * d10);
        } else {
            rect2Points = BBoxUtil.rect2Points(i12 * d10, 0.0d, (i12 + 1 + d11) * d10, i11);
        }
        return OpenCVUtil.warpCrop(mat, rect2Points);
    }

    public static OCR.OCRItem merge(List<OCR.OCRItem> list, int i10, int i11) {
        OCR.OCRItem oCRItem = new OCR.OCRItem();
        if (list.isEmpty()) {
            return oCRItem;
        }
        OCR.OCRItem oCRItem2 = list.get(i10);
        StringBuilder sb = new StringBuilder(oCRItem2.text);
        oCRItem.probabilities = oCRItem2.probabilities;
        for (int i12 = i10 + 1; i12 < i11; i12++) {
            OCR.OCRItem oCRItem3 = list.get(i12);
            int length = sb.length();
            String str = oCRItem3.text;
            int length2 = str.length();
            int i13 = 0;
            if (length >= 2 && length2 >= 2 && str.charAt(0) == sb.charAt(length - 2) && str.charAt(1) == sb.charAt(length - 1)) {
                i13 = 2;
            } else if (length >= 1 && length2 >= 1 && str.charAt(0) == sb.charAt(length - 1)) {
                i13 = 1;
            }
            List<Double> list2 = oCRItem3.probabilities;
            if (list2 != null) {
                oCRItem.probabilities = mergeProb(oCRItem.probabilities, list2, i13);
            }
            sb.append(str.substring(i13));
        }
        oCRItem.text = sb.toString();
        DebugConfig.logd(TAG, "merged result:" + StringUtil.toString(oCRItem));
        return oCRItem;
    }

    private static List<Double> mergeProb(List<Double> list, List<Double> list2, int i10) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(list2.subList(i10, list2.size()));
        return arrayList;
    }

    public static List<Mat> split(final Mat mat, int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        int i14;
        final double d10;
        final int width = mat.width();
        final int height = mat.height();
        if (width < height) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i12 = height / width;
        } else {
            i12 = width / height;
        }
        double d11 = i12;
        if (z10) {
            i13 = height;
        } else {
            i13 = width;
        }
        double d12 = i10;
        if (d11 > d12) {
            i14 = (int) (d11 / d12);
        } else {
            i14 = 1;
        }
        if (i11 == 0) {
            d10 = 0.0d;
        } else {
            d10 = 1 / i11;
        }
        final double d13 = i13 / (i14 + d10);
        DebugConfig.logd(TAG, String.format("split %d %d %f %f", Integer.valueOf(i13), Integer.valueOf(i14), Double.valueOf(d13), Double.valueOf(d10)));
        if (i14 == 1) {
            return Arrays.asList(mat.clone());
        }
        final boolean z11 = z10;
        return (List) IntStream.range(0, i14).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.E0
            @Override // java.util.function.IntFunction
            public final Object apply(int i15) {
                Mat lambda$split$0;
                lambda$split$0 = RecognizerImpl.lambda$split$0(z11, d13, width, d10, height, mat, i15);
                return lambda$split$0;
            }
        }).collect(Collectors.toList());
    }

    public abstract List<OUATask.Task> getTaskList();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.oua.ocr.core.OCRManager.Engine
    public List<OCR.OCRItem> run(OCRManager.RecognizerInput recognizerInput) {
        return (List) new OUATaskExecutor().run(recognizerInput.textImages, getTaskList(), getClass().getSimpleName(), getClass().getName());
    }

    public static List<OCR.OCRItem> merge(List<OCR.OCRItem> list, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        DebugConfig.logd(TAG, "splitLens " + StringUtil.toString(iArr));
        if (iArr != null) {
            int length = iArr.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = iArr[i10] + i11;
                arrayList.add(merge(list, i11, i12));
                i10++;
                i11 = i12;
            }
        }
        DebugConfig.logd(TAG, "merged result:" + StringUtil.toString(arrayList));
        return arrayList;
    }
}
