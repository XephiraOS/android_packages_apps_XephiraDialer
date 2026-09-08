package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class MatOfByte extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 0;

    public MatOfByte() {
    }

    public static MatOfByte fromNativeAddr(long j10) {
        return new MatOfByte(j10);
    }

    public void alloc(int i10) {
        if (i10 > 0) {
            super.create(i10, 1, CvType.makeType(0, 1));
        }
    }

    public void fromArray(byte... bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        alloc(bArr.length);
        put(0, 0, bArr);
    }

    public void fromList(List<Byte> list) {
        if (list != null && list.size() != 0) {
            Byte[] bArr = (Byte[]) list.toArray(new Byte[0]);
            byte[] bArr2 = new byte[bArr.length];
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr2[i10] = bArr[i10].byteValue();
            }
            fromArray(bArr2);
        }
    }

    public byte[] toArray() {
        int checkVector = checkVector(1, 0);
        if (checkVector >= 0) {
            byte[] bArr = new byte[checkVector];
            if (checkVector == 0) {
                return bArr;
            }
            get(0, 0, bArr);
            return bArr;
        }
        throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
    }

    public List<Byte> toList() {
        byte[] array = toArray();
        Byte[] bArr = new Byte[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            bArr[i10] = Byte.valueOf(array[i10]);
        }
        return Arrays.asList(bArr);
    }

    public MatOfByte(long j10) {
        super(j10);
        if (!empty() && checkVector(1, 0) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfByte(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 0) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public void fromArray(int i10, int i11, byte... bArr) {
        if (i10 >= 0) {
            bArr.getClass();
            if (i11 >= 0 && i11 + i10 <= bArr.length) {
                if (bArr.length == 0) {
                    return;
                }
                alloc(i11);
                put(0, 0, bArr, i10, i11);
                return;
            }
            throw new IllegalArgumentException("invalid 'length' parameter: " + Integer.toString(i11));
        }
        throw new IllegalArgumentException("offset < 0");
    }

    public MatOfByte(byte... bArr) {
        fromArray(bArr);
    }

    public MatOfByte(int i10, int i11, byte... bArr) {
        fromArray(i10, i11, bArr);
    }
}
