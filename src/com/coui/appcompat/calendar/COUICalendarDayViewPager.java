package com.coui.appcompat.calendar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUICalendarDayViewPager extends ViewPager {
    private final ArrayList<View> mMatchParentChildren;

    public COUICalendarDayViewPager(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int childMeasureSpec;
        int childMeasureSpec2;
        try {
            Method declaredMethod = ViewPager.class.getDeclaredMethod("populate", null);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this, null);
            }
        } catch (Exception unused) {
        }
        int childCount = getChildCount();
        if (View.MeasureSpec.getMode(i10) == 1073741824 && View.MeasureSpec.getMode(i11) == 1073741824) {
            z10 = false;
        } else {
            z10 = true;
        }
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewPager.LayoutParams layoutParams = (ViewPager.LayoutParams) childAt.getLayoutParams();
                i12 = Math.max(i12, childAt.getMeasuredWidth());
                i13 = Math.max(i13, childAt.getMeasuredHeight());
                i14 = View.combineMeasuredStates(i14, childAt.getMeasuredState());
                if (z10 && (((ViewGroup.LayoutParams) layoutParams).width == -1 || ((ViewGroup.LayoutParams) layoutParams).height == -1)) {
                    this.mMatchParentChildren.add(childAt);
                }
            }
        }
        int paddingLeft = i12 + getPaddingLeft() + getPaddingRight();
        int max = Math.max(i13 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight());
        int max2 = Math.max(paddingLeft, getSuggestedMinimumWidth());
        Drawable foreground = getForeground();
        if (foreground != null) {
            max = Math.max(max, foreground.getMinimumHeight());
            max2 = Math.max(max2, foreground.getMinimumWidth());
        }
        setMeasuredDimension(View.resolveSizeAndState(max2, i10, i14), View.resolveSizeAndState(max, i11, i14 << 16));
        int size = this.mMatchParentChildren.size();
        if (size > 1) {
            for (int i16 = 0; i16 < size; i16++) {
                View view = this.mMatchParentChildren.get(i16);
                ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.LayoutParams) layoutParams2).width == -1) {
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
                } else {
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), ((ViewGroup.LayoutParams) layoutParams2).width);
                }
                if (((ViewGroup.LayoutParams) layoutParams2).height == -1) {
                    childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
                } else {
                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), ((ViewGroup.LayoutParams) layoutParams2).height);
                }
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }
        this.mMatchParentChildren.clear();
    }

    public COUICalendarDayViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatchParentChildren = new ArrayList<>(1);
    }
}
