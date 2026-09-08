package com.coui.appcompat.slideview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import b9.C0535e;
import b9.C0536f;

/* loaded from: classes.dex */
public class COUISlideMenuItem {
    private Drawable mBackground;
    int[] mBackgroundStyleId;
    private Context mContext;
    private Drawable mIcon;
    private CharSequence mText;
    private int mWidth;

    public COUISlideMenuItem(Context context, CharSequence charSequence, Drawable drawable) {
        this.mBackgroundStyleId = new int[]{C0536f.f12448b, C0536f.f12447a, C0536f.f12449c};
        this.mWidth = 54;
        this.mContext = context;
        this.mBackground = drawable;
        this.mText = charSequence;
        this.mWidth = context.getResources().getDimensionPixelSize(C0535e.f12384P);
    }

    public Drawable getBackground() {
        return this.mBackground;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setBackground(Drawable drawable) {
        this.mBackground = drawable;
    }

    public void setBackgroundStyle(int i10) {
        setBackground(this.mContext.getResources().getDrawable(this.mBackgroundStyleId[i10]));
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence;
    }

    public void setWidth(int i10) {
        this.mWidth = i10;
    }

    public void setBackground(int i10) {
        setBackground(this.mContext.getResources().getDrawable(i10));
    }

    public void setIcon(int i10) {
        this.mIcon = this.mContext.getResources().getDrawable(i10);
    }

    public void setText(int i10) {
        setText(this.mContext.getText(i10));
    }

    public COUISlideMenuItem(Context context, int i10, int i11) {
        this(context, context.getResources().getString(i10), context.getResources().getDrawable(i11));
    }

    public COUISlideMenuItem(Context context, int i10, Drawable drawable) {
        this(context, context.getResources().getString(i10), drawable);
    }

    public COUISlideMenuItem(Context context, CharSequence charSequence, int i10) {
        this(context, charSequence, context.getResources().getDrawable(i10));
    }

    public COUISlideMenuItem(Context context, int i10) {
        this(context, i10, C0536f.f12447a);
    }

    public COUISlideMenuItem(Context context, CharSequence charSequence) {
        this(context, charSequence, C0536f.f12447a);
    }

    public COUISlideMenuItem(Context context, Drawable drawable) {
        int i10 = C0536f.f12448b;
        int i11 = C0536f.f12447a;
        this.mBackgroundStyleId = new int[]{i10, i11, C0536f.f12449c};
        this.mWidth = 54;
        this.mContext = context;
        this.mIcon = drawable;
        this.mBackground = context.getResources().getDrawable(i11);
        this.mText = null;
        this.mWidth = this.mContext.getResources().getDimensionPixelSize(C0535e.f12384P);
    }

    public void setContentDescription(String str) {
    }
}
