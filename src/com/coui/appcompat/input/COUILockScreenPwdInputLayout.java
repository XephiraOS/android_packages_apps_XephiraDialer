package com.coui.appcompat.input;

import Z8.b;
import Z8.c;
import Z8.d;
import Z8.e;
import Z8.f;
import Z8.i;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.edittext.COUIInputView;
import com.coui.appcompat.input.COUILockScreenPwdInputLayout;

/* loaded from: classes.dex */
public class COUILockScreenPwdInputLayout extends ConstraintLayout {
    public static final int DESKTOP = 1;
    public static final int INPUT_VIEW_TRANSPARENT_BG_COLOR = b.f5976a;
    public static final int SETTING = 0;
    public static final int SETTING1 = 2;
    private boolean mAllowNext;
    private COUILockScreenPwdInputView mInputView;
    private ImageView mNextIcon;
    private NextIconCheckListener mNextIconCheckListener;
    private COUIInputView.OnEditTextChangeListener mOnEditTextChangeListener;
    private int mScenesMode;

    /* loaded from: classes.dex */
    public interface NextIconCheckListener {
        void checkedPwd(String str);
    }

    public COUILockScreenPwdInputLayout(Context context) {
        this(context, null);
    }

    private void changeNextTransparentImageResource(boolean z10) {
        if (this.mAllowNext == z10) {
            return;
        }
        this.mAllowNext = z10;
        if (z10 && this.mScenesMode == 1) {
            setAllowNextDesktopBackground();
            return;
        }
        if (!z10 && this.mScenesMode == 1) {
            setNormalNextDesktopBackground();
        } else if (z10) {
            setAllowNextSettingBackground();
        } else {
            setNormalNextSettingBackground();
        }
    }

    private void initAttr(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f6213S, i10, 0);
        boolean z10 = obtainStyledAttributes.getBoolean(i.f6214T, false);
        int i11 = obtainStyledAttributes.getInt(i.f6215U, 0);
        int i12 = obtainStyledAttributes.getInt(i.f6217W, 2);
        this.mScenesMode = obtainStyledAttributes.getInt(i.f6218X, 0);
        int i13 = obtainStyledAttributes.getInt(i.f6216V, 6);
        obtainStyledAttributes.recycle();
        COUILockScreenPwdInputView cOUILockScreenPwdInputView = (COUILockScreenPwdInputView) findViewById(e.f6090J);
        this.mInputView = cOUILockScreenPwdInputView;
        cOUILockScreenPwdInputView.lazyInitInputView(attributeSet, this.mScenesMode);
        this.mInputView.setInputType(i12);
        this.mInputView.setEnableInputCount(z10);
        this.mNextIcon = (ImageView) findViewById(e.f6100T);
        initInputCountSetting(i11, i13);
        initListener();
        initScenesModeUI(context);
    }

    private void initInputCountSetting(int i10, int i11) {
        if (i10 > 0 && i11 > 0 && i10 > i11) {
            this.mInputView.setMaxCount(i10);
            this.mInputView.setMinInputCount(i11);
        } else {
            this.mInputView.setMaxCount(16);
            this.mInputView.setMinInputCount(6);
        }
    }

    private void initListener() {
        this.mNextIcon.setOnClickListener(new View.OnClickListener() { // from class: y3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUILockScreenPwdInputLayout.this.lambda$initListener$0(view);
            }
        });
        this.mInputView.setOnEditTextChangeListener(new COUIInputView.OnEditTextChangeListener() { // from class: y3.b
            @Override // com.coui.appcompat.edittext.COUIInputView.OnEditTextChangeListener
            public final void afterTextChange(Editable editable) {
                COUILockScreenPwdInputLayout.this.lambda$initListener$1(editable);
            }
        });
    }

    private void initScenesModeUI(Context context) {
        int i10 = this.mScenesMode;
        if (i10 == 1) {
            this.mInputView.setDefaultInputLockScreenPwdWidth(getResources().getDimensionPixelOffset(c.f6051w0));
            this.mInputView.setCheckBoxImageResourceDesktop();
            COUIEditText editText = this.mInputView.getEditText();
            Resources resources = getResources();
            int i11 = b.f5977b;
            editText.setTextColor(resources.getColor(i11, context.getTheme()));
            this.mInputView.getEditText().setEditTextColor(getResources().getColor(i11, context.getTheme()));
            setNormalNextDesktopBackground();
        } else if (i10 == 2) {
            this.mInputView.setDefaultInputLockScreenPwdWidth(getResources().getDimensionPixelOffset(c.f6055y0));
        }
        if (this.mInputView.isEnableInputCount() && this.mInputView.getInputCount() < this.mInputView.getMinInputCount()) {
            changeNextTransparentImageResource(false);
        } else {
            changeNextTransparentImageResource(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(View view) {
        NextIconCheckListener nextIconCheckListener;
        if ((!this.mInputView.isEnableInputCount() || this.mInputView.getMinInputCount() <= this.mInputView.getInputCount()) && (nextIconCheckListener = this.mNextIconCheckListener) != null) {
            nextIconCheckListener.checkedPwd(this.mInputView.getEditText().getCouiEditTexttNoEllipsisText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$1(Editable editable) {
        if (this.mInputView.isEnableInputCount()) {
            if (this.mInputView.getMinInputCount() <= editable.length()) {
                changeNextTransparentImageResource(true);
            } else {
                changeNextTransparentImageResource(false);
            }
            if (editable.length() > this.mInputView.getMaxCount()) {
                this.mInputView.getEditText().setText(editable.subSequence(0, this.mInputView.getMaxCount()));
            }
        }
        COUIInputView.OnEditTextChangeListener onEditTextChangeListener = this.mOnEditTextChangeListener;
        if (onEditTextChangeListener != null) {
            onEditTextChangeListener.afterTextChange(editable);
        }
    }

    private void setAllowNextDesktopBackground() {
        this.mNextIcon.setBackgroundResource(d.f6068k);
        this.mNextIcon.setImageResource(d.f6069l);
    }

    private void setAllowNextSettingBackground() {
        this.mNextIcon.setImageResource(d.f6071n);
        this.mNextIcon.setBackgroundResource(d.f6066i);
    }

    private void setNormalNextDesktopBackground() {
        this.mNextIcon.setBackgroundResource(d.f6067j);
        this.mNextIcon.setImageResource(d.f6069l);
    }

    private void setNormalNextSettingBackground() {
        this.mNextIcon.setBackgroundResource(d.f6066i);
        this.mNextIcon.setImageResource(d.f6070m);
    }

    public void append(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mInputView.append(str);
    }

    public void clearInputText() {
        this.mInputView.getEditText().setText("");
    }

    public void closeError() {
        if (this.mInputView.getEditText().isErrorState()) {
            this.mInputView.showError("");
        }
    }

    public COUILockScreenPwdInputView getInputView() {
        return this.mInputView;
    }

    public int getLayoutResId() {
        return f.f6161C;
    }

    public boolean isErrorState() {
        return this.mInputView.getEditText().isErrorState();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.mInputView.updateCardWidth();
        }
    }

    public void popupKeyboard() {
        this.mInputView.getEditText().setFocusable(true);
        this.mInputView.getEditText().setFocusableInTouchMode(true);
        this.mInputView.getEditText().requestFocus();
    }

    public void removeLastInputText() {
        this.mInputView.removeLastInputText();
    }

    public void setCOUIEditTextChangeListener(COUIInputView.OnEditTextChangeListener onEditTextChangeListener) {
        this.mOnEditTextChangeListener = onEditTextChangeListener;
    }

    public boolean setCOUIInputMaxCount(int i10) {
        if (i10 > 0 && i10 >= this.mInputView.getMinInputCount()) {
            this.mInputView.setMaxCount(i10);
            return true;
        }
        return false;
    }

    public boolean setCOUIInputMinCount(int i10) {
        if (i10 <= 0 || i10 > this.mInputView.getMaxCount()) {
            return false;
        }
        this.mInputView.setMinInputCount(i10);
        if (this.mInputView.isEnableInputCount() && this.mInputView.getMinInputCount() > this.mInputView.getInputCount()) {
            changeNextTransparentImageResource(false);
        } else {
            changeNextTransparentImageResource(true);
        }
        return true;
    }

    public void setCOUIInputType(int i10) {
        this.mInputView.setInputType(i10);
    }

    public void setNextIcOnClickListener(NextIconCheckListener nextIconCheckListener) {
        this.mNextIconCheckListener = nextIconCheckListener;
    }

    public void showError() {
        this.mInputView.showError("error");
    }

    public void withCOUILengthLimit(boolean z10) {
        this.mInputView.setEnableInputCount(z10);
        if (this.mInputView.isEnableInputCount() && this.mInputView.getInputCount() < this.mInputView.getMinInputCount()) {
            changeNextTransparentImageResource(false);
        } else {
            changeNextTransparentImageResource(true);
        }
    }

    public COUILockScreenPwdInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUILockScreenPwdInputLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mScenesMode = 0;
        this.mAllowNext = false;
        LayoutInflater.from(getContext()).inflate(getLayoutResId(), (ViewGroup) this, true);
        initAttr(context, attributeSet, i10);
    }
}
