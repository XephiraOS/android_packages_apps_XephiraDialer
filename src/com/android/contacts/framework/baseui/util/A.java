package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.accessory.constant.AFConstants;
import java.util.HashMap;
import java.util.Map;
import s8.C1569l;

/* compiled from: StatisticsUtils.java */
/* loaded from: classes.dex */
public class A {
    public static void a(Context context, int i10, int i11, Map map, boolean z10) {
        if (context == null) {
            return;
        }
        if (H7.a.b()) {
            H7.b.b("StatisticsUtils", "addCommonUserAction: eventId: " + i11);
        }
        try {
            C1569l.s(context, String.valueOf(i10), String.valueOf(i11), map);
        } catch (Throwable th) {
            H7.b.c("StatisticsUtils", "e = " + th);
        }
    }

    public static void b(Context context, String str) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            if (str.endsWith("entry")) {
                hashMap.put("enter_page", str);
                a(applicationContext, 2000323, 200035402, hashMap, false);
            } else if (str.endsWith("back")) {
                hashMap.put("exit_page", str);
                a(applicationContext, 2000323, 200035403, hashMap, false);
            }
        }
    }

    public static void c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("identification_of_unknown_numbers", str);
        a(P7.a.f2962b, 2000323, 200035413, hashMap, false);
    }

    public static void d(Context context, int i10, Map<String, String> map) {
        if (context == null) {
            return;
        }
        try {
            C1569l.r(context.getApplicationContext(), "20003", String.valueOf(2000318), String.valueOf(i10), map);
        } catch (Throwable th) {
            H7.b.c("StatisticsUtils", "e = " + th);
        }
    }

    public static void e(Context context) {
        try {
            C1569l.h(context);
        } catch (Throwable th) {
            H7.b.c("StatisticsUtils", "e = " + th);
        }
    }

    public static void f(Context context) {
        try {
            C1569l.u(context);
        } catch (Throwable th) {
            H7.b.c("StatisticsUtils", "e = " + th);
        }
    }

    public static void g(Context context) {
        try {
            C1569l.v(context);
        } catch (Throwable th) {
            H7.b.c("StatisticsUtils", "e = " + th);
        }
    }

    public static void h(Context context) {
        try {
            C1569l.w(context);
        } catch (Throwable th) {
            H7.b.c("StatisticsUtils", "e = " + th);
        }
    }

    public static void i(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AFConstants.EXTRA_INTENT_ACTION, str);
        hashMap.put("extra", str2);
        if (H7.a.b()) {
            H7.b.b("StatisticsUtils", "trackEvent: action: " + str + ", extra: " + str2);
        }
        a(P7.a.f2962b, 2000302, 200031214, hashMap, false);
    }
}
