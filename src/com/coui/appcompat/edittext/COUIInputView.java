package com.coui.appcompat.edittext;

import X8.c;
import X8.f;
import X8.h;
import X8.j;
import X8.m;
import X8.o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.math.RegexUtils;
import com.coui.appcompat.uiutil.UIUtil;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUIInputView extends ConstraintLayout {
    private static final int APPEAR_DURATION = 217;
    private static final int BUTTON_LAYOUT_MORE_PADDING = 3;
    private static final int COUNT_TEXTVIEW_MORE_PADDING = 10;
    private static final int COUNT_VIEW_PADDING = 8;
    private static final int DISAPPEAR_DURATION = 283;
    public static final int INPUT_TYPE_NUMBER = 1;
    public static final int INPUT_TYPE_NUMBER_PASSWORD = 2;
    public static final int INPUT_TYPE_TEXT = 0;
    private static final int MAX_BUTTON_ICON_COUNT = 2;
    private static final int MAX_LINE = 5;
    private static final int PASSWORD_STATUES_TYPE_CLOSE = 1;
    private static final int PASSWORD_STATUES_TYPE_OPEN = 0;
    private static final int SPACE_STEP = 4;
    protected View mButtonLayout;
    private ErrorStateChangeCallback mCallback;
    private Paint mCountPaint;
    protected TextView mCountTextView;
    private boolean mCustomFormat;
    private ImageButton mDeleteButton;
    private int mDeleteIconMarginEndWithPsd;
    private boolean mEditLineColor;
    protected COUIEditText mEditText;
    private LinearLayout mEdittextContainer;
    private boolean mEnableError;
    protected boolean mEnableInputCount;
    private boolean mEnablePassword;
    private TextView mErrorText;
    private ValueAnimator mHideErrorTextAnimator;
    private CharSequence mHint;
    protected int mInputType;
    protected int mMaxCount;
    protected OnEditTextChangeListener mOnEditTextChangeListener;
    private View.OnFocusChangeListener mOnFocusChangeListener;
    CheckBox mPasswordButton;
    private int mPasswordType;
    private PathInterpolator mPathInterpolator;
    private ValueAnimator mShowErrorTextAnimator;
    private String mSpaceString;
    private String mStringHidePassword;
    private String mStringShowPassword;
    private int mTextMinHeightInInputView;
    private TextWatcher mTextWatcher;
    protected CharSequence mTitle;
    protected TextView mTitleTextView;
    private Runnable mUpdateRunnable;
    private String replaceString;

    /* loaded from: classes.dex */
    public interface ErrorStateChangeCallback {
        void callback(boolean z10);
    }

    /* loaded from: classes.dex */
    public interface OnEditTextChangeListener {
        void afterTextChange(Editable editable);
    }

    public COUIInputView(Context context) {
        this(context, null);
    }

    private int getCountTextWidth() {
        if (this.mEnableInputCount) {
            if (this.mCountPaint == null) {
                Paint paint = new Paint();
                this.mCountPaint = paint;
                paint.setTextSize(this.mCountTextView.getTextSize());
            }
            return ((int) this.mCountPaint.measureText((String) this.mCountTextView.getText())) + 8;
        }
        return 0;
    }

    private int getCustomButtonShowNum() {
        TextView textView;
        View view = this.mButtonLayout;
        if (!(view instanceof ViewGroup)) {
            return 0;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i10 = 0;
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt.getVisibility() == 0 && (textView = this.mCountTextView) != null && textView.getId() != childAt.getId()) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCustomStyleText(CharSequence charSequence) {
        if (Locale.getDefault().getLanguage().equals("zh")) {
            String str = this.mSpaceString;
            if (str == null || !str.equals(charSequence.toString())) {
                this.mSpaceString = charSequence.toString();
                boolean isCnMobileExact = RegexUtils.isCnMobileExact(charSequence);
                boolean isCnBankCardId = RegexUtils.isCnBankCardId(charSequence);
                if (!isCnMobileExact && !isCnBankCardId) {
                    resetCustomStyleText(charSequence);
                    return;
                }
                this.replaceString = charSequence.toString();
                SpannableString spannableString = new SpannableString(charSequence);
                int length = spannableString.length() / 4;
                for (int i10 = 0; i10 < length; i10++) {
                    if (isCnMobileExact) {
                        int i11 = (i10 + 1) * 4;
                        spannableString.setSpan(new CustomEditTextSpan(), i11 - 2, i11 - 1, 17);
                    } else {
                        int i12 = (i10 + 1) * 4;
                        spannableString.setSpan(new CustomEditTextSpan(), i12 - 1, i12, 17);
                    }
                }
                int selectionStart = this.mEditText.getSelectionStart();
                this.mEditText.setText(spannableString);
                COUIEditText cOUIEditText = this.mEditText;
                cOUIEditText.setSelection(Math.min(selectionStart, cOUIEditText.getText().length()));
            }
        }
    }

    private void handleWithError() {
        if (this.mEnableError) {
            if (!TextUtils.isEmpty(this.mErrorText.getText())) {
                this.mErrorText.setVisibility(0);
            }
            this.mEditText.addOnErrorStateChangedListener(new COUIEditText.OnErrorStateChangedListener() { // from class: com.coui.appcompat.edittext.COUIInputView.3
                @Override // com.coui.appcompat.edittext.COUIEditText.OnErrorStateChangedListener
                public void onErrorStateChanged(boolean z10) {
                    COUIInputView.this.mEditText.setSelectAllOnFocus(z10);
                    if (z10) {
                        COUIInputView.this.showErrorMsgAnim();
                    } else {
                        COUIInputView.this.hideErrorMsgAnim();
                    }
                    if (COUIInputView.this.mCallback != null) {
                        COUIInputView.this.mCallback.callback(z10);
                    }
                }

                @Override // com.coui.appcompat.edittext.COUIEditText.OnErrorStateChangedListener
                public void onErrorStateChangeAnimationEnd(boolean z10) {
                }
            });
            return;
        }
        this.mErrorText.setVisibility(8);
    }

    private void handleWithTitle() {
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleTextView.setText(this.mTitle);
            this.mTitleTextView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideErrorMsgAnim() {
        ValueAnimator valueAnimator = this.mShowErrorTextAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mShowErrorTextAnimator.cancel();
        }
        if (this.mHideErrorTextAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.mHideErrorTextAnimator = ofFloat;
            ofFloat.setDuration(283L).setInterpolator(this.mPathInterpolator);
            this.mHideErrorTextAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUIInputView.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIInputView.this.mErrorText.setAlpha(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
            this.mHideErrorTextAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.edittext.COUIInputView.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    COUIInputView.this.mErrorText.setVisibility(8);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    COUIInputView.this.mErrorText.setVisibility(8);
                }
            });
        }
        if (this.mHideErrorTextAnimator.isStarted()) {
            this.mHideErrorTextAnimator.cancel();
        }
        this.mHideErrorTextAnimator.start();
    }

    private void init() {
        handleWithTitle();
        this.mEditText.setTopHint(this.mHint);
        if (this.mEditLineColor) {
            this.mEditText.setDefaultStrokeColor(COUIContextUtil.getAttrColor(getContext(), c.f4347F));
        }
        handleWithCount();
        handleWithPassword();
        handleWithError();
        initDeleteButton();
        updatePadding(false);
    }

    private void initDeleteButton() {
        if (this.mDeleteButton != null && !this.mEditText.isShowDeleteIcon()) {
            this.mDeleteButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.edittext.COUIInputView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUIInputView.this.mEditText.getTextDeleteListener() == null || !COUIInputView.this.mEditText.getTextDeleteListener().onTextDeleted()) {
                        COUIInputView.this.mEditText.onFastDelete();
                    }
                }
            });
        }
    }

    private boolean isEnablePassword() {
        if (this.mPasswordButton.getVisibility() == 0) {
            return this.mEnablePassword;
        }
        if (this.mEnablePassword && getCustomButtonShowNum() < 2) {
            return true;
        }
        return false;
    }

    private boolean isShowDeleteButton() {
        if (this.mDeleteButton.getVisibility() == 0) {
            return this.mEditText.isFastDeletable();
        }
        if (this.mEditText.isFastDeletable() && getCustomButtonShowNum() < 2) {
            return true;
        }
        return false;
    }

    private void resetCustomStyleText(CharSequence charSequence) {
        if (this.replaceString != null) {
            String valueOf = String.valueOf(charSequence);
            int selectionStart = this.mEditText.getSelectionStart();
            this.mEditText.setText(valueOf);
            COUIEditText cOUIEditText = this.mEditText;
            cOUIEditText.setSelection(Math.min(selectionStart, cOUIEditText.getText().length()));
            this.replaceString = null;
        }
    }

    private void setInputType() {
        int i10 = this.mInputType;
        if (i10 == -1) {
            return;
        }
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    this.mEditText.setInputType(0);
                    return;
                } else {
                    this.mEditText.setInputType(18);
                    return;
                }
            }
            this.mEditText.setInputType(2);
            return;
        }
        this.mEditText.setInputType(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorMsgAnim() {
        ValueAnimator valueAnimator = this.mHideErrorTextAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mHideErrorTextAnimator.cancel();
        }
        this.mErrorText.setVisibility(0);
        if (this.mShowErrorTextAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mShowErrorTextAnimator = ofFloat;
            ofFloat.setDuration(217L).setInterpolator(this.mPathInterpolator);
            this.mShowErrorTextAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUIInputView.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIInputView.this.mErrorText.setAlpha(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }
        if (this.mShowErrorTextAnimator.isStarted()) {
            this.mShowErrorTextAnimator.cancel();
        }
        this.mShowErrorTextAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckBoxContextDescription() {
        String str;
        CheckBox checkBox = this.mPasswordButton;
        if (checkBox.isChecked()) {
            str = this.mStringHidePassword;
        } else {
            str = this.mStringShowPassword;
        }
        checkBox.setContentDescription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDeleteButton(boolean z10) {
        if (this.mDeleteButton != null) {
            if (isShowDeleteButton() && z10 && !TextUtils.isEmpty(this.mEditText.getText().toString())) {
                if (!UIUtil.isInVisibleRect(this.mDeleteButton)) {
                    this.mDeleteButton.setVisibility(4);
                    post(new Runnable() { // from class: com.coui.appcompat.edittext.COUIInputView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            COUIInputView.this.mDeleteButton.setVisibility(0);
                        }
                    });
                    return;
                }
                return;
            }
            this.mDeleteButton.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePadding(boolean z10) {
        if (z10) {
            this.mEditText.removeCallbacks(this.mUpdateRunnable);
            this.mEditText.post(this.mUpdateRunnable);
        } else {
            this.mUpdateRunnable.run();
        }
    }

    public void addCustomButton(View view) {
        View view2 = this.mButtonLayout;
        if (view2 != null && view != null && (view2 instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view2;
            if (getCustomButtonShowNum() < 2) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(f.f4686f2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.setMarginStart(this.mDeleteIconMarginEndWithPsd);
                layoutParams.setMarginEnd(0);
                viewGroup.addView(view, layoutParams);
                updatePadding(true);
            }
        }
    }

    public TextView getCountTextView() {
        return this.mCountTextView;
    }

    public COUIEditText getEditText() {
        return this.mEditText;
    }

    public int getEdittextPaddingBottom() {
        int dimension = (int) getResources().getDimension(f.f4631Y1);
        if (!TextUtils.isEmpty(this.mTitle)) {
            return getResources().getDimensionPixelSize(f.f4617W1);
        }
        return dimension;
    }

    public int getEdittextPaddingEnd() {
        return this.mButtonLayout.getWidth();
    }

    public int getEdittextPaddingTop() {
        int dimension = (int) getResources().getDimension(f.f4646a2);
        if (!TextUtils.isEmpty(this.mTitle)) {
            return getResources().getDimensionPixelSize(f.f4624X1);
        }
        return dimension;
    }

    public CharSequence getHint() {
        return this.mHint;
    }

    public int getLayoutResId() {
        return j.f4975f;
    }

    public int getMaxCount() {
        return this.mMaxCount;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public int getTitlePaddingTop() {
        return getResources().getDimensionPixelSize(f.f4678e2);
    }

    public void handleWithCount() {
        handleWithCountTextView();
        if (this.mTextWatcher == null) {
            TextWatcher textWatcher = new TextWatcher() { // from class: com.coui.appcompat.edittext.COUIInputView.4
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    COUIInputView cOUIInputView = COUIInputView.this;
                    if (cOUIInputView.mEnableInputCount && cOUIInputView.mMaxCount > 0) {
                        OnEditTextChangeListener onEditTextChangeListener = cOUIInputView.mOnEditTextChangeListener;
                        if (onEditTextChangeListener != null) {
                            onEditTextChangeListener.afterTextChange(editable);
                        } else {
                            int length = editable.length();
                            COUIInputView cOUIInputView2 = COUIInputView.this;
                            if (length < cOUIInputView2.mMaxCount) {
                                cOUIInputView2.mCountTextView.setText(length + "/" + COUIInputView.this.mMaxCount);
                                COUIInputView cOUIInputView3 = COUIInputView.this;
                                cOUIInputView3.mCountTextView.setTextColor(COUIContextUtil.getAttrColor(cOUIInputView3.getContext(), c.f4412w));
                            } else {
                                cOUIInputView2.mCountTextView.setText(COUIInputView.this.mMaxCount + "/" + COUIInputView.this.mMaxCount);
                                COUIInputView cOUIInputView4 = COUIInputView.this;
                                cOUIInputView4.mCountTextView.setTextColor(COUIContextUtil.getAttrColor(cOUIInputView4.getContext(), c.f4402r));
                                COUIInputView cOUIInputView5 = COUIInputView.this;
                                int i10 = cOUIInputView5.mMaxCount;
                                if (length > i10) {
                                    cOUIInputView5.mEditText.setText(editable.subSequence(0, i10));
                                }
                            }
                        }
                    }
                    COUIInputView cOUIInputView6 = COUIInputView.this;
                    cOUIInputView6.updateDeleteButton(cOUIInputView6.hasFocus());
                    COUIInputView.this.updatePadding(true);
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                    if (COUIInputView.this.isIsCardSingleInput() && COUIInputView.this.mCustomFormat) {
                        COUIInputView.this.handleCustomStyleText(charSequence);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                }
            };
            this.mTextWatcher = textWatcher;
            this.mEditText.addTextChangedListener(textWatcher);
        }
        if (this.mOnFocusChangeListener == null) {
            View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.coui.appcompat.edittext.COUIInputView.5
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z10) {
                    COUIInputView.this.updateDeleteButton(z10);
                    COUIInputView.this.updatePadding(true);
                }
            };
            this.mOnFocusChangeListener = onFocusChangeListener;
            this.mEditText.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void handleWithCountTextView() {
        if (this.mEnableInputCount && this.mMaxCount > 0) {
            this.mCountTextView.setVisibility(0);
            this.mCountTextView.setText(this.mEditText.getText().length() + "/" + this.mMaxCount);
            return;
        }
        this.mCountTextView.setVisibility(8);
    }

    public void handleWithPassword() {
        if (isEnablePassword()) {
            this.mPasswordButton.setVisibility(0);
            if (this.mPasswordType == 1) {
                this.mPasswordButton.setChecked(false);
                int i10 = this.mInputType;
                if (i10 != 1 && i10 != 2) {
                    this.mEditText.setInputType(129);
                } else {
                    this.mEditText.setInputType(18);
                }
            } else {
                this.mPasswordButton.setChecked(true);
                int i11 = this.mInputType;
                if (i11 != 1 && i11 != 2) {
                    this.mEditText.setInputType(145);
                } else {
                    this.mEditText.setInputType(2);
                }
            }
            updateCheckBoxContextDescription();
            this.mPasswordButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.coui.appcompat.edittext.COUIInputView.7
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    if (z10) {
                        COUIInputView cOUIInputView = COUIInputView.this;
                        int i12 = cOUIInputView.mInputType;
                        if (i12 != 1 && i12 != 2) {
                            cOUIInputView.mEditText.setInputType(145);
                        } else {
                            cOUIInputView.mEditText.setInputType(2);
                        }
                    } else {
                        COUIInputView cOUIInputView2 = COUIInputView.this;
                        int i13 = cOUIInputView2.mInputType;
                        if (i13 != 1 && i13 != 2) {
                            cOUIInputView2.mEditText.setInputType(129);
                        } else {
                            cOUIInputView2.mEditText.setInputType(18);
                        }
                    }
                    COUIInputView.this.updateCheckBoxContextDescription();
                }
            });
            return;
        }
        this.mPasswordButton.setVisibility(8);
        setInputType();
    }

    public COUIEditText instanceCOUIEditText(Context context, AttributeSet attributeSet) {
        COUIEditText cOUIEditText = new COUIEditText(context, attributeSet, c.f4359R);
        cOUIEditText.setShowDeleteIcon(false);
        cOUIEditText.setVerticalScrollBarEnabled(false);
        cOUIEditText.setMinHeight(this.mTextMinHeightInInputView);
        return cOUIEditText;
    }

    public boolean isEnableInputCount() {
        return this.mEnableInputCount;
    }

    public boolean isIsCardSingleInput() {
        return false;
    }

    public void lazyInit(Context context, AttributeSet attributeSet) {
        COUIEditText instanceCOUIEditText = instanceCOUIEditText(context, attributeSet);
        this.mEditText = instanceCOUIEditText;
        instanceCOUIEditText.setMaxLines(5);
        this.mEdittextContainer.addView(this.mEditText, -1, -2);
        init();
    }

    public void nowInit(Context context, AttributeSet attributeSet) {
        lazyInit(context, attributeSet);
    }

    public void removeCustomButton(View view) {
        View view2 = this.mButtonLayout;
        if (view2 != null && view != null && (view2 instanceof ViewGroup)) {
            ((ViewGroup) view2).removeView(view);
            updatePadding(true);
        }
    }

    public void setCustomFormat(Boolean bool) {
        this.mCustomFormat = bool.booleanValue();
        if (this.mEditText.getText() == null) {
            return;
        }
        if (isIsCardSingleInput() && this.mCustomFormat) {
            handleCustomStyleText(this.mEditText.getText());
        } else {
            resetCustomStyleText(this.mEditText.getText());
        }
    }

    public void setEnableError(boolean z10) {
        if (this.mEnableError != z10) {
            this.mEnableError = z10;
            handleWithError();
            updatePadding(false);
        }
    }

    public void setEnableInputCount(boolean z10) {
        this.mEnableInputCount = z10;
        handleWithCount();
        updatePadding(true);
    }

    public void setEnablePassword(boolean z10) {
        if (this.mEnablePassword != z10) {
            this.mEnablePassword = z10;
            handleWithPassword();
            updatePadding(true);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.mEditText.setEnabled(z10);
        this.mTitleTextView.setEnabled(z10);
        this.mButtonLayout.setEnabled(z10);
        this.mPasswordButton.setEnabled(z10);
        this.mCountTextView.setEnabled(z10);
    }

    public void setErrorStateChangeCallBack(ErrorStateChangeCallback errorStateChangeCallback) {
        this.mCallback = errorStateChangeCallback;
    }

    public void setHint(CharSequence charSequence) {
        this.mHint = charSequence;
        this.mEditText.setTopHint(charSequence);
    }

    public void setMaxCount(int i10) {
        this.mMaxCount = i10;
        handleWithCount();
    }

    public void setOnEditTextChangeListener(OnEditTextChangeListener onEditTextChangeListener) {
        this.mOnEditTextChangeListener = onEditTextChangeListener;
    }

    public void setPasswordType(int i10) {
        if (this.mPasswordType != i10) {
            this.mPasswordType = i10;
            handleWithPassword();
            updatePadding(true);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null && !charSequence.equals(this.mTitle)) {
            this.mTitle = charSequence;
            handleWithTitle();
            updatePadding(false);
        }
    }

    public void showError(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mEditText.setErrorState(false);
        } else {
            this.mEditText.setErrorState(true);
            if (this.mEnableError) {
                this.mErrorText.setVisibility(0);
            }
        }
        this.mErrorText.setText(charSequence);
    }

    public COUIInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mOnEditTextChangeListener = null;
        this.mPathInterpolator = new COUIEaseInterpolator();
        this.mCountPaint = null;
        this.mEditLineColor = false;
        this.mCustomFormat = true;
        this.mUpdateRunnable = new Runnable() { // from class: com.coui.appcompat.edittext.COUIInputView.1
            @Override // java.lang.Runnable
            public void run() {
                COUIInputView cOUIInputView = COUIInputView.this;
                cOUIInputView.mEditText.setPaddingRelative(0, cOUIInputView.getEdittextPaddingTop(), COUIInputView.this.getEdittextPaddingEnd(), COUIInputView.this.getEdittextPaddingBottom());
                TextView textView = COUIInputView.this.mTitleTextView;
                textView.setPaddingRelative(textView.getPaddingStart(), COUIInputView.this.getTitlePaddingTop(), COUIInputView.this.mTitleTextView.getPaddingEnd(), COUIInputView.this.mTitleTextView.getPaddingBottom());
                UIUtil.setMargin(COUIInputView.this.mButtonLayout, 1, (COUIInputView.this.getEdittextPaddingTop() - COUIInputView.this.getEdittextPaddingBottom()) / 2);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5368n2, i10, 0);
        this.mTitle = obtainStyledAttributes.getText(o.f5448x2);
        this.mHint = obtainStyledAttributes.getText(o.f5408s2);
        this.mEnablePassword = obtainStyledAttributes.getBoolean(o.f5400r2, false);
        this.mPasswordType = obtainStyledAttributes.getInt(o.f5440w2, 0);
        this.mEnableError = obtainStyledAttributes.getBoolean(o.f5384p2, false);
        this.mMaxCount = obtainStyledAttributes.getInt(o.f5424u2, 0);
        this.mEnableInputCount = obtainStyledAttributes.getBoolean(o.f5392q2, false);
        this.mInputType = obtainStyledAttributes.getInt(o.f5432v2, -1);
        this.mCustomFormat = obtainStyledAttributes.getBoolean(o.f5416t2, true);
        this.mEditLineColor = obtainStyledAttributes.getBoolean(o.f5376o2, false);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(getLayoutResId(), (ViewGroup) this, true);
        this.mTitleTextView = (TextView) findViewById(h.f4881D0);
        this.mCountTextView = (TextView) findViewById(h.f4901R);
        this.mErrorText = (TextView) findViewById(h.f4877B0);
        this.mButtonLayout = findViewById(h.f4934m);
        this.mEdittextContainer = (LinearLayout) findViewById(h.f4898O);
        this.mDeleteButton = (ImageButton) findViewById(h.f4896M);
        this.mPasswordButton = (CheckBox) findViewById(h.f4942q);
        this.mDeleteIconMarginEndWithPsd = getResources().getDimensionPixelSize(f.f4694g2);
        this.mTextMinHeightInInputView = getResources().getDimensionPixelOffset(f.f4610V1);
        nowInit(context, attributeSet);
        this.mStringShowPassword = getContext().getString(m.f5005d);
        this.mStringHidePassword = getContext().getString(m.f5004c);
        updateCheckBoxContextDescription();
    }
}
