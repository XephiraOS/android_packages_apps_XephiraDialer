package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import e.C0961a;

/* loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton {
    private final C0430d mBackgroundTintHelper;
    private boolean mHasLevel;
    private final C0437k mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0430d c0430d = this.mBackgroundTintHelper;
        if (c0430d != null) {
            c0430d.b();
        }
        C0437k c0437k = this.mImageHelper;
        if (c0437k != null) {
            c0437k.c();
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

    public ColorStateList getSupportImageTintList() {
        C0437k c0437k = this.mImageHelper;
        if (c0437k != null) {
            return c0437k.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0437k c0437k = this.mImageHelper;
        if (c0437k != null) {
            return c0437k.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        if (this.mImageHelper.f() && super.hasOverlappingRendering()) {
            return true;
        }
        return false;
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

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0437k c0437k = this.mImageHelper;
        if (c0437k != null) {
            c0437k.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0437k c0437k = this.mImageHelper;
        if (c0437k != null && drawable != null && !this.mHasLevel) {
            c0437k.h(drawable);
        }
        super.setImageDrawable(drawable);
        C0437k c0437k2 = this.mImageHelper;
        if (c0437k2 != null) {
            c0437k2.c();
            if (!this.mHasLevel) {
                this.mImageHelper.b();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.mImageHelper.i(i10);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0437k c0437k = this.mImageHelper;
        if (c0437k != null) {
            c0437k.c();
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0437k c0437k = this.mImageHelper;
        if (c0437k != null) {
            c0437k.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0437k c0437k = this.mImageHelper;
        if (c0437k != null) {
            c0437k.k(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30087E);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(H.b(context), attributeSet, i10);
        this.mHasLevel = false;
        F.a(this, getContext());
        C0430d c0430d = new C0430d(this);
        this.mBackgroundTintHelper = c0430d;
        c0430d.e(attributeSet, i10);
        C0437k c0437k = new C0437k(this);
        this.mImageHelper = c0437k;
        c0437k.g(attributeSet, i10);
    }
}
