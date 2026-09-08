package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.K;
import androidx.core.view.X;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;
import e4.C0977c;
import e4.C0979e;
import e4.l;
import e4.m;
import f4.C1001b;
import u4.C1607c;

/* loaded from: classes3.dex */
public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    static final int MAX_ITEM_COUNT = 7;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    private View headerView;
    private Boolean paddingBottomSystemWindowInsets;
    private Boolean paddingStartSystemWindowInsets;
    private Boolean paddingTopSystemWindowInsets;
    private final int topMargin;

    /* loaded from: classes3.dex */
    public class a implements ViewUtils.OnApplyWindowInsetsListener {
        public a() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public X onApplyWindowInsets(View view, X x10, ViewUtils.RelativePadding relativePadding) {
            int i10;
            B.b f10 = x10.f(X.k.f());
            NavigationRailView navigationRailView = NavigationRailView.this;
            if (navigationRailView.shouldApplyWindowInsetPadding(navigationRailView.paddingTopSystemWindowInsets)) {
                relativePadding.top += f10.f208b;
            }
            NavigationRailView navigationRailView2 = NavigationRailView.this;
            if (navigationRailView2.shouldApplyWindowInsetPadding(navigationRailView2.paddingBottomSystemWindowInsets)) {
                relativePadding.bottom += f10.f210d;
            }
            NavigationRailView navigationRailView3 = NavigationRailView.this;
            if (navigationRailView3.shouldApplyWindowInsetPadding(navigationRailView3.paddingStartSystemWindowInsets)) {
                int i11 = relativePadding.start;
                if (ViewUtils.isLayoutRtl(view)) {
                    i10 = f10.f209c;
                } else {
                    i10 = f10.f207a;
                }
                relativePadding.start = i11 + i10;
            }
            relativePadding.applyToView(view);
            return x10;
        }
    }

    public NavigationRailView(Context context) {
        this(context, null);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new a());
    }

    private b getNavigationRailMenuView() {
        return (b) getMenuView();
    }

    private boolean isHeaderViewVisible() {
        View view = this.headerView;
        if (view != null && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private int makeMinWidthSpec(int i10) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i10) != 1073741824 && suggestedMinimumWidth > 0) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldApplyWindowInsetPadding(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return K.s(this);
    }

    public void addHeaderView(int i10) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, false));
    }

    public View getHeaderView() {
        return this.headerView;
    }

    public int getItemMinimumHeight() {
        return ((b) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        b navigationRailMenuView = getNavigationRailMenuView();
        int i14 = 0;
        if (isHeaderViewVisible()) {
            int bottom = this.headerView.getBottom() + this.topMargin;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i14 = bottom - top;
            }
        } else if (navigationRailMenuView.isTopGravity()) {
            i14 = this.topMargin;
        }
        if (i14 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i14, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i14);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int makeMinWidthSpec = makeMinWidthSpec(i10);
        super.onMeasure(makeMinWidthSpec, i11);
        if (isHeaderViewVisible()) {
            measureChild(getNavigationRailMenuView(), makeMinWidthSpec, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, Integer.MIN_VALUE));
        }
    }

    public void removeHeaderView() {
        View view = this.headerView;
        if (view != null) {
            removeView(view);
            this.headerView = null;
        }
    }

    public void setItemMinimumHeight(int i10) {
        ((b) getMenuView()).setItemMinimumHeight(i10);
    }

    public void setMenuGravity(int i10) {
        getNavigationRailMenuView().setMenuGravity(i10);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30672i0);
    }

    public void addHeaderView(View view) {
        removeHeaderView();
        this.headerView = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.topMargin;
        addView(view, 0, layoutParams);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public b createNavigationBarMenuView(Context context) {
        return new b(context);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, l.f31011M);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.topMargin = getResources().getDimensionPixelSize(C0979e.f30732E0);
        Context context2 = getContext();
        androidx.appcompat.widget.K obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, m.f31446k7, i10, i11, new int[0]);
        int n10 = obtainTintedStyledAttributes.n(m.f31457l7, 0);
        if (n10 != 0) {
            addHeaderView(n10);
        }
        setMenuGravity(obtainTintedStyledAttributes.k(m.f31479n7, 49));
        int i12 = m.f31468m7;
        if (obtainTintedStyledAttributes.s(i12)) {
            setItemMinimumHeight(obtainTintedStyledAttributes.f(i12, -1));
        }
        int i13 = m.f31512q7;
        if (obtainTintedStyledAttributes.s(i13)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.a(i13, false));
        }
        int i14 = m.f31490o7;
        if (obtainTintedStyledAttributes.s(i14)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.a(i14, false));
        }
        int i15 = m.f31501p7;
        if (obtainTintedStyledAttributes.s(i15)) {
            this.paddingStartSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.a(i15, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(C0979e.f30743K);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(C0979e.f30741J);
        float b10 = C1001b.b(0.0f, 1.0f, 0.3f, 1.0f, C1607c.f(context2) - 1.0f);
        float c10 = C1001b.c(getItemPaddingTop(), dimensionPixelOffset, b10);
        float c11 = C1001b.c(getItemPaddingBottom(), dimensionPixelOffset2, b10);
        setItemPaddingTop(Math.round(c10));
        setItemPaddingBottom(Math.round(c11));
        obtainTintedStyledAttributes.y();
        applyWindowInsets();
    }
}
