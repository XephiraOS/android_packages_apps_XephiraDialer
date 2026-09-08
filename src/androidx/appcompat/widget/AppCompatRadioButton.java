package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import e.C0961a;
import f.C0991a;

/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements androidx.core.widget.m {

    /* renamed from: a, reason: collision with root package name */
    public final C0432f f7603a;

    /* renamed from: b, reason: collision with root package name */
    public final C0430d f7604b;

    /* renamed from: c, reason: collision with root package name */
    public final C0443q f7605c;

    /* renamed from: d, reason: collision with root package name */
    public C0435i f7606d;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30093K);
    }

    private C0435i getEmojiTextViewHelper() {
        if (this.f7606d == null) {
            this.f7606d = new C0435i(this);
        }
        return this.f7606d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0430d c0430d = this.f7604b;
        if (c0430d != null) {
            c0430d.b();
        }
        C0443q c0443q = this.f7605c;
        if (c0443q != null) {
            c0443q.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0430d c0430d = this.f7604b;
        if (c0430d != null) {
            return c0430d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0430d c0430d = this.f7604b;
        if (c0430d != null) {
            return c0430d.d();
        }
        return null;
    }

    @Override // androidx.core.widget.m
    public ColorStateList getSupportButtonTintList() {
        C0432f c0432f = this.f7603a;
        if (c0432f != null) {
            return c0432f.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0432f c0432f = this.f7603a;
        if (c0432f != null) {
            return c0432f.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7605c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7605c.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0430d c0430d = this.f7604b;
        if (c0430d != null) {
            c0430d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0430d c0430d = this.f7604b;
        if (c0430d != null) {
            c0430d.g(i10);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0432f c0432f = this.f7603a;
        if (c0432f != null) {
            c0432f.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0443q c0443q = this.f7605c;
        if (c0443q != null) {
            c0443q.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0443q c0443q = this.f7605c;
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
        C0430d c0430d = this.f7604b;
        if (c0430d != null) {
            c0430d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0430d c0430d = this.f7604b;
        if (c0430d != null) {
            c0430d.j(mode);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0432f c0432f = this.f7603a;
        if (c0432f != null) {
            c0432f.f(colorStateList);
        }
    }

    @Override // androidx.core.widget.m
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0432f c0432f = this.f7603a;
        if (c0432f != null) {
            c0432f.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f7605c.w(colorStateList);
        this.f7605c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f7605c.x(mode);
        this.f7605c.b();
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i10) {
        super(H.b(context), attributeSet, i10);
        F.a(this, getContext());
        C0432f c0432f = new C0432f(this);
        this.f7603a = c0432f;
        c0432f.d(attributeSet, i10);
        C0430d c0430d = new C0430d(this);
        this.f7604b = c0430d;
        c0430d.e(attributeSet, i10);
        C0443q c0443q = new C0443q(this);
        this.f7605c = c0443q;
        c0443q.m(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i10) {
        setButtonDrawable(C0991a.b(getContext(), i10));
    }
}
