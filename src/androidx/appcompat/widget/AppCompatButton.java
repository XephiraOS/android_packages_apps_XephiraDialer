package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import e.C0961a;

/* loaded from: classes.dex */
public class AppCompatButton extends Button {
    private C0435i mAppCompatEmojiTextHelper;
    private final C0430d mBackgroundTintHelper;
    private final C0443q mTextHelper;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    private C0435i getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new C0435i(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0430d c0430d = this.mBackgroundTintHelper;
        if (c0430d != null) {
            c0430d.b();
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (S.f7793a) {
            return super.getAutoSizeMaxTextSize();
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            return c0443q.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (S.f7793a) {
            return super.getAutoSizeMinTextSize();
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            return c0443q.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (S.f7793a) {
            return super.getAutoSizeStepGranularity();
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            return c0443q.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (S.f7793a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            return c0443q.h();
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (S.f7793a) {
            if (super.getAutoSizeTextType() != 1) {
                return 0;
            }
            return 1;
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q == null) {
            return 0;
        }
        return c0443q.i();
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.k.r(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0430d c0430d = this.mBackgroundTintHelper;
        if (c0430d != null) {
            return c0430d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0430d c0430d = this.mBackgroundTintHelper;
        if (c0430d != null) {
            return c0430d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.o(z10, i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null && !S.f7793a && c0443q.l()) {
            this.mTextHelper.c();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
        if (S.f7793a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.t(i10, i11, i12, i13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i10) {
        if (S.f7793a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.u(iArr, i10);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (S.f7793a) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.v(i10);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0430d c0430d = this.mBackgroundTintHelper;
        if (c0430d != null) {
            c0430d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0430d c0430d = this.mBackgroundTintHelper;
        if (c0430d != null) {
            c0430d.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.s(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z10) {
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.s(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0430d c0430d = this.mBackgroundTintHelper;
        if (c0430d != null) {
            c0430d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0430d c0430d = this.mBackgroundTintHelper;
        if (c0430d != null) {
            c0430d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.w(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.x(mode);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.q(context, i10);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i10, float f10) {
        if (S.f7793a) {
            super.setTextSize(i10, f10);
            return;
        }
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.A(i10, f10);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30118q);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i10) {
        super(H.b(context), attributeSet, i10);
        F.a(this, getContext());
        C0430d c0430d = new C0430d(this);
        this.mBackgroundTintHelper = c0430d;
        c0430d.e(attributeSet, i10);
        C0443q c0443q = new C0443q(this);
        this.mTextHelper = c0443q;
        c0443q.m(attributeSet, i10);
        c0443q.b();
        getEmojiTextViewHelper().c(attributeSet, i10);
    }
}
