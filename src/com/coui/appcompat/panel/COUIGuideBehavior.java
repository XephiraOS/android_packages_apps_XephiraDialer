package com.coui.appcompat.panel;

import J.d;
import J.g;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.c;
import com.android.incallui.OplusPhoneUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e4.C0977c;
import e4.C0979e;
import e4.l;
import e4.m;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import u4.C1607c;
import x4.i;
import x4.n;

/* loaded from: classes.dex */
public class COUIGuideBehavior<V extends View> extends BottomSheetBehavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = l.f31028k;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    private static final int VERTICAL_SLIDING_PARAMETER_THRESHOLD = 2;
    int activePointerId;
    private final ArrayList<COUIBottomSheetCallback> callbacks;
    int collapsedOffset;
    private final c.AbstractC0115c dragCallback;
    private boolean draggable;
    float elevation;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialX;
    private int initialY;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    COUIPanelDragListener mCOUIPanelDragListener;
    private boolean mCanHideKeyboard;
    private boolean mIsIgnoreExpandedOffsetChange;
    private COUIPanelPullUpListener mPullUpListener;
    private i materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags;
    private COUIGuideBehavior<V>.SettleRunnable settleRunnable;
    private n shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    androidx.customview.widget.c viewDragHelper;
    WeakReference<V> viewRef;

    /* loaded from: classes.dex */
    public static abstract class COUIBottomSheetCallback {
        public abstract void onSlide(View view, float f10);

        public abstract void onStateChanged(View view, int i10);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SaveFlags {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, COUIGuideBehavior<?> cOUIGuideBehavior) {
            super(parcelable);
            this.state = cOUIGuideBehavior.state;
            this.peekHeight = ((COUIGuideBehavior) cOUIGuideBehavior).peekHeight;
            this.fitToContents = ((COUIGuideBehavior) cOUIGuideBehavior).fitToContents;
            this.hideable = cOUIGuideBehavior.hideable;
            this.skipCollapsed = ((COUIGuideBehavior) cOUIGuideBehavior).skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.state = i10;
        }
    }

    /* loaded from: classes.dex */
    public class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        private final View view;

        public SettleRunnable(View view, int i10) {
            this.view = view;
            this.targetState = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.customview.widget.c cVar = COUIGuideBehavior.this.viewDragHelper;
            if (cVar != null && cVar.n(true)) {
                K.a0(this.view, this);
            } else {
                COUIGuideBehavior.this.setStateInternal(this.targetState);
            }
            this.isPosted = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface State {
    }

    public COUIGuideBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new c.AbstractC0115c() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.3
            private boolean releasedLow(View view) {
                int top = view.getTop();
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                if (top > (cOUIGuideBehavior.parentHeight + cOUIGuideBehavior.getExpandedOffset()) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int clampViewPositionHorizontal(View view, int i10, int i11) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int clampViewPositionVertical(View view, int i10, int i11) {
                int i12;
                int i13;
                int i14;
                if (COUIGuideBehavior.this.mPullUpListener != null && ((i14 = COUIGuideBehavior.this.state) == 3 || (i14 == 1 && view.getTop() <= COUIGuideBehavior.this.getExpandedOffset()))) {
                    COUIGuideBehavior.this.mIsIgnoreExpandedOffsetChange = true;
                    i12 = COUIGuideBehavior.this.mPullUpListener.onDragging(i11, COUIGuideBehavior.this.getExpandedOffset());
                } else {
                    i12 = 0;
                }
                int expandedOffset = COUIGuideBehavior.this.getExpandedOffset() - i12;
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                if (cOUIGuideBehavior.hideable) {
                    i13 = cOUIGuideBehavior.parentHeight;
                } else {
                    i13 = cOUIGuideBehavior.collapsedOffset;
                }
                return E.a.b(i10, expandedOffset, i13);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int getViewVerticalDragRange(View view) {
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                if (cOUIGuideBehavior.hideable) {
                    return cOUIGuideBehavior.parentHeight;
                }
                return cOUIGuideBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewDragStateChanged(int i10) {
                if (i10 == 1 && COUIGuideBehavior.this.draggable) {
                    COUIGuideBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
                COUIGuideBehavior.this.dispatchOnSlide(i11);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewReleased(View view, float f10, float f11) {
                int i10;
                if (COUIGuideBehavior.this.mPullUpListener != null && COUIGuideBehavior.this.parentHeight - view.getHeight() < COUIGuideBehavior.this.getExpandedOffset() && view.getTop() < COUIGuideBehavior.this.getExpandedOffset()) {
                    COUIGuideBehavior.this.mPullUpListener.onReleased(COUIGuideBehavior.this.getExpandedOffset());
                    return;
                }
                int i11 = 6;
                if (f11 < 0.0f) {
                    if (COUIGuideBehavior.this.fitToContents) {
                        i10 = COUIGuideBehavior.this.fitToContentsOffset;
                    } else {
                        int top = view.getTop();
                        COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                        int i12 = cOUIGuideBehavior.halfExpandedOffset;
                        if (top > i12) {
                            i10 = i12;
                            COUIGuideBehavior.this.startSettlingAnimation(view, i11, i10, true);
                        }
                        i10 = cOUIGuideBehavior.expandedOffset;
                    }
                    i11 = 3;
                    COUIGuideBehavior.this.startSettlingAnimation(view, i11, i10, true);
                }
                COUIGuideBehavior cOUIGuideBehavior2 = COUIGuideBehavior.this;
                if (cOUIGuideBehavior2.hideable && cOUIGuideBehavior2.shouldHide(view, f11)) {
                    COUIPanelDragListener cOUIPanelDragListener = COUIGuideBehavior.this.mCOUIPanelDragListener;
                    if (cOUIPanelDragListener != null && cOUIPanelDragListener.onDragWhileEditing()) {
                        COUIGuideBehavior cOUIGuideBehavior3 = COUIGuideBehavior.this;
                        int i13 = cOUIGuideBehavior3.fitToContentsOffset;
                        cOUIGuideBehavior3.mCanHideKeyboard = false;
                        i10 = i13;
                    } else {
                        if ((Math.abs(f10) < Math.abs(f11) && f11 > 500.0f) || releasedLow(view)) {
                            COUIGuideBehavior cOUIGuideBehavior4 = COUIGuideBehavior.this;
                            int i14 = cOUIGuideBehavior4.parentHeight;
                            cOUIGuideBehavior4.mCanHideKeyboard = true;
                            i11 = 5;
                            i10 = i14;
                        } else if (COUIGuideBehavior.this.fitToContents) {
                            i10 = COUIGuideBehavior.this.fitToContentsOffset;
                        } else if (Math.abs(view.getTop() - COUIGuideBehavior.this.expandedOffset) < Math.abs(view.getTop() - COUIGuideBehavior.this.halfExpandedOffset)) {
                            i10 = COUIGuideBehavior.this.expandedOffset;
                        } else {
                            i10 = COUIGuideBehavior.this.halfExpandedOffset;
                        }
                        COUIGuideBehavior.this.startSettlingAnimation(view, i11, i10, true);
                    }
                    i11 = 3;
                    COUIGuideBehavior.this.startSettlingAnimation(view, i11, i10, true);
                }
                if (f11 != 0.0f && Math.abs(f10) <= Math.abs(f11)) {
                    if (COUIGuideBehavior.this.fitToContents) {
                        i10 = COUIGuideBehavior.this.collapsedOffset;
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - COUIGuideBehavior.this.halfExpandedOffset) < Math.abs(top2 - COUIGuideBehavior.this.collapsedOffset)) {
                            i10 = COUIGuideBehavior.this.halfExpandedOffset;
                        } else {
                            i10 = COUIGuideBehavior.this.collapsedOffset;
                        }
                    }
                    i11 = 4;
                } else {
                    int top3 = view.getTop();
                    if (COUIGuideBehavior.this.fitToContents) {
                        if (Math.abs(top3 - COUIGuideBehavior.this.fitToContentsOffset) < Math.abs(top3 - COUIGuideBehavior.this.collapsedOffset)) {
                            i10 = COUIGuideBehavior.this.fitToContentsOffset;
                            i11 = 3;
                        } else {
                            i10 = COUIGuideBehavior.this.collapsedOffset;
                            i11 = 4;
                        }
                    } else {
                        COUIGuideBehavior cOUIGuideBehavior5 = COUIGuideBehavior.this;
                        int i15 = cOUIGuideBehavior5.halfExpandedOffset;
                        if (top3 < i15) {
                            if (top3 < Math.abs(top3 - cOUIGuideBehavior5.collapsedOffset)) {
                                i10 = COUIGuideBehavior.this.expandedOffset;
                                i11 = 3;
                            } else {
                                i10 = COUIGuideBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top3 - i15) < Math.abs(top3 - COUIGuideBehavior.this.collapsedOffset)) {
                            i10 = COUIGuideBehavior.this.halfExpandedOffset;
                        } else {
                            i10 = COUIGuideBehavior.this.collapsedOffset;
                            i11 = 4;
                        }
                    }
                }
                COUIGuideBehavior.this.startSettlingAnimation(view, i11, i10, true);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public boolean tryCaptureView(View view, int i10) {
                View view2;
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                int i11 = cOUIGuideBehavior.state;
                if (i11 == 1 || cOUIGuideBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i11 == 3 && cOUIGuideBehavior.activePointerId == i10) {
                    WeakReference<View> weakReference = cOUIGuideBehavior.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = COUIGuideBehavior.this.viewRef;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
    }

    private void addAccessibilityActionForState(V v10, d.a aVar, final int i10) {
        K.e0(v10, aVar, null, new g() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.4
            @Override // J.g
            public boolean perform(View view, g.a aVar2) {
                COUIGuideBehavior.this.setState(i10);
                return true;
            }
        });
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto) {
            return Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16));
        }
        return this.peekHeight;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z10) {
        createMaterialShapeDrawable(context, attributeSet, z10, null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIGuideBehavior.this.materialShapeDrawable != null) {
                    COUIGuideBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    public static <V extends View> COUIGuideBehavior<V> from(V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.e) {
            CoordinatorLayout.Behavior f10 = ((CoordinatorLayout.e) layoutParams).f();
            if (f10 instanceof BottomSheetBehavior) {
                return (COUIGuideBehavior) f10;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i10 = this.saveFlags;
        if (i10 == 0) {
            return;
        }
        if (i10 == -1 || (i10 & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        if (i10 == -1 || (i10 & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (i10 == -1 || (i10 & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (i10 == -1 || (i10 & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    private void setPanelPeekHeight(int i10, boolean z10) {
        V v10;
        if (i10 == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            } else {
                return;
            }
        } else if (this.peekHeightAuto || this.peekHeight != i10) {
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i10);
        } else {
            return;
        }
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (v10 = this.viewRef.get()) != null) {
                if (z10) {
                    settleToStatePendingLayout(this.state);
                } else {
                    v10.requestLayout();
                }
            }
        }
    }

    private void setSystemGestureInsets(CoordinatorLayout coordinatorLayout) {
        WindowInsets rootWindowInsets;
        if (!isGestureInsetBottomIgnored() && (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) != null) {
            this.peekHeight += rootWindowInsets.getSystemGestureInsets().bottom;
        }
    }

    private void settleToStatePendingLayout(final int i10) {
        final V v10 = this.viewRef.get();
        if (v10 == null) {
            return;
        }
        ViewParent parent = v10.getParent();
        if (parent != null && parent.isLayoutRequested() && K.N(v10)) {
            v10.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    COUIGuideBehavior.this.settleToState(v10, i10);
                }
            });
        } else {
            settleToState(v10, i10);
        }
    }

    private void updateAccessibilityActions() {
        V v10;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        K.c0(v10, 524288);
        K.c0(v10, 262144);
        K.c0(v10, OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS);
        if (this.hideable && this.state != 5) {
            addAccessibilityActionForState((COUIGuideBehavior<V>) v10, d.a.f1410y, 5);
        }
        int i10 = this.state;
        int i11 = 6;
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 == 6) {
                    addAccessibilityActionForState((COUIGuideBehavior<V>) v10, d.a.f1409x, 4);
                    addAccessibilityActionForState((COUIGuideBehavior<V>) v10, d.a.f1408w, 3);
                    return;
                }
                return;
            }
            if (this.fitToContents) {
                i11 = 3;
            }
            addAccessibilityActionForState((COUIGuideBehavior<V>) v10, d.a.f1408w, i11);
            return;
        }
        if (this.fitToContents) {
            i11 = 4;
        }
        addAccessibilityActionForState((COUIGuideBehavior<V>) v10, d.a.f1409x, i11);
    }

    private void updateDrawableForTargetState(int i10) {
        boolean z10;
        ValueAnimator valueAnimator;
        float f10;
        if (i10 == 2) {
            return;
        }
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.isShapeExpanded != z10) {
            this.isShapeExpanded = z10;
            if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                if (valueAnimator.isRunning()) {
                    this.interpolatorAnimator.reverse();
                    return;
                }
                if (z10) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                this.interpolatorAnimator.setFloatValues(1.0f - f10, f10);
                this.interpolatorAnimator.start();
            }
        }
    }

    private void updateImportantForAccessibility(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z10) {
            if (this.importantForAccessibilityMap == null) {
                this.importantForAccessibilityMap = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = coordinatorLayout.getChildAt(i10);
            if (childAt != this.viewRef.get()) {
                if (z10) {
                    this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.updateImportantForAccessibilityOnSiblings) {
                        K.t0(childAt, 4);
                    }
                } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                    K.t0(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                }
            }
        }
        if (!z10) {
            this.importantForAccessibilityMap = null;
        }
    }

    public void addBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        if (!this.callbacks.contains(cOUIBottomSheetCallback)) {
            this.callbacks.add(cOUIBottomSheetCallback);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int i10) {
        float f10;
        float f11;
        V v10 = this.viewRef.get();
        if (v10 != null && !this.callbacks.isEmpty()) {
            int i11 = this.collapsedOffset;
            if (i10 <= i11 && i11 != getExpandedOffset()) {
                int i12 = this.collapsedOffset;
                f10 = i12 - i10;
                f11 = i12 - getExpandedOffset();
            } else {
                int i13 = this.collapsedOffset;
                f10 = i13 - i10;
                f11 = this.parentHeight - i13;
            }
            float f12 = f10 / f11;
            for (int i14 = 0; i14 < this.callbacks.size(); i14++) {
                this.callbacks.get(i14).onSlide(v10, f12);
            }
        }
    }

    public View findScrollingChild(View view) {
        if (K.P(view) && view.getVisibility() == 0) {
            return view;
        }
        if ((view instanceof ViewGroup) && view.getVisibility() == 0) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i10));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
            return null;
        }
        return null;
    }

    public COUIPanelDragListener getCOUIPanelDragListener() {
        return this.mCOUIPanelDragListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return this.expandedOffset;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getSaveFlags() {
        return this.saveFlags;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getState() {
        return this.state;
    }

    public boolean isCanHideKeyboard() {
        return this.mCanHideKeyboard;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isDraggable() {
        return this.draggable;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isFitToContents() {
        return this.fitToContents;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isHideable() {
        return this.hideable;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
        super.onAttachedToLayoutParams(eVar);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        boolean z10;
        View view;
        androidx.customview.widget.c cVar;
        if (v10.isShown() && this.draggable) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                reset();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            View view2 = null;
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 3) {
                        this.touchingScrollingChild = false;
                        this.activePointerId = -1;
                        if (this.ignoreEvents) {
                            this.ignoreEvents = false;
                            return false;
                        }
                    }
                } else {
                    COUIPanelPullUpListener cOUIPanelPullUpListener = this.mPullUpListener;
                    if (cOUIPanelPullUpListener != null) {
                        cOUIPanelPullUpListener.onCancel();
                    }
                }
            } else {
                this.initialX = (int) motionEvent.getX();
                this.initialY = (int) motionEvent.getY();
                if (this.state != 2) {
                    WeakReference<View> weakReference = this.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.z(view, this.initialX, this.initialY)) {
                        this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.touchingScrollingChild = true;
                    }
                }
                if (this.activePointerId == -1 && !coordinatorLayout.z(v10, this.initialX, this.initialY)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.ignoreEvents = z10;
            }
            if (!this.ignoreEvents && (cVar = this.viewDragHelper) != null && cVar.Q(motionEvent)) {
                return true;
            }
            if (Math.abs(this.initialY - motionEvent.getY()) > Math.abs(this.initialX - motionEvent.getX()) * 2.0f && this.viewDragHelper != null && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.A()) {
                return true;
            }
            WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.z(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(this.initialY - motionEvent.getY()) <= this.viewDragHelper.A()) {
                return false;
            }
            return true;
        }
        this.ignoreEvents = true;
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        boolean z10;
        float f10;
        i iVar;
        if (K.s(coordinatorLayout) && !K.s(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(C0979e.f30786h);
            setSystemGestureInsets(coordinatorLayout);
            this.viewRef = new WeakReference<>(v10);
            if (this.shapeThemingEnabled && (iVar = this.materialShapeDrawable) != null) {
                K.n0(v10, iVar);
            }
            i iVar2 = this.materialShapeDrawable;
            if (iVar2 != null) {
                float f11 = this.elevation;
                if (f11 == -1.0f) {
                    f11 = K.r(v10);
                }
                iVar2.setElevation(f11);
                if (this.state == 3) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.isShapeExpanded = z10;
                i iVar3 = this.materialShapeDrawable;
                if (z10) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                iVar3.setInterpolation(f10);
            }
            updateAccessibilityActions();
            if (K.t(v10) == 0) {
                K.t0(v10, 1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = androidx.customview.widget.c.p(coordinatorLayout, this.dragCallback);
        }
        int top = v10.getTop();
        coordinatorLayout.G(v10, i10);
        this.parentWidth = coordinatorLayout.getWidth();
        int height = coordinatorLayout.getHeight();
        this.parentHeight = height;
        if (!this.mIsIgnoreExpandedOffsetChange) {
            this.fitToContentsOffset = Math.max(0, height - v10.getHeight());
        }
        this.mIsIgnoreExpandedOffsetChange = false;
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i11 = this.state;
        if (i11 == 3) {
            K.U(v10, getExpandedOffset());
        } else if (i11 == 6) {
            K.U(v10, this.halfExpandedOffset);
        } else if (this.hideable && i11 == 5) {
            K.U(v10, this.parentHeight);
        } else if (i11 == 4) {
            K.U(v10, this.collapsedOffset);
        } else if (i11 == 1 || i11 == 2) {
            K.U(v10, top - v10.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v10));
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.state == 3 && !super.onNestedPreFling(coordinatorLayout, v10, view, f10, f11)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
        View view2;
        if (i12 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (view != view2) {
            return;
        }
        int top = v10.getTop();
        int i13 = top - i11;
        if (i11 > 0) {
            if (i13 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                iArr[1] = expandedOffset;
                K.U(v10, -expandedOffset);
                setStateInternal(3);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i11;
                K.U(v10, -i11);
                setStateInternal(1);
            }
        } else if (i11 < 0 && !view.canScrollVertically(-1)) {
            int i14 = this.collapsedOffset;
            if (i13 > i14 && !this.hideable) {
                int i15 = top - i14;
                iArr[1] = i15;
                K.U(v10, -i15);
                setStateInternal(4);
            } else {
                if (!this.draggable) {
                    return;
                }
                iArr[1] = i11;
                K.U(v10, -i11);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v10.getTop());
        this.lastNestedScrollDy = i11;
        this.nestedScrolled = true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v10, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i10 = savedState.state;
        if (i10 != 1 && i10 != 2) {
            this.state = i10;
        } else {
            this.state = 4;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v10), (COUIGuideBehavior<?>) this);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i10 & 2) == 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
        int i11;
        int i12 = 3;
        if (v10.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i11 = this.fitToContentsOffset;
                } else {
                    int top = v10.getTop();
                    int i13 = this.halfExpandedOffset;
                    if (top > i13) {
                        i12 = 6;
                        i11 = i13;
                    } else {
                        i11 = this.expandedOffset;
                    }
                }
            } else if (this.hideable && shouldHide(v10, getYVelocity())) {
                COUIPanelDragListener cOUIPanelDragListener = this.mCOUIPanelDragListener;
                if (cOUIPanelDragListener != null && cOUIPanelDragListener.onDragWhileEditing()) {
                    i11 = this.fitToContentsOffset;
                    this.mCanHideKeyboard = false;
                } else {
                    i11 = this.parentHeight;
                    this.mCanHideKeyboard = true;
                    i12 = 5;
                }
            } else if (this.lastNestedScrollDy == 0) {
                int top2 = v10.getTop();
                if (this.fitToContents) {
                    if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i11 = this.fitToContentsOffset;
                    } else {
                        i11 = this.collapsedOffset;
                        i12 = 4;
                    }
                } else {
                    int i14 = this.halfExpandedOffset;
                    if (top2 < i14) {
                        if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                            i11 = this.expandedOffset;
                        } else {
                            i11 = this.halfExpandedOffset;
                        }
                    } else if (Math.abs(top2 - i14) < Math.abs(top2 - this.collapsedOffset)) {
                        i11 = this.halfExpandedOffset;
                    } else {
                        i11 = this.collapsedOffset;
                        i12 = 4;
                    }
                    i12 = 6;
                }
            } else {
                if (this.fitToContents) {
                    i11 = this.collapsedOffset;
                } else {
                    int top3 = v10.getTop();
                    if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i11 = this.halfExpandedOffset;
                        i12 = 6;
                    } else {
                        i11 = this.collapsedOffset;
                    }
                }
                i12 = 4;
            }
            startSettlingAnimation(v10, i12, i11, false);
            this.nestedScrolled = false;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        androidx.customview.widget.c cVar = this.viewDragHelper;
        if (cVar != null) {
            cVar.G(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && this.viewDragHelper != null && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.A()) {
            this.viewDragHelper.c(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        this.callbacks.remove(cOUIBottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(COUIBottomSheetCallback cOUIBottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (cOUIBottomSheetCallback != null) {
            this.callbacks.add(cOUIBottomSheetCallback);
        }
    }

    public void setCanHideKeyboard(boolean z10) {
        this.mCanHideKeyboard = z10;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setDraggable(boolean z10) {
        this.draggable = z10;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setExpandedOffset(int i10) {
        if (i10 >= 0) {
            this.expandedOffset = i10;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setFitToContents(boolean z10) {
        int i10;
        if (this.fitToContents == z10) {
            return;
        }
        this.fitToContents = z10;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        if (this.fitToContents && this.state == 6) {
            i10 = 3;
        } else {
            i10 = this.state;
        }
        setStateInternal(i10);
        updateAccessibilityActions();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setGestureInsetBottomIgnored(boolean z10) {
        this.gestureInsetBottomIgnored = z10;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setHalfExpandedRatio(float f10) {
        if (f10 > 0.0f && f10 < 1.0f) {
            this.halfExpandedRatio = f10;
            if (this.viewRef != null) {
                calculateHalfExpandedOffset();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setHideable(boolean z10) {
        if (this.hideable != z10) {
            this.hideable = z10;
            if (!z10 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setPanelDragListener(COUIPanelDragListener cOUIPanelDragListener) {
        this.mCOUIPanelDragListener = cOUIPanelDragListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setPeekHeight(int i10) {
        setPanelPeekHeight(i10, false);
    }

    public void setPullUpListener(COUIPanelPullUpListener cOUIPanelPullUpListener) {
        this.mPullUpListener = cOUIPanelPullUpListener;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSaveFlags(int i10) {
        this.saveFlags = i10;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSkipCollapsed(boolean z10) {
        this.skipCollapsed = z10;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setState(int i10) {
        if (i10 == this.state) {
            return;
        }
        if (this.viewRef == null) {
            if (i10 == 4 || i10 == 3 || i10 == 6 || (this.hideable && i10 == 5)) {
                this.state = i10;
                return;
            }
            return;
        }
        settleToStatePendingLayout(i10);
    }

    public void setStateInternal(int i10) {
        V v10;
        if (this.state == i10) {
            return;
        }
        this.state = i10;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            updateImportantForAccessibility(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i10);
        for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
            this.callbacks.get(i11).onStateChanged(v10, i10);
        }
        updateAccessibilityActions();
    }

    public void setStateWithoutAnim(int i10, boolean z10) {
        V v10;
        if (this.state == i10) {
            return;
        }
        this.state = i10;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && z10 && (v10 = weakReference.get()) != null) {
            for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
                this.callbacks.get(i11).onStateChanged(v10, i10);
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setUpdateImportantForAccessibilityOnSiblings(boolean z10) {
        this.updateImportantForAccessibilityOnSiblings = z10;
    }

    public void settleToState(View view, int i10) {
        int i11;
        int i12;
        if (i10 == 4) {
            i11 = this.collapsedOffset;
        } else if (i10 == 6) {
            i11 = this.halfExpandedOffset;
            if (this.fitToContents && i11 <= (i12 = this.fitToContentsOffset)) {
                i10 = 3;
                i11 = i12;
            }
        } else if (i10 == 3) {
            i11 = getExpandedOffset();
        } else if (this.hideable && i10 == 5) {
            i11 = this.parentHeight;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i10);
        }
        startSettlingAnimation(view, i10, i11, false);
    }

    public boolean shouldHide(View view, float f10) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((view.getTop() + (f10 * 0.1f)) - this.collapsedOffset) / calculatePeekHeight() > 0.5f) {
            return true;
        }
        return false;
    }

    public void startSettlingAnimation(View view, int i10, int i11, boolean z10) {
        boolean R10;
        if (z10) {
            R10 = this.viewDragHelper.P(view.getLeft(), i11);
        } else {
            R10 = this.viewDragHelper.R(view, view.getLeft(), i11);
        }
        if (R10) {
            setStateInternal(2);
            updateDrawableForTargetState(i10);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, i10);
            }
            if (!((SettleRunnable) this.settleRunnable).isPosted) {
                COUIGuideBehavior<V>.SettleRunnable settleRunnable = this.settleRunnable;
                settleRunnable.targetState = i10;
                K.a0(view, settleRunnable);
                ((SettleRunnable) this.settleRunnable).isPosted = true;
                return;
            }
            this.settleRunnable.targetState = i10;
            return;
        }
        setStateInternal(i10);
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z10, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = n.e(context, attributeSet, C0977c.f30669h, DEF_STYLE_RES).m();
            i iVar = new i(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = iVar;
            iVar.initializeElevationOverlay(context);
            if (z10 && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    public COUIGuideBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.dragCallback = new c.AbstractC0115c() { // from class: com.coui.appcompat.panel.COUIGuideBehavior.3
            private boolean releasedLow(View view) {
                int top = view.getTop();
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                if (top > (cOUIGuideBehavior.parentHeight + cOUIGuideBehavior.getExpandedOffset()) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int clampViewPositionHorizontal(View view, int i102, int i11) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int clampViewPositionVertical(View view, int i102, int i11) {
                int i12;
                int i13;
                int i14;
                if (COUIGuideBehavior.this.mPullUpListener != null && ((i14 = COUIGuideBehavior.this.state) == 3 || (i14 == 1 && view.getTop() <= COUIGuideBehavior.this.getExpandedOffset()))) {
                    COUIGuideBehavior.this.mIsIgnoreExpandedOffsetChange = true;
                    i12 = COUIGuideBehavior.this.mPullUpListener.onDragging(i11, COUIGuideBehavior.this.getExpandedOffset());
                } else {
                    i12 = 0;
                }
                int expandedOffset = COUIGuideBehavior.this.getExpandedOffset() - i12;
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                if (cOUIGuideBehavior.hideable) {
                    i13 = cOUIGuideBehavior.parentHeight;
                } else {
                    i13 = cOUIGuideBehavior.collapsedOffset;
                }
                return E.a.b(i102, expandedOffset, i13);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public int getViewVerticalDragRange(View view) {
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                if (cOUIGuideBehavior.hideable) {
                    return cOUIGuideBehavior.parentHeight;
                }
                return cOUIGuideBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewDragStateChanged(int i102) {
                if (i102 == 1 && COUIGuideBehavior.this.draggable) {
                    COUIGuideBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewPositionChanged(View view, int i102, int i11, int i12, int i13) {
                COUIGuideBehavior.this.dispatchOnSlide(i11);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public void onViewReleased(View view, float f10, float f11) {
                int i102;
                if (COUIGuideBehavior.this.mPullUpListener != null && COUIGuideBehavior.this.parentHeight - view.getHeight() < COUIGuideBehavior.this.getExpandedOffset() && view.getTop() < COUIGuideBehavior.this.getExpandedOffset()) {
                    COUIGuideBehavior.this.mPullUpListener.onReleased(COUIGuideBehavior.this.getExpandedOffset());
                    return;
                }
                int i11 = 6;
                if (f11 < 0.0f) {
                    if (COUIGuideBehavior.this.fitToContents) {
                        i102 = COUIGuideBehavior.this.fitToContentsOffset;
                    } else {
                        int top = view.getTop();
                        COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                        int i12 = cOUIGuideBehavior.halfExpandedOffset;
                        if (top > i12) {
                            i102 = i12;
                            COUIGuideBehavior.this.startSettlingAnimation(view, i11, i102, true);
                        }
                        i102 = cOUIGuideBehavior.expandedOffset;
                    }
                    i11 = 3;
                    COUIGuideBehavior.this.startSettlingAnimation(view, i11, i102, true);
                }
                COUIGuideBehavior cOUIGuideBehavior2 = COUIGuideBehavior.this;
                if (cOUIGuideBehavior2.hideable && cOUIGuideBehavior2.shouldHide(view, f11)) {
                    COUIPanelDragListener cOUIPanelDragListener = COUIGuideBehavior.this.mCOUIPanelDragListener;
                    if (cOUIPanelDragListener != null && cOUIPanelDragListener.onDragWhileEditing()) {
                        COUIGuideBehavior cOUIGuideBehavior3 = COUIGuideBehavior.this;
                        int i13 = cOUIGuideBehavior3.fitToContentsOffset;
                        cOUIGuideBehavior3.mCanHideKeyboard = false;
                        i102 = i13;
                    } else {
                        if ((Math.abs(f10) < Math.abs(f11) && f11 > 500.0f) || releasedLow(view)) {
                            COUIGuideBehavior cOUIGuideBehavior4 = COUIGuideBehavior.this;
                            int i14 = cOUIGuideBehavior4.parentHeight;
                            cOUIGuideBehavior4.mCanHideKeyboard = true;
                            i11 = 5;
                            i102 = i14;
                        } else if (COUIGuideBehavior.this.fitToContents) {
                            i102 = COUIGuideBehavior.this.fitToContentsOffset;
                        } else if (Math.abs(view.getTop() - COUIGuideBehavior.this.expandedOffset) < Math.abs(view.getTop() - COUIGuideBehavior.this.halfExpandedOffset)) {
                            i102 = COUIGuideBehavior.this.expandedOffset;
                        } else {
                            i102 = COUIGuideBehavior.this.halfExpandedOffset;
                        }
                        COUIGuideBehavior.this.startSettlingAnimation(view, i11, i102, true);
                    }
                    i11 = 3;
                    COUIGuideBehavior.this.startSettlingAnimation(view, i11, i102, true);
                }
                if (f11 != 0.0f && Math.abs(f10) <= Math.abs(f11)) {
                    if (COUIGuideBehavior.this.fitToContents) {
                        i102 = COUIGuideBehavior.this.collapsedOffset;
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - COUIGuideBehavior.this.halfExpandedOffset) < Math.abs(top2 - COUIGuideBehavior.this.collapsedOffset)) {
                            i102 = COUIGuideBehavior.this.halfExpandedOffset;
                        } else {
                            i102 = COUIGuideBehavior.this.collapsedOffset;
                        }
                    }
                    i11 = 4;
                } else {
                    int top3 = view.getTop();
                    if (COUIGuideBehavior.this.fitToContents) {
                        if (Math.abs(top3 - COUIGuideBehavior.this.fitToContentsOffset) < Math.abs(top3 - COUIGuideBehavior.this.collapsedOffset)) {
                            i102 = COUIGuideBehavior.this.fitToContentsOffset;
                            i11 = 3;
                        } else {
                            i102 = COUIGuideBehavior.this.collapsedOffset;
                            i11 = 4;
                        }
                    } else {
                        COUIGuideBehavior cOUIGuideBehavior5 = COUIGuideBehavior.this;
                        int i15 = cOUIGuideBehavior5.halfExpandedOffset;
                        if (top3 < i15) {
                            if (top3 < Math.abs(top3 - cOUIGuideBehavior5.collapsedOffset)) {
                                i102 = COUIGuideBehavior.this.expandedOffset;
                                i11 = 3;
                            } else {
                                i102 = COUIGuideBehavior.this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top3 - i15) < Math.abs(top3 - COUIGuideBehavior.this.collapsedOffset)) {
                            i102 = COUIGuideBehavior.this.halfExpandedOffset;
                        } else {
                            i102 = COUIGuideBehavior.this.collapsedOffset;
                            i11 = 4;
                        }
                    }
                }
                COUIGuideBehavior.this.startSettlingAnimation(view, i11, i102, true);
            }

            @Override // androidx.customview.widget.c.AbstractC0115c
            public boolean tryCaptureView(View view, int i102) {
                View view2;
                COUIGuideBehavior cOUIGuideBehavior = COUIGuideBehavior.this;
                int i11 = cOUIGuideBehavior.state;
                if (i11 == 1 || cOUIGuideBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i11 == 3 && cOUIGuideBehavior.activePointerId == i102) {
                    WeakReference<View> weakReference = cOUIGuideBehavior.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = COUIGuideBehavior.this.viewRef;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31188N0);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(m.f31429j1);
        int i11 = m.f31232R0;
        boolean hasValue = obtainStyledAttributes.hasValue(i11);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, C1607c.a(context, obtainStyledAttributes, i11));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(m.f31221Q0, -1.0f);
        int i12 = m.f31298X0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i12);
        if (peekValue != null && (i10 = peekValue.data) == -1) {
            setPeekHeight(i10);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(m.f31287W0, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(m.f31341b1, false));
        setFitToContents(obtainStyledAttributes.getBoolean(m.f31265U0, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(m.f31330a1, false));
        setDraggable(obtainStyledAttributes.getBoolean(m.f31243S0, true));
        setSaveFlags(obtainStyledAttributes.getInt(m.f31309Y0, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(m.f31276V0, 0.5f));
        int i13 = m.f31254T0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i13);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i13, 0));
        }
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mCanHideKeyboard = false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }
}
