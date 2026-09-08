package C5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Bundle;

/* compiled from: AppFinder.java */
/* loaded from: classes3.dex */
public class b {
    public ApplicationInfo a(String str) {
        ApplicationInfo b10;
        Context f10 = com.heytap.epona.c.f();
        if (f10 != null) {
            for (String str2 : d(f10)) {
                ProviderInfo resolveContentProvider = f10.getPackageManager().resolveContentProvider(c(str2), 128);
                if (resolveContentProvider != null && (b10 = b(str, resolveContentProvider)) != null) {
                    return b10;
                }
            }
            return null;
        }
        return null;
    }

    public final ApplicationInfo b(String str, ProviderInfo providerInfo) {
        ApplicationInfo applicationInfo = providerInfo.applicationInfo;
        for (String str2 : e(applicationInfo, "epona_components")) {
            if (str2.trim().equals(str)) {
                return applicationInfo;
            }
        }
        return null;
    }

    public final String c(String str) {
        return str + ".epona";
    }

    public final String[] d(Context context) {
        try {
            return e(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128), "epona_packages");
        } catch (PackageManager.NameNotFoundException unused) {
            H5.a.c("AppFinder", "not find application info", new Object[0]);
            return new String[0];
        }
    }

    public final String[] e(ApplicationInfo applicationInfo, String str) {
        String[] strArr = new String[0];
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null) {
            return strArr;
        }
        String string = bundle.getString(str);
        if (string == null) {
            return strArr;
        }
        return string.split("\\|");
    }
}
