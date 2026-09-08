package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.C;
import androidx.transition.Transition;
import java.util.Map;

/* loaded from: classes3.dex */
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(C c10) {
        View view = c10.f11528b;
        if (view instanceof TextView) {
            c10.f11527a.put(PROPNAME_SCALE, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C c10) {
        captureValues(c10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C c10) {
        captureValues(c10);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C c10, C c11) {
        float f10;
        if (c10 == null || c11 == null || !(c10.f11528b instanceof TextView)) {
            return null;
        }
        View view = c11.f11528b;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        Map<String, Object> map = c10.f11527a;
        Map<String, Object> map2 = c11.f11527a;
        float f11 = 1.0f;
        if (map.get(PROPNAME_SCALE) != null) {
            f10 = ((Float) map.get(PROPNAME_SCALE)).floatValue();
        } else {
            f10 = 1.0f;
        }
        if (map2.get(PROPNAME_SCALE) != null) {
            f11 = ((Float) map2.get(PROPNAME_SCALE)).floatValue();
        }
        if (f10 == f11) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
