package com.coui.appcompat.poplist;

import android.graphics.Rect;
import android.util.Log;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.uiutil.Domain;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PopupMenuDomain extends Domain {
    private static final boolean COUI_DEBUG;
    private static final String TAG = "PopupMenuDomain";
    Rect mWindow = new Rect();
    Rect mAnchor = new Rect();
    Rect mMainMenu = new Rect();
    Rect mMainMenuRelocated = new Rect();
    Rect mSubMenu = new Rect();
    Rect mPopup = new Rect();
    Rect mSubMenuAnchor = new Rect();
    Rect mAnchorOutsets = new Rect();
    Rect mWindowBarriers = new Rect();
    int mGlobalOffsetX = 0;
    int mGlobalOffsetY = 0;
    boolean mSubMenuAnchorIsFirstItem = false;
    boolean mMainMenuCenterAlign = false;

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        COUI_DEBUG = z10;
    }

    public void dump() {
        Log.d(TAG, "mWindow = " + this.mWindow + " mAnchor = " + this.mAnchor + " mAnchorOutsets = " + this.mAnchorOutsets + " mWindowBarriers = " + this.mWindowBarriers + " mMainMenu = " + this.mMainMenu + " mMainMenuRelocated = " + this.mMainMenuRelocated + " mSubMenu = " + this.mSubMenu + " mSubMenuAnchor = " + this.mSubMenuAnchor + " mGlobalOffsetX = " + this.mGlobalOffsetX + " mGlobalOffsetY = " + this.mGlobalOffsetY);
    }

    public void getAnchorRealRect(Rect rect) {
        Rect rect2 = this.mAnchor;
        int i10 = rect2.left;
        Rect rect3 = this.mAnchorOutsets;
        rect.set(i10 - rect3.left, rect2.top - rect3.top, rect2.right + rect3.right, rect2.bottom + rect3.bottom);
    }

    public void getAvailableRect(Rect rect) {
        Rect rect2 = this.mWindow;
        int i10 = rect2.left;
        Rect rect3 = this.mWindowBarriers;
        rect.set(i10 + rect3.left, rect2.top + rect3.top, rect2.right - rect3.right, rect2.bottom - rect3.bottom);
        if (COUI_DEBUG) {
            Log.d(TAG, "PopupMenuDomain getAvailableRect mWindow.left " + this.mWindow.left + " mWindowBarriers.left " + this.mWindowBarriers.left + " mWindow.top " + this.mWindow.top + " mWindowBarriers.top " + this.mWindowBarriers.top + " mWindow.right " + this.mWindow.right + " mWindowBarriers.right " + this.mWindowBarriers.right + " mWindow.bottom " + this.mWindow.bottom + " mWindowBarriers.bottom " + this.mWindowBarriers.bottom);
        }
    }

    public int getAvailableRectHeight() {
        Rect rect = this.mWindow;
        int i10 = rect.bottom;
        Rect rect2 = this.mWindowBarriers;
        return (i10 - rect2.bottom) - (rect.top + rect2.top);
    }

    public int getAvailableRectWidth() {
        Rect rect = this.mWindow;
        int i10 = rect.right;
        Rect rect2 = this.mWindowBarriers;
        return (i10 - rect2.right) - (rect.left + rect2.left);
    }

    public int getMainMenuEnterPivotX() {
        if (this.mMainMenuCenterAlign) {
            return this.mMainMenu.centerX() - this.mMainMenu.left;
        }
        return Math.min(Math.max(this.mAnchor.centerX() - this.mMainMenu.left, 0), this.mMainMenu.width());
    }

    public int getMainMenuEnterPivotY() {
        if (this.mMainMenuCenterAlign) {
            return this.mMainMenu.centerY() - this.mMainMenu.top;
        }
        if (this.mMainMenu.centerY() > this.mAnchor.centerY()) {
            return 0;
        }
        return this.mMainMenu.height();
    }

    public int getSubMenuEnterPivotX() {
        Rect rect = this.mSubMenu;
        if (rect.left > this.mMainMenu.left) {
            return 0;
        }
        return rect.width();
    }

    public int getSubMenuEnterPivotY() {
        return this.mSubMenuAnchor.centerY() - this.mSubMenu.top;
    }

    public void reset() {
        this.mWindow.setEmpty();
        this.mAnchor.setEmpty();
        this.mMainMenu.setEmpty();
        this.mSubMenu.setEmpty();
        this.mPopup.setEmpty();
        this.mAnchorOutsets.setEmpty();
        this.mWindowBarriers.setEmpty();
        this.mMainMenuRelocated.setEmpty();
        this.mSubMenuAnchor.setEmpty();
    }
}
