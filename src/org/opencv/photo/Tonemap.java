package org.opencv.photo;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

/* loaded from: classes4.dex */
public class Tonemap extends Algorithm {
    public Tonemap(long j10) {
        super(j10);
    }

    public static Tonemap __fromPtr__(long j10) {
        return new Tonemap(j10);
    }

    private static native void delete(long j10);

    private static native float getGamma_0(long j10);

    private static native void process_0(long j10, long j11, long j12);

    private static native void setGamma_0(long j10, float f10);

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getGamma() {
        return getGamma_0(this.nativeObj);
    }

    public void process(Mat mat, Mat mat2) {
        process_0(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void setGamma(float f10) {
        setGamma_0(this.nativeObj, f10);
    }
}
