package org.opencv.imgproc;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.core.Size;

/* loaded from: classes4.dex */
public class CLAHE extends Algorithm {
    public CLAHE(long j10) {
        super(j10);
    }

    public static CLAHE __fromPtr__(long j10) {
        return new CLAHE(j10);
    }

    private static native void apply_0(long j10, long j11, long j12);

    private static native void collectGarbage_0(long j10);

    private static native void delete(long j10);

    private static native double getClipLimit_0(long j10);

    private static native double[] getTilesGridSize_0(long j10);

    private static native void setClipLimit_0(long j10, double d10);

    private static native void setTilesGridSize_0(long j10, double d10, double d11);

    public void apply(Mat mat, Mat mat2) {
        apply_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void collectGarbage() {
        collectGarbage_0(this.nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public double getClipLimit() {
        return getClipLimit_0(this.nativeObj);
    }

    public Size getTilesGridSize() {
        return new Size(getTilesGridSize_0(this.nativeObj));
    }

    public void setClipLimit(double d10) {
        setClipLimit_0(this.nativeObj, d10);
    }

    public void setTilesGridSize(Size size) {
        setTilesGridSize_0(this.nativeObj, size.width, size.height);
    }
}
