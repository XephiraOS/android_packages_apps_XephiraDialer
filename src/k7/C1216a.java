package k7;

import android.app.ActivityManager;
import android.content.Context;
import com.oplus.epona.d;
import com.oplus.utils.C0864z;
import java.util.Iterator;

/* compiled from: PackageUtils.java */
/* renamed from: k7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1216a {
    public static String a(Context context, int i10) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
            while (it.hasNext()) {
                ActivityManager.RunningAppProcessInfo next = it.next();
                try {
                } catch (Exception e10) {
                    C0864z.d("Epona->PackageUtils", "get processName form running app processes exception %s", e10.getMessage());
                }
                if (next.pid == i10) {
                    return c(next);
                }
                continue;
            }
            return "";
        }
        return "";
    }

    public static String b(int i10, int i11) {
        Context g10 = d.g();
        if (g10 == null) {
            return "";
        }
        String[] packagesForUid = g10.getPackageManager().getPackagesForUid(i10);
        if (packagesForUid != null && packagesForUid.length == 1) {
            return packagesForUid[0];
        }
        return a(g10, i11);
    }

    public static String c(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        String[] strArr = runningAppProcessInfo.pkgList;
        if (strArr != null && strArr.length != 0) {
            return strArr[0];
        }
        String str = runningAppProcessInfo.processName;
        if (str.contains(":")) {
            return str.substring(0, str.indexOf(":"));
        }
        return str;
    }
}
