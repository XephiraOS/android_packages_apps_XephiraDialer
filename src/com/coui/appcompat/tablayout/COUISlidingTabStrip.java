package com.coui.appcompat.tablayout;

import Y8.d;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.K;
import com.coui.appcompat.grid.COUIResponsiveUtils;

/* loaded from: classes3.dex */
public class COUISlidingTabStrip extends LinearLayout {
    private final Paint mBottomDividerPaint;
    private COUITabLayout mCOUITabLayout;
    private int mContentMinWidth;
    private int mHorizontalLargeMargin;
    private int mHorizontalMediumMargin;
    private int mHorizontalSmallMargin;
    private int mIndicatorAnimTime;
    private ValueAnimator mIndicatorAnimator;
    private int mIndicatorBackgroundHeight;
    private int mIndicatorBackgroundPaddingLeft;
    private int mIndicatorBackgroundPaddingRight;
    private final Paint mIndicatorBackgroundPaint;
    private int mIndicatorLeft;
    private int mIndicatorRight;
    private float mIndicatorWidthRatio;
    float mLastOffset;
    private int mLastPosition;
    float mLastSelectionOffset;
    private int mLayoutDirection;
    protected int mSelectedIndicatorHeight;
    private final Paint mSelectedIndicatorPaint;
    int mSelectedPosition;
    float mSelectionOffset;
    private int mTabMediumSpacing;
    private int mTabSmallSpacing;

    public COUISlidingTabStrip(Context context, COUITabLayout cOUITabLayout) {
        super(context);
        this.mSelectedPosition = -1;
        this.mLayoutDirection = -1;
        this.mIndicatorLeft = -1;
        this.mIndicatorRight = -1;
        this.mLastPosition = 0;
        this.mIndicatorAnimTime = -1;
        this.mCOUITabLayout = cOUITabLayout;
        setWillNotDraw(false);
        this.mSelectedIndicatorPaint = new Paint();
        this.mBottomDividerPaint = new Paint();
        this.mIndicatorBackgroundPaint = new Paint();
        setGravity(17);
        this.mHorizontalLargeMargin = getResources().getDimensionPixelSize(d.f5623O);
        this.mHorizontalMediumMargin = getResources().getDimensionPixelSize(d.f5624P);
        this.mHorizontalSmallMargin = getResources().getDimensionPixelSize(d.f5628T);
        this.mTabSmallSpacing = getResources().getDimensionPixelSize(d.f5629U);
        this.mTabMediumSpacing = getResources().getDimensionPixelSize(d.f5625Q);
        this.mContentMinWidth = getResources().getDimensionPixelSize(d.f5622N);
    }

    private int getIndicatorLeft(int i10) {
        int width = ((this.mCOUITabLayout.getWidth() - this.mCOUITabLayout.getPaddingLeft()) - this.mCOUITabLayout.getPaddingRight()) - getWidth();
        return (!isLayoutRTL() || width <= 0) ? i10 : i10 + width;
    }

    private int getIndicatorRight(int i10) {
        int width = ((this.mCOUITabLayout.getWidth() - this.mCOUITabLayout.getPaddingLeft()) - this.mCOUITabLayout.getPaddingRight()) - getWidth();
        return (!isLayoutRTL() || width <= 0) ? i10 : i10 + width;
    }

    private boolean isLayoutRTL() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    private void measureChildWithRedDot(COUITabView cOUITabView, int i10, int i11) {
        if (cOUITabView.getTextView() != null) {
            cOUITabView.getTextView().getLayoutParams().width = -2;
        }
        if (cOUITabView.getTextView() != null && cOUITabView.getHintRedDot() != null && cOUITabView.getHintRedDot().getVisibility() != 8) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cOUITabView.getHintRedDot().getLayoutParams();
            layoutParams.gravity = 48;
            if (cOUITabView.getHintRedDot().getPointMode() != 0) {
                if (isLayoutRTL()) {
                    layoutParams.rightMargin = this.mCOUITabLayout.mDotHorizontalOffset;
                } else {
                    layoutParams.leftMargin = this.mCOUITabLayout.mDotHorizontalOffset;
                }
                if (cOUITabView.getHintRedDot().getPointMode() == 2) {
                    layoutParams.topMargin = this.mCOUITabLayout.mDotVerticalOffsetFromNumberRed;
                } else {
                    layoutParams.topMargin = this.mCOUITabLayout.mDotVerticalOffsetFromOnlyRed;
                }
                cOUITabView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), i11);
                if (cOUITabView.getMeasuredWidth() > this.mCOUITabLayout.mRequestedTabMaxWidth) {
                    cOUITabView.getTextView().getLayoutParams().width = ((this.mCOUITabLayout.mRequestedTabMaxWidth - cOUITabView.getHintRedDot().getMeasuredWidth()) - layoutParams.getMarginStart()) + layoutParams.getMarginEnd();
                    cOUITabView.measure(i10, i11);
                    return;
                }
                return;
            }
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            cOUITabView.measure(i10, i11);
            return;
        }
        cOUITabView.measure(i10, i11);
    }

    private void measureShortChild(int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = ((i10 - i11) - (i12 * childCount)) / 2;
        int i15 = i12 / 2;
        setLayoutPadding(i14, i14);
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            setMargin(childAt, i15, i15, childAt.getMeasuredWidth());
        }
    }

    private void measureSmallChild(int i10, int i11, int i12) {
        int max;
        int i13;
        int childCount = getChildCount();
        int i14 = this.mContentMinWidth;
        if (i10 >= i14) {
            max = Math.max((i14 - i11) / (childCount + 1), i12);
            i13 = ((i10 - this.mContentMinWidth) + max) / 2;
        } else {
            max = Math.max((i10 - i11) / (childCount + 1), i12);
            i13 = max / 2;
        }
        int i15 = max / 2;
        setLayoutPadding(i13, i13);
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            setMargin(childAt, i15, i15, childAt.getMeasuredWidth());
        }
    }

    private int parseMinDivider(int i10) {
        if (i10 != -1) {
            return i10;
        }
        int measuredWidth = ((COUITabLayout) getParent()).getMeasuredWidth();
        if (!COUIResponsiveUtils.isMediumScreen(getContext(), measuredWidth) && !COUIResponsiveUtils.isLargeScreen(getContext(), measuredWidth)) {
            return this.mTabSmallSpacing;
        }
        return this.mTabMediumSpacing;
    }

    private int parseMinMargin(int i10) {
        if (i10 != -1) {
            return i10;
        }
        int measuredWidth = ((COUITabLayout) getParent()).getMeasuredWidth();
        if (COUIResponsiveUtils.isLargeScreen(getContext(), measuredWidth)) {
            return this.mHorizontalLargeMargin;
        }
        if (COUIResponsiveUtils.isMediumScreen(getContext(), measuredWidth)) {
            return this.mHorizontalMediumMargin;
        }
        return this.mHorizontalSmallMargin;
    }

    private void setLayoutPadding(int i10, int i11) {
        if (getParent() != null && (getParent() instanceof COUITabLayout)) {
            ((COUITabLayout) getParent()).setPaddingLeftAndRight(i10, i11);
        }
    }

    private void setMargin(View view, int i10, int i11, int i12) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = i12 + i11 + i10;
        view.setPaddingRelative(i10, view.getPaddingTop(), i11, view.getPaddingBottom());
        view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateIndicatorToPosition(final int r18, int r19) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.tablayout.COUISlidingTabStrip.animateIndicatorToPosition(int, int):void");
    }

    public boolean childrenNeedLayout() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (getChildAt(i10).getWidth() <= 0) {
                return true;
            }
        }
        return false;
    }

    public int dpToPx(int i10) {
        return Math.round(getResources().getDisplayMetrics().density * i10);
    }

    public Paint getBottomDividerPaint() {
        return this.mBottomDividerPaint;
    }

    public int getIndicatorAnimTime() {
        return this.mIndicatorAnimTime;
    }

    public int getIndicatorBackgroundHeight() {
        return this.mIndicatorBackgroundHeight;
    }

    public int getIndicatorBackgroundPaddingLeft() {
        return this.mIndicatorBackgroundPaddingLeft;
    }

    public int getIndicatorBackgroundPaddingRight() {
        return this.mIndicatorBackgroundPaddingRight;
    }

    public Paint getIndicatorBackgroundPaint() {
        return this.mIndicatorBackgroundPaint;
    }

    public float getIndicatorPosition() {
        return this.mSelectedPosition + this.mSelectionOffset;
    }

    public float getIndicatorWidthRatio() {
        return this.mIndicatorWidthRatio;
    }

    public Paint getSelectedIndicatorPaint() {
        return this.mSelectedIndicatorPaint;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.mCOUITabLayout.isUpdateindicatorposition()) {
            updateIndicatorPosition();
        }
        if (this.mCOUITabLayout.mTabAlreadyMeasure) {
            return;
        }
        ValueAnimator valueAnimator = this.mIndicatorAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mIndicatorAnimator.cancel();
            animateIndicatorToPosition(this.mSelectedPosition, Math.round((1.0f - this.mIndicatorAnimator.getAnimatedFraction()) * ((float) this.mIndicatorAnimator.getDuration())));
        }
        COUITabLayout cOUITabLayout = this.mCOUITabLayout;
        cOUITabLayout.mTabAlreadyMeasure = true;
        cOUITabLayout.setScrollPosition(this.mSelectedPosition, 0.0f, true, true);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) == 0) {
            return;
        }
        int size = View.MeasureSpec.getSize(i10);
        int childCount = getChildCount();
        if (childCount == 0) {
            super.onMeasure(i10, i11);
            return;
        }
        int parseMinMargin = parseMinMargin(this.mCOUITabLayout.getTabMinMargin());
        int parseMinDivider = parseMinDivider(this.mCOUITabLayout.getTabMinDivider());
        if (this.mCOUITabLayout.getTabMode() == 1) {
            this.mIndicatorWidthRatio = this.mCOUITabLayout.getDefaultIndicatoRatio();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mCOUITabLayout.mRequestedTabMaxWidth, Integer.MIN_VALUE);
            int i12 = 0;
            for (int i13 = 0; i13 < childCount; i13++) {
                COUITabView cOUITabView = (COUITabView) getChildAt(i13);
                setMargin(cOUITabView, 0, 0);
                measureChildWithRedDot(cOUITabView, makeMeasureSpec, i11);
                i12 += cOUITabView.getMeasuredWidth();
            }
            int i14 = (parseMinMargin * 2) + i12 + ((childCount - 1) * parseMinDivider);
            if (i14 <= this.mContentMinWidth) {
                measureSmallChild(size, i12, parseMinDivider);
            } else if (i14 <= size) {
                measureShortChild(size, i12, parseMinDivider, parseMinMargin);
            } else {
                int i15 = parseMinDivider / 2;
                int i16 = parseMinMargin - i15;
                setLayoutPadding(i16, i16);
                for (int i17 = 0; i17 < childCount; i17++) {
                    View childAt = getChildAt(i17);
                    setMargin(childAt, i15, i15, childAt.getMeasuredWidth());
                }
            }
        } else {
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mCOUITabLayout.mRequestedTabMaxWidth, Integer.MIN_VALUE);
            int i18 = parseMinDivider / 2;
            int i19 = parseMinMargin - i18;
            setLayoutPadding(i19, i19);
            for (int i20 = 0; i20 < childCount; i20++) {
                View childAt2 = getChildAt(i20);
                setMargin(childAt2, 0, 0);
                measureChildWithRedDot((COUITabView) childAt2, makeMeasureSpec2, i11);
                setMargin(childAt2, i18, i18, childAt2.getMeasuredWidth());
            }
        }
        int i21 = 0;
        for (int i22 = 0; i22 < childCount; i22++) {
            i21 += getChildAt(i22).getMeasuredWidth();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i21, 1073741824), i11);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
    }

    public void setBottomDividerColor(int i10) {
        this.mBottomDividerPaint.setColor(i10);
        K.Z(this.mCOUITabLayout);
    }

    public void setIndicatorAnimTime(int i10) {
        this.mIndicatorAnimTime = i10;
    }

    public void setIndicatorBackgroundHeight(int i10) {
        this.mIndicatorBackgroundHeight = i10;
    }

    public void setIndicatorBackgroundPaddingLeft(int i10) {
        this.mIndicatorBackgroundPaddingLeft = i10;
    }

    public void setIndicatorBackgroundPaddingRight(int i10) {
        this.mIndicatorBackgroundPaddingRight = i10;
    }

    public void setIndicatorLeft(int i10) {
        this.mIndicatorLeft = i10;
    }

    public void setIndicatorPosition(int i10, int i11) {
        int i12 = (i10 + i11) / 2;
        int max = Math.max(i11 - i10, dpToPx(32)) / 2;
        int i13 = i12 - max;
        int i14 = i12 + max;
        if (i13 != this.mIndicatorLeft || i14 != this.mIndicatorRight) {
            this.mIndicatorLeft = i13;
            this.mIndicatorRight = i14;
            K.Z(this.mCOUITabLayout);
        }
    }

    public void setIndicatorPositionFromTabPosition(int i10, float f10) {
        ValueAnimator valueAnimator = this.mIndicatorAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mIndicatorAnimator.cancel();
        }
        this.mSelectedPosition = i10;
        this.mSelectionOffset = f10;
        updateIndicatorPosition();
    }

    public void setIndicatorRight(int i10) {
        this.mIndicatorRight = i10;
    }

    public void setIndicatorWidthRatio(float f10) {
        this.mIndicatorWidthRatio = f10;
    }

    public void setSelectedIndicatorColor(int i10) {
        this.mSelectedIndicatorPaint.setColor(i10);
        K.Z(this.mCOUITabLayout);
    }

    public void setSelectedIndicatorHeight(int i10) {
        if (this.mSelectedIndicatorHeight != i10) {
            this.mSelectedIndicatorHeight = i10;
            K.Z(this.mCOUITabLayout);
        }
    }

    public void updateIndicatorPosition() {
        boolean z10;
        int right;
        int left;
        int right2;
        int i10;
        float f10;
        int left2;
        int right3;
        int i11;
        float f11;
        View childAt = getChildAt(this.mSelectedPosition);
        COUITabView cOUITabView = (COUITabView) getChildAt(this.mSelectedPosition);
        boolean z11 = false;
        if (cOUITabView != null && cOUITabView.getTextView() != null && cOUITabView.mCustomView == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (cOUITabView != null && cOUITabView.mCustomView != null) {
            z11 = true;
        }
        int i12 = -1;
        if (z10) {
            TextView textView = cOUITabView.getTextView();
            if (textView.getWidth() > 0) {
                int left3 = (cOUITabView.getLeft() + textView.getLeft()) - this.mCOUITabLayout.getIndicatorPadding();
                int left4 = cOUITabView.getLeft() + textView.getRight() + this.mCOUITabLayout.getIndicatorPadding();
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    COUITabView cOUITabView2 = (COUITabView) getChildAt(this.mSelectedPosition + 1);
                    View view = cOUITabView2.mCustomView;
                    if (view == null) {
                        view = cOUITabView2.getTextView();
                    }
                    if (view != null) {
                        left2 = (cOUITabView2.getLeft() + view.getLeft()) - this.mCOUITabLayout.getIndicatorPadding();
                        right3 = cOUITabView2.getLeft() + view.getRight() + this.mCOUITabLayout.getIndicatorPadding();
                    } else {
                        left2 = cOUITabView2.getLeft();
                        right3 = cOUITabView2.getRight();
                    }
                    int i13 = right3 - left2;
                    int i14 = left4 - left3;
                    int i15 = i13 - i14;
                    int i16 = left2 - left3;
                    if (this.mLastSelectionOffset == 0.0f) {
                        this.mLastSelectionOffset = this.mSelectionOffset;
                    }
                    float f12 = this.mSelectionOffset;
                    if (f12 - this.mLastSelectionOffset > 0.0f) {
                        i11 = (int) (i14 + (i15 * f12));
                        f11 = left3 + (i16 * f12);
                    } else {
                        i11 = (int) (i13 - (i15 * (1.0f - f12)));
                        f11 = left2 - (i16 * (1.0f - f12));
                    }
                    left3 = (int) f11;
                    left4 = left3 + i11;
                    this.mLastSelectionOffset = f12;
                }
                i12 = getIndicatorLeft(left3);
                right = getIndicatorRight(left4);
            }
            right = -1;
        } else if (z11) {
            View view2 = cOUITabView.mCustomView;
            if (view2.getWidth() > 0) {
                int left5 = (cOUITabView.getLeft() + view2.getLeft()) - this.mCOUITabLayout.getIndicatorPadding();
                int left6 = cOUITabView.getLeft() + view2.getRight() + this.mCOUITabLayout.getIndicatorPadding();
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    COUITabView cOUITabView3 = (COUITabView) getChildAt(this.mSelectedPosition + 1);
                    View view3 = cOUITabView3.mCustomView;
                    if (view3 == null) {
                        view3 = cOUITabView3.getTextView();
                    }
                    if (view3 != null) {
                        left = (cOUITabView3.getLeft() + view3.getLeft()) - this.mCOUITabLayout.getIndicatorPadding();
                        right2 = cOUITabView3.getLeft() + view3.getRight() + this.mCOUITabLayout.getIndicatorPadding();
                    } else {
                        left = cOUITabView3.getLeft();
                        right2 = cOUITabView3.getRight();
                    }
                    int i17 = right2 - left;
                    int i18 = left6 - left5;
                    int i19 = i17 - i18;
                    int i20 = left - left5;
                    if (this.mLastSelectionOffset == 0.0f) {
                        this.mLastSelectionOffset = this.mSelectionOffset;
                    }
                    float f13 = this.mSelectionOffset;
                    if (f13 - this.mLastSelectionOffset > 0.0f) {
                        i10 = (int) (i18 + (i19 * f13));
                        f10 = left5 + (i20 * f13);
                    } else {
                        i10 = (int) (i17 - (i19 * (1.0f - f13)));
                        f10 = left - (i20 * (1.0f - f13));
                    }
                    left5 = (int) f10;
                    left6 = left5 + i10;
                    this.mLastSelectionOffset = f13;
                }
                i12 = getIndicatorLeft(left5);
                right = getIndicatorRight(left6);
            }
            right = -1;
        } else {
            if (childAt != null && childAt.getWidth() > 0) {
                i12 = childAt.getLeft();
                right = childAt.getRight();
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    float left7 = this.mSelectionOffset * childAt2.getLeft();
                    float f14 = this.mSelectionOffset;
                    i12 = (int) (left7 + ((1.0f - f14) * i12));
                    right = (int) ((f14 * childAt2.getRight()) + ((1.0f - this.mSelectionOffset) * right));
                }
            }
            right = -1;
        }
        setIndicatorPosition(i12, right);
    }

    public int getIndicatorLeft() {
        return this.mIndicatorLeft;
    }

    public int getIndicatorRight() {
        return this.mIndicatorRight;
    }

    private void setMargin(View view, int i10, int i11) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        K.A0(view, 0, view.getPaddingTop(), 0, view.getPaddingBottom());
        layoutParams.setMarginStart(i10);
        layoutParams.setMarginEnd(i11);
    }
}
