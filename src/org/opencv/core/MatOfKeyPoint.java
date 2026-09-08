package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfKeyPoint extends Mat {
    private static final int _channels = 7;
    private static final int _depth = 5;

    public MatOfKeyPoint() {
    }

    public static MatOfKeyPoint fromNativeAddr(long j10) {
        return new MatOfKeyPoint(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(5, 7));
        }
    }

    public void fromArray(KeyPoint... keyPointArr) {
        if (keyPointArr != null && keyPointArr.length != 0) {
            int length = keyPointArr.length;
            alloc(length);
            float[] fArr = new float[length * 7];
            for (int i10 = 0; i10 < length; i10++) {
                KeyPoint keyPoint = keyPointArr[i10];
                int i11 = i10 * 7;
                Point point = keyPoint.pt;
                fArr[i11] = (float) point.f35882x;
                fArr[i11 + 1] = (float) point.f35883y;
                fArr[i11 + 2] = keyPoint.size;
                fArr[i11 + 3] = keyPoint.angle;
                fArr[i11 + 4] = keyPoint.response;
                fArr[i11 + 5] = keyPoint.octave;
                fArr[i11 + 6] = keyPoint.class_id;
            }
            put(0, 0, fArr);
        }
    }

    public void fromList(List<KeyPoint> list) {
        fromArray((KeyPoint[]) list.toArray(new KeyPoint[0]));
    }

    public KeyPoint[] toArray() {
        int i10 = (int) total();
        KeyPoint[] keyPointArr = new KeyPoint[i10];
        if (i10 == 0) {
            return keyPointArr;
        }
        float[] fArr = new float[i10 * 7];
        get(0, 0, fArr);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i11 * 7;
            keyPointArr[i11] = new KeyPoint(fArr[i12], fArr[i12 + 1], fArr[i12 + 2], fArr[i12 + 3], fArr[i12 + 4], (int) fArr[i12 + 5], (int) fArr[i12 + 6]);
        }
        return keyPointArr;
    }

    public List<KeyPoint> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfKeyPoint(long j10) {
        super(j10);
        if (!empty() && checkVector(7, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfKeyPoint(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(7, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfKeyPoint(KeyPoint... keyPointArr) {
        fromArray(keyPointArr);
    }
}
