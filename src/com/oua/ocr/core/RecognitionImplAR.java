package com.oua.ocr.core;

import com.oua.ocr.OCR;
import com.oua.ocr.core.OCRManager;
import com.oua.ocr.core.RecognitionImplAR;
import com.oua.opencv.OpenCVUtil;
import com.oua.task.OUATask;
import com.oua.tflite.Config;
import com.oua.tflite.TfliteModelWrapper;
import com.oua.util.BufferUtil;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import com.oua.util.Transform;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes4.dex */
public class RecognitionImplAR extends RecognizerImpl {
    private static final int EOS = 1;
    private static final String TAG = "com.oua.ocr.core.RecognitionImplAR";
    private LabelDict labelDict;
    TfliteModelWrapper<Mat, OCR.OCRItem, Void> modelWrapper;
    int[] splitLens;

    /* renamed from: com.oua.ocr.core.RecognitionImplAR$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends TfliteModelWrapper<Mat, OCR.OCRItem, Void> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getPreprocessor$0() {
            return "preprocessor";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ TfliteModelWrapper.ModelIn lambda$getPreprocessor$1(Mat mat) {
            return new TfliteModelWrapper.ModelIn(OpenCVUtil.toDirectBuffer(mat));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ List lambda$getPreprocessor$2(List list) {
            return (List) RecognitionImplAR.this.preprocess(this, list).stream().map(new Function() { // from class: com.oua.ocr.core.p0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    TfliteModelWrapper.ModelIn lambda$getPreprocessor$1;
                    lambda$getPreprocessor$1 = RecognitionImplAR.AnonymousClass1.lambda$getPreprocessor$1((Mat) obj);
                    return lambda$getPreprocessor$1;
                }
            }).collect(Collectors.toList());
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public OUATask.BatchTask<TfliteModelWrapper.ModelOut<Void>, OCR.OCRItem> getPostprocessor() {
            return RecognitionImplAR.this.getPostprocessor();
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public OUATask.BatchTask<Mat, TfliteModelWrapper.ModelIn<Void>> getPreprocessor() {
            return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.ocr.core.n0
                @Override // com.oua.task.OUATask.GetNameFunc
                public final String apply() {
                    String lambda$getPreprocessor$0;
                    lambda$getPreprocessor$0 = RecognitionImplAR.AnonymousClass1.lambda$getPreprocessor$0();
                    return lambda$getPreprocessor$0;
                }
            }, new OUATask.RunFunc() { // from class: com.oua.ocr.core.o0
                @Override // com.oua.task.OUATask.RunFunc
                public final Object apply(Object obj) {
                    List lambda$getPreprocessor$2;
                    lambda$getPreprocessor$2 = RecognitionImplAR.AnonymousClass1.this.lambda$getPreprocessor$2((List) obj);
                    return lambda$getPreprocessor$2;
                }
            });
        }
    }

    public RecognitionImplAR(OCRManager.Config config) {
        super(config);
        this.modelWrapper = createModelWrapper();
    }

    private List<OCR.OCRItem> filterDuplication(List<OCR.OCRItem> list) {
        return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.i0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                OCR.OCRItem lambda$filterDuplication$12;
                lambda$filterDuplication$12 = RecognitionImplAR.this.lambda$filterDuplication$12((OCR.OCRItem) obj);
                return lambda$filterDuplication$12;
            }
        }).collect(Collectors.toList());
    }

    private List<OCR.OCRItem> filterInvalidChar(List<OCR.OCRItem> list) {
        return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.f0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                OCR.OCRItem lambda$filterInvalidChar$14;
                lambda$filterInvalidChar$14 = RecognitionImplAR.this.lambda$filterInvalidChar$14((OCR.OCRItem) obj);
                return lambda$filterInvalidChar$14;
            }
        }).collect(Collectors.toList());
    }

    private List<OCR.OCRItem> filterLowProb(final List<OCR.OCRItem> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10).text.length() != list.get(i10).probabilities.size()) {
                DebugConfig.loge(TAG, "Error merge !" + list.get(i10).text + " " + StringUtil.toString(list.get(i10).probabilities));
            }
        }
        List<OCR.OCRItem> list2 = (List) IntStream.range(0, list.size()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.Z
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                OCR.OCRItem lambda$filterLowProb$16;
                lambda$filterLowProb$16 = RecognitionImplAR.this.lambda$filterLowProb$16(list, i11);
                return lambda$filterLowProb$16;
            }
        }).collect(Collectors.toList());
        DebugConfig.logd(TAG, "filtered low prob:" + StringUtil.toString(list2));
        return list2;
    }

    private OCR.OCRItem filterWithIndexes(final OCR.OCRItem oCRItem, int[] iArr) {
        OCR.OCRItem oCRItem2 = new OCR.OCRItem();
        oCRItem2.text = (String) Arrays.stream(iArr).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.a0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Character lambda$filterWithIndexes$8;
                lambda$filterWithIndexes$8 = RecognitionImplAR.lambda$filterWithIndexes$8(OCR.OCRItem.this, i10);
                return lambda$filterWithIndexes$8;
            }
        }).map(new Function() { // from class: com.oua.ocr.core.b0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String ch;
                ch = ((Character) obj).toString();
                return ch;
            }
        }).collect(Collectors.joining());
        oCRItem2.probabilities = (List) Arrays.stream(iArr).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.c0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Double lambda$filterWithIndexes$10;
                lambda$filterWithIndexes$10 = RecognitionImplAR.lambda$filterWithIndexes$10(OCR.OCRItem.this, i10);
                return lambda$filterWithIndexes$10;
            }
        }).collect(Collectors.toList());
        return oCRItem2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$filterDuplication$11(OCR.OCRItem oCRItem, int i10) {
        if (i10 == 0 || Character.isDigit(oCRItem.text.charAt(i10)) || oCRItem.text.charAt(i10) != oCRItem.text.charAt(i10 - 1)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ OCR.OCRItem lambda$filterDuplication$12(final OCR.OCRItem oCRItem) {
        return filterWithIndexes(oCRItem, IntStream.range(0, oCRItem.text.length()).filter(new IntPredicate() { // from class: com.oua.ocr.core.V
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                boolean lambda$filterDuplication$11;
                lambda$filterDuplication$11 = RecognitionImplAR.lambda$filterDuplication$11(OCR.OCRItem.this, i10);
                return lambda$filterDuplication$11;
            }
        }).toArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$filterInvalidChar$13(OCR.OCRItem oCRItem, int i10) {
        if (oCRItem.text.charAt(i10) != '#') {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ OCR.OCRItem lambda$filterInvalidChar$14(final OCR.OCRItem oCRItem) {
        return filterWithIndexes(oCRItem, IntStream.range(0, oCRItem.text.length()).filter(new IntPredicate() { // from class: com.oua.ocr.core.e0
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                boolean lambda$filterInvalidChar$13;
                lambda$filterInvalidChar$13 = RecognitionImplAR.lambda$filterInvalidChar$13(OCR.OCRItem.this, i10);
                return lambda$filterInvalidChar$13;
            }
        }).toArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ OCR.OCRItem lambda$filterLowProb$16(List list, int i10) {
        if (((OCR.OCRItem) list.get(i10)).probabilities.stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.ocr.core.Y
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double doubleValue;
                doubleValue = ((Double) obj).doubleValue();
                return doubleValue;
            }
        }).average().orElse(0.0d) < this.ocrManager.getOCRParams().recognizerProbThold) {
            ((OCR.OCRItem) list.get(i10)).text = "";
        }
        return (OCR.OCRItem) list.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$filterWithIndexes$10(OCR.OCRItem oCRItem, int i10) {
        return oCRItem.probabilities.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Character lambda$filterWithIndexes$8(OCR.OCRItem oCRItem, int i10) {
        return Character.valueOf(oCRItem.text.charAt(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getPostprocessor$3() {
        return "postprocessor";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getPostprocessor$4(long j10) {
        return (int) j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getPostprocessor$5(float[] fArr, int i10) {
        return new Double(fArr[i10]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ OCR.OCRItem lambda$getPostprocessor$6(List list, int i10) {
        Map<Integer, ByteBuffer> map = ((TfliteModelWrapper.ModelOut) list.get(i10)).buffers;
        int[] array = Arrays.stream(BufferUtil.toArray(map.get(0).asLongBuffer())).mapToInt(new LongToIntFunction() { // from class: com.oua.ocr.core.g0
            @Override // java.util.function.LongToIntFunction
            public final int applyAsInt(long j10) {
                int lambda$getPostprocessor$4;
                lambda$getPostprocessor$4 = RecognitionImplAR.lambda$getPostprocessor$4(j10);
                return lambda$getPostprocessor$4;
            }
        }).toArray();
        DebugConfig.logv(TAG, "model output indexs: ", array);
        OCR.OCRItem oCRItem = new OCR.OCRItem();
        oCRItem.text = this.labelDict.index2String(array);
        final float[] array2 = BufferUtil.toArray(map.get(1).asFloatBuffer());
        oCRItem.probabilities = (List) IntStream.range(0, oCRItem.text.length()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.h0
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                Double lambda$getPostprocessor$5;
                lambda$getPostprocessor$5 = RecognitionImplAR.lambda$getPostprocessor$5(array2, i11);
                return lambda$getPostprocessor$5;
            }
        }).collect(Collectors.toList());
        return oCRItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$getPostprocessor$7(final List list) {
        List<OCR.OCRItem> list2 = (List) IntStream.range(0, list.size()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.d0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                OCR.OCRItem lambda$getPostprocessor$6;
                lambda$getPostprocessor$6 = RecognitionImplAR.this.lambda$getPostprocessor$6(list, i10);
                return lambda$getPostprocessor$6;
            }
        }).collect(Collectors.toList());
        String str = TAG;
        DebugConfig.logd(str, "model output result: " + StringUtil.toString(list2));
        List<OCR.OCRItem> filterDuplication = filterDuplication(list2);
        DebugConfig.logd(str, "filter duplications result: " + StringUtil.toString(filterDuplication));
        List<OCR.OCRItem> filterInvalidChar = filterInvalidChar(filterDuplication);
        DebugConfig.logd(str, "filter invalid char result: " + StringUtil.toString(filterInvalidChar));
        return filterLowProb(RecognizerImpl.merge(filterInvalidChar, this.splitLens));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$preprocess$0(Mat mat) {
        return RecognizerImpl.split(mat, this.ocrManager.getOCRParams().longBoxRatioThold, this.ocrManager.getOCRParams().longBoxSplitOverlapFactor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Mat lambda$preprocess$2(List list, TfliteModelWrapper tfliteModelWrapper, int i10) {
        Mat mat = (Mat) list.get(i10);
        String str = TAG;
        OpenCVUtil.logAndSave(str, String.format("mat_to_rec_%d", Integer.valueOf(i10)), mat);
        OpenCVUtil.resizeAndPad(mat, mat, tfliteModelWrapper.getInputImageSize(0), Transform.PaddingOption.Central);
        OpenCVUtil.logAndSave(str, String.format("rec_pre_resized_%d", Integer.valueOf(i10)), mat);
        Imgproc.cvtColor(mat, mat, 1);
        OpenCVUtil.logAndSave(str, String.format("rec_pre_bgr_%d", Integer.valueOf(i10)), mat);
        mat.convertTo(mat, CvType.CV_32FC3, 0.00392156862745098d);
        OpenCVUtil.logAndSave(str, String.format("rec_pre_normalized_%d", Integer.valueOf(i10)), mat);
        return mat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Mat> preprocess(final TfliteModelWrapper tfliteModelWrapper, final List<Mat> list) {
        this.splitLens = null;
        if (this.ocrManager.getOCRParams().splitLongBox) {
            List list2 = (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.l0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    List lambda$preprocess$0;
                    lambda$preprocess$0 = RecognitionImplAR.this.lambda$preprocess$0((Mat) obj);
                    return lambda$preprocess$0;
                }
            }).collect(Collectors.toList());
            int[] array = list2.stream().mapToInt(new ToIntFunction() { // from class: com.oua.ocr.core.m0
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    int size;
                    size = ((List) obj).size();
                    return size;
                }
            }).toArray();
            this.splitLens = array;
            DebugConfig.logv(TAG, "splitLens", array);
            list = (List) list2.stream().flatMap(new Function() { // from class: com.oua.ocr.core.W
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((List) obj).stream();
                }
            }).collect(Collectors.toList());
        }
        return (List) IntStream.range(0, list.size()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.X
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Mat lambda$preprocess$2;
                lambda$preprocess$2 = RecognitionImplAR.lambda$preprocess$2(list, tfliteModelWrapper, i10);
                return lambda$preprocess$2;
            }
        }).collect(Collectors.toList());
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public void closeImpl() {
        this.modelWrapper.close();
    }

    public TfliteModelWrapper<Mat, OCR.OCRItem, Void> createModelWrapper() {
        return new AnonymousClass1();
    }

    public OUATask.BatchTask<TfliteModelWrapper.ModelOut<Void>, OCR.OCRItem> getPostprocessor() {
        return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.ocr.core.j0
            @Override // com.oua.task.OUATask.GetNameFunc
            public final String apply() {
                String lambda$getPostprocessor$3;
                lambda$getPostprocessor$3 = RecognitionImplAR.lambda$getPostprocessor$3();
                return lambda$getPostprocessor$3;
            }
        }, new OUATask.RunFunc() { // from class: com.oua.ocr.core.k0
            @Override // com.oua.task.OUATask.RunFunc
            public final Object apply(Object obj) {
                List lambda$getPostprocessor$7;
                lambda$getPostprocessor$7 = RecognitionImplAR.this.lambda$getPostprocessor$7((List) obj);
                return lambda$getPostprocessor$7;
            }
        });
    }

    @Override // com.oua.ocr.core.RecognizerImpl
    public List<OUATask.Task> getTaskList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.modelWrapper.getTaskList());
        return arrayList;
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public void initImpl() {
        SimpleTrace.getTrace().startSection("recognizer_init", TAG);
        TfliteModelWrapper<Mat, OCR.OCRItem, Void> tfliteModelWrapper = this.modelWrapper;
        Config config = this.config.recognizerConfig.modelConfig;
        tfliteModelWrapper.init(config, this.ocrManager.loadModelFile(config.modelPath));
        this.labelDict = new LabelDict(this.ocrManager.loadTxtFile(this.config.recognizerConfig.dictPath), this.config.recognizerConfig.dictPath, 1);
        SimpleTrace.getTrace().endSection("recognizer_init");
    }
}
