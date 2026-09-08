package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import b9.C0535e;
import b9.l;

/* loaded from: classes.dex */
public class COUIHalfHeightHorizontalPaddingLinearLayout extends LinearLayout {
    private static final int SPECIAL_COUNT = 2;
    private View mEndView;
    private int mFixPaddingEnd;
    private View mStartView;

    public COUIHalfHeightHorizontalPaddingLinearLayout(Context context) {
        super(context);
        this.mFixPaddingEnd = 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (getChildCount() == 2) {
            this.mStartView = getChildAt(0);
            this.mEndView = getChildAt(1);
            if (this.mStartView.getMeasuredHeight() < this.mEndView.getMeasuredHeight()) {
                setPadding(getPaddingStart(), 0, getPaddingEnd(), 0);
            }
            int measuredHeight = getMeasuredHeight() / 2;
            if (measuredHeight >= this.mFixPaddingEnd) {
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0535e.f12432s0);
            if (measuredHeight != getPaddingStart() || measuredHeight != getPaddingEnd() || layoutParams.getMarginEnd() == dimensionPixelSize || layoutParams.getMarginEnd() == 0) {
                setPadding(measuredHeight, getPaddingTop(), measuredHeight, getPaddingBottom());
                if (measuredHeight < this.mFixPaddingEnd) {
                    layoutParams.setMarginEnd((layoutParams.getMarginEnd() + this.mFixPaddingEnd) - measuredHeight);
                    setLayoutParams(layoutParams);
                }
                super.onMeasure(i10, i11);
            }
        }
    }

    public COUIHalfHeightHorizontalPaddingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFixPaddingEnd = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12551E);
        this.mFixPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(l.f12554F, this.mFixPaddingEnd);
        obtainStyledAttributes.recycle();
    }
}
