package com.coui.appcompat.dialog.widget;

import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes.dex */
public class COUIAlertDialogMaxScrollView extends ScrollView {
    private int mLandscapeMaxHeight;
    private int mMaxHeight;
    private int mMaxWidth;
    private OnSizeChangeListener mOnSizeChangeListener;

    /* loaded from: classes.dex */
    public interface OnSizeChangeListener {
        void onSizeChange(int i10, int i11, int i12, int i13);
    }

    public COUIAlertDialogMaxScrollView(Context context) {
        super(context);
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i12 = this.mMaxWidth;
        boolean z11 = true;
        if (i12 != 0 && measuredWidth > i12) {
            i10 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            z10 = true;
        } else {
            z10 = false;
        }
        int i13 = this.mMaxHeight;
        if (measuredHeight > i13) {
            i11 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        } else {
            z11 = z10;
        }
        if (z11) {
            super.onMeasure(i10, i11);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        OnSizeChangeListener onSizeChangeListener = this.mOnSizeChangeListener;
        if (onSizeChangeListener != null) {
            onSizeChangeListener.onSizeChange(i10, i11, i12, i13);
        }
    }

    public void setMaxHeight(int i10) {
        this.mMaxHeight = i10;
    }

    public void setMaxWidth(int i10) {
        this.mMaxWidth = i10;
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        this.mOnSizeChangeListener = onSizeChangeListener;
    }

    public COUIAlertDialogMaxScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5381p);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5397r, 0);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(o.f5389q, 0);
        obtainStyledAttributes.recycle();
    }
}
