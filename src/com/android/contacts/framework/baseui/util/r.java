package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.view.View;
import com.coui.appcompat.contextutil.COUIContextUtil;

/* compiled from: ResourcesUtils.kt */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f15957a = new r();

    public static final int a(Context context) {
        return COUIContextUtil.getAttrColor(context, N0.c.f1848i);
    }

    public static final int b(Context context) {
        if (context != null) {
            return COUIContextUtil.getAttrColor(context, N0.c.f1845f);
        }
        return -1;
    }

    public static final int c(Context context) {
        if (context != null) {
            return context.getColor(N0.e.f1856e);
        }
        return 0;
    }

    public static final int d(Context context) {
        return COUIContextUtil.getAttrColor(context, N0.c.f1846g);
    }

    public static final void e(Context context, View view) {
        if (context != null) {
            if (A7.a.a()) {
                if (view != null) {
                    view.setBackground(context.getDrawable(N0.g.f1909i));
                }
            } else if (view != null) {
                view.setBackground(context.getDrawable(N0.g.f1911k));
            }
        }
    }
}
