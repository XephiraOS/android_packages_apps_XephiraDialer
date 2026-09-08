package com.coui.appcompat.textview;

import X8.e;
import X8.f;
import X8.n;
import X8.o;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.view.K;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.edittext.COUICutoutDrawable;
import com.coui.appcompat.textutil.COUIChangeTextUtil;

/* loaded from: classes3.dex */
public class COUIAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private static final int ALPHA_VALUE = 255;
    private static final int BACKGROUND_ANIMATION_DURATION = 250;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 200;
    public static final int MODE_BACKGROUND_LINE = 1;
    public static final int MODE_BACKGROUND_NONE = 0;
    public static final int MODE_BACKGROUND_RECT = 2;
    private static final double POINT_FIVE = 0.5d;
    private static final String TAG = "AutoCompleteTextView";
    private static final double TWO = 2.0d;
    private ValueAnimator mAnimator;
    private ValueAnimator mAnimator1;
    private ValueAnimator mAnimator2;
    private GradientDrawable mBoxBackground;
    private int mBoxBackgroundMode;
    private float mBoxCornerRadiusBottomEnd;
    private float mBoxCornerRadiusBottomStart;
    private float mBoxCornerRadiusTopEnd;
    private float mBoxCornerRadiusTopStart;
    private int mBoxStrokeColor;
    private final COUICutoutDrawable.COUICollapseTextHelper mCOUICollapseTextHelper;
    private ColorStateList mDefaultHintTextColor;
    private int mDefaultStrokeColor;
    private int mDisabledColor;
    private int mDrawX;
    private int mFocusedAlpha;
    private Paint mFocusedPaint;
    private int mFocusedStrokeColor;
    private ColorStateList mFocusedTextColor;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private boolean mHintEnabled;
    private boolean mHintExpanded;
    private boolean mInDrawableStateChanged;
    private boolean mIsProvidingHint;
    private int mLabelCutoutPadding;
    private boolean mLineExpanded;
    private int mLineModePaddingMiddle;
    private int mLineModePaddingTop;
    private Paint mNormalPaint;
    private CharSequence mOriginalHint;
    private Interpolator mPathInterpolator1;
    private Interpolator mPathInterpolator2;
    private int mRectModePaddingMiddle;
    private int mRectModePaddingTop;
    private int mStrokeWidth;
    private int mStrokeWidthFocused;
    private RectF mTmpRectF;

    public COUIAutoCompleteTextView(Context context) {
        this(context, null);
    }

    private void animateToExpansionFraction(float f10) {
        if (this.mCOUICollapseTextHelper.getExpansionFraction() == f10) {
            return;
        }
        if (this.mAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mAnimator = valueAnimator;
            valueAnimator.setInterpolator(this.mPathInterpolator1);
            this.mAnimator.setDuration(200L);
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.textview.COUIAutoCompleteTextView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIAutoCompleteTextView.this.mCOUICollapseTextHelper.setExpansionFraction(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }
        this.mAnimator.setFloatValues(this.mCOUICollapseTextHelper.getExpansionFraction(), f10);
        this.mAnimator.start();
    }

    private void animateToHideBackground() {
        if (this.mAnimator2 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mAnimator2 = valueAnimator;
            valueAnimator.setInterpolator(this.mPathInterpolator2);
            this.mAnimator2.setDuration(250L);
            this.mAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.textview.COUIAutoCompleteTextView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIAutoCompleteTextView.this.mFocusedAlpha = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    COUIAutoCompleteTextView.this.invalidate();
                }
            });
        }
        this.mAnimator2.setIntValues(255, 0);
        this.mAnimator2.start();
        this.mLineExpanded = false;
    }

    private void animateToShowBackground() {
        if (this.mAnimator1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mAnimator1 = valueAnimator;
            valueAnimator.setInterpolator(this.mPathInterpolator2);
            this.mAnimator1.setDuration(250L);
            this.mAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.textview.COUIAutoCompleteTextView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIAutoCompleteTextView.this.mDrawX = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    COUIAutoCompleteTextView.this.invalidate();
                }
            });
        }
        this.mFocusedAlpha = 255;
        this.mAnimator1.setIntValues(0, getWidth());
        this.mAnimator1.start();
        this.mLineExpanded = true;
    }

    private void applyBoxAttributes() {
        int i10;
        if (this.mBoxBackground == null) {
            return;
        }
        setBoxAttributes();
        int i11 = this.mStrokeWidth;
        if (i11 > -1 && (i10 = this.mBoxStrokeColor) != 0) {
            this.mBoxBackground.setStroke(i11, i10);
        }
        this.mBoxBackground.setCornerRadii(getCornerRadiiAsArray());
        invalidate();
    }

    private void applyCutoutPadding(RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.mLabelCutoutPadding;
        rectF.left = f10 - i10;
        rectF.top -= i10;
        rectF.right += i10;
        rectF.bottom += i10;
    }

    private void assignBoxBackgroundByMode() {
        int i10 = this.mBoxBackgroundMode;
        if (i10 == 0) {
            this.mBoxBackground = null;
            return;
        }
        if (i10 == 2 && this.mHintEnabled && !(this.mBoxBackground instanceof COUICutoutDrawable)) {
            this.mBoxBackground = new COUICutoutDrawable();
        } else if (this.mBoxBackground == null) {
            this.mBoxBackground = new GradientDrawable();
        }
    }

    private int calculateCollapsedTextTopBounds() {
        int i10 = this.mBoxBackgroundMode;
        if (i10 != 1) {
            if (i10 != 2) {
                return getPaddingTop();
            }
            return getBoxBackground().getBounds().top - calculateLabelMarginTop();
        }
        return getBoxBackground().getBounds().top;
    }

    private int calculateLabelMarginTop() {
        return (int) (this.mCOUICollapseTextHelper.getCollapsedTextHeight() / 2.0f);
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((COUICutoutDrawable) this.mBoxBackground).removeCutout();
        }
    }

    private void collapseHint(boolean z10) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (z10 && this.mHintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.mCOUICollapseTextHelper.setExpansionFraction(1.0f);
        }
        this.mHintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
    }

    private boolean cutoutEnabled() {
        if (this.mHintEnabled && !TextUtils.isEmpty(this.mHint) && (this.mBoxBackground instanceof COUICutoutDrawable)) {
            return true;
        }
        return false;
    }

    private void expandHint(boolean z10) {
        if (this.mBoxBackground != null) {
            Log.d(TAG, "mBoxBackground: " + this.mBoxBackground.getBounds());
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (z10 && this.mHintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.mCOUICollapseTextHelper.setExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((COUICutoutDrawable) this.mBoxBackground).hasCutout()) {
            closeCutout();
        }
        this.mHintExpanded = true;
    }

    private int getBoundsTop() {
        int i10 = this.mBoxBackgroundMode;
        if (i10 != 1) {
            if (i10 != 2) {
                return 0;
            }
            return (int) (this.mCOUICollapseTextHelper.getCollapsedTextHeight() / 2.0f);
        }
        return this.mLineModePaddingTop;
    }

    private Drawable getBoxBackground() {
        int i10 = this.mBoxBackgroundMode;
        if (i10 != 1 && i10 != 2) {
            return null;
        }
        return this.mBoxBackground;
    }

    private float[] getCornerRadiiAsArray() {
        float f10 = this.mBoxCornerRadiusTopEnd;
        float f11 = this.mBoxCornerRadiusTopStart;
        float f12 = this.mBoxCornerRadiusBottomStart;
        float f13 = this.mBoxCornerRadiusBottomEnd;
        return new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
    }

    private int getModePaddingTop() {
        int hintHeight;
        int i10;
        int i11 = this.mBoxBackgroundMode;
        if (i11 != 1) {
            if (i11 != 2) {
                return 0;
            }
            hintHeight = this.mRectModePaddingTop;
            i10 = (int) (this.mCOUICollapseTextHelper.getCollapsedTextHeight() / 2.0f);
        } else {
            hintHeight = this.mLineModePaddingTop + ((int) this.mCOUICollapseTextHelper.getHintHeight());
            i10 = this.mLineModePaddingMiddle;
        }
        return hintHeight + i10;
    }

    private void initHintMode(Context context, AttributeSet attributeSet, int i10) {
        this.mCOUICollapseTextHelper.setTextSizeInterpolator(new COUILinearInterpolator());
        this.mCOUICollapseTextHelper.setPositionInterpolator(new COUILinearInterpolator());
        this.mCOUICollapseTextHelper.setCollapsedTextGravity(8388659);
        this.mPathInterpolator1 = new COUIMoveEaseInterpolator();
        this.mPathInterpolator2 = new COUIInEaseInterpolator();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5192R0, i10, n.f5048t);
        boolean z10 = obtainStyledAttributes.getBoolean(o.f5327i1, false);
        this.mHintEnabled = z10;
        if (!z10) {
            obtainStyledAttributes.recycle();
            return;
        }
        setBackgroundDrawable(null);
        setTopHint(obtainStyledAttributes.getText(o.f5208T0));
        this.mHintAnimationEnabled = obtainStyledAttributes.getBoolean(o.f5319h1, true);
        this.mRectModePaddingTop = obtainStyledAttributes.getDimensionPixelOffset(o.f5359m1, 0);
        float dimension = obtainStyledAttributes.getDimension(o.f5232W0, 0.0f);
        this.mBoxCornerRadiusTopStart = dimension;
        this.mBoxCornerRadiusTopEnd = dimension;
        this.mBoxCornerRadiusBottomEnd = dimension;
        this.mBoxCornerRadiusBottomStart = dimension;
        int i11 = o.f5335j1;
        this.mFocusedStrokeColor = obtainStyledAttributes.getColor(i11, -16711936);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(o.f5343k1, 0);
        this.mStrokeWidth = dimensionPixelOffset;
        this.mStrokeWidthFocused = dimensionPixelOffset;
        this.mLabelCutoutPadding = context.getResources().getDimensionPixelOffset(f.f4641Z4);
        this.mLineModePaddingTop = context.getResources().getDimensionPixelOffset(f.f4665c5);
        this.mLineModePaddingMiddle = context.getResources().getDimensionPixelOffset(f.f4657b5);
        this.mRectModePaddingMiddle = context.getResources().getDimensionPixelOffset(f.f4673d5);
        int i12 = obtainStyledAttributes.getInt(o.f5240X0, 0);
        setBoxBackgroundMode(i12);
        int i13 = o.f5200S0;
        if (obtainStyledAttributes.hasValue(i13)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(i13);
            this.mFocusedTextColor = colorStateList;
            this.mDefaultHintTextColor = colorStateList;
        }
        this.mDefaultStrokeColor = context.getResources().getColor(e.f4430G);
        this.mDisabledColor = context.getResources().getColor(e.f4431H);
        setCollapsedTextAppearance(obtainStyledAttributes.getDimensionPixelSize(o.f5224V0, 0), obtainStyledAttributes.getColorStateList(i11));
        if (i12 == 2) {
            this.mCOUICollapseTextHelper.setTypefaces(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
        }
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mNormalPaint = paint;
        paint.setColor(this.mDefaultStrokeColor);
        this.mNormalPaint.setStrokeWidth(this.mStrokeWidth);
        Paint paint2 = new Paint();
        this.mFocusedPaint = paint2;
        paint2.setColor(this.mFocusedStrokeColor);
        this.mFocusedPaint.setStrokeWidth(this.mStrokeWidth);
        setEditText();
    }

    private boolean isRtlMode() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        updateTextInputBoxBounds();
    }

    private void openCutout() {
        if (!cutoutEnabled()) {
            return;
        }
        RectF rectF = this.mTmpRectF;
        this.mCOUICollapseTextHelper.getCollapsedTextActualBounds(rectF);
        applyCutoutPadding(rectF);
        ((COUICutoutDrawable) this.mBoxBackground).setCutout(rectF);
    }

    private void setBoxAttributes() {
        int i10 = this.mBoxBackgroundMode;
        if (i10 != 1) {
            if (i10 == 2 && this.mFocusedStrokeColor == 0) {
                this.mFocusedStrokeColor = this.mFocusedTextColor.getColorForState(getDrawableState(), this.mFocusedTextColor.getDefaultColor());
                return;
            }
            return;
        }
        this.mStrokeWidth = 0;
    }

    private void setEditText() {
        onApplyBoxBackgroundMode();
        this.mCOUICollapseTextHelper.setExpandedTextSize(getTextSize());
        int gravity = getGravity();
        this.mCOUICollapseTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
        this.mCOUICollapseTextHelper.setExpandedTextGravity(gravity);
        if (this.mDefaultHintTextColor == null) {
            this.mDefaultHintTextColor = getHintTextColors();
        }
        if (this.mHintEnabled) {
            setHint((CharSequence) null);
            if (TextUtils.isEmpty(this.mHint)) {
                CharSequence hint = getHint();
                this.mOriginalHint = hint;
                setTopHint(hint);
                setHint((CharSequence) null);
            }
            this.mIsProvidingHint = true;
        }
        updateLabelState(false, true);
        updateModePadding();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mHint)) {
            this.mHint = charSequence;
            this.mCOUICollapseTextHelper.setText(charSequence);
            if (!this.mHintExpanded) {
                openCutout();
            }
        }
    }

    private void updateLineModeBackground() {
        if (this.mBoxBackgroundMode != 1) {
            return;
        }
        if (isEnabled()) {
            if (hasFocus()) {
                if (!this.mLineExpanded) {
                    animateToShowBackground();
                    return;
                }
                return;
            } else {
                if (this.mLineExpanded) {
                    animateToHideBackground();
                    return;
                }
                return;
            }
        }
        this.mDrawX = 0;
    }

    private void updateModePadding() {
        int paddingLeft;
        int paddingRight;
        int modePaddingTop = getModePaddingTop();
        if (isRtlMode()) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isRtlMode()) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        K.A0(this, paddingLeft, modePaddingTop, paddingRight, getPaddingBottom());
    }

    private void updateTextInputBoxBounds() {
        if (this.mBoxBackgroundMode != 0 && this.mBoxBackground != null && getRight() != 0) {
            this.mBoxBackground.setBounds(0, getBoundsTop(), getWidth(), getHeight());
            applyBoxAttributes();
        }
    }

    private void updateTextInputBoxState() {
        int i10;
        if (this.mBoxBackground != null && (i10 = this.mBoxBackgroundMode) != 0 && i10 == 2) {
            if (!isEnabled()) {
                this.mBoxStrokeColor = this.mDisabledColor;
            } else if (hasFocus()) {
                this.mBoxStrokeColor = this.mFocusedStrokeColor;
            } else {
                this.mBoxStrokeColor = this.mDefaultStrokeColor;
            }
            applyBoxAttributes();
        }
    }

    public boolean cutoutIsOpen() {
        if (cutoutEnabled() && ((COUICutoutDrawable) this.mBoxBackground).hasCutout()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mHintEnabled) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.mCOUICollapseTextHelper.draw(canvas);
            if (this.mBoxBackground != null && this.mBoxBackgroundMode == 2) {
                if (getScrollX() != 0) {
                    updateTextInputBoxBounds();
                }
                this.mBoxBackground.draw(canvas);
            }
            if (this.mBoxBackgroundMode == 1) {
                float height = getHeight() - ((int) ((this.mStrokeWidthFocused / TWO) + POINT_FIVE));
                canvas.drawLine(0.0f, height, getWidth(), height, this.mNormalPaint);
                this.mFocusedPaint.setAlpha(this.mFocusedAlpha);
                canvas.drawLine(0.0f, height, this.mDrawX, height, this.mFocusedPaint);
            }
            canvas.restoreToCount(save);
        }
        super.draw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        if (!this.mHintEnabled) {
            super.drawableStateChanged();
            return;
        }
        if (this.mInDrawableStateChanged) {
            return;
        }
        boolean z10 = true;
        this.mInDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (!K.O(this) || !isEnabled()) {
            z10 = false;
        }
        updateLabelState(z10);
        updateLineModeBackground();
        updateTextInputBoxBounds();
        updateTextInputBoxState();
        COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper = this.mCOUICollapseTextHelper;
        if (cOUICollapseTextHelper != null && cOUICollapseTextHelper.setState(drawableState)) {
            invalidate();
        }
        this.mInDrawableStateChanged = false;
    }

    public int getBoxStrokeColor() {
        return this.mFocusedStrokeColor;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        if (this.mHintEnabled) {
            return this.mHint;
        }
        return null;
    }

    public boolean isHintEnabled() {
        return this.mHintEnabled;
    }

    public boolean isProvidingHint() {
        return this.mIsProvidingHint;
    }

    public boolean ismHintAnimationEnabled() {
        return this.mHintAnimationEnabled;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.mHintEnabled) {
            if (this.mBoxBackground != null) {
                updateTextInputBoxBounds();
            }
            updateModePadding();
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int width = getWidth() - getCompoundPaddingRight();
            int calculateCollapsedTextTopBounds = calculateCollapsedTextTopBounds();
            this.mCOUICollapseTextHelper.setExpandedBounds(compoundPaddingLeft, getCompoundPaddingTop(), width, getHeight() - getCompoundPaddingBottom());
            this.mCOUICollapseTextHelper.setCollapsedBounds(compoundPaddingLeft, calculateCollapsedTextTopBounds, width, getHeight() - getCompoundPaddingBottom());
            this.mCOUICollapseTextHelper.recalculate();
            if (cutoutEnabled() && !this.mHintExpanded) {
                openCutout();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.mBoxBackgroundMode) {
            return;
        }
        this.mBoxBackgroundMode = i10;
        onApplyBoxBackgroundMode();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.mFocusedStrokeColor != i10) {
            this.mFocusedStrokeColor = i10;
            updateTextInputBoxState();
        }
    }

    public void setCollapsedTextAppearance(int i10, ColorStateList colorStateList) {
        this.mCOUICollapseTextHelper.setCollapsedTextAppearance(i10, colorStateList);
        this.mFocusedTextColor = this.mCOUICollapseTextHelper.getCollapsedTextColor();
        updateLabelState(false);
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.mHintEnabled) {
            this.mHintEnabled = z10;
            if (!z10) {
                this.mIsProvidingHint = false;
                if (!TextUtils.isEmpty(this.mHint) && TextUtils.isEmpty(getHint())) {
                    setHint(this.mHint);
                }
                setHintInternal(null);
                return;
            }
            CharSequence hint = getHint();
            if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.mHint)) {
                    setTopHint(hint);
                }
                setHint((CharSequence) null);
            }
            this.mIsProvidingHint = true;
        }
    }

    public void setTopHint(CharSequence charSequence) {
        if (this.mHintEnabled) {
            setHintInternal(charSequence);
        }
    }

    public void setmHintAnimationEnabled(boolean z10) {
        this.mHintAnimationEnabled = z10;
    }

    public void updateLabelState(boolean z10) {
        updateLabelState(z10, false);
    }

    public COUIAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    private void updateLabelState(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        boolean isEnabled = isEnabled();
        boolean z12 = !TextUtils.isEmpty(getText());
        ColorStateList colorStateList2 = this.mDefaultHintTextColor;
        if (colorStateList2 != null) {
            this.mCOUICollapseTextHelper.setCollapsedTextColor(colorStateList2);
            this.mCOUICollapseTextHelper.setExpandedTextColor(this.mDefaultHintTextColor);
        }
        if (!isEnabled) {
            this.mCOUICollapseTextHelper.setCollapsedTextColor(ColorStateList.valueOf(this.mDisabledColor));
            this.mCOUICollapseTextHelper.setExpandedTextColor(ColorStateList.valueOf(this.mDisabledColor));
        } else if (hasFocus() && (colorStateList = this.mFocusedTextColor) != null) {
            this.mCOUICollapseTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (!z12 && (!isEnabled() || !hasFocus())) {
            if (z11 || !this.mHintExpanded) {
                expandHint(z10);
                return;
            }
            return;
        }
        if (z11 || this.mHintExpanded) {
            collapseHint(z10);
        }
    }

    public COUIAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mCOUICollapseTextHelper = new COUICutoutDrawable.COUICollapseTextHelper(this);
        this.mStrokeWidth = 3;
        this.mTmpRectF = new RectF();
        initHintMode(context, attributeSet, i10);
    }
}
