package com.coui.appcompat.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class COUIMaxHeightDraggableVerticalLinearLayout extends COUIDraggableVerticalLinearLayout {
    private int mLayoutWindowVisibility;

    public COUIMaxHeightDraggableVerticalLinearLayout(Context context) {
        super(context);
    }

    public int getMaxHeight() {
        return COUIPanelMultiWindowUtils.getPanelMaxHeight(getContext(), null);
    }

    public void layoutAtMaxHeight() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getMaxHeight();
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        if (this.mLayoutWindowVisibility == 8 && i10 == 0) {
            measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        }
        this.mLayoutWindowVisibility = i10;
        super.onWindowVisibilityChanged(i10);
    }

    public COUIMaxHeightDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public COUIMaxHeightDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
