package org.opencv.imgproc;

/* loaded from: classes4.dex */
public class GeneralizedHoughGuil extends GeneralizedHough {
    public GeneralizedHoughGuil(long j10) {
        super(j10);
    }

    public static GeneralizedHoughGuil __fromPtr__(long j10) {
        return new GeneralizedHoughGuil(j10);
    }

    private static native void delete(long j10);

    private static native double getAngleEpsilon_0(long j10);

    private static native double getAngleStep_0(long j10);

    private static native int getAngleThresh_0(long j10);

    private static native int getLevels_0(long j10);

    private static native double getMaxAngle_0(long j10);

    private static native double getMaxScale_0(long j10);

    private static native double getMinAngle_0(long j10);

    private static native double getMinScale_0(long j10);

    private static native int getPosThresh_0(long j10);

    private static native double getScaleStep_0(long j10);

    private static native int getScaleThresh_0(long j10);

    private static native double getXi_0(long j10);

    private static native void setAngleEpsilon_0(long j10, double d10);

    private static native void setAngleStep_0(long j10, double d10);

    private static native void setAngleThresh_0(long j10, int i10);

    private static native void setLevels_0(long j10, int i10);

    private static native void setMaxAngle_0(long j10, double d10);

    private static native void setMaxScale_0(long j10, double d10);

    private static native void setMinAngle_0(long j10, double d10);

    private static native void setMinScale_0(long j10, double d10);

    private static native void setPosThresh_0(long j10, int i10);

    private static native void setScaleStep_0(long j10, double d10);

    private static native void setScaleThresh_0(long j10, int i10);

    private static native void setXi_0(long j10, double d10);

    @Override // org.opencv.imgproc.GeneralizedHough, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public double getAngleEpsilon() {
        return getAngleEpsilon_0(this.nativeObj);
    }

    public double getAngleStep() {
        return getAngleStep_0(this.nativeObj);
    }

    public int getAngleThresh() {
        return getAngleThresh_0(this.nativeObj);
    }

    public int getLevels() {
        return getLevels_0(this.nativeObj);
    }

    public double getMaxAngle() {
        return getMaxAngle_0(this.nativeObj);
    }

    public double getMaxScale() {
        return getMaxScale_0(this.nativeObj);
    }

    public double getMinAngle() {
        return getMinAngle_0(this.nativeObj);
    }

    public double getMinScale() {
        return getMinScale_0(this.nativeObj);
    }

    public int getPosThresh() {
        return getPosThresh_0(this.nativeObj);
    }

    public double getScaleStep() {
        return getScaleStep_0(this.nativeObj);
    }

    public int getScaleThresh() {
        return getScaleThresh_0(this.nativeObj);
    }

    public double getXi() {
        return getXi_0(this.nativeObj);
    }

    public void setAngleEpsilon(double d10) {
        setAngleEpsilon_0(this.nativeObj, d10);
    }

    public void setAngleStep(double d10) {
        setAngleStep_0(this.nativeObj, d10);
    }

    public void setAngleThresh(int i10) {
        setAngleThresh_0(this.nativeObj, i10);
    }

    public void setLevels(int i10) {
        setLevels_0(this.nativeObj, i10);
    }

    public void setMaxAngle(double d10) {
        setMaxAngle_0(this.nativeObj, d10);
    }

    public void setMaxScale(double d10) {
        setMaxScale_0(this.nativeObj, d10);
    }

    public void setMinAngle(double d10) {
        setMinAngle_0(this.nativeObj, d10);
    }

    public void setMinScale(double d10) {
        setMinScale_0(this.nativeObj, d10);
    }

    public void setPosThresh(int i10) {
        setPosThresh_0(this.nativeObj, i10);
    }

    public void setScaleStep(double d10) {
        setScaleStep_0(this.nativeObj, d10);
    }

    public void setScaleThresh(int i10) {
        setScaleThresh_0(this.nativeObj, i10);
    }

    public void setXi(double d10) {
        setXi_0(this.nativeObj, d10);
    }
}
