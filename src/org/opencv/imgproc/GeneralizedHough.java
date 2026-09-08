package org.opencv.imgproc;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public class GeneralizedHough extends Algorithm {
    public GeneralizedHough(long j10) {
        super(j10);
    }

    public static GeneralizedHough __fromPtr__(long j10) {
        return new GeneralizedHough(j10);
    }

    private static native void delete(long j10);

    private static native void detect_0(long j10, long j11, long j12, long j13, long j14, long j15);

    private static native void detect_1(long j10, long j11, long j12, long j13, long j14);

    private static native void detect_2(long j10, long j11, long j12, long j13);

    private static native void detect_3(long j10, long j11, long j12);

    private static native int getCannyHighThresh_0(long j10);

    private static native int getCannyLowThresh_0(long j10);

    private static native double getDp_0(long j10);

    private static native int getMaxBufferSize_0(long j10);

    private static native double getMinDist_0(long j10);

    private static native void setCannyHighThresh_0(long j10, int i10);

    private static native void setCannyLowThresh_0(long j10, int i10);

    private static native void setDp_0(long j10, double d10);

    private static native void setMaxBufferSize_0(long j10, int i10);

    private static native void setMinDist_0(long j10, double d10);

    private static native void setTemplate_0(long j10, long j11, long j12, long j13, double d10, double d11);

    private static native void setTemplate_1(long j10, long j11, long j12, long j13);

    private static native void setTemplate_2(long j10, long j11, double d10, double d11);

    private static native void setTemplate_3(long j10, long j11);

    public void detect(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        detect_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getCannyHighThresh() {
        return getCannyHighThresh_0(this.nativeObj);
    }

    public int getCannyLowThresh() {
        return getCannyLowThresh_0(this.nativeObj);
    }

    public double getDp() {
        return getDp_0(this.nativeObj);
    }

    public int getMaxBufferSize() {
        return getMaxBufferSize_0(this.nativeObj);
    }

    public double getMinDist() {
        return getMinDist_0(this.nativeObj);
    }

    public void setCannyHighThresh(int i10) {
        setCannyHighThresh_0(this.nativeObj, i10);
    }

    public void setCannyLowThresh(int i10) {
        setCannyLowThresh_0(this.nativeObj, i10);
    }

    public void setDp(double d10) {
        setDp_0(this.nativeObj, d10);
    }

    public void setMaxBufferSize(int i10) {
        setMaxBufferSize_0(this.nativeObj, i10);
    }

    public void setMinDist(double d10) {
        setMinDist_0(this.nativeObj, d10);
    }

    public void setTemplate(Mat mat, Mat mat2, Mat mat3, Point point) {
        setTemplate_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, point.f35882x, point.f35883y);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        detect_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public void setTemplate(Mat mat, Mat mat2, Mat mat3) {
        setTemplate_1(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void detect(Mat mat, Mat mat2, Mat mat3) {
        detect_2(this.nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void setTemplate(Mat mat, Point point) {
        setTemplate_2(this.nativeObj, mat.nativeObj, point.f35882x, point.f35883y);
    }

    public void detect(Mat mat, Mat mat2) {
        detect_3(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void setTemplate(Mat mat) {
        setTemplate_3(this.nativeObj, mat.nativeObj);
    }
}
