package com.oua.ocr.core;

import com.oua.ocr.core.OCRManager;
import com.oua.util.DebugConfig;
import com.oua.util.StringUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public class DetectorImplAR extends DetectorImpl {
    long nativeHandle;

    public DetectorImplAR(OCRManager.Config config) {
        super(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Point lambda$toOutput$0(IntBuffer intBuffer, int i10) {
        return new Point(intBuffer.get(), intBuffer.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$toOutput$1(final IntBuffer intBuffer, int i10) {
        return (List) IntStream.range(0, 4).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.r
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                Point lambda$toOutput$0;
                lambda$toOutput$0 = DetectorImplAR.lambda$toOutput$0(intBuffer, i11);
                return lambda$toOutput$0;
            }
        }).collect(Collectors.toList());
    }

    private OCRManager.DetectorOutput toOutput(ByteBuffer byteBuffer) {
        final IntBuffer asIntBuffer = byteBuffer.asIntBuffer();
        List<List<Point>> list = (List) IntStream.range(0, asIntBuffer.get()).mapToObj(new IntFunction() { // from class: com.oua.ocr.core.q
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                List lambda$toOutput$1;
                lambda$toOutput$1 = DetectorImplAR.lambda$toOutput$1(asIntBuffer, i10);
                return lambda$toOutput$1;
            }
        }).collect(Collectors.toList());
        OCRManager.DetectorOutput detectorOutput = new OCRManager.DetectorOutput();
        detectorOutput.degree = 0;
        detectorOutput.boundingBoxes = list;
        return detectorOutput;
    }

    @Override // com.oua.ocr.core.DetectorImpl, com.oua.ocr.core.OCRManager.Engine
    public void initImpl() {
        this.nativeHandle = OCRNative.detectorinit();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.oua.ocr.core.DetectorImpl, com.oua.ocr.core.OCRManager.Engine
    public OCRManager.DetectorOutput run(OCRManager.DetectorInput detectorInput) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(3200);
        allocateDirect.order(ByteOrder.nativeOrder());
        OCRNative.detectorrun(this.nativeHandle, detectorInput.inputMat.getNativeObjAddr(), allocateDirect);
        OCRManager.DetectorOutput output = toOutput(allocateDirect);
        DebugConfig.logd(DetectorImpl.TAG, "detection_result:" + StringUtil.toString(output.boundingBoxes));
        return output;
    }
}
