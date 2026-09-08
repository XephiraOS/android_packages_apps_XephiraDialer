package com.coui.appcompat.pressfeedback;

import X8.f;
import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringForce;
import com.coui.appcompat.log.COUILog;

/* loaded from: classes.dex */
public class COUIPressFeedbackHelper {
    public static final int BORDERLESS_BUTTON_PRESS_FEEDBACK = 1;
    public static final int CARD_PRESS_FEEDBACK = 0;
    private static final float DEFAULT_SCALE_END_RATIO = 0.92f;
    private static final float DEFAULT_SCALE_FACTOR = 10000.0f;
    private static final float DEFAULT_SCALE_START_RATIO = 1.0f;
    public static final float DEFAULT_SPRING_BOUNCE = 0.0f;
    public static final float DEFAULT_SPRING_RESPONSE = 0.3f;
    public static final int FILL_BUTTON_PRESS_FEEDBACK = 2;
    private static final float MAX_SCALE_END_RATIO = 0.98f;
    private static final float MIN_SCALE_END_RATIO = 0.92f;
    private static final String TAG = "COUIPressFeedbackHelper";
    public static final int UNJUMPABLE_CARD_PRESS_FEEDBACK = 0;
    private float mCurrentScaleValue;
    private float mMaxCardViewSize;
    private float mMinCardViewSize;
    private boolean mScaleEnable;
    private COUISpringAnimation mSpringAnimation;
    private View mTarget;
    private float mUserViewHeight;
    private float mUserViewWidth;
    private int mViewType;
    private static final PathInterpolator DEFAULT_SCALE_MAPPING_INTERPOLATOR = new COUIInEaseInterpolator();
    private static final androidx.dynamicanimation.animation.d<COUIPressFeedbackHelper> SCALE_TRANSITION = new androidx.dynamicanimation.animation.d<COUIPressFeedbackHelper>("viewScaleTransition") { // from class: com.coui.appcompat.pressfeedback.COUIPressFeedbackHelper.1
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(COUIPressFeedbackHelper cOUIPressFeedbackHelper) {
            return cOUIPressFeedbackHelper.getProgress();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(COUIPressFeedbackHelper cOUIPressFeedbackHelper, float f10) {
            cOUIPressFeedbackHelper.setProgress(f10);
        }
    };

    public COUIPressFeedbackHelper(View view) {
        this(view, 0);
    }

    private void ensureSpringAnimation() {
        if (this.mSpringAnimation != null) {
            return;
        }
        COUISpringForce cOUISpringForce = new COUISpringForce();
        cOUISpringForce.setBounce(0.0f);
        cOUISpringForce.setResponse(0.3f);
        COUISpringAnimation cOUISpringAnimation = new COUISpringAnimation(this, SCALE_TRANSITION);
        this.mSpringAnimation = cOUISpringAnimation;
        cOUISpringAnimation.setSpring(cOUISpringForce);
        this.mSpringAnimation.addUpdateListener(new COUIDynamicAnimation.OnAnimationUpdateListener() { // from class: com.coui.appcompat.pressfeedback.d
            @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(COUIDynamicAnimation cOUIDynamicAnimation, float f10, float f11) {
                COUIPressFeedbackHelper.this.lambda$ensureSpringAnimation$0(cOUIDynamicAnimation, f10, f11);
            }
        });
    }

    private float getCardScaleRatio() {
        View view = this.mTarget;
        if (view == null) {
            return 1.0f;
        }
        float f10 = this.mUserViewWidth * this.mUserViewHeight;
        if (f10 <= 0.0f) {
            f10 = view.getWidth() * this.mTarget.getHeight();
        }
        float f11 = this.mMinCardViewSize;
        if (f10 <= f11) {
            return 0.92f;
        }
        float f12 = this.mMaxCardViewSize;
        if (f10 >= f12) {
            return MAX_SCALE_END_RATIO;
        }
        return (DEFAULT_SCALE_MAPPING_INTERPOLATOR.getInterpolation((f10 - f11) / (f12 - f11)) * 0.060000002f) + 0.92f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getProgress() {
        return this.mCurrentScaleValue;
    }

    private float getScaledRatioByAnimatedValue() {
        return 1.0f - ((1.0f - getCardScaleRatio()) * (this.mCurrentScaleValue / 10000.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureSpringAnimation$0(COUIDynamicAnimation cOUIDynamicAnimation, float f10, float f11) {
        setProgress(f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f10) {
        if (this.mTarget == null) {
            COUILog.w(TAG, "press effect target is null!");
            return;
        }
        this.mCurrentScaleValue = f10;
        float scaledRatioByAnimatedValue = getScaledRatioByAnimatedValue();
        this.mTarget.setPivotX(r0.getWidth() / 2.0f);
        this.mTarget.setPivotY(r0.getHeight() / 2.0f);
        this.mTarget.setScaleX(scaledRatioByAnimatedValue);
        this.mTarget.setScaleY(scaledRatioByAnimatedValue);
    }

    private void updateConfig(Context context) {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(f.f4555N2);
        this.mMinCardViewSize = dimensionPixelOffset * dimensionPixelOffset;
        this.mMaxCardViewSize = context.getResources().getDimensionPixelOffset(f.f4534K2) * context.getResources().getDimensionPixelOffset(f.f4527J2);
    }

    public void executeFeedbackAnimator(boolean z10) {
        float f10;
        if (this.mScaleEnable) {
            ensureSpringAnimation();
            COUISpringAnimation cOUISpringAnimation = this.mSpringAnimation;
            if (z10) {
                f10 = 10000.0f;
            } else {
                f10 = 0.0f;
            }
            cOUISpringAnimation.animateToFinalPosition(f10);
        }
    }

    public COUISpringAnimation getSpringAnimation() {
        return this.mSpringAnimation;
    }

    public void setScaleEnable(boolean z10) {
        this.mScaleEnable = z10;
    }

    public void setTargetView(View view) {
        this.mTarget = view;
    }

    public void setUserViewHeight(int i10) {
        this.mUserViewHeight = i10;
    }

    public void setUserViewWidth(int i10) {
        this.mUserViewWidth = i10;
    }

    public void setViewType(int i10) {
        this.mViewType = i10;
    }

    public COUIPressFeedbackHelper(View view, int i10) {
        this.mScaleEnable = true;
        this.mUserViewWidth = 0.0f;
        this.mUserViewHeight = 0.0f;
        this.mMinCardViewSize = 0.0f;
        this.mMaxCardViewSize = 0.0f;
        this.mViewType = i10;
        setTargetView(view);
        updateConfig(view.getContext());
    }
}
