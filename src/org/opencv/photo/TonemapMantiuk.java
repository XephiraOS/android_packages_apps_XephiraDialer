package org.opencv.photo;

/* loaded from: classes4.dex */
public class TonemapMantiuk extends Tonemap {
    public TonemapMantiuk(long j10) {
        super(j10);
    }

    public static TonemapMantiuk __fromPtr__(long j10) {
        return new TonemapMantiuk(j10);
    }

    private static native void delete(long j10);

    private static native float getSaturation_0(long j10);

    private static native float getScale_0(long j10);

    private static native void setSaturation_0(long j10, float f10);

    private static native void setScale_0(long j10, float f10);

    @Override // org.opencv.photo.Tonemap, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getSaturation() {
        return getSaturation_0(this.nativeObj);
    }

    public float getScale() {
        return getScale_0(this.nativeObj);
    }

    public void setSaturation(float f10) {
        setSaturation_0(this.nativeObj, f10);
    }

    public void setScale(float f10) {
        setScale_0(this.nativeObj, f10);
    }
}
