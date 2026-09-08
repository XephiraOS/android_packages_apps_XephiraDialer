package com.coui.appcompat.searchview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.K;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.roundRect.COUIShapePath;
import com.coui.appcompat.searchview.ImeInsetsAnimationCallback;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import j.InterfaceC1146c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import u4.C1607c;

/* loaded from: classes.dex */
public class COUISearchViewAnimate extends LinearLayout implements InterfaceC1146c, ImeInsetsAnimationCallback.OnImeAnimationListener {
    private static final float CLAMP_ANIMATION_PERCENT = 0.3f;
    private static final boolean DEBUG = true;
    private static final long DEFAULT_BUTTON_ALPHA_CHANGE_DURATION = 350;
    private static final long DEFAULT_BUTTON_MOVE_DURATION = 450;
    private static final long DEFAULT_FADE_DURATION = 150;
    private static final long DEFAULT_PRESS_FEEDBACK_DURATION = 150;
    private static final long DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_DURATION = 450;
    private static final long DEFAULT_SEARCH_VIEW_SCALE_CHANGE_DURATION = 450;
    private static final float FLOAT_POINT_FIVE = 0.5f;
    private static final float FLOAT_TWO = 2.0f;
    private static final long NON_INSTANT_SEARCH_BUTTON_ALPHA_CHANGE_DURATION = 100;
    public static final int STATE_EDIT = 1;
    public static final int STATE_NORMAL = 0;
    private static final String TAG = "COUISearchViewAnimate";
    public static final int TYPE_INSTANT_SEARCH = 0;
    public static final int TYPE_NON_INSTANT_SEARCH = 1;
    private static final int WAY_AT_BEHIND = 1;
    private static final int WAY_AT_FRONT = 2;
    private static final int WAY_NONE = 0;
    private int mAddToToolbarWay;
    private volatile AnimatorHelper mAnimatorHelper;
    private OnStateChangeListener mAtToolbarFrontStateChangeListener;
    private int mBackgroundEndGap;
    private int mBackgroundStartGap;
    private ValueAnimator mButtonAlphaEnterAnimator;
    private ValueAnimator mButtonAlphaExitAnimator;
    private ImageView mButtonDivider;
    private final RectF mButtonHitRect;
    private final int[] mButtonLocation;
    private int mCancelButtonLargeStartMargin;
    private int mCancelButtonSmallStartMargin;
    private ImageView mCloseBtn;
    private int mCollapsedMinHeight;
    private float mCollapsingHeightPercent;
    private Context mContext;
    private int mCurrentBackgroundColor;
    private boolean mDivideBackground;
    private final ArgbEvaluator mEvaluator;
    private int mExtraY;
    private SearchFunctionalButton mFunctionalButton;
    private int mGravity;
    private int mGravityInToolBar;
    private boolean mHasAddedToToolbar;
    private int mHorizontalDividerColor;
    private int mInitSearchViewAnimateHeight;
    private int mInitSearchViewWrapperHeight;
    private boolean mInputMethodAnimationEnabled;
    private boolean mIsAtLeastR;
    private final int[] mLocation;
    private ImageView mMainIcon;
    private Rect mMainIconRect;
    private MenuItem mMenuItem;
    private boolean mNeedUpdateNormalRectPath;
    private boolean mNeedUpdatePressFeedbackRectPath;
    private int mNormalBackgroundColor;
    private final Path mNormalBackgroundPath;
    private RectF mNormalBackgroundRect;
    private final Paint mNormalPaint;
    private OnAnimationListener mOnAnimationListener;
    private List<OnCancelButtonClickListener> mOnCancelButtonClickListeners;
    private OnDispatchKeyEventPreImeListener mOnDispatchKeyEventPreImeListener;
    private List<OnStateChangeListener> mOnStateChangeListeners;
    private ObjectAnimator mPressFeedbackAnimator;
    private final Path mPressFeedbackBackgroundPath;
    private RectF mPressFeedbackBackgroundRect;
    private final Paint mPressFeedbackPaint;
    private boolean mPressed;
    private int mPressedBackgroundColor;
    private Rect mRect;
    private ImageView mSearchIcon;
    private boolean mSearchIconCanAnimate;
    private COUISearchView mSearchView;
    private ValueAnimator mSearchViewOffsetEnterAnimator;
    private ValueAnimator mSearchViewOffsetExitAnimator;
    private ValueAnimator mSearchViewScaleEnterAnimator;
    private ValueAnimator mSearchViewScaleExitAnimator;
    private int mSearchViewShrinkWidth;
    private AnimatorSet mSearchViewSmoothEnterAnimatorSet;
    private AnimatorSet mSearchViewSmoothExitAnimatorSet;
    private int mSearchViewType;
    private ConstraintLayout mSearchViewWrapper;
    private boolean mShouldClearFocus;
    private int mShowImeAnimDuration;
    private Interpolator mShowImeInterpolator;
    private int mStartY;
    public AtomicInteger mState;
    private int mStyle;
    private ImageView mSubIcon;
    private Rect mSubIconRect;
    private COUIToolbar mToolBar;
    private boolean mToolBarAnimationRunning;
    private int mTopOffset;
    private final Rect mWrapperBounds;
    private static final String[] TYPE_NAME = {"TYPE_INSTANT_SEARCH", "TYPE_NON_INSTANT_SEARCH"};
    private static final Interpolator DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final Interpolator DEFAULT_SEARCH_VIEW_SCALE_CHANGE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final Interpolator DEFAULT_BUTTON_ALPHA_CHANGE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final Interpolator DEFAULT_PRESS_FEEDBACK_INTERPOLATOR = new COUIEaseInterpolator();
    private static final ArgbEvaluator DEFAULT_PRESS_FEEDBACK_EVALUATOR = new ArgbEvaluator();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AddToolBarWay {
    }

    /* loaded from: classes.dex */
    public class AnimatorHelper {
        private int mIconTranslation;
        private volatile AtomicBoolean mAnimatingAtomic = new AtomicBoolean(false);
        private Runnable mToEditStartRunnable = new Runnable() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (COUISearchViewAnimate.this.mShouldClearFocus) {
                    COUISearchViewAnimate.this.setSearchAutoCompleteUnFocus();
                    COUISearchViewAnimate.this.openSoftInput(true);
                }
                COUISearchViewAnimate.this.mShouldClearFocus = true;
                if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                    COUISearchViewAnimate.this.mOnAnimationListener.onAnimationStart(1);
                }
                COUISearchViewAnimate.this.notifyOnStateChange(0, 1);
            }
        };
        private Runnable mToEditEndRunnable = new Runnable() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.2
            @Override // java.lang.Runnable
            public void run() {
                COUISearchViewAnimate.this.setSearchAutoCompleteFocus();
                AnimatorHelper.this.mAnimatingAtomic.set(false);
                if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                    COUISearchViewAnimate.this.mOnAnimationListener.onAnimationEnd(1);
                }
            }
        };
        private Runnable mToNormalStartRunnable = new Runnable() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.3
            @Override // java.lang.Runnable
            public void run() {
                COUISearchViewAnimate.this.setSearchAutoCompleteFocus();
                COUISearchViewAnimate.this.openSoftInput(false);
                if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                    COUISearchViewAnimate.this.mOnAnimationListener.onAnimationStart(0);
                }
                COUISearchViewAnimate.this.notifyOnStateChange(1, 0);
            }
        };
        private Runnable mToNormalEndRunnable = new Runnable() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.4
            @Override // java.lang.Runnable
            public void run() {
                COUISearchViewAnimate.this.setSearchAutoCompleteUnFocus();
                AnimatorHelper.this.mAnimatingAtomic.set(false);
                COUISearchViewAnimate.this.mSearchView.setQuery("", false);
                if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                    COUISearchViewAnimate.this.mOnAnimationListener.onAnimationEnd(0);
                }
            }
        };

        public AnimatorHelper() {
        }

        private void startCancelButtonEnterValueAnimator() {
            COUISearchViewAnimate.this.mFunctionalButton.setAlpha(0.0f);
            COUISearchViewAnimate.this.mFunctionalButton.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(450L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.11
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (COUISearchViewAnimate.this.mSearchViewType == 0) {
                        COUISearchViewAnimate.this.mFunctionalButton.setAlpha(floatValue);
                        COUISearchViewAnimate.this.mSearchViewShrinkWidth = (int) (floatValue * (r1.getOriginWidth() - COUISearchViewAnimate.this.getShrinkWidth()));
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) COUISearchViewAnimate.this.mSearchView.getLayoutParams();
                        marginLayoutParams.setMarginEnd(COUISearchViewAnimate.this.mSearchViewShrinkWidth);
                        COUISearchViewAnimate.this.mSearchView.setLayoutParams(marginLayoutParams);
                    } else if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                        COUISearchViewAnimate.this.mButtonDivider.setAlpha(floatValue);
                        COUISearchViewAnimate.this.mFunctionalButton.setAlpha(floatValue);
                    }
                    if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                        COUISearchViewAnimate.this.mOnAnimationListener.onUpdate(1, valueAnimator);
                    }
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.12
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    AnimatorHelper.this.mToEditEndRunnable.run();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    AnimatorHelper.this.mToEditStartRunnable.run();
                }
            });
            ofFloat.start();
        }

        private void startCancelButtonExitValueAnimator() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(450L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (COUISearchViewAnimate.this.mSearchViewType == 0) {
                        float f10 = 1.0f - floatValue;
                        COUISearchViewAnimate.this.mFunctionalButton.setAlpha(f10);
                        COUISearchViewAnimate.this.mSearchViewShrinkWidth = (int) (f10 * (r0.getOriginWidth() - COUISearchViewAnimate.this.getShrinkWidth()));
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) COUISearchViewAnimate.this.mSearchView.getLayoutParams();
                        marginLayoutParams.setMarginEnd(COUISearchViewAnimate.this.mSearchViewShrinkWidth);
                        COUISearchViewAnimate.this.mSearchView.setLayoutParams(marginLayoutParams);
                    } else if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                        float f11 = 1.0f - floatValue;
                        COUISearchViewAnimate.this.mButtonDivider.setAlpha(f11);
                        COUISearchViewAnimate.this.mFunctionalButton.setAlpha(f11);
                    }
                    if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                        COUISearchViewAnimate.this.mOnAnimationListener.onUpdate(0, valueAnimator);
                    }
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                        COUISearchViewAnimate.this.mButtonDivider.setVisibility(8);
                        COUISearchViewAnimate.this.mFunctionalButton.setVisibility(8);
                    } else if (COUISearchViewAnimate.this.mSearchViewType == 0) {
                        COUISearchViewAnimate.this.mFunctionalButton.setVisibility(4);
                    }
                    AnimatorHelper.this.mToNormalEndRunnable.run();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    AnimatorHelper.this.mToNormalStartRunnable.run();
                }
            });
            ofFloat.start();
        }

        private void startSearchIconFadeInAnimator() {
            if (COUISearchViewAnimate.this.mSearchIcon != null) {
                COUISearchViewAnimate.this.mSearchIcon.setPivotX(0.0f);
                COUISearchViewAnimate.this.mSearchIcon.setRotationY(0.0f);
                COUISearchViewAnimate.this.mSearchIcon.setVisibility(0);
                COUISearchViewAnimate.this.mSearchIcon.animate().setDuration(150L).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        COUISearchViewAnimate.this.mSearchIcon.setVisibility(0);
                    }
                }).start();
            }
        }

        private void startSearchIconFadeOutAnimator() {
            if (COUISearchViewAnimate.this.mSearchIcon != null) {
                COUISearchViewAnimate.this.mSearchIcon.setPivotX(0.0f);
                COUISearchViewAnimate.this.mSearchIcon.setRotationY(0.0f);
                COUISearchViewAnimate.this.mSearchIcon.animate().setDuration(150L).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.5
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        COUISearchViewAnimate.this.mSearchIcon.setVisibility(4);
                    }
                }).start();
            }
        }

        public void runStateChangeAnimation(int i10) {
            if (COUISearchViewAnimate.this.mState.get() == i10) {
                Log.d(COUISearchViewAnimate.TAG, "runStateChangeAnimation: same state , return. targetState = " + i10);
                return;
            }
            if (i10 == 1) {
                startToEditAnimator();
            } else if (i10 == 0) {
                startToNormalAnimator();
            }
        }

        public void startCancelButtonEnterAnimator() {
            if (COUISearchViewAnimate.this.mFunctionalButton != null) {
                COUISearchViewAnimate.this.mFunctionalButton.setAlpha(0.0f);
                if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    COUISearchViewAnimate.this.mButtonDivider.setAlpha(0.0f);
                    COUISearchViewAnimate.this.mButtonDivider.setVisibility(0);
                }
                COUISearchViewAnimate.this.mFunctionalButton.setVisibility(0);
                startCancelButtonEnterValueAnimator();
            }
        }

        public void startCancelButtonExitAnimator() {
            if (COUISearchViewAnimate.this.mFunctionalButton != null) {
                COUISearchViewAnimate.this.mFunctionalButton.setAlpha(1.0f);
                if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    COUISearchViewAnimate.this.mButtonDivider.setAlpha(1.0f);
                }
                if (!COUISearchViewAnimate.this.mFunctionalButton.isPerformClicked()) {
                    COUISearchViewAnimate.this.mFunctionalButton.setVisibility(0);
                    if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                        COUISearchViewAnimate.this.mButtonDivider.setVisibility(0);
                    }
                } else {
                    COUISearchViewAnimate.this.mFunctionalButton.setPerformClicked(false);
                }
                startCancelButtonExitValueAnimator();
            }
        }

        public void startSearchIconEnterAnimator() {
            if (COUISearchViewAnimate.this.mSearchIcon != null) {
                if (this.mIconTranslation == 0) {
                    if (!COUISearchViewAnimate.this.isRtl()) {
                        this.mIconTranslation = -COUISearchViewAnimate.this.mSearchIcon.getLeft();
                    } else {
                        this.mIconTranslation = (COUISearchViewAnimate.this.getWidth() - COUISearchViewAnimate.this.mSearchIcon.getRight()) + COUISearchViewAnimate.this.mSearchIcon.getWidth();
                    }
                }
                COUISearchViewAnimate.this.mSearchIcon.setVisibility(0);
                COUISearchViewAnimate.this.mSearchIcon.setPivotX(this.mIconTranslation);
                COUISearchViewAnimate.this.mSearchIcon.setRotationY(80.0f);
                COUISearchViewAnimate.this.mSearchIcon.animate().setDuration(150L).rotationY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.8
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        COUISearchViewAnimate.this.mSearchIcon.setRotationY(0.0f);
                    }
                }).start();
            }
        }

        public void startSearchIconExitAnimator() {
            if (COUISearchViewAnimate.this.mSearchIcon != null) {
                if (this.mIconTranslation == 0) {
                    if (!COUISearchViewAnimate.this.isRtl()) {
                        this.mIconTranslation = -COUISearchViewAnimate.this.mSearchIcon.getLeft();
                    } else {
                        this.mIconTranslation = (COUISearchViewAnimate.this.getWidth() - COUISearchViewAnimate.this.mSearchIcon.getRight()) + COUISearchViewAnimate.this.mSearchIcon.getWidth();
                    }
                }
                COUISearchViewAnimate.this.mSearchIcon.setPivotX(this.mIconTranslation);
                COUISearchViewAnimate.this.mSearchIcon.animate().setDuration(150L).rotationY(80.0f).setListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.AnimatorHelper.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        COUISearchViewAnimate.this.mSearchIcon.setVisibility(8);
                    }
                }).start();
            }
        }

        public void startToEditAnimator() {
            synchronized (this) {
                try {
                    if (!this.mAnimatingAtomic.compareAndSet(false, true)) {
                        return;
                    }
                    if (COUISearchViewAnimate.this.mIsAtLeastR && COUISearchViewAnimate.this.mShowImeAnimDuration != 0 && !COUISearchViewAnimate.this.isInMultiWindowMode()) {
                        COUISearchViewAnimate.this.setSearchAutoCompleteUnFocus();
                        COUISearchViewAnimate.this.openSoftInput(true);
                    } else {
                        COUISearchViewAnimate.this.mState.set(1);
                        COUISearchViewAnimate.this.mSearchViewSmoothEnterAnimatorSet.start();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void startToNormalAnimator() {
            synchronized (this) {
                try {
                    if (!this.mAnimatingAtomic.compareAndSet(false, true)) {
                        return;
                    }
                    COUISearchViewAnimate.this.mSearchViewSmoothExitAnimatorSet.start();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class COUISavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<COUISavedState> CREATOR = new Parcelable.Creator<COUISavedState>() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.COUISavedState.1
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

        void onUpdate(int i10, ValueAnimator valueAnimator);
    }

    /* loaded from: classes.dex */
    public interface OnCancelButtonClickListener {
        boolean onClickCancel();
    }

    /* loaded from: classes.dex */
    public interface OnDispatchKeyEventPreImeListener {
        void onDispatchKeyEventPreIme(KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public interface OnStateChangeListener {
        void onStateChange(int i10, int i11);
    }

    /* loaded from: classes.dex */
    public static class SearchFunctionalButton extends AppCompatButton {
        private static final int DEFAULT_MAX_LINES = 1;
        volatile boolean mIsPerformClicked;
        PerformClickCallback mPerformClickCallback;

        /* loaded from: classes.dex */
        public interface PerformClickCallback {
            void performClick();
        }

        public SearchFunctionalButton(Context context) {
            this(context, null);
        }

        public boolean isPerformClicked() {
            return this.mIsPerformClicked;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (this.mPerformClickCallback != null) {
                this.mIsPerformClicked = true;
                this.mPerformClickCallback.performClick();
            }
            return super.performClick();
        }

        public void setPerformClickCallback(PerformClickCallback performClickCallback) {
            this.mPerformClickCallback = performClickCallback;
        }

        public void setPerformClicked(boolean z10) {
            this.mIsPerformClicked = z10;
        }

        public SearchFunctionalButton(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public SearchFunctionalButton(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.mPerformClickCallback = null;
            this.mIsPerformClicked = false;
            setMaxLines(1);
            setMaxWidth(context.getResources().getDimensionPixelOffset(X8.f.f4626X3));
            setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SearchViewState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SearchViewType {
    }

    public COUISearchViewAnimate(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeStateWithOutAnimation(int i10) {
        if (this.mState.get() == i10) {
            Log.d(TAG, "changeStateWithOutAnimation: same state , return. targetState = " + i10);
            return;
        }
        this.mState.set(i10);
        Log.d(TAG, "changeStateWithOutAnimation: " + i10);
        if (i10 == 1) {
            this.mSearchView.setAlpha(1.0f);
            this.mFunctionalButton.setAlpha(1.0f);
            this.mSearchView.setVisibility(0);
            this.mFunctionalButton.setVisibility(0);
            this.mSearchIcon.setVisibility(0);
            int i11 = this.mSearchViewType;
            if (i11 == 1) {
                this.mButtonDivider.setAlpha(1.0f);
            } else if (i11 == 0) {
                int originWidth = getOriginWidth() - getShrinkWidth();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSearchView.getLayoutParams();
                marginLayoutParams.setMarginEnd(originWidth);
                this.mSearchView.setLayoutParams(marginLayoutParams);
            }
            getAnimatorHelper().mToEditStartRunnable.run();
            getAnimatorHelper().mToEditEndRunnable.run();
        } else {
            this.mSearchIcon.setAlpha(1.0f);
            this.mSearchIcon.setRotationY(0.0f);
            this.mSearchView.setQuery("", false);
            int i12 = this.mSearchViewType;
            if (i12 == 1) {
                this.mButtonDivider.setAlpha(0.0f);
                this.mFunctionalButton.setVisibility(8);
            } else if (i12 == 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mSearchView.getLayoutParams();
                marginLayoutParams2.setMarginEnd(0);
                this.mSearchView.setLayoutParams(marginLayoutParams2);
                this.mFunctionalButton.setVisibility(4);
            }
            this.mSearchIcon.setVisibility(0);
            getAnimatorHelper().mToNormalStartRunnable.run();
            getAnimatorHelper().mToNormalEndRunnable.run();
        }
        requestLayout();
    }

    private float clampMarginValue(float f10) {
        return Math.max(0.0f, Math.min(1.0f, f10 / 0.3f));
    }

    private float clampProgress(float f10, float f11, float f12) {
        return Float.max(0.0f, Float.min((f12 / (f11 - f10)) + (f10 / (f10 - f11)), 1.0f));
    }

    private float clampSearchViewHeight(float f10) {
        return (f10 / 0.7f) - 0.42857146f;
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

    private List ensureList(List list) {
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorHelper getAnimatorHelper() {
        if (this.mAnimatorHelper == null) {
            synchronized (this) {
                try {
                    if (this.mAnimatorHelper == null) {
                        this.mAnimatorHelper = new AnimatorHelper();
                    }
                } finally {
                }
            }
        }
        return this.mAnimatorHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getOriginWidth() {
        return (((getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) - this.mBackgroundStartGap) - this.mBackgroundEndGap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getShrinkWidth() {
        int i10 = this.mSearchViewType;
        if (i10 == 0) {
            return ((getOriginWidth() - this.mCancelButtonLargeStartMargin) - this.mFunctionalButton.getMeasuredWidth()) + this.mFunctionalButton.getPaddingEnd();
        }
        if (i10 == 1) {
            return (((getOriginWidth() - this.mCancelButtonSmallStartMargin) - this.mBackgroundEndGap) - this.mFunctionalButton.getMeasuredWidth()) - this.mButtonDivider.getMeasuredWidth();
        }
        return getOriginWidth();
    }

    private void inflateView(Context context, AttributeSet attributeSet) {
        View.inflate(context, X8.j.f4982m, this);
        this.mSearchIcon = (ImageView) findViewById(X8.h.f4918e);
        this.mSearchView = (COUISearchView) findViewById(X8.h.f4920f);
        this.mFunctionalButton = (SearchFunctionalButton) findViewById(X8.h.f4916d);
        this.mButtonDivider = (ImageView) findViewById(X8.h.f4932l);
        this.mSearchViewWrapper = (ConstraintLayout) findViewById(X8.h.f4876B);
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
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mButtonAlphaEnterAnimator = ofFloat;
        long j11 = 100;
        if (this.mSearchViewType == 0) {
            j10 = DEFAULT_BUTTON_ALPHA_CHANGE_DURATION;
        } else {
            j10 = 100;
        }
        ofFloat.setDuration(j10);
        this.mButtonAlphaEnterAnimator.setInterpolator(DEFAULT_BUTTON_ALPHA_CHANGE_INTERPOLATOR);
        ValueAnimator valueAnimator = this.mButtonAlphaEnterAnimator;
        if (this.mSearchViewType != 0) {
            j11 = 0;
        }
        valueAnimator.setStartDelay(j11);
        this.mButtonAlphaEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (COUISearchViewAnimate.this.mSearchViewType == 0) {
                    COUISearchViewAnimate.this.mFunctionalButton.setAlpha(floatValue);
                } else if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    COUISearchViewAnimate.this.mButtonDivider.setAlpha(floatValue);
                    COUISearchViewAnimate.this.mFunctionalButton.setAlpha(floatValue);
                }
            }
        });
        this.mButtonAlphaEnterAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.14
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    COUISearchViewAnimate.this.mDivideBackground = true;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    COUISearchViewAnimate.this.mButtonDivider.setVisibility(0);
                }
                COUISearchViewAnimate.this.mFunctionalButton.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void initButtonExitAnimator() {
        long j10;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mButtonAlphaExitAnimator = ofFloat;
        if (this.mSearchViewType == 0) {
            j10 = DEFAULT_BUTTON_ALPHA_CHANGE_DURATION;
        } else {
            j10 = 100;
        }
        ofFloat.setDuration(j10);
        this.mButtonAlphaExitAnimator.setInterpolator(DEFAULT_BUTTON_ALPHA_CHANGE_INTERPOLATOR);
        this.mButtonAlphaExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.18
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUISearchViewAnimate.this.mSearchViewType == 0) {
                    COUISearchViewAnimate.this.mFunctionalButton.setAlpha(1.0f - floatValue);
                } else if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    float f10 = 1.0f - floatValue;
                    COUISearchViewAnimate.this.mButtonDivider.setAlpha(f10);
                    COUISearchViewAnimate.this.mFunctionalButton.setAlpha(f10);
                }
            }
        });
    }

    private void initSearchViewEnterAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mSearchViewOffsetEnterAnimator = ofFloat;
        ofFloat.setDuration(450L);
        this.mSearchViewOffsetEnterAnimator.setInterpolator(DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR);
        this.mSearchViewOffsetEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISearchViewAnimate.this.lambda$initSearchViewEnterAnimator$0(valueAnimator);
            }
        });
        this.mSearchViewOffsetEnterAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISearchViewAnimate.this.mTopOffset = 0;
                COUISearchViewAnimate cOUISearchViewAnimate = COUISearchViewAnimate.this;
                cOUISearchViewAnimate.mStartY = cOUISearchViewAnimate.getTop();
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
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mSearchViewScaleEnterAnimator = ofFloat2;
        ofFloat2.setDuration(450L);
        this.mSearchViewScaleEnterAnimator.setInterpolator(DEFAULT_SEARCH_VIEW_SCALE_CHANGE_INTERPOLATOR);
        this.mSearchViewScaleEnterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISearchViewAnimate.this.lambda$initSearchViewEnterAnimator$1(valueAnimator);
            }
        });
        this.mSearchViewScaleEnterAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUISearchViewAnimate.this.updateBackgroundRect();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUISearchViewAnimate.this.updateBackgroundRect();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void initSearchViewExitAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mSearchViewOffsetExitAnimator = ofFloat;
        ofFloat.setDuration(450L);
        ValueAnimator valueAnimator = this.mSearchViewOffsetExitAnimator;
        Interpolator interpolator = DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR;
        valueAnimator.setInterpolator(interpolator);
        this.mSearchViewOffsetExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.16
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (COUISearchViewAnimate.this.mSearchViewType == 0) {
                    int i10 = (int) (floatValue * (COUISearchViewAnimate.this.mStartY - COUISearchViewAnimate.this.mExtraY));
                    ((ViewGroup.MarginLayoutParams) COUISearchViewAnimate.this.getLayoutParams()).topMargin += i10 - COUISearchViewAnimate.this.mTopOffset;
                    COUISearchViewAnimate.this.requestLayout();
                    COUISearchViewAnimate.this.mTopOffset = i10;
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mSearchViewScaleExitAnimator = ofFloat2;
        ofFloat2.setDuration(450L);
        this.mSearchViewScaleExitAnimator.setInterpolator(interpolator);
        this.mSearchViewScaleExitAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (COUISearchViewAnimate.this.mSearchViewType == 0) {
                    COUISearchViewAnimate.this.mSearchViewShrinkWidth = (int) ((1.0f - floatValue) * (r0.getOriginWidth() - COUISearchViewAnimate.this.getShrinkWidth()));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) COUISearchViewAnimate.this.mSearchView.getLayoutParams();
                    marginLayoutParams.setMarginEnd(COUISearchViewAnimate.this.mSearchViewShrinkWidth);
                    COUISearchViewAnimate.this.mSearchView.setLayoutParams(marginLayoutParams);
                }
            }
        });
    }

    private void initSmoothEnterAnimatorSet() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.mSearchViewSmoothEnterAnimatorSet = animatorSet;
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.15
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUISearchViewAnimate.this.updateBackgroundRect();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUISearchViewAnimate.this.mTopOffset = 0;
                if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    COUISearchViewAnimate.this.mDivideBackground = true;
                }
                COUISearchViewAnimate.this.updateBackgroundRect();
                COUISearchViewAnimate.this.setSearchAutoCompleteFocus();
                COUISearchViewAnimate.this.getAnimatorHelper().mAnimatingAtomic.set(false);
                if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                    COUISearchViewAnimate.this.mOnAnimationListener.onAnimationEnd(1);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISearchViewAnimate.this.mTopOffset = 0;
                if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    COUISearchViewAnimate.this.mButtonDivider.setVisibility(0);
                }
                COUISearchViewAnimate.this.mFunctionalButton.setVisibility(0);
                COUISearchViewAnimate.this.mState.set(1);
                if (!COUISearchViewAnimate.this.mIsAtLeastR || COUISearchViewAnimate.this.mShowImeAnimDuration == 0 || COUISearchViewAnimate.this.isInMultiWindowMode()) {
                    COUISearchViewAnimate.this.setSearchAutoCompleteUnFocus();
                    COUISearchViewAnimate.this.openSoftInput(true);
                }
                COUISearchViewAnimate.this.notifyOnStateChange(0, 1);
                COUISearchViewAnimate cOUISearchViewAnimate = COUISearchViewAnimate.this;
                cOUISearchViewAnimate.mStartY = cOUISearchViewAnimate.getTop();
                if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                    COUISearchViewAnimate.this.mOnAnimationListener.onAnimationStart(1);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mSearchViewSmoothEnterAnimatorSet.playTogether(this.mSearchViewOffsetEnterAnimator, this.mSearchViewScaleEnterAnimator, this.mButtonAlphaEnterAnimator);
    }

    private void initSmoothExitAnimatorSet() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.mSearchViewSmoothExitAnimatorSet = animatorSet;
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.19
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUISearchViewAnimate.this.updateBackgroundRect();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUISearchViewAnimate.this.mTopOffset = 0;
                if (COUISearchViewAnimate.this.mSearchViewType == 1) {
                    COUISearchViewAnimate.this.mDivideBackground = false;
                    COUISearchViewAnimate.this.mButtonDivider.setVisibility(8);
                    COUISearchViewAnimate.this.mFunctionalButton.setVisibility(8);
                } else if (COUISearchViewAnimate.this.mSearchViewType == 0) {
                    COUISearchViewAnimate.this.mFunctionalButton.setVisibility(4);
                }
                COUISearchViewAnimate.this.updateBackgroundRect();
                COUISearchViewAnimate.this.setSearchAutoCompleteUnFocus();
                COUISearchViewAnimate.this.getAnimatorHelper().mAnimatingAtomic.set(false);
                COUISearchViewAnimate.this.mSearchView.setQuery("", false);
                if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                    COUISearchViewAnimate.this.mOnAnimationListener.onAnimationEnd(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISearchViewAnimate.this.mTopOffset = 0;
                COUISearchViewAnimate.this.mSearchView.getSearchAutoComplete().setText((CharSequence) null);
                COUISearchViewAnimate.this.mSearchView.getSearchAutoComplete().clearFocus();
                COUISearchViewAnimate.this.openSoftInput(false);
                COUISearchViewAnimate.this.mState.set(0);
                COUISearchViewAnimate.this.notifyOnStateChange(1, 0);
                if (COUISearchViewAnimate.this.mOnAnimationListener != null) {
                    COUISearchViewAnimate.this.mOnAnimationListener.onAnimationStart(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mSearchViewSmoothExitAnimatorSet.playTogether(this.mSearchViewOffsetExitAnimator, this.mSearchViewScaleExitAnimator, this.mButtonAlphaExitAnimator);
    }

    private boolean isInButton(float f10, float f11) {
        return this.mButtonHitRect.contains(f10, f11);
    }

    private boolean isInIcon(float f10, float f11) {
        getGlobalVisibleRect(this.mRect);
        this.mMainIcon.getGlobalVisibleRect(this.mMainIconRect);
        this.mSubIcon.getGlobalVisibleRect(this.mSubIconRect);
        this.mMainIconRect.offset(0, -this.mRect.top);
        this.mSubIconRect.offset(0, -this.mRect.top);
        int i10 = (int) f10;
        int i11 = (int) f11;
        if (!this.mMainIconRect.contains(i10, i11) && !this.mSubIconRect.contains(i10, i11)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInMultiWindowMode() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            return ((Activity) context).isInMultiWindowMode();
        }
        return false;
    }

    private boolean isInView(float f10, float f11) {
        float f12 = (int) f10;
        float f13 = (int) f11;
        if (!this.mPressFeedbackBackgroundRect.contains(f12, f13) && !this.mNormalBackgroundRect.contains(f12, f13)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchViewEnterAnimator$0(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.mSearchViewType == 0) {
            int i10 = (int) (floatValue * (this.mStartY - this.mExtraY));
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin -= i10 - this.mTopOffset;
            requestLayout();
            this.mTopOffset = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSearchViewEnterAnimator$1(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.mSearchViewType == 0) {
            this.mSearchViewShrinkWidth = (int) (floatValue * (getOriginWidth() - getShrinkWidth()));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSearchView.getLayoutParams();
            marginLayoutParams.setMarginEnd(this.mSearchViewShrinkWidth);
            this.mSearchView.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setImeInsetsAnimationCallback$2(ImeInsetsAnimationCallback imeInsetsAnimationCallback) {
        K.G0(this.mSearchView.getRootView(), imeInsetsAnimationCallback);
    }

    private void loadAttr(Context context, AttributeSet attributeSet, int i10, int i11) {
        Drawable drawable;
        if (attributeSet != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            this.mStyle = styleAttribute;
            if (styleAttribute == 0) {
                this.mStyle = i10;
            }
        } else {
            this.mStyle = i10;
        }
        this.mBackgroundEndGap = context.getResources().getDimensionPixelOffset(X8.f.f4648a4);
        this.mBackgroundStartGap = context.getResources().getDimensionPixelOffset(X8.f.f4656b4);
        this.mCancelButtonSmallStartMargin = context.getResources().getDimensionPixelOffset(X8.f.f4672d4);
        this.mCancelButtonLargeStartMargin = context.getResources().getDimensionPixelOffset(X8.f.f4664c4);
        this.mCollapsedMinHeight = context.getResources().getDimensionPixelSize(X8.f.f4680e4);
        this.mInitSearchViewWrapperHeight = context.getResources().getDimensionPixelOffset(X8.f.f4704h4);
        this.mInitSearchViewAnimateHeight = context.getResources().getDimensionPixelOffset(X8.f.f4633Y3);
        if (this.mPressFeedbackBackgroundRect == null) {
            this.mPressFeedbackBackgroundRect = new RectF();
        }
        if (this.mNormalBackgroundRect == null) {
            this.mNormalBackgroundRect = new RectF();
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
        if (this.mMainIconRect == null) {
            this.mMainIconRect = new Rect();
        }
        if (this.mSubIconRect == null) {
            this.mSubIconRect = new Rect();
        }
        this.mNormalBackgroundColor = context.getResources().getColor(X8.e.f4425B);
        this.mPressedBackgroundColor = context.getResources().getColor(X8.e.f4426C);
        this.mCurrentBackgroundColor = this.mNormalBackgroundColor;
        this.mHorizontalDividerColor = context.getResources().getColor(X8.e.f4442h);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X8.o.f5164N4, i10, i11);
        float f10 = context.getResources().getConfiguration().fontScale;
        this.mSearchView.getSearchAutoComplete().setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(X8.o.f5252Y4, getResources().getDimensionPixelSize(X8.f.f4696g4)));
        SearchView.SearchAutoComplete searchAutoComplete = this.mSearchView.getSearchAutoComplete();
        searchAutoComplete.setPaddingRelative(0, 0, getResources().getDimensionPixelSize(X8.f.f4640Z3), 0);
        searchAutoComplete.setTextColor(obtainStyledAttributes.getColor(X8.o.f5244X4, 0));
        this.mSearchIcon.setImageDrawable(C1607c.e(context, obtainStyledAttributes, X8.o.f5196R4));
        this.mSearchView.getSearchAutoComplete().setHintTextColor(obtainStyledAttributes.getColorStateList(X8.o.f5267a5));
        this.mSearchViewType = obtainStyledAttributes.getInt(X8.o.f5204S4, 0);
        int i12 = X8.o.f5283c5;
        if (obtainStyledAttributes.hasValue(i12)) {
            setQueryHint(obtainStyledAttributes.getString(i12));
        }
        int i13 = X8.o.f5236W4;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.mFunctionalButton.setTextColor(obtainStyledAttributes.getColor(i13, 0));
        }
        int i14 = X8.o.f5228V4;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.mFunctionalButton.setText(obtainStyledAttributes.getString(i14));
        } else {
            this.mFunctionalButton.setText(X8.m.f5011j);
        }
        this.mFunctionalButton.setTextSize(0, COUIChangeTextUtil.getSuitableFontSize(this.mFunctionalButton.getTextSize(), f10, 2));
        COUITextViewCompatUtil.setPressRippleDrawable(this.mFunctionalButton);
        int i15 = X8.o.f5180P4;
        if (obtainStyledAttributes.hasValue(i15) && (drawable = obtainStyledAttributes.getDrawable(i15)) != null) {
            this.mButtonDivider.setImageDrawable(drawable);
        }
        this.mSearchView.setBackgroundColor(obtainStyledAttributes.getColor(X8.o.f5275b5, 0));
        this.mMainIcon = (ImageView) this.mSearchView.findViewById(X8.h.f4945r0);
        this.mSubIcon = (ImageView) this.mSearchView.findViewById(X8.h.f4949t0);
        this.mMainIcon.setImageDrawable(C1607c.e(context, obtainStyledAttributes, X8.o.f5212T4));
        this.mSubIcon.setImageDrawable(C1607c.e(context, obtainStyledAttributes, X8.o.f5220U4));
        this.mCloseBtn = (ImageView) this.mSearchView.findViewById(X8.h.f4943q0);
        int resourceId = obtainStyledAttributes.getResourceId(X8.o.f5188Q4, 0);
        ImageView imageView = this.mCloseBtn;
        if (imageView != null) {
            imageView.setImageResource(resourceId);
        }
        int i16 = obtainStyledAttributes.getInt(X8.o.f5172O4, 16);
        Log.i(TAG, "gravity " + i16);
        setGravity(i16);
        obtainStyledAttributes.recycle();
    }

    private boolean notifyCancelButton() {
        List<OnCancelButtonClickListener> list = this.mOnCancelButtonClickListeners;
        boolean z10 = false;
        if (list != null) {
            for (OnCancelButtonClickListener onCancelButtonClickListener : list) {
                if (onCancelButtonClickListener != null) {
                    z10 |= onCancelButtonClickListener.onClickCancel();
                }
            }
        }
        return z10;
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

    private void onClickStateEdit() {
        getAnimatorHelper().runStateChangeAnimation(0);
    }

    private void onClickStateNormal() {
        getAnimatorHelper().runStateChangeAnimation(1);
    }

    private void playPressAnimation() {
        ObjectAnimator objectAnimator = this.mPressFeedbackAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mPressFeedbackAnimator.cancel();
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "currentBackgroundColor", this.mCurrentBackgroundColor, this.mPressedBackgroundColor);
        this.mPressFeedbackAnimator = ofInt;
        ofInt.setDuration(150L);
        this.mPressFeedbackAnimator.setInterpolator(DEFAULT_PRESS_FEEDBACK_INTERPOLATOR);
        this.mPressFeedbackAnimator.setEvaluator(DEFAULT_PRESS_FEEDBACK_EVALUATOR);
        this.mPressFeedbackAnimator.start();
    }

    private void playReleaseAnimation() {
        ObjectAnimator objectAnimator = this.mPressFeedbackAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mPressFeedbackAnimator.cancel();
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "currentBackgroundColor", this.mCurrentBackgroundColor, this.mNormalBackgroundColor);
        this.mPressFeedbackAnimator = ofInt;
        ofInt.setDuration(150L);
        this.mPressFeedbackAnimator.setInterpolator(DEFAULT_PRESS_FEEDBACK_INTERPOLATOR);
        this.mPressFeedbackAnimator.setEvaluator(DEFAULT_PRESS_FEEDBACK_EVALUATOR);
        this.mPressFeedbackAnimator.start();
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

    private void setCurrentBackgroundColor(int i10) {
        this.mCurrentBackgroundColor = i10;
        invalidate();
    }

    private void setMenuItem(MenuItem menuItem) {
        this.mMenuItem = menuItem;
        if (menuItem != null && menuItem.getActionView() == this) {
            this.mMenuItem.setActionView((View) null);
        }
    }

    private void setRelativeVerticalGravity(View view, int i10) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            Arrays.fill(layoutParams2.getRules(), 0);
            layoutParams2.alignWithParent = true;
            int i11 = i10 & 112;
            int i12 = 15;
            if (i11 != 16) {
                if (i11 != 48) {
                    if (i11 == 80) {
                        i12 = 12;
                    }
                } else {
                    i12 = 10;
                }
            }
            layoutParams2.addRule(i12);
            view.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchAutoCompleteFocus() {
        SearchView.SearchAutoComplete searchAutoComplete;
        COUISearchView cOUISearchView = this.mSearchView;
        if (cOUISearchView != null && (searchAutoComplete = cOUISearchView.getSearchAutoComplete()) != null) {
            searchAutoComplete.setFocusable(true);
            searchAutoComplete.setFocusableInTouchMode(true);
            searchAutoComplete.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchAutoCompleteUnFocus() {
        COUISearchView cOUISearchView = this.mSearchView;
        if (cOUISearchView != null) {
            cOUISearchView.clearFocus();
            this.mSearchView.setFocusable(false);
            this.mSearchView.onWindowFocusChanged(false);
            SearchView.SearchAutoComplete searchAutoComplete = this.mSearchView.getSearchAutoComplete();
            if (searchAutoComplete != null) {
                searchAutoComplete.setFocusable(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolBarAlpha(float f10) {
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

    private void showSoftInput() {
        CustomWindowInsetsAnimationControlListener customWindowInsetsAnimationControlListener = new CustomWindowInsetsAnimationControlListener(true, this.mShowImeAnimDuration, this.mShowImeInterpolator);
        COUISearchView cOUISearchView = this.mSearchView;
        if (cOUISearchView != null && cOUISearchView.getWindowInsetsController() != null) {
            this.mSearchView.getWindowInsetsController().controlWindowInsetsAnimation(WindowInsets.Type.ime(), this.mShowImeAnimDuration, this.mShowImeInterpolator, null, customWindowInsetsAnimationControlListener);
        }
    }

    private static String state2String(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                return String.valueOf(i10);
            }
            return "state edit";
        }
        return "state normal";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBackgroundRect() {
        if (this.mDivideBackground) {
            if (isRtl()) {
                this.mPressFeedbackBackgroundRect.right = this.mSearchViewWrapper.getRight();
                this.mPressFeedbackBackgroundRect.left = this.mButtonDivider.getRight() + this.mSearchViewWrapper.getLeft();
            } else {
                this.mPressFeedbackBackgroundRect.left = this.mSearchViewWrapper.getLeft();
                this.mPressFeedbackBackgroundRect.right = this.mButtonDivider.getLeft() + this.mPressFeedbackBackgroundRect.left;
            }
            this.mPressFeedbackBackgroundRect.top = this.mSearchViewWrapper.getTop();
            this.mPressFeedbackBackgroundRect.bottom = this.mSearchViewWrapper.getBottom();
            this.mNeedUpdatePressFeedbackRectPath = true;
            if (isRtl()) {
                RectF rectF = this.mNormalBackgroundRect;
                rectF.right = this.mPressFeedbackBackgroundRect.left;
                rectF.left = this.mSearchViewWrapper.getLeft();
            } else {
                RectF rectF2 = this.mNormalBackgroundRect;
                rectF2.left = this.mPressFeedbackBackgroundRect.right;
                rectF2.right = this.mSearchViewWrapper.getRight();
            }
            RectF rectF3 = this.mNormalBackgroundRect;
            RectF rectF4 = this.mPressFeedbackBackgroundRect;
            rectF3.top = rectF4.top;
            rectF3.bottom = rectF4.bottom;
            this.mNeedUpdateNormalRectPath = true;
            return;
        }
        if (isRtl()) {
            this.mPressFeedbackBackgroundRect.right = this.mSearchViewWrapper.getRight();
            int i10 = this.mSearchViewType;
            if (i10 == 0) {
                this.mPressFeedbackBackgroundRect.left = this.mSearchView.getLeft() + getPaddingEnd();
            } else if (i10 == 1) {
                this.mPressFeedbackBackgroundRect.left = this.mSearchViewWrapper.getLeft();
            }
        } else {
            this.mPressFeedbackBackgroundRect.left = this.mSearchViewWrapper.getLeft();
            int i11 = this.mSearchViewType;
            if (i11 == 0) {
                this.mPressFeedbackBackgroundRect.right = this.mSearchView.getRight() + getPaddingStart();
            } else if (i11 == 1) {
                this.mPressFeedbackBackgroundRect.right = this.mSearchViewWrapper.getRight();
            }
        }
        this.mPressFeedbackBackgroundRect.top = this.mSearchViewWrapper.getTop();
        this.mPressFeedbackBackgroundRect.bottom = this.mSearchViewWrapper.getBottom();
        this.mNeedUpdatePressFeedbackRectPath = true;
    }

    private void updateBounds() {
        this.mFunctionalButton.getLocationOnScreen(this.mButtonLocation);
        getLocationOnScreen(this.mLocation);
        this.mButtonHitRect.set(this.mButtonLocation[0], r1[1] - this.mLocation[1], r2 + this.mFunctionalButton.getWidth(), (this.mButtonLocation[1] - this.mLocation[1]) + this.mFunctionalButton.getHeight());
        this.mFunctionalButton.post(new Runnable() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.3
            @Override // java.lang.Runnable
            public void run() {
                COUISearchViewAnimate.this.mFunctionalButton.getHitRect(COUISearchViewAnimate.this.mWrapperBounds);
                COUISearchViewAnimate.this.mWrapperBounds.right += COUISearchViewAnimate.this.getPaddingStart();
                COUISearchViewAnimate.this.mWrapperBounds.left += COUISearchViewAnimate.this.getPaddingStart();
                COUISearchViewAnimate.this.mWrapperBounds.top += COUISearchViewAnimate.this.mSearchViewWrapper.getTop();
                COUISearchViewAnimate.this.mWrapperBounds.bottom += COUISearchViewAnimate.this.mSearchViewWrapper.getTop();
                float max = Float.max(0.0f, COUISearchViewAnimate.this.mSearchViewWrapper.getMeasuredHeight() - COUISearchViewAnimate.this.mWrapperBounds.height());
                float f10 = max / 2.0f;
                COUISearchViewAnimate.this.mWrapperBounds.top = (int) (r1.top - f10);
                COUISearchViewAnimate.this.mWrapperBounds.bottom = (int) (r4.bottom + f10);
            }
        });
    }

    private void updatePath() {
        RectF rectF = this.mPressFeedbackBackgroundRect;
        float f10 = (rectF.bottom - rectF.top) / 2.0f;
        boolean isRtl = isRtl();
        if (this.mNeedUpdateNormalRectPath) {
            COUIShapePath.getRoundRectPath(this.mNormalBackgroundPath, this.mNormalBackgroundRect, f10, isRtl, !isRtl, isRtl, !isRtl);
            this.mNeedUpdateNormalRectPath = false;
        }
        if (this.mNeedUpdatePressFeedbackRectPath) {
            if (this.mDivideBackground) {
                COUIShapePath.getRoundRectPath(this.mPressFeedbackBackgroundPath, this.mPressFeedbackBackgroundRect, f10, !isRtl, isRtl, !isRtl, isRtl);
            } else {
                COUIShapePath.getRoundRectPath(this.mPressFeedbackBackgroundPath, this.mPressFeedbackBackgroundRect, f10, true, true, true, true);
            }
            this.mNeedUpdatePressFeedbackRectPath = false;
        }
    }

    @Deprecated
    public void addOnCancelButtonClickListener(OnCancelButtonClickListener onCancelButtonClickListener) {
        List<OnCancelButtonClickListener> ensureList = ensureList(this.mOnCancelButtonClickListeners);
        this.mOnCancelButtonClickListeners = ensureList;
        ensureList.add(onCancelButtonClickListener);
    }

    public void addOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        List<OnStateChangeListener> ensureList = ensureList(this.mOnStateChangeListeners);
        this.mOnStateChangeListeners = ensureList;
        ensureList.add(onStateChangeListener);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
    }

    public void changeStateImmediately(final int i10) {
        Log.d(TAG, "changeStateImmediately: " + state2String(i10));
        post(new Runnable() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.4
            @Override // java.lang.Runnable
            public void run() {
                COUISearchViewAnimate.this.changeStateWithOutAnimation(i10);
            }
        });
    }

    public void changeStateWithAnimation(int i10) {
        if (this.mState.get() == i10) {
            Log.d(TAG, "changeStateWithAnimation: same state , return. targetState = " + i10);
            return;
        }
        if (this.mState.get() == 1) {
            onClickStateEdit();
        } else if (this.mState.get() == 0) {
            onClickStateNormal();
        }
    }

    public void controlImeShowAnim(int i10, Interpolator interpolator) {
        this.mShowImeAnimDuration = i10;
        this.mShowImeInterpolator = interpolator;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        OnDispatchKeyEventPreImeListener onDispatchKeyEventPreImeListener = this.mOnDispatchKeyEventPreImeListener;
        if (onDispatchKeyEventPreImeListener != null) {
            onDispatchKeyEventPreImeListener.onDispatchKeyEventPreIme(keyEvent);
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                if (!isInView(motionEvent.getX(), motionEvent.getY()) && this.mPressed) {
                    this.mPressed = false;
                    playReleaseAnimation();
                }
            } else if (isInView(motionEvent.getX(), motionEvent.getY()) || this.mPressed) {
                this.mPressed = false;
                playReleaseAnimation();
            }
        } else {
            if (motionEvent.getY() < this.mSearchViewWrapper.getTop() || motionEvent.getY() > this.mSearchViewWrapper.getBottom()) {
                return false;
            }
            if (isInView(motionEvent.getX(), motionEvent.getY()) && !isInButton(motionEvent.getX(), motionEvent.getY())) {
                this.mPressed = true;
                playPressAnimation();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public long getAnimatorDuration() {
        return 150L;
    }

    public boolean getCancelIconAnimating() {
        return this.mToolBarAnimationRunning;
    }

    public SearchFunctionalButton getFunctionalButton() {
        return this.mFunctionalButton;
    }

    @Override // android.widget.LinearLayout
    public int getGravity() {
        return this.mGravity;
    }

    public boolean getInputMethodAnimationEnabled() {
        return this.mInputMethodAnimationEnabled;
    }

    public ImageView getMainIconView() {
        return this.mMainIcon;
    }

    public int getSearchState() {
        return this.mState.get();
    }

    public COUISearchView getSearchView() {
        return this.mSearchView;
    }

    public float getSearchViewAnimateHeightPercent() {
        return this.mCollapsingHeightPercent;
    }

    public ImageView getSubIconView() {
        return this.mSubIcon;
    }

    public void hideInToolBar() {
        if (this.mToolBarAnimationRunning) {
            return;
        }
        this.mToolBarAnimationRunning = true;
        ensureAddedToToolBar();
        if (this.mAddToToolbarWay == 1) {
            animate().alpha(0.0f).setDuration(150L).setListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    COUISearchViewAnimate.this.setVisibility(8);
                }
            }).start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISearchViewAnimate.this.setToolBarAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                COUISearchViewAnimate.this.mToolBarAnimationRunning = false;
                COUISearchViewAnimate.this.setToolBarChildVisibility(0);
                COUISearchViewAnimate.this.setSearchAutoCompleteUnFocus();
                COUISearchViewAnimate.this.mFunctionalButton.setVisibility(4);
                COUISearchViewAnimate.this.mButtonDivider.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }
        });
        ofFloat.start();
        if (this.mInputMethodAnimationEnabled) {
            openSoftInput(false);
        }
    }

    @Deprecated
    public boolean isIconCanAnimate() {
        return this.mSearchIconCanAnimate;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mNeedUpdateNormalRectPath || this.mNeedUpdatePressFeedbackRectPath) {
            updatePath();
        }
        Paint paint = this.mPressFeedbackPaint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mNormalPaint.setStyle(style);
        int save = canvas.save();
        if (this.mDivideBackground) {
            this.mNormalPaint.setColor(this.mCurrentBackgroundColor);
            canvas.drawPath(this.mNormalBackgroundPath, this.mNormalPaint);
        }
        this.mPressFeedbackPaint.setColor(this.mCurrentBackgroundColor);
        canvas.drawPath(this.mPressFeedbackBackgroundPath, this.mPressFeedbackPaint);
        canvas.restoreToCount(save);
        super.onDraw(canvas);
    }

    @Override // com.coui.appcompat.searchview.ImeInsetsAnimationCallback.OnImeAnimationListener
    public void onImeAnimStart() {
        if (this.mSearchView.getRootWindowInsets() != null && this.mSearchView.getRootWindowInsets().isVisible(WindowInsets.Type.ime()) && this.mState.get() == 0) {
            this.mState.set(1);
            this.mSearchViewSmoothEnterAnimatorSet.start();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isInIcon(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        if (this.mState.get() == 0 && !isInButton(motionEvent.getX(), motionEvent.getY())) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        updateBackgroundRect();
        updateBounds();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.mSearchViewType == 1) {
            int measuredWidth = (this.mBackgroundEndGap * 2) + this.mFunctionalButton.getMeasuredWidth() + this.mButtonDivider.getMeasuredWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSearchView.getLayoutParams();
            if (marginLayoutParams.getMarginEnd() != measuredWidth) {
                marginLayoutParams.setMarginEnd(measuredWidth);
                this.mSearchView.setLayoutParams(marginLayoutParams);
            }
        }
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
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.mPressFeedbackBackgroundRect.contains(motionEvent.getX(), motionEvent.getY())) {
            return true;
        }
        return onTouchEvent;
    }

    public void openSoftInput(boolean z10) {
        COUISearchView cOUISearchView = this.mSearchView;
        if (cOUISearchView != null && cOUISearchView.getSearchAutoComplete() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            Log.d(TAG, "openSoftInput: " + z10);
            if (z10) {
                setSearchAutoCompleteFocus();
                if (inputMethodManager != null) {
                    if (this.mIsAtLeastR && this.mShowImeAnimDuration != 0) {
                        showSoftInput();
                        return;
                    } else {
                        inputMethodManager.showSoftInput(this.mSearchView.getSearchAutoComplete(), 0);
                        return;
                    }
                }
                return;
            }
            if (inputMethodManager != null && inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(this.mSearchView.getSearchAutoComplete().getWindowToken(), 0);
            }
        }
    }

    public void refresh() {
        String str;
        TypedArray typedArray = null;
        if (this.mStyle != 0) {
            str = getResources().getResourceTypeName(this.mStyle);
        } else {
            str = null;
        }
        if ("attr".equals(str)) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, X8.o.f5164N4, this.mStyle, 0);
        } else if ("style".equals(str)) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, X8.o.f5164N4, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mNormalBackgroundColor = getContext().getResources().getColor(X8.e.f4425B);
            this.mPressedBackgroundColor = getContext().getResources().getColor(X8.e.f4426C);
            this.mCurrentBackgroundColor = this.mNormalBackgroundColor;
            this.mSearchView.getSearchAutoComplete().setTextColor(typedArray.getColor(X8.o.f5244X4, 0));
            int i10 = X8.o.f5196R4;
            Drawable drawable = typedArray.getDrawable(i10);
            if (typedArray.hasValue(i10)) {
                this.mSearchIcon.setImageDrawable(drawable);
            } else {
                this.mSearchIcon.setImageDrawable(drawable);
            }
            this.mSearchView.getSearchAutoComplete().setHintTextColor(typedArray.getColorStateList(X8.o.f5267a5));
            this.mSearchView.setBackgroundColor(typedArray.getColor(X8.o.f5275b5, 0));
            typedArray.getDrawable(X8.o.f5259Z4);
            this.mCloseBtn = (ImageView) this.mSearchView.findViewById(X8.h.f4943q0);
            Drawable drawable2 = typedArray.getDrawable(X8.o.f5188Q4);
            ImageView imageView = this.mCloseBtn;
            if (imageView != null) {
                imageView.setImageDrawable(drawable2);
            }
            Drawable drawable3 = typedArray.getDrawable(X8.o.f5180P4);
            if (drawable3 != null) {
                this.mButtonDivider.setImageDrawable(drawable3);
            }
            COUITextViewCompatUtil.setPressRippleDrawable(this.mFunctionalButton);
            typedArray.recycle();
        }
        if (this.mSearchViewShrinkWidth != 0) {
            this.mSearchViewShrinkWidth = getOriginWidth() - getShrinkWidth();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSearchView.getLayoutParams();
            marginLayoutParams.setMarginEnd(this.mSearchViewShrinkWidth);
            this.mSearchView.setLayoutParams(marginLayoutParams);
        }
    }

    public void setAtBehindToolBar(COUIToolbar cOUIToolbar, int i10, MenuItem menuItem) {
        this.mToolBar = cOUIToolbar;
        this.mGravityInToolBar = i10;
        this.mAddToToolbarWay = 1;
        setMenuItem(menuItem);
        this.mShouldClearFocus = false;
        changeStateImmediately(1);
        setVisibility(8);
    }

    public void setAtFrontToolBar(COUIToolbar cOUIToolbar, int i10, MenuItem menuItem) {
        this.mToolBar = cOUIToolbar;
        this.mGravityInToolBar = i10;
        this.mAddToToolbarWay = 2;
        setMenuItem(menuItem);
        ensureAddedToToolBar();
        menuItem.setVisible(false);
        addOnStateChangeListener(this.mAtToolbarFrontStateChangeListener);
    }

    public void setCancelButtonBackground(Drawable drawable) {
        this.mFunctionalButton.setBackground(drawable);
    }

    public void setCancelDividerImageDrawable(Drawable drawable) {
        this.mButtonDivider.setImageDrawable(drawable);
    }

    public void setCloseBtnBackground(Drawable drawable) {
        this.mCloseBtn.setBackground(drawable);
    }

    public void setCloseBtnImageDrawable(Drawable drawable) {
        this.mCloseBtn.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        ImageView imageView = this.mSearchIcon;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
        COUISearchView cOUISearchView = this.mSearchView;
        if (cOUISearchView != null) {
            cOUISearchView.setEnabled(z10);
        }
        SearchFunctionalButton searchFunctionalButton = this.mFunctionalButton;
        if (searchFunctionalButton != null) {
            searchFunctionalButton.setEnabled(z10);
        }
    }

    public void setExtraActivateMarginTop(int i10) {
        this.mExtraY = i10;
    }

    public void setFunctionalButtonText(String str) {
        this.mFunctionalButton.setText(str);
    }

    @Override // android.widget.LinearLayout
    public void setGravity(int i10) {
        if (this.mGravity != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 16;
            }
            this.mGravity = i10;
        }
    }

    @Deprecated
    public void setIconCanAnimate(boolean z10) {
        this.mSearchIconCanAnimate = z10;
    }

    public void setImeInsetsAnimationCallback() {
        if (this.mIsAtLeastR) {
            this.mShowImeAnimDuration = 450;
            this.mShowImeInterpolator = DEFAULT_SEARCH_VIEW_OFFSET_CHANGE_INTERPOLATOR;
            final ImeInsetsAnimationCallback imeInsetsAnimationCallback = new ImeInsetsAnimationCallback();
            imeInsetsAnimationCallback.setImeAnimationListener(this);
            this.mSearchView.post(new Runnable() { // from class: com.coui.appcompat.searchview.t
                @Override // java.lang.Runnable
                public final void run() {
                    COUISearchViewAnimate.this.lambda$setImeInsetsAnimationCallback$2(imeInsetsAnimationCallback);
                }
            });
        }
    }

    public void setInputHintTextColor(int i10) {
        this.mSearchView.getSearchAutoComplete().setHintTextColor(i10);
    }

    public void setInputMethodAnimationEnabled(boolean z10) {
        this.mInputMethodAnimationEnabled = z10;
    }

    public void setInputTextColor(int i10) {
        this.mSearchView.getSearchAutoComplete().setTextColor(i10);
    }

    public void setMainIconDrawable(Drawable drawable) {
        this.mMainIcon.setImageDrawable(drawable);
    }

    public void setOnAnimationListener(OnAnimationListener onAnimationListener) {
        this.mOnAnimationListener = onAnimationListener;
    }

    public void setOnDispatchKeyEventPreImeListener(OnDispatchKeyEventPreImeListener onDispatchKeyEventPreImeListener) {
        this.mOnDispatchKeyEventPreImeListener = onDispatchKeyEventPreImeListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        COUISearchView cOUISearchView = this.mSearchView;
        if (cOUISearchView != null) {
            cOUISearchView.setQueryHint(charSequence);
        }
    }

    public void setSearchAnimateType(int i10) {
        if (this.mState.get() == 1) {
            Log.d(TAG, "setSearchAnimateType to " + TYPE_NAME[i10] + " is not allowed in STATE_EDIT");
            return;
        }
        this.mSearchViewType = i10;
        if (i10 == 0) {
            this.mButtonDivider.setVisibility(8);
            this.mFunctionalButton.setVisibility(4);
            this.mFunctionalButton.setAlpha(0.0f);
            ((ViewGroup.MarginLayoutParams) this.mFunctionalButton.getLayoutParams()).setMarginStart(this.mCancelButtonLargeStartMargin);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSearchView.getLayoutParams();
            marginLayoutParams.setMarginEnd(0);
            this.mSearchView.setLayoutParams(marginLayoutParams);
            return;
        }
        if (i10 == 1) {
            this.mButtonDivider.setVisibility(8);
            this.mFunctionalButton.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) this.mFunctionalButton.getLayoutParams()).setMarginStart(this.mCancelButtonSmallStartMargin);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mSearchView.getLayoutParams();
            marginLayoutParams2.setMarginEnd(getOriginWidth() - getShrinkWidth());
            this.mSearchView.setLayoutParams(marginLayoutParams2);
        }
    }

    public void setSearchBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i10 = this.mNormalBackgroundColor;
            int defaultColor = colorStateList.getDefaultColor();
            this.mNormalBackgroundColor = defaultColor;
            this.mPressedBackgroundColor = colorStateList.getColorForState(new int[]{16842919}, defaultColor);
            if (this.mCurrentBackgroundColor == i10) {
                this.mCurrentBackgroundColor = this.mNormalBackgroundColor;
            }
            invalidate();
        }
    }

    public void setSearchViewAnimateHeightPercent(float f10) {
        this.mCollapsingHeightPercent = f10;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getChildAt(0).getLayoutParams();
        marginLayoutParams.height = (int) Float.max(this.mCollapsedMinHeight, this.mInitSearchViewWrapperHeight * clampSearchViewHeight(f10));
        marginLayoutParams.setMarginStart((int) (getPaddingStart() * (1.0f - clampMarginValue(f10)) * (-1.0f)));
        marginLayoutParams.setMarginEnd((int) (getPaddingEnd() * (1.0f - clampMarginValue(f10)) * (-1.0f)));
        getChildAt(0).setLayoutParams(marginLayoutParams);
        setTranslationY((this.mInitSearchViewAnimateHeight / 2.0f) * (1.0f - f10));
        float f11 = (f10 - 0.5f) * 2.0f;
        this.mSearchView.setAlpha(f11);
        this.mSearchIcon.setAlpha(f11);
        this.mCurrentBackgroundColor = ((Integer) this.mEvaluator.evaluate(clampMarginValue(f10), Integer.valueOf(this.mHorizontalDividerColor), Integer.valueOf(this.mNormalBackgroundColor))).intValue();
    }

    public void setSearchViewBackgroundColor(int i10) {
        this.mSearchView.setBackgroundColor(i10);
    }

    public void setSearchViewIcon(Drawable drawable) {
        this.mSearchIcon.setImageDrawable(drawable);
    }

    public void setSubIconDrawable(Drawable drawable) {
        this.mSubIcon.setImageDrawable(drawable);
    }

    public void showInToolBar() {
        if (this.mToolBarAnimationRunning) {
            return;
        }
        this.mToolBarAnimationRunning = true;
        ensureAddedToToolBar();
        if (this.mAddToToolbarWay == 1) {
            setVisibility(0);
            setAlpha(0.0f);
            int i10 = this.mSearchViewType;
            if (i10 == 0) {
                this.mFunctionalButton.setVisibility(0);
                this.mButtonDivider.setVisibility(8);
            } else if (i10 == 1) {
                this.mFunctionalButton.setVisibility(0);
                this.mButtonDivider.setVisibility(0);
            }
            post(new Runnable() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.5
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) COUISearchViewAnimate.this.mSearchView.getLayoutParams();
                    marginLayoutParams.setMarginEnd(COUISearchViewAnimate.this.getOriginWidth() - COUISearchViewAnimate.this.getShrinkWidth());
                    COUISearchViewAnimate.this.mSearchView.setLayoutParams(marginLayoutParams);
                }
            });
            animate().alpha(1.0f).setDuration(150L).setListener(null).start();
        }
        setToolBarChildVisibility(8);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISearchViewAnimate.this.setToolBarAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                COUISearchViewAnimate.this.mToolBarAnimationRunning = false;
                COUISearchViewAnimate.this.setSearchAutoCompleteFocus();
            }
        });
        ofFloat.start();
        setSearchAutoCompleteUnFocus();
        if (this.mInputMethodAnimationEnabled) {
            openSoftInput(true);
        }
    }

    public COUISearchViewAnimate(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4393m0);
    }

    public COUISearchViewAnimate(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPressFeedbackBackgroundPath = new Path();
        this.mNormalBackgroundPath = new Path();
        this.mPressFeedbackPaint = new Paint(1);
        this.mNormalPaint = new Paint(1);
        this.mButtonLocation = new int[2];
        this.mLocation = new int[2];
        this.mEvaluator = new ArgbEvaluator();
        this.mButtonHitRect = new RectF();
        Rect rect = new Rect();
        this.mWrapperBounds = rect;
        this.mState = new AtomicInteger(0);
        this.mGravityInToolBar = 48;
        this.mAddToToolbarWay = 0;
        this.mSearchIconCanAnimate = true;
        this.mShouldClearFocus = true;
        this.mInputMethodAnimationEnabled = true;
        this.mTopOffset = 0;
        this.mExtraY = 0;
        this.mSearchViewType = 1;
        this.mCollapsingHeightPercent = 1.0f;
        this.mDivideBackground = false;
        this.mNeedUpdatePressFeedbackRectPath = true;
        this.mNeedUpdateNormalRectPath = true;
        this.mShowImeAnimDuration = 0;
        this.mShowImeInterpolator = null;
        this.mPressed = false;
        this.mAtToolbarFrontStateChangeListener = new OnStateChangeListener() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.1
            @Override // com.coui.appcompat.searchview.COUISearchViewAnimate.OnStateChangeListener
            public void onStateChange(int i11, int i12) {
                if (i12 == 1) {
                    COUISearchViewAnimate.this.showInToolBar();
                } else if (i12 == 0) {
                    COUISearchViewAnimate.this.hideInToolBar();
                }
            }
        };
        this.mGravity = 16;
        this.mContext = context;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.mIsAtLeastR = true;
        inflateView(context, attributeSet);
        loadAttr(context, attributeSet, i10, 0);
        setClipToPadding(false);
        setClipChildren(false);
        setWillNotDraw(false);
        initAnimator();
        setLayoutDirection(3);
        setSearchAnimateType(this.mSearchViewType);
        setTouchDelegate(new TouchDelegate(rect, this.mFunctionalButton));
        this.mSearchView.getSearchAutoComplete().addTextChangedListener(new TextWatcher() { // from class: com.coui.appcompat.searchview.COUISearchViewAnimate.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if ("".contentEquals(editable)) {
                    COUISearchViewAnimate.this.mMainIcon.setVisibility(0);
                    COUISearchViewAnimate.this.mSubIcon.setVisibility(0);
                } else {
                    COUISearchViewAnimate.this.mMainIcon.setVisibility(8);
                    COUISearchViewAnimate.this.mSubIcon.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
    }

    @Override // j.InterfaceC1146c
    public void onActionViewCollapsed() {
    }

    @Override // j.InterfaceC1146c
    public void onActionViewExpanded() {
    }

    @Deprecated
    public void removeHintViewLayoutOnClickListener() {
    }

    @Deprecated
    public void setHintTextViewHintTextColor(int i10) {
    }

    @Deprecated
    public void setHintTextViewTextColor(int i10) {
    }

    @Deprecated
    public void setHintViewBackground(Drawable drawable) {
    }

    @Deprecated
    public void setHintViewLayoutOnClickListener(View.OnClickListener onClickListener) {
    }
}
