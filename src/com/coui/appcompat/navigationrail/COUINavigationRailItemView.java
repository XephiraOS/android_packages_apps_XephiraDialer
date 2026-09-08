package com.coui.appcompat.navigationrail;

import Y8.d;
import Y8.f;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.P;
import androidx.core.view.K;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.reddot.COUIHintRedDot;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.uiutil.UIUtil;
import com.google.android.material.navigation.c;
import e4.g;

/* loaded from: classes.dex */
public class COUINavigationRailItemView extends c {
    private int bigOffsetHorizontal;
    private final TextView largeLabel;
    private COUIHintRedDot mCOUIHintRedDot;
    private int mDefRedDotOffset;
    private int mDefRedDotTextOffsetHorizontal;
    private int mDefRedDotTextOffsetVertical;
    private final RectF mItemRect;
    private int mMarginVertical;
    private FrameLayout mNavigationBarItemIconContainer;
    private ImageView mNavigationBarItemIconView;
    private FrameLayout mNavigationBarItemLabelsGroup;
    private Rect mRedDotRect;
    private ViewGroup.MarginLayoutParams mRootLayoutParams;
    private FrameLayout mRootView;
    private COUIStateEffectDrawable mStateEffectBackground;
    private int mTextMarginTop;
    private int mTextSize;
    private int[] offset;
    private final TextView smallLabel;
    private int smallOffsetHorizontal;

    public COUINavigationRailItemView(Context context) {
        super(context);
        this.mItemRect = new RectF();
        this.smallOffsetHorizontal = -2;
        this.bigOffsetHorizontal = 1;
        this.mDefRedDotTextOffsetVertical = getResources().getDimensionPixelSize(d.f5669y);
        this.mDefRedDotTextOffsetHorizontal = getResources().getDimensionPixelSize(d.f5668x);
        this.mDefRedDotOffset = getResources().getDimensionPixelSize(d.f5667w);
        this.offset = new int[2];
        this.smallLabel = (TextView) findViewById(g.f30856S);
        this.largeLabel = (TextView) findViewById(g.f30855R);
        this.mCOUIHintRedDot = (COUIHintRedDot) findViewById(f.f5681f);
        this.mNavigationBarItemIconView = (ImageView) findViewById(g.f30853P);
        this.mNavigationBarItemIconContainer = (FrameLayout) findViewById(g.f30852O);
        this.mNavigationBarItemLabelsGroup = (FrameLayout) findViewById(f.f5678c);
        this.mRootView = (FrameLayout) findViewById(f.f5677b);
        this.mMarginVertical = getResources().getDimensionPixelSize(d.f5655k);
        this.mTextMarginTop = getResources().getDimensionPixelSize(d.f5666v);
        setClipChildren(false);
        setClipToPadding(false);
        setTextSize(context.getResources().getDimensionPixelSize(d.f5665u));
        configStateEffectBackground();
    }

    private void configStateEffectBackground() {
        Drawable background;
        setDefaultFocusHighlightEnabled(false);
        float dimension = getContext().getResources().getDimension(d.f5647g);
        COUIMaskEffectDrawable cOUIMaskEffectDrawable = new COUIMaskEffectDrawable(getContext(), 1);
        cOUIMaskEffectDrawable.setMaskRect(this.mItemRect, dimension, dimension);
        cOUIMaskEffectDrawable.enableSelectedState(false);
        cOUIMaskEffectDrawable.setMinProgressForTouchEnterAnimation(0.0f);
        if (getBackground() == null) {
            background = new ColorDrawable(0);
        } else {
            background = getBackground();
        }
        this.mStateEffectBackground = new COUIStateEffectDrawable(new Drawable[]{background, cOUIMaskEffectDrawable});
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        super.setBackground(this.mStateEffectBackground);
    }

    private void getOffset(int[] iArr) {
        if (this.mCOUIHintRedDot.getPointMode() == 1) {
            int i10 = this.mDefRedDotOffset;
            iArr[1] = i10;
            iArr[0] = i10;
            return;
        }
        iArr[1] = this.mDefRedDotTextOffsetVertical;
        iArr[0] = this.mDefRedDotTextOffsetHorizontal;
        if (this.mCOUIHintRedDot.getPointNumber() >= 100 && this.mCOUIHintRedDot.getPointNumber() < 1000) {
            iArr[0] = iArr[0] + UIUtil.dip2px(getContext(), this.bigOffsetHorizontal);
        } else if (this.mCOUIHintRedDot.getPointNumber() > 0 && this.mCOUIHintRedDot.getPointNumber() < 10) {
            iArr[0] = iArr[0] + UIUtil.dip2px(getContext(), this.smallOffsetHorizontal);
        }
    }

    private void layoutRedDot() {
        if (this.mCOUIHintRedDot.getVisibility() == 8) {
            return;
        }
        if (this.mRedDotRect == null) {
            this.mRedDotRect = new Rect();
        }
        getOffset(this.offset);
        if (K.v(this) == 1) {
            this.mRedDotRect.set(this.mNavigationBarItemIconContainer.getLeft(), this.mNavigationBarItemIconContainer.getTop(), this.mNavigationBarItemIconContainer.getLeft() + this.mCOUIHintRedDot.getMeasuredWidth(), this.mNavigationBarItemIconContainer.getTop() + this.mCOUIHintRedDot.getMeasuredHeight());
            Rect rect = this.mRedDotRect;
            int[] iArr = this.offset;
            rect.offset(-iArr[0], -iArr[1]);
        } else {
            this.mRedDotRect.set(this.mNavigationBarItemIconContainer.getRight() - this.mCOUIHintRedDot.getMeasuredWidth(), this.mNavigationBarItemIconContainer.getTop(), this.mNavigationBarItemIconContainer.getRight(), this.mNavigationBarItemIconContainer.getTop() + this.mCOUIHintRedDot.getMeasuredHeight());
            Rect rect2 = this.mRedDotRect;
            int[] iArr2 = this.offset;
            rect2.offset(iArr2[0], -iArr2[1]);
        }
        COUIHintRedDot cOUIHintRedDot = this.mCOUIHintRedDot;
        Rect rect3 = this.mRedDotRect;
        cOUIHintRedDot.layout(rect3.left, rect3.top, rect3.right, rect3.bottom);
    }

    private void topToBottom() {
        int measuredWidth = (this.mRootView.getMeasuredWidth() / 2) - (this.mNavigationBarItemIconContainer.getMeasuredWidth() / 2);
        int measuredWidth2 = this.mNavigationBarItemIconContainer.getMeasuredWidth() + measuredWidth;
        int paddingTop = this.mMarginVertical + getPaddingTop();
        this.mNavigationBarItemIconContainer.layout(measuredWidth, paddingTop, measuredWidth2, this.mNavigationBarItemIconContainer.getMeasuredHeight() + paddingTop);
        int measuredWidth3 = (this.mRootView.getMeasuredWidth() / 2) - (this.mNavigationBarItemLabelsGroup.getMeasuredWidth() / 2);
        int measuredWidth4 = this.mNavigationBarItemLabelsGroup.getMeasuredWidth() + measuredWidth3;
        int bottom = this.mNavigationBarItemIconContainer.getBottom() + this.mTextMarginTop;
        this.mNavigationBarItemLabelsGroup.layout(measuredWidth3, bottom, measuredWidth4, this.mNavigationBarItemLabelsGroup.getMeasuredHeight() + bottom);
    }

    public COUIHintRedDot getCOUIHintRedDot() {
        return this.mCOUIHintRedDot;
    }

    @Override // com.google.android.material.navigation.c
    public int getItemDefaultMarginResId() {
        return d.f5664t;
    }

    @Override // com.google.android.material.navigation.c
    public int getItemLayoutResId() {
        return Y8.g.f5684c;
    }

    @Override // com.google.android.material.navigation.c, androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i10) {
        super.initialize(menuItemImpl, i10);
        P.a(this, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCOUIHintRedDot.setPointMode(0);
        this.mCOUIHintRedDot.setPointText("");
        this.mCOUIHintRedDot.setVisibility(4);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        topToBottom();
        layoutRedDot();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredHeight = this.mMarginVertical + this.mNavigationBarItemIconContainer.getMeasuredHeight() + this.mNavigationBarItemLabelsGroup.getMeasuredHeight() + this.mMarginVertical + this.mTextMarginTop;
        if (this.mRootView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRootView.getLayoutParams();
            this.mRootLayoutParams = marginLayoutParams;
            marginLayoutParams.height = measuredHeight;
            this.mRootView.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = this.mRootLayoutParams;
            measuredHeight += marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), measuredHeight);
    }

    @Override // com.google.android.material.navigation.c, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        RectF rectF = this.mItemRect;
        ViewGroup.MarginLayoutParams marginLayoutParams = this.mRootLayoutParams;
        rectF.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, i10 - marginLayoutParams.rightMargin, i11 - marginLayoutParams.bottomMargin);
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return false;
    }

    public void refresh() {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            cOUIStateEffectDrawable.refresh(getContext());
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            if (drawable == null) {
                cOUIStateEffectDrawable.setViewBackground(new ColorDrawable(0));
                return;
            } else {
                cOUIStateEffectDrawable.setViewBackground(drawable);
                return;
            }
        }
        super.setBackground(drawable);
    }

    public void setTextSize(int i10) {
        this.mTextSize = i10;
        this.smallLabel.setTextSize(0, i10);
        this.largeLabel.setTextSize(0, this.mTextSize);
    }
}
