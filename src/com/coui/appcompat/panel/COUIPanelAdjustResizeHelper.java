package com.coui.appcompat.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class COUIPanelAdjustResizeHelper {
    private COUIAbsPanelAdjustResizeHelper mAdjustHelper = new COUIPanelAdjustResizeHelperAfterR();

    public void adjustResize(Context context, ViewGroup viewGroup, WindowInsets windowInsets, View view, boolean z10) {
        this.mAdjustHelper.adjustResize(context, viewGroup, windowInsets, view, z10);
    }

    public int getMarginBottomValue() {
        return this.mAdjustHelper.getMarginBottomValue();
    }

    public int getPaddingBottomOffset() {
        return this.mAdjustHelper.getPaddingBottomOffset();
    }

    public float getTranslateOffset() {
        return this.mAdjustHelper.getTranslateOffset();
    }

    public int getWindowType() {
        return this.mAdjustHelper.getWindowType();
    }

    public void recoveryScrollingParentViewPaddingBottom(COUIPanelContentLayout cOUIPanelContentLayout) {
        this.mAdjustHelper.recoveryScrollingParentViewPaddingBottom(cOUIPanelContentLayout);
    }

    public boolean releaseData() {
        return this.mAdjustHelper.releaseData();
    }

    public void resetInnerStatus() {
        this.mAdjustHelper.resetInnerStatus();
    }

    public void setIgnoreHideKeyboardAnim(boolean z10) {
        this.mAdjustHelper.setIgnoreHideKeyboardAnim(z10);
    }

    public void setWindowType(int i10) {
        this.mAdjustHelper.setWindowType(i10);
    }
}
