package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfPoint2f extends Mat {
    private static final int _channels = 2;
    private static final int _depth = 5;

    public MatOfPoint2f() {
    }

    public static MatOfPoint2f fromNativeAddr(long j10) {
        return new MatOfPoint2f(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(5, 2));
        }
    }

    public void fromArray(Point... pointArr) {
        if (pointArr != null && pointArr.length != 0) {
            int length = pointArr.length;
            alloc(length);
            float[] fArr = new float[length * 2];
            for (int i10 = 0; i10 < length; i10++) {
                Point point = pointArr[i10];
                int i11 = i10 * 2;
                fArr[i11] = (float) point.f35882x;
                fArr[i11 + 1] = (float) point.f35883y;
            }
            put(0, 0, fArr);
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
        get(0, 0, new float[i10 * 2]);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i11 * 2;
            pointArr[i11] = new Point(r2[i12], r2[i12 + 1]);
        }
        return pointArr;
    }

    public List<Point> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint2f(long j10) {
        super(j10);
        if (!empty() && checkVector(2, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint2f(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(2, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint2f(Point... pointArr) {
        fromArray(pointArr);
    }
}
