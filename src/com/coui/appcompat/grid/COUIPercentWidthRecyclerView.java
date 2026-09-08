package com.coui.appcompat.grid;

import X8.i;
import X8.o;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.recyclerview.widget.COUIRecyclerView;

/* loaded from: classes.dex */
public class COUIPercentWidthRecyclerView extends COUIRecyclerView {
    private static final int CARD_LIST_FLAG = 2;
    private static final int DEFAULT_FLAG = 0;
    private static final int LARGE_PADDING = 0;
    private static final int LIST_FLAG = 1;
    private static final int SMALL_PADDING = 1;
    private static final String TAG = "COUIPercentWidthRecyclerView";
    private int mGridNumber;
    private int mGridNumberResourceId;
    private int mInitPaddingEnd;
    private int mInitPaddingStart;
    private boolean mIsActivityEmbedded;
    private boolean mIsParentChildHierarchy;
    private int mPaddingSize;
    private int mPaddingType;
    private boolean mPercentEnabled;
    private int mScreenPhysicalWidth;

    public COUIPercentWidthRecyclerView(Context context) {
        this(context, null);
    }

    private void initAttr(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5219U3);
            int i10 = o.f5227V3;
            int i11 = i.f4968g;
            this.mGridNumberResourceId = obtainStyledAttributes.getResourceId(i10, i11);
            this.mGridNumber = obtainStyledAttributes.getInteger(i10, getContext().getResources().getInteger(i11));
            this.mPaddingType = obtainStyledAttributes.getInteger(o.f5251Y3, 1);
            this.mPaddingSize = obtainStyledAttributes.getInteger(o.f5243X3, 0);
            this.mIsParentChildHierarchy = obtainStyledAttributes.getBoolean(o.f5235W3, false);
            obtainStyledAttributes.recycle();
        }
    }

    private void prepareForMeasure() {
        Context context = getContext();
        if (context != null) {
            this.mIsActivityEmbedded = COUIResponsiveUtils.isActivityEmbedded(getContext());
            if (context instanceof Activity) {
                this.mScreenPhysicalWidth = COUIResponsiveUtils.getScreenPhysicalWidth((Activity) context);
            } else {
                this.mScreenPhysicalWidth = -1;
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getContext() != null && this.mGridNumberResourceId != 0) {
            this.mGridNumber = getContext().getResources().getInteger(this.mGridNumberResourceId);
            prepareForMeasure();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mPercentEnabled) {
            i10 = COUIResponsiveUtils.measureLayout(this, i10, this.mGridNumber, this.mPaddingType, this.mPaddingSize, 0, this.mInitPaddingStart, this.mInitPaddingEnd, this.mScreenPhysicalWidth, this.mIsParentChildHierarchy, this.mIsActivityEmbedded);
        } else if (getPaddingStart() != this.mInitPaddingStart || getPaddingEnd() != this.mInitPaddingEnd) {
            setPaddingRelative(this.mInitPaddingStart, getPaddingTop(), this.mInitPaddingEnd, getPaddingBottom());
        }
        super.onMeasure(i10, i11);
    }

    public void setIsParentChildHierarchy(boolean z10) {
        this.mIsParentChildHierarchy = z10;
        requestLayout();
    }

    public void setPercentIndentEnabled(boolean z10) {
        this.mPercentEnabled = z10;
        requestLayout();
    }

    public COUIPercentWidthRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIPercentWidthRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPercentEnabled = true;
        this.mIsActivityEmbedded = false;
        this.mScreenPhysicalWidth = 0;
        initAttr(attributeSet);
        this.mInitPaddingStart = getPaddingStart();
        this.mInitPaddingEnd = getPaddingEnd();
        setScrollBarStyle(33554432);
        prepareForMeasure();
    }
}
