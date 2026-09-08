package com.coui.appcompat.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class COUIAbsPanelAdjustResizeHelper {
    public int getMarginBottomValue() {
        return -1;
    }

    public int getPaddingBottomOffset() {
        return -1;
    }

    public float getTranslateOffset() {
        return -1.0f;
    }

    public int getWindowType() {
        return -1;
    }

    public boolean releaseData() {
        return false;
    }

    public void recoveryScrollingParentViewPaddingBottom(COUIPanelContentLayout cOUIPanelContentLayout) {
    }

    public void resetInnerStatus() {
    }

    public void setIgnoreHideKeyboardAnim(boolean z10) {
    }

    public void setWindowType(int i10) {
    }

    public void adjustResize(Context context, ViewGroup viewGroup, WindowInsets windowInsets, View view, boolean z10) {
    }
}
