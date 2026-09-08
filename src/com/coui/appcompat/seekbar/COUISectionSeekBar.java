package com.coui.appcompat.seekbar;

import a9.l;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.oplus.os.LinearmotorVibrator;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public class COUISectionSeekBar extends COUISeekBar {
    private static final float MARK_RADIUS_SCALE = 2.0f;
    private static final float MOVE_RATIO = 0.4f;
    private int mActionMoveDirection;
    private int mCurActiveMarkColor;
    private int mCurInactiveMarkColor;
    private float mCurMarkRadius;
    private float mCurrentOffset;
    private boolean mIsFastMoving;
    private float mMarkRadius;
    private float mMoveAnimationEndThumbX;
    private float mMoveAnimationStartThumbX;
    private float mMoveAnimationValue;
    private ValueAnimator mMoveAnimator;
    private boolean mOnStopTrackingMask;
    private float mOverstep;
    private final PorterDuffXfermode mPorterDuffXfermode;
    private float mThumbX;
    private int mTouchDownPos;
    private float mTouchDownThumbX;

    public COUISectionSeekBar(Context context) {
        this(context, null);
    }

    private void calculateThumbPositionByIndex() {
        int seekBarWidth = getSeekBarWidth();
        this.mThumbX = ((this.mProgress * seekBarWidth) * 1.0f) / this.mMax;
        if (isLayoutRtl()) {
            this.mThumbX = seekBarWidth - this.mThumbX;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMoveSectionWidth() {
        return getSeekBarMoveWidth() / this.mMax;
    }

    private float getMoveThumbXByIndex(int i10) {
        float f10 = (i10 * r0) / this.mMax;
        float seekBarMoveWidth = getSeekBarMoveWidth();
        float max = Math.max(0.0f, Math.min(f10, seekBarMoveWidth));
        if (isLayoutRtl()) {
            return seekBarMoveWidth - max;
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getSectionWidth() {
        return getSeekBarNormalWidth() / this.mMax;
    }

    private int getSeekBarMoveWidth() {
        return (int) (((getWidth() - getStart()) - getEnd()) - ((this.mPaddingHorizontal * this.mHorizontalPaddingScale) * 2.0f));
    }

    private int getSeekBarNormalWidth() {
        return (int) (((getWidth() - getStart()) - getEnd()) - (this.mPaddingHorizontal * 2.0f));
    }

    private int getThumbPosByX(float f10) {
        int seekBarWidth = getSeekBarWidth();
        if (isLayoutRtl()) {
            f10 = seekBarWidth - f10;
        }
        return Math.max(0, Math.min(Math.round((f10 * this.mMax) / seekBarWidth), this.mMax));
    }

    private float getThumbXByIndex(int i10) {
        float f10 = (i10 * r0) / this.mMax;
        float seekBarNormalWidth = getSeekBarNormalWidth();
        float max = Math.max(0.0f, Math.min(f10, seekBarNormalWidth));
        if (isLayoutRtl()) {
            return seekBarNormalWidth - max;
        }
        return max;
    }

    private float getTouchXOfDrawArea(MotionEvent motionEvent) {
        return Math.min(Math.max(0.0f, (motionEvent.getX() - getPaddingLeft()) - this.mCurPaddingHorizontal), getSeekBarWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateProgress(float f10, boolean z10) {
        int round;
        int i10;
        float thumbXByIndex = getThumbXByIndex(this.mProgress);
        float subtract = subtract(f10, thumbXByIndex);
        float sectionWidth = getSectionWidth();
        if (this.mIsDragging) {
            round = (int) (subtract / sectionWidth);
        } else {
            round = Math.round(subtract / sectionWidth);
        }
        ValueAnimator valueAnimator = this.mMoveAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning() || Float.compare(this.mMoveAnimationEndThumbX, (round * sectionWidth) + thumbXByIndex) != 0) {
            float f11 = round * sectionWidth;
            this.mCurrentOffset = f11;
            this.mOverstep = thumbXByIndex;
            float f12 = this.mThumbX - thumbXByIndex;
            this.mOnStopTrackingMask = true;
            float f13 = f11 + thumbXByIndex;
            if (z10) {
                i10 = 100;
            } else {
                i10 = 0;
            }
            startMoveAnimation(thumbXByIndex, f13, f12, i10);
        }
    }

    private void startMoveAnimation(float f10, float f11, float f12, int i10) {
        ValueAnimator valueAnimator;
        if (Float.compare(this.mThumbX, f11) != 0 && ((valueAnimator = this.mMoveAnimator) == null || !valueAnimator.isRunning() || Float.compare(this.mMoveAnimationEndThumbX, f11) != 0)) {
            this.mMoveAnimationEndThumbX = f11;
            this.mMoveAnimationStartThumbX = f10;
            if (this.mMoveAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.mMoveAnimator = valueAnimator2;
                valueAnimator2.setInterpolator(K.a.a(0.0f, 0.0f, 0.25f, 1.0f));
                this.mMoveAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.COUISectionSeekBar.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        COUISectionSeekBar.this.mMoveAnimationValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        COUISectionSeekBar cOUISectionSeekBar = COUISectionSeekBar.this;
                        cOUISectionSeekBar.mThumbX = cOUISectionSeekBar.mMoveAnimationStartThumbX + (COUISectionSeekBar.this.mMoveAnimationValue * COUISectionSeekBar.MOVE_RATIO) + (COUISectionSeekBar.this.mCurrentOffset * 0.6f);
                        COUISectionSeekBar cOUISectionSeekBar2 = COUISectionSeekBar.this;
                        cOUISectionSeekBar2.mOverstep = cOUISectionSeekBar2.mThumbX;
                        COUISectionSeekBar.this.invalidate();
                        COUISectionSeekBar cOUISectionSeekBar3 = COUISectionSeekBar.this;
                        int i11 = cOUISectionSeekBar3.mProgress;
                        boolean z10 = true;
                        if (cOUISectionSeekBar3.mMoveAnimationEndThumbX - COUISectionSeekBar.this.mMoveAnimationStartThumbX > 0.0f) {
                            float f13 = COUISectionSeekBar.this.mThumbX;
                            COUISectionSeekBar cOUISectionSeekBar4 = COUISectionSeekBar.this;
                            i11 = Math.round(f13 / (cOUISectionSeekBar4.mIsDragging ? cOUISectionSeekBar4.getMoveSectionWidth() : cOUISectionSeekBar4.getSectionWidth()));
                        } else if (COUISectionSeekBar.this.mMoveAnimationEndThumbX - COUISectionSeekBar.this.mMoveAnimationStartThumbX < 0.0f) {
                            float f14 = (int) COUISectionSeekBar.this.mThumbX;
                            i11 = (int) Math.ceil(f14 / (COUISectionSeekBar.this.mIsDragging ? r0.getMoveSectionWidth() : r0.getSectionWidth()));
                        } else {
                            z10 = false;
                        }
                        if (COUISectionSeekBar.this.isLayoutRtl() && z10) {
                            i11 = COUISectionSeekBar.this.mMax - i11;
                        }
                        COUISectionSeekBar.this.checkThumbPosChange(i11);
                    }
                });
                this.mMoveAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.seekbar.COUISectionSeekBar.4
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (COUISectionSeekBar.this.mOnStopTrackingMask) {
                            COUISectionSeekBar.this.onStopTrackingTouch(true);
                            COUISectionSeekBar.this.mOnStopTrackingMask = false;
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (COUISectionSeekBar.this.mOnStopTrackingMask) {
                            COUISectionSeekBar.this.onStopTrackingTouch(true);
                            COUISectionSeekBar.this.mOnStopTrackingMask = false;
                        }
                        if (COUISectionSeekBar.this.mIsFastMoving) {
                            COUISectionSeekBar.this.mIsFastMoving = false;
                            COUISectionSeekBar cOUISectionSeekBar = COUISectionSeekBar.this;
                            cOUISectionSeekBar.invalidateProgress(cOUISectionSeekBar.mLastX, true);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
            this.mMoveAnimator.cancel();
            this.mMoveAnimator.setDuration(i10);
            this.mMoveAnimator.setFloatValues(f12, f11 - f10);
            this.mMoveAnimator.start();
            return;
        }
        if (this.mOnStopTrackingMask) {
            onStopTrackingTouch(true);
            this.mOnStopTrackingMask = false;
        }
    }

    private void trackTouchEvent(float f10) {
        float f11;
        float subtract = subtract(f10, this.mTouchDownThumbX);
        if (subtract < 0.0f) {
            f11 = subtract - 0.1f;
        } else {
            f11 = subtract + 0.1f;
        }
        float moveSectionWidth = getMoveSectionWidth();
        int floatValue = (int) new BigDecimal(Float.toString(f11)).divide(new BigDecimal(Float.toString(moveSectionWidth)), RoundingMode.FLOOR).floatValue();
        float f12 = floatValue * moveSectionWidth;
        if (isLayoutRtl()) {
            floatValue = -floatValue;
        }
        this.mCurrentOffset = f11;
        if (Math.abs((this.mTouchDownPos + floatValue) - this.mProgress) > 0) {
            float f13 = this.mTouchDownThumbX;
            startMoveAnimation(f13, f12 + f13, this.mMoveAnimationValue, 100);
        } else {
            this.mThumbX = this.mTouchDownThumbX + f12 + ((this.mCurrentOffset - f12) * 0.6f);
            invalidate();
        }
        this.mLastX = f10;
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void drawActiveTrack(Canvas canvas, float f10) {
        float start;
        float f11;
        int i10;
        int i11;
        float width = (getWidth() - getEnd()) - this.mCurPaddingHorizontal;
        int seekBarCenterY = getSeekBarCenterY();
        if (isLayoutRtl()) {
            f11 = getStart() + this.mCurPaddingHorizontal + f10;
            start = getStart() + this.mCurPaddingHorizontal + this.mThumbX;
        } else {
            start = getStart() + this.mCurPaddingHorizontal;
            f11 = this.mThumbX + start;
        }
        if (this.mShowProgress) {
            this.mPaint.setColor(this.mProgressColor);
            RectF rectF = this.mProgressRect;
            float f12 = seekBarCenterY;
            float f13 = this.mCurProgressRadius;
            rectF.set(start, f12 - f13, f11, f12 + f13);
            canvas.drawRect(this.mProgressRect, this.mPaint);
            if (isLayoutRtl()) {
                RectF rectF2 = this.mTempRect;
                float f14 = this.mCurProgressRadius;
                RectF rectF3 = this.mProgressRect;
                rectF2.set(width - f14, rectF3.top, f14 + width, rectF3.bottom);
                canvas.drawArc(this.mTempRect, -90.0f, 180.0f, true, this.mPaint);
            } else {
                RectF rectF4 = this.mTempRect;
                float f15 = this.mCurProgressRadius;
                RectF rectF5 = this.mProgressRect;
                rectF4.set(start - f15, rectF5.top, start + f15, rectF5.bottom);
                canvas.drawArc(this.mTempRect, 90.0f, 180.0f, true, this.mPaint);
            }
        }
        int saveLayer = canvas.saveLayer(null, null, 31);
        this.mPaint.setXfermode(this.mPorterDuffXfermode);
        if (this.mShowProgress) {
            if (isLayoutRtl()) {
                i10 = this.mCurInactiveMarkColor;
            } else {
                i10 = this.mCurActiveMarkColor;
            }
        } else {
            i10 = this.mCurInactiveMarkColor;
        }
        this.mPaint.setColor(i10);
        float start2 = getStart() + this.mCurPaddingHorizontal;
        float f16 = width - start2;
        int i12 = 0;
        boolean z10 = false;
        while (true) {
            int i13 = this.mMax;
            if (i12 > i13) {
                break;
            }
            if (this.mShowProgress && !z10 && ((i12 * f16) / i13) + start2 > getStart() + this.mCurPaddingHorizontal + this.mThumbX) {
                Paint paint = this.mPaint;
                if (isLayoutRtl()) {
                    i11 = this.mCurActiveMarkColor;
                } else {
                    i11 = this.mCurInactiveMarkColor;
                }
                paint.setColor(i11);
                z10 = true;
            }
            canvas.drawCircle(((i12 * f16) / this.mMax) + start2, seekBarCenterY, this.mCurMarkRadius, this.mPaint);
            i12++;
        }
        this.mPaint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
        this.mLabelX = this.mThumbX;
        if (this.mShowThumb) {
            float start3 = getStart() + this.mCurPaddingHorizontal;
            this.mPaint.setColor(this.mThumbColor);
            canvas.drawCircle(start3 + Math.min(this.mThumbX, getSeekBarWidth()), seekBarCenterY, this.mThumbOutRadius, this.mPaint);
        }
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void drawInactiveTrack(Canvas canvas) {
        int i10;
        int i11;
        if (this.mThumbX == -1.0f) {
            calculateThumbPositionByIndex();
        }
        int seekBarCenterY = getSeekBarCenterY();
        int saveLayer = canvas.saveLayer(null, null, 31);
        super.drawInactiveTrack(canvas);
        this.mPaint.setXfermode(this.mPorterDuffXfermode);
        float start = getStart() + this.mCurPaddingHorizontal;
        float width = ((getWidth() - getEnd()) - this.mCurPaddingHorizontal) - start;
        if (this.mShowProgress) {
            if (isLayoutRtl()) {
                i10 = this.mBackgroundColor;
            } else {
                i10 = this.mProgressColor;
            }
        } else {
            i10 = this.mBackgroundColor;
        }
        this.mPaint.setColor(i10);
        int i12 = 0;
        boolean z10 = false;
        while (true) {
            int i13 = this.mMax;
            if (i12 <= i13) {
                if (this.mShowProgress && !z10 && ((i12 * width) / i13) + start > getStart() + this.mThumbX) {
                    Paint paint = this.mPaint;
                    if (isLayoutRtl()) {
                        i11 = this.mProgressColor;
                    } else {
                        i11 = this.mBackgroundColor;
                    }
                    paint.setColor(i11);
                    z10 = true;
                }
                canvas.drawCircle(((i12 * width) / this.mMax) + start, seekBarCenterY, this.mMarkRadius, this.mPaint);
                i12++;
            } else {
                this.mPaint.setXfermode(null);
                canvas.restoreToCount(saveLayer);
                return;
            }
        }
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void handleMotionEventDown(MotionEvent motionEvent) {
        float touchXOfDrawArea = getTouchXOfDrawArea(motionEvent);
        this.mTouchDownX = touchXOfDrawArea;
        this.mLastX = touchXOfDrawArea;
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void handleMotionEventMove(MotionEvent motionEvent) {
        float touchXOfDrawArea = getTouchXOfDrawArea(motionEvent);
        int i10 = -1;
        if (this.mIsDragging) {
            float f10 = this.mLastX;
            if (touchXOfDrawArea - f10 > 0.0f) {
                i10 = 1;
            } else if (touchXOfDrawArea - f10 >= 0.0f) {
                i10 = 0;
            }
            if (i10 == (-this.mActionMoveDirection)) {
                this.mActionMoveDirection = i10;
                int i11 = this.mTouchDownPos;
                int i12 = this.mProgress;
                if (i11 != i12) {
                    this.mTouchDownPos = i12;
                    this.mTouchDownThumbX = getMoveThumbXByIndex(i12);
                    this.mMoveAnimationValue = 0.0f;
                }
                ValueAnimator valueAnimator = this.mMoveAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
            }
            trackTouchEvent(touchXOfDrawArea);
        } else {
            if (!touchInSeekBar(motionEvent, this)) {
                return;
            }
            if (Math.abs(touchXOfDrawArea - this.mTouchDownX) > this.mTouchSlop) {
                startDrag();
                touchAnim();
                int thumbPosByX = getThumbPosByX(this.mTouchDownX);
                this.mTouchDownPos = thumbPosByX;
                checkThumbPosChange(thumbPosByX);
                float moveThumbXByIndex = getMoveThumbXByIndex(this.mTouchDownPos);
                this.mTouchDownThumbX = moveThumbXByIndex;
                this.mMoveAnimationValue = 0.0f;
                this.mThumbX = moveThumbXByIndex;
                invalidate();
                trackTouchEvent(touchXOfDrawArea);
                if (touchXOfDrawArea - this.mTouchDownX > 0.0f) {
                    i10 = 1;
                }
                this.mActionMoveDirection = i10;
            }
        }
        this.mLastX = touchXOfDrawArea;
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void handleMotionEventUp(MotionEvent motionEvent) {
        float touchXOfDrawArea = getTouchXOfDrawArea(motionEvent);
        if (this.mIsDragging) {
            ValueAnimator valueAnimator = this.mMoveAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mIsFastMoving = true;
            }
            if (!this.mIsFastMoving) {
                invalidateProgress(touchXOfDrawArea, true);
            }
            onStopTrackingTouch(false);
            setPressed(false);
            releaseAnim();
            return;
        }
        invalidateProgress(touchXOfDrawArea, false);
        animForClick(touchXOfDrawArea);
        releaseAnim();
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar, i8.InterfaceC1105a
    public /* bridge */ /* synthetic */ void onAnimationStart(i8.c cVar) {
        super.onAnimationStart(cVar);
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void onEnlargeAnimationUpdate(ValueAnimator valueAnimator) {
        super.onEnlargeAnimationUpdate(valueAnimator);
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float f10 = this.mMarkRadius;
        this.mCurMarkRadius = f10 + (animatedFraction * ((2.0f * f10) - f10));
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mThumbX = -1.0f;
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public boolean performAdaptiveFeedback() {
        boolean z10;
        if (this.mLinearMotorVibrator == null) {
            LinearmotorVibrator linearMotorVibrator = VibrateUtils.getLinearMotorVibrator(getContext());
            this.mLinearMotorVibrator = linearMotorVibrator;
            if (linearMotorVibrator != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mHasMotorVibrator = z10;
        }
        Object obj = this.mLinearMotorVibrator;
        if (obj == null) {
            return false;
        }
        VibrateUtils.setLinearMotorVibratorStrength((LinearmotorVibrator) obj, 0, this.mProgress, this.mMax, 200, 2000);
        return true;
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void performFeedback() {
        if (!this.mEnableVibrator) {
            return;
        }
        if ((!this.mHasMotorVibrator || !this.mEnableAdaptiveVibrator || !performAdaptiveFeedback()) && !performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE_SYNC)) {
            performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        }
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void releaseAnim() {
        super.releaseAnim();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(PropertyValuesHolder.ofFloat("markRadius", this.mCurMarkRadius, this.mMarkRadius), PropertyValuesHolder.ofInt("activeAlpha", Color.alpha(this.mCurActiveMarkColor), 0), PropertyValuesHolder.ofInt("inactiveAlpha", Color.alpha(this.mCurInactiveMarkColor), 0));
        valueAnimator.setDuration(183L);
        valueAnimator.setInterpolator(COUISeekBar.PROGRESS_SCALE_INTERPOLATOR);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.COUISectionSeekBar.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUISectionSeekBar.this.mCurMarkRadius = ((Float) valueAnimator2.getAnimatedValue("markRadius")).floatValue();
                int intValue = ((Integer) valueAnimator2.getAnimatedValue("activeAlpha")).intValue();
                int intValue2 = ((Integer) valueAnimator2.getAnimatedValue("inactiveAlpha")).intValue();
                COUISectionSeekBar.this.mCurActiveMarkColor = Color.argb(intValue, 0, 0, 0);
                COUISectionSeekBar.this.mCurInactiveMarkColor = Color.argb(intValue2, 255, 255, 255);
                COUISectionSeekBar.this.invalidate();
            }
        });
        valueAnimator.cancel();
        valueAnimator.start();
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar
    public void setMax(int i10) {
        if (i10 < getMin()) {
            i10 = getMin();
        }
        if (i10 != this.mMax) {
            setLocalMax(i10);
            if (this.mProgress > i10) {
                setProgress(i10);
            }
            calculateThumbPositionByIndex();
        }
        invalidate();
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void setProgress(int i10, boolean z10, boolean z11) {
        if (this.mProgress != Math.max(0, Math.min(i10, this.mMax))) {
            if (z10) {
                checkThumbPosChange(i10, false, z11);
                calculateThumbPositionByIndex();
                startTransitionAnim(i10, z11);
                return;
            }
            checkThumbPosChange(i10, false, z11);
            if (getWidth() != 0) {
                calculateThumbPositionByIndex();
                float f10 = this.mThumbX;
                this.mOverstep = f10;
                this.mMoveAnimationEndThumbX = f10;
                invalidate();
            }
        }
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void startTransitionAnim(int i10, boolean z10) {
        AnimatorSet animatorSet = this.mClickAnimatorSet;
        if (animatorSet == null) {
            this.mClickAnimatorSet = new AnimatorSet();
        } else {
            animatorSet.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt((int) this.mLabelX, (int) this.mThumbX);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.COUISectionSeekBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISectionSeekBar.this.mThumbX = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                COUISectionSeekBar.this.invalidate();
            }
        });
        ofInt.setInterpolator(COUISeekBar.THUMB_ANIMATE_INTERPOLATOR);
        long abs = (Math.abs(r6 - r5) / getSeekBarWidth()) * 483.0f;
        if (abs < 150) {
            abs = 150;
        }
        this.mClickAnimatorSet.setDuration(abs);
        this.mClickAnimatorSet.play(ofInt);
        this.mClickAnimatorSet.start();
    }

    public COUISectionSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a9.b.f6470h);
    }

    public COUISectionSeekBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, COUIContextUtil.isCOUIDarkTheme(context) ? l.f6700f : l.f6699e);
    }

    public COUISectionSeekBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        this.mOnStopTrackingMask = false;
        this.mThumbX = -1.0f;
        this.mIsFastMoving = false;
        this.mTouchDownPos = -1;
        this.mTouchDownThumbX = 0.0f;
        this.mMarkRadius = 0.0f;
        this.mCurMarkRadius = 0.0f;
        float dimensionPixelSize = getResources().getDimensionPixelSize(a9.d.f6543Y);
        this.mMarkRadius = dimensionPixelSize;
        this.mCurMarkRadius = dimensionPixelSize;
        this.mCurActiveMarkColor = 0;
        this.mCurInactiveMarkColor = 0;
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("activeAlpha", 0, Color.alpha(COUIContextUtil.getColor(getContext(), a9.c.f6486j)));
        PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("inactiveAlpha", 0, Color.alpha(COUIContextUtil.getColor(getContext(), a9.c.f6487k)));
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(ofInt, ofInt2);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.COUISectionSeekBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue("activeAlpha")).intValue();
                int intValue2 = ((Integer) valueAnimator2.getAnimatedValue("inactiveAlpha")).intValue();
                COUISectionSeekBar.this.mCurActiveMarkColor = Color.argb(intValue, 0, 0, 0);
                COUISectionSeekBar.this.mCurInactiveMarkColor = Color.argb(intValue2, 255, 255, 255);
                COUISectionSeekBar.this.invalidate();
            }
        });
        this.mTouchAnimator.play(valueAnimator);
    }
}
