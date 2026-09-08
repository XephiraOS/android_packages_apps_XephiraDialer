package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfDouble extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 6;

    public MatOfDouble() {
    }

    public static MatOfDouble fromNativeAddr(long j10) {
        return new MatOfDouble(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(6, 1));
        }
    }

    public void fromArray(double... dArr) {
        if (dArr != null && dArr.length != 0) {
            alloc(dArr.length);
            put(0, 0, dArr);
        }
    }

    public void fromList(List<Double> list) {
        if (list != null && list.size() != 0) {
            Double[] dArr = (Double[]) list.toArray(new Double[0]);
            double[] dArr2 = new double[dArr.length];
            for (int i10 = 0; i10 < dArr.length; i10++) {
                dArr2[i10] = dArr[i10].doubleValue();
            }
            fromArray(dArr2);
        }
    }

    public double[] toArray() {
        int checkVector = checkVector(1, 6);
        if (checkVector >= 0) {
            double[] dArr = new double[checkVector];
            if (checkVector == 0) {
                return dArr;
            }
            get(0, 0, dArr);
            return dArr;
        }
        throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
    }

    public List<Double> toList() {
        double[] array = toArray();
        Double[] dArr = new Double[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            dArr[i10] = Double.valueOf(array[i10]);
        }
        return Arrays.asList(dArr);
    }

    public MatOfDouble(long j10) {
        super(j10);
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfDouble(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfDouble(double... dArr) {
        fromArray(dArr);
    }
}
