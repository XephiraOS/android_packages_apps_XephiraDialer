package D2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.incallui.Log;

/* compiled from: OplusMetaDataUtils.java */
/* loaded from: classes.dex */
public class h {
    public static boolean a(Context context, String str, String str2, String str3) {
        Bundle bundle;
        boolean z10 = false;
        if (context == null) {
            Log.i("OplusMetaDataUtils", "hasMetaData, context is null, return false");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                z10 = TextUtils.equals(String.valueOf(bundle.get(str2)), str3);
            }
        } catch (PackageManager.NameNotFoundException e10) {
            Log.i("OplusMetaDataUtils", "hasMetaData, e = " + e10.toString());
        }
        if (Log.sDebug) {
            Log.d("OplusMetaDataUtils", "hasMetaData, hasMeta = " + z10 + ", metaDataName = " + str2);
        }
        return z10;
    }
}
