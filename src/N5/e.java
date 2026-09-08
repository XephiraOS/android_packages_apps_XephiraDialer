package N5;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: PackageUtils.java */
/* loaded from: classes3.dex */
public class e {
    public static String a(Context context, int i10) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str = "";
        if (activityManager != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                try {
                    if (runningAppProcessInfo.pid == i10) {
                        String[] strArr = runningAppProcessInfo.pkgList;
                        if (strArr != null && strArr.length != 0) {
                            str = strArr[0];
                        } else {
                            str = runningAppProcessInfo.processName;
                            if (str.contains(":")) {
                                str = str.substring(0, str.indexOf(":"));
                            }
                        }
                    }
                } catch (Exception e10) {
                    d.c("get exception " + e10.getMessage());
                }
            }
        }
        return str;
    }

    public static String b(Context context, String str) {
        String e10 = e(context, str, "AppPlatformKey");
        if (TextUtils.isEmpty(e10)) {
            d.b("Start to get AppPlatformCode.");
            return e(context, str, "AppPlatformCode");
        }
        return e10;
    }

    public static String c(Context context, int i10, int i11) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid != null && packagesForUid.length == 1) {
            return packagesForUid[0];
        }
        return a(context, i11);
    }

    public static int d(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).uid;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static String e(Context context, String str, String str2) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            if (bundle != null && bundle.containsKey(str2)) {
                return bundle.getString(str2);
            }
            return "";
        } catch (PackageManager.NameNotFoundException e10) {
            d.c("Unable to fetch metadata from teh manifest " + e10.getMessage());
            throw new RuntimeException("Unable to fetch metadata from teh manifest", e10);
        }
    }
}
