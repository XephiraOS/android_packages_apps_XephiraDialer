package com.coui.appcompat.floatingactionbutton;

import A.h;
import a9.d;
import a9.m;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.dynamicanimation.animation.c;
import androidx.dynamicanimation.animation.f;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.state.COUIStrokeDrawable;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f.C0991a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUIFloatingButton extends LinearLayout {
    private static final int ACTION_ANIM_DELAY = 50;
    private static final String ANIMATION_TYPE_ALPHA = "alpha";
    private static final String ANIMATION_TYPE_ROTATION = "rotation";
    private static final String ANIMATION_TYPE_SCALE_X = "scaleX";
    private static final String ANIMATION_TYPE_SCALE_Y = "scaleY";
    private static final String ANIMATION_TYPE_TRANSLATION_Y = "translationY";
    private static final float DEFAULT_ALPHA_ANIMATION_MAX_VALUE = 1.0f;
    private static final float DEFAULT_ALPHA_ANIMATION_MIN_VALUE = 0.0f;
    private static final float DEFAULT_ANIMATION_EXPAND_END_VALUE = 1.1f;
    private static final float DEFAULT_ANIMATION_EXPAND_START_VALUE = 1.0f;
    private static final float DEFAULT_ANIMATION_NARROW_END_VALUE = 1.0f;
    private static final float DEFAULT_ANIMATION_NARROW_START_VALUE = 1.1f;
    private static final int DEFAULT_BUTTON_EXPAND_ANIMATION_DURATION = 66;
    private static final int DEFAULT_BUTTON_LABEL_CLOSE_ALPHA_ANIMATION_DURATION = 350;
    private static final float DEFAULT_CLOSE_MENU_ALPHA_ANIMATION_END_VALUE = 0.0f;
    private static final float DEFAULT_CLOSE_MENU_ALPHA_ANIMATION_START_VALUE = 1.0f;
    private static final int DEFAULT_CLOSE_MENU_ANIMATION_DURATION_WITH_SLIDE_OUT = 150;
    private static final float DEFAULT_CLOSE_MENU_NARROW_ANIMATION_END_VALUE = 0.6f;
    private static final float DEFAULT_CLOSE_MENU_NARROW_ANIMATION_START_VALUE = 1.0f;
    private static final int DEFAULT_COUI_FLOATING_BUTTON_SIZE = 56;
    private static final float DEFAULT_DISABLE_ALPHA = 0.3f;
    private static final int DEFAULT_ELEVATION_FLOATING_BUTTON = 24;
    private static final float DEFAULT_ENABLE_ALPHA = 1.0f;
    private static final long DEFAULT_ENLARGE_ANIMATION_DURATION = 350;
    private static final float DEFAULT_EXPAND_MENU_ALPHA_ANIMATION_END_VALUE = 1.0f;
    private static final float DEFAULT_EXPAND_MENU_ALPHA_ANIMATION_START_VALUE = 0.0f;
    private static final float DEFAULT_EXPAND_MENU_EXPAND_ANIMATION_END_VALUE = 1.0f;
    private static final float DEFAULT_EXPAND_MENU_EXPAND_ANIMATION_START_VALUE = 0.6f;
    private static final int DEFAULT_EXPAND_WAY = 0;
    private static final int DEFAULT_LABEL_ALPHA_ANIMATION_DURATION = 200;
    private static final int DEFAULT_MAIN_FLOATING_BUTTON_ANIMATION_DURATION = 300;
    private static final int DEFAULT_MARGIN_BOTTOM_FIRST_CHILD = 32;
    private static final int DEFAULT_MARGIN_BOTTOM_NOT_FIRST_CHILD = 16;
    private static final int DEFAULT_PRESS_FEEDBACK_ANIMATION_DURATION = 200;
    private static final float DEFAULT_PRESS_FEEDBACK_BRIGHTNESS_MAX_VALUE = 1.0f;
    private static final float DEFAULT_PRESS_FEEDBACK_BRIGHTNESS_MIN_VALUE = 0.88f;
    private static final float DEFAULT_PRESS_FEEDBACK_SCALE_MAX_VALUE = 1.0f;
    private static final float DEFAULT_PRESS_FEEDBACK_SCALE_MIN_VALUE = 0.9f;
    private static final float DEFAULT_PRESS_GUARANTEED_ANIMATION_VALUE = 0.98f;
    private static final int DEFAULT_ROTATE_ANGLE = 45;
    private static final int DEFAULT_ROTATE_ANIMATION_DURATION = 250;
    private static final int DEFAULT_ROTATE_ANIMATION_DURATION_NO_ITEM = 300;
    private static final float DEFAULT_SCALE_ANIMATION_MAX_VALUE = 1.0f;
    private static final float DEFAULT_SCALE_ANIMATION_MIN_VALUE = 0.6f;
    private static final float DEFAULT_SCALE_PERCENT = 0.4f;
    private static final int DEFAULT_SLIDE_IN_ANIMATION_DURATION = 200;
    private static final int DEFAULT_SLIDE_OUT_ANIMATION_DURATION = 250;
    private static final int DEFAULT_SLIDE_OUT_TRANSITION_ANIMATION_DURATION = 140;
    private static final int DEFAULT_SLIDING_THRESHOLD = 10;
    private static final float DEFAULT_SPRING_ANIMATION_DAMPING_RATIO = 0.8f;
    private static final int DEFAULT_SPRING_ANIMATION_START_VELOCITY = 0;
    private static final int DEFAULT_SPRING_ANIMATION_STIFFNESS = 500;
    private static final int DELAY_TIME_NO_ACTION_SLIDE_OUT = 5000;
    private static final int MAIN_FAB_HORIZONTAL_MARGIN_IN_DP = 12;
    private static final int MAIN_FAB_VERTICAL_MARGIN_IN_DP = 8;
    private static final int MAX_COLOR_FLOATING_BUTTON_SIZE = 6;
    private static final int MESSAGE_PAUSE_TIME_SLIDE_OUT = 1;
    private static final int STATE_COLLAPSED = 1;
    private static final int STATE_COLLAPSING = 4;
    private static final int STATE_DISABLED = -1;
    private static final int STATE_EXPANDED = 2;
    private static final int STATE_EXPANDING = 3;
    private static final String STATE_KEY_EXPANSION_MODE = "expansionMode";
    private static final String STATE_KEY_IS_OPEN = "isOpen";
    private static final String STATE_KEY_SUPER = "superState";
    private static final int STATE_NORMAL = 0;
    private static final String TAG = "COUIFloatingButton";
    private static final float TWO = 2.0f;
    private Runnable mAutoDismissRunnable;
    private int mButtonSize;
    private PathInterpolator mCloseMenuLabelPathInterpolator;
    private PathInterpolator mCloseMenuPathInterpolator;
    private float mCurrentProgress;
    private int mCurrentWindowHeight;
    private int mCurrentWindowHeightOffset;
    private int mDisabledColor;
    private PathInterpolator mExpandMenuAnimationInterpolator;
    private OnFloatingButtonClickListener mFloatingButtonClickListener;
    private List<COUIFloatingButtonLabel> mFloatingButtonLabelList;
    private int mFloatingButtonPixel;
    private ValueAnimator mHideAnimator;
    private final InstanceState mInstanceState;
    private boolean mIsAnimationInStart;
    private boolean mIsAnimationOutStart;
    private boolean mIsFloatingButtonExpandEnable;
    private boolean mIsNeedElevation;
    private boolean mIsNeedToDelayCancelScaleAnim;
    private boolean mIsNeedVibrate;
    private boolean mIsScaleAnimation;
    private PathInterpolator mLabelPathInterpolator;
    private final Rect mMainButtonGlobalRect;
    private final RectF mMainButtonRect;
    private ShapeDrawable mMainButtonShapeDrawable;
    private Drawable mMainFabCloseOriginalDrawable;
    private Drawable mMainFabClosedDrawable;
    private AppCompatImageView mMainFloatingButton;
    private float mMainFloatingButtonX;
    private float mMainFloatingButtonY;
    private COUIMaskEffectDrawable mMaskDrawable;
    private OnActionSelectedListener mOnActionSelectedListener;
    private OnActionSelectedListener mOnActionSelectedProxyListener;
    private OnChangeListener mOnChangeListener;
    private ValueAnimator mPressAnimationRecorder;
    private float mPressValue;
    private ValueAnimator mProgressAnimator;
    private float mRotateAngle;
    private PathInterpolator mRotateBackwardInterpolator;
    private PathInterpolator mRotateForwardInterpolator;
    private int mState;
    private int mStateBeforeDisable;
    private COUIStateEffectDrawable mStateEffectBackground;
    private COUIStrokeDrawable mStrokeEffectDrawable;
    private OnActionSelectedListener mTempOnActionSelectedListener;
    private float mTranslateEnhancementRatio;
    private static final int[] DISABLED_STATE = {-16842910};
    private static final PathInterpolator DEFAULT_ENLARGE_ANIMATION_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final PathInterpolator PRESS_FEEDBACK_INTERPOLATOR = new COUIMoveEaseInterpolator();

    /* loaded from: classes.dex */
    public class AutoDismissRunnable implements Runnable {
        private AutoDismissRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIFloatingButton.this.animationFloatingButtonEnlarge();
        }
    }

    /* loaded from: classes.dex */
    public interface OnActionSelectedListener {
        boolean onActionSelected(COUIFloatingButtonItem cOUIFloatingButtonItem);
    }

    /* loaded from: classes.dex */
    public interface OnChangeListener {
        boolean onMainActionSelected();

        void onToggleChanged(boolean z10);
    }

    /* loaded from: classes.dex */
    public interface OnFloatingButtonClickListener {
        void onClick();
    }

    public COUIFloatingButton(Context context) {
        super(context);
        this.mMainButtonRect = new RectF();
        this.mMainButtonGlobalRect = new Rect();
        this.mState = 0;
        this.mStateBeforeDisable = 0;
        this.mCurrentProgress = 1.0f;
        this.mInstanceState = new InstanceState();
        this.mFloatingButtonLabelList = new ArrayList();
        this.mMainFabClosedDrawable = null;
        this.mExpandMenuAnimationInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mCloseMenuPathInterpolator = new COUIMoveEaseInterpolator();
        this.mLabelPathInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mCloseMenuLabelPathInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mRotateForwardInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mRotateBackwardInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mIsNeedElevation = true;
        this.mIsNeedVibrate = true;
        this.mIsScaleAnimation = true;
        this.mProgressAnimator = null;
        this.mOnActionSelectedProxyListener = new OnActionSelectedListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.1
            @Override // com.coui.appcompat.floatingactionbutton.COUIFloatingButton.OnActionSelectedListener
            public boolean onActionSelected(COUIFloatingButtonItem cOUIFloatingButtonItem) {
                if (COUIFloatingButton.this.mOnActionSelectedListener == null) {
                    return false;
                }
                boolean onActionSelected = COUIFloatingButton.this.mOnActionSelectedListener.onActionSelected(cOUIFloatingButtonItem);
                if (!onActionSelected) {
                    COUIFloatingButton.this.closeFloatingButtonMenu(false, 300);
                }
                return onActionSelected;
            }
        };
        init(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateNormal(android.view.MotionEvent r5) {
        /*
            r4 = this;
            android.animation.ValueAnimator r0 = r4.mProgressAnimator
            if (r0 == 0) goto Lf
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto Lf
            android.animation.ValueAnimator r0 = r4.mProgressAnimator
            r0.cancel()
        Lf:
            int r0 = r4.mState
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L37
            if (r0 == r1) goto L37
            r3 = 2
            if (r0 == r3) goto L1e
            r3 = 4
            if (r0 == r3) goto L37
            return
        L1e:
            float r0 = r5.getRawX()
            int r0 = (int) r0
            float r5 = r5.getRawY()
            int r5 = (int) r5
            boolean r5 = r4.isEventInsideView(r0, r5)
            if (r5 == 0) goto L4c
            r4.closeFloatingButtonMenu()
            com.coui.appcompat.state.COUIMaskEffectDrawable r5 = r4.mMaskDrawable
            r5.setTouchEnterStateLocked(r2, r2, r1)
            goto L4c
        L37:
            float r0 = r5.getRawX()
            int r0 = (int) r0
            float r5 = r5.getRawY()
            int r5 = (int) r5
            boolean r5 = r4.isEventInsideView(r0, r5)
            if (r5 != 0) goto L4c
            com.coui.appcompat.state.COUIMaskEffectDrawable r5 = r4.mMaskDrawable
            r5.setTouchEnterStateLocked(r2, r2, r1)
        L4c:
            android.animation.ValueAnimator r4 = r4.mProgressAnimator
            if (r4 == 0) goto L53
            r4.start()
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.animateNormal(android.view.MotionEvent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animatePress() {
        performHapticFeedback();
        ValueAnimator valueAnimator = this.mProgressAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mProgressAnimator.cancel();
        }
        int i10 = this.mState;
        if (i10 != 0 && i10 != 1) {
            if (i10 != 2 && i10 != 3 && i10 != 4) {
                return;
            }
        } else if (hasFloatingButtonLabel()) {
            this.mMaskDrawable.setTouchEnterStateLocked(true, true, true);
        }
        ValueAnimator valueAnimator2 = this.mProgressAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    private void animationFloatingButtonMenuClose(final COUIFloatingButtonLabel cOUIFloatingButtonLabel, int i10, final int i11, final int i12, final boolean z10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int totalLabelHeight = getTotalLabelHeight(i11);
        if (z10) {
            totalLabelHeight += marginLayoutParams.bottomMargin + this.mMainFloatingButton.getHeight();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel, ANIMATION_TYPE_TRANSLATION_Y, totalLabelHeight);
        ofFloat.setStartDelay(i10);
        ofFloat.setDuration(i12);
        ofFloat.setInterpolator(this.mCloseMenuPathInterpolator);
        if (cOUIFloatingButtonLabel.getFloatingButtonLabelText().getText() != "") {
            if (isRtlMode()) {
                cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().setPivotX(0.0f);
                cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().setPivotY(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().getHeight());
            } else {
                cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().setPivotX(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().getWidth());
                cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().setPivotY(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().getHeight());
            }
        }
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                cOUIFloatingButtonLabel.setTranslationY(COUIFloatingButton.this.getTotalLabelHeight(i11));
                cOUIFloatingButtonLabel.getChildFloatingButton().setPivotX(cOUIFloatingButtonLabel.getChildFloatingButton().getWidth() / 2.0f);
                cOUIFloatingButtonLabel.getChildFloatingButton().setPivotY(cOUIFloatingButtonLabel.getChildFloatingButton().getHeight() / 2.0f);
                cOUIFloatingButtonLabel.setPivotX(r3.getWidth());
                cOUIFloatingButtonLabel.setPivotY(r3.getHeight());
                if (COUIFloatingButton.this.isLastFloatingButtonLabel(i11)) {
                    COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = false;
                }
                COUIFloatingButton.this.setState(1);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUIFloatingButton.this.isFirstFloatingButtonLabel(i11)) {
                    COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = true;
                    COUIFloatingButton.this.setOnActionSelectedListener(null);
                }
                if (z10) {
                    COUIFloatingButton.this.narrowFloatingButton(cOUIFloatingButtonLabel, i11, i12, true);
                } else {
                    COUIFloatingButton.this.narrowFloatingButton(cOUIFloatingButtonLabel, i11, i12, false);
                }
                COUIFloatingButton.this.setState(4);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.start();
    }

    private void animationFloatingButtonMenuExpand(final COUIFloatingButtonLabel cOUIFloatingButtonLabel, int i10, final int i11, final int i12) {
        AnimatorSet animatorSet = new AnimatorSet();
        final f fVar = new f(cOUIFloatingButtonLabel, c.f9697n, 0.0f);
        fVar.u().f(500.0f);
        fVar.u().d(DEFAULT_SPRING_ANIMATION_DAMPING_RATIO);
        fVar.n(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getChildFloatingButton(), ANIMATION_TYPE_SCALE_X, 0.6f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getChildFloatingButton(), ANIMATION_TYPE_SCALE_Y, 0.6f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground(), ANIMATION_TYPE_SCALE_X, 0.6f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground(), ANIMATION_TYPE_SCALE_Y, 0.6f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getChildFloatingButton(), ANIMATION_TYPE_ALPHA, 0.0f, 1.0f);
        final ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground(), ANIMATION_TYPE_ALPHA, 0.0f, 1.0f);
        ofFloat6.setInterpolator(this.mExpandMenuAnimationInterpolator);
        ofFloat6.setDuration(DEFAULT_ENLARGE_ANIMATION_DURATION);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat5, ofFloat3, ofFloat4);
        animatorSet.setInterpolator(this.mExpandMenuAnimationInterpolator);
        animatorSet.setDuration(300L);
        animatorSet.setStartDelay(i10);
        if (cOUIFloatingButtonLabel.getFloatingButtonLabelText().getText() != "") {
            if (isRtlMode()) {
                cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().setPivotX(0.0f);
                cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().setPivotY(0.0f);
            } else {
                cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().setPivotX(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().getWidth());
                cOUIFloatingButtonLabel.getFloatingButtonLabelBackground().setPivotY(0.0f);
            }
        }
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIFloatingButton.this.isFirstFloatingButtonLabel(i11)) {
                    COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = false;
                    COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                    cOUIFloatingButton.setOnActionSelectedListener(cOUIFloatingButton.mTempOnActionSelectedListener);
                }
                COUIFloatingButton.this.setState(2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUIFloatingButton.this.isLastFloatingButtonLabel(i11)) {
                    COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = true;
                    COUIFloatingButton.this.setOnActionSelectedListener(null);
                }
                ofFloat6.start();
                fVar.s(0.0f);
                cOUIFloatingButtonLabel.setVisibility(i12);
                COUIFloatingButton.this.setState(3);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
    }

    private void cancelHideAnimator() {
        ValueAnimator valueAnimator = this.mHideAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mHideAnimator.cancel();
        }
    }

    private AppCompatImageView createMainFab() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f6598w);
        int i10 = this.mButtonSize;
        if (i10 > 0) {
            this.mFloatingButtonPixel = i10;
        } else {
            this.mFloatingButtonPixel = getResources().getDimensionPixelSize(d.f6604z);
        }
        int i11 = this.mFloatingButtonPixel;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i11);
        RectF rectF = this.mMainButtonRect;
        int i12 = this.mFloatingButtonPixel;
        rectF.set(0.0f, 0.0f, i12, i12);
        layoutParams.gravity = 8388613;
        int dpToPx = dpToPx(getContext(), 0.0f);
        dpToPx(getContext(), 8.0f);
        layoutParams.setMargins(dpToPx, 0, dpToPx, 0);
        appCompatImageView.setId(a9.f.f6640j);
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setPaddingRelative(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER);
        appCompatImageView.setClickable(true);
        appCompatImageView.setFocusable(true);
        return appCompatImageView;
    }

    private static int dpToPx(Context context, float f10) {
        return Math.round(TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics()));
    }

    private COUIFloatingButtonLabel findFloatingButtonItemByIndex(int i10) {
        if (i10 < this.mFloatingButtonLabelList.size()) {
            return this.mFloatingButtonLabelList.get(i10);
        }
        return null;
    }

    private COUIFloatingButtonLabel findFloatingButtonItemByPosition(int i10) {
        for (COUIFloatingButtonLabel cOUIFloatingButtonLabel : this.mFloatingButtonLabelList) {
            if (cOUIFloatingButtonLabel.getId() == i10) {
                return cOUIFloatingButtonLabel;
            }
        }
        return null;
    }

    private int getBrightnessColor(int i10, float f10) {
        float[] fArr = new float[3];
        B.a.m(i10, fArr);
        if (this.mTranslateEnhancementRatio == 0.0f) {
            fArr[2] = fArr[2] * f10;
            int a10 = B.a.a(fArr);
            return Color.argb(Color.alpha(a10), Math.min(255, Color.red(a10)), Math.min(255, Color.green(a10)), Math.min(255, Color.blue(a10)));
        }
        int a11 = B.a.a(fArr);
        return Color.argb((int) (Color.alpha(i10) / f10), Math.min(255, Color.red(a11)), Math.min(255, Color.green(a11)), Math.min(255, Color.blue(a11)));
    }

    private float getBrightnessValue(float f10) {
        float f11;
        float f12 = this.mTranslateEnhancementRatio;
        if (f12 != 0.0f) {
            f11 = 1.0f / f12;
        } else {
            f11 = DEFAULT_PRESS_FEEDBACK_BRIGHTNESS_MIN_VALUE;
        }
        return f11 + ((1.0f - f11) * f10);
    }

    private void getGlobalVisibleRectWithoutTransformation(View view) {
        view.getGlobalVisibleRect(this.mMainButtonGlobalRect);
        float width = this.mMainButtonGlobalRect.width() / view.getScaleX();
        int width2 = (int) ((width - this.mMainButtonGlobalRect.width()) * (view.getPivotX() / width));
        float height = this.mMainButtonGlobalRect.height() / view.getScaleY();
        int height2 = (int) ((height - this.mMainButtonGlobalRect.height()) * (view.getPivotY() / height));
        Rect rect = this.mMainButtonGlobalRect;
        rect.set(rect.left - width2, rect.top - height2, rect.right + width2, rect.bottom + height2);
    }

    private int getLayoutPosition(int i10) {
        return this.mFloatingButtonLabelList.size() - i10;
    }

    private float getScaleValue(float f10) {
        return (f10 * 0.100000024f) + 0.9f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTotalLabelHeight(int i10) {
        if (i10 >= 0 && i10 < this.mFloatingButtonLabelList.size()) {
            return dpToPx(getContext(), (i10 * 72) + 88);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnClickFloatingButton() {
        if (isOpen()) {
            OnChangeListener onChangeListener = this.mOnChangeListener;
            if (onChangeListener == null || !onChangeListener.onMainActionSelected()) {
                closeFloatingButtonMenu();
                return;
            }
            return;
        }
        openFloatingButtonMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide(FloatingActionButton.b bVar) {
        if (isOpen()) {
            closeFloatingButtonMenu();
            K.d(this.mMainFloatingButton).f(0.0f).g(0L).m();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6785Q, 0, 0);
        this.mIsNeedElevation = obtainStyledAttributes.getBoolean(m.f6801U, true);
        this.mIsNeedVibrate = obtainStyledAttributes.getBoolean(m.f6805V, true);
        this.mButtonSize = obtainStyledAttributes.getDimensionPixelSize(m.f6793S, 0);
        this.mIsScaleAnimation = obtainStyledAttributes.getBoolean(m.f6809W, true);
        this.mTranslateEnhancementRatio = obtainStyledAttributes.getFloat(m.f6813X, 0.0f);
        this.mMainFloatingButton = createMainFab();
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.4
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        };
        if (this.mIsNeedElevation) {
            ShadowUtils.setElevationToView(this.mMainFloatingButton, 3, getResources().getDimensionPixelOffset(X8.f.f4558N5), getResources().getColor(a9.c.f6483g));
        }
        this.mMainFloatingButton.setOutlineProvider(viewOutlineProvider);
        this.mMainFloatingButton.setClipToOutline(true);
        this.mMainFloatingButton.setDefaultFocusHighlightEnabled(false);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        this.mMainButtonShapeDrawable = shapeDrawable;
        shapeDrawable.getPaint().setColor(COUIContextUtil.getAttrColor(getContext(), X8.c.f4347F, 0));
        this.mMainButtonShapeDrawable.setBounds(0, 0, (int) this.mMainButtonRect.width(), (int) this.mMainButtonRect.height());
        COUIMaskEffectDrawable cOUIMaskEffectDrawable = new COUIMaskEffectDrawable(context, 0);
        this.mMaskDrawable = cOUIMaskEffectDrawable;
        RectF rectF = this.mMainButtonRect;
        cOUIMaskEffectDrawable.setMaskRect(rectF, rectF.width() / 2.0f, this.mMainButtonRect.height() / 2.0f);
        COUIStrokeDrawable cOUIStrokeDrawable = new COUIStrokeDrawable(context);
        this.mStrokeEffectDrawable = cOUIStrokeDrawable;
        RectF rectF2 = this.mMainButtonRect;
        cOUIStrokeDrawable.setStrokeRect(rectF2, rectF2.width() / 2.0f, this.mMainButtonRect.height() / 2.0f);
        View view = new View(getContext());
        int i10 = this.mFloatingButtonPixel;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i10);
        view.setBackground(this.mStrokeEffectDrawable);
        view.setFocusable(false);
        COUIStateEffectDrawable cOUIStateEffectDrawable = new COUIStateEffectDrawable(new Drawable[]{this.mMainButtonShapeDrawable, this.mMaskDrawable});
        this.mStateEffectBackground = cOUIStateEffectDrawable;
        cOUIStateEffectDrawable.enableScaleEffect(this.mMainFloatingButton, 2);
        this.mMainFloatingButton.setBackground(this.mStateEffectBackground);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 8388613;
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setClipChildren(false);
        frameLayout.addView(this.mMainFloatingButton);
        frameLayout.addView(view, layoutParams);
        addView(frameLayout, layoutParams2);
        setClipChildren(false);
        setClipToPadding(false);
        setFocusable(false);
        this.mMainFloatingButton.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.coui.appcompat.floatingactionbutton.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                COUIFloatingButton.this.lambda$init$0(view2, z10);
            }
        });
        this.mAutoDismissRunnable = new AutoDismissRunnable();
        this.mDisabledColor = h.d(context.getResources(), a9.c.f6482f, context.getTheme());
        try {
            try {
                this.mIsFloatingButtonExpandEnable = obtainStyledAttributes.getBoolean(m.f6797T, true);
                int resourceId = obtainStyledAttributes.getResourceId(m.f6821Z, Integer.MIN_VALUE);
                if (resourceId != Integer.MIN_VALUE) {
                    setMainFabDrawable(C0991a.b(getContext(), resourceId));
                }
                setExpansionMode();
                setMainFloatingButtonBackgroundColor(obtainStyledAttributes.getColorStateList(m.f6817Y));
                setFloatingButtonExpandEnable(this.mIsFloatingButtonExpandEnable);
                setEnabled(obtainStyledAttributes.getBoolean(m.f6789R, isEnabled()));
            } catch (Exception e10) {
                Log.e(TAG, "Failure setting FabWithLabelView icon" + e10.getMessage());
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private boolean isEventInsideView(int i10, int i11) {
        getGlobalVisibleRectWithoutTransformation(this.mMainFloatingButton);
        return this.mMainButtonGlobalRect.contains(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFirstFloatingButtonLabel(int i10) {
        COUIFloatingButtonLabel findFloatingButtonItemByIndex = findFloatingButtonItemByIndex(i10);
        if (findFloatingButtonItemByIndex == null || indexOfChild(findFloatingButtonItemByIndex) != this.mFloatingButtonLabelList.size() - 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLastFloatingButtonLabel(int i10) {
        COUIFloatingButtonLabel findFloatingButtonItemByIndex = findFloatingButtonItemByIndex(i10);
        if (findFloatingButtonItemByIndex == null || indexOfChild(findFloatingButtonItemByIndex) != 0) {
            return false;
        }
        return true;
    }

    private boolean isRtlMode() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view, boolean z10) {
        if (z10) {
            this.mStrokeEffectDrawable.setFocusEntered();
        } else {
            this.mStrokeEffectDrawable.setFocusExited();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void narrowFloatingButton(COUIFloatingButtonLabel cOUIFloatingButtonLabel, int i10, int i11, boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getChildFloatingButton(), ANIMATION_TYPE_SCALE_X, 1.0f, 0.6f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getChildFloatingButton(), ANIMATION_TYPE_SCALE_Y, 1.0f, 0.6f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground(), ANIMATION_TYPE_SCALE_X, 1.0f, 0.6f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground(), ANIMATION_TYPE_SCALE_Y, 1.0f, 0.6f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getChildFloatingButton(), ANIMATION_TYPE_ALPHA, 1.0f, 0.0f);
        final ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(cOUIFloatingButtonLabel.getFloatingButtonLabelBackground(), ANIMATION_TYPE_ALPHA, 1.0f, 0.0f);
        ofFloat6.setInterpolator(this.mCloseMenuLabelPathInterpolator);
        ofFloat6.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat5, ofFloat4, ofFloat3);
        animatorSet.setInterpolator(this.mCloseMenuPathInterpolator);
        animatorSet.setDuration(i11);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ofFloat6.start();
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
        animatorSet.start();
    }

    private void performHapticFeedback() {
        if (this.mIsNeedVibrate) {
            performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        }
    }

    private void setExpansionMode() {
        setOrientation(1);
        Iterator<COUIFloatingButtonLabel> it = this.mFloatingButtonLabelList.iterator();
        while (it.hasNext()) {
            it.next().setOrientation(0);
        }
        closeFloatingButtonMenu(false, 300);
        ArrayList<COUIFloatingButtonItem> actionItems = getActionItems();
        removeAllActionItems();
        addAllActionItems(actionItems);
    }

    private void setFloatingButtonPosition(COUIFloatingButtonLabel cOUIFloatingButtonLabel, int i10) {
        cOUIFloatingButtonLabel.setVisibility(0);
        cOUIFloatingButtonLabel.getChildFloatingButton().setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setState(int i10) {
        int i11 = this.mState;
        if (i11 != -1) {
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 == 4 && i10 == 1) {
                                this.mState = i10;
                            }
                        } else if (i10 == 2) {
                            this.mState = i10;
                        }
                    } else if (i10 == 4 || i10 == -1) {
                        this.mState = i10;
                    }
                } else if (i10 == 3 || i10 == -1 || i10 == 0) {
                    this.mState = i10;
                }
            } else if (i10 == -1 || i10 == 1) {
                this.mState = i10;
            }
        } else if (i10 == 0 || i10 == 1) {
            this.mState = i10;
        }
        if (i10 == this.mState) {
            return true;
        }
        return false;
    }

    private void toggle(boolean z10, boolean z11, int i10, boolean z12) {
        if (!this.mIsNeedElevation) {
            return;
        }
        if (z10 && this.mFloatingButtonLabelList.isEmpty()) {
            OnChangeListener onChangeListener = this.mOnChangeListener;
            if (onChangeListener != null) {
                onChangeListener.onMainActionSelected();
            }
            z10 = false;
        }
        if (isOpen() == z10) {
            return;
        }
        if (!isAnimationRunning()) {
            visibilitySetup(z10, z11, i10, z12);
            updateMainFabDrawable(z11, z12);
        }
        OnChangeListener onChangeListener2 = this.mOnChangeListener;
        if (onChangeListener2 != null) {
            onChangeListener2.onToggleChanged(z10);
        }
    }

    private void updateMainFabDrawable(boolean z10, boolean z11) {
        if (isOpen()) {
            rotateForward(this.mMainFloatingButton, 45.0f, z11);
            return;
        }
        rotateBackward(z11).start();
        Drawable drawable = this.mMainFabClosedDrawable;
        if (drawable != null) {
            this.mMainFloatingButton.setImageDrawable(drawable);
        }
    }

    private void updateMainFloatingButtonBackgroundColor() {
        int i10;
        int colorForState;
        ColorStateList mainFloatingButtonBackgroundColor = getMainFloatingButtonBackgroundColor();
        if (mainFloatingButtonBackgroundColor != null && mainFloatingButtonBackgroundColor != ColorStateList.valueOf(Integer.MIN_VALUE)) {
            Paint paint = this.mMainButtonShapeDrawable.getPaint();
            if (isEnabled()) {
                colorForState = mainFloatingButtonBackgroundColor.getDefaultColor();
            } else {
                colorForState = mainFloatingButtonBackgroundColor.getColorForState(DISABLED_STATE, this.mDisabledColor);
            }
            paint.setColor(colorForState);
            return;
        }
        Paint paint2 = this.mMainButtonShapeDrawable.getPaint();
        if (isEnabled()) {
            i10 = COUIContextUtil.getAttrColor(getContext(), X8.c.f4347F, 0);
        } else {
            i10 = this.mDisabledColor;
        }
        paint2.setColor(i10);
    }

    private void visibilitySetup(boolean z10, boolean z11, int i10, boolean z12) {
        int size = this.mFloatingButtonLabelList.size();
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                int i12 = (size - 1) - i11;
                COUIFloatingButtonLabel cOUIFloatingButtonLabel = this.mFloatingButtonLabelList.get(i12);
                if (this.mCurrentWindowHeight != 0) {
                    if (!isAllowLabelDisplay(i12)) {
                        cOUIFloatingButtonLabel.setVisibility(8);
                        if (z11) {
                            animationFloatingButtonMenuExpand(cOUIFloatingButtonLabel, i11 * 50, i12, 8);
                        }
                    } else {
                        cOUIFloatingButtonLabel.setVisibility(0);
                        if (z11) {
                            animationFloatingButtonMenuExpand(cOUIFloatingButtonLabel, i11 * 50, i12, 0);
                        }
                    }
                } else if (z11) {
                    animationFloatingButtonMenuExpand(cOUIFloatingButtonLabel, i11 * 50, i12, 0);
                }
            }
            this.mInstanceState.mCOUIFloatingButtonMenuIsOpen = true;
            return;
        }
        for (int i13 = 0; i13 < size; i13++) {
            COUIFloatingButtonLabel cOUIFloatingButtonLabel2 = this.mFloatingButtonLabelList.get(i13);
            if (z11) {
                animationFloatingButtonMenuClose(cOUIFloatingButtonLabel2, i13 * 50, i13, i10, z12);
            }
        }
        this.mMaskDrawable.setTouchEnterStateLocked(false, false, true);
        this.mInstanceState.mCOUIFloatingButtonMenuIsOpen = false;
    }

    public COUIFloatingButtonLabel addActionItem(COUIFloatingButtonItem cOUIFloatingButtonItem) {
        return addActionItem(cOUIFloatingButtonItem, this.mFloatingButtonLabelList.size());
    }

    public Collection<COUIFloatingButtonLabel> addAllActionItems(Collection<COUIFloatingButtonItem> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<COUIFloatingButtonItem> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(addActionItem(it.next()));
        }
        return arrayList;
    }

    public void animationFloatingButtonEnlarge() {
        K.d(this.mMainFloatingButton).c();
        cancelHideAnimator();
        this.mMainFloatingButton.setVisibility(0);
        this.mMainFloatingButton.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(DEFAULT_ENLARGE_ANIMATION_INTERPOLATOR).setDuration(DEFAULT_ENLARGE_ANIMATION_DURATION).setListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                cOUIFloatingButton.removeCallbacks(cOUIFloatingButton.mAutoDismissRunnable);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = true;
                COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                cOUIFloatingButton.removeCallbacks(cOUIFloatingButton.mAutoDismissRunnable);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    public ValueAnimator animationFloatingButtonShrink(Animator.AnimatorListener animatorListener) {
        K.d(this.mMainFloatingButton).c();
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(ANIMATION_TYPE_ALPHA, this.mMainFloatingButton.getAlpha(), 0.0f), PropertyValuesHolder.ofFloat(ANIMATION_TYPE_SCALE_X, this.mMainFloatingButton.getScaleX(), 0.6f), PropertyValuesHolder.ofFloat(ANIMATION_TYPE_SCALE_Y, this.mMainFloatingButton.getScaleY(), 0.6f));
        this.mHideAnimator = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setInterpolator(DEFAULT_ENLARGE_ANIMATION_INTERPOLATOR);
        this.mHideAnimator.setDuration(DEFAULT_ENLARGE_ANIMATION_DURATION);
        this.mHideAnimator.addListener(animatorListener);
        this.mHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue(COUIFloatingButton.ANIMATION_TYPE_ALPHA)).floatValue();
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue(COUIFloatingButton.ANIMATION_TYPE_SCALE_X)).floatValue();
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue(COUIFloatingButton.ANIMATION_TYPE_SCALE_Y)).floatValue();
                COUIFloatingButton.this.mMainFloatingButton.setAlpha(floatValue);
                COUIFloatingButton.this.mMainFloatingButton.setScaleX(floatValue2);
                COUIFloatingButton.this.mMainFloatingButton.setScaleY(floatValue3);
            }
        });
        return this.mHideAnimator;
    }

    @Deprecated
    public void animationFloatingButtonSlideIn(int i10) {
        animationFloatingButtonEnlarge();
    }

    @Deprecated
    public ValueAnimator animationFloatingButtonSlideOut() {
        return animationFloatingButtonShrink(new Animator.AnimatorListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                cOUIFloatingButton.removeCallbacks(cOUIFloatingButton.mAutoDismissRunnable);
                COUIFloatingButton.this.mMainFloatingButton.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIFloatingButton.this.mMainFloatingButton.setVisibility(0);
                COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = true;
                COUIFloatingButton cOUIFloatingButton = COUIFloatingButton.this;
                cOUIFloatingButton.postDelayed(cOUIFloatingButton.mAutoDismissRunnable, 5000L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    public void closeFloatingButtonMenu() {
        toggle(false, true, 300, false);
    }

    public ArrayList<COUIFloatingButtonItem> getActionItems() {
        ArrayList<COUIFloatingButtonItem> arrayList = new ArrayList<>(this.mFloatingButtonLabelList.size());
        Iterator<COUIFloatingButtonLabel> it = this.mFloatingButtonLabelList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFloatingButtonItem());
        }
        return arrayList;
    }

    public COUIFloatingButtonLabel getChildFloatingButtonWithPosition(int i10) {
        return findFloatingButtonItemByPosition(i10);
    }

    public AppCompatImageView getMainFloatingButton() {
        return this.mMainFloatingButton;
    }

    public ColorStateList getMainFloatingButtonBackgroundColor() {
        return this.mInstanceState.mMainCOUIFloatingButtonBackgroundColor;
    }

    public boolean hasFloatingButtonLabel() {
        if (this.mFloatingButtonLabelList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isAllowLabelDisplay(int i10) {
        if (i10 < 0 || i10 >= this.mFloatingButtonLabelList.size()) {
            return false;
        }
        if (getTotalLabelHeight(i10) + ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin + this.mMainFloatingButton.getHeight() > this.mCurrentWindowHeight + this.mCurrentWindowHeightOffset) {
            return false;
        }
        return true;
    }

    public boolean isAnimationRunning() {
        return this.mInstanceState.mCOUIFloatingButtonAnimationIsRun;
    }

    public boolean isFloatingButtonHasChildItem() {
        if (this.mFloatingButtonLabelList.size() != 0) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        return this.mInstanceState.mCOUIFloatingButtonMenuIsOpen;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mButtonSize <= 0) {
            Context createConfigurationContext = getContext().createConfigurationContext(configuration);
            if (COUIResponsiveUtils.isSmallScreenDp(configuration.screenWidthDp)) {
                this.mFloatingButtonPixel = createConfigurationContext.getResources().getDimensionPixelOffset(d.f6602y);
            } else {
                this.mFloatingButtonPixel = createConfigurationContext.getResources().getDimensionPixelOffset(d.f6600x);
            }
            ViewGroup.LayoutParams layoutParams = this.mMainFloatingButton.getLayoutParams();
            int i10 = this.mFloatingButtonPixel;
            layoutParams.width = i10;
            layoutParams.height = i10;
            this.mMainFloatingButton.setLayoutParams(layoutParams);
            RectF rectF = this.mMainButtonRect;
            int i11 = this.mFloatingButtonPixel;
            rectF.set(0.0f, 0.0f, i11, i11);
            COUIMaskEffectDrawable cOUIMaskEffectDrawable = this.mMaskDrawable;
            RectF rectF2 = this.mMainButtonRect;
            cOUIMaskEffectDrawable.setMaskRect(rectF2, rectF2.width() / 2.0f, this.mMainButtonRect.height() / 2.0f);
            COUIStrokeDrawable cOUIStrokeDrawable = this.mStrokeEffectDrawable;
            RectF rectF3 = this.mMainButtonRect;
            cOUIStrokeDrawable.setStrokeRect(rectF3, rectF3.width() / 2.0f, this.mMainButtonRect.height() / 2.0f);
        }
    }

    public void openFloatingButtonMenu() {
        toggle(true, true, 300, false);
    }

    public COUIFloatingButtonItem removeActionItem(int i10) {
        if (this.mFloatingButtonLabelList.size() <= i10) {
            COUILog.e(TAG, "The position cannot be greater than or equal to mFloatingButtonLabelList.size");
            return null;
        }
        COUIFloatingButtonItem floatingButtonItem = this.mFloatingButtonLabelList.get(i10).getFloatingButtonItem();
        removeActionItem(floatingButtonItem);
        return floatingButtonItem;
    }

    public COUIFloatingButtonItem removeActionItemByPosition(int i10) {
        return removeActionItem(findFloatingButtonItemByPosition(i10));
    }

    public void removeAllActionItems() {
        Iterator<COUIFloatingButtonLabel> it = this.mFloatingButtonLabelList.iterator();
        while (it.hasNext()) {
            removeActionItem(it.next(), it, true);
        }
    }

    public void removeFloatingButtonItemWithWindowHeight(int i10) {
        removeFloatingButtonItemWithWindowHeight(i10, 0);
    }

    public COUIFloatingButtonLabel replaceActionItem(COUIFloatingButtonItem cOUIFloatingButtonItem, int i10) {
        if (this.mFloatingButtonLabelList.isEmpty()) {
            return null;
        }
        return replaceActionItem(this.mFloatingButtonLabelList.get(i10).getFloatingButtonItem(), cOUIFloatingButtonItem);
    }

    public ObjectAnimator rotateBackward(boolean z10) {
        long j10;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mMainFloatingButton, ANIMATION_TYPE_ROTATION, this.mRotateAngle, 0.0f);
        ofFloat.setInterpolator(this.mRotateBackwardInterpolator);
        if (z10) {
            j10 = 250;
        } else {
            j10 = 300;
        }
        ofFloat.setDuration(j10);
        return ofFloat;
    }

    public void rotateForward(View view, float f10, boolean z10) {
        long j10;
        this.mRotateAngle = f10;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mMainFloatingButton, ANIMATION_TYPE_ROTATION, 0.0f, f10);
        ofFloat.setInterpolator(this.mRotateForwardInterpolator);
        if (z10) {
            j10 = 250;
        } else {
            j10 = 300;
        }
        ofFloat.setDuration(j10);
        ofFloat.start();
    }

    public void setAutoSlideInDisable() {
        Runnable runnable = this.mAutoDismissRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        getMainFloatingButton().setEnabled(z10);
        if (!z10) {
            this.mMainFloatingButton.setAlpha(0.3f);
            this.mStateBeforeDisable = this.mState;
            setState(-1);
        } else {
            this.mMainFloatingButton.setAlpha(1.0f);
            setState(this.mStateBeforeDisable);
        }
    }

    public void setFloatingButtonClickListener(OnFloatingButtonClickListener onFloatingButtonClickListener) {
        this.mFloatingButtonClickListener = onFloatingButtonClickListener;
    }

    public void setFloatingButtonExpandEnable(boolean z10) {
        if (z10) {
            this.mMainFloatingButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (COUIFloatingButton.this.isEnabled()) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            COUIFloatingButton.this.animatePress();
                            COUIFloatingButton.this.mStateEffectBackground.setTouched(true);
                        } else if (action == 1 || action == 3) {
                            COUIFloatingButton.this.animateNormal(motionEvent);
                            COUIFloatingButton.this.mStateEffectBackground.setTouched(false);
                        }
                    }
                    return false;
                }
            });
        }
        this.mMainFloatingButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIFloatingButton.this.mFloatingButtonClickListener != null) {
                    COUIFloatingButton.this.mFloatingButtonClickListener.onClick();
                }
                COUIFloatingButton.this.handleOnClickFloatingButton();
            }
        });
    }

    public void setIsFloatingButtonExpandEnable(boolean z10) {
        this.mIsFloatingButtonExpandEnable = z10;
        if (z10) {
            setState(1);
        } else {
            setState(0);
        }
    }

    public void setMainFabDrawable(Drawable drawable) {
        this.mMainFabClosedDrawable = drawable;
        updateMainFabDrawable(false, false);
    }

    public void setMainFloatingButtonBackgroundColor(ColorStateList colorStateList) {
        this.mInstanceState.mMainCOUIFloatingButtonBackgroundColor = colorStateList;
        updateMainFloatingButtonBackgroundColor();
    }

    public void setOnActionSelectedListener(OnActionSelectedListener onActionSelectedListener) {
        this.mOnActionSelectedListener = onActionSelectedListener;
        if (onActionSelectedListener != null) {
            this.mTempOnActionSelectedListener = onActionSelectedListener;
        }
        for (int i10 = 0; i10 < this.mFloatingButtonLabelList.size(); i10++) {
            this.mFloatingButtonLabelList.get(i10).setOnActionSelectedListener(this.mOnActionSelectedProxyListener);
        }
    }

    public void setOnChangeListener(OnChangeListener onChangeListener) {
        this.mOnChangeListener = onChangeListener;
    }

    public void setScaleAnimation(boolean z10) {
        this.mIsScaleAnimation = z10;
    }

    public void show() {
        animationFloatingButtonEnlarge();
    }

    /* loaded from: classes.dex */
    public static class COUIFloatingButtonBehavior extends CoordinatorLayout.Behavior<View> {
        private static final boolean AUTO_HIDE_DEFAULT = true;
        private boolean mAutoHideEnabled;
        private FloatingActionButton.b mInternalAutoHideListener;
        private Rect mTmpRect;

        public COUIFloatingButtonBehavior() {
            this.mAutoHideEnabled = true;
        }

        private int getMinimumHeightForVisibleOverlappingContent(AppBarLayout appBarLayout) {
            int x10 = K.x(appBarLayout);
            if (x10 != 0) {
                return x10 * 2;
            }
            int childCount = appBarLayout.getChildCount();
            if (childCount >= 1) {
                return K.x(appBarLayout.getChildAt(childCount - 1)) * 2;
            }
            return 0;
        }

        private static boolean isBottomSheet(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean shouldUpdateVisibility(View view, View view2) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) view2.getLayoutParams();
            if (!this.mAutoHideEnabled || eVar.e() != view.getId() || view2.getVisibility() != 0) {
                return false;
            }
            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!shouldUpdateVisibility(appBarLayout, view)) {
                return false;
            }
            if (this.mTmpRect == null) {
                this.mTmpRect = new Rect();
            }
            Rect rect = this.mTmpRect;
            ViewGroupUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= getMinimumHeightForVisibleOverlappingContent(appBarLayout)) {
                view.setVisibility(8);
                return true;
            }
            view.setVisibility(0);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(View view, View view2) {
            if (!shouldUpdateVisibility(view, view2)) {
                return false;
            }
            if (view.getTop() < (view2.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) view2.getLayoutParams())).topMargin) {
                hide(view2);
                return true;
            }
            show(view2);
            return true;
        }

        public void hide(View view) {
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).l(this.mInternalAutoHideListener);
            } else if (view instanceof COUIFloatingButton) {
                ((COUIFloatingButton) view).hide(this.mInternalAutoHideListener);
            } else {
                view.setVisibility(4);
            }
        }

        public boolean isAutoHideEnabled() {
            return this.mAutoHideEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            if (eVar.f9323h == 0) {
                eVar.f9323h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, view);
                return false;
            }
            if (isBottomSheet(view2)) {
                updateFabVisibilityForBottomSheet(view2, view);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            List<View> p10 = coordinatorLayout.p(view);
            int size = p10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view2 = p10.get(i11);
                if (view2 instanceof AppBarLayout) {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view2, view)) {
                        break;
                    }
                } else {
                    if (isBottomSheet(view2) && updateFabVisibilityForBottomSheet(view2, view)) {
                        break;
                    }
                }
            }
            coordinatorLayout.G(view, i10);
            return true;
        }

        public void setAutoHideEnabled(boolean z10) {
            this.mAutoHideEnabled = z10;
        }

        public void setInternalAutoHideListener(FloatingActionButton.b bVar) {
            this.mInternalAutoHideListener = bVar;
        }

        public void show(View view) {
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).r(this.mInternalAutoHideListener);
            } else if (view instanceof COUIFloatingButton) {
                view.setVisibility(0);
            } else {
                view.setVisibility(0);
            }
        }

        public COUIFloatingButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e4.m.f31191N3);
            this.mAutoHideEnabled = obtainStyledAttributes.getBoolean(e4.m.f31202O3, true);
            obtainStyledAttributes.recycle();
        }
    }

    public COUIFloatingButtonLabel addActionItem(COUIFloatingButtonItem cOUIFloatingButtonItem, int i10) {
        return addActionItem(cOUIFloatingButtonItem, i10, true);
    }

    public void closeFloatingButtonMenu(boolean z10) {
        toggle(false, true, 300, false);
    }

    public void openFloatingButtonMenu(boolean z10) {
        toggle(true, z10, 300, false);
    }

    public void removeFloatingButtonItemWithWindowHeight(int i10, int i11) {
        this.mCurrentWindowHeight = i10;
        this.mCurrentWindowHeightOffset = i11;
        int size = this.mFloatingButtonLabelList.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (isAllowLabelDisplay(i12)) {
                this.mFloatingButtonLabelList.get(i12).setVisibility(0);
            } else {
                this.mFloatingButtonLabelList.get(i12).setVisibility(8);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollViewBehavior extends COUIFloatingButtonBehavior {
        ValueAnimator mObjectAnimator;
        private boolean mOnScrollListenerIsAdd;

        public ScrollViewBehavior() {
            this.mObjectAnimator = new ObjectAnimator();
            this.mOnScrollListenerIsAdd = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void behaviorAnimate(COUIFloatingButton cOUIFloatingButton, int i10) {
            if (i10 > 10 && cOUIFloatingButton.getVisibility() == 0) {
                if (cOUIFloatingButton.isOpen() && !this.mObjectAnimator.isRunning()) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    ValueAnimator animationFloatingButtonSlideOut = cOUIFloatingButton.animationFloatingButtonSlideOut();
                    this.mObjectAnimator = animationFloatingButtonSlideOut;
                    animatorSet.playTogether(animationFloatingButtonSlideOut, cOUIFloatingButton.rotateBackward(true));
                    animatorSet.setDuration(150L);
                    cOUIFloatingButton.closeFloatingButtonMenu(true, 250, true);
                    animatorSet.start();
                    return;
                }
                if (!this.mObjectAnimator.isRunning()) {
                    ValueAnimator animationFloatingButtonSlideOut2 = cOUIFloatingButton.animationFloatingButtonSlideOut();
                    this.mObjectAnimator = animationFloatingButtonSlideOut2;
                    animationFloatingButtonSlideOut2.start();
                    return;
                }
                return;
            }
            if (i10 < -10) {
                cOUIFloatingButton.animationFloatingButtonEnlarge();
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
            super.onNestedPreScroll(coordinatorLayout, view, view2, i10, i11, iArr, i12);
            if (view instanceof COUIFloatingButton) {
                behaviorAnimate((COUIFloatingButton) view, i11);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, final View view, View view2, View view3, int i10, int i11) {
            if (view3 instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view3;
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (recyclerView.getChildCount() != 0 && itemCount != 0 && !this.mOnScrollListenerIsAdd) {
                    recyclerView.addOnScrollListener(new RecyclerView.s() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.ScrollViewBehavior.1
                        @Override // androidx.recyclerview.widget.RecyclerView.s
                        public void onScrollStateChanged(RecyclerView recyclerView2, int i12) {
                            super.onScrollStateChanged(recyclerView2, i12);
                        }

                        @Override // androidx.recyclerview.widget.RecyclerView.s
                        public void onScrolled(RecyclerView recyclerView2, int i12, int i13) {
                            super.onScrolled(recyclerView2, i12, i13);
                            View view4 = view;
                            if (view4 instanceof COUIFloatingButton) {
                                ScrollViewBehavior.this.behaviorAnimate((COUIFloatingButton) view4, i13);
                            }
                        }
                    });
                    this.mOnScrollListenerIsAdd = true;
                }
                return false;
            }
            if (view3 instanceof AbsListView) {
                AbsListView absListView = (AbsListView) view3;
                int count = absListView.getCount();
                int childCount = absListView.getChildCount();
                View childAt = absListView.getChildAt(0);
                int top = view3.getTop() - view3.getPaddingTop();
                int bottom = view3.getBottom() - view3.getPaddingBottom();
                View childAt2 = absListView.getChildAt(childCount - 1);
                if (childCount > 0 && count > 0) {
                    if (absListView.getFirstVisiblePosition() == 0 && childAt.getTop() >= (-top)) {
                        return false;
                    }
                    if (childAt2 != null && absListView.getLastVisiblePosition() == count - 1 && childAt2.getBottom() <= bottom) {
                        return false;
                    }
                }
            }
            return true;
        }

        public ScrollViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mObjectAnimator = new ObjectAnimator();
            this.mOnScrollListenerIsAdd = false;
        }
    }

    public COUIFloatingButtonLabel addActionItem(COUIFloatingButtonItem cOUIFloatingButtonItem, int i10, boolean z10) {
        return addActionItem(cOUIFloatingButtonItem, i10, z10, 0);
    }

    public void closeFloatingButtonMenu(boolean z10, int i10) {
        toggle(false, z10, i10, false);
    }

    public void openFloatingButtonMenu(boolean z10, int i10) {
        toggle(true, z10, i10, false);
    }

    public COUIFloatingButtonLabel replaceActionItem(COUIFloatingButtonItem cOUIFloatingButtonItem, COUIFloatingButtonItem cOUIFloatingButtonItem2) {
        COUIFloatingButtonLabel findFloatingButtonItemByPosition;
        int indexOf;
        if (cOUIFloatingButtonItem == null || (findFloatingButtonItemByPosition = findFloatingButtonItemByPosition(cOUIFloatingButtonItem.getFloatingButtonItemLocation())) == null || (indexOf = this.mFloatingButtonLabelList.indexOf(findFloatingButtonItemByPosition)) < 0) {
            return null;
        }
        int visibility = findFloatingButtonItemByPosition.getVisibility();
        removeActionItem(findFloatingButtonItemByPosition(cOUIFloatingButtonItem2.getFloatingButtonItemLocation()), null, false);
        removeActionItem(findFloatingButtonItemByPosition(cOUIFloatingButtonItem.getFloatingButtonItemLocation()), null, false);
        return addActionItem(cOUIFloatingButtonItem2, indexOf, false, visibility);
    }

    public COUIFloatingButtonLabel addActionItem(COUIFloatingButtonItem cOUIFloatingButtonItem, int i10, boolean z10, int i11) {
        COUIFloatingButtonLabel findFloatingButtonItemByPosition = findFloatingButtonItemByPosition(cOUIFloatingButtonItem.getFloatingButtonItemLocation());
        if (findFloatingButtonItemByPosition != null) {
            return replaceActionItem(findFloatingButtonItemByPosition.getFloatingButtonItem(), cOUIFloatingButtonItem);
        }
        COUIFloatingButtonLabel createFabWithLabelView = cOUIFloatingButtonItem.createFabWithLabelView(getContext());
        createFabWithLabelView.setMainButtonSize(this.mButtonSize);
        createFabWithLabelView.setOrientation(getOrientation() == 1 ? 0 : 1);
        createFabWithLabelView.setOnActionSelectedListener(this.mOnActionSelectedProxyListener);
        createFabWithLabelView.setVisibility(i11);
        int layoutPosition = getLayoutPosition(i10);
        if (i10 == 0) {
            createFabWithLabelView.setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), getResources().getDimensionPixelSize(d.f6594u));
            addView(createFabWithLabelView, layoutPosition);
        } else {
            createFabWithLabelView.setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), getResources().getDimensionPixelSize(d.f6596v));
            addView(createFabWithLabelView, layoutPosition);
        }
        this.mFloatingButtonLabelList.add(i10, createFabWithLabelView);
        animationFloatingButtonMenuClose(createFabWithLabelView, 0, i10, 300, false);
        return createFabWithLabelView;
    }

    public void closeFloatingButtonMenu(boolean z10, int i10, boolean z11) {
        toggle(false, z10, i10, z11);
    }

    public void hide() {
        animationFloatingButtonShrink(new Animator.AnimatorListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIFloatingButton.this.mMainFloatingButton.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIFloatingButton.this.mMainFloatingButton.setVisibility(8);
                COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIFloatingButton.this.mInstanceState.mCOUIFloatingButtonAnimationIsRun = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }).start();
    }

    public boolean removeActionItem(COUIFloatingButtonItem cOUIFloatingButtonItem) {
        return (cOUIFloatingButtonItem == null || removeActionItemByPosition(cOUIFloatingButtonItem.getFloatingButtonItemLocation()) == null) ? false : true;
    }

    /* loaded from: classes.dex */
    public static class InstanceState implements Parcelable {
        public static final Parcelable.Creator<InstanceState> CREATOR = new Parcelable.Creator<InstanceState>() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.InstanceState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public InstanceState createFromParcel(Parcel parcel) {
                return new InstanceState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public InstanceState[] newArray(int i10) {
                return new InstanceState[i10];
            }
        };
        private boolean mCOUIFloatingButtonAnimationIsRun;
        private ArrayList<COUIFloatingButtonItem> mCOUIFloatingButtonItems;
        private boolean mCOUIFloatingButtonMenuIsOpen;
        private ColorStateList mMainCOUIFloatingButtonBackgroundColor;
        private boolean mUseReverseAnimationOnClose;

        public InstanceState() {
            this.mCOUIFloatingButtonMenuIsOpen = false;
            this.mCOUIFloatingButtonAnimationIsRun = false;
            this.mMainCOUIFloatingButtonBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mUseReverseAnimationOnClose = false;
            this.mCOUIFloatingButtonItems = new ArrayList<>();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeByte(this.mCOUIFloatingButtonMenuIsOpen ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.mCOUIFloatingButtonAnimationIsRun ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.mUseReverseAnimationOnClose ? (byte) 1 : (byte) 0);
            parcel.writeTypedList(this.mCOUIFloatingButtonItems);
        }

        public InstanceState(Parcel parcel) {
            this.mCOUIFloatingButtonMenuIsOpen = false;
            this.mCOUIFloatingButtonAnimationIsRun = false;
            this.mMainCOUIFloatingButtonBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mUseReverseAnimationOnClose = false;
            this.mCOUIFloatingButtonItems = new ArrayList<>();
            this.mCOUIFloatingButtonMenuIsOpen = parcel.readByte() != 0;
            this.mCOUIFloatingButtonAnimationIsRun = parcel.readByte() != 0;
            this.mUseReverseAnimationOnClose = parcel.readByte() != 0;
            this.mCOUIFloatingButtonItems = parcel.createTypedArrayList(COUIFloatingButtonItem.CREATOR);
        }
    }

    private COUIFloatingButtonItem removeActionItem(COUIFloatingButtonLabel cOUIFloatingButtonLabel, Iterator<COUIFloatingButtonLabel> it, boolean z10) {
        if (cOUIFloatingButtonLabel == null) {
            return null;
        }
        COUIFloatingButtonItem floatingButtonItem = cOUIFloatingButtonLabel.getFloatingButtonItem();
        if (it != null) {
            it.remove();
        } else {
            this.mFloatingButtonLabelList.remove(cOUIFloatingButtonLabel);
        }
        removeView(cOUIFloatingButtonLabel);
        return floatingButtonItem;
    }

    private COUIFloatingButtonItem removeActionItem(COUIFloatingButtonLabel cOUIFloatingButtonLabel) {
        return removeActionItem(cOUIFloatingButtonLabel, null, true);
    }

    public COUIFloatingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMainButtonRect = new RectF();
        this.mMainButtonGlobalRect = new Rect();
        this.mState = 0;
        this.mStateBeforeDisable = 0;
        this.mCurrentProgress = 1.0f;
        this.mInstanceState = new InstanceState();
        this.mFloatingButtonLabelList = new ArrayList();
        this.mMainFabClosedDrawable = null;
        this.mExpandMenuAnimationInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mCloseMenuPathInterpolator = new COUIMoveEaseInterpolator();
        this.mLabelPathInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mCloseMenuLabelPathInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mRotateForwardInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mRotateBackwardInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mIsNeedElevation = true;
        this.mIsNeedVibrate = true;
        this.mIsScaleAnimation = true;
        this.mProgressAnimator = null;
        this.mOnActionSelectedProxyListener = new OnActionSelectedListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.1
            @Override // com.coui.appcompat.floatingactionbutton.COUIFloatingButton.OnActionSelectedListener
            public boolean onActionSelected(COUIFloatingButtonItem cOUIFloatingButtonItem) {
                if (COUIFloatingButton.this.mOnActionSelectedListener == null) {
                    return false;
                }
                boolean onActionSelected = COUIFloatingButton.this.mOnActionSelectedListener.onActionSelected(cOUIFloatingButtonItem);
                if (!onActionSelected) {
                    COUIFloatingButton.this.closeFloatingButtonMenu(false, 300);
                }
                return onActionSelected;
            }
        };
        init(context, attributeSet);
    }

    public COUIFloatingButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMainButtonRect = new RectF();
        this.mMainButtonGlobalRect = new Rect();
        this.mState = 0;
        this.mStateBeforeDisable = 0;
        this.mCurrentProgress = 1.0f;
        this.mInstanceState = new InstanceState();
        this.mFloatingButtonLabelList = new ArrayList();
        this.mMainFabClosedDrawable = null;
        this.mExpandMenuAnimationInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mCloseMenuPathInterpolator = new COUIMoveEaseInterpolator();
        this.mLabelPathInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mCloseMenuLabelPathInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mRotateForwardInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mRotateBackwardInterpolator = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        this.mIsNeedElevation = true;
        this.mIsNeedVibrate = true;
        this.mIsScaleAnimation = true;
        this.mProgressAnimator = null;
        this.mOnActionSelectedProxyListener = new OnActionSelectedListener() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButton.1
            @Override // com.coui.appcompat.floatingactionbutton.COUIFloatingButton.OnActionSelectedListener
            public boolean onActionSelected(COUIFloatingButtonItem cOUIFloatingButtonItem) {
                if (COUIFloatingButton.this.mOnActionSelectedListener == null) {
                    return false;
                }
                boolean onActionSelected = COUIFloatingButton.this.mOnActionSelectedListener.onActionSelected(cOUIFloatingButtonItem);
                if (!onActionSelected) {
                    COUIFloatingButton.this.closeFloatingButtonMenu(false, 300);
                }
                return onActionSelected;
            }
        };
        init(context, attributeSet);
    }
}
