package com.coui.appcompat.edittext;

import J.d;
import X8.c;
import X8.f;
import X8.m;
import X8.n;
import X8.o;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.K;
import androidx.customview.widget.a;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.edittext.COUICutoutDrawable;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.util.List;

/* loaded from: classes.dex */
public class COUIEditText extends AppCompatEditText {
    private static final int ALPHA_VALUE = 255;
    private static final int BACKGROUND_ANIMATION_DURATION = 250;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 200;
    private static final boolean LOG_DBG = false;
    public static final int MODE_BACKGROUND_LINE = 1;
    public static final int MODE_BACKGROUND_NONE = 0;
    public static final int MODE_BACKGROUND_NO_LINE = 3;
    public static final int MODE_BACKGROUND_RECT = 2;
    private static final double POINT_FIVE = 0.5d;
    private static final String TAG = "COUIEditText";
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
    private COUITextWatcher mCOUITextWatcher;
    private Runnable mCancelDeleteIcon;
    private int mClickSelectionPosition;
    private Context mContext;
    private View.OnTouchListener mCustomEditTextTouchListener;
    private ColorStateList mDefaultHintTextColor;
    private int mDefaultStrokeColor;
    private boolean mDeletable;
    private String mDeleteButton;
    private int mDeleteIconHeight;
    private int mDeleteIconWidth;
    private Drawable mDeleteNormal;
    private Drawable mDeletePressed;
    private int mDisabledColor;
    private Paint mDisabledPaint;
    private float mDrawXProgress;
    private int mDrawableSizeRight;
    private View.OnFocusChangeListener mEditFocusChangeListener;
    private Paint mEmptyTextPaint;
    private int mErrorColor;
    private boolean mErrorState;
    private COUIErrorEditTextHelper mErrorStateHelper;
    private int mFocusedAlpha;
    private Paint mFocusedPaint;
    private int mFocusedStrokeColor;
    private ColorStateList mFocusedTextColor;
    private boolean mForceFinishDetach;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private boolean mHintEnabled;
    private boolean mHintExpanded;
    private boolean mInDrawableStateChanged;
    private InputConnectionListener mInputConnectionListener;
    private String mInputText;
    private boolean mIsEllipsis;
    private boolean mIsEllipsisEnabled;
    private boolean mIsProvidingHint;
    private boolean mJustShowFocusLine;
    private int mLabelCutoutPadding;
    private boolean mLineExpanded;
    private int mLineModePaddingMiddle;
    private int mLineModePaddingTop;
    private int mLinePadding;
    private Paint mNormalPaint;
    private CharSequence mOriginalHint;
    private OnPasswordDeletedListener mPasswordDeleteListener;
    private Interpolator mPathInterpolator1;
    private Interpolator mPathInterpolator2;
    private boolean mQuickDelete;
    private int mRectModePaddingTop;
    private int mRefreshStyle;
    private Runnable mSetDeleteIcon;
    private boolean mShouldHandleDelete;
    private boolean mShowDeleteIcon;
    private int mStrokeWidth;
    private int mStrokeWidthFocused;
    private OnTextDeletedListener mTextDeleteListener;
    private TextPaint mTextPaint;
    private RectF mTmpRectF;
    private AccessibilityTouchHelper mTouchHelper;

    /* loaded from: classes.dex */
    public static class COUISavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<COUISavedState> CREATOR = new Parcelable.Creator<COUISavedState>() { // from class: com.coui.appcompat.edittext.COUIEditText.COUISavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public COUISavedState createFromParcel(Parcel parcel) {
                return new COUISavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public COUISavedState[] newArray(int i10) {
                return new COUISavedState[i10];
            }
        };
        String mText;

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.mText = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.mText);
        }

        public COUISavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private COUISavedState(Parcel parcel) {
            super(parcel);
            this.mText = parcel.readString();
        }
    }

    /* loaded from: classes.dex */
    public interface InputConnectionListener {
        void onCreateInputConnection();
    }

    /* loaded from: classes.dex */
    public interface OnErrorStateChangedListener {
        void onErrorStateChangeAnimationEnd(boolean z10);

        void onErrorStateChanged(boolean z10);
    }

    /* loaded from: classes.dex */
    public interface OnPasswordDeletedListener {
        boolean onPasswordDeleted();
    }

    /* loaded from: classes.dex */
    public interface OnTextDeletedListener {
        boolean onTextDeleted();
    }

    public COUIEditText(Context context) {
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
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUIEditText.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIEditText.this.mCOUICollapseTextHelper.setExpansionFraction(((Float) valueAnimator2.getAnimatedValue()).floatValue());
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
            this.mAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUIEditText.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIEditText.this.mFocusedAlpha = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                    COUIEditText.this.invalidate();
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
            this.mAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUIEditText.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIEditText.this.mDrawXProgress = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    COUIEditText.this.invalidate();
                }
            });
        }
        this.mFocusedAlpha = 255;
        this.mAnimator1.setFloatValues(0.0f, 1.0f);
        ValueAnimator valueAnimator2 = this.mAnimator2;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mAnimator2.cancel();
        }
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
            if (i10 != 2 && i10 != 3) {
                return getPaddingTop();
            }
            if (getBoxBackground() == null) {
                return 0;
            }
            return getBoxBackground().getBounds().top - getLabelMarginTop();
        }
        if (getBoxBackground() == null) {
            return 0;
        }
        return getBoxBackground().getBounds().top;
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
            if (i10 != 2 && i10 != 3) {
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

    private boolean getContentRect(Rect rect) {
        int width;
        if (isRtlMode()) {
            width = (getCompoundPaddingLeft() - this.mDeleteIconWidth) - getCompoundDrawablePadding();
        } else {
            width = (getWidth() - getCompoundPaddingRight()) + getCompoundDrawablePadding();
        }
        int i10 = this.mDeleteIconWidth + width;
        int height = ((((getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom()) - this.mDeleteIconWidth) / 2) + getCompoundPaddingTop();
        rect.set(width, height, i10, this.mDeleteIconWidth + height);
        return true;
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
            if (i11 != 2 && i11 != 3) {
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
        this.mHintEnabled = obtainStyledAttributes.getBoolean(o.f5327i1, false);
        setTopHint(obtainStyledAttributes.getText(o.f5208T0));
        if (this.mHintEnabled) {
            this.mHintAnimationEnabled = obtainStyledAttributes.getBoolean(o.f5319h1, true);
        }
        this.mRectModePaddingTop = obtainStyledAttributes.getDimensionPixelOffset(o.f5359m1, 0);
        float dimension = obtainStyledAttributes.getDimension(o.f5232W0, 0.0f);
        this.mBoxCornerRadiusTopStart = dimension;
        this.mBoxCornerRadiusTopEnd = dimension;
        this.mBoxCornerRadiusBottomEnd = dimension;
        this.mBoxCornerRadiusBottomStart = dimension;
        this.mFocusedStrokeColor = obtainStyledAttributes.getColor(o.f5335j1, COUIContextUtil.getAttrColor(context, c.f4347F, 0));
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5343k1, 0);
        this.mStrokeWidthFocused = obtainStyledAttributes.getDimensionPixelSize(o.f5311g1, this.mStrokeWidthFocused);
        this.mLinePadding = context.getResources().getDimensionPixelOffset(f.f4649a5);
        if (this.mHintEnabled) {
            this.mLabelCutoutPadding = context.getResources().getDimensionPixelOffset(f.f4641Z4);
            this.mLineModePaddingTop = context.getResources().getDimensionPixelOffset(f.f4665c5);
            this.mLineModePaddingMiddle = context.getResources().getDimensionPixelOffset(f.f4657b5);
        }
        int i11 = obtainStyledAttributes.getInt(o.f5240X0, 0);
        setBoxBackgroundMode(i11);
        if (this.mBoxBackgroundMode != 0) {
            setBackgroundDrawable(null);
        }
        int i12 = o.f5200S0;
        if (obtainStyledAttributes.hasValue(i12)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(i12);
            this.mDefaultHintTextColor = colorStateList;
            this.mFocusedTextColor = colorStateList;
        }
        this.mDefaultStrokeColor = obtainStyledAttributes.getColor(o.f5248Y0, 0);
        this.mDisabledColor = obtainStyledAttributes.getColor(o.f5255Z0, 0);
        String string = obtainStyledAttributes.getString(o.f5303f1);
        this.mInputText = string;
        setText(string);
        setCollapsedTextAppearance(obtainStyledAttributes.getDimensionPixelSize(o.f5224V0, 0), obtainStyledAttributes.getColorStateList(o.f5216U0));
        if (i11 == 2) {
            this.mCOUICollapseTextHelper.setTypefaces(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
        }
        obtainStyledAttributes.recycle();
        this.mEmptyTextPaint = new Paint();
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize(getTextSize());
        Paint paint = new Paint();
        this.mNormalPaint = paint;
        paint.setColor(this.mDefaultStrokeColor);
        Paint paint2 = new Paint();
        this.mDisabledPaint = paint2;
        paint2.setColor(this.mDisabledColor);
        Paint paint3 = new Paint();
        this.mFocusedPaint = paint3;
        paint3.setColor(this.mFocusedStrokeColor);
        setEditText();
    }

    private boolean isEmpty(String str) {
        if (str == null) {
            return false;
        }
        return TextUtils.isEmpty(str);
    }

    private boolean isGravityCenterHorizontal() {
        if ((getGravity() & 7) == 1) {
            return true;
        }
        return false;
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
        if (this.mBoxBackgroundMode == 2 && this.mFocusedStrokeColor == 0) {
            this.mFocusedStrokeColor = this.mFocusedTextColor.getColorForState(getDrawableState(), this.mFocusedTextColor.getDefaultColor());
        }
    }

    private void setEditText() {
        CharSequence charSequence;
        onApplyBoxBackgroundMode();
        this.mCOUICollapseTextHelper.setExpandedTextSize(getTextSize());
        int gravity = getGravity();
        this.mCOUICollapseTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
        this.mCOUICollapseTextHelper.setExpandedTextGravity(gravity);
        if (this.mDefaultHintTextColor == null) {
            this.mDefaultHintTextColor = getHintTextColors();
        }
        String str = "";
        if (!this.mHintEnabled) {
            charSequence = "";
        } else {
            charSequence = null;
        }
        setHint(charSequence);
        if (TextUtils.isEmpty(this.mHint)) {
            CharSequence hint = getHint();
            this.mOriginalHint = hint;
            setTopHint(hint);
            if (this.mHintEnabled) {
                str = null;
            }
            setHint(str);
        }
        this.mIsProvidingHint = true;
        updateLabelState(false, true);
        if (this.mHintEnabled) {
            updateModePadding();
        }
    }

    private void setEllipsize() {
        int i10;
        if (!isFocused()) {
            if (this.mTextPaint.measureText(String.valueOf(getText())) > getWidth() && !this.mIsEllipsis) {
                this.mInputText = String.valueOf(getText());
                this.mIsEllipsis = true;
                setText(TextUtils.ellipsize(getText(), this.mTextPaint, getWidth(), TextUtils.TruncateAt.END));
                if (this.mErrorState) {
                    setErrorState(true);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mIsEllipsis) {
            setText(this.mInputText);
            if (this.mClickSelectionPosition >= getSelectionEnd()) {
                i10 = getSelectionEnd();
            } else {
                i10 = this.mClickSelectionPosition;
            }
            setSelection(i10);
        }
        this.mIsEllipsis = false;
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mHint)) {
            this.mHint = charSequence;
            this.mCOUICollapseTextHelper.setText(charSequence);
            if (!this.mHintExpanded) {
                openCutout();
            }
            COUIErrorEditTextHelper cOUIErrorEditTextHelper = this.mErrorStateHelper;
            if (cOUIErrorEditTextHelper != null) {
                cOUIErrorEditTextHelper.setHintInternal(this.mCOUICollapseTextHelper);
            }
            setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDeletableStatus(boolean z10) {
        if (TextUtils.isEmpty(getText().toString())) {
            if (isGravityCenterHorizontal()) {
                setPaddingRelative(0, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
            }
            if (this.mDeletable) {
                setCompoundDrawables(null, null, null, null);
            } else {
                post(this.mCancelDeleteIcon);
            }
            this.mDeletable = false;
            return;
        }
        if (z10) {
            if (this.mDeleteNormal != null && !this.mDeletable) {
                if (isGravityCenterHorizontal()) {
                    setPaddingRelative(this.mDeleteIconWidth + getCompoundDrawablePadding(), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
                }
                if (isFastDeletable() && this.mShowDeleteIcon) {
                    post(this.mSetDeleteIcon);
                }
                this.mDeletable = true;
                return;
            }
            return;
        }
        if (this.mDeletable) {
            if (isGravityCenterHorizontal()) {
                setPaddingRelative(0, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
            }
            post(this.mCancelDeleteIcon);
            this.mDeletable = false;
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
        this.mDrawXProgress = 0.0f;
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

    public void addOnErrorStateChangedListener(OnErrorStateChangedListener onErrorStateChangedListener) {
        this.mErrorStateHelper.addOnErrorStateChangedListener(onErrorStateChangedListener);
    }

    public boolean cutoutIsOpen() {
        if (cutoutEnabled() && ((COUICutoutDrawable) this.mBoxBackground).hasCutout()) {
            return true;
        }
        return false;
    }

    public void destroyAnimators() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAnimator.removeAllListeners();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator = null;
        }
        ValueAnimator valueAnimator2 = this.mAnimator1;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.mAnimator1.removeAllListeners();
            this.mAnimator1.removeAllUpdateListeners();
            this.mAnimator1 = null;
        }
        ValueAnimator valueAnimator3 = this.mAnimator2;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.mAnimator2.removeAllListeners();
            this.mAnimator2.removeAllUpdateListeners();
            this.mAnimator2 = null;
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        AccessibilityTouchHelper accessibilityTouchHelper;
        if (isDeleteButtonExist() && (accessibilityTouchHelper = this.mTouchHelper) != null && accessibilityTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        if (this.mForceFinishDetach) {
            onStartTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (getMaxLines() < 2 && this.mIsEllipsisEnabled) {
            setEllipsize();
        }
        if (getHintTextColors() != this.mDefaultHintTextColor) {
            updateLabelState(false);
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (!this.mHintEnabled && getText().length() != 0) {
            canvas.drawText(" ", 0.0f, 0.0f, this.mEmptyTextPaint);
        } else {
            this.mCOUICollapseTextHelper.draw(canvas);
        }
        if (this.mBoxBackground != null && this.mBoxBackgroundMode == 2) {
            if (getScrollX() != 0) {
                updateTextInputBoxBounds();
            }
            if (!this.mErrorStateHelper.isErrorState()) {
                this.mBoxBackground.draw(canvas);
            } else {
                this.mErrorStateHelper.drawModeBackgroundRect(canvas, this.mBoxBackground, this.mBoxStrokeColor);
            }
        }
        if (this.mBoxBackgroundMode == 1) {
            int height = getHeight();
            this.mFocusedPaint.setAlpha(this.mFocusedAlpha);
            if (!isEnabled()) {
                if (!this.mJustShowFocusLine) {
                    canvas.drawRect(0.0f, height - this.mStrokeWidth, getWidth(), height, this.mDisabledPaint);
                }
            } else if (!this.mErrorStateHelper.isErrorState()) {
                if (!this.mJustShowFocusLine) {
                    canvas.drawRect(0.0f, height - this.mStrokeWidth, getWidth(), height, this.mNormalPaint);
                }
                if (hasFocus()) {
                    canvas.drawRect(0.0f, height - this.mStrokeWidthFocused, this.mDrawXProgress * getWidth(), height, this.mFocusedPaint);
                }
            } else {
                this.mErrorStateHelper.drawModeBackgroundLine(canvas, height, getWidth(), (int) (this.mDrawXProgress * getWidth()), this.mNormalPaint, this.mFocusedPaint);
            }
        }
        canvas.restoreToCount(save);
        super.draw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        if (this.mInDrawableStateChanged) {
            return;
        }
        boolean z10 = true;
        this.mInDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (this.mHintEnabled) {
            if (!K.O(this) || !isEnabled()) {
                z10 = false;
            }
            updateLabelState(z10);
        } else {
            updateLabelState(false);
        }
        updateLineModeBackground();
        if (this.mHintEnabled) {
            updateTextInputBoxBounds();
            updateTextInputBoxState();
            COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper = this.mCOUICollapseTextHelper;
            if (cOUICollapseTextHelper != null) {
                boolean state = cOUICollapseTextHelper.setState(drawableState);
                this.mErrorStateHelper.drawableStateChanged(drawableState);
                if (state) {
                    invalidate();
                }
            }
        }
        this.mInDrawableStateChanged = false;
    }

    public void forceFinishDetach() {
        this.mForceFinishDetach = true;
    }

    public Rect getBackgroundRect() {
        int i10 = this.mBoxBackgroundMode;
        if ((i10 == 1 || i10 == 2 || i10 == 3) && getBoxBackground() != null) {
            getBoxBackground().getBounds();
        }
        return null;
    }

    public int getBoxStrokeColor() {
        return this.mFocusedStrokeColor;
    }

    public String getCouiEditTexttNoEllipsisText() {
        if (this.mIsEllipsis) {
            return this.mInputText;
        }
        return String.valueOf(getText());
    }

    public int getDeleteButtonLeft() {
        int i10;
        Drawable drawable = this.mDeleteNormal;
        if (drawable != null) {
            i10 = drawable.getIntrinsicWidth();
        } else {
            i10 = 0;
        }
        return ((getRight() - getLeft()) - getPaddingRight()) - i10;
    }

    public int getDeleteIconWidth() {
        return this.mDeleteIconWidth;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        if (this.mHintEnabled) {
            return this.mHint;
        }
        return null;
    }

    public int getLabelMarginTop() {
        if (this.mHintEnabled) {
            return (int) (this.mCOUICollapseTextHelper.getCollapsedTextHeight() / 2.0f);
        }
        return 0;
    }

    public OnTextDeletedListener getTextDeleteListener() {
        return this.mTextDeleteListener;
    }

    public boolean isDeleteButtonExist() {
        if (this.mQuickDelete && !isEmpty(getText().toString()) && hasFocus()) {
            return true;
        }
        return false;
    }

    public boolean isEllipsisEnabled() {
        return this.mIsEllipsisEnabled;
    }

    public boolean isErrorState() {
        return this.mErrorStateHelper.isErrorState();
    }

    public boolean isFastDeletable() {
        return this.mQuickDelete;
    }

    public boolean isHintEnabled() {
        return this.mHintEnabled;
    }

    public boolean isProvidingHint() {
        return this.mIsProvidingHint;
    }

    public boolean isShowDeleteIcon() {
        return this.mShowDeleteIcon;
    }

    public boolean ismHintAnimationEnabled() {
        return this.mHintAnimationEnabled;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnectionListener inputConnectionListener = this.mInputConnectionListener;
        if (inputConnectionListener != null) {
            inputConnectionListener.onCreateInputConnection();
        }
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mInputConnectionListener != null) {
            this.mInputConnectionListener = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mErrorStateHelper.onDraw(canvas);
    }

    public void onFastDelete() {
        Editable text = getText();
        text.delete(0, text.length());
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.mQuickDelete) {
            updateDeletableStatus(z10);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.mEditFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(this, z10);
        }
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.mQuickDelete && i10 == 67) {
            super.onKeyDown(i10, keyEvent);
            OnPasswordDeletedListener onPasswordDeletedListener = this.mPasswordDeleteListener;
            if (onPasswordDeletedListener != null) {
                onPasswordDeletedListener.onPasswordDeleted();
                return true;
            }
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.mBoxBackground != null) {
            updateTextInputBoxBounds();
        }
        if (this.mHintEnabled) {
            updateModePadding();
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int width = getWidth() - getCompoundPaddingRight();
        int calculateCollapsedTextTopBounds = calculateCollapsedTextTopBounds();
        this.mCOUICollapseTextHelper.setExpandedBounds(compoundPaddingLeft, getCompoundPaddingTop(), width, getHeight() - getCompoundPaddingBottom());
        this.mCOUICollapseTextHelper.setCollapsedBounds(compoundPaddingLeft, calculateCollapsedTextTopBounds, width, getHeight() - getCompoundPaddingBottom());
        this.mCOUICollapseTextHelper.recalculate();
        if (cutoutEnabled() && !this.mHintExpanded) {
            openCutout();
        }
        this.mErrorStateHelper.onLayout(this.mCOUICollapseTextHelper);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        String str;
        if (getMaxLines() < 2 && this.mIsEllipsisEnabled && (parcelable instanceof COUISavedState) && (str = ((COUISavedState) parcelable).mText) != null) {
            setText(str);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (getMaxLines() < 2 && this.mIsEllipsisEnabled && !isFocused()) {
            COUISavedState cOUISavedState = new COUISavedState(onSaveInstanceState);
            cOUISavedState.mText = getCouiEditTexttNoEllipsisText();
            return cOUISavedState;
        }
        return onSaveInstanceState;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (this.mShowDeleteIcon && this.mQuickDelete && !TextUtils.isEmpty(getText()) && hasFocus()) {
            Rect rect = new Rect();
            if (getContentRect(rect) && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.mDeletable && z10) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2 && this.mShouldHandleDelete) {
                            return true;
                        }
                    } else if (this.mShouldHandleDelete) {
                        OnTextDeletedListener onTextDeletedListener = this.mTextDeleteListener;
                        if (onTextDeletedListener != null && onTextDeletedListener.onTextDeleted()) {
                            return true;
                        }
                        onFastDelete();
                        this.mShouldHandleDelete = false;
                        return true;
                    }
                } else {
                    this.mShouldHandleDelete = true;
                    return true;
                }
            }
        }
        View.OnTouchListener onTouchListener = this.mCustomEditTextTouchListener;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.mClickSelectionPosition = getSelectionEnd();
        return onTouchEvent;
    }

    public void refresh() {
        TypedArray obtainStyledAttributes;
        Drawable drawable;
        String resourceTypeName = getResources().getResourceTypeName(this.mRefreshStyle);
        if ("attr".equals(resourceTypeName)) {
            obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, o.f5192R0, this.mRefreshStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, o.f5192R0, 0, this.mRefreshStyle);
        } else {
            return;
        }
        int i10 = o.f5200S0;
        if (obtainStyledAttributes.hasValue(i10)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(i10);
            this.mDefaultHintTextColor = colorStateList;
            this.mFocusedTextColor = colorStateList;
            if (colorStateList == null) {
                this.mDefaultHintTextColor = getHintTextColors();
            }
        }
        this.mErrorColor = obtainStyledAttributes.getColor(o.f5279c1, COUIContextUtil.getAttrColor(getContext(), c.f4404s));
        this.mFocusedStrokeColor = obtainStyledAttributes.getColor(o.f5335j1, COUIContextUtil.getAttrColor(getContext(), c.f4347F, 0));
        this.mDefaultStrokeColor = obtainStyledAttributes.getColor(o.f5248Y0, 0);
        this.mDisabledColor = obtainStyledAttributes.getColor(o.f5255Z0, 0);
        this.mErrorStateHelper.setErrorColor(this.mErrorColor);
        this.mNormalPaint.setColor(this.mDefaultStrokeColor);
        this.mDisabledPaint.setColor(this.mDisabledColor);
        this.mFocusedPaint.setColor(this.mFocusedStrokeColor);
        this.mDeleteNormal = obtainStyledAttributes.getDrawable(o.f5263a1);
        this.mDeletePressed = obtainStyledAttributes.getDrawable(o.f5271b1);
        Drawable drawable2 = this.mDeleteNormal;
        if (drawable2 != null) {
            this.mDeleteIconWidth = drawable2.getIntrinsicWidth();
            int intrinsicHeight = this.mDeleteNormal.getIntrinsicHeight();
            this.mDeleteIconHeight = intrinsicHeight;
            this.mDeleteNormal.setBounds(0, 0, this.mDeleteIconWidth, intrinsicHeight);
        }
        Drawable drawable3 = this.mDeletePressed;
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.mDeleteIconWidth, this.mDeleteIconHeight);
        }
        if (this.mQuickDelete && this.mShowDeleteIcon && !TextUtils.isEmpty(getText()) && hasFocus() && this.mDeletable && (drawable = this.mDeleteNormal) != null) {
            setCompoundDrawables(null, null, drawable, null);
        }
        updateTextInputBoxState();
        obtainStyledAttributes.recycle();
        invalidate();
    }

    public void removeOnErrorStateChangedListener(OnErrorStateChangedListener onErrorStateChangedListener) {
        this.mErrorStateHelper.removeOnErrorStateChangedListener(onErrorStateChangedListener);
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
            this.mFocusedPaint.setColor(i10);
            updateTextInputBoxState();
        }
    }

    public void setCollapsedTextAppearance(int i10, ColorStateList colorStateList) {
        this.mCOUICollapseTextHelper.setCollapsedTextAppearance(i10, colorStateList);
        this.mFocusedTextColor = this.mCOUICollapseTextHelper.getCollapsedTextColor();
        updateLabelState(false);
        this.mErrorStateHelper.setCollapsedTextAppearance(i10, colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        if (drawable3 != null) {
            this.mDrawableSizeRight = drawable3.getBounds().width();
        } else {
            this.mDrawableSizeRight = 0;
        }
    }

    public void setCouiEditTexttNoEllipsisText(String str) {
        this.mInputText = str;
        setText(str);
    }

    public void setCustomEditTextOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mCustomEditTextTouchListener = onTouchListener;
    }

    public void setDefaultStrokeColor(int i10) {
        if (this.mDefaultStrokeColor != i10) {
            this.mDefaultStrokeColor = i10;
            this.mNormalPaint.setColor(i10);
            updateTextInputBoxState();
        }
    }

    public void setDisabledStrokeColor(int i10) {
        if (this.mDisabledColor != i10) {
            this.mDisabledColor = i10;
            this.mDisabledPaint.setColor(i10);
            updateTextInputBoxState();
        }
    }

    public void setEditFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mEditFocusChangeListener = onFocusChangeListener;
    }

    public void setEditTextColor(int i10) {
        setTextColor(i10);
        this.mErrorStateHelper.setOriginalTextColors(getTextColors());
    }

    public void setEditTextDeleteIconNormal(Drawable drawable) {
        if (drawable != null) {
            this.mDeleteNormal = drawable;
            this.mDeleteIconWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.mDeleteNormal.getIntrinsicHeight();
            this.mDeleteIconHeight = intrinsicHeight;
            this.mDeleteNormal.setBounds(0, 0, this.mDeleteIconWidth, intrinsicHeight);
            invalidate();
        }
    }

    public void setEditTextDeleteIconPressed(Drawable drawable) {
        if (drawable != null) {
            this.mDeletePressed = drawable;
            drawable.setBounds(0, 0, this.mDeleteIconWidth, this.mDeleteIconHeight);
            invalidate();
        }
    }

    public void setEditTextErrorColor(int i10) {
        if (i10 != this.mErrorColor) {
            this.mErrorColor = i10;
            this.mErrorStateHelper.setErrorColor(i10);
            invalidate();
        }
    }

    public void setErrorState(boolean z10) {
        this.mErrorState = z10;
        this.mErrorStateHelper.setErrorState(z10);
    }

    public void setFastDeletable(boolean z10) {
        if (this.mQuickDelete != z10) {
            this.mQuickDelete = z10;
            if (z10 && this.mCOUITextWatcher == null) {
                COUITextWatcher cOUITextWatcher = new COUITextWatcher();
                this.mCOUITextWatcher = cOUITextWatcher;
                addTextChangedListener(cOUITextWatcher);
            }
        }
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

    public void setInputConnectionListener(InputConnectionListener inputConnectionListener) {
        this.mInputConnectionListener = inputConnectionListener;
    }

    public void setIsEllipsisEnabled(boolean z10) {
        this.mIsEllipsisEnabled = z10;
    }

    public void setJustShowFocusLine(boolean z10) {
        this.mJustShowFocusLine = z10;
    }

    public void setOnTextDeletedListener(OnTextDeletedListener onTextDeletedListener) {
        this.mTextDeleteListener = onTextDeletedListener;
    }

    public void setShowDeleteIcon(boolean z10) {
        this.mShowDeleteIcon = z10;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        Selection.setSelection(getText(), length());
    }

    public void setTextDeletedListener(OnPasswordDeletedListener onPasswordDeletedListener) {
        this.mPasswordDeleteListener = onPasswordDeletedListener;
    }

    public void setTopHint(CharSequence charSequence) {
        setHintInternal(charSequence);
    }

    public void setmHintAnimationEnabled(boolean z10) {
        this.mHintAnimationEnabled = z10;
    }

    public void updateLabelState(boolean z10) {
        updateLabelState(z10, false);
    }

    public COUIEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    private void updateLabelState(boolean z10, boolean z11) {
        COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper;
        ColorStateList colorStateList;
        boolean isEnabled = isEnabled();
        boolean z12 = !TextUtils.isEmpty(getText());
        if (this.mDefaultHintTextColor != null) {
            this.mDefaultHintTextColor = getHintTextColors();
            COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper2 = this.mCOUICollapseTextHelper;
            if (cOUICollapseTextHelper2 != null) {
                cOUICollapseTextHelper2.setCollapsedTextColor(this.mFocusedTextColor);
                this.mCOUICollapseTextHelper.setExpandedTextColor(this.mDefaultHintTextColor);
            }
        }
        COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper3 = this.mCOUICollapseTextHelper;
        if (cOUICollapseTextHelper3 != null) {
            if (!isEnabled) {
                cOUICollapseTextHelper3.setCollapsedTextColor(ColorStateList.valueOf(this.mDisabledColor));
                this.mCOUICollapseTextHelper.setExpandedTextColor(ColorStateList.valueOf(this.mDisabledColor));
            } else if (hasFocus() && (colorStateList = this.mFocusedTextColor) != null) {
                this.mCOUICollapseTextHelper.setCollapsedTextColor(colorStateList);
            }
        }
        if (!z12 && (!isEnabled() || !hasFocus())) {
            if ((z11 || !this.mHintExpanded) && isHintEnabled()) {
                expandHint(z10);
            }
        } else if (z11 || this.mHintExpanded) {
            collapseHint(z10);
        }
        COUIErrorEditTextHelper cOUIErrorEditTextHelper = this.mErrorStateHelper;
        if (cOUIErrorEditTextHelper == null || (cOUICollapseTextHelper = this.mCOUICollapseTextHelper) == null) {
            return;
        }
        cOUIErrorEditTextHelper.updateLabelState(cOUICollapseTextHelper);
    }

    public COUIEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        COUICutoutDrawable.COUICollapseTextHelper cOUICollapseTextHelper = new COUICutoutDrawable.COUICollapseTextHelper(this);
        this.mCOUICollapseTextHelper = cOUICollapseTextHelper;
        this.mShouldHandleDelete = false;
        this.mQuickDelete = false;
        this.mDeletable = false;
        this.mTextDeleteListener = null;
        this.mPasswordDeleteListener = null;
        this.mForceFinishDetach = false;
        this.mDeleteButton = null;
        this.mCOUITextWatcher = null;
        this.mStrokeWidth = 1;
        this.mStrokeWidthFocused = 3;
        this.mTmpRectF = new RectF();
        this.mIsEllipsis = false;
        this.mIsEllipsisEnabled = false;
        this.mInputText = "";
        this.mClickSelectionPosition = 0;
        this.mShowDeleteIcon = true;
        this.mJustShowFocusLine = false;
        this.mCancelDeleteIcon = new Runnable() { // from class: com.coui.appcompat.edittext.COUIEditText.1
            @Override // java.lang.Runnable
            public void run() {
                COUIEditText.this.setCompoundDrawables(null, null, null, null);
            }
        };
        this.mSetDeleteIcon = new Runnable() { // from class: com.coui.appcompat.edittext.COUIEditText.2
            @Override // java.lang.Runnable
            public void run() {
                COUIEditText cOUIEditText = COUIEditText.this;
                cOUIEditText.setCompoundDrawables(null, null, cOUIEditText.mDeleteNormal, null);
            }
        };
        if (attributeSet != null) {
            this.mRefreshStyle = attributeSet.getStyleAttribute();
        }
        if (this.mRefreshStyle == 0) {
            this.mRefreshStyle = i10;
        }
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5192R0, i10, 0);
        boolean z10 = obtainStyledAttributes.getBoolean(o.f5351l1, false);
        this.mErrorColor = obtainStyledAttributes.getColor(o.f5279c1, COUIContextUtil.getAttrColor(context, c.f4404s));
        this.mDeleteNormal = obtainStyledAttributes.getDrawable(o.f5263a1);
        this.mDeletePressed = obtainStyledAttributes.getDrawable(o.f5271b1);
        this.mIsEllipsisEnabled = obtainStyledAttributes.getBoolean(o.f5295e1, true);
        int i11 = obtainStyledAttributes.getInt(o.f5287d1, 1);
        cOUICollapseTextHelper.setHintLines(i11);
        obtainStyledAttributes.recycle();
        setFastDeletable(z10);
        Drawable drawable = this.mDeleteNormal;
        if (drawable != null) {
            this.mDeleteIconWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.mDeleteNormal.getIntrinsicHeight();
            this.mDeleteIconHeight = intrinsicHeight;
            this.mDeleteNormal.setBounds(0, 0, this.mDeleteIconWidth, intrinsicHeight);
        }
        Drawable drawable2 = this.mDeletePressed;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.mDeleteIconWidth, this.mDeleteIconHeight);
        }
        cOUICollapseTextHelper.setHintPaddingStart(context.getResources().getDimensionPixelSize(f.f4803u1));
        AccessibilityTouchHelper accessibilityTouchHelper = new AccessibilityTouchHelper(this);
        this.mTouchHelper = accessibilityTouchHelper;
        K.j0(this, accessibilityTouchHelper);
        K.t0(this, 1);
        this.mDeleteButton = this.mContext.getString(m.f5015n);
        this.mTouchHelper.invalidateRoot();
        this.mErrorStateHelper = new COUIErrorEditTextHelper(this, i11);
        initHintMode(context, attributeSet, i10);
        this.mErrorStateHelper.init(this.mErrorColor, this.mStrokeWidthFocused, this.mBoxBackgroundMode, getCornerRadiiAsArray(), cOUICollapseTextHelper);
    }

    /* loaded from: classes.dex */
    public class AccessibilityTouchHelper extends a implements View.OnClickListener {
        private View mHostView;
        private Rect mUninstallRect;
        private Rect mViewRect;

        public AccessibilityTouchHelper(View view) {
            super(view);
            this.mUninstallRect = null;
            this.mViewRect = null;
            this.mHostView = view;
        }

        private Rect getItemBounds(int i10) {
            if (i10 == 0) {
                if (this.mUninstallRect == null) {
                    initUninstallRect();
                }
                return this.mUninstallRect;
            }
            return new Rect();
        }

        private void initUninstallRect() {
            Rect rect = new Rect();
            this.mUninstallRect = rect;
            rect.left = COUIEditText.this.getDeleteButtonLeft();
            this.mUninstallRect.right = COUIEditText.this.getWidth();
            Rect rect2 = this.mUninstallRect;
            rect2.top = 0;
            rect2.bottom = COUIEditText.this.getHeight();
        }

        private void initViewRect() {
            Rect rect = new Rect();
            this.mViewRect = rect;
            rect.left = 0;
            rect.right = COUIEditText.this.getWidth();
            Rect rect2 = this.mViewRect;
            rect2.top = 0;
            rect2.bottom = COUIEditText.this.getHeight();
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            if (this.mUninstallRect == null) {
                initUninstallRect();
            }
            Rect rect = this.mUninstallRect;
            if (f10 >= rect.left && f10 <= rect.right && f11 >= rect.top && f11 <= rect.bottom && COUIEditText.this.isDeleteButtonExist()) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            if (COUIEditText.this.isDeleteButtonExist()) {
                list.add(0);
            }
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            if (i11 == 16) {
                if (i10 == 0 && COUIEditText.this.isDeleteButtonExist()) {
                    COUIEditText.this.onFastDelete();
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // androidx.customview.widget.a
        public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(COUIEditText.this.mDeleteButton);
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            if (i10 == 0) {
                dVar.l0(COUIEditText.this.mDeleteButton);
                dVar.h0(Button.class.getName());
                dVar.a(16);
            }
            dVar.c0(getItemBounds(i10));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes.dex */
    public class COUITextWatcher implements TextWatcher {
        private COUITextWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            COUIEditText cOUIEditText = COUIEditText.this;
            cOUIEditText.updateDeletableStatus(cOUIEditText.hasFocus());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
