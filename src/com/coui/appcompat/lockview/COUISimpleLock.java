package com.coui.appcompat.lockview;

import J.d;
import a9.b;
import a9.k;
import a9.l;
import a9.m;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.PathInterpolator;
import androidx.core.view.K;
import androidx.customview.widget.a;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class COUISimpleLock extends View {
    public static final int DEFAULTTYPE = 0;
    private static final int FOURCIRCLE = 4;
    private static final int FOURINTERVAL = 3;
    private static final int SIXCIRCLE = 6;
    public static final int SIXCIRCLETYPE = 1;
    private static final int SIXINTERVAL = 5;
    private static final String TAG = "COUISimpleLock";
    private final int ADD_ANIMATION;
    private final int CLEAR_ALL_ANIMATION;
    private final float[] DELAY_FOUR;
    private final float[] DELAY_SIX;
    private final int DELETE_ANIMATION;
    private final int DRAW_ALL_ANIMATION;
    private final int FAILED_ANIMATION;
    private final int FALL_HEIGHT;
    private final int FALL_SPEED;
    private final int MORPHING_FILLED_TO_OUTLINED_TIME;
    private final int MORPHING_OUTLINED_TO_FILLED_TIME;
    private final int SHAKE_AND_FALL_TIME;
    private final float[] SHAKE_X_POINT;
    private int animationMode;
    private boolean fail_lastDraw;
    private boolean fto_lastDraw;
    private boolean isFingerprintMode;
    private ValueAnimator mAddAnimator;
    private int mCodeImageStart;
    public int mCodeNumber;
    private int mContentHeight;
    private int mContentWidth;
    private Context mContext;
    private String mDecription;
    private ValueAnimator mDeleteAnimator;
    private PathInterpolator mDeleteAnimatorInterpolator;
    private boolean mDrawFailedAnimation;
    private Drawable mDrawable;
    private int mDrawableHeight;
    private int mDrawableWidth;
    private Animator mFailedAnimator;
    private Drawable mFilledRectangleDrawable;
    private boolean mIsLinearMotorVersion;
    private boolean mIsVibrator;
    private LinkedList<String> mNumberStrList;
    private int mOpacity;
    private Drawable mOutlinedRectangleDrawable;
    private int mRectangleNum;
    private int mRectanglePadding;
    private int mRectangleType;
    private int mRectanglesNumber;
    private int mRectanglesWidth;
    private float mScaleX;
    private float mScaleY;
    private int mStyle;
    private SimpleLockTouchHelper mTouchHelper;
    private float mTransitionX;
    private float mTransitionY;
    private boolean otf_lastDraw;

    /* loaded from: classes.dex */
    public final class SimpleLockTouchHelper extends a {
        private Rect mTempRect;

        public SimpleLockTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
        }

        public CharSequence getItemDescription(int i10) {
            if (COUISimpleLock.this.mDecription != null && COUISimpleLock.this.mNumberStrList != null) {
                COUISimpleLock cOUISimpleLock = COUISimpleLock.this;
                cOUISimpleLock.mDecription = cOUISimpleLock.mDecription.replace('y', String.valueOf(COUISimpleLock.this.mRectangleNum).charAt(0));
                return COUISimpleLock.this.mDecription.replace('x', String.valueOf(COUISimpleLock.this.mNumberStrList.size()).charAt(0));
            }
            return SimpleLockTouchHelper.class.getSimpleName();
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            if (f10 >= 0.0f && f10 <= COUISimpleLock.this.mContentWidth && f11 >= 0.0f && f11 <= COUISimpleLock.this.mDrawableHeight) {
                return 0;
            }
            return -2;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            list.add(0);
        }

        public boolean onItemClicked(int i10) {
            sendEventForVirtualView(i10, 1);
            return false;
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            return onItemClicked(i10);
        }

        @Override // androidx.core.view.C0446a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.customview.widget.a
        public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(getItemDescription(i10));
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            dVar.l0(getItemDescription(i10));
            dVar.a(16);
            setRectBounds(i10, this.mTempRect);
            dVar.c0(this.mTempRect);
        }

        public void setRectBounds(int i10, Rect rect) {
            if (i10 >= 0 && i10 < 1) {
                rect.set(0, 0, COUISimpleLock.this.mContentWidth, COUISimpleLock.this.mDrawableHeight);
            }
        }
    }

    public COUISimpleLock(Context context) {
        this(context, null);
    }

    private ValueAnimator createMorphingAnimationFilledToOutLined() {
        ValueAnimator valueAnimator = this.mDeleteAnimator;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
        this.mDeleteAnimator = ofInt;
        ofInt.setInterpolator(this.mDeleteAnimatorInterpolator);
        this.mDeleteAnimator.setDuration(230L);
        this.mDeleteAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUISimpleLock.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUISimpleLock.this.setOpacity(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                COUISimpleLock.this.invalidate();
            }
        });
        this.mDeleteAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.lockview.COUISimpleLock.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUISimpleLock.this.fto_lastDraw = true;
                COUISimpleLock.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISimpleLock.this.fto_lastDraw = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return this.mDeleteAnimator;
    }

    private ValueAnimator createMorphingAnimationOutLinedToFilled() {
        ValueAnimator valueAnimator = this.mAddAnimator;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        this.mAddAnimator = ofInt;
        ofInt.setDuration(230L);
        this.mAddAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUISimpleLock.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUISimpleLock.this.setOpacity(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                COUISimpleLock.this.invalidate();
            }
        });
        this.mAddAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.lockview.COUISimpleLock.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUISimpleLock.this.otf_lastDraw = true;
                COUISimpleLock.this.invalidate();
                if (COUISimpleLock.this.mDrawFailedAnimation) {
                    if (COUISimpleLock.this.mFailedAnimator == null || !COUISimpleLock.this.mFailedAnimator.isRunning()) {
                        COUISimpleLock.this.animationMode = 5;
                        COUISimpleLock cOUISimpleLock = COUISimpleLock.this;
                        cOUISimpleLock.mFailedAnimator = cOUISimpleLock.createFailedAnimator();
                        COUISimpleLock.this.mFailedAnimator.start();
                        COUISimpleLock.this.mIsVibrator = true;
                        return;
                    }
                    COUISimpleLock.this.otf_lastDraw = false;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISimpleLock.this.otf_lastDraw = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return this.mAddAnimator;
    }

    private void drawAllCodeAnimation(Canvas canvas, int i10) {
        int i11 = this.mCodeImageStart;
        int i12 = this.mDrawableHeight;
        if (this.otf_lastDraw) {
            drawPreviousState(canvas, this.mCodeNumber);
            this.animationMode = 0;
            return;
        }
        int judgeType = judgeType();
        int i13 = i11;
        for (int i14 = 0; i14 < judgeType; i14++) {
            int i15 = i13 + this.mDrawableWidth;
            drawOutLinedRectangle(canvas, i13, 0, i15, i12);
            if (i14 <= i10) {
                drawFilledRectangle(canvas, i13, 0, i15, i12);
            }
            if (i14 > i10) {
                drawFilledRectangle(canvas, 0, i13, i15, i12, this.mOpacity);
            }
            i13 = i15 + this.mRectanglePadding;
        }
    }

    private void drawClearAllAnimation(Canvas canvas, int i10) {
        int i11 = this.mCodeImageStart;
        int i12 = this.mDrawableHeight;
        if (this.fto_lastDraw) {
            drawPreviousState(canvas, this.mCodeNumber);
            this.animationMode = 0;
            return;
        }
        int judgeType = judgeType();
        int i13 = i11;
        for (int i14 = 0; i14 < judgeType; i14++) {
            int i15 = i13 + this.mDrawableWidth;
            drawOutLinedRectangle(canvas, i13, 0, i15, i12);
            if (i14 <= i10) {
                drawFilledRectangleWithAlphaChange(canvas, 0, i13, i15, i12, this.mOpacity);
            }
            i13 = i15 + this.mRectanglePadding;
        }
    }

    private void drawFailedAnimation(Canvas canvas, int i10) {
        int i11 = this.mCodeImageStart;
        int i12 = this.mDrawableHeight;
        if (this.fail_lastDraw) {
            this.animationMode = 0;
            this.mDrawFailedAnimation = false;
            this.mCodeNumber = -1;
            drawPreviousState(canvas, -1);
            return;
        }
        int judgeType = judgeType();
        int i13 = i11;
        for (int i14 = 0; i14 < judgeType; i14++) {
            int i15 = i13 + this.mDrawableWidth;
            drawOutLinedRectangleShake(canvas, 0, i13, i15, i12, 0.0f, 0.0f);
            if (i14 <= i10) {
                drawFilledRectangleShakeAndFall(canvas, 0, i13, i15, i12, 0.0f, 0.0f, i14);
            }
            i13 = i13 + this.mDrawableWidth + this.mRectanglePadding;
        }
    }

    private void drawFilledRectangle(Canvas canvas, int i10, int i11, int i12, int i13) {
        Drawable newDrawable = this.mFilledRectangleDrawable.getConstantState().newDrawable();
        this.mDrawable = newDrawable;
        float f10 = this.mTransitionX;
        newDrawable.setBounds((int) (i10 + f10), i11, (int) (i12 + f10), i13);
        this.mDrawable.draw(canvas);
    }

    private void drawFilledRectangleShakeAndFall(Canvas canvas, int i10, int i11, int i12, int i13, float f10, float f11, int i14) {
        this.mDrawable = this.mFilledRectangleDrawable.getConstantState().newDrawable();
        float f12 = this.mTransitionX;
        this.mDrawable.setBounds((int) (i11 + f12), (int) (i10 + getDelayFallHeight(i14, this.mTransitionY)), (int) (i12 + f12), (int) (i13 + getDelayFallHeight(i14, this.mTransitionY)));
        int delayFallHeight = (int) ((1.0f - (getDelayFallHeight(i14, this.mTransitionY) / 150.0f)) * 140.0f);
        Drawable drawable = this.mDrawable;
        if (delayFallHeight <= 0) {
            delayFallHeight = 0;
        }
        drawable.setAlpha(delayFallHeight);
        this.mDrawable.draw(canvas);
    }

    private void drawFilledRectangleWithAlphaChange(Canvas canvas, int i10, int i11, int i12, int i13, int i14) {
        Drawable newDrawable = this.mFilledRectangleDrawable.getConstantState().newDrawable();
        this.mDrawable = newDrawable;
        float f10 = this.mTransitionX;
        newDrawable.setBounds((int) (i11 + f10), i10, (int) (i12 + f10), i13);
        this.mDrawable.setAlpha(i14);
        this.mDrawable.draw(canvas);
    }

    private void drawFilledToOutLined(Canvas canvas, int i10) {
        int i11 = this.mCodeImageStart;
        int i12 = this.mDrawableHeight;
        if (this.fto_lastDraw) {
            this.animationMode = 0;
            drawPreviousState(canvas, this.mCodeNumber);
            return;
        }
        int judgeType = judgeType();
        int i13 = i11;
        for (int i14 = 0; i14 < judgeType; i14++) {
            int i15 = i13 + this.mDrawableWidth;
            drawOutLinedRectangle(canvas, i13, 0, i15, i12);
            if (i14 < i10) {
                drawFilledRectangle(canvas, i13, 0, i15, i12);
            }
            if (i14 == i10) {
                drawFilledRectangleWithAlphaChange(canvas, 0, i13, i15, i12, this.mOpacity);
            }
            i13 = i15 + this.mRectanglePadding;
        }
    }

    private void drawOutLinedRectangle(Canvas canvas, int i10, int i11, int i12, int i13) {
        Drawable newDrawable = this.mOutlinedRectangleDrawable.getConstantState().newDrawable();
        this.mDrawable = newDrawable;
        float f10 = this.mTransitionX;
        newDrawable.setBounds((int) (i10 + f10), i11, (int) (i12 + f10), i13);
        this.mDrawable.draw(canvas);
    }

    private void drawOutLinedRectangleShake(Canvas canvas, int i10, int i11, int i12, int i13, float f10, float f11) {
        Drawable newDrawable = this.mOutlinedRectangleDrawable.getConstantState().newDrawable();
        this.mDrawable = newDrawable;
        float f12 = this.mTransitionX;
        newDrawable.setBounds((int) (i11 + f12), i10, (int) (i12 + f12), i13);
        this.mDrawable.draw(canvas);
    }

    private void drawOutLinedToFilled(Canvas canvas, int i10) {
        int i11 = this.mCodeImageStart;
        int i12 = this.mDrawableHeight;
        if (this.otf_lastDraw) {
            this.animationMode = 0;
            drawPreviousState(canvas, this.mCodeNumber);
            return;
        }
        int judgeType = judgeType();
        int i13 = i11;
        for (int i14 = 0; i14 < judgeType; i14++) {
            int i15 = i13 + this.mDrawableWidth;
            drawOutLinedRectangle(canvas, i13, 0, i15, i12);
            if (i14 < i10) {
                drawFilledRectangle(canvas, i13, 0, i15, i12);
            }
            if (i14 == i10) {
                drawFilledRectangle(canvas, 0, i13, i15, i12, this.mOpacity);
            }
            if (this.mDrawFailedAnimation) {
                drawFilledRectangleShakeAndFall(canvas, 0, i13, i15, i12, 0.0f, 0.0f, i14);
            }
            i13 = i13 + this.mDrawableWidth + this.mRectanglePadding;
        }
    }

    private void drawPreviousState(Canvas canvas, int i10) {
        int i11 = this.mCodeImageStart;
        int i12 = this.mDrawableHeight;
        int judgeType = judgeType();
        int i13 = i11;
        for (int i14 = 0; i14 < judgeType; i14++) {
            int i15 = i13 + this.mDrawableWidth;
            if (i14 <= i10) {
                drawFilledRectangle(canvas, i13, 0, i15, i12);
            }
            if (i14 > i10) {
                drawOutLinedRectangle(canvas, i13, 0, i15, i12);
            }
            i13 = i15 + this.mRectanglePadding;
        }
    }

    private float getDelayFallHeight(int i10, float f10) {
        int i11 = this.mRectangleNum;
        if (i11 == 4) {
            float f11 = f10 - this.DELAY_FOUR[i10];
            if (f11 < 0.0f) {
                return 0.0f;
            }
            return f11;
        }
        if (i11 == 6) {
            float f12 = f10 - this.DELAY_SIX[i10];
            if (f12 < 0.0f) {
                return 0.0f;
            }
            return f12;
        }
        return f10;
    }

    private int judgeType() {
        int i10 = this.mRectangleNum;
        if (i10 == 4) {
            return 4;
        }
        if (i10 == 6) {
            return 6;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performFeedback() {
        if (this.mIsLinearMotorVersion) {
            performHapticFeedback(304);
        } else {
            performHapticFeedback(300);
        }
    }

    public Animator createFailedAnimator() {
        Animator animator = this.mFailedAnimator;
        if (animator != null) {
            return animator;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 30.0f, -28.0f, 14.0f, -8.0f, 4.0f, -3.0f, 0.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUISimpleLock.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISimpleLock.this.setInternalTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                COUISimpleLock.this.invalidate();
            }
        });
        final ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 250.0f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.lockview.COUISimpleLock.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISimpleLock.this.setInternalTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.setInterpolator(new COUILinearInterpolator());
        ofFloat2.setInterpolator(new COUILinearInterpolator());
        ofFloat.setDuration(800L);
        ofFloat2.setDuration(800L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.lockview.COUISimpleLock.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                COUISimpleLock.this.setInternalTranslationX(0.0f);
                COUISimpleLock.this.fail_lastDraw = true;
                COUISimpleLock.this.mDrawFailedAnimation = false;
                COUISimpleLock.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                COUISimpleLock.this.animationMode = 5;
                COUISimpleLock.this.setInternalTranslationX(0.0f);
                COUISimpleLock.this.fail_lastDraw = false;
                COUISimpleLock.this.mDrawFailedAnimation = true;
                ofFloat2.start();
                if (COUISimpleLock.this.isFingerprintMode) {
                    COUISimpleLock.this.isFingerprintMode = false;
                } else if (COUISimpleLock.this.mIsVibrator) {
                    COUISimpleLock.this.performFeedback();
                    COUISimpleLock.this.mIsVibrator = false;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
            }
        });
        this.mFailedAnimator = ofFloat;
        return ofFloat;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        SimpleLockTouchHelper simpleLockTouchHelper = this.mTouchHelper;
        if (simpleLockTouchHelper != null && simpleLockTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public Animator getAddAnimator() {
        return createMorphingAnimationOutLinedToFilled();
    }

    public Animator getDeleteAnimator() {
        return createMorphingAnimationFilledToOutLined();
    }

    public Animator getFailedAnimator() {
        this.mIsVibrator = true;
        return createFailedAnimator();
    }

    public LinkedList<String> getNumberStrList() {
        return this.mNumberStrList;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10 = this.animationMode;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            drawPreviousState(canvas, this.mCodeNumber);
                            return;
                        } else {
                            drawFailedAnimation(canvas, this.mCodeNumber);
                            return;
                        }
                    }
                    drawAllCodeAnimation(canvas, this.mRectanglesNumber);
                    return;
                }
                drawClearAllAnimation(canvas, this.mRectanglesNumber);
                return;
            }
            drawOutLinedToFilled(canvas, this.mCodeNumber);
            return;
        }
        drawFilledToOutLined(canvas, this.mCodeNumber + 1);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        this.mContentWidth = size;
        this.mCodeImageStart = (size - this.mRectanglesWidth) / 2;
        setMeasuredDimension(size, this.mDrawableHeight + 150);
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, m.f6819Y1, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, m.f6819Y1, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mOutlinedRectangleDrawable = typedArray.getDrawable(m.f6833b2);
            this.mFilledRectangleDrawable = typedArray.getDrawable(m.f6828a2);
            typedArray.recycle();
        }
    }

    public void reset() {
        ValueAnimator valueAnimator = this.mDeleteAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mDeleteAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mAddAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mAddAnimator.cancel();
        }
        Animator animator = this.mFailedAnimator;
        if (animator != null && animator.isRunning()) {
            this.mFailedAnimator.cancel();
        }
        this.mCodeNumber = -1;
        this.animationMode = 0;
        this.mNumberStrList.clear();
        this.mDrawFailedAnimation = false;
        invalidate();
    }

    public void setAllCode(boolean z10) {
        int i10 = this.mRectangleNum;
        if (i10 == 4) {
            if (!this.mDrawFailedAnimation && this.mCodeNumber < 3) {
                Animator animator = this.mFailedAnimator;
                if (animator != null && animator.isRunning()) {
                    return;
                }
            } else {
                return;
            }
        } else if (i10 == 6) {
            if (!this.mDrawFailedAnimation && this.mCodeNumber < 5) {
                Animator animator2 = this.mFailedAnimator;
                if (animator2 != null && animator2.isRunning()) {
                    return;
                }
            } else {
                return;
            }
        }
        if (z10) {
            ValueAnimator valueAnimator = this.mDeleteAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mDeleteAnimator.end();
            }
            ValueAnimator valueAnimator2 = this.mAddAnimator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.mAddAnimator.end();
            }
            this.animationMode = 4;
            this.mRectanglesNumber = this.mCodeNumber;
            int i11 = this.mRectangleNum;
            if (i11 == 4) {
                this.mCodeNumber = 3;
            } else if (i11 == 6) {
                this.mCodeNumber = 5;
            }
            ValueAnimator createMorphingAnimationOutLinedToFilled = createMorphingAnimationOutLinedToFilled();
            this.mAddAnimator = createMorphingAnimationOutLinedToFilled;
            createMorphingAnimationOutLinedToFilled.start();
        }
    }

    public void setClearAll(boolean z10) {
        int i10 = this.mRectangleNum;
        if (i10 == 4) {
            int i11 = this.mCodeNumber;
            if (i11 != -1 && !this.mDrawFailedAnimation && i11 <= 3 && z10) {
                Animator animator = this.mFailedAnimator;
                if (animator != null && animator.isRunning()) {
                    return;
                }
            } else {
                return;
            }
        } else if (i10 == 6) {
            int i12 = this.mCodeNumber;
            if (i12 != -1 && !this.mDrawFailedAnimation && i12 <= 5 && z10) {
                Animator animator2 = this.mFailedAnimator;
                if (animator2 != null && animator2.isRunning()) {
                    return;
                }
            } else {
                return;
            }
        }
        ValueAnimator valueAnimator = this.mDeleteAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mDeleteAnimator.end();
        }
        ValueAnimator valueAnimator2 = this.mAddAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mAddAnimator.end();
        }
        LinkedList<String> linkedList = this.mNumberStrList;
        if (linkedList != null) {
            linkedList.clear();
        }
        this.animationMode = 3;
        this.mRectanglesNumber = this.mCodeNumber;
        this.mCodeNumber = -1;
        ValueAnimator createMorphingAnimationFilledToOutLined = createMorphingAnimationFilledToOutLined();
        this.mDeleteAnimator = createMorphingAnimationFilledToOutLined;
        createMorphingAnimationFilledToOutLined.start();
    }

    public void setDeleteLast(boolean z10) {
        int i10;
        int i11 = this.mRectangleNum;
        if ((i11 != 4 && i11 != 6) || ((i10 = this.mCodeNumber) != -1 && z10 && i10 < i11 - 1)) {
            LinkedList<String> linkedList = this.mNumberStrList;
            if (linkedList != null && !linkedList.isEmpty()) {
                this.mNumberStrList.removeFirst();
                String str = this.mDecription;
                if (str != null && this.mNumberStrList != null) {
                    this.mDecription = str.replace('y', String.valueOf(this.mRectangleNum).charAt(0));
                    announceForAccessibility(this.mDecription.replace('x', String.valueOf(this.mNumberStrList.size()).charAt(0)));
                }
            }
            this.mCodeNumber--;
            if (!this.mDrawFailedAnimation) {
                Animator animator = this.mFailedAnimator;
                if (animator == null || !animator.isRunning()) {
                    if (this.mCodeNumber >= -1) {
                        ValueAnimator valueAnimator = this.mDeleteAnimator;
                        if (valueAnimator != null && valueAnimator.isRunning()) {
                            this.mDeleteAnimator.end();
                        }
                        ValueAnimator valueAnimator2 = this.mAddAnimator;
                        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                            this.mAddAnimator.end();
                        }
                        this.animationMode = 1;
                        ValueAnimator createMorphingAnimationFilledToOutLined = createMorphingAnimationFilledToOutLined();
                        this.mDeleteAnimator = createMorphingAnimationFilledToOutLined;
                        createMorphingAnimationFilledToOutLined.start();
                        return;
                    }
                    this.mCodeNumber = -1;
                }
            }
        }
    }

    public void setFailed(boolean z10) {
        Animator animator = this.mFailedAnimator;
        if (animator != null && animator.isRunning()) {
            this.mFailedAnimator.end();
        }
        this.mDrawFailedAnimation = z10;
    }

    public void setFilledRectangleDrawable(Drawable drawable) {
        this.mFilledRectangleDrawable = drawable;
    }

    public void setFingerprintRecognition(boolean z10) {
        this.isFingerprintMode = z10;
    }

    public void setInternalTranslationX(float f10) {
        this.mTransitionX = f10;
    }

    public void setInternalTranslationY(float f10) {
        this.mTransitionY = f10;
    }

    public void setOneCode(int i10) {
        int i11 = this.mRectangleNum;
        if (i11 == 4) {
            if (this.mCodeNumber > 3) {
                return;
            }
        } else if (i11 == 6 && this.mCodeNumber > 5) {
            return;
        }
        if (i11 == 4) {
            if (this.mCodeNumber == 3) {
                this.mCodeNumber = -1;
            }
        } else if (i11 == 6 && this.mCodeNumber == 5) {
            this.mCodeNumber = -1;
        }
        ValueAnimator valueAnimator = this.mDeleteAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mDeleteAnimator.end();
        }
        ValueAnimator valueAnimator2 = this.mAddAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mAddAnimator.end();
        }
        this.animationMode = 2;
        this.mCodeNumber++;
        ValueAnimator createMorphingAnimationOutLinedToFilled = createMorphingAnimationOutLinedToFilled();
        this.mAddAnimator = createMorphingAnimationOutLinedToFilled;
        createMorphingAnimationOutLinedToFilled.start();
        if (this.mNumberStrList != null) {
            String valueOf = String.valueOf(i10);
            if (this.mCodeNumber != this.mRectangleNum - 1) {
                this.mNumberStrList.addFirst(valueOf);
            } else {
                this.mNumberStrList.clear();
            }
        }
    }

    public void setOpacity(int i10) {
        this.mOpacity = i10;
    }

    public void setOutlinedRectangleDrawable(Drawable drawable) {
        this.mOutlinedRectangleDrawable = drawable;
    }

    public void setRectanglePadding(int i10) {
        this.mRectanglePadding = i10;
    }

    public void setRectangleType(int i10) {
        this.mRectangleType = i10;
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        this.mScaleX = f10;
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        this.mScaleY = f10;
    }

    public void setSimpleLockType(int i10) {
        if (i10 == 0) {
            this.mRectangleNum = 4;
            this.mRectanglesWidth = (this.mDrawableWidth * 4) + (this.mRectanglePadding * 3);
        } else if (i10 == 1) {
            this.mRectangleNum = 6;
            this.mRectanglesWidth = (this.mDrawableWidth * 6) + (this.mRectanglePadding * 5);
        }
        this.mCodeImageStart = (this.mContentWidth - this.mRectanglesWidth) / 2;
        invalidate();
    }

    public COUISimpleLock(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f6472j);
    }

    public COUISimpleLock(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, COUIContextUtil.isCOUIDarkTheme(context) ? l.f6720z : l.f6719y);
    }

    public COUISimpleLock(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mCodeNumber = -1;
        this.DELETE_ANIMATION = 1;
        this.ADD_ANIMATION = 2;
        this.CLEAR_ALL_ANIMATION = 3;
        this.DRAW_ALL_ANIMATION = 4;
        this.FAILED_ANIMATION = 5;
        this.MORPHING_OUTLINED_TO_FILLED_TIME = 230;
        this.MORPHING_FILLED_TO_OUTLINED_TIME = 230;
        this.SHAKE_AND_FALL_TIME = 800;
        this.FALL_SPEED = 250;
        this.FALL_HEIGHT = 150;
        this.SHAKE_X_POINT = new float[]{0.0f, 30.0f, -28.0f, 14.0f, -8.0f, 4.0f, -3.0f, 0.0f};
        this.DELAY_FOUR = new float[]{0.0f, 38.5f, 91.0f, 63.0f};
        this.DELAY_SIX = new float[]{0.0f, 38.5f, 91.0f, 63.0f, 38.5f, 70.0f};
        this.mRectanglesWidth = 0;
        this.mDrawable = null;
        this.fto_lastDraw = false;
        this.otf_lastDraw = false;
        this.fail_lastDraw = false;
        this.animationMode = 0;
        this.mDrawFailedAnimation = false;
        this.mAddAnimator = null;
        this.mDeleteAnimator = null;
        this.mFailedAnimator = null;
        this.mScaleX = 0.0f;
        this.mScaleY = 0.0f;
        this.mOpacity = 0;
        this.mTransitionX = 0.0f;
        this.mTransitionY = 0.0f;
        this.isFingerprintMode = false;
        this.mRectangleType = -1;
        this.mRectangleNum = -1;
        this.mNumberStrList = null;
        this.mTouchHelper = null;
        this.mDecription = null;
        this.mIsVibrator = true;
        this.mDeleteAnimatorInterpolator = new COUIEaseInterpolator();
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        this.mContext = context;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6819Y1, i10, i11);
        this.mRectanglePadding = obtainStyledAttributes.getDimensionPixelSize(m.f6838c2, 0);
        this.mOutlinedRectangleDrawable = obtainStyledAttributes.getDrawable(m.f6833b2);
        this.mFilledRectangleDrawable = obtainStyledAttributes.getDrawable(m.f6828a2);
        this.mRectangleType = obtainStyledAttributes.getInteger(m.f6823Z1, 0);
        obtainStyledAttributes.recycle();
        Drawable drawable = this.mFilledRectangleDrawable;
        if (drawable != null) {
            this.mDrawable = drawable;
            this.mDrawableWidth = drawable.getIntrinsicWidth();
            this.mDrawableHeight = this.mDrawable.getIntrinsicHeight();
            int i12 = this.mRectangleType;
            if (i12 == 0) {
                this.mRectangleNum = 4;
                this.mRectanglesWidth = (this.mDrawableWidth * 4) + (this.mRectanglePadding * 3);
            } else if (i12 == 1) {
                this.mRectangleNum = 6;
                this.mRectanglesWidth = (this.mDrawableWidth * 6) + (this.mRectanglePadding * 5);
            }
        }
        SimpleLockTouchHelper simpleLockTouchHelper = new SimpleLockTouchHelper(this);
        this.mTouchHelper = simpleLockTouchHelper;
        K.j0(this, simpleLockTouchHelper);
        LinkedList<String> linkedList = new LinkedList<>();
        this.mNumberStrList = linkedList;
        linkedList.clear();
        this.mDecription = context.getResources().getString(k.f6682h);
        setImportantForAccessibility(1);
        this.mIsLinearMotorVersion = VibrateUtils.isLinearMotorVersion(context);
    }

    private void drawFilledRectangle(Canvas canvas, int i10, int i11, int i12, int i13, int i14) {
        Drawable newDrawable = this.mFilledRectangleDrawable.getConstantState().newDrawable();
        this.mDrawable = newDrawable;
        float f10 = this.mTransitionX;
        newDrawable.setBounds((int) (i11 + f10), i10, (int) (i12 + f10), i13);
        this.mDrawable.setAlpha(i14 > 0 ? 255 : 0);
        this.mDrawable.draw(canvas);
    }
}
