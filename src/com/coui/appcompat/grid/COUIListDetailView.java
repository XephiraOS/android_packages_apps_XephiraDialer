package com.coui.appcompat.grid;

import X8.c;
import X8.f;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.K;
import androidx.fragment.app.FragmentContainerView;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.window.WindowSizeClass;
import com.coui.component.responsiveui.window.WindowWidthSizeClass;

/* loaded from: classes.dex */
public class COUIListDetailView extends FrameLayout {
    private static final float DEFAULT_MAIN_WIDTH_PERCENT = 0.4f;
    private View mDivider;
    private int mDividerColor;
    private FragmentContainerView mEmptyPageFragment;
    private int mGapWidth;
    private FragmentContainerView mMainFragment;
    private float mMainFragmentPercent;
    private int mMaxMainFragmentWidth;
    private int mMinMainFragmentWidth;
    private FragmentContainerView mSubFragment;

    public COUIListDetailView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mMainFragment = new FragmentContainerView(context);
        this.mSubFragment = new FragmentContainerView(context);
        this.mEmptyPageFragment = new FragmentContainerView(context);
        this.mDivider = new View(context);
        addView(this.mEmptyPageFragment);
        addView(this.mMainFragment);
        addView(this.mDivider);
        addView(this.mSubFragment);
        this.mEmptyPageFragment.setId(View.generateViewId());
        this.mMainFragment.setId(View.generateViewId());
        this.mSubFragment.setId(View.generateViewId());
        int attrColor = COUIContextUtil.getAttrColor(getContext(), c.f4400q);
        this.mDividerColor = attrColor;
        setDividerColor(attrColor);
        COUIDarkModeUtil.setForceDarkAllow(this.mDivider, false);
        this.mMaxMainFragmentWidth = context.getResources().getDimensionPixelSize(f.f4513H2);
        this.mMinMainFragmentWidth = context.getResources().getDimensionPixelSize(f.f4520I2);
        this.mGapWidth = context.getResources().getDimensionPixelSize(f.f4817w1);
    }

    public FrameLayout getEmptyPageFragmentContainer() {
        return this.mEmptyPageFragment;
    }

    public FrameLayout getMainFragmentContainer() {
        return this.mMainFragment;
    }

    public FrameLayout getSubFragmentContainer() {
        return this.mSubFragment;
    }

    public boolean isInSplitMode() {
        WindowSizeClass.Companion companion = WindowSizeClass.Companion;
        Dp.Companion companion2 = Dp.Companion;
        if (companion.calculateFromSize(companion2.pixel2Dp(getContext(), Math.abs(getWidth())), companion2.pixel2Dp(getContext(), Math.abs(getWidth()))).getWindowWidthSizeClass() != WindowWidthSizeClass.Compact) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int attrColor = COUIContextUtil.getAttrColor(getContext(), c.f4400q);
        this.mDividerColor = attrColor;
        setDividerColor(attrColor);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (K.v(this) != 1) {
            z11 = false;
        }
        WindowSizeClass.Companion companion = WindowSizeClass.Companion;
        Dp.Companion companion2 = Dp.Companion;
        WindowWidthSizeClass windowWidthSizeClass = companion.calculateFromSize(companion2.pixel2Dp(getContext(), Math.abs(getWidth())), companion2.pixel2Dp(getContext(), Math.abs(getWidth()))).getWindowWidthSizeClass();
        if (z11) {
            if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
                this.mEmptyPageFragment.setVisibility(8);
                FragmentContainerView fragmentContainerView = this.mMainFragment;
                fragmentContainerView.layout(0, 0, fragmentContainerView.getWidth(), this.mMainFragment.getHeight());
                FragmentContainerView fragmentContainerView2 = this.mSubFragment;
                fragmentContainerView2.layout(0, 0, fragmentContainerView2.getWidth(), this.mSubFragment.getHeight());
                return;
            }
            this.mEmptyPageFragment.setVisibility(0);
            this.mEmptyPageFragment.layout(0, 0, this.mSubFragment.getWidth(), this.mSubFragment.getHeight());
            FragmentContainerView fragmentContainerView3 = this.mSubFragment;
            fragmentContainerView3.layout(0, 0, fragmentContainerView3.getWidth(), this.mSubFragment.getHeight());
            this.mDivider.layout(this.mSubFragment.getWidth(), 0, this.mSubFragment.getWidth() + this.mDivider.getWidth(), this.mDivider.getHeight());
            this.mMainFragment.layout(this.mSubFragment.getWidth() + this.mDivider.getWidth(), 0, this.mSubFragment.getWidth() + this.mDivider.getWidth() + this.mMainFragment.getWidth(), this.mMainFragment.getHeight());
            return;
        }
        if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
            this.mEmptyPageFragment.setVisibility(8);
            FragmentContainerView fragmentContainerView4 = this.mMainFragment;
            fragmentContainerView4.layout(0, 0, fragmentContainerView4.getWidth(), this.mMainFragment.getHeight());
            FragmentContainerView fragmentContainerView5 = this.mSubFragment;
            fragmentContainerView5.layout(0, 0, fragmentContainerView5.getWidth(), this.mSubFragment.getHeight());
            return;
        }
        this.mEmptyPageFragment.setVisibility(0);
        this.mEmptyPageFragment.layout(this.mMainFragment.getWidth() + this.mDivider.getWidth(), 0, this.mMainFragment.getWidth() + this.mDivider.getWidth() + this.mSubFragment.getWidth(), this.mSubFragment.getHeight());
        FragmentContainerView fragmentContainerView6 = this.mMainFragment;
        fragmentContainerView6.layout(0, 0, fragmentContainerView6.getWidth(), this.mMainFragment.getHeight());
        this.mDivider.layout(this.mMainFragment.getWidth(), 0, this.mMainFragment.getWidth() + this.mDivider.getWidth(), this.mDivider.getHeight());
        this.mSubFragment.layout(this.mMainFragment.getWidth() + this.mDivider.getWidth(), 0, this.mMainFragment.getWidth() + this.mDivider.getWidth() + this.mSubFragment.getWidth(), this.mSubFragment.getHeight());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int min;
        int i12;
        int i13;
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        WindowSizeClass.Companion companion = WindowSizeClass.Companion;
        Dp.Companion companion2 = Dp.Companion;
        WindowWidthSizeClass windowWidthSizeClass = companion.calculateFromSize(companion2.pixel2Dp(getContext(), Math.abs(measuredWidth)), companion2.pixel2Dp(getContext(), Math.abs(measuredWidth))).getWindowWidthSizeClass();
        int max = (int) Math.max(Math.min(measuredWidth * this.mMainFragmentPercent, this.mMaxMainFragmentWidth), this.mMinMainFragmentWidth);
        if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
            min = measuredWidth;
            i12 = min;
            i13 = 0;
        } else {
            min = Math.min(Math.max(max, this.mMinMainFragmentWidth), this.mMaxMainFragmentWidth);
            i12 = measuredWidth - min;
            i13 = this.mGapWidth;
        }
        measureChild(this.mMainFragment, ViewGroup.getChildMeasureSpec(i10, 0, Math.min(measuredWidth, min)), i11);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, 0, i12);
        measureChild(this.mSubFragment, childMeasureSpec, i11);
        measureChild(this.mEmptyPageFragment, childMeasureSpec, i11);
        measureChild(this.mDivider, ViewGroup.getChildMeasureSpec(i10, 0, i13), i11);
    }

    public void setDividerColor(int i10) {
        this.mDividerColor = i10;
        this.mDivider.setBackgroundColor(i10);
    }

    public void setMainFragmentPercent(float f10) {
        this.mMainFragmentPercent = f10;
        requestLayout();
    }

    public COUIListDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIListDetailView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMainFragmentPercent = DEFAULT_MAIN_WIDTH_PERCENT;
        init(context);
    }
}
