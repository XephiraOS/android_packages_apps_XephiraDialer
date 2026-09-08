package com.coui.appcompat.sidepane;

import J.d;
import X8.e;
import Y8.g;
import Y8.i;
import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.PathInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.c;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUISidePaneLayout extends RelativeLayout {
    public static final int CLOSE_STATE = 1;
    public static final int CONTENT_INDEX = 1;
    private static final int DEFAULT_CHILD_SIZE = 2;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int DURATION_OF_SLIDING_ANIMATOR = 483;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int OPEN_STATE = 0;
    public static final int SIDE_ICON_INDEX = 2;
    public static final int SIDE_PANE_INDEX = 0;
    private static final PathInterpolator SLIDING_ANIMATOR_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final String TAG = "COUISidePaneLayout";
    private boolean mAlwaysShow;
    private boolean mCanSlide;
    private boolean mCreateIcon;
    private boolean mDefaultShow;
    final c mDragHelper;
    private boolean mFirstAttach;
    private boolean mFirstLayout;
    private float mFirstViewWidth;
    private ImageButton mIconButton;
    private boolean mIsCover;
    private boolean mIsSliding;
    private boolean mIsTouchEnabled;
    boolean mIsUnableToDrag;
    private PanelSlideListener mLifeCycleObserverListener;
    private final int mOverhangSize;
    private PanelMaskListener mPanelMaskListener;
    private PanelSlideListener mPanelSlideListener;
    boolean mPreservedOpenState;
    private final Paint mScrimPaint;
    private ValueAnimator mSlideAnimator;
    private float mSlideDistance;
    float mSlideOffset;
    int mSlideRange;
    private final float mSlideViewWidth;
    View mSlideableView;
    private int mState;
    private ValueAnimator mTranlateAnimator;

    /* loaded from: classes.dex */
    public class AccessibilityDelegate extends C0446a {
        private final Rect mTmpRect = new Rect();

        public AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(d dVar, d dVar2) {
            Rect rect = this.mTmpRect;
            dVar2.k(rect);
            dVar.c0(rect);
            dVar2.l(rect);
            dVar.d0(rect);
            dVar.M0(dVar2.U());
            dVar.x0(dVar2.w());
            dVar.h0(dVar2.o());
            dVar.l0(dVar2.r());
            dVar.n0(dVar2.J());
            dVar.i0(dVar2.H());
            dVar.p0(dVar2.K());
            dVar.q0(dVar2.L());
            dVar.b0(dVar2.E());
            dVar.F0(dVar2.R());
            dVar.u0(dVar2.O());
            dVar.a(dVar2.i());
            dVar.w0(dVar2.v());
        }

        public boolean filter(View view) {
            return COUISidePaneLayout.this.isDimmed(view);
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(COUISidePaneLayout.class.getName());
        }

        @Override // androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            d W10 = d.W(dVar);
            super.onInitializeAccessibilityNodeInfo(view, W10);
            copyNodeInfoNoChildren(dVar, W10);
            W10.Z();
            dVar.h0(COUISidePaneLayout.class.getName());
            dVar.H0(view);
            Object B10 = K.B(view);
            if (B10 instanceof View) {
                dVar.z0((View) B10);
            }
            int childCount = COUISidePaneLayout.this.getChildCount();
            for (int i10 = 1; i10 < childCount; i10++) {
                View childAt = COUISidePaneLayout.this.getChildAt(i10);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    K.t0(childAt, 1);
                    dVar.c(childAt);
                }
            }
        }

        @Override // androidx.core.view.C0446a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!filter(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class DragHelperCallback extends c.AbstractC0115c {
        public DragHelperCallback() {
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            LayoutParams layoutParams = (LayoutParams) COUISidePaneLayout.this.mSlideableView.getLayoutParams();
            if (COUISidePaneLayout.this.isLayoutRtlSupport()) {
                int width = COUISidePaneLayout.this.getWidth() - ((COUISidePaneLayout.this.getPaddingRight() + ((RelativeLayout.LayoutParams) layoutParams).rightMargin) + COUISidePaneLayout.this.mSlideableView.getWidth());
                return Math.max(Math.min(i10, width), width - COUISidePaneLayout.this.mSlideRange);
            }
            int paddingLeft = COUISidePaneLayout.this.getPaddingLeft() + ((RelativeLayout.LayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i10, paddingLeft), COUISidePaneLayout.this.mSlideRange + paddingLeft);
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int getViewHorizontalDragRange(View view) {
            return COUISidePaneLayout.this.mSlideRange;
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onEdgeDragStarted(int i10, int i11) {
            COUISidePaneLayout cOUISidePaneLayout = COUISidePaneLayout.this;
            cOUISidePaneLayout.mDragHelper.c(cOUISidePaneLayout.mSlideableView, i11);
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewCaptured(View view, int i10) {
            COUISidePaneLayout.this.setAllChildrenVisible();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewDragStateChanged(int i10) {
            if (COUISidePaneLayout.this.mDragHelper.B() == 0) {
                COUISidePaneLayout cOUISidePaneLayout = COUISidePaneLayout.this;
                if (cOUISidePaneLayout.mSlideOffset == 0.0f) {
                    cOUISidePaneLayout.updateObscuredViewsVisibility(cOUISidePaneLayout.mSlideableView);
                    COUISidePaneLayout cOUISidePaneLayout2 = COUISidePaneLayout.this;
                    cOUISidePaneLayout2.dispatchOnPanelClosed(cOUISidePaneLayout2.mSlideableView);
                    COUISidePaneLayout.this.mPreservedOpenState = false;
                    return;
                }
                cOUISidePaneLayout.dispatchOnPanelOpened(cOUISidePaneLayout.mSlideableView);
                COUISidePaneLayout.this.mPreservedOpenState = true;
            }
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            COUISidePaneLayout cOUISidePaneLayout = COUISidePaneLayout.this;
            if (cOUISidePaneLayout.mSlideableView == null) {
                cOUISidePaneLayout.mSlideOffset = 0.0f;
                return;
            }
            if (cOUISidePaneLayout.isLayoutRtlSupport()) {
                i10 = (COUISidePaneLayout.this.getWidth() - i10) - COUISidePaneLayout.this.mSlideableView.getWidth();
            }
            COUISidePaneLayout.this.onPanelSlide(i10);
            COUISidePaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewReleased(View view, float f10, float f11) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (COUISidePaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = COUISidePaneLayout.this.getPaddingRight() + ((RelativeLayout.LayoutParams) layoutParams).rightMargin;
                if (f10 < 0.0f || (f10 == 0.0f && COUISidePaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += COUISidePaneLayout.this.mSlideRange;
                }
                paddingLeft = (COUISidePaneLayout.this.getWidth() - paddingRight) - COUISidePaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = ((RelativeLayout.LayoutParams) layoutParams).leftMargin + COUISidePaneLayout.this.getPaddingLeft();
                if (f10 > 0.0f || (f10 == 0.0f && COUISidePaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += COUISidePaneLayout.this.mSlideRange;
                }
            }
            COUISidePaneLayout.this.mDragHelper.P(paddingLeft, view.getTop());
            COUISidePaneLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public boolean tryCaptureView(View view, int i10) {
            if (COUISidePaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    /* loaded from: classes.dex */
    public interface PanelMaskListener {
        void clickMask();
    }

    /* loaded from: classes.dex */
    public interface PanelSlideListener {
        void onPanelAnimCancel(int i10);

        void onPanelAnimEnd(int i10);

        void onPanelAnimStart(int i10);

        void onPanelSlide(View view, float f10);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.sidepane.COUISidePaneLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        boolean isDefalutOpen;
        boolean isOpen;
        int state;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.isOpen ? 1 : 0);
            parcel.writeInt(this.isDefalutOpen ? 1 : 0);
            parcel.writeInt(this.state);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
            this.isDefalutOpen = parcel.readInt() != 0;
            this.state = parcel.readInt();
        }
    }

    public COUISidePaneLayout(Context context) {
        this(context, null);
    }

    private boolean closePane(View view, int i10) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i10)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void createIconView() {
        this.mIconButton = (ImageButton) LayoutInflater.from(getContext()).inflate(g.f5685d, (ViewGroup) null);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams) layoutParams).topMargin = getResources().getDimensionPixelOffset(Y8.d.f5615G);
        layoutParams.setMarginStart(getResources().getDimensionPixelOffset(Y8.d.f5614F));
        this.mIconButton.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.sidepane.COUISidePaneLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUISidePaneLayout.this.isOpen()) {
                    COUISidePaneLayout.this.closePane();
                } else {
                    COUISidePaneLayout.this.openPane();
                }
            }
        });
        addViewInLayout(this.mIconButton, 2, layoutParams);
    }

    private void initAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mTranlateAnimator = ofFloat;
        ofFloat.setDuration(483L);
        ValueAnimator valueAnimator = this.mTranlateAnimator;
        PathInterpolator pathInterpolator = SLIDING_ANIMATOR_INTERPOLATOR;
        valueAnimator.setInterpolator(pathInterpolator);
        this.mTranlateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.sidepane.COUISidePaneLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if (COUISidePaneLayout.this.getChildAt(0) != null) {
                    if (COUISidePaneLayout.this.mState == 1) {
                        View childAt = COUISidePaneLayout.this.getChildAt(0);
                        boolean isLayoutRtlSupport = COUISidePaneLayout.this.isLayoutRtlSupport();
                        float f10 = COUISidePaneLayout.this.mSlideDistance;
                        if (!isLayoutRtlSupport) {
                            f10 = -f10;
                        }
                        childAt.setTranslationX(f10 * ((Float) valueAnimator2.getAnimatedValue()).floatValue());
                        return;
                    }
                    if (COUISidePaneLayout.this.mState == 0) {
                        View childAt2 = COUISidePaneLayout.this.getChildAt(0);
                        boolean isLayoutRtlSupport2 = COUISidePaneLayout.this.isLayoutRtlSupport();
                        float f11 = COUISidePaneLayout.this.mSlideDistance;
                        if (!isLayoutRtlSupport2) {
                            f11 = -f11;
                        }
                        childAt2.setTranslationX(f11 * (1.0f - ((Float) valueAnimator2.getAnimatedValue()).floatValue()));
                    }
                }
            }
        });
        this.mTranlateAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.sidepane.COUISidePaneLayout.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUISidePaneLayout.this.mIsSliding = false;
                if (COUISidePaneLayout.this.mPanelSlideListener != null) {
                    if (COUISidePaneLayout.this.mState == 1) {
                        COUISidePaneLayout.this.mPanelSlideListener.onPanelAnimCancel(1);
                    } else if (COUISidePaneLayout.this.mState == 0) {
                        COUISidePaneLayout.this.mPanelSlideListener.onPanelAnimCancel(0);
                    }
                }
                if (COUISidePaneLayout.this.mLifeCycleObserverListener != null) {
                    if (COUISidePaneLayout.this.mState == 1) {
                        COUISidePaneLayout.this.mLifeCycleObserverListener.onPanelAnimCancel(1);
                    } else if (COUISidePaneLayout.this.mState == 0) {
                        COUISidePaneLayout.this.mLifeCycleObserverListener.onPanelAnimCancel(0);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUISidePaneLayout.this.mPanelSlideListener != null) {
                    if (COUISidePaneLayout.this.mState == 1) {
                        COUISidePaneLayout.this.mPanelSlideListener.onPanelAnimEnd(1);
                    } else if (COUISidePaneLayout.this.mState == 0) {
                        COUISidePaneLayout.this.mPanelSlideListener.onPanelAnimEnd(0);
                    }
                    COUISidePaneLayout.this.mIsSliding = false;
                }
                if (COUISidePaneLayout.this.mLifeCycleObserverListener != null) {
                    if (COUISidePaneLayout.this.mState == 1) {
                        COUISidePaneLayout.this.mLifeCycleObserverListener.onPanelAnimEnd(1);
                    } else if (COUISidePaneLayout.this.mState == 0) {
                        COUISidePaneLayout.this.mLifeCycleObserverListener.onPanelAnimEnd(0);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISidePaneLayout.this.mIsSliding = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.mSlideAnimator = valueAnimator2;
        valueAnimator2.setFloatValues(0.0f, 1.0f);
        this.mSlideAnimator.setDuration(483L);
        this.mSlideAnimator.setInterpolator(pathInterpolator);
    }

    private boolean openPane(View view, int i10) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i10)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    private void updateChildSize() {
        this.mFirstLayout = true;
        int i10 = this.mState;
        if (i10 == 0) {
            this.mFirstAttach = true;
        }
        if (this.mDefaultShow && i10 == 0) {
            openPane(this.mSlideableView, 0);
        }
    }

    private static boolean viewIsOpaque(View view) {
        if (view.isOpaque()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.n(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.a();
            } else {
                K.Z(this);
            }
        }
    }

    public void dispatchOnPanelClosed(View view) {
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelOpened(View view) {
        sendAccessibilityEvent(32);
    }

    public void dispatchOnPanelSlide(View view) {
        reMeasureContentView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int adjustmentPointerIndex = UIUtil.getAdjustmentPointerIndex(motionEvent, motionEvent.getActionIndex());
        boolean z10 = false;
        if (!isLayoutRtlSupport() ? getChildAt(0).getRight() <= motionEvent.getX(adjustmentPointerIndex) : getChildAt(0).getLeft() > motionEvent.getX(adjustmentPointerIndex)) {
            z10 = true;
        }
        if (isOpen() && z10 && this.mAlwaysShow && (motionEvent.getAction() & 15) == 5) {
            PanelMaskListener panelMaskListener = this.mPanelMaskListener;
            if (panelMaskListener != null) {
                panelMaskListener.clickMask();
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        boolean drawChild = super.drawChild(canvas, view, j10);
        if (this.mIsCover || this.mAlwaysShow) {
            boolean isContentView = isContentView(view);
            int right = getChildAt(1).getRight();
            int right2 = (int) (getChildAt(0).getRight() * this.mSlideOffset);
            int width = getWidth();
            int color = getContext().getResources().getColor(e.f4444j);
            float f10 = this.mSlideOffset;
            int i10 = (int) (right + ((width - right) * (1.0f - f10)));
            if (f10 > 0.0f && isContentView) {
                this.mScrimPaint.setColor((((int) ((((-16777216) & color) >>> 24) * f10)) << 24) | (color & UIUtil.CONSTANT_COLOR_MASK));
                if (isLayoutRtlSupport()) {
                    canvas.drawRect(getPaddingEnd(), 0.0f, i10, getHeight(), this.mScrimPaint);
                } else {
                    canvas.drawRect(right2, 0.0f, width, getHeight(), this.mScrimPaint);
                }
            }
        }
        return drawChild;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        if (i10 >= 3 && i11 < 2 && this.mIsCover) {
            return (i10 - i11) - 2;
        }
        return super.getChildDrawingOrder(i10, i11);
    }

    public ImageButton getIconView() {
        return this.mIconButton;
    }

    @Override // android.view.ViewGroup
    public boolean isChildrenDrawingOrderEnabled() {
        if (!this.mIsCover && !super.isChildrenDrawingOrderEnabled()) {
            return false;
        }
        return true;
    }

    public boolean isContentView(View view) {
        if (view == getChildAt(1)) {
            return true;
        }
        return false;
    }

    public boolean isCoverStyle() {
        return this.mIsCover;
    }

    public boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.mCanSlide || !layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
            return false;
        }
        return true;
    }

    public boolean isLayoutRtlSupport() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        if (this.mState == 0) {
            return true;
        }
        return false;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    public boolean isSliding() {
        return this.mIsSliding;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        if (this.mDefaultShow && this.mState == 0) {
            this.mFirstAttach = true;
            openPane(this.mSlideableView, 0);
        } else {
            closePane();
        }
        if (this.mCreateIcon && this.mIconButton == null) {
            createIconView();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10 = false;
        if (getChildAt(0) != null && (this.mAlwaysShow || this.mIsCover)) {
            if (!isLayoutRtlSupport() ? getChildAt(0).getRight() <= motionEvent.getX() : getChildAt(0).getLeft() > motionEvent.getX()) {
                z10 = true;
            }
            if (isOpen() && z10 && this.mAlwaysShow && motionEvent.getAction() == 0) {
                PanelMaskListener panelMaskListener = this.mPanelMaskListener;
                if (panelMaskListener != null) {
                    panelMaskListener.clickMask();
                }
                return true;
            }
            if (z10 && isOpen() && this.mIsTouchEnabled && this.mIsCover) {
                closePane();
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft;
        int paddingRight;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        char c10;
        int i20;
        boolean z11;
        float f10;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int i21 = 1;
        if (isLayoutRtlSupport) {
            this.mDragHelper.N(2);
        } else {
            this.mDragHelper.N(1);
        }
        int i22 = i12 - i10;
        if (isLayoutRtlSupport) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        float f11 = 0.0f;
        float f12 = 1.0f;
        if (this.mFirstLayout) {
            if (this.mPreservedOpenState) {
                f10 = 1.0f;
            } else {
                f10 = 0.0f;
            }
            this.mSlideOffset = f10;
        }
        int i23 = 0;
        int i24 = paddingLeft;
        int i25 = 0;
        while (i25 < childCount) {
            View childAt = getChildAt(i25);
            if (childAt.getVisibility() == 8) {
                i19 = i21;
                c10 = 2;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (i25 == i21) {
                    if (this.mIsCover) {
                        measuredWidth = Math.min(getWidth(), childAt.getMeasuredWidth());
                    } else {
                        float f13 = this.mSlideOffset;
                        if (f13 == f11) {
                            float f14 = this.mFirstViewWidth;
                            Resources resources = getResources();
                            int i26 = Y8.d.f5618J;
                            if (f14 == resources.getDimensionPixelOffset(i26)) {
                                measuredWidth = Math.max(getWidth(), childAt.getMeasuredWidth());
                            } else {
                                measuredWidth = (int) Math.max((getWidth() - this.mFirstViewWidth) + getResources().getDimensionPixelOffset(i26), childAt.getMeasuredWidth());
                            }
                        } else if (f13 == f12) {
                            measuredWidth = Math.max(getWidth() - getChildAt(i23).getMeasuredWidth(), childAt.getMeasuredWidth());
                        }
                    }
                    measuredWidth = Math.min(getWidth(), measuredWidth);
                }
                if (layoutParams.slideable) {
                    int i27 = i22 - paddingRight;
                    int min = (Math.min(i24, i27 - this.mOverhangSize) - paddingLeft) - (((RelativeLayout.LayoutParams) layoutParams).leftMargin + ((RelativeLayout.LayoutParams) layoutParams).rightMargin);
                    this.mSlideRange = min;
                    if (isLayoutRtlSupport) {
                        i20 = ((RelativeLayout.LayoutParams) layoutParams).rightMargin;
                    } else {
                        i20 = ((RelativeLayout.LayoutParams) layoutParams).leftMargin;
                    }
                    if (paddingLeft + i20 + min + (measuredWidth / 2) > i27) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    layoutParams.dimWhenOffset = z11;
                    int i28 = (int) (min * this.mSlideOffset);
                    paddingLeft += i20 + i28;
                    this.mSlideOffset = i28 / min;
                } else {
                    paddingLeft = i24;
                }
                if (isLayoutRtlSupport) {
                    if (layoutParams.slideable) {
                        if (this.mIsCover && i25 == 1) {
                            i18 = i22;
                        } else {
                            i18 = i22 - ((int) (paddingLeft + ((this.mFirstViewWidth - this.mSlideDistance) * (1.0f - this.mSlideOffset))));
                        }
                    } else {
                        i18 = i22 - paddingLeft;
                    }
                    i17 = i18 - measuredWidth;
                } else {
                    if (layoutParams.slideable) {
                        if (this.mIsCover && i25 == 1) {
                            i14 = (int) (((paddingLeft + measuredWidth) + this.mFirstViewWidth) - this.mSlideDistance);
                            i15 = 0;
                            i16 = 1;
                            if (i25 != i16 && !COUISidePaneUtils.isMediumScreenStyle((Activity) getContext())) {
                                i17 = i15;
                                i18 = i22;
                            } else {
                                int i29 = i14;
                                i17 = i15;
                                i18 = i29;
                            }
                        } else {
                            i15 = (int) (paddingLeft + ((this.mFirstViewWidth - this.mSlideDistance) * (1.0f - this.mSlideOffset)));
                            i14 = i15 + measuredWidth;
                        }
                    } else {
                        i14 = paddingLeft + measuredWidth;
                        i15 = paddingLeft;
                    }
                    i16 = 1;
                    if (i25 != i16) {
                    }
                    int i292 = i14;
                    i17 = i15;
                    i18 = i292;
                }
                int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                if (i25 == 2) {
                    if (isLayoutRtlSupport) {
                        childAt.layout((i22 - layoutParams.getMarginStart()) - measuredWidth, ((RelativeLayout.LayoutParams) layoutParams).topMargin, i22 - layoutParams.getMarginStart(), ((RelativeLayout.LayoutParams) layoutParams).topMargin + measuredWidth);
                    } else {
                        childAt.layout(layoutParams.getMarginStart(), ((RelativeLayout.LayoutParams) layoutParams).topMargin, layoutParams.getMarginStart() + measuredWidth, ((RelativeLayout.LayoutParams) layoutParams).topMargin + measuredWidth);
                    }
                    i19 = 1;
                } else {
                    i19 = 1;
                    if (i25 == 1 && isLayoutRtlSupport) {
                        childAt.layout(0, paddingTop, i18, measuredHeight);
                    } else {
                        childAt.layout(i17, paddingTop, i18, measuredHeight);
                    }
                }
                c10 = 2;
                if (i25 < 2) {
                    i24 += childAt.getWidth();
                }
            }
            i25++;
            i23 = 0;
            f11 = 0.0f;
            f12 = 1.0f;
            i21 = i19;
        }
        if (this.mFirstLayout) {
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int paddingTop;
        int i12;
        boolean z10;
        int measuredWidth;
        int makeMeasureSpec;
        int i13;
        int i14;
        int makeMeasureSpec2;
        float f10;
        float f11;
        int i15;
        int i16;
        int makeMeasureSpec3;
        int i17;
        int makeMeasureSpec4;
        int i18;
        int i19;
        int i20;
        boolean z11;
        int i21;
        float max;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
            } else {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }
        } else if (mode2 == 0) {
            if (isInEditMode()) {
                if (mode2 == 0) {
                    size2 = 300;
                    mode2 = Integer.MIN_VALUE;
                }
            } else {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
        }
        boolean z12 = false;
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 1073741824) {
                i12 = 0;
            } else {
                i12 = (size2 - getPaddingTop()) - getPaddingBottom();
            }
            paddingTop = i12;
        } else {
            paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            i12 = 0;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 3) {
            Log.e(TAG, "onMeasure: More than two child views are not supported.");
        }
        this.mSlideableView = null;
        int i22 = 0;
        boolean z13 = false;
        int i23 = paddingLeft;
        float f12 = 0.0f;
        while (i22 < childCount) {
            View childAt = getChildAt(i22);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.dimWhenOffset = z12;
            } else {
                float f13 = layoutParams.weight;
                if (f13 > 0.0f) {
                    f12 += f13;
                    if (((RelativeLayout.LayoutParams) layoutParams).width == 0) {
                    }
                }
                int i24 = ((RelativeLayout.LayoutParams) layoutParams).leftMargin + ((RelativeLayout.LayoutParams) layoutParams).rightMargin;
                int i25 = ((RelativeLayout.LayoutParams) layoutParams).width;
                if (i25 == -2 || i25 == -1) {
                    i25 = paddingLeft - i24;
                }
                if (i22 == 1 && this.mFirstAttach && !this.mIsCover) {
                    i25 = (int) (i25 - this.mFirstViewWidth);
                    f10 = this.mSlideDistance;
                } else {
                    f10 = 0.0f;
                }
                if (i22 == 1) {
                    if (this.mIsCover) {
                        i25 = paddingLeft;
                        f11 = f12;
                    } else {
                        float f14 = this.mSlideOffset;
                        if (f14 == 0.0f) {
                            float f15 = this.mFirstViewWidth;
                            Resources resources = getResources();
                            f11 = f12;
                            int i26 = Y8.d.f5618J;
                            if (f15 == resources.getDimensionPixelOffset(i26)) {
                                max = Math.max(paddingLeft - (this.mFirstViewWidth - this.mSlideDistance), childAt.getMeasuredWidth());
                            } else {
                                max = Math.max((paddingLeft - this.mSlideDistance) + getResources().getDimensionPixelOffset(i26), childAt.getMeasuredWidth());
                            }
                            i25 = (int) max;
                        } else {
                            f11 = f12;
                            if (f14 == 1.0f) {
                                i25 = Math.max(paddingLeft - getChildAt(0).getMeasuredWidth(), i25);
                            }
                        }
                    }
                    if (!this.mIsCover) {
                        i25 = Math.min(paddingLeft, i25);
                    }
                    if (!COUISidePaneUtils.isMediumScreenStyle((Activity) getContext())) {
                        i16 = paddingLeft;
                    } else {
                        i16 = i25;
                    }
                    i15 = 1;
                } else {
                    f11 = f12;
                    int i27 = i25;
                    i15 = 1;
                    i16 = i27;
                }
                if (i22 == i15 && i16 <= 0) {
                    if (this.mState == 0) {
                        i21 = getChildAt(0).getMeasuredWidth();
                    } else {
                        i21 = 0;
                    }
                    i16 = Math.max(paddingLeft - i21, ((RelativeLayout.LayoutParams) layoutParams).width);
                }
                int i28 = ((RelativeLayout.LayoutParams) layoutParams).width;
                if (i28 == -2) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE);
                } else if (i28 == -1) {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                } else {
                    makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
                }
                int i29 = ((RelativeLayout.LayoutParams) layoutParams).height;
                if (i29 == -2) {
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                    i18 = makeMeasureSpec3;
                    i19 = 3;
                    i17 = 1073741824;
                } else {
                    if (i29 == -1) {
                        i17 = 1073741824;
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                    } else {
                        i17 = 1073741824;
                        makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(i29, 1073741824);
                    }
                    i18 = makeMeasureSpec3;
                    i19 = 3;
                }
                if (i22 == i19) {
                    i20 = View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(Y8.d.f5616H), i17);
                    makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(paddingTop, i17);
                } else {
                    i20 = i18;
                }
                childAt.measure(i20, makeMeasureSpec4);
                if (i22 < 2) {
                    int measuredWidth2 = (int) (childAt.getMeasuredWidth() + f10);
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mode2 == Integer.MIN_VALUE && measuredHeight > i12) {
                        i12 = Math.min(measuredHeight, paddingTop);
                    }
                    i23 -= measuredWidth2;
                    if (i23 <= 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    layoutParams.slideable = z11;
                    z13 |= z11;
                    if (z11) {
                        this.mSlideableView = childAt;
                    }
                }
                f12 = f11;
            }
            i22++;
            z12 = false;
        }
        int i30 = 8;
        if (z13 || f12 > 0.0f) {
            int i31 = paddingLeft - this.mOverhangSize;
            int i32 = 0;
            while (i32 < childCount) {
                View childAt2 = getChildAt(i32);
                if (childAt2.getVisibility() != i30) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i30) {
                        if (((RelativeLayout.LayoutParams) layoutParams2).width == 0 && layoutParams2.weight > 0.0f) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            measuredWidth = 0;
                        } else {
                            measuredWidth = childAt2.getMeasuredWidth();
                        }
                        if (z13 && childAt2 != this.mSlideableView) {
                            if (((RelativeLayout.LayoutParams) layoutParams2).width < 0 && (measuredWidth > i31 || layoutParams2.weight > 0.0f)) {
                                if (z10) {
                                    int i33 = ((RelativeLayout.LayoutParams) layoutParams2).height;
                                    if (i33 == -2) {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                        i14 = 1073741824;
                                    } else if (i33 == -1) {
                                        i14 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                    } else {
                                        i14 = 1073741824;
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i33, 1073741824);
                                    }
                                } else {
                                    i14 = 1073741824;
                                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                }
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(i31, i14), makeMeasureSpec2);
                            }
                        } else if (layoutParams2.weight > 0.0f) {
                            if (((RelativeLayout.LayoutParams) layoutParams2).width == 0) {
                                int i34 = ((RelativeLayout.LayoutParams) layoutParams2).height;
                                if (i34 == -2) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                                } else if (i34 == -1) {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                                } else {
                                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i34, 1073741824);
                                }
                            } else {
                                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            }
                            if (z13) {
                                int i35 = paddingLeft - (((RelativeLayout.LayoutParams) layoutParams2).leftMargin + ((RelativeLayout.LayoutParams) layoutParams2).rightMargin);
                                i13 = i31;
                                int makeMeasureSpec5 = View.MeasureSpec.makeMeasureSpec(i35, 1073741824);
                                if (measuredWidth != i35) {
                                    childAt2.measure(makeMeasureSpec5, makeMeasureSpec);
                                }
                                i32++;
                                i31 = i13;
                                i30 = 8;
                            } else {
                                i13 = i31;
                                childAt2.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth + ((int) ((layoutParams2.weight * Math.max(0, i23)) / f12)), 1073741824), makeMeasureSpec);
                                i32++;
                                i31 = i13;
                                i30 = 8;
                            }
                        }
                    }
                }
                i13 = i31;
                i32++;
                i31 = i13;
                i30 = 8;
            }
        }
        setMeasuredDimension(size, i12 + getPaddingTop() + getPaddingBottom());
        this.mCanSlide = z13;
        if (this.mDragHelper.B() != 0 && !z13) {
            this.mDragHelper.a();
        }
    }

    public void onPanelSlide(int i10) {
        int paddingLeft;
        int i11;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        View view = this.mSlideableView;
        if (view == null) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (isLayoutRtlSupport) {
            paddingLeft = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            i11 = ((RelativeLayout.LayoutParams) layoutParams).rightMargin;
        } else {
            i11 = ((RelativeLayout.LayoutParams) layoutParams).leftMargin;
        }
        this.mSlideOffset = (i10 - (paddingLeft + i11)) / this.mSlideRange;
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z10 = this.mDefaultShow;
        boolean z11 = savedState.isDefalutOpen;
        if (z10 != z11) {
            if (!z11) {
                this.mFirstAttach = true;
                openPane();
                this.mPreservedOpenState = true;
                this.mState = 0;
                return;
            }
            return;
        }
        if (savedState.isOpen) {
            this.mFirstAttach = true;
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
        this.mState = savedState.state;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (isSlideable()) {
            z10 = isOpen();
        } else {
            z10 = this.mPreservedOpenState;
        }
        savedState.isOpen = z10;
        savedState.isDefalutOpen = this.mDefaultShow;
        savedState.state = this.mState;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.mFirstLayout = true;
        }
    }

    public void reMeasureContentView() {
        if (getChildAt(1) != null) {
            ViewGroup.LayoutParams layoutParams = getChildAt(1).getLayoutParams();
            if (this.mIsCover) {
                layoutParams.width = getWidth();
            } else {
                layoutParams.width = (int) ((getWidth() - this.mFirstViewWidth) - (this.mSlideDistance * (this.mSlideOffset - 1.0f)));
            }
            getChildAt(1).setLayoutParams(layoutParams);
            getChildAt(1).requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        boolean z10;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            if (view == this.mSlideableView) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mPreservedOpenState = z10;
        }
    }

    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setAlwaysShowMask(boolean z10) {
        this.mAlwaysShow = z10;
        invalidate();
    }

    public void setCoverStyle(boolean z10) {
        this.mIsCover = z10;
    }

    public void setCreateIcon(boolean z10) {
        this.mCreateIcon = z10;
    }

    public void setDefaultShowPane(Boolean bool) {
        this.mDefaultShow = bool.booleanValue();
        if (!bool.booleanValue()) {
            if (getChildCount() > 0) {
                getChildAt(0).setVisibility(8);
                ViewGroup.LayoutParams layoutParams = getChildAt(1).getLayoutParams();
                if (this.mIsCover) {
                    layoutParams.width = getWidth();
                } else {
                    layoutParams.width = (int) ((getWidth() - this.mFirstViewWidth) - (this.mSlideDistance * (this.mSlideOffset - 1.0f)));
                }
            }
            setIconViewVisible(8);
            return;
        }
        if (getChildCount() > 0) {
            getChildAt(0).setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = getChildAt(1).getLayoutParams();
            if (this.mIsCover) {
                layoutParams2.width = getWidth();
            } else {
                layoutParams2.width = (int) ((getWidth() - this.mFirstViewWidth) - (this.mSlideDistance * (this.mSlideOffset - 1.0f)));
            }
            if (this.mIconButton == null) {
                createIconView();
            } else {
                setIconViewVisible(0);
            }
        }
    }

    public void setFirstViewWidth(int i10) {
        this.mFirstViewWidth = i10;
    }

    public void setIconViewVisible(int i10) {
        ImageButton imageButton = this.mIconButton;
        if (imageButton != null) {
            imageButton.setVisibility(i10);
        }
    }

    public void setLifeCycleObserverListener(PanelSlideListener panelSlideListener) {
        this.mLifeCycleObserverListener = panelSlideListener;
    }

    public void setOnMaskClickListener(PanelMaskListener panelMaskListener) {
        this.mPanelMaskListener = panelMaskListener;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setSlideDistance(float f10) {
        this.mSlideDistance = f10;
    }

    public void setTouchContentEnable(boolean z10) {
        this.mIsTouchEnabled = z10;
    }

    public boolean smoothSlideTo(final float f10, int i10) {
        if (!this.mCanSlide) {
            return false;
        }
        this.mSlideAnimator.cancel();
        this.mSlideAnimator.removeAllUpdateListeners();
        if (f10 == 0.0f) {
            this.mSlideAnimator.setCurrentFraction(1.0f - this.mSlideOffset);
        } else {
            this.mSlideAnimator.setCurrentFraction(this.mSlideOffset);
        }
        this.mSlideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.sidepane.COUISidePaneLayout.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f11;
                float animatedFraction;
                float animatedFraction2 = valueAnimator.getAnimatedFraction();
                if (f10 == 1.0f) {
                    f11 = COUISidePaneLayout.this.mFirstViewWidth;
                } else {
                    f11 = COUISidePaneLayout.this.mFirstViewWidth;
                    animatedFraction2 = 1.0f - animatedFraction2;
                }
                int i11 = (int) (f11 * animatedFraction2);
                if (COUISidePaneLayout.this.mState == 1) {
                    animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
                } else {
                    animatedFraction = valueAnimator.getAnimatedFraction();
                }
                COUISidePaneLayout cOUISidePaneLayout = COUISidePaneLayout.this;
                if (cOUISidePaneLayout.mSlideableView != null) {
                    if (cOUISidePaneLayout.mPanelSlideListener != null) {
                        COUISidePaneLayout.this.mPanelSlideListener.onPanelSlide(COUISidePaneLayout.this.mSlideableView, animatedFraction);
                    }
                    if (COUISidePaneLayout.this.mLifeCycleObserverListener != null) {
                        COUISidePaneLayout.this.mLifeCycleObserverListener.onPanelSlide(COUISidePaneLayout.this.mSlideableView, animatedFraction);
                    }
                }
                COUISidePaneLayout.this.onPanelSlide(i11);
            }
        });
        this.mSlideAnimator.start();
        setAllChildrenVisible();
        K.Z(this);
        return true;
    }

    public void updateLayoutParams() {
        updateChildSize();
    }

    public void updateObscuredViewsVisibility(View view) {
        int paddingLeft;
        int width;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10;
        int i15;
        int i16;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            paddingLeft = getWidth() - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            width = getPaddingLeft();
        } else {
            width = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 != null && viewIsOpaque(view)) {
            i10 = view.getLeft();
            i11 = view.getRight();
            i12 = view.getTop();
            i13 = view.getBottom();
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        int childCount = getChildCount();
        int i17 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            if (childAt != view2) {
                if (childAt.getVisibility() == 8) {
                    z10 = isLayoutRtlSupport;
                } else {
                    if (isLayoutRtlSupport) {
                        i14 = width;
                    } else {
                        i14 = paddingLeft;
                    }
                    int max = Math.max(i14, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    z10 = isLayoutRtlSupport;
                    if (isLayoutRtlSupport) {
                        i15 = paddingLeft;
                    } else {
                        i15 = width;
                    }
                    int min = Math.min(i15, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max >= i10 && max2 >= i12 && min <= i11 && min2 <= i13) {
                        i16 = 4;
                    } else {
                        i16 = 0;
                    }
                    childAt.setVisibility(i16);
                }
                i17++;
                view2 = view;
                isLayoutRtlSupport = z10;
            } else {
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RelativeLayout.LayoutParams {
        private static final int[] ATTRS = {R.attr.layout_weight};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight;

        public LayoutParams() {
            super(-1, -1);
            this.weight = 0.0f;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.weight = 0.0f;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RelativeLayout.LayoutParams) layoutParams);
            this.weight = 0.0f;
            this.weight = layoutParams.weight;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.weight = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public COUISidePaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public COUISidePaneLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mDefaultShow = true;
        this.mCreateIcon = true;
        this.mFirstLayout = true;
        this.mFirstAttach = false;
        this.mAlwaysShow = false;
        this.mIsTouchEnabled = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f5736q, i10, 0);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f10) + 0.5f);
        int i11 = i.f5739t;
        Resources resources = getResources();
        int i12 = Y8.d.f5618J;
        this.mFirstViewWidth = obtainStyledAttributes.getDimension(i11, resources.getDimensionPixelOffset(i12));
        float dimension = obtainStyledAttributes.getDimension(i.f5738s, getResources().getDimensionPixelOffset(i12));
        this.mSlideViewWidth = dimension;
        this.mIsCover = obtainStyledAttributes.getBoolean(i.f5737r, false);
        this.mSlideDistance = dimension;
        this.mScrimPaint = new Paint();
        this.mState = 0;
        setWillNotDraw(false);
        K.j0(this, new AccessibilityDelegate());
        K.t0(this, 1);
        c o10 = c.o(this, 0.5f, new DragHelperCallback());
        this.mDragHelper = o10;
        o10.O(f10 * 400.0f);
        initAnimator();
        obtainStyledAttributes.recycle();
    }

    public boolean closePane() {
        this.mTranlateAnimator.cancel();
        this.mState = 1;
        this.mFirstAttach = false;
        this.mTranlateAnimator.setCurrentFraction(1.0f - this.mSlideOffset);
        this.mTranlateAnimator.start();
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelAnimStart(1);
        }
        PanelSlideListener panelSlideListener2 = this.mLifeCycleObserverListener;
        if (panelSlideListener2 != null) {
            panelSlideListener2.onPanelAnimStart(1);
        }
        return closePane(this.mSlideableView, 0);
    }

    public boolean openPane() {
        this.mTranlateAnimator.cancel();
        this.mState = 0;
        this.mTranlateAnimator.setCurrentFraction(this.mSlideOffset);
        this.mTranlateAnimator.start();
        PanelSlideListener panelSlideListener = this.mPanelSlideListener;
        if (panelSlideListener != null) {
            panelSlideListener.onPanelAnimStart(0);
        }
        PanelSlideListener panelSlideListener2 = this.mLifeCycleObserverListener;
        if (panelSlideListener2 != null) {
            panelSlideListener2.onPanelAnimStart(0);
        }
        return openPane(this.mSlideableView, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
