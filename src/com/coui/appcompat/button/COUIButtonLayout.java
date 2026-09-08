package com.coui.appcompat.button;

import X8.f;
import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class COUIButtonLayout extends LinearLayout {
    private boolean isForceSmallScreenWidth;
    private boolean isLimitHeight;
    private int mHorizontalLayoutPadding;
    private int mLimitMaxWidth;
    private int mMaxHeight;
    private int mMaxWidth;
    private int mOrientation;
    private int mVerticalLayoutPadding;

    public COUIButtonLayout(Context context) {
        super(context);
        this.isLimitHeight = false;
        this.isForceSmallScreenWidth = false;
    }

    private void initResource() {
        this.mOrientation = getOrientation();
        this.mHorizontalLayoutPadding = getResources().getDimensionPixelSize(f.f4589S1);
        this.mVerticalLayoutPadding = getResources().getDimensionPixelSize(f.f4603U1);
    }

    private void setPaddingHorizontal(int i10) {
        if (i10 == 0) {
            if (getOrientation() == 0) {
                i10 = this.mHorizontalLayoutPadding;
            } else {
                i10 = this.mVerticalLayoutPadding;
            }
        }
        setPaddingRelative(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public boolean isForceSmallScreenWidth() {
        return this.isForceSmallScreenWidth;
    }

    public boolean isLimitHeight() {
        return this.isLimitHeight;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int i12 = this.mLimitMaxWidth;
        if (i12 > 0 && (mode == Integer.MIN_VALUE || mode == 1073741824)) {
            int min = Math.min(i12, View.MeasureSpec.getSize(i10));
            this.mMaxWidth = min;
            i10 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        } else {
            this.mMaxWidth = View.MeasureSpec.getSize(i10);
        }
        this.mMaxHeight = View.MeasureSpec.getSize(i11);
        super.onMeasure(i10, i11);
    }

    public boolean setForceSmallScreenWidth(boolean z10) {
        this.isForceSmallScreenWidth = z10;
        return z10;
    }

    public void setHorizontalLayoutPadding(int i10) {
        this.mHorizontalLayoutPadding = i10;
        if (getOrientation() == 0) {
            setPaddingHorizontal(this.mHorizontalLayoutPadding);
        }
    }

    public void setLimitHeight(boolean z10) {
        this.isLimitHeight = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        super.setOrientation(i10);
        if (this.mOrientation != i10) {
            setPaddingHorizontal(0);
            this.mOrientation = i10;
        }
    }

    public void setVerticalLayoutPadding(int i10) {
        this.mVerticalLayoutPadding = i10;
        if (getOrientation() == 1) {
            setPaddingHorizontal(this.mVerticalLayoutPadding);
        }
    }

    public COUIButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isLimitHeight = false;
        this.isForceSmallScreenWidth = false;
        initResource();
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5167O);
            this.mHorizontalLayoutPadding = (int) obtainStyledAttributes.getDimension(o.f5183Q, this.mHorizontalLayoutPadding);
            this.mVerticalLayoutPadding = (int) obtainStyledAttributes.getDimension(o.f5191R, this.mVerticalLayoutPadding);
            this.mLimitMaxWidth = (int) obtainStyledAttributes.getDimension(o.f5175P, this.mLimitMaxWidth);
            obtainStyledAttributes.recycle();
        }
        setPaddingHorizontal(0);
    }
}
