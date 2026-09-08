package f7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import com.oplus.utils.C0864z;

/* compiled from: AppFinder.java */
/* renamed from: f7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1020b {
    public ApplicationInfo a(String str) {
        ApplicationInfo b10;
        Context g10 = com.oplus.epona.d.g();
        if (g10 != null) {
            for (String str2 : d(g10)) {
                ProviderInfo resolveContentProvider = g10.getPackageManager().resolveContentProvider(c(str2), 128);
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
        return str + ".oplus.epona";
    }

    public final String[] d(Context context) {
        try {
            return e(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128), "epona_packages");
        } catch (PackageManager.NameNotFoundException unused) {
            C0864z.d("Epona->AppFinder", "not find application info", new Object[0]);
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
