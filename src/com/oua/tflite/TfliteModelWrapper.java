package com.oua.tflite;

import android.util.Size;
import com.oua.task.OUATask;
import com.oua.task.OUATaskManager;
import com.oua.tflite.TfliteModelWrapper;
import com.oua.util.SimpleTrace;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.tensorflow.lite.DataType;

/* loaded from: classes4.dex */
public abstract class TfliteModelWrapper<Input, Output, Extra> extends OUATaskManager<List<Input>, List<Output>> {
    private static final String TAG = "com.oua.tflite.TfliteModelWrapper";
    public TfliteModel tfliteModel;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getModelTask$0() {
        return getName() + "_tf_run";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ModelOut lambda$getModelTask$1(ModelIn modelIn) {
        return new ModelOut(this.tfliteModel.runForMultiple(modelIn.buffers, null), modelIn.extraData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List lambda$getModelTask$2(List list) {
        return (List) list.stream().map(new Function() { // from class: com.oua.tflite.j
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                TfliteModelWrapper.ModelOut lambda$getModelTask$1;
                lambda$getModelTask$1 = TfliteModelWrapper.this.lambda$getModelTask$1((TfliteModelWrapper.ModelIn) obj);
                return lambda$getModelTask$1;
            }
        }).collect(Collectors.toList());
    }

    public void close() {
        this.tfliteModel.close();
    }

    public Size getInputImageSize(int i10) {
        return this.tfliteModel.getInputImageSize(i10);
    }

    public DataType getInputTensorDataType(int i10) {
        return this.tfliteModel.getInputTensorDataType(i10);
    }

    public int[] getInputTensorShape(int i10) {
        return this.tfliteModel.getInputTensorShape(i10);
    }

    public OUATask.BatchTask<ModelIn<Extra>, ModelOut<Extra>> getModelTask() {
        return OUATask.createBatch(new OUATask.GetNameFunc() { // from class: com.oua.tflite.k
            @Override // com.oua.task.OUATask.GetNameFunc
            public final String apply() {
                String lambda$getModelTask$0;
                lambda$getModelTask$0 = TfliteModelWrapper.this.lambda$getModelTask$0();
                return lambda$getModelTask$0;
            }
        }, new OUATask.RunFunc() { // from class: com.oua.tflite.l
            @Override // com.oua.task.OUATask.RunFunc
            public final Object apply(Object obj) {
                List lambda$getModelTask$2;
                lambda$getModelTask$2 = TfliteModelWrapper.this.lambda$getModelTask$2((List) obj);
                return lambda$getModelTask$2;
            }
        });
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public DataType getOutputTensorDataType(int i10) {
        return this.tfliteModel.getOutputTensorDataType(i10);
    }

    public int[] getOutputTensorShape(int i10) {
        return this.tfliteModel.getOutputTensorShape(i10);
    }

    public abstract OUATask.BatchTask<ModelOut<Extra>, Output> getPostprocessor();

    public abstract OUATask.BatchTask<Input, ModelIn<Extra>> getPreprocessor();

    @Override // com.oua.task.OUATaskManager
    public List<OUATask.Task> getTaskList() {
        ArrayList arrayList = new ArrayList();
        if (getPreprocessor() != null) {
            arrayList.add(getPreprocessor());
        }
        arrayList.add(getModelTask());
        if (getPostprocessor() != null) {
            arrayList.add(getPostprocessor());
        }
        return arrayList;
    }

    public void init(Config config, ByteBuffer byteBuffer) {
        SimpleTrace.getTrace().startSection(getName() + "_init", TAG);
        TfliteModel create = TfliteModel.create(config);
        this.tfliteModel = create;
        create.init(byteBuffer);
        SimpleTrace.getTrace().endSection(getName() + "_init");
    }

    /* loaded from: classes4.dex */
    public static class ModelOut<Extra> {
        public Map<Integer, ByteBuffer> buffers;
        public Extra extraData;

        public ModelOut(Map<Integer, ByteBuffer> map, Extra extra) {
            this.buffers = map;
            this.extraData = extra;
        }

        public ModelOut(ByteBuffer byteBuffer, Extra extra) {
            HashMap hashMap = new HashMap();
            hashMap.put(0, byteBuffer);
            this.buffers = hashMap;
            this.extraData = extra;
        }
    }

    /* loaded from: classes4.dex */
    public static class ModelIn<Extra> {
        public int batchSize;
        public ByteBuffer[] buffers;
        public Extra extraData;

        public ModelIn(ByteBuffer byteBuffer) {
            this.batchSize = 1;
            this.buffers = new ByteBuffer[]{byteBuffer};
            this.extraData = null;
        }

        public ModelIn(ByteBuffer[] byteBufferArr) {
            this.batchSize = 1;
            this.buffers = byteBufferArr;
            this.extraData = null;
        }

        public ModelIn(ByteBuffer byteBuffer, int i10, Extra extra) {
            this.buffers = new ByteBuffer[]{byteBuffer};
            this.extraData = extra;
            this.batchSize = i10;
        }

        public ModelIn(ByteBuffer[] byteBufferArr, int i10, Extra extra) {
            this.buffers = byteBufferArr;
            this.extraData = extra;
            this.batchSize = i10;
        }
    }
}
