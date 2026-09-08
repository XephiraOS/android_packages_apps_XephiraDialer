package com.coui.appcompat.lifecycle;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.C0458m;
import androidx.lifecycle.InterfaceC0491n;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x;
import com.coui.appcompat.sidepane.COUISidePaneLayout;
import com.coui.appcompat.sidepane.COUISidePaneUtils;

/* loaded from: classes.dex */
public class COUISidePaneLifeCycleObserver implements InterfaceC0491n {
    public Activity mActivity;
    public int mChildWidth;
    private View mEditIcon;
    private boolean mIsParentLayouat;
    private COUISidePaneLayout mSidePaneLayout;
    public int mSideWidth;
    private View mSmallScreenView;
    private View mToolbar;
    private boolean mDisableCover = false;
    private final View.OnLayoutChangeListener mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.coui.appcompat.lifecycle.COUISidePaneLifeCycleObserver.2
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (i10 != i14 || i11 != i15 || i12 != i16 || i13 != i17) {
                COUISidePaneLifeCycleObserver.this.mSidePaneLayout.reMeasureContentView();
            }
        }
    };
    private final COUISidePaneLayout.PanelSlideListener mListener = new COUISidePaneLayout.PanelSlideListener() { // from class: com.coui.appcompat.lifecycle.COUISidePaneLifeCycleObserver.3
        @Override // com.coui.appcompat.sidepane.COUISidePaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f10) {
            if (COUISidePaneLifeCycleObserver.this.mEditIcon != null) {
                COUISidePaneUtils.makeFirstEditIconAnim(f10, COUISidePaneLifeCycleObserver.this.mEditIcon, COUISidePaneLifeCycleObserver.this.mActivity);
            }
            if (COUISidePaneLifeCycleObserver.this.mToolbar != null) {
                COUISidePaneUtils.makeSecToolbarAnim(f10, COUISidePaneLifeCycleObserver.this.mToolbar, COUISidePaneLifeCycleObserver.this.mActivity);
            }
        }

        @Override // com.coui.appcompat.sidepane.COUISidePaneLayout.PanelSlideListener
        public void onPanelAnimCancel(int i10) {
        }

        @Override // com.coui.appcompat.sidepane.COUISidePaneLayout.PanelSlideListener
        public void onPanelAnimEnd(int i10) {
        }

        @Override // com.coui.appcompat.sidepane.COUISidePaneLayout.PanelSlideListener
        public void onPanelAnimStart(int i10) {
        }
    };

    public COUISidePaneLifeCycleObserver(Activity activity, COUISidePaneLayout cOUISidePaneLayout, View view, boolean z10, int i10, int i11) {
        this.mActivity = activity;
        this.mSidePaneLayout = cOUISidePaneLayout;
        this.mSmallScreenView = view;
        this.mIsParentLayouat = z10;
        this.mChildWidth = i10;
        this.mSideWidth = i11;
    }

    @x(Lifecycle.Event.ON_CREATE)
    private void componentCreate() {
        updateSidePane(true);
        this.mSidePaneLayout.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        this.mSidePaneLayout.setLifeCycleObserverListener(this.mListener);
    }

    @x(Lifecycle.Event.ON_DESTROY)
    private void componentDestroy() {
        this.mSidePaneLayout.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        this.mSidePaneLayout.setPanelSlideListener(null);
    }

    @x(Lifecycle.Event.ON_RESUME)
    private void componentRestore() {
        reLayoutParams();
    }

    private void reLayoutParams() {
        int i10 = 0;
        if (!COUISidePaneUtils.isLargeScreenStyle(this.mActivity) && !COUISidePaneUtils.isMediumScreenStyle(this.mActivity)) {
            View view = this.mEditIcon;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.mToolbar;
            if (view2 != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                C0458m.d((ViewGroup.MarginLayoutParams) this.mToolbar.getLayoutParams(), 0);
                return;
            }
            return;
        }
        View view3 = this.mEditIcon;
        if (view3 != null) {
            if (!this.mSidePaneLayout.isOpen()) {
                i10 = 8;
            }
            view3.setVisibility(i10);
        }
        if (this.mToolbar != null && !this.mSidePaneLayout.isOpen()) {
            COUISidePaneUtils.restoreInstanceToolbar(this.mToolbar, this.mActivity);
        }
    }

    public void setDisableCoverStyle(boolean z10) {
        this.mDisableCover = z10;
    }

    public void updateConfigChanged(Configuration configuration) {
        COUISidePaneLayout cOUISidePaneLayout = this.mSidePaneLayout;
        if (cOUISidePaneLayout != null) {
            cOUISidePaneLayout.updateLayoutParams();
            updateSidePane(false);
        }
    }

    public void updateSidePane(boolean z10) {
        int i10 = 8;
        if (!COUISidePaneUtils.isLargeScreenStyle(this.mActivity) && !COUISidePaneUtils.isMediumScreenStyle(this.mActivity)) {
            View view = this.mEditIcon;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.mSmallScreenView;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            if (z10) {
                this.mSidePaneLayout.setCreateIcon(false);
                this.mSidePaneLayout.closePane();
                this.mSidePaneLayout.getChildAt(0).setVisibility(8);
                this.mSidePaneLayout.setIconViewVisible(8);
            } else {
                this.mSidePaneLayout.setDefaultShowPane(Boolean.FALSE);
            }
            View view3 = this.mToolbar;
            if (view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && !z10) {
                C0458m.d((ViewGroup.MarginLayoutParams) this.mToolbar.getLayoutParams(), 0);
                return;
            }
            return;
        }
        View view4 = this.mSmallScreenView;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        if (this.mIsParentLayouat) {
            this.mSidePaneLayout.setFirstViewWidth(this.mChildWidth);
            this.mSidePaneLayout.getChildAt(0).getLayoutParams().width = this.mChildWidth;
        }
        this.mSidePaneLayout.setCoverStyle(false);
        this.mSidePaneLayout.setDefaultShowPane(Boolean.TRUE);
        View view5 = this.mEditIcon;
        if (view5 != null) {
            if (this.mSidePaneLayout.isOpen()) {
                i10 = 0;
            }
            view5.setVisibility(i10);
        }
        if (this.mToolbar != null) {
            if (!this.mSidePaneLayout.isOpen()) {
                COUISidePaneUtils.restoreInstanceToolbar(this.mToolbar, this.mActivity);
            }
            if (!z10) {
                this.mSidePaneLayout.post(new Runnable() { // from class: com.coui.appcompat.lifecycle.COUISidePaneLifeCycleObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!COUISidePaneLifeCycleObserver.this.mSidePaneLayout.isOpen()) {
                            COUISidePaneUtils.restoreInstanceToolbar(COUISidePaneLifeCycleObserver.this.mToolbar, COUISidePaneLifeCycleObserver.this.mActivity);
                        }
                    }
                });
            }
        }
    }

    public COUISidePaneLifeCycleObserver(Activity activity, COUISidePaneLayout cOUISidePaneLayout, View view, View view2) {
        this.mActivity = activity;
        this.mSidePaneLayout = cOUISidePaneLayout;
        this.mSmallScreenView = view;
        this.mToolbar = view2;
    }

    public COUISidePaneLifeCycleObserver(Activity activity, COUISidePaneLayout cOUISidePaneLayout, View view, View view2, View view3) {
        this.mActivity = activity;
        this.mSidePaneLayout = cOUISidePaneLayout;
        this.mSmallScreenView = view;
        this.mToolbar = view2;
        this.mEditIcon = view3;
    }
}
