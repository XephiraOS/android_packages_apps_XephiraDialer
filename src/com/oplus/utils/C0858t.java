package com.oplus.utils;

import android.content.Context;
import android.content.res.Configuration;

/* compiled from: DisplayUtil.kt */
/* renamed from: com.oplus.utils.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0858t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0858t f29188a = new C0858t();

    public static final boolean a(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (context.getResources().getConfiguration().smallestScreenWidthDp >= 480) {
            return true;
        }
        return false;
    }

    public static final boolean b(Configuration configuration) {
        if (configuration != null && configuration.smallestScreenWidthDp >= 480) {
            return true;
        }
        return false;
    }
}
