package com.oua.ocr.bc;

import com.oua.ocr.Language;
import com.oua.ocr.OCRParams;
import com.oua.ocr.core.DetectorImplCV;
import com.oua.ocr.core.OCREnvironment;
import com.oua.ocr.core.OCRManager;
import com.oua.ocr.core.RecognitionImplText;
import com.oua.ocr.core.TextAreaDetectorImpl;
import com.oua.tflite.Config;
import com.oua.util.DebugConfig;

/* loaded from: classes4.dex */
public class BCEnvironment extends OCREnvironment {
    public static final String DICT_NAME = "ocr_dict_text";
    private static OCRManager.Config DefaultConfig = null;
    public static final String RECOGNITION_MODEL_NAME = "ocr_recognition_text_GPU";
    private static final String TAG = "com.oua.ocr.bc.BCEnvironment";

    static {
        Config.Device device = Config.Device.CPU;
        DefaultConfig = new OCRManager.Config(new Config("ocr_textarea_detection.tflite", device, 4), new Config("ocr_detection.tflite", device, 4), new OCRManager.RecognizerConfig(new Config("ocr_recognition_text_GPU.tflite", device, 4), "ocr_dict_text.json"));
    }

    public BCEnvironment() {
        this.packageManager.addFile(DefaultConfig.detecotorModelConfig.modelPath, "cn_en");
        this.packageManager.addFile(DefaultConfig.textAreaDetecotorConfig.modelPath, "cn_en");
        addLanguage(5, "cn_en");
        addLanguage(6, "cn_en");
        addLanguage(11, "cn_en");
        addLanguage(22, "jp_kr");
        addLanguage(23, "jp_kr");
        addLanguage(59, "ru");
        addLanguage(46, "latin");
        addLanguage(47, "latin");
        addLanguage(48, "latin");
        addLanguage(49, "latin");
        addLanguage(50, "latin");
        addLanguage(52, "latin");
        addLanguage(53, "latin");
        addLanguage(54, "latin");
        addLanguage(55, "latin");
        addLanguage(56, "latin");
        addLanguage(61, "latin");
    }

    private void addLanguage(int i10, String str) {
        this.language2Package.put(Integer.valueOf(i10), str);
        OCRManager.RecognizerConfig m8clone = DefaultConfig.recognizerConfig.m8clone();
        m8clone.modelConfig.modelPath = String.format("%s_%s.tflite", RECOGNITION_MODEL_NAME, str);
        m8clone.dictPath = String.format("%s_%s.json", DICT_NAME, str);
        OCRManager.Config config = new OCRManager.Config(DefaultConfig.textAreaDetecotorConfig.m9clone(), DefaultConfig.detecotorModelConfig.m9clone(), m8clone);
        this.package2Config.put(str, config);
        this.packageManager.addPackage(str, getPackageFileName(str));
        this.packageManager.addFile(config.recognizerConfig.modelConfig.modelPath, str);
        this.packageManager.addFile(config.recognizerConfig.dictPath, str);
        if (i10 != 5 && i10 != 6) {
            DebugConfig.logd(TAG, String.format("%d %s", Integer.valueOf(i10), Language.toString(i10)));
            this.packageManager.addFile(String.format("Database_%s.json", Language.toString(i10)), str);
        } else {
            this.packageManager.addFile("Database_Chinese.json", str);
        }
    }

    public static OCRParams getDefaultParams() {
        OCRParams oCRParams = new OCRParams();
        oCRParams.detectTextArea = true;
        oCRParams.detectDirection = true;
        oCRParams.longBoxRatioThold = 7;
        oCRParams.recognizerDirectionCheckCount = 3;
        return oCRParams;
    }

    @Override // com.oua.ocr.core.OCREnvironment
    public OCRManager.Detector createDetector(OCRManager.Config config) {
        return new DetectorImplCV(config);
    }

    @Override // com.oua.ocr.core.OCREnvironment
    public OCRManager.Recognizer createRecognizer(OCRManager.Config config) {
        return new RecognitionImplText(config);
    }

    @Override // com.oua.ocr.core.OCREnvironment
    public OCRManager.TextAreaDetector createTextAreaDetector(OCRManager.Config config) {
        DebugConfig.logd(TAG, "createTextAreaDetector");
        return new TextAreaDetectorImpl(config.textAreaDetecotorConfig);
    }

    @Override // com.oua.ocr.core.OCREnvironment
    public OCRParams defaultParams() {
        return getDefaultParams();
    }

    @Override // com.oua.ocr.core.OCREnvironment
    public String getPackageFileName(String str) {
        return String.format("ocr_bc_%s.oua", str);
    }

    @Override // com.oua.ocr.core.OCREnvironment
    public String getVerifyCode() {
        return "9c35691927ea80c72c181eff297c58a0705a4f87";
    }

    @Override // com.oua.ocr.core.OCREnvironment
    public boolean useNative() {
        return false;
    }
}
