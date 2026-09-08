package org.opencv.photo;

import java.util.List;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* loaded from: classes4.dex */
public class AlignExposures extends Algorithm {
    public AlignExposures(long j10) {
        super(j10);
    }

    public static AlignExposures __fromPtr__(long j10) {
        return new AlignExposures(j10);
    }

    private static native void delete(long j10);

    private static native void process_0(long j10, long j11, long j12, long j13, long j14);

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public void process(List<Mat> list, List<Mat> list2, Mat mat, Mat mat2) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
