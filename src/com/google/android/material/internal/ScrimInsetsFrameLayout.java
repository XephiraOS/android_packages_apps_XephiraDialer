package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.core.view.z;
import e4.l;
import e4.m;

/* loaded from: classes3.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    private boolean drawBottomInsetForeground;
    private boolean drawLeftInsetForeground;
    private boolean drawRightInsetForeground;
    private boolean drawTopInsetForeground;
    Drawable insetForeground;
    Rect insets;
    private Rect tempRect;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.insets != null && this.insetForeground != null) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.drawTopInsetForeground) {
                this.tempRect.set(0, 0, width, this.insets.top);
                this.insetForeground.setBounds(this.tempRect);
                this.insetForeground.draw(canvas);
            }
            if (this.drawBottomInsetForeground) {
                this.tempRect.set(0, height - this.insets.bottom, width, height);
                this.insetForeground.setBounds(this.tempRect);
                this.insetForeground.draw(canvas);
            }
            if (this.drawLeftInsetForeground) {
                Rect rect = this.tempRect;
                Rect rect2 = this.insets;
                rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
                this.insetForeground.setBounds(this.tempRect);
                this.insetForeground.draw(canvas);
            }
            if (this.drawRightInsetForeground) {
                Rect rect3 = this.tempRect;
                Rect rect4 = this.insets;
                rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
                this.insetForeground.setBounds(this.tempRect);
                this.insetForeground.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z10) {
        this.drawBottomInsetForeground = z10;
    }

    public void setDrawLeftInsetForeground(boolean z10) {
        this.drawLeftInsetForeground = z10;
    }

    public void setDrawRightInsetForeground(boolean z10) {
        this.drawRightInsetForeground = z10;
    }

    public void setDrawTopInsetForeground(boolean z10) {
        this.drawTopInsetForeground = z10;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.insetForeground = drawable;
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        this.drawLeftInsetForeground = true;
        this.drawRightInsetForeground = true;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, m.f31469m8, i10, l.f31032o, new int[0]);
        this.insetForeground = obtainStyledAttributes.getDrawable(m.f31480n8);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        K.z0(this, new z() { // from class: com.google.android.material.internal.ScrimInsetsFrameLayout.1
            @Override // androidx.core.view.z
            public X onApplyWindowInsets(View view, X x10) {
                boolean z10;
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (scrimInsetsFrameLayout.insets == null) {
                    scrimInsetsFrameLayout.insets = new Rect();
                }
                ScrimInsetsFrameLayout.this.insets.set(x10.k(), x10.m(), x10.l(), x10.j());
                ScrimInsetsFrameLayout.this.onInsetsChanged(x10);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout2 = ScrimInsetsFrameLayout.this;
                if (x10.n() && ScrimInsetsFrameLayout.this.insetForeground != null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                scrimInsetsFrameLayout2.setWillNotDraw(z10);
                K.Z(ScrimInsetsFrameLayout.this);
                return x10.c();
            }
        });
    }

    public void onInsetsChanged(X x10) {
    }
}
