package com.oua.ocr.core;

import android.graphics.Rect;
import android.util.Size;
import com.oua.ocr.core.DetectorImpl;
import com.oua.ocr.core.OCRManager;
import com.oua.opencv.BBoxUtil;
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
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public class DetectorImpl extends OCRManager.Detector {
    protected static final String TAG = "com.oua.ocr.core.DetectorImpl";
    protected OCRManager.Config config;
    protected TfliteModelWrapper<OCRManager.DetectorInput, OCRManager.DetectorOutput, Transform.TransformGroup> modelWrapper = new AnonymousClass1();

    /* renamed from: com.oua.ocr.core.DetectorImpl$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 extends TfliteModelWrapper<OCRManager.DetectorInput, OCRManager.DetectorOutput, Transform.TransformGroup> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getPostprocessor$3() {
            return "detector_postprocessor";
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ OCRManager.DetectorOutput lambda$getPostprocessor$4(TfliteModelWrapper.ModelOut modelOut) {
            return DetectorImpl.this.postprocess(modelOut.buffers.get(0), (Transform.TransformGroup) modelOut.extraData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ List lambda$getPostprocessor$5(List list) {
            return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.k
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    OCRManager.DetectorOutput lambda$getPostprocessor$4;
                    lambda$getPostprocessor$4 = DetectorImpl.AnonymousClass1.this.lambda$getPostprocessor$4((TfliteModelWrapper.ModelOut) obj);
                    return lambda$getPostprocessor$4;
                }
            }).collect(Collectors.toList());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getPreprocessor$0() {
            return "detector_preprocessor";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ TfliteModelWrapper.ModelIn lambda$getPreprocessor$1(OCRManager.DetectorInput detectorInput) {
            return DetectorImpl.this.preprocess(detectorInput);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ List lambda$getPreprocessor$2(List list) {
            return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.p
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    TfliteModelWrapper.ModelIn lambda$getPreprocessor$1;
                    lambda$getPreprocessor$1 = DetectorImpl.AnonymousClass1.this.lambda$getPreprocessor$1((OCRManager.DetectorInput) obj);
                    return lambda$getPreprocessor$1;
                }
            }).collect(Collectors.toList());
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public String getName() {
            return DetectorImpl.class.getSimpleName();
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public OUATask.BatchTask<TfliteModelWrapper.ModelOut<Transform.TransformGroup>, OCRManager.DetectorOutput> getPostprocessor() {
            return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.ocr.core.n
                @Override // com.oua.task.OUATask.GetNameFunc
                public final String apply() {
                    String lambda$getPostprocessor$3;
                    lambda$getPostprocessor$3 = DetectorImpl.AnonymousClass1.lambda$getPostprocessor$3();
                    return lambda$getPostprocessor$3;
                }
            }, new OUATask.RunFunc() { // from class: com.oua.ocr.core.o
                @Override // com.oua.task.OUATask.RunFunc
                public final Object apply(Object obj) {
                    List lambda$getPostprocessor$5;
                    lambda$getPostprocessor$5 = DetectorImpl.AnonymousClass1.this.lambda$getPostprocessor$5((List) obj);
                    return lambda$getPostprocessor$5;
                }
            });
        }

        @Override // com.oua.tflite.TfliteModelWrapper
        public OUATask.BatchTask<OCRManager.DetectorInput, TfliteModelWrapper.ModelIn<Transform.TransformGroup>> getPreprocessor() {
            return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.ocr.core.l
                @Override // com.oua.task.OUATask.GetNameFunc
                public final String apply() {
                    String lambda$getPreprocessor$0;
                    lambda$getPreprocessor$0 = DetectorImpl.AnonymousClass1.lambda$getPreprocessor$0();
                    return lambda$getPreprocessor$0;
                }
            }, new OUATask.RunFunc() { // from class: com.oua.ocr.core.m
                @Override // com.oua.task.OUATask.RunFunc
                public final Object apply(Object obj) {
                    List lambda$getPreprocessor$2;
                    lambda$getPreprocessor$2 = DetectorImpl.AnonymousClass1.this.lambda$getPreprocessor$2((List) obj);
                    return lambda$getPreprocessor$2;
                }
            });
        }
    }

    public DetectorImpl(OCRManager.Config config) {
        OCRManager.Config m7clone = config.m7clone();
        this.config = m7clone;
        Config config2 = m7clone.detecotorModelConfig;
        if (config2.device == null) {
            config2.device = Config.Device.GPU;
            config2.threadNum = 1;
        }
    }

    private static Point[] input2OutputCoordinates(Point[] pointArr, Size size, Size size2) {
        final Transform.TransformScale createFixRatioScale = Transform.TransformScale.createFixRatioScale(size, size2);
        DebugConfig.logd(TAG, String.format("input2OutputCoordinates %s", StringUtil.toString(createFixRatioScale)));
        return (Point[]) Arrays.stream(pointArr).map(new Function() { // from class: com.oua.ocr.core.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Point lambda$input2OutputCoordinates$1;
                lambda$input2OutputCoordinates$1 = DetectorImpl.lambda$input2OutputCoordinates$1(Transform.this, (Point) obj);
                return lambda$input2OutputCoordinates$1;
            }
        }).toArray(new IntFunction() { // from class: com.oua.ocr.core.h
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Point[] lambda$input2OutputCoordinates$2;
                lambda$input2OutputCoordinates$2 = DetectorImpl.lambda$input2OutputCoordinates$2(i10);
                return lambda$input2OutputCoordinates$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$input2OutputCoordinates$1(Transform transform, Point point) {
        return new Point(transform.transform(point.f35882x, point.f35883y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point[] lambda$input2OutputCoordinates$2(int i10) {
        return new Point[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$output2InputCoordinates$3(Transform.TransformGroup transformGroup, List list) {
        return BBoxUtil.reverseTransform(list, transformGroup);
    }

    private static Mat normalize(Mat mat) {
        ArrayList arrayList = new ArrayList();
        Core.split(mat, arrayList);
        Mat mat2 = new Mat();
        Mat mat3 = (Mat) arrayList.get(0);
        int i10 = CvType.CV_32FC1;
        mat3.convertTo(mat2, i10, 0.017124753831663668d, -2.1179039301310043d);
        Mat mat4 = new Mat();
        ((Mat) arrayList.get(1)).convertTo(mat4, i10, 0.01750700280112045d, -2.0357142228785237d);
        Mat mat5 = new Mat();
        ((Mat) arrayList.get(2)).convertTo(mat5, i10, 0.017429193899782137d, -1.8044444444444445d);
        Mat mat6 = new Mat();
        Core.merge(Arrays.asList(mat2, mat4, mat5), mat6);
        mat2.release();
        mat4.release();
        mat5.release();
        arrayList.stream().forEach(new Consumer() { // from class: com.oua.ocr.core.j
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Mat) obj).release();
            }
        });
        arrayList.clear();
        return mat6;
    }

    public static List<List<Point>> output2InputCoordinates(List<List<Point>> list, Size size, Size size2, Transform.TransformGroup transformGroup) {
        Transform.TransformScale createFixRatioScale = Transform.TransformScale.createFixRatioScale(size, size2);
        DebugConfig.logd(TAG, String.format("output2InputCoordinates %s %s", StringUtil.toString(createFixRatioScale), StringUtil.toString(transformGroup)));
        final Transform.TransformGroup transformGroup2 = new Transform.TransformGroup();
        transformGroup2.transforms.addAll(transformGroup.transforms);
        transformGroup2.transforms.add(createFixRatioScale);
        return (List) list.stream().map(new Function() { // from class: com.oua.ocr.core.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List lambda$output2InputCoordinates$3;
                lambda$output2InputCoordinates$3 = DetectorImpl.lambda$output2InputCoordinates$3(Transform.TransformGroup.this, (List) obj);
                return lambda$output2InputCoordinates$3;
            }
        }).collect(Collectors.toList());
    }

    private static Mat rotateMat(Mat mat, Transform.TransformGroup transformGroup) {
        Transform.TransformRotate transformRotate = new Transform.TransformRotate(new Size(mat.width(), mat.height()), -90);
        Core.rotate(mat, mat, 2);
        SimpleTrace.getTrace().addEvent("rotate-90");
        transformGroup.transforms.add(transformRotate);
        return mat;
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public void closeImpl() {
        this.modelWrapper.close();
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public void initImpl() {
        TfliteModelWrapper<OCRManager.DetectorInput, OCRManager.DetectorOutput, Transform.TransformGroup> tfliteModelWrapper = this.modelWrapper;
        Config config = this.config.detecotorModelConfig;
        tfliteModelWrapper.init(config, this.ocrManager.loadModelFile(config.modelPath));
    }

    public OCRManager.DetectorOutput postprocess(ByteBuffer byteBuffer, Transform.TransformGroup transformGroup) {
        W9.a c10 = W9.a.c(this.modelWrapper.getOutputTensorShape(0), this.modelWrapper.getOutputTensorDataType(0));
        c10.k(byteBuffer);
        int[] outputTensorShape = this.modelWrapper.getOutputTensorShape(0);
        Size size = new Size(outputTensorShape[2], outputTensorShape[1]);
        Rect calcValidRect = transformGroup.calcValidRect();
        String str = TAG;
        DebugConfig.logd(str, "input valid rect " + calcValidRect);
        Point[] pointArr = {new Point((double) calcValidRect.left, (double) calcValidRect.top), new Point((double) calcValidRect.right, (double) calcValidRect.top), new Point((double) calcValidRect.right, (double) calcValidRect.bottom), new Point((double) calcValidRect.left, (double) calcValidRect.bottom)};
        DebugConfig.logd(str, "input valid box " + StringUtil.toString(pointArr));
        Point[] input2OutputCoordinates = input2OutputCoordinates(pointArr, this.modelWrapper.getInputImageSize(0), size);
        DebugConfig.logd(str, "output valid box" + StringUtil.toString(input2OutputCoordinates));
        List<List<Point>> run = new DetectionPostprocessor().run(this.ocrManager, c10, Arrays.asList(input2OutputCoordinates));
        SimpleTrace.getTrace().addEvent("postprocessor");
        OCRManager.DetectorOutput detectorOutput = new OCRManager.DetectorOutput();
        detectorOutput.degree = Transform.TransformRotate.reverseDegree(transformGroup.calcRotation());
        detectorOutput.boundingBoxes = output2InputCoordinates(run, this.modelWrapper.getInputImageSize(0), size, transformGroup);
        SimpleTrace.getTrace().addEvent("output2InputCoordinates");
        return detectorOutput;
    }

    public TfliteModelWrapper.ModelIn<Transform.TransformGroup> preprocess(OCRManager.DetectorInput detectorInput) {
        boolean z10;
        SimpleTrace trace = SimpleTrace.getTrace();
        String str = TAG;
        trace.startSection("preprocesse", str);
        if (this.ocrManager.getOCRParams().detectDirection) {
            z10 = DirectionDetector.isHorizontal(detectorInput.inputMat);
        } else {
            z10 = true;
        }
        SimpleTrace.getTrace().addEvent("isHorizontal");
        Transform.TransformGroup transformGroup = new Transform.TransformGroup();
        Transform.PaddingOption paddingOption = this.ocrManager.getOCRParams().detectorPaddingOptoin;
        if (!z10 && paddingOption == Transform.PaddingOption.PadBottomRight) {
            paddingOption = Transform.PaddingOption.PadBottomLeft;
        }
        Mat mat = new Mat();
        OpenCVUtil.resizeAndPad(detectorInput.inputMat, mat, this.modelWrapper.getInputImageSize(0), paddingOption, transformGroup);
        SimpleTrace.getTrace().addEvent("resizeAndPad");
        if (!z10) {
            mat = rotateMat(mat, transformGroup);
        }
        Mat normalize = normalize(mat);
        OpenCVUtil.logAndSave(str, "det_pre_normalized", normalize);
        SimpleTrace.getTrace().addEvent("normalize");
        ByteBuffer directBuffer = OpenCVUtil.toDirectBuffer(normalize);
        normalize.release();
        BufferUtil.logBuffer(str, "det_model_input", directBuffer);
        SimpleTrace.getTrace().endSection("preprocesse");
        return new TfliteModelWrapper.ModelIn<>(directBuffer, 1, transformGroup);
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public OCRManager.DetectorOutput run(OCRManager.DetectorInput detectorInput) {
        OCRManager.DetectorOutput detectorOutput = (OCRManager.DetectorOutput) ((List) this.modelWrapper.run(Arrays.asList(detectorInput))).get(0);
        DebugConfig.logd(TAG, "detection_result:" + StringUtil.toString(detectorOutput.boundingBoxes));
        return detectorOutput;
    }
}
