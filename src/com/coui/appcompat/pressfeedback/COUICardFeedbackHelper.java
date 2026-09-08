package com.coui.appcompat.pressfeedback;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;

/* loaded from: classes.dex */
public class COUICardFeedbackHelper {
    private static final float CARD_DRAG_BASE_RATIO = 0.5f;
    private static final float CARD_DRAG_DISTANCE_DEFAULT = 70.0f;
    private static final float CARD_DRAG_TANGENT_MIN = 1.0f;
    private static final long CARD_MOVE_BACK_ANIM_DURATION = 300;
    private static final long CARD_PRESS_ANIM_DURATION = 200;
    private static final long CARD_RELEASE_ANIM_DURATION = 340;
    private static final float CARD_SCALE_MAX = 1.0f;
    private static final float CARD_SCALE_PRESS_DEFAULT = 0.98f;
    public static final int DRAG_DIRECTION_ALL = 15;
    public static final int DRAG_DIRECTION_DOWN = 8;
    public static final int DRAG_DIRECTION_HORIZONTAL = 3;
    public static final int DRAG_DIRECTION_LEFT = 1;
    public static final int DRAG_DIRECTION_NONE = 0;
    public static final int DRAG_DIRECTION_RIGHT = 2;
    public static final int DRAG_DIRECTION_UP = 4;
    public static final int DRAG_DIRECTION_VERTICAL = 12;
    private static final float UNSET = Float.MAX_VALUE;
    private Runnable mAfterDragAction;
    private Runnable mAfterUpdateAction;
    private Runnable mBeforeDragAction;
    private Runnable mBeforeUpdateAction;
    private int mCurDragDirection;
    private float mCurTranslateX;
    private float mCurTranslateY;
    private float mDownX;
    private float mDownY;
    private int mDragDirection;
    private float mDragMaxHorizontal;
    private float mDragMaxVertical;
    private float mDragRatio;
    private float mDragTangent;
    private boolean mEnableMoveBack;
    private boolean mEnableScale;
    private boolean mEnableSloping;
    private boolean mHasDrag;
    private float mLastScaleX;
    private float mLastScaleY;
    private float mLastX;
    private float mLastY;
    private float mMinScale;
    private final ValueAnimator mMoveBackAnimator;
    private float mMoveX;
    private float mMoveY;
    private final ValueAnimator mPressAnimator;
    private final View mProxyView;
    private final ValueAnimator mReleaseAnimator;
    private float mStartTranslateX;
    private float mStartTranslateY;
    private static final Interpolator CARD_PRESS_ANIM_INTERPOLATOR = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator CARD_RELEASE_ANIM_INTERPOLATOR = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);

    public COUICardFeedbackHelper(View view) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mPressAnimator = duration;
        ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(340L);
        this.mReleaseAnimator = duration2;
        ValueAnimator duration3 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(CARD_MOVE_BACK_ANIM_DURATION);
        this.mMoveBackAnimator = duration3;
        this.mDragDirection = 0;
        this.mCurDragDirection = 15;
        this.mMinScale = CARD_SCALE_PRESS_DEFAULT;
        this.mLastScaleX = UNSET;
        this.mLastScaleY = UNSET;
        this.mDragRatio = 0.5f;
        this.mDragTangent = 1.0f;
        this.mEnableScale = true;
        this.mEnableMoveBack = true;
        this.mEnableSloping = true;
        this.mHasDrag = false;
        this.mProxyView = view;
        duration.setInterpolator(CARD_PRESS_ANIM_INTERPOLATOR);
        duration2.setInterpolator(CARD_RELEASE_ANIM_INTERPOLATOR);
        duration3.setInterpolator(new COUIMoveEaseInterpolator());
        initPressAnim();
        initReleaseAnim();
        initMoveBackAnim();
        resetTouchParams();
        float dp2px = dp2px(view.getContext(), CARD_DRAG_DISTANCE_DEFAULT) * 1.0f;
        this.mDragMaxVertical = dp2px;
        this.mDragMaxHorizontal = dp2px;
    }

    private static int dp2px(Context context, float f10) {
        return Math.round(TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics()));
    }

    private float getRealDragDistance(float f10, float f11, float f12, float f13) {
        return f10 * this.mDragRatio * (1.0f - (Math.abs(f12 - f11) / f13));
    }

    private void initMoveBackAnim() {
        this.mMoveBackAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.pressfeedback.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUICardFeedbackHelper.this.lambda$initMoveBackAnim$2(valueAnimator);
            }
        });
        this.mMoveBackAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.pressfeedback.COUICardFeedbackHelper.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUICardFeedbackHelper.this.mStartTranslateX = COUICardFeedbackHelper.UNSET;
                COUICardFeedbackHelper.this.mStartTranslateY = COUICardFeedbackHelper.UNSET;
                COUICardFeedbackHelper.this.mCurDragDirection = 15;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void initPressAnim() {
        this.mPressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.pressfeedback.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUICardFeedbackHelper.this.lambda$initPressAnim$0(valueAnimator);
            }
        });
    }

    private void initReleaseAnim() {
        this.mReleaseAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.pressfeedback.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUICardFeedbackHelper.this.lambda$initReleaseAnim$1(valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initMoveBackAnim$2(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Runnable runnable = this.mBeforeUpdateAction;
        if (runnable != null) {
            runnable.run();
        }
        View view = this.mProxyView;
        float f10 = this.mCurTranslateX;
        view.setTranslationX(f10 - ((f10 - this.mStartTranslateX) * floatValue));
        View view2 = this.mProxyView;
        float f11 = this.mCurTranslateY;
        view2.setTranslationY(f11 - ((f11 - this.mStartTranslateY) * floatValue));
        Runnable runnable2 = this.mAfterUpdateAction;
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPressAnim$0(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Runnable runnable = this.mBeforeUpdateAction;
        if (runnable != null) {
            runnable.run();
        }
        this.mProxyView.setScaleX(this.mLastScaleX - ((this.mLastScaleY - this.mMinScale) * floatValue));
        View view = this.mProxyView;
        float f10 = this.mLastScaleY;
        view.setScaleY(f10 - ((f10 - this.mMinScale) * floatValue));
        Runnable runnable2 = this.mAfterUpdateAction;
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initReleaseAnim$1(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Runnable runnable = this.mBeforeUpdateAction;
        if (runnable != null) {
            runnable.run();
        }
        View view = this.mProxyView;
        float f10 = this.mLastScaleX;
        view.setScaleX(f10 + ((1.0f - f10) * floatValue));
        View view2 = this.mProxyView;
        float f11 = this.mLastScaleY;
        view2.setScaleY(f11 + ((1.0f - f11) * floatValue));
        Runnable runnable2 = this.mAfterUpdateAction;
        if (runnable2 != null) {
            runnable2.run();
        }
    }

    private void onDrag(float f10, float f11) {
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        int i10;
        if (!this.mHasDrag) {
            this.mHasDrag = true;
            Runnable runnable = this.mBeforeDragAction;
            if (runnable != null) {
                runnable.run();
            }
        }
        if (this.mStartTranslateX == UNSET || this.mStartTranslateY == UNSET) {
            this.mStartTranslateX = this.mProxyView.getTranslationX();
            this.mStartTranslateY = this.mProxyView.getTranslationY();
        }
        int i11 = this.mDragDirection;
        if ((i11 & 1) != 0) {
            f12 = this.mStartTranslateX - this.mDragMaxHorizontal;
        } else {
            f12 = this.mStartTranslateX;
        }
        if ((i11 & 2) != 0) {
            f13 = this.mStartTranslateX + this.mDragMaxHorizontal;
        } else {
            f13 = this.mStartTranslateX;
        }
        if ((i11 & 4) != 0) {
            f14 = this.mStartTranslateY - this.mDragMaxVertical;
        } else {
            f14 = this.mStartTranslateY;
        }
        if ((i11 & 8) != 0) {
            f15 = this.mStartTranslateY + this.mDragMaxVertical;
        } else {
            f15 = this.mStartTranslateY;
        }
        if ((i11 & 3) != 0) {
            f16 = Math.max(f12, Math.min(f13, this.mProxyView.getTranslationX() + getRealDragDistance(f10 - this.mLastX, this.mStartTranslateX, this.mProxyView.getTranslationX(), this.mDragMaxHorizontal)));
        } else {
            f16 = Float.MAX_VALUE;
        }
        if ((this.mDragDirection & 12) != 0) {
            f17 = Math.max(f14, Math.min(f15, this.mProxyView.getTranslationY() + getRealDragDistance(f11 - this.mLastY, this.mStartTranslateY, this.mProxyView.getTranslationY(), this.mDragMaxVertical)));
        } else {
            f17 = Float.MAX_VALUE;
        }
        if (!this.mEnableSloping && this.mCurDragDirection == 15) {
            if (f16 != UNSET && f17 != UNSET) {
                if (Math.abs(this.mStartTranslateX - f16) > Math.abs(this.mStartTranslateY - f17)) {
                    i10 = 3;
                } else {
                    i10 = 12;
                }
                this.mCurDragDirection = i10;
            }
            if (f16 != UNSET && f17 == UNSET) {
                this.mCurDragDirection = 3;
            }
            if (f16 == UNSET && f17 != UNSET) {
                this.mCurDragDirection = 12;
            }
        }
        Runnable runnable2 = this.mBeforeUpdateAction;
        if (runnable2 != null) {
            runnable2.run();
        }
        if (f16 != UNSET && (this.mCurDragDirection & 3) != 0) {
            this.mProxyView.setTranslationX(f16);
        }
        if (f17 != UNSET && (this.mCurDragDirection & 12) != 0) {
            this.mProxyView.setTranslationY(f17);
        }
        Runnable runnable3 = this.mAfterUpdateAction;
        if (runnable3 != null) {
            runnable3.run();
        }
    }

    private void resetTouchParams() {
        this.mDownX = UNSET;
        this.mDownY = UNSET;
        this.mLastX = UNSET;
        this.mLastY = UNSET;
        this.mMoveX = UNSET;
        this.mMoveY = UNSET;
    }

    private void startMoveBack() {
        if (this.mDownX == UNSET || this.mDownY == UNSET || !this.mHasDrag) {
            return;
        }
        this.mHasDrag = false;
        Runnable runnable = this.mAfterDragAction;
        if (runnable != null) {
            runnable.run();
        }
        if (!this.mEnableMoveBack) {
            return;
        }
        this.mCurTranslateX = this.mProxyView.getTranslationX();
        float translationY = this.mProxyView.getTranslationY();
        this.mCurTranslateY = translationY;
        float f10 = this.mCurTranslateX;
        float f11 = this.mStartTranslateX;
        if (f10 == f11 || f11 == UNSET) {
            float f12 = this.mStartTranslateY;
            if (translationY == f12 || f12 == UNSET) {
                return;
            }
        }
        this.mMoveBackAnimator.start();
    }

    private void startPressAnim() {
        if (!this.mEnableScale) {
            return;
        }
        if (this.mReleaseAnimator.isRunning()) {
            this.mReleaseAnimator.pause();
        }
        this.mLastScaleX = this.mProxyView.getScaleX();
        float scaleY = this.mProxyView.getScaleY();
        this.mLastScaleY = scaleY;
        float f10 = this.mLastScaleX;
        float f11 = this.mMinScale;
        if (f10 == f11 && scaleY == f11) {
            return;
        }
        this.mPressAnimator.start();
    }

    private void startReleaseAnim() {
        if (!this.mEnableScale) {
            return;
        }
        if (this.mPressAnimator.isRunning()) {
            this.mPressAnimator.pause();
        }
        this.mLastScaleX = this.mProxyView.getScaleX();
        float scaleY = this.mProxyView.getScaleY();
        this.mLastScaleY = scaleY;
        if (this.mLastScaleX == 1.0f && scaleY == 1.0f) {
            return;
        }
        this.mReleaseAnimator.start();
    }

    public void addMoveBackAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mMoveBackAnimator.addListener(animatorListener);
    }

    public void addMoveBackAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mMoveBackAnimator.addUpdateListener(animatorUpdateListener);
    }

    public void addPressAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mPressAnimator.addListener(animatorListener);
    }

    public void addPressAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mPressAnimator.addUpdateListener(animatorUpdateListener);
    }

    public void addReleaseAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mReleaseAnimator.addListener(animatorListener);
    }

    public void addReleaseAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mReleaseAnimator.addUpdateListener(animatorUpdateListener);
    }

    public void doAfterDrag(Runnable runnable) {
        this.mAfterDragAction = runnable;
    }

    public void doAfterUpdate(Runnable runnable) {
        this.mAfterUpdateAction = runnable;
    }

    public void doBeforeDrag(Runnable runnable) {
        this.mBeforeDragAction = runnable;
    }

    public void doBeforeUpdate(Runnable runnable) {
        this.mBeforeUpdateAction = runnable;
    }

    public int getDragDirection() {
        return this.mDragDirection;
    }

    public void handleTouchDown(MotionEvent motionEvent) {
        if (this.mMoveBackAnimator.isRunning()) {
            this.mMoveBackAnimator.pause();
        }
        resetTouchParams();
        this.mDownX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.mDownY = rawY;
        this.mLastX = this.mDownX;
        this.mLastY = rawY;
        startPressAnim();
    }

    public boolean handleTouchMove(MotionEvent motionEvent) {
        if (this.mMoveBackAnimator.isRunning()) {
            this.mMoveBackAnimator.pause();
        }
        if (this.mDownX == UNSET || this.mDownY == UNSET) {
            return false;
        }
        if (this.mMoveX == UNSET && this.mMoveY == UNSET) {
            float abs = Math.abs(motionEvent.getRawX() - this.mDownX);
            float abs2 = Math.abs(motionEvent.getRawY() - this.mDownY);
            if (abs == 0.0f && abs2 == 0.0f) {
                return false;
            }
            int i10 = this.mDragDirection;
            if ((i10 & 15) == 0) {
                return false;
            }
            if ((i10 & 3) != 0 && (i10 & 12) == 0 && abs < this.mDragTangent * abs2) {
                resetTouchParams();
                return false;
            }
            if ((i10 & 3) == 0 && (i10 & 12) != 0 && abs2 < abs * this.mDragTangent) {
                resetTouchParams();
                return false;
            }
        }
        this.mMoveX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.mMoveY = rawY;
        onDrag(this.mMoveX, rawY);
        this.mLastX = this.mMoveX;
        this.mLastY = this.mMoveY;
        return true;
    }

    public void handleTouchUpOrCancel() {
        startReleaseAnim();
        startMoveBack();
        resetTouchParams();
    }

    public void pauseAnimation() {
        if (this.mPressAnimator.isRunning()) {
            this.mPressAnimator.pause();
        }
        if (this.mReleaseAnimator.isRunning()) {
            this.mReleaseAnimator.pause();
        }
        if (this.mMoveBackAnimator.isRunning()) {
            this.mMoveBackAnimator.pause();
        }
    }

    public void setDragDirection(int i10) {
        this.mDragDirection = i10;
    }

    public void setDragMaxDistance(float f10, float f11) {
        this.mDragMaxHorizontal = dp2px(this.mProxyView.getContext(), f10) * 1.0f;
        this.mDragMaxVertical = dp2px(this.mProxyView.getContext(), f11) * 1.0f;
    }

    public void setDragRatio(float f10) {
        this.mDragRatio = f10;
    }

    public void setDragTangent(float f10) {
        this.mDragTangent = f10;
    }

    public void setEnableDragOnSloping(boolean z10) {
        this.mEnableSloping = z10;
    }

    public void setEnableMoveBack(boolean z10) {
        this.mEnableMoveBack = z10;
    }

    public void setEnableScale(boolean z10) {
        this.mEnableScale = z10;
    }

    public void setMinScale(float f10) {
        this.mMinScale = f10;
    }

    public void setMoveBackDuration(long j10) {
        this.mMoveBackAnimator.setDuration(j10);
    }

    public void setMoveBackInterpolator(Interpolator interpolator) {
        this.mMoveBackAnimator.setInterpolator(interpolator);
    }

    public void setPressDuration(long j10) {
        this.mPressAnimator.setDuration(j10);
    }

    public void setPressInterpolator(Interpolator interpolator) {
        this.mPressAnimator.setInterpolator(interpolator);
    }

    public void setReleaseDuration(long j10) {
        this.mReleaseAnimator.setDuration(j10);
    }

    public void setReleaseInterpolator(Interpolator interpolator) {
        this.mReleaseAnimator.setInterpolator(interpolator);
    }
}
