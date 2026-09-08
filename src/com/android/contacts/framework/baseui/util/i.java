package com.android.contacts.framework.baseui.util;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;

/* compiled from: HighlightAnimationUtils.kt */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f15931a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final ArgbEvaluator f15932b = new ArgbEvaluator();

    public static final ValueAnimator c(final COUICardListSelectedItemLayout cOUICardListSelectedItemLayout) {
        if (cOUICardListSelectedItemLayout == null) {
            return null;
        }
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(1250L);
        ofFloat.setInterpolator(new TimeInterpolator() { // from class: com.android.contacts.framework.baseui.util.g
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f10) {
                float d10;
                d10 = i.d(f10);
                return d10;
            }
        });
        final int attrColor = COUIContextUtil.getAttrColor(cOUICardListSelectedItemLayout.getContext(), N0.c.f1843d);
        final int attrColor2 = COUIContextUtil.getAttrColor(cOUICardListSelectedItemLayout.getContext(), N0.c.f1844e);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.contacts.framework.baseui.util.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i.e(ofFloat, cOUICardListSelectedItemLayout, attrColor, attrColor2, valueAnimator);
            }
        });
        return ofFloat;
    }

    public static final float d(float f10) {
        if (f10 < 0.0f) {
            return 0.0f;
        }
        if (f10 < 0.08f) {
            return f10 / 0.08f;
        }
        if (f10 < 0.28f) {
            return 1.0f;
        }
        if (f10 >= 0.68f) {
            return 0.0f;
        }
        return (0.68f - f10) / 0.4f;
    }

    public static final void e(ValueAnimator valueAnimator, COUICardListSelectedItemLayout cOUICardListSelectedItemLayout, int i10, int i11, ValueAnimator it) {
        kotlin.jvm.internal.i.f(it, "it");
        if (!valueAnimator.isRunning()) {
            return;
        }
        float animatedFraction = it.getAnimatedFraction();
        if (animatedFraction <= 0.0f) {
            cOUICardListSelectedItemLayout.refreshCardBg(i10);
        } else {
            if (animatedFraction >= 1.0f) {
                cOUICardListSelectedItemLayout.refreshCardBg(i11);
                return;
            }
            Object evaluate = f15932b.evaluate(animatedFraction, Integer.valueOf(i10), Integer.valueOf(i11));
            kotlin.jvm.internal.i.d(evaluate, "null cannot be cast to non-null type kotlin.Number");
            cOUICardListSelectedItemLayout.refreshCardBg(((Number) evaluate).intValue());
        }
    }
}
