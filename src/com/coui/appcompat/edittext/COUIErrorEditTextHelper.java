package com.coui.appcompat.edittext;

import X8.f;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.view.animation.Interpolator;
import android.widget.EditText;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.edittext.COUICutoutDrawable;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class COUIErrorEditTextHelper {
    private static final int DELAY_MASK_ANIMATOR = 80;
    private static final int DURATION_HINT_ANIMATOR = 217;
    private static final int DURATION_MASK_ANIMATOR = 133;
    private static final int MAX_COLOR_VALUE = 255;
    private static final float SELECTION_MASK_ALPHA_MAX = 0.3f;
    private static final Rect tmpRect = new Rect();
    private boolean mAnimating;
    private COUICutoutDrawable mBoxBackground;
    private final COUICutoutDrawable.COUICollapseTextHelper mCOUICollapseTextHelper;
    private ColorStateList mCollapsedTextColor;
    private final EditText mEditText;
    private int mErrorColor;
    private Paint mErrorPaint;
    private boolean mErrorState;
    private AnimatorSet mErrorTrueAnimatorSet;
    private ColorStateList mExpandedTextColor;
    private float mHintColorChangeProgress;
    private boolean mIsFocusedAtAnimateBeginning;
    private ArrayList<COUIEditText.OnErrorStateChangedListener> mOnErrorStateChangedListeners;
    private int mOriginalHighlightColor;
    private ColorStateList mOriginalTextColors;
    private float mSelectionMaskAlpha;
    private Paint mSelectionMaskPaint;
    private float mSingleCOUIEditTextHeight;
    private int mStrokeWidth;
    private float mTextShakeOffset;
    private float mTextWidth;

    /* loaded from: classes.dex */
    public static class ShakeInterpolator implements Interpolator {
        private static final int[] DURATIONS;
        private static final float[] OFFSETS = {0.0f, -1.0f, 0.5f, -0.5f, 0.0f};
        static final int TOTAL_DURATION = 450;
        private static final float[] progresses;
        private final Interpolator mBetweenInterpolator;

        static {
            int[] iArr = {83, 133, 117, 117};
            DURATIONS = iArr;
            progresses = new float[iArr.length + 1];
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int[] iArr2 = DURATIONS;
                if (i10 < iArr2.length) {
                    i11 += iArr2[i10];
                    i10++;
                    progresses[i10] = i11 / 450.0f;
                } else {
                    return;
                }
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            int i10 = 1;
            while (true) {
                float[] fArr = progresses;
                if (i10 < fArr.length) {
                    float f11 = fArr[i10];
                    if (f10 <= f11) {
                        int i11 = i10 - 1;
                        float f12 = fArr[i11];
                        float interpolation = this.mBetweenInterpolator.getInterpolation((f10 - f12) / (f11 - f12));
                        float[] fArr2 = OFFSETS;
                        return (fArr2[i11] * (1.0f - interpolation)) + (fArr2[i10] * interpolation);
                    }
                    i10++;
                } else {
                    return 0.0f;
                }
            }
        }

        private ShakeInterpolator() {
            this.mBetweenInterpolator = new COUIEaseInterpolator();
        }
    }

    public COUIErrorEditTextHelper(EditText editText) {
        this(editText, 1);
    }

    private void cancelAnimation() {
        if (this.mErrorTrueAnimatorSet.isStarted()) {
            this.mErrorTrueAnimatorSet.cancel();
        }
    }

    private Layout.Alignment getAlignment() {
        switch (this.mEditText.getTextAlignment()) {
            case 1:
                int gravity = this.mEditText.getGravity() & 8388615;
                if (gravity != 1) {
                    if (gravity != 3) {
                        if (gravity != 5) {
                            if (gravity != 8388611) {
                                if (gravity != 8388613) {
                                    return Layout.Alignment.ALIGN_NORMAL;
                                }
                                return Layout.Alignment.ALIGN_OPPOSITE;
                            }
                            return Layout.Alignment.ALIGN_NORMAL;
                        }
                        if (isRtlMode()) {
                            return Layout.Alignment.ALIGN_NORMAL;
                        }
                        return Layout.Alignment.ALIGN_OPPOSITE;
                    }
                    if (isRtlMode()) {
                        return Layout.Alignment.ALIGN_OPPOSITE;
                    }
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_CENTER;
            case 2:
                return Layout.Alignment.ALIGN_NORMAL;
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 4:
                return Layout.Alignment.ALIGN_CENTER;
            case 5:
                return Layout.Alignment.ALIGN_NORMAL;
            case 6:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                return Layout.Alignment.ALIGN_NORMAL;
        }
    }

    private CharSequence getFullText() {
        if (!isPassword()) {
            return this.mEditText.getText();
        }
        return getMaskChars();
    }

    private int getGradientColor(int i10, int i11, float f10) {
        if (f10 <= 0.0f) {
            return i10;
        }
        if (f10 >= 1.0f) {
            return i11;
        }
        float f11 = 1.0f - f10;
        int alpha = (int) ((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10));
        int red = (int) ((Color.red(i10) * f11) + (Color.red(i11) * f10));
        int green = (int) ((Color.green(i10) * f11) + (Color.green(i11) * f10));
        int blue = (int) ((Color.blue(i10) * f11) + (Color.blue(i11) * f10));
        if (alpha > 255) {
            alpha = 255;
        }
        if (red > 255) {
            red = 255;
        }
        if (green > 255) {
            green = 255;
        }
        if (blue > 255) {
            blue = 255;
        }
        return Color.argb(alpha, red, green, blue);
    }

    private CharSequence getMaskChars() {
        TransformationMethod transformationMethod = this.mEditText.getTransformationMethod();
        if (transformationMethod != null) {
            return transformationMethod.getTransformation(this.mEditText.getText(), this.mEditText);
        }
        return this.mEditText.getText();
    }

    private int getSelectionMaskColor(float f10) {
        return Color.argb((int) (f10 * 255.0f), Color.red(this.mErrorColor), Color.green(this.mErrorColor), Color.blue(this.mErrorColor));
    }

    private void initAnimator() {
        float dimension = this.mEditText.getResources().getDimension(f.f4810v1);
        COUIEaseInterpolator cOUIEaseInterpolator = new COUIEaseInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(cOUIEaseInterpolator);
        ofFloat.setDuration(217L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUIErrorEditTextHelper.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIErrorEditTextHelper.this.mHintColorChangeProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, dimension);
        ofFloat2.setInterpolator(new ShakeInterpolator());
        ofFloat2.setDuration(450L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUIErrorEditTextHelper.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (COUIErrorEditTextHelper.this.mIsFocusedAtAnimateBeginning) {
                    COUIErrorEditTextHelper.this.mTextShakeOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
                COUIErrorEditTextHelper.this.mEditText.invalidate();
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 0.3f);
        ofFloat3.setInterpolator(cOUIEaseInterpolator);
        ofFloat3.setDuration(133L);
        ofFloat3.setStartDelay(80L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUIErrorEditTextHelper.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (COUIErrorEditTextHelper.this.mIsFocusedAtAnimateBeginning) {
                    COUIErrorEditTextHelper.this.mSelectionMaskAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mErrorTrueAnimatorSet = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        this.mErrorTrueAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.edittext.COUIErrorEditTextHelper.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIErrorEditTextHelper.this.setErrorStateEnd(true, true, true);
                COUIErrorEditTextHelper.this.performOnErrorStateChangeAnimationEnd(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIErrorEditTextHelper.this.mEditText.setSelection(COUIErrorEditTextHelper.this.mEditText.length());
                if (COUIErrorEditTextHelper.this.mSingleCOUIEditTextHeight <= 0.0f) {
                    COUIErrorEditTextHelper.this.mEditText.post(new Runnable() { // from class: com.coui.appcompat.edittext.COUIErrorEditTextHelper.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            COUIErrorEditTextHelper.this.mSingleCOUIEditTextHeight = r1.mEditText.getHeight();
                        }
                    });
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private boolean isPassword() {
        if ((this.mEditText.getInputType() & 128) != 128 && (this.mEditText.getInputType() & 16) != 16) {
            return false;
        }
        return true;
    }

    private boolean isRtlMode() {
        if (this.mEditText.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performOnErrorStateChangeAnimationEnd(boolean z10) {
        if (this.mOnErrorStateChangedListeners != null) {
            for (int i10 = 0; i10 < this.mOnErrorStateChangedListeners.size(); i10++) {
                this.mOnErrorStateChangedListeners.get(i10).onErrorStateChangeAnimationEnd(z10);
            }
        }
    }

    private void performOnErrorStateChanged(boolean z10) {
        if (this.mOnErrorStateChangedListeners != null) {
            for (int i10 = 0; i10 < this.mOnErrorStateChangedListeners.size(); i10++) {
                this.mOnErrorStateChangedListeners.get(i10).onErrorStateChanged(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorStateEnd(boolean z10, boolean z11, boolean z12) {
        this.mAnimating = false;
        if (z10) {
            if (z11) {
                this.mEditText.setTextColor(this.mOriginalTextColors);
            }
            this.mEditText.setHighlightColor(getSelectionMaskColor(0.3f));
            if (z12) {
                EditText editText = this.mEditText;
                editText.setSelection(0, editText.getText().length());
                return;
            }
            return;
        }
        this.mEditText.setTextColor(this.mOriginalTextColors);
        this.mEditText.setHighlightColor(this.mOriginalHighlightColor);
    }

    private void setErrorStateWithAnimation(boolean z10, boolean z11) {
        if (z10) {
            cancelAnimation();
            this.mEditText.setTextColor(0);
            this.mEditText.setHighlightColor(0);
            this.mHintColorChangeProgress = 0.0f;
            this.mTextShakeOffset = 0.0f;
            this.mSelectionMaskAlpha = 0.0f;
            this.mAnimating = true;
            this.mIsFocusedAtAnimateBeginning = this.mEditText.isFocused();
            this.mErrorTrueAnimatorSet.start();
            return;
        }
        cancelAnimation();
        setErrorStateEnd(false, false, z11);
    }

    private void setErrorStateWithoutAnimation(boolean z10, boolean z11) {
        if (z10) {
            this.mHintColorChangeProgress = 1.0f;
            this.mTextShakeOffset = 0.0f;
            this.mSelectionMaskAlpha = 0.0f;
            setErrorStateEnd(true, false, z11);
            return;
        }
        setErrorStateEnd(false, false, z11);
    }

    public void addOnErrorStateChangedListener(COUIEditText.OnErrorStateChangedListener onErrorStateChangedListener) {
        if (this.mOnErrorStateChangedListeners == null) {
            this.mOnErrorStateChangedListeners = new ArrayList<>();
        }
        if (!this.mOnErrorStateChangedListeners.contains(onErrorStateChangedListener)) {
            this.mOnErrorStateChangedListeners.add(onErrorStateChangedListener);
        }
    }

    public void drawCollapseText(Canvas canvas, COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper) {
        this.mCOUICollapseTextHelper.setCollapsedTextColor(ColorStateList.valueOf(getGradientColor(this.mCollapsedTextColor.getDefaultColor(), this.mErrorColor, this.mHintColorChangeProgress)));
        this.mCOUICollapseTextHelper.setExpandedTextColor(ColorStateList.valueOf(getGradientColor(this.mExpandedTextColor.getDefaultColor(), this.mErrorColor, this.mHintColorChangeProgress)));
        this.mCOUICollapseTextHelper.setExpansionFraction(cOUICollapseTextHelper.getExpandedFraction());
        this.mCOUICollapseTextHelper.draw(canvas);
    }

    public void drawModeBackgroundLine(Canvas canvas, int i10, int i11, int i12, Paint paint, Paint paint2) {
        this.mErrorPaint.setColor(getGradientColor(paint.getColor(), this.mErrorColor, this.mHintColorChangeProgress));
        float f10 = i10;
        canvas.drawRect(0.0f, i10 - this.mStrokeWidth, i11, f10, this.mErrorPaint);
        this.mErrorPaint.setColor(getGradientColor(paint2.getColor(), this.mErrorColor, this.mHintColorChangeProgress));
        canvas.drawRect(0.0f, i10 - this.mStrokeWidth, i12, f10, this.mErrorPaint);
    }

    public void drawModeBackgroundRect(Canvas canvas, GradientDrawable gradientDrawable, int i10) {
        this.mBoxBackground.setBounds(gradientDrawable.getBounds());
        if (gradientDrawable instanceof COUICutoutDrawable) {
            this.mBoxBackground.setCutout(((COUICutoutDrawable) gradientDrawable).getCutout());
        }
        this.mBoxBackground.setStroke(this.mStrokeWidth, getGradientColor(i10, this.mErrorColor, this.mHintColorChangeProgress));
        this.mBoxBackground.draw(canvas);
    }

    public void drawableStateChanged(int[] iArr) {
        this.mCOUICollapseTextHelper.setState(iArr);
    }

    public void init(int i10, int i11, int i12, float[] fArr, COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper) {
        this.mOriginalTextColors = this.mEditText.getTextColors();
        this.mOriginalHighlightColor = this.mEditText.getHighlightColor();
        this.mErrorColor = i10;
        this.mStrokeWidth = i11;
        if (i12 == 2) {
            this.mCOUICollapseTextHelper.setTypefaces(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
        }
        this.mCOUICollapseTextHelper.setExpandedTextSize(cOUICollapseTextHelper.getExpandedTextSize());
        this.mCOUICollapseTextHelper.setCollapsedTextGravity(cOUICollapseTextHelper.getCollapsedTextGravity());
        this.mCOUICollapseTextHelper.setExpandedTextGravity(cOUICollapseTextHelper.getExpandedTextGravity());
        COUICutoutDrawable cOUICutoutDrawable = new COUICutoutDrawable();
        this.mBoxBackground = cOUICutoutDrawable;
        cOUICutoutDrawable.setCornerRadii(fArr);
        this.mErrorPaint = new Paint();
        this.mSelectionMaskPaint = new Paint();
        initAnimator();
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.edittext.COUIErrorEditTextHelper.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                COUIErrorEditTextHelper.this.setErrorState(false, false, false);
                Editable text = COUIErrorEditTextHelper.this.mEditText.getText();
                int length = text.length();
                COUIErrorEditTextHelper cOUIErrorEditTextHelper = COUIErrorEditTextHelper.this;
                cOUIErrorEditTextHelper.mTextWidth = cOUIErrorEditTextHelper.mEditText.getPaint().measureText(text, 0, length);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i13, int i14, int i15) {
                if (COUIErrorEditTextHelper.this.mSingleCOUIEditTextHeight <= 0.0f) {
                    COUIErrorEditTextHelper.this.mSingleCOUIEditTextHeight = r0.mEditText.getHeight();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i13, int i14, int i15) {
            }
        });
        setHintInternal(cOUICollapseTextHelper);
        updateLabelState(cOUICollapseTextHelper);
    }

    public boolean isErrorState() {
        return this.mErrorState;
    }

    public void onDraw(Canvas canvas) {
        Layout.Alignment alignment;
        float f10;
        float f11;
        if (this.mAnimating && this.mErrorState) {
            int save = canvas.save();
            if (!isRtlMode()) {
                canvas.translate(this.mTextShakeOffset, 0.0f);
            } else {
                canvas.translate(-this.mTextShakeOffset, 0.0f);
            }
            int compoundPaddingStart = this.mEditText.getCompoundPaddingStart();
            int compoundPaddingEnd = this.mEditText.getCompoundPaddingEnd();
            int width = this.mEditText.getWidth() - compoundPaddingEnd;
            int i10 = width - compoundPaddingStart;
            float x10 = width + this.mEditText.getX() + this.mEditText.getScrollX();
            float f12 = i10;
            float scrollX = (this.mTextWidth - this.mEditText.getScrollX()) - f12;
            this.mEditText.getLineBounds(0, tmpRect);
            int save2 = canvas.save();
            if (!isRtlMode()) {
                canvas.translate(compoundPaddingStart, r10.top);
            } else {
                canvas.translate(compoundPaddingEnd, r10.top);
            }
            int save3 = canvas.save();
            if (this.mEditText.getBottom() - this.mEditText.getTop() == this.mSingleCOUIEditTextHeight && this.mTextWidth > f12) {
                if (!isRtlMode()) {
                    canvas.translate(-scrollX, 0.0f);
                    canvas.clipRect(this.mEditText.getScrollX(), 0.0f, x10, this.mSingleCOUIEditTextHeight);
                } else {
                    canvas.clipRect(this.mEditText.getScrollX() + i10, 0.0f, this.mEditText.getScrollX(), this.mSingleCOUIEditTextHeight);
                }
            }
            Layout layout = this.mEditText.getLayout();
            layout.getPaint().setColor(this.mOriginalTextColors.getDefaultColor());
            layout.draw(canvas);
            canvas.restoreToCount(save3);
            canvas.restoreToCount(save2);
            Layout.Alignment alignment2 = getAlignment();
            this.mSelectionMaskPaint.setColor(getSelectionMaskColor(this.mSelectionMaskAlpha));
            Layout.Alignment alignment3 = Layout.Alignment.ALIGN_NORMAL;
            if ((alignment2 == alignment3 && !isRtlMode()) || ((alignment2 == (alignment = Layout.Alignment.ALIGN_OPPOSITE) && isRtlMode()) || ((alignment2 == alignment3 && isRtlMode()) || (alignment2 == alignment && !isRtlMode())))) {
                f10 = compoundPaddingStart;
                f11 = f10;
            } else {
                float f13 = ((compoundPaddingStart + r4) - compoundPaddingEnd) / 2.0f;
                float f14 = this.mTextWidth;
                float f15 = f13 - (f14 / 2.0f);
                f10 = f15;
                f11 = f15 + f14;
            }
            canvas.drawRect(f10, r10.top, f11, r10.bottom, this.mSelectionMaskPaint);
            canvas.restoreToCount(save);
        }
    }

    public void onLayout(COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper) {
        Rect expandedBounds = cOUICollapseTextHelper.getExpandedBounds();
        Rect collapsedBounds = cOUICollapseTextHelper.getCollapsedBounds();
        this.mCOUICollapseTextHelper.setExpandedBounds(expandedBounds.left, expandedBounds.top, expandedBounds.right, expandedBounds.bottom);
        this.mCOUICollapseTextHelper.setCollapsedBounds(collapsedBounds.left, collapsedBounds.top, collapsedBounds.right, collapsedBounds.bottom);
        this.mCOUICollapseTextHelper.recalculate();
    }

    public void removeOnErrorStateChangedListener(COUIEditText.OnErrorStateChangedListener onErrorStateChangedListener) {
        ArrayList<COUIEditText.OnErrorStateChangedListener> arrayList = this.mOnErrorStateChangedListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(onErrorStateChangedListener);
    }

    public void setCollapsedTextAppearance(int i10, ColorStateList colorStateList) {
        this.mCOUICollapseTextHelper.setCollapsedTextAppearance(i10, colorStateList);
    }

    public void setErrorColor(int i10) {
        this.mErrorColor = i10;
    }

    public void setErrorState(boolean z10) {
        setErrorState(z10, true);
    }

    public void setHintInternal(COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper) {
        this.mCOUICollapseTextHelper.setText(cOUICollapseTextHelper.getText());
    }

    public void setOriginalTextColors(ColorStateList colorStateList) {
        this.mOriginalTextColors = colorStateList;
    }

    public void updateLabelState(COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper) {
        this.mCollapsedTextColor = cOUICollapseTextHelper.getCollapsedTextColor();
        this.mExpandedTextColor = cOUICollapseTextHelper.getExpandedTextColor();
        this.mCOUICollapseTextHelper.setCollapsedTextColor(this.mCollapsedTextColor);
        this.mCOUICollapseTextHelper.setExpandedTextColor(this.mExpandedTextColor);
    }

    public COUIErrorEditTextHelper(EditText editText, int i10) {
        this.mEditText = editText;
        COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper = new COUICutoutDrawable.COUICollapseTextHelper(editText);
        this.mCOUICollapseTextHelper = cOUICollapseTextHelper;
        cOUICollapseTextHelper.setHintLines(i10);
        cOUICollapseTextHelper.setTextSizeInterpolator(new COUILinearInterpolator());
        cOUICollapseTextHelper.setPositionInterpolator(new COUILinearInterpolator());
        cOUICollapseTextHelper.setCollapsedTextGravity(8388659);
    }

    private void setErrorState(boolean z10, boolean z11) {
        setErrorState(z10, z11, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setErrorState(boolean z10, boolean z11, boolean z12) {
        if (this.mErrorState == z10) {
            return;
        }
        this.mErrorState = z10;
        performOnErrorStateChanged(z10);
        if (z11) {
            setErrorStateWithAnimation(z10, z12);
        } else {
            setErrorStateWithoutAnimation(z10, z12);
        }
    }
}
