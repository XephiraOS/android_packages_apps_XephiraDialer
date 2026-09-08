package com.oua.ocr.core;

import android.util.Size;
import com.oua.ocr.core.OCRManager;
import com.oua.opencv.BBoxUtil;
import com.oua.opencv.OpenCVUtil;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.Transform;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;

/* loaded from: classes4.dex */
public class DetectorImplCV extends OCRManager.Detector {
    protected static final String TAG = "com.oua.ocr.core.DetectorImplCV";

    public DetectorImplCV(OCRManager.Config config) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$run$0(Transform.TransformGroup transformGroup, List list) {
        return BBoxUtil.reverseTransform(list, transformGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$run$1(Transform.TransformGroup transformGroup, List list) {
        List<Point> reverseTransform = BBoxUtil.reverseTransform(list, transformGroup);
        list.clear();
        list.addAll(reverseTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$run$2(final Transform.TransformGroup transformGroup, List list) {
        list.forEach(new Consumer() { // from class: com.oua.ocr.core.s
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DetectorImplCV.lambda$run$1(Transform.TransformGroup.this, (List) obj);
            }
        });
    }

    private static Mat rotateMat(Mat mat, Transform.TransformGroup transformGroup) {
        Transform.TransformRotate transformRotate = new Transform.TransformRotate(new Size(mat.width(), mat.height()), -90);
        Core.rotate(mat, mat, 2);
        SimpleTrace.getTrace().addEvent("rotate-90");
        transformGroup.transforms.add(transformRotate);
        return mat;
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public OCRManager.DetectorOutput run(OCRManager.DetectorInput detectorInput) {
        boolean isHorizontal = this.ocrManager.getOCRParams().detectDirection ? DirectionDetector.isHorizontal(detectorInput.inputMat) : true;
        final Transform.TransformGroup transformGroup = new Transform.TransformGroup();
        Mat mat = new Mat();
        Imgproc.cvtColor(detectorInput.inputMat, mat, 10);
        double min = Math.min(mat.width(), mat.height());
        int i10 = this.ocrManager.getOCRParams().detectShortEdge;
        if (i10 > 0) {
            double d10 = i10 / min;
            OpenCVUtil.resizeAndPad(mat, mat, new Size((int) (mat.width() * d10), (int) (mat.height() * d10)), Transform.PaddingOption.NoPadding, transformGroup);
        }
        if (!isHorizontal) {
            mat = rotateMat(mat, transformGroup);
        }
        String str = TAG;
        OpenCVUtil.logAndSave(str, "detect_gray", mat);
        OCRManager.DetectorOutput detect = OCRNative.detect(mat);
        mat.release();
        detect.degree = Transform.TransformRotate.reverseDegree(transformGroup.calcRotation());
        DebugConfig.logv(str, "transformGroup.calcRotation() " + transformGroup.calcRotation());
        detect.boundingBoxes = (List) detect.boundingBoxes.stream().map(new Function() { // from class: com.oua.ocr.core.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                List lambda$run$0;
                lambda$run$0 = DetectorImplCV.lambda$run$0(Transform.TransformGroup.this, (List) obj);
                return lambda$run$0;
            }
        }).collect(Collectors.toList());
        detect.segmentBoxes.forEach(new Consumer() { // from class: com.oua.ocr.core.u
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DetectorImplCV.lambda$run$2(Transform.TransformGroup.this, (List) obj);
            }
        });
        return detect;
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public void closeImpl() {
    }

    @Override // com.oua.ocr.core.OCRManager.Engine
    public void initImpl() {
    }
}
