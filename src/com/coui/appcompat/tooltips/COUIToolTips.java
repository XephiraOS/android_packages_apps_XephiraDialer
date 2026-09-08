package com.coui.appcompat.tooltips;

import X8.f;
import a9.c;
import a9.h;
import a9.l;
import a9.m;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.dynamicanimation.animation.d;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.animation.dynamicanimation.COUISpringAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringForce;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.poplist.COUIPopupWindow;
import com.coui.appcompat.poplist.WindowSpacingControlHelper;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.coui.appcompat.uiutil.UIUtil;
import y.C1698b;

/* loaded from: classes3.dex */
public class COUIToolTips extends COUIPopupWindow {
    public static final int ALIGN_BOTTOM = 128;
    public static final int ALIGN_END = 64;
    public static final int ALIGN_LEFT = 16;
    public static final int ALIGN_RIGHT = 8;
    public static final int ALIGN_START = 32;
    public static final int ANIMATION_DURATION = 300;
    public static final int ANIMATION_EXIT_DURATION = 20;
    public static final int DEFAULT_ALIGN_DIRECTION = 4;
    private static final float DEFAULT_SPRING_FACTOR = 10000.0f;
    private static final float DEFAULT_TOOLTIPS_ALPHA_SPRING_RESPONSE = 0.3f;
    private static final float DEFAULT_TOOLTIPS_SCALE_SPRING_RESPONSE = 0.4f;
    private static final float DEFAULT_TOOLTIPS_SPRING_BOUNCE = 0.2f;
    public static final int MODE_INFO = 1;
    public static final int MODE_TOOLTIPS = 0;
    private static final float ONE = 1.0f;
    private static final float POINT_FIVE = 0.5f;
    private static final String TAG = "COUIToolTips";
    private static final float ZERO = 0.0f;
    private View mAnchor;
    private Interpolator mAnimationInterpolator;
    private Drawable mArrowDownDrawable;
    private Drawable mArrowLeftDrawable;
    private int mArrowOverflow;
    private Drawable mArrowRightDrawable;
    private int mArrowType;
    private Drawable mArrowUpDrawable;
    private ImageView mArrowView;
    private Runnable mCheckAnimateExit;
    private ViewGroup mContentContainer;
    private Rect mContentRectOnScreen;
    private ColorStateList mContentTextColor;
    private TextView mContentTv;
    private final Context mContext;
    private final Point mCoordsOnWindow;
    private ImageView mDismissIv;
    private boolean mHasIndicator;
    private int mIndicatorEmbedDistance;
    private boolean mIndicatorFollowContent;
    private boolean mIsDismissing;
    private boolean mIsEntering;
    private boolean mLeftOrTop;
    private ViewGroup mMainPanel;
    private int mMode;
    private int mOffsetX;
    private int mOffsetY;
    private OnCloseIconClickListener mOnCloseIconClickListener;
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private PopupWindow.OnDismissListener mOnPopupWindowDismissListener;
    private View mParent;
    private Rect mParentRectOnScreen;
    private float mPivotX;
    private float mPivotY;
    private ScrollView mScrollView;
    private int mShowDirection;
    private final int[] mTmpCoords;
    private final d<Float> mToolTipsAlphaProperty;
    private float mToolTipsAnimationAlphaProgress;
    private float mToolTipsAnimationScaleProgress;
    private final d<Float> mToolTipsScaleProperty;
    private Rect mViewPortOnScreen;
    private Rect mViewportOffset;
    private int[] mWindowLocationOnScreen;

    /* loaded from: classes3.dex */
    public interface OnCloseIconClickListener {
        void onCloseIconClick();
    }

    @Deprecated
    public COUIToolTips(Window window) {
        this(window, 0);
    }

    private void addIndicator(Rect rect, int i10, int i11) {
        if (isLayoutRtl(this.mAnchor)) {
            i10 = -i10;
        }
        int i12 = this.mShowDirection;
        if (i12 != 128 && i12 != 4) {
            i10 = 0;
        } else {
            i11 = 0;
        }
        this.mArrowView = new ImageView(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i13 = this.mShowDirection;
        if (i13 != 4 && i13 != 128) {
            if (i13 == 16) {
                this.mLeftOrTop = true;
                layoutParams.rightMargin = ((this.mMainPanel.getPaddingRight() - this.mArrowRightDrawable.getIntrinsicWidth()) - i10) + this.mIndicatorEmbedDistance;
                layoutParams.leftMargin = ((getWidth() - layoutParams.rightMargin) - this.mArrowRightDrawable.getIntrinsicWidth()) - this.mIndicatorEmbedDistance;
                layoutParams.topMargin = (((rect.centerY() - this.mCoordsOnWindow.y) - this.mWindowLocationOnScreen[1]) - (this.mArrowRightDrawable.getIntrinsicHeight() / 2)) + i11;
                layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.mArrowRightDrawable.getIntrinsicHeight();
                this.mArrowView.setBackground(this.mArrowRightDrawable);
            } else {
                layoutParams.leftMargin = (this.mMainPanel.getPaddingLeft() - this.mArrowLeftDrawable.getIntrinsicWidth()) + i10 + this.mIndicatorEmbedDistance;
                layoutParams.rightMargin = ((getWidth() - layoutParams.leftMargin) - this.mArrowLeftDrawable.getIntrinsicWidth()) - this.mIndicatorEmbedDistance;
                layoutParams.topMargin = (((rect.centerY() - this.mCoordsOnWindow.y) - this.mWindowLocationOnScreen[1]) - (this.mArrowRightDrawable.getIntrinsicHeight() / 2)) + i11;
                layoutParams.bottomMargin = (getHeight() - layoutParams.topMargin) - this.mArrowRightDrawable.getIntrinsicHeight();
                this.mArrowView.setBackground(this.mArrowLeftDrawable);
            }
        } else {
            this.mParent.getRootView().getLocationOnScreen(this.mTmpCoords);
            int i14 = this.mTmpCoords[0];
            this.mParent.getRootView().getLocationInWindow(this.mTmpCoords);
            layoutParams.leftMargin = (((rect.centerX() - this.mCoordsOnWindow.x) - (i14 - this.mTmpCoords[0])) - (this.mArrowUpDrawable.getIntrinsicWidth() / 2)) + i10;
            layoutParams.rightMargin = (getWidth() - layoutParams.leftMargin) - this.mArrowUpDrawable.getIntrinsicWidth();
            if (this.mCoordsOnWindow.y >= rect.top - this.mWindowLocationOnScreen[1]) {
                this.mArrowView.setBackground(this.mArrowUpDrawable);
                this.mLeftOrTop = true;
                layoutParams.topMargin = (this.mMainPanel.getPaddingTop() - this.mArrowUpDrawable.getIntrinsicHeight()) + i11 + this.mIndicatorEmbedDistance;
            } else {
                this.mArrowView.setBackground(this.mArrowDownDrawable);
                layoutParams.gravity = 80;
                layoutParams.bottomMargin = ((this.mMainPanel.getPaddingBottom() - this.mArrowDownDrawable.getIntrinsicHeight()) - i11) + this.mIndicatorEmbedDistance;
            }
        }
        this.mContentContainer.addView(this.mArrowView, layoutParams);
        UIUtil.safeForceHasOverlappingRendering(this.mArrowView, false);
    }

    private void animateEnter() {
        ViewGroup viewGroup = this.mMainPanel;
        Resources resources = this.mContext.getResources();
        int i10 = f.f4544L5;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i10);
        Resources resources2 = this.mContext.getResources();
        int i11 = f.f4565O5;
        int dimensionPixelOffset2 = resources2.getDimensionPixelOffset(i11);
        Context context = this.mContext;
        int i12 = c.f6494r;
        ShadowUtils.setElevationToView(viewGroup, 2, dimensionPixelOffset, dimensionPixelOffset2, b.c(context, i12));
        ShadowUtils.setElevationToView(this.mArrowView, 2, this.mContext.getResources().getDimensionPixelOffset(i10), this.mContext.getResources().getDimensionPixelOffset(i11), b.c(this.mContext, i12));
        animateSpring(true);
    }

    private void animateExit() {
        ShadowUtils.clearShadow(this.mMainPanel);
        ShadowUtils.clearShadow(this.mArrowView);
        animateSpring(false);
        this.mIsDismissing = true;
        this.mContentContainer.removeCallbacks(this.mCheckAnimateExit);
        this.mContentContainer.postDelayed(this.mCheckAnimateExit, 320L);
    }

    private void animateSpring(boolean z10) {
        this.mIsEntering = z10;
        this.mContentContainer.setPivotX(this.mPivotX * getWidth());
        this.mContentContainer.setPivotY(this.mPivotY * getHeight());
        COUISpringAnimation cOUISpringAnimation = new COUISpringAnimation(Float.valueOf(this.mToolTipsAnimationScaleProgress), this.mToolTipsScaleProperty);
        COUISpringForce cOUISpringForce = new COUISpringForce();
        cOUISpringForce.setBounce(0.2f);
        cOUISpringForce.setResponse(DEFAULT_TOOLTIPS_SCALE_SPRING_RESPONSE);
        cOUISpringAnimation.setSpring(cOUISpringForce);
        cOUISpringAnimation.setStartValue(0.0f);
        cOUISpringAnimation.animateToFinalPosition(10000.0f);
        COUISpringAnimation cOUISpringAnimation2 = new COUISpringAnimation(Float.valueOf(this.mToolTipsAnimationAlphaProgress), this.mToolTipsAlphaProperty);
        COUISpringForce cOUISpringForce2 = new COUISpringForce();
        cOUISpringForce2.setBounce(0.2f);
        cOUISpringForce2.setResponse(0.3f);
        cOUISpringAnimation2.setSpring(cOUISpringForce2);
        cOUISpringAnimation2.setStartValue(0.0f);
        cOUISpringAnimation2.animateToFinalPosition(10000.0f);
    }

    private void calculatePivot() {
        int i10 = this.mShowDirection;
        float f10 = 0.0f;
        if (i10 != 4 && i10 != 128) {
            if (i10 == 16) {
                f10 = 1.0f;
            }
            this.mPivotX = f10;
            this.mPivotY = ((this.mContentRectOnScreen.centerY() - this.mCoordsOnWindow.y) - this.mWindowLocationOnScreen[1]) / getViewportHeight();
            return;
        }
        if ((this.mContentRectOnScreen.centerX() - this.mWindowLocationOnScreen[0]) - this.mCoordsOnWindow.x >= getViewportWidth()) {
            this.mPivotX = 1.0f;
        } else if (getViewportWidth() != 0) {
            int centerX = (this.mContentRectOnScreen.centerX() - this.mWindowLocationOnScreen[0]) - this.mCoordsOnWindow.x;
            if (centerX <= 0) {
                centerX = -centerX;
            }
            this.mPivotX = centerX / getViewportWidth();
        } else {
            this.mPivotX = 0.5f;
        }
        if (this.mCoordsOnWindow.y >= this.mContentRectOnScreen.top - this.mWindowLocationOnScreen[1]) {
            this.mPivotY = 0.0f;
        } else {
            this.mPivotY = 1.0f;
        }
    }

    private void calculatePosition() {
        this.mParent.getWindowVisibleDisplayFrame(this.mViewPortOnScreen);
        registerOrientationHandler();
        Rect rect = new Rect();
        this.mContentRectOnScreen = rect;
        this.mAnchor.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        this.mParentRectOnScreen = rect2;
        this.mParent.getGlobalVisibleRect(rect2);
        int[] iArr = new int[2];
        this.mParent.getLocationOnScreen(iArr);
        this.mContentRectOnScreen.offset(iArr[0], iArr[1]);
        this.mParentRectOnScreen.offset(iArr[0], iArr[1]);
        int[] iArr2 = new int[2];
        Rect rect3 = this.mContentRectOnScreen;
        this.mWindowSpacingControlHelper.setOriginCenterPoint(new int[]{rect3.left, rect3.top}, iArr2, this.mAnchor);
        int width = this.mAnchor.getWidth();
        int height = this.mAnchor.getHeight();
        Rect rect4 = this.mContentRectOnScreen;
        int i10 = iArr2[0];
        int i11 = width / 2;
        rect4.left = i10 - i11;
        int i12 = iArr2[1];
        int i13 = height / 2;
        rect4.top = i12 - i13;
        rect4.right = i10 + i11;
        rect4.bottom = i12 + i13;
        Rect rect5 = this.mViewPortOnScreen;
        rect5.left = Math.max(rect5.left, this.mParentRectOnScreen.left);
        Rect rect6 = this.mViewPortOnScreen;
        rect6.top = Math.max(rect6.top, this.mParentRectOnScreen.top);
        Rect rect7 = this.mViewPortOnScreen;
        rect7.right = Math.min(rect7.right, this.mParentRectOnScreen.right);
        Rect rect8 = this.mViewPortOnScreen;
        rect8.bottom = Math.min(rect8.bottom, this.mParentRectOnScreen.bottom);
        sizePopupWindow();
        refreshCoordinated(this.mContentRectOnScreen);
        if (this.mIndicatorFollowContent) {
            prepareContent(this.mContentRectOnScreen, this.mHasIndicator, 0, 0);
        } else {
            prepareContent(this.mContentRectOnScreen, this.mHasIndicator, -this.mOffsetX, -this.mOffsetY);
        }
        setContentView(this.mContentContainer);
        calculatePivot();
        animateEnter();
        if (isLayoutRtl(this.mAnchor)) {
            this.mCoordsOnWindow.x -= this.mOffsetX;
        } else {
            this.mCoordsOnWindow.x += this.mOffsetX;
        }
        this.mCoordsOnWindow.y += this.mOffsetY;
    }

    private void checkViewTypeEnum(WindowSpacingControlHelper.AnchorViewTypeEnum anchorViewTypeEnum) {
        WindowSpacingControlHelper.AnchorViewTypeEnum anchorViewTypeEnum2 = this.mWindowSpacingControlHelper.getAnchorViewTypeEnum(this.mAnchor);
        if (anchorViewTypeEnum2 != WindowSpacingControlHelper.AnchorViewTypeEnum.TOOLBAR && anchorViewTypeEnum2 != WindowSpacingControlHelper.AnchorViewTypeEnum.NAVIGATION) {
            this.mArrowOverflow = getAnchorViewSpacing(anchorViewTypeEnum);
        }
    }

    private static ViewGroup createContentContainer(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissPopupWindow() {
        unregisterOrientationHandler();
        this.mParent = null;
        super.dismiss();
        this.mContentContainer.removeAllViews();
        this.mContentContainer.removeCallbacks(this.mCheckAnimateExit);
    }

    private int getViewportHeight() {
        int height = getHeight();
        Rect rect = this.mViewportOffset;
        return (height - rect.top) + rect.bottom;
    }

    private int getViewportWidth() {
        int width = getWidth();
        Rect rect = this.mViewportOffset;
        return (width - rect.left) + rect.right;
    }

    private void offsetRect(Rect rect, Rect rect2) {
        if (rect2 == null) {
            return;
        }
        rect.left += rect2.left;
        rect.top += rect2.top;
        rect.right += rect2.right;
        rect.bottom += rect2.bottom;
    }

    private void prepareContent(Rect rect, boolean z10, int i10, int i11) {
        this.mContentContainer.removeAllViews();
        this.mContentContainer.addView(this.mMainPanel);
        if (z10) {
            addIndicator(rect, i10, i11);
        }
    }

    private void refreshCoordinated(Rect rect) {
        int i10;
        int i11;
        int max;
        int viewportHeight;
        int i12;
        this.mArrowType = -1;
        int anchorViewSpacing = getAnchorViewSpacing(this.mWindowSpacingControlHelper.getAnchorViewTypeEnum(this.mAnchor));
        int i13 = this.mShowDirection;
        if (i13 == 4) {
            i11 = Math.min(rect.centerX() - (getViewportWidth() / 2), this.mViewPortOnScreen.right - getViewportWidth());
            int i14 = rect.top;
            Rect rect2 = this.mViewPortOnScreen;
            int i15 = i14 - rect2.top;
            int i16 = (rect2.bottom - rect.bottom) - anchorViewSpacing;
            viewportHeight = getViewportHeight();
            if (i15 >= viewportHeight) {
                this.mArrowType = 4;
                i12 = rect.top;
                max = i12 - viewportHeight;
            } else if (i16 >= viewportHeight) {
                this.mArrowType = 128;
                max = rect.bottom;
            } else if (i15 > i16) {
                this.mArrowType = 4;
                max = this.mViewPortOnScreen.top;
                setHeight(i15);
            } else {
                this.mArrowType = 128;
                max = rect.bottom;
                setHeight(i16);
            }
        } else if (i13 == 128) {
            i11 = Math.min(rect.centerX() - (getViewportWidth() / 2), this.mViewPortOnScreen.right - getViewportWidth());
            int i17 = rect.top;
            Rect rect3 = this.mViewPortOnScreen;
            int i18 = i17 - rect3.top;
            int i19 = (rect3.bottom - rect.bottom) - anchorViewSpacing;
            viewportHeight = getViewportHeight();
            if (i19 >= viewportHeight) {
                this.mArrowType = 128;
                max = rect.bottom;
            } else if (i18 >= viewportHeight) {
                this.mArrowType = 4;
                i12 = rect.top;
                max = i12 - viewportHeight;
            } else if (i18 > i19) {
                this.mArrowType = 4;
                max = this.mViewPortOnScreen.top;
                setHeight(i18);
            } else {
                this.mArrowType = 128;
                max = rect.bottom;
                setHeight(i19);
            }
        } else {
            if (i13 == 16) {
                i10 = rect.left - getViewportWidth();
            } else {
                i10 = rect.right;
            }
            i11 = i10;
            max = Math.max(rect.centerY() - (((getViewportHeight() + this.mMainPanel.getPaddingTop()) - this.mMainPanel.getPaddingBottom()) / 2), this.mViewPortOnScreen.top + this.mViewportOffset.top);
        }
        this.mParent.getRootView().getLocationOnScreen(this.mTmpCoords);
        int[] iArr = this.mTmpCoords;
        int i20 = iArr[0];
        int i21 = iArr[1];
        this.mParent.getRootView().getLocationInWindow(this.mTmpCoords);
        int[] iArr2 = this.mTmpCoords;
        int i22 = iArr2[0];
        int i23 = iArr2[1];
        int[] iArr3 = this.mWindowLocationOnScreen;
        int i24 = i20 - i22;
        iArr3[0] = i24;
        int i25 = i21 - i23;
        iArr3[1] = i25;
        int i26 = i11 - i24;
        Rect rect4 = this.mViewportOffset;
        int i27 = i26 - rect4.left;
        int i28 = (max - i25) - rect4.top;
        int i29 = this.mShowDirection;
        if (i29 == 8) {
            checkViewTypeEnum(WindowSpacingControlHelper.AnchorViewTypeEnum.END);
            i27 += this.mArrowOverflow;
        } else if (i29 == 16) {
            checkViewTypeEnum(WindowSpacingControlHelper.AnchorViewTypeEnum.START);
            i27 -= this.mArrowOverflow;
        } else {
            int i30 = this.mArrowType;
            if (i30 == 4) {
                checkViewTypeEnum(WindowSpacingControlHelper.AnchorViewTypeEnum.TOP);
                i28 -= this.mArrowOverflow;
            } else if (i30 == 128) {
                checkViewTypeEnum(WindowSpacingControlHelper.AnchorViewTypeEnum.BOTTOM);
                i28 += this.mArrowOverflow;
            }
        }
        this.mCoordsOnWindow.set(Math.max(0, i27), Math.max(0, i28));
    }

    private void registerOrientationHandler() {
        unregisterOrientationHandler();
        this.mParent.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolTipsAlphaProgress(float f10) {
        float f11 = f10 / 10000.0f;
        this.mToolTipsAnimationAlphaProgress = f11;
        float f12 = 1.0f;
        float f13 = 0.0f;
        if (this.mIsEntering) {
            f13 = 1.0f;
            f12 = 0.0f;
        }
        this.mContentContainer.setAlpha(UIUtil.getConvertedFraction(f12, f13, f11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolTipsScaleProgress(float f10) {
        float f11 = f10 / 10000.0f;
        this.mToolTipsAnimationScaleProgress = f11;
        float f12 = 1.0f;
        float f13 = 0.0f;
        if (this.mIsEntering) {
            f13 = 1.0f;
            f12 = 0.0f;
        }
        this.mContentContainer.setScaleX(UIUtil.getConvertedFraction(f12, f13, f11));
        this.mContentContainer.setScaleY(UIUtil.getConvertedFraction(f12, f13, this.mToolTipsAnimationScaleProgress));
    }

    private void showToolTips() {
        Activity contextToActivity = UIUtil.contextToActivity(this.mContext);
        if (contextToActivity != null && (contextToActivity.isFinishing() || contextToActivity.isDestroyed())) {
            return;
        }
        calculatePosition();
        View view = this.mParent;
        Point point = this.mCoordsOnWindow;
        showAtLocation(view, 0, point.x, point.y);
        UIUtil.safeForceHasOverlappingRendering(this.mContentContainer, false);
        for (ViewParent parent = this.mContentContainer.getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipToOutline(false);
            viewGroup.setClipChildren(false);
            UIUtil.safeForceHasOverlappingRendering((View) parent, false);
        }
    }

    private void sizePopupWindow() {
        Resources resources = this.mContext.getResources();
        int i10 = a9.d.f6567g1;
        int dimensionPixelSize = resources.getDimensionPixelSize(i10) + this.mMainPanel.getPaddingLeft() + this.mMainPanel.getPaddingRight();
        int i11 = this.mShowDirection;
        if (i11 == 8) {
            dimensionPixelSize = Math.min(this.mViewPortOnScreen.right - this.mContentRectOnScreen.right, dimensionPixelSize);
        } else if (i11 == 16) {
            dimensionPixelSize = Math.min(this.mContentRectOnScreen.left - this.mViewPortOnScreen.left, dimensionPixelSize);
        }
        Rect rect = this.mViewPortOnScreen;
        int max = Math.max(Math.min(rect.right - rect.left, dimensionPixelSize), 0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mScrollView.getLayoutParams();
        this.mContentTv.setMaxWidth((((max - this.mMainPanel.getPaddingLeft()) - this.mMainPanel.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
        this.mMainPanel.measure(0, 0);
        setWidth(Math.min(this.mMainPanel.getMeasuredWidth(), max));
        int measuredHeight = this.mMainPanel.getMeasuredHeight();
        Rect rect2 = this.mViewPortOnScreen;
        setHeight(Math.min(measuredHeight, rect2.bottom - rect2.top));
        if ((this.mContentRectOnScreen.centerY() - (((getViewportHeight() + this.mMainPanel.getPaddingTop()) - this.mMainPanel.getPaddingBottom()) / 2)) + getViewportHeight() >= this.mViewPortOnScreen.bottom) {
            this.mShowDirection = 4;
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(i10) + this.mMainPanel.getPaddingLeft() + this.mMainPanel.getPaddingRight();
            Rect rect3 = this.mViewPortOnScreen;
            int max2 = Math.max(Math.min(rect3.right - rect3.left, dimensionPixelSize2), 0);
            this.mContentTv.setMaxWidth((((max2 - this.mMainPanel.getPaddingLeft()) - this.mMainPanel.getPaddingRight()) - layoutParams.leftMargin) - layoutParams.rightMargin);
            this.mMainPanel.measure(0, 0);
            setWidth(Math.min(this.mMainPanel.getMeasuredWidth(), max2));
            setHeight(this.mMainPanel.getMeasuredHeight());
        }
    }

    private void unregisterOrientationHandler() {
        View view = this.mParent;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
    }

    public void calculateFakeBeyondScreenTips(View view, int i10, boolean z10, int i11, int i12) {
        if (isShowing()) {
            return;
        }
        this.mShowDirection = i10;
        this.mParent = view.getRootView();
        int i13 = this.mShowDirection;
        if (i13 == 32 || i13 == 64) {
            int i14 = 16;
            if (isLayoutRtl(view)) {
                if (this.mShowDirection == 32) {
                    i14 = 8;
                }
                this.mShowDirection = i14;
            } else {
                if (this.mShowDirection != 32) {
                    i14 = 8;
                }
                this.mShowDirection = i14;
            }
        }
        this.mAnchor = view;
        this.mParent.getWindowVisibleDisplayFrame(this.mViewPortOnScreen);
        registerOrientationHandler();
        Rect rect = new Rect();
        this.mContentRectOnScreen = rect;
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        this.mParentRectOnScreen = rect2;
        this.mParent.getGlobalVisibleRect(rect2);
        int[] iArr = new int[2];
        this.mParent.getLocationOnScreen(iArr);
        this.mContentRectOnScreen.offset(iArr[0], iArr[1]);
        this.mParentRectOnScreen.offset(iArr[0], iArr[1]);
        Rect rect3 = this.mViewPortOnScreen;
        rect3.left = Math.max(rect3.left, this.mParentRectOnScreen.left);
        Rect rect4 = this.mViewPortOnScreen;
        rect4.top = Math.max(rect4.top, this.mParentRectOnScreen.top);
        Rect rect5 = this.mViewPortOnScreen;
        rect5.right = Math.min(rect5.right, this.mParentRectOnScreen.right);
        Rect rect6 = this.mViewPortOnScreen;
        rect6.bottom = Math.min(rect6.bottom, this.mParentRectOnScreen.bottom);
        sizePopupWindow();
        refreshCoordinated(this.mContentRectOnScreen);
        prepareContent(this.mContentRectOnScreen, z10, -i11, -i12);
        setContentView(this.mContentContainer);
        calculatePivot();
        animateEnter();
        if (isLayoutRtl(this.mAnchor)) {
            this.mCoordsOnWindow.x -= this.mOffsetX;
        } else {
            this.mCoordsOnWindow.x += this.mOffsetX;
        }
        this.mCoordsOnWindow.y += i12;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        unregisterOrientationHandler();
        if (!this.mIsDismissing) {
            animateExit();
        } else {
            dismissPopupWindow();
            this.mIsDismissing = false;
        }
    }

    public void dismissImmediately() {
        dismissPopupWindow();
        this.mIsDismissing = false;
    }

    public TextView getContentTv() {
        return this.mContentTv;
    }

    public ImageView getDismissIv() {
        return this.mDismissIv;
    }

    public void hideDismissButton() {
        this.mDismissIv.setVisibility(8);
    }

    public void init(int i10) {
        int i11;
        int i12;
        int i13;
        Drawable drawable;
        Drawable drawable2;
        this.mMode = i10;
        if (i10 == 0) {
            i11 = a9.b.f6475m;
            if (COUIContextUtil.isCOUIDarkTheme(this.mContext)) {
                i12 = l.f6704j;
            } else {
                i12 = l.f6703i;
            }
        } else {
            i11 = a9.b.f6474l;
            if (COUIContextUtil.isCOUIDarkTheme(this.mContext)) {
                i12 = l.f6706l;
            } else {
                i12 = l.f6705k;
            }
        }
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, m.f6860h2, i11, i12);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(m.f6884n2);
        drawable3.setDither(true);
        this.mArrowUpDrawable = obtainStyledAttributes.getDrawable(m.f6880m2);
        this.mArrowDownDrawable = obtainStyledAttributes.getDrawable(m.f6864i2);
        this.mArrowLeftDrawable = obtainStyledAttributes.getDrawable(m.f6868j2);
        this.mArrowRightDrawable = obtainStyledAttributes.getDrawable(m.f6876l2);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(m.f6872k2, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(m.f6912u2, 0);
        int i14 = obtainStyledAttributes.getInt(m.f6888o2, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(m.f6900r2, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(m.f6904s2, 0);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(m.f6896q2, 0);
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(m.f6892p2, 0);
        this.mContentTextColor = obtainStyledAttributes.getColorStateList(m.f6908t2);
        int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(m.f6924x2, 0);
        int dimensionPixelSize8 = obtainStyledAttributes.getDimensionPixelSize(m.f6928y2, 0);
        int dimensionPixelSize9 = obtainStyledAttributes.getDimensionPixelSize(m.f6920w2, 0);
        int dimensionPixelSize10 = obtainStyledAttributes.getDimensionPixelSize(m.f6916v2, 0);
        final int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a9.d.f6582o);
        obtainStyledAttributes.recycle();
        this.mAnimationInterpolator = new COUIMoveEaseInterpolator();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(h.f6671n, (ViewGroup) null);
        this.mMainPanel = viewGroup;
        viewGroup.setBackground(drawable3);
        this.mMainPanel.setMinimumWidth(dimensionPixelSize2);
        ViewGroup createContentContainer = createContentContainer(this.mContext);
        this.mContentContainer = createContentContainer;
        COUIDarkModeUtil.setForceDarkAllow(createContentContainer, false);
        TextView textView = (TextView) this.mMainPanel.findViewById(a9.f.f6636f);
        this.mContentTv = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ScrollView scrollView = (ScrollView) this.mMainPanel.findViewById(a9.f.f6622L);
        this.mScrollView = scrollView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) scrollView.getLayoutParams();
        layoutParams.gravity = i14;
        layoutParams.setMargins(dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize5, dimensionPixelSize6);
        layoutParams.setMarginStart(dimensionPixelSize3);
        layoutParams.setMarginEnd(dimensionPixelSize5);
        this.mScrollView.setLayoutParams(layoutParams);
        float f10 = this.mContext.getResources().getConfiguration().fontScale;
        Resources resources = this.mContext.getResources();
        if (i10 == 0) {
            i13 = a9.d.f6564f1;
        } else {
            i13 = a9.d.f6552b1;
        }
        this.mContentTv.setTextSize(0, (int) COUIChangeTextUtil.getSuitableFontSize(resources.getDimensionPixelSize(i13), f10, 4));
        ColorStateList colorStateList = this.mContentTextColor;
        if (colorStateList != null) {
            this.mContentTv.setTextColor(colorStateList);
        }
        ImageView imageView = (ImageView) this.mMainPanel.findViewById(a9.f.f6654x);
        this.mDismissIv = imageView;
        if (i10 == 0) {
            imageView.setVisibility(0);
            this.mDismissIv.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.tooltips.COUIToolTips.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIToolTips.this.dismiss();
                    if (COUIToolTips.this.mOnCloseIconClickListener != null) {
                        COUIToolTips.this.mOnCloseIconClickListener.onCloseIconClick();
                    }
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        this.mDismissIv.post(new Runnable() { // from class: com.coui.appcompat.tooltips.COUIToolTips.7
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                C1698b.a(COUIToolTips.this.mMainPanel, COUIToolTips.this.mDismissIv, rect);
                int i15 = dimensionPixelOffset;
                rect.inset(-i15, -i15);
                COUIToolTips.this.mMainPanel.setTouchDelegate(new TouchDelegate(rect, COUIToolTips.this.mDismissIv));
            }
        });
        if (!isLayoutRtl(this.mMainPanel)) {
            this.mViewportOffset = new Rect(dimensionPixelSize7, dimensionPixelSize8, dimensionPixelSize9, dimensionPixelSize10);
        } else {
            this.mViewportOffset = new Rect(dimensionPixelSize9, dimensionPixelSize8, dimensionPixelSize7, dimensionPixelSize10);
        }
        setClippingEnabled(false);
        setAnimationStyle(0);
        setElevation(this.mContext.getResources().getDimensionPixelOffset(f.f4544L5));
        setOnDismissListener(this.mOnPopupWindowDismissListener);
        ImageView imageView2 = this.mArrowView;
        if (imageView2 != null) {
            int i15 = this.mShowDirection;
            if (i15 != 4 && i15 != 128) {
                if (this.mLeftOrTop) {
                    drawable2 = this.mArrowRightDrawable;
                } else {
                    drawable2 = this.mArrowLeftDrawable;
                }
                imageView2.setBackground(drawable2);
            } else {
                if (this.mLeftOrTop) {
                    drawable = this.mArrowUpDrawable;
                } else {
                    drawable = this.mArrowDownDrawable;
                }
                imageView2.setBackground(drawable);
            }
        }
        this.mIsOutLineBackgroundInPopupWindow = false;
        setElevationInPopupwindow(false);
        int dimensionPixelSize11 = dimensionPixelSize + this.mContext.getResources().getDimensionPixelSize(a9.d.f6520M0);
        int dimensionPixelSize12 = dimensionPixelSize + this.mContext.getResources().getDimensionPixelSize(a9.d.f6518L0);
        addSpacingControlUtil(dimensionPixelSize11, WindowSpacingControlHelper.AnchorViewTypeEnum.TOP);
        addSpacingControlUtil(dimensionPixelSize12, WindowSpacingControlHelper.AnchorViewTypeEnum.BOTTOM);
        addSpacingControlUtil(dimensionPixelSize, WindowSpacingControlHelper.AnchorViewTypeEnum.START);
        addSpacingControlUtil(dimensionPixelSize, WindowSpacingControlHelper.AnchorViewTypeEnum.END);
        addSpacingControlUtil(this.mContext.getResources().getDimensionPixelSize(a9.d.f6514J0), WindowSpacingControlHelper.AnchorViewTypeEnum.NAVIGATION);
        addSpacingControlUtil(this.mContext.getResources().getDimensionPixelSize(a9.d.f6516K0), WindowSpacingControlHelper.AnchorViewTypeEnum.TOOLBAR);
        this.mIndicatorEmbedDistance = this.mContext.getResources().getDimensionPixelSize(a9.d.f6512I0);
    }

    @Override // com.coui.appcompat.poplist.COUIPopupWindow
    public void initPopupWindowBackground(Context context, TypedArray typedArray) {
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public boolean isLayoutRtl(View view) {
        if (view.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public void refresh() {
        int i10;
        int i11;
        Drawable drawable;
        Drawable drawable2;
        if (this.mMode == 0) {
            i10 = a9.b.f6475m;
            i11 = l.f6703i;
        } else {
            i10 = a9.b.f6474l;
            i11 = l.f6705k;
        }
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, m.f6860h2, i10, i11);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(m.f6884n2);
        drawable3.setDither(true);
        this.mArrowUpDrawable = obtainStyledAttributes.getDrawable(m.f6880m2);
        this.mArrowDownDrawable = obtainStyledAttributes.getDrawable(m.f6864i2);
        this.mArrowLeftDrawable = obtainStyledAttributes.getDrawable(m.f6868j2);
        this.mArrowRightDrawable = obtainStyledAttributes.getDrawable(m.f6876l2);
        this.mArrowOverflow = obtainStyledAttributes.getDimensionPixelSize(m.f6872k2, 0);
        this.mContentTextColor = obtainStyledAttributes.getColorStateList(m.f6908t2);
        obtainStyledAttributes.recycle();
        this.mMainPanel.setBackground(drawable3);
        ColorStateList colorStateList = this.mContentTextColor;
        if (colorStateList != null) {
            this.mContentTv.setTextColor(colorStateList);
        }
        ImageView imageView = this.mArrowView;
        if (imageView != null) {
            int i12 = this.mShowDirection;
            if (i12 != 4 && i12 != 128) {
                if (this.mLeftOrTop) {
                    drawable2 = this.mArrowRightDrawable;
                } else {
                    drawable2 = this.mArrowLeftDrawable;
                }
                imageView.setBackground(drawable2);
                return;
            }
            if (this.mLeftOrTop) {
                drawable = this.mArrowUpDrawable;
            } else {
                drawable = this.mArrowDownDrawable;
            }
            imageView.setBackground(drawable);
        }
    }

    public void refreshWhileLayoutChange() {
        Activity contextToActivity = UIUtil.contextToActivity(this.mContext);
        if (contextToActivity != null && (contextToActivity.isFinishing() || contextToActivity.isDestroyed())) {
            COUILog.e(TAG, "activity is not active when refreshWhileLayoutChange");
            return;
        }
        if (UIUtil.isInVisibleRect(this.mAnchor)) {
            calculatePosition();
            Point point = this.mCoordsOnWindow;
            update(point.x, point.y, getWidth(), getHeight());
        } else {
            dismissImmediately();
            COUILog.e(TAG, "mAnchor is now visible, so dismiss it.");
        }
    }

    public void setArrowOverflow(int i10) {
        this.mArrowOverflow = i10;
    }

    public void setContent(CharSequence charSequence) {
        this.mContentTv.setText(charSequence);
    }

    public void setContentTextColor(int i10) {
        setContentTextColor(ColorStateList.valueOf(i10));
    }

    public void setDismissOnTouchOutside(boolean z10) {
        if (z10) {
            setTouchable(true);
            setFocusable(true);
            setOutsideTouchable(true);
        } else {
            setFocusable(false);
            setOutsideTouchable(false);
        }
        update();
    }

    public void setOnCloseIconClickListener(OnCloseIconClickListener onCloseIconClickListener) {
        this.mOnCloseIconClickListener = onCloseIconClickListener;
    }

    public void show(View view) {
        show(view, true);
    }

    public void showWithDirection(View view, int i10) {
        showWithDirection(view, i10, true);
    }

    @Deprecated
    public COUIToolTips(Window window, int i10) {
        super(window.getContext());
        this.mTmpCoords = new int[2];
        this.mCoordsOnWindow = new Point();
        this.mToolTipsScaleProperty = new d<Float>("toolTipsScaleProperty") { // from class: com.coui.appcompat.tooltips.COUIToolTips.1
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(Float f10) {
                return COUIToolTips.this.mToolTipsAnimationScaleProgress;
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(Float f10, float f11) {
                COUIToolTips.this.setToolTipsScaleProgress(f11);
            }
        };
        this.mToolTipsAlphaProperty = new d<Float>("toolTipsAlphaProperty") { // from class: com.coui.appcompat.tooltips.COUIToolTips.2
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(Float f10) {
                return COUIToolTips.this.mToolTipsAnimationAlphaProgress;
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(Float f10, float f11) {
                COUIToolTips.this.setToolTipsAlphaProgress(f11);
            }
        };
        this.mViewPortOnScreen = new Rect();
        this.mLeftOrTop = false;
        this.mShowDirection = 4;
        this.mWindowLocationOnScreen = new int[2];
        this.mArrowType = -1;
        this.mToolTipsAnimationScaleProgress = 0.0f;
        this.mToolTipsAnimationAlphaProgress = 0.0f;
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.coui.appcompat.tooltips.COUIToolTips.3
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                Rect rect = new Rect(i11, i12, i13, i14);
                Rect rect2 = new Rect(i15, i16, i17, i18);
                if (COUIToolTips.this.isShowing() && !rect.equals(rect2) && COUIToolTips.this.mAnchor != null) {
                    try {
                        COUIToolTips.this.refreshWhileLayoutChange();
                    } catch (Exception e10) {
                        Log.e(COUIToolTips.TAG, "refreshWhileLayoutChange fail,e:" + e10.getMessage());
                    }
                }
            }
        };
        this.mOnPopupWindowDismissListener = new PopupWindow.OnDismissListener() { // from class: com.coui.appcompat.tooltips.COUIToolTips.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                COUIToolTips.this.mContentContainer.removeAllViews();
            }
        };
        this.mCheckAnimateExit = new Runnable() { // from class: com.coui.appcompat.tooltips.COUIToolTips.5
            @Override // java.lang.Runnable
            public void run() {
                if (COUIToolTips.this.mIsDismissing) {
                    COUIToolTips.this.dismissPopupWindow();
                    COUIToolTips.this.mIsDismissing = false;
                }
            }
        };
        this.mContext = window.getContext();
        init(i10);
    }

    public void setContent(View view) {
        this.mScrollView.removeAllViews();
        this.mScrollView.addView(view);
    }

    public void setContentTextColor(ColorStateList colorStateList) {
        this.mContentTv.setTextColor(colorStateList);
    }

    public void show(View view, boolean z10) {
        showWithDirection(view, 4, z10);
    }

    public void showWithDirection(View view, int i10, boolean z10) {
        showWithDirection(view, i10, z10, 0, 0);
    }

    public void showWithDirection(View view, int i10, boolean z10, int i11, int i12) {
        showWithDirection(view, i10, z10, i11, i12, false);
    }

    public void showWithDirection(View view, int i10, boolean z10, int i11, int i12, boolean z11) {
        if (isShowing()) {
            return;
        }
        WindowSpacingControlHelper.AnchorViewTypeEnum anchorViewTypeEnum = this.mWindowSpacingControlHelper.getAnchorViewTypeEnum(view);
        if (anchorViewTypeEnum == WindowSpacingControlHelper.AnchorViewTypeEnum.TOOLBAR) {
            this.mArrowOverflow = getAnchorViewSpacing(anchorViewTypeEnum);
        } else if (anchorViewTypeEnum == WindowSpacingControlHelper.AnchorViewTypeEnum.NAVIGATION) {
            this.mArrowOverflow = getAnchorViewSpacing(view, anchorViewTypeEnum);
        }
        this.mParent = view.getRootView();
        this.mHasIndicator = z10;
        this.mIndicatorFollowContent = z11;
        this.mOffsetX = i11;
        this.mOffsetY = i12;
        this.mShowDirection = i10;
        if (i10 == 32 || i10 == 64) {
            if (isLayoutRtl(view)) {
                this.mShowDirection = this.mShowDirection == 32 ? 8 : 16;
            } else {
                this.mShowDirection = this.mShowDirection != 32 ? 8 : 16;
            }
        }
        this.mAnchor = view;
        try {
            showToolTips();
        } catch (Exception e10) {
            Log.e(TAG, "showToolTips fail,e:" + e10.getMessage());
        }
        this.mContentContainer.removeCallbacks(this.mCheckAnimateExit);
    }

    public COUIToolTips(Context context) {
        this(context, 0);
    }

    public COUIToolTips(Context context, int i10) {
        super(context);
        this.mTmpCoords = new int[2];
        this.mCoordsOnWindow = new Point();
        this.mToolTipsScaleProperty = new d<Float>("toolTipsScaleProperty") { // from class: com.coui.appcompat.tooltips.COUIToolTips.1
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(Float f10) {
                return COUIToolTips.this.mToolTipsAnimationScaleProgress;
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(Float f10, float f11) {
                COUIToolTips.this.setToolTipsScaleProgress(f11);
            }
        };
        this.mToolTipsAlphaProperty = new d<Float>("toolTipsAlphaProperty") { // from class: com.coui.appcompat.tooltips.COUIToolTips.2
            @Override // androidx.dynamicanimation.animation.d
            public float getValue(Float f10) {
                return COUIToolTips.this.mToolTipsAnimationAlphaProgress;
            }

            @Override // androidx.dynamicanimation.animation.d
            public void setValue(Float f10, float f11) {
                COUIToolTips.this.setToolTipsAlphaProgress(f11);
            }
        };
        this.mViewPortOnScreen = new Rect();
        this.mLeftOrTop = false;
        this.mShowDirection = 4;
        this.mWindowLocationOnScreen = new int[2];
        this.mArrowType = -1;
        this.mToolTipsAnimationScaleProgress = 0.0f;
        this.mToolTipsAnimationAlphaProgress = 0.0f;
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.coui.appcompat.tooltips.COUIToolTips.3
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                Rect rect = new Rect(i11, i12, i13, i14);
                Rect rect2 = new Rect(i15, i16, i17, i18);
                if (COUIToolTips.this.isShowing() && !rect.equals(rect2) && COUIToolTips.this.mAnchor != null) {
                    try {
                        COUIToolTips.this.refreshWhileLayoutChange();
                    } catch (Exception e10) {
                        Log.e(COUIToolTips.TAG, "refreshWhileLayoutChange fail,e:" + e10.getMessage());
                    }
                }
            }
        };
        this.mOnPopupWindowDismissListener = new PopupWindow.OnDismissListener() { // from class: com.coui.appcompat.tooltips.COUIToolTips.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                COUIToolTips.this.mContentContainer.removeAllViews();
            }
        };
        this.mCheckAnimateExit = new Runnable() { // from class: com.coui.appcompat.tooltips.COUIToolTips.5
            @Override // java.lang.Runnable
            public void run() {
                if (COUIToolTips.this.mIsDismissing) {
                    COUIToolTips.this.dismissPopupWindow();
                    COUIToolTips.this.mIsDismissing = false;
                }
            }
        };
        this.mContext = context;
        init(i10);
    }

    @Deprecated
    public void setDelay(int i10) {
    }
}
