package org.opencv.photo;

/* loaded from: classes4.dex */
public class TonemapReinhard extends Tonemap {
    public TonemapReinhard(long j10) {
        super(j10);
    }

    public static TonemapReinhard __fromPtr__(long j10) {
        return new TonemapReinhard(j10);
    }

    private static native void delete(long j10);

    private static native float getColorAdaptation_0(long j10);

    private static native float getIntensity_0(long j10);

    private static native float getLightAdaptation_0(long j10);

    private static native void setColorAdaptation_0(long j10, float f10);

    private static native void setIntensity_0(long j10, float f10);

    private static native void setLightAdaptation_0(long j10, float f10);

    @Override // org.opencv.photo.Tonemap, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getColorAdaptation() {
        return getColorAdaptation_0(this.nativeObj);
    }

    public float getIntensity() {
        return getIntensity_0(this.nativeObj);
    }

    public float getLightAdaptation() {
        return getLightAdaptation_0(this.nativeObj);
    }

    public void setColorAdaptation(float f10) {
        setColorAdaptation_0(this.nativeObj, f10);
    }

    public void setIntensity(float f10) {
        setIntensity_0(this.nativeObj, f10);
    }

    public void setLightAdaptation(float f10) {
        setLightAdaptation_0(this.nativeObj, f10);
    }
}
