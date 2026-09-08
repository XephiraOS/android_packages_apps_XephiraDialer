package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import e.C0961a;
import f.C0991a;

/* loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements androidx.core.widget.m {
    private C0435i mAppCompatEmojiTextHelper;
    private final C0430d mBackgroundTintHelper;
    private final C0432f mCompoundButtonHelper;
    private final C0443q mTextHelper;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    private C0435i getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new C0435i(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
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

    @Override // androidx.core.widget.m
    public ColorStateList getSupportButtonTintList() {
        C0432f c0432f = this.mCompoundButtonHelper;
        if (c0432f != null) {
            return c0432f.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0432f c0432f = this.mCompoundButtonHelper;
        if (c0432f != null) {
            return c0432f.c();
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

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0432f c0432f = this.mCompoundButtonHelper;
        if (c0432f != null) {
            c0432f.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0443q c0443q = this.mTextHelper;
        if (c0443q != null) {
            c0443q.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
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

    @Override // androidx.core.widget.m
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0432f c0432f = this.mCompoundButtonHelper;
        if (c0432f != null) {
            c0432f.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0432f c0432f = this.mCompoundButtonHelper;
        if (c0432f != null) {
            c0432f.g(mode);
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

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30119r);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i10) {
        super(H.b(context), attributeSet, i10);
        F.a(this, getContext());
        C0432f c0432f = new C0432f(this);
        this.mCompoundButtonHelper = c0432f;
        c0432f.d(attributeSet, i10);
        C0430d c0430d = new C0430d(this);
        this.mBackgroundTintHelper = c0430d;
        c0430d.e(attributeSet, i10);
        C0443q c0443q = new C0443q(this);
        this.mTextHelper = c0443q;
        c0443q.m(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(C0991a.b(getContext(), i10));
    }
}
