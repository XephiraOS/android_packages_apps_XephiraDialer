package r5;

import android.content.Context;
import android.content.pm.PackageManager;
import n5.C1371a;

/* compiled from: PackageUtils.java */
/* loaded from: classes3.dex */
public class g {
    public static int a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).uid;
        } catch (PackageManager.NameNotFoundException e10) {
            C1371a.k("PackageUtils", "getUid failed:" + e10);
            return 0;
        }
    }
}
