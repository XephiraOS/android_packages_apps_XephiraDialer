package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import e.C0961a;
import f.C0991a;

/* loaded from: classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView {
    private static final int[] TINT_ATTRS = {R.attr.popupBackground};
    private final C0434h mAppCompatEmojiEditTextHelper;
    private final C0430d mBackgroundTintHelper;
    private final C0443q mTextHelper;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, null);
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

    public void initEmojiKeyListener(C0434h c0434h) {
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

    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.c();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mAppCompatEmojiEditTextHelper.e(C0436j.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.k.s(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(C0991a.b(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.mAppCompatEmojiEditTextHelper.f(z10);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.a(keyListener));
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

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30117p);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(H.b(context), attributeSet, i10);
        F.a(this, getContext());
        K w10 = K.w(getContext(), attributeSet, TINT_ATTRS, i10, 0);
        if (w10.s(0)) {
            setDropDownBackgroundDrawable(w10.g(0));
        }
        w10.y();
        C0430d c0430d = new C0430d(this);
        this.mBackgroundTintHelper = c0430d;
        c0430d.e(attributeSet, i10);
        C0443q c0443q = new C0443q(this);
        this.mTextHelper = c0443q;
        c0443q.m(attributeSet, i10);
        c0443q.b();
        C0434h c0434h = new C0434h(this);
        this.mAppCompatEmojiEditTextHelper = c0434h;
        c0434h.d(attributeSet, i10);
        initEmojiKeyListener(c0434h);
    }
}
