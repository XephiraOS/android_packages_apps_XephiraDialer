package com.coui.appcompat.touchhelper;

import J.d;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.widget.a;
import java.util.List;

/* loaded from: classes3.dex */
public class COUIViewExplorerByTouchHelper extends a {
    private static final String VIEW_LOG_TAG = "COUIViewExplorerByTouchHelper";
    private COUIViewTalkBalkInteraction mCOUIViewTalkBalkInteraction;
    private View mHostView;
    private final Rect mTempRect;

    /* loaded from: classes3.dex */
    public interface COUIViewTalkBalkInteraction {
        CharSequence getClassName();

        int getCurrentPosition();

        int getDisablePosition();

        void getItemBounds(int i10, Rect rect);

        int getItemCounts();

        CharSequence getItemDescription(int i10);

        int getVirtualViewAt(float f10, float f11);

        void performAction(int i10, int i11, boolean z10);
    }

    public COUIViewExplorerByTouchHelper(View view) {
        super(view);
        this.mTempRect = new Rect();
        this.mCOUIViewTalkBalkInteraction = null;
        this.mHostView = view;
    }

    private void getItemBounds(int i10, Rect rect) {
        if (i10 >= 0 && i10 < this.mCOUIViewTalkBalkInteraction.getItemCounts()) {
            this.mCOUIViewTalkBalkInteraction.getItemBounds(i10, rect);
        }
    }

    public void clearFocusedVirtualView() {
        int focusedVirtualView = getFocusedVirtualView();
        if (focusedVirtualView != Integer.MIN_VALUE) {
            getAccessibilityNodeProvider(this.mHostView).f(focusedVirtualView, 128, null);
        }
    }

    @Override // androidx.customview.widget.a
    public int getVirtualViewAt(float f10, float f11) {
        int virtualViewAt = this.mCOUIViewTalkBalkInteraction.getVirtualViewAt(f10, f11);
        if (virtualViewAt >= 0) {
            return virtualViewAt;
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.customview.widget.a
    public void getVisibleVirtualViews(List<Integer> list) {
        for (int i10 = 0; i10 < this.mCOUIViewTalkBalkInteraction.getItemCounts(); i10++) {
            list.add(Integer.valueOf(i10));
        }
    }

    @Override // androidx.customview.widget.a
    public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
        if (i11 != 16) {
            return false;
        }
        this.mCOUIViewTalkBalkInteraction.performAction(i10, 16, false);
        return true;
    }

    @Override // androidx.customview.widget.a
    public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setContentDescription(this.mCOUIViewTalkBalkInteraction.getItemDescription(i10));
    }

    @Override // androidx.customview.widget.a
    public void onPopulateNodeForVirtualView(int i10, d dVar) {
        getItemBounds(i10, this.mTempRect);
        dVar.l0(this.mCOUIViewTalkBalkInteraction.getItemDescription(i10));
        dVar.c0(this.mTempRect);
        if (this.mCOUIViewTalkBalkInteraction.getClassName() != null) {
            dVar.h0(this.mCOUIViewTalkBalkInteraction.getClassName());
        }
        dVar.a(16);
        if (i10 == this.mCOUIViewTalkBalkInteraction.getCurrentPosition()) {
            dVar.F0(true);
        }
        if (i10 == this.mCOUIViewTalkBalkInteraction.getDisablePosition()) {
            dVar.n0(false);
        }
    }

    public void setCOUIViewTalkBalkInteraction(COUIViewTalkBalkInteraction cOUIViewTalkBalkInteraction) {
        this.mCOUIViewTalkBalkInteraction = cOUIViewTalkBalkInteraction;
    }

    public void setFocusedVirtualView(int i10) {
        getAccessibilityNodeProvider(this.mHostView).f(i10, 64, null);
    }
}
