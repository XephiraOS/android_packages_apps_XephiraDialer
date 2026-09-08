package org.opencv.photo;

/* loaded from: classes4.dex */
public class TonemapDrago extends Tonemap {
    public TonemapDrago(long j10) {
        super(j10);
    }

    public static TonemapDrago __fromPtr__(long j10) {
        return new TonemapDrago(j10);
    }

    private static native void delete(long j10);

    private static native float getBias_0(long j10);

    private static native float getSaturation_0(long j10);

    private static native void setBias_0(long j10, float f10);

    private static native void setSaturation_0(long j10, float f10);

    @Override // org.opencv.photo.Tonemap, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getBias() {
        return getBias_0(this.nativeObj);
    }

    public float getSaturation() {
        return getSaturation_0(this.nativeObj);
    }

    public void setBias(float f10) {
        setBias_0(this.nativeObj, f10);
    }

    public void setSaturation(float f10) {
        setSaturation_0(this.nativeObj, f10);
    }
}
