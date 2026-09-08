package com.android.store_incallui;

import A8.a;
import R2.c;
import android.app.Application;
import android.content.Context;
import com.android.incallui.OplusInCallApp;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;

/* compiled from: ShellInCallApp.kt */
/* loaded from: classes.dex */
public final class ShellInCallApp extends OplusInCallApp {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShellInCallApp(Application application) {
        super(application);
        i.f(application, "application");
    }

    @Override // com.android.incallui.OplusInCallApp, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        i.f(context, "context");
        super.attachBaseContext(context);
    }

    @Override // com.android.incallui.OplusInCallApp, com.android.incallui.InCallApp, android.app.Application
    public void onCreate() {
        a.f202a.b().put(k.b(Application.class), this);
        c.a(this);
        init();
    }
}
