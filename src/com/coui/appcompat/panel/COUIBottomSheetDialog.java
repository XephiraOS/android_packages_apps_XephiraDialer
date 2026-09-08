package com.coui.appcompat.panel;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.dynamicanimation.animation.c;
import androidx.dynamicanimation.animation.e;
import androidx.dynamicanimation.animation.f;
import androidx.dynamicanimation.animation.g;
import c4.h;
import c4.j;
import c4.l;
import c9.C0569a;
import c9.C0570b;
import c9.C0571c;
import c9.C0572d;
import c9.C0573e;
import c9.C0574f;
import c9.C0575g;
import c9.C0576h;
import c9.C0577i;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.COUIOutEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.edittext.COUIInputView;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.panel.COUIBottomSheetBehavior;
import com.coui.appcompat.theme.COUIThemeOverlay;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.coui.appcompat.uiutil.UIUtil;
import com.coui.appcompat.version.COUIVersionUtil;
import com.oplus.dynamicframerate.AnimationVelocityCalculator;
import com.oplus.dynamicframerate.DynamicFrameRateManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class COUIBottomSheetDialog extends com.google.android.material.bottomsheet.a implements c.r, c.q {
    private static final float ALPHA_OPAQUE = 1.0f;
    private static final float ALPHA_TRANSPARENT = 0.0f;
    public static final int ANIMATION_TYPE_ID = 10101;
    private static final boolean DEBUG;
    private static final float DEFAULT_ALPHA_HIDING_ANIMATOR_DURATION = 183.0f;
    private static final float DEFAULT_SPRING_DAMPING_RATIO = 0.7f;
    private static final float DEFAULT_SPRING_STIFFNESS = 200.0f;
    private static final float DEFAULT_TRANSLATE_HIDING_ANIMATOR_DURATION = 333.0f;
    private static final float DIALOG_SHOW_SCALE_DELTA = 0.2f;
    private static final float DIALOG_SHOW_SCALE_START = 0.8f;
    private static final Interpolator DISMISS_ALPHA_ANIM_INTERPOLATOR;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT = 133.0f;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE = 117.0f;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 200.0f;
    private static final Interpolator DISMISS_HEIGHT_ANIM_INTERPOLATOR;
    private static final Interpolator DISMISS_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE;
    private static final float ELEVATION_VALUE = 24.0f;
    private static final int FLAG_DISABLE_SUB_DISPLAY_EXPAND = 268435456;
    private static final float FLOAT_ONE = 1.0f;
    private static final float FLOAT_POINT_FIVE = 0.5f;
    private static final float FOLLOW_HAND_ALPHA_ANIM_DURATION_IN_LARGE = 167.0f;
    private static final float FOLLOW_HAND_SHOW_ANIM_START_OFFSET_DURATION_IN_LARGE = 167.0f;
    private static final int HUNDRED = 100;
    private static final int INT_TWO = 2;
    private static final long NAV_COLOR_ANIM_DURATION = 200;
    private static final float NO_ELEVATION_VALUE = 0.0f;
    private static final Interpolator OUTSIDE_ALPHA_ANIM_INTERPOLATOR;
    private static final float PHYSICS_UNSET = Float.MIN_VALUE;
    private static final float PULL_UP_FRICTION = 0.8f;
    private static final int PULL_UP_REBOUND_BOUNCINESS = 6;
    private static final int PULL_UP_REBOUND_SPEED = 42;
    private static final int SDK_SUB_VERSION = 10;
    private static final float SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT = 132.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE = 150.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 300.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_IN_TINY_SCREEN = 167.0f;
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR;
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE;
    private static final String STATE_FOCUS_CHANGES = "state_focus_changes";
    private static final String TAG = "COUIBottomSheetDialog";
    private static final double THREE_POINT_EIGHT = 3.8d;
    private static final double TWENTY = 20.0d;
    private static final int UNSET_SIZE = -1;
    private static final double ZERO = 0.0d;
    protected boolean isLargeScreenLimitMaxSize;
    private int mADFRFeatureType;
    private WeakReference<Activity> mActivityWeakReference;
    private ViewGroup mAdjustLayout;
    private boolean mAdjustResizeEnable;
    private COUIPanelAdjustResizeHelper mAdjustResizeHelper;
    private View mAnchorView;
    private OnAnimationListener mAnimationListener;
    private float mAppearDampingRatio;
    private f mAppearSpringAnim;
    private g mAppearSpringForce;
    private float mAppearStiffness;
    private WindowInsets mApplyWindowInsets;
    private BottomSheetDialogAnimatorListener mBottomSheetDialogAnimatorListener;
    private boolean mCanPerformHapticFeedback;
    private boolean mCanPullUp;
    private boolean mCancelable;
    private boolean mCanceledOnTouchOutside;
    private ComponentCallbacks mComponentCallbacks;
    private Configuration mConfiguration;
    private IgnoreWindowInsetsFrameLayout mContainerFrameLayout;
    private View mContentView;
    private View mCoordinatorLayout;
    protected int mCoordinatorLayoutMinInsetsTop;
    private int mCoordinatorLayoutPaddingExtra;
    private float mCurrentOutsideAlpha;
    private float mCurrentParentViewTranslationY;
    private int mCurrentSpringTotalOffset;
    private COUIPanelPercentFrameLayout mDesignBottomSheetFrameLayout;
    private DialogOffsetListener mDialogOffsetListener;
    private c4.g mDisableFastCloseFeedbackSpring;
    private boolean mDisableSubExpand;

    @Deprecated
    private OnDismissAnimationEndListener mDismissListener;
    protected COUIPanelContentLayout mDraggableConstraintLayout;
    private View mFeedBackView;
    private int mFinalNavColorAfterDismiss;
    private boolean mFirstShowCollapsed;
    private Boolean mFocusChange;
    private boolean mFrameRate;
    private boolean mGlobalDrag;
    private boolean mHandleViewHasPressAnim;
    private int mHideDragViewHeight;
    private InputMethodManager mInputMethodManager;
    private boolean mIsAppearSpringAnimStared;
    private boolean mIsDraggable;
    private boolean mIsExecuteNavColorAnimAfterDismiss;
    private boolean mIsExecutingDismissAnim;
    private boolean mIsFullScreenInTinyScreen;
    private boolean mIsGestureNavigation;
    private boolean mIsHandlePanel;
    private boolean mIsInTinyScreen;
    private boolean mIsInWindowFloatingMode;
    private boolean mIsInterruptingAnim;
    private boolean mIsNeedOutsideViewAnim;
    private boolean mIsNeedShowKeyboard;
    private boolean mIsShowInDialogFragment;
    private boolean mIsShowInMaxHeight;
    private boolean mIsVSdk;
    private int mNavColor;
    private View mNavigationCustomView;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    private int mOriginWidth;
    private View.OnTouchListener mOutSideViewTouchListener;
    private View mOutsideView;
    private float mOutsideViewBackgroundAlpha;
    private Drawable mPanelBackground;
    private int mPanelBackgroundTintColor;
    private COUIPanelBarView mPanelBarView;
    private Drawable mPanelDragViewDrawable;
    private int mPanelDragViewDrawableTintColor;
    private int mPanelHeight;
    private COUIPanelPullUpListener mPanelPullUpListener;
    private c4.g mPanelSpringBackAnim;
    private AnimatorSet mPanelViewTranslationAnimationSet;
    private int mPanelWidth;
    private int mParentViewPaddingBottom;
    private int mPeekHeight;
    private float mPhysicsDampingRatio;
    private float mPhysicsFrequency;
    private int mPreferWidth;
    private WindowInsets mProgressWindowInsets;
    private int mPullUpMaxOffset;
    private View mPulledUpView;
    private boolean mRegisterConfigurationChangeCallBack;
    private boolean mShouldRegisterWindowInsetsListener;

    @Deprecated
    private OnShowAnimationEndListener mShowListener;
    private boolean mSkipCollapsed;
    private int mSnapStartBottom;
    private int mStatusBarHeight;
    private float mTranslateHidingDuration;
    private boolean mWindowInsetsAnimEnable;
    private int mWindowInsetsLeft;
    private View.OnApplyWindowInsetsListener mWindowInsetsListener;
    private int mWindowInsetsTop;

    /* loaded from: classes.dex */
    public interface BottomSheetDialogAnimatorListener {
        void onBottomSheetDialogCollapsed();

        void onBottomSheetDialogExpanded();
    }

    /* loaded from: classes.dex */
    public interface DialogOffsetListener {
        void onDialogOffsetChanged(float f10);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnDismissAnimationEndListener {
        void onDismissAnimationEnd();
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface OnShowAnimationEndListener {
        void onShowAnimationEnd();
    }

    static {
        COUIInEaseInterpolator cOUIInEaseInterpolator = new COUIInEaseInterpolator();
        SHOW_HEIGHT_ANIM_INTERPOLATOR = cOUIInEaseInterpolator;
        OUTSIDE_ALPHA_ANIM_INTERPOLATOR = new COUIEaseInterpolator();
        SHOW_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE = new COUIInEaseInterpolator();
        DISMISS_HEIGHT_ANIM_INTERPOLATOR = new COUIOutEaseInterpolator();
        DISMISS_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE = new COUIOutEaseInterpolator();
        DISMISS_ALPHA_ANIM_INTERPOLATOR = cOUIInEaseInterpolator;
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public COUIBottomSheetDialog(Context context) {
        this(context, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] calculateFinalLocationOnScreen(android.view.View r17) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.panel.COUIBottomSheetDialog.calculateFinalLocationOnScreen(android.view.View):int[]");
    }

    private void cancelAnim(Animator animator) {
        if (animator != null && animator.isRunning()) {
            animator.end();
        }
    }

    private void checkInitState() {
        if (this.mContainerFrameLayout != null) {
            if (this.mCoordinatorLayout != null) {
                if (this.mOutsideView != null) {
                    if (this.mDesignBottomSheetFrameLayout != null) {
                        return;
                    } else {
                        throw new IllegalArgumentException("design_bottom_sheet can not be null");
                    }
                }
                throw new IllegalArgumentException("panel_outside can not be null");
            }
            throw new IllegalArgumentException("coordinator can not be null");
        }
        throw new IllegalArgumentException("container can not be null");
    }

    private ValueAnimator createDialogAlphaAnim(final boolean z10, PathInterpolator pathInterpolator) {
        float f10;
        float f11 = 1.0f;
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        if (!z10) {
            f11 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout != null) {
                    COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setAlpha(floatValue);
                    if (z10) {
                        float f12 = (floatValue * 0.2f) + 0.8f;
                        COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setScaleX(f12);
                        COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setScaleY(f12);
                    }
                }
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator createNavigationColorAnimation(int i10) {
        if (COUINavigationBarUtil.isNavigationBarShow(getContext()) && getWindow() != null) {
            final Window window = getWindow();
            int navigationBarColor = window.getNavigationBarColor();
            if (Color.alpha(i10) == 0) {
                i10 = Color.argb(1, Color.red(i10), Color.green(i10), Color.blue(i10));
            }
            if (navigationBarColor != i10) {
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(navigationBarColor), Integer.valueOf(i10));
                ofObject.setDuration(200L);
                ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.14
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        window.setNavigationBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                return ofObject;
            }
        }
        return null;
    }

    private ValueAnimator createOutsideAlphaAnimation(final boolean z10, float f10, PathInterpolator pathInterpolator) {
        float f11;
        float f12 = this.mCurrentOutsideAlpha;
        if (z10) {
            f11 = 1.0f;
        } else {
            f11 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f12, f11);
        ofFloat.setDuration(f10);
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                View findFocus;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIBottomSheetDialog.this.mOutsideView != null) {
                    COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog.mCurrentOutsideAlpha = cOUIBottomSheetDialog.getOutsideViewAlpha(floatValue);
                    COUIBottomSheetDialog.this.mOutsideView.setAlpha(COUIBottomSheetDialog.this.mCurrentOutsideAlpha);
                }
                if (COUIBottomSheetDialog.this.mOutsideView != null && COUIPanelMultiWindowUtils.isVirtualNavigation(COUIBottomSheetDialog.this.getContext()) && ((COUIBottomSheetDialog.this.isFollowHand() || COUIBottomSheetDialog.this.isFadeInCenterAllState() || COUIBottomSheetDialog.this.shouldHandlePanelUpdateNavBarColor()) && !COUIBottomSheetDialog.this.mIsInTinyScreen)) {
                    COUIBottomSheetDialog cOUIBottomSheetDialog2 = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog2.setNavigationBarColorAlpha(cOUIBottomSheetDialog2.mCurrentOutsideAlpha);
                }
                COUIBottomSheetDialog cOUIBottomSheetDialog3 = COUIBottomSheetDialog.this;
                if (cOUIBottomSheetDialog3.mDraggableConstraintLayout != null && cOUIBottomSheetDialog3.mIsNeedShowKeyboard && (findFocus = COUIBottomSheetDialog.this.mDraggableConstraintLayout.findFocus()) != null && z10 && COUIBottomSheetDialog.this.mInputMethodManager != null) {
                    COUIBottomSheetDialog.this.mInputMethodManager.showSoftInput(findFocus, 0);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout != null && COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getAlpha() == 0.0f) {
                    COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setAlpha(1.0f);
                }
                COUIBottomSheetDialog.this.mIsNeedShowKeyboard = false;
            }
        });
        return ofFloat;
    }

    private void createPanelConstraintLayout() {
        int i10;
        LayoutInflater layoutInflater = getLayoutInflater();
        if (this.mIsInTinyScreen) {
            i10 = C0575g.f12930f;
        } else {
            i10 = C0575g.f12929e;
        }
        COUIPanelContentLayout cOUIPanelContentLayout = (COUIPanelContentLayout) layoutInflater.inflate(i10, (ViewGroup) null);
        Drawable drawable = this.mPanelDragViewDrawable;
        if (drawable != null) {
            drawable.setTint(this.mPanelDragViewDrawableTintColor);
            cOUIPanelContentLayout.setDragViewDrawable(this.mPanelDragViewDrawable);
        }
        if (this.mHandleViewHasPressAnim) {
            cOUIPanelContentLayout.setDragViewPressAnim(true);
        }
        cOUIPanelContentLayout.setNavigationMargin(null, COUIViewMarginUtil.getMargin(this.mCoordinatorLayout, 3), this.mApplyWindowInsets);
        this.mDraggableConstraintLayout = cOUIPanelContentLayout;
        if (!this.mIsHandlePanel) {
            hideDragView();
        }
    }

    private ValueAnimator createPanelTranslateAnimation(int i10, int i11, float f10, PathInterpolator pathInterpolator) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i10, i11);
        ofFloat.setDuration(f10);
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setTranslationY(floatValue);
                    if (!COUIBottomSheetDialog.this.mIsInterruptingAnim) {
                        COUIBottomSheetDialog.this.mCurrentParentViewTranslationY = floatValue;
                    }
                    COUIBottomSheetDialog.this.mIsInterruptingAnim = false;
                }
            }
        });
        setFrameRate(ofFloat);
        return ofFloat;
    }

    private void dismissWithAlphaAnim() {
        ValueAnimator valueAnimator;
        if (this.mIsExecuteNavColorAnimAfterDismiss) {
            valueAnimator = createNavigationColorAnimation(this.mFinalNavColorAfterDismiss);
        } else {
            valueAnimator = null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(DISMISS_ALPHA_ANIM_INTERPOLATOR);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = false;
                super.onAnimationCancel(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIBottomSheetDialog.this.mBottomSheetDialogAnimatorListener != null) {
                    COUIBottomSheetDialog.this.mBottomSheetDialogAnimatorListener.onBottomSheetDialogCollapsed();
                }
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = false;
                COUIBottomSheetDialog.this.superDismiss();
                COUIBottomSheetDialog.this.releaseBehaviorPullUpListener();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = true;
                super.onAnimationStart(animator);
            }
        });
        if (valueAnimator == null) {
            animatorSet.playTogether(createOutsideAlphaAnimation(false, 200.0f, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR));
        } else {
            animatorSet.playTogether(createOutsideAlphaAnimation(false, 200.0f, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR), valueAnimator);
        }
        animatorSet.start();
    }

    private void dismissWithInterruptibleAnim() {
        doParentViewTranslationHidingAnim(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (COUIBottomSheetDialog.this.mBottomSheetDialogAnimatorListener != null) {
                    COUIBottomSheetDialog.this.mBottomSheetDialogAnimatorListener.onBottomSheetDialogCollapsed();
                }
                if (COUIBottomSheetDialog.this.mAnimationListener != null) {
                    COUIBottomSheetDialog.this.mAnimationListener.onDismissAnimationEnd();
                }
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = false;
                if (!COUIBottomSheetDialog.this.mIsExecuteNavColorAnimAfterDismiss) {
                    COUIBottomSheetDialog.this.superDismiss();
                } else {
                    COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                    ValueAnimator createNavigationColorAnimation = cOUIBottomSheetDialog.createNavigationColorAnimation(cOUIBottomSheetDialog.mFinalNavColorAfterDismiss);
                    if (createNavigationColorAnimation == null) {
                        COUIBottomSheetDialog.this.superDismiss();
                    } else {
                        createNavigationColorAnimation.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.6.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                COUIBottomSheetDialog.this.superDismiss();
                            }
                        });
                        createNavigationColorAnimation.start();
                    }
                }
                COUIBottomSheetDialog.this.releaseBehaviorPullUpListener();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = true;
                if (COUIBottomSheetDialog.this.mAnimationListener != null) {
                    COUIBottomSheetDialog.this.mAnimationListener.onDismissAnimationStart();
                }
            }
        });
    }

    private void doFeedbackAnimation(View view) {
        if (view == null) {
            return;
        }
        if (this.mDisableFastCloseFeedbackSpring == null || this.mFeedBackView != view) {
            this.mFeedBackView = view;
            c4.g c10 = l.h().c();
            this.mDisableFastCloseFeedbackSpring = c10;
            c10.q(h.a(THREE_POINT_EIGHT, TWENTY));
            this.mDisableFastCloseFeedbackSpring.a(new j() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.15
                @Override // c4.j
                public void onSpringUpdate(c4.g gVar) {
                    if (COUIBottomSheetDialog.this.mDisableFastCloseFeedbackSpring != null && COUIBottomSheetDialog.this.mFeedBackView != null) {
                        int c11 = (int) gVar.c();
                        if (c11 >= 100) {
                            COUIBottomSheetDialog.this.mDisableFastCloseFeedbackSpring.n(0.0d);
                        }
                        COUIBottomSheetDialog.this.mFeedBackView.setTranslationY(c11);
                    }
                }

                @Override // c4.j
                public void onSpringActivate(c4.g gVar) {
                }

                @Override // c4.j
                public void onSpringAtRest(c4.g gVar) {
                }

                @Override // c4.j
                public void onSpringEndStateChange(c4.g gVar) {
                }
            });
        }
        this.mDisableFastCloseFeedbackSpring.n(100.0d);
    }

    private void doParentViewTranslationHidingAnim(Animator.AnimatorListener animatorListener) {
        stopCurrentRunningViewTranslationAnim();
        int dialogMaxHeight = getDialogMaxHeight();
        if (dialogMaxHeight == 0) {
            Log.d(TAG, "doParentViewTranslationHidingAnim return directly for dialogMaxHeight is 0, but call superDismiss");
            superDismiss();
            return;
        }
        int height = (this.mContainerFrameLayout.getHeight() - this.mDesignBottomSheetFrameLayout.getTop()) + COUIViewMarginUtil.getMargin(this.mDesignBottomSheetFrameLayout, 3);
        int i10 = (int) this.mCurrentParentViewTranslationY;
        if (this.mFirstShowCollapsed && getBehavior().getState() == 4) {
            height = this.mPeekHeight;
        }
        float f10 = i10 - height;
        float f11 = dialogMaxHeight;
        float abs = Math.abs((DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT * f10) / f11) + 200.0f;
        Interpolator interpolator = DISMISS_HEIGHT_ANIM_INTERPOLATOR;
        if (COUIPanelMultiWindowUtils.isLargeHeightScreen(getContext(), null)) {
            abs = Math.abs((f10 * DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE) / f11) + 200.0f;
            interpolator = DISMISS_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE;
        }
        this.mPanelViewTranslationAnimationSet = new AnimatorSet();
        if (this.mIsInTinyScreen) {
            startReleaseAnimInTinyScreen(i10, height, this.mTranslateHidingDuration, animatorListener);
            return;
        }
        if (isFollowHand()) {
            startReleaseAnimFollowHand(animatorListener);
        } else if (isFadeInCenter()) {
            startReleaseAnimFadeOut(animatorListener);
        } else {
            this.mPanelViewTranslationAnimationSet.playTogether(createPanelTranslateAnimation(i10, height, abs, (PathInterpolator) interpolator), createOutsideAlphaAnimation(false, abs, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR));
            startReleaseAnim(animatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doParentViewTranslationShowingAnim(int i10, Animator.AnimatorListener animatorListener) {
        int i11;
        stopCurrentRunningViewTranslationAnim();
        int dialogMaxHeight = getDialogMaxHeight();
        if (dialogMaxHeight == 0) {
            Log.d(TAG, "doParentViewTranslationShowingAnim return directly for dialogMaxHeight is 0");
            return;
        }
        int contentViewHeightWithMargins = getContentViewHeightWithMargins();
        if (this.mFirstShowCollapsed) {
            i11 = this.mPeekHeight;
        } else {
            i11 = contentViewHeightWithMargins + i10;
        }
        float f10 = i11;
        float f11 = dialogMaxHeight;
        float abs = Math.abs((SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT * f10) / f11) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
        Interpolator interpolator = SHOW_HEIGHT_ANIM_INTERPOLATOR;
        if (COUIPanelMultiWindowUtils.isLargeHeightScreen(getContext(), null)) {
            abs = Math.abs((f10 * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE) / f11) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
            interpolator = SHOW_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE;
        }
        this.mPanelViewTranslationAnimationSet = new AnimatorSet();
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null && cOUIPanelContentLayout.findFocus() != null) {
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getAlpha() != 0.0f) {
                this.mDesignBottomSheetFrameLayout.setAlpha(0.0f);
            }
            this.mPanelViewTranslationAnimationSet.playTogether(createOutsideAlphaAnimation(true, abs, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR));
            startShowingAnim(animatorListener);
            return;
        }
        if (this.mIsInTinyScreen) {
            startShowingAnimInTinyScreen(i10, animatorListener);
            return;
        }
        if (isFollowHand()) {
            startShowingAnimFollowHand(animatorListener);
        } else if (isFadeInCenter()) {
            startShowingAnimFadeIn(animatorListener);
        } else {
            this.mPanelViewTranslationAnimationSet.playTogether(createPanelTranslateAnimation(i11, 0, abs, (PathInterpolator) interpolator), createOutsideAlphaAnimation(true, abs, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR));
            startShowingAnim(animatorListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSpringBackReboundAnim(final int i10) {
        c4.g c10 = l.h().c();
        this.mPanelSpringBackAnim = c10;
        c10.q(h.a(6.0d, 42.0d));
        this.mCurrentSpringTotalOffset = 0;
        this.mPanelSpringBackAnim.a(new j() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.19
            @Override // c4.j
            public void onSpringAtRest(c4.g gVar) {
                if ((COUIBottomSheetDialog.this.getBehavior() instanceof COUIBottomSheetBehavior) && COUIBottomSheetDialog.this.mPulledUpView != null) {
                    COUIBottomSheetDialog.this.mParentViewPaddingBottom = 0;
                    COUIBottomSheetDialog.this.setPulledUpViewPaddingBottom(0);
                    ((COUIBottomSheetBehavior) COUIBottomSheetDialog.this.getBehavior()).setStateInternal(3);
                }
                COUIBottomSheetDialog.this.setCanPullUp(true);
            }

            @Override // c4.j
            public void onSpringUpdate(c4.g gVar) {
                if (COUIBottomSheetDialog.this.mPanelSpringBackAnim != null && COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout != null) {
                    if (gVar.t() && gVar.g() == 0.0d) {
                        COUIBottomSheetDialog.this.mPanelSpringBackAnim.k();
                        return;
                    }
                    int c11 = (int) gVar.c();
                    COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.offsetTopAndBottom(c11 - COUIBottomSheetDialog.this.mCurrentSpringTotalOffset);
                    COUIBottomSheetDialog.this.mCurrentSpringTotalOffset = c11;
                    COUIBottomSheetDialog.this.setPulledUpViewPaddingBottom(i10 - c11);
                }
            }

            @Override // c4.j
            public void onSpringActivate(c4.g gVar) {
            }

            @Override // c4.j
            public void onSpringEndStateChange(c4.g gVar) {
            }
        });
        this.mPanelSpringBackAnim.n(i10);
    }

    private void enforceChangeScreenWidth() {
        if (this.mPreferWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            Configuration configuration = resources.getConfiguration();
            this.mOriginWidth = configuration.screenWidthDp;
            configuration.screenWidthDp = this.mPreferWidth;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "enforceChangeScreenWidth : OriginWidth=" + this.mOriginWidth + " ,PreferWidth:" + this.mPreferWidth);
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null) {
                cOUIPanelPercentFrameLayout.setPreferWidth(this.mPreferWidth);
            }
        } catch (Exception unused) {
            Log.d(TAG, "enforceChangeScreenWidth : failed to updateConfiguration");
        }
    }

    private void ensureDraggableContentLayout() {
        if (this.mDraggableConstraintLayout == null) {
            createPanelConstraintLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentViewHeightWithMargins() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            return cOUIPanelPercentFrameLayout.getMeasuredHeight() + COUIViewMarginUtil.getMargin(this.mDesignBottomSheetFrameLayout, 3);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getFocusChange() {
        Boolean bool = this.mFocusChange;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private Rect getLocationRectInScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        return new Rect(i10, iArr[1], view.getMeasuredWidth() + i10, iArr[1] + view.getMeasuredHeight());
    }

    private int getNavColor(Configuration configuration) {
        int i10 = this.mNavColor;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        if (this.mIsHandlePanel) {
            return COUIContextUtil.getAttrColor(getContext(), X8.c.f4353L);
        }
        if (configuration == null) {
            return getContext().getResources().getColor(C0571c.f12874c);
        }
        return getContext().createConfigurationContext(configuration).getResources().getColor(C0571c.f12874c);
    }

    private COUIPanelPullUpListener getPanelPullUpListener() {
        return new COUIPanelPullUpListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.18
            private int mLastPosition = -1;

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onCancel() {
                COUIBottomSheetDialog.this.setPulledUpViewPaddingBottom(0);
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public int onDragging(int i10, int i11) {
                if (COUIBottomSheetDialog.this.mPanelSpringBackAnim != null && COUIBottomSheetDialog.this.mPanelSpringBackAnim.g() != 0.0d) {
                    COUIBottomSheetDialog.this.mPanelSpringBackAnim.k();
                    return COUIBottomSheetDialog.this.mParentViewPaddingBottom;
                }
                int b10 = E.a.b((int) (COUIBottomSheetDialog.this.mPulledUpView.getPaddingBottom() - (i10 * 0.19999999f)), 0, Math.min(COUIBottomSheetDialog.this.mPullUpMaxOffset, COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getTop()));
                if (COUIBottomSheetDialog.this.mParentViewPaddingBottom != b10) {
                    COUIBottomSheetDialog.this.mParentViewPaddingBottom = b10;
                    COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog.setPulledUpViewPaddingBottom(cOUIBottomSheetDialog.mParentViewPaddingBottom);
                }
                return COUIBottomSheetDialog.this.mParentViewPaddingBottom;
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onDraggingPanel() {
                boolean unused = COUIBottomSheetDialog.this.mIsInTinyScreen;
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onOffsetChanged(float f10) {
                if (this.mLastPosition == -1) {
                    this.mLastPosition = COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getHeight();
                }
                if (COUIBottomSheetDialog.this.mDialogOffsetListener != null) {
                    COUIBottomSheetDialog.this.mDialogOffsetListener.onDialogOffsetChanged(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getTop());
                }
                if (COUIBottomSheetDialog.this.mIsNeedOutsideViewAnim) {
                    if (!COUIBottomSheetDialog.this.mIsExecutingDismissAnim) {
                        float outsideViewAlpha = COUIBottomSheetDialog.this.getOutsideViewAlpha(f10);
                        COUIBottomSheetDialog.this.mOutsideView.setAlpha(outsideViewAlpha);
                        COUIBottomSheetDialog.this.mCurrentOutsideAlpha = outsideViewAlpha;
                    }
                    if ((!COUIPanelMultiWindowUtils.isSmallScreen(COUIBottomSheetDialog.this.getContext(), null)) && COUINavigationBarUtil.isNavigationBarShow(COUIBottomSheetDialog.this.getContext()) && ((!COUIBottomSheetDialog.this.mIsHandlePanel || COUIBottomSheetDialog.this.shouldHandlePanelUpdateNavBarColor()) && COUIBottomSheetDialog.this.getWindow() != null && ((int) (COUIBottomSheetDialog.this.mOutsideViewBackgroundAlpha * f10)) != 0 && !COUINavigationBarUtil.isGestureNavigation(COUIBottomSheetDialog.this.getContext()))) {
                        COUIBottomSheetDialog.this.setNavigationBarColorAlpha(f10);
                    }
                }
                if (COUIBottomSheetDialog.this.mPanelBarView != null && f10 != 1.0f && COUIBottomSheetDialog.this.mIsInTinyScreen) {
                    COUIBottomSheetDialog.this.mPanelBarView.setPanelOffset(this.mLastPosition - ((int) (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getHeight() * f10)));
                    this.mLastPosition = (int) (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getHeight() * f10);
                }
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onReleased(int i10) {
                COUIBottomSheetDialog.this.setCanPullUp(false);
                int top = COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getTop() - (i10 - COUIBottomSheetDialog.this.mParentViewPaddingBottom);
                COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                cOUIBottomSheetDialog.doSpringBackReboundAnim(cOUIBottomSheetDialog.mParentViewPaddingBottom - top);
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onReleasedDrag() {
                boolean unused = COUIBottomSheetDialog.this.mIsInTinyScreen;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator.AnimatorListener getPanelShowAnimListener() {
        return new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.17
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout != null) {
                    if (!COUIBottomSheetDialog.this.isFollowHand() && !COUIBottomSheetDialog.this.isFadeInCenter()) {
                        COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setTranslationY(COUIBottomSheetDialog.this.mCurrentParentViewTranslationY);
                    }
                    if (COUIBottomSheetDialog.this.getBehavior() != null && COUIBottomSheetDialog.this.getBehavior().getState() == 3 && COUIBottomSheetDialog.this.mCanPerformHapticFeedback) {
                        COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.performHapticFeedback(14);
                    }
                }
                if (COUIBottomSheetDialog.this.mShowListener != null) {
                    COUIBottomSheetDialog.this.mShowListener.onShowAnimationEnd();
                }
                if (COUIBottomSheetDialog.this.mAnimationListener != null) {
                    COUIBottomSheetDialog.this.mAnimationListener.onShowAnimationEnd();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUIBottomSheetDialog.this.getBehavior() != null && COUIBottomSheetDialog.this.getBehavior().getState() == 5) {
                    ((COUIBottomSheetBehavior) COUIBottomSheetDialog.this.getBehavior()).setPanelState(3);
                }
                if (COUIBottomSheetDialog.this.mAnimationListener != null) {
                    COUIBottomSheetDialog.this.mAnimationListener.onShowAnimationStart();
                }
            }
        };
    }

    private Drawable getTypedArrayDrawable(TypedArray typedArray, int i10, int i11) {
        Drawable drawable;
        if (typedArray != null) {
            drawable = typedArray.getDrawable(i10);
        } else {
            drawable = null;
        }
        if (drawable == null) {
            return getContext().getResources().getDrawable(i11, getContext().getTheme());
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBehaviorStateChange(View view, int i10) {
        if (i10 != 2) {
            if (i10 != 3) {
                if (i10 == 5) {
                    dismiss();
                    return;
                }
                return;
            } else {
                this.mAdjustResizeEnable = true;
                this.mWindowInsetsAnimEnable = false;
                return;
            }
        }
        if (needHideKeyboardWhenSettling()) {
            hideKeyboard();
        }
    }

    private boolean hasEditText(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof EditText) || (childAt instanceof COUIInputView)) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasEditText((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean haveEnoughSpace() {
        View view;
        if (this.mDesignBottomSheetFrameLayout == null || (view = this.mAnchorView) == null) {
            return false;
        }
        Rect locationRectInScreen = getLocationRectInScreen(view);
        int measuredWidth = this.mDesignBottomSheetFrameLayout.getMeasuredWidth();
        int measuredHeight = this.mDesignBottomSheetFrameLayout.getMeasuredHeight();
        Rect locationRectInScreen2 = getLocationRectInScreen(((ViewGroup) this.mAnchorView.getRootView()).getChildAt(0));
        int navigationBarHeight = COUINavigationBarUtil.getNavigationBarHeight(getContext());
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(X8.f.f4740m0);
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(X8.f.f4756o0);
        if ((locationRectInScreen.left - measuredWidth) - dimensionPixelOffset2 <= locationRectInScreen2.left && locationRectInScreen.right + measuredWidth + dimensionPixelOffset2 >= locationRectInScreen2.right && ((locationRectInScreen.top - measuredHeight) - this.mCoordinatorLayoutMinInsetsTop) - dimensionPixelOffset <= locationRectInScreen2.top && locationRectInScreen.bottom + measuredHeight + navigationBarHeight + dimensionPixelOffset >= locationRectInScreen2.bottom) {
            Log.d(TAG, "anchor view have no enoughSpace anchorContentViewLocationRect: " + locationRectInScreen2);
            this.mDesignBottomSheetFrameLayout.setHasAnchor(false);
            this.mDesignBottomSheetFrameLayout.setElevation(0.0f);
            this.mOutsideView.setAlpha(1.0f);
            return false;
        }
        Log.d(TAG, "anchor view haveEnoughSpace");
        this.mDesignBottomSheetFrameLayout.setHasAnchor(true);
        this.mDesignBottomSheetFrameLayout.setTop(0);
        this.mDesignBottomSheetFrameLayout.setBottom(measuredHeight);
        ShadowUtils.setElevationToView(this.mDesignBottomSheetFrameLayout, 3, getContext().getResources().getDimensionPixelOffset(C0572d.f12881d), androidx.core.content.b.c(getContext(), C0571c.f12873b));
        this.mOutsideView.setAlpha(0.0f);
        setCanPullUp(false);
        getBehavior().setDraggable(false);
        return true;
    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            if (getWindow() != null) {
                this.mAdjustResizeEnable = false;
            }
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null) {
                this.mInputMethodManager.hideSoftInputFromWindow(cOUIPanelPercentFrameLayout.getWindowToken(), 0);
            }
        }
    }

    private void initBehavior() {
        int i10;
        boolean z10;
        if (getBehavior() instanceof COUIBottomSheetBehavior) {
            COUIBottomSheetBehavior cOUIBottomSheetBehavior = (COUIBottomSheetBehavior) getBehavior();
            cOUIBottomSheetBehavior.applyPhysics(this.mPhysicsFrequency, this.mPhysicsDampingRatio);
            cOUIBottomSheetBehavior.setGlobalDrag(this.mGlobalDrag);
            cOUIBottomSheetBehavior.setIsInTinyScreen(this.mIsInTinyScreen);
            cOUIBottomSheetBehavior.setPanelPeekHeight(this.mPeekHeight);
            cOUIBottomSheetBehavior.setPanelSkipCollapsed(this.mSkipCollapsed);
            cOUIBottomSheetBehavior.setIsHandlePanel(this.mIsHandlePanel);
            int i11 = 4;
            if (this.mIsHandlePanel) {
                if (COUIPanelMultiWindowUtils.isNormalLandScreen(getContext(), this.mConfiguration)) {
                    i10 = 4;
                    z10 = true;
                } else {
                    i10 = 6;
                    z10 = false;
                }
                cOUIBottomSheetBehavior.setFitToContents(z10);
                cOUIBottomSheetBehavior.setGestureInsetBottomIgnored(true);
                setIsNeedOutsideViewAnim(false);
            } else {
                i10 = 3;
            }
            if (!this.mFirstShowCollapsed) {
                i11 = i10;
            }
            cOUIBottomSheetBehavior.setPanelState(i11);
            cOUIBottomSheetBehavior.addBottomSheetCallback(new COUIBottomSheetBehavior.COUIBottomSheetCallback() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.2
                @Override // com.coui.appcompat.panel.COUIBottomSheetBehavior.COUIBottomSheetCallback
                public void onStateChanged(View view, int i12) {
                    if (COUIBottomSheetDialog.DEBUG) {
                        Log.d(COUIBottomSheetDialog.TAG, "onStateChanged: newState=" + i12);
                    }
                    COUIBottomSheetDialog.this.handleBehaviorStateChange(view, i12);
                }

                @Override // com.coui.appcompat.panel.COUIBottomSheetBehavior.COUIBottomSheetCallback
                public void onSlide(View view, float f10) {
                }
            });
            if (DEBUG) {
                Log.d(TAG, "initBehavior: peekHeight=" + this.mPeekHeight + " mSkipCollapsed=" + this.mSkipCollapsed + " mIsHandlePanel=" + this.mIsHandlePanel + " mFirstShowCollapsed=" + this.mFirstShowCollapsed + " state=" + i11);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Must use COUIBottomSheetBehavior, check value of bottom_sheet_behavior in strings.xml");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCoordinateInsets(WindowInsets windowInsets) {
        View view = this.mCoordinatorLayout;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(C0572d.f12884g);
            if (this.mIsHandlePanel) {
                this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(C0572d.f12886i);
            }
            if (this.mIsInTinyScreen) {
                if (this.mIsFullScreenInTinyScreen) {
                    this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(C0572d.f12903z);
                } else {
                    this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(C0572d.f12876B);
                }
            }
            layoutParams.topMargin = this.mCoordinatorLayoutMinInsetsTop;
            this.mCoordinatorLayout.setLayoutParams(layoutParams);
            COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
            if (cOUIPanelContentLayout != null) {
                cOUIPanelContentLayout.setNavigationMargin(this.mConfiguration, layoutParams.bottomMargin, windowInsets);
            }
        }
    }

    private void initDraggableConstraintLayoutSize() {
        setPanelWidth();
        setPanelHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMaxHeight(WindowInsets windowInsets) {
        boolean z10;
        int i10;
        if (this.mPanelHeight >= COUIPanelMultiWindowUtils.getPanelMaxHeight(getContext(), null, windowInsets, this.mIsHandlePanel)) {
            z10 = true;
        } else {
            z10 = false;
        }
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams = cOUIPanelPercentFrameLayout.getLayoutParams();
            if (!this.mIsShowInMaxHeight && !z10) {
                i10 = -2;
            } else {
                i10 = -1;
            }
            layoutParams.height = i10;
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            if (this.mIsShowInMaxHeight || z10) {
                cOUIPanelContentLayout.getLayoutParams().height = -1;
            }
        }
    }

    private void initNavigationView() {
        if (unNeedNavigationCustomView()) {
            if (this.mNavigationCustomView != null && (this.mContainerFrameLayout.getParent() instanceof FrameLayout)) {
                FrameLayout frameLayout = (FrameLayout) this.mContainerFrameLayout.getParent();
                if (frameLayout.indexOfChild(this.mNavigationCustomView) != -1) {
                    frameLayout.removeView(this.mNavigationCustomView);
                }
                this.mNavigationCustomView = null;
                return;
            }
            return;
        }
        if (this.mNavigationCustomView == null) {
            this.mNavigationCustomView = new View(getContext());
        }
        setNavigationBarColor(getNavColor(null));
        if (this.mContainerFrameLayout.getParent() instanceof FrameLayout) {
            FrameLayout frameLayout2 = (FrameLayout) this.mContainerFrameLayout.getParent();
            if (frameLayout2.indexOfChild(this.mNavigationCustomView) == -1) {
                frameLayout2.addView(this.mNavigationCustomView, new FrameLayout.LayoutParams(-1, Math.max(0, COUINavigationBarUtil.getNavigationBarHeight(getContext())), 80));
            }
        }
    }

    private void initPhysics() {
        if (this.mAppearStiffness == PHYSICS_UNSET) {
            this.mAppearStiffness = 200.0f;
        }
        if (this.mAppearDampingRatio == PHYSICS_UNSET) {
            this.mAppearDampingRatio = DEFAULT_SPRING_DAMPING_RATIO;
        }
        this.mAppearSpringForce = new g(0.0f).f(this.mAppearStiffness).d(this.mAppearDampingRatio);
        f x10 = new f(new e()).x(this.mAppearSpringForce);
        this.mAppearSpringAnim = x10;
        x10.b(this);
        this.mAppearSpringAnim.a(this);
    }

    private void initThemeResources(int i10) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0577i.f12934a, C0569a.f12867a, i10);
        this.mPanelDragViewDrawable = getTypedArrayDrawable(obtainStyledAttributes, C0577i.f12940g, C0573e.f12906c);
        this.mPanelDragViewDrawableTintColor = obtainStyledAttributes.getColor(C0577i.f12941h, COUIContextUtil.getAttrColor(getContext(), X8.c.f4394n));
        this.mPanelBackground = getTypedArrayDrawable(obtainStyledAttributes, C0577i.f12938e, C0573e.f12905b);
        this.mPanelBackgroundTintColor = obtainStyledAttributes.getColor(C0577i.f12939f, COUIContextUtil.getAttrColor(getContext(), X8.c.f4353L));
        this.mHandleViewHasPressAnim = obtainStyledAttributes.getBoolean(C0577i.f12935b, true);
        this.mIsShowInMaxHeight = obtainStyledAttributes.getBoolean(C0577i.f12937d, true);
        boolean z10 = obtainStyledAttributes.getBoolean(C0577i.f12936c, false);
        this.mIsHandlePanel = z10;
        if (z10 && this.mSkipCollapsed) {
            this.mSkipCollapsed = false;
        }
        obtainStyledAttributes.recycle();
        Drawable drawable = this.mPanelBackground;
        if (drawable != null) {
            drawable.setTint(this.mPanelBackgroundTintColor);
        }
    }

    private void initValueResources() {
        this.mPullUpMaxOffset = (int) getContext().getResources().getDimension(C0572d.f12877C);
        this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(C0572d.f12902y);
        this.mCoordinatorLayoutPaddingExtra = getContext().getResources().getDimensionPixelOffset(C0572d.f12875A);
        this.mOutsideViewBackgroundAlpha = Color.alpha(getContext().getResources().getColor(X8.e.f4444j));
        boolean isGestureNavigation = COUINavigationBarUtil.isGestureNavigation(getContext());
        this.mIsGestureNavigation = isGestureNavigation;
        if (isGestureNavigation) {
            this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(C0572d.f12894q);
        } else {
            this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(C0572d.f12893p);
        }
    }

    private void initView() {
        int i10;
        this.mContainerFrameLayout = (IgnoreWindowInsetsFrameLayout) findViewById(C0574f.f12909c);
        this.mOutsideView = findViewById(C0574f.f12919m);
        this.mCoordinatorLayout = findViewById(C0574f.f12910d);
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = (COUIPanelPercentFrameLayout) findViewById(X8.h.f4897N);
        this.mDesignBottomSheetFrameLayout = cOUIPanelPercentFrameLayout;
        cOUIPanelPercentFrameLayout.setIsHandlePanel(this.mIsHandlePanel);
        this.mPanelBarView = (COUIPanelBarView) findViewById(C0574f.f12918l);
        ViewGroup.LayoutParams layoutParams = this.mDesignBottomSheetFrameLayout.getLayoutParams();
        if (this.mIsShowInMaxHeight) {
            i10 = -1;
        } else {
            i10 = -2;
        }
        layoutParams.height = i10;
        if (isFollowHand()) {
            this.mDesignBottomSheetFrameLayout.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.3
                @Override // java.lang.Runnable
                public void run() {
                    if (COUIBottomSheetDialog.this.haveEnoughSpace()) {
                        ShadowUtils.setElevationToView(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, 3, COUIBottomSheetDialog.this.getContext().getResources().getDimensionPixelOffset(C0572d.f12881d), androidx.core.content.b.c(COUIBottomSheetDialog.this.getContext(), C0571c.f12873b));
                        COUIBottomSheetDialog.this.setCanPullUp(false);
                        COUIBottomSheetDialog.this.getBehavior().setDraggable(false);
                    }
                }
            });
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            cOUIPanelContentLayout.setLayoutAtMaxHeight(this.mIsShowInMaxHeight);
        }
        this.mPulledUpView = this.mDesignBottomSheetFrameLayout;
        checkInitState();
        this.mOutsideView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIBottomSheetDialog.this.mCancelable && COUIBottomSheetDialog.this.isShowing() && COUIBottomSheetDialog.this.mCanceledOnTouchOutside) {
                    COUIBottomSheetDialog.this.cancel();
                }
            }
        });
        this.mDesignBottomSheetFrameLayout.setBackground(this.mPanelBackground);
        initNavigationView();
    }

    private void initWindow() {
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setLayout(-1, -1);
            window.setGravity(80);
        }
    }

    private void initWindowInsetsListener() {
        if (this.mShouldRegisterWindowInsetsListener && getWindow() != null && this.mWindowInsetsListener == null) {
            View decorView = getWindow().getDecorView();
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = new View.OnApplyWindowInsetsListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.5
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    ViewGroup viewGroup;
                    ViewGroup viewGroup2;
                    if (view != null && view.getLayoutParams() != null) {
                        COUIBottomSheetDialog.this.initCoordinateInsets(windowInsets);
                        COUIBottomSheetDialog.this.initMaxHeight(windowInsets);
                        if (COUIBottomSheetDialog.this.mInputMethodManager == null) {
                            COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                            cOUIBottomSheetDialog.mInputMethodManager = (InputMethodManager) cOUIBottomSheetDialog.getContext().getSystemService("input_method");
                        }
                        boolean z10 = COUIBottomSheetDialog.this.getContext().getResources().getBoolean(C0570b.f12870b);
                        ViewGroup viewGroup3 = (ViewGroup) COUIBottomSheetDialog.this.findViewById(X8.h.f4897N);
                        ViewGroup viewGroup4 = (ViewGroup) COUIBottomSheetDialog.this.findViewById(C0574f.f12911e);
                        if (z10) {
                            viewGroup3 = viewGroup4;
                        }
                        ViewGroup viewGroup5 = COUIBottomSheetDialog.this.mAdjustLayout;
                        COUIBottomSheetDialog cOUIBottomSheetDialog2 = COUIBottomSheetDialog.this;
                        if (!z10) {
                            viewGroup = cOUIBottomSheetDialog2.mDesignBottomSheetFrameLayout;
                        } else {
                            viewGroup = cOUIBottomSheetDialog2.mDraggableConstraintLayout;
                        }
                        if (viewGroup5 != viewGroup) {
                            COUIViewMarginUtil.setMargin(COUIBottomSheetDialog.this.mAdjustLayout, 3, 0);
                        }
                        COUIBottomSheetDialog cOUIBottomSheetDialog3 = COUIBottomSheetDialog.this;
                        if (!z10) {
                            viewGroup2 = cOUIBottomSheetDialog3.mDesignBottomSheetFrameLayout;
                        } else {
                            viewGroup2 = cOUIBottomSheetDialog3.mDraggableConstraintLayout;
                        }
                        cOUIBottomSheetDialog3.mAdjustLayout = viewGroup2;
                        if (COUIBottomSheetDialog.this.mAdjustLayout != null) {
                            viewGroup3 = COUIBottomSheetDialog.this.mAdjustLayout;
                        }
                        ViewGroup viewGroup6 = viewGroup3;
                        if (COUIBottomSheetDialog.this.mAdjustResizeEnable) {
                            COUIBottomSheetDialog.this.getAdjustResizeHelper().adjustResize(COUIBottomSheetDialog.this.getContext(), viewGroup6, windowInsets, COUIBottomSheetDialog.this.mCoordinatorLayout, COUIBottomSheetDialog.this.getFocusChange());
                        }
                        COUIBottomSheetDialog.this.largeScreenLimitMaxSize();
                        COUIBottomSheetDialog.this.setNavigationCustomViewHeight(windowInsets);
                        COUIBottomSheetDialog.this.mApplyWindowInsets = windowInsets;
                        view.onApplyWindowInsets(COUIBottomSheetDialog.this.mApplyWindowInsets);
                        return COUIBottomSheetDialog.this.mApplyWindowInsets;
                    }
                    return windowInsets;
                }
            };
            this.mWindowInsetsListener = onApplyWindowInsetsListener;
            decorView.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFadeInCenter() {
        if (this.mDesignBottomSheetFrameLayout.getRatio() == 2.0f && (getBehavior() == null || (getBehavior() != null && getBehavior().getState() != 4))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFadeInCenterAllState() {
        if (this.mDesignBottomSheetFrameLayout.getRatio() == 2.0f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFollowHand() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout;
        if (this.mAnchorView != null && (cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout) != null && cOUIPanelPercentFrameLayout.getRatio() == 2.0f && this.mAnchorView.isAttachedToWindow()) {
            return true;
        }
        return false;
    }

    private boolean isInMultiWindowMode() {
        WeakReference<Activity> weakReference = this.mActivityWeakReference;
        if (weakReference != null && weakReference.get() != null && COUIPanelMultiWindowUtils.isInMultiWindowMode(this.mActivityWeakReference.get())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFrameRate$0(AnimationVelocityCalculator animationVelocityCalculator, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        float calculator = animationVelocityCalculator.calculator(this.mDesignBottomSheetFrameLayout.getHeight(), valueAnimator);
        COUILog.d(TAG, "DynamicFrameRateManager.getSuggestFrameRate: v " + calculator + " frame " + DynamicFrameRateManager.getSuggestFrameRate(calculator, 2));
        DynamicFrameRateManager.setFrameRate(this.mDesignBottomSheetFrameLayout, 10101, (int) calculator, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void largeScreenLimitMaxSize() {
        int max;
        int i10;
        if (this.mDesignBottomSheetFrameLayout == null) {
            return;
        }
        int i11 = getContext().getResources().getConfiguration().screenWidthDp;
        int i12 = getContext().getResources().getConfiguration().screenHeightDp;
        if (this.isLargeScreenLimitMaxSize && COUIResponsiveUtils.isLargePadWindow(getContext(), i11, i12)) {
            if (!COUIPanelMultiWindowUtils.isInMultiWindowMode(COUIPanelMultiWindowUtils.contextToActivity(getContext()))) {
                i10 = Math.min(UIUtil.getScreenHeightRealSize(getContext()), UIUtil.getScreenWidthRealSize(getContext()));
                max = Math.max(UIUtil.getScreenHeightRealSize(getContext()), UIUtil.getScreenWidthRealSize(getContext()));
            } else {
                float f10 = i12;
                float f11 = i11;
                int min = Math.min(UIUtil.dip2px(getContext(), f10), UIUtil.dip2px(getContext(), f11));
                max = Math.max(UIUtil.dip2px(getContext(), f10), UIUtil.dip2px(getContext(), f11));
                i10 = min;
            }
            this.mDesignBottomSheetFrameLayout.setMaxSize((int) COUIResponsiveUtils.calculateWidth(max, i10, this.mDesignBottomSheetFrameLayout.getGridNumber(), this.mDesignBottomSheetFrameLayout.getPaddingType(), this.mDesignBottomSheetFrameLayout.getPaddingSize(), getContext()), i10 - (this.mCoordinatorLayoutMinInsetsTop * 2));
            return;
        }
        this.mDesignBottomSheetFrameLayout.restoreDefaultMaxSize();
    }

    private boolean needHideKeyboardWhenSettling() {
        return ((COUIBottomSheetBehavior) getBehavior()).isCanHideKeyboard();
    }

    private int normalizePoints(int i10, int i11) {
        return Math.max(0, Math.min(i10, i11));
    }

    private void offsetViewTo() {
        int[] calculateFinalLocationOnScreen = calculateFinalLocationOnScreen(this.mAnchorView);
        this.mDesignBottomSheetFrameLayout.setX(calculateFinalLocationOnScreen[0]);
        this.mDesignBottomSheetFrameLayout.setY(calculateFinalLocationOnScreen[1]);
        this.mCurrentParentViewTranslationY = this.mDesignBottomSheetFrameLayout.getY();
    }

    private void refreshParams() {
        if (!COUIPanelMultiWindowUtils.isVirtualNavigation(getContext())) {
            resetParentViewStyle(getContext().getResources().getConfiguration());
            resetNavigationBarColor(null);
        }
    }

    private void registerApplicationConfigChangeListener() {
        getContext().registerComponentCallbacks(this.mComponentCallbacks);
    }

    private void registerBehaviorPullUpListener() {
        COUIPanelPullUpListener cOUIPanelPullUpListener;
        if (getBehavior() instanceof COUIBottomSheetBehavior) {
            if (this.mCanPullUp) {
                cOUIPanelPullUpListener = getPanelPullUpListener();
            } else {
                cOUIPanelPullUpListener = null;
            }
            this.mPanelPullUpListener = cOUIPanelPullUpListener;
            ((COUIBottomSheetBehavior) getBehavior()).setPullUpListener(this.mPanelPullUpListener);
        }
    }

    private void registerPreDrawListener() {
        View view = this.mOutsideView;
        if (view != null) {
            view.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    private void releaseApplicationConfigChangeListener() {
        if (this.mComponentCallbacks != null) {
            getContext().unregisterComponentCallbacks(this.mComponentCallbacks);
        }
    }

    private void releaseApplyWindowInsetsListener() {
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setOnApplyWindowInsetsListener(null);
            this.mWindowInsetsListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseBehaviorPullUpListener() {
        if (getBehavior() instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) getBehavior()).setPullUpListener(null);
            this.mPanelPullUpListener = null;
        }
    }

    private void releaseResizeHelper() {
        COUIPanelAdjustResizeHelper cOUIPanelAdjustResizeHelper = this.mAdjustResizeHelper;
        if (cOUIPanelAdjustResizeHelper != null) {
            cOUIPanelAdjustResizeHelper.releaseData();
            this.mAdjustResizeHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOnPreDrawListener() {
        View view = this.mOutsideView;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    private void resetNavigationBarColor(Configuration configuration) {
        setNavigationBarColor(getNavColor(configuration));
    }

    private void resetParentViewStyle(Configuration configuration) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout == null) {
            return;
        }
        COUIViewMarginUtil.setMargin(cOUIPanelPercentFrameLayout, 3, 0);
    }

    private void resetWindowImeAnimFlags() {
        this.mAdjustResizeEnable = true;
        int i10 = 0;
        this.mIsNeedShowKeyboard = false;
        Window window = getWindow();
        getAdjustResizeHelper().setWindowType(window.getAttributes().type);
        int i11 = window.getAttributes().softInputMode & 15;
        if (i11 == 5 && !isInMultiWindowMode() && !this.mIsInWindowFloatingMode) {
            this.mIsNeedShowKeyboard = true;
        } else {
            i10 = i11;
        }
        window.setSoftInputMode(i10 | 16);
    }

    public static int resolveDialogTheme(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0569a.f12867a, typedValue, true);
        return typedValue.resourceId;
    }

    private void restoreScreenWidth() {
        if (this.mOriginWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.screenWidthDp = this.mOriginWidth;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "restoreScreenWidth : PreferWidth=" + this.mPreferWidth + " ,OriginWidth=" + this.mOriginWidth);
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null) {
                cOUIPanelPercentFrameLayout.delPreferWidth();
            }
        } catch (Exception unused) {
            Log.d(TAG, "restoreScreenWidth : failed to updateConfiguration");
        }
    }

    private void saveActivityContextToGetMultiWindowInfo(Context context) {
        if (context instanceof Activity) {
            this.mActivityWeakReference = new WeakReference<>((Activity) context);
        }
    }

    private void setContentViewLocal(View view) {
        if (!this.mIsShowInDialogFragment) {
            ensureDraggableContentLayout();
            this.mDraggableConstraintLayout.removeContentView();
            this.mDraggableConstraintLayout.addContentView(view);
            super.setContentView(this.mDraggableConstraintLayout);
        } else {
            super.setContentView(view);
        }
        this.mContentView = view;
    }

    private void setFocusChangeFalseIfHasnotEdittext() {
        if (this.mFocusChange == null && hasEditText((ViewGroup) getWindow().getDecorView().getRootView())) {
            this.mFocusChange = Boolean.TRUE;
        }
    }

    private void setFrameRate(final ValueAnimator valueAnimator) {
        if (!this.mIsVSdk || this.mDesignBottomSheetFrameLayout == null) {
            return;
        }
        int i10 = this.mADFRFeatureType;
        if (i10 == 2) {
            final AnimationVelocityCalculator animationVelocityCalculator = new AnimationVelocityCalculator(valueAnimator);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIBottomSheetDialog.this.lambda$setFrameRate$0(animationVelocityCalculator, valueAnimator, valueAnimator2);
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    COUILog.d(COUIBottomSheetDialog.TAG, "LEVEL_HIGH_PRECISION onAnimatorEnd: DynamicFrameRateManager.FRAME_RATE_END");
                    DynamicFrameRateManager.setFrameRate(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, 10101, -2, (Bundle) null);
                }
            });
        } else if (i10 == 1) {
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.11
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    COUILog.d(COUIBottomSheetDialog.TAG, "LEVEL_LOW_PRECISION onAnimatorEnd: DynamicFrameRateManager.FRAME_RATE_END");
                    DynamicFrameRateManager.setFrameRate(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, 10101, -2, (Bundle) null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    COUILog.d(COUIBottomSheetDialog.TAG, "LEVEL_LOW_PRECISION onAnimatorStart: DynamicFrameRateManager.LOW_PRECISION_FRAME_RATE");
                    DynamicFrameRateManager.setFrameRate(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, 10101, -1, (Bundle) null);
                }
            });
        } else if (i10 == 0) {
            COUILog.d(TAG, "LEVEL_DEFAULT do nothing");
        }
    }

    private void setNavigation() {
        if (this.mIsGestureNavigation) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 512);
            getWindow().setNavigationBarContrastEnforced(false);
            setNavigationBarColor(0);
            return;
        }
        getWindow().setDecorFitsSystemWindows(false);
        getWindow().setNavigationBarContrastEnforced(false);
    }

    private void setNavigationBarColor(int i10) {
        if (unNeedNavigationCustomView()) {
            getWindow().setNavigationBarColor(i10);
        } else {
            getWindow().setNavigationBarColor(0);
        }
        setNavigationCustomViewColor(i10);
        COUILog.d(TAG, "setNavigationBarColor color: " + Integer.toHexString(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationBarColorAlpha(float f10) {
        int i10 = (int) (f10 * this.mOutsideViewBackgroundAlpha);
        if (i10 > 0) {
            setNavigationBarColor(Color.argb(i10, 0, 0, 0));
        } else {
            setNavigationBarColor(0);
            getWindow().setNavigationBarContrastEnforced(false);
        }
    }

    private void setNavigationCustomViewColor(int i10) {
        View view;
        if (!unNeedNavigationCustomView() && (view = this.mNavigationCustomView) != null) {
            view.setBackgroundColor(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationCustomViewHeight(WindowInsets windowInsets) {
        if (!unNeedNavigationCustomView() && windowInsets != null && this.mNavigationCustomView != null) {
            int i10 = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
            this.mNavigationCustomView.getLayoutParams().height = Math.max(0, i10);
        }
    }

    private void setPanelHeight() {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            ViewGroup.LayoutParams layoutParams = cOUIPanelContentLayout.getLayoutParams();
            int i10 = this.mPanelHeight;
            if (i10 != 0) {
                layoutParams.height = i10;
            }
            this.mDraggableConstraintLayout.setLayoutParams(layoutParams);
        }
        WindowInsets windowInsets = this.mApplyWindowInsets;
        if (windowInsets != null) {
            initMaxHeight(windowInsets);
        }
    }

    private void setPanelWidth() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams = cOUIPanelPercentFrameLayout.getLayoutParams();
            int i10 = this.mPanelWidth;
            if (i10 != 0) {
                layoutParams.width = i10;
            }
            this.mDesignBottomSheetFrameLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPulledUpViewPaddingBottom(int i10) {
        View view = this.mPulledUpView;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), this.mPulledUpView.getPaddingTop(), this.mPulledUpView.getPaddingRight(), i10);
        }
    }

    private void setSpringStartPosition(float f10) {
        this.mAppearSpringAnim.m(f10);
    }

    private void setStatusBarTransparentAndFont(Window window) {
        int i10;
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i11 = systemUiVisibility | 1024;
        window.setStatusBarColor(0);
        window.addFlags(Integer.MIN_VALUE);
        if (COUIDarkModeUtil.isNightMode(getContext())) {
            i10 = i11 & (-8209);
        } else {
            i10 = systemUiVisibility | 1280;
        }
        decorView.setSystemUiVisibility(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldHandlePanelUpdateNavBarColor() {
        if (this.mIsHandlePanel) {
            return COUIPanelMultiWindowUtils.isNormalLandScreen(getContext(), this.mConfiguration);
        }
        return false;
    }

    private void snapToTop() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            this.mSnapStartBottom = cOUIPanelPercentFrameLayout.getBottom();
        }
        this.mIsAppearSpringAnimStared = true;
        this.mAppearSpringAnim.p();
    }

    private void startReleaseAnim(Animator.AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mPanelViewTranslationAnimationSet.addListener(animatorListener);
        }
        this.mPanelViewTranslationAnimationSet.start();
    }

    private void startReleaseAnimFadeOut(Animator.AnimatorListener animatorListener) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getAlpha() != 1.0f) {
            this.mDesignBottomSheetFrameLayout.setAlpha(1.0f);
        }
        AnimatorSet animatorSet = this.mPanelViewTranslationAnimationSet;
        Interpolator interpolator = OUTSIDE_ALPHA_ANIM_INTERPOLATOR;
        animatorSet.playTogether(createOutsideAlphaAnimation(false, 167.0f, (PathInterpolator) interpolator), createDialogAlphaAnim(false, (PathInterpolator) interpolator));
        startReleaseAnim(animatorListener);
    }

    private void startReleaseAnimFollowHand(Animator.AnimatorListener animatorListener) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getAlpha() != 1.0f) {
            this.mDesignBottomSheetFrameLayout.setAlpha(1.0f);
        }
        if (haveEnoughSpace()) {
            this.mPanelViewTranslationAnimationSet.playTogether(createDialogAlphaAnim(false, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR));
        } else {
            AnimatorSet animatorSet = this.mPanelViewTranslationAnimationSet;
            Interpolator interpolator = OUTSIDE_ALPHA_ANIM_INTERPOLATOR;
            animatorSet.playTogether(createOutsideAlphaAnimation(false, 167.0f, (PathInterpolator) interpolator), createDialogAlphaAnim(false, (PathInterpolator) interpolator));
        }
        startReleaseAnim(animatorListener);
    }

    private void startReleaseAnimInTinyScreen(int i10, int i11, float f10, Animator.AnimatorListener animatorListener) {
        this.mPanelViewTranslationAnimationSet.playTogether(createPanelTranslateAnimation(i10, i11, this.mTranslateHidingDuration, new COUIOutEaseInterpolator()), createOutsideAlphaAnimation(false, DEFAULT_ALPHA_HIDING_ANIMATOR_DURATION, new COUIEaseInterpolator()));
        startReleaseAnim(animatorListener);
    }

    private void startShowingAnim(Animator.AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mPanelViewTranslationAnimationSet.addListener(animatorListener);
        }
        this.mPanelViewTranslationAnimationSet.start();
    }

    private void startShowingAnimFadeIn(Animator.AnimatorListener animatorListener) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getAlpha() != 0.0f) {
            this.mDesignBottomSheetFrameLayout.setAlpha(0.0f);
            this.mDesignBottomSheetFrameLayout.setScaleX(0.8f);
            this.mDesignBottomSheetFrameLayout.setScaleY(0.8f);
        }
        updateBottomSheetCenterVertical();
        AnimatorSet animatorSet = this.mPanelViewTranslationAnimationSet;
        Interpolator interpolator = OUTSIDE_ALPHA_ANIM_INTERPOLATOR;
        animatorSet.playTogether(createOutsideAlphaAnimation(true, 167.0f, (PathInterpolator) interpolator), createDialogAlphaAnim(true, (PathInterpolator) interpolator));
        startShowingAnim(animatorListener);
    }

    private void startShowingAnimFollowHand(Animator.AnimatorListener animatorListener) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getAlpha() != 0.0f) {
            this.mDesignBottomSheetFrameLayout.setAlpha(0.0f);
            this.mDesignBottomSheetFrameLayout.setScaleX(0.8f);
            this.mDesignBottomSheetFrameLayout.setScaleY(0.8f);
        }
        if (haveEnoughSpace()) {
            offsetViewTo();
            this.mPanelViewTranslationAnimationSet.playTogether(createDialogAlphaAnim(true, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR));
        } else {
            updateBottomSheetCenterVertical();
            AnimatorSet animatorSet = this.mPanelViewTranslationAnimationSet;
            Interpolator interpolator = OUTSIDE_ALPHA_ANIM_INTERPOLATOR;
            animatorSet.playTogether(createOutsideAlphaAnimation(true, 167.0f, (PathInterpolator) interpolator), createDialogAlphaAnim(true, (PathInterpolator) interpolator));
        }
        startShowingAnim(animatorListener);
    }

    private void startShowingAnimInTinyScreen(int i10, Animator.AnimatorListener animatorListener) {
        float contentViewHeightWithMargins;
        this.mPanelViewTranslationAnimationSet.playTogether(createOutsideAlphaAnimation(true, 167.0f, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR));
        if (this.mFirstShowCollapsed) {
            contentViewHeightWithMargins = this.mPeekHeight;
        } else {
            contentViewHeightWithMargins = getContentViewHeightWithMargins() + i10;
        }
        setSpringStartPosition(contentViewHeightWithMargins);
        snapToTop();
        startShowingAnim(animatorListener);
    }

    private void stopCurrentRunningViewTranslationAnim() {
        AnimatorSet animatorSet = this.mPanelViewTranslationAnimationSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mIsInterruptingAnim = true;
            this.mPanelViewTranslationAnimationSet.end();
        }
        if (this.mIsInTinyScreen && this.mIsAppearSpringAnimStared) {
            this.mAppearSpringAnim.c();
        }
    }

    private void stopFeedbackAnimation() {
        c4.g gVar = this.mDisableFastCloseFeedbackSpring;
        if (gVar != null && gVar.g() != 0.0d) {
            this.mDisableFastCloseFeedbackSpring.k();
            this.mDisableFastCloseFeedbackSpring = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void superDismiss() {
        if (DEBUG) {
            Log.d(TAG, "superDismiss");
        }
        try {
            super.dismiss();
            OnDismissAnimationEndListener onDismissAnimationEndListener = this.mDismissListener;
            if (onDismissAnimationEndListener != null) {
                onDismissAnimationEndListener.onDismissAnimationEnd();
            }
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    private boolean unNeedNavigationCustomView() {
        if (!this.mIsGestureNavigation && this.mDesignBottomSheetFrameLayout != null) {
            return false;
        }
        return true;
    }

    private void updateBottomSheetCenterVertical() {
        int i10;
        View view = this.mCoordinatorLayout;
        if (view == null) {
            Log.w(TAG, "updateBottomSheetCenterVertical: directly return for mCoordinatorLayout is null");
            return;
        }
        if (this.mDesignBottomSheetFrameLayout == null) {
            Log.i(TAG, "updateBottomSheetCenterVertical: directly return for mDesignBottomSheetFrameLayout is null");
            return;
        }
        int measuredHeight = view.getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = this.mDesignBottomSheetFrameLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            i10 = 0;
        }
        int max = (int) Math.max(0.0f, ((measuredHeight - i10) / this.mDesignBottomSheetFrameLayout.getRatio()) - (this.mDesignBottomSheetFrameLayout.getHeight() / this.mDesignBottomSheetFrameLayout.getRatio()));
        if (this.mDesignBottomSheetFrameLayout.getBottom() + max <= measuredHeight) {
            this.mDesignBottomSheetFrameLayout.setY(max);
        }
    }

    private void updateFitToContents() {
        if (!this.mIsHandlePanel) {
            return;
        }
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout == null) {
            Log.e(TAG, "updateFitToContents: mDesignBottomSheetFrameLayout is null");
        } else {
            COUIBottomSheetBehavior.from(cOUIPanelPercentFrameLayout).setFitToContents(COUIPanelMultiWindowUtils.isNormalLandScreen(getContext(), this.mConfiguration));
        }
    }

    private void updatePanelMarginBottom(Configuration configuration, WindowInsets windowInsets) {
        if (windowInsets != null && configuration != null) {
            ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) this.mDesignBottomSheetFrameLayout.getLayoutParams())).bottomMargin = COUIPanelMultiWindowUtils.getPanelMarginBottom(getContext(), configuration, windowInsets, this.mIsHandlePanel);
        }
    }

    public boolean canPullUp() {
        return this.mCanPullUp;
    }

    public void delPreferWidth() {
        restoreScreenWidth();
        this.mPreferWidth = -1;
        this.mOriginWidth = -1;
        Log.d(TAG, "delPreferWidth");
    }

    @Override // androidx.appcompat.app.i, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        stopFeedbackAnimation();
        dismiss(true);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        COUIPanelContentLayout cOUIPanelContentLayout;
        if (motionEvent.getAction() == 1 && (cOUIPanelContentLayout = this.mDraggableConstraintLayout) != null && cOUIPanelContentLayout.mIsTurnOnAnim) {
            cOUIPanelContentLayout.mIsTurnOnAnim = false;
            cOUIPanelContentLayout.dragBgEndAnim();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public COUIPanelAdjustResizeHelper getAdjustResizeHelper() {
        if (this.mAdjustResizeHelper == null) {
            this.mAdjustResizeHelper = new COUIPanelAdjustResizeHelper();
        }
        return this.mAdjustResizeHelper;
    }

    public boolean getCanPerformHapticFeedback() {
        return this.mCanPerformHapticFeedback;
    }

    public Button getCenterButton() {
        if (getWindow() != null) {
            return (Button) getWindow().findViewById(R.id.button3);
        }
        return null;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public int getDialogHeight() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            return cOUIPanelPercentFrameLayout.getHeight();
        }
        return 0;
    }

    public int getDialogMaxHeight() {
        View view = this.mCoordinatorLayout;
        if (view != null) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    public COUIPanelContentLayout getDragableLinearLayout() {
        return this.mDraggableConstraintLayout;
    }

    public boolean getIsHandlePanel() {
        return this.mIsHandlePanel;
    }

    public boolean getIsInWindowFloatingMode() {
        return this.mIsInWindowFloatingMode;
    }

    public Button getLeftButton() {
        if (getWindow() != null) {
            return (Button) getWindow().findViewById(R.id.button2);
        }
        return null;
    }

    public float getOutsideViewAlpha(float f10) {
        if (!this.mIsInTinyScreen) {
            return f10;
        }
        return Math.max(0.0f, f10 - 0.5f) * 2.0f;
    }

    public int getPeekHeight() {
        return this.mPeekHeight;
    }

    public Button getRightButton() {
        if (getWindow() != null) {
            return (Button) getWindow().findViewById(R.id.button1);
        }
        return null;
    }

    @Override // android.app.Dialog
    public void hide() {
        COUIPanelContentLayout cOUIPanelContentLayout;
        if (this.mIsShowInDialogFragment && (cOUIPanelContentLayout = this.mDraggableConstraintLayout) != null && cOUIPanelContentLayout.findFocus() != null) {
            return;
        }
        super.hide();
    }

    public void hideDragView() {
        COUIPanelBarView cOUIPanelBarView = this.mPanelBarView;
        if (cOUIPanelBarView != null) {
            cOUIPanelBarView.setVisibility(4);
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null && cOUIPanelContentLayout.getDrawLayout() != null) {
            setHideDragViewHeight();
            this.mDraggableConstraintLayout.getDrawLayout().setVisibility(4);
            if (this.mDraggableConstraintLayout.getDragBgView() != null) {
                this.mDraggableConstraintLayout.getDragBgView().setVisibility(8);
            }
        }
    }

    public boolean isFirstShowCollapsed() {
        return this.mFirstShowCollapsed;
    }

    public boolean isSkipCollapsed() {
        return this.mSkipCollapsed;
    }

    @Override // androidx.dynamicanimation.animation.c.q
    public void onAnimationEnd(androidx.dynamicanimation.animation.c cVar, boolean z10, float f10, float f11) {
        this.mIsAppearSpringAnimStared = false;
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null && this.mSnapStartBottom != -1) {
            cOUIPanelPercentFrameLayout.layout(cOUIPanelPercentFrameLayout.getLeft(), this.mDesignBottomSheetFrameLayout.getTop(), this.mDesignBottomSheetFrameLayout.getRight(), this.mSnapStartBottom);
        }
        this.mSnapStartBottom = -1;
        BottomSheetDialogAnimatorListener bottomSheetDialogAnimatorListener = this.mBottomSheetDialogAnimatorListener;
        if (bottomSheetDialogAnimatorListener != null) {
            bottomSheetDialogAnimatorListener.onBottomSheetDialogExpanded();
        }
    }

    @Override // androidx.dynamicanimation.animation.c.r
    public void onAnimationUpdate(androidx.dynamicanimation.animation.c cVar, float f10, float f11) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null && this.mSnapStartBottom != -1) {
            if (f10 < 0.0f) {
                cOUIPanelPercentFrameLayout.layout(cOUIPanelPercentFrameLayout.getLeft(), this.mDesignBottomSheetFrameLayout.getTop(), this.mDesignBottomSheetFrameLayout.getRight(), (int) (this.mSnapStartBottom - f10));
            }
            this.mDesignBottomSheetFrameLayout.setTranslationY(f10);
            if (!this.mIsInterruptingAnim) {
                this.mCurrentParentViewTranslationY = this.mDesignBottomSheetFrameLayout.getTranslationY();
            }
            this.mIsInterruptingAnim = false;
        }
    }

    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        enforceChangeScreenWidth();
        refreshParams();
        resetWindowImeAnimFlags();
        setStatusBarTransparentAndFont(getWindow());
        setWindowFlag(getWindow());
        registerPreDrawListener();
        registerApplicationConfigChangeListener();
        registerBehaviorPullUpListener();
        initWindowInsetsListener();
        setNavigation();
    }

    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mConfiguration = getContext().getResources().getConfiguration();
        int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.mStatusBarHeight = getContext().getResources().getDimensionPixelSize(identifier);
        }
        if (this.mIsInTinyScreen) {
            initPhysics();
        }
        initBehavior();
        initWindow();
        initDraggableConstraintLayoutSize();
        if (this.mFrameRate && COUIVersionUtil.checkOPlusViewSubSDK(34, 10)) {
            this.mADFRFeatureType = DynamicFrameRateManager.getDynamicFrameRateType();
            this.mIsVSdk = true;
        }
    }

    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        releaseResizeHelper();
        releaseApplyWindowInsetsListener();
        cancelAnim(this.mPanelViewTranslationAnimationSet);
        releaseApplicationConfigChangeListener();
        releaseBehaviorPullUpListener();
        restoreScreenWidth();
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        this.mFocusChange = Boolean.valueOf(bundle.getBoolean(STATE_FOCUS_CHANGES, getFocusChange()));
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.activity.j, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putBoolean(STATE_FOCUS_CHANGES, getFocusChange());
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        if (z10) {
            setFocusChangeFalseIfHasnotEdittext();
        }
        super.onWindowFocusChanged(z10);
    }

    public void refresh() {
        if (this.mDraggableConstraintLayout == null) {
            return;
        }
        Drawable drawable = null;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, C0577i.f12934a, 0, C0576h.f12933c);
        this.mPanelDragViewDrawable = getTypedArrayDrawable(obtainStyledAttributes, C0577i.f12940g, C0573e.f12906c);
        this.mPanelDragViewDrawableTintColor = obtainStyledAttributes.getColor(C0577i.f12941h, COUIContextUtil.getAttrColor(getContext(), X8.c.f4394n));
        this.mPanelBackground = getTypedArrayDrawable(obtainStyledAttributes, C0577i.f12938e, C0573e.f12905b);
        this.mPanelBackgroundTintColor = obtainStyledAttributes.getColor(C0577i.f12939f, COUIContextUtil.getAttrColor(getContext(), X8.c.f4353L));
        obtainStyledAttributes.recycle();
        Drawable drawable2 = this.mPanelDragViewDrawable;
        if (drawable2 != null && this.mDraggableConstraintLayout != null) {
            drawable2.setTint(this.mPanelDragViewDrawableTintColor);
            this.mDraggableConstraintLayout.setDragViewDrawable(this.mPanelDragViewDrawable);
        }
        Drawable drawable3 = this.mPanelBackground;
        if (drawable3 != null && this.mDraggableConstraintLayout != null) {
            drawable3.setTint(this.mPanelBackgroundTintColor);
            COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
            if (this.mIsShowInDialogFragment) {
                drawable = this.mPanelBackground;
            }
            cOUIPanelContentLayout.setBackground(drawable);
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null) {
                cOUIPanelPercentFrameLayout.setBackground(this.mPanelBackground);
            }
        }
    }

    public void setAnchorView(View view) {
        if (view != null) {
            Log.e(TAG, "setAnchorView: ---------");
            this.mAnchorView = view;
            getBehavior().setDraggable(false);
        }
    }

    public void setAnimationListener(OnAnimationListener onAnimationListener) {
        this.mAnimationListener = onAnimationListener;
    }

    public void setBottomButtonBar(boolean z10, String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2, String str3, View.OnClickListener onClickListener3) {
        ensureDraggableContentLayout();
        this.mDraggableConstraintLayout.setUpBottomBar(z10, str, onClickListener, str2, onClickListener2, str3, onClickListener3);
    }

    public void setBottomSheetDialogAnimatorListener(BottomSheetDialogAnimatorListener bottomSheetDialogAnimatorListener) {
        this.mBottomSheetDialogAnimatorListener = bottomSheetDialogAnimatorListener;
    }

    public void setCanPerformHapticFeedback(boolean z10) {
        this.mCanPerformHapticFeedback = z10;
    }

    public void setCanPullUp(boolean z10) {
        COUIPanelPullUpListener cOUIPanelPullUpListener;
        if (this.mCanPullUp != z10) {
            this.mCanPullUp = z10;
            if (getBehavior() instanceof COUIBottomSheetBehavior) {
                if (this.mCanPullUp) {
                    cOUIPanelPullUpListener = getPanelPullUpListener();
                } else {
                    cOUIPanelPullUpListener = null;
                }
                this.mPanelPullUpListener = cOUIPanelPullUpListener;
                ((COUIBottomSheetBehavior) getBehavior()).setPullUpListener(this.mPanelPullUpListener);
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog
    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        this.mCancelable = z10;
    }

    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.mCancelable) {
            this.mCancelable = true;
        }
        this.mCanceledOnTouchOutside = z10;
    }

    public void setCenterButton(String str, View.OnClickListener onClickListener) {
        ensureDraggableContentLayout();
        this.mDraggableConstraintLayout.setCenterButton(str, onClickListener);
    }

    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void setContentView(int i10) {
        setContentView(getLayoutInflater().inflate(i10, (ViewGroup) null));
    }

    public void setDialogOffsetListener(DialogOffsetListener dialogOffsetListener) {
        this.mDialogOffsetListener = dialogOffsetListener;
    }

    public void setDisableSubExpand(boolean z10) {
        this.mDisableSubExpand = z10;
    }

    public void setDragableLinearLayout(COUIPanelContentLayout cOUIPanelContentLayout) {
        setDragableLinearLayout(cOUIPanelContentLayout, false);
    }

    public void setDraggable(boolean z10) {
        if (this.mIsDraggable != z10) {
            this.mIsDraggable = z10;
            getBehavior().setDraggable(this.mIsDraggable);
        }
    }

    public void setExecuteNavColorAnimAfterDismiss(boolean z10) {
        this.mIsExecuteNavColorAnimAfterDismiss = z10;
    }

    public void setFinalNavColorAfterDismiss(int i10) {
        this.mFinalNavColorAfterDismiss = i10;
    }

    public void setFirstShowCollapsed(boolean z10) {
        this.mFirstShowCollapsed = z10;
    }

    public void setFollowWindowChange(boolean z10) {
        this.mFocusChange = Boolean.valueOf(z10);
    }

    public void setGlobalDrag(boolean z10) {
        this.mGlobalDrag = z10;
    }

    public void setHandleViewHasPressAnim(boolean z10) {
        if (this.mHandleViewHasPressAnim != z10) {
            this.mHandleViewHasPressAnim = z10;
            COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
            if (cOUIPanelContentLayout == null) {
                return;
            }
            if (z10) {
                cOUIPanelContentLayout.setDragViewPressAnim(true);
            } else {
                cOUIPanelContentLayout.removeDragViewPressAnim();
            }
        }
    }

    public void setHeight(int i10) {
        this.mPanelHeight = i10;
        setPanelHeight();
    }

    public void setHideDragViewHeight(int i10) {
        COUIPanelContentLayout cOUIPanelContentLayout;
        this.mHideDragViewHeight = i10;
        if (this.mIsHandlePanel || (cOUIPanelContentLayout = this.mDraggableConstraintLayout) == null || cOUIPanelContentLayout.getDrawLayout() == null) {
            return;
        }
        setHideDragViewHeight();
    }

    public void setIsHandlePanel(boolean z10) {
        if (this.mIsHandlePanel != z10) {
            this.mIsHandlePanel = z10;
            if (this.mDraggableConstraintLayout == null) {
                return;
            }
            if (z10) {
                showDragView();
            } else {
                hideDragView();
            }
        }
    }

    public void setIsInTinyScreen(boolean z10, boolean z11) {
        this.mIsInTinyScreen = z10;
        this.mIsFullScreenInTinyScreen = z11;
    }

    public void setIsInWindowFloatingMode(boolean z10) {
        this.mIsInWindowFloatingMode = z10;
    }

    public void setIsNeedOutsideViewAnim(boolean z10) {
        this.mIsNeedOutsideViewAnim = z10;
    }

    public void setIsShowInMaxHeight(boolean z10) {
        int i10;
        this.mIsShowInMaxHeight = z10;
        if (z10) {
            i10 = -1;
        } else {
            i10 = -2;
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            cOUIPanelContentLayout.setLayoutAtMaxHeight(z10);
        }
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams = cOUIPanelPercentFrameLayout.getLayoutParams();
            layoutParams.height = i10;
            this.mDesignBottomSheetFrameLayout.setLayoutParams(layoutParams);
        }
    }

    public void setLeftButton(String str, View.OnClickListener onClickListener) {
        ensureDraggableContentLayout();
        this.mDraggableConstraintLayout.setLeftButton(str, onClickListener);
    }

    public void setNavColor(int i10) {
        this.mNavColor = i10;
        if (getWindow() != null) {
            setNavigationBarColor(getNavColor(null));
        }
    }

    @Deprecated
    public void setOnDismissAnimationEndListener(OnDismissAnimationEndListener onDismissAnimationEndListener) {
        this.mDismissListener = onDismissAnimationEndListener;
    }

    @Deprecated
    public void setOnShowAnimationEndListener(OnShowAnimationEndListener onShowAnimationEndListener) {
        this.mShowListener = onShowAnimationEndListener;
    }

    public void setOutSideViewTouchListener(View.OnTouchListener onTouchListener) {
        if (this.mOutsideView == null) {
            this.mOutsideView = findViewById(C0574f.f12919m);
        }
        this.mOutSideViewTouchListener = onTouchListener;
        View view = this.mOutsideView;
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public void setOutsideMaskColor(int i10) {
        View view = this.mOutsideView;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setPanelBackground(Drawable drawable) {
        if (this.mDesignBottomSheetFrameLayout != null && drawable != null && this.mPanelBackground != drawable) {
            this.mPanelBackground = drawable;
            COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
            if (cOUIPanelContentLayout != null) {
                if (!this.mIsShowInDialogFragment) {
                    drawable = null;
                }
                cOUIPanelContentLayout.setBackground(drawable);
            }
            this.mDesignBottomSheetFrameLayout.setBackground(this.mPanelBackground);
        }
    }

    public void setPanelBackgroundTintColor(int i10) {
        Drawable drawable;
        Drawable drawable2;
        if (this.mDesignBottomSheetFrameLayout != null && (drawable = this.mPanelBackground) != null && this.mPanelBackgroundTintColor != i10) {
            this.mPanelBackgroundTintColor = i10;
            drawable.setTint(i10);
            COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
            if (cOUIPanelContentLayout != null) {
                if (this.mIsShowInDialogFragment) {
                    drawable2 = this.mPanelBackground;
                } else {
                    drawable2 = null;
                }
                cOUIPanelContentLayout.setBackground(drawable2);
            }
            this.mDesignBottomSheetFrameLayout.setBackground(this.mPanelBackground);
        }
    }

    public void setPanelBarViewColor(int i10) {
        COUIPanelBarView cOUIPanelBarView = this.mPanelBarView;
        if (cOUIPanelBarView != null) {
            cOUIPanelBarView.setBarColor(i10);
        }
    }

    public void setPanelDismissTranslateDuration(float f10) {
        this.mTranslateHidingDuration = f10;
    }

    public void setPanelDragViewDrawable(Drawable drawable) {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null && drawable != null && this.mPanelDragViewDrawable != drawable) {
            this.mPanelDragViewDrawable = drawable;
            cOUIPanelContentLayout.setDragViewDrawable(drawable);
        }
    }

    public void setPanelDragViewDrawableTintColor(int i10) {
        Drawable drawable;
        if (this.mDraggableConstraintLayout != null && (drawable = this.mPanelDragViewDrawable) != null && this.mPanelDragViewDrawableTintColor != i10) {
            this.mPanelDragViewDrawableTintColor = i10;
            drawable.setTint(i10);
            this.mDraggableConstraintLayout.setDragViewDrawable(this.mPanelDragViewDrawable);
        }
    }

    public void setPeekHeight(int i10) {
        this.mPeekHeight = i10;
    }

    public void setPhysicsParams(float f10, float f11) {
        this.mAppearStiffness = f10;
        this.mAppearDampingRatio = f11;
    }

    public void setPreferWidth(int i10) {
        this.mPreferWidth = i10;
        Log.d(TAG, "setPreferWidth =：" + this.mPreferWidth);
    }

    public void setRegisterConfigurationChangeCallBack(boolean z10) {
        this.mRegisterConfigurationChangeCallBack = z10;
    }

    public void setRightButton(String str, View.OnClickListener onClickListener) {
        ensureDraggableContentLayout();
        this.mDraggableConstraintLayout.setRightButton(str, onClickListener);
    }

    public void setShouldRegisterWindowInsetsListener(boolean z10) {
        this.mShouldRegisterWindowInsetsListener = z10;
    }

    public void setShowInDialogFragment(boolean z10) {
        this.mIsShowInDialogFragment = z10;
    }

    public void setSkipCollapsed(boolean z10) {
        this.mSkipCollapsed = z10;
    }

    public void setWidth(int i10) {
        this.mPanelWidth = i10;
        setPanelWidth();
    }

    public void showDragView() {
        COUIPanelBarView cOUIPanelBarView = this.mPanelBarView;
        if (cOUIPanelBarView != null) {
            cOUIPanelBarView.setVisibility(0);
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null && cOUIPanelContentLayout.getDrawLayout() != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mDraggableConstraintLayout.getDrawLayout().getLayoutParams();
            marginLayoutParams.height = getContext().getResources().getDimensionPixelSize(C0572d.f12896s);
            marginLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(C0572d.f12898u);
            this.mDraggableConstraintLayout.getDrawLayout().setLayoutParams(marginLayoutParams);
            this.mDraggableConstraintLayout.getDrawLayout().setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T typeCasting(Class<T> cls, Object obj) {
        if (obj != 0 && cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    public boolean updateFollowHandPanelLocation() {
        if (this.mDesignBottomSheetFrameLayout == null) {
            Log.e(TAG, "update follow hand panel while config change error.");
            return false;
        }
        boolean isFollowHand = isFollowHand();
        this.mDesignBottomSheetFrameLayout.setHasAnchor(isFollowHand);
        boolean haveEnoughSpace = haveEnoughSpace();
        if (isFollowHand && haveEnoughSpace) {
            this.mOutsideView.setAlpha(0.0f);
            this.mCurrentOutsideAlpha = 0.0f;
            offsetViewTo();
            return true;
        }
        updateBottomSheetCenterVertical();
        this.mDesignBottomSheetFrameLayout.setElevation(0.0f);
        this.mOutsideView.setAlpha(1.0f);
        this.mCurrentOutsideAlpha = 1.0f;
        this.mDesignBottomSheetFrameLayout.setTranslationY(0.0f);
        this.mDesignBottomSheetFrameLayout.setTranslationX(0.0f);
        return true;
    }

    public void updateLayoutWhileConfigChange(Configuration configuration) {
        enforceChangeScreenWidth(configuration);
        this.mConfiguration = configuration;
        this.mIsGestureNavigation = COUINavigationBarUtil.isGestureNavigation(getContext());
        getAdjustResizeHelper().resetInnerStatus();
        resetParentViewStyle(configuration);
        if (!this.mIsHandlePanel || COUIPanelMultiWindowUtils.isNormalScreen(getContext(), this.mConfiguration)) {
            resetNavigationBarColor(configuration);
        }
        setNavigation();
        if (this.mDesignBottomSheetFrameLayout != null) {
            largeScreenLimitMaxSize();
            this.mDesignBottomSheetFrameLayout.updateLayoutWhileConfigChange(configuration);
        }
        updatePanelMarginBottom(configuration, this.mApplyWindowInsets);
        updateFitToContents();
        initNavigationView();
    }

    public COUIBottomSheetDialog(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        this(context, C0576h.f12933c);
        setCancelable(z10);
        setOnCancelListener(onCancelListener);
    }

    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void setContentView(View view) {
        if (view != null) {
            COUIThemeOverlay.getInstance().applyThemeOverlays(getContext());
            setContentViewLocal(view);
            initView();
            return;
        }
        throw new IllegalArgumentException("ContentView can't be null");
    }

    public void setDragableLinearLayout(COUIPanelContentLayout cOUIPanelContentLayout, boolean z10) {
        this.mDraggableConstraintLayout = cOUIPanelContentLayout;
        if (!this.mIsHandlePanel) {
            hideDragView();
        }
        if (cOUIPanelContentLayout != null) {
            this.mPulledUpView = (ViewGroup) this.mDraggableConstraintLayout.getParent();
            cOUIPanelContentLayout.setLayoutAtMaxHeight(this.mIsShowInMaxHeight);
            if (this.mHandleViewHasPressAnim) {
                cOUIPanelContentLayout.setDragViewPressAnim(true);
            }
        }
        if (z10) {
            refresh();
        } else if (cOUIPanelContentLayout != null) {
            cOUIPanelContentLayout.setNavigationMargin(null, COUIViewMarginUtil.getMargin(this.mCoordinatorLayout, 3), this.mApplyWindowInsets);
        }
        initDraggableConstraintLayoutSize();
    }

    public void dismiss(boolean z10) {
        if (isShowing() && z10 && !this.mIsExecutingDismissAnim) {
            hideKeyboard();
            if (getBehavior().getState() == 5) {
                dismissWithAlphaAnim();
                return;
            } else {
                dismissWithInterruptibleAnim();
                return;
            }
        }
        superDismiss();
    }

    private void setHideDragViewHeight() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mDraggableConstraintLayout.getDrawLayout().getLayoutParams();
        int i10 = this.mHideDragViewHeight;
        if (i10 > 0) {
            marginLayoutParams.height = i10;
        } else {
            marginLayoutParams.height = getContext().getResources().getDimensionPixelSize(C0572d.f12897t);
        }
        marginLayoutParams.topMargin = 0;
        this.mDraggableConstraintLayout.getDrawLayout().setLayoutParams(marginLayoutParams);
    }

    public COUIBottomSheetDialog(Context context, int i10, float f10, float f11) {
        this(context, i10);
        this.mPhysicsFrequency = f10;
        this.mPhysicsDampingRatio = f11;
    }

    public COUIBottomSheetDialog(Context context, int i10) {
        super(context, resolveDialogTheme(context, i10));
        this.mHandleViewHasPressAnim = true;
        this.mIsShowInDialogFragment = false;
        this.mCancelable = true;
        this.mCanceledOnTouchOutside = true;
        this.mCanPullUp = true;
        this.mCurrentSpringTotalOffset = 0;
        this.mCoordinatorLayoutMinInsetsTop = 0;
        this.mCoordinatorLayoutPaddingExtra = 0;
        this.mPeekHeight = 0;
        this.mSkipCollapsed = true;
        this.mFirstShowCollapsed = false;
        this.mCurrentParentViewTranslationY = 0.0f;
        this.mCurrentOutsideAlpha = 0.0f;
        this.mIsInterruptingAnim = false;
        this.mWindowInsetsListener = null;
        this.mPanelPullUpListener = null;
        this.mNavColor = Integer.MAX_VALUE;
        this.mWindowInsetsAnimEnable = false;
        this.mIsInWindowFloatingMode = false;
        this.mCanPerformHapticFeedback = false;
        this.mRegisterConfigurationChangeCallBack = true;
        this.mIsNeedShowKeyboard = false;
        this.mIsNeedOutsideViewAnim = true;
        this.mFocusChange = null;
        this.mIsDraggable = true;
        this.mTranslateHidingDuration = DEFAULT_TRANSLATE_HIDING_ANIMATOR_DURATION;
        this.mPanelBarView = null;
        this.mBottomSheetDialogAnimatorListener = null;
        this.mDisableSubExpand = false;
        this.mGlobalDrag = true;
        this.mPhysicsFrequency = PHYSICS_UNSET;
        this.mPhysicsDampingRatio = PHYSICS_UNSET;
        this.mAnchorView = null;
        this.mStatusBarHeight = 0;
        this.mSnapStartBottom = -1;
        this.mAppearStiffness = PHYSICS_UNSET;
        this.mAppearDampingRatio = PHYSICS_UNSET;
        this.mIsAppearSpringAnimStared = false;
        this.mShouldRegisterWindowInsetsListener = true;
        this.mPreferWidth = -1;
        this.mOriginWidth = -1;
        this.isLargeScreenLimitMaxSize = false;
        this.mIsHandlePanel = false;
        this.mIsGestureNavigation = true;
        this.mHideDragViewHeight = 0;
        this.mFrameRate = true;
        this.mComponentCallbacks = new ComponentCallbacks() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                if (COUIBottomSheetDialog.this.mRegisterConfigurationChangeCallBack) {
                    COUIBottomSheetDialog.this.updateLayoutWhileConfigChange(configuration);
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        };
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.16
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                COUIBottomSheetDialog.this.removeOnPreDrawListener();
                if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout != null) {
                    int contentViewHeightWithMargins = COUIBottomSheetDialog.this.getContentViewHeightWithMargins();
                    if (COUIBottomSheetDialog.this.mFirstShowCollapsed) {
                        contentViewHeightWithMargins = COUIBottomSheetDialog.this.mPeekHeight;
                    }
                    COUIPanelContentLayout cOUIPanelContentLayout = COUIBottomSheetDialog.this.mDraggableConstraintLayout;
                    if ((cOUIPanelContentLayout == null || cOUIPanelContentLayout.findFocus() == null) && !COUIBottomSheetDialog.this.isFollowHand() && !COUIBottomSheetDialog.this.isFadeInCenter()) {
                        COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setTranslationY(contentViewHeightWithMargins);
                    }
                    COUIBottomSheetDialog.this.mOutsideView.setAlpha(0.0f);
                    if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getRatio() == 2.0f) {
                        COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                        cOUIBottomSheetDialog.doParentViewTranslationShowingAnim(cOUIBottomSheetDialog.mCoordinatorLayout.getHeight() / 2, COUIBottomSheetDialog.this.getPanelShowAnimListener());
                    } else {
                        COUIBottomSheetDialog cOUIBottomSheetDialog2 = COUIBottomSheetDialog.this;
                        cOUIBottomSheetDialog2.doParentViewTranslationShowingAnim(0, cOUIBottomSheetDialog2.getPanelShowAnimListener());
                    }
                    return true;
                }
                COUIBottomSheetDialog cOUIBottomSheetDialog3 = COUIBottomSheetDialog.this;
                cOUIBottomSheetDialog3.doParentViewTranslationShowingAnim(0, cOUIBottomSheetDialog3.getPanelShowAnimListener());
                return true;
            }
        };
        initThemeResources(i10);
        initValueResources();
        saveActivityContextToGetMultiWindowInfo(context);
    }

    public void setFrameRate(boolean z10) {
        this.mFrameRate = z10;
    }

    public void doFeedbackAnimation() {
        AnimatorSet animatorSet;
        if (this.mDesignBottomSheetFrameLayout == null || (animatorSet = this.mPanelViewTranslationAnimationSet) == null || animatorSet.isRunning()) {
            return;
        }
        doFeedbackAnimation(this.mDesignBottomSheetFrameLayout);
    }

    private void enforceChangeScreenWidth(Configuration configuration) {
        if (this.mPreferWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            this.mOriginWidth = configuration.screenWidthDp;
            configuration.screenWidthDp = this.mPreferWidth;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "enforceChangeScreenWidth : OriginWidth=" + this.mOriginWidth + " ,PreferWidth:" + this.mPreferWidth);
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null) {
                cOUIPanelPercentFrameLayout.setPreferWidth(this.mPreferWidth);
            }
        } catch (Exception unused) {
            Log.d(TAG, "enforceChangeScreenWidth : failed to updateConfiguration");
        }
    }

    /* loaded from: classes.dex */
    public interface OnAnimationListener {
        default void onDismissAnimationEnd() {
        }

        default void onDismissAnimationStart() {
        }

        default void onShowAnimationEnd() {
        }

        default void onShowAnimationStart() {
        }
    }

    private void setWindowFlag(Window window) {
    }
}
