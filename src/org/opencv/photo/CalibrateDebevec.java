package org.opencv.photo;

/* loaded from: classes4.dex */
public class CalibrateDebevec extends CalibrateCRF {
    public CalibrateDebevec(long j10) {
        super(j10);
    }

    public static CalibrateDebevec __fromPtr__(long j10) {
        return new CalibrateDebevec(j10);
    }

    private static native void delete(long j10);

    private static native float getLambda_0(long j10);

    private static native boolean getRandom_0(long j10);

    private static native int getSamples_0(long j10);

    private static native void setLambda_0(long j10, float f10);

    private static native void setRandom_0(long j10, boolean z10);

    private static native void setSamples_0(long j10, int i10);

    @Override // org.opencv.photo.CalibrateCRF, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getLambda() {
        return getLambda_0(this.nativeObj);
    }

    public boolean getRandom() {
        return getRandom_0(this.nativeObj);
    }

    public int getSamples() {
        return getSamples_0(this.nativeObj);
    }

    public void setLambda(float f10) {
        setLambda_0(this.nativeObj, f10);
    }

    public void setRandom(boolean z10) {
        setRandom_0(this.nativeObj, z10);
    }

    public void setSamples(int i10) {
        setSamples_0(this.nativeObj, i10);
    }
}
