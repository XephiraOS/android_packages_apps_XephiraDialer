package com.coui.appcompat.tablayout;

import Y8.d;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.K;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.window.WindowWidthSizeClass;

/* loaded from: classes3.dex */
public class COUIPercentTabWithSearchView extends FrameLayout {
    private static final int MAX_CHILD_COUNT = 2;
    private static final int RESPONSIVE_WIDTH_TYPE_COMPAT = 0;
    private static final int RESPONSIVE_WIDTH_TYPE_EXPANDED = 2;
    private static final int RESPONSIVE_WIDTH_TYPE_MEDIUM = 1;
    private int mHorizontalPaddingInLargerScreen;
    private ResponsiveUIModel mResponsiveUIModel;
    private int mResponsiveWidthSize;
    private final int[] mSearchBarPaddingEnd;
    private final int[] mSearchBarPaddingStart;
    private WindowWidthSizeClass mWindowSize;

    public COUIPercentTabWithSearchView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        initAttr();
        this.mResponsiveUIModel = new ResponsiveUIModel(context, 0, 0);
    }

    private void initAttr() {
        if (getContext() != null) {
            this.mHorizontalPaddingInLargerScreen = getContext().getResources().getDimensionPixelSize(d.f5638b0);
        }
    }

    private void layoutSearchBarAndTabLayout(View view, View view2) {
        int calculateWidth;
        int gutter;
        int calculateWidth2;
        int gutter2;
        int i10;
        boolean z10 = true;
        if (K.v(this) != 1) {
            z10 = false;
        }
        WindowWidthSizeClass windowWidthSizeClass = this.mWindowSize;
        if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
            if (view != null) {
                i10 = view.getHeight();
                view.layout(0, 0, view.getWidth(), i10);
            } else {
                i10 = 0;
            }
            if (view2 != null) {
                view2.layout(0, i10, view2.getWidth(), view2.getHeight() + i10);
                return;
            }
            return;
        }
        if (z10) {
            if (view2 != null) {
                if (windowWidthSizeClass == WindowWidthSizeClass.Medium) {
                    view2.layout(getMeasuredWidth() - view2.getWidth(), (getMeasuredHeight() - view2.getHeight()) / 2, getMeasuredWidth(), view2.getHeight() + ((getMeasuredHeight() - view2.getHeight()) / 2));
                } else {
                    view2.layout((getMeasuredWidth() - view2.getWidth()) - this.mHorizontalPaddingInLargerScreen, (getMeasuredHeight() - view2.getHeight()) / 2, getMeasuredWidth() - this.mHorizontalPaddingInLargerScreen, view2.getHeight() + ((getMeasuredHeight() - view2.getHeight()) / 2));
                }
            }
            if (this.mWindowSize == WindowWidthSizeClass.Medium) {
                calculateWidth2 = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
                gutter2 = this.mResponsiveUIModel.gutter();
            } else {
                calculateWidth2 = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 8, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
                gutter2 = this.mResponsiveUIModel.gutter();
            }
            int measuredWidth = getMeasuredWidth() - (calculateWidth2 + gutter2);
            if (view != null) {
                view.layout(measuredWidth - view.getWidth(), 0, measuredWidth, view.getHeight());
                return;
            }
            return;
        }
        if (view2 != null) {
            if (windowWidthSizeClass == WindowWidthSizeClass.Medium) {
                view2.layout(0, (getMeasuredHeight() - view2.getHeight()) / 2, view2.getWidth(), view2.getHeight() + ((getMeasuredHeight() - view2.getHeight()) / 2));
            } else {
                view2.layout(this.mHorizontalPaddingInLargerScreen, (getMeasuredHeight() - view2.getHeight()) / 2, view2.getWidth() + this.mHorizontalPaddingInLargerScreen, view2.getHeight() + ((getMeasuredHeight() - view2.getHeight()) / 2));
            }
        }
        if (this.mWindowSize == WindowWidthSizeClass.Medium) {
            calculateWidth = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
            gutter = this.mResponsiveUIModel.gutter();
        } else {
            calculateWidth = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 8, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
            gutter = this.mResponsiveUIModel.gutter();
        }
        int i11 = calculateWidth + gutter;
        if (view != null) {
            view.layout(i11, 0, view.getWidth() + i11, view.getHeight());
        }
    }

    private void layoutToolbarAndTabLayout(View view, View view2) {
        int calculateWidth;
        int gutter;
        int calculateWidth2;
        int gutter2;
        int i10;
        boolean z10 = true;
        if (K.v(this) != 1) {
            z10 = false;
        }
        WindowWidthSizeClass windowWidthSizeClass = this.mWindowSize;
        if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
            if (view != null) {
                i10 = view.getHeight();
                if (z10) {
                    view.layout(0, 0, view.getWidth(), i10);
                } else {
                    view.layout(this.mResponsiveUIModel.margin(), 0, this.mResponsiveUIModel.margin() + view.getWidth(), i10);
                }
            } else {
                i10 = 0;
            }
            if (view2 != null) {
                view2.layout(0, i10, view2.getWidth(), view2.getHeight() + i10);
                return;
            }
            return;
        }
        if (z10) {
            if (view2 != null) {
                if (windowWidthSizeClass == WindowWidthSizeClass.Medium) {
                    view2.layout(getMeasuredWidth() - view2.getWidth(), (getMeasuredHeight() - view2.getHeight()) / 2, getMeasuredWidth(), view2.getHeight() + ((getMeasuredHeight() - view2.getHeight()) / 2));
                } else {
                    view2.layout((getMeasuredWidth() - view2.getWidth()) - this.mHorizontalPaddingInLargerScreen, (getMeasuredHeight() - view2.getHeight()) / 2, getMeasuredWidth() - this.mHorizontalPaddingInLargerScreen, view2.getHeight() + ((getMeasuredHeight() - view2.getHeight()) / 2));
                }
            }
            if (this.mWindowSize == WindowWidthSizeClass.Medium) {
                calculateWidth2 = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
                gutter2 = this.mResponsiveUIModel.gutter();
            } else {
                calculateWidth2 = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 8, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
                gutter2 = this.mResponsiveUIModel.gutter();
            }
            int measuredWidth = getMeasuredWidth() - (calculateWidth2 + gutter2);
            if (view != null) {
                view.layout(measuredWidth - view.getWidth(), 0, measuredWidth, view.getHeight());
                return;
            }
            return;
        }
        if (view2 != null) {
            if (windowWidthSizeClass == WindowWidthSizeClass.Medium) {
                view2.layout(0, (getMeasuredHeight() - view2.getHeight()) / 2, view2.getWidth(), view2.getHeight() + ((getMeasuredHeight() - view2.getHeight()) / 2));
            } else {
                view2.layout(this.mHorizontalPaddingInLargerScreen, (getMeasuredHeight() - view2.getHeight()) / 2, view2.getWidth() + this.mHorizontalPaddingInLargerScreen, view2.getHeight() + ((getMeasuredHeight() - view2.getHeight()) / 2));
            }
        }
        if (this.mWindowSize == WindowWidthSizeClass.Medium) {
            calculateWidth = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
            gutter = this.mResponsiveUIModel.gutter();
        } else {
            calculateWidth = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 8, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
            gutter = this.mResponsiveUIModel.gutter();
        }
        int i11 = calculateWidth + gutter;
        if (view != null) {
            view.layout(i11, 0, view.getWidth() + i11, view.getHeight());
        }
    }

    private void measureSearchBar(int i10, int i11, View view) {
        int calculateWidth;
        if (this.mWindowSize == WindowWidthSizeClass.Compact) {
            calculateWidth = getMeasuredWidth();
        } else {
            calculateWidth = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
        }
        int[] iArr = this.mSearchBarPaddingStart;
        int i12 = this.mResponsiveWidthSize;
        view.setPaddingRelative(iArr[i12], 0, this.mSearchBarPaddingEnd[i12], 0);
        measureChild(view, ViewGroup.getChildMeasureSpec(i10, 0, Math.min(getMeasuredWidth(), calculateWidth)), ViewGroup.getChildMeasureSpec(i11, 0, getMeasuredHeight()));
    }

    private void measureTabLayout(int i10, int i11, View view) {
        int i12;
        int margin;
        WindowWidthSizeClass windowWidthSizeClass = this.mWindowSize;
        if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
            margin = (int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 1, 0, getContext());
        } else {
            if (windowWidthSizeClass == WindowWidthSizeClass.Medium) {
                i12 = (int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 0, 0, getContext());
            } else if (windowWidthSizeClass == WindowWidthSizeClass.Expanded) {
                i12 = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 8, 0, 0, getContext())) - this.mHorizontalPaddingInLargerScreen;
            } else {
                i12 = 0;
            }
            margin = i12 + this.mResponsiveUIModel.margin();
        }
        measureChild(view, ViewGroup.getChildMeasureSpec(i10, 0, Math.min(getMeasuredWidth(), margin)), ViewGroup.getChildMeasureSpec(i11, 0, getMeasuredHeight()));
    }

    private void measureToolbar(int i10, int i11, View view) {
        int calculateWidth;
        if (this.mWindowSize == WindowWidthSizeClass.Compact) {
            calculateWidth = ((int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 0, 0, getContext())) + this.mResponsiveUIModel.margin();
        } else {
            calculateWidth = (int) COUIResponsiveUtils.calculateWidth(getMeasuredWidth(), 4, 0, 0, getContext());
            if (this.mWindowSize == WindowWidthSizeClass.Expanded) {
                calculateWidth -= this.mHorizontalPaddingInLargerScreen;
            }
        }
        measureChild(view, ViewGroup.getChildMeasureSpec(i10, 0, Math.min(getMeasuredWidth(), calculateWidth + this.mResponsiveUIModel.margin())), ViewGroup.getChildMeasureSpec(i11, 0, getMeasuredHeight()));
    }

    private void updateResponsiveUI() {
        int measuredWidth = getMeasuredWidth();
        this.mResponsiveUIModel.rebuild(measuredWidth, 0).chooseMargin(MarginType.MARGIN_SMALL);
        this.mWindowSize = this.mResponsiveUIModel.windowSizeClass().getWindowWidthSizeClass();
        if (COUIResponsiveUtils.isSmallScreen(getContext(), measuredWidth)) {
            this.mResponsiveWidthSize = 0;
        } else if (COUIResponsiveUtils.isMediumScreen(getContext(), measuredWidth)) {
            this.mResponsiveWidthSize = 1;
        } else if (COUIResponsiveUtils.isLargeScreen(getContext(), measuredWidth)) {
            this.mResponsiveWidthSize = 2;
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mResponsiveUIModel.onConfigurationChanged(configuration);
        this.mResponsiveUIModel.chooseMargin(MarginType.MARGIN_SMALL);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i14 = 0; i14 < childCount && i14 < 2; i14++) {
            View childAt = getChildAt(i14);
            if (childAt instanceof COUIToolbar) {
                view = childAt;
            } else if (childAt instanceof COUITabLayout) {
                view3 = childAt;
            } else if (childAt instanceof COUISearchBar) {
                view2 = childAt;
            }
        }
        if (view2 == null) {
            layoutToolbarAndTabLayout(view, view3);
        } else {
            layoutSearchBarAndTabLayout(view2, view3);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        updateResponsiveUI();
        int childCount = getChildCount();
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount && i15 < 2; i15++) {
            View childAt = getChildAt(i15);
            if (childAt instanceof COUIToolbar) {
                measureToolbar(i10, i11, childAt);
                i13 = childAt.getMeasuredHeight();
            } else if (childAt instanceof COUITabLayout) {
                measureTabLayout(i10, i11, childAt);
                i12 = childAt.getMeasuredHeight();
            } else if (childAt instanceof COUISearchBar) {
                ((COUISearchBar) childAt).setUseResponsivePadding(false);
                measureSearchBar(i10, i11, childAt);
                i14 = childAt.getMeasuredHeight();
                z10 = true;
            }
        }
        if (this.mWindowSize == WindowWidthSizeClass.Compact) {
            int resolveSizeAndState = View.resolveSizeAndState(View.MeasureSpec.getSize(i10), i10, 0);
            if (z10) {
                i13 = i14;
            }
            setMeasuredDimension(resolveSizeAndState, i13 + i12);
            return;
        }
        int resolveSizeAndState2 = View.resolveSizeAndState(View.MeasureSpec.getSize(i10), i10, 0);
        if (z10) {
            i13 = i14;
        }
        setMeasuredDimension(resolveSizeAndState2, Math.max(i12, i13));
    }

    public COUIPercentTabWithSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIPercentTabWithSearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mWindowSize = WindowWidthSizeClass.Compact;
        this.mResponsiveWidthSize = 0;
        this.mSearchBarPaddingStart = new int[]{getContext().getResources().getDimensionPixelOffset(d.f5633Y), getContext().getResources().getDimensionPixelOffset(d.f5636a0), getContext().getResources().getDimensionPixelOffset(d.f5634Z)};
        this.mSearchBarPaddingEnd = new int[]{getContext().getResources().getDimensionPixelOffset(d.f5630V), getContext().getResources().getDimensionPixelOffset(d.f5632X), getContext().getResources().getDimensionPixelOffset(d.f5631W)};
        init(context);
    }
}
