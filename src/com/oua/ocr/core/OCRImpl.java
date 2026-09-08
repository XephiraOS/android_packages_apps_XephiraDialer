package com.oua.ocr.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.oua.ocr.OCR;
import com.oua.ocr.OCRParams;
import com.oua.util.DebugConfig;
import java.util.List;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public class OCRImpl implements OCR {
    private static final String TAG = "com.oua.ocr.core.OCRImpl";
    OCREnvironment ocrEnvironment;
    OCRManager ocrManager;

    public OCRImpl(OCREnvironment oCREnvironment) {
        this.ocrEnvironment = oCREnvironment;
    }

    @Override // com.oua.ocr.OCR
    public void close() {
        OCRManager oCRManager = this.ocrManager;
        if (oCRManager != null) {
            oCRManager.close();
            this.ocrManager = null;
        }
    }

    @Override // com.oua.ocr.OCR
    public OCR.OCRResult detect(Bitmap bitmap, int[] iArr) {
        if (isInitialized()) {
            return this.ocrManager.run(bitmap, (getOCRParams().detectTextArea ? 1 : 0) | 2, null, null, iArr);
        }
        throw new RuntimeException("ocr has not not been initialized!");
    }

    @Override // com.oua.ocr.OCR
    public OCR.OCRResult detectTextArea(Bitmap bitmap) {
        if (isInitialized()) {
            return this.ocrManager.detectTextArea(bitmap);
        }
        throw new RuntimeException("ocr has not not been initialized!");
    }

    @Override // com.oua.ocr.OCR
    public OCRParams getOCRParams() {
        return this.ocrEnvironment.getParams();
    }

    @Override // com.oua.ocr.OCR
    public String getSDKDebugInfo(Context context) {
        return this.ocrEnvironment.getSDKDebugInfo(context);
    }

    @Override // com.oua.ocr.OCR
    public void init(Context context) {
        init(context, new int[]{5, 6, 11});
    }

    @Override // com.oua.ocr.OCR
    public boolean isInitialized() {
        if (this.ocrManager != null) {
            return true;
        }
        return false;
    }

    @Override // com.oua.ocr.OCR
    public OCR.OCRResult recognize(Bitmap bitmap, int[] iArr) {
        return recognize(bitmap, null, iArr);
    }

    @Override // com.oua.ocr.OCR
    public OCR.OCRResult run(Bitmap bitmap) {
        return run(bitmap, null, null);
    }

    @Override // com.oua.ocr.OCR
    public void setDebugLevel(int i10, String str) {
        DebugConfig.setDebugLevel(i10, str);
        OCRNative.setDebugLevel(i10, str);
    }

    @Override // com.oua.ocr.OCR
    public void setOCRParams(OCRParams oCRParams) {
        this.ocrEnvironment.setParams(oCRParams);
    }

    @Override // com.oua.ocr.OCR
    public void init(Context context, int[] iArr) {
        init(context, iArr, null, null);
    }

    @Override // com.oua.ocr.OCR
    public OCR.OCRResult recognize(Bitmap bitmap) {
        return recognize(bitmap, null);
    }

    @Override // com.oua.ocr.OCR
    public OCR.OCRResult run(Bitmap bitmap, int[] iArr, OCR.Option option) {
        if (isInitialized()) {
            return this.ocrManager.run(bitmap, (getOCRParams().detectTextArea ? 1 : 0) | 6, option, null, iArr);
        }
        throw new RuntimeException("ocr has not not been initialized!");
    }

    @Override // com.oua.ocr.OCR
    public void init(Context context, int[] iArr, String str, String str2) {
        DebugConfig.logd(TAG, "init");
        OCRManager oCRManager = new OCRManager(this.ocrEnvironment);
        this.ocrManager = oCRManager;
        oCRManager.init(context, iArr, str, str2);
    }

    @Override // com.oua.ocr.OCR
    public OCR.OCRResult recognize(Bitmap bitmap, List<List<Point>> list, int[] iArr) {
        if (isInitialized()) {
            return this.ocrManager.run(bitmap, 4, null, list, iArr);
        }
        throw new RuntimeException("ocr has not not been initialized!");
    }

    @Override // com.oua.ocr.OCR
    public OCR.OCRResult detect(Bitmap bitmap) {
        if (isInitialized()) {
            return detect(bitmap, null);
        }
        throw new RuntimeException("ocr has not not been initialized!");
    }
}
