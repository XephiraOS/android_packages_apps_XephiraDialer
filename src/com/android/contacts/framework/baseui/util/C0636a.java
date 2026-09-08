package com.android.contacts.framework.baseui.util;

import android.app.Activity;

/* compiled from: ActivityTransition.kt */
/* renamed from: com.android.contacts.framework.baseui.util.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0636a {
    public static final void a(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(N0.a.f1838c, N0.a.f1836a);
        }
    }

    public static final void b(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(0, N0.a.f1837b);
        }
    }
}
