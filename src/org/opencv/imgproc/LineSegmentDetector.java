package org.opencv.imgproc;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.Size;

/* loaded from: classes4.dex */
public class LineSegmentDetector extends Algorithm {
    public LineSegmentDetector(long j10) {
        super(j10);
    }

    public static LineSegmentDetector __fromPtr__(long j10) {
        return new LineSegmentDetector(j10);
    }

    private static native int compareSegments_0(long j10, double d10, double d11, long j11, long j12, long j13);

    private static native int compareSegments_1(long j10, double d10, double d11, long j11, long j12);

    private static native void delete(long j10);

    private static native void detect_0(long j10, long j11, long j12, long j13, long j14, long j15);

    private static native void detect_1(long j10, long j11, long j12, long j13, long j14);

    private static native void detect_2(long j10, long j11, long j12, long j13);

    private static native void detect_3(long j10, long j11, long j12);

    private static native void drawSegments_0(long j10, long j11, long j12);

    public int compareSegments(Size size, Mat mat, Mat mat2, Mat mat3) {
        return compareSegments_0(this.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        detect_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    public void drawSegments(Mat mat, Mat mat2) {
        drawSegments_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int compareSegments(Size size, Mat mat, Mat mat2) {
        return compareSegments_1(this.nativeObj, size.width, size.height, mat.nativeObj, mat2.nativeObj);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        detect_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3) {
        detect_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void detect(Mat mat, Mat mat2) {
        detect_3(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }
}
