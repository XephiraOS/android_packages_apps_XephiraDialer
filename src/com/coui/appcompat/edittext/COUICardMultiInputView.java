package com.coui.appcompat.edittext;

import X8.c;
import X8.f;
import X8.h;
import X8.j;
import X8.o;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;

/* loaded from: classes.dex */
public class COUICardMultiInputView extends ConstraintLayout implements View.OnLayoutChangeListener {
    private static final int ERROR_COUNT_COLOR_ANIMATOR_TIME = 250;
    private static final int ERROR_COUNT_COLOR_DELAY_TIME = 1000;
    private static final int MAX_LINE = 5;
    private boolean isErrorColor;
    private int mCountTextColor;
    private ValueAnimator mCountTextColorAnimator;
    private TextView mCountTextView;
    private COUIEditText mEditText;
    private int mEditTextMaxHeight;
    private LinearLayout mEdittextContainer;
    private Rect mEdittextContainerRect;
    private boolean mEnableInputCount;
    private CharSequence mHint;
    private InputMethodManager mInputMethodManager;
    private int mMaxCount;
    private Runnable setCountColorRunnable;

    public COUICardMultiInputView(Context context) {
        this(context, null);
    }

    private void cancelColorAnimator() {
        ValueAnimator valueAnimator = this.mCountTextColorAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mCountTextColorAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeColorAnimator(int i10, int i11) {
        cancelColorAnimator();
        ValueAnimator ofInt = ValueAnimator.ofInt(i10, i11);
        this.mCountTextColorAnimator = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.edittext.COUICardMultiInputView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUICardMultiInputView.this.mCountTextColor = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                COUICardMultiInputView.this.mCountTextView.setTextColor(COUICardMultiInputView.this.mCountTextColor);
            }
        });
        this.mCountTextColorAnimator.setDuration(250L);
        this.mCountTextColorAnimator.setEvaluator(new ArgbEvaluator());
        this.mCountTextColorAnimator.start();
    }

    private void handleWithCount() {
        if (this.mEnableInputCount && this.mMaxCount > 0) {
            this.mCountTextView.setVisibility(0);
            this.mCountTextView.setText(this.mEditText.getText().length() + "/" + this.mMaxCount);
            this.mEditText.post(new Runnable() { // from class: com.coui.appcompat.edittext.COUICardMultiInputView.2
                @Override // java.lang.Runnable
                public void run() {
                    COUICardMultiInputView.this.mEditText.setPadding(COUICardMultiInputView.this.mEditText.getPaddingLeft(), COUICardMultiInputView.this.mEditText.getPaddingTop(), COUICardMultiInputView.this.mEditText.getPaddingRight(), COUICardMultiInputView.this.mCountTextView.getMeasuredHeight());
                }
            });
            this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.edittext.COUICardMultiInputView.3
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    int length = editable.length();
                    if (length < COUICardMultiInputView.this.mMaxCount) {
                        COUICardMultiInputView.this.mCountTextView.setText(length + "/" + COUICardMultiInputView.this.mMaxCount);
                        if (COUICardMultiInputView.this.isErrorColor) {
                            COUICardMultiInputView cOUICardMultiInputView = COUICardMultiInputView.this;
                            cOUICardMultiInputView.executeColorAnimator(cOUICardMultiInputView.mCountTextColor, COUIContextUtil.getAttrColor(COUICardMultiInputView.this.getContext(), c.f4412w));
                            COUICardMultiInputView.this.mEditText.removeCallbacks(COUICardMultiInputView.this.setCountColorRunnable);
                        }
                        COUICardMultiInputView.this.isErrorColor = false;
                        return;
                    }
                    COUICardMultiInputView.this.mCountTextView.setText(COUICardMultiInputView.this.mMaxCount + "/" + COUICardMultiInputView.this.mMaxCount);
                    if (length > COUICardMultiInputView.this.mMaxCount) {
                        COUICardMultiInputView.this.mEditText.setText(editable.subSequence(0, COUICardMultiInputView.this.mMaxCount));
                    }
                    COUICardMultiInputView cOUICardMultiInputView2 = COUICardMultiInputView.this;
                    cOUICardMultiInputView2.executeColorAnimator(cOUICardMultiInputView2.mCountTextColor, COUIContextUtil.getAttrColor(COUICardMultiInputView.this.getContext(), c.f4402r));
                    COUICardMultiInputView.this.mEditText.removeCallbacks(COUICardMultiInputView.this.setCountColorRunnable);
                    COUICardMultiInputView.this.mEditText.postDelayed(COUICardMultiInputView.this.setCountColorRunnable, 1000L);
                    COUICardMultiInputView.this.isErrorColor = true;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                }
            });
            return;
        }
        this.mCountTextView.setVisibility(8);
        COUIEditText cOUIEditText = this.mEditText;
        cOUIEditText.setPadding(cOUIEditText.getPaddingLeft(), this.mEditText.getPaddingTop(), this.mEditText.getPaddingRight(), this.mEditText.getPaddingTop());
    }

    private void init() {
        this.mEditText.setTopHint(this.mHint);
        handleWithCount();
    }

    private void releaseCountColorRunnable() {
        Runnable runnable;
        COUIEditText cOUIEditText = this.mEditText;
        if (cOUIEditText != null && (runnable = this.setCountColorRunnable) != null) {
            cOUIEditText.removeCallbacks(runnable);
        }
    }

    public COUIEditText getEditText() {
        return this.mEditText;
    }

    public CharSequence getHint() {
        return this.mHint;
    }

    public int getLayoutResId() {
        return j.f4977h;
    }

    public COUIEditText instanceCOUIEditText(Context context, AttributeSet attributeSet) {
        return new COUIEditText(context, attributeSet, c.f4370b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseCountColorRunnable();
        cancelColorAnimator();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (motionEvent.getAction() == 0) {
            this.mEditTextMaxHeight = (((this.mEdittextContainer.getMeasuredHeight() - this.mEdittextContainer.getPaddingTop()) - this.mEdittextContainer.getPaddingBottom()) - this.mEditText.getPaddingTop()) - this.mEditText.getPaddingBottom();
            if (this.mEditText.getLineCount() * this.mEditText.getLineHeight() > this.mEditTextMaxHeight) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.mEdittextContainerRect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && z10 && this.mEditText.getLineCount() >= 1) {
                this.mEdittextContainer.requestDisallowInterceptTouchEvent(true);
            }
        }
        return false;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        Rect rect = this.mEdittextContainerRect;
        rect.left = 0;
        rect.top = 0;
        rect.right = getMeasuredWidth();
        this.mEdittextContainerRect.bottom = getMeasuredHeight() - this.mEdittextContainer.getPaddingBottom();
    }

    public void setHint(CharSequence charSequence) {
        this.mHint = charSequence;
        this.mEditText.setTopHint(charSequence);
    }

    public void setMaxCount(int i10) {
        this.mMaxCount = i10;
        handleWithCount();
    }

    public COUICardMultiInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUICardMultiInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mEdittextContainerRect = new Rect();
        this.isErrorColor = false;
        this.setCountColorRunnable = new Runnable() { // from class: com.coui.appcompat.edittext.COUICardMultiInputView.4
            @Override // java.lang.Runnable
            public void run() {
                if (COUICardMultiInputView.this.isErrorColor) {
                    COUICardMultiInputView cOUICardMultiInputView = COUICardMultiInputView.this;
                    cOUICardMultiInputView.executeColorAnimator(cOUICardMultiInputView.mCountTextColor, COUIContextUtil.getAttrColor(COUICardMultiInputView.this.getContext(), c.f4412w));
                    COUICardMultiInputView.this.isErrorColor = false;
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5368n2, i10, 0);
        this.mHint = obtainStyledAttributes.getText(o.f5408s2);
        this.mMaxCount = obtainStyledAttributes.getInt(o.f5424u2, 0);
        this.mEnableInputCount = obtainStyledAttributes.getBoolean(o.f5392q2, false);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(getLayoutResId(), (ViewGroup) this, true);
        this.mEdittextContainer = (LinearLayout) findViewById(h.f4898O);
        COUIEditText instanceCOUIEditText = instanceCOUIEditText(context, attributeSet);
        this.mEditText = instanceCOUIEditText;
        instanceCOUIEditText.setMaxLines(5);
        this.mEditText.setGravity(8388659);
        this.mEdittextContainer.addView(this.mEditText, -1, -1);
        this.mEdittextContainer.addOnLayoutChangeListener(this);
        this.mCountTextView = (TextView) findViewById(h.f4901R);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(f.f4516H5);
        this.mCountTextColor = COUIContextUtil.getAttrColor(getContext(), c.f4412w);
        findViewById(h.f4953v0).setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.edittext.COUICardMultiInputView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action == 1 || action == 3) && motionEvent.getX() > dimensionPixelSize && motionEvent.getX() < COUICardMultiInputView.this.getWidth() - dimensionPixelSize) {
                    if (COUICardMultiInputView.this.mInputMethodManager == null) {
                        COUICardMultiInputView cOUICardMultiInputView = COUICardMultiInputView.this;
                        cOUICardMultiInputView.mInputMethodManager = (InputMethodManager) cOUICardMultiInputView.getContext().getSystemService("input_method");
                    }
                    COUICardMultiInputView.this.mEditText.setFocusable(true);
                    COUICardMultiInputView.this.mEditText.requestFocus();
                    COUICardMultiInputView.this.mInputMethodManager.showSoftInput(COUICardMultiInputView.this.mEditText, 0);
                }
                return true;
            }
        });
        init();
    }
}
