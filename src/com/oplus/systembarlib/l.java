package com.oplus.systembarlib;

import android.content.Context;

/* compiled from: NightModeChecker.kt */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f29015a = new l();

    public final boolean a(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (32 == (context.getResources().getConfiguration().uiMode & 48)) {
            return true;
        }
        return false;
    }
}
