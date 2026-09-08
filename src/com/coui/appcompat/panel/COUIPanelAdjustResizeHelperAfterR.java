package com.coui.appcompat.panel;

import X8.h;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import c9.C0574f;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.COUIOutEaseInterpolator;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIPanelAdjustResizeHelperAfterR extends COUIAbsPanelAdjustResizeHelper {
    private static final float DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT = 133.0f;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE = 117.0f;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 200.0f;
    private static final long PANEL_ALPHA_ANIM_DURATION = 250;
    private static final float SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT = 132.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE = 150.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 300.0f;
    private static final String TAG = "AdjustResizeAfterR";
    private boolean mIsPanelAlphaRun;
    private int mWindowType = 2;
    private ValueAnimator marginBottomAnim;
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR = new COUIInEaseInterpolator();
    private static final Interpolator DISMISS_HEIGHT_ANIM_INTERPOLATOR = new COUIOutEaseInterpolator();
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE = new COUIInEaseInterpolator();
    private static final Interpolator DISMISS_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE = new COUIOutEaseInterpolator();

    private ValueAnimator createPanelAlphaAnimation(final View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperAfterR.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view != null) {
                    view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (!COUIPanelAdjustResizeHelperAfterR.this.mIsPanelAlphaRun) {
                        COUIPanelAdjustResizeHelperAfterR.this.mIsPanelAlphaRun = true;
                    }
                }
            }
        });
        return ofFloat;
    }

    private void doMarginBottomAnim(final View view, final int i10, boolean z10, final int i11, View view2, int i12) {
        float abs;
        final View findViewById = view.findViewById(C0574f.f12911e);
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int max = Math.max(0, i11 + i12);
        int max2 = Math.max(0, i12);
        int screenHeightRealSize = UIUtil.getScreenHeightRealSize(view.getContext());
        this.marginBottomAnim = ValueAnimator.ofInt(max2, max);
        if (COUIPanelMultiWindowUtils.isLargeHeightScreen(view.getContext(), null)) {
            if (z10) {
                abs = Math.abs((i10 * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE) / screenHeightRealSize) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
                this.marginBottomAnim.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE);
            } else {
                abs = Math.abs((i10 * DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE) / screenHeightRealSize) + 200.0f;
                this.marginBottomAnim.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE);
            }
        } else if (z10) {
            abs = Math.abs((i10 * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT) / screenHeightRealSize) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
            this.marginBottomAnim.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR);
        } else {
            abs = Math.abs((i10 * DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT) / screenHeightRealSize) + 200.0f;
            this.marginBottomAnim.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR);
        }
        this.marginBottomAnim.setDuration(abs);
        int i13 = h.f4897N;
        ValueAnimator createPanelAlphaAnimation = createPanelAlphaAnimation(view2.findViewById(i13));
        createPanelAlphaAnimation.setDuration(PANEL_ALPHA_ANIM_DURATION);
        createPanelAlphaAnimation.setInterpolator(this.marginBottomAnim.getInterpolator());
        this.marginBottomAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperAfterR.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i14;
                View view3;
                if (view.isAttachedToWindow()) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (i11 > 0 && intValue >= (i14 = i10) && (view3 = findViewById) != null) {
                        view3.setPadding(0, 0, 0, Math.max(intValue - i14, 0));
                        intValue = i14;
                    }
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = intValue;
                        view.setLayoutParams(layoutParams2);
                    }
                }
            }
        });
        this.marginBottomAnim.start();
        if (!z10) {
            this.mIsPanelAlphaRun = false;
        }
        if (z10 && !this.mIsPanelAlphaRun && view2.findViewById(i13).getAlpha() == 0.0f) {
            createPanelAlphaAnimation.start();
        }
    }

    private void setMarginBottomTo(View view, int i10, WindowInsets windowInsets, View view2) {
        boolean z10;
        int i11;
        boolean z11;
        int i12;
        if (view != null) {
            View findViewById = view2.findViewById(C0574f.f12911e);
            int measuredHeight = view2.getMeasuredHeight();
            int measuredHeight2 = view.getMeasuredHeight();
            if (i10 > measuredHeight * 0.9f) {
                Log.e(TAG, "KeyboardHeight > availableHeight * 0.9f, so not elevated");
                return;
            }
            Context context = view.getContext();
            View findViewById2 = view2.findViewById(h.f4897N);
            if (findViewById2 instanceof COUIPanelPercentFrameLayout) {
                z10 = ((COUIPanelPercentFrameLayout) findViewById2).isIsHandlePanel();
            } else {
                z10 = false;
            }
            int panelMarginBottom = COUIPanelMultiWindowUtils.getPanelMarginBottom(context, context.getResources().getConfiguration(), windowInsets, z10);
            if (measuredHeight > 0 && measuredHeight2 > 0 && (i12 = measuredHeight2 + panelMarginBottom + i10) > measuredHeight) {
                i11 = i10 - (i12 - measuredHeight);
            } else {
                i11 = i10;
            }
            int i13 = i10 - panelMarginBottom;
            ValueAnimator valueAnimator = this.marginBottomAnim;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.marginBottomAnim.cancel();
            }
            if (i10 == 0) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = panelMarginBottom;
                    view.setLayoutParams(layoutParams);
                }
                if (findViewById != null) {
                    findViewById.setPadding(0, 0, 0, 0);
                    return;
                }
                return;
            }
            if (windowInsets.getInsets(WindowInsets.Type.ime()).bottom != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            doMarginBottomAnim(view, i11, z11, i13, view2, panelMarginBottom);
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void adjustResize(Context context, ViewGroup viewGroup, WindowInsets windowInsets, View view, boolean z10) {
        int i10 = 0;
        if (z10) {
            i10 = Math.max(0, windowInsets.getInsets(WindowInsets.Type.ime()).bottom - windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom);
        }
        setMarginBottomTo(viewGroup, i10, windowInsets, view);
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getMarginBottomValue() {
        return -1;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getPaddingBottomOffset() {
        return -1;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public float getTranslateOffset() {
        return -1.0f;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getWindowType() {
        return this.mWindowType;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void recoveryScrollingParentViewPaddingBottom(COUIPanelContentLayout cOUIPanelContentLayout) {
        if (cOUIPanelContentLayout != null) {
            cOUIPanelContentLayout.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public boolean releaseData() {
        return true;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void setWindowType(int i10) {
        this.mWindowType = i10;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void resetInnerStatus() {
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void setIgnoreHideKeyboardAnim(boolean z10) {
    }
}
