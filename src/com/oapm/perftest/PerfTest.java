package com.oapm.perftest;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes3.dex */
public class PerfTest {
    public static String getDuid() {
        return "NULL";
    }

    @Deprecated
    public static boolean isInAnalyzerProcess(Context context) {
        return false;
    }

    public static boolean isOapmProcess(Context context) {
        return false;
    }

    public static boolean isOnline() {
        return false;
    }

    public static void stopFrameScene() {
    }

    public static void uploadHprof() {
    }

    public static void addSQLiteConcernDB(SQLiteDatabase sQLiteDatabase) {
    }

    public static void beginDefinedStartup(String str) {
    }

    public static void endDefinedStartup(String str) {
    }

    public static void leakWatch(Object obj) {
    }

    public static void markNativeLeakScene(String str) {
    }

    public static void setBlockThreshold(int i10) {
    }

    public static void setNetRequestEnable(boolean z10) {
    }

    public static void startBatteryCheck(int i10) {
    }

    public static void startFrameScene(String str) {
    }

    public static void stopBatteryCheck(int i10) {
    }

    public static void loadEnd(String str, int i10) {
    }

    public static void loadStart(String str, int i10) {
    }

    public static void initOApm(Application application, String str, String str2, String str3, int i10) {
    }
}
