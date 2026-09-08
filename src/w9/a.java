package W9;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.tensorflow.lite.DataType;

/* compiled from: TensorBuffer.java */
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f4248a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f4249b;

    /* renamed from: c, reason: collision with root package name */
    public int f4250c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4251d = false;

    /* compiled from: TensorBuffer.java */
    /* renamed from: W9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C0080a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4252a;

        static {
            int[] iArr = new int[DataType.values().length];
            f4252a = iArr;
            try {
                iArr[DataType.FLOAT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4252a[DataType.UINT8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(int[] iArr) {
        a(iArr);
    }

    public static int b(int[] iArr) {
        V9.a.b(iArr, "Shape cannot be null.");
        int i10 = 1;
        for (int i11 : iArr) {
            i10 *= i11;
        }
        return i10;
    }

    public static a c(int[] iArr, DataType dataType) {
        int i10 = C0080a.f4252a[dataType.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return new c(iArr);
            }
            throw new AssertionError("TensorBuffer does not support data type: " + dataType);
        }
        return new b(iArr);
    }

    public static boolean j(int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        for (int i10 : iArr) {
            if (i10 < 0) {
                return false;
            }
        }
        return true;
    }

    public final void a(int[] iArr) {
        V9.a.b(iArr, "TensorBuffer shape cannot be null.");
        V9.a.a(j(iArr), "Values in TensorBuffer shape should be non-negative.");
        int b10 = b(iArr);
        if (this.f4250c == b10) {
            return;
        }
        this.f4250c = b10;
        this.f4249b = (int[]) iArr.clone();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f4250c * i());
        this.f4248a = allocateDirect;
        allocateDirect.order(ByteOrder.nativeOrder());
    }

    public ByteBuffer d() {
        return this.f4248a;
    }

    public abstract DataType e();

    public int f() {
        return this.f4250c;
    }

    public abstract float[] g();

    public int[] h() {
        int[] iArr = this.f4249b;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public abstract int i();

    public void k(ByteBuffer byteBuffer) {
        l(byteBuffer, this.f4249b);
    }

    public void l(ByteBuffer byteBuffer, int[] iArr) {
        boolean z10;
        V9.a.b(byteBuffer, "Byte buffer cannot be null.");
        int b10 = b(iArr);
        boolean z11 = false;
        if (byteBuffer.limit() == i() * b10) {
            z10 = true;
        } else {
            z10 = false;
        }
        V9.a.a(z10, "The size of byte buffer and the shape do not match.");
        if (!this.f4251d) {
            if (b10 == this.f4250c) {
                z11 = true;
            }
            V9.a.a(z11, "The size of byte buffer and the size of the tensor buffer do not match.");
        } else {
            this.f4250c = b10;
        }
        this.f4249b = (int[]) iArr.clone();
        byteBuffer.rewind();
        this.f4248a = byteBuffer;
    }
}
