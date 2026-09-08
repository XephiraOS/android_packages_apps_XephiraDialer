package com.coui.appcompat.scrollview;

import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import com.coui.appcompat.animation.COUIPhysicalAnimationUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.scroll.COUIIOverScroller;
import com.coui.appcompat.scroll.SpringOverScroller;
import com.coui.appcompat.version.COUIVersionUtil;
import com.coui.appcompat.view.ViewNative;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUIHorizontalScrollView extends HorizontalScrollView {
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final float DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE = 20.0f;
    private static final int DEFAULT_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD = 2500;
    private static final double DEGREE_TO_ARC_CONSTANT = 0.017453292519943295d;
    private static final int FLING_SCROLL_THRESHOLD = 1500;
    private static final float HORIZONTAL_SPRING_BACK_TENSION_MULTIPLE = 3.2f;
    private static final int INVALID_POINTER = -1;
    private static final int OVER_SCROLL_TOUCH_DURATION_THRESHOLD = 100;
    private static final int OVER_SCROLL_TOUCH_OFFSET_THRESHOLD = 10;
    private static final int SLOW_SCROLL_THRESHOLD = 250;
    private static final String TAG = "COUIHorScrollView";
    private float mAbortVelocityX;
    private int mActivePointerId;
    private boolean mAvoidAccidentalTouch;
    private View mChildToScrollTo;
    private int mDispatchEventVelocityThreshold;
    private boolean mEnableDispatchEventWhileOverScrolling;
    private boolean mEnableDispatchEventWhileScrolling;
    private boolean mEnableOptimizedScroll;
    private boolean mEnableVibrator;
    private float mEventFilterAngle;
    private float mFastFlingVelocity;
    private boolean mFillViewport;
    private boolean mFlingStrictSpan;
    private float mFlingVelocityX;
    private float mHorizontalScrollFactor;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsBeingDragged;
    private Boolean mIsColorDevice;
    private boolean mIsLayoutDirty;
    private boolean mIsTouchDownWhileOverScrolling;
    private boolean mIsTouchDownWhileSlowScrolling;
    private boolean mItemClickableWhileOverScrolling;
    private boolean mItemClickableWhileSlowScrolling;
    private int mLastMotionX;
    private long mLastScroll;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private COUIIOverScroller mOverScroller;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private int mScreenWidth;
    private boolean mScrollStrictSpan;
    private boolean mSmoothScrollingEnabled;
    private SpringOverScroller mSpringOverScroller;
    private final Rect mTempRect;
    private int mTouchSlop;
    private long mTouchTime;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public static class COUISavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<COUISavedState> CREATOR = new Parcelable.Creator<COUISavedState>() { // from class: com.coui.appcompat.scrollview.COUIHorizontalScrollView.COUISavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public COUISavedState createFromParcel(Parcel parcel) {
                return new COUISavedState(parcel, COUISavedState.class.getClassLoader());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public COUISavedState[] newArray(int i10) {
                return new COUISavedState[i10];
            }
        };
        public int scrollOffsetFromStart;

        public COUISavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollOffsetFromStart + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.scrollOffsetFromStart);
        }

        public COUISavedState(Parcel parcel) {
            super(parcel);
            this.scrollOffsetFromStart = parcel.readInt();
        }

        public COUISavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.scrollOffsetFromStart = parcel.readInt();
        }
    }

    public COUIHorizontalScrollView(Context context) {
        this(context, null);
    }

    private boolean canScroll() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getWidth() >= childAt.getWidth() + getPaddingLeft() + getPaddingRight()) {
            return false;
        }
        return true;
    }

    private boolean dispatchClickEvent(View view, MotionEvent motionEvent) {
        boolean z10 = true;
        int[] iArr = {0, 1};
        for (int i10 = 0; i10 < 2; i10++) {
            motionEvent.setAction(iArr[i10]);
            z10 &= view.dispatchTouchEvent(motionEvent);
        }
        return z10;
    }

    private void doScrollX(int i10) {
        if (i10 != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothCOUIScrollBy(i10, 0);
            } else {
                scrollBy(i10, 0);
            }
        }
    }

    private View findFocusableViewInBounds(boolean z10, int i10, int i11) {
        boolean z11;
        boolean z12;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z13 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view2 = focusables.get(i12);
            int left = view2.getLeft();
            int right = view2.getRight();
            if (i10 < right && left < i11) {
                if (i10 < left && right < i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (view == null) {
                    view = view2;
                    z13 = z11;
                } else {
                    if ((z10 && left < view.getLeft()) || (!z10 && right > view.getRight())) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z13) {
                        if (z11) {
                            if (!z12) {
                            }
                            view = view2;
                        }
                    } else if (z11) {
                        view = view2;
                        z13 = true;
                    } else {
                        if (!z12) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private View findFocusableViewInMyBounds(boolean z10, int i10, View view) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        int i11 = i10 + horizontalFadingEdgeLength;
        int width = (i10 + getWidth()) - horizontalFadingEdgeLength;
        if (view != null && view.getLeft() < width && view.getRight() > i11) {
            return view;
        }
        return findFocusableViewInBounds(z10, i11, width);
    }

    private View findViewToDispatchClickEvent(MotionEvent motionEvent) {
        View view = null;
        if (!isClickEvent(motionEvent)) {
            return null;
        }
        Rect rect = new Rect();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0 || childAt.getAnimation() != null) {
                childAt.getHitRect(rect);
                boolean contains = rect.contains(((int) motionEvent.getX()) + getScrollX(), ((int) motionEvent.getY()) + getScrollY());
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.offsetLocation(getScrollX() - childAt.getLeft(), getScrollY() - childAt.getTop());
                if (contains && dispatchClickEvent(childAt, obtain)) {
                    view = childAt;
                }
                obtain.recycle();
            }
        }
        return view;
    }

    private int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        return Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight()));
    }

    private float getVelocityAlongScrollableDirection() {
        if (this.mOverScroller != null && (getNestedScrollAxes() & 2) == 0) {
            return this.mOverScroller.getCurrVelocityX();
        }
        return 0.0f;
    }

    private boolean hookIfNeedInterceptMoveEvent(float f10, float f11) {
        if ((!this.mEnableDispatchEventWhileScrolling && (!this.mEnableDispatchEventWhileOverScrolling || !isOverScrolling())) || f11 == 0.0f || Math.abs(f10 / f11) > Math.tan(this.mEventFilterAngle * DEGREE_TO_ARC_CONSTANT)) {
            return true;
        }
        return false;
    }

    private boolean inChild(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollX = getScrollX();
        View childAt = getChildAt(0);
        if (i11 < childAt.getTop() || i11 >= childAt.getBottom() || i10 < childAt.getLeft() - scrollX || i10 >= childAt.getRight() - scrollX) {
            return false;
        }
        return true;
    }

    private void initCOUIHorizontalScrollView(Context context) {
        if (this.mOverScroller == null) {
            SpringOverScroller springOverScroller = new SpringOverScroller(context);
            this.mSpringOverScroller = springOverScroller;
            springOverScroller.setSpringBackTensionMultiple(HORIZONTAL_SPRING_BACK_TENSION_MULTIPLE);
            this.mSpringOverScroller.setIsScrollView(true);
            this.mOverScroller = this.mSpringOverScroller;
            setEnableFlingSpeedIncrease(true);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        int i10 = displayMetrics.widthPixels;
        this.mOverscrollDistance = i10;
        this.mOverflingDistance = i10;
        this.mScreenWidth = i10;
        this.mHorizontalScrollFactor = viewConfiguration.getScaledHorizontalScrollFactor();
        setOverScrollMode(0);
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isClickEvent(MotionEvent motionEvent) {
        int x10 = (int) (motionEvent.getX() - this.mInitialTouchX);
        int sqrt = (int) Math.sqrt(x10 * x10);
        if (System.currentTimeMillis() - this.mTouchTime < 100 && sqrt < 10) {
            return true;
        }
        return false;
    }

    private Boolean isColorDevice() {
        if (this.mIsColorDevice == null) {
            this.mIsColorDevice = Boolean.valueOf(COUIVersionUtil.isColorOS());
        }
        return this.mIsColorDevice;
    }

    private boolean isFastFling(float f10, float f11) {
        if (this.mAvoidAccidentalTouch && Math.abs(f10) <= this.mFastFlingVelocity && Math.abs(f11) <= this.mFastFlingVelocity) {
            return false;
        }
        return true;
    }

    private boolean isOffScreen(View view) {
        return !isWithinDeltaOfScreen(view, 0);
    }

    private boolean isOverScrolling() {
        if (getScrollX() >= 0 && getScrollX() <= getScrollRange()) {
            return false;
        }
        return true;
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        if ((parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2)) {
            return true;
        }
        return false;
    }

    private boolean isWithinDeltaOfScreen(View view, int i10) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (this.mTempRect.right + i10 >= getScrollX() && this.mTempRect.left - i10 <= getScrollX() + getWidth()) {
            return true;
        }
        return false;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i10;
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            if (action == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            int x10 = (int) motionEvent.getX(i10);
            this.mLastMotionX = x10;
            this.mInitialTouchX = x10;
            this.mInitialTouchY = (int) motionEvent.getY(i10);
            this.mActivePointerId = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void performFeedback() {
        if (this.mEnableVibrator) {
            performHapticFeedback(COUIHapticFeedbackConstants.EDGE_LIST_VIBRATE);
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private boolean scrollAndFocus(int i10, int i11, int i12) {
        boolean z10;
        int i13;
        int width = getWidth();
        int scrollX = getScrollX();
        int i14 = width + scrollX;
        boolean z11 = false;
        if (i10 == 17) {
            z10 = true;
        } else {
            z10 = false;
        }
        View findFocusableViewInBounds = findFocusableViewInBounds(z10, i11, i12);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i11 < scrollX || i12 > i14) {
            if (z10) {
                i13 = i11 - scrollX;
            } else {
                i13 = i12 - i14;
            }
            doScrollX(i13);
            z11 = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(i10);
        }
        return z11;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(computeScrollDeltaToGetChildRectOnScreen, 0);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z10) {
        boolean z11;
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (z10) {
                scrollBy(computeScrollDeltaToGetChildRectOnScreen, 0);
            } else {
                smoothCOUIScrollBy(computeScrollDeltaToGetChildRectOnScreen, 0);
            }
        }
        return z11;
    }

    @Override // android.widget.HorizontalScrollView
    public boolean arrowScroll(int i10) {
        int right;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && isWithinDeltaOfScreen(findNextFocus, maxScrollAmount)) {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            doScrollX(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            findNextFocus.requestFocus(i10);
        } else {
            if (i10 == 17 && getScrollX() < maxScrollAmount) {
                maxScrollAmount = getScrollX();
            } else if (i10 == 66 && getChildCount() > 0 && (right = getChildAt(0).getRight() - (getScrollX() + getWidth())) < maxScrollAmount) {
                maxScrollAmount = right;
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 66) {
                maxScrollAmount = -maxScrollAmount;
            }
            doScrollX(maxScrollAmount);
        }
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
            return true;
        }
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void computeScroll() {
        COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
        if (cOUIIOverScroller != null && cOUIIOverScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int cOUICurrX = this.mOverScroller.getCOUICurrX();
            int cOUICurrY = this.mOverScroller.getCOUICurrY();
            if (scrollX != cOUICurrX || scrollY != cOUICurrY) {
                overScrollBy(cOUICurrX - scrollX, cOUICurrY - scrollY, scrollX, scrollY, getScrollRange(), 0, this.mOverflingDistance, 0, false);
                onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
            }
            if (!awakenScrollBars()) {
                postInvalidateOnAnimation();
                return;
            }
            return;
        }
        if (this.mFlingStrictSpan) {
            this.mFlingStrictSpan = false;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        COUIIOverScroller cOUIIOverScroller;
        if (this.mEnableDispatchEventWhileScrolling || (this.mEnableDispatchEventWhileOverScrolling && isOverScrolling())) {
            float velocityAlongScrollableDirection = getVelocityAlongScrollableDirection();
            if (motionEvent.getActionMasked() == 0 && this.mDispatchEventVelocityThreshold >= Math.abs(velocityAlongScrollableDirection)) {
                COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
                float f10 = 0.0f;
                if (cOUIIOverScroller2 != null && cOUIIOverScroller2.getCurrVelocityX() != 0.0f) {
                    f10 = this.mFlingVelocityX;
                }
                this.mAbortVelocityX = f10;
                COUIIOverScroller cOUIIOverScroller3 = this.mOverScroller;
                if (cOUIIOverScroller3 != null) {
                    cOUIIOverScroller3.abortAnimation();
                }
                stopNestedScroll();
            }
            if ((motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) && (cOUIIOverScroller = this.mOverScroller) != null && cOUIIOverScroller.springBack(getScrollX(), getScrollY(), 0, getScrollRange(), 0, 0)) {
                postInvalidateOnAnimation();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        int i10 = 66;
        if (!canScroll()) {
            if (!isFocused()) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 66);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(66)) {
                return false;
            }
            return true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 21) {
            if (keyCode != 22) {
                if (keyCode != 62) {
                    return false;
                }
                if (keyEvent.isShiftPressed()) {
                    i10 = 17;
                }
                pageScroll(i10);
                return false;
            }
            if (!keyEvent.isAltPressed()) {
                return arrowScroll(66);
            }
            return fullScroll(66);
        }
        if (!keyEvent.isAltPressed()) {
            return arrowScroll(17);
        }
        return fullScroll(17);
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i10) {
        int i11;
        this.mFlingVelocityX = i10;
        if (getChildCount() > 0) {
            int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
            int i12 = 0;
            int max = Math.max(0, (getChildAt(0).getRight() - getPaddingLeft()) - width);
            COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
            if (cOUIIOverScroller != null) {
                cOUIIOverScroller.fling(getScrollX(), getScrollY(), i10, 0, 0, max, 0, 0, width / 2, 0);
            }
            boolean z10 = true;
            if (!this.mFlingStrictSpan) {
                this.mFlingStrictSpan = true;
            }
            if (i10 <= 0) {
                z10 = false;
            }
            View findFocus = findFocus();
            COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
            if (cOUIIOverScroller2 != null) {
                i12 = cOUIIOverScroller2.getCOUIFinalX();
            }
            View findFocusableViewInMyBounds = findFocusableViewInMyBounds(z10, i12, findFocus);
            if (findFocusableViewInMyBounds == null) {
                findFocusableViewInMyBounds = this;
            }
            if (findFocusableViewInMyBounds != findFocus) {
                if (z10) {
                    i11 = 66;
                } else {
                    i11 = 17;
                }
                findFocusableViewInMyBounds.requestFocus(i11);
            }
            postInvalidateOnAnimation();
        }
    }

    @Override // android.widget.HorizontalScrollView
    public boolean fullScroll(int i10) {
        boolean z10;
        if (i10 == 66) {
            z10 = true;
        } else {
            z10 = false;
        }
        int width = getWidth();
        Rect rect = this.mTempRect;
        rect.left = 0;
        rect.right = width;
        if (z10 && getChildCount() > 0) {
            this.mTempRect.right = getChildAt(0).getRight();
            Rect rect2 = this.mTempRect;
            rect2.left = rect2.right - width;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(i10, rect3.left, rect3.right);
    }

    public int getScrollableRange() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void invalidateParentIfNeeded() {
        if (isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public boolean isEnableFlingSpeedIncrease() {
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            return springOverScroller.isEnableFlingSpeedIncrease();
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView
    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.widget.HorizontalScrollView
    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mScrollStrictSpan) {
            this.mScrollStrictSpan = false;
        }
        if (this.mFlingStrictSpan) {
            this.mFlingStrictSpan = false;
        }
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.cancelCallback();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f10;
        if (motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            if (motionEvent.isFromSource(2)) {
                if ((motionEvent.getMetaState() & 1) != 0) {
                    f10 = -motionEvent.getAxisValue(9);
                } else {
                    f10 = motionEvent.getAxisValue(10);
                }
            } else if (motionEvent.isFromSource(4194304)) {
                f10 = motionEvent.getAxisValue(26);
            } else {
                f10 = 0.0f;
            }
            int round = Math.round(f10 * this.mHorizontalScrollFactor);
            if (round != 0) {
                int scrollRange = getScrollRange();
                int scrollX = getScrollX();
                int i10 = round + scrollX;
                if (i10 < 0) {
                    scrollRange = 0;
                } else if (i10 <= scrollRange) {
                    scrollRange = i10;
                }
                if (scrollRange != scrollX) {
                    super.scrollTo(scrollRange, getScrollY());
                    return true;
                }
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f10;
        boolean z10;
        boolean z11;
        int action = motionEvent.getAction();
        boolean z12 = true;
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i10 = action & 255;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 5) {
                            if (i10 == 6) {
                                onSecondaryPointerUp(motionEvent);
                                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                                if (findPointerIndex == -1) {
                                    Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onInterceptTouchEvent ACTION_POINTER_UP");
                                } else {
                                    int x10 = (int) motionEvent.getX(findPointerIndex);
                                    this.mLastMotionX = x10;
                                    this.mInitialTouchX = x10;
                                    this.mInitialTouchY = (int) motionEvent.getY(findPointerIndex);
                                }
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            int x11 = (int) motionEvent.getX(actionIndex);
                            this.mLastMotionX = x11;
                            this.mInitialTouchX = x11;
                            this.mInitialTouchY = (int) motionEvent.getY(actionIndex);
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                        }
                    }
                } else {
                    int i11 = this.mActivePointerId;
                    if (i11 != -1) {
                        int findPointerIndex2 = motionEvent.findPointerIndex(i11);
                        if (findPointerIndex2 == -1) {
                            Log.e(TAG, "Invalid pointerId=" + i11 + " in onInterceptTouchEvent");
                        } else {
                            int x12 = (int) motionEvent.getX(findPointerIndex2);
                            int y10 = (int) motionEvent.getY(findPointerIndex2);
                            int abs = Math.abs(x12 - this.mInitialTouchX);
                            int abs2 = Math.abs(y10 - this.mInitialTouchY);
                            if (abs > this.mTouchSlop && (getNestedScrollAxes() & 1) == 0 && hookIfNeedInterceptMoveEvent(abs, abs2)) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionX = x12;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
            if (cOUIIOverScroller != null && cOUIIOverScroller.springBack(getScrollX(), getScrollY(), 0, getScrollRange(), 0, 0)) {
                postInvalidateOnAnimation();
            }
        } else {
            COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
            if (cOUIIOverScroller2 != null) {
                f10 = cOUIIOverScroller2.getCurrVelocityX();
            } else {
                f10 = 0.0f;
            }
            if (Math.abs(this.mFlingVelocityX) > 1500.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (Math.abs(f10) > 0.0f && Math.abs(f10) < 250.0f && z10) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.mIsTouchDownWhileSlowScrolling = z11;
            this.mIsTouchDownWhileOverScrolling = isOverScrolling();
            this.mTouchTime = System.currentTimeMillis();
            int x13 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (!inChild(x13, (int) motionEvent.getY())) {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            } else {
                this.mLastMotionX = x13;
                this.mInitialTouchX = x13;
                this.mInitialTouchY = y11;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                COUIIOverScroller cOUIIOverScroller3 = this.mOverScroller;
                if (cOUIIOverScroller3 == null || cOUIIOverScroller3.isCOUIFinished()) {
                    z12 = false;
                }
                this.mIsBeingDragged = z12;
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.mFillViewport && View.MeasureSpec.getMode(i10) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int paddingLeft = getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin;
            int paddingTop = getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin;
            int measuredWidth = getMeasuredWidth() - paddingLeft;
            if (childAt.getMeasuredWidth() < measuredWidth) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), ViewGroup.getChildMeasureSpec(i11, paddingTop, layoutParams.height));
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        int i12;
        if (getScrollY() != i11 || getScrollX() != i10) {
            if (isOverScrolling() && this.mFlingStrictSpan) {
                if (i10 >= getScrollRange()) {
                    i12 = getScrollRange();
                } else {
                    i12 = 0;
                }
                i10 = COUIPhysicalAnimationUtil.calcOverFlingDecelerateDist(i12, i10 - i12, this.mScreenWidth);
            }
            if (getOverScrollMode() == 2 || (getOverScrollMode() == 1 && getChildAt(0).getWidth() <= getScrollableRange())) {
                i10 = Math.min(Math.max(i10, 0), getScrollRange());
            }
            if (getScrollX() >= 0 && i10 < 0 && this.mFlingStrictSpan) {
                performFeedback();
                SpringOverScroller springOverScroller = this.mSpringOverScroller;
                if (springOverScroller != null) {
                    springOverScroller.notifyHorizontalEdgeReached(i10, 0, this.mOverflingDistance);
                }
            }
            if (getScrollX() <= getScrollRange() && i10 > getScrollRange() && this.mFlingStrictSpan) {
                performFeedback();
                SpringOverScroller springOverScroller2 = this.mSpringOverScroller;
                if (springOverScroller2 != null) {
                    springOverScroller2.notifyHorizontalEdgeReached(i10, getScrollRange(), this.mOverflingDistance);
                }
            }
            if (isColorDevice().booleanValue()) {
                ViewNative.setScrollX(this, i10);
                ViewNative.setScrollY(this, i11);
            } else {
                super.scrollTo(i10, i11);
            }
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        View findNextFocusFromRect;
        if (i10 == 2) {
            i10 = 66;
        } else if (i10 == 1) {
            i10 = 17;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i10);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i10);
        }
        if (findNextFocusFromRect == null || isOffScreen(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i10, rect);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        int i14 = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mOverscrollDistance = i14;
        this.mOverflingDistance = i14;
        this.mScreenWidth = i14;
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && isWithinDeltaOfScreen(findFocus, getRight() - getLeft())) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollX(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z10;
        boolean z11;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    } else if (this.mIsBeingDragged && getChildCount() > 0) {
                        COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
                        if (cOUIIOverScroller != null && cOUIIOverScroller.springBack(getScrollX(), getScrollY(), 0, getScrollRange(), 0, 0)) {
                            postInvalidateOnAnimation();
                        }
                        this.mActivePointerId = -1;
                        this.mIsBeingDragged = false;
                        recycleVelocityTracker();
                    }
                } else {
                    COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
                    if ((cOUIIOverScroller2 instanceof SpringOverScroller) && this.mEnableOptimizedScroll) {
                        ((SpringOverScroller) cOUIIOverScroller2).triggerCallback();
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    } else {
                        int x10 = (int) motionEvent.getX(findPointerIndex);
                        int i10 = this.mLastMotionX - x10;
                        if (!this.mIsBeingDragged && Math.abs(i10) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            i10 = i10 > 0 ? i10 - this.mTouchSlop : i10 + this.mTouchSlop;
                        }
                        if (this.mIsBeingDragged) {
                            this.mLastMotionX = x10;
                            int scrollRange = getScrollRange();
                            if (getScrollX() < 0) {
                                i10 = COUIPhysicalAnimationUtil.calcRealOverScrollDist(i10, getScrollX(), this.mOverscrollDistance);
                            } else if (getScrollX() > getScrollRange()) {
                                i10 = COUIPhysicalAnimationUtil.calcRealOverScrollDist(i10, getScrollX() - getScrollRange(), this.mOverscrollDistance);
                            }
                            if (overScrollBy(i10, 0, getScrollX(), 0, scrollRange, 0, this.mOverscrollDistance, 0, true) && !hasNestedScrollingParent()) {
                                this.mVelocityTracker.clear();
                            }
                        }
                    }
                }
            } else {
                boolean isOverScrolling = isOverScrolling();
                if (this.mItemClickableWhileSlowScrolling && this.mIsTouchDownWhileSlowScrolling) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (this.mItemClickableWhileOverScrolling && this.mIsTouchDownWhileOverScrolling && isOverScrolling) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z10 || z11) {
                    findViewToDispatchClickEvent(motionEvent);
                }
                if (this.mIsBeingDragged) {
                    initVelocityTrackerIfNotExists();
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        COUIIOverScroller cOUIIOverScroller3 = this.mOverScroller;
                        if (cOUIIOverScroller3 != null) {
                            cOUIIOverScroller3.setCurrVelocityX(-xVelocity);
                        }
                        if (getScrollX() < 0) {
                            if (xVelocity > -1500) {
                                COUIIOverScroller cOUIIOverScroller4 = this.mOverScroller;
                                if (cOUIIOverScroller4 != null && cOUIIOverScroller4.springBack(getScrollX(), getScrollY(), 0, getScrollRange(), 0, 0)) {
                                    postInvalidateOnAnimation();
                                }
                            } else {
                                fling(-xVelocity);
                            }
                        } else if (getScrollX() > getScrollRange()) {
                            if (xVelocity < FLING_SCROLL_THRESHOLD) {
                                COUIIOverScroller cOUIIOverScroller5 = this.mOverScroller;
                                if (cOUIIOverScroller5 != null && cOUIIOverScroller5.springBack(getScrollX(), getScrollY(), 0, getScrollRange(), 0, 0)) {
                                    postInvalidateOnAnimation();
                                }
                            } else {
                                fling(-xVelocity);
                            }
                        } else {
                            fling(-xVelocity);
                        }
                    } else {
                        COUIIOverScroller cOUIIOverScroller6 = this.mOverScroller;
                        if (cOUIIOverScroller6 != null && cOUIIOverScroller6.springBack(getScrollX(), getScrollY(), 0, getScrollRange(), 0, 0)) {
                            postInvalidateOnAnimation();
                        }
                    }
                    if (getScrollX() < 0 || getScrollX() > getScrollRange()) {
                        performFeedback();
                    }
                    this.mActivePointerId = -1;
                    this.mIsBeingDragged = false;
                    recycleVelocityTracker();
                } else {
                    COUIIOverScroller cOUIIOverScroller7 = this.mOverScroller;
                    if (cOUIIOverScroller7 != null && cOUIIOverScroller7.springBack(getScrollX(), getScrollY(), 0, getScrollRange(), 0, 0)) {
                        postInvalidateOnAnimation();
                    }
                }
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            COUIIOverScroller cOUIIOverScroller8 = this.mOverScroller;
            if (cOUIIOverScroller8 != null && !cOUIIOverScroller8.isCOUIFinished() && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            COUIIOverScroller cOUIIOverScroller9 = this.mOverScroller;
            if (cOUIIOverScroller9 != null && !cOUIIOverScroller9.isCOUIFinished()) {
                float f10 = 0.0f;
                if (this.mOverScroller.getCurrVelocityX() != 0.0f) {
                    f10 = this.mFlingVelocityX;
                }
                this.mAbortVelocityX = f10;
                this.mOverScroller.abortAnimation();
                if (this.mFlingStrictSpan) {
                    this.mFlingStrictSpan = false;
                }
            }
            int x11 = (int) motionEvent.getX();
            this.mLastMotionX = x11;
            this.mInitialTouchX = x11;
            this.mInitialTouchY = (int) motionEvent.getY();
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        return true;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        SpringOverScroller springOverScroller;
        super.onVisibilityChanged(view, i10);
        if (i10 != 0 && (springOverScroller = this.mSpringOverScroller) != null) {
            springOverScroller.abortAnimation();
            this.mSpringOverScroller.cancelCallback();
        }
    }

    @Override // android.view.View
    public boolean overScrollBy(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        onOverScrolled(i12 + i10, i13 + i11, false, false);
        return false;
    }

    @Override // android.widget.HorizontalScrollView
    public boolean pageScroll(int i10) {
        boolean z10;
        if (i10 == 66) {
            z10 = true;
        } else {
            z10 = false;
        }
        int width = getWidth();
        if (z10) {
            this.mTempRect.left = getScrollX() + width;
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (this.mTempRect.left + width > childAt.getRight()) {
                    this.mTempRect.left = childAt.getRight() - width;
                }
            }
        } else {
            this.mTempRect.left = getScrollX() - width;
            Rect rect = this.mTempRect;
            if (rect.left < 0) {
                rect.left = 0;
            }
        }
        Rect rect2 = this.mTempRect;
        int i11 = rect2.left;
        int i12 = width + i11;
        rect2.right = i12;
        return scrollAndFocus(i10, i11, i12);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (view2 != null && view2.getRevealOnFocusHint()) {
            if (!this.mIsLayoutDirty) {
                scrollToChild(view2);
            } else {
                this.mChildToScrollTo = view2;
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    public void setAvoidAccidentalTouch(boolean z10) {
        this.mAvoidAccidentalTouch = z10;
    }

    public void setDispatchEventWhileOverScrolling(boolean z10) {
        this.mEnableDispatchEventWhileOverScrolling = z10;
    }

    public void setDispatchEventWhileScrolling(boolean z10) {
        this.mEnableDispatchEventWhileScrolling = z10;
    }

    public void setDispatchEventWhileScrollingThreshold(int i10) {
        this.mDispatchEventVelocityThreshold = i10;
    }

    public void setEnableFlingSpeedIncrease(boolean z10) {
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.setEnableFlingSpeedIncrease(z10);
        }
    }

    public void setEventFilterTangent(float f10) {
        this.mEventFilterAngle = f10;
    }

    public void setFastFlingThreshold(float f10) {
        this.mFastFlingVelocity = Math.max(f10, 0.0f);
    }

    @Override // android.widget.HorizontalScrollView
    public void setFillViewport(boolean z10) {
        if (z10 != this.mFillViewport) {
            this.mFillViewport = z10;
            requestLayout();
        }
    }

    public void setIsUseOptimizedScroll(boolean z10) {
        this.mEnableOptimizedScroll = z10;
    }

    public void setItemClickableWhileOverScrolling(boolean z10) {
        this.mItemClickableWhileOverScrolling = z10;
    }

    public void setItemClickableWhileSlowScrolling(boolean z10) {
        this.mItemClickableWhileSlowScrolling = z10;
    }

    @Override // android.widget.HorizontalScrollView
    public void setSmoothScrollingEnabled(boolean z10) {
        this.mSmoothScrollingEnabled = z10;
    }

    public void setSpringOverScrollerDebug(boolean z10) {
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.setDebug(z10);
        }
    }

    public final void smoothCOUIScrollBy(int i10, int i11) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            int max = Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingRight()) - getPaddingLeft()));
            int scrollX = getScrollX();
            int max2 = Math.max(0, Math.min(i10 + scrollX, max)) - scrollX;
            COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
            if (cOUIIOverScroller != null) {
                cOUIIOverScroller.startScroll(scrollX, getScrollY(), max2, 0);
            }
            postInvalidateOnAnimation();
        } else {
            COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
            if (cOUIIOverScroller2 != null && !cOUIIOverScroller2.isCOUIFinished()) {
                float f10 = 0.0f;
                if (this.mOverScroller.getCurrVelocityX() != 0.0f) {
                    f10 = this.mFlingVelocityX;
                }
                this.mAbortVelocityX = f10;
                this.mOverScroller.abortAnimation();
                if (this.mFlingStrictSpan) {
                    this.mFlingStrictSpan = false;
                }
            }
            scrollBy(i10, i11);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void smoothCOUIScrollTo(int i10, int i11) {
        smoothCOUIScrollBy(i10 - getScrollX(), i11 - getScrollY());
    }

    public COUIHorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIHorizontalScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mScreenWidth = 0;
        this.mTempRect = new Rect();
        this.mOverScroller = null;
        this.mSpringOverScroller = null;
        this.mIsLayoutDirty = true;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mItemClickableWhileSlowScrolling = true;
        this.mItemClickableWhileOverScrolling = true;
        this.mEnableDispatchEventWhileScrolling = false;
        this.mEnableDispatchEventWhileOverScrolling = false;
        this.mDispatchEventVelocityThreshold = DEFAULT_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD;
        this.mEventFilterAngle = DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE;
        this.mFastFlingVelocity = 1500.0f;
        this.mAvoidAccidentalTouch = true;
        this.mScrollStrictSpan = false;
        this.mFlingStrictSpan = false;
        this.mEnableOptimizedScroll = true;
        this.mEnableVibrator = true;
        this.mIsColorDevice = null;
        initCOUIHorizontalScrollView(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5076C4, i10, 0);
        this.mEnableVibrator = obtainStyledAttributes.getBoolean(o.f5084D4, true);
        obtainStyledAttributes.recycle();
    }

    public COUIHorizontalScrollView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mScreenWidth = 0;
        this.mTempRect = new Rect();
        this.mOverScroller = null;
        this.mSpringOverScroller = null;
        this.mIsLayoutDirty = true;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mItemClickableWhileSlowScrolling = true;
        this.mItemClickableWhileOverScrolling = true;
        this.mEnableDispatchEventWhileScrolling = false;
        this.mEnableDispatchEventWhileOverScrolling = false;
        this.mDispatchEventVelocityThreshold = DEFAULT_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD;
        this.mEventFilterAngle = DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE;
        this.mFastFlingVelocity = 1500.0f;
        this.mAvoidAccidentalTouch = true;
        this.mScrollStrictSpan = false;
        this.mFlingStrictSpan = false;
        this.mEnableOptimizedScroll = true;
        this.mEnableVibrator = true;
        this.mIsColorDevice = null;
        initCOUIHorizontalScrollView(context);
    }
}
