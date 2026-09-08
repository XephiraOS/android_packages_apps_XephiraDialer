package com.oua.ocr;

import android.content.Context;
import android.graphics.Bitmap;
import com.oua.ocr.ContactInfo;
import com.oua.ocr.OCR;
import com.oua.ocr.bc.BCEnvironment;
import com.oua.ocr.bc.ContactScannerImpl;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface ContactScanner {

    /* loaded from: classes4.dex */
    public static class Result {
        public List<ContactInfo.ContactItem> contactItems;
        public OCR.OCRResult ocrResult;
    }

    static ContactScanner create() {
        return new ContactScannerImpl();
    }

    static OCRParams getDefaultParams() {
        return BCEnvironment.getDefaultParams();
    }

    void close();

    Map<Integer, OCR.LanguagePackageInfo> getAllLanguagePackageInfo(Context context);

    Result getContactInfo(Bitmap bitmap);

    Result getContactInfo(Bitmap bitmap, int[] iArr, OCR.Option option);

    OCR.LanguagePackageInfo getLanguagePackageInfo(Context context, int i10);

    OCR getOCR();

    void init(Context context, String str);

    void init(Context context, int[] iArr, String str);

    void init(Context context, int[] iArr, String str, String str2);

    boolean isInitialized();
}
