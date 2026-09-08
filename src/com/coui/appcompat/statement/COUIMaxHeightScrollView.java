package com.coui.appcompat.statement;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.coui.appcompat.scrollview.COUIScrollView;

/* loaded from: classes.dex */
public class COUIMaxHeightScrollView extends COUIScrollView {
    private int mMinHeight;
    private int maxHeight;

    public COUIMaxHeightScrollView(Context context) {
        this(context, null);
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    @Override // com.coui.appcompat.scrollview.COUIScrollView, android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        int i12 = this.maxHeight;
        if (i12 > 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, size), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        int measuredHeight = getMeasuredHeight();
        int i13 = this.mMinHeight;
        if (measuredHeight < i13) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
        }
    }

    public void setMaxHeight(int i10) {
        this.maxHeight = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        this.mMinHeight = i10;
        requestLayout();
    }

    public COUIMaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIMaxHeightScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X8.o.f5329i3);
        this.maxHeight = obtainStyledAttributes.getDimensionPixelOffset(X8.o.f5337j3, 0);
        this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(X8.o.f5345k3, 0);
        obtainStyledAttributes.recycle();
    }
}
