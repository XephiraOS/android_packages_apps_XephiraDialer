package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import kotlin.Result;

/* compiled from: NavigationModeUtils.kt */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f15947a = new n();

    /* renamed from: b, reason: collision with root package name */
    public static a f15948b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f15949c;

    /* compiled from: NavigationModeUtils.kt */
    /* loaded from: classes.dex */
    public static final class a extends ContentObserver {
        public a() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            H7.b.e("NavigationModeObserver", "selfChange = " + z10);
            n.d();
        }
    }

    public static final void a(Context context) {
        Object b10;
        m9.q qVar;
        kotlin.jvm.internal.i.f(context, "context");
        f15948b = new a();
        try {
            Result.a aVar = Result.f34166a;
            a aVar2 = f15948b;
            if (aVar2 != null) {
                context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("navigation_mode"), true, aVar2);
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
            H7.b.c("NavigationModeObserver", "th = " + d10);
        }
    }

    public static final boolean b() {
        if (f15949c == null) {
            f15949c = Boolean.valueOf(c(P7.a.f2961a.a()));
        }
        Boolean bool = f15949c;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean c(Context context) {
        if (G0.c.d(context, 2, "navigation_mode", 0) != 2) {
            return false;
        }
        return true;
    }

    public static final void d() {
        Boolean valueOf = Boolean.valueOf(c(P7.a.f2961a.a()));
        f15949c = valueOf;
        H7.b.e("NavigationModeObserver", "isGestureNavMode = " + valueOf);
    }
}
