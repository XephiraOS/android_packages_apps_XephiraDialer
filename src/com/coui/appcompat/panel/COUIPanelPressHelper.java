package com.coui.appcompat.panel;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.animation.COUIEaseInterpolator;

/* loaded from: classes.dex */
public class COUIPanelPressHelper {
    private static final String BG_ALPHA = "bgAlpha";
    private static final PathInterpolator COUI_EASE_INTERPOLATOR = new COUIEaseInterpolator();
    private static final int LOAD_BG_DURATION = 200;
    private Float bgAlpha = Float.valueOf(0.0f);
    private ValueAnimator pressAnim;
    private ValueAnimator releaseAnim;

    private void cancelAnim(ValueAnimator valueAnimator) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$endAnim$1(View view, ValueAnimator valueAnimator) {
        Float f10 = (Float) valueAnimator.getAnimatedValue(BG_ALPHA);
        this.bgAlpha = f10;
        view.setAlpha(f10.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnim$0(View view, ValueAnimator valueAnimator) {
        Float f10 = (Float) valueAnimator.getAnimatedValue(BG_ALPHA);
        this.bgAlpha = f10;
        view.setAlpha(f10.floatValue());
    }

    public void endAnim(final View view) {
        cancelAnim(this.pressAnim);
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(BG_ALPHA, this.bgAlpha.floatValue(), 0.0f));
        this.releaseAnim = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setInterpolator(COUI_EASE_INTERPOLATOR);
        this.releaseAnim.setDuration(200L);
        this.releaseAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIPanelPressHelper.this.lambda$endAnim$1(view, valueAnimator);
            }
        });
        this.releaseAnim.start();
    }

    public void startAnim(final View view) {
        cancelAnim(this.releaseAnim);
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(BG_ALPHA, 0.0f, 1.0f));
        this.pressAnim = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setInterpolator(COUI_EASE_INTERPOLATOR);
        this.pressAnim.setDuration(200L);
        this.pressAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIPanelPressHelper.this.lambda$startAnim$0(view, valueAnimator);
            }
        });
        this.pressAnim.start();
    }
}
