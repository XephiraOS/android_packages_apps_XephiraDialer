package com.coui.appcompat.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;

/* loaded from: classes.dex */
public class COUIBackgroundAnimationUtil {
    public static final int APPEAR_DURATION = 150;
    public static final int DISAPPEAR_DURATION = 367;
    public static final int STATE_BACKGROUND_APPEAR = 1;
    public static final int STATE_BACKGROUND_DISAPPEAR = 2;
    private static final String TAG = "COUIAnimationHelper";
    private ValueAnimator mBackgroundAppearAnimator;
    private ValueAnimator mBackgroundDisappearAnimator;
    private int mDefaultColor;
    private boolean mIsSelected;
    private int mPressColor;
    private View mTargetView;
    private int mDisappearDuration = DISAPPEAR_DURATION;
    private int mAppearDuration = 150;
    public int mState = 2;
    public Interpolator mDisappearInterpolator = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
    public Interpolator mAppearInterpolator = new COUILinearInterpolator();
    private boolean mNeedAutoStartDisAppear = false;
    private boolean mIfDisappearWhenGetCancelEvent = true;
    private boolean mIsNeedVibrate = false;
    private boolean mActionIsFromTouchListView = false;
    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() { // from class: com.coui.appcompat.list.COUIBackgroundAnimationUtil.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.isEnabled() && view.isClickable()) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 3) {
                            if (COUIBackgroundAnimationUtil.this.mIfDisappearWhenGetCancelEvent) {
                                COUIBackgroundAnimationUtil.this.startDisAppearAnimationOrNot();
                            }
                            COUIBackgroundAnimationUtil.this.mActionIsFromTouchListView = false;
                        }
                    } else {
                        COUIBackgroundAnimationUtil.this.startDisAppearAnimationOrNot();
                        COUIBackgroundAnimationUtil.this.mActionIsFromTouchListView = false;
                    }
                } else {
                    if (motionEvent.getSource() == -1) {
                        COUIBackgroundAnimationUtil.this.mActionIsFromTouchListView = true;
                    }
                    COUIBackgroundAnimationUtil.this.startAppearAnimation();
                }
            }
            return false;
        }
    };

    private void cancelAnimation() {
        ValueAnimator valueAnimator = this.mBackgroundDisappearAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mBackgroundDisappearAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mBackgroundAppearAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mBackgroundAppearAnimator.cancel();
        }
    }

    private void performHapticFeedback() {
        View view;
        if (this.mIsNeedVibrate && (view = this.mTargetView) != null && this.mActionIsFromTouchListView) {
            view.performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        }
    }

    public void init(View view, int i10, int i11) {
        init(view, i10, i11, false);
    }

    public View.OnTouchListener operateTouchListener(boolean z10) {
        View view = this.mTargetView;
        if (view != null) {
            if (!z10) {
                view.setOnTouchListener(this.mOnTouchListener);
                return null;
            }
            return this.mOnTouchListener;
        }
        throw new IllegalArgumentException("Must be called after the init method");
    }

    public void refreshCardBg(int i10) {
        View view = this.mTargetView;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setAppearDuration(int i10) {
        this.mAppearDuration = i10;
    }

    public void setDisappearDuration(int i10) {
        this.mDisappearDuration = i10;
    }

    public void setIfDisappearWhenGetCancelEvent(boolean z10) {
        this.mIfDisappearWhenGetCancelEvent = z10;
    }

    public void setIsSelected(boolean z10) {
        setIsSelected(z10, false);
    }

    public void startAppearAnimation() {
        if (!this.mIsSelected) {
            if (this.mBackgroundDisappearAnimator.isRunning()) {
                this.mBackgroundDisappearAnimator.cancel();
            }
            if (this.mBackgroundAppearAnimator.isRunning()) {
                this.mBackgroundAppearAnimator.cancel();
            }
            this.mBackgroundAppearAnimator.start();
            performHapticFeedback();
        }
    }

    public void startDisAppearAnimationOrNot() {
        if (this.mBackgroundAppearAnimator.isRunning()) {
            this.mNeedAutoStartDisAppear = true;
        } else if (!this.mBackgroundDisappearAnimator.isRunning() && this.mState == 1 && !this.mIsSelected) {
            this.mBackgroundDisappearAnimator.start();
        }
    }

    public void init(View view, int i10, int i11, boolean z10) {
        this.mIsNeedVibrate = z10;
        this.mTargetView = view;
        this.mPressColor = i11;
        this.mDefaultColor = i10;
        ValueAnimator valueAnimator = this.mBackgroundAppearAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mBackgroundAppearAnimator.end();
            this.mBackgroundAppearAnimator = null;
        }
        ValueAnimator valueAnimator2 = this.mBackgroundDisappearAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mBackgroundDisappearAnimator.end();
            this.mBackgroundDisappearAnimator = null;
        }
        this.mBackgroundAppearAnimator = ObjectAnimator.ofInt(view, "backgroundColor", i10, i11);
        this.mBackgroundDisappearAnimator = ObjectAnimator.ofInt(view, "backgroundColor", i11, i10);
        this.mBackgroundAppearAnimator.setDuration(this.mAppearDuration);
        this.mBackgroundAppearAnimator.setInterpolator(this.mAppearInterpolator);
        this.mBackgroundAppearAnimator.setEvaluator(new ArgbEvaluator());
        this.mBackgroundAppearAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.list.COUIBackgroundAnimationUtil.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIBackgroundAnimationUtil cOUIBackgroundAnimationUtil = COUIBackgroundAnimationUtil.this;
                cOUIBackgroundAnimationUtil.mState = 1;
                if (cOUIBackgroundAnimationUtil.mNeedAutoStartDisAppear) {
                    COUIBackgroundAnimationUtil.this.mNeedAutoStartDisAppear = false;
                    if (!COUIBackgroundAnimationUtil.this.mIsSelected) {
                        COUIBackgroundAnimationUtil.this.mBackgroundDisappearAnimator.start();
                    }
                }
            }
        });
        this.mBackgroundDisappearAnimator.setDuration(this.mDisappearDuration);
        this.mBackgroundDisappearAnimator.setInterpolator(this.mDisappearInterpolator);
        this.mBackgroundDisappearAnimator.setEvaluator(new ArgbEvaluator());
        this.mBackgroundDisappearAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.list.COUIBackgroundAnimationUtil.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                if (COUIBackgroundAnimationUtil.this.mIsSelected) {
                    COUIBackgroundAnimationUtil.this.mBackgroundDisappearAnimator.cancel();
                }
            }
        });
        this.mBackgroundDisappearAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.list.COUIBackgroundAnimationUtil.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIBackgroundAnimationUtil.this.mState = 2;
            }
        });
    }

    public void setIsSelected(boolean z10, boolean z11) {
        if (this.mIsSelected != z10) {
            this.mIsSelected = z10;
            cancelAnimation();
            if (z10) {
                if (!z11) {
                    refreshCardBg(this.mPressColor);
                    return;
                }
                ValueAnimator valueAnimator = this.mBackgroundAppearAnimator;
                if (valueAnimator != null) {
                    valueAnimator.start();
                    return;
                }
                return;
            }
            if (!z11) {
                refreshCardBg(this.mDefaultColor);
                return;
            }
            ValueAnimator valueAnimator2 = this.mBackgroundDisappearAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }
}
