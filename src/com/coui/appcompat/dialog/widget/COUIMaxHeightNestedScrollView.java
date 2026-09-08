package com.coui.appcompat.dialog.widget;

import X8.o;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.coui.appcompat.scrollview.COUINestedScrollView;

/* loaded from: classes.dex */
public class COUIMaxHeightNestedScrollView extends COUINestedScrollView {
    private ConfigChangeListener mConfigChangeListener;
    private int mMinHeight;
    private int maxHeight;

    /* loaded from: classes.dex */
    public interface ConfigChangeListener {
        void onChange();
    }

    public COUIMaxHeightNestedScrollView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ConfigChangeListener configChangeListener = this.mConfigChangeListener;
        if (configChangeListener != null) {
            configChangeListener.onChange();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredHeight = getMeasuredHeight();
        int i12 = this.mMinHeight;
        if (i12 > 0) {
            measuredHeight = Math.max(measuredHeight, i12);
        }
        int i13 = this.maxHeight;
        if (i13 > 0) {
            measuredHeight = Math.min(i13, measuredHeight);
        }
        if (measuredHeight != getMeasuredHeight()) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(Math.min(this.maxHeight, measuredHeight), 1073741824));
        }
    }

    public void setConfigChangeListener(ConfigChangeListener configChangeListener) {
        this.mConfigChangeListener = configChangeListener;
    }

    public void setMaxHeight(int i10) {
        this.maxHeight = i10;
        if (isInLayout()) {
            post(new Runnable() { // from class: com.coui.appcompat.dialog.widget.COUIMaxHeightNestedScrollView.1
                @Override // java.lang.Runnable
                public void run() {
                    COUIMaxHeightNestedScrollView.this.requestLayout();
                }
            });
        } else {
            requestLayout();
        }
    }

    public void setMinHeight(int i10) {
        this.mMinHeight = i10;
        requestLayout();
    }

    public COUIMaxHeightNestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIMaxHeightNestedScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5329i3);
        this.maxHeight = obtainStyledAttributes.getDimensionPixelOffset(o.f5337j3, 0);
        this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(o.f5345k3, 0);
        obtainStyledAttributes.recycle();
    }
}
