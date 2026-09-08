package com.oplus.ocs.icdf.utils.logging;

import android.util.Log;

/* loaded from: classes3.dex */
public class ICDFLog {
    private static boolean sDevelopMode = true;
    private static boolean sVerboseMode = false;

    public static void d(String str, String str2) {
        if (sDevelopMode) {
            Log.println(3, str, str2);
        }
    }

    public static void e(String str, String str2) {
        Log.println(6, str, str2);
    }

    public static void enableDevelopMode(boolean z10) {
        sDevelopMode = z10;
    }

    public static void enableVerboseMode(boolean z10) {
        sVerboseMode = z10;
    }

    public static void i(String str, String str2) {
        if (sDevelopMode) {
            Log.println(4, str, str2);
        }
    }

    public static boolean isDevelopMode() {
        return sDevelopMode;
    }

    public static boolean isVerboseMode() {
        return sVerboseMode;
    }

    public static void v(String str, String str2) {
        if (sVerboseMode) {
            Log.println(2, str, str2);
        }
    }

    public static void w(String str, String str2) {
        Log.println(5, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.println(6, str, str2 + Log.getStackTraceString(th));
    }

    public static void w(String str, String str2, Throwable th) {
        Log.println(5, str, str2 + Log.getStackTraceString(th));
    }
}
