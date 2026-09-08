package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

/* compiled from: StatusBarUtil.java */
/* loaded from: classes.dex */
public class B {
    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return context.getResources().getDimensionPixelOffset(N0.f.f1884j);
    }

    public static View b(Context context, boolean z10) {
        int a10 = a(context);
        ImageView imageView = new ImageView(context);
        if (z10) {
            imageView.setBackgroundResource(N0.g.f1910j);
        } else {
            imageView.setBackgroundResource(N0.g.f1902b);
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, a10));
        return imageView;
    }

    public static void c(Context context, Window window, int i10) {
        d(context, window, i10, o.e(context));
    }

    public static void d(Context context, Window window, int i10, boolean z10) {
        int i11;
        window.setStatusBarColor(0);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        if (i10 == 2) {
            decorView.setSystemUiVisibility(1024);
        } else if (i10 == 3) {
            decorView.setSystemUiVisibility(1024);
            window.setNavigationBarColor(context.getColor(N0.e.f1857f));
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z10) {
            i11 = systemUiVisibility & (-8209);
        } else if (!context.getResources().getBoolean(N0.d.f1851b)) {
            i11 = systemUiVisibility | 8192;
        } else {
            i11 = systemUiVisibility | 256;
        }
        decorView.setSystemUiVisibility(i11);
    }
}
