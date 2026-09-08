package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfDMatch extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 5;

    public MatOfDMatch() {
    }

    public static MatOfDMatch fromNativeAddr(long j10) {
        return new MatOfDMatch(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(5, 4));
        }
    }

    public void fromArray(DMatch... dMatchArr) {
        if (dMatchArr != null && dMatchArr.length != 0) {
            int length = dMatchArr.length;
            alloc(length);
            float[] fArr = new float[length * 4];
            for (int i10 = 0; i10 < length; i10++) {
                DMatch dMatch = dMatchArr[i10];
                int i11 = i10 * 4;
                fArr[i11] = dMatch.queryIdx;
                fArr[i11 + 1] = dMatch.trainIdx;
                fArr[i11 + 2] = dMatch.imgIdx;
                fArr[i11 + 3] = dMatch.distance;
            }
            put(0, 0, fArr);
        }
    }

    public void fromList(List<DMatch> list) {
        fromArray((DMatch[]) list.toArray(new DMatch[0]));
    }

    public DMatch[] toArray() {
        int i10 = (int) total();
        DMatch[] dMatchArr = new DMatch[i10];
        if (i10 == 0) {
            return dMatchArr;
        }
        float[] fArr = new float[i10 * 4];
        get(0, 0, fArr);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i11 * 4;
            dMatchArr[i11] = new DMatch((int) fArr[i12], (int) fArr[i12 + 1], (int) fArr[i12 + 2], fArr[i12 + 3]);
        }
        return dMatchArr;
    }

    public List<DMatch> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfDMatch(long j10) {
        super(j10);
        if (empty() || checkVector(4, 5) >= 0) {
            return;
        }
        throw new IllegalArgumentException("Incompatible Mat: " + toString());
    }

    public MatOfDMatch(Mat mat) {
        super(mat, Range.all());
        if (empty() || checkVector(4, 5) >= 0) {
            return;
        }
        throw new IllegalArgumentException("Incompatible Mat: " + toString());
    }

    public MatOfDMatch(DMatch... dMatchArr) {
        fromArray(dMatchArr);
    }
}
