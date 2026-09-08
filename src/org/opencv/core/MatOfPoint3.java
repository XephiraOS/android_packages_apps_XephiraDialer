package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfPoint3 extends Mat {
    private static final int _channels = 3;
    private static final int _depth = 4;

    public MatOfPoint3() {
    }

    public static MatOfPoint3 fromNativeAddr(long j10) {
        return new MatOfPoint3(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(4, 3));
        }
    }

    public void fromArray(Point3... point3Arr) {
        if (point3Arr != null && point3Arr.length != 0) {
            int length = point3Arr.length;
            alloc(length);
            int[] iArr = new int[length * 3];
            for (int i10 = 0; i10 < length; i10++) {
                Point3 point3 = point3Arr[i10];
                int i11 = i10 * 3;
                iArr[i11] = (int) point3.f35884x;
                iArr[i11 + 1] = (int) point3.f35885y;
                iArr[i11 + 2] = (int) point3.f35886z;
            }
            put(0, 0, iArr);
        }
    }

    public void fromList(List<Point3> list) {
        fromArray((Point3[]) list.toArray(new Point3[0]));
    }

    public Point3[] toArray() {
        int i10 = (int) total();
        Point3[] point3Arr = new Point3[i10];
        if (i10 == 0) {
            return point3Arr;
        }
        get(0, 0, new int[i10 * 3]);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i11 * 3;
            point3Arr[i11] = new Point3(r2[i12], r2[i12 + 1], r2[i12 + 2]);
        }
        return point3Arr;
    }

    public List<Point3> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint3(long j10) {
        super(j10);
        if (!empty() && checkVector(3, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(3, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3(Point3... point3Arr) {
        fromArray(point3Arr);
    }
}
