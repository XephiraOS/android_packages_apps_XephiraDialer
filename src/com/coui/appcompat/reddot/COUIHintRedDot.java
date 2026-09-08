package com.coui.appcompat.reddot;

import X8.c;
import X8.g;
import X8.k;
import X8.m;
import X8.o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;

/* loaded from: classes.dex */
public class COUIHintRedDot extends View {
    public static final int CONSTANT_VALUE_3 = 3;
    public static final int CONSTANT_VALUE_4 = 4;
    public static final int MAX_ALPHA_VALUE = 255;
    public static final int MIN_ALPHA_VALUE = 0;
    public static final int NO_POINT_MODE = 0;
    public static final long NUM_CHANGE_ALPHA_ANIM_DURATION = 150;
    public static final long NUM_CHANGE_WIDTH_ANIM_DURATION = 517;
    public static final Interpolator NUM_CHANGE_WIDTH_ANIM_INTERPOLATOR = new COUIMoveEaseInterpolator();
    public static final int POINT_NAVI_WITH_NUM = 3;
    public static final int POINT_NUM_MODE_STROKE = 5;
    public static final int POINT_ONLY_MODE = 1;
    public static final int POINT_ONLY_MODE_STROKE = 4;
    public static final int POINT_WITH_NUM_MODE = 2;
    public static final long RED_POINT_ANIM_DURATION = 520;
    public static final int TYPE_BIG_RECT_RADIUS = 2;
    public static final int TYPE_SMALL_RECT_RADIUS = 1;
    private ValueAnimator mAlphaAnim;
    private COUIHintRedDotHelper mCOUIHintRedDotHelper;
    private boolean mIsExecutingAlphaAnim;
    private boolean mIsExecutingWidthAnim;
    private boolean mIsLaidOut;
    private int mPointMode;
    private int mPointNumber;
    private String mPointText;
    private RectF mRectF;
    private String mRedDotDescription;
    private int mRedDotWithNumberDescriptionId;
    private Drawable mStrokeBackground;
    private int mTempPointNumber;
    private int mTempWidth;
    private int mTextPaintAlpha;
    private ValueAnimator mWidthAnim;

    public COUIHintRedDot(Context context) {
        this(context, null);
    }

    private void cancelAnim() {
        ValueAnimator valueAnimator = this.mWidthAnim;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mWidthAnim.end();
        }
        ValueAnimator valueAnimator2 = this.mAlphaAnim;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mAlphaAnim.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeAlphaAnim() {
        if (this.mAlphaAnim == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
            this.mAlphaAnim = ofInt;
            ofInt.setDuration(150L);
            this.mAlphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.reddot.COUIHintRedDot.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUIHintRedDot.this.mTextPaintAlpha = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                }
            });
            this.mAlphaAnim.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.reddot.COUIHintRedDot.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    COUIHintRedDot.this.mIsExecutingAlphaAnim = false;
                    COUIHintRedDot cOUIHintRedDot = COUIHintRedDot.this;
                    cOUIHintRedDot.mPointNumber = cOUIHintRedDot.mTempPointNumber;
                    COUIHintRedDot cOUIHintRedDot2 = COUIHintRedDot.this;
                    cOUIHintRedDot2.mPointText = String.valueOf(cOUIHintRedDot2.mPointNumber);
                    COUIHintRedDot.this.mTempPointNumber = 0;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    COUIHintRedDot.this.mIsExecutingAlphaAnim = false;
                    COUIHintRedDot cOUIHintRedDot = COUIHintRedDot.this;
                    cOUIHintRedDot.mPointNumber = cOUIHintRedDot.mTempPointNumber;
                    COUIHintRedDot cOUIHintRedDot2 = COUIHintRedDot.this;
                    cOUIHintRedDot2.mPointText = String.valueOf(cOUIHintRedDot2.mPointNumber);
                    COUIHintRedDot.this.mTempPointNumber = 0;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    COUIHintRedDot.this.mIsExecutingAlphaAnim = true;
                }
            });
        }
        this.mAlphaAnim.start();
    }

    private void executeWidthAnim(int i10, int i11) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mCOUIHintRedDotHelper.getViewWidth(this.mPointMode, i10), this.mCOUIHintRedDotHelper.getViewWidth(this.mPointMode, i11));
        this.mWidthAnim = ofInt;
        ofInt.setDuration(517L);
        this.mWidthAnim.setInterpolator(NUM_CHANGE_WIDTH_ANIM_INTERPOLATOR);
        this.mWidthAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.reddot.COUIHintRedDot.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIHintRedDot.this.mTempWidth = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                COUIHintRedDot.this.requestLayout();
            }
        });
        this.mWidthAnim.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.reddot.COUIHintRedDot.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIHintRedDot.this.mIsExecutingWidthAnim = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIHintRedDot.this.mIsExecutingWidthAnim = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIHintRedDot.this.mIsExecutingWidthAnim = true;
                COUIHintRedDot.this.executeAlphaAnim();
            }
        });
        this.mWidthAnim.start();
    }

    public void changePointNumber(int i10) {
        int i11;
        if (getVisibility() != 8 && (i11 = this.mPointMode) != 0 && i11 != 1 && i11 != 4 && i11 != 5 && this.mPointNumber != i10 && i10 > 0 && this.mCOUIHintRedDotHelper != null) {
            cancelAnim();
            if (this.mIsLaidOut) {
                this.mTempPointNumber = i10;
                executeWidthAnim(this.mPointNumber, i10);
            } else {
                setPointNumber(i10);
            }
        }
    }

    public void executeScaleAnim(final boolean z10) {
        float f10;
        float f11 = 1.0f;
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        if (!z10) {
            f11 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        ofFloat.setDuration(520L);
        ofFloat.setInterpolator(NUM_CHANGE_WIDTH_ANIM_INTERPOLATOR);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.reddot.COUIHintRedDot.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float f12 = (Float) valueAnimator.getAnimatedValue();
                if (COUIHintRedDot.this.getVisibility() != 8) {
                    COUIHintRedDot.this.setScaleX(f12.floatValue());
                    COUIHintRedDot.this.setScaleY(f12.floatValue());
                    COUIHintRedDot.this.invalidate();
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.reddot.COUIHintRedDot.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (!z10) {
                    COUIHintRedDot.this.setPointMode(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!z10) {
                    COUIHintRedDot.this.setVisibility(8);
                    COUIHintRedDot.this.setPointMode(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z10) {
                    COUIHintRedDot.this.setVisibility(0);
                    COUIHintRedDot.this.requestLayout();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
    }

    public boolean getIsLaidOut() {
        return this.mIsLaidOut;
    }

    public int getPointMode() {
        return this.mPointMode;
    }

    public int getPointNumber() {
        return this.mPointNumber;
    }

    public String getPointText() {
        return this.mPointText;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        cancelAnim();
        super.onDetachedFromWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        RectF rectF = this.mRectF;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.mRectF.bottom = getHeight();
        if (this.mIsExecutingAlphaAnim && ((i10 = this.mPointNumber) < 1000 || this.mTempPointNumber < 1000)) {
            COUIHintRedDotHelper cOUIHintRedDotHelper = this.mCOUIHintRedDotHelper;
            int i11 = this.mTextPaintAlpha;
            cOUIHintRedDotHelper.drawPointWithFadeNumber(canvas, i10, i11, this.mTempPointNumber, 255 - i11, this.mRectF);
            return;
        }
        this.mCOUIHintRedDotHelper.drawRedPoint(canvas, this.mPointMode, this.mPointText, this.mRectF);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.mIsLaidOut = true;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int viewWidth;
        if (this.mIsExecutingWidthAnim) {
            viewWidth = this.mTempWidth;
        } else {
            viewWidth = this.mCOUIHintRedDotHelper.getViewWidth(this.mPointMode, this.mPointText);
        }
        setMeasuredDimension(viewWidth, this.mCOUIHintRedDotHelper.getViewHeight(this.mPointMode));
    }

    public COUIHintRedDotMemento saveMemento() {
        COUIHintRedDotMemento cOUIHintRedDotMemento = new COUIHintRedDotMemento();
        cOUIHintRedDotMemento.setPointMode(getPointMode());
        cOUIHintRedDotMemento.setPointNumber(getPointNumber());
        cOUIHintRedDotMemento.setPointText(getPointText());
        return cOUIHintRedDotMemento;
    }

    public void setBgColor(int i10) {
        this.mCOUIHintRedDotHelper.setBgColor(i10);
    }

    public void setCornerRadius(int i10) {
        this.mCOUIHintRedDotHelper.setCornerRadius(i10);
    }

    public void setDotDiameter(int i10) {
        this.mCOUIHintRedDotHelper.setDotDiameter(i10);
    }

    public void setEllipsisDiameter(int i10) {
        this.mCOUIHintRedDotHelper.setEllipsisDiameter(i10);
    }

    public void setLaidOut() {
        this.mIsLaidOut = true;
    }

    public void setLargeWidth(int i10) {
        this.mCOUIHintRedDotHelper.setLargeWidth(i10);
    }

    public void setMediumWidth(int i10) {
        this.mCOUIHintRedDotHelper.setMediumWidth(i10);
    }

    public void setPointMode(int i10) {
        if (this.mPointMode != i10) {
            this.mPointMode = i10;
            if (i10 == 4) {
                setBackground(this.mStrokeBackground);
            }
            requestLayout();
            int i11 = this.mPointMode;
            if (i11 != 1 && i11 != 4) {
                if (i11 == 0) {
                    setContentDescription("");
                    return;
                }
                return;
            }
            setContentDescription(this.mRedDotDescription);
        }
    }

    public void setPointNumber(int i10) {
        this.mPointNumber = i10;
        if (i10 != 0) {
            setPointText(String.valueOf(i10));
        } else {
            setPointText("");
        }
        if (i10 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(",");
            Resources resources = getResources();
            int i11 = this.mRedDotWithNumberDescriptionId;
            int i12 = this.mPointNumber;
            sb.append(resources.getQuantityString(i11, i12, Integer.valueOf(i12)));
            setContentDescription(sb.toString());
        }
    }

    public void setPointText(String str) {
        this.mPointText = str;
        requestLayout();
    }

    public void setSmallWidth(int i10) {
        this.mCOUIHintRedDotHelper.setSmallWidth(i10);
    }

    public void setTextColor(int i10) {
        this.mCOUIHintRedDotHelper.setTextColor(i10);
    }

    public void setTextSize(int i10) {
        this.mCOUIHintRedDotHelper.setTextSize(i10);
    }

    public void setViewHeight(int i10) {
        this.mCOUIHintRedDotHelper.setViewHeight(i10);
    }

    public COUIHintRedDot(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f4357P);
    }

    public COUIHintRedDot(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPointMode = 0;
        this.mPointNumber = 0;
        this.mPointText = "";
        this.mTempPointNumber = 0;
        this.mTextPaintAlpha = 255;
        int[] iArr = o.f5225V1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        this.mPointMode = obtainStyledAttributes.getInteger(o.f5280c2, 0);
        setPointNumber(obtainStyledAttributes.getInteger(o.f5288d2, 0));
        this.mPointText = obtainStyledAttributes.getString(o.f5296e2);
        obtainStyledAttributes.recycle();
        this.mCOUIHintRedDotHelper = new COUIHintRedDotHelper(context, attributeSet, iArr, i10, 0);
        this.mRectF = new RectF();
        this.mRedDotDescription = getResources().getString(m.f4992B);
        this.mRedDotWithNumberDescriptionId = k.f4988a;
        Drawable drawable = context.getResources().getDrawable(g.f4843A);
        this.mStrokeBackground = drawable;
        if (this.mPointMode == 4) {
            setBackground(drawable);
        }
    }
}
