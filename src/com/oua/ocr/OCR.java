package com.oua.ocr;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public interface OCR {

    /* loaded from: classes4.dex */
    public static class LanguagePackageInfo {
        public String filePath;
        public long timestamp;
    }

    /* loaded from: classes4.dex */
    public static class OCRItem {
        public int id;
        public String text = "";
        public List<Double> probabilities = new ArrayList();
        public List<Point> boundingBox = new ArrayList();
    }

    /* loaded from: classes4.dex */
    public static class OCRResult {
        public int degree;
        public Bitmap textAreaBmp;
        public List<Point> textArea = new ArrayList();
        public List<OCRItem> ocrItems = new ArrayList();
    }

    /* loaded from: classes4.dex */
    public static class Option {
        public boolean cropTextArea = true;
    }

    void close();

    OCRResult detect(Bitmap bitmap);

    OCRResult detect(Bitmap bitmap, int[] iArr);

    OCRResult detectTextArea(Bitmap bitmap);

    OCRParams getOCRParams();

    String getSDKDebugInfo(Context context);

    void init(Context context);

    void init(Context context, int[] iArr);

    void init(Context context, int[] iArr, String str, String str2);

    boolean isInitialized();

    OCRResult recognize(Bitmap bitmap);

    OCRResult recognize(Bitmap bitmap, List<List<Point>> list, int[] iArr);

    OCRResult recognize(Bitmap bitmap, int[] iArr);

    OCRResult run(Bitmap bitmap);

    OCRResult run(Bitmap bitmap, int[] iArr, Option option);

    void setDebugLevel(int i10, String str);

    void setOCRParams(OCRParams oCRParams);
}
