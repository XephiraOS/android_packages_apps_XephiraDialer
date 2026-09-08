package com.coui.appcompat.cardview;

import a9.c;
import a9.m;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class COUICardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        CardViewApi21Impl cardViewApi21Impl = new CardViewApi21Impl();
        IMPL = cardViewApi21Impl;
        cardViewApi21Impl.initStatic();
    }

    public COUICardView(Context context) {
        super(context);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new CardViewDelegate() { // from class: com.coui.appcompat.cardview.COUICardView.1
            private Drawable mCardBackground;

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public View getCardView() {
                return COUICardView.this;
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return COUICardView.this.getPreventCornerOverlap();
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public boolean getUseCompatPadding() {
                return COUICardView.this.getUseCompatPadding();
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                COUICardView.this.setBackgroundDrawable(drawable);
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setMinWidthHeightInternal(int i10, int i11) {
                COUICardView cOUICardView = COUICardView.this;
                if (i10 > cOUICardView.mUserSetMinWidth) {
                    COUICardView.super.setMinimumWidth(i10);
                }
                COUICardView cOUICardView2 = COUICardView.this;
                if (i11 > cOUICardView2.mUserSetMinHeight) {
                    COUICardView.super.setMinimumHeight(i11);
                }
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setShadowPadding(int i10, int i11, int i12, int i13) {
                COUICardView.this.mShadowBounds.set(i10, i11, i12, i13);
                COUICardView cOUICardView = COUICardView.this;
                Rect rect = cOUICardView.mContentPadding;
                COUICardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
            }
        };
        initialize(context, null, 0);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i10) {
        int color;
        ColorStateList valueOf;
        float f10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6857h, i10, 0);
        int i11 = m.f6869k;
        if (obtainStyledAttributes.hasValue(i11)) {
            valueOf = obtainStyledAttributes.getColorStateList(i11);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(c.f6478b);
            } else {
                color = getResources().getColor(c.f6477a);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(m.f6873l, 0.0f);
        float f11 = obtainStyledAttributes.getFloat(m.f6913v, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(m.f6877m, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(m.f6881n, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(m.f6889p, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(m.f6885o, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(m.f6893q, 0);
        this.mContentPadding.left = obtainStyledAttributes.getDimensionPixelSize(m.f6901s, dimensionPixelSize);
        this.mContentPadding.top = obtainStyledAttributes.getDimensionPixelSize(m.f6909u, dimensionPixelSize);
        this.mContentPadding.right = obtainStyledAttributes.getDimensionPixelSize(m.f6905t, dimensionPixelSize);
        this.mContentPadding.bottom = obtainStyledAttributes.getDimensionPixelSize(m.f6897r, dimensionPixelSize);
        if (dimension2 > dimension3) {
            f10 = dimension2;
        } else {
            f10 = dimension3;
        }
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(m.f6861i, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(m.f6865j, 0);
        obtainStyledAttributes.recycle();
        IMPL.initialize(this.mCardViewDelegate, context, colorStateList, dimension, dimension2, f10, f11);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public float getWeight() {
        return IMPL.getWeight(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!(IMPL instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(i11)), mode2);
            }
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        IMPL.setElevation(this.mCardViewDelegate, f10);
    }

    public void setContentPadding(int i10, int i11, int i12, int i13) {
        this.mContentPadding.set(i10, i11, i12, i13);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f10) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.mUserSetMinHeight = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.mUserSetMinWidth = i10;
        super.setMinimumWidth(i10);
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z10;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f10) {
        IMPL.setRadius(this.mCardViewDelegate, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.mCompatPadding != z10) {
            this.mCompatPadding = z10;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }

    public void setWeight(float f10) {
        IMPL.setWeight(this.mCardViewDelegate, f10);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public COUICardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new CardViewDelegate() { // from class: com.coui.appcompat.cardview.COUICardView.1
            private Drawable mCardBackground;

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public View getCardView() {
                return COUICardView.this;
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return COUICardView.this.getPreventCornerOverlap();
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public boolean getUseCompatPadding() {
                return COUICardView.this.getUseCompatPadding();
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                COUICardView.this.setBackgroundDrawable(drawable);
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setMinWidthHeightInternal(int i10, int i11) {
                COUICardView cOUICardView = COUICardView.this;
                if (i10 > cOUICardView.mUserSetMinWidth) {
                    COUICardView.super.setMinimumWidth(i10);
                }
                COUICardView cOUICardView2 = COUICardView.this;
                if (i11 > cOUICardView2.mUserSetMinHeight) {
                    COUICardView.super.setMinimumHeight(i11);
                }
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setShadowPadding(int i10, int i11, int i12, int i13) {
                COUICardView.this.mShadowBounds.set(i10, i11, i12, i13);
                COUICardView cOUICardView = COUICardView.this;
                Rect rect = cOUICardView.mContentPadding;
                COUICardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
            }
        };
        initialize(context, attributeSet, 0);
    }

    public COUICardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new CardViewDelegate() { // from class: com.coui.appcompat.cardview.COUICardView.1
            private Drawable mCardBackground;

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public View getCardView() {
                return COUICardView.this;
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return COUICardView.this.getPreventCornerOverlap();
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public boolean getUseCompatPadding() {
                return COUICardView.this.getUseCompatPadding();
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                COUICardView.this.setBackgroundDrawable(drawable);
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setMinWidthHeightInternal(int i102, int i11) {
                COUICardView cOUICardView = COUICardView.this;
                if (i102 > cOUICardView.mUserSetMinWidth) {
                    COUICardView.super.setMinimumWidth(i102);
                }
                COUICardView cOUICardView2 = COUICardView.this;
                if (i11 > cOUICardView2.mUserSetMinHeight) {
                    COUICardView.super.setMinimumHeight(i11);
                }
            }

            @Override // com.coui.appcompat.cardview.CardViewDelegate
            public void setShadowPadding(int i102, int i11, int i12, int i13) {
                COUICardView.this.mShadowBounds.set(i102, i11, i12, i13);
                COUICardView cOUICardView = COUICardView.this;
                Rect rect = cOUICardView.mContentPadding;
                COUICardView.super.setPadding(i102 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
            }
        };
        initialize(context, attributeSet, i10);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }
}
