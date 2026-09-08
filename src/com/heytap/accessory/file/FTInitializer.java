package com.heytap.accessory.file;

import android.content.Context;
import android.content.pm.PackageManager;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.SdkUnsupportedException;
import n5.C1371a;

/* loaded from: classes3.dex */
public class FTInitializer {
    public static final String FILE_TRANSFER_SERVICE_INTENT = "com.heytap.accessory.IAfFtManager";
    private static final String TAG = "FTInitializer";
    private static boolean sInitialized;

    private FTInitializer() {
    }

    public static String getFileTransferPackageName(Context context) {
        if (Initializer.useOAFApp()) {
            return ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE;
        }
        return context.getPackageName();
    }

    public static void init(Context context) {
        if (!sInitialized) {
            if (!Initializer.useOAFApp()) {
                C1371a.k(TAG, "aar mode, no need to check package info");
                sInitialized = true;
                return;
            }
            try {
                if (context.getPackageManager().getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0) != null) {
                    C1371a.c(TAG, "Accessory File Transfer SDK version: " + Config.getSdkVersionName());
                    sInitialized = true;
                    return;
                }
                throw new SdkUnsupportedException("Accessory Framework not installed", 2);
            } catch (PackageManager.NameNotFoundException unused) {
                C1371a.d(TAG, "Accessory Framework not installed");
                throw new SdkUnsupportedException("Accessory Framework not installed", 2);
            }
        }
    }
}
