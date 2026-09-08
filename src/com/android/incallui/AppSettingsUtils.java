package com.android.incallui;

import android.content.Context;
import android.net.Uri;

/* compiled from: AppSettingsUtils.kt */
/* loaded from: classes.dex */
public final class AppSettingsUtils {
    public static final AppSettingsUtils INSTANCE = new AppSettingsUtils();

    private AppSettingsUtils() {
    }

    public static final Uri globalGetUriFor(String str) {
        return null;
    }

    public static final String systemGetString(Context context, String str) {
        return "";
    }

    public static final int globalGetInt(Context context, String str, int i10) {
        return i10;
    }

    public static final void globalPutInt(Context context, String str, int i10) {
    }

    public static final int secureGetInt(Context context, String str, int i10) {
        return i10;
    }

    public static final void securePutInt(Context context, String str, int i10) {
    }

    public static final int systemGetInt(Context context, String str, int i10) {
        return i10;
    }
}
