package com.oplus.utils;

import android.content.Context;
import android.content.res.Configuration;

/* compiled from: DialogUtils.kt */
/* renamed from: com.oplus.utils.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0857s {
    public static final int a(Context context, Configuration configuration) {
        boolean b10;
        kotlin.jvm.internal.i.f(context, "context");
        if (configuration == null) {
            b10 = C0858t.a(context);
        } else {
            b10 = C0858t.b(configuration);
        }
        if (b10) {
            return 17;
        }
        return 80;
    }
}
