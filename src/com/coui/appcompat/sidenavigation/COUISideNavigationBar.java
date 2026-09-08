package com.coui.appcompat.sidenavigation;

import A.h;
import J.d;
import X8.c;
import X8.e;
import Y8.i;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.core.view.C0455j;
import androidx.core.view.K;
import androidx.drawerlayout.widget.DrawerLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.log.COUILog;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.window.WindowSizeClass;
import com.coui.component.responsiveui.window.WindowWidthSizeClass;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUISideNavigationBar extends DrawerLayout {
    private static final int CONTENT_STRUCTURE_WEIGHT_NORMAL = 1;
    private static final int CONTENT_STRUCTURE_WEIGHT_PARENT_CHILD = 2;
    private static final ArgbEvaluator DEFAULT_COLOR_EVALUATOR = new ArgbEvaluator();
    private static final int DEFAULT_DRAWER_DIVIDER_TRANSLATION_Z = 1;
    private static final int DRAWER_EXPLICIT_DRAWER_STATE_CLOSING = 0;
    private static final int DRAWER_EXPLICIT_DRAWER_STATE_OPENING = 1;
    private static final int DRAWER_EXPLICIT_DRAWER_STATE_UNSPECIFIED = -1;
    private static final int DRAWER_IMPLICIT_DRAWER_STATE_CLOSED = 0;
    private static final int DRAWER_IMPLICIT_DRAWER_STATE_OPENED = 1;
    private static final int DRAWER_IMPLICIT_DRAWER_STATE_UNSPECIFIED = -1;
    public static final int DRAWER_MODE_FIXED = 1;
    public static final int DRAWER_MODE_TEMPORARY = 0;
    public static final int DRAWER_MODE_UNSPECIFIED = -1;
    private static final float DRAWER_WIDTH_PROPORTION = 0.382f;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int NATIVE_DEFAULT_SCRIM_COLOR = -1728053248;
    private static final String TAG = "COUISideNavigationBar";
    private static final int WINDOW_CONTENT_WEIGHT_COMPAT = 1;
    private static final int WINDOW_CONTENT_WEIGHT_EXPANDED = 3;
    private static final int WINDOW_CONTENT_WEIGHT_MEDIUM = 2;
    private int mContentStructureWeight;
    private View mContentView;
    private View mDividerView;
    private int mDrawerDividerColor;
    private int mDrawerDividerWidth;
    private final DrawerLayout.DrawerListener mDrawerListener;
    private int mDrawerMode;
    private View mDrawerView;
    private int mDrawerViewWidth;
    private int mDrawerWidthInTemporaryMode;
    private int mExplicitDrawerState;
    private boolean mFirstLayout;
    private boolean mHandlerEditModeMask;
    private int mImplicitDrawerState;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsEditState;
    private boolean mIsParentChildHierarchy;
    private List<COUISideNavigationBarListener> mListeners;
    private float mMaskAnimatorPercent;
    private int mMaskColor;
    private int mMaxDrawerWidth;
    private int mMinDrawerMargin;
    private ResponsiveUIModel mModel;
    private int mPendingDrawerMode;
    private int mScrimColor;
    private float mTouchSlop;
    private int mWindowContentWeight;
    private WindowSizeClass mWindowSizeClass;
    private ValueAnimator maskAnimator;

    /* loaded from: classes.dex */
    public interface COUISideNavigationBarListener {
        void onDrawerClosed(View view);

        void onDrawerModeChanged(int i10);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f10, int i10, int i11);

        void onDrawerStateChanged(int i10);

        void onDrawerWidthChanged(int i10, int i11, int i12);
    }

    /* loaded from: classes.dex */
    public static class COUISideNavigationBarSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<COUISideNavigationBarSavedState> CREATOR = new Parcelable.Creator<COUISideNavigationBarSavedState>() { // from class: com.coui.appcompat.sidenavigation.COUISideNavigationBar.COUISideNavigationBarSavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public COUISideNavigationBarSavedState createFromParcel(Parcel parcel) {
                return new COUISideNavigationBarSavedState(parcel, COUISideNavigationBarSavedState.class.getClassLoader());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public COUISideNavigationBarSavedState[] newArray(int i10) {
                return new COUISideNavigationBarSavedState[i10];
            }
        };
        public int mExplicitDrawerState;
        public int mImplicitDrawerState;
        public boolean mIsEditState;

        public COUISideNavigationBarSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "COUISideNavigationBarSavedState { " + Integer.toHexString(System.identityHashCode(this)) + " IsEditStat=" + this.mIsEditState + " ImplicitDrawerState=" + this.mImplicitDrawerState + " ExplicitDrawerState=" + this.mExplicitDrawerState + " }";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mIsEditState ? 1 : 0);
            parcel.writeInt(this.mImplicitDrawerState);
            parcel.writeInt(this.mExplicitDrawerState);
        }

        public COUISideNavigationBarSavedState(Parcel parcel) {
            super(parcel);
            this.mIsEditState = parcel.readInt() != 0;
            this.mImplicitDrawerState = parcel.readInt();
            this.mExplicitDrawerState = parcel.readInt();
        }

        public COUISideNavigationBarSavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mIsEditState = parcel.readInt() != 0;
            this.mImplicitDrawerState = parcel.readInt();
            this.mExplicitDrawerState = parcel.readInt();
        }
    }

    public COUISideNavigationBar(Context context) {
        this(context, null);
    }

    private void findView() {
        if (this.mDrawerView == null || this.mContentView == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (this.mDrawerView == null && isDrawerViewForParent(childAt)) {
                    this.mDrawerView = childAt;
                }
                if (this.mContentView == null && isContentViewForParent(childAt)) {
                    this.mContentView = childAt;
                }
            }
        }
    }

    private boolean isRTL() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startMaskFadeAnimation$0(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.mMaskAnimatorPercent = animatedFraction;
        setScrimColor(((Integer) DEFAULT_COLOR_EVALUATOR.evaluate(animatedFraction, 0, Integer.valueOf(this.mMaskColor))).intValue());
    }

    private boolean pointerInsideDrawerView(float f10, float f11) {
        View drawerView = getDrawerView();
        if (drawerView == null || f10 < drawerView.getX() || f10 >= drawerView.getX() + drawerView.getWidth() || f11 < drawerView.getY() || f11 >= drawerView.getY() + drawerView.getHeight()) {
            return false;
        }
        return true;
    }

    private void setDrawerMode(int i10, int i11) {
        COUILog.d(TAG, "setDrawerMode drawer mode = " + this.mDrawerMode + " new mode = " + i10);
        if (this.mDrawerMode == i10) {
            return;
        }
        this.mDrawerMode = i10;
        if (i10 == 1 && !this.mIsEditState) {
            int i12 = 0;
            setScrimColor(0);
            if (this.mImplicitDrawerState == -1) {
                if (i11 == 1) {
                    i12 = 1;
                }
                this.mImplicitDrawerState = i12;
            }
        } else if (i10 == 0) {
            setScrimColor(this.mMaskColor);
        }
        List<COUISideNavigationBarListener> list = this.mListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onDrawerModeChanged(this.mDrawerMode);
            }
        }
        updateChildImportanceForAccessibility();
    }

    private void setReflectField(Class cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception e10) {
            Log.e(TAG, "setReflectField error: " + e10.getMessage());
        }
    }

    private boolean shouldIgnoreAccessibilityInContent() {
        if (!this.mIsEditState && (this.mDrawerMode != 0 || !isDrawerOpening())) {
            return false;
        }
        return true;
    }

    private void startMaskFadeAnimation(boolean z10) {
        if (this.maskAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.maskAnimator = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.sidenavigation.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUISideNavigationBar.this.lambda$startMaskFadeAnimation$0(valueAnimator);
                }
            });
        }
        if (this.maskAnimator.isRunning()) {
            this.maskAnimator.cancel();
        }
        this.maskAnimator.setCurrentFraction(this.mMaskAnimatorPercent);
        if (z10) {
            this.maskAnimator.start();
        } else {
            this.maskAnimator.reverse();
        }
    }

    private void updateChildImportanceForAccessibility() {
        if (!shouldIgnoreAccessibilityInContent()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                K.t0(getChildAt(i10), 1);
            }
            K.c0(this, d.a.f1410y.b());
        }
    }

    private void updateDrawerState() {
        String windowSizeClass;
        ResponsiveUIModel responsiveUIModel = this.mModel;
        if (responsiveUIModel == null) {
            this.mModel = new ResponsiveUIModel(getContext(), getMeasuredWidth(), getMeasuredHeight());
        } else {
            responsiveUIModel.rebuild(getMeasuredWidth(), getMeasuredHeight());
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("old window size = ");
        WindowSizeClass windowSizeClass2 = this.mWindowSizeClass;
        if (windowSizeClass2 == null) {
            windowSizeClass = "null";
        } else {
            windowSizeClass = windowSizeClass2.toString();
        }
        sb.append(windowSizeClass);
        sb.append(" current window size = ");
        sb.append(this.mModel.windowSizeClass());
        COUILog.d(str, sb.toString());
        if (this.mModel.windowSizeClass().getWindowWidthSizeClass() == WindowWidthSizeClass.Compact) {
            this.mWindowContentWeight = 1;
        } else if (this.mModel.windowSizeClass().getWindowWidthSizeClass() == WindowWidthSizeClass.Medium) {
            this.mWindowContentWeight = 2;
        } else if (this.mModel.windowSizeClass().getWindowWidthSizeClass() == WindowWidthSizeClass.Expanded) {
            this.mWindowContentWeight = 3;
        }
        if (this.mModel.windowSizeClass().equals(this.mWindowSizeClass)) {
            return;
        }
        this.mWindowSizeClass = this.mModel.windowSizeClass();
        View drawerView = getDrawerView();
        if (drawerView == null) {
            COUILog.e(str, "drawerView is Empty!");
            return;
        }
        int i10 = this.mWindowContentWeight - this.mContentStructureWeight;
        COUILog.d(str, "window weight = " + this.mWindowContentWeight + " content weight = " + this.mContentStructureWeight + " edit = " + this.mIsEditState + " implicit state = " + this.mImplicitDrawerState + " isDrawerOpening = " + isDrawerOpening());
        if (i10 > 0) {
            if (!this.mFirstLayout) {
                if (!this.mIsEditState) {
                    if (this.mImplicitDrawerState == 0 && isDrawerOpening()) {
                        super.closeDrawer(drawerView, false);
                        this.mExplicitDrawerState = 0;
                    } else if (this.mImplicitDrawerState == 1) {
                        super.openDrawer(drawerView, false);
                        this.mExplicitDrawerState = 1;
                    }
                } else {
                    this.mImplicitDrawerState = isDrawerOpening() ? 1 : 0;
                }
            }
            this.mPendingDrawerMode = 1;
            return;
        }
        if (!this.mFirstLayout && !this.mIsEditState && this.mImplicitDrawerState != 1 && isDrawerOpening()) {
            super.closeDrawer(drawerView, false);
            this.mExplicitDrawerState = 0;
        }
        this.mPendingDrawerMode = 0;
    }

    public void addSideNavigationBarListener(COUISideNavigationBarListener cOUISideNavigationBarListener) {
        if (cOUISideNavigationBarListener == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
            addDrawerListener(this.mDrawerListener);
        }
        this.mListeners.add(cOUISideNavigationBarListener);
    }

    public int calculateDrawerWidth(int i10) {
        int i11 = this.mPendingDrawerMode;
        if (i11 == -1) {
            i11 = this.mDrawerMode;
        }
        boolean z10 = i11 == 0;
        if (!COUIResponsiveUtils.isSmallScreen(getContext(), i10) && !z10) {
            if (COUIResponsiveUtils.isMediumScreen(getContext(), i10) || COUIResponsiveUtils.isLargeScreen(getContext(), i10)) {
                return Math.min(this.mMaxDrawerWidth, (int) (i10 * DRAWER_WIDTH_PROPORTION));
            }
            return 0;
        }
        return this.mDrawerWidthInTemporaryMode;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void closeDrawer(View view, boolean z10) {
        super.closeDrawer(view, z10);
        int i10 = this.mWindowContentWeight - this.mContentStructureWeight;
        int i11 = this.mExplicitDrawerState;
        this.mExplicitDrawerState = 0;
        if (i10 > 0) {
            setDrawerMode(1, i11);
        } else {
            setDrawerMode(0, i11);
        }
        COUILog.d(TAG, "close drawer window weight = " + this.mWindowContentWeight + " content weight = " + this.mContentStructureWeight + " drawerMode = " + this.mDrawerMode);
        if (this.mDrawerMode == 1) {
            this.mImplicitDrawerState = 0;
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScrimColor == 0 && !shouldIgnoreAccessibilityInContent()) {
            setReflectField(DrawerLayout.class, this, "mScrimOpacity", 0);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            int action = motionEvent.getAction();
            if ((action == 9 || action == 7) && !shouldIgnoreAccessibilityInContent() && dispatchHoverEvent(motionEvent)) {
                return true;
            }
            if (action == 10 && dispatchHoverEvent(motionEvent)) {
                return true;
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        if (view == this.mDividerView) {
            if (isRTL()) {
                this.mDividerView.setTranslationX(this.mDrawerView.getLeft() + this.mDrawerDividerWidth);
            } else {
                this.mDividerView.setTranslationX(this.mDrawerView.getRight());
            }
            setReflectField(DrawerLayout.class, this, "mScrimColor", 0);
            boolean drawChild = super.drawChild(canvas, view, j10);
            setReflectField(DrawerLayout.class, this, "mScrimColor", Integer.valueOf(this.mScrimColor));
            return drawChild;
        }
        return super.drawChild(canvas, view, j10);
    }

    public View getContentView() {
        if (this.mContentView == null) {
            findView();
        }
        return this.mContentView;
    }

    public int getDrawerMode() {
        return this.mDrawerMode;
    }

    public View getDrawerView() {
        if (this.mDrawerView == null) {
            findView();
        }
        return this.mDrawerView;
    }

    public int getDrawerViewWidth() {
        return this.mDrawerViewWidth;
    }

    public boolean getHandlerEditModeMask() {
        return this.mHandlerEditModeMask;
    }

    public boolean getIsInEditState() {
        return this.mIsEditState;
    }

    public boolean isContentViewForParent(View view) {
        if (((DrawerLayout.LayoutParams) view.getLayoutParams()).gravity == 0) {
            return true;
        }
        return false;
    }

    public boolean isDrawerOpening() {
        if (this.mExplicitDrawerState == 1) {
            return true;
        }
        return false;
    }

    public boolean isDrawerViewForParent(View view) {
        int b10 = C0455j.b(((DrawerLayout.LayoutParams) view.getLayoutParams()).gravity, K.v(view));
        if ((b10 & 3) != 0 || (b10 & 5) != 0) {
            return true;
        }
        return false;
    }

    public boolean isParentChildHierarchy() {
        return this.mIsParentChildHierarchy;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        findView();
        this.mFirstLayout = true;
        if (this.mDividerView.getParent() == null) {
            addView(this.mDividerView, new DrawerLayout.LayoutParams(this.mDrawerDividerWidth, -1));
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        requestLayout();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mDrawerView = null;
        this.mContentView = null;
        this.mFirstLayout = true;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.mDrawerMode == 1 && !pointerInsideDrawerView(motionEvent.getX(), motionEvent.getY())) {
            return this.mIsEditState;
        }
        if (motionEvent.getActionMasked() == 0 && onInterceptTouchEvent) {
            if (this.mDrawerMode == 0) {
                return true;
            }
            return false;
        }
        return onInterceptTouchEvent;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.mFirstLayout = false;
        this.mDividerView.layout(-this.mDrawerDividerWidth, getTop(), 0, getBottom());
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        updateDrawerState();
        calculateDrawerWidth(getDrawerView(), i10, i11);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        COUISideNavigationBarSavedState cOUISideNavigationBarSavedState = (COUISideNavigationBarSavedState) parcelable;
        super.onRestoreInstanceState(cOUISideNavigationBarSavedState.getSuperState());
        this.mIsEditState = cOUISideNavigationBarSavedState.mIsEditState;
        this.mImplicitDrawerState = cOUISideNavigationBarSavedState.mImplicitDrawerState;
        this.mExplicitDrawerState = cOUISideNavigationBarSavedState.mExplicitDrawerState;
        requestLayout();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public Parcelable onSaveInstanceState() {
        COUISideNavigationBarSavedState cOUISideNavigationBarSavedState = new COUISideNavigationBarSavedState(super.onSaveInstanceState());
        cOUISideNavigationBarSavedState.mIsEditState = this.mIsEditState;
        cOUISideNavigationBarSavedState.mImplicitDrawerState = this.mImplicitDrawerState;
        cOUISideNavigationBarSavedState.mExplicitDrawerState = this.mExplicitDrawerState;
        return cOUISideNavigationBarSavedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        int i14 = this.mPendingDrawerMode;
        if (i14 != -1) {
            setDrawerMode(i14, this.mExplicitDrawerState);
            this.mPendingDrawerMode = -1;
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 && this.mDrawerMode == 0 && !this.mIsEditState) {
                float x10 = motionEvent.getX() - this.mInitialMotionX;
                float y10 = motionEvent.getY() - this.mInitialMotionY;
                View drawerView = getDrawerView();
                float f10 = (x10 * x10) + (y10 * y10);
                float f11 = this.mTouchSlop;
                if (f10 < f11 * f11 && drawerView != null) {
                    super.closeDrawer(drawerView, true);
                    this.mExplicitDrawerState = 0;
                }
            }
        } else {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.mInitialMotionX = x11;
            this.mInitialMotionY = y11;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void openDrawer(View view, boolean z10) {
        super.openDrawer(view, z10);
        int i10 = this.mWindowContentWeight - this.mContentStructureWeight;
        int i11 = this.mExplicitDrawerState;
        this.mExplicitDrawerState = 1;
        if (i10 > 0) {
            setDrawerMode(1, i11);
        } else {
            setDrawerMode(0, i11);
        }
        COUILog.d(TAG, "open drawer window weight = " + this.mWindowContentWeight + " content weight = " + this.mContentStructureWeight + " drawerMode = " + this.mDrawerMode);
        if (this.mDrawerMode == 1) {
            this.mImplicitDrawerState = 1;
        }
    }

    public void removeSideNavigationBarListener(COUISideNavigationBarListener cOUISideNavigationBarListener) {
        List<COUISideNavigationBarListener> list;
        if (cOUISideNavigationBarListener == null || (list = this.mListeners) == null) {
            return;
        }
        list.remove(cOUISideNavigationBarListener);
        if (this.mListeners.isEmpty()) {
            removeDrawerListener(this.mDrawerListener);
        }
    }

    public void setHandlerEditModeMask(boolean z10) {
        this.mHandlerEditModeMask = z10;
    }

    public void setIsInEditState(boolean z10) {
        if (this.mIsEditState == z10) {
            return;
        }
        if (this.mHandlerEditModeMask && this.mDrawerMode == 1) {
            startMaskFadeAnimation(z10);
        }
        this.mIsEditState = z10;
    }

    public void setParentChildHierarchy(boolean z10) {
        int i10;
        COUILog.d(TAG, "setParentChildHierarchy = " + z10);
        this.mIsParentChildHierarchy = z10;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        this.mContentStructureWeight = i10;
        requestLayout();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void setScrimColor(int i10) {
        this.mScrimColor = i10;
        super.setScrimColor(i10);
    }

    public COUISideNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUISideNavigationBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mDrawerListener = new DrawerLayout.DrawerListener() { // from class: com.coui.appcompat.sidenavigation.COUISideNavigationBar.1
            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerClosed(View view) {
                if (COUISideNavigationBar.this.mListeners != null) {
                    for (int size = COUISideNavigationBar.this.mListeners.size() - 1; size >= 0; size--) {
                        ((COUISideNavigationBarListener) COUISideNavigationBar.this.mListeners.get(size)).onDrawerClosed(view);
                    }
                }
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerOpened(View view) {
                if (COUISideNavigationBar.this.mListeners != null) {
                    for (int size = COUISideNavigationBar.this.mListeners.size() - 1; size >= 0; size--) {
                        ((COUISideNavigationBarListener) COUISideNavigationBar.this.mListeners.get(size)).onDrawerOpened(view);
                    }
                }
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerSlide(View view, float f10) {
                if (COUISideNavigationBar.this.mListeners != null) {
                    for (int size = COUISideNavigationBar.this.mListeners.size() - 1; size >= 0; size--) {
                        ((COUISideNavigationBarListener) COUISideNavigationBar.this.mListeners.get(size)).onDrawerSlide(view, f10, (int) (COUISideNavigationBar.this.getDrawerViewWidth() * f10), COUISideNavigationBar.this.mDrawerMode);
                    }
                }
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public void onDrawerStateChanged(int i11) {
                if (COUISideNavigationBar.this.mListeners != null) {
                    for (int size = COUISideNavigationBar.this.mListeners.size() - 1; size >= 0; size--) {
                        ((COUISideNavigationBarListener) COUISideNavigationBar.this.mListeners.get(size)).onDrawerStateChanged(i11);
                    }
                }
            }
        };
        this.mDrawerMode = -1;
        this.mPendingDrawerMode = -1;
        this.mImplicitDrawerState = -1;
        this.mExplicitDrawerState = -1;
        this.mWindowContentWeight = 0;
        this.mContentStructureWeight = 0;
        this.mMaskColor = 0;
        this.mScrimColor = NATIVE_DEFAULT_SCRIM_COLOR;
        this.mIsEditState = false;
        this.mHandlerEditModeMask = true;
        this.mFirstLayout = true;
        this.mMaskAnimatorPercent = 0.0f;
        this.maskAnimator = null;
        this.mMinDrawerMargin = (int) ((getResources().getDisplayMetrics().density * 64.0f) + 0.5f);
        androidx.appcompat.widget.K w10 = androidx.appcompat.widget.K.w(context, attributeSet, i.f5734o, i10, 0);
        this.mIsParentChildHierarchy = w10.a(i.f5735p, false);
        this.mDrawerWidthInTemporaryMode = getResources().getDimensionPixelSize(Y8.d.f5612D);
        this.mMaxDrawerWidth = getResources().getDimensionPixelSize(Y8.d.f5611C);
        this.mDrawerDividerWidth = getResources().getDimensionPixelSize(Y8.d.f5613E);
        this.mDrawerDividerColor = COUIContextUtil.getAttrColor(getContext(), c.f4400q, e.f4442h);
        w10.y();
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaskColor = h.d(getResources(), e.f4444j, getContext().getTheme());
        setDrawerMode(0, this.mExplicitDrawerState);
        super.setDrawerLockMode(2, 3);
        super.setDrawerLockMode(2, 5);
        View view = new View(context);
        this.mDividerView = view;
        view.setTranslationZ(1.0f);
        this.mDividerView.setBackgroundColor(this.mDrawerDividerColor);
        COUIDarkModeUtil.setForceDarkAllow(this.mDividerView, false);
    }

    private void calculateDrawerWidth(View view, int i10, int i11) {
        if (view == null) {
            return;
        }
        this.mDrawerViewWidth = calculateDrawerWidth(getMeasuredWidth());
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) view.getLayoutParams();
        COUILog.d(TAG, "calculateDrawerWidth: params.width = " + ((ViewGroup.MarginLayoutParams) layoutParams).width + " mDrawerViewWidth = " + this.mDrawerViewWidth);
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        int i13 = this.mDrawerViewWidth;
        if (i12 != i13) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = i13;
            view.setLayoutParams(layoutParams);
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height);
            int width = view.getWidth();
            view.measure(childMeasureSpec, childMeasureSpec2);
            List<COUISideNavigationBarListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerWidthChanged(width, this.mDrawerViewWidth, this.mDrawerMode);
                }
            }
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void setDrawerLockMode(int i10, int i11) {
    }
}
