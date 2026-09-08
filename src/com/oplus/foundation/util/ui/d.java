package com.oplus.foundation.util.ui;

import android.view.View;
import android.widget.TextView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;

/* compiled from: ViewUtils.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f28372a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final int f28373b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f28374c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final int f28375d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f28376e = {0, 0};

    public static final int c(View view) {
        int[] iArr = f28376e;
        iArr[1] = 0;
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr[1];
    }

    public static final void d(TextView textView, int i10) {
        int i11;
        if (textView != null) {
            i11 = (int) textView.getTextSize();
        } else {
            i11 = 0;
        }
        e(textView, i11, i10);
    }

    public static final void e(TextView textView, int i10, int i11) {
        if (textView != null) {
            textView.setTextSize(0, (int) COUIChangeTextUtil.getSuitableFontSize(i10, textView.getResources().getConfiguration().fontScale, i11));
        }
    }

    public final int a() {
        return f28373b;
    }

    public final int b() {
        return f28375d;
    }
}
