package com.oua.ocr.bc;

import android.content.Context;
import android.graphics.Bitmap;
import com.oua.ocr.ContactScanner;
import com.oua.ocr.OCR;
import com.oua.ocr.bc.libBCREngine;
import com.oua.ocr.core.OCREnvironment;
import com.oua.ocr.core.OCRImpl;
import com.oua.util.DebugConfig;
import com.oua.util.SimpleTrace;
import com.oua.util.StringUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import org.opencv.core.Point;

/* loaded from: classes4.dex */
public class ContactScannerImpl implements ContactScanner {
    private static final String TAG = "com.oua.ocr.bc.ContactScannerImpl";
    private Context context;
    private boolean isInit = false;
    private OCREnvironment env = new BCEnvironment();
    public OCR ocr = new OCRImpl(this.env);

    private void initBCREngine(final Context context, int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            libBCREngine.init((List) Arrays.stream(iArr).mapToObj(new IntFunction() { // from class: com.oua.ocr.bc.i
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    Integer valueOf;
                    valueOf = Integer.valueOf(i10);
                    return valueOf;
                }
            }).collect(Collectors.toList()), new libBCREngine.FileLoader() { // from class: com.oua.ocr.bc.j
                @Override // com.oua.ocr.bc.libBCREngine.FileLoader
                public final String read(String str) {
                    String lambda$initBCREngine$1;
                    lambda$initBCREngine$1 = ContactScannerImpl.this.lambda$initBCREngine$1(context, str);
                    return lambda$initBCREngine$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int[] lambda$getContactInfo$2(Point point) {
        return new int[]{(int) point.f35882x, (int) point.f35883y};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int[][] lambda$getContactInfo$3(int i10) {
        return new int[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BBox lambda$getContactInfo$4(OCR.OCRItem oCRItem) {
        BBox bBox = new BBox();
        bBox.text = oCRItem.text;
        bBox.f29375c = (int[][]) oCRItem.boundingBox.stream().map(new Function() { // from class: com.oua.ocr.bc.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int[] lambda$getContactInfo$2;
                lambda$getContactInfo$2 = ContactScannerImpl.lambda$getContactInfo$2((Point) obj);
                return lambda$getContactInfo$2;
            }
        }).toArray(new IntFunction() { // from class: com.oua.ocr.bc.g
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                int[][] lambda$getContactInfo$3;
                lambda$getContactInfo$3 = ContactScannerImpl.lambda$getContactInfo$3(i10);
                return lambda$getContactInfo$3;
            }
        });
        return bBox;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ String lambda$initBCREngine$1(Context context, String str) {
        try {
            return (String) this.env.packageManager.loadFile(str, context, String.class).data;
        } catch (Exception e10) {
            e10.printStackTrace();
            throw new RuntimeException(e10);
        }
    }

    @Override // com.oua.ocr.ContactScanner
    public void close() {
        String str = TAG;
        DebugConfig.logi(str, "close");
        if (!this.isInit) {
            DebugConfig.logd(str, "ContactScanner has not not been initialized!");
        } else {
            this.ocr.close();
        }
    }

    @Override // com.oua.ocr.ContactScanner
    public Map<Integer, OCR.LanguagePackageInfo> getAllLanguagePackageInfo(Context context) {
        return this.env.getAllLanguagePackageInfo(context);
    }

    @Override // com.oua.ocr.ContactScanner
    public ContactScanner.Result getContactInfo(Bitmap bitmap, int[] iArr, OCR.Option option) {
        SimpleTrace trace = SimpleTrace.getTrace();
        String str = TAG;
        trace.startSection("getContactInfo", str);
        if (this.isInit) {
            if (iArr == null) {
                iArr = new int[]{5, 11};
            }
            DebugConfig.logd(str, "getContactInfo " + StringUtil.toString(iArr));
            initBCREngine(this.context, iArr);
            ContactScanner.Result result = new ContactScanner.Result();
            result.ocrResult = this.ocr.run(bitmap, iArr, option);
            SimpleTrace.getTrace().addEvent("ocr");
            result.contactItems = libBCREngine.getContactInfo((List) result.ocrResult.ocrItems.stream().map(new Function() { // from class: com.oua.ocr.bc.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    BBox lambda$getContactInfo$4;
                    lambda$getContactInfo$4 = ContactScannerImpl.lambda$getContactInfo$4((OCR.OCRItem) obj);
                    return lambda$getContactInfo$4;
                }
            }).collect(Collectors.toList())).items;
            DebugConfig.logd(str, "result:", result);
            SimpleTrace.getTrace().addEvent("extra_fields");
            SimpleTrace.getTrace().endSection("getContactInfo");
            return result;
        }
        throw new RuntimeException("ContactScanner has not not been initialized!");
    }

    @Override // com.oua.ocr.ContactScanner
    public OCR.LanguagePackageInfo getLanguagePackageInfo(Context context, int i10) {
        return this.env.getLanguagePackageInfo(context, i10);
    }

    @Override // com.oua.ocr.ContactScanner
    public OCR getOCR() {
        return this.ocr;
    }

    @Override // com.oua.ocr.ContactScanner
    public void init(Context context, String str) {
        init(context, null, str, null);
    }

    @Override // com.oua.ocr.ContactScanner
    public boolean isInitialized() {
        return this.ocr.isInitialized();
    }

    @Override // com.oua.ocr.ContactScanner
    public void init(Context context, int[] iArr, String str) {
        init(context, iArr, str, null);
    }

    @Override // com.oua.ocr.ContactScanner
    public void init(Context context, int[] iArr, String str, String str2) {
        SimpleTrace.getTrace().startSection("init", TAG);
        this.context = context;
        if (iArr == null) {
            iArr = new int[]{5, 6, 11};
        }
        this.ocr.init(context, iArr, str, str2);
        SimpleTrace.getTrace().addEvent("init_ocr");
        initBCREngine(context, iArr);
        SimpleTrace.getTrace().addEvent("init_bc");
        this.isInit = true;
        SimpleTrace.getTrace().endSection("init");
    }

    @Override // com.oua.ocr.ContactScanner
    public ContactScanner.Result getContactInfo(Bitmap bitmap) {
        return getContactInfo(bitmap, null, null);
    }
}
