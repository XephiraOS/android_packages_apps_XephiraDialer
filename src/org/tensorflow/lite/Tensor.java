package org.tensorflow.lite;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class Tensor {

    /* renamed from: a, reason: collision with root package name */
    public long f35912a;

    /* renamed from: b, reason: collision with root package name */
    public final DataType f35913b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f35914c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f35915d;

    /* renamed from: e, reason: collision with root package name */
    public final a f35916e;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final float f35917a;

        /* renamed from: b, reason: collision with root package name */
        public final int f35918b;

        public a(float f10, int i10) {
            this.f35917a = f10;
            this.f35918b = i10;
        }
    }

    public Tensor(long j10) {
        this.f35912a = j10;
        this.f35913b = DataType.b(dtype(j10));
        this.f35914c = shape(j10);
        this.f35915d = shapeSignature(j10);
        this.f35916e = new a(quantizationScale(j10), quantizationZeroPoint(j10));
    }

    private static native ByteBuffer buffer(long j10);

    public static int c(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return 0;
        }
        if (Array.getLength(obj) != 0) {
            return c(Array.get(obj, 0)) + 1;
        }
        throw new IllegalArgumentException("Array lengths cannot be 0.");
    }

    private static native long create(long j10, int i10);

    public static int[] d(Object obj) {
        int[] iArr = new int[c(obj)];
        i(obj, 0, iArr);
        return iArr;
    }

    private static native void delete(long j10);

    private static native int dtype(long j10);

    public static DataType h(Object obj) {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            while (cls.isArray()) {
                cls = cls.getComponentType();
            }
            if (!Float.TYPE.equals(cls) && !(obj instanceof FloatBuffer)) {
                if (!Integer.TYPE.equals(cls) && !(obj instanceof IntBuffer)) {
                    if (Byte.TYPE.equals(cls)) {
                        return DataType.UINT8;
                    }
                    if (!Long.TYPE.equals(cls) && !(obj instanceof LongBuffer)) {
                        if (String.class.equals(cls)) {
                            return DataType.STRING;
                        }
                    } else {
                        return DataType.INT64;
                    }
                } else {
                    return DataType.INT32;
                }
            } else {
                return DataType.FLOAT32;
            }
        }
        throw new IllegalArgumentException("DataType error: cannot resolve DataType of " + obj.getClass().getName());
    }

    private static native boolean hasDelegateBufferHandle(long j10);

    public static void i(Object obj, int i10, int[] iArr) {
        if (iArr != null && i10 != iArr.length) {
            int length = Array.getLength(obj);
            int i11 = iArr[i10];
            if (i11 == 0) {
                iArr[i10] = length;
            } else if (i11 != length) {
                throw new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", Integer.valueOf(iArr[i10]), Integer.valueOf(length), Integer.valueOf(i10)));
            }
            for (int i12 = 0; i12 < length; i12++) {
                i(Array.get(obj, i12), i10 + 1, iArr);
            }
        }
    }

    private static native int index(long j10);

    public static Tensor j(long j10, int i10) {
        return new Tensor(create(j10, i10));
    }

    public static boolean l(Object obj) {
        return obj instanceof Buffer;
    }

    public static boolean m(Object obj) {
        return obj instanceof ByteBuffer;
    }

    private static native String name(long j10);

    private static native int numBytes(long j10);

    private static native float quantizationScale(long j10);

    private static native int quantizationZeroPoint(long j10);

    private static native void readMultiDimensionalArray(long j10, Object obj);

    private static native int[] shape(long j10);

    private static native int[] shapeSignature(long j10);

    private static native void writeDirectBuffer(long j10, Buffer buffer);

    private static native void writeMultiDimensionalArray(long j10, Object obj);

    public final ByteBuffer a() {
        return buffer(this.f35912a).order(ByteOrder.nativeOrder());
    }

    public void b() {
        delete(this.f35912a);
        this.f35912a = 0L;
    }

    public Object e(Object obj) {
        if (obj == null) {
            if (hasDelegateBufferHandle(this.f35912a)) {
                return obj;
            }
            throw new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
        }
        s(obj);
        if (l(obj)) {
            f((Buffer) obj);
        } else {
            readMultiDimensionalArray(this.f35912a, obj);
        }
        return obj;
    }

    public final void f(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            ((ByteBuffer) buffer).put(a());
            return;
        }
        if (buffer instanceof FloatBuffer) {
            ((FloatBuffer) buffer).put(a().asFloatBuffer());
            return;
        }
        if (buffer instanceof LongBuffer) {
            ((LongBuffer) buffer).put(a().asLongBuffer());
        } else {
            if (buffer instanceof IntBuffer) {
                ((IntBuffer) buffer).put(a().asIntBuffer());
                return;
            }
            throw new IllegalArgumentException("Unexpected output buffer type: " + buffer);
        }
    }

    public DataType g() {
        return this.f35913b;
    }

    public int[] k(Object obj) {
        if (obj == null || l(obj)) {
            return null;
        }
        u(obj);
        int[] d10 = d(obj);
        if (Arrays.equals(this.f35914c, d10)) {
            return null;
        }
        return d10;
    }

    public int n() {
        return numBytes(this.f35912a);
    }

    public void o() {
        this.f35914c = shape(this.f35912a);
    }

    public void p(Object obj) {
        if (obj == null) {
            if (hasDelegateBufferHandle(this.f35912a)) {
                return;
            } else {
                throw new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
            }
        }
        s(obj);
        if (l(obj)) {
            q((Buffer) obj);
        } else {
            writeMultiDimensionalArray(this.f35912a, obj);
        }
    }

    public final void q(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) buffer;
            if (byteBuffer.isDirect() && byteBuffer.order() == ByteOrder.nativeOrder()) {
                writeDirectBuffer(this.f35912a, buffer);
                return;
            } else {
                a().put(byteBuffer);
                return;
            }
        }
        if (buffer instanceof LongBuffer) {
            LongBuffer longBuffer = (LongBuffer) buffer;
            if (longBuffer.isDirect() && longBuffer.order() == ByteOrder.nativeOrder()) {
                writeDirectBuffer(this.f35912a, buffer);
                return;
            } else {
                a().asLongBuffer().put(longBuffer);
                return;
            }
        }
        if (buffer instanceof FloatBuffer) {
            FloatBuffer floatBuffer = (FloatBuffer) buffer;
            if (floatBuffer.isDirect() && floatBuffer.order() == ByteOrder.nativeOrder()) {
                writeDirectBuffer(this.f35912a, buffer);
                return;
            } else {
                a().asFloatBuffer().put(floatBuffer);
                return;
            }
        }
        if (buffer instanceof IntBuffer) {
            IntBuffer intBuffer = (IntBuffer) buffer;
            if (intBuffer.isDirect() && intBuffer.order() == ByteOrder.nativeOrder()) {
                writeDirectBuffer(this.f35912a, buffer);
                return;
            } else {
                a().asIntBuffer().put(intBuffer);
                return;
            }
        }
        throw new IllegalArgumentException("Unexpected input buffer type: " + buffer);
    }

    public int[] r() {
        return this.f35914c;
    }

    public final void s(Object obj) {
        u(obj);
        t(obj);
    }

    public final void t(Object obj) {
        int a10;
        if (l(obj)) {
            Buffer buffer = (Buffer) obj;
            int n10 = n();
            if (m(obj)) {
                a10 = buffer.capacity();
            } else {
                a10 = this.f35913b.a() * buffer.capacity();
            }
            if (n10 == a10) {
                return;
            } else {
                throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite buffer with %d bytes and a Java Buffer with %d bytes.", Integer.valueOf(n10), Integer.valueOf(a10)));
            }
        }
        int[] d10 = d(obj);
        if (Arrays.equals(d10, this.f35914c)) {
        } else {
            throw new IllegalArgumentException(String.format("Cannot copy between a TensorFlowLite tensor with shape %s and a Java object with shape %s.", Arrays.toString(this.f35914c), Arrays.toString(d10)));
        }
    }

    public final void u(Object obj) {
        DataType h10;
        if (m(obj) || (h10 = h(obj)) == this.f35913b || h10.c().equals(this.f35913b.c())) {
        } else {
            throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", this.f35913b, obj.getClass().getName(), h10));
        }
    }
}
