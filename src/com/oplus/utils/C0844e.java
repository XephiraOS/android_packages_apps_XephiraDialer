package com.oplus.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import v6.C1629c;

/* compiled from: BlackListAppUtils.java */
/* renamed from: com.oplus.utils.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0844e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f29133a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f29134b;

    /* renamed from: c, reason: collision with root package name */
    public static Context f29135c;

    public static String a(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return charSequence.toString();
    }

    public static Context b() {
        return f29135c;
    }

    public static boolean c(Context context, String str, String str2) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).metaData.getBoolean(str2);
        } catch (Exception e10) {
            Log.e("BlackListAppUtils", "e = " + e10);
            return false;
        }
    }

    public static String d(Context context, String str, String str2) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).metaData.getString(str2);
        } catch (Exception e10) {
            Log.e("BlackListAppUtils", "e = " + e10);
            return "";
        }
    }

    public static boolean e(Context context, String str, String str2, String str3) {
        try {
            return TextUtils.equals(str3, context.getPackageManager().getApplicationInfo(str, 128).metaData.getString(str2));
        } catch (Exception e10) {
            Log.e("BlackListAppUtils", "e = " + e10);
            return false;
        }
    }

    public static boolean f(Context context) {
        if (!D.c(context) && !D.d(context)) {
            return false;
        }
        return true;
    }

    public static void g(Context context) {
        f29135c = context;
        f29133a = k(context);
        f29134b = context.getPackageName().equals(C1629c.f37417c);
    }

    public static boolean h() {
        if (F6.b.d() >= 31) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        return true;
    }

    public static boolean j() {
        return true;
    }

    public static boolean k(Context context) {
        if (context == null) {
            return false;
        }
        if (!l7.b.f34744l && !l7.b.f34754v) {
            return false;
        }
        boolean e10 = e(context, "com.android.mms", "rcs_group_chat", "close");
        C0846g.i("BlackListAppUtils", "isIncludeMessageApplication include = " + e10);
        return e10;
    }

    public static boolean l() {
        if (F6.b.d() > 22) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m(android.content.Context r6) {
        /*
            java.lang.String r0 = "check isSupportHighRiskNumber"
            java.lang.String r1 = "BlackListAppUtils"
            com.oplus.utils.C0846g.k(r1, r0)
            r0 = 0
            if (r6 != 0) goto Lb
            return r0
        Lb:
            boolean r2 = l7.b.f34737e
            if (r2 == 0) goto L15
            java.lang.String r6 = "VERSION_EXP not support high risk number"
            com.oplus.utils.C0846g.k(r1, r6)
            return r0
        L15:
            java.lang.String r2 = "com.android.contacts"
            java.lang.String r3 = v6.C1629c.f37419e
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}
            r3 = r0
        L1e:
            r4 = 2
            if (r3 >= r4) goto L43
            r4 = r2[r3]
            java.lang.String r5 = "high_risk_number"
            boolean r5 = c(r6, r4, r5)
            if (r5 != 0) goto L40
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r2 = "not support high risk number"
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.oplus.utils.C0846g.k(r1, r6)
            return r0
        L40:
            int r3 = r3 + 1
            goto L1e
        L43:
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: java.lang.Exception -> L58 android.content.pm.PackageManager.NameNotFoundException -> L5a
            java.lang.String r2 = "com.heytap.speechassist"
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo(r2, r3)     // Catch: java.lang.Exception -> L58 android.content.pm.PackageManager.NameNotFoundException -> L5a
            android.os.Bundle r6 = r6.metaData     // Catch: java.lang.Exception -> L58 android.content.pm.PackageManager.NameNotFoundException -> L5a
            java.lang.String r2 = "xiaobu_aicall_version"
            int r6 = r6.getInt(r2)     // Catch: java.lang.Exception -> L58 android.content.pm.PackageManager.NameNotFoundException -> L5a
            goto L8a
        L58:
            r6 = move-exception
            goto L5c
        L5a:
            r6 = move-exception
            goto L71
        L5c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "e = "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            android.util.Log.e(r1, r6)
            goto L89
        L71:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Package not found: "
            r2.append(r3)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            android.util.Log.e(r1, r6)
        L89:
            r6 = r0
        L8a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "xiaobuVersion :"
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.oplus.utils.C0846g.k(r1, r2)
            r1 = 1
            if (r6 <= r1) goto La2
            r0 = r1
        La2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.C0844e.m(android.content.Context):boolean");
    }

    public static void n(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str) {
        if (j()) {
            try {
                context.registerReceiver(broadcastReceiver, new IntentFilter(str), 2);
                return;
            } catch (Exception e10) {
                Log.e("BlackListAppUtils", "e =" + e10);
                return;
            }
        }
        intentFilter.addAction(str);
    }
}
