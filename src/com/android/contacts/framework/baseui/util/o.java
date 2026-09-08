package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import kotlin.Result;

/* compiled from: NightModeUtils.kt */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static a f15951b;

    /* renamed from: a, reason: collision with root package name */
    public static final o f15950a = new o();

    /* renamed from: c, reason: collision with root package name */
    public static int f15952c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static float f15953d = -1.0f;

    /* compiled from: NightModeUtils.kt */
    /* loaded from: classes.dex */
    public static final class a extends ContentObserver {
        public a() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            H7.b.e("NightModeUtils", "selfChange = " + z10);
            o.f();
        }
    }

    public static final int a(Context context) {
        float f10 = f15953d;
        if (f10 == 0.0f) {
            return context.getColor(N0.e.f1861j);
        }
        if (f10 == 8.0f) {
            return context.getColor(N0.e.f1862k);
        }
        if (f10 == 20.0f) {
            return context.getColor(N0.e.f1863l);
        }
        return context.getColor(N0.e.f1861j);
    }

    public static final int b() {
        if (-1 == f15952c) {
            f();
        }
        return f15952c;
    }

    public static final float c() {
        if (-1.0f == f15953d) {
            f();
        }
        return f15953d;
    }

    public static final void d(Context context) {
        Object b10;
        m9.q qVar;
        kotlin.jvm.internal.i.f(context, "context");
        f15951b = new a();
        try {
            Result.a aVar = Result.f34166a;
            a aVar2 = f15951b;
            if (aVar2 != null) {
                context.getContentResolver().registerContentObserver(Settings.System.getUriFor("DarkMode_BackgroundMaxL_System"), true, aVar2);
                qVar = m9.q.f35511a;
            } else {
                qVar = null;
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar3 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("NightModeUtils", "th = " + d10);
        }
    }

    public static final boolean e(Context context) {
        Context applicationContext;
        if (context != null && (applicationContext = context.getApplicationContext()) != null) {
            boolean isNightMode = COUIDarkModeUtil.isNightMode(applicationContext);
            if (H7.a.b()) {
                H7.b.b("NightModeUtils", "isNightMode = " + isNightMode);
            }
            return isNightMode;
        }
        return false;
    }

    public static final void f() {
        P7.a aVar = P7.a.f2961a;
        f15953d = G0.c.c(aVar.a(), 0, "DarkMode_BackgroundMaxL_System", -1.0f, 0, 16, null);
        if (H7.a.b()) {
            H7.b.b("NightModeUtils", "nightLevel = " + f15953d);
        }
        f15952c = a(aVar.a());
    }
}
