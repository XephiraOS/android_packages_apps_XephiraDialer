package com.coui.appcompat.log;

import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class COUILog {
    private static final String COUI_LOG_FLAG = "COUI";
    public static final int LEVEL_ASSERT = 7;
    public static final int LEVEL_DEBUG = 3;
    public static final int LEVEL_ERROR = 6;
    public static final int LEVEL_INFO = 4;
    public static final int LEVEL_SILENT = Integer.MAX_VALUE;
    public static final int LEVEL_VERBOSE = 2;
    public static final int LEVEL_WARN = 5;
    public static final boolean LOG_ASSERT;
    public static final boolean LOG_DEBUG;
    public static final boolean LOG_ERROR;
    public static final boolean LOG_INFO;
    private static int LOG_LEVEL = 0;
    public static final boolean LOG_SILENT;
    public static final boolean LOG_VERBOSE;
    public static final boolean LOG_WARN;
    private static final String STACK_TAG = "StackTrace";
    private static final boolean STACK_TRACE = false;
    private static Boolean isColorOS;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface COUILogLevel {
    }

    static {
        boolean z10;
        boolean isLoggable = isLoggable(COUI_LOG_FLAG, 2);
        LOG_VERBOSE = isLoggable;
        boolean isLoggable2 = isLoggable(COUI_LOG_FLAG, 3);
        LOG_DEBUG = isLoggable2;
        boolean isLoggable3 = isLoggable(COUI_LOG_FLAG, 4);
        LOG_INFO = isLoggable3;
        boolean isLoggable4 = isLoggable(COUI_LOG_FLAG, 5);
        LOG_WARN = isLoggable4;
        boolean isLoggable5 = isLoggable(COUI_LOG_FLAG, 6);
        LOG_ERROR = isLoggable5;
        boolean isLoggable6 = isLoggable(COUI_LOG_FLAG, 7);
        LOG_ASSERT = isLoggable6;
        if (!isLoggable && !isLoggable2 && !isLoggable3 && !isLoggable4 && !isLoggable5 && !isLoggable6) {
            z10 = true;
        } else {
            z10 = false;
        }
        LOG_SILENT = z10;
        isColorOS = null;
        LOG_LEVEL = 4;
    }

    public static void d(String str, String str2) {
        if (LOG_LEVEL <= 3 || Log.isLoggable(str, 3) || LOG_DEBUG) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (LOG_LEVEL <= 6 || Log.isLoggable(str, 6) || LOG_ERROR) {
            Log.e(str, str2);
        }
    }

    public static int getCOUILogLevel() {
        return LOG_LEVEL;
    }

    public static void i(String str, String str2) {
        if (LOG_LEVEL <= 4 || Log.isLoggable(str, 4) || LOG_INFO) {
            Log.i(str, str2);
        }
    }

    public static boolean isLoggable(String str, int i10) {
        return Log.isLoggable(str, i10);
    }

    public static void logStatus(String str) {
        boolean isLoggable = str.equals(COUI_LOG_FLAG) ? LOG_VERBOSE : Log.isLoggable(str, 2);
        boolean isLoggable2 = str.equals(COUI_LOG_FLAG) ? LOG_DEBUG : Log.isLoggable(str, 3);
        boolean isLoggable3 = str.equals(COUI_LOG_FLAG) ? LOG_INFO : Log.isLoggable(str, 2);
        boolean isLoggable4 = str.equals(COUI_LOG_FLAG) ? LOG_WARN : Log.isLoggable(str, 2);
        boolean isLoggable5 = str.equals(COUI_LOG_FLAG) ? LOG_ERROR : Log.isLoggable(str, 2);
        boolean isLoggable6 = str.equals(COUI_LOG_FLAG) ? LOG_ASSERT : Log.isLoggable(str, 2);
        Log.println(7, COUI_LOG_FLAG, "Log status for tag: " + str + "\nVERBOSE: " + isLoggable + "\nDEBUG: " + isLoggable2 + "\nINFO: " + isLoggable3 + "\nWARN: " + isLoggable4 + "\nERROR: " + isLoggable5 + "\nASSERT: " + isLoggable6 + "\nSILENT: " + (str.equals(COUI_LOG_FLAG) ? LOG_SILENT : (isLoggable || isLoggable2 || isLoggable3 || isLoggable4 || isLoggable5 || isLoggable6) ? false : true));
    }

    public static void setCOUILogLevel(int i10) {
        LOG_LEVEL = i10;
    }

    public static void v(String str, String str2) {
        if (LOG_LEVEL <= 2 || Log.isLoggable(str, 2) || LOG_VERBOSE) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (LOG_LEVEL <= 5 || Log.isLoggable(str, 5) || LOG_WARN) {
            Log.w(str, str2);
        }
    }

    public static void wtf(String str, String str2) {
        Log.wtf(str, str2);
    }

    public static void wtf(boolean z10, String str, String str2) {
        if (z10) {
            Log.wtf(str, str2);
        }
    }

    public static void d(boolean z10, String str, String str2) {
        if (z10) {
            Log.d(str, str2);
        }
    }

    public static void e(boolean z10, String str, String str2) {
        if (z10) {
            Log.e(str, str2);
        }
    }

    public static void i(boolean z10, String str, String str2) {
        if (z10) {
            Log.i(str, str2);
        }
    }

    public static void v(boolean z10, String str, String str2) {
        if (z10) {
            Log.v(str, str2);
        }
    }

    public static void w(boolean z10, String str, String str2) {
        if (z10) {
            Log.w(str, str2);
        }
    }

    public static void wtf(String str, Throwable th) {
        Log.wtf(str, th);
    }

    public static void d(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        Log.v(str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    public static void wtf(boolean z10, String str, Throwable th) {
        if (z10) {
            Log.wtf(str, th);
        }
    }

    public static void d(boolean z10, String str, String str2, Throwable th) {
        if (z10) {
            Log.d(str, str2, th);
        }
    }

    public static void e(boolean z10, String str, String str2, Throwable th) {
        if (z10) {
            Log.e(str, str2, th);
        }
    }

    public static void i(boolean z10, String str, String str2, Throwable th) {
        if (z10) {
            Log.i(str, str2, th);
        }
    }

    public static void v(boolean z10, String str, String str2, Throwable th) {
        if (z10) {
            Log.v(str, str2, th);
        }
    }

    public static void w(boolean z10, String str, String str2, Throwable th) {
        if (z10) {
            Log.w(str, str2, th);
        }
    }

    public static void logStatus() {
        logStatus(COUI_LOG_FLAG);
    }

    public static void printStackTrace(StackTraceElement[] stackTraceElementArr, String str, boolean z10) {
    }
}
