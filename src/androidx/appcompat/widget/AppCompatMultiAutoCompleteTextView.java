package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import e.C0961a;
import f.C0991a;

/* loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f7599d = {R.attr.popupBackground};

    /* renamed from: a, reason: collision with root package name */
    public final C0430d f7600a;

    /* renamed from: b, reason: collision with root package name */
    public final C0443q f7601b;

    /* renamed from: c, reason: collision with root package name */
    public final C0434h f7602c;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30117p);
    }

    public void a(C0434h c0434h) {
        KeyListener keyListener = getKeyListener();
        if (c0434h.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a10 = c0434h.a(keyListener);
            if (a10 == keyListener) {
                return;
            }
            super.setKeyListener(a10);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
            super.setClickable(isClickable);
            super.setLongClickable(isLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0430d c0430d = this.f7600a;
        if (c0430d != null) {
            c0430d.b();
        }
        C0443q c0443q = this.f7601b;
        if (c0443q != null) {
            c0443q.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0430d c0430d = this.f7600a;
        if (c0430d != null) {
            return c0430d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0430d c0430d = this.f7600a;
        if (c0430d != null) {
            return c0430d.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7601b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7601b.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f7602c.e(C0436j.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0430d c0430d = this.f7600a;
        if (c0430d != null) {
            c0430d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        C0430d c0430d = this.f7600a;
        if (c0430d != null) {
            c0430d.g(i10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0443q c0443q = this.f7601b;
        if (c0443q != null) {
            c0443q.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0443q c0443q = this.f7601b;
        if (c0443q != null) {
            c0443q.p();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(C0991a.b(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f7602c.f(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f7602c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0430d c0430d = this.f7600a;
        if (c0430d != null) {
            c0430d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0430d c0430d = this.f7600a;
        if (c0430d != null) {
            c0430d.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f7601b.w(colorStateList);
        this.f7601b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f7601b.x(mode);
        this.f7601b.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C0443q c0443q = this.f7601b;
        if (c0443q != null) {
            c0443q.q(context, i10);
        }
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(H.b(context), attributeSet, i10);
        F.a(this, getContext());
        K w10 = K.w(getContext(), attributeSet, f7599d, i10, 0);
        if (w10.s(0)) {
            setDropDownBackgroundDrawable(w10.g(0));
        }
        w10.y();
        C0430d c0430d = new C0430d(this);
        this.f7600a = c0430d;
        c0430d.e(attributeSet, i10);
        C0443q c0443q = new C0443q(this);
        this.f7601b = c0443q;
        c0443q.m(attributeSet, i10);
        c0443q.b();
        C0434h c0434h = new C0434h(this);
        this.f7602c = c0434h;
        c0434h.d(attributeSet, i10);
        a(c0434h);
    }
}
