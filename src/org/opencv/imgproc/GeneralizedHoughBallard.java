package org.opencv.imgproc;

/* loaded from: classes4.dex */
public class GeneralizedHoughBallard extends GeneralizedHough {
    public GeneralizedHoughBallard(long j10) {
        super(j10);
    }

    public static GeneralizedHoughBallard __fromPtr__(long j10) {
        return new GeneralizedHoughBallard(j10);
    }

    private static native void delete(long j10);

    private static native int getLevels_0(long j10);

    private static native int getVotesThreshold_0(long j10);

    private static native void setLevels_0(long j10, int i10);

    private static native void setVotesThreshold_0(long j10, int i10);

    @Override // org.opencv.imgproc.GeneralizedHough, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getLevels() {
        return getLevels_0(this.nativeObj);
    }

    public int getVotesThreshold() {
        return getVotesThreshold_0(this.nativeObj);
    }

    public void setLevels(int i10) {
        setLevels_0(this.nativeObj, i10);
    }

    public void setVotesThreshold(int i10) {
        setVotesThreshold_0(this.nativeObj, i10);
    }
}
