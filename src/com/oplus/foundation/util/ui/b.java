package com.oplus.foundation.util.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.oplus.foundation.util.display.DisplayUtil;
import kotlin.jvm.internal.i;

/* compiled from: DialogUtils.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final int a(Context context, boolean z10, View view) {
        i.f(context, "context");
        if (z10 && view == null) {
            return B7.b.f264c;
        }
        if (DisplayUtil.k(context)) {
            if (view != null) {
                return B7.b.f265d;
            }
            return B7.b.f263b;
        }
        return B7.b.f262a;
    }

    public static /* synthetic */ int b(Context context, boolean z10, View view, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            view = null;
        }
        return a(context, z10, view);
    }

    public static final int c(Context context, Configuration configuration) {
        boolean l10;
        i.f(context, "context");
        if (configuration == null) {
            l10 = DisplayUtil.k(context);
        } else {
            l10 = DisplayUtil.l(configuration);
        }
        if (l10) {
            return 17;
        }
        return 80;
    }

    public static /* synthetic */ int d(Context context, Configuration configuration, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            configuration = null;
        }
        return c(context, configuration);
    }
}
