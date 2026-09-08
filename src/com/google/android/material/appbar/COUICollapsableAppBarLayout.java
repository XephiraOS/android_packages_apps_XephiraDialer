package com.google.android.material.appbar;

import X8.f;
import X8.h;
import X8.o;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.COUIDividerAppBarLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class COUICollapsableAppBarLayout extends COUIDividerAppBarLayout {
    private static boolean DEBUG = false;
    public static final int DEFAULT_SCROLL_FLAG = 19;
    public static final int MODE_COLLAPSABLE = 0;
    public static final int MODE_FIXED_COLLAPSED = 1;
    public static final int MODE_FIXED_EXPANDED = 2;
    private static final String MODE_STATE_KEY = "MODE_STATE_KEY";
    private static final String OFFSET_STATE_KEY = "OFFSET_STATE_KEY";
    private static final String SUPER_STATE_KEY = "SUPER_STATE_KEY";
    private static final String TAG = "COUICollapsableAppBarLayout";
    private static final String TITLE_FRACTION_STATE_KEY = "TITLE_FRACTION_STATE_KEY";
    private boolean mAutoExpand;
    private int mEndPaddingBottom;
    private int mMode;
    private boolean mNeedUpdateModeAfterOffsetChanged;
    private int mOffset;
    private int mStartPaddingBottom;
    private boolean mSubtitleHideEnable;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Mode {
    }

    /* loaded from: classes3.dex */
    public static class ScrollBehavior extends COUIDividerAppBarLayout.DividerBehavior {
        private int mLastStartedType;
        private boolean mShouldSnapToBottom;

        private ScrollBehavior() {
        }

        public boolean contentInScreen(View view) {
            if (!view.canScrollVertically(1) && !view.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.HeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            if (this.mShouldSnapToBottom) {
                this.mShouldSnapToBottom = false;
                return 0;
            }
            return super.getTopBottomOffsetForScrollingSibling();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.HeaderBehavior
        public boolean canDragView(AppBarLayout appBarLayout) {
            return super.canDragView((ScrollBehavior) appBarLayout) && (!(appBarLayout instanceof COUICollapsableAppBarLayout) || ((COUICollapsableAppBarLayout) appBarLayout).getMode() == 0);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            if ((view instanceof COUIRecyclerView) && view.getScrollY() < 0) {
                i11 = 0;
            }
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i10, i11, iArr, i12);
        }

        @Override // com.google.android.material.appbar.COUIDividerAppBarLayout.DividerBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i10, i11, i12, ((appBarLayout instanceof COUICollapsableAppBarLayout) && ((COUICollapsableAppBarLayout) appBarLayout).mMode == 1) ? 0 : i13, i14, iArr);
        }

        @Override // com.google.android.material.appbar.COUIDividerAppBarLayout.DividerBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
            this.mLastStartedType = i11;
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i10, i11);
        }

        @Override // com.google.android.material.appbar.COUIDividerAppBarLayout.DividerBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
            if (appBarLayout.getChildCount() > 0) {
                if (appBarLayout.getChildAt(0) instanceof COUICollapsingToolbarLayout) {
                    int scrollFlags = ((AppBarLayout.LayoutParams) appBarLayout.getChildAt(0).getLayoutParams()).getScrollFlags() & 17;
                    boolean z10 = scrollFlags == 17 && contentInScreen(view) && ((COUICollapsableAppBarLayout) appBarLayout).mCollapsable;
                    this.mShouldSnapToBottom = z10;
                    this.mShouldSnapToBottom = z10 && ((COUICollapsableAppBarLayout) appBarLayout).mAutoExpand;
                    if (COUICollapsableAppBarLayout.DEBUG) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("((mLastStartedType == ViewCompat.TYPE_TOUCH) || (type == ViewCompat.TYPE_NON_TOUCH)) = ");
                        sb.append(this.mLastStartedType == 0 || i10 == 1);
                        sb.append("\n((snapFlag & LayoutParams.FLAG_SNAP) == LayoutParams.FLAG_SNAP) = ");
                        sb.append(scrollFlags == 17);
                        sb.append("\n(contentInScreen(target)) = ");
                        sb.append(contentInScreen(view));
                        sb.append("\n(((COUICollapsableAppBarLayout) abl).mCollapsable = ");
                        sb.append(((COUICollapsableAppBarLayout) appBarLayout).mCollapsable);
                        Log.d(COUICollapsableAppBarLayout.TAG, sb.toString());
                    }
                }
            }
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i10);
        }
    }

    public COUICollapsableAppBarLayout(Context context) {
        this(context, null);
    }

    private void adjustPaddingBottom(int i10, boolean z10) {
        float totalScrollRange = getTotalScrollRange();
        if (!z10 && (totalScrollRange == 0.0f || this.mStartPaddingBottom == this.mEndPaddingBottom)) {
            return;
        }
        int i11 = this.mStartPaddingBottom;
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i11 + ((int) ((this.mEndPaddingBottom - i11) * (Math.abs(i10) / totalScrollRange))));
    }

    private void adjustSubtitleIfNeed(int i10) {
        boolean z10;
        View findSubtitleContentView = findSubtitleContentView();
        if (findSubtitleContentView != null && findSubtitleContentView.getVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (findCollapsingToolbarLayout() != null && z10) {
            float abs = Math.abs(i10) / getTotalScrollRange();
            float f10 = 1.0f;
            if (this.mSubtitleHideEnable) {
                f10 = 1.0f - abs;
            }
            int i11 = (int) (0 + ((-findSubtitleContentView.getMeasuredHeight()) * abs));
            ViewGroup.LayoutParams layoutParams = findSubtitleContentView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i11;
                if (COUIResponsiveUtils.isSmallScreen(getContext(), getMeasuredWidth())) {
                    marginLayoutParams.setMarginStart(getContext().getResources().getDimensionPixelOffset(f.f4738l6));
                } else if (COUIResponsiveUtils.isMediumScreen(getContext(), getMeasuredWidth())) {
                    marginLayoutParams.setMarginStart(getContext().getResources().getDimensionPixelOffset(f.f4754n6));
                } else if (COUIResponsiveUtils.isLargeScreen(getContext(), getMeasuredWidth())) {
                    marginLayoutParams.setMarginStart(getContext().getResources().getDimensionPixelOffset(f.f4746m6));
                } else {
                    marginLayoutParams.setMarginStart(0);
                }
            }
            findSubtitleContentView.setLayoutParams(layoutParams);
            findSubtitleContentView.setAlpha(f10);
        }
    }

    private View findCollapsingToolbarLayout() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof CollapsingToolbarLayout) {
                return childAt;
            }
        }
        return null;
    }

    private float getExpansionFraction() {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            return ((COUICollapsingToolbarLayout) findCollapsingToolbarLayout).collapsingTextHelper.getExpansionFraction();
        }
        return 0.0f;
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5406s0);
        this.mMode = obtainStyledAttributes.getInt(o.f5422u0, 0);
        this.mSubtitleHideEnable = obtainStyledAttributes.getBoolean(o.f5438w0, true);
        this.mStartPaddingBottom = obtainStyledAttributes.getDimensionPixelOffset(o.f5430v0, getContext().getResources().getDimensionPixelOffset(f.f4538L));
        this.mEndPaddingBottom = obtainStyledAttributes.getDimensionPixelOffset(o.f5414t0, getContext().getResources().getDimensionPixelOffset(f.f4531K));
        if (this.mMode == 0) {
            this.mCollapsable = true;
        }
        obtainStyledAttributes.recycle();
    }

    private boolean isCollapsed() {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            return ((COUICollapsingToolbarLayout) findCollapsingToolbarLayout).isCollapsed();
        }
        return false;
    }

    private boolean isExpanded() {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            return ((COUICollapsingToolbarLayout) findCollapsingToolbarLayout).isExpanded();
        }
        return false;
    }

    private void setScrollFlags(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.setScrollFlags(i10);
            childAt.setLayoutParams(layoutParams);
        }
    }

    private void updateIconViewLocationIfNeed(float f10) {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            COUICollapsingToolbarLayout cOUICollapsingToolbarLayout = (COUICollapsingToolbarLayout) findCollapsingToolbarLayout;
            cOUICollapsingToolbarLayout.collapsingTextHelper.setExpansionFraction(f10);
            cOUICollapsingToolbarLayout.updateIconViewLocationIfNeed();
        }
    }

    public void enableAutoExpand(boolean z10) {
        this.mAutoExpand = z10;
    }

    public View findSubtitleContentView() {
        return findViewById(h.f4950u);
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout, com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new ScrollBehavior();
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout
    public int getDividerScrollRange() {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout != null) {
            int i10 = this.mMode;
            if (i10 == 0) {
                return getTotalScrollRange();
            }
            if (i10 == 1) {
                return findCollapsingToolbarLayout.getMinimumHeight();
            }
        }
        return getMeasuredHeight();
    }

    public int getEndPaddingBottom() {
        return this.mEndPaddingBottom;
    }

    public int getMode() {
        return this.mMode;
    }

    public int getStartPaddingBottom() {
        return this.mStartPaddingBottom;
    }

    public boolean isSubtitleHideEnable() {
        return this.mSubtitleHideEnable;
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout, com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i10;
        super.onAttachedToWindow();
        if (this.mMode != 1 && !isCollapsed()) {
            i10 = this.mStartPaddingBottom;
        } else {
            i10 = this.mEndPaddingBottom;
        }
        setMode(this.mMode);
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i10);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        post(new Runnable() { // from class: com.google.android.material.appbar.c
            @Override // java.lang.Runnable
            public final void run() {
                COUICollapsableAppBarLayout.this.updateSubtitle();
            }
        });
    }

    @Override // com.google.android.material.appbar.AppBarLayout
    public void onOffsetChanged(int i10) {
        super.onOffsetChanged(i10);
        if (i10 == this.mOffset) {
            return;
        }
        if (this.mMode == 0) {
            this.mScrollDyByOffset = Math.max(0, -i10);
        }
        this.mOffset = i10;
        onDividerChanged();
        int i11 = this.mMode;
        if (i11 != 1) {
            if (i11 == 2) {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.mStartPaddingBottom);
            }
        } else {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.mEndPaddingBottom);
        }
        adjustPaddingBottom(i10, false);
        adjustSubtitleIfNeed(i10);
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            ((COUICollapsingToolbarLayout) findCollapsingToolbarLayout).updateIconViewLocationIfNeed();
            findCollapsingToolbarLayout.invalidate();
        }
        if (this.mNeedUpdateModeAfterOffsetChanged) {
            int i12 = this.mMode;
            if (i12 == 0) {
                this.mNeedUpdateModeAfterOffsetChanged = false;
            } else if (i12 == 1 && this.mOffset == (-getDividerScrollRange())) {
                updateIconViewLocationIfNeed(1.0f);
                this.mNeedUpdateModeAfterOffsetChanged = false;
            } else if (this.mMode == 2 && this.mOffset == 0) {
                setScrollFlags(0);
                updateIconViewLocationIfNeed(0.0f);
                this.mNeedUpdateModeAfterOffsetChanged = false;
            }
        }
        if (this.mTargetViewState == 2 && this.mOffset == (-getDividerScrollRange()) && !this.mTargetView.canScrollVertically(1) && !this.mTargetView.canScrollVertically(-1) && this.mMode == 0) {
            setExpanded(true);
        }
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mOffset = bundle.getInt(OFFSET_STATE_KEY);
            this.mMode = bundle.getInt(MODE_STATE_KEY);
            updateIconViewLocationIfNeed(bundle.getFloat(TITLE_FRACTION_STATE_KEY, 0.0f));
            parcelable = bundle.getParcelable(SUPER_STATE_KEY);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, super.onSaveInstanceState());
        bundle.putInt(OFFSET_STATE_KEY, this.mOffset);
        bundle.putInt(MODE_STATE_KEY, this.mMode);
        bundle.putFloat(TITLE_FRACTION_STATE_KEY, getExpansionFraction());
        return bundle;
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout
    public boolean refreshAppBar(View view) {
        boolean z10;
        boolean refreshAppBar = super.refreshAppBar(view);
        if (!view.canScrollVertically(1) && !view.canScrollVertically(-1) && this.mMode == 0 && isCollapsed() && this.mTargetViewState == 2) {
            setExpanded(true);
            z10 = true;
        } else {
            z10 = false;
        }
        if (refreshAppBar || z10) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void refreshExpand(View view) {
        if (!view.canScrollVertically(1) && !view.canScrollVertically(-1) && this.mMode == 0 && isCollapsed()) {
            setExpanded(true);
        }
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout
    public void reset() {
        super.reset();
        this.mCollapsable = true;
        setMode(0);
        setExpanded(true);
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout
    public void setDebug(boolean z10) {
        super.setDebug(z10);
        DEBUG = z10;
    }

    public void setEndPaddingBottom(int i10) {
        this.mEndPaddingBottom = i10;
        adjustPaddingBottom(this.mOffset, true);
    }

    public void setMode(int i10) {
        if (this.mMode == i10) {
            return;
        }
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    this.mCollapsable = false;
                    setExpanded(true);
                    this.mScrollDyByOffset = 0;
                    if (isExpanded()) {
                        setScrollFlags(0);
                        updateIconViewLocationIfNeed(0.0f);
                    } else {
                        this.mNeedUpdateModeAfterOffsetChanged = true;
                    }
                    onDividerChanged();
                }
            } else {
                this.mCollapsable = false;
                setExpanded(false);
                setScrollFlags(19);
                this.mScrollDyByOffset = 0;
                if (isCollapsed()) {
                    updateIconViewLocationIfNeed(1.0f);
                } else {
                    this.mNeedUpdateModeAfterOffsetChanged = true;
                }
                onDividerChanged();
            }
        } else {
            this.mCollapsable = true;
            setScrollFlags(19);
            if (this.mMode == 1) {
                if (this.mScrollDyByScroll > 0) {
                    this.mScrollDyByOffset -= this.mOffset;
                    onDividerChanged();
                } else {
                    setExpanded(true);
                }
            }
            if (this.mMode == 2 && this.mScrollDyByScroll > 0) {
                this.mScrollDyByOffset -= this.mOffset;
                setExpanded(false);
            }
        }
        this.mMode = i10;
    }

    public void setStartPaddingBottom(int i10) {
        this.mStartPaddingBottom = i10;
        adjustPaddingBottom(this.mOffset, true);
    }

    public void setSubtitleHideEnable(boolean z10) {
        if (this.mSubtitleHideEnable != z10) {
            this.mSubtitleHideEnable = z10;
            updateSubtitle();
        }
    }

    public void updateSubtitle() {
        adjustSubtitleIfNeed(this.mOffset);
    }

    public COUICollapsableAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 0;
        this.mAutoExpand = true;
        this.mNeedUpdateModeAfterOffsetChanged = false;
        init(attributeSet);
    }

    public COUICollapsableAppBarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMode = 0;
        this.mAutoExpand = true;
        this.mNeedUpdateModeAfterOffsetChanged = false;
        init(attributeSet);
    }
}
