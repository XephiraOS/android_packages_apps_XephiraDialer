package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfPoint extends Mat {
    private static final int _channels = 2;
    private static final int _depth = 4;

    public MatOfPoint() {
    }

    public static MatOfPoint fromNativeAddr(long j10) {
        return new MatOfPoint(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(4, 2));
        }
    }

    public void fromArray(Point... pointArr) {
        if (pointArr != null && pointArr.length != 0) {
            int length = pointArr.length;
            alloc(length);
            int[] iArr = new int[length * 2];
            for (int i10 = 0; i10 < length; i10++) {
                Point point = pointArr[i10];
                int i11 = i10 * 2;
                iArr[i11] = (int) point.f35882x;
                iArr[i11 + 1] = (int) point.f35883y;
            }
            put(0, 0, iArr);
        }
    }

    public void fromList(List<Point> list) {
        fromArray((Point[]) list.toArray(new Point[0]));
    }

    public Point[] toArray() {
        int i10 = (int) total();
        Point[] pointArr = new Point[i10];
        if (i10 == 0) {
            return pointArr;
        }
        get(0, 0, new int[i10 * 2]);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i11 * 2;
            pointArr[i11] = new Point(r2[i12], r2[i12 + 1]);
        }
        return pointArr;
    }

    public List<Point> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint(long j10) {
        super(j10);
        if (!empty() && checkVector(2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint(Point... pointArr) {
        fromArray(pointArr);
    }
}
