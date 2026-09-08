package com.oua.ocr.core;

import android.content.Context;
import com.oua.ocr.OCR;
import com.oua.ocr.core.OCRPackageManager;
import com.oua.util.DebugConfig;
import com.oua.util.FileUtil;
import com.oua.util.OUAFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* loaded from: classes4.dex */
public class OCRPackageManager {
    private static final String TAG = "com.oua.ocr.core.OCRPackageManager";
    private String verifyCode;
    private String packageFolder = null;
    private Map<String, String> file2Package = new HashMap();
    private Map<String, String> packageName2File = new HashMap();

    /* loaded from: classes4.dex */
    public class FileData<T> {
        public T data;
        public String filePath;

        public FileData(String str, T t10) {
            this.filePath = str;
            this.data = t10;
        }
    }

    /* loaded from: classes4.dex */
    public static class PackageDetail {
        public OUAFile.Header header;
        public OUAFile.Version version;
    }

    private String findPackageFile(String str) {
        String str2 = this.packageName2File.get(str);
        if (str2 != null) {
            if (this.packageFolder == null) {
                return str2;
            }
            String str3 = this.packageFolder + "/" + str2;
            if (new File(str3).exists()) {
                return str3;
            }
            return str2;
        }
        throw new FileNotFoundException(String.format("Cannot find file for package %s!", str2));
    }

    private String findPackageFileForFile(String str) {
        String str2 = this.file2Package.get(str);
        if (str2 != null) {
            return findPackageFile(str2);
        }
        throw new FileNotFoundException(String.format("Cannot find %s! File does not belong to any package!", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getPackageDetails$2(String str) {
        try {
            return findPackageFile(str);
        } catch (Exception e10) {
            return e10.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ PackageDetail lambda$getPackageDetails$3(Context context, String str) {
        try {
            OUAFile loadPackageFile = loadPackageFile(str, context);
            PackageDetail packageDetail = new PackageDetail();
            packageDetail.version = loadPackageFile.getVersion();
            OUAFile.Header header = loadPackageFile.getHeader();
            packageDetail.header = header;
            for (OUAFile.FileEntry fileEntry : header.entryList) {
                fileEntry.name = loadFile(fileEntry.name, context, ByteBuffer.class).filePath;
            }
            return packageDetail;
        } catch (Exception e10) {
            DebugConfig.logd(TAG, "Load package file error!" + e10.toString());
            return new PackageDetail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getPackageFileList$0(String str, Map.Entry entry) {
        return ((String) entry.getValue()).equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getPackageFileList$1(Map.Entry entry) {
        return (String) entry.getKey();
    }

    private <T> FileData<T> loadFromFolder(String str, Class<T> cls) {
        if (this.packageFolder == null) {
            return null;
        }
        String str2 = this.packageFolder + "/" + str;
        if (new File(str2).exists()) {
            DebugConfig.logd(TAG, "load file " + str2);
            try {
                if (cls == ByteBuffer.class) {
                    return new FileData<>(str2, cls.cast(FileUtil.toDirectBuffer(str2)));
                }
                if (cls == String.class) {
                    return new FileData<>(str2, cls.cast(FileUtil.toString(str2)));
                }
            } catch (Exception e10) {
                DebugConfig.logd(TAG, "load from folder error!", e10);
            }
        }
        return null;
    }

    private <T> FileData<T> loadlFromAsset(String str, Context context, Class<T> cls) {
        DebugConfig.logd(TAG, "load from assets " + str);
        if (cls == ByteBuffer.class) {
            return new FileData<>("assets:" + str, cls.cast(FileUtil.toDirectBuffer(str, context)));
        }
        if (cls == String.class) {
            return new FileData<>("assets:" + str, cls.cast(FileUtil.toString(str, context)));
        }
        return null;
    }

    private <T> FileData<T> loadlFromPackageFile(String str, Context context, String str2, Class<T> cls) {
        String str3;
        try {
            str3 = findPackageFileForFile(str);
            try {
                String str4 = TAG;
                DebugConfig.logd(str4, "packageFileName " + str3);
                if (str3 != null) {
                    DebugConfig.logd(str4, String.format("load %s from %s ", str, str3));
                    if (cls == ByteBuffer.class) {
                        return new FileData<>(str3 + ":" + str, cls.cast(OUAFile.file2DirectBuffer(str3, str, context, str2)));
                    }
                    if (cls == String.class) {
                        return new FileData<>(str3 + ":" + str, cls.cast(OUAFile.file2String(str3, str, context, str2)));
                    }
                }
                return null;
            } catch (Exception e10) {
                e = e10;
                DebugConfig.logd(TAG, String.format("Load %s from package file %s error! ", str, str3) + e.toString());
                return null;
            }
        } catch (Exception e11) {
            e = e11;
            str3 = null;
        }
    }

    public void addFile(String str, String str2) {
        this.file2Package.put(str, str2);
    }

    public void addPackage(String str, String str2) {
        this.packageName2File.put(str, str2);
    }

    public Map<String, PackageDetail> getPackageDetails(final Context context) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.file2Package.values());
        return (Map) hashSet.stream().collect(Collectors.toMap(new Function() { // from class: com.oua.ocr.core.Q
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String lambda$getPackageDetails$2;
                lambda$getPackageDetails$2 = OCRPackageManager.this.lambda$getPackageDetails$2((String) obj);
                return lambda$getPackageDetails$2;
            }
        }, new Function() { // from class: com.oua.ocr.core.S
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                OCRPackageManager.PackageDetail lambda$getPackageDetails$3;
                lambda$getPackageDetails$3 = OCRPackageManager.this.lambda$getPackageDetails$3(context, (String) obj);
                return lambda$getPackageDetails$3;
            }
        }));
    }

    public List<String> getPackageFileList(final String str) {
        return (List) this.file2Package.entrySet().stream().filter(new Predicate() { // from class: com.oua.ocr.core.T
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$getPackageFileList$0;
                lambda$getPackageFileList$0 = OCRPackageManager.lambda$getPackageFileList$0(str, (Map.Entry) obj);
                return lambda$getPackageFileList$0;
            }
        }).map(new Function() { // from class: com.oua.ocr.core.U
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                String lambda$getPackageFileList$1;
                lambda$getPackageFileList$1 = OCRPackageManager.lambda$getPackageFileList$1((Map.Entry) obj);
                return lambda$getPackageFileList$1;
            }
        }).collect(Collectors.toList());
    }

    public String getPackageForFile(String str) {
        return this.file2Package.get(str);
    }

    public OCR.LanguagePackageInfo getPackageInfo(String str, Context context) {
        OCR.LanguagePackageInfo languagePackageInfo = new OCR.LanguagePackageInfo();
        OUAFile loadPackageFile = loadPackageFile(str, context);
        OUAFile.Header header = loadPackageFile.getHeader();
        languagePackageInfo.filePath = loadPackageFile.getFilePath();
        languagePackageInfo.timestamp = header.timestamp;
        return languagePackageInfo;
    }

    public <T> FileData<T> loadFile(String str, Context context, Class<T> cls) {
        FileData<T> loadFromFolder = loadFromFolder(str, cls);
        if (loadFromFolder == null && (loadFromFolder = loadlFromPackageFile(str, context, this.verifyCode, cls)) == null && (loadFromFolder = loadlFromAsset(str, context, cls)) == null) {
            DebugConfig.loge(TAG, "cannot find file " + str);
            throw new FileNotFoundException(str);
        }
        return loadFromFolder;
    }

    public OUAFile loadPackageFile(String str, Context context) {
        return new OUAFile(findPackageFile(str), context, this.verifyCode);
    }

    public void setPackageFolder(String str) {
        this.packageFolder = str;
    }

    public void setVerifyCode(String str) {
        this.verifyCode = str;
    }
}
