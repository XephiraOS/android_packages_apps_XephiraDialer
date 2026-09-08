package com.oua.ocr.core;

import android.content.Context;
import android.text.TextUtils;
import com.oua.ocr.BuildConfig;
import com.oua.ocr.Language;
import com.oua.ocr.OCR;
import com.oua.ocr.OCRParams;
import com.oua.ocr.core.OCRManager;
import com.oua.util.DebugConfig;
import com.oua.util.StringUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class OCREnvironment {
    private static final String TAG = "com.oua.ocr.core.OCREnvironment";
    public Map<Integer, String> language2Package = new HashMap();
    public Map<String, OCRManager.Config> package2Config = new HashMap();
    private boolean verified = false;
    protected OCRParams params = defaultParams();
    public OCRPackageManager packageManager = new OCRPackageManager();

    /* loaded from: classes4.dex */
    public static class SDKInfo {
        public long version;
        public String versionName;

        private SDKInfo() {
        }
    }

    private SDKInfo getSDKInfo(Context context) {
        SDKInfo sDKInfo = new SDKInfo();
        sDKInfo.version = 1L;
        sDKInfo.versionName = BuildConfig.VERSION_NAME;
        return sDKInfo;
    }

    public abstract OCRManager.Detector createDetector(OCRManager.Config config);

    public abstract OCRManager.Recognizer createRecognizer(OCRManager.Config config);

    public OCRManager.TextAreaDetector createTextAreaDetector(OCRManager.Config config) {
        return null;
    }

    public OCRParams defaultParams() {
        return new OCRParams();
    }

    public Map<Integer, OCR.LanguagePackageInfo> getAllLanguagePackageInfo(Context context) {
        HashMap hashMap = new HashMap();
        for (Integer num : Language.LANGUAGE_NAMES.keySet()) {
            hashMap.put(num, getLanguagePackageInfo(context, num.intValue()));
        }
        return hashMap;
    }

    public OCRManager.Config getConfig(int i10) {
        return getConfigForPackage(getLanguagePackage(i10));
    }

    public OCRManager.Config getConfigForPackage(String str) {
        OCRManager.Config config = this.package2Config.get(str);
        if (config == null) {
            DebugConfig.loge(TAG, "cannot find config for  " + str);
            return this.package2Config.get("cn_en");
        }
        return config;
    }

    public String getLanguagePackage(int i10) {
        return this.language2Package.getOrDefault(Integer.valueOf(i10), this.language2Package.get(11));
    }

    public OCR.LanguagePackageInfo getLanguagePackageInfo(Context context, int i10) {
        try {
            return this.packageManager.getPackageInfo(getLanguagePackage(i10), context);
        } catch (Exception unused) {
            return null;
        }
    }

    public abstract String getPackageFileName(String str);

    public OCRParams getParams() {
        return this.params;
    }

    public String getSDKDebugInfo(Context context) {
        if (!isVerified()) {
            return "SDK has not been initialized!";
        }
        return String.format("SDK:\n%s\n\n", StringUtil.toString(getSDKInfo(context))) + String.format("languages:\n%s\n\n", StringUtil.toString(getAllLanguagePackageInfo(context))) + String.format("packages:\n%s\n\n", StringUtil.toString(this.packageManager.getPackageDetails(context)));
    }

    public abstract String getVerifyCode();

    public void init(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            verify(context, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.packageManager.setPackageFolder(str2);
        }
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setParams(OCRParams oCRParams) {
        this.params = oCRParams;
    }

    public boolean useNative() {
        return false;
    }

    public void verify(Context context, String str) {
        StringUtil.encrypt(str + "-" + context.getApplicationContext().getPackageName());
        if (StringUtil.encrypt(str + "-com.android.contacts").equals(getVerifyCode())) {
            this.packageManager.setVerifyCode(str);
            this.verified = true;
            return;
        }
        throw new Exception("The application is not authorized to use the SDK!");
    }
}
