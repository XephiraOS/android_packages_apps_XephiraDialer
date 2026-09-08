package com.coui.appcompat.grid;

import X8.i;
import X8.o;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import com.coui.appcompat.list.COUIListView;

/* loaded from: classes.dex */
public class COUIPercentWidthListView extends COUIListView {
    private static final int CARD_LIST_FLAG = 2;
    private static final int DEFAULT_FLAG = 0;
    private static final int LARGE_PADDING = 0;
    private static final int LIST_FLAG = 1;
    private static final int PADDING_MODE = 0;
    private static final int REMEASURE_MODE = 1;
    private static final int SMALL_PADDING = 1;
    private static final String TAG = "COUIPercentWidthListView";
    private int mGridNumber;
    private int mGridNumberResourceId;
    private int mInitPaddingEnd;
    private int mInitPaddingStart;
    private boolean mIsActivityEmbedded;
    private boolean mIsParentChildHierarchy;
    private boolean mMeasureEnabled;
    public int mMode;
    private int mPaddingSize;
    private int mPaddingType;
    private boolean mPercentEnabled;
    private int mScreenPhysicalWidth;

    public COUIPercentWidthListView(Context context) {
        this(context, null);
    }

    private void initAttr(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5179P3);
            int i10 = o.f5187Q3;
            int i11 = i.f4968g;
            this.mGridNumberResourceId = obtainStyledAttributes.getResourceId(i10, i11);
            this.mGridNumber = obtainStyledAttributes.getInteger(i10, getContext().getResources().getInteger(i11));
            this.mMode = obtainStyledAttributes.getInt(o.f5211T3, 0);
            this.mPaddingType = obtainStyledAttributes.getInteger(o.f5203S3, 1);
            this.mPaddingSize = obtainStyledAttributes.getInteger(o.f5195R3, 0);
            this.mIsParentChildHierarchy = obtainStyledAttributes.getBoolean(o.f5235W3, false);
            this.mPercentEnabled = obtainStyledAttributes.getBoolean(o.f5139K3, true);
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

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.mMeasureEnabled) {
            if (this.mPercentEnabled) {
                i10 = COUIResponsiveUtils.measureLayout(this, i10, this.mGridNumber, this.mPaddingType, this.mPaddingSize, this.mMode, this.mInitPaddingStart, this.mInitPaddingEnd, this.mScreenPhysicalWidth, this.mIsParentChildHierarchy, this.mIsActivityEmbedded);
            } else if (getPaddingStart() != this.mInitPaddingStart || getPaddingEnd() != this.mInitPaddingEnd) {
                setPaddingRelative(this.mInitPaddingStart, getPaddingTop(), this.mInitPaddingEnd, getPaddingBottom());
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setIsParentChildHierarchy(boolean z10) {
        this.mIsParentChildHierarchy = z10;
        requestLayout();
    }

    public void setMeasureEnable(boolean z10) {
        Log.d(TAG, "setMeasureEnable = " + z10 + " " + Log.getStackTraceString(new Throwable()));
        this.mMeasureEnabled = z10;
    }

    public void setPercentIndentEnabled(boolean z10) {
        this.mPercentEnabled = z10;
        requestLayout();
    }

    public COUIPercentWidthListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPercentEnabled = true;
        this.mMode = 0;
        this.mIsActivityEmbedded = false;
        this.mScreenPhysicalWidth = 0;
        this.mMeasureEnabled = true;
        initAttr(attributeSet);
        prepareForMeasure();
    }

    public COUIPercentWidthListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPercentEnabled = true;
        this.mMode = 0;
        this.mIsActivityEmbedded = false;
        this.mScreenPhysicalWidth = 0;
        this.mMeasureEnabled = true;
        initAttr(attributeSet);
        this.mInitPaddingStart = getPaddingStart();
        this.mInitPaddingEnd = getPaddingEnd();
        setScrollBarStyle(33554432);
    }
}
