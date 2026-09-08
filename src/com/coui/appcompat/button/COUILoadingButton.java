package com.coui.appcompat.button;

import X8.f;
import X8.m;
import X8.o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.coui.appcompat.animation.COUILinearInterpolator;
import e.C0961a;

/* loaded from: classes.dex */
public class COUILoadingButton extends COUIButton {
    public static final int DEFAULT_STATE = 0;
    private static final float DOT_END_ALPHA = 255.0f;
    private static final float DOT_MID_ALPHA = 127.5f;
    private static final float DOT_START_ALPHA = 51.0f;
    public static final int LOADING_STATE = 1;
    private int mButtonState;
    private final String mDots;
    private int mFirstLoadingDotAlpha;
    private AnimatorSet mLoadingAnim;
    private final float mLoadingCircleRadius;
    private final float mLoadingCircleSpacing;
    private final float mLoadingCircleTotalWidth;
    private String mLoadingText;
    private final Rect mLoadingTextBounds;
    private OnLoadingStateChangeListener mOnLoadingStateChangeListener;
    private String mOriginalText;
    private int mSecondLoadingDotAlpha;
    private boolean mShowLoadingText;
    private int mThirdLoadingDotAlpha;

    /* loaded from: classes.dex */
    public interface OnLoadingStateChangeListener {
        void OnLoadingStateChanged(int i10);
    }

    public COUILoadingButton(Context context) {
        this(context, null);
    }

    private void drawClipDot(Canvas canvas, float f10, float f11, float f12, float f13, TextPaint textPaint, int i10) {
        textPaint.setAlpha(i10);
        int save = canvas.save();
        canvas.clipRect(f10, 0.0f, f11, getHeight());
        canvas.drawText(this.mDots, f12, f13, textPaint);
        canvas.restoreToCount(save);
    }

    private void drawLoadingCircles(Canvas canvas, TextPaint textPaint) {
        int i10;
        int i11;
        int i12 = this.mSecondLoadingDotAlpha;
        if (isRtlMode()) {
            i10 = this.mThirdLoadingDotAlpha;
            i11 = this.mFirstLoadingDotAlpha;
        } else {
            i10 = this.mFirstLoadingDotAlpha;
            i11 = this.mThirdLoadingDotAlpha;
        }
        float measuredHeight = getMeasuredHeight() / 2.0f;
        float measuredWidth = ((getMeasuredWidth() - this.mLoadingCircleTotalWidth) / 2.0f) + this.mLoadingCircleRadius;
        textPaint.setAlpha(i10);
        canvas.drawCircle(measuredWidth, measuredHeight, this.mLoadingCircleRadius, textPaint);
        float f10 = measuredWidth + (this.mLoadingCircleRadius * 2.0f) + this.mLoadingCircleSpacing;
        textPaint.setAlpha(i12);
        canvas.drawCircle(f10, measuredHeight, this.mLoadingCircleRadius, textPaint);
        float f11 = f10 + (this.mLoadingCircleRadius * 2.0f) + this.mLoadingCircleSpacing;
        textPaint.setAlpha(i11);
        canvas.drawCircle(f11, measuredHeight, this.mLoadingCircleRadius, textPaint);
    }

    private ValueAnimator getAlphaAnimator(float f10, float f11, long j10, long j11, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        ofFloat.setDuration(j10);
        ofFloat.setStartDelay(j11);
        ofFloat.addUpdateListener(animatorUpdateListener);
        return ofFloat;
    }

    private void initAnim() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.button.COUILoadingButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUILoadingButton.this.mFirstLoadingDotAlpha = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                COUILoadingButton.this.invalidate();
            }
        };
        ValueAnimator alphaAnimator = getAlphaAnimator(DOT_START_ALPHA, DOT_MID_ALPHA, 133L, 0L, animatorUpdateListener);
        ValueAnimator alphaAnimator2 = getAlphaAnimator(DOT_MID_ALPHA, 255.0f, 67L, 133L, animatorUpdateListener);
        ValueAnimator alphaAnimator3 = getAlphaAnimator(255.0f, DOT_MID_ALPHA, 67L, 467L, animatorUpdateListener);
        ValueAnimator alphaAnimator4 = getAlphaAnimator(DOT_MID_ALPHA, DOT_START_ALPHA, 133L, 533L, animatorUpdateListener);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.button.COUILoadingButton.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUILoadingButton.this.mSecondLoadingDotAlpha = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                COUILoadingButton.this.invalidate();
            }
        };
        ValueAnimator alphaAnimator5 = getAlphaAnimator(DOT_START_ALPHA, DOT_MID_ALPHA, 133L, 333L, animatorUpdateListener2);
        ValueAnimator alphaAnimator6 = getAlphaAnimator(DOT_MID_ALPHA, 255.0f, 67L, 466L, animatorUpdateListener2);
        ValueAnimator alphaAnimator7 = getAlphaAnimator(255.0f, DOT_MID_ALPHA, 67L, 800L, animatorUpdateListener2);
        ValueAnimator alphaAnimator8 = getAlphaAnimator(DOT_MID_ALPHA, DOT_START_ALPHA, 133L, 866L, animatorUpdateListener2);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener3 = new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.button.COUILoadingButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUILoadingButton.this.mThirdLoadingDotAlpha = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                COUILoadingButton.this.invalidate();
            }
        };
        ValueAnimator alphaAnimator9 = getAlphaAnimator(DOT_START_ALPHA, DOT_MID_ALPHA, 133L, 666L, animatorUpdateListener3);
        ValueAnimator alphaAnimator10 = getAlphaAnimator(DOT_MID_ALPHA, 255.0f, 67L, 799L, animatorUpdateListener3);
        ValueAnimator alphaAnimator11 = getAlphaAnimator(255.0f, DOT_MID_ALPHA, 67L, 1133L, animatorUpdateListener3);
        ValueAnimator alphaAnimator12 = getAlphaAnimator(DOT_MID_ALPHA, DOT_START_ALPHA, 133L, 1199L, animatorUpdateListener3);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mLoadingAnim = animatorSet;
        animatorSet.playTogether(alphaAnimator, alphaAnimator2, alphaAnimator3, alphaAnimator4, alphaAnimator5, alphaAnimator6, alphaAnimator7, alphaAnimator8, alphaAnimator9, alphaAnimator10, alphaAnimator11, alphaAnimator12);
        this.mLoadingAnim.setInterpolator(new COUILinearInterpolator());
        this.mLoadingAnim.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.button.COUILoadingButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUILoadingButton.this.mLoadingAnim != null && COUILoadingButton.this.mButtonState == 1) {
                    COUILoadingButton.this.post(new Runnable() { // from class: com.coui.appcompat.button.COUILoadingButton.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            COUILoadingButton.this.mLoadingAnim.start();
                        }
                    });
                }
            }
        });
    }

    private void initTextChangeListener() {
        addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.button.COUILoadingButton.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                if (COUILoadingButton.this.mButtonState == 1 && !charSequence.toString().equals("")) {
                    COUILoadingButton.this.mOriginalText = charSequence.toString();
                    COUILoadingButton.this.setText("");
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
    }

    private boolean isRtlMode() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public int getButtonState() {
        return this.mButtonState;
    }

    public String getLoadingText() {
        return this.mLoadingText;
    }

    public OnLoadingStateChangeListener getOnLoadingStateChangeListener(OnLoadingStateChangeListener onLoadingStateChangeListener) {
        return this.mOnLoadingStateChangeListener;
    }

    public boolean getShowLoadingText() {
        return this.mShowLoadingText;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        AnimatorSet animatorSet;
        super.onAttachedToWindow();
        if (this.mButtonState == 1 && (animatorSet = this.mLoadingAnim) != null && !animatorSet.isRunning()) {
            this.mLoadingAnim.start();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mButtonState == 1) {
            this.mLoadingAnim.cancel();
        }
    }

    @Override // com.coui.appcompat.button.COUIButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        float measuredWidth;
        float f10;
        int i11;
        int i12;
        super.onDraw(canvas);
        if (this.mButtonState == 1 && getPaint() != null) {
            TextPaint paint = getPaint();
            int alpha = paint.getAlpha();
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.mShowLoadingText) {
                float measureText = paint.measureText(this.mLoadingText);
                float measureText2 = paint.measureText(this.mDots);
                if (measureText + measureText2 > (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) {
                    drawLoadingCircles(canvas, paint);
                    i10 = save;
                } else {
                    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                    float measuredHeight = (((getMeasuredHeight() + (fontMetrics.bottom - fontMetrics.top)) / 2.0f) - fontMetrics.bottom) - ((getPaddingBottom() - getPaddingTop()) / 2);
                    int i13 = this.mSecondLoadingDotAlpha;
                    if (isRtlMode()) {
                        measuredWidth = (((getMeasuredWidth() - measureText) - measureText2) / 2.0f) + measureText2;
                        i11 = this.mThirdLoadingDotAlpha;
                        i12 = this.mFirstLoadingDotAlpha;
                        f10 = ((getMeasuredWidth() - measureText) - measureText2) / 2.0f;
                    } else {
                        measuredWidth = ((getMeasuredWidth() - measureText) - measureText2) / 2.0f;
                        f10 = measureText + measuredWidth;
                        i11 = this.mFirstLoadingDotAlpha;
                        i12 = this.mThirdLoadingDotAlpha;
                    }
                    canvas.drawText(this.mLoadingText, measuredWidth - ((getPaddingEnd() - getPaddingStart()) / 2), measuredHeight, paint);
                    paint.getTextBounds(this.mDots, 0, 1, this.mLoadingTextBounds);
                    float f11 = f10;
                    i10 = save;
                    drawClipDot(canvas, f10, this.mLoadingTextBounds.right + f10, f11, measuredHeight, paint, i11);
                    paint.getTextBounds(this.mDots, 0, 2, this.mLoadingTextBounds);
                    drawClipDot(canvas, r0.right + f10, this.mLoadingTextBounds.right + f10, f11, measuredHeight, paint, i13);
                    drawClipDot(canvas, this.mLoadingTextBounds.right + f10, f10 + measureText2, f11, measuredHeight, paint, i12);
                }
            } else {
                i10 = save;
                drawLoadingCircles(canvas, paint);
            }
            paint.setAlpha(alpha);
            canvas.restoreToCount(i10);
        }
    }

    public void resetButtonState() {
        if (this.mButtonState == 1) {
            this.mButtonState = 0;
            setText(this.mOriginalText);
            this.mLoadingAnim.cancel();
            this.mFirstLoadingDotAlpha = 51;
            this.mSecondLoadingDotAlpha = 51;
            this.mThirdLoadingDotAlpha = 51;
            OnLoadingStateChangeListener onLoadingStateChangeListener = this.mOnLoadingStateChangeListener;
            if (onLoadingStateChangeListener != null) {
                onLoadingStateChangeListener.OnLoadingStateChanged(this.mButtonState);
            }
        }
    }

    public void setLoadingText(String str) {
        if (str != null && this.mShowLoadingText) {
            this.mLoadingText = str;
        }
    }

    public void setOnLoadingStateChangeListener(OnLoadingStateChangeListener onLoadingStateChangeListener) {
        this.mOnLoadingStateChangeListener = onLoadingStateChangeListener;
    }

    public void setOriginalText(String str) {
        this.mOriginalText = str;
    }

    public void setShowLoadingText(boolean z10) {
        this.mShowLoadingText = z10;
    }

    public void switchToLoadingState() {
        if (this.mLoadingAnim == null) {
            initTextChangeListener();
            initAnim();
        }
        if (this.mButtonState == 0) {
            this.mButtonState = 1;
            setText("");
            this.mLoadingAnim.start();
            OnLoadingStateChangeListener onLoadingStateChangeListener = this.mOnLoadingStateChangeListener;
            if (onLoadingStateChangeListener != null) {
                onLoadingStateChangeListener.OnLoadingStateChanged(this.mButtonState);
            }
        }
    }

    public COUILoadingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30118q);
    }

    public COUILoadingButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mButtonState = 0;
        this.mLoadingText = "";
        this.mLoadingTextBounds = new Rect();
        this.mFirstLoadingDotAlpha = 51;
        this.mSecondLoadingDotAlpha = 51;
        this.mThirdLoadingDotAlpha = 51;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5405s, i10, 0);
        boolean z10 = obtainStyledAttributes.getBoolean(o.f5087E, false);
        this.mShowLoadingText = z10;
        if (z10) {
            String string = obtainStyledAttributes.getString(o.f5095F);
            this.mLoadingText = string;
            if (string == null) {
                this.mLoadingText = "";
            }
        }
        obtainStyledAttributes.recycle();
        this.mOriginalText = getText().toString();
        this.mDots = context.getString(m.f5022u);
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(f.f4790s2);
        this.mLoadingCircleRadius = dimensionPixelOffset;
        float dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(f.f4797t2);
        this.mLoadingCircleSpacing = dimensionPixelOffset2;
        this.mLoadingCircleTotalWidth = (dimensionPixelOffset * 6.0f) + (dimensionPixelOffset2 * 2.0f);
    }
}
