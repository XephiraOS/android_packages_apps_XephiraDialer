package com.coui.appcompat.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b9.C0535e;
import b9.C0537g;

/* loaded from: classes.dex */
public class StatementBehavior extends CoordinatorLayout.Behavior {
    private View mChild;
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
    private int mListFirstChildInitY;
    private int[] mLocation;
    private int mLocationY;
    private int mMarginLeftRight;
    private int mNewOffset;
    private Resources mResources;
    private View mScrollView;

    public StatementBehavior() {
        this.mLocation = new int[2];
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.mResources = resources;
        this.mMarginLeftRight = resources.getDimensionPixelOffset(C0535e.f12422n0) * 2;
        this.mDividerAlphaChangeOffset = this.mResources.getDimensionPixelOffset(C0535e.f12428q0);
        this.mDividerWidthChangeOffset = this.mResources.getDimensionPixelOffset(C0535e.f12424o0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScroll() {
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
        this.mLocationY = i11;
        this.mNewOffset = 0;
        if (i11 < this.mDividerAlphaChangeEndY) {
            this.mNewOffset = this.mDividerAlphaChangeOffset;
        } else {
            int i12 = this.mListFirstChildInitY;
            if (i11 > i12) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i12 - i11;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        if (this.mDividerAlphaRange <= 1.0f) {
            float abs = Math.abs(r0) / this.mDividerAlphaChangeOffset;
            this.mDividerAlphaRange = abs;
            this.mDivider.setAlpha(abs);
        }
        int i13 = this.mLocationY;
        if (i13 < this.mDividerWidthChangeEndY) {
            this.mNewOffset = this.mDividerWidthChangeOffset;
        } else {
            int i14 = this.mDividerWidthChangeInitY;
            if (i13 > i14) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i14 - i13;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        float abs2 = Math.abs(r0) / this.mDividerWidthChangeOffset;
        this.mDividerWidthRange = abs2;
        ViewGroup.LayoutParams layoutParams = this.mDividerParams;
        layoutParams.width = (int) (this.mDividerInitWidth - (this.mMarginLeftRight * (1.0f - abs2)));
        this.mDivider.setLayoutParams(layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10, int i11) {
        if (this.mListFirstChildInitY <= 0) {
            view.getLocationOnScreen(this.mLocation);
            this.mListFirstChildInitY = this.mLocation[1];
            this.mScrollView = view3;
            View findViewById = view.findViewById(C0537g.f12492u);
            this.mDivider = findViewById;
            this.mDividerInitWidth = findViewById.getWidth();
            this.mDividerParams = this.mDivider.getLayoutParams();
            int i12 = this.mListFirstChildInitY;
            this.mDividerAlphaChangeEndY = i12 - this.mDividerAlphaChangeOffset;
            int dimensionPixelOffset = i12 - this.mResources.getDimensionPixelOffset(C0535e.f12426p0);
            this.mDividerWidthChangeInitY = dimensionPixelOffset;
            this.mDividerWidthChangeEndY = dimensionPixelOffset - this.mDividerWidthChangeOffset;
        }
        view3.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.coui.appcompat.behavior.StatementBehavior.1
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view4, int i13, int i14, int i15, int i16) {
                StatementBehavior.this.onScroll();
            }
        });
        return false;
    }

    public StatementBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLocation = new int[2];
        init(context);
    }
}
