package com.coui.appcompat.scrollview;

import J.d;
import J.f;
import X8.o;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import androidx.core.widget.NestedScrollView;
import com.coui.appcompat.animation.COUIPhysicalAnimationUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.scroll.COUIIOverScroller;
import com.coui.appcompat.scroll.SpringOverScroller;
import com.coui.appcompat.version.COUIVersionUtil;
import com.coui.appcompat.view.ViewNative;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUINestedScrollView extends NestedScrollView {
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final boolean DEBUG = true;
    private static final int DEBUG_PAINT_TEXT_OFFSET_Y = 50;
    private static final int DEBUG_PAINT_TEXT_SIZE = 30;
    private static final float DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE = 20.0f;
    private static final int DEFAULT_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD = 2500;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final double DEGREE_TO_ARC_CONSTANT = 0.017453292519943295d;
    private static final int FLING_SCROLL_THRESHOLD = 1500;
    private static final int INVALID_POINTER = -1;
    private static final int OVER_SCROLL_TOUCH_DURATION_THRESHOLD = 100;
    private static final int OVER_SCROLL_TOUCH_OFFSET_THRESHOLD = 10;
    private static final int SLOW_SCROLL_THRESHOLD = 250;
    private static final String TAG = "COUINestedScrollView";
    private static final float VERTICAL_SPRING_BACK_TENSION_MULTIPLE = 2.15f;
    private float mAbortVelocityY;
    private int mActivePointerId;
    private boolean mAvoidAccidentalTouch;
    private View mChildToScrollTo;
    private Paint mDebugPaint;
    private int mDispatchEventVelocityThreshold;
    private boolean mEnableDispatchEventWhileOverScrolling;
    private boolean mEnableDispatchEventWhileScrolling;
    private boolean mEnableOptimizedScroll;
    private boolean mEnableVibrator;
    private float mEventFilterAngle;
    private float mFastFlingVelocity;
    private boolean mFlingStrictSpan;
    private float mFlingVelocityY;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private boolean mIsBeingDragged;
    private Boolean mIsColorDevice;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private boolean mIsTouchDownWhileOverScrolling;
    private boolean mIsTouchDownWhileSlowScrolling;
    private boolean mItemClickableWhileOverScrolling;
    private boolean mItemClickableWhileSlowScrolling;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private ArrayList<OnCOUIScrollChangeListener> mOnCOUIScrollChangeListener;
    private OnScrollChangeListener mOnScrollChangeListener;
    private COUIIOverScroller mOverScroller;
    private int mOverflingDistance;
    private int mOverscrollDistance;
    private COUISavedState mSavedState;
    private int mScreenHeight;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private boolean mSmoothScrollingEnabled;
    private SpringOverScroller mSpringOverScroller;
    private final Rect mTempRect;
    private int mTouchSlop;
    private long mTouchTime;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    /* loaded from: classes.dex */
    public static class AccessibilityDelegate extends C0446a {
        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z10;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            COUINestedScrollView cOUINestedScrollView = (COUINestedScrollView) view;
            accessibilityEvent.setClassName(COUIScrollView.class.getName());
            if (cOUINestedScrollView.getScrollRange() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            accessibilityEvent.setScrollX(cOUINestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(cOUINestedScrollView.getScrollY());
            f.a(accessibilityEvent, cOUINestedScrollView.getScrollX());
            f.b(accessibilityEvent, cOUINestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            COUINestedScrollView cOUINestedScrollView = (COUINestedScrollView) view;
            dVar.h0(ScrollView.class.getName());
            if (cOUINestedScrollView.isEnabled() && (scrollRange = cOUINestedScrollView.getScrollRange()) > 0) {
                dVar.E0(true);
                if (cOUINestedScrollView.getScrollY() > 0) {
                    dVar.b(d.a.f1403r);
                    dVar.b(d.a.f1370C);
                }
                if (cOUINestedScrollView.getScrollY() < scrollRange) {
                    dVar.b(d.a.f1402q);
                    dVar.b(d.a.f1372E);
                }
            }
        }

        @Override // androidx.core.view.C0446a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            COUINestedScrollView cOUINestedScrollView = (COUINestedScrollView) view;
            if (!cOUINestedScrollView.isEnabled()) {
                return false;
            }
            if (i10 != 4096) {
                if (i10 != 8192 && i10 != 16908344) {
                    if (i10 != 16908346) {
                        return false;
                    }
                } else {
                    int max = Math.max(cOUINestedScrollView.getScrollY() - ((cOUINestedScrollView.getHeight() - cOUINestedScrollView.getPaddingBottom()) - cOUINestedScrollView.getPaddingTop()), 0);
                    if (max == cOUINestedScrollView.getScrollY()) {
                        return false;
                    }
                    cOUINestedScrollView.smoothCOUIScrollTo(0, max, true);
                    return true;
                }
            }
            int min = Math.min(cOUINestedScrollView.getScrollY() + ((cOUINestedScrollView.getHeight() - cOUINestedScrollView.getPaddingBottom()) - cOUINestedScrollView.getPaddingTop()), cOUINestedScrollView.getScrollRange());
            if (min == cOUINestedScrollView.getScrollY()) {
                return false;
            }
            cOUINestedScrollView.smoothCOUIScrollTo(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class COUISavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<COUISavedState> CREATOR = new Parcelable.Creator<COUISavedState>() { // from class: com.coui.appcompat.scrollview.COUINestedScrollView.COUISavedState.1
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
        public int scrollPosition;

        public COUISavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "NestedScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.scrollPosition);
        }

        public COUISavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        public COUISavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.scrollPosition = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public interface OnCOUIScrollChangeListener {
        void onCOUIScrollChange(int i10, int i11, int i12, int i13);
    }

    /* loaded from: classes.dex */
    public interface OnScrollChangeListener {
        void onScrollChange(COUINestedScrollView cOUINestedScrollView, int i10, int i11, int i12, int i13);
    }

    public COUINestedScrollView(Context context) {
        this(context, null);
    }

    private void abortAnimatedScroll() {
        COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
        if (cOUIIOverScroller != null) {
            cOUIIOverScroller.abortAnimation();
        }
        stopNestedScroll(1);
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin <= (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return false;
        }
        return true;
    }

    private static int clamp(int i10, int i11, int i12) {
        if (i11 < i12 && i10 >= 0) {
            if (i11 + i10 > i12) {
                return i12 - i11;
            }
            return i10;
        }
        return 0;
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

    private void doScrollY(int i10) {
        if (i10 != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, i10);
            } else {
                scrollBy(0, i10);
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
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
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                if (i10 < top && bottom < i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (view == null) {
                    view = view2;
                    z13 = z11;
                } else {
                    if ((z10 && top < view.getTop()) || (!z10 && bottom > view.getBottom())) {
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
        Log.d(TAG, "findViewToDispatchClickEvent: target: " + view);
        return view;
    }

    private float getVelocityAlongScrollableDirection() {
        if (this.mOverScroller != null && (getNestedScrollAxes() & 2) == 0) {
            return this.mOverScroller.getCurrVelocityY();
        }
        return 0.0f;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    private boolean hookIfNeedInterceptMoveEvent(float f10, float f11) {
        if ((!this.mEnableDispatchEventWhileScrolling && (!this.mEnableDispatchEventWhileOverScrolling || !isOverScrolling())) || f10 == 0.0f || Math.abs(f11 / f10) > Math.tan(this.mEventFilterAngle * DEGREE_TO_ARC_CONSTANT)) {
            return true;
        }
        return false;
    }

    private boolean inChild(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i11 < childAt.getTop() - scrollY || i11 >= childAt.getBottom() - scrollY || i10 < childAt.getLeft() || i10 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView(Context context) {
        if (this.mOverScroller == null) {
            SpringOverScroller springOverScroller = new SpringOverScroller(context);
            this.mSpringOverScroller = springOverScroller;
            springOverScroller.setSpringBackTensionMultiple(VERTICAL_SPRING_BACK_TENSION_MULTIPLE);
            this.mSpringOverScroller.setIsScrollView(true);
            this.mOverScroller = this.mSpringOverScroller;
            setEnableFlingSpeedIncrease(true);
        }
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        int i10 = displayMetrics.heightPixels;
        this.mOverscrollDistance = i10;
        this.mOverflingDistance = i10;
        this.mScreenHeight = i10;
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isClickEvent(MotionEvent motionEvent) {
        int y10 = (int) (motionEvent.getY() - this.mInitialTouchY);
        int sqrt = (int) Math.sqrt(y10 * y10);
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
        return !isWithinDeltaOfScreen(view, 0, getHeight());
    }

    private boolean isOverScrolling() {
        if (getScrollY() >= 0 && getScrollY() <= getScrollRange()) {
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

    private boolean isWithinDeltaOfScreen(View view, int i10, int i11) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (this.mTempRect.bottom + i10 >= getScrollY() && this.mTempRect.top - i10 <= getScrollY() + i11) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onNestedScrollInternal(int r9, int r10, int[] r11) {
        /*
            r8 = this;
            int r1 = r8.getScrollY()
            int r2 = r8.getOverScrollMode()
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == r3) goto L21
            int r2 = r8.getOverScrollMode()
            if (r2 != r5) goto L43
            android.view.View r2 = r8.getChildAt(r4)
            int r2 = r2.getHeight()
            int r3 = r8.getHeight()
            if (r2 > r3) goto L43
        L21:
            int r2 = r8.getScrollY()
            int r2 = r2 + r9
            if (r2 >= 0) goto L2e
            int r2 = r8.getScrollY()
            int r2 = -r2
            goto L44
        L2e:
            int r2 = r8.getScrollY()
            int r2 = r2 + r9
            int r3 = r8.getScrollRange()
            if (r2 <= r3) goto L43
            int r2 = r8.getScrollRange()
            int r3 = r8.getScrollY()
            int r2 = r2 - r3
            goto L44
        L43:
            r2 = r9
        L44:
            r8.scrollBy(r4, r2)
            int r3 = r8.getScrollY()
            int r3 = r3 - r1
            if (r11 == 0) goto L53
            r1 = r11[r5]
            int r1 = r1 + r3
            r11[r5] = r1
        L53:
            int r4 = r2 - r3
            r5 = 0
            r6 = 0
            r1 = 0
            r0 = r8
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r10
            r7 = r11
            r0.dispatchNestedScroll(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.scrollview.COUINestedScrollView.onNestedScrollInternal(int, int, int[]):void");
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i10;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.mInitialTouchX = (int) motionEvent.getX(i10);
            int y10 = (int) motionEvent.getY(i10);
            this.mLastMotionY = y10;
            this.mInitialTouchY = y10;
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

    private void runAnimatedScroll(boolean z10) {
        if (z10) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.mLastScrollerY = getScrollY();
        K.Z(this);
    }

    private boolean scrollAndFocus(int i10, int i11, int i12) {
        boolean z10;
        int i13;
        int height = getHeight();
        int scrollY = getScrollY();
        int i14 = height + scrollY;
        boolean z11 = false;
        if (i10 == 33) {
            z10 = true;
        } else {
            z10 = false;
        }
        View findFocusableViewInBounds = findFocusableViewInBounds(z10, i11, i12);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i11 < scrollY || i12 > i14) {
            if (z10) {
                i13 = i11 - scrollY;
            } else {
                i13 = i12 - i14;
            }
            doScrollY(i13);
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
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
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
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothCOUIScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z11;
    }

    private void scrollToWithClamp(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int clamp = clamp(i10, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int clamp2 = clamp(i11, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                scrollTo(clamp, clamp2);
            }
        }
    }

    public boolean addOnCOUIScrollChangeListener(OnCOUIScrollChangeListener onCOUIScrollChangeListener) {
        return this.mOnCOUIScrollChangeListener.add(onCOUIScrollChangeListener);
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean arrowScroll(int i10) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            findNextFocus.requestFocus(i10);
        } else {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            doScrollY(maxScrollAmount);
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

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
        if (cOUIIOverScroller != null && cOUIIOverScroller.computeScrollOffset()) {
            int cOUICurrY = this.mOverScroller.getCOUICurrY();
            if (!canScroll() && getOverScrollMode() != 0 && (cOUICurrY < 0 || cOUICurrY > getScrollRange())) {
                abortAnimatedScroll();
                this.mOverScroller.abortAnimation();
                return;
            }
            int i10 = cOUICurrY - this.mLastScrollerY;
            this.mLastScrollerY = cOUICurrY;
            int[] iArr = this.mScrollConsumed;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i10, iArr, null, 1);
            int i11 = i10 - this.mScrollConsumed[1];
            int scrollRange = getScrollRange();
            if (i11 != 0) {
                int scrollY = getScrollY();
                overScrollByCompat(0, i11, getScrollX(), scrollY, 0, scrollRange, 0, this.mOverflingDistance, false);
                int scrollY2 = getScrollY() - scrollY;
                int[] iArr2 = this.mScrollConsumed;
                iArr2[1] = 0;
                dispatchNestedScroll(0, scrollY2, 0, i11 - scrollY2, this.mScrollOffset, 1, iArr2);
                int i12 = this.mScrollConsumed[1];
            }
            if (!this.mOverScroller.isCOUIFinished()) {
                K.Z(this);
                return;
            } else {
                stopNestedScroll(1);
                return;
            }
        }
        if (this.mFlingStrictSpan) {
            this.mFlingStrictSpan = false;
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.View
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
            Log.d(TAG, "dispatchTouchEvent: current velocity " + velocityAlongScrollableDirection + " threshold " + this.mDispatchEventVelocityThreshold);
            if (motionEvent.getActionMasked() == 0 && this.mDispatchEventVelocityThreshold >= Math.abs(velocityAlongScrollableDirection)) {
                COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
                float f10 = 0.0f;
                if (cOUIIOverScroller2 != null && cOUIIOverScroller2.getCurrVelocityY() != 0.0f) {
                    f10 = this.mFlingVelocityY;
                }
                this.mAbortVelocityY = f10;
                COUIIOverScroller cOUIIOverScroller3 = this.mOverScroller;
                if (cOUIIOverScroller3 != null) {
                    cOUIIOverScroller3.abortAnimation();
                }
                stopNestedScroll();
            }
            if ((motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) && (cOUIIOverScroller = this.mOverScroller) != null && cOUIIOverScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        int i10 = 130;
        if (!canScroll()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19) {
            if (keyCode != 20) {
                if (keyCode != 62) {
                    return false;
                }
                if (keyEvent.isShiftPressed()) {
                    i10 = 33;
                }
                pageScroll(i10);
                return false;
            }
            if (!keyEvent.isAltPressed()) {
                return arrowScroll(130);
            }
            return fullScroll(130);
        }
        if (!keyEvent.isAltPressed()) {
            return arrowScroll(33);
        }
        return fullScroll(33);
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int i10) {
        this.mFlingVelocityY = i10;
        if (getChildCount() > 0) {
            COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
            if (cOUIIOverScroller != null) {
                cOUIIOverScroller.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            }
            runAnimatedScroll(true);
            if (!this.mFlingStrictSpan) {
                this.mFlingStrictSpan = true;
            }
        }
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean fullScroll(int i10) {
        boolean z10;
        int childCount;
        if (i10 == 130) {
            z10 = true;
        } else {
            z10 = false;
        }
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.mTempRect.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.mTempRect;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(i10, rect3.top, rect3.bottom);
    }

    public int getCOUIScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    public int getScrollableRange() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
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

    @Override // androidx.core.widget.NestedScrollView
    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpringOverScroller springOverScroller = this.mSpringOverScroller;
        if (springOverScroller != null) {
            springOverScroller.cancelCallback();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i10 = scrollY - verticalScrollFactorCompat;
                if (i10 < 0) {
                    scrollRange = 0;
                } else if (i10 <= scrollRange) {
                    scrollRange = i10;
                }
                if (scrollRange != scrollY) {
                    scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f10;
        boolean z10;
        boolean z11;
        boolean z12;
        int action = motionEvent.getAction();
        boolean z13 = true;
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
                            }
                        } else {
                            this.mInitialTouchX = (int) motionEvent.getX(0);
                            this.mInitialTouchY = (int) motionEvent.getY(0);
                        }
                    }
                } else {
                    int i11 = this.mActivePointerId;
                    if (i11 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i11);
                        if (findPointerIndex == -1) {
                            Log.e(TAG, "Invalid pointerId=" + i11 + " in onInterceptTouchEvent");
                        } else {
                            int x10 = (int) motionEvent.getX(findPointerIndex);
                            int y10 = (int) motionEvent.getY(findPointerIndex);
                            int abs = Math.abs(x10 - this.mInitialTouchX);
                            int abs2 = Math.abs(y10 - this.mInitialTouchY);
                            if (abs2 > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0 && hookIfNeedInterceptMoveEvent(abs, abs2)) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = y10;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mNestedYOffset = 0;
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
            recycleVelocityTracker();
            COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
            if (cOUIIOverScroller != null && cOUIIOverScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                K.Z(this);
            }
            stopNestedScroll(0);
        } else {
            COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
            if (cOUIIOverScroller2 != null) {
                f10 = cOUIIOverScroller2.getCurrVelocityY();
            } else {
                f10 = 0.0f;
            }
            boolean isFastFling = isFastFling(this.mFlingVelocityY, this.mAbortVelocityY);
            if (Math.abs(f10) > 0.0f && Math.abs(f10) < 250.0f && isFastFling) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mIsTouchDownWhileSlowScrolling = z10;
            this.mIsTouchDownWhileOverScrolling = isOverScrolling();
            this.mTouchTime = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("onInterceptTouchEvent: ACTION_DOWN, isFastFlingY = ");
            sb.append(isFastFling);
            sb.append(", isSlowScrolling = ");
            sb.append(this.mIsTouchDownWhileSlowScrolling);
            sb.append(", \nMath.abs(scrollVelocityY) > 0 = ");
            if (Math.abs(f10) > 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            sb.append(z11);
            sb.append(", \nscrollVelocityY = ");
            sb.append(f10);
            sb.append(", \nMath.abs(scrollVelocityY) < SLOW_SCROLL_THRESHOLD = ");
            if (Math.abs(f10) < 250.0f) {
                z12 = true;
            } else {
                z12 = false;
            }
            sb.append(z12);
            sb.append(", \nisOverScrolling = ");
            sb.append(this.mIsTouchDownWhileOverScrolling);
            sb.append(", scrollVelocityY = ");
            sb.append(Math.abs(f10));
            sb.append(", mFlingVelocityY = ");
            sb.append(this.mFlingVelocityY);
            Log.d(TAG, sb.toString());
            int x11 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (!inChild((int) motionEvent.getX(), y11)) {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            } else {
                this.mInitialTouchX = x11;
                this.mLastMotionY = y11;
                this.mInitialTouchY = y11;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                COUIIOverScroller cOUIIOverScroller3 = this.mOverScroller;
                if (cOUIIOverScroller3 != null) {
                    cOUIIOverScroller3.computeScrollOffset();
                }
                COUIIOverScroller cOUIIOverScroller4 = this.mOverScroller;
                if (cOUIIOverScroller4 == null || cOUIIOverScroller4.isCOUIFinished()) {
                    z13 = false;
                }
                this.mIsBeingDragged = z13;
                startNestedScroll(2, 0);
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int scrollY = getScrollY();
        super.onLayout(z10, i10, i11, i12, i13);
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            ViewNative.setScrollY(this, scrollY);
        }
        ViewNative.setScrollY(this, scrollY);
        scrollToWithClamp(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.InterfaceC0468x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        onNestedScrollInternal(i13, i14, iArr);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        int i12;
        if (getScrollY() != i11 || getScrollX() != i10) {
            if (isOverScrolling() && this.mFlingStrictSpan) {
                if (i11 >= getScrollRange()) {
                    i12 = getScrollRange();
                } else {
                    i12 = 0;
                }
                i11 = COUIPhysicalAnimationUtil.calcOverFlingDecelerateDist(i12, i11 - i12, this.mScreenHeight);
            }
            if (getOverScrollMode() == 2 || (getOverScrollMode() == 1 && getChildAt(0).getHeight() <= getScrollableRange())) {
                i11 = Math.min(Math.max(i11, 0), getScrollRange());
            }
            if (getScrollY() >= 0 && i11 < 0 && this.mFlingStrictSpan) {
                performFeedback();
                SpringOverScroller springOverScroller = this.mSpringOverScroller;
                if (springOverScroller != null) {
                    springOverScroller.notifyVerticalEdgeReached(i11, 0, this.mOverflingDistance);
                }
            }
            if (getScrollY() <= getScrollRange() && i11 > getScrollRange() && this.mFlingStrictSpan) {
                performFeedback();
                SpringOverScroller springOverScroller2 = this.mSpringOverScroller;
                if (springOverScroller2 != null) {
                    springOverScroller2.notifyVerticalEdgeReached(i11, getScrollRange(), this.mOverflingDistance);
                }
            }
            this.mLastScrollerY = i11;
            scrollTo(i10, i11);
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        View findNextFocusFromRect;
        if (i10 == 2) {
            i10 = 130;
        } else if (i10 == 1) {
            i10 = 33;
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

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof COUISavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        COUISavedState cOUISavedState = (COUISavedState) parcelable;
        super.onRestoreInstanceState(cOUISavedState.getSuperState());
        this.mSavedState = cOUISavedState;
        requestLayout();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        COUISavedState cOUISavedState = new COUISavedState(super.onSaveInstanceState());
        cOUISavedState.scrollPosition = getScrollY();
        return cOUISavedState;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i10, i11, i12, i13);
        }
        for (int i14 = 0; i14 < this.mOnCOUIScrollChangeListener.size(); i14++) {
            this.mOnCOUIScrollChangeListener.get(i14).onCOUIScrollChange(i10, i11, i12, i13);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        if (getScrollY() > getScrollRange()) {
            ViewNative.setScrollY(this, getScrollRange());
            scrollTo(getScrollX(), getScrollY());
        }
        COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
        if (cOUIIOverScroller != null) {
            cOUIIOverScroller.abortAnimation();
        }
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && isWithinDeltaOfScreen(findFocus, 0, i13)) {
            findFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        ViewParent parent;
        boolean z11;
        COUIIOverScroller cOUIIOverScroller;
        initVelocityTrackerIfNotExists();
        int actionMasked = motionEvent.getActionMasked();
        boolean z12 = false;
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        float f10 = 0.0f;
        obtain.offsetLocation(0.0f, this.mNestedYOffset);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                onSecondaryPointerUp(motionEvent);
                                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                                if (findPointerIndex == -1) {
                                    Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent ACTION_POINTER_UP");
                                } else {
                                    this.mLastMotionY = (int) motionEvent.getY(findPointerIndex);
                                }
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.mInitialTouchX = (int) motionEvent.getX(actionIndex);
                            int y10 = (int) motionEvent.getY(actionIndex);
                            this.mLastMotionY = y10;
                            this.mInitialTouchY = y10;
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        if (this.mIsBeingDragged && getChildCount() > 0 && (cOUIIOverScroller = this.mOverScroller) != null && cOUIIOverScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            K.Z(this);
                        }
                        this.mActivePointerId = -1;
                        endDrag();
                    }
                } else {
                    COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
                    if ((cOUIIOverScroller2 instanceof SpringOverScroller) && this.mEnableOptimizedScroll) {
                        ((SpringOverScroller) cOUIIOverScroller2).triggerCallback();
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex2 == -1) {
                        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                    } else {
                        int y11 = (int) motionEvent.getY(findPointerIndex2);
                        int i10 = this.mLastMotionY - y11;
                        if (!this.mIsBeingDragged && Math.abs(i10) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            i10 = i10 > 0 ? i10 - this.mTouchSlop : i10 + this.mTouchSlop;
                        }
                        int i11 = i10;
                        if (this.mIsBeingDragged) {
                            if (dispatchNestedPreScroll(0, i11, this.mScrollConsumed, this.mScrollOffset, 0)) {
                                i11 -= this.mScrollConsumed[1];
                                this.mNestedYOffset += this.mScrollOffset[1];
                            }
                            this.mLastMotionY = y11 - this.mScrollOffset[1];
                            int scrollY = getScrollY();
                            int scrollRange = getScrollRange();
                            if (getScrollY() < 0) {
                                i11 = COUIPhysicalAnimationUtil.calcRealOverScrollDist(i11, getScrollY(), this.mOverscrollDistance);
                            } else if (getScrollY() > getScrollRange()) {
                                i11 = COUIPhysicalAnimationUtil.calcRealOverScrollDist(i11, getScrollY() - getScrollRange(), this.mOverscrollDistance);
                            }
                            int i12 = i11;
                            if (overScrollByCompat(0, i12, 0, getScrollY(), 0, scrollRange, 0, this.mOverflingDistance, true) && !hasNestedScrollingParent(0)) {
                                this.mVelocityTracker.clear();
                            }
                            int scrollY2 = getScrollY() - scrollY;
                            int[] iArr = this.mScrollConsumed;
                            iArr[1] = 0;
                            dispatchNestedScroll(0, scrollY2, 0, i12 - scrollY2, this.mScrollOffset, 0, iArr);
                            int i13 = this.mLastMotionY;
                            int i14 = this.mScrollOffset[1];
                            this.mLastMotionY = i13 - i14;
                            this.mNestedYOffset += i14;
                        }
                    }
                }
            } else {
                boolean isOverScrolling = isOverScrolling();
                if (this.mItemClickableWhileSlowScrolling && this.mIsTouchDownWhileSlowScrolling) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (this.mItemClickableWhileOverScrolling && this.mIsTouchDownWhileOverScrolling && isOverScrolling) {
                    z12 = true;
                }
                if (z11 || z12) {
                    findViewToDispatchClickEvent(motionEvent);
                }
                if (this.mIsBeingDragged) {
                    initVelocityTrackerIfNotExists();
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                    if (Math.abs(yVelocity) > this.mMinimumVelocity) {
                        if (getScrollY() < 0) {
                            COUIIOverScroller cOUIIOverScroller3 = this.mOverScroller;
                            if (cOUIIOverScroller3 != null) {
                                cOUIIOverScroller3.setCurrVelocityY(-yVelocity);
                            }
                            if (yVelocity > -1500) {
                                COUIIOverScroller cOUIIOverScroller4 = this.mOverScroller;
                                if (cOUIIOverScroller4 != null && cOUIIOverScroller4.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                                    K.Z(this);
                                }
                            } else {
                                int i15 = -yVelocity;
                                float f11 = i15;
                                if (!dispatchNestedPreFling(0.0f, f11)) {
                                    dispatchNestedFling(0.0f, f11, true);
                                    fling(i15);
                                }
                            }
                        } else if (getScrollY() > getScrollRange()) {
                            COUIIOverScroller cOUIIOverScroller5 = this.mOverScroller;
                            if (cOUIIOverScroller5 != null) {
                                cOUIIOverScroller5.setCurrVelocityY(-yVelocity);
                            }
                            if (yVelocity < FLING_SCROLL_THRESHOLD) {
                                COUIIOverScroller cOUIIOverScroller6 = this.mOverScroller;
                                if (cOUIIOverScroller6 != null && cOUIIOverScroller6.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                                    K.Z(this);
                                }
                            } else {
                                int i16 = -yVelocity;
                                float f12 = i16;
                                if (!dispatchNestedPreFling(0.0f, f12)) {
                                    dispatchNestedFling(0.0f, f12, true);
                                    fling(i16);
                                }
                            }
                        } else {
                            int i17 = -yVelocity;
                            float f13 = i17;
                            if (!dispatchNestedPreFling(0.0f, f13)) {
                                dispatchNestedFling(0.0f, f13, true);
                                fling(i17);
                            }
                        }
                    } else {
                        COUIIOverScroller cOUIIOverScroller7 = this.mOverScroller;
                        if (cOUIIOverScroller7 != null && cOUIIOverScroller7.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            K.Z(this);
                        }
                    }
                    if (getScrollY() < 0 || getScrollY() > getScrollRange()) {
                        performFeedback();
                    }
                    this.mActivePointerId = -1;
                    endDrag();
                }
            }
        } else {
            if (getChildCount() == 0) {
                obtain.recycle();
                return false;
            }
            COUIIOverScroller cOUIIOverScroller8 = this.mOverScroller;
            if (cOUIIOverScroller8 != null && !cOUIIOverScroller8.isCOUIFinished()) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mIsBeingDragged = z10;
            if (z10 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            COUIIOverScroller cOUIIOverScroller9 = this.mOverScroller;
            if (cOUIIOverScroller9 != null && !cOUIIOverScroller9.isCOUIFinished()) {
                if (this.mOverScroller.getCurrVelocityY() != 0.0f) {
                    f10 = this.mFlingVelocityY;
                }
                this.mAbortVelocityY = f10;
                this.mOverScroller.abortAnimation();
                if (this.mFlingStrictSpan) {
                    this.mFlingStrictSpan = false;
                }
            }
            this.mInitialTouchX = (int) motionEvent.getX();
            int y12 = (int) motionEvent.getY();
            this.mLastMotionY = y12;
            this.mInitialTouchY = y12;
            this.mActivePointerId = motionEvent.getPointerId(0);
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            int r4 = r12.getPaddingLeft()
            int r3 = r3 - r4
            int r4 = r12.getPaddingRight()
            int r3 = r3 - r4
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L1d
            r2 = r5
            goto L1e
        L1d:
            r2 = r4
        L1e:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            int r7 = r12.getPaddingTop()
            int r6 = r6 - r7
            int r7 = r12.getPaddingBottom()
            int r6 = r6 - r7
            if (r3 <= r6) goto L34
            r3 = r5
            goto L35
        L34:
            r3 = r4
        L35:
            if (r1 == 0) goto L3e
            if (r1 != r5) goto L3c
            if (r2 == 0) goto L3c
            goto L3e
        L3c:
            r2 = r4
            goto L3f
        L3e:
            r2 = r5
        L3f:
            if (r1 == 0) goto L48
            if (r1 != r5) goto L46
            if (r3 == 0) goto L46
            goto L48
        L46:
            r1 = r4
            goto L49
        L48:
            r1 = r5
        L49:
            int r3 = r15 + r13
            if (r2 != 0) goto L4f
            r6 = r4
            goto L51
        L4f:
            r6 = r19
        L51:
            int r7 = r16 + r14
            if (r1 != 0) goto L57
            r8 = r4
            goto L59
        L57:
            r8 = r20
        L59:
            int r9 = -r6
            int r6 = r6 + r17
            int r10 = -r8
            int r8 = r8 + r18
            if (r2 != 0) goto L6b
            if (r3 <= r6) goto L66
            r2 = r5
            r3 = r6
            goto L6c
        L66:
            if (r3 >= r9) goto L6b
            r2 = r5
            r3 = r9
            goto L6c
        L6b:
            r2 = r4
        L6c:
            if (r1 != 0) goto L78
            if (r7 <= r8) goto L73
            r1 = r5
            r7 = r8
            goto L79
        L73:
            if (r7 >= r10) goto L78
            r1 = r5
            r7 = r10
            goto L79
        L78:
            r1 = r4
        L79:
            com.coui.appcompat.scroll.COUIIOverScroller r6 = r0.mOverScroller
            if (r6 == 0) goto L9c
            if (r1 == 0) goto L9c
            boolean r6 = r12.hasNestedScrollingParent(r5)
            if (r6 != 0) goto L9c
            com.coui.appcompat.scroll.COUIIOverScroller r6 = r0.mOverScroller
            r8 = 0
            int r9 = r12.getScrollRange()
            r10 = 0
            r11 = 0
            r13 = r6
            r14 = r3
            r15 = r7
            r16 = r10
            r17 = r11
            r18 = r8
            r19 = r9
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L9c:
            r12.onOverScrolled(r3, r7, r2, r1)
            if (r2 != 0) goto La3
            if (r1 == 0) goto La4
        La3:
            r4 = r5
        La4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.scrollview.COUINestedScrollView.overScrollByCompat(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean pageScroll(int i10) {
        boolean z10;
        if (i10 == 130) {
            z10 = true;
        } else {
            z10 = false;
        }
        int height = getHeight();
        if (z10) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.mTempRect;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            Rect rect2 = this.mTempRect;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.mTempRect;
        int i11 = rect3.top;
        int i12 = height + i11;
        rect3.bottom = i12;
        return scrollAndFocus(i10, i11, i12);
    }

    public boolean removeOnCOUIScrollChangeListener(OnCOUIScrollChangeListener onCOUIScrollChangeListener) {
        return this.mOnCOUIScrollChangeListener.remove(onCOUIScrollChangeListener);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mIsLayoutDirty) {
            scrollToChild(view2);
        } else {
            this.mChildToScrollTo = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            if (getScrollX() != i10 || getScrollY() != i11) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (isColorDevice().booleanValue()) {
                    ViewNative.setScrollX(this, i10);
                    ViewNative.setScrollY(this, i11);
                    onScrollChanged(i10, i11, scrollX, scrollY);
                } else {
                    super.scrollTo(i10, i11);
                }
                if (!awakenScrollBars()) {
                    postInvalidateOnAnimation();
                }
            }
        }
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

    public void setIsUseOptimizedScroll(boolean z10) {
        this.mEnableOptimizedScroll = z10;
    }

    public void setItemClickableWhileOverScrolling(boolean z10) {
        this.mItemClickableWhileOverScrolling = z10;
    }

    public void setItemClickableWhileSlowScrolling(boolean z10) {
        this.mItemClickableWhileSlowScrolling = z10;
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    @Override // androidx.core.widget.NestedScrollView
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
        smoothCOUIScrollBy(i10, i11, 250, false);
    }

    public final void smoothCOUIScrollTo(int i10, int i11) {
        smoothCOUIScrollTo(i10, i11, 250, false);
    }

    @Override // androidx.core.widget.NestedScrollView
    public void stopNestedScroll(int i10) {
        super.stopNestedScroll(i10);
    }

    public COUINestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.InterfaceC0467w
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScrollInternal(i13, i14, null);
    }

    public final void smoothCOUIScrollBy(int i10, int i11, int i12) {
        smoothCOUIScrollBy(i10, i11, i12, false);
    }

    public final void smoothCOUIScrollTo(int i10, int i11, int i12) {
        smoothCOUIScrollTo(i10, i11, i12, false);
    }

    public COUINestedScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mScreenHeight = 0;
        this.mItemClickableWhileSlowScrolling = true;
        this.mItemClickableWhileOverScrolling = true;
        this.mDebugPaint = new Paint();
        this.mEnableDispatchEventWhileScrolling = false;
        this.mEnableDispatchEventWhileOverScrolling = false;
        this.mDispatchEventVelocityThreshold = DEFAULT_INTERACTING_NESTED_SCROLL_VELOCITY_THRESHOLD;
        this.mEventFilterAngle = DEFAULT_INTERACTING_NESTED_SCROLL_ANGLE;
        this.mFastFlingVelocity = 1500.0f;
        this.mAvoidAccidentalTouch = true;
        this.mEnableOptimizedScroll = true;
        this.mOnCOUIScrollChangeListener = new ArrayList<>();
        this.mEnableVibrator = true;
        this.mTempRect = new Rect();
        this.mOverScroller = null;
        this.mSpringOverScroller = null;
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mFlingStrictSpan = false;
        this.mIsColorDevice = null;
        initScrollView(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5076C4, i10, 0);
        this.mEnableVibrator = obtainStyledAttributes.getBoolean(o.f5084D4, true);
        obtainStyledAttributes.recycle();
    }

    private void smoothCOUIScrollBy(int i10, int i11, int i12, boolean z10) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int max = Math.max(0, Math.min(i11 + scrollY, Math.max(0, height - height2))) - scrollY;
            COUIIOverScroller cOUIIOverScroller = this.mOverScroller;
            if (cOUIIOverScroller != null) {
                cOUIIOverScroller.startScroll(getScrollX(), scrollY, 0, max, i12);
            }
            runAnimatedScroll(z10);
        } else {
            COUIIOverScroller cOUIIOverScroller2 = this.mOverScroller;
            if (cOUIIOverScroller2 != null && !cOUIIOverScroller2.isCOUIFinished()) {
                this.mAbortVelocityY = this.mOverScroller.getCurrVelocityY() != 0.0f ? this.mFlingVelocityY : 0.0f;
                abortAnimatedScroll();
                if (this.mFlingStrictSpan) {
                    this.mFlingStrictSpan = false;
                }
            }
            scrollBy(i10, i11);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScrollInternal(i13, 0, null);
        this.mLastScrollerY += i13;
    }

    public void smoothCOUIScrollTo(int i10, int i11, boolean z10) {
        smoothCOUIScrollTo(i10, i11, 250, z10);
    }

    public void smoothCOUIScrollTo(int i10, int i11, int i12, boolean z10) {
        smoothCOUIScrollBy(i10 - getScrollX(), i11 - getScrollY(), i12, z10);
    }
}
