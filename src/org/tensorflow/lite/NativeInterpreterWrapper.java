package org.tensorflow.lite;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.b;
import org.tensorflow.lite.nnapi.NnApiDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class NativeInterpreterWrapper implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public long f35900a;

    /* renamed from: b, reason: collision with root package name */
    public long f35901b;

    /* renamed from: c, reason: collision with root package name */
    public long f35902c;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f35904e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, Integer> f35905f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, Integer> f35906g;

    /* renamed from: h, reason: collision with root package name */
    public Tensor[] f35907h;

    /* renamed from: i, reason: collision with root package name */
    public Tensor[] f35908i;

    /* renamed from: d, reason: collision with root package name */
    public long f35903d = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f35909j = false;

    /* renamed from: k, reason: collision with root package name */
    public final List<a> f35910k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final List<AutoCloseable> f35911l = new ArrayList();

    public NativeInterpreterWrapper(ByteBuffer byteBuffer, b.a aVar) {
        TensorFlowLite.a();
        if (byteBuffer != null && ((byteBuffer instanceof MappedByteBuffer) || (byteBuffer.isDirect() && byteBuffer.order() == ByteOrder.nativeOrder()))) {
            this.f35904e = byteBuffer;
            long createErrorReporter = createErrorReporter(512);
            l(createErrorReporter, createModelWithBuffer(this.f35904e, createErrorReporter), aVar);
            return;
        }
        throw new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
    }

    private static native long allocateTensors(long j10, long j11);

    private static native void allowBufferHandleOutput(long j10, boolean z10);

    private static native void allowFp16PrecisionForFp32(long j10, boolean z10);

    private static native void applyDelegate(long j10, long j11, long j12);

    private static native long createErrorReporter(int i10);

    private static native long createInterpreter(long j10, long j11, int i10);

    private static native long createModel(String str, long j10);

    private static native long createModelWithBuffer(ByteBuffer byteBuffer, long j10);

    private static native void delete(long j10, long j11, long j12);

    private static native int getInputCount(long j10);

    private static native String[] getInputNames(long j10);

    private static native int getInputTensorIndex(long j10, int i10);

    private static native int getOutputCount(long j10);

    private static native int getOutputDataType(long j10, int i10);

    private static native String[] getOutputNames(long j10);

    private static native int getOutputTensorIndex(long j10, int i10);

    private static native boolean hasUnresolvedFlexOp(long j10);

    private static native void numThreads(long j10, int i10);

    public static a o(List<a> list) {
        try {
            Class<?> cls = Class.forName("org.tensorflow.lite.flex.FlexDelegate");
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                if (cls.isInstance(it.next())) {
                    return null;
                }
            }
            return (a) cls.getConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static native void resetVariableTensors(long j10, long j11);

    private static native boolean resizeInput(long j10, long j11, int i10, int[] iArr);

    private static native void run(long j10, long j11);

    private static native void useNNAPI(long j10, boolean z10);

    public final void a(b.a aVar) {
        a o10;
        boolean hasUnresolvedFlexOp = hasUnresolvedFlexOp(this.f35901b);
        if (hasUnresolvedFlexOp && (o10 = o(aVar.f35926e)) != null) {
            this.f35911l.add((AutoCloseable) o10);
            applyDelegate(this.f35901b, this.f35900a, o10.a());
        }
        try {
            for (a aVar2 : aVar.f35926e) {
                applyDelegate(this.f35901b, this.f35900a, aVar2.a());
                this.f35910k.add(aVar2);
            }
            Boolean bool = aVar.f35923b;
            if (bool != null && bool.booleanValue()) {
                NnApiDelegate nnApiDelegate = new NnApiDelegate();
                this.f35911l.add(nnApiDelegate);
                applyDelegate(this.f35901b, this.f35900a, nnApiDelegate.a());
            }
        } catch (IllegalArgumentException e10) {
            if (hasUnresolvedFlexOp && !hasUnresolvedFlexOp(this.f35901b)) {
                System.err.println("Ignoring failed delegate application: " + e10);
                return;
            }
            throw e10;
        }
    }

    public Tensor c(int i10) {
        if (i10 >= 0) {
            Tensor[] tensorArr = this.f35907h;
            if (i10 < tensorArr.length) {
                Tensor tensor = tensorArr[i10];
                if (tensor == null) {
                    long j10 = this.f35901b;
                    Tensor j11 = Tensor.j(j10, getInputTensorIndex(j10, i10));
                    tensorArr[i10] = j11;
                    return j11;
                }
                return tensor;
            }
        }
        throw new IllegalArgumentException("Invalid input Tensor index: " + i10);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        int i10 = 0;
        while (true) {
            Tensor[] tensorArr = this.f35907h;
            if (i10 >= tensorArr.length) {
                break;
            }
            Tensor tensor = tensorArr[i10];
            if (tensor != null) {
                tensor.b();
                this.f35907h[i10] = null;
            }
            i10++;
        }
        int i11 = 0;
        while (true) {
            Tensor[] tensorArr2 = this.f35908i;
            if (i11 >= tensorArr2.length) {
                break;
            }
            Tensor tensor2 = tensorArr2[i11];
            if (tensor2 != null) {
                tensor2.b();
                this.f35908i[i11] = null;
            }
            i11++;
        }
        delete(this.f35900a, this.f35902c, this.f35901b);
        this.f35900a = 0L;
        this.f35902c = 0L;
        this.f35901b = 0L;
        this.f35904e = null;
        this.f35905f = null;
        this.f35906g = null;
        this.f35909j = false;
        this.f35910k.clear();
        Iterator<AutoCloseable> it = this.f35911l.iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (Exception e10) {
                System.err.println("Failed to close flex delegate: " + e10);
            }
        }
        this.f35911l.clear();
    }

    public int e() {
        return this.f35907h.length;
    }

    public Tensor f(int i10) {
        if (i10 >= 0) {
            Tensor[] tensorArr = this.f35908i;
            if (i10 < tensorArr.length) {
                Tensor tensor = tensorArr[i10];
                if (tensor == null) {
                    long j10 = this.f35901b;
                    Tensor j11 = Tensor.j(j10, getOutputTensorIndex(j10, i10));
                    tensorArr[i10] = j11;
                    return j11;
                }
                return tensor;
            }
        }
        throw new IllegalArgumentException("Invalid output Tensor index: " + i10);
    }

    public int g() {
        return this.f35908i.length;
    }

    public final void l(long j10, long j11, b.a aVar) {
        if (aVar == null) {
            aVar = new b.a();
        }
        this.f35900a = j10;
        this.f35902c = j11;
        long createInterpreter = createInterpreter(j11, j10, aVar.f35922a);
        this.f35901b = createInterpreter;
        this.f35907h = new Tensor[getInputCount(createInterpreter)];
        this.f35908i = new Tensor[getOutputCount(this.f35901b)];
        Boolean bool = aVar.f35924c;
        if (bool != null) {
            allowFp16PrecisionForFp32(this.f35901b, bool.booleanValue());
        }
        Boolean bool2 = aVar.f35925d;
        if (bool2 != null) {
            allowBufferHandleOutput(this.f35901b, bool2.booleanValue());
        }
        a(aVar);
        allocateTensors(this.f35901b, j10);
        this.f35909j = true;
    }

    public void r() {
        resetVariableTensors(this.f35901b, this.f35900a);
    }

    public void s(int i10, int[] iArr) {
        if (resizeInput(this.f35901b, this.f35900a, i10, iArr)) {
            this.f35909j = false;
            Tensor tensor = this.f35907h[i10];
            if (tensor != null) {
                tensor.o();
            }
        }
    }

    public void u(Object[] objArr, Map<Integer, Object> map) {
        this.f35903d = -1L;
        if (objArr != null && objArr.length != 0) {
            if (map != null && !map.isEmpty()) {
                int i10 = 0;
                for (int i11 = 0; i11 < objArr.length; i11++) {
                    int[] k10 = c(i11).k(objArr[i11]);
                    if (k10 != null) {
                        s(i11, k10);
                    }
                }
                boolean z10 = !this.f35909j;
                if (z10) {
                    allocateTensors(this.f35901b, this.f35900a);
                    this.f35909j = true;
                }
                for (int i12 = 0; i12 < objArr.length; i12++) {
                    c(i12).p(objArr[i12]);
                }
                long nanoTime = System.nanoTime();
                run(this.f35901b, this.f35900a);
                long nanoTime2 = System.nanoTime() - nanoTime;
                if (z10) {
                    while (true) {
                        Tensor[] tensorArr = this.f35908i;
                        if (i10 >= tensorArr.length) {
                            break;
                        }
                        Tensor tensor = tensorArr[i10];
                        if (tensor != null) {
                            tensor.o();
                        }
                        i10++;
                    }
                }
                for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                    f(entry.getKey().intValue()).e(entry.getValue());
                }
                this.f35903d = nanoTime2;
                return;
            }
            throw new IllegalArgumentException("Input error: Outputs should not be null or empty.");
        }
        throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
    }
}
