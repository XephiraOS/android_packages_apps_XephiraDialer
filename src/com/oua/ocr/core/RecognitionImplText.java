package com.oua.ocr.core;

import android.util.Log;
import android.util.Size;
import com.oua.ocr.OCR;
import com.oua.ocr.core.OCRManager;
import com.oua.ocr.core.RecognitionImplText;
import com.oua.opencv.OpenCVUtil;
import com.oua.task.OUATask;
import com.oua.task.OUATaskExecutor;
import com.oua.tflite.Config;
import com.oua.tflite.TfliteModelWrapper;
import com.oua.util.BufferUtil;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.Transform;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes4.dex */
public class RecognitionImplText extends RecognizerImpl {
    private static final String TAG = "com.oua.ocr.core.RecognitionImplText";
    protected LabelDict labelDict;
    private TfliteModelWrapper<Mat, OCR.OCRItem, Void> modelWrapper;

    /* renamed from: com.oua.ocr.core.RecognitionImplText$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends TfliteModelWrapper<Mat, OCR.OCRItem, Void> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getPostprocessor$2() {
            return "postprocessor";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ List lambda$getPostprocessor$3(List list) {
            return RecognitionImplText.this.postprocess(this, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getPreprocessor$0() {
            return "preprocessor";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ List lambda$getPreprocessor$1(List list) {
            return RecognitionImplText.preprocess(this, list);
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public String getName() {
            return RecognitionImplText.class.getSimpleName();
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public OUATask.BatchTask<TfliteModelWrapper.ModelOut<Void>, OCR.OCRItem> getPostprocessor() {
            return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.ocr.core.C0
                @Override // com.oua.task.OUATask.GetNameFunc
                public final String apply() {
                    String lambda$getPostprocessor$2;
                    lambda$getPostprocessor$2 = RecognitionImplText.AnonymousClass1.lambda$getPostprocessor$2();
                    return lambda$getPostprocessor$2;
                }
            }, new OUATask.RunFunc() { // from class: com.oua.ocr.core.D0
                @Override // com.oua.task.OUATask.RunFunc
                public final Object apply(Object obj) {
                    List lambda$getPostprocessor$3;
                    lambda$getPostprocessor$3 = RecognitionImplText.AnonymousClass1.this.lambda$getPostprocessor$3((List) obj);
                    return lambda$getPostprocessor$3;
                }
            });
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public OUATask.BatchTask<Mat, TfliteModelWrapper.ModelIn<Void>> getPreprocessor() {
            return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.ocr.core.A0
                @Override // com.oua.task.OUATask.GetNameFunc
                public final String apply() {
                    String lambda$getPreprocessor$0;
                    lambda$getPreprocessor$0 = RecognitionImplText.AnonymousClass1.lambda$getPreprocessor$0();
                    return lambda$getPreprocessor$0;
                }
            }, new OUATask.RunFunc() { // from class: com.oua.ocr.core.B0
                @Override // com.oua.task.OUATask.RunFunc
                public final Object apply(Object obj) {
                    List lambda$getPreprocessor$1;
                    lambda$getPreprocessor$1 = RecognitionImplText.AnonymousClass1.this.lambda$getPreprocessor$1((List) obj);
                    return lambda$getPreprocessor$1;
                }
            });
        }
    }

    public RecognitionImplText(OCRManager.Config config) {
        super(config);
        this.modelWrapper = createModelWrapper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$postprocess$4(int[] iArr, FloatBuffer floatBuffer, double[] dArr, int i10) {
        int i11 = iArr[2];
        float[] fArr = new float[i11];
        floatBuffer.get(fArr);
        int i12 = -1;
        float f10 = 0.0f;
        for (int i13 = 0; i13 < i11; i13++) {
            float f11 = fArr[i13];
            if (f11 > f10) {
                i12 = i13;
                f10 = f11;
            }
        }
        double d10 = f10;
        if (!Double.isFinite(d10)) {
            d10 = 1.0d;
        }
        dArr[i10] = d10;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$postprocess$6(int[] iArr, int[] iArr2, int i10) {
        int i11 = iArr[i10];
        if (i11 >= 0 && i11 < iArr2[2] - 1) {
            if (i10 <= 0 || i11 != iArr[i10 - 1]) {
                return true;
            }
            if (i10 > 1 && i11 == iArr[i10 - 2]) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$postprocess$7(int[] iArr, int i10) {
        return iArr[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$postprocess$8(OCR.OCRItem oCRItem, int i10) {
        return oCRItem.probabilities.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ OCR.OCRItem lambda$postprocess$9(TfliteModelWrapper tfliteModelWrapper, TfliteModelWrapper.ModelOut modelOut) {
        final FloatBuffer asFloatBuffer = modelOut.buffers.get(0).asFloatBuffer();
        String str = TAG;
        BufferUtil.logBuffer(str, "rec_model_out", modelOut.buffers.get(0));
        final int[] outputTensorShape = tfliteModelWrapper.getOutputTensorShape(0);
        int i10 = outputTensorShape[1];
        final double[] dArr = new double[i10];
        final int[] array = IntStream.range(0, i10).map(new IntUnaryOperator() { // from class: com.oua.ocr.core.v0
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i11) {
                int lambda$postprocess$4;
                lambda$postprocess$4 = RecognitionImplText.lambda$postprocess$4(outputTensorShape, asFloatBuffer, dArr, i11);
                return lambda$postprocess$4;
            }
        }).toArray();
        DebugConfig.logv(str, "text_indexes", array);
        final OCR.OCRItem oCRItem = new OCR.OCRItem();
        oCRItem.probabilities = (List) Arrays.stream(dArr).mapToObj(new DoubleFunction() { // from class: com.oua.ocr.core.w0
            @Override // java.util.function.DoubleFunction
            public final Object apply(double d10) {
                Double valueOf;
                valueOf = Double.valueOf(d10);
                return valueOf;
            }
        }).collect(Collectors.toList());
        int[] array2 = IntStream.range(0, array.length).filter(new IntPredicate() { // from class: com.oua.ocr.core.x0
            @Override // java.util.function.IntPredicate
            public final boolean test(int i11) {
                boolean lambda$postprocess$6;
                lambda$postprocess$6 = RecognitionImplText.lambda$postprocess$6(array, outputTensorShape, i11);
                return lambda$postprocess$6;
            }
        }).toArray();
        String index2String = this.labelDict.index2String(Arrays.stream(array2).map(new IntUnaryOperator() { // from class: com.oua.ocr.core.y0
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i11) {
                int lambda$postprocess$7;
                lambda$postprocess$7 = RecognitionImplText.lambda$postprocess$7(array, i11);
                return lambda$postprocess$7;
            }
        }).toArray());
        oCRItem.text = index2String;
        int[] copyOf = Arrays.copyOf(array2, index2String.length());
        oCRItem.probabilities = (List) Arrays.stream(copyOf).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.z0
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                Double lambda$postprocess$8;
                lambda$postprocess$8 = RecognitionImplText.lambda$postprocess$8(OCR.OCRItem.this, i11);
                return lambda$postprocess$8;
            }
        }).collect(Collectors.toList());
        if (oCRItem.text.length() != oCRItem.probabilities.size()) {
            DebugConfig.logd(str, String.format("lengths %d, %d, %d", Integer.valueOf(oCRItem.text.length()), Integer.valueOf(oCRItem.probabilities.size()), Integer.valueOf(copyOf.length)));
        }
        DebugConfig.logd(str, "result: ", oCRItem);
        return oCRItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TfliteModelWrapper.ModelIn lambda$preprocess$3(List list, TfliteModelWrapper tfliteModelWrapper, int i10) {
        Mat mat = (Mat) list.get(i10);
        String str = TAG;
        OpenCVUtil.logAndSave(str, String.format("rec_input_%d", Integer.valueOf(i10)), mat);
        Size inputImageSize = tfliteModelWrapper.getInputImageSize(0);
        int height = (int) ((inputImageSize.getHeight() / mat.height()) * mat.width());
        Mat mat2 = new Mat();
        if (height > inputImageSize.getWidth()) {
            Imgproc.resize(mat, mat2, new org.opencv.core.Size(inputImageSize.getWidth(), inputImageSize.getHeight()));
        } else {
            OpenCVUtil.resizeAndPad(mat, mat2, inputImageSize, Transform.PaddingOption.PadBottomRight);
        }
        OpenCVUtil.logAndSave(str, String.format("rec_pre_resized_%d", Integer.valueOf(i10)), mat2);
        Imgproc.cvtColor(mat2, mat2, 11);
        OpenCVUtil.logAndSave(str, String.format("rec_pre_gray_%d", Integer.valueOf(i10)), mat2);
        mat2.convertTo(mat2, CvType.CV_32FC1, 0.00392156862745098d, -0.5d);
        OpenCVUtil.logAndSave(str, String.format("rec_pre_normalized_%d", Integer.valueOf(i10)), mat2);
        ByteBuffer directBuffer = OpenCVUtil.toDirectBuffer(mat2);
        mat2.release();
        BufferUtil.logBuffer(str, String.format("input_buffer_%d", Integer.valueOf(i10)), directBuffer);
        return new TfliteModelWrapper.ModelIn(directBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$run$0(Mat mat) {
        return RecognizerImpl.split(mat, this.ocrManager.getOCRParams().longBoxRatioThold, this.ocrManager.getOCRParams().longBoxSplitOverlapFactor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ OCR.OCRItem lambda$run$2(OUATaskExecutor oUATaskExecutor, List list) {
        Log.d(TAG, "SplitMat " + list.size());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            List list2 = (List) oUATaskExecutor.run(Arrays.asList((Mat) it.next()), getTaskList(), getClass().getSimpleName(), getClass().getName());
            if (((OCR.OCRItem) list2.get(0)).probabilities.stream().mapToDouble(new ToDoubleFunction() { // from class: com.oua.ocr.core.u0
                @Override // java.util.function.ToDoubleFunction
                public final double applyAsDouble(Object obj) {
                    double doubleValue;
                    doubleValue = ((Double) obj).doubleValue();
                    return doubleValue;
                }
            }).average().orElse(0.0d) < this.ocrManager.getOCRParams().recognizerProbTholdCV) {
                DebugConfig.loge(TAG, "SplitMat break " + list2.toString());
                break;
            }
            arrayList.add((OCR.OCRItem) list2.get(0));
        }
        return RecognizerImpl.merge(arrayList, 0, arrayList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<OCR.OCRItem> postprocess(final TfliteModelWrapper tfliteModelWrapper, List<TfliteModelWrapper.ModelOut<Void>> list) {
        return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.q0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                OCR.OCRItem lambda$postprocess$9;
                lambda$postprocess$9 = RecognitionImplText.this.lambda$postprocess$9(tfliteModelWrapper, (TfliteModelWrapper.ModelOut) obj);
                return lambda$postprocess$9;
            }
        }).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<TfliteModelWrapper.ModelIn<Void>> preprocess(final TfliteModelWrapper tfliteModelWrapper, final List<Mat> list) {
        return (List) IntStream.range(0, list.size()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.t0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                TfliteModelWrapper.ModelIn lambda$preprocess$3;
                lambda$preprocess$3 = RecognitionImplText.lambda$preprocess$3(list, tfliteModelWrapper, i10);
                return lambda$preprocess$3;
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
        this.labelDict = new LabelDict(this.ocrManager.loadTxtFile(this.config.recognizerConfig.dictPath), this.config.recognizerConfig.dictPath, 0);
        SimpleTrace.getTrace().endSection("recognizer_init");
    }

    @Override // com.oua.ocr.core.RecognizerImpl, com.oua.ocr.core.OCRManager.Engine
    public List<OCR.OCRItem> run(OCRManager.RecognizerInput recognizerInput) {
        final OUATaskExecutor oUATaskExecutor = new OUATaskExecutor();
        List<Mat> list = recognizerInput.textImages;
        return (List) (this.ocrManager.getOCRParams().splitLongBox ? (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.r0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List lambda$run$0;
                lambda$run$0 = RecognitionImplText.this.lambda$run$0((Mat) obj);
                return lambda$run$0;
            }
        }).collect(Collectors.toList()) : Arrays.asList(list)).stream().map(new Function() { // from class: com.oua.ocr.core.s0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                OCR.OCRItem lambda$run$2;
                lambda$run$2 = RecognitionImplText.this.lambda$run$2(oUATaskExecutor, (List) obj);
                return lambda$run$2;
            }
        }).collect(Collectors.toList());
    }
}
