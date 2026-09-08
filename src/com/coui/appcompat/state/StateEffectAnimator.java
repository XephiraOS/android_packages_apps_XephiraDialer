package com.coui.appcompat.state;

import android.animation.ArgbEvaluator;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.dynamicanimation.animation.d;
import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringForce;

/* loaded from: classes.dex */
public class StateEffectAnimator {
    public static final float DEFAULT_ANIMATE_FACTOR = 10000.0f;
    private static final ArgbEvaluator EVALUATOR = new ArgbEvaluator();
    private static final float UNSET = Float.MAX_VALUE;
    private float mCurrentAnimatedValue;
    private int mCurrentMaskColor;
    private int mEndMaskColor;
    private Drawable mHostDrawable;
    private View mHostView;
    private StateEffectAnimatorListener mListener;
    private final d<StateEffectAnimator> mMaskTransition;
    private float mPendingThresholdValue;
    private final COUIDynamicAnimation.OnAnimationEndListener mResetEndListener;
    private COUISpringAnimation mSpringAnimation;
    private int mStartMaskColor;
    private final String mTag;

    /* loaded from: classes.dex */
    public interface StateEffectAnimatorListener {
        void onValueUpdateListener(float f10);
    }

    public StateEffectAnimator(Drawable drawable, String str, int i10, int i11) {
        this(drawable, null, str, i10, i11);
    }

    private void ensureSpringAnimation() {
        if (this.mSpringAnimation != null) {
            return;
        }
        COUISpringAnimation cOUISpringAnimation = new COUISpringAnimation(this, this.mMaskTransition);
        this.mSpringAnimation = cOUISpringAnimation;
        cOUISpringAnimation.setSpring(new COUISpringForce());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getProgress() {
        return this.mCurrentAnimatedValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(float f10) {
        this.mCurrentAnimatedValue = f10;
        this.mCurrentMaskColor = ((Integer) EVALUATOR.evaluate(f10 / 10000.0f, Integer.valueOf(this.mStartMaskColor), Integer.valueOf(this.mEndMaskColor))).intValue();
        StateEffectAnimatorListener stateEffectAnimatorListener = this.mListener;
        if (stateEffectAnimatorListener != null) {
            stateEffectAnimatorListener.onValueUpdateListener(f10);
        }
        Drawable drawable = this.mHostDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        }
        View view = this.mHostView;
        if (view != null) {
            view.invalidate();
        }
        float f11 = this.mCurrentAnimatedValue;
        if (f11 > this.mPendingThresholdValue) {
            this.mPendingThresholdValue = UNSET;
            if (f11 >= 10000.0f) {
                this.mSpringAnimation.addEndListener(this.mResetEndListener);
            } else {
                animateToProgress(0.0f, true);
            }
        }
    }

    public void animateToProgress(float f10, boolean z10) {
        ensureSpringAnimation();
        this.mSpringAnimation.removeEndListener(this.mResetEndListener);
        if (z10) {
            this.mSpringAnimation.setStartValue(this.mCurrentAnimatedValue);
            this.mSpringAnimation.animateToFinalPosition(f10);
        } else {
            if (this.mSpringAnimation.isRunning()) {
                this.mSpringAnimation.animateToFinalPosition(f10);
                this.mSpringAnimation.reset();
            }
            setProgress(f10);
        }
        this.mPendingThresholdValue = UNSET;
    }

    public void animateToProgressUntil(float f10, float f11) {
        ensureSpringAnimation();
        this.mSpringAnimation.removeEndListener(this.mResetEndListener);
        if (this.mSpringAnimation.isRunning()) {
            float f12 = this.mCurrentAnimatedValue;
            if (f12 > f11) {
                this.mSpringAnimation.setStartValue(f12);
                this.mSpringAnimation.animateToFinalPosition(f10);
                return;
            } else {
                this.mPendingThresholdValue = f11;
                return;
            }
        }
        this.mSpringAnimation.setStartValue(this.mCurrentAnimatedValue);
        this.mSpringAnimation.animateToFinalPosition(f10);
        this.mPendingThresholdValue = f11;
    }

    public int getCurrentMaskColor() {
        return this.mCurrentMaskColor;
    }

    public void setEndMaskColor(int i10) {
        this.mEndMaskColor = i10;
    }

    public void setHostDrawable(Drawable drawable) {
        this.mHostDrawable = drawable;
    }

    public void setHostView(View view) {
        this.mHostView = view;
    }

    public void setSpringBounce(float f10) {
        ensureSpringAnimation();
        this.mSpringAnimation.getSpring().setBounce(f10);
    }

    public void setSpringResponse(float f10) {
        ensureSpringAnimation();
        this.mSpringAnimation.getSpring().setResponse(f10);
    }

    public void setStartMaskColor(int i10) {
        this.mStartMaskColor = i10;
    }

    public void setStateEffectAnimatorListener(StateEffectAnimatorListener stateEffectAnimatorListener) {
        this.mListener = stateEffectAnimatorListener;
    }

    public StateEffectAnimator(View view, String str, int i10, int i11) {
        this(null, view, str, i10, i11);
    }

    public StateEffectAnimator(Drawable drawable, View view, String str, int i10, int i11) {
        this.mResetEndListener = new COUIDynamicAnimation.OnAnimationEndListener() { // from class: com.coui.appcompat.state.StateEffectAnimator.1
            @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(COUIDynamicAnimation cOUIDynamicAnimation, boolean z10, float f10, float f11) {
                StateEffectAnimator.this.animateToProgress(0.0f, true);
                cOUIDynamicAnimation.removeEndListener(StateEffectAnimator.this.mResetEndListener);
            }
        };
        this.mCurrentAnimatedValue = 0.0f;
        this.mPendingThresholdValue = UNSET;
        this.mListener = null;
        this.mHostDrawable = drawable;
        this.mHostView = view;
        this.mTag = str;
        this.mMaskTransition = new d<StateEffectAnimator>(str) { // from class: com.coui.appcompat.state.StateEffectAnimator.2
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(StateEffectAnimator stateEffectAnimator) {
                return stateEffectAnimator.getProgress();
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(StateEffectAnimator stateEffectAnimator, float f10) {
                stateEffectAnimator.setProgress(f10);
            }
        };
        ensureSpringAnimation();
        this.mStartMaskColor = i10;
        this.mEndMaskColor = i11;
    }
}
