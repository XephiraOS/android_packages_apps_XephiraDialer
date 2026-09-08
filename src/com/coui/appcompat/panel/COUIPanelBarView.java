package com.coui.appcompat.panel;

import A.h;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import c9.C0571c;
import c9.C0572d;
import com.coui.appcompat.animation.COUIEaseInterpolator;

/* loaded from: classes.dex */
public class COUIPanelBarView extends View {
    private static final long ANIMATOR_DURATION = 167;
    private static final int ANIMATOR_RESPONSE_THRESHOLD = 5;
    private int continuousMove;
    private int directTo;
    private int mBarColor;
    private int mBarHeight;
    private int mBarMarginTop;
    private int mBarWidth;
    private int mCurrentPosition;
    private boolean mIsBeingDragged;
    private boolean mIsFixed;
    private float mMaxOffset;
    private float mOffset;
    private Paint mPaint;
    private Path mPath;
    private int mSpecialThreshold;
    private float mTopLeftPointX;
    private float mTopLeftPointY;
    private float mTopMiddlePointX;
    private float mTopMiddlePointY;
    private float mTopRightPointX;
    private float mTopRightPointY;
    private ObjectAnimator translationAnimator;

    public COUIPanelBarView(Context context) {
        super(context);
        this.mIsFixed = false;
        this.mIsBeingDragged = false;
        this.mOffset = 0.0f;
        this.mTopLeftPointX = 0.0f;
        this.mTopLeftPointY = 0.0f;
        this.mTopMiddlePointX = 0.0f;
        this.mTopMiddlePointY = 0.0f;
        this.mTopRightPointX = 0.0f;
        this.mTopRightPointY = 0.0f;
        this.mMaxOffset = 0.0f;
        this.continuousMove = 0;
        this.mCurrentPosition = 0;
        this.mSpecialThreshold = 0;
        this.directTo = -1;
        init(context);
    }

    private void drawBar(Canvas canvas) {
        setPoint();
        this.mPath.reset();
        this.mPath.moveTo(this.mTopLeftPointX, this.mTopLeftPointY);
        this.mPath.lineTo(this.mTopMiddlePointX, this.mTopMiddlePointY);
        this.mPath.lineTo(this.mTopRightPointX, this.mTopRightPointY);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init(Context context) {
        this.mBarWidth = getContext().getResources().getDimensionPixelOffset(C0572d.f12889l);
        this.mBarHeight = getContext().getResources().getDimensionPixelOffset(C0572d.f12887j);
        this.mBarMarginTop = getContext().getResources().getDimensionPixelOffset(C0572d.f12888k);
        this.mMaxOffset = getContext().getResources().getDimensionPixelOffset(C0572d.f12895r);
        this.mSpecialThreshold = getContext().getResources().getDimensionPixelOffset(C0572d.f12876B);
        this.mBarColor = h.d(context.getResources(), C0571c.f12872a, null);
        this.mPaint = new Paint();
        this.mPath = new Path();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setDither(true);
        this.mPaint.setStrokeWidth(this.mBarHeight);
        this.mPaint.setColor(this.mBarColor);
    }

    private void playResetAnimator() {
        if (!this.mIsFixed) {
            ObjectAnimator objectAnimator = this.translationAnimator;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.translationAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "barOffset", this.mOffset, 0.0f);
            this.translationAnimator = ofFloat;
            ofFloat.setDuration((Math.abs(this.mOffset) / (this.mMaxOffset * 2.0f)) * 167.0f);
            this.translationAnimator.setInterpolator(new COUIEaseInterpolator());
            this.translationAnimator.start();
            this.directTo = 0;
        }
    }

    private void playTowardsDownAnimator() {
        if (!this.mIsFixed) {
            ObjectAnimator objectAnimator = this.translationAnimator;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.translationAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "barOffset", this.mOffset, this.mMaxOffset);
            this.translationAnimator = ofFloat;
            ofFloat.setDuration((Math.abs(this.mMaxOffset - this.mOffset) / (this.mMaxOffset * 2.0f)) * 167.0f);
            this.translationAnimator.setInterpolator(new COUIEaseInterpolator());
            this.translationAnimator.start();
            this.directTo = 1;
        }
    }

    private void playTowardsUpAnimator() {
        if (!this.mIsFixed) {
            ObjectAnimator objectAnimator = this.translationAnimator;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                this.translationAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "barOffset", this.mOffset, -this.mMaxOffset);
            this.translationAnimator = ofFloat;
            ofFloat.setDuration((Math.abs(this.mMaxOffset + this.mOffset) / (this.mMaxOffset * 2.0f)) * 167.0f);
            this.translationAnimator.setInterpolator(new LinearInterpolator());
            this.translationAnimator.start();
            this.directTo = -1;
        }
    }

    private void setBarOffset(float f10) {
        this.mOffset = f10;
        invalidate();
    }

    private void setPoint() {
        float f10 = this.mOffset / 2.0f;
        int i10 = this.mBarHeight;
        this.mTopLeftPointX = i10 / 2.0f;
        float f11 = (i10 / 2.0f) - f10;
        this.mTopLeftPointY = f11;
        int i11 = this.mBarWidth;
        this.mTopMiddlePointX = (i11 / 2.0f) + (i10 / 2.0f);
        this.mTopMiddlePointY = (i10 / 2.0f) + f10;
        this.mTopRightPointX = i11 + (i10 / 2.0f);
        this.mTopRightPointY = f11;
    }

    private void startAnimator() {
        if (!this.mIsBeingDragged) {
            return;
        }
        int i10 = this.continuousMove;
        if (i10 > 0 && this.mOffset <= 0.0f && this.directTo != 1) {
            playTowardsDownAnimator();
        } else if (i10 < 0 && this.mOffset >= 0.0f && this.directTo != -1 && this.mCurrentPosition >= this.mSpecialThreshold) {
            playTowardsUpAnimator();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0.0f, this.mBarMarginTop);
        drawBar(canvas);
    }

    public void releaseDrag() {
        playResetAnimator();
    }

    public void setBarColor(int i10) {
        this.mBarColor = i10;
        this.mPaint.setColor(i10);
        invalidate();
    }

    public void setIsBeingDragged(boolean z10) {
        if (this.mIsBeingDragged != z10) {
            this.mIsBeingDragged = z10;
            if (!z10) {
                releaseDrag();
            }
        }
    }

    public void setIsFixed(boolean z10) {
        this.mIsFixed = z10;
    }

    public void setPanelOffset(int i10) {
        if (!this.mIsFixed) {
            int i11 = this.continuousMove;
            if (i11 * i10 > 0) {
                this.continuousMove = i11 + i10;
            } else {
                this.continuousMove = i10;
            }
            this.mCurrentPosition += i10;
            if (Math.abs(this.continuousMove) > 5 || (this.continuousMove > 0 && this.mCurrentPosition < this.mSpecialThreshold)) {
                startAnimator();
            }
        }
    }

    public COUIPanelBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFixed = false;
        this.mIsBeingDragged = false;
        this.mOffset = 0.0f;
        this.mTopLeftPointX = 0.0f;
        this.mTopLeftPointY = 0.0f;
        this.mTopMiddlePointX = 0.0f;
        this.mTopMiddlePointY = 0.0f;
        this.mTopRightPointX = 0.0f;
        this.mTopRightPointY = 0.0f;
        this.mMaxOffset = 0.0f;
        this.continuousMove = 0;
        this.mCurrentPosition = 0;
        this.mSpecialThreshold = 0;
        this.directTo = -1;
        init(context);
    }

    public COUIPanelBarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsFixed = false;
        this.mIsBeingDragged = false;
        this.mOffset = 0.0f;
        this.mTopLeftPointX = 0.0f;
        this.mTopLeftPointY = 0.0f;
        this.mTopMiddlePointX = 0.0f;
        this.mTopMiddlePointY = 0.0f;
        this.mTopRightPointX = 0.0f;
        this.mTopRightPointY = 0.0f;
        this.mMaxOffset = 0.0f;
        this.continuousMove = 0;
        this.mCurrentPosition = 0;
        this.mSpecialThreshold = 0;
        this.directTo = -1;
        init(context);
    }

    public COUIPanelBarView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mIsFixed = false;
        this.mIsBeingDragged = false;
        this.mOffset = 0.0f;
        this.mTopLeftPointX = 0.0f;
        this.mTopLeftPointY = 0.0f;
        this.mTopMiddlePointX = 0.0f;
        this.mTopMiddlePointY = 0.0f;
        this.mTopRightPointX = 0.0f;
        this.mTopRightPointY = 0.0f;
        this.mMaxOffset = 0.0f;
        this.continuousMove = 0;
        this.mCurrentPosition = 0;
        this.mSpecialThreshold = 0;
        this.directTo = -1;
        init(context);
    }
}
