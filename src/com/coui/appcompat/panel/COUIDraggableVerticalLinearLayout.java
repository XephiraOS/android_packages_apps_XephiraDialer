package com.coui.appcompat.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c9.C0569a;
import c9.C0572d;
import c9.C0573e;
import c9.C0576h;
import c9.C0577i;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import f.C0991a;

/* loaded from: classes.dex */
public class COUIDraggableVerticalLinearLayout extends LinearLayout {
    private ImageView mAnimDragView;
    private Drawable mDragViewDrawable;
    private int mDragViewDrawableTintColor;
    private float mElevation;
    private boolean mHasShadowNinePatchDrawable;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mStyle;

    public COUIDraggableVerticalLinearLayout(Context context) {
        this(context, null);
    }

    private void initDragView(AttributeSet attributeSet, int i10, int i11) {
        setOrientation(1);
        this.mAnimDragView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(C0572d.f12899v), (int) getResources().getDimension(C0572d.f12896s));
        layoutParams.gravity = 1;
        this.mAnimDragView.setLayoutParams(layoutParams);
        COUIDarkModeUtil.setForceDarkAllow(this.mAnimDragView, false);
        setDragViewByTypeArray(getContext().obtainStyledAttributes(attributeSet, C0577i.f12942i, i10, i11));
        if (attributeSet != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            this.mStyle = styleAttribute;
            if (styleAttribute == 0) {
                this.mStyle = i10;
            }
        } else {
            this.mStyle = i10;
        }
        recordPaddingAndElevation();
        addView(this.mAnimDragView);
    }

    private void recordPaddingAndElevation() {
        this.mElevation = getElevation();
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingBottom = getPaddingBottom();
    }

    private void setDragViewByTypeArray(TypedArray typedArray) {
        if (typedArray != null) {
            this.mHasShadowNinePatchDrawable = typedArray.getBoolean(C0577i.f12945l, false);
            int resourceId = typedArray.getResourceId(C0577i.f12943j, C0573e.f12906c);
            int color = typedArray.getColor(C0577i.f12944k, COUIContextUtil.getAttrColor(getContext(), X8.c.f4394n));
            typedArray.recycle();
            Drawable b10 = C0991a.b(getContext(), resourceId);
            if (b10 != null) {
                b10.setTint(color);
                this.mAnimDragView.setImageDrawable(b10);
            }
            if (this.mHasShadowNinePatchDrawable) {
                setBackground(getContext().getDrawable(C0573e.f12904a));
            } else {
                setBackground(getContext().getDrawable(C0573e.f12905b));
            }
        }
    }

    public ImageView getDragView() {
        return this.mAnimDragView;
    }

    @Deprecated
    public boolean isHasShadowNinePatchDrawable() {
        return this.mHasShadowNinePatchDrawable;
    }

    public void refresh() {
        TypedArray typedArray = null;
        if (this.mStyle != 0) {
            String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
            if (TextUtils.equals(resourceTypeName, "attr")) {
                typedArray = getContext().getTheme().obtainStyledAttributes(null, C0577i.f12942i, this.mStyle, 0);
            } else if (TextUtils.equals(resourceTypeName, "style")) {
                typedArray = getContext().getTheme().obtainStyledAttributes(null, C0577i.f12942i, 0, this.mStyle);
            }
        }
        setDragViewByTypeArray(typedArray);
        setBackground(getContext().getResources().getDrawable(C0573e.f12904a));
    }

    public void setDragViewDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mDragViewDrawable = drawable;
            this.mAnimDragView.setImageDrawable(drawable);
        }
    }

    public void setDragViewDrawableTintColor(int i10) {
        Drawable drawable = this.mDragViewDrawable;
        if (drawable != null && this.mDragViewDrawableTintColor != i10) {
            this.mDragViewDrawableTintColor = i10;
            drawable.setTint(i10);
            this.mAnimDragView.setImageDrawable(this.mDragViewDrawable);
        }
    }

    @Deprecated
    public void setHasShadowNinePatchDrawable(boolean z10) {
        this.mHasShadowNinePatchDrawable = z10;
        if (z10) {
            setBackground(getContext().getDrawable(C0573e.f12904a));
            setElevation(0.0f);
        } else {
            setBackground(getContext().getDrawable(C0573e.f12905b));
            setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
            setElevation(this.mElevation);
        }
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        super.setOrientation(1);
    }

    public COUIDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0569a.f12868b);
    }

    public COUIDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, COUIContextUtil.isCOUIDarkTheme(context) ? C0576h.f12932b : C0576h.f12931a);
    }

    public COUIDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mHasShadowNinePatchDrawable = false;
        this.mElevation = 0.0f;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        initDragView(attributeSet, i10, i11);
    }
}
