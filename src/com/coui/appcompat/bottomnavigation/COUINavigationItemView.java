package com.coui.appcompat.bottomnavigation;

import Y8.b;
import Y8.d;
import Y8.f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.P;
import androidx.core.view.K;
import com.coui.appcompat.reddot.COUIHintRedDot;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.uiutil.UIUtil;
import e4.g;
import g4.C1045a;

/* loaded from: classes.dex */
public class COUINavigationItemView extends C1045a {
    public static final int TIPS_CIRCLE = 1;
    public static final int TIPS_HIDE = 3;
    public static final int TIPS_OVAL = 2;
    private int bigOffsetHorizontal;
    private COUIHintRedDot mCOUIHintRedDot;
    private int mDefRedDotOffset;
    private int mDefRedDotTextOffsetHorizontal;
    private int mDefRedDotTextOffsetVertical;
    private int mEnlargeIconSize;
    private int mEnlargeItemHeight;
    private FrameLayout mFlRoot;
    private ImageView mIcon;
    private FrameLayout mIconContainer;
    private int mIconMarginTop;
    private boolean mIsEnlarge;
    private boolean mIsEnlargeView;
    private boolean mIsHorizontalView;
    private boolean mIsShowPressShadow;
    private final RectF mItemRect;
    private TextView mLargeLabel;
    private int mLayoutType;
    private COUIMaskEffectDrawable mMaskEffectDrawable;
    private int mNormalIconSize;
    private int mNormalItemHeight;
    private Rect mRedDotRect;
    private TextView mSmallLabel;
    private COUIStateEffectDrawable mStateEffectBackground;
    private int mTextSize;
    private int[] offset;
    private int smallOffsetHorizontal;

    public COUINavigationItemView(Context context) {
        super(context);
        this.mItemRect = new RectF();
        this.smallOffsetHorizontal = -2;
        this.bigOffsetHorizontal = 1;
        this.mEnlargeIconSize = getResources().getDimensionPixelSize(d.f5641d);
        this.mNormalIconSize = getResources().getDimensionPixelSize(d.f5656l);
        this.mEnlargeItemHeight = getResources().getDimensionPixelSize(d.f5643e);
        this.mNormalItemHeight = getResources().getDimensionPixelSize(d.f5657m);
        this.mIconMarginTop = getResources().getDimensionPixelSize(d.f5639c);
        this.mDefRedDotTextOffsetVertical = getResources().getDimensionPixelSize(d.f5669y);
        this.mDefRedDotTextOffsetHorizontal = 0;
        this.mDefRedDotOffset = getResources().getDimensionPixelSize(d.f5667w);
        this.offset = new int[2];
        this.mIsEnlarge = false;
        this.mIsEnlargeView = false;
        this.mIsShowPressShadow = false;
        this.mIsHorizontalView = false;
        this.mSmallLabel = (TextView) findViewById(g.f30856S);
        this.mLargeLabel = (TextView) findViewById(g.f30855R);
        this.mIcon = (ImageView) findViewById(g.f30853P);
        this.mIconContainer = (FrameLayout) findViewById(g.f30852O);
        this.mFlRoot = (FrameLayout) findViewById(f.f5676a);
        this.mCOUIHintRedDot = (COUIHintRedDot) findViewById(f.f5681f);
        setTextSize(context.getResources().getDimensionPixelSize(d.f5653j));
        setClipChildren(false);
        setClipToPadding(false);
        setHapticFeedbackEnabled(false);
        this.mDefRedDotTextOffsetHorizontal = context.getResources().getDimensionPixelSize(d.f5668x);
        configStateEffectBackground();
    }

    private void configStateEffectBackground() {
        Drawable background;
        setDefaultFocusHighlightEnabled(false);
        float dimension = getContext().getResources().getDimension(d.f5647g);
        COUIMaskEffectDrawable cOUIMaskEffectDrawable = new COUIMaskEffectDrawable(getContext(), 1);
        this.mMaskEffectDrawable = cOUIMaskEffectDrawable;
        cOUIMaskEffectDrawable.setMaskRect(this.mItemRect, dimension, dimension);
        this.mMaskEffectDrawable.enableSelectedState(false);
        this.mMaskEffectDrawable.setMinProgressForTouchEnterAnimation(0.0f);
        if (getBackground() == null) {
            background = new ColorDrawable(0);
        } else {
            background = getBackground();
        }
        COUIStateEffectDrawable cOUIStateEffectDrawable = new COUIStateEffectDrawable(new Drawable[]{background, this.mMaskEffectDrawable});
        this.mStateEffectBackground = cOUIStateEffectDrawable;
        super.setBackground(cOUIStateEffectDrawable);
    }

    public static int dp2px(Context context, int i10) {
        return Double.valueOf((context.getResources().getConfiguration().densityDpi * i10) + 0.5d).intValue();
    }

    private void enlargeSelectView(boolean z10) {
        int i10;
        int i11;
        int i12;
        if (this.mIsEnlargeView) {
            if (z10) {
                i10 = this.mEnlargeIconSize;
            } else {
                i10 = this.mNormalIconSize;
            }
            setIconSize(i10);
            TextView textView = this.mSmallLabel;
            if (z10) {
                i11 = 8;
            } else {
                i11 = 0;
            }
            textView.setVisibility(i11);
            if (!this.mIsHorizontalView) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mIconContainer.getLayoutParams();
                if (z10) {
                    i12 = 0;
                } else {
                    i12 = this.mIconMarginTop;
                }
                layoutParams.setMargins(0, i12, 0, 0);
                this.mIconContainer.setLayoutParams(layoutParams);
            }
        }
    }

    private void getOffset(int[] iArr) {
        if (this.mCOUIHintRedDot.getPointMode() == 1) {
            int i10 = this.mDefRedDotOffset;
            iArr[1] = i10;
            iArr[0] = i10;
            return;
        }
        iArr[1] = this.mDefRedDotTextOffsetVertical;
        iArr[0] = this.mDefRedDotTextOffsetHorizontal;
        if (this.mCOUIHintRedDot.getPointNumber() >= 100 && this.mCOUIHintRedDot.getPointNumber() < 1000) {
            iArr[0] = iArr[0] + UIUtil.dip2px(getContext(), this.bigOffsetHorizontal);
        } else if (this.mCOUIHintRedDot.getPointNumber() > 0 && this.mCOUIHintRedDot.getPointNumber() < 10) {
            iArr[0] = iArr[0] + UIUtil.dip2px(getContext(), this.smallOffsetHorizontal);
        }
    }

    private boolean isRtlMode() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void layoutRedDot() {
        if (this.mCOUIHintRedDot.getVisibility() == 8) {
            return;
        }
        if (this.mRedDotRect == null) {
            this.mRedDotRect = new Rect();
        }
        getOffset(this.offset);
        if (K.v(this) == 1) {
            this.mRedDotRect.set(this.mIconContainer.getLeft(), this.mIconContainer.getTop(), this.mIconContainer.getLeft() + this.mCOUIHintRedDot.getMeasuredWidth(), this.mIconContainer.getTop() + this.mCOUIHintRedDot.getMeasuredHeight());
            Rect rect = this.mRedDotRect;
            int[] iArr = this.offset;
            rect.offset(-iArr[0], -iArr[1]);
        } else {
            this.mRedDotRect.set(this.mIconContainer.getRight() - this.mCOUIHintRedDot.getMeasuredWidth(), this.mIconContainer.getTop(), this.mIconContainer.getRight(), this.mIconContainer.getTop() + this.mCOUIHintRedDot.getMeasuredHeight());
            Rect rect2 = this.mRedDotRect;
            int[] iArr2 = this.offset;
            rect2.offset(iArr2[0], -iArr2[1]);
        }
        COUIHintRedDot cOUIHintRedDot = this.mCOUIHintRedDot;
        Rect rect3 = this.mRedDotRect;
        cOUIHintRedDot.layout(rect3.left, rect3.top, rect3.right, rect3.bottom);
    }

    private void leftToRight() {
        int measuredWidth;
        int i10;
        int i11 = 0;
        View childAt = this.mFlRoot.getChildAt(0);
        View childAt2 = this.mFlRoot.getChildAt(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f5637b);
        int measuredWidth2 = ((this.mFlRoot.getMeasuredWidth() - childAt.getMeasuredWidth()) - childAt2.getMeasuredWidth()) - dimensionPixelSize;
        if (measuredWidth2 > 0) {
            i11 = measuredWidth2 / 2;
        }
        if (this.mIsEnlargeView) {
            i10 = (this.mFlRoot.getMeasuredWidth() / 2) - (childAt.getMeasuredWidth() / 2);
            measuredWidth = (this.mFlRoot.getMeasuredWidth() / 2) + (childAt.getMeasuredWidth() / 2);
        } else {
            measuredWidth = i11 + childAt.getMeasuredWidth();
            i10 = i11;
        }
        childAt.layout(i10, (this.mFlRoot.getMeasuredHeight() / 2) - (childAt.getMeasuredHeight() / 2), measuredWidth, (this.mFlRoot.getMeasuredHeight() / 2) + (childAt.getMeasuredHeight() / 2));
        int right = childAt.getRight() + dimensionPixelSize;
        int measuredWidth3 = this.mFlRoot.getMeasuredWidth() - i11;
        int measuredHeight = (this.mFlRoot.getMeasuredHeight() / 2) - (childAt2.getMeasuredHeight() / 2);
        int measuredHeight2 = (this.mFlRoot.getMeasuredHeight() / 2) + (childAt2.getMeasuredHeight() / 2);
        childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth3 - right, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824));
        childAt2.layout(right, measuredHeight, measuredWidth3, measuredHeight2);
        if (this.mIsEnlargeView) {
            childAt2.setVisibility(8);
        }
        this.mIsHorizontalView = true;
    }

    private void rightToLeft() {
        int i10 = 0;
        View childAt = this.mFlRoot.getChildAt(0);
        View childAt2 = this.mFlRoot.getChildAt(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f5637b);
        int measuredWidth = ((this.mFlRoot.getMeasuredWidth() - childAt.getMeasuredWidth()) - childAt2.getMeasuredWidth()) - dimensionPixelSize;
        if (measuredWidth > 0) {
            i10 = measuredWidth / 2;
        }
        if (this.mIsEnlargeView) {
            childAt.layout((this.mFlRoot.getMeasuredWidth() / 2) - (childAt.getMeasuredWidth() / 2), (this.mFlRoot.getMeasuredHeight() / 2) - (childAt.getMeasuredHeight() / 2), (this.mFlRoot.getMeasuredWidth() / 2) + (childAt.getMeasuredWidth() / 2), (this.mFlRoot.getMeasuredHeight() / 2) + (childAt.getMeasuredHeight() / 2));
        } else {
            int measuredWidth2 = this.mFlRoot.getMeasuredWidth() - i10;
            childAt.layout(measuredWidth2 - childAt.getMeasuredWidth(), (this.mFlRoot.getMeasuredHeight() / 2) - (childAt.getMeasuredHeight() / 2), measuredWidth2, (this.mFlRoot.getMeasuredHeight() / 2) + (childAt.getMeasuredHeight() / 2));
        }
        int left = childAt.getLeft() - dimensionPixelSize;
        int measuredHeight = (this.mFlRoot.getMeasuredHeight() / 2) - (childAt2.getMeasuredHeight() / 2);
        int measuredHeight2 = (this.mFlRoot.getMeasuredHeight() / 2) + (childAt2.getMeasuredHeight() / 2);
        childAt2.measure(View.MeasureSpec.makeMeasureSpec(left - i10, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824));
        childAt2.layout(i10, measuredHeight, left, measuredHeight2);
        if (this.mIsEnlargeView) {
            childAt2.setVisibility(8);
        }
        this.mIsHorizontalView = true;
    }

    public void childLayout(int i10) {
        this.mLayoutType = i10;
        requestLayout();
    }

    public void clearColorFilter() {
        this.mIcon.clearColorFilter();
    }

    @Override // com.google.android.material.navigation.c, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mIsShowPressShadow) {
            if (motionEvent.getActionMasked() == 0) {
                this.mStateEffectBackground.setTouched(true);
            }
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                this.mStateEffectBackground.setTouched(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public COUIHintRedDot getCOUIHintRedDot() {
        return this.mCOUIHintRedDot;
    }

    @Override // g4.C1045a, com.google.android.material.navigation.c
    public int getItemDefaultMarginResId() {
        return d.f5635a;
    }

    @Override // g4.C1045a, com.google.android.material.navigation.c
    public int getItemLayoutResId() {
        return Y8.g.f5682a;
    }

    @Override // com.google.android.material.navigation.c, androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i10) {
        super.initialize(menuItemImpl, i10);
        P.a(this, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsEnlarge) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mFlRoot.getLayoutParams();
            layoutParams.gravity = 80;
            if (this.mIsEnlargeView) {
                layoutParams.height = this.mEnlargeItemHeight;
                setIconSize(this.mNormalIconSize);
                setIconTintList(null);
            } else {
                layoutParams.height = this.mNormalItemHeight;
            }
            this.mFlRoot.setLayoutParams(layoutParams);
            enlargeSelectView(isSelected());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCOUIHintRedDot.setPointMode(0);
        this.mCOUIHintRedDot.setPointText("");
        this.mCOUIHintRedDot.setVisibility(4);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        super.onLayout(z10, i10, i11, i12, i13);
        if (getResources().getConfiguration().orientation == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = getContext().getResources().getBoolean(b.f5603b);
        boolean z13 = getContext().getResources().getBoolean(b.f5602a);
        boolean z14 = getContext().getResources().getBoolean(b.f5604c);
        if (this.mLayoutType == 1) {
            topToBottom();
        } else if ((z11 || z13) && !isRtlMode() && !z14) {
            leftToRight();
        } else if ((z11 || z13) && isRtlMode()) {
            rightToLeft();
        } else if (z12 || z14) {
            topToBottom();
        }
        layoutRedDot();
    }

    @Override // com.google.android.material.navigation.c, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mItemRect.set(0.0f, 0.0f, i10, i11);
    }

    public void refresh() {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            cOUIStateEffectDrawable.refresh(getContext());
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            if (drawable == null) {
                cOUIStateEffectDrawable.setViewBackground(new ColorDrawable(0));
                return;
            } else {
                cOUIStateEffectDrawable.setViewBackground(drawable);
                return;
            }
        }
        super.setBackground(drawable);
    }

    @Override // com.google.android.material.navigation.c, androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z10) {
        enlargeSelectView(z10);
        setSelected(z10);
    }

    public void setEnlarge(boolean z10, boolean z11) {
        this.mIsEnlarge = z10;
        this.mIsEnlargeView = z11;
    }

    public void setIconTintForWhite() {
        if (!this.mIsEnlargeView) {
            this.mIcon.setColorFilter(-1);
        }
    }

    public void setShowPressShadow(boolean z10) {
        this.mIsShowPressShadow = z10;
    }

    public void setTextSize(int i10) {
        this.mTextSize = i10;
        this.mSmallLabel.setTextSize(0, i10);
        this.mLargeLabel.setTextSize(0, this.mTextSize);
        requestLayout();
    }

    public void topToBottom() {
        int dimensionPixelSize;
        View childAt = this.mFlRoot.getChildAt(0);
        View childAt2 = this.mFlRoot.getChildAt(1);
        if (this.mIsEnlargeView && isSelected()) {
            dimensionPixelSize = 0;
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(d.f5645f);
        }
        childAt.layout((this.mFlRoot.getMeasuredWidth() / 2) - (childAt.getMeasuredWidth() / 2), dimensionPixelSize, (this.mFlRoot.getMeasuredWidth() / 2) + (childAt.getMeasuredWidth() / 2), childAt.getMeasuredHeight() + dimensionPixelSize);
        int measuredWidth = (this.mFlRoot.getMeasuredWidth() / 2) - (childAt2.getMeasuredWidth() / 2);
        int measuredWidth2 = (this.mFlRoot.getMeasuredWidth() / 2) + (childAt2.getMeasuredWidth() / 2);
        int measuredHeight = this.mFlRoot.getMeasuredHeight() - childAt2.getMeasuredHeight();
        Resources resources = getResources();
        int i10 = d.f5645f;
        int dimensionPixelSize2 = measuredHeight - resources.getDimensionPixelSize(i10);
        Resources resources2 = getResources();
        int i11 = d.f5609A;
        childAt2.layout(measuredWidth, dimensionPixelSize2 + resources2.getDimensionPixelSize(i11), measuredWidth2, (this.mFlRoot.getMeasuredHeight() - getResources().getDimensionPixelSize(i10)) + getResources().getDimensionPixelSize(i11));
        if (this.mIsEnlargeView) {
            childAt2.setVisibility(0);
        }
        this.mIsHorizontalView = false;
    }
}
