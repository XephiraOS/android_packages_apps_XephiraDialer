package com.heytap.accessory;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.bean.SdkUnsupportedException;
import java.lang.reflect.InvocationTargetException;
import n5.C1371a;
import r5.h;

/* loaded from: classes3.dex */
public class Initializer {
    private static final String FW_SERVICE = "com.heytap.accessory.action.FRAMEWORK_MANAGER";
    private static final String INIT_CLASS = "com.heytap.accessory.platform.FrameworkInitializer";
    private static final String INIT_METHOD = "init";
    private static final int OAF_FEATURE_11_2_SUPPORT_WATCH_VERION = 20214;
    private static final int OAF_FEATURE_11_3_MIN_VERION = 20300;
    private static final int OAF_FEATURE_11_3_SUPPORT_WATCH_VERION = 20307;
    private static final int OAF_FEATURE_12_SUPPORT_WATCH_VERION = 20400;
    public static final int SDK_INTEGRATOR_ROLE_AF = 1;
    public static final int SDK_INTEGRATOR_ROLE_APP = 0;
    private static final String TAG = "Initializer";
    private static h mSdkConfig = null;
    private static Context sContext = null;
    private static int sOAFSdkVersion = 0;
    private static boolean sUseOAFApp = true;

    private Initializer() {
    }

    public static void clearSdkConfig() {
        if (mSdkConfig != null) {
            mSdkConfig = null;
        }
    }

    public static Context getContext() {
        return sContext;
    }

    public static int getOAFVersion() {
        return sOAFSdkVersion;
    }

    public static int getSdkIntegratorRole() {
        if (sContext == null) {
            return 0;
        }
        if (useOAFApp() && !ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE.equals(sContext.getPackageName())) {
            return 0;
        }
        return 1;
    }

    public static void initAFMAccessory(Context context) {
        int i10;
        if (!useOAFApp()) {
            C1371a.k(TAG, "is not AppMode,ignore");
            return;
        }
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0);
                if (packageInfo == null) {
                    i10 = -1;
                } else {
                    i10 = packageInfo.versionCode;
                }
                C1371a.g(TAG, "AF version: " + i10);
                return;
            } catch (PackageManager.NameNotFoundException unused) {
                C1371a.d(TAG, "AF not installed");
                throw new SdkUnsupportedException("AF not installed", 2);
            }
        }
        throw new IllegalArgumentException("Illegal argument: context");
    }

    public static void initBufferPool(Context context) {
        if (context != null) {
            if (mSdkConfig == null) {
                try {
                    mSdkConfig = new h(context);
                    C1371a.c(TAG, "Initializing AF");
                    s5.b.b(context);
                    return;
                } catch (GeneralException e10) {
                    throw new SdkUnsupportedException(e10.getMessage(), e10.getErrorCode());
                }
            }
            return;
        }
        throw new IllegalArgumentException("Illegal argument: context");
    }

    public static void initContext(Context context) {
        sContext = context.getApplicationContext();
    }

    public static void initFramework(Context context, boolean z10) {
        C1371a.g(TAG, context.getPackageName() + " is " + z10);
        if (z10) {
            return;
        }
        sContext = context.getApplicationContext();
        sUseOAFApp = z10;
        try {
            Class<?> cls = Class.forName(INIT_CLASS);
            cls.getDeclaredMethod(INIT_METHOD, Context.class).invoke(cls, sContext);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            e10.printStackTrace();
        }
    }

    public static void setOAFSdkVersion(int i10) {
        sOAFSdkVersion = i10;
    }

    public static boolean useOAFApp() {
        return sUseOAFApp;
    }

    public static boolean useSystemOAF4Watch(Context context) {
        boolean z10;
        try {
            int i10 = context.getPackageManager().getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0).versionCode;
            if ((i10 > OAF_FEATURE_11_2_SUPPORT_WATCH_VERION && i10 < OAF_FEATURE_11_3_MIN_VERION) || i10 >= OAF_FEATURE_11_3_SUPPORT_WATCH_VERION) {
                z10 = true;
            } else {
                z10 = false;
            }
            C1371a.g(TAG, "useSystemOAF: versionCode=" + i10 + " support=" + z10);
            return z10;
        } catch (PackageManager.NameNotFoundException unused) {
            C1371a.k(TAG, "useSystemOAF: not find OAF");
            return false;
        }
    }
}
