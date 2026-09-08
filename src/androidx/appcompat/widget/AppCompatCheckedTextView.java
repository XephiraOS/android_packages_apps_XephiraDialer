package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import e.C0961a;
import f.C0991a;

/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: a, reason: collision with root package name */
    public final C0431e f7594a;

    /* renamed from: b, reason: collision with root package name */
    public final C0430d f7595b;

    /* renamed from: c, reason: collision with root package name */
    public final C0443q f7596c;

    /* renamed from: d, reason: collision with root package name */
    public C0435i f7597d;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30120s);
    }

    private C0435i getEmojiTextViewHelper() {
        if (this.f7597d == null) {
            this.f7597d = new C0435i(this);
        }
        return this.f7597d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0443q c0443q = this.f7596c;
        if (c0443q != null) {
            c0443q.b();
        }
        C0430d c0430d = this.f7595b;
        if (c0430d != null) {
            c0430d.b();
        }
        C0431e c0431e = this.f7594a;
        if (c0431e != null) {
            c0431e.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.k.r(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0430d c0430d = this.f7595b;
        if (c0430d != null) {
            return c0430d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0430d c0430d = this.f7595b;
        if (c0430d != null) {
            return c0430d.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0431e c0431e = this.f7594a;
        if (c0431e != null) {
            return c0431e.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0431e c0431e = this.f7594a;
        if (c0431e != null) {
            return c0431e.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7596c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7596c.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0436j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0430d c0430d = this.f7595b;
        if (c0430d != null) {
            c0430d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0430d c0430d = this.f7595b;
        if (c0430d != null) {
            c0430d.g(i10);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0431e c0431e = this.f7594a;
        if (c0431e != null) {
            c0431e.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0443q c0443q = this.f7596c;
        if (c0443q != null) {
            c0443q.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0443q c0443q = this.f7596c;
        if (c0443q != null) {
            c0443q.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.s(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0430d c0430d = this.f7595b;
        if (c0430d != null) {
            c0430d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0430d c0430d = this.f7595b;
        if (c0430d != null) {
            c0430d.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0431e c0431e = this.f7594a;
        if (c0431e != null) {
            c0431e.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0431e c0431e = this.f7594a;
        if (c0431e != null) {
            c0431e.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f7596c.w(colorStateList);
        this.f7596c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f7596c.x(mode);
        this.f7596c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C0443q c0443q = this.f7596c;
        if (c0443q != null) {
            c0443q.q(context, i10);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i10) {
        super(H.b(context), attributeSet, i10);
        F.a(this, getContext());
        C0443q c0443q = new C0443q(this);
        this.f7596c = c0443q;
        c0443q.m(attributeSet, i10);
        c0443q.b();
        C0430d c0430d = new C0430d(this);
        this.f7595b = c0430d;
        c0430d.e(attributeSet, i10);
        C0431e c0431e = new C0431e(this);
        this.f7594a = c0431e;
        c0431e.d(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(C0991a.b(getContext(), i10));
    }
}
