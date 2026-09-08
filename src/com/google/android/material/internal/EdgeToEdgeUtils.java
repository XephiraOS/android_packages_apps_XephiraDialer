package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.view.Window;
import androidx.core.view.V;
import l4.C1292a;

/* loaded from: classes3.dex */
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(Window window, boolean z10) {
        applyEdgeToEdge(window, z10, null, null);
    }

    private static int getNavigationBarColor(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return C1292a.b(context, R.attr.navigationBarColor, -16777216);
    }

    private static int getStatusBarColor(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return C1292a.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean isUsingLightSystemBar(int i10, boolean z10) {
        if (!C1292a.h(i10) && (i10 != 0 || !z10)) {
            return false;
        }
        return true;
    }

    public static void setLightNavigationBar(Window window, boolean z10) {
        V.a(window, window.getDecorView()).c(z10);
    }

    public static void setLightStatusBar(Window window, boolean z10) {
        V.a(window, window.getDecorView()).d(z10);
    }

    public static void applyEdgeToEdge(Window window, boolean z10, Integer num, Integer num2) {
        boolean z11 = num == null || num.intValue() == 0;
        boolean z12 = num2 == null || num2.intValue() == 0;
        if (z11 || z12) {
            int b10 = C1292a.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z11) {
                num = Integer.valueOf(b10);
            }
            if (z12) {
                num2 = Integer.valueOf(b10);
            }
        }
        V.b(window, !z10);
        int statusBarColor = getStatusBarColor(window.getContext(), z10);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z10);
        window.setStatusBarColor(statusBarColor);
        window.setNavigationBarColor(navigationBarColor);
        setLightStatusBar(window, isUsingLightSystemBar(statusBarColor, C1292a.h(num.intValue())));
        setLightNavigationBar(window, isUsingLightSystemBar(navigationBarColor, C1292a.h(num2.intValue())));
    }
}
