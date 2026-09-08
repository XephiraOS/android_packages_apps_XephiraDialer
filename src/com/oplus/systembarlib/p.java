package com.oplus.systembarlib;

import android.view.View;
import android.view.Window;
import androidx.core.view.K;
import androidx.core.view.X;
import o9.C1413c;

/* compiled from: SystemBarController.kt */
/* loaded from: classes3.dex */
public final class p {
    public static final boolean b(View view) {
        kotlin.jvm.internal.i.f(view, "<this>");
        j(view, "hasVirtualKey");
        X C10 = K.C(view.getRootView());
        if (C10 == null) {
            return false;
        }
        return c(C10);
    }

    public static final boolean c(X x10) {
        kotlin.jvm.internal.i.f(x10, "<this>");
        if (e(x10, false, 1, null) <= 80) {
            return false;
        }
        return true;
    }

    public static final int d(X x10, boolean z10) {
        int b10;
        kotlin.jvm.internal.i.f(x10, "<this>");
        B.b f10 = f(x10, z10);
        b10 = C1413c.b(f10.f207a, f10.f208b, f10.f209c, f10.f210d);
        return b10;
    }

    public static /* synthetic */ int e(X x10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return d(x10, z10);
    }

    public static final B.b f(X x10, boolean z10) {
        kotlin.jvm.internal.i.f(x10, "<this>");
        if (z10) {
            B.b g10 = x10.g(X.k.d());
            kotlin.jvm.internal.i.e(g10, "{\n        this.getInsets…e.navigationBars())\n    }");
            return g10;
        }
        B.b f10 = x10.f(X.k.d());
        kotlin.jvm.internal.i.e(f10, "{\n        this.getInsets…e.navigationBars())\n    }");
        return f10;
    }

    public static /* synthetic */ B.b g(X x10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return f(x10, z10);
    }

    public static final B.b h(X x10, boolean z10) {
        kotlin.jvm.internal.i.f(x10, "<this>");
        if (z10) {
            B.b g10 = x10.g(X.k.e());
            kotlin.jvm.internal.i.e(g10, "{\n        this.getInsets….Type.statusBars())\n    }");
            return g10;
        }
        B.b f10 = x10.f(X.k.e());
        kotlin.jvm.internal.i.e(f10, "{\n        this.getInsets….Type.statusBars())\n    }");
        return f10;
    }

    public static /* synthetic */ B.b i(X x10, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return h(x10, z10);
    }

    public static final void j(View view, String str) {
        if (K.C(view) == null) {
            SystemBarLog.e("SystemBarController", str + ". rootWindowInsets is null, rootViewAttached=" + view.getRootView().isAttachedToWindow());
        }
    }

    public static final void k(h hVar, Window window, String str) {
        if (window == null) {
            SystemBarLog.e("SystemBarController", str + ". class:" + ((Object) hVar.getClass().getSimpleName()) + ". window is null.");
        }
    }
}
