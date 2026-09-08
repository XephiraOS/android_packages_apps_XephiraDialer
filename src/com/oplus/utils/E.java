package com.oplus.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.ActionBar;
import com.coui.appcompat.toolbar.COUIToolbar;

/* compiled from: NavigateUtils.java */
/* loaded from: classes3.dex */
public class E {
    public static void a(Intent intent, int i10, String str) {
        if (i10 > 0) {
            intent.putExtra("navigate_title_id", i10);
            intent.putExtra("navigate_parent_package", str);
        }
    }

    public static String b(Context context, Intent intent) {
        Context context2;
        if (context != null && intent != null) {
            int b10 = C0863y.b(intent, "navigate_title_id", 0);
            C0846g.i("NavigateUtils", "getContentDescriptonById: id = " + b10);
            if (b10 > 0) {
                String d10 = C0863y.d(intent, "navigate_parent_package");
                if (!TextUtils.isEmpty(d10) && !d10.equals(context.getPackageName())) {
                    try {
                        context2 = context.createPackageContext(d10, 3);
                    } catch (PackageManager.NameNotFoundException e10) {
                        Log.d("NavigateUtils", "com.android.contacts NameNotFoundException" + e10);
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

    public static void c(Context context, ActionBar actionBar, COUIToolbar cOUIToolbar, Intent intent) {
        if (intent != null && actionBar != null && cOUIToolbar != null) {
            String b10 = b(context, intent);
            if (TextUtils.isEmpty(b10)) {
                b10 = C0863y.d(intent, "navigate_title_text");
            }
            Log.i("NavigateUtils", "contentDescripton " + b10);
            if (!TextUtils.isEmpty(b10)) {
                cOUIToolbar.setTitle(b10);
                return;
            } else {
                actionBar.t(false);
                return;
            }
        }
        Log.i("NavigateUtils", "intent or action bar is null");
    }
}
