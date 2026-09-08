package com.coui.appcompat.panel;

import X8.h;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.D;
import c9.C0570b;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.buttonBar.COUIButtonBarLayout;
import com.coui.appcompat.uiutil.UIUtil;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class COUIPanelAdjustResizeHelperBeforeR extends COUIAbsPanelAdjustResizeHelper {
    private static final float DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT = 50.0f;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 200.0f;
    private static final int IME_ADJUST = 1;
    private static final int IME_HIDE = 2;
    private static final int IME_SHOW = 0;
    private static final float SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT = 120.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 300.0f;
    private ValueAnimator mBottomButtonBarAnim;
    private int mMarginBottomValue;
    private ValueAnimator mPaddingBottomAnim;
    private WeakReference<View> mPaddingBottomAnimView;
    private int mPaddingBottomOffset;
    private float mTranslateOffset;
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR = new COUIInEaseInterpolator();
    private static final Interpolator DISMISS_HEIGHT_ANIM_INTERPOLATOR = new LinearInterpolator();
    private int mWindowType = 2;
    private int mAdjustResizeType = 2;
    private int mAdjustKeyboardStartHeight = 0;
    private int mAdjustKeyboardHeight = 0;
    private int mAdjustKeyboardOffset = 0;
    private int mFocusViewRawY = 0;
    private boolean mIsIgnoreHideKeyboardAnim = true;
    private boolean mIsKeyboardShow = false;
    private boolean mIsFocusViewDisplayInVerticalScrolledView = false;
    private View mFocusVerticalScrolledView = null;

    private void adjustResizeBeforeR(ViewGroup viewGroup, boolean z10, int i10) {
        updateAdjustKeyboardType(z10);
        updateAdjustKeyboardData(viewGroup, i10);
        updateAdjustKeyboardOffset(viewGroup, Boolean.valueOf(z10));
        doAdjustKeyboardAnim(viewGroup, z10);
        this.mIsIgnoreHideKeyboardAnim = false;
    }

    private void doAdjustKeyboardAnim(ViewGroup viewGroup, boolean z10) {
        float abs;
        float abs2;
        if (viewGroup != null && this.mPaddingBottomAnimView != null) {
            if (viewGroup instanceof COUIPanelContentLayout) {
                COUIPanelContentLayout cOUIPanelContentLayout = (COUIPanelContentLayout) viewGroup;
                int maxHeight = cOUIPanelContentLayout.getMaxHeight();
                if (z10) {
                    abs2 = Math.abs((this.mAdjustKeyboardOffset * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT) / maxHeight) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
                } else {
                    abs2 = Math.abs((this.mAdjustKeyboardOffset * 50.0f) / maxHeight) + 200.0f;
                }
                long j10 = abs2;
                doPaddingBottomAnim(this.mPaddingBottomAnimView.get(), this.mPaddingBottomOffset, j10);
                doBottomButtonTranslateAnim(cOUIPanelContentLayout, this.mTranslateOffset, j10);
                return;
            }
            int screenHeightRealSize = UIUtil.getScreenHeightRealSize(viewGroup.getContext());
            if (z10) {
                abs = Math.abs((this.mAdjustKeyboardOffset * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT) / screenHeightRealSize) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
            } else {
                abs = Math.abs((this.mAdjustKeyboardOffset * 50.0f) / screenHeightRealSize) + 200.0f;
            }
            doMarginBottomAnim(viewGroup, this.mMarginBottomValue, abs);
        }
    }

    private void doBottomButtonTranslateAnim(final COUIPanelContentLayout cOUIPanelContentLayout, float f10, long j10) {
        if (f10 != 0.0f && cOUIPanelContentLayout != null && cOUIPanelContentLayout.getBtnBarLayout() != null) {
            float translationY = cOUIPanelContentLayout.getBtnBarLayout().getTranslationY();
            final float min = Math.min(0.0f, f10 + translationY);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(translationY, min);
            this.mBottomButtonBarAnim = ofFloat;
            ofFloat.setDuration(j10);
            if (translationY < min) {
                this.mBottomButtonBarAnim.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR);
            } else {
                this.mBottomButtonBarAnim.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR);
            }
            this.mBottomButtonBarAnim.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    cOUIPanelContentLayout.getBtnBarLayout().setTranslationY(min);
                    cOUIPanelContentLayout.getDivider().setTranslationY(min);
                }
            });
            this.mBottomButtonBarAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (cOUIPanelContentLayout.isAttachedToWindow()) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        cOUIPanelContentLayout.getBtnBarLayout().setTranslationY(floatValue);
                        cOUIPanelContentLayout.getDivider().setTranslationY(floatValue);
                    }
                }
            });
            this.mBottomButtonBarAnim.start();
        }
    }

    private void doMarginBottomAnim(final View view, int i10, long j10) {
        if (i10 != 0 && view != null) {
            int max = Math.max(0, COUIViewMarginUtil.getMargin(view, 3));
            final int max2 = Math.max(0, i10 + max);
            ValueAnimator ofInt = ValueAnimator.ofInt(max, max2);
            ofInt.setDuration(j10);
            if (max < max2) {
                ofInt.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR);
            } else {
                ofInt.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR);
            }
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    COUIViewMarginUtil.setMargin(view, max2, 3);
                }
            });
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (view.isAttachedToWindow()) {
                        COUIViewMarginUtil.setMargin(view, ((Integer) valueAnimator.getAnimatedValue()).intValue(), 3);
                    }
                }
            });
            ofInt.start();
        }
    }

    private void doPaddingBottomAnim(final View view, int i10, long j10) {
        if (i10 != 0 && view != null) {
            final int paddingLeft = view.getPaddingLeft();
            final int paddingRight = view.getPaddingRight();
            final int paddingTop = view.getPaddingTop();
            int max = Math.max(0, view.getPaddingBottom());
            final int max2 = Math.max(0, i10 + max);
            ValueAnimator ofInt = ValueAnimator.ofInt(max, max2);
            this.mPaddingBottomAnim = ofInt;
            ofInt.setDuration(j10);
            if (max < max2) {
                this.mPaddingBottomAnim.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR);
            } else {
                this.mPaddingBottomAnim.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR);
            }
            this.mPaddingBottomAnim.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setPadding(paddingLeft, paddingTop, paddingRight, max2);
                }
            });
            this.mPaddingBottomAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (view.isAttachedToWindow()) {
                        view.setPadding(paddingLeft, paddingTop, paddingRight, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            this.mPaddingBottomAnim.start();
        }
    }

    private void findFocusView(ViewGroup viewGroup) {
        View findFocus;
        if (viewGroup != null && (findFocus = viewGroup.findFocus()) != null) {
            this.mFocusViewRawY = 0;
            this.mIsFocusViewDisplayInVerticalScrolledView = false;
            this.mFocusVerticalScrolledView = null;
            if (isScrollable(findFocus)) {
                this.mIsFocusViewDisplayInVerticalScrolledView = true;
                this.mFocusVerticalScrolledView = findFocus;
            }
            this.mFocusViewRawY = getMeasureHeight(findFocus) + findFocus.getTop() + COUIViewMarginUtil.getMargin(findFocus, 3);
            for (View view = (View) findFocus.getParent(); view != null && view != viewGroup.getParent(); view = (View) view.getParent()) {
                if (isScrollable(view)) {
                    this.mIsFocusViewDisplayInVerticalScrolledView = true;
                    this.mFocusVerticalScrolledView = view;
                }
                this.mFocusViewRawY += view.getTop();
            }
        }
    }

    private int getKeyboardHeightBeforeR(int i10, int i11) {
        if (this.mWindowType == 2038) {
            return i10;
        }
        return i10 - i11;
    }

    private int getMeasureHeight(View view) {
        if (view == null || view.getVisibility() == 8) {
            return 0;
        }
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight == 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            return view.getMeasuredHeight();
        }
        return measuredHeight;
    }

    private boolean isScrollable(View view) {
        if (!(view instanceof ScrollView) && !(view instanceof AbsListView) && !(view instanceof D)) {
            return false;
        }
        return true;
    }

    private boolean updateAdjustKeyboardData(ViewGroup viewGroup, int i10) {
        int i11;
        if (viewGroup == null) {
            return false;
        }
        releaseData();
        if (viewGroup instanceof COUIPanelContentLayout) {
            COUIPanelContentLayout cOUIPanelContentLayout = (COUIPanelContentLayout) viewGroup;
            int maxHeight = cOUIPanelContentLayout.getMaxHeight();
            if (cOUIPanelContentLayout.getLayoutAtMaxHeight()) {
                i11 = 1073741824;
            } else {
                i11 = Integer.MIN_VALUE;
            }
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(maxHeight, i11));
            findFocusView(viewGroup);
        }
        int measuredHeight = viewGroup.getMeasuredHeight();
        this.mAdjustKeyboardStartHeight = measuredHeight;
        int i12 = this.mAdjustResizeType;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2 && !this.mIsIgnoreHideKeyboardAnim) {
                    this.mAdjustKeyboardHeight = i10;
                    this.mAdjustKeyboardOffset = i10;
                }
            } else {
                this.mAdjustKeyboardStartHeight = measuredHeight - i10;
                this.mAdjustKeyboardOffset = i10 - this.mAdjustKeyboardHeight;
                this.mAdjustKeyboardHeight = i10;
            }
        } else {
            this.mAdjustKeyboardHeight = i10;
            this.mAdjustKeyboardOffset = i10;
        }
        return true;
    }

    private void updateAdjustKeyboardOffset(ViewGroup viewGroup, Boolean bool) {
        this.mPaddingBottomAnimView = null;
        this.mPaddingBottomOffset = 0;
        this.mTranslateOffset = 0.0f;
        this.mMarginBottomValue = 0;
        if (viewGroup != null && this.mAdjustKeyboardOffset != 0) {
            if (viewGroup instanceof COUIPanelContentLayout) {
                updateOffsetInConstraintLayout((COUIPanelContentLayout) viewGroup, bool);
            } else {
                updateOffsetInNormalLayout(viewGroup, bool);
            }
        }
    }

    private void updateAdjustKeyboardType(boolean z10) {
        this.mAdjustResizeType = 2;
        boolean z11 = this.mIsKeyboardShow;
        if (!z11 && z10) {
            this.mAdjustResizeType = 0;
        } else if (z11 && z10) {
            this.mAdjustResizeType = 1;
        }
        this.mIsKeyboardShow = z10;
    }

    private void updateOffsetInConstraintLayout(COUIPanelContentLayout cOUIPanelContentLayout, Boolean bool) {
        int i10;
        float f10;
        int i11;
        int i12;
        float f11;
        if (this.mAdjustResizeType == 2) {
            i10 = -1;
        } else {
            i10 = 1;
        }
        int maxHeight = cOUIPanelContentLayout.getMaxHeight();
        int i13 = this.mAdjustKeyboardOffset * i10;
        if (cOUIPanelContentLayout.getBtnBarLayout() != null) {
            f10 = cOUIPanelContentLayout.getBtnBarLayout().getTranslationY();
        } else {
            f10 = 0.0f;
        }
        this.mPaddingBottomAnimView = new WeakReference<>(cOUIPanelContentLayout);
        if ((this.mIsFocusViewDisplayInVerticalScrolledView && maxHeight != 0) || (!COUIPanelMultiWindowUtils.isPortrait(cOUIPanelContentLayout.getContext()) && f10 == 0.0f)) {
            View view = this.mFocusVerticalScrolledView;
            if (view != null) {
                View view2 = (View) view.getParent();
                if (view2 != null) {
                    this.mPaddingBottomAnimView = new WeakReference<>(view2);
                }
                this.mTranslateOffset = -i13;
            }
            this.mPaddingBottomOffset = i13;
            return;
        }
        int i14 = this.mAdjustKeyboardStartHeight - this.mFocusViewRawY;
        int paddingBottom = cOUIPanelContentLayout.getPaddingBottom();
        if (cOUIPanelContentLayout.getBtnBarLayout() != null) {
            i11 = cOUIPanelContentLayout.getBtnBarLayout().getHeight();
        } else {
            i11 = 0;
        }
        if (cOUIPanelContentLayout.getDivider() != null) {
            i12 = cOUIPanelContentLayout.getDivider().getHeight();
        } else {
            i12 = 0;
        }
        int i15 = this.mAdjustResizeType;
        if (i15 == 1) {
            i14 += this.mAdjustKeyboardHeight;
        } else if (i15 == 2) {
            i14 -= this.mAdjustKeyboardHeight;
        }
        int i16 = this.mAdjustKeyboardHeight;
        if (i14 >= i16 + i11 + i12 && paddingBottom == 0) {
            this.mTranslateOffset = -i13;
            return;
        }
        int i17 = ((i16 + i11) + i12) - i14;
        int i18 = i10 * i17;
        this.mPaddingBottomOffset = Math.max(-paddingBottom, i18);
        if (this.mAdjustResizeType == 1) {
            int max = Math.max(0, paddingBottom + i18);
            int i19 = this.mAdjustKeyboardHeight;
            this.mTranslateOffset = (-Math.min(i19, Math.max(-i19, i19 - max))) - f10;
        } else {
            if (bool.booleanValue()) {
                f11 = -(i13 - i17);
            } else {
                f11 = -f10;
            }
            this.mTranslateOffset = f11;
        }
    }

    private void updateOffsetInNormalLayout(ViewGroup viewGroup, Boolean bool) {
        int i10;
        if (this.mAdjustResizeType == 2) {
            i10 = -1;
        } else {
            i10 = 1;
        }
        int i11 = i10 * this.mAdjustKeyboardOffset;
        this.mPaddingBottomAnimView = new WeakReference<>(viewGroup);
        this.mMarginBottomValue = i11;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void adjustResize(Context context, ViewGroup viewGroup, WindowInsets windowInsets, View view, boolean z10) {
        int i10;
        if (viewGroup == null) {
            return;
        }
        boolean z11 = context.getResources().getBoolean(C0570b.f12871c);
        boolean z12 = false;
        if (COUINavigationBarUtil.isNavigationBarShow(context) && !z11) {
            i10 = COUINavigationBarUtil.getNavigationBarHeight(context);
        } else {
            i10 = 0;
        }
        int keyboardHeightBeforeR = getKeyboardHeightBeforeR(windowInsets.getSystemWindowInsetBottom(), i10);
        if (keyboardHeightBeforeR > 0) {
            adjustResizeBeforeR(viewGroup, true, keyboardHeightBeforeR);
            return;
        }
        if (this.mAdjustResizeType != 2) {
            adjustResizeBeforeR(viewGroup, false, this.mAdjustKeyboardHeight);
        }
        View findViewById = view.findViewById(h.f4897N);
        if (findViewById instanceof COUIPanelPercentFrameLayout) {
            z12 = ((COUIPanelPercentFrameLayout) findViewById).isIsHandlePanel();
        }
        int panelMarginBottom = COUIPanelMultiWindowUtils.getPanelMarginBottom(viewGroup.getContext(), viewGroup.getContext().getResources().getConfiguration(), windowInsets, z12);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = panelMarginBottom;
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getMarginBottomValue() {
        return this.mMarginBottomValue;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getPaddingBottomOffset() {
        return this.mPaddingBottomOffset;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public float getTranslateOffset() {
        return this.mTranslateOffset;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getWindowType() {
        return this.mWindowType;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void recoveryScrollingParentViewPaddingBottom(COUIPanelContentLayout cOUIPanelContentLayout) {
        if (cOUIPanelContentLayout != null) {
            COUIButtonBarLayout btnBarLayout = cOUIPanelContentLayout.getBtnBarLayout();
            View divider = cOUIPanelContentLayout.getDivider();
            if (btnBarLayout != null) {
                btnBarLayout.setTranslationY(0.0f);
            }
            if (divider != null) {
                divider.setTranslationY(0.0f);
            }
            cOUIPanelContentLayout.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public boolean releaseData() {
        ValueAnimator valueAnimator = this.mPaddingBottomAnim;
        boolean z10 = false;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.mPaddingBottomAnim.cancel();
                z10 = true;
            }
            this.mPaddingBottomAnim = null;
        }
        ValueAnimator valueAnimator2 = this.mBottomButtonBarAnim;
        if (valueAnimator2 != null) {
            if (valueAnimator2.isRunning()) {
                this.mBottomButtonBarAnim.cancel();
            }
            this.mBottomButtonBarAnim = null;
        }
        return z10;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void resetInnerStatus() {
        this.mAdjustKeyboardHeight = 0;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void setIgnoreHideKeyboardAnim(boolean z10) {
        this.mIsIgnoreHideKeyboardAnim = z10;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void setWindowType(int i10) {
        this.mWindowType = i10;
    }
}
