package com.android.contacts.framework.api.appstore.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import kotlin.jvm.internal.i;

/* compiled from: ApplicationLifecycleManager.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15535a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final IApplicationApi f15536b = IApplicationApi.f15531a.a();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f15537c;

    public static final void a(Context context, Application application) {
        i.f(context, "context");
        i.f(application, "application");
        IApplicationApi iApplicationApi = f15536b;
        if (iApplicationApi != null) {
            iApplicationApi.b(context, application);
        }
    }

    public static final boolean b() {
        return f15537c;
    }

    public static final void c(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        IApplicationApi iApplicationApi = f15536b;
        if (iApplicationApi != null) {
            iApplicationApi.onConfigurationChanged(newConfig);
        }
    }

    public static final void d(Application application) {
        i.f(application, "application");
        IApplicationApi iApplicationApi = f15536b;
        if (iApplicationApi != null) {
            iApplicationApi.a(application);
        }
    }

    public static final void e(boolean z10) {
        f15537c = z10;
    }
}
