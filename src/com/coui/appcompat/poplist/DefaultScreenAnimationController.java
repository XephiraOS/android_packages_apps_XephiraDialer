package com.coui.appcompat.poplist;

import android.util.Log;
import android.view.View;
import com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringForce;
import com.coui.appcompat.poplist.BasePopupMenuAnimationController;
import com.coui.appcompat.uiutil.UIUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DefaultScreenAnimationController extends BasePopupMenuAnimationController {
    private static final float DEFAULT_ALPHA = 1.0f;
    private static final float DEFAULT_SCALE = 1.0f;
    private static final float MIN_ALPHA = 0.1f;
    private static final String TAG = "PopupMenuAnimCtrl-D";
    private COUISpringAnimation mMainMenuAnimation;
    private COUISpringAnimation mSubMenuAnimation;
    private static final androidx.dynamicanimation.animation.d<DefaultScreenAnimationController> SUB_MENU_TRANSITION = new androidx.dynamicanimation.animation.d<DefaultScreenAnimationController>("subMenuTransition") { // from class: com.coui.appcompat.poplist.DefaultScreenAnimationController.1
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(DefaultScreenAnimationController defaultScreenAnimationController) {
            return defaultScreenAnimationController.getSubMenuTransitionProgress();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(DefaultScreenAnimationController defaultScreenAnimationController, float f10) {
            defaultScreenAnimationController.setSubMenuTransitionProgress(f10);
        }
    };
    private static final androidx.dynamicanimation.animation.d<DefaultScreenAnimationController> MAIN_MENU_TRANSITION = new androidx.dynamicanimation.animation.d<DefaultScreenAnimationController>("mainMenuTransition") { // from class: com.coui.appcompat.poplist.DefaultScreenAnimationController.2
        @Override // androidx.dynamicanimation.animation.d
        public float getValue(DefaultScreenAnimationController defaultScreenAnimationController) {
            return defaultScreenAnimationController.getMainMenuTransitionProgress();
        }

        @Override // androidx.dynamicanimation.animation.d
        public void setValue(DefaultScreenAnimationController defaultScreenAnimationController, float f10) {
            defaultScreenAnimationController.setMainMenuTransitionProgress(f10);
        }
    };
    private final COUIDynamicAnimation.OnAnimationEndListener mMainMenuAnimationEndListener = new COUIDynamicAnimation.OnAnimationEndListener() { // from class: com.coui.appcompat.poplist.h
        @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.OnAnimationEndListener
        public final void onAnimationEnd(COUIDynamicAnimation cOUIDynamicAnimation, boolean z10, float f10, float f11) {
            DefaultScreenAnimationController.this.lambda$new$0(cOUIDynamicAnimation, z10, f10, f11);
        }
    };
    private final COUIDynamicAnimation.OnAnimationEndListener mSubMenuAnimationEndListener = new COUIDynamicAnimation.OnAnimationEndListener() { // from class: com.coui.appcompat.poplist.i
        @Override // com.coui.appcompat.animation.dynamicanimation.COUIDynamicAnimation.OnAnimationEndListener
        public final void onAnimationEnd(COUIDynamicAnimation cOUIDynamicAnimation, boolean z10, float f10, float f11) {
            DefaultScreenAnimationController.this.lambda$new$1(cOUIDynamicAnimation, z10, f10, f11);
        }
    };
    private float mMainMenuTransitionProgress = 0.0f;
    private float mSubMenuTransitionProgress = 0.0f;

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
        int i10;
        this.mSubMenuTransitionProgress = f10;
        float f11 = f10 / 10000.0f;
        if (this.mSubMenuRoot != null) {
            float convertedFraction = UIUtil.getConvertedFraction(0.0f, 1.0f, f11);
            View view = this.mSubMenuRoot;
            if ((view instanceof RoundFrameLayout) && ((RoundFrameLayout) view).getUseBackgroundBlur()) {
                View view2 = this.mSubMenuRoot;
                if (convertedFraction <= 0.1f) {
                    i10 = 8;
                } else {
                    i10 = 0;
                }
                view2.setVisibility(i10);
            }
            this.mSubMenuRoot.setAlpha(convertedFraction);
            this.mSubMenuRoot.setScaleX(UIUtil.getConvertedFraction(0.0f, 1.0f, f11));
            this.mSubMenuRoot.setScaleY(UIUtil.getConvertedFraction(0.0f, 1.0f, f11));
        }
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void detach() {
        View view = this.mSubMenuRoot;
        if (view instanceof RoundFrameLayout) {
            view.setAlpha(1.0f);
            this.mSubMenuRoot.setScaleX(1.0f);
            this.mSubMenuRoot.setScaleY(1.0f);
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
            this.mSubMenuAnimation.cancel();
        }
        super.setSubMenuView(view);
    }

    @Override // com.coui.appcompat.poplist.BasePopupMenuAnimationController
    public void startMainMenuEnter(boolean z10) {
        View view = this.mMainMenuRoot;
        if (view != null) {
            this.mMainMenuTransitionProgress = 0.0f;
            view.setPivotX(this.mDomain.getMainMenuEnterPivotX());
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
            BasePopupMenuAnimationController.OnMenuStateChangedListener onMenuStateChangedListener = this.mMenuStateChangedListener;
            if (onMenuStateChangedListener != null) {
                onMenuStateChangedListener.onSubMenuStartToEnter();
            }
            this.mSubMenuRoot.setPivotX(this.mDomain.getSubMenuEnterPivotX());
            this.mSubMenuRoot.setPivotY(this.mDomain.getSubMenuEnterPivotY());
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
        if (this.mMainMenuRoot == null) {
            Log.e(TAG, "No main menu view! Add a main menu view before showing sub menu!");
            return;
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
