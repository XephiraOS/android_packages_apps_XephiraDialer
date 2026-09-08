package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfRect extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 4;

    public MatOfRect() {
    }

    public static MatOfRect fromNativeAddr(long j10) {
        return new MatOfRect(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(4, 4));
        }
    }

    public void fromArray(Rect... rectArr) {
        if (rectArr != null && rectArr.length != 0) {
            int length = rectArr.length;
            alloc(length);
            int[] iArr = new int[length * 4];
            for (int i10 = 0; i10 < length; i10++) {
                Rect rect = rectArr[i10];
                int i11 = i10 * 4;
                iArr[i11] = rect.f35887x;
                iArr[i11 + 1] = rect.f35888y;
                iArr[i11 + 2] = rect.width;
                iArr[i11 + 3] = rect.height;
            }
            put(0, 0, iArr);
        }
    }

    public void fromList(List<Rect> list) {
        fromArray((Rect[]) list.toArray(new Rect[0]));
    }

    public Rect[] toArray() {
        int i10 = (int) total();
        Rect[] rectArr = new Rect[i10];
        if (i10 == 0) {
            return rectArr;
        }
        int[] iArr = new int[i10 * 4];
        get(0, 0, iArr);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i11 * 4;
            rectArr[i11] = new Rect(iArr[i12], iArr[i12 + 1], iArr[i12 + 2], iArr[i12 + 3]);
        }
        return rectArr;
    }

    public List<Rect> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRect(long j10) {
        super(j10);
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect(Rect... rectArr) {
        fromArray(rectArr);
    }
}
