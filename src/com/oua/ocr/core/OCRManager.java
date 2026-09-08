package com.oua.ocr.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oua.ocr.Language;
import com.oua.ocr.OCR;
import com.oua.ocr.OCRParams;
import com.oua.ocr.core.OCRManager;
import com.oua.tflite.Config;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public class OCRManager {
    public static final int Detection = 2;
    public static final int Recognization = 4;
    private static final String TAG = "com.oua.ocr.core.OCRManager";
    public static final int TextAreaDetection = 1;
    private Context context;
    ByteBuffer detectorModel;
    private OCREnvironment ocrEnv;
    private OCRNative ocrNative;
    ByteBuffer recognizerModel;
    private TextAreaDetector textArea;
    ByteBuffer textAreaDetectorModel;
    private Map<com.oua.tflite.Config, Detector> language2Detector = new HashMap();
    private Map<RecognizerConfig, Recognizer> language2Recognizer = new HashMap();
    private boolean isInit = false;

    /* loaded from: classes4.dex */
    public static class Config implements Cloneable {
        public com.oua.tflite.Config detecotorModelConfig;
        public RecognizerConfig recognizerConfig;
        public com.oua.tflite.Config textAreaDetecotorConfig;

        public Config(String str, String str2, String str3) {
            this.detecotorModelConfig = str != null ? new com.oua.tflite.Config(str, Config.Device.GPU, 4) : null;
            if (str2 != null) {
                this.recognizerConfig = new RecognizerConfig(new com.oua.tflite.Config(str2, Config.Device.CPU, 4), str3);
            }
        }

        private void copy(com.oua.tflite.Config config, com.oua.tflite.Config config2, RecognizerConfig recognizerConfig) {
            com.oua.tflite.Config config3;
            com.oua.tflite.Config config4;
            RecognizerConfig recognizerConfig2 = null;
            if (config != null) {
                config3 = config.m9clone();
            } else {
                config3 = null;
            }
            this.textAreaDetecotorConfig = config3;
            if (config2 != null) {
                config4 = config2.m9clone();
            } else {
                config4 = null;
            }
            this.detecotorModelConfig = config4;
            if (recognizerConfig != null) {
                recognizerConfig2 = recognizerConfig.m8clone();
            }
            this.recognizerConfig = recognizerConfig2;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Config m7clone() {
            return new Config(this);
        }

        public Config(com.oua.tflite.Config config, com.oua.tflite.Config config2, RecognizerConfig recognizerConfig) {
            copy(config, config2, recognizerConfig);
        }

        public Config(com.oua.tflite.Config config, RecognizerConfig recognizerConfig) {
            copy(null, config, recognizerConfig);
        }

        public Config(Config config) {
            DebugConfig.logd(Constants.MessagerConstants.CONFIG_KEY, StringUtil.toString(config));
            copy(config.textAreaDetecotorConfig, config.detecotorModelConfig, config.recognizerConfig);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Detector extends Engine<DetectorInput, DetectorOutput> {
    }

    /* loaded from: classes4.dex */
    public static class DetectorInput {
        Mat inputMat;
    }

    /* loaded from: classes4.dex */
    public static class DetectorOutput {
        int degree;
        List<List<Point>> boundingBoxes = new ArrayList();
        List<List<List<Point>>> segmentBoxes = new ArrayList();
    }

    /* loaded from: classes4.dex */
    public static abstract class Engine<In, Out> implements AutoCloseable {
        public static final int Closed = 1;
        public static final int Created = 0;
        public static final int Initilized = 1;
        OCRManager ocrManager;

        @Status
        private int status = 0;

        /* loaded from: classes4.dex */
        public @interface Status {
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            closeImpl();
            this.status = 1;
        }

        public abstract void closeImpl();

        public void init(OCRManager oCRManager) {
            this.ocrManager = oCRManager;
            initImpl();
            this.status = 1;
        }

        public abstract void initImpl();

        public abstract Out run(In in);
    }

    @FunctionalInterface
    /* loaded from: classes4.dex */
    public interface FactoryFunc<E> {
        E run(int i10);
    }

    /* loaded from: classes4.dex */
    public static abstract class Recognizer extends Engine<RecognizerInput, List<OCR.OCRItem>> {
    }

    /* loaded from: classes4.dex */
    public static class RecognizerConfig implements Cloneable {
        public String dictPath;
        public com.oua.tflite.Config modelConfig;

        public RecognizerConfig(com.oua.tflite.Config config, String str) {
            this.modelConfig = config.m9clone();
            this.dictPath = str;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RecognizerConfig)) {
                return false;
            }
            RecognizerConfig recognizerConfig = (RecognizerConfig) obj;
            if (!this.modelConfig.equals(recognizerConfig.modelConfig) || !this.dictPath.equals(recognizerConfig.dictPath)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public String toString() {
            return StringUtil.toString(this);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RecognizerConfig m8clone() {
            return new RecognizerConfig(this.modelConfig, this.dictPath);
        }
    }

    /* loaded from: classes4.dex */
    public static class RecognizerInput {
        List<Mat> textImages;
    }

    /* loaded from: classes4.dex */
    public static class RecognizerOutput {
        int degree;
        List<OCR.OCRItem> items = new ArrayList();
    }

    /* loaded from: classes4.dex */
    public static abstract class TextAreaDetector extends Engine<Bitmap, TextAreaOutput> {
    }

    /* loaded from: classes4.dex */
    public static class TextAreaOutput {
        List<Point> textArea;
    }

    static {
        String name = OCRManager.class.getName();
        if (!OpenCVLoader.initDebug()) {
            DebugConfig.loge(name, "OpenCV initialization failed!");
        }
        System.loadLibrary("opencv_java4");
    }

    public OCRManager(OCREnvironment oCREnvironment) {
        this.ocrEnv = oCREnvironment;
    }

    public static OCRManager create(OCREnvironment oCREnvironment) {
        return new OCRManager(oCREnvironment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createDetector, reason: merged with bridge method [inline-methods] */
    public Detector lambda$run$1(int i10) {
        Config config = this.ocrEnv.getConfig(i10);
        if (config != null) {
            Detector createDetector = this.ocrEnv.createDetector(config);
            if (createDetector != null) {
                createDetector.init(this);
            }
            this.language2Detector.put(config.detecotorModelConfig, createDetector);
            return createDetector;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createRecognizer, reason: merged with bridge method [inline-methods] */
    public Recognizer lambda$run$3(int i10) {
        Config config = this.ocrEnv.getConfig(i10);
        if (config != null) {
            Recognizer createRecognizer = this.ocrEnv.createRecognizer(config);
            if (createRecognizer != null) {
                createRecognizer.init(this);
            }
            this.language2Recognizer.put(config.recognizerConfig, createRecognizer);
            return createRecognizer;
        }
        return null;
    }

    private TextAreaDetector createTextArea() {
        try {
            Config config = this.ocrEnv.getConfig(5);
            if (config != null && config.textAreaDetecotorConfig != null) {
                String str = TAG;
                DebugConfig.logd(str, "create TextArea");
                TextAreaDetector createTextAreaDetector = this.ocrEnv.createTextAreaDetector(config);
                if (createTextAreaDetector != null) {
                    DebugConfig.logd(str, "init TextArea");
                    createTextAreaDetector.init(this);
                }
                return createTextAreaDetector;
            }
            return null;
        } catch (Exception e10) {
            DebugConfig.loge(TAG, "cannot create text area detector ");
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getDetctor, reason: merged with bridge method [inline-methods] */
    public Detector lambda$run$0(int i10) {
        Config config = this.ocrEnv.getConfig(i10);
        if (config != null) {
            return this.language2Detector.get(config.detecotorModelConfig);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRecognizer, reason: merged with bridge method [inline-methods] */
    public Recognizer lambda$run$2(int i10) {
        Config config = this.ocrEnv.getConfig(i10);
        if (config != null) {
            return this.language2Recognizer.get(config.recognizerConfig);
        }
        return null;
    }

    private <E extends Engine> E selectEngine(int[] iArr, FactoryFunc<E> factoryFunc, FactoryFunc<E> factoryFunc2) {
        E run;
        for (int i10 : iArr) {
            try {
                run = factoryFunc.run(i10);
            } catch (Exception unused) {
                DebugConfig.loge(TAG, "cannot ceate ocr engine for language:" + Language.toString(i10));
            }
            if (run != null) {
                DebugConfig.logd(TAG, "select ocr engine for " + Language.toString(i10));
                return run;
            }
            E run2 = factoryFunc2.run(i10);
            if (run2 != null) {
                DebugConfig.logd(TAG, "select ocr engine for " + Language.toString(i10));
                return run2;
            }
        }
        throw new Exception("Cannot find OCR engine for selected languages " + StringUtil.toString(iArr));
    }

    public void close() {
        DebugConfig.logd(TAG, "close");
        try {
            Iterator<Detector> it = this.language2Detector.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.language2Detector.clear();
            Iterator<Recognizer> it2 = this.language2Recognizer.values().iterator();
            while (it2.hasNext()) {
                it2.next().close();
            }
            this.language2Recognizer.clear();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public OCR.OCRResult detectTextArea(Bitmap bitmap) {
        OCR.OCRResult oCRResult = new OCR.OCRResult();
        if (this.textArea == null) {
            this.textArea = createTextArea();
        }
        oCRResult.textArea = this.textArea.run(bitmap).textArea;
        return oCRResult;
    }

    public OCRParams getOCRParams() {
        return this.ocrEnv.getParams();
    }

    public void init(Context context, String str, String str2) {
        DebugConfig.logd(TAG, "init");
        init(context, new int[]{5, 6, 11}, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ByteBuffer loadModelFile(String str) {
        return (ByteBuffer) this.ocrEnv.packageManager.loadFile(str, this.context, ByteBuffer.class).data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String loadTxtFile(String str) {
        return (String) this.ocrEnv.packageManager.loadFile(str, this.context, String.class).data;
    }

    public OCR.OCRResult run(Bitmap bitmap, int i10, OCR.Option option, List<List<Point>> list, int[] iArr) {
        if (this.isInit) {
            if (iArr == null || iArr.length == 0) {
                iArr = new int[]{5, 6, 11};
            }
            if (option == null) {
                option = new OCR.Option();
            }
            OCR.Option option2 = option;
            if (this.ocrEnv.useNative()) {
                return this.ocrNative.run(bitmap, getOCRParams());
            }
            DebugConfig.logd(TAG, "Language " + StringUtil.toString(iArr));
            if ((i10 & 1) != 0) {
                try {
                    if (this.textArea == null) {
                        this.textArea = createTextArea();
                    }
                } catch (Exception e10) {
                    throw new RuntimeException(e10);
                }
            }
            return OCREngine.run(this, this.textArea, (Detector) selectEngine(iArr, new FactoryFunc() { // from class: com.oua.ocr.core.M
                @Override // com.oua.ocr.core.OCRManager.FactoryFunc
                public final Object run(int i11) {
                    OCRManager.Detector lambda$run$0;
                    lambda$run$0 = OCRManager.this.lambda$run$0(i11);
                    return lambda$run$0;
                }
            }, new FactoryFunc() { // from class: com.oua.ocr.core.N
                @Override // com.oua.ocr.core.OCRManager.FactoryFunc
                public final Object run(int i11) {
                    OCRManager.Detector lambda$run$1;
                    lambda$run$1 = OCRManager.this.lambda$run$1(i11);
                    return lambda$run$1;
                }
            }), (Recognizer) selectEngine(iArr, new FactoryFunc() { // from class: com.oua.ocr.core.O
                @Override // com.oua.ocr.core.OCRManager.FactoryFunc
                public final Object run(int i11) {
                    OCRManager.Recognizer lambda$run$2;
                    lambda$run$2 = OCRManager.this.lambda$run$2(i11);
                    return lambda$run$2;
                }
            }, new FactoryFunc() { // from class: com.oua.ocr.core.P
                @Override // com.oua.ocr.core.OCRManager.FactoryFunc
                public final Object run(int i11) {
                    OCRManager.Recognizer lambda$run$3;
                    lambda$run$3 = OCRManager.this.lambda$run$3(i11);
                    return lambda$run$3;
                }
            }), bitmap, i10, option2, list);
        }
        throw new RuntimeException("OCR has not been initialized!");
    }

    public void init(Context context, int[] iArr, String str, String str2) {
        SimpleTrace trace = SimpleTrace.getTrace();
        String str3 = TAG;
        trace.startSection("init", str3);
        DebugConfig.logMemory(str3, "start");
        DebugConfig.logd(str3, "init");
        this.isInit = false;
        this.context = context;
        this.ocrEnv.init(context, str, str2);
        SimpleTrace.getTrace().addEvent("init_env");
        if (this.ocrEnv.useNative()) {
            this.ocrNative = new OCRNative();
            Config config = this.ocrEnv.getConfig(iArr[0]);
            this.textAreaDetectorModel = loadModelFile(config.textAreaDetecotorConfig.modelPath);
            this.detectorModel = loadModelFile(config.detecotorModelConfig.modelPath);
            ByteBuffer loadModelFile = loadModelFile(config.recognizerConfig.modelConfig.modelPath);
            this.recognizerModel = loadModelFile;
            this.ocrNative.init(this.textAreaDetectorModel, this.detectorModel, loadModelFile, loadTxtFile(config.recognizerConfig.dictPath));
        } else {
            if (getOCRParams().detectTextArea) {
                this.textArea = createTextArea();
            }
            DebugConfig.logMemory(str3, "createTextArea");
            if (iArr != null) {
                for (int i10 : iArr) {
                    if (lambda$run$0(i10) == null) {
                        lambda$run$1(i10);
                        DebugConfig.logMemory(TAG, "createDetector");
                    }
                    if (lambda$run$2(i10) == null) {
                        lambda$run$3(i10);
                        DebugConfig.logMemory(TAG, "createRecognizer");
                    }
                }
            }
        }
        this.isInit = true;
        SimpleTrace.getTrace().endSection("init");
    }
}
