package com.oplus.foundation.util.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import kotlin.jvm.internal.i;

/* compiled from: AppBadgeUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28368a = new a();

    public static final void a(Context context, int i10) {
        i.f(context, "context");
        if (H7.a.b()) {
            H7.b.b("AppBadgeUtils", "badgeCount = " + i10);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i10);
            bundle.putString("app_badge_packageName", context.getPackageName());
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
        } catch (RemoteException e10) {
            H7.b.c("AppBadgeUtils", "Write unread number FAILED!!! e = " + e10);
        }
    }
}
