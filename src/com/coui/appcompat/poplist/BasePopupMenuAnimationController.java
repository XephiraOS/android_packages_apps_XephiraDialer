package com.coui.appcompat.poplist;

import android.view.View;

/* loaded from: classes.dex */
abstract class BasePopupMenuAnimationController {

    @Deprecated
    static final float DEFAULT_MAIN_MENU_ALPHA_SPRING_RESPONSE = 0.3f;
    static final float DEFAULT_MAIN_MENU_ENTER_ALPHA_END_VALUE = 1.0f;
    static final float DEFAULT_MAIN_MENU_ENTER_ALPHA_START_VALUE = 0.0f;
    static final float DEFAULT_MAIN_MENU_ENTER_SCALE_END_VALUE = 1.0f;
    static final float DEFAULT_MAIN_MENU_ENTER_SCALE_START_VALUE = 0.0f;

    @Deprecated
    static final float DEFAULT_MAIN_MENU_SCALE_SPRING_RESPONSE = 0.4f;
    static final float DEFAULT_MAIN_MENU_SPRING_BOUNCE = 0.2f;
    static final float DEFAULT_MAIN_MENU_SPRING_RESPONSE = 0.3f;
    static final float DEFAULT_SPRING_FACTOR = 10000.0f;
    static final float DEFAULT_SUB_MENU_SPRING_BOUNCE = 0.0f;
    static final float DEFAULT_SUB_MENU_SPRING_RESPONSE = 0.35f;
    PopupMenuDomain mDomain;
    View mMainMenuRoot;
    OnMenuStateChangedListener mMenuStateChangedListener = null;
    View mSubMenuRoot;

    /* loaded from: classes.dex */
    public interface OnMenuStateChangedListener {
        void onMainMenuEntered();

        void onMainMenuStartToEnter();

        void onSubMenuAnimationCanceled();

        void onSubMenuEntered();

        void onSubMenuExited();

        void onSubMenuStartToEnter();

        void onSubMenuStartToExit();
    }

    public void setDomain(PopupMenuDomain popupMenuDomain) {
        this.mDomain = popupMenuDomain;
    }

    public void setMainMenuView(View view) {
        this.mMainMenuRoot = view;
    }

    public void setOnSubMenuStateChangedListener(OnMenuStateChangedListener onMenuStateChangedListener) {
        this.mMenuStateChangedListener = onMenuStateChangedListener;
    }

    public void setSubMenuView(View view) {
        this.mSubMenuRoot = view;
    }

    public void startMainMenuEnter(boolean z10) {
    }

    public void startSubMenuEnter(boolean z10) {
    }

    public void startSubMenuExit(boolean z10) {
    }

    public final void startMainMenuEnter() {
        startMainMenuEnter(true);
    }

    public final void startSubMenuEnter() {
        startSubMenuEnter(true);
    }

    public final void startSubMenuExit() {
        startSubMenuExit(true);
    }

    public void detach() {
    }

    public void stopAllAnimation() {
    }
}
