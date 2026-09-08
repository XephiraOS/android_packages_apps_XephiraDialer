package com.android.contacts.framework.api.appstore.appinfo;

import android.app.Activity;
import android.content.Context;
import com.android.incallui.OplusPhoneUtils;
import kotlin.jvm.internal.i;

/* compiled from: AppInfoCompat.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15529a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final IAppInfoCompatApi f15530b = IAppInfoCompatApi.f15525a.a();

    public static final void a(Context context, Runnable runnable) {
        i.f(runnable, "runnable");
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi != null) {
            iAppInfoCompatApi.h(context, runnable);
        }
    }

    public static final String b() {
        String a10;
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null || (a10 = iAppInfoCompatApi.a()) == null) {
            return "";
        }
        return a10;
    }

    public static final String c() {
        String n10;
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null || (n10 = iAppInfoCompatApi.n()) == null) {
            return "";
        }
        return n10;
    }

    public static final String d() {
        String f10;
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null || (f10 = iAppInfoCompatApi.f()) == null) {
            return OplusPhoneUtils.ACTION_CALL_PRIVILEGED;
        }
        return f10;
    }

    public static final String e() {
        String m10;
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null || (m10 = iAppInfoCompatApi.m()) == null) {
            return "";
        }
        return m10;
    }

    public static final String f() {
        String b10;
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null || (b10 = iAppInfoCompatApi.b()) == null) {
            return "";
        }
        return b10;
    }

    public static final String g(String str) {
        i.f(str, "default");
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null) {
            return str;
        }
        return iAppInfoCompatApi.k(str);
    }

    public static final String h(String str) {
        i.f(str, "default");
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null) {
            return str;
        }
        return iAppInfoCompatApi.j(str);
    }

    public static final String i() {
        String c10;
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null || (c10 = iAppInfoCompatApi.c()) == null) {
            return "";
        }
        return c10;
    }

    public static final String j() {
        String i10;
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi == null || (i10 = iAppInfoCompatApi.i()) == null) {
            return "";
        }
        return i10;
    }

    public static final boolean k() {
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi != null) {
            return iAppInfoCompatApi.d();
        }
        return false;
    }

    public static final void m(Activity activity) {
        i.f(activity, "activity");
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi != null) {
            iAppInfoCompatApi.l(activity);
        }
    }

    public static final void n(Activity activity) {
        i.f(activity, "activity");
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi != null) {
            iAppInfoCompatApi.e(activity);
        }
    }

    public static final boolean o() {
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi != null) {
            return iAppInfoCompatApi.g();
        }
        return false;
    }

    public final boolean l() {
        IAppInfoCompatApi iAppInfoCompatApi = f15530b;
        if (iAppInfoCompatApi != null) {
            return iAppInfoCompatApi.o();
        }
        return true;
    }
}
