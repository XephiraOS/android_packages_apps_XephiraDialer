package com.oplus.scenecard;

import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: LogUtil.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f28951a;

    /* renamed from: b, reason: collision with root package name */
    public static int f28952b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f28953c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f28954d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f28955e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f28956f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f28957g;

    static {
        int i10;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = false;
        boolean b10 = b("persist.sys.assert.panic", false);
        f28951a = b10;
        if (b10) {
            i10 = 3;
        } else {
            i10 = 4;
        }
        f28952b = i10;
        if (i10 <= 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        f28953c = z10;
        if (i10 <= 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        f28954d = z11;
        if (i10 <= 4) {
            z12 = true;
        } else {
            z12 = false;
        }
        f28955e = z12;
        if (i10 <= 5) {
            z13 = true;
        } else {
            z13 = false;
        }
        f28956f = z13;
        if (i10 <= 6) {
            z14 = true;
        }
        f28957g = z14;
    }

    public static void a(String str, String str2) {
        if (f28954d) {
            Log.d(str, str2);
        }
    }

    public static boolean b(String str, boolean z10) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, str, Boolean.valueOf(z10))).booleanValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void c(String str, String str2) {
        if (f28955e) {
            Log.i(str, str2);
        }
    }
}
