package org.opencv.photo;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* loaded from: classes4.dex */
public class MergeRobertson extends MergeExposures {
    public MergeRobertson(long j10) {
        super(j10);
    }

    public static MergeRobertson __fromPtr__(long j10) {
        return new MergeRobertson(j10);
    }

    private static native void delete(long j10);

    private static native void process_0(long j10, long j11, long j12, long j13, long j14);

    private static native void process_1(long j10, long j11, long j12, long j13);

    @Override // org.opencv.photo.MergeExposures, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    @Override // org.opencv.photo.MergeExposures
    public void process(List<Mat> list, Mat mat, Mat mat2, Mat mat3) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void process(List<Mat> list, Mat mat, Mat mat2) {
        process_1(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
