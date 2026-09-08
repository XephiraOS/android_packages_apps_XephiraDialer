package r5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.heytap.accessory.Config;
import com.heytap.accessory.Initializer;
import com.heytap.accessory.api.ManagerConfig;
import com.heytap.accessory.bean.GeneralException;
import com.heytap.accessory.constant.AFConstants;
import n5.C1371a;

/* compiled from: SdkConfig.java */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static int f36288a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static String f36289b = "";

    /* renamed from: c, reason: collision with root package name */
    public static int f36290c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static int f36291d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static int f36292e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static int f36293f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static int f36294g = 1;

    public h(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (!Initializer.useOAFApp()) {
            C1371a.k("SdkConfig", "is not AppMode,ignore");
            return;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(ManagerConfig.ACCESSORY_FRAMEWORK_PACKAGE, 0);
            if (packageInfo != null) {
                f36288a = packageInfo.versionCode;
                f36289b = packageInfo.versionName;
                C1371a.g("SdkConfig", "Accessory Framework: " + packageInfo.versionName + " Accessory SDK: " + Config.getSdkVersionName());
                g();
                return;
            }
            C1371a.d("SdkConfig", "Accessory Framework Not installed");
            throw new GeneralException(2, "Accessory Framework Not installed");
        } catch (PackageManager.NameNotFoundException unused) {
            C1371a.d("SdkConfig", "Accessory Framework Not installed");
            throw new GeneralException(2, "Accessory Framework Not installed");
        }
    }

    public static boolean a(Context context) {
        String packageName = context.getPackageName();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                C1371a.k("SdkConfig", "Package Manager is null");
                return false;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4096);
            if (packageInfo == null) {
                C1371a.k("SdkConfig", "PackageInfo is null");
                return false;
            }
            String[] strArr = packageInfo.requestedPermissions;
            if (strArr == null) {
                return false;
            }
            int i10 = 0;
            while (true) {
                if (i10 >= strArr.length) {
                    break;
                }
                if (AFConstants.PERMISSION_ACCESSORY_FRAMEWORK.equals(strArr[i10])) {
                    if (i10 != -1) {
                        C1371a.g("SdkConfig", "Accessory service permission available for Package" + packageName);
                        return true;
                    }
                } else {
                    i10++;
                }
            }
            C1371a.k("SdkConfig", "Accessory service permission not granted for Package" + packageName);
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            C1371a.d("SdkConfig", "Admin Permission check failed for Package" + packageName);
            return false;
        }
    }

    public static int b() {
        return f36294g;
    }

    public static int c() {
        return f36293f;
    }

    public static int d() {
        return f36291d;
    }

    public static int e() {
        return f36292e;
    }

    public static String f() {
        return "UTF-8";
    }

    public static void g() {
        C1371a.g("SdkConfig", "sdk version: commit id is 3e02c5c time is241202");
    }

    public static void h(int i10) {
        f36294g = i10;
    }

    public static void i(int i10) {
        f36293f = i10;
    }

    public static void j(int i10) {
        f36291d = i10;
    }

    public static void k(int i10) {
        f36292e = i10;
    }

    public static void l(int i10) {
        f36290c = i10;
    }
}
