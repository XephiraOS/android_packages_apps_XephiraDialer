package com.oua.tflite;

import android.content.Context;
import android.util.Size;
import com.oua.tflite.Config;
import com.oua.util.DebugConfig;
import com.oua.util.FileUtil;
import com.oua.util.StringUtil;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.tensorflow.lite.DataType;

/* loaded from: classes4.dex */
public abstract class TfliteModel {
    private static final String TAG = "com.oua.tflite.TfliteModel";
    public Config config;

    /* renamed from: com.oua.tflite.TfliteModel$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$oua$tflite$Config$Device = new int[Config.Device.values().length];
    }

    public TfliteModel(Config config) {
        this.config = config.m9clone();
        DebugConfig.logd(TAG, "config: ", config);
    }

    public static TfliteModel create(Config config) {
        if (config.device == null) {
            config.device = Config.Device.CPU;
            config.threadNum = 4;
        }
        int i10 = AnonymousClass1.$SwitchMap$com$oua$tflite$Config$Device[config.device.ordinal()];
        return new TfliteModelImpl(config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ByteBuffer lambda$createOutputBuffers$2(Integer num) {
        return createOutputBuffer(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$runForMultiple$3(Map.Entry entry) {
        return (Integer) entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$runForMultiple$5(Map.Entry entry) {
        return (Integer) entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ByteBuffer lambda$runForMultiple$6(Map.Entry entry) {
        ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
        byteBuffer.flip();
        DebugConfig.logd(TAG, String.format("output buffer %d: %s", entry.getKey(), byteBuffer.toString()));
        return byteBuffer;
    }

    public abstract void close();

    public abstract ByteBuffer createOutputBuffer(int i10);

    public Map<Integer, ByteBuffer> createOutputBuffers() {
        return (Map) IntStream.range(0, getOutputTensorCount()).mapToObj(new IntFunction() { // from class: com.oua.tflite.a
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                Integer valueOf;
                valueOf = Integer.valueOf(i10);
                return valueOf;
            }
        }).collect(Collectors.toMap(new Function() { // from class: com.oua.tflite.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Integer lambda$createOutputBuffers$1;
                lambda$createOutputBuffers$1 = TfliteModel.lambda$createOutputBuffers$1((Integer) obj);
                return lambda$createOutputBuffers$1;
            }
        }, new Function() { // from class: com.oua.tflite.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ByteBuffer lambda$createOutputBuffers$2;
                lambda$createOutputBuffers$2 = TfliteModel.this.lambda$createOutputBuffers$2((Integer) obj);
                return lambda$createOutputBuffers$2;
            }
        }));
    }

    public Size getInputImageSize(int i10) {
        int[] inputTensorShape = getInputTensorShape(i10);
        return new Size(inputTensorShape[2], inputTensorShape[1]);
    }

    public abstract int getInputTensorCount();

    public abstract DataType getInputTensorDataType(int i10);

    public abstract int[] getInputTensorShape(int i10);

    public abstract int getOutputTensorCount();

    public abstract DataType getOutputTensorDataType(int i10);

    public abstract int[] getOutputTensorShape(int i10);

    public void init(Context context) {
        DebugConfig.logd(TAG, "init " + StringUtil.toString(this.config));
        init(FileUtil.toDirectBuffer(this.config.modelPath, context));
    }

    public abstract void init(ByteBuffer byteBuffer);

    public abstract ByteBuffer run(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    public Map<Integer, ByteBuffer> runForMultiple(ByteBuffer[] byteBufferArr, Map<Integer, ByteBuffer> map) {
        if (map == null) {
            map = createOutputBuffers();
        }
        Map<Integer, Object> map2 = (Map) map.entrySet().stream().collect(Collectors.toMap(new Function() { // from class: com.oua.tflite.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Integer lambda$runForMultiple$3;
                lambda$runForMultiple$3 = TfliteModel.lambda$runForMultiple$3((Map.Entry) obj);
                return lambda$runForMultiple$3;
            }
        }, new Function() { // from class: com.oua.tflite.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object value;
                value = ((Map.Entry) obj).getValue();
                return value;
            }
        }));
        runForMultipleImpl(byteBufferArr, map2);
        return (Map) map2.entrySet().stream().collect(Collectors.toMap(new Function() { // from class: com.oua.tflite.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Integer lambda$runForMultiple$5;
                lambda$runForMultiple$5 = TfliteModel.lambda$runForMultiple$5((Map.Entry) obj);
                return lambda$runForMultiple$5;
            }
        }, new Function() { // from class: com.oua.tflite.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ByteBuffer lambda$runForMultiple$6;
                lambda$runForMultiple$6 = TfliteModel.lambda$runForMultiple$6((Map.Entry) obj);
                return lambda$runForMultiple$6;
            }
        }));
    }

    public abstract void runForMultipleImpl(ByteBuffer[] byteBufferArr, Map<Integer, Object> map);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$createOutputBuffers$1(Integer num) {
        return num;
    }
}
