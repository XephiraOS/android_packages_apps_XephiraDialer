package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfInt extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 4;

    public MatOfInt() {
    }

    public static MatOfInt fromNativeAddr(long j10) {
        return new MatOfInt(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(4, 1));
        }
    }

    public void fromArray(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            alloc(iArr.length);
            put(0, 0, iArr);
        }
    }

    public void fromList(List<Integer> list) {
        if (list != null && list.size() != 0) {
            Integer[] numArr = (Integer[]) list.toArray(new Integer[0]);
            int[] iArr = new int[numArr.length];
            for (int i10 = 0; i10 < numArr.length; i10++) {
                iArr[i10] = numArr[i10].intValue();
            }
            fromArray(iArr);
        }
    }

    public int[] toArray() {
        int checkVector = checkVector(1, 4);
        if (checkVector >= 0) {
            int[] iArr = new int[checkVector];
            if (checkVector == 0) {
                return iArr;
            }
            get(0, 0, iArr);
            return iArr;
        }
        throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
    }

    public List<Integer> toList() {
        int[] array = toArray();
        Integer[] numArr = new Integer[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            numArr[i10] = Integer.valueOf(array[i10]);
        }
        return Arrays.asList(numArr);
    }

    public MatOfInt(long j10) {
        super(j10);
        if (!empty() && checkVector(1, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfInt(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfInt(int... iArr) {
        fromArray(iArr);
    }
}
