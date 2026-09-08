package com.coui.appcompat.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import c9.C0577i;

/* loaded from: classes.dex */
public class IgnoreWindowInsetsFrameLayout extends FrameLayout {
    private boolean mIsIgnoreWindowInsetsBottom;
    private boolean mIsIgnoreWindowInsetsLeft;
    private boolean mIsIgnoreWindowInsetsRight;
    private boolean mIsIgnoreWindowInsetsTop;
    private int mWindowInsetsBottomOffset;
    private int mWindowInsetsLeftOffset;
    private int mWindowInsetsRightOffset;
    private int mWindowInsetsTopOffset;

    public IgnoreWindowInsetsFrameLayout(Context context) {
        super(context);
        this.mIsIgnoreWindowInsetsLeft = true;
        this.mIsIgnoreWindowInsetsTop = true;
        this.mIsIgnoreWindowInsetsRight = true;
        this.mIsIgnoreWindowInsetsBottom = true;
    }

    private void initAttr(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0577i.f12948o);
            this.mIsIgnoreWindowInsetsLeft = obtainStyledAttributes.getBoolean(C0577i.f12950q, true);
            this.mIsIgnoreWindowInsetsTop = obtainStyledAttributes.getBoolean(C0577i.f12952s, true);
            this.mIsIgnoreWindowInsetsRight = obtainStyledAttributes.getBoolean(C0577i.f12951r, true);
            this.mIsIgnoreWindowInsetsBottom = obtainStyledAttributes.getBoolean(C0577i.f12949p, true);
            obtainStyledAttributes.recycle();
            if (!COUINavigationBarUtil.isGestureNavigation(getContext())) {
                this.mIsIgnoreWindowInsetsBottom = false;
                setFitsSystemWindows(false);
                setClipToPadding(true);
            }
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        int max;
        int max2;
        int max3;
        int max4;
        int i10 = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        if (this.mIsIgnoreWindowInsetsLeft) {
            max = 0;
        } else {
            max = Math.max(0, windowInsets.getSystemWindowInsetLeft() + this.mWindowInsetsLeftOffset);
        }
        if (this.mIsIgnoreWindowInsetsTop) {
            max2 = 0;
        } else {
            max2 = Math.max(0, windowInsets.getSystemWindowInsetTop() + this.mWindowInsetsTopOffset);
        }
        if (this.mIsIgnoreWindowInsetsRight) {
            max3 = 0;
        } else {
            max3 = Math.max(0, windowInsets.getSystemWindowInsetRight() + this.mWindowInsetsRightOffset);
        }
        if (this.mIsIgnoreWindowInsetsBottom) {
            max4 = 0;
        } else {
            max4 = Math.max(0, i10 + this.mWindowInsetsBottomOffset);
        }
        setPadding(max, max2, max3, max4);
        this.mWindowInsetsLeftOffset = 0;
        this.mWindowInsetsTopOffset = 0;
        this.mWindowInsetsRightOffset = 0;
        this.mWindowInsetsBottomOffset = 0;
        return windowInsets.consumeSystemWindowInsets();
    }

    public void setIgnoreWindowInsetsBottom(boolean z10) {
        this.mIsIgnoreWindowInsetsBottom = z10;
    }

    public void setIgnoreWindowInsetsLeft(boolean z10) {
        this.mIsIgnoreWindowInsetsLeft = z10;
    }

    public void setIgnoreWindowInsetsRight(boolean z10) {
        this.mIsIgnoreWindowInsetsRight = z10;
    }

    public void setIgnoreWindowInsetsTop(boolean z10) {
        this.mIsIgnoreWindowInsetsTop = z10;
    }

    public void setWindowInsetsBottomOffset(int i10) {
        this.mWindowInsetsBottomOffset = i10;
    }

    public void setWindowInsetsLeftOffset(int i10) {
        this.mWindowInsetsLeftOffset = i10;
    }

    public void setWindowInsetsRightOffset(int i10) {
        this.mWindowInsetsRightOffset = i10;
    }

    public void setWindowInsetsTopOffset(int i10) {
        this.mWindowInsetsTopOffset = i10;
    }

    public IgnoreWindowInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsIgnoreWindowInsetsLeft = true;
        this.mIsIgnoreWindowInsetsTop = true;
        this.mIsIgnoreWindowInsetsRight = true;
        this.mIsIgnoreWindowInsetsBottom = true;
        initAttr(attributeSet);
    }

    public IgnoreWindowInsetsFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsIgnoreWindowInsetsLeft = true;
        this.mIsIgnoreWindowInsetsTop = true;
        this.mIsIgnoreWindowInsetsRight = true;
        this.mIsIgnoreWindowInsetsBottom = true;
        initAttr(attributeSet);
    }
}
