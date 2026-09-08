package org.opencv.photo;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* loaded from: classes4.dex */
public class MergeMertens extends MergeExposures {
    public MergeMertens(long j10) {
        super(j10);
    }

    public static MergeMertens __fromPtr__(long j10) {
        return new MergeMertens(j10);
    }

    private static native void delete(long j10);

    private static native float getContrastWeight_0(long j10);

    private static native float getExposureWeight_0(long j10);

    private static native float getSaturationWeight_0(long j10);

    private static native void process_0(long j10, long j11, long j12, long j13, long j14);

    private static native void process_1(long j10, long j11, long j12);

    private static native void setContrastWeight_0(long j10, float f10);

    private static native void setExposureWeight_0(long j10, float f10);

    private static native void setSaturationWeight_0(long j10, float f10);

    @Override // org.opencv.photo.MergeExposures, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getContrastWeight() {
        return getContrastWeight_0(this.nativeObj);
    }

    public float getExposureWeight() {
        return getExposureWeight_0(this.nativeObj);
    }

    public float getSaturationWeight() {
        return getSaturationWeight_0(this.nativeObj);
    }

    @Override // org.opencv.photo.MergeExposures
    public void process(List<Mat> list, Mat mat, Mat mat2, Mat mat3) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void setContrastWeight(float f10) {
        setContrastWeight_0(this.nativeObj, f10);
    }

    public void setExposureWeight(float f10) {
        setExposureWeight_0(this.nativeObj, f10);
    }

    public void setSaturationWeight(float f10) {
        setSaturationWeight_0(this.nativeObj, f10);
    }

    public void process(List<Mat> list, Mat mat) {
        process_1(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }
}
