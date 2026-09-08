package com.coui.appcompat.progressbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.dynamicanimation.animation.c;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.animation.COUIOutEaseInterpolator;

/* loaded from: classes.dex */
public class COUICircularProgressDrawable extends Drawable {
    private static final int ACCURACY = 100;
    private static final boolean DEBUG = false;
    private static final float DEFAULT_ALPHA_START_FRACTION = 0.7f;
    private static final long DEFAULT_DELAY = 200;
    private static final long DEFAULT_ERROR_DURATION = 350;
    private static final long DEFAULT_ICON_PAUSE_DURATION = 300;
    private static final long DEFAULT_ICON_RESUME_DURATION = 200;
    private static final float DEFAULT_MIN_PROGRESS_VALUE = 1.0E-4f;
    private static final long DEFAULT_PROGRESS_PAUSE_DURATION = 200;
    private static final long DEFAULT_PROGRESS_RESUME_DURATION = 200;
    private static final int FULL_ALPHA = 255;
    private static final int FULL_DEGREE = 360;
    private static final int ORIGINAL_ANGLE = -90;
    private static final String TAG = "COUICircularDrawable";
    private int mActualProgress;
    private float mCenterX;
    private float mCenterY;
    private AnimatorSet mErrorAnimatorSet;
    private float mErrorIconCircleBias;
    private float mErrorIconCircleRadius;
    private int mErrorIconColor;
    private float mErrorIconRectBias;
    private float mErrorIconRectHeight;
    private float mErrorIconRectWidth;
    private View mHostView;
    private ValueAnimator mIconErrorAnimator;
    private float mIconErrorScale;
    private Paint mIconPaint;
    private ValueAnimator mIconPauseAnimator;
    private float mIconPauseScale;
    private ValueAnimator mIconRecoverAnimator;
    private ValueAnimator mIconResumeAnimator;
    private OnProgressChangedListener mOnProgressChangedListener;
    private OnProgressStateAnimatorListener mOnProgressStateAnimatorListener;
    private AnimatorSet mPauseAnimatorSet;
    private int mPauseIconColor;
    private float mPauseIconRectGap;
    private float mPauseIconRectHeight;
    private float mPauseIconRectRadius;
    private float mPauseIconRectWidth;
    private float mProgressBarOuterDiameter;
    private float mProgressBarStrokeWidth;
    private ValueAnimator mProgressEnlargeAnimator;
    private Paint mProgressPaint;
    private ValueAnimator mProgressPauseAnimator;
    private ProgressBarStyleProperty mProgressProperty;
    private ValueAnimator mProgressResumeAnimator;
    private ValueAnimator mProgressShrinkAnimator;
    private AnimatorSet mRecoverAnimatorSet;
    private AnimatorSet mResumeAnimatorSet;
    private float mShadowRadius;
    private float mShadowXBias;
    private float mShadowYBias;
    private androidx.dynamicanimation.animation.f mSpringAnimation;
    private Paint mTrackPaint;
    private ProgressBarStyleProperty mTrackProperty;
    private float mVisualProgress;
    private static final Interpolator DEFAULT_LINEAR_INTERPOLATOR = new COUILinearInterpolator();
    private static final Interpolator DEFAULT_IN_EASE_INTERPOLATOR = new COUIInEaseInterpolator();
    private static final Interpolator DEFAULT_OUT_EASE_INTERPOLATOR = new COUIOutEaseInterpolator();
    private static final Interpolator DEFAULT_MOVE_EASE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final ArgbEvaluator ColorEvaluator = new ArgbEvaluator();
    private static final androidx.dynamicanimation.animation.d<COUICircularProgressDrawable> VISUAL_PROGRESS = new androidx.dynamicanimation.animation.d<COUICircularProgressDrawable>("visualProgress") { // from class: com.coui.appcompat.progressbar.COUICircularProgressDrawable.1
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(COUICircularProgressDrawable cOUICircularProgressDrawable) {
            return cOUICircularProgressDrawable.getVisualProgress();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(COUICircularProgressDrawable cOUICircularProgressDrawable, float f10) {
            cOUICircularProgressDrawable.setVisualProgress(f10);
            cOUICircularProgressDrawable.notifyVisualProgressChanged();
        }
    };
    private int mGlobalAlpha = 255;
    private int mProgressBarAlpha = 255;
    private int mMax = 100;
    private int mCurrentPauseIconAlpha = 0;
    private int mCurrentErrorIconAlpha = 0;
    private int mShadowColor = 0;
    private boolean mAnimating = false;

    /* loaded from: classes.dex */
    public static class ProgressBarStyleProperty {
        private int mCurrentBarColor;
        private float mProgressBarCurrentOuterDiameter;
        private float mProgressBarCurrentStrokeWidth;
        private int mProgressBarErrorColor;
        private float mProgressBarErrorOuterDiameter = Float.MIN_VALUE;
        private float mProgressBarErrorStrokeWidth = Float.MIN_VALUE;
        private float mProgressBarCenterX = 0.0f;
        private float mProgressBarCenterY = 0.0f;
        private float mProgressBarStrokeWidth = 0.0f;
        private float mProgressBarOuterDiameter = 0.0f;
        private int mProgressBarColor = 0;

        public int getCurrentBarColor() {
            return this.mCurrentBarColor;
        }

        public float getProgressBarCenterX() {
            return this.mProgressBarCenterX;
        }

        public float getProgressBarCenterY() {
            return this.mProgressBarCenterY;
        }

        public int getProgressBarColor() {
            return this.mProgressBarColor;
        }

        public float getProgressBarCurrentOuterDiameter() {
            return this.mProgressBarCurrentOuterDiameter;
        }

        public float getProgressBarCurrentStrokeWidth() {
            return this.mProgressBarCurrentStrokeWidth;
        }

        public int getProgressBarErrorColor() {
            return this.mProgressBarErrorColor;
        }

        public float getProgressBarErrorOuterDiameter() {
            if (this.mProgressBarErrorStrokeWidth == Float.MIN_VALUE) {
                return this.mProgressBarOuterDiameter;
            }
            return this.mProgressBarErrorOuterDiameter;
        }

        public float getProgressBarErrorStrokeWidth() {
            float f10 = this.mProgressBarErrorStrokeWidth;
            if (f10 == Float.MIN_VALUE) {
                return this.mProgressBarStrokeWidth;
            }
            return f10;
        }

        public float getProgressBarOuterDiameter() {
            return this.mProgressBarOuterDiameter;
        }

        public float getProgressBarStrokeWidth() {
            return this.mProgressBarStrokeWidth;
        }

        public void setCurrentBarColor(int i10) {
            this.mCurrentBarColor = i10;
        }

        public void setProgressBarCenterX(float f10) {
            this.mProgressBarCenterX = f10;
        }

        public void setProgressBarCenterY(float f10) {
            this.mProgressBarCenterY = f10;
        }

        public void setProgressBarColor(int i10) {
            this.mProgressBarColor = i10;
            this.mCurrentBarColor = i10;
        }

        public void setProgressBarCurrentOuterDiameter(float f10) {
            if (f10 < 0.0f) {
                Log.w(COUICircularProgressDrawable.TAG, "Progress bar outer diameter should be greater than 0 !");
            }
            this.mProgressBarCurrentOuterDiameter = Math.max(0.0f, f10);
        }

        public void setProgressBarCurrentStrokeWidth(float f10) {
            if (f10 < 0.0f) {
                Log.w(COUICircularProgressDrawable.TAG, "Progress bar stroke width should be greater than 0 !");
            }
            this.mProgressBarCurrentStrokeWidth = Math.max(0.0f, f10);
        }

        public void setProgressBarErrorColor(int i10) {
            this.mProgressBarErrorColor = i10;
        }

        public void setProgressBarErrorOuterDiameter(float f10) {
            if (f10 < 0.0f) {
                Log.w(COUICircularProgressDrawable.TAG, "Progress bar outer diameter should be greater than 0 !");
            }
            this.mProgressBarErrorOuterDiameter = Math.max(0.0f, f10);
        }

        public void setProgressBarErrorStrokeWidth(float f10) {
            if (f10 < 0.0f) {
                Log.w(COUICircularProgressDrawable.TAG, "Progress bar stroke width should be greater than 0 !");
            }
            this.mProgressBarErrorStrokeWidth = Math.max(0.0f, f10);
        }

        public void setProgressBarOuterDiameter(float f10) {
            if (f10 < 0.0f) {
                Log.w(COUICircularProgressDrawable.TAG, "Progress bar outer diameter should be greater than 0 !");
            }
            this.mProgressBarOuterDiameter = Math.max(0.0f, f10);
        }

        public void setProgressBarStrokeWidth(float f10) {
            if (f10 < 0.0f) {
                Log.w(COUICircularProgressDrawable.TAG, "Progress bar stroke width should be greater than 0 !");
            }
            this.mProgressBarStrokeWidth = Math.max(0.0f, f10);
        }
    }

    public COUICircularProgressDrawable(Context context) {
        initAttr(context);
        initPaint();
        initAnimator();
    }

    private float actual2VisualProgress(float f10) {
        return (((int) ((f10 * 100.0f) / r2)) / 100.0f) * this.mMax;
    }

    private void drawErrorIcon(Canvas canvas) {
        int i10 = this.mCurrentErrorIconAlpha;
        if (i10 != 0) {
            canvas.saveLayerAlpha(0.0f, 0.0f, this.mCenterX * 2.0f, this.mCenterY * 2.0f, i10);
            float f10 = this.mIconErrorScale;
            canvas.scale(f10, f10, this.mCenterX, this.mCenterY);
            this.mIconPaint.setColor(this.mErrorIconColor);
            float f11 = this.mCenterX;
            float f12 = this.mErrorIconRectWidth;
            float f13 = this.mCenterY;
            float f14 = this.mErrorIconRectBias;
            canvas.drawRect(f11 - (f12 / 2.0f), f13 - f14, f11 + (f12 / 2.0f), (f13 - f14) + this.mErrorIconRectHeight, this.mIconPaint);
            canvas.drawCircle(this.mCenterX, this.mCenterY + this.mErrorIconCircleBias, this.mErrorIconCircleRadius, this.mIconPaint);
            canvas.restore();
        }
    }

    private void drawPauseIcon(Canvas canvas) {
        int i10 = this.mCurrentPauseIconAlpha;
        if (i10 != 0) {
            canvas.saveLayerAlpha(0.0f, 0.0f, this.mCenterX * 2.0f, this.mCenterY * 2.0f, i10);
            float f10 = this.mIconPauseScale;
            canvas.scale(f10, f10, this.mCenterX, this.mCenterY);
            this.mIconPaint.setColor(this.mPauseIconColor);
            float f11 = this.mCenterX;
            float f12 = f11 - this.mPauseIconRectWidth;
            float f13 = this.mPauseIconRectGap;
            float f14 = f12 - (f13 / 2.0f);
            float f15 = this.mCenterY;
            float f16 = this.mPauseIconRectHeight;
            float f17 = this.mPauseIconRectRadius;
            canvas.drawRoundRect(f14, f15 - (f16 / 2.0f), f11 - (f13 / 2.0f), f15 + (f16 / 2.0f), f17, f17, this.mIconPaint);
            float f18 = this.mCenterX;
            float f19 = this.mPauseIconRectGap;
            float f20 = this.mCenterY;
            float f21 = this.mPauseIconRectHeight;
            float f22 = this.mPauseIconRectRadius;
            canvas.drawRoundRect(f18 + (f19 / 2.0f), f20 - (f21 / 2.0f), f18 + this.mPauseIconRectWidth + (f19 / 2.0f), f20 + (f21 / 2.0f), f22, f22, this.mIconPaint);
            canvas.restore();
        }
    }

    private void drawProgress(Canvas canvas) {
        float progressBarCurrentOuterDiameter = (this.mTrackProperty.getProgressBarCurrentOuterDiameter() - this.mTrackProperty.getProgressBarCurrentStrokeWidth()) / 2.0f;
        float progressBarCurrentOuterDiameter2 = (this.mProgressProperty.getProgressBarCurrentOuterDiameter() - this.mProgressProperty.getProgressBarCurrentStrokeWidth()) / 2.0f;
        int i10 = this.mProgressBarAlpha;
        if (i10 != 255) {
            canvas.saveLayerAlpha(0.0f, 0.0f, this.mCenterX * 2.0f, this.mCenterY * 2.0f, i10);
        } else {
            canvas.save();
        }
        canvas.drawCircle(this.mCenterX, this.mCenterY, progressBarCurrentOuterDiameter, this.mTrackPaint);
        canvas.rotate(-90.0f, this.mCenterX, this.mCenterY);
        canvas.drawArc(this.mProgressProperty.getProgressBarCenterX() - progressBarCurrentOuterDiameter2, this.mProgressProperty.getProgressBarCenterY() - progressBarCurrentOuterDiameter2, this.mProgressProperty.getProgressBarCenterX() + progressBarCurrentOuterDiameter2, this.mProgressProperty.getProgressBarCenterY() + progressBarCurrentOuterDiameter2, 0.0f, Math.max(DEFAULT_MIN_PROGRESS_VALUE, (this.mVisualProgress * 360.0f) / this.mMax), false, this.mProgressPaint);
        canvas.restore();
    }

    private void initAnimator() {
        initSpring();
        initPauseAnimator();
        initResumeAnimator();
        initErrorAnimator();
        initRecoverAnimator();
    }

    private void initAttr(Context context) {
        this.mPauseIconRectWidth = context.getResources().getDimension(X8.f.f4609V0);
        this.mPauseIconRectHeight = context.getResources().getDimension(X8.f.f4595T0);
        this.mPauseIconRectRadius = context.getResources().getDimension(X8.f.f4602U0);
        this.mPauseIconRectGap = context.getResources().getDimension(X8.f.f4588S0);
        this.mErrorIconRectWidth = context.getResources().getDimension(X8.f.f4546M0);
        this.mErrorIconRectHeight = context.getResources().getDimension(X8.f.f4539L0);
        this.mErrorIconRectBias = context.getResources().getDimension(X8.f.f4532K0);
        this.mErrorIconCircleRadius = context.getResources().getDimension(X8.f.f4525J0);
        this.mErrorIconCircleBias = context.getResources().getDimension(X8.f.f4518I0);
        this.mShadowRadius = context.getResources().getDimension(X8.f.f4616W0);
        this.mShadowXBias = context.getResources().getDimension(X8.f.f4623X0);
        this.mShadowYBias = context.getResources().getDimension(X8.f.f4630Y0);
        this.mShadowColor = A.h.d(context.getResources(), X8.e.f4438d, context.getTheme());
    }

    private void initErrorAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mProgressShrinkAnimator = ofFloat;
        ofFloat.setDuration(DEFAULT_ERROR_DURATION);
        ValueAnimator valueAnimator = this.mProgressShrinkAnimator;
        Interpolator interpolator = DEFAULT_MOVE_EASE_INTERPOLATOR;
        valueAnimator.setInterpolator(interpolator);
        this.mProgressShrinkAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUICircularProgressDrawable.this.lambda$initErrorAnimator$5(valueAnimator2);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mIconErrorAnimator = ofFloat2;
        ofFloat2.setDuration(DEFAULT_ERROR_DURATION);
        this.mIconErrorAnimator.setInterpolator(interpolator);
        this.mIconErrorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUICircularProgressDrawable.this.lambda$initErrorAnimator$6(valueAnimator2);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mErrorAnimatorSet = animatorSet;
        animatorSet.playTogether(this.mIconErrorAnimator, this.mProgressShrinkAnimator);
        this.mErrorAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.progressbar.COUICircularProgressDrawable.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = false;
                if (COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener != null) {
                    COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener.onErrorAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = true;
                if (COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener != null) {
                    COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener.onErrorAnimationStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void initPaint() {
        Paint paint = new Paint(1);
        this.mTrackPaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.mTrackProperty = new ProgressBarStyleProperty();
        Paint paint2 = new Paint(1);
        this.mProgressPaint = paint2;
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressPaint.setStyle(style);
        this.mProgressPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mProgressProperty = new ProgressBarStyleProperty();
        Paint paint3 = new Paint(1);
        this.mIconPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
    }

    private void initPauseAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mProgressPauseAnimator = ofFloat;
        ofFloat.setDuration(200L);
        this.mProgressPauseAnimator.setInterpolator(DEFAULT_LINEAR_INTERPOLATOR);
        this.mProgressPauseAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUICircularProgressDrawable.this.lambda$initPauseAnimator$1(valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mIconPauseAnimator = ofFloat2;
        ofFloat2.setStartDelay(200L);
        this.mIconPauseAnimator.setDuration(DEFAULT_ICON_PAUSE_DURATION);
        this.mIconPauseAnimator.setInterpolator(DEFAULT_IN_EASE_INTERPOLATOR);
        this.mIconPauseAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUICircularProgressDrawable.this.lambda$initPauseAnimator$2(valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mPauseAnimatorSet = animatorSet;
        animatorSet.playTogether(this.mIconPauseAnimator, this.mProgressPauseAnimator);
        this.mPauseAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.progressbar.COUICircularProgressDrawable.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = false;
                if (COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener != null) {
                    COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener.onPauseAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = true;
                if (COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener != null) {
                    COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener.onPauseAnimationStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void initRecoverAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mProgressEnlargeAnimator = ofFloat;
        ofFloat.setDuration(DEFAULT_ERROR_DURATION);
        ValueAnimator valueAnimator = this.mProgressEnlargeAnimator;
        Interpolator interpolator = DEFAULT_MOVE_EASE_INTERPOLATOR;
        valueAnimator.setInterpolator(interpolator);
        this.mProgressEnlargeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUICircularProgressDrawable.this.lambda$initRecoverAnimator$7(valueAnimator2);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mIconRecoverAnimator = ofFloat2;
        ofFloat2.setDuration(DEFAULT_ERROR_DURATION);
        this.mIconRecoverAnimator.setInterpolator(interpolator);
        this.mIconRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUICircularProgressDrawable.this.lambda$initRecoverAnimator$8(valueAnimator2);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mRecoverAnimatorSet = animatorSet;
        animatorSet.playTogether(this.mIconRecoverAnimator, this.mProgressEnlargeAnimator);
        this.mRecoverAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.progressbar.COUICircularProgressDrawable.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = false;
                if (COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener != null) {
                    COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener.onRecoverAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = true;
                if (COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener != null) {
                    COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener.onRecoverAnimationStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void initResumeAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mProgressResumeAnimator = ofFloat;
        ofFloat.setStartDelay(200L);
        this.mProgressResumeAnimator.setDuration(200L);
        this.mProgressResumeAnimator.setInterpolator(DEFAULT_OUT_EASE_INTERPOLATOR);
        this.mProgressResumeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUICircularProgressDrawable.this.lambda$initResumeAnimator$3(valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mIconResumeAnimator = ofFloat2;
        ofFloat2.setDuration(200L);
        this.mIconResumeAnimator.setInterpolator(DEFAULT_LINEAR_INTERPOLATOR);
        this.mIconResumeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUICircularProgressDrawable.this.lambda$initResumeAnimator$4(valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mResumeAnimatorSet = animatorSet;
        animatorSet.playTogether(this.mProgressResumeAnimator, this.mIconResumeAnimator);
        this.mResumeAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.progressbar.COUICircularProgressDrawable.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = false;
                if (COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener != null) {
                    COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener.onResumeAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUICircularProgressDrawable.this.mAnimating = true;
                if (COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener != null) {
                    COUICircularProgressDrawable.this.mOnProgressStateAnimatorListener.onResumeAnimationStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void initSpring() {
        androidx.dynamicanimation.animation.g gVar = new androidx.dynamicanimation.animation.g();
        gVar.d(1.0f);
        gVar.f(50.0f);
        androidx.dynamicanimation.animation.f fVar = new androidx.dynamicanimation.animation.f(this, VISUAL_PROGRESS);
        this.mSpringAnimation = fVar;
        fVar.x(gVar);
        this.mSpringAnimation.b(new c.r() { // from class: com.coui.appcompat.progressbar.c
            @Override // androidx.dynamicanimation.animation.c.r
            public final void onAnimationUpdate(androidx.dynamicanimation.animation.c cVar, float f10, float f11) {
                COUICircularProgressDrawable.this.lambda$initSpring$0(cVar, f10, f11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initErrorAnimator$5(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float f10 = 1.0f - animatedFraction;
        float progressBarErrorOuterDiameter = this.mProgressProperty.getProgressBarErrorOuterDiameter() + ((this.mProgressProperty.getProgressBarOuterDiameter() - this.mProgressProperty.getProgressBarErrorOuterDiameter()) * f10);
        float progressBarErrorOuterDiameter2 = this.mTrackProperty.getProgressBarErrorOuterDiameter() + ((this.mTrackProperty.getProgressBarOuterDiameter() - this.mTrackProperty.getProgressBarErrorOuterDiameter()) * f10);
        float progressBarErrorStrokeWidth = this.mProgressProperty.getProgressBarErrorStrokeWidth() + ((this.mProgressProperty.getProgressBarStrokeWidth() - this.mProgressProperty.getProgressBarErrorStrokeWidth()) * f10);
        float progressBarErrorStrokeWidth2 = this.mTrackProperty.getProgressBarErrorStrokeWidth() + (f10 * (this.mTrackProperty.getProgressBarStrokeWidth() - this.mTrackProperty.getProgressBarErrorStrokeWidth()));
        ArgbEvaluator argbEvaluator = ColorEvaluator;
        int intValue = ((Integer) argbEvaluator.evaluate(animatedFraction, Integer.valueOf(this.mTrackProperty.getProgressBarColor()), Integer.valueOf(this.mTrackProperty.getProgressBarErrorColor()))).intValue();
        int intValue2 = ((Integer) argbEvaluator.evaluate(animatedFraction, Integer.valueOf(this.mProgressProperty.getProgressBarColor()), Integer.valueOf(this.mProgressProperty.getProgressBarErrorColor()))).intValue();
        this.mProgressProperty.setProgressBarCurrentOuterDiameter(progressBarErrorOuterDiameter);
        this.mProgressProperty.setProgressBarCurrentStrokeWidth(progressBarErrorStrokeWidth);
        this.mProgressProperty.setCurrentBarColor(intValue2);
        this.mTrackProperty.setProgressBarCurrentOuterDiameter(progressBarErrorOuterDiameter2);
        this.mTrackProperty.setProgressBarCurrentStrokeWidth(progressBarErrorStrokeWidth2);
        this.mTrackProperty.setCurrentBarColor(intValue);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initErrorAnimator$6(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.mIconErrorScale = (0.3f * animatedFraction) + DEFAULT_ALPHA_START_FRACTION;
        this.mCurrentErrorIconAlpha = (int) (animatedFraction * 255.0f);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPauseAnimator$1(ValueAnimator valueAnimator) {
        this.mProgressBarAlpha = (int) ((1.0f - valueAnimator.getAnimatedFraction()) * 255.0f);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPauseAnimator$2(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.mCurrentPauseIconAlpha = (int) (255.0f * animatedFraction);
        this.mIconPauseScale = (animatedFraction * 0.3f) + DEFAULT_ALPHA_START_FRACTION;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRecoverAnimator$7(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float progressBarErrorOuterDiameter = this.mProgressProperty.getProgressBarErrorOuterDiameter() + ((this.mProgressProperty.getProgressBarOuterDiameter() - this.mProgressProperty.getProgressBarErrorOuterDiameter()) * animatedFraction);
        float progressBarErrorOuterDiameter2 = this.mTrackProperty.getProgressBarErrorOuterDiameter() + ((this.mTrackProperty.getProgressBarOuterDiameter() - this.mTrackProperty.getProgressBarErrorOuterDiameter()) * animatedFraction);
        float progressBarErrorStrokeWidth = this.mProgressProperty.getProgressBarErrorStrokeWidth() + ((this.mProgressProperty.getProgressBarStrokeWidth() - this.mProgressProperty.getProgressBarErrorStrokeWidth()) * animatedFraction);
        float progressBarErrorStrokeWidth2 = this.mTrackProperty.getProgressBarErrorStrokeWidth() + ((this.mTrackProperty.getProgressBarStrokeWidth() - this.mTrackProperty.getProgressBarErrorStrokeWidth()) * animatedFraction);
        ArgbEvaluator argbEvaluator = ColorEvaluator;
        int intValue = ((Integer) argbEvaluator.evaluate(animatedFraction, Integer.valueOf(this.mTrackProperty.getProgressBarErrorColor()), Integer.valueOf(this.mTrackProperty.getProgressBarColor()))).intValue();
        int intValue2 = ((Integer) argbEvaluator.evaluate(animatedFraction, Integer.valueOf(this.mProgressProperty.getProgressBarErrorColor()), Integer.valueOf(this.mProgressProperty.getProgressBarColor()))).intValue();
        this.mProgressProperty.setProgressBarCurrentOuterDiameter(progressBarErrorOuterDiameter);
        this.mProgressProperty.setProgressBarCurrentStrokeWidth(progressBarErrorStrokeWidth);
        this.mProgressProperty.setCurrentBarColor(intValue2);
        this.mTrackProperty.setProgressBarCurrentOuterDiameter(progressBarErrorOuterDiameter2);
        this.mTrackProperty.setProgressBarCurrentStrokeWidth(progressBarErrorStrokeWidth2);
        this.mTrackProperty.setCurrentBarColor(intValue);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initRecoverAnimator$8(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        this.mIconErrorScale = (0.3f * animatedFraction) + DEFAULT_ALPHA_START_FRACTION;
        this.mCurrentErrorIconAlpha = (int) (animatedFraction * 255.0f);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initResumeAnimator$3(ValueAnimator valueAnimator) {
        this.mProgressBarAlpha = (int) (valueAnimator.getAnimatedFraction() * 255.0f);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initResumeAnimator$4(ValueAnimator valueAnimator) {
        this.mCurrentPauseIconAlpha = (int) ((1.0f - valueAnimator.getAnimatedFraction()) * 255.0f);
        this.mIconPauseScale = 1.0f;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSpring$0(androidx.dynamicanimation.animation.c cVar, float f10, float f11) {
        invalidateSelf();
    }

    private void notifyActualProgressChanged() {
        OnProgressChangedListener onProgressChangedListener = this.mOnProgressChangedListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onProgressChanged(this.mActualProgress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyVisualProgressChanged() {
        OnProgressChangedListener onProgressChangedListener = this.mOnProgressChangedListener;
        if (onProgressChangedListener != null) {
            onProgressChangedListener.onVisualProgressChanged(this.mVisualProgress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisualProgress(float f10) {
        this.mVisualProgress = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mTrackPaint.setColor(this.mTrackProperty.getCurrentBarColor());
        this.mTrackPaint.setStrokeWidth(this.mTrackProperty.getProgressBarCurrentStrokeWidth());
        this.mProgressPaint.setColor(this.mProgressProperty.getCurrentBarColor());
        this.mProgressPaint.setStrokeWidth(this.mProgressProperty.getProgressBarCurrentStrokeWidth());
        canvas.saveLayerAlpha(0.0f, 0.0f, this.mCenterX * 2.0f, this.mCenterY * 2.0f, this.mGlobalAlpha);
        drawProgress(canvas);
        drawPauseIcon(canvas);
        drawErrorIcon(canvas);
        canvas.restore();
    }

    public void error() {
        this.mErrorAnimatorSet.start();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mGlobalAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getVisualProgress() {
        return this.mVisualProgress;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        View view = this.mHostView;
        if (view != null) {
            view.invalidate();
        }
    }

    public boolean isAnimating() {
        return this.mAnimating;
    }

    public void pause() {
        this.mPauseAnimatorSet.start();
    }

    public void recover() {
        this.mRecoverAnimatorSet.start();
    }

    public void recycle() {
        this.mHostView = null;
    }

    public void resume() {
        this.mResumeAnimatorSet.start();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.mGlobalAlpha = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        invalidateSelf();
    }

    public void setErrorIconColor(int i10) {
        this.mErrorIconColor = i10;
        this.mTrackProperty.setProgressBarErrorColor(i10);
        this.mProgressProperty.setProgressBarErrorColor(i10);
    }

    public void setHostView(View view) {
        this.mHostView = view;
    }

    public void setIsDrawShadow(boolean z10) {
        if (z10) {
            this.mTrackPaint.setShadowLayer(this.mShadowRadius, this.mShadowXBias, this.mShadowYBias, this.mShadowColor);
            this.mIconPaint.setShadowLayer(this.mShadowRadius, this.mShadowXBias, this.mShadowYBias, this.mShadowColor);
        } else {
            this.mTrackPaint.clearShadowLayer();
            this.mIconPaint.clearShadowLayer();
        }
    }

    public void setMax(int i10) {
        if (i10 < 0) {
            Log.w(TAG, "Max value should not lesser than 0!");
            i10 = 0;
        }
        if (i10 != this.mMax) {
            if (i10 < this.mActualProgress) {
                this.mActualProgress = i10;
                this.mVisualProgress = i10;
            }
            this.mMax = i10;
        }
        invalidateSelf();
    }

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.mOnProgressChangedListener = onProgressChangedListener;
    }

    public void setOnProgressStateAnimatorListener(OnProgressStateAnimatorListener onProgressStateAnimatorListener) {
        this.mOnProgressStateAnimatorListener = onProgressStateAnimatorListener;
    }

    public void setPauseIconColor(int i10) {
        this.mPauseIconColor = i10;
    }

    public void setProgress(int i10, boolean z10) {
        Log.d(TAG, "setProgress: " + i10 + "\nmActualProgress = " + this.mActualProgress + "\nmVisualProgress = " + this.mVisualProgress + "\nanimate = " + z10);
        this.mActualProgress = i10;
        float actual2VisualProgress = actual2VisualProgress((float) i10);
        if (z10) {
            float f10 = this.mVisualProgress;
            if (f10 != actual2VisualProgress) {
                this.mSpringAnimation.m(f10);
                this.mSpringAnimation.s(actual2VisualProgress);
                notifyActualProgressChanged();
            }
        }
        this.mVisualProgress = actual2VisualProgress;
        notifyVisualProgressChanged();
        invalidateSelf();
        notifyActualProgressChanged();
    }

    public void setProgressBarErrorColor(int i10) {
        this.mTrackProperty.setProgressBarErrorColor(i10);
        this.mProgressProperty.setProgressBarErrorColor(i10);
    }

    public void setProgressBarErrorSize(float f10, float f11) {
        this.mProgressProperty.setProgressBarErrorOuterDiameter(f10);
        this.mProgressProperty.setProgressBarErrorStrokeWidth(f11);
        this.mTrackProperty.setProgressBarErrorOuterDiameter(f10);
        this.mTrackProperty.setProgressBarErrorStrokeWidth(f11);
    }

    public void setProgressColor(int i10) {
        this.mProgressProperty.setProgressBarColor(i10);
        invalidateSelf();
    }

    public void setProperties(float f10, float f11, float f12, float f13) {
        this.mCenterX = f10;
        this.mCenterY = f11;
        this.mProgressBarOuterDiameter = f12;
        this.mProgressBarStrokeWidth = f13;
        this.mTrackProperty.setProgressBarCenterX(f10);
        this.mTrackProperty.setProgressBarCenterY(this.mCenterY);
        this.mTrackProperty.setProgressBarOuterDiameter(this.mProgressBarOuterDiameter);
        this.mTrackProperty.setProgressBarStrokeWidth(this.mProgressBarStrokeWidth);
        this.mTrackProperty.setProgressBarCurrentOuterDiameter(this.mProgressBarOuterDiameter);
        this.mTrackProperty.setProgressBarCurrentStrokeWidth(this.mProgressBarStrokeWidth);
        this.mProgressProperty.setProgressBarCenterX(this.mCenterX);
        this.mProgressProperty.setProgressBarCenterY(this.mCenterY);
        this.mProgressProperty.setProgressBarOuterDiameter(this.mProgressBarOuterDiameter);
        this.mProgressProperty.setProgressBarStrokeWidth(this.mProgressBarStrokeWidth);
        this.mProgressProperty.setProgressBarCurrentOuterDiameter(this.mProgressBarOuterDiameter);
        this.mProgressProperty.setProgressBarCurrentStrokeWidth(this.mProgressBarStrokeWidth);
        this.mTrackPaint.setStrokeWidth(this.mTrackProperty.getProgressBarStrokeWidth());
        this.mProgressPaint.setStrokeWidth(this.mProgressProperty.getProgressBarStrokeWidth());
    }

    public void setTrackColor(int i10) {
        this.mTrackProperty.setProgressBarColor(i10);
        invalidateSelf();
    }

    /* loaded from: classes.dex */
    public interface OnProgressChangedListener {
        default void onProgressChanged(int i10) {
        }

        default void onVisualProgressChanged(float f10) {
        }
    }

    /* loaded from: classes.dex */
    public interface OnProgressStateAnimatorListener {
        default void onErrorAnimationEnd() {
        }

        default void onErrorAnimationStart() {
        }

        default void onPauseAnimationEnd() {
        }

        default void onPauseAnimationStart() {
        }

        default void onRecoverAnimationEnd() {
        }

        default void onRecoverAnimationStart() {
        }

        default void onResumeAnimationEnd() {
        }

        default void onResumeAnimationStart() {
        }
    }
}
