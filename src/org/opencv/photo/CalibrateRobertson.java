package org.opencv.photo;

import org.opencv.core.Mat;

/* loaded from: classes4.dex */
public class CalibrateRobertson extends CalibrateCRF {
    public CalibrateRobertson(long j10) {
        super(j10);
    }

    public static CalibrateRobertson __fromPtr__(long j10) {
        return new CalibrateRobertson(j10);
    }

    private static native void delete(long j10);

    private static native int getMaxIter_0(long j10);

    private static native long getRadiance_0(long j10);

    private static native float getThreshold_0(long j10);

    private static native void setMaxIter_0(long j10, int i10);

    private static native void setThreshold_0(long j10, float f10);

    @Override // org.opencv.photo.CalibrateCRF, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getMaxIter() {
        return getMaxIter_0(this.nativeObj);
    }

    public Mat getRadiance() {
        return new Mat(getRadiance_0(this.nativeObj));
    }

    public float getThreshold() {
        return getThreshold_0(this.nativeObj);
    }

    public void setMaxIter(int i10) {
        setMaxIter_0(this.nativeObj, i10);
    }

    public void setThreshold(float f10) {
        setThreshold_0(this.nativeObj, f10);
    }
}
