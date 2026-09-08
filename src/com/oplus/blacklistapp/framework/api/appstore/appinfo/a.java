package com.oplus.blacklistapp.framework.api.appstore.appinfo;

import com.android.incallui.BuildConfig;

/* compiled from: AppInfoCompat.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f27210a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final IAppInfoCompatApi f27211b = IAppInfoCompatApi.f27206a.a();

    public static final String a() {
        String a10;
        IAppInfoCompatApi iAppInfoCompatApi = f27211b;
        if (iAppInfoCompatApi == null || (a10 = iAppInfoCompatApi.a()) == null) {
            return "";
        }
        return a10;
    }

    public static final String b() {
        String e10;
        IAppInfoCompatApi iAppInfoCompatApi = f27211b;
        if (iAppInfoCompatApi == null || (e10 = iAppInfoCompatApi.e()) == null) {
            return "com.android.contacts";
        }
        return e10;
    }

    public static final String c() {
        String b10;
        IAppInfoCompatApi iAppInfoCompatApi = f27211b;
        if (iAppInfoCompatApi == null || (b10 = iAppInfoCompatApi.b()) == null) {
            return BuildConfig.LIBRARY_PACKAGE_NAME;
        }
        return b10;
    }

    public static final String d() {
        String c10;
        IAppInfoCompatApi iAppInfoCompatApi = f27211b;
        if (iAppInfoCompatApi == null || (c10 = iAppInfoCompatApi.c()) == null) {
            return "inquirenoarea";
        }
        return c10;
    }

    public static final boolean e(String str) {
        IAppInfoCompatApi iAppInfoCompatApi = f27211b;
        if (iAppInfoCompatApi != null) {
            return iAppInfoCompatApi.d(str);
        }
        return false;
    }
}
