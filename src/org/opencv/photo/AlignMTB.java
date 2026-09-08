package org.opencv.photo;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.utils.Converters;

/* loaded from: classes4.dex */
public class AlignMTB extends AlignExposures {
    public AlignMTB(long j10) {
        super(j10);
    }

    public static AlignMTB __fromPtr__(long j10) {
        return new AlignMTB(j10);
    }

    private static native double[] calculateShift_0(long j10, long j11, long j12);

    private static native void computeBitmaps_0(long j10, long j11, long j12, long j13);

    private static native void delete(long j10);

    private static native boolean getCut_0(long j10);

    private static native int getExcludeRange_0(long j10);

    private static native int getMaxBits_0(long j10);

    private static native void process_0(long j10, long j11, long j12, long j13, long j14);

    private static native void process_1(long j10, long j11, long j12);

    private static native void setCut_0(long j10, boolean z10);

    private static native void setExcludeRange_0(long j10, int i10);

    private static native void setMaxBits_0(long j10, int i10);

    private static native void shiftMat_0(long j10, long j11, long j12, double d10, double d11);

    public Point calculateShift(Mat mat, Mat mat2) {
        return new Point(calculateShift_0(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }

    public void computeBitmaps(Mat mat, Mat mat2, Mat mat3) {
        computeBitmaps_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    @Override // org.opencv.photo.AlignExposures, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public boolean getCut() {
        return getCut_0(this.nativeObj);
    }

    public int getExcludeRange() {
        return getExcludeRange_0(this.nativeObj);
    }

    public int getMaxBits() {
        return getMaxBits_0(this.nativeObj);
    }

    @Override // org.opencv.photo.AlignExposures
    public void process(List<Mat> list, List<Mat> list2, Mat mat, Mat mat2) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void setCut(boolean z10) {
        setCut_0(this.nativeObj, z10);
    }

    public void setExcludeRange(int i10) {
        setExcludeRange_0(this.nativeObj, i10);
    }

    public void setMaxBits(int i10) {
        setMaxBits_0(this.nativeObj, i10);
    }

    public void shiftMat(Mat mat, Mat mat2, Point point) {
        shiftMat_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, point.f35882x, point.f35883y);
    }

    public void process(List<Mat> list, List<Mat> list2) {
        process_1(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, Converters.vector_Mat_to_Mat(list2).nativeObj);
    }
}
