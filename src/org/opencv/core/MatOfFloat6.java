package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfFloat6 extends Mat {
    private static final int _channels = 6;
    private static final int _depth = 5;

    public MatOfFloat6() {
    }

    public static MatOfFloat6 fromNativeAddr(long j10) {
        return new MatOfFloat6(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(5, 6));
        }
    }

    public void fromArray(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            alloc(fArr.length / 6);
            put(0, 0, fArr);
        }
    }

    public void fromList(List<Float> list) {
        if (list != null && list.size() != 0) {
            Float[] fArr = (Float[]) list.toArray(new Float[0]);
            float[] fArr2 = new float[fArr.length];
            for (int i10 = 0; i10 < fArr.length; i10++) {
                fArr2[i10] = fArr[i10].floatValue();
            }
            fromArray(fArr2);
        }
    }

    public float[] toArray() {
        int checkVector = checkVector(6, 5);
        if (checkVector >= 0) {
            float[] fArr = new float[checkVector * 6];
            if (checkVector == 0) {
                return fArr;
            }
            get(0, 0, fArr);
            return fArr;
        }
        throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
    }

    public List<Float> toList() {
        float[] array = toArray();
        Float[] fArr = new Float[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            fArr[i10] = Float.valueOf(array[i10]);
        }
        return Arrays.asList(fArr);
    }

    public MatOfFloat6(long j10) {
        super(j10);
        if (!empty() && checkVector(6, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfFloat6(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(6, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfFloat6(float... fArr) {
        fromArray(fArr);
    }
}
