package com.android.incallui;

import android.content.Context;
import android.text.TextUtils;
import com.internal_dependency.InternalSdkDepends;
import com.internal_dependency.SettingsUtils;

/* loaded from: classes.dex */
public class Log {
    private static final String SEPARATOR = " - ";
    public static final String TAG = "InCall";
    public static final String TAG_DELIMETER = " - ";
    public static boolean sDebug = false;
    public static boolean sInfo = false;
    public static boolean sOplusDebug = false;
    public static boolean sOplusPanic = false;
    public static boolean sOplusPhoneLogSwitch = false;
    public static boolean sSystraceDebug;
    public static boolean sVerbose;

    static {
        boolean booleanSystemProperties = InternalSdkDepends.getSInstance().getBooleanSystemProperties("persist.sys.assert.panic", false);
        sOplusPanic = booleanSystemProperties;
        sSystraceDebug = booleanSystemProperties;
        sDebug = booleanSystemProperties;
        sVerbose = booleanSystemProperties;
        sInfo = booleanSystemProperties;
        sOplusDebug = false;
    }

    public static void d(String str, String str2) {
        if (sDebug) {
            android.util.Log.d(TAG, delimit(str) + str2);
        }
    }

    private static String delimit(String str) {
        return str + " - ";
    }

    public static void e(String str, String str2, Exception exc) {
        android.util.Log.e(TAG, delimit(str) + str2, exc);
    }

    private static String getPrefix(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.getClass().getSimpleName() + " - ";
    }

    public static void i(String str, String str2) {
        if (sInfo) {
            android.util.Log.i(TAG, delimit(str) + str2);
        }
    }

    public static void oplusRefreshLogSwitch(Context context) {
        boolean z10;
        if (context == null) {
            return;
        }
        boolean z11 = false;
        if (SettingsUtils.INSTANCE.getSystemSettingsInt(context.getContentResolver(), "phone.log.switch", 0) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        sOplusPhoneLogSwitch = z10;
        boolean booleanSystemProperties = InternalSdkDepends.getSInstance().getBooleanSystemProperties("persist.sys.assert.panic", false);
        sOplusPanic = booleanSystemProperties;
        boolean z12 = sOplusPhoneLogSwitch;
        if (z12 || booleanSystemProperties) {
            z11 = true;
        }
        sDebug = z11;
        sSystraceDebug = z11;
        sVerbose = z11;
        sInfo = z11;
        sOplusDebug = z12;
    }

    private static void println(int i10, String str, String str2, String str3, Object... objArr) {
        boolean z10;
        if (objArr != null && objArr.length <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (i10 >= 4 || android.util.Log.isLoggable(str, i10)) {
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(" - ");
                if (z10) {
                    str3 = String.format(str3, objArr);
                }
                sb.append(str3);
                str2 = sb.toString();
            }
            android.util.Log.println(i10, str, str2);
        }
    }

    public static void v(Object obj, String str) {
        if (sVerbose) {
            android.util.Log.v(TAG, getPrefix(obj) + str);
        }
    }

    public static void w(Object obj, String str) {
        android.util.Log.w(TAG, getPrefix(obj) + str);
    }

    public static void wtf(Object obj, String str) {
        android.util.Log.wtf(TAG, getPrefix(obj) + str);
    }

    public static void e(String str, String str2) {
        android.util.Log.e(TAG, delimit(str) + str2);
    }

    public static void d(Object obj, String str) {
        if (sDebug) {
            android.util.Log.d(TAG, getPrefix(obj) + str);
        }
    }

    public static void e(Object obj, String str, Exception exc) {
        android.util.Log.e(TAG, getPrefix(obj) + str, exc);
    }

    public static void i(Object obj, String str) {
        if (sInfo) {
            android.util.Log.i(TAG, getPrefix(obj) + str);
        }
    }

    public static void v(Object obj, String str, Object obj2) {
        if (sVerbose) {
            android.util.Log.d(TAG, getPrefix(obj) + str + obj2);
        }
    }

    public static void e(Object obj, String str) {
        android.util.Log.e(TAG, getPrefix(obj) + str);
    }

    public static void d(Object obj, String str, Object obj2) {
        if (sDebug) {
            android.util.Log.d(TAG, getPrefix(obj) + str + obj2);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        println(4, TAG, str, str2, objArr);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, TAG, str, str2, objArr);
    }
}
