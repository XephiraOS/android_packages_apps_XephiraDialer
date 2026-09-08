package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfRotatedRect extends Mat {
    private static final int _channels = 5;
    private static final int _depth = 5;

    public MatOfRotatedRect() {
    }

    public static MatOfRotatedRect fromNativeAddr(long j10) {
        return new MatOfRotatedRect(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(5, 5));
        }
    }

    public void fromArray(RotatedRect... rotatedRectArr) {
        if (rotatedRectArr != null && rotatedRectArr.length != 0) {
            int length = rotatedRectArr.length;
            alloc(length);
            float[] fArr = new float[length * 5];
            for (int i10 = 0; i10 < length; i10++) {
                RotatedRect rotatedRect = rotatedRectArr[i10];
                int i11 = i10 * 5;
                Point point = rotatedRect.center;
                fArr[i11] = (float) point.f35882x;
                fArr[i11 + 1] = (float) point.f35883y;
                Size size = rotatedRect.size;
                fArr[i11 + 2] = (float) size.width;
                fArr[i11 + 3] = (float) size.height;
                fArr[i11 + 4] = (float) rotatedRect.angle;
            }
            put(0, 0, fArr);
        }
    }

    public void fromList(List<RotatedRect> list) {
        fromArray((RotatedRect[]) list.toArray(new RotatedRect[0]));
    }

    public RotatedRect[] toArray() {
        int i10 = (int) total();
        RotatedRect[] rotatedRectArr = new RotatedRect[i10];
        if (i10 == 0) {
            return rotatedRectArr;
        }
        float[] fArr = new float[5];
        for (int i11 = 0; i11 < i10; i11++) {
            get(i11, 0, fArr);
            rotatedRectArr[i11] = new RotatedRect(new Point(fArr[0], fArr[1]), new Size(fArr[2], fArr[3]), fArr[4]);
        }
        return rotatedRectArr;
    }

    public List<RotatedRect> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRotatedRect(long j10) {
        super(j10);
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRotatedRect(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRotatedRect(RotatedRect... rotatedRectArr) {
        fromArray(rotatedRectArr);
    }
}
