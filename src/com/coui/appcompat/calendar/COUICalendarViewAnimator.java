package com.coui.appcompat.calendar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ViewAnimator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUICalendarViewAnimator extends ViewAnimator {
    private final ArrayList<View> mMatchParentChildren;

    public COUICalendarViewAnimator(Context context) {
        super(context);
        this.mMatchParentChildren = new ArrayList<>(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int childMeasureSpec;
        int childMeasureSpec2;
        boolean z11;
        boolean z12;
        int i12;
        if (View.MeasureSpec.getMode(i10) == 1073741824 && View.MeasureSpec.getMode(i11) == 1073741824) {
            z10 = false;
        } else {
            z10 = true;
        }
        int childCount = getChildCount();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (getMeasureAllChildren() || childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (layoutParams.height == -1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z10 && (z11 || z12)) {
                    this.mMatchParentChildren.add(childAt);
                }
                int i17 = i13;
                int i18 = i14;
                measureChildWithMargins(childAt, i10, 0, i11, 0);
                if (z10 && !z11) {
                    i15 = Math.max(i15, childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
                    i12 = childAt.getMeasuredWidthAndState() & (-16777216);
                } else {
                    i12 = 0;
                }
                if (z10 && !z12) {
                    i14 = Math.max(i18, childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                    i12 |= (childAt.getMeasuredHeightAndState() >> 16) & (-256);
                } else {
                    i14 = i18;
                }
                i13 = View.combineMeasuredStates(i17, i12);
            }
        }
        int i19 = i13;
        int paddingLeft = i15 + getPaddingLeft() + getPaddingRight();
        int max = Math.max(i14 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight());
        int max2 = Math.max(paddingLeft, getSuggestedMinimumWidth());
        Drawable foreground = getForeground();
        if (foreground != null) {
            max = Math.max(max, foreground.getMinimumHeight());
            max2 = Math.max(max2, foreground.getMinimumWidth());
        }
        setMeasuredDimension(View.resolveSizeAndState(max2, i10, i19), View.resolveSizeAndState(max, i11, i19 << 16));
        int size = this.mMatchParentChildren.size();
        for (int i20 = 0; i20 < size; i20++) {
            View view = this.mMatchParentChildren.get(i20);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.width == -1) {
                childMeasureSpec = View.MeasureSpec.makeMeasureSpec((((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824);
            } else {
                childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
            }
            if (marginLayoutParams.height == -1) {
                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824);
            } else {
                childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
            }
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
        this.mMatchParentChildren.clear();
    }

    public COUICalendarViewAnimator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatchParentChildren = new ArrayList<>(1);
    }
}
