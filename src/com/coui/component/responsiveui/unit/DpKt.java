package com.coui.component.responsiveui.unit;

import android.content.Context;
import kotlin.jvm.internal.i;

/* compiled from: Dp.kt */
/* loaded from: classes3.dex */
public final class DpKt {
    public static final Dp getDp(int i10) {
        return new Dp(i10);
    }

    public static final Dp pixel2Dp(int i10, Context context) {
        i.f(context, "context");
        return new Dp(i10 / context.getResources().getDisplayMetrics().density);
    }
}
