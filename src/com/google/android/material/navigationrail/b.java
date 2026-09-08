package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.c;
import com.google.android.material.navigation.e;

/* compiled from: NavigationRailMenuView.java */
/* loaded from: classes3.dex */
public class b extends e {
    private int itemMinimumHeight;
    private final FrameLayout.LayoutParams layoutParams;

    public b(Context context) {
        super(context);
        this.itemMinimumHeight = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int i10, int i11, int i12) {
        int max = i11 / Math.max(1, i12);
        int i13 = this.itemMinimumHeight;
        if (i13 == -1) {
            i13 = View.MeasureSpec.getSize(i10);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i13, max), 0);
    }

    private int measureChildHeight(View view, int i10, int i11) {
        if (view.getVisibility() != 8) {
            view.measure(i10, i11);
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int measureSharedChildHeights(int i10, int i11, int i12, View view) {
        int makeMeasureSpec;
        if (view == null) {
            makeMeasureSpec = makeSharedHeightSpec(i10, i11, i12);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt != view) {
                i13 += measureChildHeight(childAt, i10, makeMeasureSpec);
            }
        }
        return i13;
    }

    private int measureShiftingChildHeights(int i10, int i11, int i12) {
        int i13;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i13 = measureChildHeight(childAt, i10, makeSharedHeightSpec(i10, i11, i12));
            i11 -= i13;
            i12--;
        } else {
            i13 = 0;
        }
        return i13 + measureSharedChildHeights(i10, i11, i12, childAt);
    }

    @Override // com.google.android.material.navigation.e
    public c createNavigationBarItemView(Context context) {
        return new a(context);
    }

    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    public boolean isTopGravity() {
        if ((this.layoutParams.gravity & 112) == 48) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                childAt.layout(0, i15, i14, measuredHeight);
                i15 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measureSharedChildHeights;
        int size = View.MeasureSpec.getSize(i11);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 > 1 && isShifting(getLabelVisibilityMode(), size2)) {
            measureSharedChildHeights = measureShiftingChildHeights(i10, size, size2);
        } else {
            measureSharedChildHeights = measureSharedChildHeights(i10, size, size2, null);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.resolveSizeAndState(measureSharedChildHeights, i11, 0));
    }

    public void setItemMinimumHeight(int i10) {
        if (this.itemMinimumHeight != i10) {
            this.itemMinimumHeight = i10;
            requestLayout();
        }
    }

    public void setMenuGravity(int i10) {
        FrameLayout.LayoutParams layoutParams = this.layoutParams;
        if (layoutParams.gravity != i10) {
            layoutParams.gravity = i10;
            setLayoutParams(layoutParams);
        }
    }
}
