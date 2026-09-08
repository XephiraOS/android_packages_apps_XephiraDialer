package com.oua.tflite;

import com.oua.tflite.Config;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.TensorFlowLite;
import org.tensorflow.lite.b;
import org.tensorflow.lite.gpu.GpuDelegate;
import org.tensorflow.lite.nnapi.NnApiDelegate;

/* loaded from: classes4.dex */
public class TfliteModelImpl extends TfliteModel {
    private static final String TAG = "com.oua.tflite.TfliteModelImpl";
    private org.tensorflow.lite.a apiDelegate;
    public org.tensorflow.lite.b interpreter;
    protected final b.a tfliteOptions;

    /* renamed from: com.oua.tflite.TfliteModelImpl$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$oua$tflite$Config$Device;

        static {
            int[] iArr = new int[Config.Device.values().length];
            $SwitchMap$com$oua$tflite$Config$Device = iArr;
            try {
                iArr[Config.Device.NNAPI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$oua$tflite$Config$Device[Config.Device.GPU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$oua$tflite$Config$Device[Config.Device.CPU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TfliteModelImpl(Config config) {
        super(config);
        this.apiDelegate = null;
        this.tfliteOptions = new b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(int i10) {
        DebugConfig.logd(TAG, String.format("input tensor %d:%s", Integer.valueOf(i10), TensorUtil.toString(this.interpreter.c(i10))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(int i10) {
        DebugConfig.logd(TAG, String.format("output tensor %d:%s", Integer.valueOf(i10), TensorUtil.toString(this.interpreter.f(i10))));
    }

    @Override // com.oua.tflite.TfliteModel
    public void close() {
        org.tensorflow.lite.b bVar = this.interpreter;
        if (bVar != null) {
            bVar.close();
            this.interpreter = null;
        }
        org.tensorflow.lite.a aVar = this.apiDelegate;
        if (aVar != null) {
            if (aVar instanceof GpuDelegate) {
                ((GpuDelegate) aVar).close();
            } else if (aVar instanceof NnApiDelegate) {
                ((NnApiDelegate) aVar).close();
            }
            this.apiDelegate = null;
        }
    }

    @Override // com.oua.tflite.TfliteModel
    public ByteBuffer createOutputBuffer(int i10) {
        for (int i11 = 0; i11 < this.interpreter.g(); i11++) {
            DebugConfig.logd(TAG, String.format("output %d, %s", Integer.valueOf(i11), StringUtil.toString(this.interpreter.f(i11).r())));
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.interpreter.f(i10).n());
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect;
    }

    @Override // com.oua.tflite.TfliteModel
    public int getInputTensorCount() {
        return this.interpreter.e();
    }

    @Override // com.oua.tflite.TfliteModel
    public DataType getInputTensorDataType(int i10) {
        return this.interpreter.c(i10).g();
    }

    @Override // com.oua.tflite.TfliteModel
    public int[] getInputTensorShape(int i10) {
        return this.interpreter.c(i10).r();
    }

    @Override // com.oua.tflite.TfliteModel
    public int getOutputTensorCount() {
        return this.interpreter.g();
    }

    @Override // com.oua.tflite.TfliteModel
    public DataType getOutputTensorDataType(int i10) {
        return this.interpreter.f(i10).g();
    }

    @Override // com.oua.tflite.TfliteModel
    public int[] getOutputTensorShape(int i10) {
        return this.interpreter.f(i10).r();
    }

    @Override // com.oua.tflite.TfliteModel
    public void init(ByteBuffer byteBuffer) {
        String str = TAG;
        DebugConfig.logi(str, "Tflite version: " + TensorFlowLite.b());
        int i10 = AnonymousClass1.$SwitchMap$com$oua$tflite$Config$Device[this.config.device.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                GpuDelegate gpuDelegate = new GpuDelegate();
                this.apiDelegate = gpuDelegate;
                this.tfliteOptions.a(gpuDelegate);
            }
        } else {
            NnApiDelegate nnApiDelegate = new NnApiDelegate();
            this.apiDelegate = nnApiDelegate;
            this.tfliteOptions.a(nnApiDelegate);
        }
        this.tfliteOptions.b(this.config.threadNum);
        this.interpreter = new org.tensorflow.lite.b(byteBuffer, this.tfliteOptions);
        DebugConfig.logd(str, "input tensor count " + this.interpreter.e());
        IntStream.range(0, this.interpreter.e()).forEach(new IntConsumer() { // from class: com.oua.tflite.h
            @Override // java.util.function.IntConsumer
            public final void accept(int i11) {
                TfliteModelImpl.this.lambda$init$0(i11);
            }
        });
        DebugConfig.logd(str, "output tensor count " + this.interpreter.g());
        IntStream.range(0, this.interpreter.g()).forEach(new IntConsumer() { // from class: com.oua.tflite.i
            @Override // java.util.function.IntConsumer
            public final void accept(int i11) {
                TfliteModelImpl.this.lambda$init$1(i11);
            }
        });
    }

    @Override // com.oua.tflite.TfliteModel
    public ByteBuffer run(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer2 == null) {
            byteBuffer2 = createOutputBuffer(0);
        }
        SimpleTrace trace = SimpleTrace.getTrace();
        String str = TAG;
        trace.startSection("run", str);
        if (this.config.resetVariable) {
            this.interpreter.l();
        }
        this.interpreter.o(byteBuffer, byteBuffer2);
        SimpleTrace.getTrace().endSection("run");
        byteBuffer2.flip();
        DebugConfig.logd(str, "output buffer " + byteBuffer2.toString());
        return byteBuffer2;
    }

    @Override // com.oua.tflite.TfliteModel
    public void runForMultipleImpl(ByteBuffer[] byteBufferArr, Map<Integer, Object> map) {
        SimpleTrace.getTrace().startSection("runForMultipleImpl", TAG);
        if (this.config.resetVariable) {
            this.interpreter.l();
        }
        this.interpreter.r(byteBufferArr, map);
        SimpleTrace.getTrace().endSection("runForMultipleImpl");
    }
}
