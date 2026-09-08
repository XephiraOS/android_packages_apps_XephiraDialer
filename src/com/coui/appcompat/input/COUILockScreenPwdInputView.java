package com.coui.appcompat.input;

import Z8.a;
import Z8.c;
import Z8.d;
import Z8.e;
import Z8.f;
import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.edittext.COUIInputView;
import com.coui.appcompat.input.COUILockScreenPwdInputView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;

/* loaded from: classes.dex */
public class COUILockScreenPwdInputView extends COUIInputView {
    public static final int DEFAULT_MAX_INPUT_COUNT = 16;
    public static final int DEFAULT_MIN_INPUT_COUNT = 6;
    private final int DEFAULT_SCREEN_WIDTH_DP;
    private final int INPUT_LOCK_SCREEN_PWD_EDIT_MARGIN;
    private int mDefaultInputLockScreenPwdWidth;
    private View mLockScreenPwdCard;
    private int mMinInputCount;
    private int mScenesMode;
    private TextWatcher mTextWatcher;

    public COUILockScreenPwdInputView(Context context) {
        this(context, null);
    }

    private void initAttr() {
        this.mDefaultInputLockScreenPwdWidth = getResources().getDimensionPixelOffset(c.f6057z0);
        this.mLockScreenPwdCard = findViewById(e.f6106Z);
        getEditText().setVerticalScrollBarEnabled(false);
        COUIChangeTextUtil.adaptFontSize(getEditText(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateCardWidth$0() {
        this.mLockScreenPwdCard.requestLayout();
    }

    public void append(String str) {
        this.mEditText.append(str);
    }

    public void cropBeyondFont() {
        String couiEditTexttNoEllipsisText = this.mEditText.getCouiEditTexttNoEllipsisText();
        if (this.mMaxCount > 0 && this.mEditText.getText() != null) {
            int length = couiEditTexttNoEllipsisText.length();
            int i10 = this.mMaxCount;
            if (length > i10) {
                this.mEditText.setText(couiEditTexttNoEllipsisText.subSequence(0, i10));
            }
        }
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public int getEdittextPaddingBottom() {
        return getResources().getDimensionPixelSize(c.f5979A0);
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public int getEdittextPaddingEnd() {
        return this.mButtonLayout.getWidth();
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public int getEdittextPaddingTop() {
        return getResources().getDimensionPixelSize(c.f5981B0);
    }

    public int getInputCount() {
        String couiEditTexttNoEllipsisText = this.mEditText.getCouiEditTexttNoEllipsisText();
        if (this.mEditText.getText() != null && couiEditTexttNoEllipsisText.length() > 0) {
            return couiEditTexttNoEllipsisText.length();
        }
        return 0;
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public int getLayoutResId() {
        return f.f6162D;
    }

    public int getMinInputCount() {
        return this.mMinInputCount;
    }

    public View getmLockScreenPwdCard() {
        return this.mLockScreenPwdCard;
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public COUIEditText instanceCOUIEditText(Context context, AttributeSet attributeSet) {
        if (this.mScenesMode == 1) {
            return new COUIEditText(context, attributeSet, a.f5975b);
        }
        return new COUIEditText(context, attributeSet, a.f5974a);
    }

    public void lazyInitInputView(AttributeSet attributeSet, int i10) {
        this.mScenesMode = i10;
        lazyInit(getContext(), attributeSet);
        initAttr();
    }

    public void removeLastInputText() {
        String couiEditTexttNoEllipsisText = this.mEditText.getCouiEditTexttNoEllipsisText();
        if (this.mEditText.getText() != null && couiEditTexttNoEllipsisText.length() > 0) {
            this.mEditText.setText(couiEditTexttNoEllipsisText.subSequence(0, couiEditTexttNoEllipsisText.length() - 1));
        }
    }

    public void setCheckBoxImageResourceDesktop() {
        ((CheckBox) findViewById(e.f6129l)).setButtonDrawable(d.f6065h);
    }

    public void setDefaultInputLockScreenPwdWidth(int i10) {
        this.mDefaultInputLockScreenPwdWidth = i10;
        updateCardWidth();
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public void setEnableInputCount(boolean z10) {
        this.mEnableInputCount = z10;
        cropBeyondFont();
        handleWithCount();
    }

    public void setInputType(int i10) {
        if (this.mInputType == i10) {
            return;
        }
        this.mInputType = i10;
        handleWithPassword();
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public void setMaxCount(int i10) {
        this.mMaxCount = i10;
        cropBeyondFont();
        handleWithCount();
    }

    public void setMinInputCount(int i10) {
        this.mMinInputCount = i10;
    }

    public void updateCardWidth() {
        if (this.mLockScreenPwdCard == null) {
            return;
        }
        this.mLockScreenPwdCard.getLayoutParams().width = (int) (this.mDefaultInputLockScreenPwdWidth * (Math.min(getResources().getConfiguration().screenWidthDp, 360.0d) / 360.0d));
        this.mLockScreenPwdCard.post(new Runnable() { // from class: y3.c
            @Override // java.lang.Runnable
            public final void run() {
                COUILockScreenPwdInputView.this.lambda$updateCardWidth$0();
            }
        });
    }

    public COUILockScreenPwdInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUILockScreenPwdInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.DEFAULT_SCREEN_WIDTH_DP = 360;
        this.INPUT_LOCK_SCREEN_PWD_EDIT_MARGIN = getResources().getDimensionPixelOffset(c.f6053x0);
        this.mMinInputCount = 6;
        this.mScenesMode = 0;
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public void handleWithCountTextView() {
    }

    @Override // com.coui.appcompat.edittext.COUIInputView
    public void nowInit(Context context, AttributeSet attributeSet) {
    }
}
