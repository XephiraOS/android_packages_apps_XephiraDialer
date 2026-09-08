package com.coui.appcompat.chip;

import X8.n;
import X8.o;
import a9.d;
import a9.l;
import a9.m;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.K;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.pressfeedback.COUIPressFeedbackHelper;
import com.coui.appcompat.reddot.COUIHintRedDotHelper;
import com.coui.appcompat.state.COUIStrokeDrawable;
import com.coui.appcompat.state.StateEffectAnimator;
import com.coui.appcompat.state.StatefulDrawableListener;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

/* loaded from: classes.dex */
public class COUIChip extends Chip {
    private static final int ALPHA_VALUE_30 = 1308622847;
    private static final int BACKGROUND_COLOR_STATE_SIZE = 2;
    private static final int COLOR_ANIMATION_DURATION = 200;
    private static final float DEFAULT_STATE_SPRING_BOUNCE = 0.0f;
    private static final float DEFAULT_STATE_SPRING_RESPONSE = 0.3f;
    private static final int STATE_CHECKED = 1;
    private static final int STATE_DISABLED = 2;
    private static final int STATE_UNCHECKED = 0;
    private static final String TAG = "COUIChip";
    private static final int TEXT_COLOR_STATE_SIZE = 3;
    private boolean isShowRedDot;
    private boolean mAnimEnable;
    private ValueAnimator mBackgroundColorAnimator;
    private int[][] mBackgroundColorStates;
    private int[] mBackgroundColors;
    private int mBgColorAnimCurVal;
    private int mBgColorAnimEndVal;
    private int mCheckDisabledTextColor;
    private int mCheckedBackgroundColor;
    private int mCheckedTextColor;
    private Interpolator mColorAnimationInterpolator;
    private int mDisabledTextColor;
    private String mFontAfterChecked;
    private COUIHintRedDotHelper mHintRedDotHelper;
    private StateEffectAnimator mHoverAnimator;
    private int mHoverMaskColor;
    private int[] mLocation;
    private boolean mOpenCheckedTextFontFamily;
    private StateEffectAnimator mPressAnimator;
    private int mPressMaskColor;
    private COUIPressFeedbackHelper mPressScaleHelper;
    private RectF mRectF;
    private int mRedDotOffsetHorizontal;
    private int mRedDotOffsetVertical;
    private COUIStrokeDrawable mStrokeDrawable;
    private int mStyle;
    private ValueAnimator mTextColorAnimator;
    private int[][] mTextColorStates;
    private int[] mTextColors;
    private int mTxColorAnimCurVal;
    private int mTxColorAnimEndVal;
    private int mUncheckedBackgroundColor;
    private int mUncheckedTextColor;
    private static final RectF CHIP_RECT = new RectF();
    private static final int[] CHIP_STATE_CHECKED = {R.attr.state_checked, 16842910};
    private static final int[] CHIP_STATE_UNCHECKED = {-16842912, 16842910};
    private static final int[] CHIP_STATE_DISABLED = {-16842910};

    public COUIChip(Context context) {
        this(context, null);
    }

    private void changeFontFamily(boolean z10) {
        if (z10 != isChecked()) {
            changeFontFamilyImpl(z10);
        }
    }

    private void changeFontFamilyImpl(boolean z10) {
        if (!this.mOpenCheckedTextFontFamily) {
            return;
        }
        if (z10) {
            setTypeface(Typeface.create(this.mFontAfterChecked, 0));
        } else {
            setTypeface(Typeface.DEFAULT);
        }
    }

    private void configStateAnimator() {
        this.mStrokeDrawable = new COUIStrokeDrawable(getContext());
        this.mPressScaleHelper = new COUIPressFeedbackHelper(this, 2);
        this.mHoverAnimator = new StateEffectAnimator(null, null, "hover", 0, COUIContextUtil.getAttrColor(getContext(), X8.c.f4414x));
        this.mPressAnimator = new StateEffectAnimator(null, null, "press", 0, COUIContextUtil.getAttrColor(getContext(), X8.c.f4345D));
        this.mHoverAnimator.setSpringBounce(0.0f);
        this.mHoverAnimator.setSpringResponse(0.3f);
        this.mPressAnimator.setSpringBounce(0.0f);
        this.mPressAnimator.setSpringResponse(0.3f);
        this.mStrokeDrawable.setStatefulDrawableListener(new StatefulDrawableListener() { // from class: com.coui.appcompat.chip.a
            @Override // com.coui.appcompat.state.StatefulDrawableListener
            public final void onDrawableUpdate() {
                COUIChip.this.invalidate();
            }
        });
        this.mHoverAnimator.setStateEffectAnimatorListener(new StateEffectAnimator.StateEffectAnimatorListener() { // from class: com.coui.appcompat.chip.b
            @Override // com.coui.appcompat.state.StateEffectAnimator.StateEffectAnimatorListener
            public final void onValueUpdateListener(float f10) {
                COUIChip.this.lambda$configStateAnimator$0(f10);
            }
        });
        this.mPressAnimator.setStateEffectAnimatorListener(new StateEffectAnimator.StateEffectAnimatorListener() { // from class: com.coui.appcompat.chip.c
            @Override // com.coui.appcompat.state.StateEffectAnimator.StateEffectAnimatorListener
            public final void onValueUpdateListener(float f10) {
                COUIChip.this.lambda$configStateAnimator$1(f10);
            }
        });
    }

    private void drawRedDot(Canvas canvas) {
        float f10;
        float f11;
        float textEndPadding;
        int viewWidth = this.mHintRedDotHelper.getViewWidth(1, 0);
        int viewHeight = this.mHintRedDotHelper.getViewHeight(1);
        float measureText = getPaint().measureText(getText().toString());
        float f12 = 0.0f;
        if (isChipIconVisible() && getChipIcon() != null) {
            f10 = getChipIconSize() + getIconStartPadding() + getIconEndPadding() + 0.0f;
        } else {
            f10 = 0.0f;
        }
        if (isCloseIconVisible() && getCloseIcon() != null) {
            f11 = getCloseIconSize() + getCloseIconStartPadding() + getCloseIconEndPadding() + 0.0f;
        } else {
            f11 = 0.0f;
        }
        float width = (((((getWidth() - getTextEndPadding()) - getTextStartPadding()) - f10) - f11) - measureText) / 2.0f;
        if (f11 > 0.0f) {
            textEndPadding = getCloseIconEndPadding();
        } else {
            textEndPadding = getTextEndPadding();
        }
        float width2 = getWidth() - textEndPadding;
        if (width > 0.0f) {
            f12 = width;
        }
        float f13 = (width2 - f12) + this.mRedDotOffsetHorizontal;
        if (isLayoutRTL()) {
            f13 = (getWidth() - f13) - viewWidth;
        }
        float f14 = viewWidth + f13;
        RectF rectF = this.mRectF;
        rectF.left = f13;
        float f15 = this.mRedDotOffsetVertical;
        rectF.top = f15;
        rectF.right = f14;
        rectF.bottom = f15 + viewHeight;
        if (getScrollX() == 0 && getScrollY() == 0) {
            this.mHintRedDotHelper.drawRedPoint(canvas, 1, 1, this.mRectF);
            return;
        }
        canvas.translate(getScrollX(), getScrollY());
        this.mHintRedDotHelper.drawRedPoint(canvas, 1, 1, this.mRectF);
        canvas.translate(-getScrollX(), -getScrollY());
    }

    private void drawStroke(Canvas canvas) {
        RectF rectF = CHIP_RECT;
        rectF.set(getScrollX(), getScrollY(), getScrollX() + getWidth(), getScrollY() + getHeight());
        this.mStrokeDrawable.setStrokeRect(rectF, getChipCornerRadius(), getChipCornerRadius());
        this.mStrokeDrawable.draw(canvas);
    }

    private void executeBackgroundColorAnimator(final boolean z10) {
        ValueAnimator valueAnimator = this.mBackgroundColorAnimator;
        if (valueAnimator == null) {
            this.mBackgroundColorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.mBgColorAnimCurVal), Integer.valueOf(this.mBgColorAnimEndVal));
        } else {
            valueAnimator.setIntValues(this.mBgColorAnimCurVal, this.mBgColorAnimEndVal);
        }
        this.mBackgroundColorAnimator.setInterpolator(this.mColorAnimationInterpolator);
        this.mBackgroundColorAnimator.setDuration(200L);
        this.mBackgroundColorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.chip.COUIChip.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUIChip.this.mBgColorAnimCurVal = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                COUIChip.this.mBackgroundColors[!z10 ? 1 : 0] = COUIChip.this.mBgColorAnimCurVal;
                COUIChip.this.setChipBackgroundColor(new ColorStateList(COUIChip.this.mBackgroundColorStates, COUIChip.this.mBackgroundColors));
            }
        });
        this.mBackgroundColorAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.chip.COUIChip.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIChip.this.mBgColorAnimCurVal == COUIChip.this.mUncheckedBackgroundColor || COUIChip.this.mBgColorAnimCurVal == COUIChip.this.mCheckedBackgroundColor) {
                    COUIChip cOUIChip = COUIChip.this;
                    cOUIChip.resetBackgroundColor(cOUIChip.isEnabled());
                }
            }
        });
        this.mBackgroundColorAnimator.start();
    }

    private void executeColorAnimation(MotionEvent motionEvent, boolean z10) {
        boolean z11;
        int i10;
        getLocationOnScreen(this.mLocation);
        boolean z12 = false;
        if (motionEvent.getRawX() > this.mLocation[0] && motionEvent.getRawX() < this.mLocation[0] + getWidth() && motionEvent.getRawY() > this.mLocation[1] && motionEvent.getRawY() < this.mLocation[1] + getHeight()) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i11 = this.mBgColorAnimCurVal;
        int i12 = this.mCheckedBackgroundColor;
        if (i11 == i12 || i11 == this.mUncheckedBackgroundColor || (i10 = this.mTxColorAnimCurVal) == this.mCheckedTextColor || i10 == this.mUncheckedTextColor) {
            z12 = true;
        }
        if (z11) {
            if (z12) {
                if (z10) {
                    this.mBgColorAnimCurVal = i12;
                    this.mBgColorAnimEndVal = this.mUncheckedBackgroundColor;
                    this.mTxColorAnimCurVal = this.mCheckedTextColor;
                    this.mTxColorAnimEndVal = this.mUncheckedTextColor;
                } else {
                    this.mBgColorAnimCurVal = this.mUncheckedBackgroundColor;
                    this.mBgColorAnimEndVal = i12;
                    this.mTxColorAnimCurVal = this.mUncheckedTextColor;
                    this.mTxColorAnimEndVal = this.mCheckedTextColor;
                }
            } else if (z10) {
                this.mBgColorAnimEndVal = this.mUncheckedBackgroundColor;
                this.mTxColorAnimEndVal = this.mUncheckedTextColor;
            } else {
                this.mBgColorAnimEndVal = i12;
                this.mTxColorAnimEndVal = this.mCheckedTextColor;
            }
            executeBackgroundColorAnimator(z10);
            executeTextColorAnimator(z10);
            return;
        }
        if (!z12) {
            if (z10) {
                this.mBgColorAnimEndVal = i12;
                this.mTxColorAnimEndVal = this.mCheckedTextColor;
            } else {
                this.mBgColorAnimEndVal = this.mUncheckedBackgroundColor;
                this.mTxColorAnimEndVal = this.mUncheckedTextColor;
            }
            executeBackgroundColorAnimator(!z10);
            executeTextColorAnimator(!z10);
        }
    }

    private void executeScaleAnimator(boolean z10) {
        this.mPressScaleHelper.executeFeedbackAnimator(z10);
    }

    private void executeTextColorAnimator(final boolean z10) {
        ValueAnimator valueAnimator = this.mTextColorAnimator;
        if (valueAnimator == null) {
            this.mTextColorAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.mTxColorAnimCurVal), Integer.valueOf(this.mTxColorAnimEndVal));
        } else {
            valueAnimator.setIntValues(this.mTxColorAnimCurVal, this.mTxColorAnimEndVal);
        }
        this.mTextColorAnimator.setInterpolator(this.mColorAnimationInterpolator);
        this.mTextColorAnimator.setDuration(200L);
        this.mTextColorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.chip.COUIChip.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUIChip.this.mTxColorAnimCurVal = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                COUIChip.this.mTextColors[!z10 ? 1 : 0] = COUIChip.this.mTxColorAnimCurVal;
                COUIChip.this.setTextColor(new ColorStateList(COUIChip.this.mTextColorStates, COUIChip.this.mTextColors));
            }
        });
        this.mTextColorAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.chip.COUIChip.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIChip.this.mTxColorAnimCurVal == COUIChip.this.mUncheckedTextColor || COUIChip.this.mTxColorAnimCurVal == COUIChip.this.mCheckedTextColor) {
                    COUIChip.this.resetTextColor();
                }
            }
        });
        this.mTextColorAnimator.start();
    }

    private boolean isLayoutRTL() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    private boolean isNeedChangeColor() {
        boolean z10;
        ViewParent parent = getParent();
        if (parent instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) parent;
            int i10 = this.mBgColorAnimCurVal;
            if ((i10 == this.mCheckedBackgroundColor && this.mTxColorAnimCurVal == this.mCheckedTextColor) || (i10 == this.mUncheckedBackgroundColor && this.mTxColorAnimCurVal == this.mUncheckedTextColor)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (chipGroup.isSelectionRequired() && chipGroup.getCheckedChipIds().size() == 1 && isChecked() && z10) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configStateAnimator$0(float f10) {
        this.mHoverMaskColor = this.mHoverAnimator.getCurrentMaskColor();
        resetBackgroundColor(isEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configStateAnimator$1(float f10) {
        this.mPressMaskColor = this.mPressAnimator.getCurrentMaskColor();
        resetBackgroundColor(isEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetBackgroundColor(boolean z10) {
        int i10;
        if (this.mBackgroundColorStates == null) {
            this.mBackgroundColorStates = new int[2];
        }
        if (this.mBackgroundColors == null) {
            this.mBackgroundColors = new int[this.mBackgroundColorStates.length];
        }
        int[][] iArr = this.mBackgroundColorStates;
        iArr[0] = CHIP_STATE_UNCHECKED;
        iArr[1] = CHIP_STATE_CHECKED;
        int[] iArr2 = this.mBackgroundColors;
        iArr2[0] = this.mUncheckedBackgroundColor;
        if (z10) {
            i10 = this.mCheckedBackgroundColor;
        } else {
            i10 = this.mCheckedBackgroundColor & ALPHA_VALUE_30;
        }
        iArr2[1] = i10;
        setChipBackgroundColor(new ColorStateList(this.mBackgroundColorStates, this.mBackgroundColors));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTextColor() {
        int i10;
        if (this.mTextColorStates == null) {
            this.mTextColorStates = new int[3];
        }
        if (this.mTextColors == null) {
            this.mTextColors = new int[this.mTextColorStates.length];
        }
        int[][] iArr = this.mTextColorStates;
        iArr[0] = CHIP_STATE_UNCHECKED;
        iArr[1] = CHIP_STATE_CHECKED;
        iArr[2] = CHIP_STATE_DISABLED;
        int[] iArr2 = this.mTextColors;
        iArr2[0] = this.mUncheckedTextColor;
        iArr2[1] = this.mCheckedTextColor;
        if (isChecked()) {
            i10 = this.mCheckDisabledTextColor;
        } else {
            i10 = this.mDisabledTextColor;
        }
        iArr2[2] = i10;
        setTextColor(new ColorStateList(this.mTextColorStates, this.mTextColors));
    }

    @Override // com.google.android.material.chip.Chip, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 9) {
                if (actionMasked == 10) {
                    this.mHoverAnimator.animateToProgress(0.0f, true);
                }
            } else {
                this.mHoverAnimator.animateToProgress(10000.0f, true);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public boolean isShowRedDot() {
        return this.isShowRedDot;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawStroke(canvas);
        if (this.isShowRedDot && !TextUtils.isEmpty(getText())) {
            drawRedDot(canvas);
        }
    }

    @Override // com.google.android.material.chip.Chip, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            this.mStrokeDrawable.setFocusEntered();
        } else {
            this.mStrokeDrawable.setFocusExited();
        }
        ViewParent parent = getParent();
        if ((parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren()) {
            COUILog.w(TAG, "COUIChip parent view should set clip children false to make drawing focused stroke effect works.");
        }
    }

    @Override // com.google.android.material.chip.Chip, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean isChecked = isChecked();
        if (isEnabled() && this.mAnimEnable) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    if (isCheckable() && isNeedChangeColor()) {
                        executeColorAnimation(motionEvent, isChecked);
                    }
                    executeScaleAnimator(false);
                    this.mPressAnimator.animateToProgress(0.0f, true);
                }
            } else {
                executeScaleAnimator(true);
                this.mPressAnimator.animateToProgress(10000.0f, true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, m.f6917w, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, m.f6917w, 0, this.mStyle);
        }
        if (typedArray != null) {
            int i10 = m.f6925y;
            Context context = getContext();
            int i11 = X8.c.f4348G;
            setCheckedBackgroundColor(typedArray.getColor(i10, COUIContextUtil.getAttrColor(context, i11)));
            setUncheckedBackgroundColor(typedArray.getColor(m.f6737E, COUIContextUtil.getAttrColor(getContext(), X8.c.f4346E)));
            setCheckedTextColor(typedArray.getColor(m.f6721A, COUIContextUtil.getAttrColor(getContext(), X8.c.f4416y)));
            setUncheckedTextColor(typedArray.getColor(m.f6741F, COUIContextUtil.getAttrColor(getContext(), i11)));
            setDisabledTextColor(typedArray.getColor(m.f6729C, COUIContextUtil.getAttrColor(getContext(), X8.c.f4398p)), typedArray.getColor(m.f6921x, COUIContextUtil.getColor(getContext(), a9.c.f6481e)));
            typedArray.recycle();
        }
        StateEffectAnimator stateEffectAnimator = this.mHoverAnimator;
        if (stateEffectAnimator != null) {
            stateEffectAnimator.setEndMaskColor(COUIContextUtil.getAttrColor(getContext(), X8.c.f4414x));
        }
        StateEffectAnimator stateEffectAnimator2 = this.mPressAnimator;
        if (stateEffectAnimator2 != null) {
            stateEffectAnimator2.setEndMaskColor(COUIContextUtil.getAttrColor(getContext(), X8.c.f4345D));
        }
    }

    @Override // com.google.android.material.chip.Chip, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        changeFontFamily(z10);
        super.setChecked(z10);
    }

    public void setCheckedBackgroundColor(int i10) {
        if (i10 != this.mCheckedBackgroundColor) {
            this.mCheckedBackgroundColor = i10;
            resetBackgroundColor(isEnabled());
        }
    }

    public void setCheckedTextColor(int i10) {
        if (i10 != this.mCheckedTextColor) {
            this.mCheckedTextColor = i10;
            resetTextColor();
        }
    }

    @Override // com.google.android.material.chip.Chip
    public void setChipBackgroundColor(ColorStateList colorStateList) {
        int[] iArr;
        if (this.mHoverAnimator != null && (iArr = this.mBackgroundColors) != null && this.mBackgroundColorStates != null) {
            int q10 = B.a.q(this.mPressMaskColor, B.a.q(this.mHoverMaskColor, iArr[0]));
            int q11 = B.a.q(this.mPressMaskColor, B.a.q(this.mHoverMaskColor, this.mBackgroundColors[1]));
            int[] iArr2 = this.mBackgroundColors;
            iArr2[0] = q10;
            iArr2[1] = q11;
            super.setChipBackgroundColor(new ColorStateList(this.mBackgroundColorStates, this.mBackgroundColors));
            return;
        }
        super.setChipBackgroundColor(colorStateList);
    }

    public void setDisabledTextColor(int i10, int i11) {
        if (i10 != this.mDisabledTextColor || i11 != this.mCheckDisabledTextColor) {
            this.mDisabledTextColor = i10;
            this.mCheckDisabledTextColor = i11;
            resetTextColor();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        resetBackgroundColor(z10);
        resetTextColor();
        super.setEnabled(z10);
    }

    public void setShowRedDot(boolean z10) {
        this.isShowRedDot = z10;
        invalidate();
    }

    public void setUncheckedBackgroundColor(int i10) {
        if (i10 != this.mUncheckedBackgroundColor) {
            this.mUncheckedBackgroundColor = i10;
            resetBackgroundColor(isEnabled());
        }
    }

    public void setUncheckedTextColor(int i10) {
        if (i10 != this.mUncheckedTextColor) {
            this.mUncheckedTextColor = i10;
            resetTextColor();
        }
    }

    public COUIChip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a9.b.f6463a);
    }

    public COUIChip(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, l.f6693A);
    }

    public COUIChip(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.mPressMaskColor = 0;
        this.mHoverMaskColor = 0;
        this.mLocation = new int[2];
        this.isShowRedDot = false;
        this.mRectF = new RectF();
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6917w, i10, i11);
        this.mAnimEnable = obtainStyledAttributes.getBoolean(m.f6725B, true);
        int i12 = m.f6925y;
        int i13 = X8.c.f4348G;
        this.mCheckedBackgroundColor = obtainStyledAttributes.getColor(i12, COUIContextUtil.getAttrColor(context, i13));
        this.mUncheckedBackgroundColor = obtainStyledAttributes.getColor(m.f6737E, COUIContextUtil.getAttrColor(context, X8.c.f4346E));
        this.mCheckedTextColor = obtainStyledAttributes.getColor(m.f6721A, COUIContextUtil.getAttrColor(getContext(), X8.c.f4416y));
        this.mUncheckedTextColor = obtainStyledAttributes.getColor(m.f6741F, COUIContextUtil.getAttrColor(context, i13));
        int i14 = m.f6729C;
        this.mDisabledTextColor = obtainStyledAttributes.getColor(i14, COUIContextUtil.getAttrColor(context, X8.c.f4398p));
        this.mCheckDisabledTextColor = obtainStyledAttributes.getColor(i14, COUIContextUtil.getColor(context, a9.c.f6481e));
        this.mOpenCheckedTextFontFamily = obtainStyledAttributes.getBoolean(m.f6733D, false);
        String string = obtainStyledAttributes.getString(m.f6929z);
        this.mFontAfterChecked = string;
        if (this.mOpenCheckedTextFontFamily && TextUtils.isEmpty(string)) {
            this.mFontAfterChecked = COUIChangeTextUtil.MEDIUM_FONT;
        }
        changeFontFamilyImpl(isChecked());
        if (isCheckable()) {
            resetBackgroundColor(isEnabled());
            resetTextColor();
        }
        if (this.mAnimEnable && isCheckable()) {
            this.mBgColorAnimCurVal = isChecked() ? this.mCheckedBackgroundColor : this.mUncheckedBackgroundColor;
            this.mTxColorAnimCurVal = isChecked() ? this.mCheckedTextColor : this.mUncheckedTextColor;
            this.mColorAnimationInterpolator = new COUIEaseInterpolator();
        }
        obtainStyledAttributes.recycle();
        this.mHintRedDotHelper = new COUIHintRedDotHelper(context, null, o.f5225V1, 0, n.f5047s);
        this.mRedDotOffsetHorizontal = context.getResources().getDimensionPixelOffset(d.f6586q);
        this.mRedDotOffsetVertical = context.getResources().getDimensionPixelOffset(d.f6588r);
        configStateAnimator();
    }
}
