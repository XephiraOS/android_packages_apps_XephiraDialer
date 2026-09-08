package com.coui.appcompat.poplist;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringForce;
import com.coui.appcompat.poplist.BasePopupMenuAnimationController;
import com.coui.appcompat.uiutil.UIUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SmallScreenAnimationController extends BasePopupMenuAnimationController {
    private static final float DEFAULT_MAIN_MENU_ALPHA_PERCENT = 0.3f;
    private static final float DEFAULT_TRANSLATE = 0.0f;
    private static final String TAG = "PopupMenuAnimCtrl-S";
    private float mMainMenuAlphaPercent;
    private COUISpringAnimation mMainMenuAnimation;
    private float mMainMenuScalePercentX;
    private float mMainMenuScalePercentY;
    private final int mMenuInnerPaddingVertical;
    private final int mMinGapBetweenMainAndSubMenu;
    private COUISpringAnimation mSubMenuAnimation;
    private int mSubMenuClippedBottomEnd;
    private int mSubMenuClippedBottomStart;
    private int mSubMenuClippedTopEnd;
    private int mSubMenuClippedTopStart;
    private int mSubMenuTranslateEnd;
    private int mSubMenuTranslateStart;
    private static final androidx.dynamicanimation.animation.d<SmallScreenAnimationController> SUB_MENU_TRANSITION = new androidx.dynamicanimation.animation.d<SmallScreenAnimationController>("subMenuTransition") { // from class: com.coui.appcompat.poplist.SmallScreenAnimationController.1
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(SmallScreenAnimationController smallScreenAnimationController) {
            return smallScreenAnimationController.getSubMenuTransitionProgress();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(SmallScreenAnimationController smallScreenAnimationController, float f10) {
            smallScreenAnimationController.setSubMenuTransitionProgress(f10);
        }
    };
    private static final androidx.dynamicanimation.animation.d<SmallScreenAnimationController> MAIN_MENU_TRANSITION = new androidx.dynamicanimation.animation.d<SmallScreenAnimationController>("mainMenuTransition") { // from class: com.coui.appcompat.poplist.SmallScreenAnimationController.2
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(SmallScreenAnimationController smallScreenAnimationController) {
            return smallScreenAnimationController.getMainMenuTransitionProgress();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(SmallScreenAnimationController smallScreenAnimationController, float f10) {
            smallScreenAnimationController.setMainMenuTransitionProgress(f10);
        }
    };
    private final COUIDynamicAnimation.OnAnimationEndListener mMainMenuAnimationEndListener = new COUIDynamicAnimation.OnAnimationEndListener() { // from class: com.coui.appcompat.poplist.l
        @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.OnAnimationEndListener
        public final void onAnimationEnd(COUIDynamicAnimation cOUIDynamicAnimation, boolean z10, float f10, float f11) {
            SmallScreenAnimationController.this.lambda$new$0(cOUIDynamicAnimation, z10, f10, f11);
        }
    };
    private final COUIDynamicAnimation.OnAnimationEndListener mSubMenuAnimationEndListener = new COUIDynamicAnimation.OnAnimationEndListener() { // from class: com.coui.appcompat.poplist.m
        @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.OnAnimationEndListener
        public final void onAnimationEnd(COUIDynamicAnimation cOUIDynamicAnimation, boolean z10, float f10, float f11) {
            SmallScreenAnimationController.this.lambda$new$1(cOUIDynamicAnimation, z10, f10, f11);
        }
    };
    private float mMainMenuTransitionProgress = 0.0f;
    private float mSubMenuTransitionProgress = 0.0f;

    public SmallScreenAnimationController(Context context) {
        this.mMinGapBetweenMainAndSubMenu = context.getResources().getDimensionPixelOffset(X8.f.f4695g3);
        this.mMenuInnerPaddingVertical = context.getResources().getDimensionPixelOffset(X8.f.f4604U2);
    }

    private void configMainMenuAnimationPropertiesForSubMenuEnter() {
        this.mMainMenuAlphaPercent = 0.3f;
        float width = this.mDomain.mMainMenuRelocated.width() / this.mDomain.mMainMenu.width();
        this.mMainMenuScalePercentX = width;
        this.mMainMenuScalePercentY = width;
        PopupMenuDomain popupMenuDomain = this.mDomain;
        Rect rect = popupMenuDomain.mMainMenu;
        int i10 = rect.left;
        Rect rect2 = popupMenuDomain.mMainMenuRelocated;
        if (i10 == rect2.left) {
            this.mMainMenuRoot.setPivotX(0.0f);
        } else if (rect.right == rect2.right) {
            this.mMainMenuRoot.setPivotX(r0.getWidth());
        } else {
            this.mMainMenuRoot.setPivotX(r0.getWidth() / 2.0f);
        }
        this.mMainMenuRoot.setPivotY(0.0f);
    }

    private void configSubMenuAnimationPropertiesForSubMenuEnter() {
        BasePopupMenuAnimationController.OnMenuStateChangedListener onMenuStateChangedListener = this.mMenuStateChangedListener;
        if (onMenuStateChangedListener != null) {
            onMenuStateChangedListener.onSubMenuStartToEnter();
        }
        this.mSubMenuClippedTopStart = this.mMenuInnerPaddingVertical * 2;
        this.mSubMenuClippedTopEnd = 0;
        this.mSubMenuClippedBottomStart = this.mDomain.mSubMenuAnchor.height() - this.mSubMenuClippedTopStart;
        this.mSubMenuClippedBottomEnd = this.mDomain.mSubMenu.height();
        View view = this.mSubMenuRoot;
        if (view instanceof RoundFrameLayout) {
            ((RoundFrameLayout) view).setOverrideOutline(0, this.mSubMenuClippedTopStart, this.mDomain.mSubMenu.width(), this.mSubMenuClippedBottomStart, 1.0f);
        }
    }

    private void ensureMainMenuEnterAnimator() {
        if (this.mMainMenuAnimation != null) {
            return;
        }
        COUISpringForce cOUISpringForce = new COUISpringForce();
        cOUISpringForce.setBounce(0.2f);
        cOUISpringForce.setResponse(0.3f);
        COUISpringAnimation cOUISpringAnimation = new COUISpringAnimation(this, MAIN_MENU_TRANSITION);
        this.mMainMenuAnimation = cOUISpringAnimation;
        cOUISpringAnimation.setSpring(cOUISpringForce);
        this.mMainMenuAnimation.addEndListener(this.mMainMenuAnimationEndListener);
    }

    private void ensureSubMenuAnimator() {
        if (this.mSubMenuAnimation != null) {
            return;
        }
        COUISpringForce cOUISpringForce = new COUISpringForce();
        cOUISpringForce.setBounce(0.0f);
        cOUISpringForce.setResponse(0.35f);
        COUISpringAnimation cOUISpringAnimation = new COUISpringAnimation(this, SUB_MENU_TRANSITION);
        this.mSubMenuAnimation = cOUISpringAnimation;
        cOUISpringAnimation.setSpring(cOUISpringForce);
        this.mSubMenuAnimation.addEndListener(this.mSubMenuAnimationEndListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMainMenuTransitionProgress() {
        return this.mMainMenuTransitionProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getSubMenuTransitionProgress() {
        return this.mSubMenuTransitionProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(COUIDynamicAnimation cOUIDynamicAnimation, boolean z10, float f10, float f11) {
        BasePopupMenuAnimationController.OnMenuStateChangedListener onMenuStateChangedListener = this.mMenuStateChangedListener;
        if (onMenuStateChangedListener != null) {
            onMenuStateChangedListener.onMainMenuEntered();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(COUIDynamicAnimation cOUIDynamicAnimation, boolean z10, float f10, float f11) {
        if (!z10) {
            if (f10 == 0.0f) {
                BasePopupMenuAnimationController.OnMenuStateChangedListener onMenuStateChangedListener = this.mMenuStateChangedListener;
                if (onMenuStateChangedListener != null) {
                    onMenuStateChangedListener.onSubMenuExited();
                    return;
                }
                return;
            }
            BasePopupMenuAnimationController.OnMenuStateChangedListener onMenuStateChangedListener2 = this.mMenuStateChangedListener;
            if (onMenuStateChangedListener2 != null) {
                onMenuStateChangedListener2.onSubMenuEntered();
                return;
            }
            return;
        }
        BasePopupMenuAnimationController.OnMenuStateChangedListener onMenuStateChangedListener3 = this.mMenuStateChangedListener;
        if (onMenuStateChangedListener3 != null) {
            onMenuStateChangedListener3.onSubMenuAnimationCanceled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMainMenuTransitionProgress(float f10) {
        this.mMainMenuTransitionProgress = f10;
        float f11 = f10 / 10000.0f;
        View view = this.mMainMenuRoot;
        if (view != null) {
            if (view.getVisibility() != 0) {
                this.mMainMenuRoot.setVisibility(0);
            }
            this.mMainMenuRoot.setAlpha(UIUtil.getConvertedFraction(0.0f, 1.0f, f11));
            this.mMainMenuRoot.setScaleX(UIUtil.getConvertedFraction(0.0f, 1.0f, f11));
            this.mMainMenuRoot.setScaleY(UIUtil.getConvertedFraction(0.0f, 1.0f, f11));
            return;
        }
        Log.w(TAG, "No main menu root view! Skip animation update");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubMenuTransitionProgress(float f10) {
        this.mSubMenuTransitionProgress = f10;
        float f11 = f10 / 10000.0f;
        int round = Math.round(UIUtil.getConvertedFraction(this.mSubMenuTranslateStart, this.mSubMenuTranslateEnd, f11));
        View view = this.mSubMenuRoot;
        if (view instanceof RoundFrameLayout) {
            view.setTranslationY(round);
            int convertedFraction = (int) UIUtil.getConvertedFraction(this.mSubMenuClippedTopStart, this.mSubMenuClippedTopEnd, f11);
            ((RoundFrameLayout) this.mSubMenuRoot).setOverrideOutline(0, convertedFraction, this.mDomain.mSubMenu.width(), convertedFraction + ((int) UIUtil.getConvertedFraction(this.mSubMenuClippedBottomStart, this.mSubMenuClippedBottomEnd, f11)), f11);
            View childAt = ((RoundFrameLayout) this.mSubMenuRoot).getChildAt(0);
            if (childAt instanceof ListView) {
                int i10 = 1;
                while (true) {
                    ListView listView = (ListView) childAt;
                    if (i10 > listView.getChildCount()) {
                        break;
                    }
                    View childAt2 = listView.getChildAt(i10);
                    if (childAt2 != null) {
                        childAt2.setAlpha(f11);
                    }
                    i10++;
                }
            }
        }
        View view2 = this.mMainMenuRoot;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).getChildAt(0).setAlpha(UIUtil.getConvertedFraction(1.0f, this.mMainMenuAlphaPercent, f11));
        }
        this.mMainMenuRoot.setScaleX(UIUtil.getConvertedFraction(1.0f, this.mMainMenuScalePercentX, f11));
        this.mMainMenuRoot.setScaleY(UIUtil.getConvertedFraction(1.0f, this.mMainMenuScalePercentY, f11));
        translateMainMenu(f11, round);
    }

    private void translateMainMenu(float f10, int i10) {
        if (!this.mDomain.mSubMenu.isEmpty()) {
            PopupMenuDomain popupMenuDomain = this.mDomain;
            int i11 = popupMenuDomain.mMainMenu.top;
            int i12 = this.mMinGapBetweenMainAndSubMenu;
            int i13 = i11 + i12;
            int i14 = popupMenuDomain.mSubMenu.top;
            if (i13 > i14) {
                this.mMainMenuRoot.setTranslationY((int) UIUtil.getConvertedFraction(0.0f, (i14 - i12) - i11, f10));
                return;
            } else if (i11 + i12 > i14 + i10) {
                this.mMainMenuRoot.setTranslationY((i14 + i10) - (i11 + i12));
                return;
            } else {
                this.mMainMenuRoot.setTranslationY(0.0f);
                return;
            }
        }
        this.mMainMenuRoot.setTranslationY(0.0f);
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void detach() {
        View view = this.mSubMenuRoot;
        if (view instanceof RoundFrameLayout) {
            view.setTranslationY(0.0f);
            ((RoundFrameLayout) this.mSubMenuRoot).clearOverrideOutline();
        }
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void setMainMenuView(View view) {
        super.setMainMenuView(view);
        ensureMainMenuEnterAnimator();
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void setSubMenuView(View view) {
        ensureSubMenuAnimator();
        if (this.mSubMenuAnimation.isRunning() && this.mSubMenuAnimation.canSkipToEnd()) {
            if (view == this.mSubMenuRoot) {
                this.mSubMenuAnimation.cancel();
            } else {
                this.mSubMenuAnimation.skipToEnd();
            }
        }
        PopupMenuDomain popupMenuDomain = this.mDomain;
        int i10 = popupMenuDomain.mSubMenuAnchor.top - popupMenuDomain.mSubMenu.top;
        this.mSubMenuTranslateStart = i10;
        if (!popupMenuDomain.mSubMenuAnchorIsFirstItem) {
            this.mSubMenuTranslateStart = i10 - this.mMenuInnerPaddingVertical;
        }
        this.mSubMenuTranslateEnd = 0;
        super.setSubMenuView(view);
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void startMainMenuEnter(boolean z10) {
        View view = this.mMainMenuRoot;
        if (view != null) {
            this.mMainMenuTransitionProgress = 0.0f;
            view.setTranslationY(0.0f);
            this.mMainMenuRoot.setPivotX(this.mDomain.getMainMenuEnterPivotX());
            this.mMainMenuRoot.setPivotY(this.mDomain.getMainMenuEnterPivotY());
            BasePopupMenuAnimationController.OnMenuStateChangedListener onMenuStateChangedListener = this.mMenuStateChangedListener;
            if (onMenuStateChangedListener != null) {
                onMenuStateChangedListener.onMainMenuStartToEnter();
            }
            this.mMainMenuAnimation.setStartValue(this.mMainMenuTransitionProgress);
            this.mMainMenuAnimation.animateToFinalPosition(10000.0f);
            if (!z10 && this.mMainMenuAnimation.canSkipToEnd()) {
                this.mMainMenuAnimation.skipToEnd();
                return;
            }
            return;
        }
        Log.w(TAG, "No main menu root view! Set a main menu view before starting animation!");
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void startSubMenuEnter(boolean z10) {
        if (this.mMainMenuRoot == null) {
            Log.e(TAG, "No main menu view! Add a main menu view before showing sub menu!");
            return;
        }
        if (this.mSubMenuRoot != null) {
            configMainMenuAnimationPropertiesForSubMenuEnter();
            configSubMenuAnimationPropertiesForSubMenuEnter();
            this.mSubMenuAnimation.setStartValue(this.mSubMenuTransitionProgress);
            this.mSubMenuAnimation.animateToFinalPosition(10000.0f);
            if (!z10 && this.mSubMenuAnimation.canSkipToEnd()) {
                this.mSubMenuAnimation.skipToEnd();
                return;
            }
            return;
        }
        Log.w(TAG, "No sub menu root view! Set a sub menu view before starting animation!");
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void startSubMenuExit(boolean z10) {
        if (this.mSubMenuAnimation.isRunning()) {
            Log.w(TAG, "Sub menu is exiting!");
        }
        if (this.mSubMenuRoot != null) {
            BasePopupMenuAnimationController.OnMenuStateChangedListener onMenuStateChangedListener = this.mMenuStateChangedListener;
            if (onMenuStateChangedListener != null) {
                onMenuStateChangedListener.onSubMenuStartToExit();
            }
            this.mSubMenuAnimation.setStartValue(this.mSubMenuTransitionProgress);
            this.mSubMenuAnimation.animateToFinalPosition(0.0f);
            if (!z10 && this.mSubMenuAnimation.canSkipToEnd()) {
                this.mSubMenuAnimation.skipToEnd();
                return;
            }
            return;
        }
        Log.w(TAG, "No sub menu root view! Set a sub menu view before starting animation!");
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void stopAllAnimation() {
        COUISpringAnimation cOUISpringAnimation = this.mMainMenuAnimation;
        if (cOUISpringAnimation != null) {
            cOUISpringAnimation.cancel();
        }
        COUISpringAnimation cOUISpringAnimation2 = this.mSubMenuAnimation;
        if (cOUISpringAnimation2 != null) {
            cOUISpringAnimation2.cancel();
        }
        setSubMenuTransitionProgress(0.0f);
    }
}
