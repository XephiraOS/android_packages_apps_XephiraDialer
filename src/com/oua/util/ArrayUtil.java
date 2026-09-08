package com.oua.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.function.IntToDoubleFunction;
import java.util.stream.IntStream;

/* loaded from: classes4.dex */
public class ArrayUtil {
    public static <T> String analyze(T t10) {
        return Arrays.stream(toDoubleArray(t10)).summaryStatistics().toString();
    }

    public static ByteBuffer byte2ByteBuffer(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        allocate.put(bArr);
        allocate.flip();
        return allocate;
    }

    public static ByteBuffer double2Bytebufer(double[] dArr) {
        ByteBuffer allocate = ByteBuffer.allocate(dArr.length * 8);
        allocate.asDoubleBuffer().put(dArr);
        return allocate;
    }

    public static ByteBuffer float2ByteBufer(float[] fArr) {
        ByteBuffer allocate = ByteBuffer.allocate(fArr.length * 4);
        allocate.asFloatBuffer().put(fArr);
        return allocate;
    }

    public static ByteBuffer int2ByteBuffer(int[] iArr) {
        ByteBuffer allocate = ByteBuffer.allocate(iArr.length * 4);
        allocate.asIntBuffer().put(iArr);
        return allocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$toDoubleArray$0(float[] fArr, int i10) {
        return fArr[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$toDoubleArray$1(byte[] bArr, int i10) {
        return bArr[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$toDoubleArray$2(short[] sArr, int i10) {
        return sArr[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double lambda$toDoubleArray$3(int[] iArr, int i10) {
        return iArr[i10];
    }

    public static <T> void save(T t10, String str) {
        BufferUtil.saveRawBuffer(toByteBuffer(t10), str);
    }

    public static ByteBuffer short2ByteBuffer(short[] sArr) {
        ByteBuffer allocate = ByteBuffer.allocate(sArr.length * 2);
        allocate.asShortBuffer().put(sArr);
        allocate.flip();
        return allocate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> ByteBuffer toByteBuffer(T t10) {
        if (t10 instanceof float[]) {
            return float2ByteBufer((float[]) t10);
        }
        if (t10 instanceof byte[]) {
            return byte2ByteBuffer((byte[]) t10);
        }
        if (t10 instanceof short[]) {
            return short2ByteBuffer((short[]) t10);
        }
        if (t10 instanceof int[]) {
            return int2ByteBuffer((int[]) t10);
        }
        if (t10 instanceof double[]) {
            return double2Bytebufer((double[]) t10);
        }
        throw new RuntimeException("unsupported type for " + t10.toString());
    }

    public static ByteBuffer toDirectBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.asFloatBuffer().put(fArr);
        return allocateDirect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> double[] toDoubleArray(T t10) {
        if (t10 instanceof double[]) {
            return (double[]) t10;
        }
        if (t10 instanceof float[]) {
            final float[] fArr = (float[]) t10;
            return IntStream.range(0, fArr.length).mapToDouble(new IntToDoubleFunction() { // from class: com.oua.util.a
                @Override // java.util.function.IntToDoubleFunction
                public final double applyAsDouble(int i10) {
                    double lambda$toDoubleArray$0;
                    lambda$toDoubleArray$0 = ArrayUtil.lambda$toDoubleArray$0(fArr, i10);
                    return lambda$toDoubleArray$0;
                }
            }).toArray();
        }
        if (t10 instanceof byte[]) {
            final byte[] bArr = (byte[]) t10;
            return IntStream.range(0, bArr.length).mapToDouble(new IntToDoubleFunction() { // from class: com.oua.util.b
                @Override // java.util.function.IntToDoubleFunction
                public final double applyAsDouble(int i10) {
                    double lambda$toDoubleArray$1;
                    lambda$toDoubleArray$1 = ArrayUtil.lambda$toDoubleArray$1(bArr, i10);
                    return lambda$toDoubleArray$1;
                }
            }).toArray();
        }
        if (t10 instanceof short[]) {
            final short[] sArr = (short[]) t10;
            return IntStream.range(0, sArr.length).mapToDouble(new IntToDoubleFunction() { // from class: com.oua.util.c
                @Override // java.util.function.IntToDoubleFunction
                public final double applyAsDouble(int i10) {
                    double lambda$toDoubleArray$2;
                    lambda$toDoubleArray$2 = ArrayUtil.lambda$toDoubleArray$2(sArr, i10);
                    return lambda$toDoubleArray$2;
                }
            }).toArray();
        }
        if (t10 instanceof int[]) {
            final int[] iArr = (int[]) t10;
            return IntStream.range(0, iArr.length).mapToDouble(new IntToDoubleFunction() { // from class: com.oua.util.d
                @Override // java.util.function.IntToDoubleFunction
                public final double applyAsDouble(int i10) {
                    double lambda$toDoubleArray$3;
                    lambda$toDoubleArray$3 = ArrayUtil.lambda$toDoubleArray$3(iArr, i10);
                    return lambda$toDoubleArray$3;
                }
            }).toArray();
        }
        return null;
    }
}
