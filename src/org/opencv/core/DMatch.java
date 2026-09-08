package org.opencv.core;

/* loaded from: classes4.dex */
public class DMatch {
    public float distance;
    public int imgIdx;
    public int queryIdx;
    public int trainIdx;

    public DMatch() {
        this(-1, -1, Float.MAX_VALUE);
    }

    public boolean lessThan(DMatch dMatch) {
        if (this.distance < dMatch.distance) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "DMatch [queryIdx=" + this.queryIdx + ", trainIdx=" + this.trainIdx + ", imgIdx=" + this.imgIdx + ", distance=" + this.distance + "]";
    }

    public DMatch(int i10, int i11, float f10) {
        this.queryIdx = i10;
        this.trainIdx = i11;
        this.imgIdx = -1;
        this.distance = f10;
    }

    public DMatch(int i10, int i11, int i12, float f10) {
        this.queryIdx = i10;
        this.trainIdx = i11;
        this.imgIdx = i12;
        this.distance = f10;
    }
}
