package org.opencv.photo;

import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* loaded from: classes4.dex */
public class CalibrateCRF extends Algorithm {
    public CalibrateCRF(long j10) {
        super(j10);
    }

    public static CalibrateCRF __fromPtr__(long j10) {
        return new CalibrateCRF(j10);
    }

    private static native void delete(long j10);

    private static native void process_0(long j10, long j11, long j12, long j13);

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public void process(List<Mat> list, Mat mat, Mat mat2) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
