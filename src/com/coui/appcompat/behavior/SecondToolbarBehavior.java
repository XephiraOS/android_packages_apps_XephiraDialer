package com.coui.appcompat.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b9.C0533c;
import b9.C0535e;
import b9.C0537g;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public class SecondToolbarBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {
    private View mChild;
    private int mCountOffset;
    private int mCurrentOffset;
    private View mDivider;
    private int mDividerAlphaChangeEndY;
    private int mDividerAlphaChangeOffset;
    private float mDividerAlphaRange;
    public int mDividerInitWidth;
    private ViewGroup.LayoutParams mDividerParams;
    private int mDividerWidthChangeEndY;
    private int mDividerWidthChangeInitY;
    private int mDividerWidthChangeOffset;
    private float mDividerWidthRange;
    private boolean mIsImmerSiveTheme;
    private int mListFirstChildInitY;
    private int[] mLocation;
    private int mMarginLeftRight;
    private int mMaxWidth;
    private int mNewOffset;
    private Resources mResources;
    private View mScrollView;

    public SecondToolbarBehavior() {
        this.mLocation = new int[2];
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.mResources = resources;
        this.mMarginLeftRight = resources.getDimensionPixelOffset(C0535e.f12422n0);
        this.mDividerAlphaChangeOffset = this.mResources.getDimensionPixelOffset(C0535e.f12428q0);
        this.mDividerWidthChangeOffset = this.mResources.getDimensionPixelOffset(C0535e.f12424o0);
        this.mCountOffset = this.mResources.getDimensionPixelOffset(C0535e.f12426p0);
        this.mIsImmerSiveTheme = this.mResources.getBoolean(C0533c.f12361a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        this.mChild = null;
        View view = this.mScrollView;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i10 = 0;
                while (true) {
                    if (i10 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i10).getVisibility() == 0) {
                        this.mChild = viewGroup.getChildAt(i10);
                        break;
                    }
                    i10++;
                }
            }
        }
        if (this.mChild == null) {
            this.mChild = this.mScrollView;
        }
        this.mChild.getLocationOnScreen(this.mLocation);
        int i11 = this.mLocation[1];
        int[] iArr = new int[2];
        this.mScrollView.getRootView().getLocationOnScreen(iArr);
        int i12 = iArr[1];
        if (i12 != 0) {
            i11 -= i12;
        }
        this.mNewOffset = 0;
        if (i11 < this.mDividerAlphaChangeEndY) {
            this.mNewOffset = this.mDividerAlphaChangeOffset;
        } else {
            int i13 = this.mListFirstChildInitY;
            if (i11 > i13) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i13 - i11;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        if (this.mDividerAlphaRange <= 1.0f) {
            float abs = Math.abs(r1) / this.mDividerAlphaChangeOffset;
            this.mDividerAlphaRange = abs;
            this.mDivider.setAlpha(abs);
        }
        if (i11 < this.mDividerWidthChangeEndY) {
            this.mNewOffset = this.mDividerWidthChangeOffset;
        } else {
            int i14 = this.mDividerWidthChangeInitY;
            if (i11 > i14) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i14 - i11;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        float abs2 = Math.abs(r0) / this.mDividerWidthChangeOffset;
        this.mDividerWidthRange = abs2;
        ViewGroup.LayoutParams layoutParams = this.mDividerParams;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int i15 = (int) (this.mMarginLeftRight * (1.0f - abs2));
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i15;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i15;
        }
        this.mDivider.setLayoutParams(layoutParams);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        onListScroll();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        boolean z10 = (i10 & 2) != 0 && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        if (!this.mIsImmerSiveTheme && z10) {
            if (this.mListFirstChildInitY <= 0) {
                this.mScrollView = view2;
                this.mDivider = appBarLayout.findViewById(C0537g.f12492u);
            }
            int measuredHeight = appBarLayout.getMeasuredHeight();
            this.mListFirstChildInitY = measuredHeight;
            this.mDividerAlphaChangeEndY = measuredHeight - this.mDividerAlphaChangeOffset;
            int i12 = measuredHeight - this.mCountOffset;
            this.mDividerWidthChangeInitY = i12;
            this.mDividerWidthChangeEndY = i12 - this.mDividerWidthChangeOffset;
            this.mDividerInitWidth = this.mDivider.getWidth();
            this.mDividerParams = this.mDivider.getLayoutParams();
            this.mMaxWidth = appBarLayout.getMeasuredWidth();
            view2.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.coui.appcompat.behavior.SecondToolbarBehavior.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view3, int i13, int i14, int i15, int i16) {
                    SecondToolbarBehavior.this.onListScroll();
                }
            });
        }
        return false;
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLocation = new int[2];
        init(context);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
