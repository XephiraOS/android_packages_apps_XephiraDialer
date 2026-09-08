package v6;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0863y;

/* compiled from: NavigateUtils.java */
/* renamed from: v6.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1633g {
    public static String a(Context context, Intent intent) {
        Context context2;
        if (context != null && intent != null) {
            int b10 = C0863y.b(intent, "navigate_title_id", 0);
            C0846g.i("NavigateUtils", "getContentDescriptonById: id = " + b10);
            if (b10 != 0) {
                String d10 = C0863y.d(intent, "navigate_parent_package");
                if (!TextUtils.isEmpty(d10) && !d10.equals(context.getPackageName())) {
                    try {
                        context2 = context.createPackageContext(d10, 3);
                    } catch (PackageManager.NameNotFoundException unused) {
                        context2 = null;
                    }
                    if (context2 != null) {
                        return context2.getResources().getString(b10);
                    }
                } else {
                    return context.getResources().getString(b10);
                }
            }
        }
        return null;
    }

    public static String b(Context context, Intent intent) {
        if (context != null && intent != null) {
            String d10 = C0863y.d(intent, "navigate_title_text");
            if (TextUtils.isEmpty(d10)) {
                d10 = a(context, intent);
            }
            Log.i("NavigateUtils", "contentDescripton " + d10);
            return d10;
        }
        Log.i("NavigateUtils", "context or intent is null");
        return null;
    }
}
