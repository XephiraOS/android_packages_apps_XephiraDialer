package com.oua.ocr.core;

import android.graphics.Bitmap;
import android.util.Size;
import com.oua.ocr.core.OCRManager;
import com.oua.ocr.core.TextAreaDetectorImpl;
import com.oua.opencv.BBoxUtil;
import com.oua.opencv.OpenCVUtil;
import com.oua.task.OUATask;
import com.oua.tflite.Config;
import com.oua.tflite.TfliteModelWrapper;
import com.oua.util.BitmapUtil;
import com.oua.util.DebugConfig;
import com.oua.util.StringUtil;
import com.oua.util.Transform;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes4.dex */
public class TextAreaDetectorImpl extends OCRManager.TextAreaDetector {
    protected static final String TAG = "com.oua.ocr.core.TextAreaDetectorImpl";
    protected Config config;
    protected TfliteModelWrapper<Bitmap, OCRManager.TextAreaOutput, Transform.TransformGroup> modelWrapper = new AnonymousClass1();

    /* renamed from: com.oua.ocr.core.TextAreaDetectorImpl$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends TfliteModelWrapper<Bitmap, OCRManager.TextAreaOutput, Transform.TransformGroup> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getPostprocessor$3() {
            return "detector_postprocessor";
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ OCRManager.TextAreaOutput lambda$getPostprocessor$4(TfliteModelWrapper.ModelOut modelOut) {
            return TextAreaDetectorImpl.this.postprocess(modelOut.buffers.get(0), (Transform.TransformGroup) modelOut.extraData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ List lambda$getPostprocessor$5(List list) {
            return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.N0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    OCRManager.TextAreaOutput lambda$getPostprocessor$4;
                    lambda$getPostprocessor$4 = TextAreaDetectorImpl.AnonymousClass1.this.lambda$getPostprocessor$4((TfliteModelWrapper.ModelOut) obj);
                    return lambda$getPostprocessor$4;
                }
            }).collect(Collectors.toList());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getPreprocessor$0() {
            return "detector_preprocessor";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ TfliteModelWrapper.ModelIn lambda$getPreprocessor$1(Bitmap bitmap) {
            return TextAreaDetectorImpl.this.preprocess(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ List lambda$getPreprocessor$2(List list) {
            return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.K0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    TfliteModelWrapper.ModelIn lambda$getPreprocessor$1;
                    lambda$getPreprocessor$1 = TextAreaDetectorImpl.AnonymousClass1.this.lambda$getPreprocessor$1((Bitmap) obj);
                    return lambda$getPreprocessor$1;
                }
            }).collect(Collectors.toList());
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public String getName() {
            return TextAreaDetectorImpl.class.getSimpleName();
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public OUATask.BatchTask<TfliteModelWrapper.ModelOut<Transform.TransformGroup>, OCRManager.TextAreaOutput> getPostprocessor() {
            return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.ocr.core.L0
                @Override // com.oua.task.OUATask.GetNameFunc
                public final String apply() {
                    String lambda$getPostprocessor$3;
                    lambda$getPostprocessor$3 = TextAreaDetectorImpl.AnonymousClass1.lambda$getPostprocessor$3();
                    return lambda$getPostprocessor$3;
                }
            }, new OUATask.RunFunc() { // from class: com.oua.ocr.core.M0
                @Override // com.oua.task.OUATask.RunFunc
                public final Object apply(Object obj) {
                    List lambda$getPostprocessor$5;
                    lambda$getPostprocessor$5 = TextAreaDetectorImpl.AnonymousClass1.this.lambda$getPostprocessor$5((List) obj);
                    return lambda$getPostprocessor$5;
                }
            });
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public OUATask.BatchTask<Bitmap, TfliteModelWrapper.ModelIn<Transform.TransformGroup>> getPreprocessor() {
            return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.ocr.core.I0
                @Override // com.oua.task.OUATask.GetNameFunc
                public final String apply() {
                    String lambda$getPreprocessor$0;
                    lambda$getPreprocessor$0 = TextAreaDetectorImpl.AnonymousClass1.lambda$getPreprocessor$0();
                    return lambda$getPreprocessor$0;
                }
            }, new OUATask.RunFunc() { // from class: com.oua.ocr.core.J0
                @Override // com.oua.task.OUATask.RunFunc
                public final Object apply(Object obj) {
                    List lambda$getPreprocessor$2;
                    lambda$getPreprocessor$2 = TextAreaDetectorImpl.AnonymousClass1.this.lambda$getPreprocessor$2((List) obj);
                    return lambda$getPreprocessor$2;
                }
            });
        }
    }

    public TextAreaDetectorImpl(Config config) {
        Config m9clone = config.m9clone();
        this.config = m9clone;
        if (m9clone.device == null) {
            m9clone.device = Config.Device.GPU;
            m9clone.threadNum = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortBox$1(List list, Integer num, Integer num2) {
        Point point = (Point) list.get(num.intValue());
        Point point2 = (Point) list.get(num2.intValue());
        double d10 = point.f35882x;
        double d11 = point.f35883y;
        double d12 = point2.f35883y;
        double d13 = point2.f35882x;
        return Double.compare((d10 * d10) + (d11 * d12), (d13 * d13) + (d12 * d12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$sortBox$2(List list, int i10, int i11) {
        return (Point) list.get((i11 + i10) % list.size());
    }

    private static List<Point> sortBox(final List<Point> list) {
        final int intValue = ((Integer) IntStream.range(0, list.size()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.F0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Integer valueOf;
                valueOf = Integer.valueOf(i10);
                return valueOf;
            }
        }).min(new Comparator() { // from class: com.oua.ocr.core.G0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int lambda$sortBox$1;
                lambda$sortBox$1 = TextAreaDetectorImpl.lambda$sortBox$1(list, (Integer) obj, (Integer) obj2);
                return lambda$sortBox$1;
            }
        }).orElse(0)).intValue();
        return (List) IntStream.range(0, list.size()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.H0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Point lambda$sortBox$2;
                lambda$sortBox$2 = TextAreaDetectorImpl.lambda$sortBox$2(list, intValue, i10);
                return lambda$sortBox$2;
            }
        }).collect(Collectors.toList());
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public void closeImpl() {
        this.modelWrapper.close();
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public void initImpl() {
        TfliteModelWrapper<Bitmap, OCRManager.TextAreaOutput, Transform.TransformGroup> tfliteModelWrapper = this.modelWrapper;
        Config config = this.config;
        tfliteModelWrapper.init(config, this.ocrManager.loadModelFile(config.modelPath));
    }

    public OCRManager.TextAreaOutput postprocess(ByteBuffer byteBuffer, Transform.TransformGroup transformGroup) {
        int[] outputTensorShape = this.modelWrapper.getOutputTensorShape(0);
        Mat mat = new Mat(outputTensorShape[0], outputTensorShape[1], 5, byteBuffer);
        OpenCVUtil.logAndSave(TAG, "textarea_detect_modelOutput", mat);
        List<Point> textAreaDetectorPostProcess = OCRNative.textAreaDetectorPostProcess(mat);
        OCRManager.TextAreaOutput textAreaOutput = new OCRManager.TextAreaOutput();
        if (textAreaDetectorPostProcess != null && textAreaDetectorPostProcess.size() >= 4) {
            textAreaOutput.textArea = BBoxUtil.reverseTransform(sortBox(textAreaDetectorPostProcess), transformGroup);
        } else {
            textAreaOutput.textArea = BBoxUtil.rect2Points(0.0d, 0.0d, transformGroup.getSrcSize().getWidth(), transformGroup.getSrcSize().getHeight());
        }
        return textAreaOutput;
    }

    public TfliteModelWrapper.ModelIn<Transform.TransformGroup> preprocess(Bitmap bitmap) {
        Transform.TransformGroup transformGroup = new Transform.TransformGroup();
        int[] inputTensorShape = this.modelWrapper.getInputTensorShape(0);
        Bitmap resize = BitmapUtil.resize(bitmap, new Size(inputTensorShape[1], inputTensorShape[0]), transformGroup);
        Mat mat = new Mat();
        Utils.bitmapToMat(resize, mat);
        resize.recycle();
        Imgproc.cvtColor(mat, mat, 1);
        mat.convertTo(mat, CvType.CV_32FC3);
        OpenCVUtil.logAndSave(TAG, "edge_detect_modelInput", mat);
        ByteBuffer directBuffer = OpenCVUtil.toDirectBuffer(mat);
        mat.release();
        return new TfliteModelWrapper.ModelIn<>(directBuffer, 1, transformGroup);
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public OCRManager.TextAreaOutput run(Bitmap bitmap) {
        OCRManager.TextAreaOutput textAreaOutput = (OCRManager.TextAreaOutput) ((List) this.modelWrapper.run(Arrays.asList(bitmap))).get(0);
        DebugConfig.logd(TAG, "edge_detection_result:" + StringUtil.toString(textAreaOutput.textArea));
        return textAreaOutput;
    }
}
