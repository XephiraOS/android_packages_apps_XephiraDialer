package com.coui.appcompat.floatingactionbutton;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;

/* loaded from: classes.dex */
public class COUIFABPressFeedbackUtil {
    private static final float BIG_CARD_GUARANTEE_VALUE_THRESHOLD_PERCENTAGE = 0.07f;
    private static final int DEFAULT_FLOATING_BUTTON_HEIGHT = 156;
    private static final float DEFAULT_GUARANTEE_VALUE_THRESHOLD_PERCENTAGE = 0.1f;
    private static final int DEFAULT_PRESS_FEEDBACK_ANIMATION_DURATION = 200;
    private static final float DEFAULT_PRESS_FEEDBACK_SCALE_MAX_VALUE = 1.0f;
    private static final float DEFAULT_PRESS_FEEDBACK_SCALE_MIN_VALUE = 0.9f;
    private static final int DEFAULT_RELEASE_ANIMATION_DURATION = 340;
    private static final int DEFAULT_TARGET_GUARANTEED_VALUE_THRESHOLD_HEIGHT = 600;
    private static final PathInterpolator PRESS_FEEDBACK_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final float SMALL_CARD_GUARANTEE_VALUE_THRESHOLD_PERCENTAGE = 0.35f;

    public static COUIFloatingButtonTouchAnimation generatePressAnimation(View view) {
        if (view != null) {
            COUIFloatingButtonTouchAnimation cOUIFloatingButtonTouchAnimation = new COUIFloatingButtonTouchAnimation(1.0f, 0.9f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
            cOUIFloatingButtonTouchAnimation.setDuration(200L);
            cOUIFloatingButtonTouchAnimation.setFillAfter(true);
            cOUIFloatingButtonTouchAnimation.setInterpolator(PRESS_FEEDBACK_INTERPOLATOR);
            cOUIFloatingButtonTouchAnimation.setTargetView(view);
            return cOUIFloatingButtonTouchAnimation;
        }
        throw new IllegalArgumentException("The given view is empty. Please provide a valid view.");
    }

    public static ValueAnimator generatePressAnimationRecord() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.9f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(PRESS_FEEDBACK_INTERPOLATOR);
        return ofFloat;
    }

    public static COUIFloatingButtonTouchAnimation generateResumeAnimation(View view, float f10) {
        if (view != null) {
            COUIFloatingButtonTouchAnimation cOUIFloatingButtonTouchAnimation = new COUIFloatingButtonTouchAnimation(f10, 1.0f, view.getWidth() / 2.0f, view.getHeight() / 2.0f);
            cOUIFloatingButtonTouchAnimation.setDuration(340L);
            cOUIFloatingButtonTouchAnimation.setFillAfter(true);
            cOUIFloatingButtonTouchAnimation.setInterpolator(PRESS_FEEDBACK_INTERPOLATOR);
            cOUIFloatingButtonTouchAnimation.setTargetView(view);
            return cOUIFloatingButtonTouchAnimation;
        }
        throw new IllegalArgumentException("The given view is empty. Please provide a valid view.");
    }

    public static float getGuaranteedAnimationValue(View view) {
        if (view != null) {
            if (view.getHeight() >= 600) {
                return 0.993f;
            }
            if (view.getHeight() >= DEFAULT_FLOATING_BUTTON_HEIGHT) {
                return 0.965f;
            }
            return 0.99f;
        }
        throw new IllegalArgumentException("The given view is empty. Please provide a valid view.");
    }
}
