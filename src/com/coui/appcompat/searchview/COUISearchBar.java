package com.coui.appcompat.searchview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.CollapsibleActionView;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.K;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.rippleutil.COUIRippleDrawableUtil;
import com.coui.appcompat.roundRect.COUIShapePath;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.searchview.ImeInsetsAnimationCallback;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.state.COUIMaskRippleDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.state.COUIStrokeDrawable;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class COUISearchBar extends ViewGroup implements CollapsibleActionView, ImeInsetsAnimationCallback.OnImeAnimationListener {
    private static final float CLAMP_ANIMATION_PERCENT = 0.3f;
    private static final long DEFAULT_BUTTON_ALPHA_CHANGE_DURATION = 350;
    private static final long DEFAULT_FADE_DURATION = 150;
    private static final int DEFAULT_MAX_LINES = 1;
    private static final long DEFAULT_SEARCH_VIEW_BUTTON_ALPHA_FADE_IN_DURATION = 400;
    private static final long DEFAULT_SEARCH_VIEW_BUTTON_ALPHA_FADE_OUT_DURATION = 200;
    private static final long DEFAULT_SEARCH_VIEW_BUTTON_ANIMATION_START_DELAY = 50;
    private static final long DEFAULT_SEARCH_VIEW_BUTTON_OFFSET_DURATION = 400;
    private static final long DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_DURATION = 450;
    private static final long DEFAULT_SEARCH_VIEW_SCALE_CHANGE_DURATION = 450;
    private static final float FLOAT_POINT_FIVE = 0.5f;
    private static final float FLOAT_TWO = 2.0f;
    private static final long NON_INSTANT_SEARCH_BUTTON_ALPHA_CHANGE_DURATION = 100;
    private static final int RESPONSIVE_WIDTH_TYPE_COMPAT = 0;
    private static final int RESPONSIVE_WIDTH_TYPE_EXPANDED = 2;
    private static final int RESPONSIVE_WIDTH_TYPE_MEDIUM = 1;
    public static final int STATE_EDIT = 1;
    public static final int STATE_NORMAL = 0;
    private static final String TAG = "COUISearchBar";
    public static final int TYPE_INSTANT_SEARCH = 0;
    public static final int TYPE_NON_INSTANT_SEARCH = 1;
    private static final int WAY_AT_BEHIND = 1;
    private static final int WAY_AT_FRONT = 2;
    private static final int WAY_NONE = 0;
    private int mAddToToolbarWay;
    private AnimatorHelper mAnimatorHelper;
    private AttributeSet mAttrs;
    private final Rect mBackgroundRect;
    private float mBackgroundScaleFraction;
    private int mButtonOffsetAnimationDistance;
    private COUIHintAnimationLayout mCOUIHintAnimationLayout;
    private int mClearTextDrawableResourceId;
    private int mCollapsedMinHeight;
    private float mCollapsingHeightPercent;
    private int mDividerHeight;
    private final Rect mDividerRect;
    private int mDividerWidth;
    private final COUISearchBarDrawingProxyDrawable mDrawingProxyDrawable;
    private View mDrawingProxyView;
    private int mExtraHorizontalBackground;
    private int[] mFunctionButtonEndGap;
    private int mFunctionButtonMaxWidth;
    private int mFunctionButtonStartGap;
    private TextView mFunctionalButton;
    private ValueAnimator mFunctionalButtonAlphaEnterAnimator;
    private ValueAnimator mFunctionalButtonAlphaExitAnimator;
    private ValueAnimator mFunctionalButtonOffsetEnterAnimator;
    private ValueAnimator mFunctionalButtonOffsetExitAnimator;
    private int mGravityInToolBar;
    private boolean mHasAddedToToolbar;
    private int mHorizontalDividerColor;
    private int mIconMaxHeight;
    private int mIconMaxWidth;
    private int mInitSearchBarHeight;
    private int mInnerIconSize;
    private ImageView mInnerPrimaryButton;
    private ImageView mInnerSecondaryButton;
    private boolean mInputMethodAnimationEnabled;
    private boolean mIsAtLeastR;
    private COUIMaskEffectDrawable mMaskDrawable;
    private MenuItem mMenuItem;
    private int[] mNavigationButtonStartGap;
    private int mNavigationButtonWidth;
    private ImageView mNavigationView;
    private int mNonInstantSearchInnerGap;
    private int mNormalBackgroundColor;
    private int mNormalBackgroundHeight;
    private OnAnimationListener mOnAnimationListener;
    private List<OnStateChangeListener> mOnStateChangeListeners;
    private ValueAnimator mOuterButtonAlphaEnterAnimator;
    private ValueAnimator mOuterButtonAlphaExitAnimator;
    private int[] mOuterButtonEndGap;
    private int mOuterButtonGap;
    private ValueAnimator mOuterButtonOffsetEnterAnimator;
    private ValueAnimator mOuterButtonOffsetExitAnimator;
    private int mOuterButtonWidth;
    private ImageView mOuterPrimaryButton;
    private ImageView mOuterSecondaryButton;
    private boolean mPressed;
    private int mPressedBackgroundColor;
    private ImageView mQuickDeleteButton;
    private int[] mResponsiveHorizontalPadding;
    private int mResponsiveWidthSize;
    private String mSearchBarContentDesc;
    private String mSearchBarHintTitleDesc;
    private EditText mSearchEditText;
    private int mSearchIconStartGap;
    private ImageView mSearchIconView;
    private ValueAnimator mSearchViewOffsetEnterAnimator;
    private ValueAnimator mSearchViewOffsetExitAnimator;
    private ValueAnimator mSearchViewScaleEnterAnimator;
    private ValueAnimator mSearchViewScaleExitAnimator;
    private AnimatorSet mSearchViewSmoothEnterAnimatorSet;
    private AnimatorSet mSearchViewSmoothExitAnimatorSet;
    private int mSearchViewType;
    private int mShowImeAnimDuration;
    private Interpolator mShowImeInterpolator;
    private float mShrinkFraction;
    private volatile AtomicInteger mState;
    private COUIStateEffectDrawable mStateEffectBackground;
    private COUIStrokeDrawable mStrokeDrawable;
    private int mStyle;
    private COUIToolbar mToolBar;
    private boolean mToolBarAnimationRunning;
    private boolean mUseResponsivePadding;
    private static final Interpolator DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final Interpolator DEFAULT_SEARCH_VIEW_SCALE_CHANGE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final Interpolator DEFAULT_BUTTON_ALPHA_CHANGE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final ArgbEvaluator DEFAULT_EVALUATOR = new ArgbEvaluator();
    private static final String[] TYPE_NAME = {"TYPE_INSTANT_SEARCH", "TYPE_NON_INSTANT_SEARCH"};

    /* loaded from: classes.dex */
    public class AnimatorHelper {
        private int mTopOffset = 0;
        private int mTopMargin = 0;
        private int mStartY = 0;
        private int mExtraY = 0;
        private volatile AtomicBoolean mAnimatingAtomic = new AtomicBoolean(false);

        public AnimatorHelper() {
            initAnimator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimateToEditState() {
            this.mTopOffset = 0;
            if (COUISearchBar.this.mSearchViewType == 0) {
                int i10 = this.mStartY - this.mExtraY;
                if (((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()) != null) {
                    ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin = this.mTopMargin - i10;
                }
                COUISearchBar.this.mShrinkFraction = 1.0f;
                COUISearchBar.this.mFunctionalButton.setAlpha(1.0f);
                COUISearchBar.this.setOuterButtonVisibility(8);
            } else if (COUISearchBar.this.mSearchViewType == 1) {
                COUISearchBar.this.mDrawingProxyDrawable.setDividerAlpha(1.0f);
                COUISearchBar.this.mFunctionalButton.setAlpha(1.0f);
            }
            COUISearchBar.this.requestLayout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endAnimateToNormalState() {
            this.mTopOffset = 0;
            if (COUISearchBar.this.mSearchViewType == 0) {
                if (((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()) != null) {
                    ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin = this.mTopMargin;
                }
                COUISearchBar.this.mShrinkFraction = 0.0f;
            } else if (COUISearchBar.this.mSearchViewType == 1) {
                COUISearchBar.this.mDrawingProxyDrawable.setDividerAlpha(0.0f);
            }
            COUISearchBar.this.mFunctionalButton.setAlpha(0.0f);
            COUISearchBar.this.mFunctionalButton.setVisibility(8);
            COUISearchBar.this.requestLayout();
        }

        private void initAnimator() {
            initSearchViewEnterAnimator();
            initSearchViewExitAnimator();
            initButtonEnterAnimator();
            initButtonExitAnimator();
            initSmoothEnterAnimatorSet();
            initSmoothExitAnimatorSet();
        }

        private void initButtonEnterAnimator() {
            long j10;
            COUISearchBar.this.mFunctionalButtonAlphaEnterAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            long j11 = 100;
            if (COUISearchBar.this.mSearchViewType == 0) {
                j10 = COUISearchBar.DEFAULT_BUTTON_ALPHA_CHANGE_DURATION;
            } else if (COUISearchBar.this.getOuterButtonCount() == 1) {
                j10 = 400;
            } else {
                j10 = 100;
            }
            COUISearchBar.this.mFunctionalButtonAlphaEnterAnimator.setDuration(j10);
            COUISearchBar.this.mFunctionalButtonAlphaEnterAnimator.setInterpolator(COUISearchBar.DEFAULT_BUTTON_ALPHA_CHANGE_INTERPOLATOR);
            if (COUISearchBar.this.mSearchViewType != 0) {
                if (COUISearchBar.this.getOuterButtonCount() == 1) {
                    j11 = COUISearchBar.DEFAULT_SEARCH_VIEW_BUTTON_ANIMATION_START_DELAY;
                } else {
                    j11 = 0;
                }
            }
            COUISearchBar.this.mFunctionalButtonAlphaEnterAnimator.setStartDelay(j11);
            COUISearchBar.this.mFunctionalButtonAlphaEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.n
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initButtonEnterAnimator$2(valueAnimator);
                }
            });
            COUISearchBar.this.mFunctionalButtonOffsetEnterAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mFunctionalButtonOffsetEnterAnimator.setDuration(400L);
            COUISearchBar.this.mFunctionalButtonOffsetEnterAnimator.setInterpolator(COUISearchBar.DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mFunctionalButtonOffsetEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.o
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initButtonEnterAnimator$3(valueAnimator);
                }
            });
            COUISearchBar.this.mOuterButtonAlphaEnterAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mOuterButtonAlphaEnterAnimator.setDuration(200L);
            COUISearchBar.this.mOuterButtonAlphaEnterAnimator.setInterpolator(COUISearchBar.DEFAULT_BUTTON_ALPHA_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mOuterButtonAlphaEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.p
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initButtonEnterAnimator$4(valueAnimator);
                }
            });
            COUISearchBar.this.mOuterButtonOffsetEnterAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mOuterButtonOffsetEnterAnimator.setDuration(400L);
            COUISearchBar.this.mOuterButtonOffsetEnterAnimator.setInterpolator(COUISearchBar.DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mOuterButtonOffsetEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.q
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initButtonEnterAnimator$5(valueAnimator);
                }
            });
        }

        private void initButtonExitAnimator() {
            long j10;
            COUISearchBar.this.mFunctionalButtonAlphaExitAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            if (COUISearchBar.this.mSearchViewType == 0) {
                j10 = COUISearchBar.DEFAULT_BUTTON_ALPHA_CHANGE_DURATION;
            } else if (COUISearchBar.this.getOuterButtonCount() == 1) {
                j10 = 200;
            } else {
                j10 = 100;
            }
            COUISearchBar.this.mFunctionalButtonAlphaExitAnimator.setDuration(j10);
            COUISearchBar.this.mFunctionalButtonAlphaExitAnimator.setInterpolator(COUISearchBar.DEFAULT_BUTTON_ALPHA_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mFunctionalButtonAlphaExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initButtonExitAnimator$8(valueAnimator);
                }
            });
            COUISearchBar.this.mFunctionalButtonOffsetExitAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mFunctionalButtonOffsetExitAnimator.setDuration(400L);
            COUISearchBar.this.mFunctionalButtonOffsetExitAnimator.setInterpolator(COUISearchBar.DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mFunctionalButtonOffsetExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.k
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initButtonExitAnimator$9(valueAnimator);
                }
            });
            COUISearchBar.this.mOuterButtonAlphaExitAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mOuterButtonAlphaExitAnimator.setDuration(400L);
            COUISearchBar.this.mOuterButtonAlphaExitAnimator.setStartDelay(COUISearchBar.DEFAULT_SEARCH_VIEW_BUTTON_ANIMATION_START_DELAY);
            COUISearchBar.this.mOuterButtonAlphaExitAnimator.setInterpolator(COUISearchBar.DEFAULT_BUTTON_ALPHA_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mOuterButtonAlphaExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.l
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initButtonExitAnimator$10(valueAnimator);
                }
            });
            COUISearchBar.this.mOuterButtonOffsetExitAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
            COUISearchBar.this.mOuterButtonOffsetExitAnimator.setDuration(400L);
            COUISearchBar.this.mOuterButtonOffsetExitAnimator.setStartDelay(COUISearchBar.DEFAULT_SEARCH_VIEW_BUTTON_ANIMATION_START_DELAY);
            COUISearchBar.this.mOuterButtonOffsetExitAnimator.setInterpolator(COUISearchBar.DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mOuterButtonOffsetExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.m
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initButtonExitAnimator$11(valueAnimator);
                }
            });
        }

        private void initSearchViewEnterAnimator() {
            COUISearchBar.this.mSearchViewOffsetEnterAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mSearchViewOffsetEnterAnimator.setDuration(450L);
            COUISearchBar.this.mSearchViewOffsetEnterAnimator.setInterpolator(COUISearchBar.DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mSearchViewOffsetEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initSearchViewEnterAnimator$0(valueAnimator);
                }
            });
            COUISearchBar.this.mSearchViewScaleEnterAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mSearchViewScaleEnterAnimator.setDuration(450L);
            COUISearchBar.this.mSearchViewScaleEnterAnimator.setInterpolator(COUISearchBar.DEFAULT_SEARCH_VIEW_SCALE_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mSearchViewScaleEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initSearchViewEnterAnimator$1(valueAnimator);
                }
            });
        }

        private void initSearchViewExitAnimator() {
            COUISearchBar.this.mSearchViewOffsetExitAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mSearchViewOffsetExitAnimator.setDuration(450L);
            COUISearchBar.this.mSearchViewOffsetExitAnimator.setInterpolator(COUISearchBar.DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mSearchViewOffsetExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initSearchViewExitAnimator$6(valueAnimator);
                }
            });
            COUISearchBar.this.mSearchViewScaleExitAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
            COUISearchBar.this.mSearchViewScaleExitAnimator.setDuration(450L);
            COUISearchBar.this.mSearchViewScaleExitAnimator.setInterpolator(COUISearchBar.DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR);
            COUISearchBar.this.mSearchViewScaleExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.AnimatorHelper.this.lambda$initSearchViewExitAnimator$7(valueAnimator);
                }
            });
        }

        private void initSmoothEnterAnimatorSet() {
            COUISearchBar.this.mSearchViewSmoothEnterAnimatorSet = new AnimatorSet();
            COUISearchBar.this.mSearchViewSmoothEnterAnimatorSet.addListener(new DefaultAnimatorListener() { // from class: com.coui.appcompat.searchview.COUISearchBar.AnimatorHelper.1
                @Override // com.coui.appcompat.searchview.COUISearchBar.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AnimatorHelper.this.endAnimateToEditState();
                    AnimatorHelper.this.mAnimatingAtomic.set(false);
                    if (COUISearchBar.this.mOnAnimationListener != null) {
                        COUISearchBar.this.mOnAnimationListener.onAnimationEnd(1);
                    }
                }

                @Override // com.coui.appcompat.searchview.COUISearchBar.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (COUISearchBar.this.mOnAnimationListener != null) {
                        COUISearchBar.this.mOnAnimationListener.onAnimationStart(1);
                    }
                }
            });
            COUISearchBar.this.mSearchViewSmoothEnterAnimatorSet.playTogether(COUISearchBar.this.mSearchViewOffsetEnterAnimator, COUISearchBar.this.mSearchViewScaleEnterAnimator, COUISearchBar.this.mFunctionalButtonAlphaEnterAnimator, COUISearchBar.this.mFunctionalButtonOffsetEnterAnimator, COUISearchBar.this.mOuterButtonAlphaEnterAnimator, COUISearchBar.this.mOuterButtonOffsetEnterAnimator);
        }

        private void initSmoothExitAnimatorSet() {
            COUISearchBar.this.mSearchViewSmoothExitAnimatorSet = new AnimatorSet();
            COUISearchBar.this.mSearchViewSmoothExitAnimatorSet.addListener(new DefaultAnimatorListener() { // from class: com.coui.appcompat.searchview.COUISearchBar.AnimatorHelper.2
                @Override // com.coui.appcompat.searchview.COUISearchBar.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AnimatorHelper.this.endAnimateToNormalState();
                    AnimatorHelper.this.mAnimatingAtomic.set(false);
                    if (COUISearchBar.this.mOnAnimationListener != null) {
                        COUISearchBar.this.mOnAnimationListener.onAnimationEnd(0);
                    }
                }

                @Override // com.coui.appcompat.searchview.COUISearchBar.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (COUISearchBar.this.mOnAnimationListener != null) {
                        COUISearchBar.this.mOnAnimationListener.onAnimationStart(0);
                    }
                    if (COUISearchBar.this.mSearchViewType == 0 && COUISearchBar.this.getOuterButtonCount() == 1 && COUISearchBar.this.mFunctionalButton != null) {
                        COUISearchBar.this.mFunctionalButton.jumpDrawablesToCurrentState();
                    }
                }
            });
            COUISearchBar.this.mSearchViewSmoothExitAnimatorSet.playTogether(COUISearchBar.this.mSearchViewOffsetExitAnimator, COUISearchBar.this.mSearchViewScaleExitAnimator, COUISearchBar.this.mFunctionalButtonAlphaExitAnimator, COUISearchBar.this.mFunctionalButtonOffsetExitAnimator, COUISearchBar.this.mOuterButtonAlphaExitAnimator, COUISearchBar.this.mOuterButtonOffsetExitAnimator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initButtonEnterAnimator$2(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.mSearchViewType == 0) {
                COUISearchBar.this.mFunctionalButton.setAlpha(floatValue);
            } else if (COUISearchBar.this.mSearchViewType == 1) {
                COUISearchBar.this.mDrawingProxyDrawable.setDividerAlpha(floatValue);
                COUISearchBar.this.mFunctionalButton.setAlpha(floatValue);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initButtonEnterAnimator$3(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.mSearchViewType == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.mFunctionalButton != null) {
                    COUISearchBar.this.mFunctionalButton.setTranslationX((1.0f - floatValue) * COUISearchBar.this.mButtonOffsetAnimationDistance);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initButtonEnterAnimator$4(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.mSearchViewType == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.mOuterPrimaryButton != null) {
                    COUISearchBar.this.mOuterPrimaryButton.setAlpha(1.0f - floatValue);
                }
                if (COUISearchBar.this.mOuterSecondaryButton != null) {
                    COUISearchBar.this.mOuterSecondaryButton.setAlpha(1.0f - floatValue);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initButtonEnterAnimator$5(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.mSearchViewType == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.mOuterPrimaryButton != null) {
                    COUISearchBar.this.mOuterPrimaryButton.setTranslationX((-floatValue) * COUISearchBar.this.mButtonOffsetAnimationDistance);
                }
                if (COUISearchBar.this.mOuterSecondaryButton != null) {
                    COUISearchBar.this.mOuterSecondaryButton.setTranslationX((-floatValue) * COUISearchBar.this.mButtonOffsetAnimationDistance);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initButtonExitAnimator$10(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.mSearchViewType == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.mOuterPrimaryButton != null) {
                    COUISearchBar.this.mOuterPrimaryButton.setAlpha(floatValue);
                }
                if (COUISearchBar.this.mOuterSecondaryButton != null) {
                    COUISearchBar.this.mOuterSecondaryButton.setAlpha(floatValue);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initButtonExitAnimator$11(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.mSearchViewType == 0) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.mOuterPrimaryButton != null) {
                    COUISearchBar.this.mOuterPrimaryButton.setTranslationX((-floatValue) * COUISearchBar.this.mButtonOffsetAnimationDistance);
                }
                if (COUISearchBar.this.mOuterSecondaryButton != null) {
                    COUISearchBar.this.mOuterSecondaryButton.setTranslationX((-floatValue) * COUISearchBar.this.mButtonOffsetAnimationDistance);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initButtonExitAnimator$8(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.mSearchViewType == 0) {
                COUISearchBar.this.mFunctionalButton.setAlpha(1.0f - floatValue);
            } else if (COUISearchBar.this.mSearchViewType == 1) {
                float f10 = 1.0f - floatValue;
                COUISearchBar.this.mDrawingProxyDrawable.setDividerAlpha(f10);
                COUISearchBar.this.mFunctionalButton.setAlpha(f10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initButtonExitAnimator$9(ValueAnimator valueAnimator) {
            if (COUISearchBar.this.mSearchViewType == 0 && COUISearchBar.this.getOuterButtonCount() == 1) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchBar.this.mFunctionalButton != null) {
                    COUISearchBar.this.mFunctionalButton.setTranslationX(floatValue * COUISearchBar.this.mButtonOffsetAnimationDistance);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initSearchViewEnterAnimator$0(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.mSearchViewType == 0) {
                int i10 = (int) (floatValue * (this.mStartY - this.mExtraY));
                ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin -= i10 - this.mTopOffset;
                this.mTopOffset = i10;
                COUISearchBar.this.requestLayout();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initSearchViewEnterAnimator$1(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.mSearchViewType == 0) {
                COUISearchBar.this.mShrinkFraction = floatValue;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initSearchViewExitAnimator$6(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.mSearchViewType == 0) {
                int i10 = (int) (floatValue * (this.mStartY - this.mExtraY));
                ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin += i10 - this.mTopOffset;
                this.mTopOffset = i10;
                COUISearchBar.this.requestLayout();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initSearchViewExitAnimator$7(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (COUISearchBar.this.mSearchViewType == 0) {
                COUISearchBar.this.mShrinkFraction = 1.0f - floatValue;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startAnimateToEditState() {
            this.mTopOffset = 0;
            if (((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()) != null) {
                this.mTopMargin = ((ViewGroup.MarginLayoutParams) COUISearchBar.this.getLayoutParams()).topMargin;
            }
            this.mStartY = COUISearchBar.this.getTop();
            COUISearchBar.this.mFunctionalButton.setVisibility(0);
            if ((!COUISearchBar.this.mIsAtLeastR || COUISearchBar.this.mShowImeAnimDuration == 0) && COUISearchBar.this.mInputMethodAnimationEnabled) {
                COUISearchBar.this.openSoftInput(true);
            }
            COUISearchBar.this.mState.set(1);
            COUISearchBar.this.notifyOnStateChange(0, 1);
        }

        private void startAnimateToNormalState() {
            this.mTopOffset = 0;
            COUISearchBar.this.mSearchEditText.setText((CharSequence) null);
            if (COUISearchBar.this.mInputMethodAnimationEnabled) {
                COUISearchBar.this.openSoftInput(false);
            }
            if (COUISearchBar.this.mSearchViewType == 0) {
                COUISearchBar.this.setOuterButtonVisibility(0);
            }
            COUISearchBar.this.mState.set(0);
            COUISearchBar.this.notifyOnStateChange(1, 0);
        }

        public void runStateChangeAnimation(int i10) {
            if (COUISearchBar.this.mState.get() == i10) {
                COUILog.d(COUISearchBar.TAG, "runStateChangeAnimation: same state , return. targetState = " + i10);
                return;
            }
            if (i10 == 1) {
                startToEditAnimator();
            } else if (i10 == 0) {
                startToNormalAnimator();
            }
        }

        public void runStateChangeImmediately(int i10) {
            if (this.mAnimatingAtomic.get()) {
                COUILog.w(COUISearchBar.TAG, "animating");
                return;
            }
            if (i10 == 1) {
                startAnimateToEditState();
                endAnimateToEditState();
            } else if (i10 == 0) {
                startAnimateToNormalState();
                endAnimateToNormalState();
            }
        }

        public void startToEditAnimator() {
            if (COUISearchBar.this.mState.get() != 0 || !this.mAnimatingAtomic.compareAndSet(false, true)) {
                return;
            }
            startAnimateToEditState();
            COUISearchBar.this.mSearchViewSmoothEnterAnimatorSet.start();
        }

        public void startToNormalAnimator() {
            if (COUISearchBar.this.mState.get() != 1 || !this.mAnimatingAtomic.compareAndSet(false, true)) {
                return;
            }
            startAnimateToNormalState();
            COUISearchBar.this.mSearchViewSmoothExitAnimatorSet.start();
        }
    }

    /* loaded from: classes.dex */
    public static class COUISavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<COUISavedState> CREATOR = new Parcelable.Creator<COUISavedState>() { // from class: com.coui.appcompat.searchview.COUISearchBar.COUISavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public COUISavedState createFromParcel(Parcel parcel) {
                return new COUISavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public COUISavedState[] newArray(int i10) {
                return new COUISavedState[i10];
            }
        };
        float mCollapsingHeightPercent;

        public COUISavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.mCollapsingHeightPercent = parcel.readFloat();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeFloat(this.mCollapsingHeightPercent);
        }

        public COUISavedState(Parcel parcel) {
            super(parcel);
            this.mCollapsingHeightPercent = parcel.readFloat();
        }
    }

    /* loaded from: classes.dex */
    public interface OnAnimationListener {
        void onAnimationEnd(int i10);

        void onAnimationStart(int i10);

        @Deprecated
        void onUpdate(int i10, ValueAnimator valueAnimator);
    }

    /* loaded from: classes.dex */
    public interface OnStateChangeListener {
        void onStateChange(int i10, int i11);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SearchViewState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SearchViewType {
    }

    public COUISearchBar(Context context) {
        this(context, null);
    }

    private int calculateRelativeTop(int i10, int i11, int i12) {
        return i10 + ((i11 - i12) / 2);
    }

    private float clampMarginValue(float f10) {
        return Math.max(0.0f, Math.min(1.0f, f10 / 0.3f));
    }

    private float clampSearchViewHeight(float f10) {
        return (f10 / 0.7f) - 0.42857146f;
    }

    private void configImageViewDrawable(ImageView imageView, Drawable drawable, int i10) {
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            imageView.setClickable(true);
            if (drawable != null) {
                int intrinsicWidth = (i10 - drawable.getIntrinsicWidth()) / 2;
                imageView.setPadding(intrinsicWidth, 0, intrinsicWidth, 0);
            }
        }
    }

    private void configResponsive() {
        if (COUIResponsiveUtils.isSmallScreen(getContext(), getMeasuredWidth())) {
            this.mResponsiveWidthSize = 0;
        } else if (COUIResponsiveUtils.isMediumScreen(getContext(), getMeasuredWidth())) {
            this.mResponsiveWidthSize = 1;
        } else if (COUIResponsiveUtils.isLargeScreen(getContext(), getMeasuredWidth())) {
            this.mResponsiveWidthSize = 2;
        }
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void ensureAddedToToolBar() {
        if (!this.mHasAddedToToolbar) {
            this.mHasAddedToToolbar = true;
            if (this.mToolBar != null) {
                removeLast();
                COUIToolbar.LayoutParams layoutParams = new COUIToolbar.LayoutParams(-1, this.mToolBar.getHeight() - this.mToolBar.getPaddingTop());
                layoutParams.gravity = this.mGravityInToolBar;
                this.mToolBar.setSearchView(this, layoutParams);
            }
        }
    }

    private ImageView ensureImageView(Drawable drawable, boolean z10, boolean z11, int i10) {
        if (drawable != null) {
            ImageView imageView = new ImageView(getContext());
            if (!z11) {
                imageView.setClickable(false);
                imageView.setFocusable(false);
            }
            if (z10 && z11) {
                COUIRippleDrawableUtil.setIconPressRippleDrawable(imageView, i10);
            }
            addView(imageView);
            return imageView;
        }
        return null;
    }

    private void ensureNavigationView() {
        if (this.mNavigationView == null) {
            ImageView imageView = new ImageView(getContext());
            this.mNavigationView = imageView;
            COUIRippleDrawableUtil.setIconPressRippleDrawable(imageView, COUIMaskRippleDrawable.getMaskRippleRadiusByType(getContext(), 0));
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(X8.f.f4707i);
            this.mNavigationView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
            addView(this.mNavigationView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureQuickDeleteButton() {
        Drawable f10;
        if (this.mQuickDeleteButton == null && (f10 = A.h.f(getResources(), this.mClearTextDrawableResourceId, getContext().getTheme())) != null) {
            ImageView ensureImageView = ensureImageView(f10, true, true, this.mInnerIconSize / 2);
            this.mQuickDeleteButton = ensureImageView;
            ensureImageView.setContentDescription(getResources().getString(X8.m.f5009h));
            configImageViewDrawable(this.mQuickDeleteButton, f10, this.mInnerIconSize);
            showButton(this.mQuickDeleteButton, false);
            this.mQuickDeleteButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.searchview.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    COUISearchBar.this.lambda$ensureQuickDeleteButton$1(view);
                }
            });
        }
    }

    private AnimatorHelper getAnimatorHelper() {
        if (this.mAnimatorHelper == null) {
            this.mAnimatorHelper = new AnimatorHelper();
        }
        return this.mAnimatorHelper;
    }

    private int getInternalPaddingEnd() {
        if (this.mUseResponsivePadding) {
            return this.mResponsiveHorizontalPadding[this.mResponsiveWidthSize];
        }
        return getPaddingEnd();
    }

    private int getInternalPaddingStart() {
        if (this.mUseResponsivePadding) {
            return this.mResponsiveHorizontalPadding[this.mResponsiveWidthSize];
        }
        return getPaddingStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getOuterButtonCount() {
        return (shouldLayoutOut(this.mOuterPrimaryButton) ? 1 : 0) + (shouldLayoutOut(this.mOuterSecondaryButton) ? 1 : 0);
    }

    private View getSearchEditOrAnimationLayout() {
        COUIHintAnimationLayout cOUIHintAnimationLayout = this.mCOUIHintAnimationLayout;
        if (cOUIHintAnimationLayout != null) {
            return cOUIHintAnimationLayout;
        }
        return this.mSearchEditText;
    }

    private void init(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.mIsAtLeastR = true;
        initDrawingProxyView();
        initEdittext();
        initFunctionButton();
        this.mAttrs = attributeSet;
        if (attributeSet != null) {
            this.mStyle = attributeSet.getStyleAttribute();
        }
        if (this.mStyle == 0) {
            this.mStyle = i10;
        }
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mCollapsedMinHeight = context.getResources().getDimensionPixelSize(X8.f.f4680e4);
        this.mHorizontalDividerColor = context.getResources().getColor(X8.e.f4442h);
        this.mInitSearchBarHeight = context.getResources().getDimensionPixelOffset(X8.f.f4507G3);
        this.mNonInstantSearchInnerGap = context.getResources().getDimensionPixelOffset(X8.f.f4556N3);
        this.mNormalBackgroundHeight = context.getResources().getDimensionPixelOffset(X8.f.f4563O3);
        this.mInnerIconSize = context.getResources().getDimensionPixelOffset(X8.f.f4514H3);
        this.mSearchIconStartGap = context.getResources().getDimensionPixelOffset(X8.f.f4521I3);
        this.mDividerWidth = context.getResources().getDimensionPixelOffset(X8.f.f4840z3);
        this.mDividerHeight = context.getResources().getDimensionPixelOffset(X8.f.f4833y3);
        this.mOuterButtonWidth = context.getResources().getDimensionPixelOffset(X8.f.f4598T3);
        this.mNavigationButtonWidth = context.getResources().getDimensionPixelOffset(X8.f.f4549M3);
        this.mOuterButtonGap = context.getResources().getDimensionPixelOffset(X8.f.f4591S3);
        this.mFunctionButtonMaxWidth = context.getResources().getDimensionPixelOffset(X8.f.f4486D3);
        this.mFunctionButtonStartGap = context.getResources().getDimensionPixelOffset(X8.f.f4500F3);
        this.mButtonOffsetAnimationDistance = context.getResources().getDimensionPixelOffset(X8.f.f4493E3);
        Resources resources = context.getResources();
        int i12 = X8.f.f4688f4;
        this.mIconMaxWidth = resources.getDimensionPixelSize(i12);
        this.mIconMaxHeight = context.getResources().getDimensionPixelSize(i12);
        this.mFunctionButtonEndGap = new int[]{context.getResources().getDimensionPixelOffset(X8.f.f4465A3), context.getResources().getDimensionPixelOffset(X8.f.f4479C3), context.getResources().getDimensionPixelOffset(X8.f.f4472B3)};
        this.mNavigationButtonStartGap = new int[]{context.getResources().getDimensionPixelOffset(X8.f.f4528J3), context.getResources().getDimensionPixelOffset(X8.f.f4542L3), context.getResources().getDimensionPixelOffset(X8.f.f4535K3)};
        this.mOuterButtonEndGap = new int[]{context.getResources().getDimensionPixelOffset(X8.f.f4570P3), context.getResources().getDimensionPixelOffset(X8.f.f4584R3), context.getResources().getDimensionPixelOffset(X8.f.f4577Q3)};
        this.mResponsiveHorizontalPadding = new int[]{context.getResources().getDimensionPixelOffset(X8.f.f4605U3), context.getResources().getDimensionPixelOffset(X8.f.f4619W3), context.getResources().getDimensionPixelOffset(X8.f.f4612V3)};
        loadAttr(context, attributeSet, i10, i11);
        this.mNormalBackgroundColor = A.h.d(getContext().getResources(), X8.e.f4425B, getContext().getTheme());
        this.mPressedBackgroundColor = A.h.d(getContext().getResources(), X8.e.f4426C, getContext().getTheme());
        this.mDrawingProxyDrawable.setButtonDividerColor(COUIContextUtil.getAttrColor(getContext(), X8.c.f4400q));
        this.mDrawingProxyDrawable.setCurrentBackgroundColor(this.mNormalBackgroundColor);
        this.mSearchBarContentDesc = getResources().getString(X8.m.f5010i);
        this.mSearchBarHintTitleDesc = getResources().getString(X8.m.f4993C);
    }

    private void initDrawingProxyView() {
        View view = new View(getContext());
        this.mDrawingProxyView = view;
        COUIDarkModeUtil.setForceDarkAllow(view, false);
        COUIMaskEffectDrawable cOUIMaskEffectDrawable = new COUIMaskEffectDrawable(getContext(), 0);
        this.mMaskDrawable = cOUIMaskEffectDrawable;
        cOUIMaskEffectDrawable.setMaskPath(this.mDrawingProxyDrawable.getNormalBackgroundPath());
        COUIStrokeDrawable cOUIStrokeDrawable = new COUIStrokeDrawable(getContext());
        this.mStrokeDrawable = cOUIStrokeDrawable;
        cOUIStrokeDrawable.setStrokePath(this.mDrawingProxyDrawable.getNormalBackgroundPath());
        COUIStateEffectDrawable cOUIStateEffectDrawable = new COUIStateEffectDrawable(new Drawable[]{this.mDrawingProxyDrawable, this.mMaskDrawable, this.mStrokeDrawable});
        this.mStateEffectBackground = cOUIStateEffectDrawable;
        this.mDrawingProxyView.setBackground(cOUIStateEffectDrawable);
        addView(this.mDrawingProxyView, new ViewGroup.LayoutParams(-1, -1));
        setDefaultFocusHighlightEnabled(false);
        setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.coui.appcompat.searchview.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                COUISearchBar.this.lambda$initDrawingProxyView$0(view2, z10);
            }
        });
    }

    private void initEdittext() {
        EditText editText = new EditText(new ContextThemeWrapper(getContext(), X8.n.f5049u), null);
        this.mSearchEditText = editText;
        editText.setVerticalScrollBarEnabled(false);
        this.mSearchEditText.setMaxLines(1);
        this.mSearchEditText.setInputType(1);
        this.mSearchEditText.setEllipsize(TextUtils.TruncateAt.END);
        this.mSearchEditText.setImeOptions(3);
        this.mSearchEditText.setId(X8.h.f4947s0);
        this.mSearchEditText.setImportantForAccessibility(2);
        this.mSearchEditText.setImportantForAutofill(2);
        this.mSearchEditText.addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.searchview.COUISearchBar.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    COUISearchBar cOUISearchBar = COUISearchBar.this;
                    cOUISearchBar.showButton(cOUISearchBar.mInnerPrimaryButton, true);
                    COUISearchBar cOUISearchBar2 = COUISearchBar.this;
                    cOUISearchBar2.showButton(cOUISearchBar2.mInnerSecondaryButton, true);
                    COUISearchBar cOUISearchBar3 = COUISearchBar.this;
                    cOUISearchBar3.showButton(cOUISearchBar3.mQuickDeleteButton, false);
                    return;
                }
                COUISearchBar cOUISearchBar4 = COUISearchBar.this;
                cOUISearchBar4.showButton(cOUISearchBar4.mInnerPrimaryButton, false);
                COUISearchBar cOUISearchBar5 = COUISearchBar.this;
                cOUISearchBar5.showButton(cOUISearchBar5.mInnerSecondaryButton, false);
                COUISearchBar cOUISearchBar6 = COUISearchBar.this;
                cOUISearchBar6.showButton(cOUISearchBar6.mQuickDeleteButton, true);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
                COUISearchBar.this.ensureQuickDeleteButton();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        addView(this.mSearchEditText);
    }

    private void initFunctionButton() {
        TextView textView = new TextView(getContext());
        this.mFunctionalButton = textView;
        textView.setMaxLines(1);
        this.mFunctionalButton.setEllipsize(TextUtils.TruncateAt.END);
        this.mFunctionalButton.setTextAppearance(getContext(), X8.n.f5053y);
        this.mFunctionalButton.setText(X8.m.f5011j);
        this.mFunctionalButton.setTextColor(A.h.d(getResources(), X8.e.f4427D, getContext().getTheme()));
        this.mFunctionalButton.setClickable(true);
        this.mFunctionalButton.setFocusable(true);
        this.mFunctionalButton.setAlpha(0.0f);
        this.mFunctionalButton.setVisibility(8);
        this.mFunctionalButton.setTextSize(0, COUIChangeTextUtil.getSuitableFontSize(this.mFunctionalButton.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
        COUITextViewCompatUtil.setPressRippleDrawable(this.mFunctionalButton);
        addView(this.mFunctionalButton);
    }

    private boolean isInMultiWindowMode() {
        if (getContext() instanceof Activity) {
            return ((Activity) getContext()).isInMultiWindowMode();
        }
        return false;
    }

    private boolean isInsideBackground(float f10, float f11) {
        return this.mBackgroundRect.contains((int) f10, (int) f11);
    }

    private boolean isInsideFunctionButton(float f10, float f11) {
        return isInsideView(this.mFunctionalButton, f10, f11);
    }

    private boolean isInsideInnerButton(float f10, float f11) {
        if (!isInsideView(this.mInnerPrimaryButton, f10, f11) && !isInsideView(this.mInnerSecondaryButton, f10, f11) && !isInsideView(this.mQuickDeleteButton, f10, f11)) {
            return false;
        }
        return true;
    }

    private boolean isInsideOuterButton(float f10, float f11) {
        if (!isInsideView(this.mOuterPrimaryButton, f10, f11) && !isInsideView(this.mOuterSecondaryButton, f10, f11) && !isInsideView(this.mNavigationView, f10, f11)) {
            return false;
        }
        return true;
    }

    private boolean isInsideView(View view, float f10, float f11) {
        if (view == null || view.getVisibility() == 8 || f10 < view.getLeft() || f10 > view.getRight() || f11 < view.getTop() || f11 > view.getBottom()) {
            return false;
        }
        return true;
    }

    private boolean isRtl() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureQuickDeleteButton$1(View view) {
        EditText editText = this.mSearchEditText;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideInToolBar$3(ValueAnimator valueAnimator) {
        setToolBarAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDrawingProxyView$0(View view, boolean z10) {
        this.mStateEffectBackground.setFocused(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setImeInsetsAnimationCallback$4(ImeInsetsAnimationCallback imeInsetsAnimationCallback) {
        K.G0(this.mSearchEditText.getRootView(), imeInsetsAnimationCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInToolBar$2(ValueAnimator valueAnimator) {
        setToolBarAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void layoutBackground() {
        int internalPaddingStart;
        int i10;
        int width;
        View view = this.mDrawingProxyView;
        view.layout(0, 0, view.getMeasuredWidth(), this.mDrawingProxyView.getMeasuredHeight());
        int calculateRelativeTop = calculateRelativeTop(0, getMeasuredHeight(), this.mBackgroundRect.height());
        int height = this.mBackgroundRect.height() + calculateRelativeTop;
        if (isRtl()) {
            if (shouldLayoutOut(this.mNavigationView)) {
                width = this.mNavigationView.getLeft();
            } else {
                width = getMeasuredWidth() - (getInternalPaddingStart() - this.mExtraHorizontalBackground);
            }
            i10 = width - this.mBackgroundRect.width();
        } else {
            if (shouldLayoutOut(this.mNavigationView)) {
                internalPaddingStart = this.mNavigationView.getRight();
            } else {
                internalPaddingStart = getInternalPaddingStart() - this.mExtraHorizontalBackground;
            }
            i10 = internalPaddingStart;
            width = this.mBackgroundRect.width() + i10;
        }
        this.mBackgroundRect.set(i10, calculateRelativeTop, width, height);
        updateBackgroundPath();
    }

    private void layoutBackgroundArea() {
        layoutBackground();
        layoutSearchIcon();
        layoutEditFrame();
        int layoutInnerButton = layoutInnerButton();
        if (this.mSearchViewType == 1) {
            layoutFunctionalButton(layoutDivider(layoutInnerButton));
        }
    }

    private void layoutBackgroundLeft() {
        if (this.mSearchViewType == 1) {
            layoutNavigationButton();
        }
    }

    private void layoutBackgroundRight() {
        int i10;
        int i11 = this.mSearchViewType;
        if (i11 == 0) {
            if (isRtl()) {
                i10 = this.mBackgroundRect.left - this.mFunctionButtonStartGap;
            } else {
                i10 = this.mBackgroundRect.right + this.mFunctionButtonStartGap;
            }
            layoutFunctionalButton(i10);
            if (getOuterButtonCount() == 1) {
                layoutOuterButton();
                return;
            }
            return;
        }
        if (i11 == 1) {
            layoutOuterButton();
        }
    }

    private int layoutDivider(int i10) {
        int width;
        int i11;
        Rect rect = this.mBackgroundRect;
        int calculateRelativeTop = calculateRelativeTop(rect.top, rect.height(), this.mDividerRect.height());
        int height = this.mDividerRect.height() + calculateRelativeTop;
        if (isRtl()) {
            int width2 = i10 - this.mDividerRect.width();
            i11 = i10 - this.mNonInstantSearchInnerGap;
            width = i10;
            i10 = width2;
        } else {
            width = this.mDividerRect.width() + i10;
            i11 = this.mNonInstantSearchInnerGap + i10;
        }
        int width3 = i11 + this.mDividerRect.width();
        this.mDividerRect.set(i10, calculateRelativeTop, width, height);
        this.mDrawingProxyDrawable.setDividerRect(this.mDividerRect);
        return width3;
    }

    private void layoutEditFrame() {
        int i10;
        int i11;
        Rect rect = this.mBackgroundRect;
        int calculateRelativeTop = calculateRelativeTop(rect.top, rect.height(), getSearchEditOrAnimationLayout().getMeasuredHeight());
        if (isRtl()) {
            if (shouldLayoutOut(this.mSearchIconView)) {
                i11 = this.mSearchIconView.getLeft();
            } else {
                i11 = this.mBackgroundRect.right;
            }
            getSearchEditOrAnimationLayout().layout(i11 - getSearchEditOrAnimationLayout().getMeasuredWidth(), calculateRelativeTop, i11, getSearchEditOrAnimationLayout().getMeasuredHeight() + calculateRelativeTop);
            return;
        }
        if (shouldLayoutOut(this.mSearchIconView)) {
            i10 = this.mSearchIconView.getRight();
        } else {
            i10 = this.mBackgroundRect.left;
        }
        getSearchEditOrAnimationLayout().layout(i10, calculateRelativeTop, getSearchEditOrAnimationLayout().getMeasuredWidth() + i10, getSearchEditOrAnimationLayout().getMeasuredHeight() + calculateRelativeTop);
    }

    private void layoutFunctionalButton(int i10) {
        if (shouldLayoutOut(this.mFunctionalButton)) {
            Rect rect = this.mBackgroundRect;
            int calculateRelativeTop = calculateRelativeTop(rect.top, rect.height(), this.mFunctionalButton.getMeasuredHeight());
            if (isRtl()) {
                TextView textView = this.mFunctionalButton;
                textView.layout(i10 - textView.getMeasuredWidth(), calculateRelativeTop, i10, this.mFunctionalButton.getMeasuredHeight() + calculateRelativeTop);
            } else {
                TextView textView2 = this.mFunctionalButton;
                textView2.layout(i10, calculateRelativeTop, textView2.getMeasuredWidth() + i10, this.mFunctionalButton.getMeasuredHeight() + calculateRelativeTop);
            }
        }
    }

    private int layoutInnerButton() {
        if (isRtl()) {
            int left = getSearchEditOrAnimationLayout().getLeft();
            if (shouldLayoutOut(this.mQuickDeleteButton)) {
                Rect rect = this.mBackgroundRect;
                int calculateRelativeTop = calculateRelativeTop(rect.top, rect.height(), this.mQuickDeleteButton.getMeasuredHeight());
                ImageView imageView = this.mQuickDeleteButton;
                imageView.layout(left - imageView.getMeasuredWidth(), calculateRelativeTop, left, this.mQuickDeleteButton.getMeasuredHeight() + calculateRelativeTop);
                left -= this.mQuickDeleteButton.getMeasuredWidth();
            }
            if (shouldLayoutOut(this.mInnerPrimaryButton)) {
                Rect rect2 = this.mBackgroundRect;
                int calculateRelativeTop2 = calculateRelativeTop(rect2.top, rect2.height(), this.mInnerPrimaryButton.getMeasuredHeight());
                ImageView imageView2 = this.mInnerPrimaryButton;
                imageView2.layout(left - imageView2.getMeasuredWidth(), calculateRelativeTop2, left, this.mInnerPrimaryButton.getMeasuredHeight() + calculateRelativeTop2);
                left -= this.mInnerPrimaryButton.getMeasuredWidth();
            }
            if (shouldLayoutOut(this.mInnerSecondaryButton)) {
                Rect rect3 = this.mBackgroundRect;
                int calculateRelativeTop3 = calculateRelativeTop(rect3.top, rect3.height(), this.mInnerSecondaryButton.getMeasuredHeight());
                ImageView imageView3 = this.mInnerSecondaryButton;
                imageView3.layout(left - imageView3.getMeasuredWidth(), calculateRelativeTop3, left, this.mInnerSecondaryButton.getMeasuredHeight() + calculateRelativeTop3);
                left -= this.mInnerSecondaryButton.getMeasuredWidth();
            }
            if (left != getSearchEditOrAnimationLayout().getLeft()) {
                return left - this.mNonInstantSearchInnerGap;
            }
            return left;
        }
        int right = getSearchEditOrAnimationLayout().getRight();
        if (shouldLayoutOut(this.mQuickDeleteButton)) {
            Rect rect4 = this.mBackgroundRect;
            int calculateRelativeTop4 = calculateRelativeTop(rect4.top, rect4.height(), this.mQuickDeleteButton.getMeasuredHeight());
            ImageView imageView4 = this.mQuickDeleteButton;
            imageView4.layout(right, calculateRelativeTop4, imageView4.getMeasuredWidth() + right, this.mQuickDeleteButton.getMeasuredHeight() + calculateRelativeTop4);
            right += this.mQuickDeleteButton.getMeasuredWidth();
        }
        if (shouldLayoutOut(this.mInnerPrimaryButton)) {
            Rect rect5 = this.mBackgroundRect;
            int calculateRelativeTop5 = calculateRelativeTop(rect5.top, rect5.height(), this.mInnerPrimaryButton.getMeasuredHeight());
            ImageView imageView5 = this.mInnerPrimaryButton;
            imageView5.layout(right, calculateRelativeTop5, imageView5.getMeasuredWidth() + right, this.mInnerPrimaryButton.getMeasuredHeight() + calculateRelativeTop5);
            right += this.mInnerPrimaryButton.getMeasuredWidth();
        }
        if (shouldLayoutOut(this.mInnerSecondaryButton)) {
            Rect rect6 = this.mBackgroundRect;
            int calculateRelativeTop6 = calculateRelativeTop(rect6.top, rect6.height(), this.mInnerSecondaryButton.getMeasuredHeight());
            ImageView imageView6 = this.mInnerSecondaryButton;
            imageView6.layout(right, calculateRelativeTop6, imageView6.getMeasuredWidth() + right, this.mInnerSecondaryButton.getMeasuredHeight() + calculateRelativeTop6);
            right += this.mInnerSecondaryButton.getMeasuredWidth();
        }
        if (right != getSearchEditOrAnimationLayout().getRight()) {
            return right + this.mNonInstantSearchInnerGap;
        }
        return right;
    }

    private void layoutNavigationButton() {
        if (shouldLayoutOut(this.mNavigationView)) {
            int calculateRelativeTop = calculateRelativeTop(0, getMeasuredHeight(), this.mNavigationView.getMeasuredHeight());
            if (isRtl()) {
                int measuredWidth = getMeasuredWidth() - this.mNavigationButtonStartGap[this.mResponsiveWidthSize];
                ImageView imageView = this.mNavigationView;
                imageView.layout(measuredWidth - imageView.getMeasuredWidth(), calculateRelativeTop, measuredWidth, this.mNavigationView.getMeasuredHeight() + calculateRelativeTop);
            } else {
                int i10 = this.mNavigationButtonStartGap[this.mResponsiveWidthSize];
                ImageView imageView2 = this.mNavigationView;
                imageView2.layout(i10, calculateRelativeTop, imageView2.getMeasuredWidth() + i10, this.mNavigationView.getMeasuredHeight() + calculateRelativeTop);
            }
        }
    }

    private void layoutOuterButton() {
        if (isRtl()) {
            int i10 = this.mBackgroundRect.left - this.mOuterButtonGap;
            if (shouldLayoutOut(this.mOuterPrimaryButton)) {
                int calculateRelativeTop = calculateRelativeTop(0, getMeasuredHeight(), this.mOuterPrimaryButton.getMeasuredHeight());
                ImageView imageView = this.mOuterPrimaryButton;
                imageView.layout(i10 - imageView.getMeasuredWidth(), calculateRelativeTop, i10, this.mOuterPrimaryButton.getMeasuredHeight() + calculateRelativeTop);
                i10 -= this.mOuterPrimaryButton.getMeasuredWidth();
            }
            if (shouldLayoutOut(this.mOuterSecondaryButton)) {
                int calculateRelativeTop2 = calculateRelativeTop(0, getMeasuredHeight(), this.mOuterSecondaryButton.getMeasuredHeight());
                ImageView imageView2 = this.mOuterSecondaryButton;
                imageView2.layout(i10 - imageView2.getMeasuredWidth(), calculateRelativeTop2, i10, this.mOuterSecondaryButton.getMeasuredHeight() + calculateRelativeTop2);
                return;
            }
            return;
        }
        int i11 = this.mBackgroundRect.right + this.mOuterButtonGap;
        if (shouldLayoutOut(this.mOuterPrimaryButton)) {
            int calculateRelativeTop3 = calculateRelativeTop(0, getMeasuredHeight(), this.mOuterPrimaryButton.getMeasuredHeight());
            ImageView imageView3 = this.mOuterPrimaryButton;
            imageView3.layout(i11, calculateRelativeTop3, imageView3.getMeasuredWidth() + i11, this.mOuterPrimaryButton.getMeasuredHeight() + calculateRelativeTop3);
            i11 += this.mOuterPrimaryButton.getMeasuredWidth();
        }
        if (shouldLayoutOut(this.mOuterSecondaryButton)) {
            int calculateRelativeTop4 = calculateRelativeTop(0, getMeasuredHeight(), this.mOuterSecondaryButton.getMeasuredHeight());
            ImageView imageView4 = this.mOuterSecondaryButton;
            imageView4.layout(i11, calculateRelativeTop4, imageView4.getMeasuredWidth() + i11, this.mOuterSecondaryButton.getMeasuredHeight() + calculateRelativeTop4);
        }
    }

    private void layoutSearchIcon() {
        if (shouldLayoutOut(this.mSearchIconView)) {
            Rect rect = this.mBackgroundRect;
            int calculateRelativeTop = calculateRelativeTop(rect.top, rect.height(), this.mSearchIconView.getMeasuredHeight());
            if (isRtl()) {
                int i10 = this.mBackgroundRect.right - this.mSearchIconStartGap;
                ImageView imageView = this.mSearchIconView;
                imageView.layout(i10 - imageView.getMeasuredWidth(), calculateRelativeTop, i10, this.mSearchIconView.getMeasuredHeight() + calculateRelativeTop);
            } else {
                int i11 = this.mBackgroundRect.left + this.mSearchIconStartGap;
                ImageView imageView2 = this.mSearchIconView;
                imageView2.layout(i11, calculateRelativeTop, imageView2.getMeasuredWidth() + i11, this.mSearchIconView.getMeasuredHeight() + calculateRelativeTop);
            }
        }
    }

    private void loadAttr(Context context, AttributeSet attributeSet, int i10, int i11) {
        Drawable f10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X8.o.f5092E4, i10, i11);
        int i12 = X8.o.f5140K4;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.mSearchEditText.setTextSize(obtainStyledAttributes.getDimension(i12, this.mSearchEditText.getTextSize()));
        }
        int i13 = X8.o.f5132J4;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.mSearchEditText.setTextColor(obtainStyledAttributes.getColorStateList(i13));
        }
        int i14 = X8.o.f5148L4;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.mSearchEditText.setHintTextColor(obtainStyledAttributes.getColorStateList(i14));
        }
        int i15 = X8.o.f5116H4;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.mFunctionalButton.setText(obtainStyledAttributes.getString(i15));
        }
        int i16 = X8.o.f5124I4;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.mFunctionalButton.setTextColor(obtainStyledAttributes.getColorStateList(i16));
        }
        int i17 = X8.o.f5108G4;
        if (obtainStyledAttributes.hasValue(i17)) {
            f10 = obtainStyledAttributes.getDrawable(i17);
        } else {
            f10 = A.h.f(getContext().getResources(), X8.g.f4870w, getContext().getTheme());
        }
        int intrinsicWidth = f10.getIntrinsicWidth();
        int i18 = this.mIconMaxWidth;
        if (intrinsicWidth > i18) {
            f10 = zoomDrawable(f10, (int) (i18 * getResources().getDisplayMetrics().density), (int) (this.mIconMaxHeight * getResources().getDisplayMetrics().density));
        }
        if (this.mSearchIconView == null) {
            ImageView ensureImageView = ensureImageView(f10, false, false, 0);
            this.mSearchIconView = ensureImageView;
            ensureImageView.setId(X8.h.f4918e);
            this.mSearchIconView.setImportantForAccessibility(2);
        }
        configImageViewDrawable(this.mSearchIconView, f10, this.mInnerIconSize);
        int i19 = X8.o.f5156M4;
        if (obtainStyledAttributes.hasValue(i19)) {
            this.mSearchEditText.setHint(obtainStyledAttributes.getString(i19));
        }
        this.mClearTextDrawableResourceId = obtainStyledAttributes.getResourceId(X8.o.f5100F4, X8.g.f4870w);
        obtainStyledAttributes.recycle();
    }

    private int measureBackground(int i10) {
        measureFunctionalButton();
        measureView(this.mDrawingProxyView, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        int i11 = this.mSearchViewType;
        if (i11 == 0) {
            int measuredWidth = (int) (((((getMeasuredWidth() - getInternalPaddingStart()) - this.mFunctionalButton.getMeasuredWidth()) - this.mFunctionButtonStartGap) - this.mFunctionButtonEndGap[this.mResponsiveWidthSize]) + ((i10 - r0) * (1.0f - this.mShrinkFraction)));
            measureRect(this.mBackgroundRect, (this.mExtraHorizontalBackground * 2) + measuredWidth, (int) Float.max(this.mCollapsedMinHeight, this.mNormalBackgroundHeight * this.mBackgroundScaleFraction));
            return measuredWidth;
        }
        if (i11 == 1) {
            measureRect(this.mBackgroundRect, i10, (int) Float.max(this.mCollapsedMinHeight, this.mNormalBackgroundHeight * this.mBackgroundScaleFraction));
            return i10;
        }
        return i10;
    }

    private int measureDivider(int i10) {
        if (this.mSearchViewType == 1) {
            measureRect(this.mDividerRect, this.mDividerWidth, this.mDividerHeight);
            return (i10 - this.mNonInstantSearchInnerGap) - this.mDividerWidth;
        }
        return i10;
    }

    private void measureEditFrame(int i10) {
        measureView(getSearchEditOrAnimationLayout(), View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mNormalBackgroundHeight, Integer.MIN_VALUE));
    }

    private void measureFunctionalButton() {
        if (shouldLayoutOut(this.mFunctionalButton)) {
            measureView(this.mFunctionalButton, View.MeasureSpec.makeMeasureSpec(this.mFunctionButtonMaxWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
        }
    }

    private int measureInnerButton(int i10) {
        int i11;
        if (shouldLayoutOut(this.mInnerPrimaryButton)) {
            i11 = i10 - measureView(this.mInnerPrimaryButton, View.MeasureSpec.makeMeasureSpec(this.mInnerIconSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mInnerIconSize, 1073741824));
        } else {
            i11 = i10;
        }
        if (shouldLayoutOut(this.mInnerSecondaryButton)) {
            i11 -= measureView(this.mInnerSecondaryButton, View.MeasureSpec.makeMeasureSpec(this.mInnerIconSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mInnerIconSize, 1073741824));
        }
        if (shouldLayoutOut(this.mQuickDeleteButton)) {
            i11 -= measureView(this.mQuickDeleteButton, View.MeasureSpec.makeMeasureSpec(this.mInnerIconSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mInnerIconSize, 1073741824));
        }
        if (i11 != i10) {
            return i11 - this.mNonInstantSearchInnerGap;
        }
        return i11;
    }

    private void measureInsideBackground(int i10) {
        int measureSearchIcon = measureSearchIcon(i10);
        int i11 = this.mSearchViewType;
        if (i11 == 0) {
            measureSearchIcon = measureInnerButton(measureSearchIcon);
        } else if (i11 == 1) {
            if (shouldLayoutOut(this.mFunctionalButton)) {
                measureSearchIcon = measureDivider(measureSearchIcon - (this.mFunctionalButton.getMeasuredWidth() + this.mNonInstantSearchInnerGap));
            }
            measureSearchIcon = measureInnerButton(measureSearchIcon);
        }
        measureEditFrame(measureSearchIcon);
    }

    private int measureNavigationButton(int i10) {
        if (shouldLayoutOut(this.mNavigationView) && this.mSearchViewType == 1) {
            int measureView = i10 - measureView(this.mNavigationView, View.MeasureSpec.makeMeasureSpec(this.mNavigationButtonWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            if (measureView != i10 && this.mUseResponsivePadding) {
                return (measureView + getInternalPaddingStart()) - this.mNavigationButtonStartGap[this.mResponsiveWidthSize];
            }
            return measureView;
        }
        return i10;
    }

    private int measureOuterButton(int i10) {
        int i11;
        if (this.mSearchViewType != 1 && getOuterButtonCount() != 1) {
            return i10;
        }
        if (shouldLayoutOut(this.mOuterPrimaryButton)) {
            i11 = i10 - measureView(this.mOuterPrimaryButton, View.MeasureSpec.makeMeasureSpec(this.mOuterButtonWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        } else {
            i11 = i10;
        }
        if (shouldLayoutOut(this.mOuterSecondaryButton)) {
            i11 -= measureView(this.mOuterSecondaryButton, View.MeasureSpec.makeMeasureSpec(this.mOuterButtonWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
        if (i11 != i10) {
            if (this.mUseResponsivePadding) {
                i11 = (i11 + getInternalPaddingEnd()) - this.mOuterButtonEndGap[this.mResponsiveWidthSize];
            }
            return i11 - this.mOuterButtonGap;
        }
        return i11;
    }

    private int measureOutsideBackground() {
        return measureOuterButton(measureNavigationButton((getMeasuredWidth() - getInternalPaddingStart()) - getInternalPaddingEnd()));
    }

    private void measureRect(Rect rect, int i10, int i11) {
        if (rect != null) {
            rect.set(0, 0, i10, i11);
        }
    }

    private int measureSearchIcon(int i10) {
        if (shouldLayoutOut(this.mSearchIconView)) {
            int measureView = i10 - measureView(this.mSearchIconView, View.MeasureSpec.makeMeasureSpec(this.mInnerIconSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mInnerIconSize, 1073741824));
            if (measureView != i10) {
                return measureView - this.mSearchIconStartGap;
            }
            return measureView;
        }
        return i10;
    }

    private int measureView(View view, int i10, int i11) {
        view.measure(i10, i11);
        return view.getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnStateChange(int i10, int i11) {
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            for (OnStateChangeListener onStateChangeListener : list) {
                if (onStateChangeListener != null) {
                    onStateChangeListener.onStateChange(i10, i11);
                }
            }
        }
    }

    private void removeLast() {
        int childCount = this.mToolBar.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (getClass().isInstance(this.mToolBar.getChildAt(i10))) {
                this.mToolBar.removeViewAt(i10);
                return;
            }
        }
    }

    private void setMenuItem(MenuItem menuItem) {
        this.mMenuItem = menuItem;
        if (menuItem != null && menuItem.getActionView() == this) {
            this.mMenuItem.setActionView((View) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOuterButtonVisibility(int i10) {
        if (i10 != 0 && i10 != 4 && i10 != 8) {
            return;
        }
        ImageView imageView = this.mOuterPrimaryButton;
        if (imageView != null) {
            imageView.setVisibility(i10);
        }
        ImageView imageView2 = this.mOuterSecondaryButton;
        if (imageView2 != null) {
            imageView2.setVisibility(i10);
        }
    }

    private void setToolBarAlpha(float f10) {
        COUIToolbar cOUIToolbar = this.mToolBar;
        if (cOUIToolbar != null) {
            int childCount = cOUIToolbar.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.mToolBar.getChildAt(i10);
                if (childAt != this) {
                    childAt.setAlpha(f10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolBarChildVisibility(int i10) {
        COUIToolbar cOUIToolbar = this.mToolBar;
        if (cOUIToolbar != null) {
            int childCount = cOUIToolbar.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = this.mToolBar.getChildAt(i11);
                if (childAt != this) {
                    childAt.setVisibility(i10);
                }
            }
        }
    }

    private boolean shouldLayoutOut(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof ImageView) {
            if (((ImageView) view).getDrawable() == null || view.getVisibility() == 8) {
                return false;
            }
            return true;
        }
        if (view.getVisibility() == 8) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showButton(View view, boolean z10) {
        int i10;
        if (view != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            view.setVisibility(i10);
        }
    }

    private void showSoftInput() {
        CustomWindowInsetsAnimationControlListener customWindowInsetsAnimationControlListener = new CustomWindowInsetsAnimationControlListener(true, this.mShowImeAnimDuration, this.mShowImeInterpolator);
        if (this.mSearchEditText.getWindowInsetsController() != null) {
            this.mSearchEditText.getWindowInsetsController().controlWindowInsetsAnimation(WindowInsets.Type.ime(), this.mShowImeAnimDuration, this.mShowImeInterpolator, null, customWindowInsetsAnimationControlListener);
        }
    }

    private void updateAccessibilityImportance(int i10) {
        if (i10 == 1) {
            this.mSearchEditText.setImportantForAccessibility(1);
        } else if (i10 == 0) {
            this.mSearchEditText.setImportantForAccessibility(2);
        }
    }

    private void updateBackgroundPath() {
        Rect rect = this.mBackgroundRect;
        COUIShapePath.getRoundRectPath(this.mDrawingProxyDrawable.getNormalBackgroundPath(), new RectF(this.mBackgroundRect), (rect.bottom - rect.top) / 2.0f, true, true, true, true);
        this.mDrawingProxyDrawable.invalidateSelf();
    }

    private Drawable zoomDrawable(Drawable drawable, int i10, int i11) {
        return new BitmapDrawable(Bitmap.createScaledBitmap(drawableToBitmap(drawable), i10, i11, true));
    }

    public void addOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        if (this.mOnStateChangeListeners == null) {
            this.mOnStateChangeListeners = new ArrayList();
        }
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    public void changeState(int i10, boolean z10) {
        if (z10) {
            changeStateWithAnimation(i10);
        } else {
            changeStateImmediately(i10);
        }
    }

    public void changeStateImmediately(int i10) {
        if (this.mState.get() == i10) {
            COUILog.d(TAG, "changeStateImmediately: same state , return. targetState = " + i10);
            return;
        }
        updateAccessibilityImportance(i10);
        if (this.mState.get() == 1) {
            getAnimatorHelper().runStateChangeImmediately(0);
        } else if (this.mState.get() == 0) {
            getAnimatorHelper().runStateChangeImmediately(1);
        }
    }

    public void changeStateWithAnimation(int i10) {
        if (this.mState.get() == i10) {
            COUILog.d(TAG, "changeStateWithAnimation: same state , return. targetState = " + i10);
            return;
        }
        updateAccessibilityImportance(i10);
        if (this.mState.get() == 1) {
            getAnimatorHelper().runStateChangeAnimation(0);
        } else if (this.mState.get() == 0) {
            getAnimatorHelper().runStateChangeAnimation(1);
        }
    }

    public void controlImeShowAnim(int i10, Interpolator interpolator) {
        this.mShowImeAnimDuration = i10;
        this.mShowImeInterpolator = interpolator;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f10 = this.mCollapsingHeightPercent;
        if (f10 < 1.0f && f10 >= 0.5f) {
            canvas.save();
            canvas.clipRect(0, this.mBackgroundRect.top, getWidth(), this.mBackgroundRect.bottom);
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (isEnabled() && (motionEvent.getActionMasked() == 9 || motionEvent.getActionMasked() == 7)) {
            this.mStateEffectBackground.setHovered(isInsideBackground(motionEvent.getX(), motionEvent.getY()));
        }
        if (motionEvent.getActionMasked() == 10) {
            this.mStateEffectBackground.setHovered(false);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                if (!isInsideBackground(motionEvent.getX(), motionEvent.getY()) && this.mPressed) {
                    this.mPressed = false;
                    this.mStateEffectBackground.setTouched(false);
                }
            } else if (isInsideBackground(motionEvent.getX(), motionEvent.getY()) || this.mPressed) {
                this.mPressed = false;
                this.mStateEffectBackground.setTouched(false);
            }
        } else {
            if (motionEvent.getY() < this.mBackgroundRect.top || motionEvent.getY() > this.mBackgroundRect.bottom) {
                return false;
            }
            if (isInsideBackground(motionEvent.getX(), motionEvent.getY()) && !isInsideInnerButton(motionEvent.getX(), motionEvent.getY()) && !isInsideFunctionButton(motionEvent.getX(), motionEvent.getY())) {
                this.mPressed = true;
                this.mStateEffectBackground.setTouched(true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public TextView getFunctionalButton() {
        return this.mFunctionalButton;
    }

    public COUIHintAnimationLayout getHintAnimationLayout() {
        if (this.mCOUIHintAnimationLayout == null) {
            this.mCOUIHintAnimationLayout = new COUIHintAnimationLayout(getContext());
            removeView(this.mSearchEditText);
            this.mCOUIHintAnimationLayout.setSearchEditText(this.mSearchEditText);
            addView(this.mCOUIHintAnimationLayout);
        }
        return this.mCOUIHintAnimationLayout;
    }

    public View getInnerPrimaryButton() {
        return this.mInnerPrimaryButton;
    }

    public View getInnerSecondaryButton() {
        return this.mInnerSecondaryButton;
    }

    public boolean getInputMethodAnimationEnabled() {
        return this.mInputMethodAnimationEnabled;
    }

    public View getNavigationView() {
        return this.mNavigationView;
    }

    public View getOuterPrimaryButton() {
        return this.mOuterPrimaryButton;
    }

    public View getOuterSecondaryButton() {
        return this.mOuterSecondaryButton;
    }

    public View getQuickDeleteButton() {
        return this.mQuickDeleteButton;
    }

    public EditText getSearchEditText() {
        return this.mSearchEditText;
    }

    public int getSearchState() {
        return this.mState.get();
    }

    public float getSearchViewAnimateHeightPercent() {
        return this.mCollapsingHeightPercent;
    }

    public void hideInToolBar() {
        if (this.mToolBar != null && !this.mToolBarAnimationRunning) {
            this.mToolBarAnimationRunning = true;
            ensureAddedToToolBar();
            if (this.mAddToToolbarWay == 1) {
                animate().alpha(0.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchBar.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        COUISearchBar.this.setVisibility(8);
                    }
                }).start();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(150L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.this.lambda$hideInToolBar$3(valueAnimator);
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchBar.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    COUISearchBar.this.mToolBarAnimationRunning = false;
                    COUISearchBar.this.setToolBarChildVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (COUISearchBar.this.mInputMethodAnimationEnabled) {
                        COUISearchBar.this.openSoftInput(false);
                    }
                }
            });
            ofFloat.start();
        }
    }

    @Override // com.coui.appcompat.searchview.ImeInsetsAnimationCallback.OnImeAnimationListener
    public void onImeAnimStart() {
        if (this.mSearchEditText.getRootWindowInsets() != null && this.mSearchEditText.getRootWindowInsets().isVisible(WindowInsets.Type.ime())) {
            getAnimatorHelper().startAnimateToEditState();
            this.mSearchViewSmoothEnterAnimatorSet.start();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.mSearchEditText.getImportantForAccessibility() == 1) {
            return;
        }
        String str = "";
        if (!TextUtils.isEmpty(this.mSearchBarContentDesc)) {
            str = "" + this.mSearchBarContentDesc;
        }
        COUIHintAnimationLayout cOUIHintAnimationLayout = this.mCOUIHintAnimationLayout;
        if (cOUIHintAnimationLayout != null && cOUIHintAnimationLayout.getCurrentHintTextView() != null) {
            str = str + "," + this.mSearchBarHintTitleDesc + ((Object) this.mCOUIHintAnimationLayout.getCurrentHintTextView().getText());
        }
        accessibilityNodeInfo.setContentDescription(str);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isInsideInnerButton(motionEvent.getX(), motionEvent.getY()) && !isInsideOuterButton(motionEvent.getX(), motionEvent.getY())) {
            if (this.mState.get() == 0) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        layoutBackgroundLeft();
        layoutBackgroundArea();
        layoutBackgroundRight();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
        configResponsive();
        measureInsideBackground(measureBackground(measureOutsideBackground()));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof COUISavedState) {
            setSearchViewAnimateHeightPercent(((COUISavedState) parcelable).mCollapsingHeightPercent);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        COUISavedState cOUISavedState = new COUISavedState(super.onSaveInstanceState());
        cOUISavedState.mCollapsingHeightPercent = this.mCollapsingHeightPercent;
        return cOUISavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && !isInsideBackground(motionEvent.getX(), motionEvent.getY())) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            super.onTouchEvent(obtain);
            obtain.recycle();
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void openSoftInput(boolean z10) {
        if (this.mSearchEditText != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            COUILog.d(TAG, "openSoftInput: " + z10);
            if (z10) {
                this.mSearchEditText.requestFocus();
                if (inputMethodManager != null) {
                    if (this.mIsAtLeastR && this.mShowImeAnimDuration != 0 && !isInMultiWindowMode()) {
                        showSoftInput();
                        return;
                    }
                    WindowInsetsController windowInsetsController = this.mSearchEditText.getWindowInsetsController();
                    if (windowInsetsController != null) {
                        windowInsetsController.show(WindowInsets.Type.ime());
                        return;
                    }
                    return;
                }
                return;
            }
            this.mSearchEditText.clearFocus();
            if (inputMethodManager != null && inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(this.mSearchEditText.getWindowToken(), 0);
            }
        }
    }

    public void refresh() {
        loadAttr(getContext(), this.mAttrs, this.mStyle, 0);
        ImageView imageView = this.mQuickDeleteButton;
        if (imageView != null) {
            imageView.setImageDrawable(A.h.f(getContext().getResources(), this.mClearTextDrawableResourceId, getContext().getTheme()));
        }
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            cOUIStateEffectDrawable.refresh(getContext());
        }
    }

    public void removeOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list == null) {
            return;
        }
        list.remove(onStateChangeListener);
    }

    public void setAtBehindToolBar(COUIToolbar cOUIToolbar, int i10, MenuItem menuItem) {
        this.mToolBar = cOUIToolbar;
        this.mGravityInToolBar = i10;
        this.mAddToToolbarWay = 1;
        setMenuItem(menuItem);
        setVisibility(8);
    }

    public void setAtFrontToolBar(COUIToolbar cOUIToolbar, int i10, MenuItem menuItem) {
        this.mToolBar = cOUIToolbar;
        this.mGravityInToolBar = i10;
        this.mAddToToolbarWay = 2;
        setMenuItem(menuItem);
        ensureAddedToToolBar();
        menuItem.setVisible(false);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.mFunctionalButton.setEnabled(z10);
        this.mDrawingProxyView.setEnabled(z10);
        ImageView imageView = this.mSearchIconView;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
        ImageView imageView2 = this.mNavigationView;
        if (imageView2 != null) {
            imageView2.setEnabled(z10);
        }
        ImageView imageView3 = this.mQuickDeleteButton;
        if (imageView3 != null) {
            imageView3.setEnabled(z10);
        }
        ImageView imageView4 = this.mInnerPrimaryButton;
        if (imageView4 != null) {
            imageView4.setEnabled(z10);
        }
        ImageView imageView5 = this.mInnerSecondaryButton;
        if (imageView5 != null) {
            imageView5.setEnabled(z10);
        }
        ImageView imageView6 = this.mOuterPrimaryButton;
        if (imageView6 != null) {
            imageView6.setEnabled(z10);
        }
        ImageView imageView7 = this.mOuterSecondaryButton;
        if (imageView7 != null) {
            imageView7.setEnabled(z10);
        }
    }

    public void setExtraActivateMarginTop(int i10) {
        getAnimatorHelper().mExtraY = i10;
    }

    public void setFunctionalButtonText(String str) {
        this.mFunctionalButton.setText(str);
    }

    public void setImeInsetsAnimationCallback() {
        if (this.mIsAtLeastR) {
            this.mShowImeAnimDuration = 450;
            this.mShowImeInterpolator = DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR;
            final ImeInsetsAnimationCallback imeInsetsAnimationCallback = new ImeInsetsAnimationCallback();
            imeInsetsAnimationCallback.setImeAnimationListener(this);
            this.mSearchEditText.post(new Runnable() { // from class: com.coui.appcompat.searchview.b
                @Override // java.lang.Runnable
                public final void run() {
                    COUISearchBar.this.lambda$setImeInsetsAnimationCallback$4(imeInsetsAnimationCallback);
                }
            });
        }
    }

    public void setInnerPrimaryButton(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i10 = this.mIconMaxWidth;
        if (intrinsicWidth > i10) {
            drawable = zoomDrawable(drawable, (int) (i10 * getResources().getDisplayMetrics().density), (int) (this.mIconMaxHeight * getResources().getDisplayMetrics().density));
        }
        if (this.mInnerPrimaryButton == null) {
            this.mInnerPrimaryButton = ensureImageView(drawable, true, true, this.mInnerIconSize / 2);
        }
        ImageView imageView = this.mInnerPrimaryButton;
        if (imageView != null) {
            configImageViewDrawable(imageView, drawable, this.mInnerIconSize);
        }
    }

    public void setInnerSecondaryButton(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i10 = this.mIconMaxWidth;
        if (intrinsicWidth > i10) {
            drawable = zoomDrawable(drawable, (int) (i10 * getResources().getDisplayMetrics().density), (int) (this.mIconMaxHeight * getResources().getDisplayMetrics().density));
        }
        if (this.mInnerSecondaryButton == null) {
            this.mInnerSecondaryButton = ensureImageView(drawable, true, true, this.mInnerIconSize / 2);
        }
        ImageView imageView = this.mInnerSecondaryButton;
        if (imageView != null) {
            configImageViewDrawable(imageView, drawable, this.mInnerIconSize);
        }
    }

    public void setInputMethodAnimationEnabled(boolean z10) {
        this.mInputMethodAnimationEnabled = z10;
    }

    public void setNavigationViewDrawable(Drawable drawable) {
        ensureNavigationView();
        this.mNavigationView.setImageDrawable(drawable);
        this.mNavigationView.setClickable(true);
    }

    public void setOnAnimationListener(OnAnimationListener onAnimationListener) {
        this.mOnAnimationListener = onAnimationListener;
    }

    public void setOuterPrimaryButton(Drawable drawable) {
        if (drawable != null) {
            if (this.mOuterPrimaryButton == null) {
                this.mOuterPrimaryButton = ensureImageView(drawable, true, true, this.mOuterButtonWidth / 2);
            }
            ImageView imageView = this.mOuterPrimaryButton;
            if (imageView != null) {
                configImageViewDrawable(imageView, drawable, this.mOuterButtonWidth);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mOuterPrimaryButton;
        if (imageView2 != null) {
            removeView(imageView2);
            this.mOuterPrimaryButton = null;
        }
    }

    public void setOuterSecondaryButton(Drawable drawable) {
        if (drawable != null) {
            if (this.mOuterSecondaryButton == null) {
                this.mOuterSecondaryButton = ensureImageView(drawable, true, true, this.mOuterButtonWidth / 2);
            }
            ImageView imageView = this.mOuterSecondaryButton;
            if (imageView != null) {
                configImageViewDrawable(imageView, drawable, this.mOuterButtonWidth);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mOuterSecondaryButton;
        if (imageView2 != null) {
            removeView(imageView2);
            this.mOuterSecondaryButton = null;
        }
    }

    public void setSearchAnimateType(int i10) {
        if (this.mState.get() == 1) {
            COUILog.d(TAG, "setSearchAnimateType to " + TYPE_NAME[i10] + " is not allowed in STATE_EDIT");
            return;
        }
        this.mSearchViewType = i10;
        requestLayout();
    }

    public void setSearchBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i10 = this.mNormalBackgroundColor;
            int defaultColor = colorStateList.getDefaultColor();
            this.mNormalBackgroundColor = defaultColor;
            this.mPressedBackgroundColor = colorStateList.getColorForState(new int[]{16842919}, defaultColor);
            if (this.mDrawingProxyDrawable.getCurrentBackgroundColor() == i10) {
                this.mDrawingProxyDrawable.setCurrentBackgroundColor(this.mNormalBackgroundColor);
            }
            invalidate();
        }
    }

    public void setSearchViewAnimateHeightPercent(float f10) {
        this.mCollapsingHeightPercent = f10;
        this.mBackgroundScaleFraction = clampSearchViewHeight(f10);
        this.mExtraHorizontalBackground = (int) (getInternalPaddingEnd() * (1.0f - clampMarginValue(f10)));
        setTranslationY(Math.max(0.0f, ((this.mInitSearchBarHeight / 2.0f) * (1.0f - f10)) - 1.0f));
        float f11 = (f10 - 0.5f) * 2.0f;
        ImageView imageView = this.mSearchIconView;
        if (imageView != null) {
            imageView.setAlpha(f11);
        }
        ImageView imageView2 = this.mInnerPrimaryButton;
        if (imageView2 != null) {
            imageView2.setAlpha(f11);
        }
        ImageView imageView3 = this.mInnerSecondaryButton;
        if (imageView3 != null) {
            imageView3.setAlpha(f11);
        }
        ImageView imageView4 = this.mOuterPrimaryButton;
        if (imageView4 != null) {
            imageView4.setAlpha(f11);
        }
        ImageView imageView5 = this.mOuterSecondaryButton;
        if (imageView5 != null) {
            imageView5.setAlpha(f11);
        }
        this.mDrawingProxyDrawable.setCurrentBackgroundColor(((Integer) DEFAULT_EVALUATOR.evaluate(clampMarginValue(f10), Integer.valueOf(this.mHorizontalDividerColor), Integer.valueOf(this.mNormalBackgroundColor))).intValue());
        COUIHintAnimationLayout cOUIHintAnimationLayout = this.mCOUIHintAnimationLayout;
        if (cOUIHintAnimationLayout != null) {
            cOUIHintAnimationLayout.setAlpha(f11);
        } else {
            this.mSearchEditText.setAlpha(f11);
        }
        COUIHintAnimationLayout cOUIHintAnimationLayout2 = this.mCOUIHintAnimationLayout;
        if (cOUIHintAnimationLayout2 != null) {
            if (f10 < 1.0f) {
                cOUIHintAnimationLayout2.pauseHintsAnimation();
            } else {
                cOUIHintAnimationLayout2.resumeHintsAnimation();
            }
        }
        if (isInLayout()) {
            configResponsive();
            measureInsideBackground(measureBackground(measureOutsideBackground()));
            layoutBackgroundLeft();
            layoutBackgroundArea();
            layoutBackgroundRight();
            return;
        }
        requestLayout();
    }

    public void setSearchViewIcon(Drawable drawable) {
        configImageViewDrawable(this.mSearchIconView, drawable, this.mInnerIconSize);
    }

    public void setUseResponsivePadding(boolean z10) {
        this.mUseResponsivePadding = z10;
        requestLayout();
    }

    public void showInToolBar() {
        if (this.mToolBar != null && !this.mToolBarAnimationRunning) {
            this.mToolBarAnimationRunning = true;
            ensureAddedToToolBar();
            if (this.mAddToToolbarWay == 1) {
                setVisibility(0);
                setAlpha(0.0f);
                changeStateImmediately(1);
                animate().alpha(1.0f).setDuration(150L).setListener(null).start();
            }
            setToolBarChildVisibility(8);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(150L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISearchBar.this.lambda$showInToolBar$2(valueAnimator);
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchBar.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    COUISearchBar.this.mToolBarAnimationRunning = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (COUISearchBar.this.mInputMethodAnimationEnabled) {
                        COUISearchBar.this.openSoftInput(true);
                    }
                }
            });
            ofFloat.start();
        }
    }

    public COUISearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4391l0);
    }

    public COUISearchBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUISearchBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mDrawingProxyDrawable = new COUISearchBarDrawingProxyDrawable();
        this.mBackgroundRect = new Rect();
        this.mDividerRect = new Rect();
        this.mBackgroundScaleFraction = 1.0f;
        this.mResponsiveWidthSize = 0;
        this.mAddToToolbarWay = 0;
        this.mGravityInToolBar = 48;
        this.mPressed = false;
        this.mUseResponsivePadding = true;
        this.mButtonOffsetAnimationDistance = 0;
        this.mStyle = 0;
        this.mClearTextDrawableResourceId = -1;
        this.mCollapsingHeightPercent = 1.0f;
        this.mShrinkFraction = 0.0f;
        this.mAttrs = null;
        this.mInputMethodAnimationEnabled = true;
        this.mShowImeAnimDuration = 0;
        this.mShowImeInterpolator = null;
        this.mState = new AtomicInteger(0);
        this.mSearchViewType = 0;
        init(context, attributeSet, i10, i11);
    }

    /* loaded from: classes.dex */
    public static class DefaultAnimatorListener implements Animator.AnimatorListener {
        private DefaultAnimatorListener() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // android.view.CollapsibleActionView
    public void onActionViewCollapsed() {
    }

    @Override // android.view.CollapsibleActionView
    public void onActionViewExpanded() {
    }
}
