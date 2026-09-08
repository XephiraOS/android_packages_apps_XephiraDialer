package com.android.contacts.scenecard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.FeatureUtil;

/* compiled from: SceneUIHelper.kt */
/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public static final X f17252a = new X();

    public final void a(View view) {
        kotlin.jvm.internal.i.f(view, "view");
        if (FeatureUtil.S()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = view.getResources().getDimensionPixelSize(R.dimen.DP_16);
                view.setLayoutParams(marginLayoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    public final void b(TextView textView) {
        if (textView != null) {
            textView.setFontVariationSettings("'wght' 1000");
        }
    }

    public final void c(View view) {
        TextView textView;
        kotlin.jvm.internal.i.f(view, "view");
        if (FeatureUtil.S()) {
            view.setPadding(view.getPaddingLeft(), view.getResources().getDimensionPixelSize(R.dimen.DP_19), view.getPaddingRight(), view.getPaddingBottom());
        }
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setText(R.string.odialer_app_name);
            }
        }
    }
}
